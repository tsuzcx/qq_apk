import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bklj
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
      QLog.e("TenDocChannelPlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        boolean bool = localJSONObject.optBoolean("success");
        String str = localJSONObject.optString("url");
        paramString = localJSONObject.optString("fileName");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isSuccess", bool);
        localBundle.putString("url", str);
        localBundle.putString("fileName", paramString);
        if ((!(paramActivity instanceof TeamWorkDocEditBrowserActivity)) || (((TeamWorkDocEditBrowserActivity)paramActivity).getHostWebView() == null)) {
          break label203;
        }
        paramActivity = ((TeamWorkDocEditBrowserActivity)paramActivity).getHostWebView().getUrl();
        paramString = paramActivity;
        if (TextUtils.isEmpty(paramActivity)) {
          paramString = localJSONObject.optString("refer_url");
        }
        localBundle.putString("docUrl", paramString);
        localBundle.putString("cookie", CookieManager.getInstance().getCookie(str));
        localBundle.putBoolean("isMiniProgram", true);
        QIPCClientHelper.getInstance().getClient().callServer("TeamWorkModule", "action_download_export_file", localBundle);
      }
      catch (Exception paramActivity)
      {
        QLog.e("TenDocChannelPlugin", 1, "downloadExportedFile exception e = " + paramActivity.toString());
        continue;
      }
      finally {}
      return;
      label203:
      paramActivity = null;
    }
  }
  
  private void b(Activity paramActivity, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("fileName");
      new Bundle().putString("fileName", paramString);
      bebf.a(paramActivity, paramString, true);
      beeg.a(null, "0X800A4B2");
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        QLog.e("TenDocChannelPlugin", 1, "startExportedFile exception e = " + paramActivity.toString());
      }
    }
    finally {}
  }
  
  private void c(Activity paramActivity, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("folderId");
      Intent localIntent = new Intent(paramActivity, FMActivity.class);
      localIntent.putExtra(beay.f, true);
      localIntent.addFlags(536870912);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("busiType", 9);
      localIntent.putExtra("peerType", 10006);
      localIntent.putExtra("enterfrom", 9);
      localIntent.putExtra("tab_tab_type", 7);
      localIntent.putExtra("only_show_local_tab", true);
      localIntent.putExtra(beay.g, paramString);
      localIntent.putExtra("smart_device_support_flag", 8);
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        QLog.e("TenDocChannelPlugin", 1, "openFMActivityToImport exception", paramActivity);
      }
    }
    finally {}
  }
  
  @JsEvent({"tdoc_channel"})
  public void tdocChannel(RequestEvent paramRequestEvent)
  {
    Object localObject;
    Activity localActivity;
    try
    {
      paramRequestEvent = a(paramRequestEvent);
      if (paramRequestEvent == null) {
        return;
      }
      localObject = new JSONObject(paramRequestEvent.optString("data"));
      paramRequestEvent = ((JSONObject)localObject).getString("action");
      localObject = ((JSONObject)localObject).getString("data");
      localActivity = this.mMiniAppContext.getAttachedActivity();
      if (TextUtils.equals(paramRequestEvent, "openLocalFilesToImport"))
      {
        c(localActivity, (String)localObject);
        return;
      }
      if (TextUtils.equals(paramRequestEvent, "txDocsStartExport"))
      {
        b(localActivity, (String)localObject);
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QLog.e("TenDocChannelPlugin", 1, "parse param failed", paramRequestEvent);
      return;
    }
    if (TextUtils.equals(paramRequestEvent, "openExportedFile")) {
      a(localActivity, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklj
 * JD-Core Version:    0.7.0.1
 */