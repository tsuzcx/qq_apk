import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.2.1;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.2.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

public class ayux
  implements ITransactionCallback
{
  ayux(ayuw paramayuw, long paramLong, String paramString) {}
  
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
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_bdhSrv", paramHashMap.get("ip"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_bdhPort", paramHashMap.get("port"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str5);
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str6);
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_net_ip_type", paramHashMap.get("param_net_ip_type"));
    ThreadManager.post(new ShortVideoForwardProcessor.2.2(this, l2, l3, l4, l5), 5, null, true);
    this.jdField_a_of_type_Ayuw.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Ayuw.jdField_b_of_type_Aypd);
    this.jdField_a_of_type_Ayuw.d();
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
          this.jdField_a_of_type_Ayuw.f = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      paramArrayOfByte = (String)paramHashMap.get("rep_bdhTrans");
      String str1 = (String)paramHashMap.get("segspercnt");
      String str2 = (String)paramHashMap.get("param_conf_segSize");
      String str3 = (String)paramHashMap.get("param_conf_segNum");
      String str4 = (String)paramHashMap.get("param_conf_connNum");
      String str5 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Ayuw.jdField_a_of_type_Ayqo.jdField_a_of_type_Long + " transInfo:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_bdhSrv", paramHashMap.get("ip"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_bdhPort", paramHashMap.get("port"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_a_of_type_Ayuw.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", paramArrayOfByte);
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str1);
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str2);
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str3);
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str4);
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str5);
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_net_ip_type", paramHashMap.get("param_net_ip_type"));
      this.jdField_a_of_type_Ayuw.jdField_b_of_type_Aypd.b();
      this.jdField_a_of_type_Ayuw.jdField_b_of_type_Aypd.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Ayuw.s = this.jdField_a_of_type_Ayuw.jdField_q_of_type_Long;
      this.jdField_a_of_type_Ayuw.jdField_q_of_type_Boolean = true;
      this.jdField_a_of_type_Ayuw.b(false);
      ThreadManager.post(new ShortVideoForwardProcessor.2.1(this, l2, l3, l4, l5), 5, null, true);
      this.jdField_a_of_type_Ayuw.jdField_a_of_type_Ayqo.a();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bbdx.d(this.jdField_a_of_type_JavaLangString);
      paramArrayOfByte = (String)paramHashMap.get("ip");
      paramHashMap = (String)paramHashMap.get("port");
      this.jdField_a_of_type_Ayuw.a(true, 0, paramArrayOfByte, paramHashMap);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoForwardProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Ayuw.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Ayuw.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Ayuw.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Ayuw.jdField_b_of_type_Aypd.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Ayuw.jdField_b_of_type_Aypd.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ayuw localayuw = this.jdField_a_of_type_Ayuw;
    ayqo localayqo = this.jdField_a_of_type_Ayuw.jdField_a_of_type_Ayqo;
    long l = paramInt;
    localayqo.e = l;
    localayuw.s = l;
    if ((paramInt < this.jdField_a_of_type_Ayuw.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Ayuw.o) && (!this.jdField_a_of_type_Ayuw.k))
    {
      this.jdField_a_of_type_Ayuw.i();
      if (this.jdField_a_of_type_Ayuw.g) {
        bjmu.a(this.jdField_a_of_type_Ayuw.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1002, this.jdField_a_of_type_Ayuw.f());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayux
 * JD-Core Version:    0.7.0.1
 */