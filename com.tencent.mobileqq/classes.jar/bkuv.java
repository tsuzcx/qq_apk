import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bkuv
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
      QMLog.e("TimTeamPlugin", "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  @JsEvent({"tim_space"})
  public void timSpace(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = new JSONObject(a(paramRequestEvent).getString("data")).getString("action");
      if (QMLog.isColorLevel()) {
        QMLog.d("TimTeamPlugin", "onInvoke|" + paramRequestEvent);
      }
      if (TextUtils.equals(paramRequestEvent, "showCoopSpaceProfile"))
      {
        paramRequestEvent = this.mMiniAppContext.getAttachedActivity();
        Intent localIntent = new Intent(paramRequestEvent, AccountDetailActivity.class);
        localIntent.putExtra("uin", antf.aV);
        paramRequestEvent.startActivity(localIntent);
      }
      return;
    }
    catch (Exception paramRequestEvent)
    {
      while (!QMLog.isColorLevel()) {}
      QMLog.w("TimTeamPlugin", "decode param error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuv
 * JD-Core Version:    0.7.0.1
 */