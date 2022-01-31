import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class bavx
  implements ITransactionCallback
{
  bavx(bavw parambavw, String paramString) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - bavw.a(this.jdField_a_of_type_Bavw)) + "ms");
    }
    bavw.a(this.jdField_a_of_type_Bavw).put("serverip", paramHashMap.get("ip"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_bdhSrv", paramHashMap.get("ip"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_bdhPort", paramHashMap.get("port"));
    bavw.a(this.jdField_a_of_type_Bavw).put("X-piccachetime", paramArrayOfByte);
    bavw.a(this.jdField_a_of_type_Bavw).put("param_BdhTrans", str1);
    bavw.a(this.jdField_a_of_type_Bavw).put("param_segspercnt", str2);
    bavw.a(this.jdField_a_of_type_Bavw).put("param_conf_segSize", str3);
    bavw.a(this.jdField_a_of_type_Bavw).put("param_conf_segNum", str4);
    bavw.a(this.jdField_a_of_type_Bavw).put("param_conf_connNum", str5);
    bavw.a(this.jdField_a_of_type_Bavw).put("param_fin_lost", str6);
    bavw.a(this.jdField_a_of_type_Bavw).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_retry_code", paramHashMap.get("param_retry_code"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_ip_index", paramHashMap.get("param_ip_index"));
    bavw.a(this.jdField_a_of_type_Bavw).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      bavw.a(this.jdField_a_of_type_Bavw, true);
    }
    bavw.a(this.jdField_a_of_type_Bavw, paramInt);
    bavw.c(this.jdField_a_of_type_Bavw, "sessionKey or sigSession is null");
    bavw.a(this.jdField_a_of_type_Bavw).a(paramInt, bavw.b(this.jdField_a_of_type_Bavw));
    bavw.a(this.jdField_a_of_type_Bavw, false);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          bavw.a(this.jdField_a_of_type_Bavw, paramArrayOfByte);
          bavw.a(this.jdField_a_of_type_Bavw).a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      bavw.b(this.jdField_a_of_type_Bavw, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - bavw.a(this.jdField_a_of_type_Bavw)) + "ms transInfo:" + bavw.a(this.jdField_a_of_type_Bavw));
      }
      bavw.a(this.jdField_a_of_type_Bavw).put("serverip", paramHashMap.get("ip"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_bdhSrv", paramHashMap.get("ip"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_bdhPort", paramHashMap.get("port"));
      bavw.a(this.jdField_a_of_type_Bavw).put("X-piccachetime", String.valueOf(bavw.a(this.jdField_a_of_type_Bavw).mTransReport.timeCost_Cache));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_BdhTrans", bavw.a(this.jdField_a_of_type_Bavw));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_segspercnt", paramArrayOfByte);
      bavw.a(this.jdField_a_of_type_Bavw).put("param_conf_segSize", str1);
      bavw.a(this.jdField_a_of_type_Bavw).put("param_conf_segNum", str2);
      bavw.a(this.jdField_a_of_type_Bavw).put("param_conf_connNum", str3);
      bavw.a(this.jdField_a_of_type_Bavw).put("param_fin_lost", str4);
      bavw.a(this.jdField_a_of_type_Bavw).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_retry_code", paramHashMap.get("param_retry_code"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_ip_index", paramHashMap.get("param_ip_index"));
      bavw.a(this.jdField_a_of_type_Bavw).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        bavw.a(this.jdField_a_of_type_Bavw, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bdhb.d(this.jdField_a_of_type_JavaLangString);
      bavw.a(this.jdField_a_of_type_Bavw, true);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PtvGuideUploader", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> onTransStart()");
    }
  }
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavx
 * JD-Core Version:    0.7.0.1
 */