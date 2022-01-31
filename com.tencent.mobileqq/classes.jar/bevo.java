import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

final class bevo
  implements AsyncResult
{
  bevo(MiniAppInfo paramMiniAppInfo, beue parambeue) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    besl.a("JsApiUpdateManager", "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if ((paramJSONObject != null) && (paramBoolean))
    {
      bevn.a((MiniAppInfo)paramJSONObject.opt("mini_app_info_data"));
      if (bevn.a() != null)
      {
        if (bekj.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bevn.a()))
        {
          bevn.a(this.jdField_a_of_type_Beue, true);
          bevn.a(this.jdField_a_of_type_Beue, bevn.a());
          return;
        }
        bevn.a(this.jdField_a_of_type_Beue, false);
        return;
      }
      besl.d("JsApiUpdateManager", "onCmdListener newMiniAppInfo = null");
      return;
    }
    besl.d("JsApiUpdateManager", "onCmdListener success = " + paramBoolean + " ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevo
 * JD-Core Version:    0.7.0.1
 */