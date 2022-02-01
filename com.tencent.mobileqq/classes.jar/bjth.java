import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class bjth
  implements EIPCResultCallback
{
  bjth(bjtf parambjtf, RequestEvent paramRequestEvent, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      localJSONObject = new JSONObject();
      if (paramEIPCResult == null)
      {
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail("result is null");
        return;
      }
      if (paramEIPCResult.code != 0) {
        break label143;
      }
      j = paramEIPCResult.data.getInt("uin_type");
      i = -1;
      if (j != 10009) {
        break label134;
      }
      i = 1;
    }
    catch (Throwable paramEIPCResult)
    {
      JSONObject localJSONObject;
      int j;
      int i;
      while (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent != null)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail("exceptions!");
        return;
        label134:
        if (j == 0) {
          i = 2;
        }
      }
      label143:
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail("result code:" + paramEIPCResult.code);
    }
    localJSONObject.put("code", 0);
    localJSONObject.put("type", i);
    ausx.a(bjtf.a(this.jdField_a_of_type_Bjtf).getAttachedActivity(), this.jdField_a_of_type_JavaLangString, j);
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(localJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjth
 * JD-Core Version:    0.7.0.1
 */