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

public class bocf
{
  public static void a(String paramString1, String paramString2, boal paramboal, boolean paramBoolean, long paramLong)
  {
    try
    {
      bocg localbocg = new bocg();
      localbocg.jdField_a_of_type_Int = paramboal.jdField_b_of_type_Int;
      localbocg.jdField_a_of_type_JavaLangString = paramboal.jdField_a_of_type_JavaLangString;
      boak localboak2 = paramboal.jdField_a_of_type_Boak;
      boak localboak1 = localboak2;
      if (localboak2 == null) {
        localboak1 = boan.a().a(paramLong);
      }
      if (localboak1 != null)
      {
        localbocg.f = localboak1.a().jdField_b_of_type_JavaLangString;
        localbocg.jdField_a_of_type_Long = localboak1.a().jdField_a_of_type_Long;
        localbocg.g = localboak1.a().jdField_a_of_type_JavaLangString;
        localbocg.e = localboak1.a().c;
        localbocg.h = paramboal.jdField_b_of_type_JavaLangString;
        paramboal = localboak1.a();
        if (paramboal != null) {
          localbocg.d = paramboal.jdField_a_of_type_JavaLangString;
        }
      }
      a(paramString1, paramString2, localbocg, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bocg parambocg, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambocg.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambocg.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambocg.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambocg.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambocg.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambocg.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambocg.c);
    localHashMap.put("param_serverPort", String.valueOf(parambocg.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambocg.d);
    localHashMap.put("param_MD5", parambocg.e);
    Object localObject;
    if (parambocg.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambocg.jdField_a_of_type_Long));
      bdmc.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambocg.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambocg.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambocg.d);
        ((JSONObject)localObject).put("t_file_name", parambocg.f);
        ((JSONObject)localObject).put("t_file_id", parambocg.g);
        ((JSONObject)localObject).put("t_file_path", parambocg.h);
        ((JSONObject)localObject).put("t_file_size", parambocg.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambocg.e);
        ((JSONObject)localObject).put("t_err_code", parambocg.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", arta.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambocg.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bnzv.a("https://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bocg localbocg = new bocg();
      localbocg.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbocg.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbocg.f = localUploadJobContext1.file().fileName;
        localbocg.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbocg.g = paramStatusInfo.fileId;
        localbocg.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbocg.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbocg.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbocg.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbocg.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbocg, paramBoolean, false);
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
 * Qualified Name:     bocf
 * JD-Core Version:    0.7.0.1
 */