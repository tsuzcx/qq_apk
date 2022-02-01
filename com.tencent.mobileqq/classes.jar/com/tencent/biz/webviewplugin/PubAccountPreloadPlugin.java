package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.detail.api.IReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebResourceUtil;
import com.tencent.mobileqq.kandian.repo.webarticle.api.IRIJPageGenerator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
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
    if (localObject != null)
    {
      localObject = (AppInterface)((AppRuntime)localObject).getAppRuntime("modular_web");
      if (localObject != null)
      {
        this.b = ((AppInterface)localObject).getCurrentAccountUin();
        localObject = BaseApplicationImpl.getContext();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("sp_public_account_with_cuin_");
        localStringBuilder2.append(this.b);
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder2.toString(), 4);
        if (localObject != null)
        {
          boolean bool1 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload", false);
          boolean bool2 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_wifi", false);
          boolean bool3 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_4G", false);
          boolean bool4 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_3G", false);
          boolean bool5 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_2G", false);
          boolean bool6 = ((SharedPreferences)localObject).getBoolean("kandian_feeds_image_preload", false);
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
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("reportJson");
            localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
            QLog.i("PubAccountPreloadPlugin", 2, localStringBuilder1.toString());
          }
        }
      }
    }
  }
  
  private int a(String paramString)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("此时进入getOffline的时间为");
      ((StringBuilder)localObject1).append(l2);
      QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.mRuntime != null)
    {
      Object localObject2 = this.mRuntime.a();
      if ((localObject2 != null) && ((localObject2 instanceof IReadInJoyArticleDetailActivity)))
      {
        int i = NetUtil.a(null);
        localObject1 = PreloadManager.a(paramString2);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject1 != null))
        {
          localObject2 = (IReadInJoyArticleDetailActivity)localObject2;
          if (((IReadInJoyArticleDetailActivity)localObject2).a((String)localObject1))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("此时开始读内存");
              ((StringBuilder)localObject1).append(System.currentTimeMillis());
              QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject1).toString());
            }
            long l1 = System.currentTimeMillis();
            localObject1 = ((IReadInJoyArticleDetailActivity)localObject2).a();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("此时在等待结束以后开始读内存的时间为");
              ((StringBuilder)localObject2).append(System.currentTimeMillis());
              QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject2).toString());
            }
            if (localObject1 != null)
            {
              paramString1 = new WebResourceResponse(paramString1, "utf-8", new BufferedInputStream(new ByteArrayInputStream((byte[])localObject1)));
              long l3 = System.currentTimeMillis();
              if (QLog.isColorLevel())
              {
                QLog.i("PubAccountPreloadPlugin", 2, "-->right");
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("在内存中此时结束的时间为");
                ((StringBuilder)localObject2).append(l3);
                QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject2).toString());
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("在内存中读出总共耗时为");
                ((StringBuilder)localObject2).append(l3 - l2);
                QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject2).toString());
              }
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("开始解析的时间");
                ((StringBuilder)localObject2).append(System.currentTimeMillis());
                QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject2).toString());
              }
              this.jdField_a_of_type_JavaUtilList = a(new String((byte[])localObject1), paramString2);
              if (QLog.isColorLevel())
              {
                paramString2 = new StringBuilder();
                paramString2.append("结束解析的时间");
                paramString2.append(System.currentTimeMillis());
                QLog.d("PubAccountPreloadPlugin", 2, paramString2.toString());
              }
              l2 = System.currentTimeMillis();
              paramString2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(i);
              localObject1 = ((StringBuilder)localObject1).toString();
              localObject2 = this.jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(l2 - l1);
              paramString2.publicAccountReportClickEvent(null, "", "0X8007621", "0X8007621", 0, 0, "1", (String)localObject1, (String)localObject2, localStringBuilder.toString());
              return paramString1;
            }
          }
          else
          {
            paramString1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            paramString2 = new StringBuilder();
            paramString2.append("");
            paramString2.append(i);
            paramString1.publicAccountReportClickEvent(null, "", "0X8007621", "0X8007621", 0, 0, "0", paramString2.toString(), this.jdField_a_of_type_JavaLangString, "0");
            return null;
          }
        }
        else
        {
          paramString1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          paramString2 = new StringBuilder();
          paramString2.append("");
          paramString2.append(i);
          paramString1.publicAccountReportClickEvent(null, "", "0X8007621", "0X8007621", 0, 0, "0", paramString2.toString(), this.jdField_a_of_type_JavaLangString, "0");
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
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("http:"))
    {
      if (paramString.startsWith("https")) {
        return paramString;
      }
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https:");
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http:");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      Object localObject = new URL(paramString);
      paramString = ((URL)localObject).getHost();
      localObject = ((URL)localObject).getPath();
      if (("post.mp.qq.com".equalsIgnoreCase(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        boolean bool = ((String)localObject).endsWith(".html");
        if (bool) {
          return true;
        }
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    int i = a(paramString2);
    int j = NetUtil.a(null);
    Object localObject1;
    Object localObject2;
    try
    {
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge != null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge.a(paramString2, i);
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        break label182;
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("timeCost", -1);
        ((JSONObject)localObject2).put("position", i);
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(j);
        localStringBuilder2.append("");
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8007622", "0X8007622", 0, 0, "1", localStringBuilder2.toString(), this.jdField_a_of_type_JavaLangString, ((JSONObject)localObject2).toString());
        return localObject1;
      }
      catch (Exception localException1) {}
      localObject2 = localObject1;
    }
    catch (Exception localException2)
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("PubAccountPreloadPlugin", 2, "shouldInterceptRequest got exception!", localException2);
      localObject2 = localObject1;
    }
    label182:
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("offline image time is : ");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(", url = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2 == null) {
        return localObject2;
      }
      localObject1 = MD5Utils.toMD5(paramString2);
      if (this.mRuntime != null)
      {
        new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE).mkdirs();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = new File(((StringBuilder)localObject2).toString());
        localObject1 = new JSONObject();
        if (((File)localObject2).exists())
        {
          l1 = System.currentTimeMillis();
          paramString1 = a((File)localObject2, paramString2, paramString1);
          long l2 = System.currentTimeMillis();
          try
          {
            ((JSONObject)localObject1).put("timeCost", l2 - l1);
            ((JSONObject)localObject1).put("position", i);
          }
          catch (JSONException paramString2)
          {
            paramString2.printStackTrace();
          }
          paramString2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(j);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("");
          localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
          paramString2.publicAccountReportClickEvent(null, "", "0X8007622", "0X8007622", 0, 0, "1", (String)localObject2, localStringBuilder1.toString(), ((JSONObject)localObject1).toString());
          return paramString1;
        }
        try
        {
          ((JSONObject)localObject1).put("timeCost", 0);
          ((JSONObject)localObject1).put("position", i);
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
        }
        paramString1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(j);
        paramString2 = paramString2.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        paramString1.publicAccountReportClickEvent(null, "", "0X8007622", "0X8007622", 0, 0, "0", paramString2, ((StringBuilder)localObject2).toString(), ((JSONObject)localObject1).toString());
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountPreloadPlugin", 2, "runtime is null");
      }
    }
    return localObject2;
  }
  
  /* Error */
  public WebResourceResponse a(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: new 68	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 359
    //   20: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   29: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 142
    //   35: iconst_2
    //   36: aload 4
    //   38: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aconst_null
    //   45: astore 5
    //   47: aconst_null
    //   48: astore 6
    //   50: aconst_null
    //   51: astore 4
    //   53: new 361	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 367	java/io/FileInputStream:available	()I
    //   66: newarray byte
    //   68: astore 4
    //   70: aload_1
    //   71: aload 4
    //   73: invokevirtual 371	java/io/FileInputStream:read	([B)I
    //   76: pop
    //   77: new 217	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   80: dup
    //   81: aload_3
    //   82: ldc 219
    //   84: new 221	java/io/BufferedInputStream
    //   87: dup
    //   88: new 223	java/io/ByteArrayInputStream
    //   91: dup
    //   92: aload 4
    //   94: invokespecial 226	java/io/ByteArrayInputStream:<init>	([B)V
    //   97: invokespecial 229	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 232	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   103: astore_3
    //   104: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +57 -> 164
    //   110: new 68	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   117: astore 4
    //   119: aload 4
    //   121: ldc_w 373
    //   124: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 4
    //   130: aload_2
    //   131: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 4
    //   137: ldc_w 375
    //   140: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 4
    //   146: invokestatic 171	java/lang/System:currentTimeMillis	()J
    //   149: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 142
    //   155: iconst_2
    //   156: aload 4
    //   158: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_3
    //   165: astore 4
    //   167: aload_1
    //   168: invokevirtual 378	java/io/FileInputStream:close	()V
    //   171: aload_3
    //   172: areturn
    //   173: astore 4
    //   175: aload_3
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: goto +19 -> 199
    //   183: astore_2
    //   184: aload_3
    //   185: astore 4
    //   187: aload_2
    //   188: astore_3
    //   189: goto +17 -> 206
    //   192: astore_2
    //   193: goto +86 -> 279
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_2
    //   199: goto +28 -> 227
    //   202: astore_3
    //   203: aconst_null
    //   204: astore 4
    //   206: aload_1
    //   207: astore_2
    //   208: aload 4
    //   210: astore_1
    //   211: goto +46 -> 257
    //   214: astore_2
    //   215: aload 4
    //   217: astore_1
    //   218: goto +61 -> 279
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_2
    //   224: aload 5
    //   226: astore_1
    //   227: aload_1
    //   228: astore 4
    //   230: aload_3
    //   231: invokevirtual 379	java/lang/OutOfMemoryError:printStackTrace	()V
    //   234: aload_2
    //   235: astore_3
    //   236: aload_1
    //   237: ifnull +40 -> 277
    //   240: aload_1
    //   241: astore_3
    //   242: aload_2
    //   243: astore 4
    //   245: aload_3
    //   246: invokevirtual 378	java/io/FileInputStream:close	()V
    //   249: aload_2
    //   250: areturn
    //   251: astore_3
    //   252: aconst_null
    //   253: astore_1
    //   254: aload 6
    //   256: astore_2
    //   257: aload_2
    //   258: astore 4
    //   260: aload_3
    //   261: invokevirtual 380	java/io/IOException:printStackTrace	()V
    //   264: aload_1
    //   265: astore_3
    //   266: aload_2
    //   267: ifnull +10 -> 277
    //   270: aload_2
    //   271: astore_3
    //   272: aload_1
    //   273: astore_2
    //   274: goto -32 -> 242
    //   277: aload_3
    //   278: areturn
    //   279: aload_1
    //   280: ifnull +7 -> 287
    //   283: aload_1
    //   284: invokevirtual 378	java/io/FileInputStream:close	()V
    //   287: goto +5 -> 292
    //   290: aload_2
    //   291: athrow
    //   292: goto -2 -> 290
    //   295: astore_1
    //   296: aload 4
    //   298: areturn
    //   299: astore_1
    //   300: goto -13 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	PubAccountPreloadPlugin
    //   0	303	1	paramFile	File
    //   0	303	2	paramString1	String
    //   0	303	3	paramString2	String
    //   13	153	4	localObject1	Object
    //   173	5	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   185	112	4	localObject2	Object
    //   45	180	5	localObject3	Object
    //   48	207	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   104	164	173	java/lang/OutOfMemoryError
    //   104	164	183	java/io/IOException
    //   62	104	192	finally
    //   104	164	192	finally
    //   62	104	196	java/lang/OutOfMemoryError
    //   62	104	202	java/io/IOException
    //   53	62	214	finally
    //   230	234	214	finally
    //   260	264	214	finally
    //   53	62	221	java/lang/OutOfMemoryError
    //   53	62	251	java/io/IOException
    //   167	171	295	java/io/IOException
    //   245	249	295	java/io/IOException
    //   283	287	299	java/io/IOException
  }
  
  public List<String> a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramString1 == null) {
        return null;
      }
      boolean bool = paramString2.startsWith("https");
      paramString1 = Pattern.compile("<head>[.\\s\\S\\w]*?</head>").matcher(paramString1);
      if (paramString1.find())
      {
        paramString1 = Pattern.compile("<meta[.\\s\\S\\w]*?/>").matcher(paramString1.group());
        while (paramString1.find()) {
          if (Pattern.compile("itemprop[\\s]*=[\\s]*\"[\\s]*prefetch-images[\\s]*\"").matcher(paramString1.group()).find())
          {
            paramString2 = Pattern.compile("content[\\s]*=[\\s]*\"(.*?)\"").matcher(paramString1.group());
            if (paramString2.find())
            {
              paramString1 = paramString2.group(1);
              break label112;
            }
          }
        }
      }
      paramString1 = null;
      label112:
      if (paramString1 == null) {
        return null;
      }
      paramString2 = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < paramString1.length()) {
        if ((paramString1.charAt(i) != ';') && (i != paramString1.length() - 1))
        {
          i += 1;
        }
        else
        {
          int k;
          if (i == paramString1.length() - 1) {
            k = paramString1.length();
          } else {
            k = i;
          }
          if (k > j)
          {
            String str = a(paramString1.substring(j, k), bool);
            if (str != null)
            {
              paramString2.add(str);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("预下载图片url = ");
                localStringBuilder.append(str);
                QLog.d("PubAccountPreloadPlugin", 2, localStringBuilder.toString());
              }
            }
            j = k + 1;
            i = j;
          }
        }
      }
      return paramString2;
    }
    return null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge.a(paramString, paramBoolean);
  }
  
  public boolean b(String paramString)
  {
    try
    {
      Object localObject = new URL(paramString);
      paramString = ((URL)localObject).getHost();
      localObject = ((URL)localObject).getPath();
      if (("qqpublic.qpic.cn".equalsIgnoreCase(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        boolean bool = ((String)localObject).startsWith("/qq_public/");
        if (bool) {
          return true;
        }
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString == null) {
        return false;
      }
      if (paramString.indexOf("?") != -1) {
        paramString = paramString.substring(0, paramString.indexOf("?"));
      }
      return d(paramString);
    }
    return false;
  }
  
  public boolean d(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountPreloadPlugin", 2, "preDownloadImageUrlList is null");
      }
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((String)((Iterator)localObject).next()).equals(paramString))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("need to preload, url = ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject).toString());
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
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url is ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PubAccountPreloadPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramLong == 8L) && (!TextUtils.isEmpty(paramString)))
    {
      if (a(paramString))
      {
        localObject = ((IRIJPageGenerator)QRoute.api(IRIJPageGenerator.class)).getPageHtmlFromUrl(paramString);
        if (localObject != null) {
          return localObject;
        }
        return a("text/html", paramString);
      }
      if (this.mRuntime != null) {
        localObject = this.mRuntime.a();
      } else {
        localObject = null;
      }
      if ((localObject != null) && ((localObject instanceof IReadInJoyArticleDetailActivity)) && (!this.jdField_a_of_type_Boolean))
      {
        ((IReadInJoyArticleDetailActivity)localObject).b();
        this.jdField_a_of_type_Boolean = true;
      }
      if ((b(paramString)) && (c(paramString))) {
        return b("image/*", paramString);
      }
      paramString = ((IRIJWebResourceUtil)QRoute.api(IRIJWebResourceUtil.class)).getWebResourceResponse(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (((paramLong == 8589934595L) || (paramLong == 8589934594L)) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.mRuntime != null) {
        paramString = this.mRuntime.a();
      } else {
        paramString = null;
      }
      if ((paramString != null) && ((paramString instanceof IReadInJoyArticleDetailActivity)))
      {
        ((IReadInJoyArticleDetailActivity)paramString).b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountPreloadPlugin
 * JD-Core Version:    0.7.0.1
 */