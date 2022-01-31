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
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.HtmlOffline.MyWebResourceResponse;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.OfflinePluginInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
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
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pbs;
import pbt;
import pbu;
import pbv;
import pbw;
import pbx;
import pby;
import pbz;
import pca;
import pcb;

public class OfflinePlugin
  extends WebViewPlugin
{
  static final int jdField_a_of_type_Int = Build.VERSION.SDK_INT;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static HashMap a;
  public static ConcurrentHashMap a;
  public static HashMap b;
  private static boolean f;
  public volatile long a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pbz(this);
  public LinearLayout a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  private AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  private LoadedBack2 jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2 = new pca(this);
  public OfflineWebResManager a;
  public Runnable a;
  public String a;
  public HashSet a;
  public CopyOnWriteArrayList a;
  protected CopyOnWriteArraySet a;
  public AtomicBoolean a;
  public AtomicInteger a;
  public boolean a;
  public volatile int b;
  public volatile long b;
  public String b;
  boolean b;
  public volatile int c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private String d;
  public volatile boolean d;
  public boolean e;
  private boolean g;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public OfflinePlugin()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new pcb(this);
    this.mPluginNameSpace = "offline";
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if (jdField_a_of_type_AndroidContentContext == null) {
      jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    }
    if (jdField_a_of_type_AndroidContentContext != null) {}
    for (int i = com.tencent.biz.common.util.NetworkUtil.a(jdField_a_of_type_AndroidContentContext);; i = -1)
    {
      String str2 = "";
      String str1 = str2;
      int j;
      if (!TextUtils.isEmpty(paramString3)) {
        if (!paramString3.startsWith("http"))
        {
          str1 = str2;
          if (!paramString3.startsWith("https")) {}
        }
        else
        {
          j = paramString3.indexOf("?");
          if (j == -1) {
            break label118;
          }
        }
      }
      label118:
      for (str1 = paramString3.substring(0, j);; str1 = paramString3)
      {
        ReportController.b(null, "P_CliOper", "OfflineStatusReport", "", paramString2, paramString1, paramInt1, 1, paramInt2, str1, paramString4, paramString5, String.valueOf(i));
        return;
      }
    }
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
  
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    String str = HtmlOffline.d(paramString1);
    if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!paramString2.equals(this.jdField_c_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet == null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString2))
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString2);
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "now begin check ex bid : " + paramString2);
        }
        Util.a("OfflinePlugin_verifySign_" + paramString2);
        if (!HtmlOffline.c(paramString2)) {}
        for (i = 1;; i = 0)
        {
          Util.b("OfflinePlugin_verifySign_" + paramString2);
          if (i == 0) {
            break;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "verfySign fail to reload");
          }
          return null;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_b_of_type_Int == 3) || (i != 0))
      {
        Util.a("OfflinePlugin_verifySingleFile_" + str);
        if (!HtmlOffline.a(paramString2, paramString1)) {}
        for (int j = 1;; j = 0)
        {
          Util.b("OfflinePlugin_verifySingleFile_" + str);
          if (j == 0) {
            break label312;
          }
          if (i == 0)
          {
            this.jdField_d_of_type_Boolean = true;
            c();
          }
          a(paramString2, "Offline_InterceptRequest", 0, 3, paramString1, "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest verfy single fail to reload");
          return null;
        }
      }
      label312:
      Util.a("OfflinePlugin_offlineGetResponse_" + str);
      paramString1 = HtmlOffline.a(paramString2, paramString1);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = new WebResourceResponse(paramString1.jdField_a_of_type_JavaLangString, "utf-8", paramString1.jdField_a_of_type_JavaIoInputStream))
      {
        Util.b("OfflinePlugin_offlineGetResponse_" + str);
        if (paramString1 != null)
        {
          this.g = true;
          if (i == 0) {
            this.e = true;
          }
        }
        return paramString1;
      }
    }
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
    ThreadManager.getFileThreadHandler().post(new pbt(paramString));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler = new pbu(this, Looper.getMainLooper());
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
    if (this.mRuntime.a() == null) {}
    do
    {
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.mRuntime.a().findViewById(2131363455);
      } while (localViewStub == null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewStub.inflate());
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363462));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363461));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363460));
  }
  
  private void e(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_Long == -1L)
    {
      localObject = this.mRuntime.a();
      WebViewFragment localWebViewFragment = this.mRuntime.a();
      if (localWebViewFragment == null) {
        break label117;
      }
      localObject = localWebViewFragment.c();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      localObject = HtmlOffline.d(this.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (!((String)localObject).equalsIgnoreCase(paramString)) {
          break label154;
        }
      }
    }
    label154:
    for (long l = System.currentTimeMillis();; l = -1L)
    {
      this.jdField_b_of_type_Long = l;
      if ((QLog.isColorLevel()) && (this.jdField_b_of_type_Long != -1L)) {
        QLog.d("OfflinePluginQQ", 2, "read index offline res!");
      }
      return;
      label117:
      if (!(localObject instanceof WebUiUtils.OfflinePluginInterface)) {
        break;
      }
      localObject = ((WebUiUtils.OfflinePluginInterface)localObject).c();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      break;
    }
  }
  
  public WebResourceResponse a(String paramString)
  {
    if (AppSetting.e) {
      return null;
    }
    if ((this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {
      return null;
    }
    String str1 = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str1)) {
      str1 = this.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject1 = SwiftOfflineDataUtils.a(paramString);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject1).jdField_b_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadRes");
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(str1);
        return new WebResourceResponse(((SwiftOfflineDataUtils.OfflineData)localObject1).jdField_a_of_type_JavaLangString, ((SwiftOfflineDataUtils.OfflineData)localObject1).jdField_c_of_type_JavaLangString, new BufferedInputStream(new ByteArrayInputStream(((SwiftOfflineDataUtils.OfflineData)localObject1).jdField_b_of_type_JavaLangString.getBytes())));
      }
      try
      {
        if (TextUtils.isEmpty(str1)) {
          return null;
        }
        if (!str1.equals(this.jdField_c_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            break label218;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
          }
          if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)) {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramString);
          }
        }
        for (;;)
        {
          localObject1 = OfflineEnvHelper.a(str1);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return null;
          label218:
          b(paramString);
        }
        localObject1 = (String)localObject1 + str1 + File.separator;
      }
      catch (Exception paramString)
      {
        QLog.e("OfflinePluginQQ", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
        return null;
      }
      String str2 = HtmlOffline.d(paramString);
      if (str1.equals(this.jdField_c_of_type_JavaLangString))
      {
        localObject2 = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break;
        }
        if (!((ArrayList)localObject2).contains((String)localObject1 + str2)) {
          return null;
        }
      }
      Object localObject2 = a(paramString, str1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = b(paramString, str1);
      }
      if (localObject1 != null)
      {
        if (str1.equals(this.jdField_c_of_type_JavaLangString)) {
          this.e = true;
        }
        Map localMap = ((WebResourceResponse)localObject1).getResponseHeaders();
        localObject2 = localMap;
        if (localMap == null) {
          localObject2 = new HashMap();
        }
        ((Map)localObject2).put("Access-Control-Allow-Origin", "*");
        ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
        OfflineWebResManager.a(paramString);
        e(str2);
      }
      if (localObject1 != null)
      {
        QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") uses the offline res");
        this.jdField_a_of_type_JavaUtilHashSet.add(str1);
        return localObject1;
      }
      QLog.d("OfflinePluginQQ", 2, "Url(" + paramString + ") does not  use the offline res");
      return localObject1;
    }
    return null;
  }
  
  /* Error */
  public WebResourceResponse a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 517	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   7: ifnull +40 -> 47
    //   10: getstatic 517	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_2
    //   14: invokevirtual 520	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +30 -> 47
    //   20: getstatic 517	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_2
    //   24: invokevirtual 477	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 142	java/lang/String
    //   30: astore 12
    //   32: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   35: lstore 5
    //   37: aload 12
    //   39: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +185 -> 227
    //   45: aconst_null
    //   46: areturn
    //   47: new 230	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   54: aload_2
    //   55: invokestatic 464	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 522
    //   68: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 12
    //   76: new 472	java/io/File
    //   79: dup
    //   80: aload 12
    //   82: invokespecial 523	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: invokevirtual 526	java/io/File:exists	()Z
    //   88: istore 11
    //   90: iload 11
    //   92: ifne +5 -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: new 439	java/io/BufferedInputStream
    //   100: dup
    //   101: new 528	java/io/FileInputStream
    //   104: dup
    //   105: aload 12
    //   107: invokespecial 529	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   110: invokespecial 451	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore 14
    //   115: aload 14
    //   117: astore 12
    //   119: aload 14
    //   121: invokestatic 534	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   124: astore 13
    //   126: aload 14
    //   128: astore 12
    //   130: getstatic 517	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   133: aload_2
    //   134: aload 13
    //   136: invokevirtual 535	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: pop
    //   140: aload 13
    //   142: astore 12
    //   144: aload 14
    //   146: ifnull -114 -> 32
    //   149: aload 14
    //   151: invokevirtual 538	java/io/BufferedInputStream:close	()V
    //   154: aload 13
    //   156: astore 12
    //   158: goto -126 -> 32
    //   161: astore_1
    //   162: ldc 195
    //   164: iconst_1
    //   165: ldc_w 540
    //   168: aload_1
    //   169: invokestatic 470	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aconst_null
    //   173: areturn
    //   174: astore 15
    //   176: aconst_null
    //   177: astore 14
    //   179: aconst_null
    //   180: astore_2
    //   181: aload 14
    //   183: astore 12
    //   185: ldc 195
    //   187: iconst_1
    //   188: aload 15
    //   190: invokevirtual 543	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: invokestatic 205	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_2
    //   197: astore 12
    //   199: aload 14
    //   201: ifnull -169 -> 32
    //   204: aload 14
    //   206: invokevirtual 538	java/io/BufferedInputStream:close	()V
    //   209: aload_2
    //   210: astore 12
    //   212: goto -180 -> 32
    //   215: aload 12
    //   217: ifnull +8 -> 225
    //   220: aload 12
    //   222: invokevirtual 538	java/io/BufferedInputStream:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: new 545	org/json/JSONObject
    //   230: dup
    //   231: aload 12
    //   233: invokespecial 546	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   236: astore 12
    //   238: aload_1
    //   239: invokestatic 211	com/tencent/biz/common/offline/HtmlOffline:d	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore_2
    //   243: aload 12
    //   245: aload_2
    //   246: invokevirtual 549	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 12
    //   251: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   254: lstore 7
    //   256: invokestatic 553	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   259: invokevirtual 557	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   262: astore 13
    //   264: aload 13
    //   266: instanceof 559
    //   269: ifeq +46 -> 315
    //   272: aload 13
    //   274: ldc_w 561
    //   277: invokevirtual 567	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   280: astore 13
    //   282: aload 13
    //   284: instanceof 569
    //   287: ifeq +19 -> 306
    //   290: aload_0
    //   291: new 507	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   294: dup
    //   295: aload 13
    //   297: checkcast 569	com/tencent/common/app/AppInterface
    //   300: invokespecial 572	com/tencent/biz/webviewplugin/OfflineWebResManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   303: putfield 574	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   306: aload_0
    //   307: getfield 574	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   310: ifnonnull +32 -> 342
    //   313: aconst_null
    //   314: areturn
    //   315: aload 13
    //   317: instanceof 569
    //   320: ifeq -14 -> 306
    //   323: aload_0
    //   324: new 507	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   327: dup
    //   328: aload 13
    //   330: checkcast 569	com/tencent/common/app/AppInterface
    //   333: invokespecial 572	com/tencent/biz/webviewplugin/OfflineWebResManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   336: putfield 574	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   339: goto -33 -> 306
    //   342: aload_0
    //   343: getfield 574	com/tencent/biz/webviewplugin/OfflinePlugin:jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   346: aload 12
    //   348: invokevirtual 577	com/tencent/biz/webviewplugin/OfflineWebResManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   351: astore 12
    //   353: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   356: lstore 9
    //   358: aload 12
    //   360: ifnonnull +5 -> 365
    //   363: aconst_null
    //   364: areturn
    //   365: new 472	java/io/File
    //   368: dup
    //   369: invokestatic 127	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   372: invokevirtual 583	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   375: ldc_w 585
    //   378: invokespecial 588	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   381: astore 13
    //   383: aload 13
    //   385: invokevirtual 526	java/io/File:exists	()Z
    //   388: ifne +13 -> 401
    //   391: aload 13
    //   393: invokevirtual 591	java/io/File:mkdirs	()Z
    //   396: ifne +5 -> 401
    //   399: aconst_null
    //   400: areturn
    //   401: aload_2
    //   402: ldc_w 593
    //   405: invokevirtual 595	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   408: ifeq +155 -> 563
    //   411: ldc_w 597
    //   414: astore_2
    //   415: new 472	java/io/File
    //   418: dup
    //   419: aload 13
    //   421: aload 12
    //   423: getfield 602	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   426: invokespecial 588	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   429: astore 12
    //   431: aload 12
    //   433: invokevirtual 526	java/io/File:exists	()Z
    //   436: ifeq -264 -> 172
    //   439: new 285	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   442: dup
    //   443: aload_2
    //   444: ldc_w 291
    //   447: new 439	java/io/BufferedInputStream
    //   450: dup
    //   451: new 528	java/io/FileInputStream
    //   454: dup
    //   455: aload 12
    //   457: invokespecial 605	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   460: invokespecial 451	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   463: invokespecial 297	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   466: astore_2
    //   467: aload_2
    //   468: ifnull +185 -> 653
    //   471: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +179 -> 653
    //   477: ldc 195
    //   479: iconst_2
    //   480: new 230	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 607
    //   490: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: lload 5
    //   495: lload_3
    //   496: lsub
    //   497: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: ldc_w 612
    //   503: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: lload 7
    //   508: lload 5
    //   510: lsub
    //   511: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   514: ldc_w 614
    //   517: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: lload 9
    //   522: lload 7
    //   524: lsub
    //   525: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   528: ldc_w 616
    //   531: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   537: lload_3
    //   538: lsub
    //   539: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   542: ldc_w 618
    //   545: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokestatic 211	com/tencent/biz/common/offline/HtmlOffline:d	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload_2
    //   562: areturn
    //   563: aload_2
    //   564: ldc_w 620
    //   567: invokevirtual 595	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   570: ifeq +10 -> 580
    //   573: ldc_w 622
    //   576: astore_2
    //   577: goto -162 -> 415
    //   580: aload_2
    //   581: ldc_w 624
    //   584: invokevirtual 595	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   587: ifne +33 -> 620
    //   590: aload_2
    //   591: ldc_w 626
    //   594: invokevirtual 595	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   597: ifne +23 -> 620
    //   600: aload_2
    //   601: ldc_w 628
    //   604: invokevirtual 595	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   607: ifne +13 -> 620
    //   610: aload_2
    //   611: ldc_w 630
    //   614: invokevirtual 595	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   617: ifeq +29 -> 646
    //   620: ldc_w 632
    //   623: astore_2
    //   624: goto -209 -> 415
    //   627: astore_1
    //   628: goto -413 -> 215
    //   631: astore 15
    //   633: aconst_null
    //   634: astore_2
    //   635: goto -454 -> 181
    //   638: astore 15
    //   640: aload 13
    //   642: astore_2
    //   643: goto -462 -> 181
    //   646: ldc_w 634
    //   649: astore_2
    //   650: goto -235 -> 415
    //   653: aload_2
    //   654: areturn
    //   655: astore_1
    //   656: aconst_null
    //   657: astore 12
    //   659: goto -444 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	OfflinePlugin
    //   0	662	1	paramString1	String
    //   0	662	2	paramString2	String
    //   3	535	3	l1	long
    //   35	474	5	l2	long
    //   254	269	7	l3	long
    //   356	165	9	l4	long
    //   88	3	11	bool	boolean
    //   30	628	12	localObject1	Object
    //   124	517	13	localObject2	Object
    //   113	92	14	localBufferedInputStream	BufferedInputStream
    //   174	15	15	localException1	Exception
    //   631	1	15	localException2	Exception
    //   638	1	15	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	32	161	java/lang/Exception
    //   32	45	161	java/lang/Exception
    //   47	90	161	java/lang/Exception
    //   149	154	161	java/lang/Exception
    //   204	209	161	java/lang/Exception
    //   220	225	161	java/lang/Exception
    //   225	227	161	java/lang/Exception
    //   227	306	161	java/lang/Exception
    //   306	313	161	java/lang/Exception
    //   315	339	161	java/lang/Exception
    //   342	358	161	java/lang/Exception
    //   365	399	161	java/lang/Exception
    //   401	411	161	java/lang/Exception
    //   415	467	161	java/lang/Exception
    //   471	561	161	java/lang/Exception
    //   563	573	161	java/lang/Exception
    //   580	620	161	java/lang/Exception
    //   97	115	174	java/lang/Exception
    //   119	126	627	finally
    //   130	140	627	finally
    //   185	196	627	finally
    //   119	126	631	java/lang/Exception
    //   130	140	638	java/lang/Exception
    //   97	115	655	finally
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
    if ((TextUtils.isEmpty(paramString)) || (!Uri.parse(paramString).isHierarchical())) {}
    for (;;)
    {
      return paramString;
      try
      {
        this.jdField_c_of_type_JavaLangString = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.jdField_d_of_type_JavaLangString == null) {
          this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        }
        if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizAuthorizeConfig != null))
        {
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(paramString);
          if (this.jdField_d_of_type_JavaLangString == null) {
            this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          }
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
          {
            String str1 = HtmlOffline.a(paramString, "_bid=" + this.jdField_c_of_type_JavaLangString);
            if (b(str1)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUrl:" + Util.b(str1, new String[0]));
            }
            return str1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          String str2 = paramString;
        }
      }
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {}
    label14:
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          break label14;
          do
          {
            return;
          } while (localCustomWebView.getX5WebViewExtension() == null);
          str1 = localCustomWebView.getUrl();
        } while (TextUtils.isEmpty(str1));
        localObject = Uri.parse(str1);
        if ((localObject == null) || (!((Uri)localObject).isHierarchical())) {
          break;
        }
        str2 = ((Uri)localObject).getQueryParameter("_sw");
        if (("1".equals(str2)) || ("0".equals(str2))) {
          break label156;
        }
      } while (!QLog.isColorLevel());
      QLog.i("OfflinePluginQQ", 2, "url doesn't support ServiceWorker! " + Util.b(str1, new String[0]));
      return;
    } while (!QLog.isColorLevel());
    QLog.i("OfflinePluginQQ", 2, "url is illegal! " + str1);
    return;
    label156:
    int i = str1.indexOf("?");
    Object localObject = str1;
    if (i != -1) {
      localObject = str1.substring(0, i);
    }
    ThreadManager.post(new pby(this, (String)localObject, str2, localCustomWebView), 8, null, false);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp,url=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp.");
    }
    HtmlOffline.a(paramString, this.mRuntime.a(), new pbs(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflinePluginQQ", 2, "OfflinePlugin handleSchemaRequest loadMode: " + this.jdField_b_of_type_Int + ", bid: " + this.jdField_c_of_type_JavaLangString + ", cost: " + this.jdField_c_of_type_Int);
      }
      a(paramString);
      a(this.jdField_c_of_type_JavaLangString, "Offline_Check", this.jdField_c_of_type_Int, 2, paramString, String.valueOf(this.jdField_b_of_type_Int), "");
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    do
    {
      OfflineUpdateStatus localOfflineUpdateStatus;
      Object localObject2;
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = this.mRuntime.a();
            } while (localObject1 == null);
            if (jdField_a_of_type_JavaUtilHashMap == null) {
              jdField_a_of_type_JavaUtilHashMap = new HashMap();
            }
          } while ((OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString) != null);
          localOfflineUpdateStatus = new OfflineUpdateStatus(this.jdField_d_of_type_JavaLangString);
          localOfflineUpdateStatus.a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
          localObject2 = paramJSONObject.optJSONObject("wording");
          if (localObject2 != null)
          {
            localOfflineUpdateStatus.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("nonWifiUpdatingText");
            localOfflineUpdateStatus.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("wifiUpdatingText");
            localOfflineUpdateStatus.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("updateCompletedText");
          }
          localOfflineUpdateStatus.e = ((Activity)localObject1).getResources().getString(2131430201);
          jdField_a_of_type_JavaUtilHashMap.put(this.jdField_d_of_type_JavaLangString, localOfflineUpdateStatus);
          localObject2 = paramJSONObject.optString("url");
          localOfflineUpdateStatus.f = ((String)localObject2);
          i = paramJSONObject.optInt("filesize");
          localOfflineUpdateStatus.jdField_a_of_type_Int = i;
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          if (!com.tencent.mobileqq.utils.NetworkUtil.h(((Activity)localObject1).getApplicationContext())) {
            break;
          }
          localOfflineUpdateStatus.e = localOfflineUpdateStatus.jdField_b_of_type_JavaLangString;
          paramJSONObject = localOfflineUpdateStatus.e;
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
        e();
        localOfflineUpdateStatus.b(1);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject + "0%");
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        HtmlOffline.a(((Activity)localObject1).getApplicationContext(), this.jdField_d_of_type_JavaLangString, (String)localObject2, i, localOfflineUpdateStatus);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        return;
        paramJSONObject = localOfflineUpdateStatus.jdField_c_of_type_JavaLangString;
      } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0));
      e();
      localOfflineUpdateStatus.b(0);
      Object localObject1 = ((Activity)localObject1).getResources().getDrawable(2130842434);
      ((Drawable)localObject1).setBounds(0, 0, 40, 40);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  protected boolean a(String paramString)
  {
    Object localObject2 = "0";
    try
    {
      String str = Uri.parse(paramString).getQueryParameter("_duck");
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("1")))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + Util.b(paramString, new String[0]));
          localObject1 = localObject2;
        }
      }
    }
    return true;
  }
  
  public String b(String paramString)
  {
    String str = OfflineEnvHelper.a(paramString);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str + paramString + "/";
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
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(paramString, this.mRuntime.a());
  }
  
  public void c()
  {
    if (this.mRuntime.a() == null) {}
    do
    {
      WebUiBaseInterface localWebUiBaseInterface;
      CustomWebView localCustomWebView;
      do
      {
        do
        {
          return;
          localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
        } while ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)));
        localCustomWebView = this.mRuntime.a();
      } while (localCustomWebView == null);
      localCustomWebView.loadUrl(((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).b());
    } while (!QLog.isColorLevel());
    QLog.i("OfflinePluginQQ", 2, "reloadCurrentUrl");
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return a(paramString);
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 2L)
    {
      paramString = this.mRuntime.a();
      paramMap = this.mRuntime.a(this.mRuntime.a());
      if ((paramMap == null) || (!(paramMap instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
      {
        paramMap = (OfflineUpdateStatus)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
        if (paramMap != null)
        {
          e();
          paramMap.a(this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack2);
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          switch (paramMap.b())
          {
          }
        }
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.e + paramMap.c() + "%");
          }
          if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            continue;
            if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMap.c());
            }
            if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            }
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
            {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              continue;
              if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.jdField_d_of_type_JavaLangString);
              }
              if (paramString == null) {
                return false;
              }
              paramString = paramString.getResources().getDrawable(2130838572);
              paramString.setBounds(0, 0, paramString.getMinimumWidth(), paramString.getMinimumHeight());
              if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
              }
              if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              }
              if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
              {
                this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                continue;
                if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
                {
                  this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                  continue;
                  if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMap.jdField_c_of_type_JavaLangString);
                  }
                  if (paramString == null) {
                    return false;
                  }
                  paramString = paramString.getResources().getDrawable(2130842434);
                  paramString.setBounds(0, 0, 40, 40);
                  if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramString, null, null, null);
                  }
                  if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                  }
                  if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
                  {
                    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                    continue;
                    if (paramLong == 8589934594L)
                    {
                      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                      ThreadManager.post(new pbx(this), 5, null, false);
                      if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager != null) {
                        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.a(5);
                      }
                    }
                    else
                    {
                      if (paramLong != 8589934601L) {
                        break;
                      }
                      if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager != null) {
                        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.a(0);
                      }
                      a();
                    }
                  }
                }
              }
            }
          }
        }
      } while (paramLong != 32L);
      paramMap = SwiftOfflineDataUtils.a(paramString);
    } while ((paramMap == null) || (TextUtils.isEmpty(paramMap.jdField_b_of_type_JavaLangString)));
    handleSchemaRequest(paramString, SwiftWebViewUtils.a(paramString));
    this.mRuntime.a().loadDataWithBaseURL(paramString, paramMap.jdField_b_of_type_JavaLangString, "text/html", "utf-8", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadUrl");
    }
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    paramString1 = null;
    int i = 0;
    if ("offline".equals(paramString2))
    {
      if (("clearCache".equals(paramString3)) && (paramVarArgs.length > 0)) {
        paramJsBridgeListener = paramString1;
      }
      do
      {
        do
        {
          do
          {
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
            }
            catch (JSONException paramString1)
            {
              do
              {
                if (QLog.isColorLevel()) {
                  QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + paramString1);
                }
                try
                {
                  paramString1 = new JSONObject();
                  paramString1.put("retcode", -1);
                  paramString1.put("msg", "error");
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                  return true;
                }
                catch (JSONException paramJsBridgeListener) {}
              } while (!QLog.isColorLevel());
              QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + paramJsBridgeListener);
              return true;
            }
            return true;
            if (!"disableCache".equals(paramString3)) {
              break;
            }
            paramJsBridgeListener = localObject;
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
              paramJsBridgeListener = paramString1;
              f = true;
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
              if (QLog.isColorLevel()) {
                QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + paramString1);
              }
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retcode", -1);
                paramString1.put("msg", "error");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                return true;
              }
              catch (JSONException paramJsBridgeListener) {}
            }
          } while (!QLog.isColorLevel());
          QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + paramJsBridgeListener);
          return true;
        } while ((!"batchCheckUpdate".equals(paramString3)) || (paramVarArgs.length <= 0));
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString1 = paramString2.optJSONArray("bids");
          this.jdField_a_of_type_JavaLangString = paramString2.optString("callback");
          int j = paramString1.length();
          paramString2 = new ArrayList(j);
          while (i < j)
          {
            paramString2.add(paramString1.optString(i));
            i += 1;
          }
          HtmlOffline.a(paramString2, this.mRuntime.a(), new pbv(this, paramJsBridgeListener), true, false);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramJsBridgeListener);
          }
          try
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("retcode", -1);
            paramJsBridgeListener.put("msg", "error");
            callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramJsBridgeListener);
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
      paramString2.a(new pbw(this, l, paramString1), paramString1);
      return true;
    }
    if (paramString2 != null) {}
    for (int i = paramString2.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();; i = 0)
    {
      a(paramString1, i);
      return false;
    }
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin
 * JD-Core Version:    0.7.0.1
 */