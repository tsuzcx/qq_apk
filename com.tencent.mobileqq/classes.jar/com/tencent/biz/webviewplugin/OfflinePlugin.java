package com.tencent.biz.webviewplugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.HtmlOffline.MyWebResourceResponse;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.OfflinePluginInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflinePlugin
  extends WebViewPlugin
{
  static final int jdField_a_of_type_Int = Build.VERSION.SDK_INT;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static HashMap<String, OfflineUpdateStatus> a;
  public static ConcurrentHashMap<String, ArrayList<String>> a;
  public static HashMap<String, String> b;
  private static boolean g = false;
  public volatile long a;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new OfflinePlugin.7(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private LoadedBack2 jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2 = new OfflinePlugin.8(this);
  public OfflineWebResManager a;
  public Runnable a;
  public String a;
  public HashSet<String> a;
  protected CopyOnWriteArrayList<String> a;
  protected CopyOnWriteArraySet<String> a;
  public AtomicBoolean a;
  public AtomicInteger a;
  boolean jdField_a_of_type_Boolean = false;
  public volatile int b;
  public volatile long b;
  public String b;
  boolean b;
  public volatile int c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private String d;
  public volatile boolean d;
  public volatile boolean e = false;
  public boolean f = false;
  private boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public OfflinePlugin()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new OfflinePlugin.9(this);
    this.mPluginNameSpace = "offline";
  }
  
  public static long a(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = a(paramCustomWebView);
    if (paramCustomWebView != null) {
      return paramCustomWebView.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public static OfflinePlugin a(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = paramCustomWebView.getPluginEngine();
    if (paramCustomWebView != null)
    {
      paramCustomWebView = paramCustomWebView.a("offline");
      if ((paramCustomWebView instanceof OfflinePlugin)) {
        return (OfflinePlugin)paramCustomWebView;
      }
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    String str = paramString3;
    if (jdField_a_of_type_AndroidContentContext == null) {
      jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    }
    int i;
    if (jdField_a_of_type_AndroidContentContext != null) {
      i = NetworkUtil.getNetWorkType();
    } else {
      i = -1;
    }
    if ((!TextUtils.isEmpty(paramString3)) && ((str.startsWith("http")) || (str.startsWith("https"))))
    {
      int j = str.indexOf("?");
      paramString3 = str;
      if (j != -1) {
        paramString3 = str.substring(0, j);
      }
    }
    else
    {
      paramString3 = "";
    }
    ReportController.b(null, "P_CliOper", "OfflineStatusReport", "", paramString2, paramString1, paramInt1, 1, paramInt2, paramString3, paramString4, paramString5, String.valueOf(i));
  }
  
  public static boolean a()
  {
    Integer[] arrayOfInteger = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
    if ((arrayOfInteger != null) && (arrayOfInteger[13].intValue() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflinePluginQQ", 2, "now enable service worker!");
      }
      return true;
    }
    QLog.e("OfflinePluginQQ", 1, "disable service worker!");
    return false;
  }
  
  public static boolean a(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = a(paramCustomWebView);
    return (paramCustomWebView != null) && (paramCustomWebView.f);
  }
  
  public static long b(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = a(paramCustomWebView);
    if (paramCustomWebView != null) {
      return paramCustomWebView.jdField_b_of_type_Long;
    }
    return 0L;
  }
  
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    String str = HtmlOffline.d(paramString1);
    boolean bool = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    Object localObject = null;
    int i;
    if ((!bool) && (paramString2.equals(this.jdField_c_of_type_JavaLangString)))
    {
      i = 0;
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet == null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString2))
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString2);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("now begin check ex bid : ");
          localStringBuilder.append(paramString2);
          QLog.i("OfflinePluginQQ", 2, localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OfflinePlugin_verifySign_");
        localStringBuilder.append(paramString2);
        Util.a(localStringBuilder.toString());
        bool = HtmlOffline.c(paramString2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OfflinePlugin_verifySign_");
        localStringBuilder.append(paramString2);
        Util.b(localStringBuilder.toString());
        if ((bool ^ true))
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "verfySign fail to reload");
          }
          return null;
        }
      }
      i = 1;
    }
    if ((this.jdField_b_of_type_Int == 3) || (i != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OfflinePlugin_verifySingleFile_");
      localStringBuilder.append(str);
      Util.a(localStringBuilder.toString());
      bool = HtmlOffline.a(paramString2, paramString1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OfflinePlugin_verifySingleFile_");
      localStringBuilder.append(str);
      Util.b(localStringBuilder.toString());
      if ((bool ^ true))
      {
        if (i == 0)
        {
          this.e = true;
          c();
        }
        a(paramString2, "Offline_InterceptRequest", 0, 3, paramString1, "", "");
        if (QLog.isColorLevel()) {
          QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest verfy single fail to reload");
        }
        return null;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OfflinePlugin_offlineGetResponse_");
    localStringBuilder.append(str);
    Util.a(localStringBuilder.toString());
    paramString1 = HtmlOffline.a(paramString2, paramString1);
    if (paramString1 == null) {
      paramString1 = localObject;
    } else {
      paramString1 = new WebResourceResponse(paramString1.jdField_a_of_type_JavaLangString, "utf-8", paramString1.jdField_a_of_type_JavaIoInputStream);
    }
    paramString2 = new StringBuilder();
    paramString2.append("OfflinePlugin_offlineGetResponse_");
    paramString2.append(str);
    Util.b(paramString2.toString());
    if (paramString1 != null)
    {
      this.h = true;
      if (i == 0) {
        this.f = true;
      }
    }
    return paramString1;
  }
  
  public static boolean b(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = a(paramCustomWebView);
    return (paramCustomWebView != null) && (paramCustomWebView.e);
  }
  
  private boolean b(String paramString)
  {
    paramString = SwiftBrowserOfflineHandler.a(paramString);
    if (paramString != null)
    {
      paramString.b();
      if (SwiftBrowserOfflineHandler.c.get() == 4)
      {
        this.jdField_c_of_type_JavaLangString = null;
        this.jdField_c_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  public static void c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new OfflinePlugin.10(paramString));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler = new OfflinePlugin.2(this, Looper.getMainLooper());
  }
  
  public static void d(String paramString)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    paramString = SwiftBrowserOfflineHandler.b(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  private void e()
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    Object localObject = (ViewStub)this.mRuntime.a().findViewById(2131363809);
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((ViewStub)localObject).inflate());
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((RelativeLayout)localObject).findViewById(2131368081));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368082));
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368076));
      }
    }
  }
  
  private void e(String paramString)
  {
    if (this.jdField_b_of_type_Long == -1L)
    {
      Object localObject = this.mRuntime.a();
      WebViewProvider localWebViewProvider = this.mRuntime.a();
      if (localWebViewProvider != null)
      {
        localObject = localWebViewProvider.getRedirect302Url();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
        }
      }
      else if ((localObject instanceof WebUiUtils.OfflinePluginInterface))
      {
        localObject = ((WebUiUtils.OfflinePluginInterface)localObject).getRedirect302Url();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
        }
      }
      localObject = HtmlOffline.d(this.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l;
        if (((String)localObject).equalsIgnoreCase(paramString)) {
          l = System.currentTimeMillis();
        } else {
          l = -1L;
        }
        this.jdField_b_of_type_Long = l;
        if ((QLog.isColorLevel()) && (this.jdField_b_of_type_Long != -1L)) {
          QLog.d("OfflinePluginQQ", 2, "read index offline res!");
        }
      }
    }
  }
  
  public WebResourceResponse a(String paramString)
  {
    if (AppSetting.g) {
      return null;
    }
    if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramString)))
    {
      if (!paramString.startsWith("http")) {
        return null;
      }
      Object localObject2 = Uri.parse(paramString).getQueryParameter("_bid");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_c_of_type_JavaLangString;
      }
      localObject2 = SwiftOfflineDataUtils.a(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject2).jdField_b_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadRes");
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(localObject1);
        return new WebResourceResponse(((SwiftOfflineDataUtils.OfflineData)localObject2).jdField_a_of_type_JavaLangString, ((SwiftOfflineDataUtils.OfflineData)localObject2).jdField_c_of_type_JavaLangString, new BufferedInputStream(new ByteArrayInputStream(((SwiftOfflineDataUtils.OfflineData)localObject2).jdField_b_of_type_JavaLangString.getBytes())));
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        if (!((String)localObject1).equals(this.jdField_c_of_type_JavaLangString)) {
          if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
              this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
            }
            if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)) {
              this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramString);
            }
          }
          else
          {
            b(paramString);
          }
        }
        localObject2 = OfflineEnvHelper.a((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return null;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(File.separator);
        localObject2 = ((StringBuilder)localObject3).toString();
        String str = HtmlOffline.d(paramString);
        Object localObject4;
        if (((String)localObject1).equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject3 = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
          if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
            break label559;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(str);
          if (!((ArrayList)localObject3).contains(((StringBuilder)localObject4).toString())) {
            return null;
          }
        }
        localObject3 = a(paramString, (String)localObject1);
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = b(paramString, (String)localObject1);
        }
        if (localObject2 != null)
        {
          if (((String)localObject1).equals(this.jdField_c_of_type_JavaLangString)) {
            this.f = true;
          }
          localObject4 = ((WebResourceResponse)localObject2).getResponseHeaders();
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = new HashMap();
          }
          ((Map)localObject3).put("Access-Control-Allow-Origin", "*");
          ((WebResourceResponse)localObject2).setResponseHeaders((Map)localObject3);
          OfflineWebResManager.a(paramString);
          e(str);
        }
        if (localObject2 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Url(");
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(") uses the offline res");
          QLog.d("OfflinePluginQQ", 2, ((StringBuilder)localObject3).toString());
          this.jdField_a_of_type_JavaUtilHashSet.add(localObject1);
          return localObject2;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Url(");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(") does not  use the offline res");
        QLog.d("OfflinePluginQQ", 2, ((StringBuilder)localObject1).toString());
        return localObject2;
      }
      catch (Exception paramString)
      {
        QLog.e("OfflinePluginQQ", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
      }
    }
    else
    {
      return null;
    }
    label559:
    return null;
  }
  
  /* Error */
  public WebResourceResponse a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 435	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 547	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   7: ifnull +28 -> 35
    //   10: getstatic 547	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_2
    //   14: invokevirtual 550	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +18 -> 35
    //   20: getstatic 547	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_2
    //   24: invokevirtual 502	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 177	java/lang/String
    //   30: astore 13
    //   32: goto +178 -> 210
    //   35: new 265	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   42: astore 12
    //   44: aload 12
    //   46: aload_2
    //   47: invokestatic 495	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 12
    //   56: aload_2
    //   57: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 12
    //   63: ldc_w 552
    //   66: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 12
    //   72: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 12
    //   77: new 497	java/io/File
    //   80: dup
    //   81: aload 12
    //   83: invokespecial 553	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 556	java/io/File:exists	()Z
    //   89: istore 11
    //   91: iload 11
    //   93: ifne +5 -> 98
    //   96: aconst_null
    //   97: areturn
    //   98: new 469	java/io/BufferedInputStream
    //   101: dup
    //   102: new 558	java/io/FileInputStream
    //   105: dup
    //   106: aload 12
    //   108: invokespecial 559	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: invokespecial 481	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore 12
    //   116: aload 12
    //   118: astore 13
    //   120: aload 12
    //   122: invokestatic 564	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   125: astore 15
    //   127: aload 12
    //   129: astore 13
    //   131: getstatic 547	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   134: aload_2
    //   135: aload 15
    //   137: invokevirtual 565	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aload 15
    //   143: astore_2
    //   144: aload 12
    //   146: invokevirtual 568	java/io/BufferedInputStream:close	()V
    //   149: aload_2
    //   150: astore 13
    //   152: goto +58 -> 210
    //   155: astore 14
    //   157: aload 15
    //   159: astore_2
    //   160: goto +24 -> 184
    //   163: astore 14
    //   165: aconst_null
    //   166: astore_2
    //   167: goto +17 -> 184
    //   170: astore_1
    //   171: aconst_null
    //   172: astore 13
    //   174: goto +489 -> 663
    //   177: astore 14
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: astore 12
    //   184: aload 12
    //   186: astore 13
    //   188: ldc 229
    //   190: iconst_1
    //   191: aload 14
    //   193: invokevirtual 571	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_2
    //   200: astore 13
    //   202: aload 12
    //   204: ifnull +6 -> 210
    //   207: goto -63 -> 144
    //   210: invokestatic 435	java/lang/System:currentTimeMillis	()J
    //   213: lstore 5
    //   215: aload 13
    //   217: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +5 -> 225
    //   223: aconst_null
    //   224: areturn
    //   225: new 573	org/json/JSONObject
    //   228: dup
    //   229: aload 13
    //   231: invokespecial 574	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   234: astore_2
    //   235: aload_1
    //   236: invokestatic 246	com/tencent/biz/common/offline/HtmlOffline:d	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 12
    //   241: aload_2
    //   242: aload 12
    //   244: invokevirtual 577	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: astore_2
    //   248: invokestatic 435	java/lang/System:currentTimeMillis	()J
    //   251: lstore 7
    //   253: getstatic 583	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   256: aconst_null
    //   257: invokevirtual 587	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   260: astore 13
    //   262: getstatic 590	mqq/app/MobileQQ:sProcessId	I
    //   265: bipush 7
    //   267: if_icmpne +40 -> 307
    //   270: aload 13
    //   272: ldc_w 592
    //   275: invokevirtual 598	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   278: astore 13
    //   280: aload 13
    //   282: instanceof 600
    //   285: ifeq +46 -> 331
    //   288: aload_0
    //   289: new 532	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   292: dup
    //   293: aload 13
    //   295: checkcast 600	com/tencent/common/app/AppInterface
    //   298: invokespecial 603	com/tencent/biz/webviewplugin/OfflineWebResManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   301: putfield 605	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   304: goto +27 -> 331
    //   307: aload 13
    //   309: instanceof 600
    //   312: ifeq +19 -> 331
    //   315: aload_0
    //   316: new 532	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   319: dup
    //   320: aload 13
    //   322: checkcast 600	com/tencent/common/app/AppInterface
    //   325: invokespecial 603	com/tencent/biz/webviewplugin/OfflineWebResManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   328: putfield 605	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   331: aload_0
    //   332: getfield 605	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   335: ifnonnull +5 -> 340
    //   338: aconst_null
    //   339: areturn
    //   340: aload_0
    //   341: getfield 605	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   344: aload_2
    //   345: invokevirtual 608	com/tencent/biz/webviewplugin/OfflineWebResManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   348: astore 13
    //   350: invokestatic 435	java/lang/System:currentTimeMillis	()J
    //   353: lstore 9
    //   355: aload 13
    //   357: ifnonnull +5 -> 362
    //   360: aconst_null
    //   361: areturn
    //   362: new 497	java/io/File
    //   365: dup
    //   366: invokestatic 161	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   369: invokevirtual 612	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   372: ldc_w 614
    //   375: invokespecial 617	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   378: astore 14
    //   380: aload 14
    //   382: invokevirtual 556	java/io/File:exists	()Z
    //   385: ifne +13 -> 398
    //   388: aload 14
    //   390: invokevirtual 620	java/io/File:mkdirs	()Z
    //   393: ifne +5 -> 398
    //   396: aconst_null
    //   397: areturn
    //   398: ldc_w 622
    //   401: astore_2
    //   402: aload 12
    //   404: ldc_w 624
    //   407: invokevirtual 626	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   410: ifeq +10 -> 420
    //   413: ldc_w 628
    //   416: astore_2
    //   417: goto +68 -> 485
    //   420: aload 12
    //   422: ldc_w 630
    //   425: invokevirtual 626	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   428: ifeq +10 -> 438
    //   431: ldc_w 632
    //   434: astore_2
    //   435: goto +50 -> 485
    //   438: aload 12
    //   440: ldc_w 634
    //   443: invokevirtual 626	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   446: ifne +242 -> 688
    //   449: aload 12
    //   451: ldc_w 636
    //   454: invokevirtual 626	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   457: ifne +231 -> 688
    //   460: aload 12
    //   462: ldc_w 638
    //   465: invokevirtual 626	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   468: ifne +220 -> 688
    //   471: aload 12
    //   473: ldc_w 640
    //   476: invokevirtual 626	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +6 -> 485
    //   482: goto +206 -> 688
    //   485: new 497	java/io/File
    //   488: dup
    //   489: aload 14
    //   491: aload 13
    //   493: getfield 645	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   496: invokespecial 617	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   499: astore 12
    //   501: aload 12
    //   503: invokevirtual 556	java/io/File:exists	()Z
    //   506: ifeq +191 -> 697
    //   509: new 314	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   512: dup
    //   513: aload_2
    //   514: ldc_w 320
    //   517: new 469	java/io/BufferedInputStream
    //   520: dup
    //   521: new 558	java/io/FileInputStream
    //   524: dup
    //   525: aload 12
    //   527: invokespecial 648	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   530: invokespecial 481	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   533: invokespecial 326	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   536: astore_2
    //   537: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +155 -> 695
    //   543: new 265	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   550: astore 12
    //   552: aload 12
    //   554: ldc_w 650
    //   557: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 12
    //   563: lload 5
    //   565: lload_3
    //   566: lsub
    //   567: invokevirtual 653	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 12
    //   573: ldc_w 655
    //   576: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 12
    //   582: lload 7
    //   584: lload 5
    //   586: lsub
    //   587: invokevirtual 653	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 12
    //   593: ldc_w 657
    //   596: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 12
    //   602: lload 9
    //   604: lload 7
    //   606: lsub
    //   607: invokevirtual 653	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 12
    //   613: ldc_w 659
    //   616: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 12
    //   622: invokestatic 435	java/lang/System:currentTimeMillis	()J
    //   625: lload_3
    //   626: lsub
    //   627: invokevirtual 653	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 12
    //   633: ldc_w 661
    //   636: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 12
    //   642: aload_1
    //   643: invokestatic 246	com/tencent/biz/common/offline/HtmlOffline:d	(Ljava/lang/String;)Ljava/lang/String;
    //   646: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: ldc 229
    //   652: iconst_2
    //   653: aload 12
    //   655: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload_2
    //   662: areturn
    //   663: aload 13
    //   665: ifnull +8 -> 673
    //   668: aload 13
    //   670: invokevirtual 568	java/io/BufferedInputStream:close	()V
    //   673: aload_1
    //   674: athrow
    //   675: astore_1
    //   676: ldc 229
    //   678: iconst_1
    //   679: ldc_w 663
    //   682: aload_1
    //   683: invokestatic 546	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aconst_null
    //   687: areturn
    //   688: ldc_w 665
    //   691: astore_2
    //   692: goto -207 -> 485
    //   695: aload_2
    //   696: areturn
    //   697: aconst_null
    //   698: areturn
    //   699: astore_1
    //   700: goto -37 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	703	0	this	OfflinePlugin
    //   0	703	1	paramString1	String
    //   0	703	2	paramString2	String
    //   3	623	3	l1	long
    //   213	372	5	l2	long
    //   251	354	7	l3	long
    //   353	250	9	l4	long
    //   89	3	11	bool	boolean
    //   42	612	12	localObject1	Object
    //   30	639	13	localObject2	Object
    //   155	1	14	localException1	Exception
    //   163	1	14	localException2	Exception
    //   177	15	14	localException3	Exception
    //   378	112	14	localFile	File
    //   125	33	15	str	String
    // Exception table:
    //   from	to	target	type
    //   131	141	155	java/lang/Exception
    //   120	127	163	java/lang/Exception
    //   98	116	170	finally
    //   98	116	177	java/lang/Exception
    //   0	32	675	java/lang/Exception
    //   35	91	675	java/lang/Exception
    //   144	149	675	java/lang/Exception
    //   210	223	675	java/lang/Exception
    //   225	304	675	java/lang/Exception
    //   307	331	675	java/lang/Exception
    //   331	338	675	java/lang/Exception
    //   340	355	675	java/lang/Exception
    //   362	396	675	java/lang/Exception
    //   402	413	675	java/lang/Exception
    //   420	431	675	java/lang/Exception
    //   438	471	675	java/lang/Exception
    //   471	482	675	java/lang/Exception
    //   485	661	675	java/lang/Exception
    //   668	673	675	java/lang/Exception
    //   673	675	675	java/lang/Exception
    //   120	127	699	finally
    //   131	141	699	finally
    //   188	199	699	finally
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offlien:checkOfflineUrl");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!Uri.parse(paramString).isHierarchical()) {
        return paramString;
      }
      try
      {
        this.jdField_c_of_type_JavaLangString = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.jdField_d_of_type_JavaLangString == null) {
          this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentBizAuthorizeConfig;
        if (localObject != null)
        {
          this.jdField_c_of_type_JavaLangString = ((AuthorizeConfig)localObject).a(paramString);
          if (this.jdField_d_of_type_JavaLangString == null) {
            this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          }
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("_bid=");
            ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
            localObject = HtmlOffline.a(paramString, ((StringBuilder)localObject).toString());
            break label163;
          }
        }
      }
      Object localObject = paramString;
      label163:
      if (b((String)localObject)) {
        return paramString;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("-->offline:checkOfflineUrl:");
        paramString.append(Util.b((String)localObject, new String[0]));
        QLog.i("OfflinePluginQQ", 2, paramString.toString());
      }
      return localObject;
    }
    return paramString;
  }
  
  @TargetApi(11)
  public void a()
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    if (localCustomWebView.getX5WebViewExtension() == null) {
      return;
    }
    String str1 = localCustomWebView.getUrl();
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    Object localObject = Uri.parse(str1);
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      String str2 = ((Uri)localObject).getQueryParameter("_sw");
      if ((!"1".equals(str2)) && (!"0".equals(str2)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("url doesn't support ServiceWorker! ");
          ((StringBuilder)localObject).append(Util.b(str1, new String[0]));
          QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      int i = str1.indexOf("?");
      localObject = str1;
      if (i != -1) {
        localObject = str1.substring(0, i);
      }
      ThreadManager.post(new OfflinePlugin.6(this, (String)localObject, str2, localCustomWebView), 8, null, false);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url is illegal! ");
      ((StringBuilder)localObject).append(str1);
      QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->offline:checkOfflineUp,url=");
      localStringBuilder.append(paramString);
      QLog.i("OfflinePluginQQ", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp.");
    }
    HtmlOffline.a(paramString, this.mRuntime.a(), new OfflinePlugin.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = (SwiftBrowserStatistics)getBrowserComponent(-2);
    if (localObject != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((SwiftBrowserStatistics)localObject).x = bool;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OfflinePlugin handleSchemaRequest loadMode: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(", bid: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", cost: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject).toString());
      }
      a(paramString);
      a(this.jdField_c_of_type_JavaLangString, "Offline_Check", this.jdField_c_of_type_Int, 2, paramString, String.valueOf(this.jdField_b_of_type_Int), "");
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      return;
    }
    Object localObject1 = this.mRuntime.a();
    if (localObject1 == null) {
      return;
    }
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if ((OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString) != null) {
      return;
    }
    Object localObject2 = new OfflineUpdateStatus(this.jdField_d_of_type_JavaLangString);
    ((OfflineUpdateStatus)localObject2).a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
    Object localObject3 = paramJSONObject.optJSONObject("wording");
    if (localObject3 != null)
    {
      ((OfflineUpdateStatus)localObject2).jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).optString("nonWifiUpdatingText");
      ((OfflineUpdateStatus)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("wifiUpdatingText");
      ((OfflineUpdateStatus)localObject2).jdField_d_of_type_JavaLangString = ((JSONObject)localObject3).optString("updateCompletedText");
    }
    ((OfflineUpdateStatus)localObject2).e = ((Activity)localObject1).getResources().getString(2131696090);
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_d_of_type_JavaLangString, localObject2);
    localObject3 = paramJSONObject.optString("url");
    ((OfflineUpdateStatus)localObject2).f = ((String)localObject3);
    int i = paramJSONObject.optInt("filesize");
    ((OfflineUpdateStatus)localObject2).jdField_a_of_type_Int = i;
    paramJSONObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramJSONObject != null) {
      paramJSONObject.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if (NetworkUtil.isWifiConnected(((Activity)localObject1).getApplicationContext()))
    {
      ((OfflineUpdateStatus)localObject2).e = ((OfflineUpdateStatus)localObject2).jdField_b_of_type_JavaLangString;
      paramJSONObject = ((OfflineUpdateStatus)localObject2).e;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i > 0))
      {
        e();
        ((OfflineUpdateStatus)localObject2).a(1);
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localTextView != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramJSONObject);
          localStringBuilder.append("0%");
          localTextView.setText(localStringBuilder.toString());
        }
        paramJSONObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
        if (paramJSONObject != null) {
          paramJSONObject.setProgress(0);
        }
        paramJSONObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        HtmlOffline.a(((Activity)localObject1).getApplicationContext(), this.jdField_d_of_type_JavaLangString, (String)localObject3, i, (AsyncBack)localObject2);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      }
    }
    else
    {
      paramJSONObject = ((OfflineUpdateStatus)localObject2).jdField_c_of_type_JavaLangString;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i > 0))
      {
        e();
        ((OfflineUpdateStatus)localObject2).a(0);
        localObject1 = ((Activity)localObject1).getResources().getDrawable(2130845046);
        ((Drawable)localObject1).setBounds(0, 0, 40, 40);
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject2 != null) {
          ((TextView)localObject2).setCompoundDrawables((Drawable)localObject1, null, null, null);
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(paramJSONObject);
        }
        paramJSONObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
        if (paramJSONObject != null) {
          paramJSONObject.setProgress(0);
        }
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    try
    {
      localObject1 = Uri.parse(paramString).getQueryParameter("_duck");
    }
    catch (Exception localException1)
    {
      Object localObject1;
      label14:
      label78:
      break label14;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkOfflineUpr:url parse exception:");
      ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
      QLog.e("QQBrowserActivity", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = "0";
    try
    {
      localObject2 = Uri.parse(paramString).getQueryParameter("_discheck");
    }
    catch (Exception localException2)
    {
      Object localObject2;
      break label78;
    }
    localObject2 = localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkOfflineUpr:url parse exception:");
      ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
      QLog.e("QQBrowserActivity", 2, ((StringBuilder)localObject2).toString());
      localObject2 = localObject1;
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(paramString);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals("1")))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("has discheck ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("OfflineCheck", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("no discheck ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("OfflineCheck", 2, ((StringBuilder)localObject1).toString());
    }
    return true;
  }
  
  public String b(String paramString)
  {
    String str = OfflineEnvHelper.a(paramString);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
      if (localOfflineUpdateStatus != null) {
        localOfflineUpdateStatus.a();
      }
    }
    c();
  }
  
  protected void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(paramString, this.mRuntime.a());
  }
  
  protected void c()
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)))
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null)
      {
        localCustomWebView.loadUrl(((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).getCurrentUrl());
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "reloadCurrentUrl");
        }
      }
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 42L;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return a(paramString);
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject;
    if (paramLong == 2L)
    {
      if (this.mRuntime == null)
      {
        QLog.e("OfflinePluginQQ", 1, "handleEvent error mRuntime == null");
        return false;
      }
      paramMap = this.mRuntime.a();
      paramString = this.mRuntime.a(this.mRuntime.a());
      if (paramString != null)
      {
        if (!(paramString instanceof WebUiUtils.QQBrowserBaseActivityInterface)) {
          return false;
        }
        paramString = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
        {
          paramString = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
          if (paramString != null)
          {
            e();
            paramString.a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
            localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
            if (localObject != null) {
              ((RelativeLayout)localObject).setVisibility(0);
            }
            localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
            if (localObject != null) {
              ((LinearLayout)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            }
            int i = paramString.b();
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2)
                {
                  if (i != 3)
                  {
                    if (i != 4) {
                      return false;
                    }
                    paramString = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
                    if (paramString != null)
                    {
                      paramString.setVisibility(8);
                      return false;
                    }
                  }
                  else
                  {
                    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
                    if (localObject != null) {
                      ((TextView)localObject).setText(paramString.jdField_d_of_type_JavaLangString);
                    }
                    if (paramMap == null) {
                      return false;
                    }
                    paramString = paramMap.getResources().getDrawable(2130839376);
                    paramString.setBounds(0, 0, paramString.getMinimumWidth(), paramString.getMinimumHeight());
                    paramMap = this.jdField_a_of_type_AndroidWidgetTextView;
                    if (paramMap != null) {
                      paramMap.setCompoundDrawables(paramString, null, null, null);
                    }
                    paramString = this.jdField_a_of_type_AndroidWidgetProgressBar;
                    if (paramString != null) {
                      paramString.setVisibility(8);
                    }
                    paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout;
                    if (paramString != null)
                    {
                      paramString.setVisibility(0);
                      return false;
                    }
                  }
                }
                else
                {
                  paramMap = this.jdField_a_of_type_AndroidWidgetProgressBar;
                  if (paramMap != null) {
                    paramMap.setProgress(paramString.c());
                  }
                  paramString = this.jdField_a_of_type_AndroidWidgetProgressBar;
                  if (paramString != null) {
                    paramString.setVisibility(0);
                  }
                  paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout;
                  if (paramString != null)
                  {
                    paramString.setVisibility(8);
                    return false;
                  }
                }
              }
              else
              {
                paramMap = this.jdField_a_of_type_AndroidWidgetTextView;
                if (paramMap != null)
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramString.e);
                  ((StringBuilder)localObject).append(paramString.c());
                  ((StringBuilder)localObject).append("%");
                  paramMap.setText(((StringBuilder)localObject).toString());
                }
                paramString = this.jdField_a_of_type_AndroidWidgetProgressBar;
                if (paramString != null) {
                  paramString.setVisibility(0);
                }
                paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout;
                if (paramString != null)
                {
                  paramString.setVisibility(0);
                  return false;
                }
              }
            }
            else
            {
              localObject = this.jdField_a_of_type_AndroidWidgetTextView;
              if (localObject != null) {
                ((TextView)localObject).setText(paramString.jdField_c_of_type_JavaLangString);
              }
              if (paramMap == null) {
                return false;
              }
              paramString = paramMap.getResources().getDrawable(2130845046);
              paramString.setBounds(0, 0, 40, 40);
              paramMap = this.jdField_a_of_type_AndroidWidgetTextView;
              if (paramMap != null) {
                paramMap.setCompoundDrawables(paramString, null, null, null);
              }
              paramString = this.jdField_a_of_type_AndroidWidgetProgressBar;
              if (paramString != null) {
                paramString.setVisibility(0);
              }
              paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout;
              if (paramString != null)
              {
                paramString.setVisibility(0);
                return false;
              }
            }
          }
        }
      }
      else
      {
        return false;
      }
    }
    else if (paramLong == 8589934594L)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManager.post(new OfflinePlugin.5(this), 5, null, false);
      paramString = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager;
      if (paramString != null)
      {
        paramString.a(5);
        return false;
      }
    }
    else
    {
      if (paramLong == 8589934601L)
      {
        paramString = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager;
        if (paramString != null) {
          paramString.a(0);
        }
        a();
        return false;
      }
      if (paramLong == 32L)
      {
        if (this.mRuntime == null) {
          return false;
        }
        paramMap = this.mRuntime.a();
        if (paramMap.getX5WebViewExtension() != null)
        {
          localObject = SwiftOfflineDataUtils.a(paramString);
          if ((localObject != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject).jdField_b_of_type_JavaLangString)))
          {
            handleSchemaRequest(paramString, SwiftWebViewUtils.b(paramString));
            paramMap.loadDataWithBaseURL(paramString, ((SwiftOfflineDataUtils.OfflineData)localObject).jdField_b_of_type_JavaLangString, "text/html", "utf-8", paramString);
            if (QLog.isColorLevel()) {
              QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadUrl");
            }
            return true;
          }
        }
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("offline".equals(paramString2))
    {
      boolean bool = "clearCache".equals(paramString3);
      paramString2 = null;
      paramString1 = null;
      if ((bool) && (paramVarArgs.length > 0))
      {
        paramJsBridgeListener = paramString1;
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1;
          paramString2 = paramString3.optString("bid");
          paramJsBridgeListener = paramString1;
          paramString1 = paramString3.optString("callback");
          paramJsBridgeListener = paramString1;
          HtmlOffline.a(this.mRuntime.a(), paramString2, 1);
          paramJsBridgeListener = paramString1;
          paramString2 = new JSONObject();
          paramJsBridgeListener = paramString1;
          paramString2.put("retcode", 0);
          paramJsBridgeListener = paramString1;
          paramString2.put("msg", "ok");
          paramJsBridgeListener = paramString1;
          callJs(paramString1, new String[] { paramString2.toString() });
          return true;
        }
        catch (JSONException paramString1)
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("OfflinePlugin, clearCache, JSONException :");
            paramString2.append(paramString1);
            QLog.d("OfflinePluginQQ", 2, paramString2.toString());
          }
          try
          {
            paramString1 = new JSONObject();
            paramString1.put("retcode", -1);
            paramString1.put("msg", "error");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label727;
            }
          }
          paramString1 = new StringBuilder();
          paramString1.append("OfflinePlugin, clearCache, JSONException :");
          paramString1.append(paramJsBridgeListener);
          QLog.d("OfflinePluginQQ", 2, paramString1.toString());
          return true;
        }
      }
      else if ("disableCache".equals(paramString3))
      {
        paramJsBridgeListener = paramString2;
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
          paramJsBridgeListener = paramString1;
          g = true;
          paramJsBridgeListener = paramString1;
          paramString2 = new JSONObject();
          paramJsBridgeListener = paramString1;
          paramString2.put("retcode", 0);
          paramJsBridgeListener = paramString1;
          paramString2.put("msg", "ok");
          paramJsBridgeListener = paramString1;
          callJs(paramString1, new String[] { paramString2.toString() });
          return true;
        }
        catch (JSONException paramString1)
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("OfflinePlugin, disableCache, JSONException :");
            paramString2.append(paramString1);
            QLog.d("OfflinePluginQQ", 2, paramString2.toString());
          }
          try
          {
            paramString1 = new JSONObject();
            paramString1.put("retcode", -1);
            paramString1.put("msg", "error");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label727;
            }
          }
          paramString1 = new StringBuilder();
          paramString1.append("OfflinePlugin, disableCache, JSONException :");
          paramString1.append(paramJsBridgeListener);
          QLog.d("OfflinePluginQQ", 2, paramString1.toString());
          return true;
        }
      }
      else if (("batchCheckUpdate".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString1 = paramString2.optJSONArray("bids");
          this.jdField_a_of_type_JavaLangString = paramString2.optString("callback");
          int j = paramString1.length();
          paramString2 = new ArrayList(j);
          int i = 0;
          while (i < j)
          {
            paramString2.add(paramString1.optString(i));
            i += 1;
          }
          HtmlOffline.a(paramString2, this.mRuntime.a(), new OfflinePlugin.3(this, paramJsBridgeListener), true, false);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("OfflinePlugin, batchCheckUpdate, JSONException :");
            paramString1.append(paramJsBridgeListener);
            QLog.d("OfflinePluginQQ", 2, paramString1.toString());
          }
          try
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("retcode", -1);
            paramJsBridgeListener.put("msg", "error");
            callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("OfflinePlugin, batchCheckUpdate, JSONException :");
              paramString1.append(paramJsBridgeListener);
              QLog.d("OfflinePluginQQ", 2, paramString1.toString());
            }
          }
        }
      }
      label727:
      return true;
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!paramString2.equals("http")) && (!paramString2.equals("https"))) {
      return false;
    }
    paramString1 = a(paramString1);
    long l = System.currentTimeMillis();
    paramString2 = SwiftBrowserOfflineHandler.a(paramString1);
    if ((paramString2 != null) && (!paramString2.a()))
    {
      paramString2.a(new OfflinePlugin.4(this, l, paramString1), paramString1);
      return true;
    }
    int i;
    if (paramString2 != null) {
      i = paramString2.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    } else {
      i = 0;
    }
    a(paramString1, i);
    return false;
  }
  
  public void onAppRuntimeReady(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    d();
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
      if (localOfflineUpdateStatus != null)
      {
        localOfflineUpdateStatus.b(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
        if (localOfflineUpdateStatus.a() == 0) {
          jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_d_of_type_JavaLangString);
        }
      }
      if (jdField_a_of_type_JavaUtilHashMap.size() == 0) {
        jdField_a_of_type_JavaUtilHashMap = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin
 * JD-Core Version:    0.7.0.1
 */