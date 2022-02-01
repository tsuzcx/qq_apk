import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.uploader.UploadRequest;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class blhm
{
  public static void a(String paramString1, String paramString2, blfs paramblfs, boolean paramBoolean, long paramLong)
  {
    try
    {
      blhn localblhn = new blhn();
      localblhn.jdField_a_of_type_Int = paramblfs.jdField_b_of_type_Int;
      localblhn.jdField_a_of_type_JavaLangString = paramblfs.jdField_a_of_type_JavaLangString;
      blfr localblfr2 = paramblfs.jdField_a_of_type_Blfr;
      blfr localblfr1 = localblfr2;
      if (localblfr2 == null) {
        localblfr1 = blfu.a().a(paramLong);
      }
      if (localblfr1 != null)
      {
        localblhn.f = localblfr1.a().jdField_b_of_type_JavaLangString;
        localblhn.jdField_a_of_type_Long = localblfr1.a().jdField_a_of_type_Long;
        localblhn.g = localblfr1.a().jdField_a_of_type_JavaLangString;
        localblhn.e = localblfr1.a().c;
        localblhn.h = paramblfs.jdField_b_of_type_JavaLangString;
        paramblfs = localblfr1.a();
        if (paramblfs != null) {
          localblhn.d = paramblfs.mReqUrl;
        }
      }
      a(paramString1, paramString2, localblhn, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, blhn paramblhn, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramblhn.jdField_a_of_type_Int));
    localHashMap.put("serverip", paramblhn.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", paramblhn.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(paramblhn.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", paramblhn.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", paramblhn.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", paramblhn.c);
    localHashMap.put("param_serverPort", String.valueOf(paramblhn.jdField_b_of_type_Int));
    localHashMap.put("param_url", paramblhn.d);
    localHashMap.put("param_MD5", paramblhn.e);
    Object localObject;
    if (paramblhn.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(paramblhn.jdField_a_of_type_Long));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", paramblhn.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", paramblhn.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", paramblhn.d);
        ((JSONObject)localObject).put("t_file_name", paramblhn.f);
        ((JSONObject)localObject).put("t_file_id", paramblhn.g);
        ((JSONObject)localObject).put("t_file_path", paramblhn.h);
        ((JSONObject)localObject).put("t_file_size", paramblhn.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", paramblhn.e);
        ((JSONObject)localObject).put("t_err_code", paramblhn.jdField_a_of_type_Int);
        if (paramString1 != null)
        {
          if (paramString1.startsWith("weiyun_")) {
            l = Long.parseLong(paramString1.substring(7));
          }
        }
        else
        {
          label343:
          ((JSONObject)localObject).put("t_uin", l);
          ((JSONObject)localObject).put("t_terminal", "Android_mobileQQ");
          if (!paramBoolean2) {
            break label466;
          }
        }
        label466:
        for (int i = 1;; i = 2)
        {
          ((JSONObject)localObject).put("t_action", i);
          ((JSONObject)localObject).put("t_app_ver", aqmy.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", paramblhn.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          blfc.a("https://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
          return;
          localObject = "1";
          break;
          l = Long.parseLong(paramString1);
          break label343;
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public static void a(String paramString1, String paramString2, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    try
    {
      blhn localblhn = new blhn();
      localblhn.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localblhn.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localblhn.f = localUploadJobContext1.file().fileName;
        localblhn.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localblhn.g = paramStatusInfo.fileId;
        localblhn.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localblhn.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localblhn.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localblhn.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localblhn.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localblhn, paramBoolean, false);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report upload exception =" + paramString1.getMessage(), paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhm
 * JD-Core Version:    0.7.0.1
 */