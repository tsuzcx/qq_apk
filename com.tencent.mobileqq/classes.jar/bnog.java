import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.1;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.2;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.3;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.4;
import cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.5;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class bnog
  extends bnnn
  implements bngj
{
  private ConcurrentHashMap<String, String> a;
  
  public bnog()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private Bundle a(Bundle paramBundle, String paramString)
  {
    if (paramBundle.containsKey("data")) {
      try
      {
        paramBundle = paramBundle.getBundle("data");
        if (paramBundle == null) {
          QLog.e("QzoneRecommedPhotoJsPlugin", 1, "call js function,bundle is empty");
        }
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramBundle);
        i(paramString);
      }
    }
    for (;;)
    {
      return null;
      i(paramString);
    }
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return bnni.a(paramString, 200, 200, true);
    }
    return "";
  }
  
  private void a(String paramString)
  {
    a("cmd.getEventVideoAlbumState", paramString, new QzoneRecommedPhotoJsPlugin.1(this), true);
  }
  
  private void a(String paramString, Bundle paramBundle, bnok parambnok)
  {
    Bundle localBundle;
    if ((paramBundle != null) && (parambnok != null))
    {
      localBundle = a(paramBundle, paramString);
      if (localBundle != null) {
        paramBundle = new JSONObject();
      }
    }
    try
    {
      parambnok.a(paramBundle, localBundle);
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { paramBundle.toString() });
      }
      return;
    }
    catch (Throwable parambnok)
    {
      for (;;)
      {
        QLog.e("QzoneRecommedPhotoJsPlugin", 1, "onCallJsBridge.setData error", parambnok);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, Runnable paramRunnable, boolean paramBoolean)
  {
    try
    {
      String str = new JSONObject(paramString2).optString("callback");
      if ((paramBoolean) && (TextUtils.isEmpty(str))) {
        return;
      }
      if (!TextUtils.isEmpty(paramString1)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, str);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(bnos.class).post(paramRunnable);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleRunnable error" + paramString2, paramString1);
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("cmd.getRecommedPhoto", paramString);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(bnos.class).post(new QzoneRecommedPhotoJsPlugin.2(this));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleGetRecommendphoto error", paramString);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("photoEventID");
      Intent localIntent = new Intent("action_enter_to_qzone_recommend_photo");
      localIntent.putExtra("param.formSchemeToRecommend", true);
      localIntent.putExtra("param.photoUnikey", paramString);
      bmtd.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), bmtk.a(), localIntent, 0);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleForwardToRecommedPhoto error", paramString);
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_on", paramString.optString("recommend_on"));
      localBundle.putString("recommendPush_on", paramString.optString("recommendPush_on"));
      localBundle.putString("recommendChatCachePhoto_on", paramString.optString("recommendChatCachePhoto_on"));
      bngf.a().a().a(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetShouldScanPhotoEventState error", paramString);
    }
  }
  
  private void e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("event_video_album_state", paramString.optString("event_video_album_state"));
      bngf.a().a().b(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetEventVideoAlbumState error", paramString);
    }
  }
  
  private void f(String paramString)
  {
    a("cmd.getLocalPhotoSwitcher", paramString, new QzoneRecommedPhotoJsPlugin.3(this), true);
  }
  
  private void g(String paramString)
  {
    a("cmd.getQuickMakeDynamicStatus", paramString, new QzoneRecommedPhotoJsPlugin.4(this), true);
  }
  
  private void h(String paramString)
  {
    a("cmd.setQuickMakeDynamicStatus", paramString, new QzoneRecommedPhotoJsPlugin.5(this, paramString), false);
  }
  
  private void i(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error", paramString);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("getEventVideoAlbumState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      bngf.a().a(this);
      a(paramVarArgs[0]);
      return true;
    }
    if (("setEventVideoAlbumState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      e(paramVarArgs[0]);
      return true;
    }
    if (("getRecommendPhotoEvent".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      bngf.a().a(this);
      b(paramVarArgs[0]);
      return true;
    }
    if (("enterPhotoEventDetail".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      c(paramVarArgs[0]);
      return true;
    }
    if (("setShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      d(paramVarArgs[0]);
      return true;
    }
    if (("getShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      bngf.a().a(this);
      f(paramVarArgs[0]);
      return true;
    }
    if (("getQuickMakeDynamicStatus".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      bngf.a().a(this);
      g(paramVarArgs[0]);
      return true;
    }
    if (("setQuickMakeDynamicStatus".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      h(paramVarArgs[0]);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    Object localObject1;
    do
    {
      return;
      str = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (!"cmd.getRecommedPhoto".equals(paramString)) {
        break;
      }
      localObject1 = a(paramBundle, str);
    } while (localObject1 == null);
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject();
        paramString.put("code", 0);
        paramString.put("photoEventID", ((Bundle)localObject1).getString("photoEventID"));
        paramString.put("title", ((Bundle)localObject1).getString("title"));
        paramString.put("time", ((Bundle)localObject1).getString("time"));
        paramString.put("mediaCount", ((Bundle)localObject1).getInt("mediaCount"));
        paramBundle = ((Bundle)localObject1).getIntegerArrayList("dataType");
        localObject1 = ((Bundle)localObject1).getStringArrayList("dataPath");
        JSONArray localJSONArray = new JSONArray();
        if ((paramBundle != null) && (paramBundle.size() > 0) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0) && (paramBundle.size() == ((ArrayList)localObject1).size()))
        {
          i = 0;
          if (i < paramBundle.size())
          {
            Object localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("imageData", "data:image/jpg;base64," + a((String)((ArrayList)localObject1).get(i)));
            ((JSONObject)localObject2).put("type", paramBundle.get(i));
            localJSONArray.put(localObject2);
            if (((Integer)paramBundle.get(i)).intValue() != 3) {
              break label444;
            }
            localObject2 = new File((String)((ArrayList)localObject1).get(i));
            if (!((File)localObject2).exists()) {
              break label444;
            }
            ((File)localObject2).delete();
            break label444;
          }
          paramString.put("thumbInfos", localJSONArray);
          if (str == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { paramString.toString() });
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramString);
        return;
      }
      i(str);
      return;
      if ("cmd.getLocalPhotoSwitcher".equals(paramString))
      {
        a(str, paramBundle, new bnoh(this));
        return;
      }
      if ("cmd.getQuickMakeDynamicStatus".equals(paramString))
      {
        a(str, paramBundle, new bnoi(this));
        return;
      }
      if (!"cmd.getEventVideoAlbumState".equals(paramString)) {
        break;
      }
      a(str, paramBundle, new bnoj(this));
      return;
      label444:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnog
 * JD-Core Version:    0.7.0.1
 */