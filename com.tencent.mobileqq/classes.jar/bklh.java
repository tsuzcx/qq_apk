import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class bklh
  implements EIPCResultCallback
{
  private RequestEvent jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
  
  bklh(bklg parambklg, RequestEvent paramRequestEvent)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SetAvatarNativePlugin", 2, "onCallback, result=" + paramEIPCResult);
    }
    if (paramEIPCResult == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SetAvatarNativePlugin", 2, "onCallback, result.isSuccess=" + paramEIPCResult.isSuccess());
        }
        paramEIPCResult = paramEIPCResult.data;
        if (paramEIPCResult != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SetAvatarNativePlugin", 2, "onCallback, data is null");
      return;
      localObject = paramEIPCResult.getString("param_action");
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, action=" + (String)localObject);
      }
    } while (!"set_avatar".equals(localObject));
    int i = paramEIPCResult.getInt("param_result_code", -1);
    paramEIPCResult = paramEIPCResult.getString("param_result_desc", "null");
    if (QLog.isColorLevel()) {
      QLog.d("SetAvatarNativePlugin", 2, "onCallback, errCode=" + i + ", errDesc=" + paramEIPCResult);
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("param_result_code", i);
      ((JSONObject)localObject).put("param_result_desc", paramEIPCResult);
      label222:
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok((JSONObject)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail((JSONObject)localObject, paramEIPCResult);
      return;
    }
    catch (Exception localException)
    {
      break label222;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklh
 * JD-Core Version:    0.7.0.1
 */