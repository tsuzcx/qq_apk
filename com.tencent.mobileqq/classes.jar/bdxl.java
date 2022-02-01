import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class bdxl
  implements ITransactionCallback
{
  bdxl(bdxk parambdxk, String paramString) {}
  
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
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - bdxk.a(this.jdField_a_of_type_Bdxk)) + "ms");
    }
    bdxk.a(this.jdField_a_of_type_Bdxk).put("serverip", paramHashMap.get("ip"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_bdhSrv", paramHashMap.get("ip"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_bdhPort", paramHashMap.get("port"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("X-piccachetime", paramArrayOfByte);
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_BdhTrans", str1);
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_segspercnt", str2);
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_conf_segSize", str3);
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_conf_segNum", str4);
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_conf_connNum", str5);
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_fin_lost", str6);
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_retry_code", paramHashMap.get("param_retry_code"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_ip_index", paramHashMap.get("param_ip_index"));
    bdxk.a(this.jdField_a_of_type_Bdxk).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      bdxk.a(this.jdField_a_of_type_Bdxk, true);
    }
    bdxk.a(this.jdField_a_of_type_Bdxk, paramInt);
    bdxk.c(this.jdField_a_of_type_Bdxk, "sessionKey or sigSession is null");
    bdxk.a(this.jdField_a_of_type_Bdxk).a(paramInt, bdxk.b(this.jdField_a_of_type_Bdxk));
    bdxk.a(this.jdField_a_of_type_Bdxk, false);
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
          bdxk.a(this.jdField_a_of_type_Bdxk, paramArrayOfByte);
          bdxk.a(this.jdField_a_of_type_Bdxk).a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      bdxk.b(this.jdField_a_of_type_Bdxk, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - bdxk.a(this.jdField_a_of_type_Bdxk)) + "ms transInfo:" + bdxk.a(this.jdField_a_of_type_Bdxk));
      }
      bdxk.a(this.jdField_a_of_type_Bdxk).put("serverip", paramHashMap.get("ip"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_bdhSrv", paramHashMap.get("ip"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_bdhPort", paramHashMap.get("port"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("X-piccachetime", String.valueOf(bdxk.a(this.jdField_a_of_type_Bdxk).mTransReport.timeCost_Cache));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_BdhTrans", bdxk.a(this.jdField_a_of_type_Bdxk));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_segspercnt", paramArrayOfByte);
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_conf_segSize", str1);
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_conf_segNum", str2);
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_conf_connNum", str3);
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_fin_lost", str4);
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_retry_code", paramHashMap.get("param_retry_code"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_ip_index", paramHashMap.get("param_ip_index"));
      bdxk.a(this.jdField_a_of_type_Bdxk).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        bdxk.a(this.jdField_a_of_type_Bdxk, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bgmg.d(this.jdField_a_of_type_JavaLangString);
      bdxk.a(this.jdField_a_of_type_Bdxk, true);
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
 * Qualified Name:     bdxl
 * JD-Core Version:    0.7.0.1
 */