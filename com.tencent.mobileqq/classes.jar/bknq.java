import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class bknq
  implements EIPCResultCallback
{
  bknq(bknl parambknl, IMiniAppContext paramIMiniAppContext, String paramString, AsyncResult paramAsyncResult) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null) && (paramEIPCResult.data.getBoolean("hasCreateOrManageTroop")))
    {
      TroopApplicationListUtil.startTroopActivityAndAddTroopApplication(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult);
      return;
    }
    try
    {
      paramEIPCResult = new JSONObject();
      paramEIPCResult.put("errMsg", "not group manager");
      paramEIPCResult.put("errorCode", 41004);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(false, paramEIPCResult);
      TroopApplicationListUtil.showToast(41004);
      return;
    }
    catch (Exception paramEIPCResult)
    {
      QLog.e("ChannelProxyImpl", 1, "addGroupApp, exception: " + Log.getStackTraceString(paramEIPCResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknq
 * JD-Core Version:    0.7.0.1
 */