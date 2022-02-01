import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bklg
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("SetAvatarNativePlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  @JsEvent({"uploadAvatar"})
  public void uploadAvatar(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = a(paramRequestEvent);
      QLog.i("SetAvatarNativePlugin", 1, "onInvoke, param=" + localObject);
      localObject = ((JSONObject)localObject).optJSONObject("data");
      if (localObject == null)
      {
        paramRequestEvent.fail(new JSONObject("empty data"), "empty data");
        return;
      }
      localObject = ((JSONObject)localObject).optString("path", null);
      localObject = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath((String)localObject);
      QLog.d("SetAvatarNativePlugin", 1, (String)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putString("param_avatar_path", (String)localObject);
      QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "set_avatar", localBundle, new bklh(this, paramRequestEvent));
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("SetAvatarNativePlugin", 1, "setAvatar err", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklg
 * JD-Core Version:    0.7.0.1
 */