import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class axti
  implements ITransactionCallback
{
  axti(axth paramaxth, String paramString) {}
  
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
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - axth.a(this.jdField_a_of_type_Axth)) + "ms");
    }
    axth.a(this.jdField_a_of_type_Axth).put("serverip", paramHashMap.get("ip"));
    axth.a(this.jdField_a_of_type_Axth).put("param_bdhSrv", paramHashMap.get("ip"));
    axth.a(this.jdField_a_of_type_Axth).put("param_bdhPort", paramHashMap.get("port"));
    axth.a(this.jdField_a_of_type_Axth).put("X-piccachetime", paramArrayOfByte);
    axth.a(this.jdField_a_of_type_Axth).put("param_BdhTrans", str1);
    axth.a(this.jdField_a_of_type_Axth).put("param_segspercnt", str2);
    axth.a(this.jdField_a_of_type_Axth).put("param_conf_segSize", str3);
    axth.a(this.jdField_a_of_type_Axth).put("param_conf_segNum", str4);
    axth.a(this.jdField_a_of_type_Axth).put("param_conf_connNum", str5);
    axth.a(this.jdField_a_of_type_Axth).put("param_fin_lost", str6);
    axth.a(this.jdField_a_of_type_Axth).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    axth.a(this.jdField_a_of_type_Axth).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    axth.a(this.jdField_a_of_type_Axth).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    axth.a(this.jdField_a_of_type_Axth).put("param_retry_code", paramHashMap.get("param_retry_code"));
    axth.a(this.jdField_a_of_type_Axth).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    axth.a(this.jdField_a_of_type_Axth).put("param_ip_index", paramHashMap.get("param_ip_index"));
    axth.a(this.jdField_a_of_type_Axth).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      axth.a(this.jdField_a_of_type_Axth, true);
    }
    axth.a(this.jdField_a_of_type_Axth, paramInt);
    axth.c(this.jdField_a_of_type_Axth, "sessionKey or sigSession is null");
    axth.a(this.jdField_a_of_type_Axth).a(paramInt, axth.b(this.jdField_a_of_type_Axth));
    axth.a(this.jdField_a_of_type_Axth, false);
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
          axth.a(this.jdField_a_of_type_Axth, paramArrayOfByte);
          axth.a(this.jdField_a_of_type_Axth).a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      axth.b(this.jdField_a_of_type_Axth, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - axth.a(this.jdField_a_of_type_Axth)) + "ms transInfo:" + axth.a(this.jdField_a_of_type_Axth));
      }
      axth.a(this.jdField_a_of_type_Axth).put("serverip", paramHashMap.get("ip"));
      axth.a(this.jdField_a_of_type_Axth).put("param_bdhSrv", paramHashMap.get("ip"));
      axth.a(this.jdField_a_of_type_Axth).put("param_bdhPort", paramHashMap.get("port"));
      axth.a(this.jdField_a_of_type_Axth).put("X-piccachetime", String.valueOf(axth.a(this.jdField_a_of_type_Axth).mTransReport.timeCost_Cache));
      axth.a(this.jdField_a_of_type_Axth).put("param_BdhTrans", axth.a(this.jdField_a_of_type_Axth));
      axth.a(this.jdField_a_of_type_Axth).put("param_segspercnt", paramArrayOfByte);
      axth.a(this.jdField_a_of_type_Axth).put("param_conf_segSize", str1);
      axth.a(this.jdField_a_of_type_Axth).put("param_conf_segNum", str2);
      axth.a(this.jdField_a_of_type_Axth).put("param_conf_connNum", str3);
      axth.a(this.jdField_a_of_type_Axth).put("param_fin_lost", str4);
      axth.a(this.jdField_a_of_type_Axth).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      axth.a(this.jdField_a_of_type_Axth).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      axth.a(this.jdField_a_of_type_Axth).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      axth.a(this.jdField_a_of_type_Axth).put("param_retry_code", paramHashMap.get("param_retry_code"));
      axth.a(this.jdField_a_of_type_Axth).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      axth.a(this.jdField_a_of_type_Axth).put("param_ip_index", paramHashMap.get("param_ip_index"));
      axth.a(this.jdField_a_of_type_Axth).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        axth.a(this.jdField_a_of_type_Axth, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bace.d(this.jdField_a_of_type_JavaLangString);
      axth.a(this.jdField_a_of_type_Axth, true);
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
 * Qualified Name:     axti
 * JD-Core Version:    0.7.0.1
 */