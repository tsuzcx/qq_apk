import com.tencent.qqmini.proxyimpl.AIOEntryPlugin.1;
import com.tencent.qqmini.proxyimpl.AIOEntryPlugin.2;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class bkma
  extends BaseJsPlugin
{
  @JsEvent({"hideMiniAIOEntrance"})
  public void hideMiniAIOEntrance(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new AIOEntryPlugin.2(this, paramRequestEvent));
  }
  
  @JsEvent({"showMiniAIOEntrance"})
  public void showMiniAIOEntrance(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new AIOEntryPlugin.1(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkma
 * JD-Core Version:    0.7.0.1
 */