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

public class bmud
{
  public static void a(String paramString1, String paramString2, bmsj parambmsj, boolean paramBoolean, long paramLong)
  {
    try
    {
      bmue localbmue = new bmue();
      localbmue.jdField_a_of_type_Int = parambmsj.jdField_b_of_type_Int;
      localbmue.jdField_a_of_type_JavaLangString = parambmsj.jdField_a_of_type_JavaLangString;
      bmsi localbmsi2 = parambmsj.jdField_a_of_type_Bmsi;
      bmsi localbmsi1 = localbmsi2;
      if (localbmsi2 == null) {
        localbmsi1 = bmsl.a().a(paramLong);
      }
      if (localbmsi1 != null)
      {
        localbmue.f = localbmsi1.a().jdField_b_of_type_JavaLangString;
        localbmue.jdField_a_of_type_Long = localbmsi1.a().jdField_a_of_type_Long;
        localbmue.g = localbmsi1.a().jdField_a_of_type_JavaLangString;
        localbmue.e = localbmsi1.a().c;
        localbmue.h = parambmsj.jdField_b_of_type_JavaLangString;
        parambmsj = localbmsi1.a();
        if (parambmsj != null) {
          localbmue.d = parambmsj.mReqUrl;
        }
      }
      a(paramString1, paramString2, localbmue, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, bmue parambmue, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parambmue.jdField_a_of_type_Int));
    localHashMap.put("serverip", parambmue.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_errMsg", parambmue.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_errorDesc", String.valueOf(parambmue.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Server", parambmue.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_ftnIP", parambmue.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_innerServerIp", parambmue.c);
    localHashMap.put("param_serverPort", String.valueOf(parambmue.jdField_b_of_type_Int));
    localHashMap.put("param_url", parambmue.d);
    localHashMap.put("param_MD5", parambmue.e);
    Object localObject;
    if (parambmue.jdField_a_of_type_Boolean) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parambmue.jdField_a_of_type_Long));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parambmue.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("t_server_port", parambmue.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("t_url", parambmue.d);
        ((JSONObject)localObject).put("t_file_name", parambmue.f);
        ((JSONObject)localObject).put("t_file_id", parambmue.g);
        ((JSONObject)localObject).put("t_file_path", parambmue.h);
        ((JSONObject)localObject).put("t_file_size", parambmue.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("t_file_sha", parambmue.e);
        ((JSONObject)localObject).put("t_err_code", parambmue.jdField_a_of_type_Int);
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
          ((JSONObject)localObject).put("t_app_ver", arqj.a(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parambmue.jdField_a_of_type_JavaLangString);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          bmrt.a("https://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
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
      bmue localbmue = new bmue();
      localbmue.jdField_a_of_type_Int = paramStatusInfo.errorCode;
      localbmue.jdField_a_of_type_JavaLangString = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        localbmue.f = localUploadJobContext1.file().fileName;
        localbmue.jdField_a_of_type_Long = localUploadJobContext1.file().fileSize;
        localbmue.g = paramStatusInfo.fileId;
        localbmue.e = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          localbmue.jdField_b_of_type_JavaLangString = paramStatusInfo.serverIp();
          localbmue.jdField_b_of_type_Int = paramStatusInfo.serverPort();
          localbmue.d = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      localbmue.jdField_a_of_type_Boolean = bool;
      a(paramString1, paramString2, localbmue, paramBoolean, false);
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
 * Qualified Name:     bmud
 * JD-Core Version:    0.7.0.1
 */