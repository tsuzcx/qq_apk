import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class bgyb
{
  public static int a(int paramInt)
  {
    return paramInt & 0xFF;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return (paramInt2 << 8) + paramInt1;
  }
  
  public static Bundle a()
  {
    if ((bgyd.jdField_a_of_type_Boolean) || (bgyd.b))
    {
      StringBuilder localStringBuilder = new StringBuilder("_tcvassp_0_=");
      if ((bgyd.jdField_a_of_type_Int != -1) && (bgyd.jdField_a_of_type_JavaUtilArrayList.size() != 0))
      {
        localStringBuilder.append(bgyd.jdField_a_of_type_Int);
        if (bgyd.b) {}
        for (Object localObject = "shp";; localObject = "webp")
        {
          localStringBuilder.append((String)localObject);
          localObject = new Bundle();
          ((Bundle)localObject).putString("argument", localStringBuilder.toString());
          ((Bundle)localObject).putStringArrayList("domains", bgyd.jdField_a_of_type_JavaUtilArrayList);
          if (QLog.isColorLevel())
          {
            QLog.i("SwiftWebViewUtils", 2, "getCDNExtensionData, arg: " + localStringBuilder.toString());
            QLog.i("SwiftWebViewUtils", 2, "getCDNExtensionData, domainList: " + TextUtils.join(", ", bgyd.jdField_a_of_type_JavaUtilArrayList));
          }
          return localObject;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("SwiftWebViewUtils", 2, "CdnCacheConfig did not parse!!!");
      }
    }
    return null;
  }
  
  public static Bundle a(WebViewFragment paramWebViewFragment, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    Object localObject = Uri.parse(paramWebViewFragment.mUrl);
    paramIntent = localBundle;
    if (localObject != null)
    {
      localObject = ((Uri)localObject).getHost();
      paramIntent = localBundle;
      if (Build.VERSION.SDK_INT >= 19) {
        if (!ugf.d((String)localObject))
        {
          paramIntent = localBundle;
          if (!"buluo.qq.com".equalsIgnoreCase((String)localObject)) {}
        }
        else
        {
          paramWebViewFragment.webView.evaluateJavascript("document.querySelector(\"meta[itemprop='name']\").getAttribute('content')", new bgyc(paramWebViewFragment));
          paramIntent = null;
        }
      }
    }
    return paramIntent;
  }
  
  public static WebResourceResponse a()
  {
    WebResourceResponse localWebResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
    Map localMap = localWebResourceResponse.getResponseHeaders();
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("cache-control", "must-revalidate，no-store");
    localWebResourceResponse.setResponseHeaders((Map)localObject);
    return localWebResourceResponse;
  }
  
  public static String a(Intent paramIntent)
  {
    Object localObject = "";
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("url");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("key_params_qq");
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = "";
        }
      }
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("url:");
    if ((paramString != null) && (paramString.length() > 512)) {
      localStringBuilder.append(paramString.substring(0, 512));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramString);
    }
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int m = 0;
    i = 0;
    String str1;
    String str2;
    label66:
    int n;
    int i1;
    switch (HttpUtil.getNetWorkType())
    {
    case 0: 
    default: 
      str1 = "";
      str2 = "";
      if (WebpSoLoader.b())
      {
        str2 = " WebP/0.3.1";
        if (!TextUtils.isEmpty(str2)) {
          bgyd.jdField_a_of_type_Boolean = true;
        }
        bgyd.b = paramBoolean;
        n = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        i1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
        if (!bbyp.b()) {
          break label467;
        }
      }
      break;
    }
    label467:
    for (int k = 1;; k = 0)
    {
      j = m;
      try
      {
        localObject = BaseApplicationImpl.getApplication().getResources().getConfiguration().toString();
        j = m;
        if (((String)localObject).contains("hwMultiwindow-magic")) {
          break label516;
        }
        j = m;
        if (!((String)localObject).contains("hw-magic-windows")) {}
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject;
          StringBuilder localStringBuilder;
          QLog.e("SwiftWebViewUtils", 1, "getUA ", localThrowable);
          i = j;
          continue;
          paramString1 = " " + paramString2;
          continue;
          i = 1;
        }
      }
      j = i;
      if (QLog.isColorLevel())
      {
        j = i;
        QLog.d("SwiftWebViewUtils", 2, new Object[] { "config:", localObject, " isInMagicWindow:", Integer.valueOf(i) });
      }
      localStringBuilder = new StringBuilder();
      localObject = paramString1;
      if (paramString1 == null) {
        localObject = "";
      }
      localObject = localStringBuilder.append((String)localObject).append(" ").append(QZoneHelper.getQUA());
      if (!TextUtils.isEmpty(paramString2)) {
        break label492;
      }
      paramString1 = "";
      return paramString1 + " QQ/" + "8.4.8" + "." + "4810" + str1 + str2 + " Pixel/" + n + " StatusBarHeight/" + i1 + " SimpleUISwitch/" + k + " QQTheme/" + ThemeUtil.getCurrentThemeId() + " InMagicWin/" + i;
      str1 = " NetType/UNKNOWN";
      break;
      str1 = " NetType/WIFI";
      break;
      str1 = " NetType/2G";
      break;
      str1 = " NetType/3G";
      break;
      str1 = " NetType/4G";
      break;
      localObject = WebpSoLoader.a();
      if (paramBoolean)
      {
        str2 = " WebP/0.3.0";
        break label66;
      }
      if (localObject == null) {
        break label66;
      }
      str2 = String.format(" WebP/%d.%d.%d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
      break label66;
    }
  }
  
  public static void a()
  {
    int j = 0;
    if ((bgyd.jdField_a_of_type_JavaUtilArrayList.size() != 0) && (bgyd.jdField_a_of_type_Int != -1)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), bgcw.e.jdField_a_of_type_JavaLangString);
      if (((File)localObject1).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SwiftWebViewUtils", 2, "no WebviewCrashReport.json exists!");
    return;
    for (;;)
    {
      int i;
      String[] arrayOfString;
      try
      {
        localObject1 = FileUtils.readFileContent((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = new JSONObject((String)localObject1);
        if ((!((JSONObject)localObject1).has("group_domain")) || (!((JSONObject)localObject1).has("group_strategy"))) {
          break label520;
        }
        Object localObject2 = ((JSONObject)localObject1).getString("group_domain");
        localObject1 = ((JSONObject)localObject1).getString("group_strategy");
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewUtils", 2, "cdnCacheConfig, domain: " + (String)localObject2 + ", strategys: " + (String)localObject1);
        }
        localObject2 = ((String)localObject2).replace("[", "").replace("]", "").replace("\"", "").split(",");
        if (localObject2.length > 0)
        {
          bgyd.jdField_a_of_type_JavaUtilArrayList.clear();
          k = localObject2.length;
          i = 0;
          if (i < k)
          {
            arrayOfString = localObject2[i];
            bgyd.jdField_a_of_type_JavaUtilArrayList.add(arrayOfString.trim());
            i += 1;
            continue;
          }
        }
        int k = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        localObject1 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1).split("\\],\\[");
        if (localObject1.length <= 0) {
          break;
        }
        bgyd.jdField_a_of_type_Int = -1;
        int m = localObject1.length;
        i = j;
        if (i >= m) {
          break;
        }
        localObject2 = localObject1[i].replace("[", "").replace("]", "").replace("\"", "");
        arrayOfString = ((String)localObject2).split(",");
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewUtils", 2, "stragegy: " + (String)localObject2);
        }
        if (arrayOfString.length != 3) {
          break label502;
        }
        j = Integer.parseInt(arrayOfString[0].trim());
        int n = Integer.parseInt(arrayOfString[1].trim());
        if ((k < j) || (k > n)) {
          break label536;
        }
        i = Integer.parseInt(arrayOfString[2]);
        bgyd.jdField_a_of_type_Int = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SwiftWebViewUtils", 2, "hit stragegy, target cdn size: " + i + ", stragegy: " + (String)localObject2);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SwiftWebViewUtils", 2, "", localException);
      return;
      label502:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SwiftWebViewUtils", 2, Arrays.toString(arrayOfString));
      return;
      label520:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("SwiftWebViewUtils", 2, "no cdnCacheConfig!");
      return;
      label536:
      i += 1;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("banner_webViewUrl");
    } while (str.contains("minAIOFromMsgList"));
    paramIntent.putExtra("banner_webViewUrl", str + "&minAIOFromMsgList=1");
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (paramWebView.getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("address", paramString);
      paramWebView.getX5WebViewExtension().invokeMiscMethod("setHttpSystemProxy", localBundle);
    }
  }
  
  public static boolean a()
  {
    return BaseApplication.getContext().getSharedPreferences("webview_report_config", 0).getBoolean("hide_back_text", false);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = Uri.parse(paramString);
      } while (!paramString.isHierarchical());
      paramString = paramString.getQueryParameter("_tbs_xv");
    } while ((TextUtils.isEmpty(paramString)) || (1L != (Long.parseLong(paramString) & 1L)));
    return true;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    boolean bool1 = false;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = bool1;
    if (localObject != null)
    {
      if (!((AppRuntime)localObject).isLogin()) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    String str = paramJSONObject.optString("platformId", "");
    if ((!"0".equals(str)) && (!"2".equals(str)))
    {
      QLog.e("SwiftWebViewUtils", 1, "not support Android! " + paramJSONObject.toString());
      return false;
    }
    label127:
    int j;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(paramJSONObject.optString("business", ""))))
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramJSONObject.has("minVersion"))
        {
          paramString = paramJSONObject.optString("minVersion");
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString))
          {
            bool1 = bool2;
            if (!bgev.a(paramString, "8.4.8.4810")) {
              bool1 = false;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramJSONObject.has("maxVersion"))
        {
          paramString = paramJSONObject.optString("maxVersion");
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramString))
          {
            bool2 = bool1;
            if (!bgev.a("8.4.8.4810", paramString)) {
              bool2 = false;
            }
          }
        }
      }
      bool1 = bool2;
      if (!bool2) {
        break label503;
      }
      paramString = ((AppRuntime)localObject).getAccount();
      int m = paramJSONObject.optInt("startIndex");
      int k = paramJSONObject.optInt("endIndex");
      if (m < k) {
        break label506;
      }
      j = paramString.length();
      if ((j < m) || (j < k)) {
        break label506;
      }
      m = j - m;
      k = j - k;
      if ((m >= j) || (k >= j) || (m > k)) {
        break label506;
      }
      long l1 = Long.parseLong(paramString.substring(m, k + 1));
      long l2 = paramJSONObject.optLong("min");
      long l3 = paramJSONObject.optLong("max");
      if ((l1 < l2) || (l1 > l3)) {
        break label506;
      }
    }
    label429:
    label503:
    label506:
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        localObject = paramJSONObject.optString("uinWhiteList");
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          j = localObject.length;
          bool1 = bool2;
          if (i < j) {
            if (paramString.equals(localObject[i])) {
              bool1 = true;
            }
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        QLog.e("SwiftWebViewUtils", 1, "Config is not valid: " + paramJSONObject);
        return bool1;
        bool2 = false;
        break label127;
        i += 1;
        break label429;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    return paramInt >> 8 & 0xFF;
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i).toLowerCase();
      }
    }
    return "";
  }
  
  public static void b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("x5_proxy_setting", 4);
    bgye.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("http_proxy_address", "");
    bgye.jdField_a_of_type_Boolean = localSharedPreferences.contains("need_set_proxy");
    localSharedPreferences.edit().remove("need_set_proxy").apply();
  }
  
  public static boolean b()
  {
    int i = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[14].intValue();
    QLog.d("SwiftWebViewUtils", 1, "isSupportPreRend: " + i);
    return i == 1;
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("Dalvik/");
    localStringBuilder.append(System.getProperty("java.vm.version"));
    localStringBuilder.append(" (Linux; U; Android ");
    String str = Build.VERSION.RELEASE;
    if (str.length() > 0) {}
    for (;;)
    {
      localStringBuilder.append(str);
      if ("REL".equals(Build.VERSION.CODENAME))
      {
        str = Build.MODEL;
        if (str.length() > 0)
        {
          localStringBuilder.append("; ");
          localStringBuilder.append(str);
        }
      }
      str = Build.ID;
      if (str.length() > 0)
      {
        localStringBuilder.append(" Build/");
        localStringBuilder.append(str);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      str = "1.0";
    }
  }
  
  public static String d(String paramString)
  {
    int i = 50;
    int k;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      k = paramString.indexOf(":");
      if (k > 0)
      {
        j = (paramString + "?#").indexOf("?");
        if (j <= 50) {
          break label81;
        }
      }
    }
    for (;;)
    {
      if ((k + 3 < paramString.length()) && (i >= 0)) {
        return paramString.substring(k + 3, i);
      }
      return "";
      label81:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyb
 * JD-Core Version:    0.7.0.1
 */