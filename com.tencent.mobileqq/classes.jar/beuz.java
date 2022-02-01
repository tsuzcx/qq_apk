import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoRspExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureRspInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class beuz
  implements IRequestCallback
{
  beuz(beuw parambeuw) {}
  
  public void onFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer  onFailed  erroCode : " + paramInt);
    }
    this.a.f(paramInt);
  }
  
  public void onResponse(HwResponse paramHwResponse)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse retCode : " + paramHwResponse.retCode + " htCost:" + paramHwResponse.htCost + " front:" + paramHwResponse.cacheCost);
    }
    int i;
    if (paramHwResponse.retCode == 0)
    {
      if (paramHwResponse.segmentResp.uint32_cache_addr.has())
      {
        i = paramHwResponse.segmentResp.uint32_cache_addr.get();
        if (i != 0)
        {
          BdhLogUtil.LogEvent("R", "RequestAck onResponse : cache_addr res from server is : " + i + " ( " + HwRequest.intToIP(i) + " )");
          if (beuw.a(this.a) == 0) {
            beuw.a(this.a, i);
          }
          if ((beuw.a(this.a) != 0) && (beuw.a(this.a) != i)) {
            BdhLogUtil.LogEvent("R", "RequestAck onResponse : cache ip Diff !");
          }
        }
      }
      Object localObject1 = paramHwResponse.mBuExtendinfo;
      if ((localObject1 != null) && (localObject1.length > 0)) {
        try
        {
          localObject2 = new Bdh_extinfo.ShortVideoRspExtInfo();
          ((Bdh_extinfo.ShortVideoRspExtInfo)localObject2).mergeFrom((byte[])localObject1);
          if (!((Bdh_extinfo.ShortVideoRspExtInfo)localObject2).msg_shortvideo_sure_rsp.has())
          {
            if ((beuw.jdField_a_of_type_Boolean) || (!QLog.isColorLevel())) {
              return;
            }
            QLog.e("LightVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse error : rspExtInfo.msg_shortvideo_sure_rsp is null");
            return;
          }
          localObject1 = new Bdh_extinfo.ShortVideoSureRspInfo();
          ((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).mergeFrom(((Bdh_extinfo.ShortVideoRspExtInfo)localObject2).msg_shortvideo_sure_rsp.toByteArray());
          if (((Bdh_extinfo.ShortVideoSureRspInfo)localObject1).msg_videoinfo.has()) {
            break label326;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("LightVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse error : rspInfo.msg_videoinfo is null");
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LightVideoUploadProcessor", 2, "sendAckToBDHServer onResponse ", localInvalidProtocolBufferMicroException);
          }
        }
      }
    }
    this.a.f(paramHwResponse.retCode);
    return;
    label326:
    Object localObject2 = (Bdh_extinfo.VideoInfo)localInvalidProtocolBufferMicroException.msg_videoinfo.get();
    if (!((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("LightVideoUploadProcessor", 2, "<BDH_LOG>sendAckToBDHServer onResponse error : videoInfo.bytes_bin_md5 is null");
      }
    }
    else
    {
      Object localObject3 = ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.get().toByteArray();
      i = ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.get();
      int j = ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.get();
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.get();
      bhnn.a(String.valueOf(this.a.jdField_a_of_type_Beyg.a), "svrcomp_r", "sendAckToBDHServer success!  MD5:" + HexUtil.bytes2HexStr((byte[])localObject3));
      this.a.jdField_a_of_type_Beyg.f = HexUtil.bytes2HexStr((byte[])localObject3);
      this.a.jdField_a_of_type_Beyg.i = ShortVideoUtils.a(beuw.a(this.a), "mp4");
      this.a.c = this.a.jdField_a_of_type_Beyg.f;
      this.a.f = localInvalidProtocolBufferMicroException.bytes_fileid.get().toStringUtf8();
      this.a.q = i;
      beuw.a(this.a, j);
      bete localbete = this.a.jdField_a_of_type_Bete;
      localObject2 = this.a.jdField_a_of_type_Bete;
      localObject3 = this.a;
      long l = this.a.q;
      ((beuw)localObject3).s = l;
      ((bete)localObject2).e = l;
      localbete.a = l;
      this.a.d(1007);
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuz
 * JD-Core Version:    0.7.0.1
 */