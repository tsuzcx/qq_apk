import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

final class bgzh
  implements AsyncResult
{
  bgzh(MiniAppInfo paramMiniAppInfo, bgxn parambgxn) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("JsApiUpdateManager", "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if ((paramJSONObject != null) && (paramBoolean))
    {
      bgzg.a((MiniAppInfo)paramJSONObject.opt("mini_app_info_data"));
      if (bgzg.a() != null)
      {
        if (bgos.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bgzg.a()))
        {
          bgzg.a(this.jdField_a_of_type_Bgxn, true);
          bgzg.a(this.jdField_a_of_type_Bgxn, bgzg.a());
          return;
        }
        bgzg.a(this.jdField_a_of_type_Bgxn, false);
        return;
      }
      QMLog.e("JsApiUpdateManager", "onCmdListener newMiniAppInfo = null");
      return;
    }
    QMLog.e("JsApiUpdateManager", "onCmdListener success = " + paramBoolean + " ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzh
 * JD-Core Version:    0.7.0.1
 */