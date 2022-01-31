import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.jsp.QQApiPlugin.1;
import com.tencent.mobileqq.jsp.QQApiPlugin.2;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;
import com.tencent.mobileqq.jsp.QQApiPlugin.4;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class atid
  extends WebViewPlugin
{
  public Context a;
  belh jdField_a_of_type_Belh = null;
  beln jdField_a_of_type_Beln = null;
  belp jdField_a_of_type_Belp = null;
  belq jdField_a_of_type_Belq = null;
  belt jdField_a_of_type_Belt = null;
  public bety a;
  public bfah a;
  String jdField_a_of_type_JavaLangString;
  public osn a;
  public yqz a;
  String b;
  public String c;
  
  public atid()
  {
    this.jdField_a_of_type_Yqz = null;
    this.mPluginNameSpace = "QQApi";
  }
  
  Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public String a(String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_Beln != null)
    {
      paramString = this.jdField_a_of_type_Beln.b(paramString);
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("gamecenter", 2, "<--getOpenidBatch result=" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bety == null)
    {
      if (this.jdField_a_of_type_Belp != null) {
        this.jdField_a_of_type_Bety = this.jdField_a_of_type_Belp.a().a();
      }
    }
    else {
      return;
    }
    begg localbegg = this.mRuntime.a(this.mRuntime.a());
    if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
    {
      if ((paramActivity instanceof belp))
      {
        this.jdField_a_of_type_Bety = ((belp)paramActivity).a().a();
        return;
      }
      this.jdField_a_of_type_Bety = new bety(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if ((localbegg instanceof belp))
    {
      this.jdField_a_of_type_Bety = ((belp)localbegg).a().a();
      return;
    }
    this.jdField_a_of_type_Bety = new bety(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298914));
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("appID");
      String str1 = ((JSONObject)localObject).optString("paramsStr");
      String str2 = ((JSONObject)localObject).optString("packageName");
      String str3 = ((JSONObject)localObject).optString("flags");
      String str4 = ((JSONObject)localObject).optString("type");
      localObject = ((JSONObject)localObject).optString("subappid");
      a(paramString, str1, str2, str3, str4, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("launchAppWithTokens", 2, "parse params error");
      }
      paramString.printStackTrace();
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = this.mRuntime.a();
    if (this.jdField_a_of_type_Bety == null) {
      a(paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
      }
      QQToast.a(BaseApplication.getContext(), 0, 2131720031, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131720031, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
          paramString1.printStackTrace();
          if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
            this.jdField_a_of_type_Bety.dismiss();
          }
        }
      }
      finally
      {
        if ((this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {
          break;
        }
        this.jdField_a_of_type_Bety.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareMsgToSina end!");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToQidianOrQiye start: " + paramInt);
    }
    Activity localActivity = this.mRuntime.a();
    if (this.jdField_a_of_type_Bety == null) {
      a(localActivity);
    }
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
    bfyh.a(localActivity, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "launchAppWithTokens " + paramString3);
    }
    ayyy localayyy = new ayyy();
    Object localObject;
    if ((this.jdField_a_of_type_Belh != null) || ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForTool))) {
      localObject = this.mRuntime.a();
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
          localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
        }
      }
      else
      {
        int j = 268435456;
        try
        {
          k = Integer.parseInt(paramString4);
          if ((0x4000000 & k) == 67108864) {
            j = 335544320;
          }
          i = j;
          if ((0x20000000 & k) == 536870912) {
            i = j | 0x20000000;
          }
          j = i;
          if ((k & 0x400000) == 4194304) {
            j = i | 0x400000;
          }
          i = j;
        }
        catch (Exception paramString4)
        {
          int i;
          for (;;)
          {
            int k;
            String str;
            i = 268435456;
            continue;
            paramString2 = paramString4;
            if (QLog.isColorLevel())
            {
              QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
              paramString2 = paramString4;
            }
          }
          localayyy.a((AppInterface)localObject, this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, paramString3, i);
          return;
        }
        azqs.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
        k = 0;
        str = "tencentwtlogin" + paramString1 + "://";
        j = k;
        if ("wtlogin".equals(paramString5))
        {
          paramString4 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
          paramString5 = new Intent("android.intent.action.VIEW");
          paramString5.setData(Uri.parse(str));
          j = k;
          if (paramString4 != null)
          {
            j = k;
            if (paramString4.queryIntentActivities(paramString5, 0).size() > 0) {
              j = 1;
            }
          }
        }
        if (j != 0)
        {
          paramString4 = "";
          if ((this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            paramString2 = this.mRuntime.a().getUrl();
            localayyy.a(str, this.jdField_a_of_type_AndroidContentContext, paramString2, (AppInterface)localObject, paramString1, paramString3, i, paramString6);
            return;
          }
        }
      }
      localObject = null;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "dialog get web js time :" + l);
    }
    this.jdField_a_of_type_JavaLangString = null;
    for (;;)
    {
      JSONObject localJSONObject;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str8;
      String str9;
      int k;
      String str14;
      try
      {
        localJSONObject = new JSONObject(paramString);
        Activity localActivity = this.mRuntime.a();
        if (!paramBoolean) {
          break label839;
        }
        paramString = "shareType";
        str1 = localJSONObject.optString(paramString, "0");
        str2 = localJSONObject.optString("title");
        str3 = localJSONObject.optString("desc");
        if (!paramBoolean) {
          break label1164;
        }
        paramString = "shareUrl";
        str4 = localJSONObject.optString(paramString);
        if (!paramBoolean) {
          break label1171;
        }
        paramString = "imageUrl";
        paramString = localJSONObject.optString(paramString);
        str5 = localJSONObject.optString("shareElement");
        str6 = localJSONObject.optString("flash_url");
        str7 = localJSONObject.optString("article_id");
        str8 = localJSONObject.optString("rowkey");
        str9 = localJSONObject.optString("isfan");
        k = localJSONObject.optInt("WXShareFromQQKandian");
        String str10 = localJSONObject.optString("short_video_vid");
        String str11 = localJSONObject.optString("short_video_url");
        String str12 = localJSONObject.optString("short_video_cover_url");
        String str13 = localJSONObject.optString("short_video_theme_name");
        str14 = localJSONObject.optString("is_tribe_short_video");
        i = 0;
        if (TextUtils.isEmpty(paramString)) {
          i = 1;
        }
        j = i;
        if (TextUtils.isEmpty(str3)) {
          j = i | 0x2;
        }
        if (!TextUtils.isEmpty(str2)) {
          break label1158;
        }
        i = j | 0x4;
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "102");
        ((Bundle)localObject).putString("act_type", "94");
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (i != 0) {
          break label1178;
        }
        j = 0;
        ((Bundle)localObject).putString("intext_1", j);
        ((Bundle)localObject).putString("intext_2", "" + i);
        ((Bundle)localObject).putString("stringext_1", "" + str4);
        bfhz.a().a((Bundle)localObject, "", this.mRuntime.a().getAccount(), false);
        i = localJSONObject.optInt("shareQQType", 13);
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString("callback");
        paramBoolean = localJSONObject.optBoolean("keepShareUrl", false);
        localObject = new HashMap();
        if ((!paramBoolean) && (str4 != null) && (str4.length() > 140) && (!"3".equals(str1))) {
          ((HashMap)localObject).put("share_url", str4);
        }
        if ((paramString != null) && (paramString.length() > 80) && (!"2".equals(str1)) && (!"3".equals(str1)) && (!"4".equals(str1))) {
          ((HashMap)localObject).put("image_url", paramString);
        }
        if ((str6 != null) && (str6.length() > 30)) {
          ((HashMap)localObject).put("flash_url", str6);
        }
        if (!TextUtils.isEmpty(str10)) {
          ((HashMap)localObject).put("short_video_vid", str10);
        }
        if (!TextUtils.isEmpty(str12)) {
          ((HashMap)localObject).put("short_video_cover_url", str12);
        }
        if (!TextUtils.isEmpty(str11)) {
          ((HashMap)localObject).put("short_video_url", str11);
        }
        if (!TextUtils.isEmpty(str13)) {
          ((HashMap)localObject).put("short_video_theme_name", str11);
        }
        if (!TextUtils.isEmpty(str14)) {
          ((HashMap)localObject).put("is_tribe_short_video", str14);
        }
        if ((((HashMap)localObject).isEmpty()) || ("1".equals(str1))) {
          break label846;
        }
        if (this.jdField_a_of_type_Bety == null) {
          a(localActivity);
        }
        if (!this.jdField_a_of_type_Bety.isShowing())
        {
          this.jdField_a_of_type_Bety.c(2131694219);
          this.jdField_a_of_type_Bety.show();
        }
        ThreadManager.post(new QQApiPlugin.1(this, (HashMap)localObject, str4, paramString, str6, str1, localJSONObject, str2, str3, str5, str7, str8, str9, k, str14, i, localActivity), 8, null, true);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQApi", 2, "shareMsg error: " + paramString.toString());
      return;
      label839:
      paramString = "share_type";
      continue;
      label846:
      if ("1".equals(str1))
      {
        a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6);
        syb.a(1002, str4, str7, str8, str9);
        return;
      }
      if (("2".equals(str1)) || ("3".equals(str1)))
      {
        a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, k);
        if ("2".equals(str1)) {
          syb.a(1003, str4, str7, str8, str9);
        }
        if (!"3".equals(str1)) {
          break;
        }
        syb.a(1004, str4, str7, str8, str9);
        return;
      }
      if ("4".equals(str1))
      {
        b(str2, str3, str4, paramString);
        syb.a(1005, str4, str7, str8, str9);
        return;
      }
      if ("5".equals(str1))
      {
        a(str2, str3, str4, paramString, 6);
        return;
      }
      if ("6".equals(str1))
      {
        a(str2, str3, str4, paramString, 7);
        return;
      }
      if ((!TextUtils.isEmpty(str14)) && (localJSONObject.has("is_tribe_short_video")) && (str14.equals("true")))
      {
        b(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, i);
        return;
      }
      c(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, i);
      syb.a(1001, str4, str7, str8, str9);
      return;
      label1158:
      int i = j;
      continue;
      label1164:
      paramString = "share_url";
      continue;
      label1171:
      paramString = "image_url";
      continue;
      label1178:
      int j = 1;
    }
  }
  
  /* Error */
  void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	atid:mRuntime	Lbegz;
    //   4: invokevirtual 344	begz:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7: invokevirtual 540	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 45	atid:mRuntime	Lbegz;
    //   15: invokevirtual 543	begz:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   18: getfield 548	com/tencent/mobileqq/webview/swift/WebViewFragment:g	Ljava/lang/String;
    //   21: astore_3
    //   22: aload_2
    //   23: invokevirtual 553	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	()Lmyl;
    //   26: aload_3
    //   27: ldc_w 555
    //   30: invokevirtual 560	myl:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   33: ifne +37 -> 70
    //   36: ldc 36
    //   38: iconst_1
    //   39: ldc_w 562
    //   42: invokestatic 565	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   49: ifnull +229 -> 278
    //   52: aload_0
    //   53: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   56: invokevirtual 188	bety:isShowing	()Z
    //   59: ifeq +219 -> 278
    //   62: aload_0
    //   63: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   66: invokevirtual 191	bety:dismiss	()V
    //   69: return
    //   70: aload_1
    //   71: ldc_w 567
    //   74: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_2
    //   78: aload_1
    //   79: ldc_w 571
    //   82: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_1
    //   87: ldc_w 573
    //   90: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 4
    //   95: aload_1
    //   96: ldc_w 384
    //   99: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 5
    //   104: aload_1
    //   105: ldc_w 575
    //   108: ldc_w 577
    //   111: invokevirtual 380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 6
    //   116: aload_1
    //   117: ldc_w 579
    //   120: ldc 58
    //   122: invokevirtual 380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore_1
    //   126: new 145	org/json/JSONObject
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 147	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   134: ldc 160
    //   136: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_1
    //   140: new 462	java/util/HashMap
    //   143: dup
    //   144: invokespecial 463	java/util/HashMap:<init>	()V
    //   147: astore 7
    //   149: aload 7
    //   151: ldc_w 575
    //   154: aload 6
    //   156: invokeinterface 582 3 0
    //   161: pop
    //   162: aload 7
    //   164: ldc 160
    //   166: aload_1
    //   167: invokeinterface 582 3 0
    //   172: pop
    //   173: aload 7
    //   175: ldc_w 384
    //   178: aload 5
    //   180: invokeinterface 582 3 0
    //   185: pop
    //   186: aload_0
    //   187: getfield 45	atid:mRuntime	Lbegz;
    //   190: invokevirtual 50	begz:a	()Landroid/app/Activity;
    //   193: astore_1
    //   194: aload_1
    //   195: ifnull +35 -> 230
    //   198: aload_1
    //   199: aload_2
    //   200: aload_3
    //   201: aload 4
    //   203: ldc 58
    //   205: aload_1
    //   206: invokevirtual 130	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   209: invokevirtual 586	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   212: getfield 592	android/util/DisplayMetrics:scaledDensity	F
    //   215: aload 7
    //   217: invokestatic 597	com/tencent/mobileqq/activity/ArkFullScreenAppActivity:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/util/Map;)Landroid/content/Intent;
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +8 -> 230
    //   225: aload_1
    //   226: aload_2
    //   227: invokestatic 602	aryv:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   230: aload_0
    //   231: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   234: ifnull +44 -> 278
    //   237: aload_0
    //   238: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   241: invokevirtual 188	bety:isShowing	()Z
    //   244: ifeq +34 -> 278
    //   247: aload_0
    //   248: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   251: invokevirtual 191	bety:dismiss	()V
    //   254: return
    //   255: astore_1
    //   256: ldc 36
    //   258: iconst_1
    //   259: ldc_w 604
    //   262: aload_1
    //   263: invokestatic 607	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: return
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 172	org/json/JSONException:printStackTrace	()V
    //   272: ldc 58
    //   274: astore_1
    //   275: goto -135 -> 140
    //   278: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	atid
    //   0	279	1	paramJSONObject	JSONObject
    //   10	217	2	localObject	Object
    //   21	180	3	str1	String
    //   93	109	4	str2	String
    //   102	77	5	str3	String
    //   114	41	6	str4	String
    //   147	69	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   0	69	255	java/lang/Exception
    //   70	126	255	java/lang/Exception
    //   126	140	255	java/lang/Exception
    //   140	194	255	java/lang/Exception
    //   198	221	255	java/lang/Exception
    //   225	230	255	java/lang/Exception
    //   230	254	255	java/lang/Exception
    //   268	272	255	java/lang/Exception
    //   126	140	267	org/json/JSONException
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = this.mRuntime.a();
    if (this.jdField_a_of_type_Bety == null) {
      a(paramString1);
    }
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
    paramString6 = new Bundle();
    paramString6.putString("title", paramString2);
    paramString6.putString("desc", paramString3);
    paramString6.putString("detail_url", paramString4);
    paramString6.putString("from", "qq");
    if (paramJSONObject != null) {
      paramString6.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(paramString5);
    paramString6.putStringArrayList("image_url", paramJSONObject);
    paramString6.putLong("req_share_id", 0L);
    paramString6.putInt("iUrlInfoFrm", 1);
    paramString6.putLong("share_begin_time", beir.b);
    if ((this.jdField_a_of_type_Belq != null) && (this.jdField_a_of_type_Belt != null))
    {
      paramString6.putString("strurt_msgid", this.jdField_a_of_type_Belq.g());
      paramString6.putString("struct_uin", this.jdField_a_of_type_Belq.h());
      paramString6.putString("struct_url", this.jdField_a_of_type_Belt.b());
      paramString6.putBoolean("from_web", true);
      if ((this.jdField_a_of_type_Belq.i() != null) && (!"".equals(this.jdField_a_of_type_Belq.i()))) {
        paramString6.putString("source_puin", this.jdField_a_of_type_Belq.i());
      }
    }
    if (this.jdField_a_of_type_Belh != null) {}
    for (int i = this.jdField_a_of_type_Belh.a(this, (byte)1, true);; i = 1)
    {
      if (paramString1.getIntent().getBooleanExtra("confess_half_screen_web", false)) {
        i = 15001;
      }
      if (!bjev.a(this.mRuntime.a(), a(), paramString6, null, i)) {
        break;
      }
      return;
    }
    ybk.a(1, 2131689512);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { "false" });
      return;
    }
    callJs4OpenApiIfNeeded("shareMsg", 0, "false");
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramJSONObject = this.mRuntime.a();
    int i = -1;
    if (!WXShareHelper.a().a()) {
      i = 2131721491;
    }
    while (i != -1)
    {
      ybk.a(0, i);
      if (this.jdField_a_of_type_Bety == null) {
        a(paramJSONObject);
      }
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
      }
      return;
      if (!WXShareHelper.a().b()) {
        i = 2131721492;
      }
    }
    HashMap localHashMap = new HashMap(1);
    paramString2 = new QQApiPlugin.3(this, paramString1, paramString4, paramInt, localHashMap, paramString6, paramString2, paramString3, paramString7);
    if (TextUtils.isEmpty(paramString5))
    {
      paramString2.run();
      return;
    }
    if (this.jdField_a_of_type_Bety == null) {
      a(paramJSONObject);
    }
    if (!this.jdField_a_of_type_Bety.isShowing())
    {
      this.jdField_a_of_type_Bety.c(2131694219);
      this.jdField_a_of_type_Bety.show();
    }
    ThreadManager.post(new QQApiPlugin.4(this, paramString5, localHashMap, paramString2, paramString1, paramString4), 8, null, false);
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_Belp != null) && (this.jdField_a_of_type_Belp.a(paramString));
  }
  
  public void b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      paramString = (beie)super.getBrowserComponent(32);
      if (paramString != null)
      {
        Message localMessage = paramString.a.obtainMessage(0, i, 0);
        paramString.a.sendMessage(localMessage);
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina start!");
    }
    try
    {
      localObject = Uri.parse(paramString3);
      if (localObject != null)
      {
        localObject = ((Uri)localObject).getHost();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("article.mp.qq.com".equalsIgnoreCase((String)localObject)) || ("post.mp.qq.com".equalsIgnoreCase((String)localObject))))
        {
          a(paramString1, paramString2, paramString3, paramString4);
          return;
        }
      }
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString2 = this.mRuntime.a();
        if (this.jdField_a_of_type_Bety == null) {
          a(paramString2);
        }
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "shareMsgToSina empty title or share_url");
          }
          if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
            this.jdField_a_of_type_Bety.dismiss();
          }
          QQToast.a(BaseApplication.getContext(), 0, 2131720031, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
          return;
        }
        Object localObject = BaseApplicationImpl.getContext().getPackageManager();
        try
        {
          localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "shareMsgToSina installSinaWeibo:true");
          }
          ThreadManager.executeOnSubThread(new QQApiPlugin.2(this, paramString4, paramString1, paramString3, paramString2, (ApplicationInfo)localObject));
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label257;
            }
            QLog.d("QQApi", 2, "shareMsgToSina installSinaWeibo:false");
            try
            {
              paramString1 = URLEncoder.encode(paramString1, "UTF-8");
              paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
              paramString3 = URLEncoder.encode(paramString3, "UTF-8");
              paramString1 = paramString1 + "&url=" + paramString3;
              paramString3 = URLEncoder.encode(paramString4, "UTF-8");
              paramString1 = paramString1 + "&pic=" + paramString3;
              paramString1 = paramString1 + "&_wv=3";
              paramString3 = new Intent(paramString2, QQBrowserActivity.class);
              paramString3.putExtra("url", paramString1);
              paramString2.startActivity(paramString3);
              if (!QLog.isColorLevel()) {
                break label410;
              }
              QLog.d("QQApi", 2, "shareMsgToSina start webview!");
              if ((this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {
                continue;
              }
              this.jdField_a_of_type_Bety.dismiss();
            }
            catch (Exception paramString1)
            {
              QQToast.a(BaseApplication.getContext(), 0, 2131720031, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
              paramString1.printStackTrace();
              if ((this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {
                continue;
              }
              this.jdField_a_of_type_Bety.dismiss();
            }
            finally
            {
              if ((this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {
                break label519;
              }
              this.jdField_a_of_type_Bety.dismiss();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQApi", 2, "shareMsgToSina end!");
      return;
    }
  }
  
  /* Error */
  public void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	atid:mRuntime	Lbegz;
    //   4: invokevirtual 50	begz:a	()Landroid/app/Activity;
    //   7: astore 19
    //   9: new 229	android/content/Intent
    //   12: dup
    //   13: invokespecial 797	android/content/Intent:<init>	()V
    //   16: astore 18
    //   18: aload_1
    //   19: ldc_w 799
    //   22: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: aload_1
    //   27: ldc_w 801
    //   30: iconst_0
    //   31: invokevirtual 452	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   34: istore 10
    //   36: aload_2
    //   37: ifnull +997 -> 1034
    //   40: aload_2
    //   41: invokevirtual 466	java/lang/String:length	()I
    //   44: iconst_5
    //   45: if_icmplt +989 -> 1034
    //   48: aload 18
    //   50: aload_0
    //   51: getfield 267	atid:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   54: ldc_w 803
    //   57: invokevirtual 807	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   60: pop
    //   61: aload 18
    //   63: ldc_w 799
    //   66: aload_2
    //   67: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   70: pop
    //   71: aload 18
    //   73: ldc_w 801
    //   76: iload 10
    //   78: invokevirtual 810	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   81: pop
    //   82: aload 18
    //   84: ldc_w 812
    //   87: iconst_1
    //   88: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   91: pop
    //   92: aload_3
    //   93: astore 6
    //   95: aload_3
    //   96: ifnull +43 -> 139
    //   99: aload_3
    //   100: astore 6
    //   102: aload_3
    //   103: invokevirtual 466	java/lang/String:length	()I
    //   106: bipush 45
    //   108: if_icmple +31 -> 139
    //   111: new 72	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   118: aload_3
    //   119: iconst_0
    //   120: bipush 45
    //   122: invokevirtual 819	java/lang/String:substring	(II)Ljava/lang/String;
    //   125: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 821
    //   131: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 6
    //   139: iload 9
    //   141: istore 10
    //   143: iload 9
    //   145: ifgt +7 -> 152
    //   148: bipush 13
    //   150: istore 10
    //   152: ldc 58
    //   154: astore_3
    //   155: ldc 58
    //   157: astore 4
    //   159: ldc 58
    //   161: astore_2
    //   162: ldc 58
    //   164: astore 7
    //   166: ldc 58
    //   168: astore 8
    //   170: ldc 58
    //   172: astore 15
    //   174: ldc 58
    //   176: astore 17
    //   178: aload_1
    //   179: ldc_w 413
    //   182: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   185: ifeq +905 -> 1090
    //   188: aload_1
    //   189: ldc_w 413
    //   192: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: ldc_w 531
    //   198: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +889 -> 1090
    //   204: iconst_0
    //   205: istore 9
    //   207: iconst_0
    //   208: istore 11
    //   210: aload_1
    //   211: ldc_w 823
    //   214: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   217: ifeq +11 -> 228
    //   220: aload_1
    //   221: ldc_w 823
    //   224: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore_3
    //   228: aload_1
    //   229: ldc_w 825
    //   232: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   235: ifeq +12 -> 247
    //   238: aload_1
    //   239: ldc_w 825
    //   242: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 4
    //   247: aload_1
    //   248: ldc_w 827
    //   251: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   254: ifeq +12 -> 266
    //   257: aload_1
    //   258: ldc_w 827
    //   261: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: astore 7
    //   266: aload_1
    //   267: ldc_w 829
    //   270: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   273: ifeq +11 -> 284
    //   276: aload_1
    //   277: ldc_w 829
    //   280: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   283: astore_2
    //   284: aload_1
    //   285: ldc_w 831
    //   288: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   291: ifeq +12 -> 303
    //   294: aload_1
    //   295: ldc_w 831
    //   298: invokevirtual 834	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   301: istore 9
    //   303: aload_1
    //   304: ldc_w 836
    //   307: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   310: ifeq +12 -> 322
    //   313: aload_1
    //   314: ldc_w 836
    //   317: invokevirtual 834	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   320: istore 11
    //   322: aload_1
    //   323: ldc_w 838
    //   326: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   329: ifeq +12 -> 341
    //   332: aload_1
    //   333: ldc_w 838
    //   336: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   339: astore 8
    //   341: aload_1
    //   342: ldc_w 840
    //   345: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   348: ifeq +12 -> 360
    //   351: aload_1
    //   352: ldc_w 840
    //   355: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   358: astore 15
    //   360: aload_1
    //   361: ldc_w 842
    //   364: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   367: ifeq +12 -> 379
    //   370: aload_1
    //   371: ldc_w 842
    //   374: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   377: astore 17
    //   379: aload 18
    //   381: ldc_w 844
    //   384: bipush 36
    //   386: invokevirtual 810	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   389: pop
    //   390: new 145	org/json/JSONObject
    //   393: dup
    //   394: invokespecial 845	org/json/JSONObject:<init>	()V
    //   397: astore 16
    //   399: aload 16
    //   401: ldc_w 413
    //   404: iconst_1
    //   405: invokevirtual 848	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload 16
    //   411: ldc_w 838
    //   414: aload 8
    //   416: invokevirtual 851	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 16
    //   422: ldc_w 823
    //   425: aload_3
    //   426: invokevirtual 851	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 16
    //   432: ldc_w 825
    //   435: aload 4
    //   437: invokevirtual 851	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   440: pop
    //   441: aload 16
    //   443: ldc_w 827
    //   446: aload 7
    //   448: invokevirtual 851	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   451: pop
    //   452: aload 16
    //   454: ldc_w 831
    //   457: iload 9
    //   459: invokevirtual 848	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   462: pop
    //   463: aload 16
    //   465: ldc_w 836
    //   468: iload 11
    //   470: invokevirtual 848	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   473: pop
    //   474: aload 16
    //   476: ldc_w 840
    //   479: aload 15
    //   481: invokevirtual 851	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   484: pop
    //   485: aload 16
    //   487: ldc_w 842
    //   490: aload 17
    //   492: invokevirtual 851	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   495: pop
    //   496: aload 18
    //   498: ldc_w 853
    //   501: aload 16
    //   503: invokevirtual 854	org/json/JSONObject:toString	()Ljava/lang/String;
    //   506: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   509: pop
    //   510: aload 16
    //   512: astore 4
    //   514: aload 4
    //   516: astore 7
    //   518: aload 18
    //   520: ldc_w 856
    //   523: ldc_w 858
    //   526: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   529: pop
    //   530: aload 18
    //   532: ldc_w 382
    //   535: aload 6
    //   537: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   540: pop
    //   541: aload 18
    //   543: ldc_w 449
    //   546: iload 10
    //   548: invokevirtual 810	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   551: pop
    //   552: aload 18
    //   554: ldc_w 844
    //   557: bipush 36
    //   559: invokevirtual 810	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   562: pop
    //   563: aload 18
    //   565: ldc_w 628
    //   568: aload_1
    //   569: ldc_w 860
    //   572: ldc2_w 861
    //   575: invokevirtual 866	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   578: invokevirtual 869	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   581: pop
    //   582: aload 18
    //   584: ldc_w 871
    //   587: ldc_w 873
    //   590: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   593: pop
    //   594: aload 18
    //   596: ldc_w 875
    //   599: aload_2
    //   600: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   603: pop
    //   604: aload 18
    //   606: ldc_w 877
    //   609: aload_1
    //   610: ldc_w 384
    //   613: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   616: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   619: pop
    //   620: aload 18
    //   622: ldc_w 879
    //   625: aload_1
    //   626: ldc_w 879
    //   629: iconst_0
    //   630: invokevirtual 452	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   633: invokevirtual 810	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   636: pop
    //   637: aload 18
    //   639: ldc_w 609
    //   642: aload 5
    //   644: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   647: pop
    //   648: aload 18
    //   650: ldc_w 881
    //   653: bipush 118
    //   655: invokevirtual 810	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   658: pop
    //   659: aload 18
    //   661: ldc_w 883
    //   664: invokestatic 889	mqq/app/MobileQQ:getMobileQQ	()Lmqq/app/MobileQQ;
    //   667: invokevirtual 892	mqq/app/MobileQQ:getQQProcessName	()Ljava/lang/String;
    //   670: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   673: pop
    //   674: aload_1
    //   675: ldc_w 894
    //   678: iconst_0
    //   679: invokevirtual 460	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   682: istore 12
    //   684: aload_1
    //   685: ldc_w 896
    //   688: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   691: ifeq +12 -> 703
    //   694: aload_1
    //   695: ldc_w 896
    //   698: invokevirtual 899	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   701: istore 12
    //   703: aload 18
    //   705: ldc_w 896
    //   708: iload 12
    //   710: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   713: pop
    //   714: aload_0
    //   715: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   718: ifnonnull +9 -> 727
    //   721: aload_0
    //   722: aload 19
    //   724: invokevirtual 177	atid:a	(Landroid/app/Activity;)V
    //   727: aload_0
    //   728: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   731: ifnull +58 -> 789
    //   734: aload_0
    //   735: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   738: invokevirtual 188	bety:isShowing	()Z
    //   741: ifeq +48 -> 789
    //   744: invokestatic 367	java/lang/System:currentTimeMillis	()J
    //   747: lstore 13
    //   749: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +30 -> 782
    //   755: ldc 36
    //   757: iconst_2
    //   758: new 72	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 901
    //   768: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: lload 13
    //   773: invokevirtual 372	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   776: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: aload_0
    //   783: getfield 90	atid:jdField_a_of_type_Bety	Lbety;
    //   786: invokevirtual 191	bety:dismiss	()V
    //   789: aload_1
    //   790: ldc_w 903
    //   793: aconst_null
    //   794: invokevirtual 380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   797: astore_2
    //   798: aload_2
    //   799: ifnonnull +381 -> 1180
    //   802: aload_1
    //   803: ldc_w 905
    //   806: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   809: astore_2
    //   810: aload_2
    //   811: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   814: ifne +219 -> 1033
    //   817: aload_0
    //   818: getfield 45	atid:mRuntime	Lbegz;
    //   821: invokevirtual 272	begz:a	()Lcom/tencent/common/app/AppInterface;
    //   824: aload_0
    //   825: getfield 45	atid:mRuntime	Lbegz;
    //   828: invokevirtual 272	begz:a	()Lcom/tencent/common/app/AppInterface;
    //   831: invokevirtual 444	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   834: invokevirtual 909	com/tencent/common/app/AppInterface:getEntityManagerFactory	(Ljava/lang/String;)Lawgg;
    //   837: invokevirtual 915	awgg:createEntityManager	()Lawgf;
    //   840: astore_3
    //   841: aload_3
    //   842: ldc_w 917
    //   845: aload_2
    //   846: invokevirtual 922	awgf:a	(Ljava/lang/Class;Ljava/lang/String;)Lawge;
    //   849: checkcast 917	com/tencent/mobileqq/data/AccountDetail
    //   852: astore 4
    //   854: aload_3
    //   855: invokevirtual 924	awgf:a	()V
    //   858: aload 4
    //   860: ifnull +314 -> 1174
    //   863: aload 4
    //   865: getfield 927	com/tencent/mobileqq/data/AccountDetail:name	Ljava/lang/String;
    //   868: astore 4
    //   870: aload 4
    //   872: astore_3
    //   873: aload 4
    //   875: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   878: ifeq +24 -> 902
    //   881: aload 4
    //   883: astore_3
    //   884: aload_1
    //   885: ldc_w 929
    //   888: invokevirtual 529	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   891: ifeq +11 -> 902
    //   894: aload_1
    //   895: ldc_w 929
    //   898: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   901: astore_3
    //   902: aload_3
    //   903: astore 4
    //   905: aload_3
    //   906: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   909: ifeq +6 -> 915
    //   912: aload_2
    //   913: astore 4
    //   915: aload 18
    //   917: ldc_w 931
    //   920: aload_1
    //   921: ldc_w 931
    //   924: ldc 58
    //   926: invokevirtual 380	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   929: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   932: pop
    //   933: aload 18
    //   935: ldc_w 933
    //   938: ldc_w 935
    //   941: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   944: pop
    //   945: aload 18
    //   947: ldc_w 672
    //   950: aload_2
    //   951: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   954: pop
    //   955: aload 18
    //   957: ldc_w 937
    //   960: aload 4
    //   962: invokevirtual 240	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   965: pop
    //   966: aload 18
    //   968: ldc_w 881
    //   971: bipush 118
    //   973: invokevirtual 810	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   976: pop
    //   977: aload 18
    //   979: invokevirtual 941	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   982: invokestatic 946	azvd:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   985: astore_1
    //   986: aload_1
    //   987: ifnonnull +136 -> 1123
    //   990: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   993: ifeq +12 -> 1005
    //   996: ldc 36
    //   998: iconst_2
    //   999: ldc_w 948
    //   1002: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: aload_0
    //   1006: getfield 374	atid:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1009: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1012: ifne +99 -> 1111
    //   1015: aload_0
    //   1016: aload_0
    //   1017: getfield 374	atid:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1020: iconst_1
    //   1021: anewarray 118	java/lang/String
    //   1024: dup
    //   1025: iconst_0
    //   1026: ldc_w 701
    //   1029: aastore
    //   1030: invokevirtual 705	atid:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1033: return
    //   1034: aload 18
    //   1036: ldc_w 950
    //   1039: iconst_1
    //   1040: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1043: pop
    //   1044: aload 18
    //   1046: aload_0
    //   1047: getfield 267	atid:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1050: ldc_w 952
    //   1053: invokevirtual 807	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1056: pop
    //   1057: goto -975 -> 82
    //   1060: astore 7
    //   1062: aconst_null
    //   1063: astore_3
    //   1064: aload_3
    //   1065: astore 4
    //   1067: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1070: ifeq -556 -> 514
    //   1073: ldc 36
    //   1075: iconst_2
    //   1076: aload 7
    //   1078: invokestatic 956	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1081: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: aload_3
    //   1085: astore 4
    //   1087: goto -573 -> 514
    //   1090: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1093: ifeq +12 -> 1105
    //   1096: ldc 36
    //   1098: iconst_2
    //   1099: ldc_w 958
    //   1102: invokestatic 961	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1105: aconst_null
    //   1106: astore 7
    //   1108: goto -590 -> 518
    //   1111: aload_0
    //   1112: ldc_w 707
    //   1115: iconst_0
    //   1116: ldc_w 701
    //   1119: invokevirtual 710	atid:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: return
    //   1123: aload_1
    //   1124: bipush 118
    //   1126: putfield 967	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1129: aload_1
    //   1130: aload 7
    //   1132: invokevirtual 854	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1135: putfield 970	com/tencent/mobileqq/structmsg/AbsStructMsg:mTribeShortVideoExtra	Ljava/lang/String;
    //   1138: aload_1
    //   1139: invokestatic 975	com/tencent/mobileqq/data/MessageForTribeShortVideo:buildCompatibleText	()Ljava/lang/String;
    //   1142: putfield 978	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   1145: aload 18
    //   1147: ldc_w 980
    //   1150: aload_1
    //   1151: invokevirtual 984	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1154: invokevirtual 987	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1157: pop
    //   1158: aload_0
    //   1159: aload 18
    //   1161: iconst_4
    //   1162: invokevirtual 991	atid:startActivityForResult	(Landroid/content/Intent;B)V
    //   1165: return
    //   1166: astore 7
    //   1168: aload 16
    //   1170: astore_3
    //   1171: goto -107 -> 1064
    //   1174: aconst_null
    //   1175: astore 4
    //   1177: goto -307 -> 870
    //   1180: goto -370 -> 810
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1183	0	this	atid
    //   0	1183	1	paramJSONObject	JSONObject
    //   0	1183	2	paramString1	String
    //   0	1183	3	paramString2	String
    //   0	1183	4	paramString3	String
    //   0	1183	5	paramString4	String
    //   0	1183	6	paramString5	String
    //   0	1183	7	paramString6	String
    //   0	1183	8	paramString7	String
    //   0	1183	9	paramInt	int
    //   34	513	10	i	int
    //   208	261	11	j	int
    //   682	27	12	bool	boolean
    //   747	25	13	l	long
    //   172	308	15	str1	String
    //   397	772	16	localJSONObject	JSONObject
    //   176	315	17	str2	String
    //   16	1144	18	localIntent	Intent
    //   7	716	19	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   390	399	1060	java/lang/Exception
    //   399	510	1166	java/lang/Exception
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "setShareInfo been called");
    }
    Bundle localBundle = new Bundle();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optString("title");
        String str1 = ((JSONObject)localObject1).optString("desc");
        String str2 = ((JSONObject)localObject1).optString("share_url");
        String str3 = ((JSONObject)localObject1).optString("image_url");
        localObject2 = ((JSONObject)localObject1).optString("type");
        String str4 = ((JSONObject)localObject1).optString("miniprogram_image_url");
        String str5 = ((JSONObject)localObject1).optString("cover_url");
        String str6 = ((JSONObject)localObject1).optString("source_name");
        String str7 = ((JSONObject)localObject1).optString("article_id");
        boolean bool1 = ((JSONObject)localObject1).optBoolean("editable", true);
        String str8 = ((JSONObject)localObject1).optString("policy");
        boolean bool2 = ((JSONObject)localObject1).optBoolean("isCreator", false);
        String str9 = ((JSONObject)localObject1).optString("singleLineTitle");
        boolean bool3 = ((JSONObject)localObject1).optBoolean("contentEdited");
        boolean bool4 = ((JSONObject)localObject1).optBoolean("isNewCreate");
        String str10 = ((JSONObject)localObject1).optString("groupCode");
        String str11 = ((JSONObject)localObject1).optString("domainId");
        String str12 = ((JSONObject)localObject1).optString("localPadId");
        if (!TextUtils.isEmpty(str5)) {
          localBundle.putString("cover_url", str5);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localBundle.putString("type", (String)localObject2);
        }
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("miniprogram_image_url", str4);
        }
        if (!TextUtils.isEmpty(str6)) {
          localBundle.putString("source_name", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
          localBundle.putString("article_id", str7);
        }
        if (!TextUtils.isEmpty(str9)) {
          localBundle.putString("singleLineTitle", str9);
        }
        localBundle.putBoolean("editable", bool1);
        localBundle.putBoolean("isCreator", bool2);
        if (!TextUtils.isEmpty(str8)) {
          localBundle.putString("policy", str8);
        }
        localBundle.putBoolean("contentEdited", bool3);
        localBundle.putBoolean("isNewCreate", bool4);
        if (!TextUtils.isEmpty(str10)) {
          localBundle.putString("groupCode", str10);
        }
        if (!TextUtils.isEmpty(str11)) {
          localBundle.putString("domainId", str11);
        }
        if (!TextUtils.isEmpty(str12)) {
          localBundle.putString("localPadId", str12);
        }
        localObject2 = this.mRuntime.a();
        if ((localObject2 != null) && ((localObject2 instanceof TeamWorkDocEditBrowserActivity)))
        {
          localObject1 = ((JSONObject)localObject1).optString("type");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (!"docx".equals(localObject1)) {
              break label573;
            }
            ((TeamWorkDocEditBrowserActivity)localObject2).a(1);
          }
        }
        localObject1 = this.mRuntime.a(this.mRuntime.a());
        if ((localObject1 == null) || (!(localObject1 instanceof belp))) {
          break;
        }
        localBundle.putInt("extra_url_info_from", 1);
        return ((belp)localObject1).a(paramString, str1, str2, str3, localBundle);
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "setShareInfo param error");
        }
        return false;
      }
      label573:
      if ("sheet".equals(localObject1)) {
        ((TeamWorkDocEditBrowserActivity)localObject2).a(2);
      }
    }
    return false;
  }
  
  public void c(String paramString)
  {
    this.b = null;
    for (;;)
    {
      Intent localIntent;
      try
      {
        if (this.jdField_a_of_type_Belp != null)
        {
          this.jdField_a_of_type_Bety = this.jdField_a_of_type_Belp.a().a();
          if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
            this.jdField_a_of_type_Bety.dismiss();
          }
        }
        localIntent = new Intent();
        Object localObject = new JSONObject(paramString);
        this.b = ((JSONObject)localObject).optString("callback");
        paramString = ((JSONObject)localObject).optString("appName");
        if (!myl.a().k(paramString))
        {
          if (TextUtils.isEmpty(this.b)) {
            break;
          }
          callJs(this.b, new String[] { "{\"result\":2}" });
          return;
        }
        String str1 = ((JSONObject)localObject).optString("toUin");
        int i = ((JSONObject)localObject).optInt("uinType", 0);
        String str2 = ((JSONObject)localObject).optString("toNickName");
        if ((str1 != null) && (str1.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str1);
          localIntent.putExtra("uinType", i);
          localIntent.putExtra("nickName", str2);
          localIntent.putExtra("shareQQType", ((JSONObject)localObject).optInt("shareQQType", 13));
          localIntent.putExtra("forward_type", 27);
          localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          localIntent.putExtra("k_back", ((JSONObject)localObject).optBoolean("k_back", ((JSONObject)localObject).optBoolean("back", false)));
          str1 = ((JSONObject)localObject).optString("appDesc");
          str2 = ((JSONObject)localObject).optString("appMinVersion");
          String str3 = ((JSONObject)localObject).optString("appView");
          String str4 = ((JSONObject)localObject).optString("appConfig");
          String str5 = ((JSONObject)localObject).optString("metaData");
          String str6 = ((JSONObject)localObject).optString("promptText");
          localObject = ((JSONObject)localObject).optString("compatibleText");
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str5)))
          {
            if (TextUtils.isEmpty(this.b)) {
              break label687;
            }
            callJs(this.b, new String[] { "{\"result\":1}" });
          }
          localIntent.putExtra("forward_ark_app_name", paramString);
          localIntent.putExtra("forward_ark_app_view", str3);
          localIntent.putExtra("forward_ark_app_desc", str1);
          localIntent.putExtra("forward_ark_app_ver", str2);
          localIntent.putExtra("forward_ark_app_prompt", str6);
          localIntent.putExtra("forward_ark_app_meta", str5);
          localIntent.putExtra("forward_ark_app_config", str4);
          localIntent.putExtra("forward_ark_app_compat", (String)localObject);
          localIntent.putExtra("is_ark_display_share", true);
          localIntent.putExtra("appName", paramString);
          localIntent.putExtra("appView", str3);
          localIntent.putExtra("appMinVersion", str2);
          localIntent.putExtra("metaData", str5);
          localIntent.putExtra("scale", this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
          if (!(this.jdField_a_of_type_AndroidContentContext instanceof QQBrowserActivity)) {
            break label701;
          }
          paramString = ((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).a();
          if (paramString != null)
          {
            paramString = paramString.b();
            if (!TextUtils.isEmpty(paramString)) {
              localIntent.putExtra("forward_ark_h5_from_js", paramString);
            }
          }
          startActivityForResult(localIntent, (byte)3);
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (!TextUtils.isEmpty(this.b)) {
          callJs(this.b, new String[] { "{\"result\":3}" });
        }
        QLog.e("QQApi", 1, "shareArkMsg error: " + paramString.toString());
        return;
      }
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      continue;
      label687:
      callJs4OpenApiIfNeeded("shareMsg", 0, "{\"result\":1}");
      continue;
      label701:
      if (this.mRuntime != null)
      {
        paramString = this.mRuntime.a();
        if (paramString != null)
        {
          paramString = paramString.g;
          if (!TextUtils.isEmpty(paramString)) {
            localIntent.putExtra("forward_ark_h5_from_js", paramString);
          }
        }
      }
    }
  }
  
  public void c(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    if ((paramJSONObject.has("isArkMessage")) && (paramJSONObject.getBoolean("isArkMessage")))
    {
      a(paramJSONObject);
      return;
    }
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent();
    String str = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    paramString1 = (beir)this.mRuntime.a().b().a(4);
    Bundle localBundle = paramString1.a();
    localIntent.putExtra("forward_source_business_type", 100500);
    int j;
    if (TextUtils.isEmpty(paramString1.e))
    {
      paramString1 = "";
      localIntent.putExtra("forward_source_sub_business_type", paramString1);
      if ((!TextUtils.isEmpty(str)) || (i != 0) || (localBundle == null) || (localBundle.isEmpty())) {
        break label2421;
      }
      str = localBundle.getString("to_qq");
      j = localBundle.getInt("to_uin_type");
      i = j;
      paramString1 = str;
      if (QLog.isColorLevel())
      {
        QLog.d("QQApi", 2, "shareMsgToQQ() called : toUin = " + str + ", uinType = " + j);
        paramString1 = str;
        i = j;
      }
    }
    for (;;)
    {
      str = paramJSONObject.optString("toNickName");
      j = paramJSONObject.optInt("isEncryptUin", 0);
      if ((paramString1 != null) && (paramString1.length() >= 5))
      {
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
        localIntent.putExtra("toUin", paramString1);
        localIntent.putExtra("uinType", i);
        if (j == 1)
        {
          localIntent.putExtra("isEncryptUin", j);
          localIntent.putExtra("vfwebqq", paramJSONObject.optString("vfwebqq"));
          localIntent.putExtra("tok", paramJSONObject.optString("tok"));
        }
        if ((TextUtils.isEmpty(str)) && (localBundle != null) && (!localBundle.isEmpty()))
        {
          paramString1 = localBundle.getString("to_uin_name");
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "shareMsgToQQ() called : nickName = " + paramString1);
          }
          localIntent.putExtra("nickName", paramString1);
        }
        label412:
        localIntent.putExtra("key_flag_from_plugin", true);
        paramString1 = this.mRuntime.a();
        if (paramString1 == null) {
          break label2413;
        }
        paramString1 = (beir)paramString1.a.a(4);
        if ((paramString1 == null) || (paramString1.a == null) || (!paramString1.a.a(localIntent))) {
          break label2413;
        }
      }
      label1212:
      label2262:
      label2397:
      label2399:
      label2405:
      label2413:
      for (i = 38;; i = 1001)
      {
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          paramString1 = paramString2;
          if (paramString2.length() > 45) {
            paramString1 = paramString2.substring(0, 45) + "…";
          }
        }
        paramString2 = paramString3;
        if (paramString3 != null)
        {
          paramString2 = paramString3;
          if (paramString3.length() > 60) {
            paramString2 = paramString3.substring(0, 60) + "…";
          }
        }
        j = paramInt;
        if (paramInt <= 0) {
          j = 13;
        }
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("title", paramString1);
        localIntent.putExtra("desc", paramString2);
        localIntent.putExtra("detail_url", paramString4);
        localIntent.putExtra("shareQQType", j);
        localIntent.putExtra("forward_type", i);
        localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
        localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
        localIntent.putExtra("image_url_remote", paramString5);
        localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696875, new Object[] { paramString1 }));
        localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
        if (paramJSONObject.has("contentAction")) {
          localIntent.putExtra("struct_share_key_content_action", paramJSONObject.getString("contentAction"));
        }
        if (paramJSONObject.has("actionData")) {
          localIntent.putExtra("struct_share_key_content_action_DATA", paramJSONObject.getString("actionData"));
        }
        if (paramJSONObject.has("sourceAction")) {
          localIntent.putExtra("struct_share_key_source_action", paramJSONObject.getString("sourceAction"));
        }
        if (paramJSONObject.has("isShareFlag")) {
          localIntent.putExtra("is_share_flag", Integer.parseInt(paramJSONObject.getString("isShareFlag")));
        }
        if (paramJSONObject.has("srcActionData")) {
          localIntent.putExtra("struct_share_key_source_action_data", paramJSONObject.getString("srcActionData"));
        }
        if (paramJSONObject.has("appName")) {
          localIntent.putExtra("app_name", paramJSONObject.getString("appName"));
        }
        if ("audio".equals(paramString6))
        {
          paramInt = 2;
          localIntent.putExtra("audio_url", paramString7);
        }
        boolean bool;
        long l;
        for (;;)
        {
          localIntent.putExtra("req_type", paramInt);
          if (paramJSONObject.has("report")) {
            localIntent.putExtra("report", paramJSONObject.getString("report"));
          }
          localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          bool = paramJSONObject.optBoolean("back", false);
          if (paramJSONObject.has("k_back")) {
            bool = paramJSONObject.getBoolean("k_back");
          }
          localIntent.putExtra("k_back", bool);
          if (paramJSONObject.has("serviceID")) {
            localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
          }
          if (paramJSONObject.has("serviceID"))
          {
            paramInt = paramJSONObject.getInt("serviceID");
            if ((paramInt == 116) || (paramInt == 123)) {
              localIntent.putExtra("compatible_text", aoiy.jdField_a_of_type_JavaLangString);
            }
          }
          if (paramJSONObject.has("need_send_long_msg_when_failed")) {
            localIntent.putExtra("need_send_long_msg_when_failed", paramJSONObject.optBoolean("need_send_long_msg_when_failed"));
          }
          l = paramJSONObject.optLong("appid", 0L);
          if (l <= 0L) {
            break label1302;
          }
          paramJSONObject = this.mRuntime.a();
          if (paramJSONObject != null)
          {
            if (this.jdField_a_of_type_Bety == null) {
              a(localActivity);
            }
            if (!this.jdField_a_of_type_Bety.isShowing())
            {
              this.jdField_a_of_type_Bety.c(2131694219);
              this.jdField_a_of_type_Bety.show();
            }
            localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
            zfy.a(paramJSONObject, this.jdField_a_of_type_AndroidContentContext, paramJSONObject.getAccount(), l, 3000L, new atih(this, localIntent));
          }
          if (localBundle == null) {
            break label2397;
          }
          localBundle.clear();
          return;
          paramString1 = paramString1.e;
          break;
          localIntent.putExtra("isWebCompShare", true);
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          break label412;
          i = paramJSONObject.optInt("req_type", 146);
          paramInt = i;
          if (i == 2)
          {
            localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
            paramInt = i;
          }
        }
        if (this.jdField_a_of_type_Bety == null) {
          a(localActivity);
        }
        if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing()))
        {
          l = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "dialog dimiss time :" + l);
          }
          this.jdField_a_of_type_Bety.dismiss();
        }
        paramString1 = paramJSONObject.optString("puin", null);
        if (paramString1 == null) {
          paramString1 = paramJSONObject.optString("oaUin");
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramString1))
          {
            paramString2 = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
            paramString5 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
            paramString2.a();
            paramString4 = paramJSONObject.optString("src_action", "");
            paramString2 = null;
            if (TextUtils.isEmpty(paramString4)) {
              if (paramString5 == null) {
                break label2405;
              }
            }
          }
          for (paramString2 = paramString5.name;; paramString2 = null)
          {
            paramString3 = paramString2;
            if (TextUtils.isEmpty(paramString2))
            {
              paramString3 = paramString2;
              if (paramJSONObject.has("sourceName")) {
                paramString3 = paramJSONObject.optString("sourceName");
              }
            }
            paramString2 = paramString3;
            if (TextUtils.isEmpty(paramString3)) {
              paramString2 = paramString1;
            }
            for (;;)
            {
              if (paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131700034)))
              {
                bool = paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131700034));
                if (bool)
                {
                  paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
                  if (!bool) {
                    break label1904;
                  }
                  paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
                  if (!bool) {
                    break label1912;
                  }
                  paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
                  localIntent.putExtra("source_puin", paramString1);
                  localIntent.putExtra("struct_share_key_source_action", "plugin");
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
                  localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
                  localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
                  localIntent.putExtra("struct_share_key_source_icon", paramString4);
                  localIntent.putExtra("app_name", paramString2);
                }
              }
              for (;;)
              {
                if ((this.jdField_a_of_type_Belq != null) && (this.jdField_a_of_type_Belt != null))
                {
                  localIntent.putExtra("strurt_msgid", this.jdField_a_of_type_Belq.g());
                  localIntent.putExtra("struct_uin", this.jdField_a_of_type_Belq.h());
                  localIntent.putExtra("struct_url", this.jdField_a_of_type_Belt.b());
                  localIntent.putExtra("from_web", true);
                  if ((this.jdField_a_of_type_Belq.i() != null) && (!"".equals(this.jdField_a_of_type_Belq.i()))) {
                    localIntent.putExtra("source_puin", this.jdField_a_of_type_Belq.i());
                  }
                }
                paramJSONObject = azvd.a(localIntent.getExtras());
                if (paramJSONObject != null) {
                  break label2376;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QQApi", 2, "build struct msg fail");
                }
                if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
                  break label2364;
                }
                callJs(this.jdField_a_of_type_JavaLangString, new String[] { "false" });
                return;
                if (paramJSONObject.has("sourceName")) {
                  paramString2 = paramJSONObject.optString("sourceName");
                }
                paramString3 = paramString2;
                if (TextUtils.isEmpty(paramString2))
                {
                  paramString3 = paramString2;
                  if (paramString5 != null) {
                    paramString3 = paramString5.name;
                  }
                }
                if (!TextUtils.isEmpty(paramString3)) {
                  break label2399;
                }
                paramString2 = paramString1;
                break;
                paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
                break label1565;
                label1904:
                paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
                break label1575;
                label1912:
                paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
                break label1585;
                paramString3 = paramJSONObject.optString("src_webActionUrl", "");
                paramString5 = paramJSONObject.optString("src_actionData", "");
                paramString6 = paramJSONObject.optString("src_a_actionData", "");
                paramString7 = paramJSONObject.optString("src_i_actionData", "");
                if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(paramString7)))))
                {
                  paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
                  paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
                  localIntent.putExtra("struct_share_key_source_action", "plugin");
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
                  localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
                }
                for (;;)
                {
                  localIntent.putExtra("source_puin", paramString1);
                  localIntent.putExtra("app_name", paramString2);
                  paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
                  if (!TextUtils.isEmpty(paramJSONObject)) {
                    break label2262;
                  }
                  localIntent.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
                  break;
                  localIntent.putExtra("struct_share_key_source_action", paramString4);
                  if ("web".equals(paramString4))
                  {
                    localIntent.putExtra("struct_share_key_source_url", paramString3);
                    localIntent.putExtra("source_url", paramString3);
                  }
                  else
                  {
                    if (!TextUtils.isEmpty(paramString5)) {
                      localIntent.putExtra("struct_share_key_source_action_data", paramString5);
                    }
                    if (!TextUtils.isEmpty(paramString6)) {
                      localIntent.putExtra("struct_share_key_source_a_action_data", paramString6);
                    }
                    if (!TextUtils.isEmpty(paramString7)) {
                      localIntent.putExtra("struct_share_key_source_i_action_data", paramString7);
                    }
                  }
                }
                localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
                continue;
                if (paramJSONObject.has("sourceName"))
                {
                  paramString1 = paramJSONObject.optString("sourceName");
                  localIntent.putExtra("app_name", paramString1);
                  if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
                    localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
                  }
                }
                else
                {
                  localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidContentContext.getString(2131696891));
                }
              }
              callJs4OpenApiIfNeeded("shareMsg", 0, "false");
              return;
              localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
              startActivityForResult(localIntent, (byte)1);
              break label1212;
              break;
              paramString2 = paramString3;
            }
          }
        }
      }
      label1302:
      label1565:
      label1575:
      label1585:
      label2364:
      label2376:
      label2421:
      paramString1 = str;
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = null;
      try
      {
        paramString = new JSONObject(paramString);
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        localIntent.putExtra("isFromShare", true);
        String str = paramString.optString("toUin");
        int i = paramString.optInt("uinType", 0);
        if ((str != null) && (str.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str);
          localIntent.putExtra("uinType", i);
        }
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", paramString.optString("text"));
        this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
        if (paramString.has("report")) {
          localIntent.putExtra("report", paramString.getString("report"));
        }
        localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        startActivityForResult(localIntent, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareText error: " + paramString.getMessage());
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        if (!"0".equals(((JSONObject)localObject).optString("share_type", "0"))) {
          break;
        }
        paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        paramString.putExtra("pluginName", "web_share");
        paramString.putExtra("forward_type", -4);
        paramString.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        paramString.putExtra("req_type", 3);
        paramString.putExtra("k_back", false);
        paramString.putExtra("key_flag_from_plugin", true);
        paramString.putExtra("forward_text", ((JSONObject)localObject).optString("text"));
        paramString.putExtra("struct_share_key_source_name", ((JSONObject)localObject).optString("srcName"));
        paramString.putExtra("struct_share_key_source_icon", ((JSONObject)localObject).optString("srcIconUrl"));
        paramString.putExtra("struct_share_key_source_url", ((JSONObject)localObject).optString("srcUrl"));
        localObject = azvd.a(paramString.getExtras());
        if (localObject != null) {
          break label244;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "build struct msg fail");
        }
        startActivityForResult(paramString, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQApi", 2, "shareHyperText error: " + paramString.getMessage());
      return;
      label244:
      paramString.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = null;
      paramString = new JSONObject(paramString);
      Intent localIntent = new Intent();
      String str = paramString.optString("toUin");
      if ((str == null) || (str.length() < 5))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0}" });
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "toUin invalide: " + str);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
        localIntent.putExtra("toUin", str);
        localIntent.putExtra("key_flag_from_plugin", true);
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("forward_type", 30);
        localIntent.putExtra("k_back", true);
        startActivityForResult(localIntent, (byte)2);
        return;
      }
    }
    catch (JSONException paramString)
    {
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0}" });
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "shareMsg error: " + paramString.toString());
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool1;
    int i;
    if ("QQApi".equals(paramString2))
    {
      if ((paramJsBridgeListener == null) || (!paramJsBridgeListener.a)) {
        break label96;
      }
      bool1 = true;
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      i = paramVarArgs.length;
      if ((!"isAppInstalled".equals(paramString3)) || (i != 1)) {
        break label102;
      }
      paramString1 = Boolean.valueOf(bdiv.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]));
      label77:
      if (!bool1) {
        break label674;
      }
      callJs4OpenApiIfNeeded(paramString3, 0, paramString1);
    }
    for (;;)
    {
      bool2 = true;
      label96:
      label102:
      do
      {
        do
        {
          return bool2;
          bool1 = false;
          break;
          if (("checkAppInstalled".equals(paramString3)) && (i == 1))
          {
            paramString1 = bdiv.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("checkAppInstalledBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = bdiv.b(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("isAppInstalledBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = bdiv.c(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("startAppWithPkgName".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(bdiv.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], null));
            break label77;
          }
          if (("startAppWithPkgNameAndOpenId".equals(paramString3)) && (i == 2))
          {
            paramString1 = Boolean.valueOf(bdiv.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], paramVarArgs[1]));
            break label77;
          }
          if (("getOpenidBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = a(paramVarArgs[0]);
            break label77;
          }
          if (("launchAppWithTokens".equals(paramString3)) && ((i == 1) || (i == 4)))
          {
            if (i == 1)
            {
              a(paramVarArgs[0]);
              paramString1 = localObject;
              break label77;
            }
            paramString1 = localObject;
            if (i != 4) {
              break label77;
            }
            a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], null, "");
            paramString1 = localObject;
            break label77;
          }
          if (("getAppsVerionCodeBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = bdiv.d(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("setShareURL".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(a(paramVarArgs[0]));
            break label77;
          }
          if (("setShareInfo".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(b(paramVarArgs[0]));
            break label77;
          }
          if (("setToolHiddenFlags".equals(paramString3)) && (i == 1))
          {
            b(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("shareMsg".equals(paramString3)) && (i == 1))
          {
            a(paramVarArgs[0], bool1);
            paramString1 = localObject;
            break label77;
          }
          if (("shareText".equals(paramString3)) && (i == 1))
          {
            d(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("shareHypertext".equals(paramString3)) && (i == 1))
          {
            e(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("sendPokeMsg".equals(paramString3)) && (i == 1))
          {
            f(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          bool2 = bool3;
        } while (!"shareArkMessage".equals(paramString3));
        bool2 = bool3;
      } while (i != 1);
      c(paramVarArgs[0]);
      paramString1 = localObject;
      break label77;
      label674:
      paramJsBridgeListener.a(paramString1);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject;
    if (paramByte == 1) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        if (paramInt == -1)
        {
          paramIntent = "true";
          callJs((String)localObject, new String[] { paramIntent });
        }
      }
    }
    do
    {
      do
      {
        return;
        paramIntent = "false";
        break;
        if (paramInt == -1) {}
        for (paramIntent = "true";; paramIntent = "false")
        {
          callJs4OpenApiIfNeeded("shareMsg", 0, paramIntent);
          return;
        }
        if (paramByte == 2)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            localObject = this.jdField_a_of_type_JavaLangString;
            if (paramInt == -1) {}
            for (paramIntent = "{\"result\":1}";; paramIntent = "{\"result\":0}")
            {
              callJs((String)localObject, new String[] { paramIntent });
              return;
            }
          }
          if (paramInt == -1) {}
          for (paramIntent = "{\"result\":1}";; paramIntent = "{\"result\":0}")
          {
            callJs4OpenApiIfNeeded("shareMsg", 0, paramIntent);
            return;
          }
        }
        if (paramByte == 3)
        {
          if (!TextUtils.isEmpty(this.b))
          {
            localObject = this.b;
            if (paramInt == -1) {}
            for (paramIntent = "{\"result\":0}";; paramIntent = "{\"result\":4}")
            {
              callJs((String)localObject, new String[] { paramIntent });
              return;
            }
          }
          if (paramInt == -1) {}
          for (paramIntent = "{\"result\":0}";; paramIntent = "{\"result\":4}")
          {
            callJs4OpenApiIfNeeded("shareMsg", 0, paramIntent);
            return;
          }
        }
      } while (paramByte != 4);
      localObject = this.mRuntime.a();
    } while ((paramInt != -1) || (localObject == null) || (((Activity)localObject).isFinishing()) || (paramIntent == null));
    paramIntent = new Bundle(paramIntent.getExtras());
    this.jdField_a_of_type_Yqz.a(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = a();
    begg localbegg = this.mRuntime.a(this.mRuntime.a());
    if ((localbegg != null) && ((localbegg instanceof belt))) {
      this.jdField_a_of_type_Belt = ((belt)localbegg);
    }
    localbegg = this.mRuntime.a(this.mRuntime.a());
    if ((localbegg != null) && ((localbegg instanceof belh))) {
      this.jdField_a_of_type_Belh = ((belh)localbegg);
    }
    localbegg = this.mRuntime.a(this.mRuntime.a());
    if ((localbegg != null) && ((localbegg instanceof beln))) {
      this.jdField_a_of_type_Beln = ((beln)localbegg);
    }
    localbegg = this.mRuntime.a(this.mRuntime.a());
    if ((localbegg != null) && ((localbegg instanceof belq))) {
      this.jdField_a_of_type_Belq = ((belq)localbegg);
    }
    localbegg = this.mRuntime.a(this.mRuntime.a());
    if ((localbegg != null) && ((localbegg instanceof belp))) {
      this.jdField_a_of_type_Belp = ((belp)localbegg);
    }
    if (this.jdField_a_of_type_Yqz == null)
    {
      this.jdField_a_of_type_Yqz = yqz.a();
      this.jdField_a_of_type_Yqz.a();
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
    if (this.jdField_a_of_type_Bfah != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_Bfah);
    }
    if (this.jdField_a_of_type_Yqz != null) {
      this.jdField_a_of_type_Yqz.b();
    }
    if (this.jdField_a_of_type_Osn != null) {
      WxShareHelperFromReadInjoy.a().b(this.jdField_a_of_type_Osn);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atid
 * JD-Core Version:    0.7.0.1
 */