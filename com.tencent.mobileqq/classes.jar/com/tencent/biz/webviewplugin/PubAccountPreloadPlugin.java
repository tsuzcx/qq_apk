package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJPageGenerator;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebResourceUtil;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class PubAccountPreloadPlugin
  extends WebViewPlugin
{
  PubAccountWebViewHttpBridge jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge = new PubAccountWebViewHttpBridge();
  String jdField_a_of_type_JavaLangString = "";
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  String b = "";
  
  public PubAccountPreloadPlugin()
  {
    this.mPluginNameSpace = "pubAccountPreload";
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    if (localObject != null)
    {
      localObject = (AppInterface)((AppRuntime)localObject).getAppRuntime("modular_web");
      if (localObject != null)
      {
        this.b = ((AppInterface)localObject).getCurrentAccountUin();
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.b, 4);
        if (localObject != null)
        {
          bool1 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload", false);
          bool2 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_wifi", false);
          bool3 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_4G", false);
          bool4 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_3G", false);
          bool5 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_2G", false);
          bool6 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_image_preload", false);
        }
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("readInJoyPreload", bool1);
      ((JSONObject)localObject).put("readInJoyPreloadWifi", bool2);
      ((JSONObject)localObject).put("readInJoyPreload4G", bool3);
      ((JSONObject)localObject).put("readInJoyPreload3G", bool4);
      ((JSONObject)localObject).put("readInJoyPreload2G", bool5);
      ((JSONObject)localObject).put("readInJoyImgPreload", bool6);
      ((JSONObject)localObject).put("platform", "android");
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.i("PubAccountPreloadPlugin", 2, "reportJson" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private int a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        if (((String)this.jdField_a_of_type_JavaUtilList.get(i)).startsWith(paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private WebResourceResponse a(String paramString1, String paramString2)
  {
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountPreloadPlugin", 2, "此时进入getOffline的时间为" + l2);
    }
    if (this.mRuntime != null)
    {
      Object localObject = this.mRuntime.a();
      if ((localObject != null) && ((localObject instanceof ReadInJoyArticleDetailActivity)))
      {
        int i = NetUtil.a(null);
        String str = PreloadManager.a(paramString2);
        if ((TextUtils.isEmpty(str)) || (str == null))
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007621", "0X8007621", 0, 0, "0", "" + i, this.jdField_a_of_type_JavaLangString, "0");
          return null;
        }
        if (((ReadInJoyArticleDetailActivity)localObject).a(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PubAccountPreloadPlugin", 2, "此时开始读内存" + System.currentTimeMillis());
          }
          long l1 = System.currentTimeMillis();
          localObject = ((ReadInJoyArticleDetailActivity)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("PubAccountPreloadPlugin", 2, "此时在等待结束以后开始读内存的时间为" + System.currentTimeMillis());
          }
          if (localObject != null)
          {
            paramString1 = new WebResourceResponse(paramString1, "utf-8", new BufferedInputStream(new ByteArrayInputStream((byte[])localObject)));
            long l3 = System.currentTimeMillis();
            if (QLog.isColorLevel())
            {
              QLog.i("PubAccountPreloadPlugin", 2, "-->right");
              QLog.d("PubAccountPreloadPlugin", 2, "在内存中此时结束的时间为" + l3);
              QLog.d("PubAccountPreloadPlugin", 2, "在内存中读出总共耗时为" + (l3 - l2));
            }
            if (QLog.isColorLevel()) {
              QLog.d("PubAccountPreloadPlugin", 2, "开始解析的时间" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_JavaUtilList = a(new String((byte[])localObject), paramString2);
            if (QLog.isColorLevel()) {
              QLog.d("PubAccountPreloadPlugin", 2, "结束解析的时间" + System.currentTimeMillis());
            }
            l2 = System.currentTimeMillis();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007621", "0X8007621", 0, 0, "1", "" + i, this.jdField_a_of_type_JavaLangString, "" + (l2 - l1));
            return paramString1;
          }
        }
        else
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007621", "0X8007621", 0, 0, "0", "" + i, this.jdField_a_of_type_JavaLangString, "0");
          return null;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PubAccountPreloadPlugin", 2, "activity is null");
      }
    }
    return null;
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.startsWith("http:"));
      str = paramString;
    } while (paramString.startsWith("https"));
    if (paramBoolean) {
      return "https:" + paramString;
    }
    return "http:" + paramString;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = new URL(paramString);
      paramString = ((URL)localObject).getHost();
      localObject = ((URL)localObject).getPath();
      boolean bool1 = bool2;
      if ("post.mp.qq.com".equalsIgnoreCase(paramString))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool3 = ((String)localObject).endsWith(".html");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 304	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:a	(Ljava/lang/String;)I
    //   5: istore_3
    //   6: aconst_null
    //   7: invokestatic 195	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   10: istore 4
    //   12: aload_0
    //   13: getfield 22	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge	Lcom/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge;
    //   16: ifnull +111 -> 127
    //   19: aload_0
    //   20: getfield 22	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge	Lcom/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge;
    //   23: aload_2
    //   24: iload_3
    //   25: invokevirtual 307	com/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge:a	(Ljava/lang/String;I)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   28: astore 9
    //   30: aload 9
    //   32: ifnull +101 -> 133
    //   35: new 104	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 105	org/json/JSONObject:<init>	()V
    //   42: astore 10
    //   44: aload 10
    //   46: ldc_w 309
    //   49: iconst_m1
    //   50: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload 10
    //   56: ldc_w 314
    //   59: iload_3
    //   60: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   63: pop
    //   64: ldc 208
    //   66: invokestatic 214	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   69: checkcast 208	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   72: aconst_null
    //   73: ldc 29
    //   75: ldc_w 316
    //   78: ldc_w 316
    //   81: iconst_0
    //   82: iconst_0
    //   83: ldc_w 267
    //   86: new 68	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   93: iload 4
    //   95: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc 29
    //   100: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload_0
    //   107: getfield 31	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: aload 10
    //   112: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   115: invokeinterface 225 11 0
    //   120: aload 9
    //   122: astore 10
    //   124: aload 10
    //   126: areturn
    //   127: aconst_null
    //   128: astore 9
    //   130: goto -100 -> 30
    //   133: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   136: lstore 5
    //   138: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +40 -> 181
    //   144: ldc 137
    //   146: iconst_2
    //   147: new 68	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 318
    //   157: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: lload 5
    //   162: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   165: ldc_w 320
    //   168: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload 9
    //   183: astore 10
    //   185: aload_2
    //   186: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne -65 -> 124
    //   192: aload 9
    //   194: astore 10
    //   196: aload_2
    //   197: ifnull -73 -> 124
    //   200: aload_2
    //   201: invokestatic 325	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 10
    //   206: aload_0
    //   207: getfield 183	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   210: ifnull +327 -> 537
    //   213: new 327	java/io/File
    //   216: dup
    //   217: getstatic 332	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE	Ljava/lang/String;
    //   220: invokespecial 333	java/io/File:<init>	(Ljava/lang/String;)V
    //   223: invokevirtual 336	java/io/File:mkdirs	()Z
    //   226: pop
    //   227: new 327	java/io/File
    //   230: dup
    //   231: new 68	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   238: getstatic 332	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE	Ljava/lang/String;
    //   241: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 10
    //   246: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokespecial 333	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: astore 10
    //   257: new 104	org/json/JSONObject
    //   260: dup
    //   261: invokespecial 105	org/json/JSONObject:<init>	()V
    //   264: astore 9
    //   266: aload 10
    //   268: invokevirtual 339	java/io/File:exists	()Z
    //   271: ifeq +163 -> 434
    //   274: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   277: lstore 5
    //   279: aload_0
    //   280: aload 10
    //   282: aload_2
    //   283: aload_1
    //   284: invokevirtual 342	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:a	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   287: astore_1
    //   288: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   291: lstore 7
    //   293: aload 9
    //   295: ldc_w 309
    //   298: lload 7
    //   300: lload 5
    //   302: lsub
    //   303: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   306: pop
    //   307: aload 9
    //   309: ldc_w 314
    //   312: iload_3
    //   313: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   316: pop
    //   317: ldc 208
    //   319: invokestatic 214	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   322: checkcast 208	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   325: aconst_null
    //   326: ldc 29
    //   328: ldc_w 316
    //   331: ldc_w 316
    //   334: iconst_0
    //   335: iconst_0
    //   336: ldc_w 267
    //   339: new 68	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   346: ldc 29
    //   348: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: iload 4
    //   353: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: new 68	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   366: ldc 29
    //   368: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_0
    //   372: getfield 31	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   375: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: aload 9
    //   383: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   386: invokeinterface 225 11 0
    //   391: aload_1
    //   392: areturn
    //   393: astore 11
    //   395: aconst_null
    //   396: astore 10
    //   398: aload 10
    //   400: astore 9
    //   402: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq -272 -> 133
    //   408: ldc 137
    //   410: iconst_2
    //   411: ldc_w 347
    //   414: aload 11
    //   416: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   419: aload 10
    //   421: astore 9
    //   423: goto -290 -> 133
    //   426: astore_2
    //   427: aload_2
    //   428: invokevirtual 146	org/json/JSONException:printStackTrace	()V
    //   431: goto -114 -> 317
    //   434: aload 9
    //   436: ldc_w 309
    //   439: iconst_0
    //   440: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 9
    //   446: ldc_w 314
    //   449: iload_3
    //   450: invokevirtual 312	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   453: pop
    //   454: ldc 208
    //   456: invokestatic 214	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   459: checkcast 208	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   462: aconst_null
    //   463: ldc 29
    //   465: ldc_w 316
    //   468: ldc_w 316
    //   471: iconst_0
    //   472: iconst_0
    //   473: ldc 218
    //   475: new 68	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   482: ldc 29
    //   484: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: iload 4
    //   489: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: new 68	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   502: ldc 29
    //   504: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_0
    //   508: getfield 31	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   511: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: aload 9
    //   519: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   522: invokeinterface 225 11 0
    //   527: aconst_null
    //   528: areturn
    //   529: astore_1
    //   530: aload_1
    //   531: invokevirtual 146	org/json/JSONException:printStackTrace	()V
    //   534: goto -80 -> 454
    //   537: aload 9
    //   539: astore 10
    //   541: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq -420 -> 124
    //   547: ldc 137
    //   549: iconst_2
    //   550: ldc_w 353
    //   553: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload 9
    //   558: areturn
    //   559: astore 11
    //   561: aload 9
    //   563: astore 10
    //   565: goto -167 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	PubAccountPreloadPlugin
    //   0	568	1	paramString1	String
    //   0	568	2	paramString2	String
    //   5	445	3	i	int
    //   10	478	4	j	int
    //   136	165	5	l1	long
    //   291	8	7	l2	long
    //   28	534	9	localObject1	Object
    //   42	522	10	localObject2	Object
    //   393	22	11	localException1	java.lang.Exception
    //   559	1	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	30	393	java/lang/Exception
    //   293	317	426	org/json/JSONException
    //   434	454	529	org/json/JSONException
    //   35	120	559	java/lang/Exception
  }
  
  /* Error */
  public WebResourceResponse a(java.io.File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 137
    //   8: iconst_2
    //   9: new 68	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 359
    //   19: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   25: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 361	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore 4
    //   44: aload 4
    //   46: astore_1
    //   47: aload 4
    //   49: invokevirtual 367	java/io/FileInputStream:available	()I
    //   52: newarray byte
    //   54: astore 5
    //   56: aload 4
    //   58: astore_1
    //   59: aload 4
    //   61: aload 5
    //   63: invokevirtual 371	java/io/FileInputStream:read	([B)I
    //   66: pop
    //   67: aload 4
    //   69: astore_1
    //   70: new 236	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   73: dup
    //   74: aload_3
    //   75: ldc 238
    //   77: new 240	java/io/BufferedInputStream
    //   80: dup
    //   81: new 242	java/io/ByteArrayInputStream
    //   84: dup
    //   85: aload 5
    //   87: invokespecial 245	java/io/ByteArrayInputStream:<init>	([B)V
    //   90: invokespecial 248	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: invokespecial 251	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   96: astore_3
    //   97: aload 4
    //   99: astore_1
    //   100: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +44 -> 147
    //   106: aload 4
    //   108: astore_1
    //   109: ldc 137
    //   111: iconst_2
    //   112: new 68	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 373
    //   122: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 375
    //   132: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   138: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   141: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_3
    //   148: astore_1
    //   149: aload 4
    //   151: ifnull +10 -> 161
    //   154: aload 4
    //   156: invokevirtual 378	java/io/FileInputStream:close	()V
    //   159: aload_3
    //   160: astore_1
    //   161: aload_1
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_2
    //   169: aload 4
    //   171: astore_1
    //   172: aload_3
    //   173: invokevirtual 379	java/io/IOException:printStackTrace	()V
    //   176: aload_2
    //   177: astore_1
    //   178: aload 4
    //   180: ifnull -19 -> 161
    //   183: aload 4
    //   185: invokevirtual 378	java/io/FileInputStream:close	()V
    //   188: aload_2
    //   189: areturn
    //   190: astore_1
    //   191: aload_2
    //   192: areturn
    //   193: astore_3
    //   194: aconst_null
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_2
    //   199: aload 4
    //   201: astore_1
    //   202: aload_3
    //   203: invokevirtual 380	java/lang/OutOfMemoryError:printStackTrace	()V
    //   206: aload_2
    //   207: astore_1
    //   208: aload 4
    //   210: ifnull -49 -> 161
    //   213: aload 4
    //   215: invokevirtual 378	java/io/FileInputStream:close	()V
    //   218: aload_2
    //   219: areturn
    //   220: astore_1
    //   221: aload_2
    //   222: areturn
    //   223: astore_2
    //   224: aconst_null
    //   225: astore_1
    //   226: aload_1
    //   227: ifnull +7 -> 234
    //   230: aload_1
    //   231: invokevirtual 378	java/io/FileInputStream:close	()V
    //   234: aload_2
    //   235: athrow
    //   236: astore_1
    //   237: aload_3
    //   238: areturn
    //   239: astore_1
    //   240: goto -6 -> 234
    //   243: astore_2
    //   244: goto -18 -> 226
    //   247: astore_3
    //   248: aconst_null
    //   249: astore_2
    //   250: goto -51 -> 199
    //   253: astore_1
    //   254: aload_3
    //   255: astore_2
    //   256: aload_1
    //   257: astore_3
    //   258: goto -59 -> 199
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_2
    //   264: goto -95 -> 169
    //   267: astore_1
    //   268: aload_3
    //   269: astore_2
    //   270: aload_1
    //   271: astore_3
    //   272: goto -103 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	PubAccountPreloadPlugin
    //   0	275	1	paramFile	java.io.File
    //   0	275	2	paramString1	String
    //   0	275	3	paramString2	String
    //   42	172	4	localFileInputStream	java.io.FileInputStream
    //   54	32	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   34	44	163	java/io/IOException
    //   183	188	190	java/io/IOException
    //   34	44	193	java/lang/OutOfMemoryError
    //   213	218	220	java/io/IOException
    //   34	44	223	finally
    //   154	159	236	java/io/IOException
    //   230	234	239	java/io/IOException
    //   47	56	243	finally
    //   59	67	243	finally
    //   70	97	243	finally
    //   100	106	243	finally
    //   109	147	243	finally
    //   172	176	243	finally
    //   202	206	243	finally
    //   47	56	247	java/lang/OutOfMemoryError
    //   59	67	247	java/lang/OutOfMemoryError
    //   70	97	247	java/lang/OutOfMemoryError
    //   100	106	253	java/lang/OutOfMemoryError
    //   109	147	253	java/lang/OutOfMemoryError
    //   47	56	261	java/io/IOException
    //   59	67	261	java/io/IOException
    //   70	97	261	java/io/IOException
    //   100	106	267	java/io/IOException
    //   109	147	267	java/io/IOException
  }
  
  public List<String> a(String paramString1, String paramString2)
  {
    int i = 0;
    if ((TextUtils.isEmpty(paramString1)) || (paramString1 == null)) {
      return null;
    }
    boolean bool = paramString2.startsWith("https");
    paramString1 = Pattern.compile("<head>[.\\s\\S\\w]*?</head>").matcher(paramString1);
    if (paramString1.find())
    {
      paramString1 = Pattern.compile("<meta[.\\s\\S\\w]*?/>").matcher(paramString1.group());
      do
      {
        do
        {
          if (!paramString1.find()) {
            break;
          }
        } while (!Pattern.compile("itemprop[\\s]*=[\\s]*\"[\\s]*prefetch-images[\\s]*\"").matcher(paramString1.group()).find());
        paramString2 = Pattern.compile("content[\\s]*=[\\s]*\"(.*?)\"").matcher(paramString1.group());
      } while (!paramString2.find());
    }
    for (paramString1 = paramString2.group(1);; paramString1 = null)
    {
      if (paramString1 == null) {
        return null;
      }
      paramString2 = new ArrayList();
      int j = 0;
      while (i < paramString1.length()) {
        if ((paramString1.charAt(i) == ';') || (i == paramString1.length() - 1))
        {
          if (i == paramString1.length() - 1) {}
          for (int k = paramString1.length();; k = i)
          {
            if (k <= j) {
              break label255;
            }
            String str = a(paramString1.substring(j, k), bool);
            if (str != null)
            {
              paramString2.add(str);
              if (QLog.isColorLevel()) {
                QLog.d("PubAccountPreloadPlugin", 2, "预下载图片url = " + str);
              }
            }
            i = k + 1;
            j = i;
            break;
          }
        }
        else
        {
          label255:
          i += 1;
        }
      }
      return paramString2;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge.a(paramString, paramBoolean);
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = new URL(paramString);
      paramString = ((URL)localObject).getHost();
      localObject = ((URL)localObject).getPath();
      boolean bool1 = bool2;
      if ("qqpublic.qpic.cn".equalsIgnoreCase(paramString))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool3 = ((String)localObject).startsWith("/qq_public/");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString == null)) {
      return false;
    }
    if (paramString.indexOf("?") == -1) {}
    for (;;)
    {
      return d(paramString);
      paramString = paramString.substring(0, paramString.indexOf("?"));
    }
  }
  
  public boolean d(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountPreloadPlugin", 2, "preDownloadImageUrlList is null");
      }
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountPreloadPlugin", 2, "need to preload, url = " + paramString);
        }
        return true;
      }
    }
    return false;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountPreloadPlugin", 2, "url is " + paramString);
    }
    if ((paramLong == 8L) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject;
      if (a(paramString))
      {
        localObject = RIJPageGenerator.a.a(paramString);
        if (localObject != null) {
          paramString = (String)localObject;
        }
      }
      do
      {
        return paramString;
        return a("text/html", paramString);
        if (this.mRuntime != null) {}
        for (localObject = this.mRuntime.a();; localObject = null)
        {
          if ((localObject != null) && ((localObject instanceof ReadInJoyArticleDetailActivity)) && (!this.jdField_a_of_type_Boolean))
          {
            ((ReadInJoyArticleDetailActivity)localObject).b();
            this.jdField_a_of_type_Boolean = true;
          }
          if ((!b(paramString)) || (!c(paramString))) {
            break;
          }
          return b("image/*", paramString);
        }
        localObject = RIJWebResourceUtil.a.a(paramString);
        paramString = (String)localObject;
      } while (localObject != null);
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (((paramLong == 8589934595L) || (paramLong == 8589934594L)) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.mRuntime != null) {}
      for (paramString = this.mRuntime.a(); (paramString != null) && ((paramString instanceof ReadInJoyArticleDetailActivity)); paramString = null)
      {
        ((ReadInJoyArticleDetailActivity)paramString).b();
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge.a();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountPreloadPlugin
 * JD-Core Version:    0.7.0.1
 */