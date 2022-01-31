import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzonePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bjzk
  extends WebViewPlugin
{
  public static String a = "QZFamousUserHome";
  public static String b = "usermoodlist";
  public static String c = "useralbum";
  public static String d = "userhome";
  public static String e = "openRedPocket";
  public static String f = "famous";
  public static String g = "key_uin";
  public static String h = "key_nickname";
  
  public bjzk()
  {
    this.mPluginNameSpace = a;
  }
  
  private void a(String... paramVarArgs)
  {
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      String str;
      Activity localActivity;
      try
      {
        localObject = new JSONObject(paramVarArgs[0]);
        long l = ((JSONObject)localObject).getLong("uin");
        if (!((JSONObject)localObject).has("actiontype")) {
          break label362;
        }
        i = ((JSONObject)localObject).getInt("actiontype");
        if (!((JSONObject)localObject).has("actionurl")) {
          break label367;
        }
        paramVarArgs = ((JSONObject)localObject).optString("actionurl");
        if (!((JSONObject)localObject).has("cover_type")) {
          break label373;
        }
        j = ((JSONObject)localObject).getInt("cover_type");
        if (!((JSONObject)localObject).has("action_url")) {
          break label378;
        }
        str = ((JSONObject)localObject).optString("action_url");
        if (!((JSONObject)localObject).has("autoShowTimeLine")) {
          break label385;
        }
        localObject = ((JSONObject)localObject).optString("autoShowTimeLine");
        boolean bool = "1".equals(localObject);
        localObject = new Intent();
        localActivity = this.mRuntime.a();
        if ((35 == i) && (paramVarArgs != null) && (paramVarArgs.length() > 0))
        {
          if ((localActivity != null) && ((localActivity instanceof bjzl)) && (((bjzl)localActivity).a())) {
            return;
          }
          str = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
          ((Intent)localObject).putExtra("famous_space_webview_url", paramVarArgs);
          paramVarArgs = str;
          QzonePluginProxyActivity.a((Intent)localObject, paramVarArgs);
          ((Intent)localObject).putExtra("qqid", l);
          ((Intent)localObject).putExtra("refer", f);
          ((Intent)localObject).putExtra("autoShowTimeLine", bool);
          if (bool) {
            ((Intent)localObject).setFlags(335544320);
          }
          if ((localActivity == null) || ((!(localActivity instanceof bjzl)) && (!(localActivity instanceof BasePluginActivity)))) {
            break label343;
          }
          ((Intent)localObject).setClassName(localActivity, paramVarArgs);
          localActivity.startActivity((Intent)localObject);
          return;
        }
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
      if ((j == 35) && (str != null) && (str.length() > 0))
      {
        paramVarArgs = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
        ((Intent)localObject).putExtra("famous_space_webview_url", str);
      }
      else
      {
        paramVarArgs = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
        ((Intent)localObject).setFlags(67108864);
        continue;
        label343:
        QzonePluginProxyActivity.a(localActivity, this.mRuntime.a().getAccount(), (Intent)localObject, 0);
        return;
        label362:
        i = 0;
        continue;
        label367:
        paramVarArgs = "";
        continue;
        label373:
        j = 0;
        continue;
        label378:
        str = "";
        continue;
        label385:
        localObject = "0";
      }
    }
  }
  
  private void b(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      long l = paramVarArgs.getLong("uin");
      paramVarArgs = paramVarArgs.getString("nick");
      Intent localIntent = new Intent();
      QzonePluginProxyActivity.a(localIntent, "com.qzone.homepage.ui.activity.QzoneMoodListActivity");
      localIntent.putExtra(g, l);
      if (!TextUtils.isEmpty(paramVarArgs)) {
        localIntent.putExtra(h, paramVarArgs);
      }
      localIntent.putExtra("refer", f);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), localIntent, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  private void c(String... paramVarArgs)
  {
    try
    {
      long l = new JSONObject(paramVarArgs[0]).getLong("uin");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity");
      paramVarArgs.putExtra("key_left_tab_title", this.mRuntime.a().getString(2131718038));
      paramVarArgs.putExtra("key_right_tab_title", this.mRuntime.a().getString(2131718119));
      paramVarArgs.putExtra("key_album_owner_uin", l);
      paramVarArgs.putExtra("key_selected_tab", 0);
      paramVarArgs.putExtra("refer", f);
      QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!a.equals(paramString2)) {}
    do
    {
      return false;
      if (paramString3.equals(b))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          b(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(c))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          c(paramVarArgs);
        }
        return true;
      }
      if (paramString3.equals(d))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          a(paramVarArgs);
        }
        return true;
      }
    } while (!paramString3.equals(e));
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      l = Long.parseLong(paramVarArgs[0]);
      if (l != 0L)
      {
        this.mRuntime.a();
        paramJsBridgeListener = new Intent();
        paramJsBridgeListener.setAction("qzoneGrapRedPocket");
        paramJsBridgeListener.putExtra("uin", l);
        if (this.mRuntime.a() != null) {
          this.mRuntime.a().sendBroadcast(paramJsBridgeListener);
        }
      }
      return true;
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
        long l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjzk
 * JD-Core Version:    0.7.0.1
 */