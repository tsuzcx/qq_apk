package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
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
  List jdField_a_of_type_JavaUtilList = new ArrayList();
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
          PublicAccountReportUtils.a(null, "", "0X8007621", "0X8007621", 0, 0, "0", "" + i, this.jdField_a_of_type_JavaLangString, "0");
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
            PublicAccountReportUtils.a(null, "", "0X8007621", "0X8007621", 0, 0, "1", "" + i, this.jdField_a_of_type_JavaLangString, "" + (l2 - l1));
            return paramString1;
          }
        }
        else
        {
          PublicAccountReportUtils.a(null, "", "0X8007621", "0X8007621", 0, 0, "0", "" + i, this.jdField_a_of_type_JavaLangString, "0");
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
    //   2: invokespecial 296	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:a	(Ljava/lang/String;)I
    //   5: istore_3
    //   6: aconst_null
    //   7: invokestatic 194	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   10: istore 4
    //   12: aload_0
    //   13: getfield 21	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge	Lcom/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge;
    //   16: ifnull +101 -> 117
    //   19: aload_0
    //   20: getfield 21	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge	Lcom/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge;
    //   23: aload_2
    //   24: iload_3
    //   25: invokevirtual 299	com/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge:a	(Ljava/lang/String;I)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   28: astore 9
    //   30: aload 9
    //   32: ifnull +91 -> 123
    //   35: new 103	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 104	org/json/JSONObject:<init>	()V
    //   42: astore 10
    //   44: aload 10
    //   46: ldc_w 301
    //   49: iconst_m1
    //   50: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload 10
    //   56: ldc_w 306
    //   59: iload_3
    //   60: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   63: pop
    //   64: aconst_null
    //   65: ldc 28
    //   67: ldc_w 308
    //   70: ldc_w 308
    //   73: iconst_0
    //   74: iconst_0
    //   75: ldc_w 259
    //   78: new 67	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   85: iload 4
    //   87: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc 28
    //   92: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload_0
    //   99: getfield 30	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: aload 10
    //   104: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   107: invokestatic 217	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 9
    //   112: astore 10
    //   114: aload 10
    //   116: areturn
    //   117: aconst_null
    //   118: astore 9
    //   120: goto -90 -> 30
    //   123: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   126: lstore 5
    //   128: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +40 -> 171
    //   134: ldc 136
    //   136: iconst_2
    //   137: new 67	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 310
    //   147: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: lload 5
    //   152: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   155: ldc_w 312
    //   158: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_2
    //   162: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 9
    //   173: astore 10
    //   175: aload_2
    //   176: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne -65 -> 114
    //   182: aload 9
    //   184: astore 10
    //   186: aload_2
    //   187: ifnull -73 -> 114
    //   190: aload_2
    //   191: invokestatic 316	com/tencent/open/base/MD5Utils:d	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 10
    //   196: aload_0
    //   197: getfield 182	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   200: ifnull +307 -> 507
    //   203: new 318	java/io/File
    //   206: dup
    //   207: getstatic 323	com/tencent/mobileqq/app/AppConstants:cp	Ljava/lang/String;
    //   210: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: invokevirtual 327	java/io/File:mkdirs	()Z
    //   216: pop
    //   217: new 318	java/io/File
    //   220: dup
    //   221: new 67	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   228: getstatic 323	com/tencent/mobileqq/app/AppConstants:cp	Ljava/lang/String;
    //   231: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 10
    //   236: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore 10
    //   247: new 103	org/json/JSONObject
    //   250: dup
    //   251: invokespecial 104	org/json/JSONObject:<init>	()V
    //   254: astore 9
    //   256: aload 10
    //   258: invokevirtual 330	java/io/File:exists	()Z
    //   261: ifeq +153 -> 414
    //   264: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   267: lstore 5
    //   269: aload_0
    //   270: aload 10
    //   272: aload_2
    //   273: aload_1
    //   274: invokevirtual 333	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:a	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   277: astore_1
    //   278: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   281: lstore 7
    //   283: aload 9
    //   285: ldc_w 301
    //   288: lload 7
    //   290: lload 5
    //   292: lsub
    //   293: invokevirtual 336	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   296: pop
    //   297: aload 9
    //   299: ldc_w 306
    //   302: iload_3
    //   303: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   306: pop
    //   307: aconst_null
    //   308: ldc 28
    //   310: ldc_w 308
    //   313: ldc_w 308
    //   316: iconst_0
    //   317: iconst_0
    //   318: ldc_w 259
    //   321: new 67	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   328: ldc 28
    //   330: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: iload 4
    //   335: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: new 67	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   348: ldc 28
    //   350: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: getfield 30	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   357: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: aload 9
    //   365: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 217	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload_1
    //   372: areturn
    //   373: astore 11
    //   375: aconst_null
    //   376: astore 10
    //   378: aload 10
    //   380: astore 9
    //   382: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq -262 -> 123
    //   388: ldc 136
    //   390: iconst_2
    //   391: ldc_w 338
    //   394: aload 11
    //   396: invokestatic 342	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: aload 10
    //   401: astore 9
    //   403: goto -280 -> 123
    //   406: astore_2
    //   407: aload_2
    //   408: invokevirtual 145	org/json/JSONException:printStackTrace	()V
    //   411: goto -104 -> 307
    //   414: aload 9
    //   416: ldc_w 301
    //   419: iconst_0
    //   420: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   423: pop
    //   424: aload 9
    //   426: ldc_w 306
    //   429: iload_3
    //   430: invokevirtual 304	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   433: pop
    //   434: aconst_null
    //   435: ldc 28
    //   437: ldc_w 308
    //   440: ldc_w 308
    //   443: iconst_0
    //   444: iconst_0
    //   445: ldc 209
    //   447: new 67	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   454: ldc 28
    //   456: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: iload 4
    //   461: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   464: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: new 67	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   474: ldc 28
    //   476: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: getfield 30	com/tencent/biz/webviewplugin/PubAccountPreloadPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   483: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: aload 9
    //   491: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   494: invokestatic 217	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   497: aconst_null
    //   498: areturn
    //   499: astore_1
    //   500: aload_1
    //   501: invokevirtual 145	org/json/JSONException:printStackTrace	()V
    //   504: goto -70 -> 434
    //   507: aload 9
    //   509: astore 10
    //   511: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq -400 -> 114
    //   517: ldc 136
    //   519: iconst_2
    //   520: ldc_w 344
    //   523: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: aload 9
    //   528: areturn
    //   529: astore 11
    //   531: aload 9
    //   533: astore 10
    //   535: goto -157 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	PubAccountPreloadPlugin
    //   0	538	1	paramString1	String
    //   0	538	2	paramString2	String
    //   5	425	3	i	int
    //   10	450	4	j	int
    //   126	165	5	l1	long
    //   281	8	7	l2	long
    //   28	504	9	localObject1	Object
    //   42	492	10	localObject2	Object
    //   373	22	11	localException1	java.lang.Exception
    //   529	1	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	30	373	java/lang/Exception
    //   283	307	406	org/json/JSONException
    //   414	434	499	org/json/JSONException
    //   35	110	529	java/lang/Exception
  }
  
  /* Error */
  public WebResourceResponse a(java.io.File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 136
    //   8: iconst_2
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 350
    //   19: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   25: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 352	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore 4
    //   44: aload 4
    //   46: astore_1
    //   47: aload 4
    //   49: invokevirtual 358	java/io/FileInputStream:available	()I
    //   52: newarray byte
    //   54: astore 5
    //   56: aload 4
    //   58: astore_1
    //   59: aload 4
    //   61: aload 5
    //   63: invokevirtual 362	java/io/FileInputStream:read	([B)I
    //   66: pop
    //   67: aload 4
    //   69: astore_1
    //   70: new 228	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   73: dup
    //   74: aload_3
    //   75: ldc 230
    //   77: new 232	java/io/BufferedInputStream
    //   80: dup
    //   81: new 234	java/io/ByteArrayInputStream
    //   84: dup
    //   85: aload 5
    //   87: invokespecial 237	java/io/ByteArrayInputStream:<init>	([B)V
    //   90: invokespecial 240	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: invokespecial 243	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   96: astore_3
    //   97: aload 4
    //   99: astore_1
    //   100: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +44 -> 147
    //   106: aload 4
    //   108: astore_1
    //   109: ldc 136
    //   111: iconst_2
    //   112: new 67	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 364
    //   122: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 366
    //   132: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   138: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   141: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_3
    //   148: astore_1
    //   149: aload 4
    //   151: ifnull +10 -> 161
    //   154: aload 4
    //   156: invokevirtual 369	java/io/FileInputStream:close	()V
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
    //   173: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   176: aload_2
    //   177: astore_1
    //   178: aload 4
    //   180: ifnull -19 -> 161
    //   183: aload 4
    //   185: invokevirtual 369	java/io/FileInputStream:close	()V
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
    //   203: invokevirtual 371	java/lang/OutOfMemoryError:printStackTrace	()V
    //   206: aload_2
    //   207: astore_1
    //   208: aload 4
    //   210: ifnull -49 -> 161
    //   213: aload 4
    //   215: invokevirtual 369	java/io/FileInputStream:close	()V
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
    //   231: invokevirtual 369	java/io/FileInputStream:close	()V
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
  
  public List a(String paramString1, String paramString2)
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
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountPreloadPlugin", 2, "url is " + paramString);
    }
    if ((paramLong == 8L) && (!TextUtils.isEmpty(paramString)))
    {
      if (a(paramString)) {
        return a("text/html", paramString);
      }
      if (this.mRuntime != null) {}
      for (Activity localActivity = this.mRuntime.a();; localActivity = null)
      {
        if ((localActivity != null) && ((localActivity instanceof ReadInJoyArticleDetailActivity)) && (!this.jdField_a_of_type_Boolean))
        {
          ((ReadInJoyArticleDetailActivity)localActivity).b();
          this.jdField_a_of_type_Boolean = true;
        }
        if ((!b(paramString)) || (!c(paramString))) {
          break;
        }
        return b("image/*", paramString);
      }
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
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
  
  protected void onDestroy()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge.a();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountPreloadPlugin
 * JD-Core Version:    0.7.0.1
 */