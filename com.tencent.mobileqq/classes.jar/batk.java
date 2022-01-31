import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.2.1;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.2.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class batk
  implements ITransactionCallback
{
  batk(batj parambatj) {}
  
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
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - batj.a(this.a)) + "ms");
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str5);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str6);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_net_ip_type", paramHashMap.get("param_net_ip_type"));
    ThreadManager.post(new GroupPicUploadProcessor.2.2(this, l2, l3, l4, l5), 5, null, false);
    this.a.a(paramInt, "OnFailed.", "", this.a.jdField_b_of_type_Barh);
    this.a.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
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
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - batj.a(this.a)) + "ms ,fileSize:" + this.a.jdField_a_of_type_Bass.a + " transInfo:" + paramArrayOfByte);
    }
    this.a.m = this.a.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Ht;
    this.a.jdField_o_of_type_Long = this.a.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache;
    this.a.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.a.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", paramArrayOfByte);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str1);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str2);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str3);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str4);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str5);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_net_ip_type", paramHashMap.get("param_net_ip_type"));
    this.a.jdField_b_of_type_Barh.b();
    this.a.jdField_b_of_type_Barh.a = 1;
    this.a.s = this.a.jdField_q_of_type_Long;
    this.a.jdField_q_of_type_Boolean = true;
    this.a.t();
    ThreadManager.post(new GroupPicUploadProcessor.2.1(this, l2, l3, l4, l5), 5, null, false);
    this.a.jdField_a_of_type_Bass.a();
    paramArrayOfByte = (String)paramHashMap.get("ip");
    paramHashMap = (String)paramHashMap.get("port");
    this.a.a(true, 0, paramArrayOfByte, paramHashMap);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.a.d("<BDH_LOG> onSwitch2BackupChannel() switch to HTTP channel");
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - batj.a(this.a)));
  }
  
  public void onTransStart()
  {
    this.a.jdField_b_of_type_Barh.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    batj localbatj = this.a;
    bass localbass = this.a.jdField_a_of_type_Bass;
    long l = paramInt;
    localbass.e = l;
    localbatj.s = l;
    if ((paramInt < this.a.jdField_q_of_type_Long) && (!this.a.jdField_o_of_type_Boolean) && (!this.a.k))
    {
      this.a.i();
      if (batj.a(this.a)) {
        bmcp.a(batj.a(this.a), 1002, this.a.f());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batk
 * JD-Core Version:    0.7.0.1
 */