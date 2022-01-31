import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoRspExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureRspInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.segment.HwRequest;
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

public class axva
  implements ITransactionCallback
{
  public int a;
  public Transaction a;
  
  public axva(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt);
    }
    badi.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.jdField_a_of_type_Long), "segment", "index: " + this.jdField_a_of_type_Int + "<BDH_LOG> step: resp onFailed errorCoed:" + paramInt + " BdhTransId : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)
    {
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true)))
      {
        BdhLogUtil.LogEvent("R", "TransactionListener onFailed : cacheIp of trans Diff!  BdhTransId : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
      }
      paramHashMap = (axow)this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (paramHashMap != null) {
        paramHashMap.b();
      }
      if (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 1) {
        return;
      }
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 1);
      ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, paramInt);
      paramHashMap = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.iterator();
      if (paramHashMap.hasNext()) {
        ((Transaction)paramHashMap.next()).cancelTransaction();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelAckRequest(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = null;
    }
    if (paramArrayOfByte != null) {
      paramHashMap = new Bdh_extinfo.ShortVideoRspExtInfo();
    }
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      if ((paramHashMap.uint32_retry_flag.has()) && (paramHashMap.uint32_retry_flag.get() != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener  onFailed. don't rollback ");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.b();
          this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.jdField_a_of_type_Int = 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener  onFailed !", paramArrayOfByte);
        }
      }
    }
    if (ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> TransactionListener.onFailed mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
      }
      badi.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.jdField_a_of_type_Long), "onFailed", "TransactionListener.onFailed mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor);
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    badi.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.jdField_a_of_type_Long), "segment", "index: " + this.jdField_a_of_type_Int + "<BDH_LOG> step: resp onSuccess BdhTransId : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true)))
        {
          BdhLogUtil.LogEvent("R", "TransactionListener onSuccess : cacheIp of trans Diff!  BdhTransId : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
          ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
        }
        localObject1 = (axow)this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
        if (localObject1 != null) {
          ((axow)localObject1).b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp == 0) {
          break label451;
        }
        BdhLogUtil.LogEvent("R", "TransactionListener onSuccess : trans.cacheIp is : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp + " ( " + HwRequest.intToIP(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp) + " ) BdhTransId : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
        if (ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 0) {
          break label546;
        }
        ShortVideoUploadProcessor.e(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Transaction)((Iterator)localObject1).next();
        if (((Transaction)localObject2).cacheIp == 0) {
          ((Transaction)localObject2).cacheIp = ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor);
        }
      }
      if (((Transaction)localObject2).cacheIp != ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor))
      {
        BdhLogUtil.LogEvent("R", "TransactionListener onSuccess : cacheIp Diff!  mCache_ip:" + ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " ( " + HwRequest.intToIP(ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)) + " )t.cacheIp : " + ((Transaction)localObject2).cacheIp);
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck.cacheIp_send = ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor);
    }
    label546:
    for (;;)
    {
      label451:
      if ((ShortVideoUploadProcessor.jdField_a_of_type_Boolean) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendFileSliceByBDH onSuccess -> extendInfo is not null");
        }
        try
        {
          localObject1 = new Bdh_extinfo.ShortVideoRspExtInfo();
          ((Bdh_extinfo.ShortVideoRspExtInfo)localObject1).mergeFrom(paramArrayOfByte);
          if (!((Bdh_extinfo.ShortVideoRspExtInfo)localObject1).msg_shortvideo_sure_rsp.has())
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.isEmpty()) && (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 4)) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f(5);
            }
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp != ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor))
            {
              BdhLogUtil.LogEvent("R", "TransactionListener onSuccess : cacheIp Diff!  mCache_ip:" + ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " ( " + HwRequest.intToIP(ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)) + " )");
              ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
            }
          }
          else
          {
            paramArrayOfByte = new Bdh_extinfo.ShortVideoSureRspInfo();
            paramArrayOfByte.mergeFrom(((Bdh_extinfo.ShortVideoRspExtInfo)localObject1).msg_shortvideo_sure_rsp.toByteArray());
            if (!paramArrayOfByte.msg_videoinfo.has())
            {
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendFileSliceByBDH onSuccess -> get rspInfo error : rspInfo.msg_videoinfo is null");
              }
              this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f(4);
              return;
            }
            localObject1 = (Bdh_extinfo.VideoInfo)paramArrayOfByte.msg_videoinfo.get();
            if (!((Bdh_extinfo.VideoInfo)localObject1).bytes_bin_md5.has())
            {
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendFileSliceByBDH onSuccess -> get rspInfo error  : videoInfo.bytes_bin_md5 is null");
              }
              this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f(4);
              return;
            }
            localObject2 = ((Bdh_extinfo.VideoInfo)localObject1).bytes_bin_md5.get().toByteArray();
            int i = ((Bdh_extinfo.VideoInfo)localObject1).uint32_size.get();
            int j = ((Bdh_extinfo.VideoInfo)localObject1).uint32_time.get();
            int k = ((Bdh_extinfo.VideoInfo)localObject1).uint32_format.get();
            badi.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.jdField_a_of_type_Long), "svrcomp_r", "TransactionListener.onSuccess -> get MD5 from Server success!  MD5:" + HexUtil.bytes2HexStr((byte[])localObject2));
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.f = HexUtil.bytes2HexStr((byte[])localObject2);
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.f;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fileMD5", this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.f);
              this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(j));
              this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(k));
              if (paramArrayOfByte.uint32_merge_cost.has())
              {
                k = paramArrayOfByte.uint32_merge_cost.get();
                this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_cost_s_comp", String.valueOf(k));
              }
              this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_cost_s_store", String.valueOf(paramHashMap.get("tc_p:")));
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.i = ShortVideoUtils.a((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, "mp4");
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f = paramArrayOfByte.bytes_fileid.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendFileSliceByBDH onSuccess mResid = " + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f);
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.q = i;
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_Int = j;
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.b();
            this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.jdField_a_of_type_Int = 1;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.isEmpty()) {
                break label1402;
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((Transaction)((Iterator)localObject1).next()).cancelTransaction();
              }
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.isEmpty()) {
              break label1386;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoUploadProcessor", 2, "sendFileSliceByBDH onSuccess ", paramArrayOfByte);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> TransactionListener.onSuccess , mTransactions.isEmpty() = true,  mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " mEncodeFinish = " + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mSendClicked = " + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if (ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.t();
    }
    if ((!ShortVideoUploadProcessor.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilList);
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 3);
    }
    label1386:
    return;
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.clear();
    label1402:
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axqf;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axqf;
    ShortVideoUploadProcessor localShortVideoUploadProcessor2 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor;
    long l = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.q;
    localShortVideoUploadProcessor2.s = l;
    ((axqf)localObject2).e = l;
    ((axqf)localObject1).jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d(1007);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.b(false);
    ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true, paramArrayOfByte.uint32_merge_cost.get(), String.valueOf(paramHashMap.get("tc_p:")));
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt)
  {
    for (;;)
    {
      Transaction localTransaction;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor;
        ((ShortVideoUploadProcessor)localObject1).s += paramInt;
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Axqf.e = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.s;
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp == 0) {
          break label317;
        }
        BdhLogUtil.LogEvent("R", "TransactionListener onUpdateProgress : trans.cacheIp is : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp + " ( " + HwRequest.intToIP(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp) + " ) BdhTransId : " + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
        if (ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 0) {
          break label365;
        }
        ShortVideoUploadProcessor.e(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_c_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localTransaction = (Transaction)((Iterator)localObject1).next();
        if (localTransaction.cacheIp == 0) {
          localTransaction.cacheIp = ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor);
        }
      }
      if (localTransaction.cacheIp != ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor))
      {
        BdhLogUtil.LogEvent("R", "TransactionListener onUpdateProgress : cacheIp Diff!  mCache_ip:" + ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " ( " + HwRequest.intToIP(ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)) + " )t.cacheIp : " + localTransaction.cacheIp);
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck.cacheIp_send = ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor);
    }
    for (;;)
    {
      label317:
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.s < this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.q) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.k)) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.i();
      }
      return;
      label365:
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cacheIp != ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor))
      {
        BdhLogUtil.LogEvent("R", "TransactionListener onUpdateProgress : cacheIp Diff!  mCache_ip:" + ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " ( " + HwRequest.intToIP(ShortVideoUploadProcessor.d(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)) + " )");
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axva
 * JD-Core Version:    0.7.0.1
 */