import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class bkyo
  implements MiniAppCmdInterface
{
  bkyo(bkyl parambkyl, RequestEvent paramRequestEvent, BaseRuntime paramBaseRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniSDKClientQIPCModule", 1, "sendArkMsg receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean)
    {
      try
      {
        int i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        if (i == 0)
        {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
          bkyl.a(this.jdField_a_of_type_Bkyl, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_success");
          if (!this.jdField_a_of_type_JavaLangString.equals("shareMessageToFriend")) {
            return;
          }
          bkyl.a(this.jdField_a_of_type_Bkyl, localJSONObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "", true, ApiUtil.wrapCallbackOk(this.jdField_a_of_type_JavaLangString, localJSONObject));
          return;
        }
        localJSONObject.put("errMsg", paramJSONObject);
        localJSONObject.put("errCode", i);
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(localJSONObject, paramJSONObject);
        bkyl.a(this.jdField_a_of_type_Bkyl, localJSONObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, paramJSONObject, false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, localJSONObject));
        return;
      }
      catch (Throwable paramJSONObject)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
        bkyl.a(this.jdField_a_of_type_Bkyl, localJSONObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "请求失败", false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, localJSONObject));
        return;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
      bkyl.a(this.jdField_a_of_type_Bkyl, localJSONObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "请求失败", false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, localJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyo
 * JD-Core Version:    0.7.0.1
 */