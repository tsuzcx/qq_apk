import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjye
  extends bjxz
{
  private bjjr a;
  
  bjye()
  {
    this.jdField_a_of_type_Bjjr = new bjyf(this);
  }
  
  private static void a(begz parambegz, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      int i = new JSONObject(paramVarArgs[0]).getInt("timestamp");
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallClicktime: " + i);
      }
      bjzy.a(Integer.valueOf(i), Long.valueOf(parambegz.a().getLongAccountUin()));
      return;
    }
    catch (JSONException parambegz)
    {
      parambegz.printStackTrace();
    }
  }
  
  public static void a(CustomWebView paramCustomWebView)
  {
    try
    {
      QZLog.i("QzonePersonalizeJsPlugin", "tiantai notifyWebviewStartAnimation");
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("action", "startAnimation");
      JSONObject localJSONObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("*.qzone.qq.com");
      localJSONObject2.put("echo", true);
      localJSONObject2.put("broadcast", true);
      localJSONObject2.put("domains", localJSONArray);
      a(paramCustomWebView, "qzRooftop", localJSONObject1, localJSONObject2);
      paramCustomWebView.setTag(2131375088, Boolean.FALSE);
      paramCustomWebView.setTag(2131375091, Boolean.FALSE);
      return;
    }
    catch (Exception paramCustomWebView)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai notifyWebviewStartAnimation: ", paramCustomWebView);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "callback is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i = 1;; i = 0)
    {
      if (Build.VERSION.SDK_INT > 20) {
        j = 1;
      }
      try
      {
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("msg", paramString2);
        localJSONObject.put("noZip", i);
        localJSONObject.put("noCrossDomain", j);
        paramString2 = localJSONObject.toString();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramString1, new String[] { paramString2 });
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramString1.getMessage());
        return;
      }
    }
  }
  
  private void a(String... paramVarArgs)
  {
    String str1;
    int i;
    int j;
    String str2;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        str1 = paramVarArgs.optString("url");
        i = paramVarArgs.optInt("id", -1);
        j = paramVarArgs.optInt("download");
        str2 = paramVarArgs.optString("callback");
        if ((j != 0) && (TextUtils.isEmpty(str1)))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "url is empty.");
          return;
        }
        if (TextUtils.isEmpty(str2))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "callback is empty.");
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
        return;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        break label193;
      }
      QLog.e("QzonePersonalizeJsPlugin", 1, "low android version system, so not to download font. sdk = " + Build.VERSION.SDK_INT);
      a(str2, -1, "font has not been cached.");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(bjjo.a(i, str1, str2, paramVarArgs)))
      {
        a(str2, 0, "success");
        return;
      }
      label193:
      do
      {
        paramVarArgs = this.jdField_a_of_type_Bjjr;
        break;
        if (paramVarArgs == null) {
          a(str2, -1, "font has not been cached.");
        }
        return;
      } while (j != 0);
      paramVarArgs = null;
    }
  }
  
  private void b()
  {
    QLog.i("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady");
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
        break label180;
      }
      CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (localCustomWebView == null)
      {
        QZLog.w("QzonePersonalizeJsPlugin", "tiantai webView == null");
        return;
      }
      localCustomWebView.setTag(2131375091, Boolean.TRUE);
      QLog.i("QzonePersonalizeJsPlugin", 1, "tiantai webview activity name: " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getClass().getSimpleName());
      if (!(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() instanceof QzoneTiantaiTranslucentBrowserActivity))
      {
        QZLog.i("QzonePersonalizeJsPlugin", "tiantai 非定制webview直接返回");
        a(localCustomWebView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady: ", localException);
      return;
    }
    Object localObject2 = localException.getTag(2131375088);
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        QZLog.i("QzonePersonalizeJsPlugin", "tiantai video not finish");
        return;
      }
      a(localException);
      return;
      label180:
      Object localObject1 = null;
      break;
    }
  }
  
  private static void b(begz parambegz, String... paramVarArgs)
  {
    int j = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallID");
        }
        localObject = new JSONObject(paramVarArgs[0]).getJSONArray("id");
        if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
          break;
        }
        paramVarArgs = new int[((JSONArray)localObject).length()];
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          paramVarArgs[i] = ((JSONArray)localObject).getInt(i);
          i += 1;
          continue;
        }
        if (paramVarArgs.length <= 0) {
          break;
        }
        new HashMap();
        localObject = bjzy.a(Long.valueOf(parambegz.a().getLongAccountUin()));
        i = j;
        if (i < paramVarArgs.length)
        {
          if (((Map)localObject).containsKey(Integer.valueOf(paramVarArgs[i]))) {
            break label190;
          }
          ((Map)localObject).put(Integer.valueOf(paramVarArgs[i]), Long.valueOf(0L));
        }
      }
      catch (JSONException parambegz)
      {
        parambegz.printStackTrace();
        return;
      }
      bjzy.a((Map)localObject, Long.valueOf(parambegz.a().getLongAccountUin()));
      return;
      label190:
      i += 1;
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      long l;
      String str;
      int i;
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        l = localJSONObject.optLong("uin");
        str = localJSONObject.optString("url");
        i = localJSONObject.optInt("id", -1);
        j = localJSONObject.optInt("formatType");
        if (localJSONObject.optInt("sparkle_id", -1) != -1) {
          d(paramVarArgs);
        }
        if (localJSONObject.optInt("bubble_iItemId", -2147483648) != -2147483648) {
          c(paramVarArgs);
        }
        if (i < 0)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "font id error , id = " + i);
          return;
        }
        if ((i > 0) && (TextUtils.isEmpty(str)))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "url is empty.");
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
        return;
      }
      paramVarArgs = new bjjy();
      paramVarArgs.jdField_a_of_type_Int = i;
      paramVarArgs.b = j;
      paramVarArgs.jdField_a_of_type_JavaLangString = str;
      bjjo.a(l, paramVarArgs);
      if (i > 0) {
        bjjo.a(l, null);
      }
    }
  }
  
  private static void c(begz parambegz, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      int i = paramVarArgs.getInt("CustomVipId");
      paramVarArgs = paramVarArgs.getString("zipUrl");
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "Custom_Vip_Setting");
      localBundle.putInt("CustomVipId", i);
      localBundle.putString("zipUrl", paramVarArgs);
      localIntent.putExtras(localBundle);
      bjdt.a(parambegz.a(), bjea.a(), localIntent);
      return;
    }
    catch (JSONException parambegz)
    {
      parambegz.printStackTrace();
    }
  }
  
  private void c(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        long l = ((JSONObject)localObject2).optLong("uin");
        int i = ((JSONObject)localObject2).optInt("bubble_iItemId", -2147483648);
        paramVarArgs = ((JSONObject)localObject2).optString("bubble_strTextColor");
        Object localObject1 = ((JSONObject)localObject2).optString("bubble_strAndBgUrl");
        String str1 = ((JSONObject)localObject2).optString("bubble_strIosBgUrl");
        String str2 = ((JSONObject)localObject2).optString("bubble_strFrameZip");
        int j = ((JSONObject)localObject2).optInt("bubble_iFrameRate");
        if (i == -2147483648)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "CommentBubble id error , id = " + i);
          return;
        }
        localObject2 = new bjjx();
        ((bjjx)localObject2).jdField_a_of_type_Int = i;
        ((bjjx)localObject2).jdField_a_of_type_JavaLangString = bjjx.a(i, paramVarArgs, (String)localObject1, str1, str2, j);
        bjjo.a(l, (bjjx)localObject2);
        paramVarArgs = new Intent("action_personalize_js2qzone");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("cmd", "refreshCommonList");
        paramVarArgs.putExtras((Bundle)localObject1);
        bjdt.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), bjea.a(), paramVarArgs);
        if (i > 0)
        {
          bjjo.a(l, null);
          bjjo.a(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private static void d(begz parambegz, String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        if (((JSONObject)localObject).getInt("success") == 1)
        {
          paramVarArgs = ((JSONObject)localObject).getJSONArray("uins");
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(parambegz.a(), 2, 2131689601, 0).a();
            }
            localObject = new long[paramVarArgs.length()];
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              i += 1;
            }
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("key_msg_type", 2);
            paramVarArgs.putExtra("key_friend_list", (long[])localObject);
            parambegz.a().setResult(-1, paramVarArgs);
            parambegz.a().finish();
            return;
          }
        }
      }
      catch (JSONException parambegz)
      {
        parambegz.printStackTrace();
      }
    }
  }
  
  private void d(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        long l = paramVarArgs.optLong("uin");
        int i = paramVarArgs.optInt("sparkle_id");
        paramVarArgs = paramVarArgs.optString("sparkle_json");
        if (i < 0)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "font id error , id = " + i);
          return;
        }
        bjjz localbjjz = new bjjz();
        localbjjz.jdField_a_of_type_Int = i;
        localbjjz.jdField_a_of_type_JavaLangString = paramVarArgs;
        bjjo.a(l, localbjjz);
        if (i > 0)
        {
          bjjo.a(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void e(begz parambegz, String... paramVarArgs)
  {
    Intent localIntent = new Intent("action_personalize_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "SetFacade");
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      localBundle.putInt("showonfridyn", new JSONObject(paramVarArgs[0]).getInt("showonfridyn"));
      localIntent.putExtras(localBundle);
      bjdt.a(parambegz.a(), bjea.a(), localIntent);
      return;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void e(String[] paramArrayOfString)
  {
    int j = -1;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      for (;;)
      {
        bjjz localbjjz;
        bjjx localbjjx;
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          long l = paramArrayOfString.optLong("uin");
          paramArrayOfString = paramArrayOfString.optString("callback");
          if (TextUtils.isEmpty(paramArrayOfString))
          {
            QLog.e("QzonePersonalizeJsPlugin", 1, "callback is empty.");
            return;
          }
          bjjy localbjjy = bjjo.a(l);
          localbjjz = bjjo.a(l);
          localbjjx = bjjo.a(l);
          try
          {
            JSONObject localJSONObject = new JSONObject();
            if (localbjjy == null)
            {
              i = -1;
              localJSONObject.put("id", i);
              if (localbjjz != null) {
                break label194;
              }
              i = -1;
              localJSONObject.put("sparkle_id", i);
              if (localbjjx != null) {
                break label203;
              }
              i = j;
              localJSONObject.put("bubble_iItemId", i);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramArrayOfString, new String[] { localJSONObject.toString() });
              return;
            }
          }
          catch (JSONException paramArrayOfString)
          {
            QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
            return;
          }
          i = localbjjy.jdField_a_of_type_Int;
        }
        catch (Exception paramArrayOfString)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
          return;
        }
        continue;
        label194:
        int i = localbjjz.jdField_a_of_type_Int;
        continue;
        label203:
        i = localbjjx.jdField_a_of_type_Int;
      }
    }
  }
  
  private void f(String... paramVarArgs)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "Custom_Player_Setting");
      localBundle.putInt("itemId", localJSONObject.getInt("itemId"));
      localBundle.putString("playerDecoUrl", localJSONObject.optString("playerDecoUrl"));
      localBundle.putLong("textColor", localJSONObject.optLong("textColor"));
      localIntent.putExtras(localBundle);
      bjdt.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), bjea.a(), localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "parse json error " + paramVarArgs[0]);
    }
  }
  
  private void g(String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (paramArrayOfString.optInt("transparent") == 1) {
        i = 1;
      }
      paramArrayOfString = paramArrayOfString.optString("url");
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (i != 0)
      {
        if ((localActivity instanceof BasePluginActivity))
        {
          bjdt.a(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
          return;
        }
        bjdt.a(localActivity, paramArrayOfString, -1, null, null);
        return;
      }
      if ((localActivity instanceof BasePluginActivity))
      {
        bjdt.a(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
        return;
      }
      bjdt.a(localActivity, paramArrayOfString, -1, null, null);
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  private void h(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      boolean bool = paramArrayOfString.getBoolean("isGet");
      paramArrayOfString = paramArrayOfString.getString("ugckey");
      if (bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("param.yellowdiamondRedpocketUgckey", paramArrayOfString);
        bjqu.a().a("cmd.getYellowDiamondRedPocket", localBundle, false);
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleYellowDiamondRedpocket  ", paramArrayOfString);
    }
  }
  
  private void i(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFriendNaviDeco");
      localBundle.putInt("itemId", paramArrayOfString.getInt("itemid"));
      localBundle.putString("friendNaviDecoUrl", paramArrayOfString.optString("friendnavidecoresurl", ""));
      localBundle.putString("textColor", paramArrayOfString.optString("fontcolor", ""));
      localIntent.putExtras(localBundle);
      bjdt.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), bjea.a(), localIntent);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleFriendNaviDeco  ", paramArrayOfString);
    }
  }
  
  private void j(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      int i = ((JSONObject)localObject).getInt("itemId");
      paramArrayOfString = ((JSONObject)localObject).getString("itemUrl");
      localObject = ((JSONObject)localObject).getString("itemText");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setResponsiveLike");
      localBundle.putInt("itemId", i);
      localBundle.putString("itemUrl", paramArrayOfString);
      localBundle.putString("itemText", (String)localObject);
      bjqu.a().a("cmd.setResponsiveLike", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleHighFive  ", paramArrayOfString);
    }
  }
  
  private void k(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 1)) {}
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).optString("data");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setDiyHomePage");
      localBundle.putString("layoutJson", paramArrayOfString);
      bjqu.a().a("cmd.setDIYData", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleDIYData  ", paramArrayOfString);
    }
  }
  
  private void l(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      Bundle localBundle = new Bundle();
      localBundle.putInt("itemId", paramArrayOfString.getInt("itemid"));
      QLog.i("QzonePersonalizeJsPlugin", 1, "handleCustomTrack  h5set ");
      bjqu.a().a("cmd.setCustomTrack", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "handleCustomTrack  ", paramArrayOfString);
    }
  }
  
  public void a()
  {
    super.a();
    axjs.a().onDestroy();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (bjwt.a(paramString3))
          {
            LocalMultiProcConfig.putBool("qzone_force_refresh", true);
            LocalMultiProcConfig.putBool("qzone_force_refresh_passive", true);
          }
          if ("UpdateMallTimestamp".equalsIgnoreCase(paramString3))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if ("UpdateMallid".equalsIgnoreCase(paramString3))
          {
            b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if ("Personalize".equalsIgnoreCase(paramString3))
          {
            d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if ("SetFacade".equalsIgnoreCase(paramString3))
          {
            e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if (paramString3.equals("CleanZebraNum"))
          {
            bkac.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if (paramString3.equals("SetPersonalizeFinished"))
          {
            bjzz.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if (paramString3.equals("openNameplateSucc"))
          {
            bjzv.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if ("downLoadFont".equalsIgnoreCase(paramString3))
          {
            a(paramVarArgs);
            return true;
          }
          if ("OpenCustomVipSucc".equals(paramString3))
          {
            c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
            return true;
          }
          if ("setDefaultFont".equals(paramString3))
          {
            b(paramVarArgs);
            return true;
          }
          if ("getDefaultFont".equals(paramString3))
          {
            e(paramVarArgs);
            return true;
          }
          if ("SetPlayerDeco".equals(paramString3))
          {
            f(paramVarArgs);
            return true;
          }
          if ("qzRooftopPageReady".equals(paramString3))
          {
            b();
            return true;
          }
          if ("OpenUrl".equals(paramString3))
          {
            g(paramVarArgs);
            return true;
          }
          if ("RefreshDeco".equals(paramString3))
          {
            bjqu.a().a("cmd.refeshDecoCustom", null, false);
            return true;
          }
          if (!"GiftPlayAnimation".equals(paramString3)) {
            break;
          }
          bool1 = bool2;
        } while (paramVarArgs == null);
        bool1 = bool2;
      } while (paramVarArgs.length != 1);
      bool1 = bool2;
    } while (TextUtils.isEmpty(paramVarArgs[0]));
    axjs.a().b(paramVarArgs[0]);
    return true;
    if ("GetRedpocket".equals(paramString3))
    {
      h(paramVarArgs);
      return true;
    }
    if ("setFriendNaviDeco".equals(paramString3))
    {
      i(paramVarArgs);
      return true;
    }
    if ("setResponsiveLike".equals(paramString3))
    {
      j(paramVarArgs);
      return true;
    }
    if ("setDiyHomePage".equals(paramString3))
    {
      k(paramVarArgs);
      return true;
    }
    if ("setCustomTrack".equals(paramString3)) {
      l(paramVarArgs);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjye
 * JD-Core Version:    0.7.0.1
 */