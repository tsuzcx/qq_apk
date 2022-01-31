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

public class bifq
{
  public static void a(String paramString1, String paramString2, bidw parambidw, boolean paramBoolean, long paramLong)
  {
    try
    {
      bifr localbifr = new bifr();
      localbifr.jdField_a_of_type_Int = parambidw.jdField_b_of_type_Int;
      localbifr.jdField_a_of_type_JavaLangString = parambidw.jdField_a_of_type_JavaLangString;
      bidv localbidv2 = parambidw.jdField_a_of_type_Bidv;
      bidv localbidv1 = localbidv2;
      if (localbidv2 == null) {
        localbidv1 = bidy.a().a(paramLong);
      }
      if (localbidv1 != null)
      {
        localbifr.f = localbidv1.a().jdField_b_of_type_JavaLangString;
        localbifr.jdField_a_of_type_Long = localbidv1.a().jdField_a_of_type_Long;
        localbifr.g = localbidv1.a().jdField_a_of_type_JavaLangString;
        localbifr.e = localbidv1.a().c;
        localbifr.h = parambidw.jdField_b_of_type_JavaLangString;
        parambidw = localbidv1.a();
        if (parambidw != null) {
          localbifr.d = parambidw.jdField_a_of_type_JavaLangString;
        }
      }
      a(paramString1, paramString2, localbifr, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bifr parambifr, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambifr.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambifr.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambifr.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambifr.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambifr.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambifr.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambifr.c);
    localHashMap.put("param_serverPort", String.valueOf(parambifr.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambifr.d);
    localHashMap.put("param_MD5", parambifr.e);
    Object localObject;
    if (parambifr.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambifr.jdField_a_of_type_Long));
      axrl.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambifr.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambifr.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambifr.d);
        ((JSONObject)localObject).put("t_file_name", parambifr.f);
        ((JSONObject)localObject).put("t_file_id", parambifr.g);
        ((JSONObject)localObject).put("t_file_path", parambifr.h);
        ((JSONObject)localObject).put("t_file_size", parambifr.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambifr.e);
        ((JSONObject)localObject).put("t_err_code", parambifr.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", anet.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambifr.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bidg.a("http://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bifr localbifr = new bifr();
      localbifr.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbifr.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbifr.f = localUploadJobContext1.file().fileName;
        localbifr.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbifr.g = paramStatusInfo.fileId;
        localbifr.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbifr.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbifr.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbifr.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbifr.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbifr, paramBoolean, false);
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
 * Qualified Name:     bifq
 * JD-Core Version:    0.7.0.1
 */