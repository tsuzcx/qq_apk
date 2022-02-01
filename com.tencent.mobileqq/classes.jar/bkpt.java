import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class bkpt
  implements MiniAppCmdInterface
{
  bkpt(bkpq parambkpq, RequestEvent paramRequestEvent, BaseRuntime paramBaseRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject;
    if ("sendArkMsg receive isSuc= " + paramBoolean + " ret=" + paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    }
    for (;;)
    {
      QLog.d("MiniSDKClientQIPCModule", 1, (String)localObject);
      if (paramJSONObject == null)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
        bkpq.a(this.jdField_a_of_type_Bkpq, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event, "fail", 3, "request fail");
      }
      localObject = new JSONObject();
      if (paramBoolean) {
        try
        {
          int i = paramJSONObject.getInt("retCode");
          paramJSONObject = paramJSONObject.getString("errMsg");
          if (i == 0)
          {
            this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
            bkpq.a(this.jdField_a_of_type_Bkpq, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event, "success", 3, null);
            bkpq.a(this.jdField_a_of_type_Bkpq, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_success");
            if (this.jdField_a_of_type_JavaLangString.equals("shareMessageToFriend")) {
              bkpq.a(this.jdField_a_of_type_Bkpq, (JSONObject)localObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "", true, ApiUtil.wrapCallbackOk(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject));
            }
            return;
            localObject = null + "; event :" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event;
          }
          else
          {
            ((JSONObject)localObject).put("errMsg", paramJSONObject);
            ((JSONObject)localObject).put("errCode", i);
            this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail((JSONObject)localObject, paramJSONObject);
            bkpq.a(this.jdField_a_of_type_Bkpq, (JSONObject)localObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, paramJSONObject, false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject));
            bkpq.a(this.jdField_a_of_type_Bkpq, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event, "fail", 3, i + "," + paramJSONObject);
            return;
          }
        }
        catch (Throwable paramJSONObject)
        {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
          bkpq.a(this.jdField_a_of_type_Bkpq, (JSONObject)localObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "请求失败", false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject));
          bkpq.a(this.jdField_a_of_type_Bkpq, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event, "fail", 3, "request exception");
          return;
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
    bkpq.a(this.jdField_a_of_type_Bkpq, (JSONObject)localObject, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "请求失败", false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject));
    bkpq.a(this.jdField_a_of_type_Bkpq, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event, "fail", 3, "request fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpt
 * JD-Core Version:    0.7.0.1
 */