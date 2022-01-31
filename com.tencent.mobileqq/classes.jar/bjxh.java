import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2;
import cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.3;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjxh
{
  public static bjsb a;
  static CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  static String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Bjsb = new bjxi();
  }
  
  private static int a(Context paramContext, String paramString, int paramInt, begz parambegz)
  {
    int i = 2;
    if (paramContext == null) {
      return 5;
    }
    if (a(paramString)) {
      if (a(paramContext, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "simpleSchemeJump");
        }
        a(paramContext, Uri.parse(paramString));
        paramInt = 1;
      }
    }
    for (;;)
    {
      return paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "showQzoneAppDownloadDialog");
      }
      a(paramContext, parambegz);
      paramInt = i;
      continue;
      if (URLUtil.isNetworkUrl(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "isNetworkUrl do nothing");
        }
        paramInt = 5;
      }
      else
      {
        paramInt = 5;
      }
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("_wv");
        if (str == null) {
          return a(paramString, "_wv", String.valueOf(paramInt));
        }
        if (paramBoolean)
        {
          str = a(paramString, "_wv", String.valueOf(Integer.valueOf(str).intValue() | paramInt));
          return str;
        }
      }
      catch (Exception localException) {}
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2 + '=';
    int i = paramString1.indexOf(str);
    int j;
    if (i != -1)
    {
      if (i == 0) {}
      do
      {
        i = paramString1.indexOf(str, str.length() + i);
        break;
        j = paramString1.charAt(i - 1);
      } while ((j != 63) && (j != 35) && (j != 38));
    }
    int k;
    if (i > -1)
    {
      k = i + str.length();
      j = k;
      if (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m != 38) && (m != 35)) {}
      }
      else
      {
        if ((!paramString2.equals("_wv")) || (i <= paramString1.indexOf('#'))) {
          break label188;
        }
        paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
    }
    for (;;)
    {
      return paramString1;
      j += 1;
      break;
      label188:
      paramString1 = paramString1.substring(0, k) + paramString3 + paramString1.substring(j);
      continue;
      paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
    }
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SignInSbumited");
    if (paramActivity != null) {
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent;
    if (paramContext != null)
    {
      String str1 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromMarket", "market://details?id=com.tencent.weishi");
      if (!TextUtils.isEmpty(str1))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(str1));
        bjdt.c(localIntent);
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        str2 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromURL", "http://android.myapp.com/myapp/detail.htm?apkName=com.tencent.weishi");
      } while (TextUtils.isEmpty(str2));
      localIntent.setData(Uri.parse(str2));
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, "goToDownloadWeishi catch an exception.", paramContext);
      }
    }
  }
  
  static void a(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent();
    localIntent.setData(paramUri);
    localIntent.setPackage("com.qzone");
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, begz parambegz)
  {
    parambegz = bdgm.a(paramContext, 0);
    parambegz.setMessage(paramContext.getString(2131720822));
    parambegz.setPositiveButton(paramContext.getString(2131691976), new bjxj(paramContext));
    parambegz.setNegativeButton(paramContext.getString(2131693480), new bjxk(parambegz));
    try
    {
      if (!parambegz.isShowing()) {
        parambegz.show();
      }
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "mDialog.show() exception", paramContext);
    }
  }
  
  /* Error */
  private static void a(begz parambegz, String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_0
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: new 260	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 261	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc_w 263
    //   22: invokevirtual 266	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   25: istore_2
    //   26: aload 5
    //   28: ldc_w 268
    //   31: invokevirtual 271	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_1
    //   35: aload 5
    //   37: ldc_w 273
    //   40: invokevirtual 266	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   43: istore 4
    //   45: iload 4
    //   47: istore_3
    //   48: new 151	android/content/Intent
    //   51: dup
    //   52: invokespecial 152	android/content/Intent:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: ldc_w 275
    //   62: invokevirtual 158	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   65: pop
    //   66: aload 5
    //   68: ldc_w 263
    //   71: iload_2
    //   72: invokevirtual 279	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   75: pop
    //   76: aload 5
    //   78: ldc_w 268
    //   81: aload_1
    //   82: invokestatic 285	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   85: invokevirtual 288	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   88: pop
    //   89: aload 5
    //   91: ldc_w 290
    //   94: ldc_w 292
    //   97: invokevirtual 295	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   100: pop
    //   101: aload 5
    //   103: ldc_w 273
    //   106: iload_3
    //   107: invokevirtual 279	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   110: pop
    //   111: aload_0
    //   112: invokevirtual 300	begz:a	()Landroid/app/Activity;
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull -111 -> 6
    //   120: aload_0
    //   121: aload 5
    //   123: invokevirtual 164	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   126: return
    //   127: astore 5
    //   129: ldc_w 302
    //   132: astore_1
    //   133: iconst_m1
    //   134: istore_2
    //   135: aload 5
    //   137: invokevirtual 305	org/json/JSONException:printStackTrace	()V
    //   140: goto -92 -> 48
    //   143: astore 5
    //   145: ldc_w 302
    //   148: astore_1
    //   149: goto -14 -> 135
    //   152: astore 5
    //   154: goto -19 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	parambegz	begz
    //   0	157	1	paramString	String
    //   25	110	2	i	int
    //   1	106	3	j	int
    //   43	3	4	k	int
    //   15	107	5	localObject	Object
    //   127	9	5	localJSONException1	JSONException
    //   143	1	5	localJSONException2	JSONException
    //   152	1	5	localJSONException3	JSONException
    // Exception table:
    //   from	to	target	type
    //   7	26	127	org/json/JSONException
    //   26	35	143	org/json/JSONException
    //   35	45	152	org/json/JSONException
  }
  
  static void a(begz parambegz, String... paramVarArgs)
  {
    if ((parambegz != null) && (parambegz.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject1 = parambegz.a(parambegz.a());
        if ((localObject1 != null) && ((localObject1 instanceof belp)))
        {
          localObject1 = ((belp)localObject1).a().a();
          if ((localObject1 != null) && (((bety)localObject1).isShowing())) {
            ((bety)localObject1).dismiss();
          }
        }
        jdField_a_of_type_ComTencentBizPubaccountCustomWebView = parambegz.a();
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("callback");
        paramVarArgs = ((JSONObject)localObject2).optString("webpageUrl");
        ((JSONObject)localObject2).optInt("miniprogramType");
        localObject1 = ((JSONObject)localObject2).optString("userName");
        String str1 = ((JSONObject)localObject2).optString("path");
        String str2 = ((JSONObject)localObject2).optString("title");
        String str3 = ((JSONObject)localObject2).optString("description");
        localObject2 = ((JSONObject)localObject2).optString("picUrl");
        HashMap localHashMap = new HashMap(1);
        paramVarArgs = new QZoneWebViewJsHandleLogic.2(parambegz, localHashMap, str2, str3, paramVarArgs, str1, (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramVarArgs.run();
          return;
        }
        ThreadManager.post(new QZoneWebViewJsHandleLogic.3((String)localObject2, localHashMap, parambegz, paramVarArgs), 8, null, false);
        return;
      }
      catch (Exception parambegz)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "shareMiniProgramFromQzone error", parambegz);
      }
    }
  }
  
  private static void a(WebViewPlugin paramWebViewPlugin, begz parambegz, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (parambegz == null) || (paramVarArgs.length <= 0)) {}
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label397:
    label717:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject5 = new JSONObject(paramVarArgs[0]);
              localObject1 = ((JSONObject)localObject5).optString("schema");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              paramVarArgs = parambegz.a().getUrl();
              if (!bjvd.a().a(paramVarArgs, (String)localObject1))
              {
                QLog.e("QZoneWebViewJsHandleLogic", 1, "has no right handle this jsapi");
                return;
              }
            }
            catch (JSONException paramWebViewPlugin)
            {
              paramWebViewPlugin.printStackTrace();
              QLog.e("QZoneWebViewJsHandleLogic", 1, "handleSchema", paramWebViewPlugin);
              return;
            }
            paramVarArgs = ((JSONObject)localObject5).optJSONObject("dealparam");
            if (paramVarArgs == null) {
              break label1099;
            }
            localObject2 = paramVarArgs.optString("url");
            paramVarArgs = paramVarArgs.optString("blogurl", "");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
              break label1084;
            }
            localObject3 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            localObject2 = localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("QZoneWebViewPlugin", 2, " handleSchema scheme:" + (String)localObject2);
            }
            localObject4 = null;
            if (parambegz != null) {
              localObject4 = parambegz.a();
            }
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if ((localObject4 instanceof BasePluginActivity)) {
                localObject3 = ((BasePluginActivity)localObject4).getOutActivity();
              }
            }
            localObject4 = localObject3;
            if (localObject3 != null)
            {
              localObject4 = localObject3;
              if ((localObject3 instanceof BasePluginActivity)) {
                localObject4 = ((BasePluginActivity)localObject3).getOutActivity();
              }
            }
            bool = ((String)localObject2).startsWith("mqzone://arouse/userhome");
            if (bool)
            {
              if (localObject4 == null) {
                continue;
              }
              try
              {
                if (((String)localObject2).indexOf("uin=") != -1)
                {
                  paramWebViewPlugin = ((String)localObject2).substring(((String)localObject2).indexOf("uin=") + 4, ((String)localObject2).length());
                  bjdt.a((Context)localObject4, bjea.a(), paramWebViewPlugin, 0, 0, 0);
                  return;
                }
              }
              catch (Exception paramWebViewPlugin)
              {
                paramWebViewPlugin.printStackTrace();
                return;
              }
            }
          }
          if (!((String)localObject2).startsWith("mqzone://arouse/webtofeeddetail")) {
            break;
          }
        } while (localObject4 == null);
        parambegz = parambegz.a((Activity)localObject4);
        if (!(parambegz instanceof beha)) {
          break label1115;
        }
        i = ((beha)parambegz).switchRequestCode(paramWebViewPlugin, (byte)3);
        if (TextUtils.isEmpty(paramVarArgs))
        {
          bjdt.a((Activity)localObject4, bjea.a(), (String)localObject1, i);
          return;
        }
        bjdt.a((Activity)localObject4, bjea.a(), (String)localObject1, i, paramVarArgs);
        return;
        if (!((String)localObject2).startsWith("mqzone://arouse/detail")) {
          break;
        }
      } while (localObject4 == null);
      paramVarArgs = Uri.parse((String)localObject2);
      localObject1 = paramVarArgs.getQueryParameter("uin");
      localObject2 = paramVarArgs.getQueryParameter("appid");
      localObject3 = paramVarArgs.getQueryParameter("cellid");
      localObject5 = paramVarArgs.getQueryParameter("subid");
      Object localObject6 = paramVarArgs.getQueryParameter("source");
      String str1 = paramVarArgs.getQueryParameter("cookie");
      String str2 = paramVarArgs.getQueryParameter("local_city_feedindex");
      String str3 = paramVarArgs.getQueryParameter("ugckey");
      String str4 = paramVarArgs.getQueryParameter("feedData");
      String str5 = paramVarArgs.getQueryParameter("needShowBottom");
      String str6 = paramVarArgs.getQueryParameter("urlForTodayInHistory");
      String str7 = paramVarArgs.getQueryParameter("buttonText");
      Bundle localBundle = new Bundle();
      if (localObject6 != null) {
        localBundle.putString("source", (String)localObject6);
      }
      if (str1 != null) {
        localBundle.putString("cookie", str1);
      }
      if (str2 != null) {
        localBundle.putString("local_city_feedindex", str2);
      }
      if (str3 != null) {
        localBundle.putString("ugckey", str3);
      }
      if (str4 != null) {
        localBundle.putString("local_city_feedData", str4);
      }
      if (str5 != null) {
        localBundle.putString("show_share_btn", str5);
      }
      if (str6 != null) {
        localBundle.putString("share_url", str6);
      }
      if (str7 != null) {
        localBundle.putString("share_btn_text", str7);
      }
      localObject6 = parambegz.a((Activity)localObject4);
      if (!(localObject6 instanceof beha)) {
        break label1120;
      }
      i = ((beha)localObject6).switchRequestCode(paramWebViewPlugin, (byte)3);
      paramWebViewPlugin = bjea.a();
      paramWebViewPlugin.jdField_a_of_type_JavaLangString = parambegz.a().getAccount();
      parambegz = new Bundle();
      parambegz.putString("source", paramVarArgs.getQueryParameter("source"));
      parambegz.putString("bypassparam", paramVarArgs.getQueryParameter("bypassparam"));
      parambegz.putAll(localBundle);
      bjdt.a((Activity)localObject4, paramWebViewPlugin, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject5, i, parambegz);
      return;
      if (!"mqzone://arouse/dynamicnickname".equalsIgnoreCase((String)localObject2)) {
        break;
      }
    } while ((parambegz == null) || (parambegz.a() == null) || (parambegz.a() == null));
    bjdt.a(parambegz.a(), parambegz.a().getAccount());
    return;
    if (((String)localObject2).startsWith("mqzone://arouse/uploadphoto"))
    {
      bjdt.a(paramWebViewPlugin, parambegz, parambegz.a(), parambegz.a().getAccount(), (String)localObject2);
      return;
    }
    if ((((String)localObject2).startsWith("mqzone://arouse/facade")) || (((String)localObject2).startsWith("mqzonev2://arouse/facade")))
    {
      a(parambegz.a(), (String)localObject2, 81, parambegz);
      return;
    }
    if (((String)localObject2).startsWith("mqzone://arouse/moodVoiceRecord"))
    {
      bjdt.b(paramWebViewPlugin, parambegz, parambegz.a(), parambegz.a().getAccount(), (String)localObject2);
      return;
    }
    paramVarArgs = new Intent("action_js2qzone");
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("cmd", "Schema");
    ((Bundle)localObject1).putString("schema", (String)localObject2);
    if (((JSONObject)localObject5).optInt("showQzoneProgressDialog", 1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramVarArgs.putExtras((Bundle)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleSchema actionString: " + paramVarArgs.getAction() + "scheme:" + (String)localObject2);
      }
      if (((String)localObject2).startsWith("mqzone://arouse/openvideolayer"))
      {
        i = bjxl.a(paramWebViewPlugin, parambegz, 4);
        bjdt.a((Activity)localObject4, bjea.a(), paramVarArgs, i, bool);
        return;
      }
      bjdt.a((Activity)localObject4, bjea.a(), paramVarArgs, -1, bool);
      return;
      label1084:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      label1099:
      localObject3 = null;
      localObject2 = localObject1;
      paramVarArgs = null;
      localObject1 = localObject3;
      break;
      label1115:
      i = 3;
      break label397;
      label1120:
      i = 3;
      break label717;
    }
  }
  
  static void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("handleUrl", 2, "browse url fail:" + paramString);
      }
    }
    do
    {
      return;
      paramString = a(paramString, 7, false);
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromQZone", true);
      localIntent.putExtra("injectrecommend", true);
      localIntent.setData(Uri.parse(paramString));
      localIntent.addFlags(268435456);
      localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131718341));
      paramContext.startActivity(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("handleurl", 2, "jump to browser: " + paramString);
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.versionCode >= paramInt) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static boolean a(WebViewPlugin paramWebViewPlugin, begz parambegz, String paramString, String... paramVarArgs)
  {
    if ("updateFeedContainer".equalsIgnoreCase(paramString)) {
      f(parambegz, paramVarArgs);
    }
    do
    {
      return true;
      if ("SendGiftFinished".equalsIgnoreCase(paramString))
      {
        g(parambegz, paramVarArgs);
        return true;
      }
      if ("sendGiftSuccess".equalsIgnoreCase(paramString))
      {
        h(parambegz, paramVarArgs);
        return true;
      }
      if ("openAppDetail".equalsIgnoreCase(paramString))
      {
        i(parambegz, paramVarArgs);
        return true;
      }
      if ("Schema".equalsIgnoreCase(paramString))
      {
        a(paramWebViewPlugin, parambegz, paramVarArgs);
        return true;
      }
      if (!"refreshFeeds".equals(paramString)) {
        break;
      }
    } while (parambegz.a() == null);
    a(parambegz.a());
    return true;
    if ("UpdateFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      a(parambegz, paramVarArgs[0]);
      return true;
    }
    if ("clickWeiShiWidget".equalsIgnoreCase(paramString))
    {
      e(parambegz, paramVarArgs);
      return true;
    }
    if ("showFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      d(parambegz, paramVarArgs);
      return true;
    }
    if ("updateNativeIsSpecialFollow".equalsIgnoreCase(paramString))
    {
      c(parambegz, paramVarArgs);
      return true;
    }
    if ("ShareToWXMiniProgram".equals(paramString))
    {
      a(parambegz, paramVarArgs);
      return true;
    }
    if ("pickGameMates".equals(paramString))
    {
      b(parambegz, paramVarArgs);
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString).getScheme();
      if (("mqzone".equals(paramString)) || ("mqzonev2".equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static void b(begz parambegz, String... paramVarArgs)
  {
    if ((parambegz != null) && (parambegz.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      parambegz = new Intent("qzone.pickgamemates");
      parambegz.putExtra("gamemates", paramVarArgs[0]);
      BaseApplicationImpl.getApplication().sendBroadcast(parambegz);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "handleGameMates = " + paramVarArgs[0]);
      }
    }
  }
  
  private static void c(begz parambegz, String... paramVarArgs)
  {
    if ((parambegz != null) && (parambegz.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("isSpecialFollow", -1);
      parambegz = new Intent("updateIsSpecialFollow");
      parambegz.putExtra("isSpecialFollow", i);
      BaseApplicationImpl.getApplication().sendBroadcast(parambegz);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception parambegz)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleUpdateIsSpecialFollow catch an exception. ", parambegz);
    }
  }
  
  private static void d(begz parambegz, String... paramVarArgs)
  {
    if ((parambegz != null) && (parambegz.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("followStatus");
      parambegz = new Intent("showFollowActionSheet");
      parambegz.putExtra("followStatus", i);
      BaseApplicationImpl.getApplication().sendBroadcast(parambegz);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception parambegz)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleShowFollowActionSheet catch an exception. ", parambegz);
    }
  }
  
  private static void e(begz parambegz, String... paramVarArgs)
  {
    Activity localActivity;
    if ((parambegz != null) && (parambegz.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localActivity = parambegz.a();
      if (bdiv.a(localActivity, "com.tencent.weishi"))
      {
        parambegz = "";
        try
        {
          paramVarArgs = new JSONObject(paramVarArgs[0]).optString("schema");
          parambegz = paramVarArgs;
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            parambegz = paramVarArgs;
            Intent localIntent = new Intent();
            parambegz = paramVarArgs;
            localIntent.setAction("android.intent.action.VIEW");
            parambegz = paramVarArgs;
            localIntent.setData(Uri.parse(paramVarArgs));
            parambegz = paramVarArgs;
            bjdt.c(localIntent);
            parambegz = paramVarArgs;
            List localList = localActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
            if (localList == null) {
              break label177;
            }
            parambegz = paramVarArgs;
            if (localList.size() <= 0) {
              break label177;
            }
            parambegz = paramVarArgs;
            localActivity.startActivity(localIntent);
          }
          for (;;)
          {
            parambegz = paramVarArgs;
            if (!QLog.isColorLevel()) {
              break;
            }
            parambegz = paramVarArgs;
            QLog.d("QZoneWebViewJsHandleLogic", 1, "weishi schema is " + paramVarArgs);
            return;
            label177:
            parambegz = paramVarArgs;
            a(localActivity);
          }
          a(localActivity);
        }
        catch (Exception paramVarArgs)
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, "handleClickWeiShiWidget catch an exception. weishi schema is " + parambegz, paramVarArgs);
          return;
        }
      }
    }
  }
  
  private static void f(begz parambegz, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (new JSONObject(paramVarArgs[0]).getInt("height") <= 0)
          {
            if (!(parambegz.a().getParent() instanceof RelativeLayout)) {
              continue;
            }
            ((RelativeLayout)parambegz.a().getParent()).setVisibility(8);
          }
        }
        catch (JSONException parambegz)
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, parambegz, new Object[0]);
          return;
        }
      }
    } while (!(parambegz.a().getParent() instanceof RelativeLayout));
    ((RelativeLayout)parambegz.a().getParent()).setVisibility(0);
  }
  
  private static void g(begz parambegz, String... paramVarArgs)
  {
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
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("birthdays");
          String str = ((JSONObject)localObject).getString("giftmessage");
          int j = ((JSONObject)localObject).optInt("giftid");
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0) && (localJSONArray != null) && (localJSONArray.length() == paramVarArgs.length()))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(parambegz.a(), 2, 2131689601, 0).a();
            }
            localObject = new long[paramVarArgs.length()];
            long[] arrayOfLong = new long[localJSONArray.length()];
            int i = 0;
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              arrayOfLong[i] = localJSONArray.getLong(i);
              i += 1;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("key_msg_type", 2);
            localIntent.putExtra("key_friend_list", (long[])localObject);
            localIntent.putExtra("key_time_list", arrayOfLong);
            localIntent.putExtra("key_msg_content", str);
            localIntent.putExtra("key_gift_id", j);
            parambegz.a().setResult(-1, localIntent);
            parambegz.a().finish();
            if (QLog.isColorLevel())
            {
              QLog.d("QZoneWebViewJsHandleLogic", 2, "the giftid is " + j + "\n the giftmessage is" + str + "\n the uins are: " + paramVarArgs.toString() + "\n the birthdays are: " + localJSONArray.toString());
              return;
            }
          }
        }
      }
      catch (JSONException parambegz)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, parambegz, new Object[0]);
      }
    }
  }
  
  private static void h(begz parambegz, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      LocalMultiProcConfig.putString("BirthdayGiftSendSuccessList", new JSONObject(paramVarArgs[0]).optString("uins"));
      return;
    }
    catch (JSONException parambegz)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, parambegz, new Object[0]);
    }
  }
  
  private static void i(begz parambegz, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).getString("packName");
        Object localObject1 = ((JSONObject)localObject2).getString("taskAppId");
        String str1 = ((JSONObject)localObject2).getString("appId");
        String str2 = ((JSONObject)localObject2).getString("taskApkId");
        String str3 = ((JSONObject)localObject2).getString("via");
        String str4 = ((JSONObject)localObject2).getString("versionCode");
        String str5 = ((JSONObject)localObject2).getString("channel");
        localObject2 = ((JSONObject)localObject2).getString("from");
        int j = 3;
        int i = j;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            i = Integer.parseInt((String)localObject2);
          }
          localObject2 = new StringBuilder();
          if (!TextUtils.isEmpty(str1)) {
            ((StringBuilder)localObject2).append(bfoh.b).append("=").append(str1);
          }
          if (!TextUtils.isEmpty(paramVarArgs)) {
            ((StringBuilder)localObject2).append("&").append(bfoh.f).append("=").append(paramVarArgs);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((StringBuilder)localObject2).append("&").append(bfoh.c).append("=").append((String)localObject1);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((StringBuilder)localObject2).append("&").append(bfoh.d).append("=").append(str2);
          }
          if (!TextUtils.isEmpty(str3)) {
            ((StringBuilder)localObject2).append("&").append(bfoh.i).append("=").append(str3);
          }
          if (!TextUtils.isEmpty(str4)) {
            ((StringBuilder)localObject2).append("&").append(bfoh.e).append("=").append(str4);
          }
          if (!TextUtils.isEmpty(str5)) {
            ((StringBuilder)localObject2).append("&").append(bfoh.B).append("=").append(str5);
          }
          paramVarArgs = ((StringBuilder)localObject2).toString();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("from", i);
          ((Bundle)localObject1).putString("schemaUrl", paramVarArgs);
          bjdt.a((Bundle)localObject1);
          bfir.a(parambegz.a(), (Bundle)localObject1);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.e("QZoneWebViewJsHandleLogic", 2, "from 错误", localNumberFormatException);
              i = j;
            }
          }
        }
        return;
      }
      catch (JSONException parambegz)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneWebViewJsHandleLogic", 2, "json 解析异常", parambegz);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxh
 * JD-Core Version:    0.7.0.1
 */