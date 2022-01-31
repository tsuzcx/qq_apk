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

public class bkmk
{
  public static void a(String paramString1, String paramString2, bkkq parambkkq, boolean paramBoolean, long paramLong)
  {
    try
    {
      bkml localbkml = new bkml();
      localbkml.jdField_a_of_type_Int = parambkkq.jdField_b_of_type_Int;
      localbkml.jdField_a_of_type_JavaLangString = parambkkq.jdField_a_of_type_JavaLangString;
      bkkp localbkkp2 = parambkkq.jdField_a_of_type_Bkkp;
      bkkp localbkkp1 = localbkkp2;
      if (localbkkp2 == null) {
        localbkkp1 = bkks.a().a(paramLong);
      }
      if (localbkkp1 != null)
      {
        localbkml.f = localbkkp1.a().jdField_b_of_type_JavaLangString;
        localbkml.jdField_a_of_type_Long = localbkkp1.a().jdField_a_of_type_Long;
        localbkml.g = localbkkp1.a().jdField_a_of_type_JavaLangString;
        localbkml.e = localbkkp1.a().c;
        localbkml.h = parambkkq.jdField_b_of_type_JavaLangString;
        parambkkq = localbkkp1.a();
        if (parambkkq != null) {
          localbkml.d = parambkkq.jdField_a_of_type_JavaLangString;
        }
      }
      a(paramString1, paramString2, localbkml, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bkml parambkml, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambkml.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambkml.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambkml.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambkml.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambkml.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambkml.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambkml.c);
    localHashMap.put("param_serverPort", String.valueOf(parambkml.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambkml.d);
    localHashMap.put("param_MD5", parambkml.e);
    Object localObject;
    if (parambkml.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambkml.jdField_a_of_type_Long));
      azri.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambkml.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambkml.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambkml.d);
        ((JSONObject)localObject).put("t_file_name", parambkml.f);
        ((JSONObject)localObject).put("t_file_id", parambkml.g);
        ((JSONObject)localObject).put("t_file_path", parambkml.h);
        ((JSONObject)localObject).put("t_file_size", parambkml.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambkml.e);
        ((JSONObject)localObject).put("t_err_code", parambkml.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", apao.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambkml.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bkka.a("http://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bkml localbkml = new bkml();
      localbkml.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbkml.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbkml.f = localUploadJobContext1.file().fileName;
        localbkml.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbkml.g = paramStatusInfo.fileId;
        localbkml.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbkml.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbkml.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbkml.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbkml.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbkml, paramBoolean, false);
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
 * Qualified Name:     bkmk
 * JD-Core Version:    0.7.0.1
 */