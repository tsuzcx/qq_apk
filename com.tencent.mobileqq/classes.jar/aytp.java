import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class aytp
  implements ITransactionCallback
{
  aytp(ayto paramayto, String paramString) {}
  
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
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - ayto.a(this.jdField_a_of_type_Ayto)) + "ms");
    }
    ayto.a(this.jdField_a_of_type_Ayto).put("serverip", paramHashMap.get("ip"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_bdhSrv", paramHashMap.get("ip"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_bdhPort", paramHashMap.get("port"));
    ayto.a(this.jdField_a_of_type_Ayto).put("X-piccachetime", paramArrayOfByte);
    ayto.a(this.jdField_a_of_type_Ayto).put("param_BdhTrans", str1);
    ayto.a(this.jdField_a_of_type_Ayto).put("param_segspercnt", str2);
    ayto.a(this.jdField_a_of_type_Ayto).put("param_conf_segSize", str3);
    ayto.a(this.jdField_a_of_type_Ayto).put("param_conf_segNum", str4);
    ayto.a(this.jdField_a_of_type_Ayto).put("param_conf_connNum", str5);
    ayto.a(this.jdField_a_of_type_Ayto).put("param_fin_lost", str6);
    ayto.a(this.jdField_a_of_type_Ayto).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_retry_code", paramHashMap.get("param_retry_code"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_ip_index", paramHashMap.get("param_ip_index"));
    ayto.a(this.jdField_a_of_type_Ayto).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      ayto.a(this.jdField_a_of_type_Ayto, true);
    }
    ayto.a(this.jdField_a_of_type_Ayto, paramInt);
    ayto.c(this.jdField_a_of_type_Ayto, "sessionKey or sigSession is null");
    ayto.a(this.jdField_a_of_type_Ayto).a(paramInt, ayto.b(this.jdField_a_of_type_Ayto));
    ayto.a(this.jdField_a_of_type_Ayto, false);
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
          ayto.a(this.jdField_a_of_type_Ayto, paramArrayOfByte);
          ayto.a(this.jdField_a_of_type_Ayto).a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      ayto.b(this.jdField_a_of_type_Ayto, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - ayto.a(this.jdField_a_of_type_Ayto)) + "ms transInfo:" + ayto.a(this.jdField_a_of_type_Ayto));
      }
      ayto.a(this.jdField_a_of_type_Ayto).put("serverip", paramHashMap.get("ip"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_bdhSrv", paramHashMap.get("ip"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_bdhPort", paramHashMap.get("port"));
      ayto.a(this.jdField_a_of_type_Ayto).put("X-piccachetime", String.valueOf(ayto.a(this.jdField_a_of_type_Ayto).mTransReport.timeCost_Cache));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_BdhTrans", ayto.a(this.jdField_a_of_type_Ayto));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_segspercnt", paramArrayOfByte);
      ayto.a(this.jdField_a_of_type_Ayto).put("param_conf_segSize", str1);
      ayto.a(this.jdField_a_of_type_Ayto).put("param_conf_segNum", str2);
      ayto.a(this.jdField_a_of_type_Ayto).put("param_conf_connNum", str3);
      ayto.a(this.jdField_a_of_type_Ayto).put("param_fin_lost", str4);
      ayto.a(this.jdField_a_of_type_Ayto).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_retry_code", paramHashMap.get("param_retry_code"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_ip_index", paramHashMap.get("param_ip_index"));
      ayto.a(this.jdField_a_of_type_Ayto).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        ayto.a(this.jdField_a_of_type_Ayto, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bbdj.d(this.jdField_a_of_type_JavaLangString);
      ayto.a(this.jdField_a_of_type_Ayto, true);
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
 * Qualified Name:     aytp
 * JD-Core Version:    0.7.0.1
 */