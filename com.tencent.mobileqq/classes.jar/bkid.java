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

public class bkid
{
  public static void a(String paramString1, String paramString2, bkgj parambkgj, boolean paramBoolean, long paramLong)
  {
    try
    {
      bkie localbkie = new bkie();
      localbkie.jdField_a_of_type_Int = parambkgj.jdField_b_of_type_Int;
      localbkie.jdField_a_of_type_JavaLangString = parambkgj.jdField_a_of_type_JavaLangString;
      bkgi localbkgi2 = parambkgj.jdField_a_of_type_Bkgi;
      bkgi localbkgi1 = localbkgi2;
      if (localbkgi2 == null) {
        localbkgi1 = bkgl.a().a(paramLong);
      }
      if (localbkgi1 != null)
      {
        localbkie.f = localbkgi1.a().jdField_b_of_type_JavaLangString;
        localbkie.jdField_a_of_type_Long = localbkgi1.a().jdField_a_of_type_Long;
        localbkie.g = localbkgi1.a().jdField_a_of_type_JavaLangString;
        localbkie.e = localbkgi1.a().c;
        localbkie.h = parambkgj.jdField_b_of_type_JavaLangString;
        parambkgj = localbkgi1.a();
        if (parambkgj != null) {
          localbkie.d = parambkgj.jdField_a_of_type_JavaLangString;
        }
      }
      a(paramString1, paramString2, localbkie, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bkie parambkie, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambkie.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambkie.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambkie.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambkie.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambkie.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambkie.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambkie.c);
    localHashMap.put("param_serverPort", String.valueOf(parambkie.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambkie.d);
    localHashMap.put("param_MD5", parambkie.e);
    Object localObject;
    if (parambkie.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambkie.jdField_a_of_type_Long));
      azmz.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambkie.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambkie.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambkie.d);
        ((JSONObject)localObject).put("t_file_name", parambkie.f);
        ((JSONObject)localObject).put("t_file_id", parambkie.g);
        ((JSONObject)localObject).put("t_file_path", parambkie.h);
        ((JSONObject)localObject).put("t_file_size", parambkie.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambkie.e);
        ((JSONObject)localObject).put("t_err_code", parambkie.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", aowf.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambkie.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bkft.a("http://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bkie localbkie = new bkie();
      localbkie.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbkie.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbkie.f = localUploadJobContext1.file().fileName;
        localbkie.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbkie.g = paramStatusInfo.fileId;
        localbkie.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbkie.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbkie.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbkie.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbkie.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbkie, paramBoolean, false);
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
 * Qualified Name:     bkid
 * JD-Core Version:    0.7.0.1
 */