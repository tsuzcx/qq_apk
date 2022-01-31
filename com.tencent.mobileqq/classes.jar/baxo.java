import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.2.1;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.2.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

public class baxo
  implements ITransactionCallback
{
  public baxo(ShortVideoUploadProcessor paramShortVideoUploadProcessor, long paramLong, String paramString) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_bdhSrv", paramHashMap.get("ip"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_bdhPort", paramHashMap.get("port"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str6);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_net_ip_type", paramHashMap.get("param_net_ip_type"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
    }
    ThreadManager.post(new ShortVideoUploadProcessor.2.2(this, l2, l3, l4, l5), 5, null, true);
    ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, false, 0L, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_Barh);
    if ((ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 3) && (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.b();
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.jdField_a_of_type_Int = 0;
    }
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d();
      return;
      azqy.a("Upload_Video_Error", String.valueOf(paramInt));
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      Object localObject = (String)paramHashMap.get("param_conf_segNum");
      String str2 = (String)paramHashMap.get("param_conf_connNum");
      String str3 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Bass.jdField_a_of_type_Long + " transInfo:" + ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_bdhSrv", paramHashMap.get("ip"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_bdhPort", paramHashMap.get("port"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str1);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", localObject);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str2);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str3);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_net_ip_type", paramHashMap.get("param_net_ip_type"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_Barh.b();
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_Barh.jdField_a_of_type_Int = 1;
      if ((ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 3) && (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.b();
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.e.jdField_a_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.s = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.q;
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.g = true;
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d(1007);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.b(false);
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true, -1L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache));
      ThreadManager.post(new ShortVideoUploadProcessor.2.1(this, l2, l3, l4, l5), 5, null, true);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Bass.a();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bdhb.d(this.jdField_a_of_type_JavaLangString);
      str1 = (String)paramHashMap.get("ip");
      paramHashMap = (String)paramHashMap.get("port");
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f == null)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.l;
        ((ShortVideoUploadProcessor)localObject).a("actRichMediaNetMonitor_videoUp", true, 0, str1, paramHashMap, str2, paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.x + "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("ShortVideoUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
          continue;
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.f;
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_Barh.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_Barh.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ShortVideoUploadProcessor localShortVideoUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor;
    bass localbass = this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_Bass;
    long l = paramInt;
    localbass.e = l;
    localShortVideoUploadProcessor.s = l;
    if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.q) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.k)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxo
 * JD-Core Version:    0.7.0.1
 */