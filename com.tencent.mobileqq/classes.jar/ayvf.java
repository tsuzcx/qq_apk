import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoRspExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureRspInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayvf
  implements IRequestCallback
{
  public ayvf(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onFailed(int paramInt)
  {
    synchronized (this.a)
    {
      this.a.u();
      ShortVideoUploadProcessor.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer  onFailed  erroCode : " + paramInt);
      }
      bbfb.a(String.valueOf(this.a.jdField_a_of_type_Aywc.jdField_a_of_type_Long), "svrcomp_r", "sendAckToBDHServer fail!  erroCode:" + paramInt);
      this.a.f(paramInt);
      return;
    }
  }
  
  public void onResponse(HwResponse paramHwResponse)
  {
    int i;
    Object localObject1;
    synchronized (this.a)
    {
      ShortVideoUploadProcessor.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse retCode : " + paramHwResponse.retCode + " htCost:" + paramHwResponse.htCost + " front:" + paramHwResponse.cacheCost);
      }
      this.a.u();
      if (paramHwResponse.retCode != 0) {
        break label992;
      }
      if (paramHwResponse.segmentResp.uint32_cache_addr.has())
      {
        i = paramHwResponse.segmentResp.uint32_cache_addr.get();
        if (i != 0)
        {
          BdhLogUtil.LogEvent("R", "RequestAck onResponse : cache_addr res from server is : " + i + " ( " + HwRequest.intToIP(i) + " )");
          if (ShortVideoUploadProcessor.d(this.a) == 0) {
            ShortVideoUploadProcessor.e(this.a, i);
          }
          if ((ShortVideoUploadProcessor.d(this.a) != 0) && (ShortVideoUploadProcessor.d(this.a) != i))
          {
            BdhLogUtil.LogEvent("R", "RequestAck onResponse : cache ip Diff !");
            ShortVideoUploadProcessor.a(this.a, true);
          }
        }
      }
      localObject1 = paramHwResponse.mBuExtendinfo;
      if (localObject1 == null) {
        break label849;
      }
      i = localObject1.length;
      if (i <= 0) {
        break label849;
      }
    }
    Object localObject2;
    Object localObject3;
    try
    {
      localObject2 = new Bdh_extinfo.ShortVideoRspExtInfo();
      ((Bdh_extinfo.ShortVideoRspExtInfo)localObject2).mergeFrom((byte[])localObject1);
      if (!((Bdh_extinfo.ShortVideoRspExtInfo)localObject2).msg_shortvideo_sure_rsp.has())
      {
        if (!ShortVideoUploadProcessor.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse error : rspExtInfo.msg_shortvideo_sure_rsp is null");
          }
          this.a.f(4);
        }
        return;
      }
      localObject1 = new Bdh_extinfo.ShortVideoSureRspInfo();
      ((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).mergeFrom(((Bdh_extinfo.ShortVideoRspExtInfo)localObject2).msg_shortvideo_sure_rsp.toByteArray());
      if (!((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).msg_videoinfo.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse error : rspInfo.msg_videoinfo is null");
        }
        this.a.f(4);
        return;
        paramHwResponse = finally;
        throw paramHwResponse;
      }
      localObject2 = (Bdh_extinfo.VideoInfo)((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).msg_videoinfo.get();
      if (!((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse error : videoInfo.bytes_bin_md5 is null");
        }
        this.a.f(4);
        return;
      }
      localObject3 = ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.get().toByteArray();
      i = ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.get();
      int j = ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.get();
      int k = ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.get();
      bbfb.a(String.valueOf(this.a.jdField_a_of_type_Aywc.jdField_a_of_type_Long), "svrcomp_r", "sendAckToBDHServer success!  MD5:" + HexUtil.bytes2HexStr((byte[])localObject3) + " mSendClicked : " + this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      this.a.jdField_a_of_type_Aywc.f = HexUtil.bytes2HexStr((byte[])localObject3);
      this.a.jdField_c_of_type_JavaLangString = this.a.jdField_a_of_type_Aywc.f;
      if (this.a.jdField_a_of_type_JavaUtilHashMap != null)
      {
        this.a.jdField_a_of_type_JavaUtilHashMap.put("param_fileMD5", this.a.jdField_a_of_type_Aywc.f);
        this.a.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(j));
        this.a.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(k));
        if (((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).uint32_merge_cost.has())
        {
          k = ((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).uint32_merge_cost.get();
          this.a.jdField_a_of_type_JavaUtilHashMap.put("param_cost_s_comp", String.valueOf(k));
        }
        this.a.jdField_a_of_type_JavaUtilHashMap.put("param_cost_s_store", String.valueOf(paramHwResponse.cacheCost));
      }
      this.a.jdField_a_of_type_Aywc.i = ShortVideoUtils.a((MessageForShortVideo)this.a.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, "mp4");
      this.a.f = ((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).bytes_fileid.get().toStringUtf8();
      this.a.q = i;
      this.a.jdField_c_of_type_Int = j;
      this.a.e.b();
      this.a.e.a = 1;
      if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (!ShortVideoUploadProcessor.jdField_a_of_type_Boolean) {
          break label893;
        }
        if (this.a.jdField_c_of_type_JavaUtilList.isEmpty()) {
          break label865;
        }
        localObject2 = this.a.jdField_c_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Transaction)((Iterator)localObject2).next()).cancelTransaction();
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramHwResponse)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "sendAckToBDHServer onResponse ", paramHwResponse);
      }
    }
    for (;;)
    {
      label849:
      return;
      this.a.jdField_c_of_type_JavaUtilList.clear();
      label865:
      if (this.a.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
      {
        this.a.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
        this.a.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
      }
      label893:
      localObject2 = this.a.jdField_a_of_type_Ayqo;
      localObject3 = this.a.jdField_a_of_type_Ayqo;
      ShortVideoUploadProcessor localShortVideoUploadProcessor2 = this.a;
      long l = this.a.q;
      localShortVideoUploadProcessor2.s = l;
      ((ayqo)localObject3).e = l;
      ((ayqo)localObject2).jdField_a_of_type_Long = l;
      this.a.d(1007);
      this.a.b(false);
      ShortVideoUploadProcessor.a(this.a, true, ((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).uint32_merge_cost.get(), String.valueOf(paramHwResponse.cacheCost));
      continue;
      label992:
      ShortVideoUploadProcessor.a(this.a, false, 0L, "");
      this.a.f(paramHwResponse.retCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvf
 * JD-Core Version:    0.7.0.1
 */