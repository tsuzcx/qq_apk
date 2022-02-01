import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class bkkp
  implements MiniAppCmdInterface
{
  bkkp(bkkn parambkkn, RequestEvent paramRequestEvent) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject = new JSONObject(paramJSONObject.optString("result_data"));
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramJSONObject);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
        return;
      }
    }
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = "")
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(paramJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkp
 * JD-Core Version:    0.7.0.1
 */