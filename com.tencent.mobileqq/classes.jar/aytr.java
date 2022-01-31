import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class aytr
  implements ITransactionCallback
{
  aytr(aytq paramaytq, String paramString) {}
  
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
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - aytq.a(this.jdField_a_of_type_Aytq)) + "ms");
    }
    aytq.a(this.jdField_a_of_type_Aytq).put("serverip", paramHashMap.get("ip"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_bdhSrv", paramHashMap.get("ip"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_bdhPort", paramHashMap.get("port"));
    aytq.a(this.jdField_a_of_type_Aytq).put("X-piccachetime", paramArrayOfByte);
    aytq.a(this.jdField_a_of_type_Aytq).put("param_BdhTrans", str1);
    aytq.a(this.jdField_a_of_type_Aytq).put("param_segspercnt", str2);
    aytq.a(this.jdField_a_of_type_Aytq).put("param_conf_segSize", str3);
    aytq.a(this.jdField_a_of_type_Aytq).put("param_conf_segNum", str4);
    aytq.a(this.jdField_a_of_type_Aytq).put("param_conf_connNum", str5);
    aytq.a(this.jdField_a_of_type_Aytq).put("param_fin_lost", str6);
    aytq.a(this.jdField_a_of_type_Aytq).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_retry_code", paramHashMap.get("param_retry_code"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_ip_index", paramHashMap.get("param_ip_index"));
    aytq.a(this.jdField_a_of_type_Aytq).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      aytq.a(this.jdField_a_of_type_Aytq, true);
    }
    aytq.a(this.jdField_a_of_type_Aytq, paramInt);
    aytq.c(this.jdField_a_of_type_Aytq, "sessionKey or sigSession is null");
    aytq.a(this.jdField_a_of_type_Aytq).a(paramInt, aytq.b(this.jdField_a_of_type_Aytq));
    aytq.a(this.jdField_a_of_type_Aytq, false);
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
          aytq.a(this.jdField_a_of_type_Aytq, paramArrayOfByte);
          aytq.a(this.jdField_a_of_type_Aytq).a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      aytq.b(this.jdField_a_of_type_Aytq, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - aytq.a(this.jdField_a_of_type_Aytq)) + "ms transInfo:" + aytq.a(this.jdField_a_of_type_Aytq));
      }
      aytq.a(this.jdField_a_of_type_Aytq).put("serverip", paramHashMap.get("ip"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_bdhSrv", paramHashMap.get("ip"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_bdhPort", paramHashMap.get("port"));
      aytq.a(this.jdField_a_of_type_Aytq).put("X-piccachetime", String.valueOf(aytq.a(this.jdField_a_of_type_Aytq).mTransReport.timeCost_Cache));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_BdhTrans", aytq.a(this.jdField_a_of_type_Aytq));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_segspercnt", paramArrayOfByte);
      aytq.a(this.jdField_a_of_type_Aytq).put("param_conf_segSize", str1);
      aytq.a(this.jdField_a_of_type_Aytq).put("param_conf_segNum", str2);
      aytq.a(this.jdField_a_of_type_Aytq).put("param_conf_connNum", str3);
      aytq.a(this.jdField_a_of_type_Aytq).put("param_fin_lost", str4);
      aytq.a(this.jdField_a_of_type_Aytq).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_retry_code", paramHashMap.get("param_retry_code"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_ip_index", paramHashMap.get("param_ip_index"));
      aytq.a(this.jdField_a_of_type_Aytq).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        aytq.a(this.jdField_a_of_type_Aytq, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bbdx.d(this.jdField_a_of_type_JavaLangString);
      aytq.a(this.jdField_a_of_type_Aytq, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aytr
 * JD-Core Version:    0.7.0.1
 */