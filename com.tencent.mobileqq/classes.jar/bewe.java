import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class bewe
  implements ITransactionCallback
{
  bewe(bewd parambewd, String paramString) {}
  
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
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - bewd.a(this.jdField_a_of_type_Bewd)) + "ms");
    }
    bewd.a(this.jdField_a_of_type_Bewd).put("serverip", paramHashMap.get("ip"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_bdhSrv", paramHashMap.get("ip"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_bdhPort", paramHashMap.get("port"));
    bewd.a(this.jdField_a_of_type_Bewd).put("X-piccachetime", paramArrayOfByte);
    bewd.a(this.jdField_a_of_type_Bewd).put("param_BdhTrans", str1);
    bewd.a(this.jdField_a_of_type_Bewd).put("param_segspercnt", str2);
    bewd.a(this.jdField_a_of_type_Bewd).put("param_conf_segSize", str3);
    bewd.a(this.jdField_a_of_type_Bewd).put("param_conf_segNum", str4);
    bewd.a(this.jdField_a_of_type_Bewd).put("param_conf_connNum", str5);
    bewd.a(this.jdField_a_of_type_Bewd).put("param_fin_lost", str6);
    bewd.a(this.jdField_a_of_type_Bewd).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_retry_code", paramHashMap.get("param_retry_code"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_ip_index", paramHashMap.get("param_ip_index"));
    bewd.a(this.jdField_a_of_type_Bewd).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      bewd.a(this.jdField_a_of_type_Bewd, true);
    }
    bewd.a(this.jdField_a_of_type_Bewd, paramInt);
    bewd.c(this.jdField_a_of_type_Bewd, "sessionKey or sigSession is null");
    bewd.a(this.jdField_a_of_type_Bewd).a(paramInt, bewd.b(this.jdField_a_of_type_Bewd));
    bewd.a(this.jdField_a_of_type_Bewd, false);
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
          bewd.a(this.jdField_a_of_type_Bewd, paramArrayOfByte);
          bewd.a(this.jdField_a_of_type_Bewd).a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      bewd.b(this.jdField_a_of_type_Bewd, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - bewd.a(this.jdField_a_of_type_Bewd)) + "ms transInfo:" + bewd.a(this.jdField_a_of_type_Bewd));
      }
      bewd.a(this.jdField_a_of_type_Bewd).put("serverip", paramHashMap.get("ip"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_bdhSrv", paramHashMap.get("ip"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_bdhPort", paramHashMap.get("port"));
      bewd.a(this.jdField_a_of_type_Bewd).put("X-piccachetime", String.valueOf(bewd.a(this.jdField_a_of_type_Bewd).mTransReport.timeCost_Cache));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_BdhTrans", bewd.a(this.jdField_a_of_type_Bewd));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_segspercnt", paramArrayOfByte);
      bewd.a(this.jdField_a_of_type_Bewd).put("param_conf_segSize", str1);
      bewd.a(this.jdField_a_of_type_Bewd).put("param_conf_segNum", str2);
      bewd.a(this.jdField_a_of_type_Bewd).put("param_conf_connNum", str3);
      bewd.a(this.jdField_a_of_type_Bewd).put("param_fin_lost", str4);
      bewd.a(this.jdField_a_of_type_Bewd).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_retry_code", paramHashMap.get("param_retry_code"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_ip_index", paramHashMap.get("param_ip_index"));
      bewd.a(this.jdField_a_of_type_Bewd).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        bewd.a(this.jdField_a_of_type_Bewd, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bhmi.d(this.jdField_a_of_type_JavaLangString);
      bewd.a(this.jdField_a_of_type_Bewd, true);
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
 * Qualified Name:     bewe
 * JD-Core Version:    0.7.0.1
 */