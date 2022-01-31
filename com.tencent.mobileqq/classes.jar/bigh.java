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

public class bigh
{
  public static void a(String paramString1, String paramString2, bien parambien, boolean paramBoolean, long paramLong)
  {
    try
    {
      bigi localbigi = new bigi();
      localbigi.jdField_a_of_type_Int = parambien.jdField_b_of_type_Int;
      localbigi.jdField_a_of_type_JavaLangString = parambien.jdField_a_of_type_JavaLangString;
      biem localbiem2 = parambien.jdField_a_of_type_Biem;
      biem localbiem1 = localbiem2;
      if (localbiem2 == null) {
        localbiem1 = biep.a().a(paramLong);
      }
      if (localbiem1 != null)
      {
        localbigi.f = localbiem1.a().jdField_b_of_type_JavaLangString;
        localbigi.jdField_a_of_type_Long = localbiem1.a().jdField_a_of_type_Long;
        localbigi.g = localbiem1.a().jdField_a_of_type_JavaLangString;
        localbigi.e = localbiem1.a().c;
        localbigi.h = parambien.jdField_b_of_type_JavaLangString;
        parambien = localbiem1.a();
        if (parambien != null) {
          localbigi.d = parambien.jdField_a_of_type_JavaLangString;
        }
      }
      a(paramString1, paramString2, localbigi, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bigi parambigi, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambigi.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambigi.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambigi.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambigi.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambigi.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambigi.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambigi.c);
    localHashMap.put("param_serverPort", String.valueOf(parambigi.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambigi.d);
    localHashMap.put("param_MD5", parambigi.e);
    Object localObject;
    if (parambigi.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambigi.jdField_a_of_type_Long));
      axrn.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambigi.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambigi.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambigi.d);
        ((JSONObject)localObject).put("t_file_name", parambigi.f);
        ((JSONObject)localObject).put("t_file_id", parambigi.g);
        ((JSONObject)localObject).put("t_file_path", parambigi.h);
        ((JSONObject)localObject).put("t_file_size", parambigi.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambigi.e);
        ((JSONObject)localObject).put("t_err_code", parambigi.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", aney.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambigi.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bidx.a("http://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bigi localbigi = new bigi();
      localbigi.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbigi.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbigi.f = localUploadJobContext1.file().fileName;
        localbigi.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbigi.g = paramStatusInfo.fileId;
        localbigi.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbigi.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbigi.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbigi.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbigi.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbigi, paramBoolean, false);
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
 * Qualified Name:     bigh
 * JD-Core Version:    0.7.0.1
 */