import android.os.Bundle;
import android.util.Base64;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class avvc
  implements BusinessObserver
{
  public void a() {}
  
  public void a(FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse) {}
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(oidb_0x5e1.RspBody paramRspBody) {}
  
  public void a(oidb_0x87a.RspBody paramRspBody) {}
  
  public void a(oidb_0x87c.RspBody paramRspBody) {}
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("cmd");
    Object localObject;
    if (!paramBoolean)
    {
      localObject = paramBundle.getString("dataErrorMsg", "");
      paramInt = paramBundle.getInt("dataErrorCode");
      QLog.e("LoginVerifyObserver", 1, "LoginVerifyObserver onReceive error, code is : " + paramInt + ", error msg is : " + (String)localObject + " cmd is : " + str);
      a(str, paramInt, (String)localObject);
    }
    do
    {
      return;
      QLog.d("LoginVerifyObserver", 1, "LoginVerifyObserver success, cmd is : " + str);
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null)
      {
        QLog.e("LoginVerifyObserver", 1, "LoginVerifyObserver onReceive success but data is null");
        a(str, -1, "data is null");
        return;
      }
      if ("getTmpkey".equals(str))
      {
        try
        {
          paramBundle = new JSONObject(new String(paramBundle));
          paramInt = paramBundle.optInt("ret", -1);
          if (paramInt == 0)
          {
            a(paramBundle.optString("openid"), paramBundle.optString("tmpkey"));
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          QLog.e("LoginVerifyObserver", 1, "getTmpKey error : JSONException " + paramBundle.getMessage());
          a(str, -1, paramBundle.getMessage());
          return;
        }
        paramBundle = paramBundle.optString("errmsg");
        a(str, paramInt, paramBundle);
        QLog.e("LoginVerifyObserver", 1, "getTmpError, ret : " + paramInt + "  error : " + paramBundle);
        return;
      }
      if ("getAppConfig".equals(str))
      {
        try
        {
          paramBundle = new JSONObject(new String(paramBundle));
          paramInt = paramBundle.optInt("ret", -1);
          if (paramInt == 0)
          {
            a(Base64.decode(paramBundle.optString("appconf_rsp"), 11));
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          QLog.e("LoginVerifyObserver", 1, "getAppconf error : JSONException " + paramBundle.getMessage());
          a(str, -1, paramBundle.getMessage());
          return;
        }
        paramBundle = paramBundle.optString("errmsg");
        a(str, paramInt, paramBundle);
        QLog.e("LoginVerifyObserver", 1, "getAppconf, ret : " + paramInt + "  error : " + paramBundle);
        return;
      }
      if ("FaceRecognition.SecureCheck".equals(str))
      {
        localObject = new FaceSecureCheck.SecureCheckResponse();
        try
        {
          ((FaceSecureCheck.SecureCheckResponse)localObject).mergeFrom(paramBundle);
          paramInt = ((FaceSecureCheck.SecureCheckResponse)localObject).uint32_errcode.get();
          if (paramInt != 0)
          {
            paramBundle = ((FaceSecureCheck.SecureCheckResponse)localObject).str_err_msg.get();
            a(str, paramInt, paramBundle);
            QLog.e("LoginVerifyObserver", 1, "sso result error, ret : " + paramInt + "  error : " + paramBundle);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          QLog.e("LoginVerifyObserver", 1, new Object[] { "SecureCheckResponse merge from data error : ", paramBundle.getMessage() });
          return;
        }
        a((FaceSecureCheck.SecureCheckResponse)localObject);
        return;
      }
      try
      {
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramBundle);
        paramInt = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (paramInt != 0)
        {
          paramBundle = ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get();
          a(str, paramInt, paramBundle);
          QLog.e("LoginVerifyObserver", 1, "sso result error, ret : " + paramInt + "  error : " + paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        a(str, -1, paramBundle.getMessage());
        return;
      }
      paramBundle = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
      if ("OidbSvc.0x5e1_295".equals(str))
      {
        localObject = new oidb_0x5e1.RspBody();
        ((oidb_0x5e1.RspBody)localObject).mergeFrom(paramBundle);
        a((oidb_0x5e1.RspBody)localObject);
        return;
      }
      if ("OidbSvc.0x87c_108".equals(str))
      {
        localObject = new oidb_0x87c.RspBody();
        ((oidb_0x87c.RspBody)localObject).mergeFrom(paramBundle);
        a((oidb_0x87c.RspBody)localObject);
        return;
      }
      if ("OidbSvc.0x87a_108".equals(str))
      {
        localObject = new oidb_0x87a.RspBody();
        ((oidb_0x87a.RspBody)localObject).mergeFrom(paramBundle);
        a((oidb_0x87a.RspBody)localObject);
        return;
      }
    } while (!"OidbSvc.0x587_63".equals(str));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvc
 * JD-Core Version:    0.7.0.1
 */