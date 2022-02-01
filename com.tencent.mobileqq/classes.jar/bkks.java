import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bkks
  extends BaseJsPlugin
{
  @JsEvent({"checkGameBuddyType"})
  public void checkGameBuddyType(RequestEvent paramRequestEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBuddyPlugin", 2, new Object[] { "[checkGameBuddyType 2.0], req:", paramRequestEvent });
    }
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      if ("checkGameBuddyType".equals(((JSONObject)localObject).optString("api_name")))
      {
        localObject = ((JSONObject)localObject).optJSONObject("data").optString("uid");
        Bundle localBundle = new Bundle();
        localBundle.putString("uin_value", (String)localObject);
        QIPCClientHelper.getInstance().callServer("module_game_buddy", "action_check_aio_type", localBundle, new bkkt(this, paramRequestEvent));
      }
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("GameBuddyPlugin", 1, paramRequestEvent, new Object[0]);
    }
  }
  
  @JsEvent({"invokeGameBuddyAio"})
  public void invokeGameBuddyAio(RequestEvent paramRequestEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameBuddyPlugin", 2, new Object[] { "[invokeGameBuddyAio 2.0], req:", paramRequestEvent });
    }
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      if ("invokeGameBuddyAio".equals(((JSONObject)localObject).optString("api_name")))
      {
        localObject = ((JSONObject)localObject).optJSONObject("data").optString("uid");
        Bundle localBundle = new Bundle();
        localBundle.putString("uin_value", (String)localObject);
        QIPCClientHelper.getInstance().callServer("module_game_buddy", "action_check_aio_type", localBundle, new bkku(this, paramRequestEvent, (String)localObject));
      }
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("GameBuddyPlugin", 1, paramRequestEvent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkks
 * JD-Core Version:    0.7.0.1
 */