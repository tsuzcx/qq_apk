import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

final class bgva
  implements AsyncResult
{
  bgva(MiniAppInfo paramMiniAppInfo, bgtg parambgtg) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("JsApiUpdateManager", "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if ((paramJSONObject != null) && (paramBoolean))
    {
      bguz.a((MiniAppInfo)paramJSONObject.opt("mini_app_info_data"));
      if (bguz.a() != null)
      {
        if (bgkl.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bguz.a()))
        {
          bguz.a(this.jdField_a_of_type_Bgtg, true);
          bguz.a(this.jdField_a_of_type_Bgtg, bguz.a());
          return;
        }
        bguz.a(this.jdField_a_of_type_Bgtg, false);
        return;
      }
      QMLog.e("JsApiUpdateManager", "onCmdListener newMiniAppInfo = null");
      return;
    }
    QMLog.e("JsApiUpdateManager", "onCmdListener success = " + paramBoolean + " ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgva
 * JD-Core Version:    0.7.0.1
 */