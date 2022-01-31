import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.DataUtils;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class bgjb
  extends bgix
{
  private static final int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  public static WeakReference<CustomWebView> a;
  private static final boolean jdField_a_of_type_Boolean;
  public static WeakReference<Activity> b;
  
  static
  {
    boolean bool = true;
    if (1 == QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheEnable", 1)) {}
    for (;;)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheBufferSize", 16384);
      jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheWhiteList", ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn,imgcache.gtimg.cn,.qq.com,.myqcloud.com,.qqopenapp.com,.qzoneapp.com,.twsapp.com,7.url.cn,8.url.cn,9.url.cn,i.gtimg.cn");
      return;
      bool = false;
    }
  }
  
  private static int a(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getQuery();
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        int k = localObject.indexOf('=');
        if ((k > 0) && (k < localObject.length() - 1) && ("fontId".equalsIgnoreCase(localObject.substring(0, k))))
        {
          i = Integer.parseInt(localObject.substring(k + 1));
          return i;
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneOfflinePluginJsForQQ", 1, paramString.getMessage());
    }
  }
  
  @TargetApi(11)
  public static Object a(AppInterface paramAppInterface, WebView paramWebView, String paramString1, String paramString2)
  {
    Object localObject2;
    Object localObject1;
    if ((paramWebView != null) && (xeh.a(paramWebView)) && (bbee.b(paramString1)) && (!a(paramString1)) && (!b(paramString1)))
    {
      localObject2 = paramWebView.getTag(2131307432);
      localObject1 = paramWebView.getTag(2131307433);
      if ((localObject2 instanceof String))
      {
        localObject2 = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramAppInterface = new BufferedInputStream(new ByteArrayInputStream(((String)localObject2).getBytes("UTF-8")), jdField_a_of_type_Int);
        paramWebView.setTag(2131307432, null);
        paramWebView.setTag(2131307433, null);
        paramWebView = new WebResourceResponse("text/html", "UTF-8", paramAppInterface);
        if (QLog.isColorLevel())
        {
          if ((localObject1 == null) || (!(localObject1 instanceof Long))) {
            break label666;
          }
          l1 = ((Long)localObject1).longValue();
          long l2 = System.currentTimeMillis();
          QLog.i("WebSo", 2, "webview use WebSo! url: " + paramString1 + " , time cost=" + (l2 - l1));
        }
        return paramWebView;
      }
      catch (Exception paramAppInterface)
      {
        QLog.w("QzoneOfflinePluginJsForQQ", 1, "get buffer input stream fail", paramAppInterface);
        return null;
      }
      if (a(paramString1))
      {
        paramWebView = a();
        localObject1 = b(paramString1);
        if ((paramWebView == null) || (!paramWebView.containsKey(localObject1))) {
          break label661;
        }
      }
      label655:
      label661:
      for (paramWebView = (String)paramWebView.get(localObject1);; paramWebView = null)
      {
        if ((paramWebView == null) || (paramWebView.length() == 0))
        {
          b(String.format("not support this ext,url:%s ,minetype:%s", new Object[] { paramString1, paramWebView }));
          return null;
        }
        if (QzoneZipCacheHelper.checkDownloadZip(paramString1)) {}
        for (paramAppInterface = QzoneZipCacheHelper.getFileIfExists(paramAppInterface, paramString1); (paramAppInterface == null) || (!paramAppInterface.exists()); paramAppInterface = QzoneOfflineCacheHelper.downLoadFileIfNeeded(paramAppInterface, paramString1, null, true, paramString2))
        {
          b(String.format("not get offline cache,start download,url:%s ,minetype:%s", new Object[] { paramString1, paramWebView }));
          return null;
        }
        localObject1 = a(paramAppInterface);
        paramString2 = paramWebView;
        if (localObject1 != null)
        {
          paramString2 = paramWebView;
          if (((HashMap)localObject1).get("Content-Type") != null)
          {
            paramString2 = (String)((HashMap)localObject1).get("Content-Type");
            a("Use real Content-Type header as MIME type: " + paramString2);
          }
        }
        for (;;)
        {
          try
          {
            paramAppInterface = new BufferedInputStream(new FileInputStream(paramAppInterface), jdField_a_of_type_Int);
            if ((localObject1 == null) || (!"gzip".equalsIgnoreCase((String)((HashMap)localObject1).get("Content-Encoding")))) {
              break label655;
            }
            if (!b())
            {
              DataUtils.closeDataObject(paramAppInterface);
              return null;
            }
            ((HashMap)localObject1).remove("Content-Encoding");
            a("make gzip inputstream");
            i = 1;
            if (i != 0)
            {
              paramAppInterface = new WebResourceResponse(paramString2, "utf-8", new GZIPInputStream(paramAppInterface));
              a(String.format("[SUCC] get offline cache,url:%s ,minetype:%s", new Object[] { paramString1, paramString2 }));
              paramWebView = paramAppInterface;
              if (localObject1 == null) {
                break;
              }
              paramAppInterface.setResponseHeaders((Map)localObject1);
              return paramAppInterface;
            }
          }
          catch (Exception paramAppInterface)
          {
            QLog.e("QzoneOfflinePluginJsForQQ", 1, "shouldInterceptRequest Exception: " + paramAppInterface);
          }
          for (;;)
          {
            return null;
            paramAppInterface = new WebResourceResponse(paramString2, "utf-8", paramAppInterface);
            break;
            if (b(paramString1)) {
              return a(paramString1);
            }
            if ((bggb.a(paramString2)) && (bggb.b(paramString1))) {
              return new WebResourceResponse("text/javascript", "utf-8", new ByteArrayInputStream("if(1===1){};".getBytes()));
            }
            a(String.format("not get offline cache,not offline,url:%s", new Object[] { paramString1 }));
          }
          int i = 0;
        }
      }
      label666:
      long l1 = 0L;
    }
  }
  
  private static Object a(String paramString)
  {
    int i = a(paramString);
    if (i > 0)
    {
      Object localObject2 = bfuw.a(i, paramString, null, null);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        Object localObject1 = new File((String)localObject2);
        if (!((File)localObject1).exists())
        {
          QLog.e("QzoneOfflinePluginJsForQQ", 1, "getResponse local file not exists :" + (String)localObject2);
          return null;
        }
        try
        {
          localObject2 = new WebResourceResponse("application/octet-stream", "utf-8", new FileInputStream((String)localObject2));
          if (QLog.isColorLevel()) {
            QLog.i("QzoneOfflinePluginJsForQQ", 2, String.format("[SUCC] get offline cache,url : %s,mineType : %s", new Object[] { paramString, "application/octet-stream" }));
          }
          localObject1 = a((File)localObject1);
          if (localObject1 != null) {
            ((WebResourceResponse)localObject2).setResponseHeaders((Map)localObject1);
          }
          return localObject2;
        }
        catch (Exception localException)
        {
          QLog.e("QzoneOfflinePluginJsForQQ", 1, "interceptDownloadFontRequest Exception: " + localException);
        }
      }
    }
    QLog.e("QzoneOfflinePluginJsForQQ", 1, "[FAIL] interceptDownloadFontRequest fontId: +" + i + ",url : " + paramString);
    return null;
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: new 262	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 265	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 344	java/io/FileInputStream:available	()I
    //   15: iconst_1
    //   16: iadd
    //   17: newarray byte
    //   19: astore_2
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 348	java/io/FileInputStream:read	([B)I
    //   27: pop
    //   28: aload_1
    //   29: astore_0
    //   30: new 67	java/lang/String
    //   33: dup
    //   34: aload_2
    //   35: ldc 138
    //   37: invokespecial 351	java/lang/String:<init>	([BLjava/lang/String;)V
    //   40: astore_2
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 354	java/io/FileInputStream:close	()V
    //   49: aload_2
    //   50: areturn
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 357	java/lang/Exception:printStackTrace	()V
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 354	java/io/FileInputStream:close	()V
    //   68: ldc_w 359
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: ifnull +7 -> 83
    //   79: aload_0
    //   80: invokevirtual 354	java/io/FileInputStream:close	()V
    //   83: ldc_w 359
    //   86: areturn
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: astore_2
    //   92: goto -38 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramFile	File
    //   8	57	1	localFileInputStream	FileInputStream
    //   87	1	1	localObject1	Object
    //   19	31	2	localObject2	Object
    //   51	6	2	localException1	Exception
    //   91	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	51	java/lang/Exception
    //   0	9	72	finally
    //   11	20	87	finally
    //   22	28	87	finally
    //   30	41	87	finally
    //   56	60	87	finally
    //   11	20	91	java/lang/Exception
    //   22	28	91	java/lang/Exception
    //   30	41	91	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    boolean bool;
    if (paramInt > 36521)
    {
      i = 1;
      if (paramInt > 0) {
        j = 1;
      }
      bool = a();
      if (!a(paramString)) {
        break label203;
      }
      HashMap localHashMap = a();
      paramString = b(paramString);
      if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
        localStringBuilder.append((String)localHashMap.get(paramString));
      }
    }
    for (;;)
    {
      paramString = localStringBuilder.toString();
      if ((paramString != null) && (paramString.startsWith("image")))
      {
        if ((bool) && (j != 0) && (!paramString.contains("webp"))) {
          localStringBuilder.append(",").append("image/webp");
        }
        if ((bool) && (i != 0) && (!paramString.contains("sharpp"))) {
          localStringBuilder.append(",").append("image/sharpp");
        }
        localStringBuilder.append(",").append("image/*").append(",").append("*/*");
      }
      return localStringBuilder.toString();
      i = 0;
      break;
      label203:
      if (b(paramString)) {
        localStringBuilder.append("application/octet-stream");
      }
    }
  }
  
  private static HashMap<String, String> a()
  {
    return a(QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheExt2MimeType", "{'html':'text/html','css':'text/css','js':'application/javascript','jpg':'image/jpeg','jpeg':'image/jpeg','png':'image/png','bmp':'image/bmp','image':'image','webp':'image/webp'}"));
  }
  
  public static HashMap<String, String> a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = paramFile.getPath() + ".headers";
    a("> getCacheHeadersOfFile: " + paramFile);
    paramFile = new File(paramFile);
    if (paramFile.exists()) {
      try
      {
        paramFile = a(a(paramFile));
        return paramFile;
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    a("> getCacheHeadersOfFile: return null");
    return null;
  }
  
  private static HashMap<String, String> a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        localIterator = localJSONObject.keys();
        if (localIterator == null) {
          break label125;
        }
        if (localIterator.hasNext()) {
          break label120;
        }
      }
      catch (Throwable paramString)
      {
        JSONObject localJSONObject;
        Iterator localIterator;
        String str1;
        String str2;
        return null;
      }
      localObject = paramString;
      if (!localIterator.hasNext()) {
        break;
      }
      str1 = (String)localIterator.next();
      localObject = paramString;
      if (str1 != null)
      {
        str2 = localJSONObject.optString(str1);
        localObject = paramString;
        if (str2 != null)
        {
          localObject = paramString;
          if (paramString == null) {
            localObject = new HashMap();
          }
          ((HashMap)localObject).put(str1, str2);
        }
      }
      paramString = (String)localObject;
      continue;
      label120:
      paramString = null;
    }
    label125:
    return null;
  }
  
  public static void a(String paramString) {}
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "OfflineCacheSupportWebpAndSharppImage", 1) > 0;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = bool2;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    if (paramString.contains("?_offline=1")) {
                      break;
                    }
                    bool1 = bool2;
                  } while (!paramString.contains("&_offline=1"));
                  bool1 = bool2;
                } while (b(paramString));
                bool1 = bool2;
              } while (!jdField_a_of_type_Boolean);
              if (!paramString.contains("_proxy=")) {
                break;
              }
              bool1 = bool2;
            } while (paramString.contains("?_proxy=1"));
            bool1 = bool2;
          } while (paramString.contains("&_proxy=1"));
          bool1 = bool2;
        } while (paramString.contains("?_proxy=true"));
        bool1 = bool2;
      } while (paramString.contains("&_proxy=true"));
      bool2 = c(a(paramString));
      bool1 = bool2;
    } while (!bool2);
    a("走offline url=" + paramString);
    return bool2;
  }
  
  public static String b(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = new URL(paramString);
        Object localObject1 = paramString.getQuery();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split("&");
          if (localObject1 != null)
          {
            int j = localObject1.length;
            if (i < j)
            {
              Object localObject2 = localObject1[i];
              int k = localObject2.indexOf('=');
              if ((k <= 0) || (k >= localObject2.length() - 1) || (!"_fileExt".equalsIgnoreCase(localObject2.substring(0, k)))) {
                break label143;
              }
              return localObject2.substring(k + 1);
            }
          }
        }
        paramString = paramString.getPath();
        if (paramString != null)
        {
          i = paramString.lastIndexOf(".");
          if ((i >= 0) && (i < paramString.length() - 1))
          {
            paramString = paramString.substring(i + 1);
            return paramString;
          }
        }
      }
      catch (Throwable paramString) {}
      return null;
      label143:
      i += 1;
    }
  }
  
  private static void b(String paramString)
  {
    if ((!QLog.isDevelopLevel()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    QLog.i("QzoneOfflinePluginJsForQQ", 4, paramString);
  }
  
  public static boolean b()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "OfflineCacheSupportGZip", 1) > 0;
  }
  
  public static boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1")))) {}
    while ((!paramString.contains("&fontId=")) && (!paramString.contains("?fontId="))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return false;
    }
    localObject = ((String)localObject).split(",");
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      if (str == null) {}
      label94:
      do
      {
        do
        {
          i += 1;
          break;
          str = str.trim();
          if (!str.startsWith(".")) {
            break label94;
          }
        } while (!paramString.endsWith(str));
        return true;
      } while (!paramString.equals(str));
      return true;
    }
    return false;
  }
  
  public Object a(String paramString, long paramLong)
  {
    Object localObject1 = null;
    if (paramLong == 8L)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
        break label192;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
      b = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    }
    for (;;)
    {
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if (localObject2 == null) {
          break label174;
        }
        localObject2 = ((Activity)localObject2).getIntent();
        label121:
        if (localObject2 == null) {
          break label180;
        }
        localObject2 = ((Intent)localObject2).getStringExtra("url");
        label136:
        if (jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label186;
        }
      }
      label174:
      label180:
      label186:
      for (CustomWebView localCustomWebView = (CustomWebView)jdField_a_of_type_JavaLangRefWeakReference.get();; localCustomWebView = null)
      {
        localObject1 = a((AppInterface)localObject1, localCustomWebView, paramString, (String)localObject2);
        return localObject1;
        localObject2 = null;
        break;
        localObject2 = null;
        break label121;
        localObject2 = null;
        break label136;
      }
      label192:
      localObject1 = null;
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgjb
 * JD-Core Version:    0.7.0.1
 */