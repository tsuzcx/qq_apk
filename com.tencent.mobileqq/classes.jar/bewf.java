import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

final class bewf
  implements AsyncResult
{
  bewf(MiniAppInfo paramMiniAppInfo, beuv parambeuv) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.a("JsApiUpdateManager", "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if ((paramJSONObject != null) && (paramBoolean))
    {
      bewe.a((MiniAppInfo)paramJSONObject.opt("mini_app_info_data"));
      if (bewe.a() != null)
      {
        if (bela.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bewe.a()))
        {
          bewe.a(this.jdField_a_of_type_Beuv, true);
          bewe.a(this.jdField_a_of_type_Beuv, bewe.a());
          return;
        }
        bewe.a(this.jdField_a_of_type_Beuv, false);
        return;
      }
      betc.d("JsApiUpdateManager", "onCmdListener newMiniAppInfo = null");
      return;
    }
    betc.d("JsApiUpdateManager", "onCmdListener success = " + paramBoolean + " ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewf
 * JD-Core Version:    0.7.0.1
 */