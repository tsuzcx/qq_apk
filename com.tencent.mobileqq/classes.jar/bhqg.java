import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PublishEventTag;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bhqg
  extends bhrq
  implements bhko
{
  public static String a;
  public static String b = "addfriends";
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Qzone";
  }
  
  private void a(WebViewPlugin paramWebViewPlugin, bcdb parambcdb, String[] paramArrayOfString)
  {
    try
    {
      paramWebViewPlugin = new JSONObject(paramArrayOfString[0]);
      long l = paramWebViewPlugin.getLong("uin");
      int i = paramWebViewPlugin.optInt("sourceId", 3011);
      int j = paramWebViewPlugin.optInt("subSourceId", 21);
      paramWebViewPlugin = parambcdb.a();
      paramWebViewPlugin.startActivity(AddFriendLogicActivity.a(paramWebViewPlugin, 1, String.valueOf(l), "", i, j, null, null, null, null, null));
      return;
    }
    catch (JSONException paramWebViewPlugin)
    {
      paramWebViewPlugin.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      this.c = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.c)) {
        bhkl.a().a().s();
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "getHistoryEventTag error", paramString);
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("list");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0);
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramString.optString("uin"));
        localBundle.putString("time", paramString.optString("time"));
        localBundle.putString("title", paramString.optString("title"));
        localBundle.putString("picUrl", paramString.optString("picUrl"));
        localBundle.putString("id", paramString.optString("id"));
        bhkl.a().a().d(localBundle);
        return;
      }
      bhkl.a().a().d(null);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "setHistoryEventTag error", paramString);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new Bundle();
      paramString.putString("uin", ((JSONObject)localObject).optString("uin"));
      paramString.putString("time", ((JSONObject)localObject).optString("time"));
      paramString.putString("title", ((JSONObject)localObject).optString("title"));
      paramString.putString("picUrl", ((JSONObject)localObject).optString("picUrl"));
      paramString.putString("id", ((JSONObject)localObject).optString("id"));
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject = ((JSONObject)localObject).optJSONObject("joinList");
      if (localObject != null)
      {
        if (((JSONObject)localObject).has("names")) {
          localStringBuilder1.append(((JSONObject)localObject).optString("names"));
        }
        if (((JSONObject)localObject).has("middle"))
        {
          String str = ((JSONObject)localObject).optString("middle");
          localStringBuilder1.append(str);
          localStringBuilder2.append(str);
        }
        if (((JSONObject)localObject).has("suffix"))
        {
          localObject = ((JSONObject)localObject).optString("suffix");
          localStringBuilder1.append((String)localObject);
          localStringBuilder2.append((String)localObject);
        }
      }
      paramString.putString("desc", localStringBuilder1.toString());
      paramString.putString("truncateNum", localStringBuilder2.toString());
      bhkl.a().a().e(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "selectHistoryEventTag error", paramString);
    }
  }
  
  private void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.w("QZoneEventTagJsPlugin", 1, "errorCallBack error");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QZoneEventTagJsPlugin", 1, "errorCallBack error", paramString);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals(jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (!paramString3.equals(b)) {
          break;
        }
        bool1 = bool2;
      } while (paramVarArgs == null);
      bool1 = bool2;
    } while (paramVarArgs.length <= 0);
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
    return true;
    if ("getHistoryEventTag".equals(paramString3))
    {
      bhkl.a().a(this);
      a(paramVarArgs[0]);
      return true;
    }
    if ("setHistoryEventTag".equals(paramString3))
    {
      b(paramVarArgs[0]);
      return true;
    }
    if ("selectEventTag".equals(paramString3))
    {
      c(paramVarArgs[0]);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!"cmd.getHistoryEventTag".equals(paramString))) {}
    do
    {
      return;
      if (!paramBundle.containsKey("data")) {
        break;
      }
      paramString = paramBundle.getBundle("data");
      if (paramString == null)
      {
        QLog.e("QZoneEventTagJsPlugin", 1, "call js function,bundle is empty");
        return;
      }
      try
      {
        paramBundle = paramString.getParcelableArrayList("event_tag");
        paramString = new JSONArray();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          PublishEventTag localPublishEventTag = (PublishEventTag)paramBundle.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localPublishEventTag.g);
          localJSONObject.put("time", localPublishEventTag.h);
          localJSONObject.put("title", localPublishEventTag.jdField_a_of_type_JavaLangString);
          localJSONObject.put("picUrl", localPublishEventTag.b);
          localJSONObject.put("id", localPublishEventTag.c);
          paramString.put(localJSONObject);
        }
        paramBundle = new JSONObject();
      }
      catch (JSONException paramString)
      {
        QLog.e("QZoneEventTagJsPlugin", 1, "onWebEvent error", paramString);
        return;
      }
      paramBundle.put("list", paramString);
    } while (this.c == null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { paramBundle.toString() });
    return;
    d(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqg
 * JD-Core Version:    0.7.0.1
 */