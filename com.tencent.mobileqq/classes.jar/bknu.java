import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x87c.RspBody;

class bknu
  extends MiniAppSendSmsCodeObserver
{
  bknu(bknl parambknl, AsyncResult paramAsyncResult) {}
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    super.onFailedResponse(paramString1, paramInt, paramString2);
    QLog.e("ChannelProxyImpl", 1, "verify onFailedResponse cmd : " + paramString1 + ", code : " + paramInt + "; message : " + paramString2);
    try
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("message", paramString2);
        localJSONObject.put("code", paramInt);
        localJSONObject.put("cmd", paramString1);
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(false, localJSONObject);
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ChannelProxyImpl", 1, "onFailedResponse error,", paramString1);
    }
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
  {
    super.verifySmsCodeSuccess(paramRspBody);
    QLog.d("ChannelProxyImpl", 1, "verify success");
    try
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult != null)
      {
        paramRspBody = new JSONObject();
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(true, paramRspBody);
      }
      return;
    }
    catch (Throwable paramRspBody)
    {
      QLog.e("ChannelProxyImpl", 1, "onFailedResponse error,", paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknu
 * JD-Core Version:    0.7.0.1
 */