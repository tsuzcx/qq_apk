import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class baro
  implements ITransactionCallback
{
  baro(barn parambarn, String paramString) {}
  
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
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - barn.a(this.jdField_a_of_type_Barn)) + "ms");
    }
    barn.a(this.jdField_a_of_type_Barn).put("serverip", paramHashMap.get("ip"));
    barn.a(this.jdField_a_of_type_Barn).put("param_bdhSrv", paramHashMap.get("ip"));
    barn.a(this.jdField_a_of_type_Barn).put("param_bdhPort", paramHashMap.get("port"));
    barn.a(this.jdField_a_of_type_Barn).put("X-piccachetime", paramArrayOfByte);
    barn.a(this.jdField_a_of_type_Barn).put("param_BdhTrans", str1);
    barn.a(this.jdField_a_of_type_Barn).put("param_segspercnt", str2);
    barn.a(this.jdField_a_of_type_Barn).put("param_conf_segSize", str3);
    barn.a(this.jdField_a_of_type_Barn).put("param_conf_segNum", str4);
    barn.a(this.jdField_a_of_type_Barn).put("param_conf_connNum", str5);
    barn.a(this.jdField_a_of_type_Barn).put("param_fin_lost", str6);
    barn.a(this.jdField_a_of_type_Barn).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    barn.a(this.jdField_a_of_type_Barn).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    barn.a(this.jdField_a_of_type_Barn).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    barn.a(this.jdField_a_of_type_Barn).put("param_retry_code", paramHashMap.get("param_retry_code"));
    barn.a(this.jdField_a_of_type_Barn).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    barn.a(this.jdField_a_of_type_Barn).put("param_ip_index", paramHashMap.get("param_ip_index"));
    barn.a(this.jdField_a_of_type_Barn).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      barn.a(this.jdField_a_of_type_Barn, true);
    }
    barn.a(this.jdField_a_of_type_Barn, paramInt);
    barn.c(this.jdField_a_of_type_Barn, "sessionKey or sigSession is null");
    barn.a(this.jdField_a_of_type_Barn).a(paramInt, barn.b(this.jdField_a_of_type_Barn));
    barn.a(this.jdField_a_of_type_Barn, false);
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
          barn.a(this.jdField_a_of_type_Barn, paramArrayOfByte);
          barn.a(this.jdField_a_of_type_Barn).a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      barn.b(this.jdField_a_of_type_Barn, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - barn.a(this.jdField_a_of_type_Barn)) + "ms transInfo:" + barn.a(this.jdField_a_of_type_Barn));
      }
      barn.a(this.jdField_a_of_type_Barn).put("serverip", paramHashMap.get("ip"));
      barn.a(this.jdField_a_of_type_Barn).put("param_bdhSrv", paramHashMap.get("ip"));
      barn.a(this.jdField_a_of_type_Barn).put("param_bdhPort", paramHashMap.get("port"));
      barn.a(this.jdField_a_of_type_Barn).put("X-piccachetime", String.valueOf(barn.a(this.jdField_a_of_type_Barn).mTransReport.timeCost_Cache));
      barn.a(this.jdField_a_of_type_Barn).put("param_BdhTrans", barn.a(this.jdField_a_of_type_Barn));
      barn.a(this.jdField_a_of_type_Barn).put("param_segspercnt", paramArrayOfByte);
      barn.a(this.jdField_a_of_type_Barn).put("param_conf_segSize", str1);
      barn.a(this.jdField_a_of_type_Barn).put("param_conf_segNum", str2);
      barn.a(this.jdField_a_of_type_Barn).put("param_conf_connNum", str3);
      barn.a(this.jdField_a_of_type_Barn).put("param_fin_lost", str4);
      barn.a(this.jdField_a_of_type_Barn).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      barn.a(this.jdField_a_of_type_Barn).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      barn.a(this.jdField_a_of_type_Barn).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      barn.a(this.jdField_a_of_type_Barn).put("param_retry_code", paramHashMap.get("param_retry_code"));
      barn.a(this.jdField_a_of_type_Barn).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      barn.a(this.jdField_a_of_type_Barn).put("param_ip_index", paramHashMap.get("param_ip_index"));
      barn.a(this.jdField_a_of_type_Barn).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        barn.a(this.jdField_a_of_type_Barn, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bdcs.d(this.jdField_a_of_type_JavaLangString);
      barn.a(this.jdField_a_of_type_Barn, true);
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
 * Qualified Name:     baro
 * JD-Core Version:    0.7.0.1
 */