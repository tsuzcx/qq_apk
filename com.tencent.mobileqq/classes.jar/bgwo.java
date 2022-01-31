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

public class bgwo
{
  public static void a(String paramString1, String paramString2, bguu parambguu, boolean paramBoolean, long paramLong)
  {
    try
    {
      bgwp localbgwp = new bgwp();
      localbgwp.jdField_a_of_type_Int = parambguu.jdField_b_of_type_Int;
      localbgwp.jdField_a_of_type_JavaLangString = parambguu.jdField_a_of_type_JavaLangString;
      bgut localbgut2 = parambguu.jdField_a_of_type_Bgut;
      bgut localbgut1 = localbgut2;
      if (localbgut2 == null) {
        localbgut1 = bguw.a().a(paramLong);
      }
      if (localbgut1 != null)
      {
        localbgwp.f = localbgut1.a().jdField_b_of_type_JavaLangString;
        localbgwp.jdField_a_of_type_Long = localbgut1.a().jdField_a_of_type_Long;
        localbgwp.g = localbgut1.a().jdField_a_of_type_JavaLangString;
        localbgwp.e = localbgut1.a().c;
        localbgwp.h = parambguu.jdField_b_of_type_JavaLangString;
        parambguu = localbgut1.a();
        if (parambguu != null) {
          localbgwp.d = parambguu.jdField_a_of_type_JavaLangString;
        }
      }
      a(paramString1, paramString2, localbgwp, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bgwp parambgwp, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambgwp.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambgwp.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambgwp.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambgwp.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambgwp.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambgwp.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambgwp.c);
    localHashMap.put("param_serverPort", String.valueOf(parambgwp.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambgwp.d);
    localHashMap.put("param_MD5", parambgwp.e);
    Object localObject;
    if (parambgwp.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambgwp.jdField_a_of_type_Long));
      awrn.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambgwp.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambgwp.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambgwp.d);
        ((JSONObject)localObject).put("t_file_name", parambgwp.f);
        ((JSONObject)localObject).put("t_file_id", parambgwp.g);
        ((JSONObject)localObject).put("t_file_path", parambgwp.h);
        ((JSONObject)localObject).put("t_file_size", parambgwp.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambgwp.e);
        ((JSONObject)localObject).put("t_err_code", parambgwp.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", amom.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambgwp.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bgue.a("http://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bgwp localbgwp = new bgwp();
      localbgwp.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbgwp.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbgwp.f = localUploadJobContext1.file().fileName;
        localbgwp.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbgwp.g = paramStatusInfo.fileId;
        localbgwp.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbgwp.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbgwp.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbgwp.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbgwp.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbgwp, paramBoolean, false);
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
 * Qualified Name:     bgwo
 * JD-Core Version:    0.7.0.1
 */