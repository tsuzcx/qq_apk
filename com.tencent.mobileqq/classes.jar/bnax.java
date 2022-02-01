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

public class bnax
{
  public static void a(String paramString1, String paramString2, bmzd parambmzd, boolean paramBoolean, long paramLong)
  {
    try
    {
      bnay localbnay = new bnay();
      localbnay.jdField_a_of_type_Int = parambmzd.jdField_b_of_type_Int;
      localbnay.jdField_a_of_type_JavaLangString = parambmzd.jdField_a_of_type_JavaLangString;
      bmzc localbmzc2 = parambmzd.jdField_a_of_type_Bmzc;
      bmzc localbmzc1 = localbmzc2;
      if (localbmzc2 == null) {
        localbmzc1 = bmzf.a().a(paramLong);
      }
      if (localbmzc1 != null)
      {
        localbnay.f = localbmzc1.a().jdField_b_of_type_JavaLangString;
        localbnay.jdField_a_of_type_Long = localbmzc1.a().jdField_a_of_type_Long;
        localbnay.g = localbmzc1.a().jdField_a_of_type_JavaLangString;
        localbnay.e = localbmzc1.a().c;
        localbnay.h = parambmzd.jdField_b_of_type_JavaLangString;
        parambmzd = localbmzc1.a();
        if (parambmzd != null) {
          localbnay.d = parambmzd.jdField_a_of_type_JavaLangString;
        }
      }
      a(paramString1, paramString2, localbnay, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bnay parambnay, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambnay.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambnay.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambnay.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambnay.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambnay.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambnay.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambnay.c);
    localHashMap.put("param_serverPort", String.valueOf(parambnay.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambnay.d);
    localHashMap.put("param_MD5", parambnay.e);
    Object localObject;
    if (parambnay.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambnay.jdField_a_of_type_Long));
      bctj.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambnay.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambnay.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambnay.d);
        ((JSONObject)localObject).put("t_file_name", parambnay.f);
        ((JSONObject)localObject).put("t_file_id", parambnay.g);
        ((JSONObject)localObject).put("t_file_path", parambnay.h);
        ((JSONObject)localObject).put("t_file_size", parambnay.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambnay.e);
        ((JSONObject)localObject).put("t_err_code", parambnay.jdField_a_of_type_Int);
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
            break label465;
          }
        }
        label465:
        for (int i = 1;; i = 2)
        {
          ((JSONObject)localObject).put("t_action", i);
          ((JSONObject)localObject).put("t_app_ver", ardl.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambnay.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bmyn.a("https://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bnay localbnay = new bnay();
      localbnay.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbnay.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbnay.f = localUploadJobContext1.file().fileName;
        localbnay.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbnay.g = paramStatusInfo.fileId;
        localbnay.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbnay.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbnay.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbnay.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbnay.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbnay, paramBoolean, false);
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
 * Qualified Name:     bnax
 * JD-Core Version:    0.7.0.1
 */