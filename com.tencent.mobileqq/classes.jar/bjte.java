import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class bjte
  implements EIPCResultCallback
{
  bjte(bjtd parambjtd, RequestEvent paramRequestEvent) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO onCallback");
    if (paramEIPCResult == null)
    {
      QLog.e("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO error, result is null");
      return;
    }
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("guid", "");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("guid", paramEIPCResult);
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(localJSONObject);
        return;
      }
      catch (JSONException paramEIPCResult)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(paramEIPCResult.getMessage());
        QLog.e("DeviceInfoPlugin", 1, new Object[] { "evaluateCallback error : ", paramEIPCResult.getMessage() });
        return;
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(String.valueOf(-102));
    QLog.e("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO failed, code return error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjte
 * JD-Core Version:    0.7.0.1
 */