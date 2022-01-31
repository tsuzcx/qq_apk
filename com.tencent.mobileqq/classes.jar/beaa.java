import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.AbsWebView.1;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public abstract class beaa
{
  public static final String TAG = "AbsWebView";
  public static final String WEBP_DECODER_VERSION_OF_X5 = " WebP/0.3.0";
  private nmx mChromeClient;
  protected Context mContext;
  protected Activity mInActivity;
  protected AppInterface mInterface;
  public boolean mIsFirstOnPageStart = true;
  protected ProgressBar mLoadProgress;
  public WebViewProgressBar mLoadingProgressBar;
  yzu mOfflinePlugin;
  public boolean mPerfFirstLoadTag = true;
  public WebViewPluginEngine mPluginEngine;
  public ArrayList<WebViewPlugin> mPluginList;
  public besa mProgressBarController;
  public long mRedirect302Time = -1L;
  public String mRedirect302Url = "";
  public long mStartLoadUrlMilliTimeStamp;
  public bega mStateReporter = new bega();
  public long mTimeBeforeLoadUrl;
  public String mUrl;
  private WebViewClient mWebViewClient;
  public TouchWebView mWebview;
  public JSONObject mX5PerformanceJson;
  private final Object sInitEngineLock = new Object();
  
  public beaa(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.mContext = paramContext;
    this.mInActivity = paramActivity;
    this.mInterface = paramAppInterface;
  }
  
  private void bindAllJavaScript()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "bindAllJavaScript");
    }
    long l = System.currentTimeMillis();
    if (this.mPluginList == null) {
      this.mPluginList = new ArrayList();
    }
    for (;;)
    {
      bindJavaScript(this.mPluginList);
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "bindAllJavaScript time = " + (System.currentTimeMillis() - l));
      }
      return;
      this.mPluginList.clear();
    }
  }
  
  private void bindWebChromeClient()
  {
    if (this.mChromeClient == null) {
      this.mChromeClient = new beae(this);
    }
    this.mWebview.setWebChromeClient(this.mChromeClient);
  }
  
  private void bindWebViewClient()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API Level >= 23");
      }
    }
    for (this.mWebViewClient = new beac(this);; this.mWebViewClient = new bead(this))
    {
      this.mWebview.setWebViewClient(this.mWebViewClient);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API level < 23");
      }
    }
  }
  
  private void checkOfflinePlugin()
  {
    if (this.mOfflinePlugin == null)
    {
      Object localObject = this.mWebview.getPluginEngine();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("offline");
        if ((localObject != null) && ((localObject instanceof yzu))) {
          this.mOfflinePlugin = ((yzu)localObject);
        }
      }
    }
  }
  
  private void initWebView(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "initWebView");
    }
    this.mWebview.setPluginEngine(this.mPluginEngine);
    if (!this.mPluginEngine.a(this.mUrl, 1L, null)) {}
    WebSettings localWebSettings = this.mWebview.getSettings();
    paramAppInterface = localWebSettings.getUserAgentString();
    String str1 = getUAMark();
    boolean bool;
    if (this.mWebview.getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      localWebSettings.setUserAgentString(befr.a(paramAppInterface, str1, bool));
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localWebSettings.setMediaPlaybackRequiresUserGesture(false);
      paramAppInterface = this.mContext.getPackageManager();
      try
      {
        if (!paramAppInterface.hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = paramAppInterface.hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {}
        }
        else
        {
          i = 1;
          if (i != 0) {
            break label519;
          }
          bool = true;
          localWebSettings.setDisplayZoomControls(bool);
          localWebSettings.setPluginsEnabled(true);
          localWebSettings.setJavaScriptEnabled(true);
          localWebSettings.setAllowContentAccess(true);
          localWebSettings.setDatabaseEnabled(true);
          localWebSettings.setDomStorageEnabled(true);
          localWebSettings.setAppCacheEnabled(true);
          String str2 = MobileQQ.getMobileQQ().getQQProcessName();
          str1 = "";
          paramAppInterface = str1;
          if (str2 != null)
          {
            i = str2.lastIndexOf(':');
            paramAppInterface = str1;
            if (i > -1) {
              paramAppInterface = "_" + str2.substring(i + 1);
            }
          }
          localWebSettings.setDatabasePath(this.mContext.getApplicationContext().getDir("database" + paramAppInterface, 0).getPath());
          localWebSettings.setAppCachePath(this.mContext.getApplicationContext().getDir("appcache" + paramAppInterface, 0).getPath());
          if (Build.VERSION.SDK_INT >= 11) {
            this.mWebview.removeJavascriptInterface("searchBoxJavaBridge_");
          }
        }
      }
      catch (RuntimeException paramAppInterface)
      {
        try
        {
          for (;;)
          {
            this.mWebview.requestFocus();
            label378:
            this.mWebview.setFocusableInTouchMode(true);
            this.mWebview.setDownloadListener(new beab(this));
            CookieSyncManager.createInstance(this.mContext.getApplicationContext());
            if (this.mWebview.getX5WebViewExtension() != null)
            {
              this.mWebview.getX5WebViewExtension().setWebViewClientExtension(new beaf(this, this.mWebview));
              if (this.mContext.getSharedPreferences("WebView_X5_Report", 4).getBoolean("enableX5Report", true))
              {
                paramAppInterface = new Bundle();
                paramAppInterface.putBoolean("enabled", true);
                this.mWebview.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", paramAppInterface);
              }
            }
            return;
            bool = false;
            break;
            int i = 0;
            continue;
            paramAppInterface = paramAppInterface;
            i = 0;
          }
          label519:
          bool = false;
        }
        catch (Exception paramAppInterface)
        {
          break label378;
        }
      }
    }
  }
  
  protected final void bindBaseJavaScript()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "bindBaseJavaScript");
    }
    if (this.mPluginList == null) {
      this.mPluginList = new ArrayList();
    }
    for (;;)
    {
      this.mPluginList.add(new yzu());
      this.mPluginList.add(new VasWebReport());
      this.mPluginList.add(new zbx());
      this.mPluginList.add(new atda());
      this.mPluginList.add(new UiApiPlugin());
      this.mPluginList.add(new atcy());
      this.mPluginList.add(new QWalletPayJsPlugin());
      this.mPluginList.add(new VasCommonJsPlugin());
      this.mPluginList.add(new bdut());
      this.mPluginList.add(new QWalletMixJsPlugin());
      return;
      this.mPluginList.clear();
    }
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList) {}
  
  protected final void buildBaseWebView(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "buildBaseWebView");
    }
    initPluginEngine();
    initWebView(paramAppInterface);
    bindWebViewClient();
    bindWebChromeClient();
  }
  
  public Object doInterceptRequest(WebView paramWebView, String paramString)
  {
    return null;
  }
  
  protected final void doOnBackPressed(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnBackPressed");
    }
    String str = this.mWebview.getUrl();
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnBackPressed...url=" + str);
    }
    this.mStateReporter.a(this.mContext, paramAppInterface.getLongAccountUin(), str, false);
  }
  
  protected final void doOnCreate(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnCreate");
    }
    this.mStateReporter.a(1);
    if (paramIntent != null)
    {
      this.mStateReporter.a(paramIntent.getStringExtra("key_service_id"));
      long l2 = paramIntent.getLongExtra("startOpenPageTime", -1L);
      long l1 = l2;
      if (-1L == l2) {
        l1 = System.currentTimeMillis();
      }
      this.mStateReporter.a(l1);
    }
  }
  
  protected final void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnDestroy");
    }
    if (this.mChromeClient != null) {
      this.mChromeClient.a();
    }
    if (this.mWebview != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.mWebview.getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        localWebViewPluginEngine.a(this.mWebview.getUrl(), 8589934596L, null);
        localWebViewPluginEngine.b();
      }
    }
    try
    {
      this.mWebview.stopLoading();
      label75:
      this.mWebview.loadUrlOriginal("about:blank");
      this.mWebview.clearView();
      this.mWebview.destroy();
      return;
    }
    catch (Exception localException)
    {
      break label75;
    }
  }
  
  protected final void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnPause");
    }
    if (this.mWebview != null)
    {
      this.mWebview.onPause();
      WebViewPluginEngine localWebViewPluginEngine = this.mWebview.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(this.mWebview.getUrl(), 8589934597L, null);
      }
    }
  }
  
  protected final void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnResume");
    }
    if (this.mWebview != null)
    {
      this.mWebview.onResume();
      WebViewPluginEngine localWebViewPluginEngine = this.mWebview.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(this.mWebview.getUrl(), 2L, null);
      }
    }
  }
  
  public boolean getIsReloadUrl()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.d;
    }
    return false;
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.a;
    }
    return 0L;
  }
  
  public long getReadIndexFromOfflineTime()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.b;
    }
    return 0L;
  }
  
  protected String getUAMark()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  public CustomWebView getWebView()
  {
    return this.mWebview;
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    return this.mTimeBeforeLoadUrl;
  }
  
  /* Error */
  public void initPluginEngine()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 8
    //   10: iconst_2
    //   11: ldc_w 550
    //   14: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 193	beaa:mPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   21: ifnull +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: getfield 58	beaa:sInitEngineLock	Ljava/lang/Object;
    //   29: astore 5
    //   31: aload 5
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 193	beaa:mPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   38: ifnonnull +100 -> 138
    //   41: aload_0
    //   42: invokespecial 552	beaa:bindAllJavaScript	()V
    //   45: iconst_0
    //   46: istore_3
    //   47: iconst_0
    //   48: istore 4
    //   50: iload 4
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 81	beaa:mInterface	Lcom/tencent/common/app/AppInterface;
    //   57: invokestatic 557	bdzt:a	(Lmqq/app/AppRuntime;)Z
    //   60: ifeq +55 -> 115
    //   63: iload 4
    //   65: istore_1
    //   66: getstatic 560	bdzt:c	Z
    //   69: ifne +46 -> 115
    //   72: iload 4
    //   74: istore_1
    //   75: getstatic 562	bdzt:jdField_a_of_type_Boolean	Z
    //   78: ifeq +37 -> 115
    //   81: getstatic 564	bdzt:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   84: astore 6
    //   86: aload_0
    //   87: aload 6
    //   89: putfield 193	beaa:mPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   92: aload 6
    //   94: ifnull +56 -> 150
    //   97: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +163 -> 263
    //   103: ldc 8
    //   105: iconst_2
    //   106: ldc_w 566
    //   109: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: goto +151 -> 263
    //   115: iload_1
    //   116: ifeq +112 -> 228
    //   119: aload_0
    //   120: getfield 193	beaa:mPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   123: aload_0
    //   124: getfield 81	beaa:mInterface	Lcom/tencent/common/app/AppInterface;
    //   127: aload_0
    //   128: getfield 79	beaa:mInActivity	Landroid/app/Activity;
    //   131: aload_0
    //   132: getfield 102	beaa:mPluginList	Ljava/util/ArrayList;
    //   135: invokevirtual 569	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Ljava/util/List;)V
    //   138: aload 5
    //   140: monitorexit
    //   141: return
    //   142: astore 6
    //   144: aload 5
    //   146: monitorexit
    //   147: aload 6
    //   149: athrow
    //   150: getstatic 571	bdzt:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   153: astore 6
    //   155: aload 6
    //   157: monitorenter
    //   158: getstatic 571	bdzt:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   161: ldc2_w 572
    //   164: invokevirtual 576	java/lang/Object:wait	(J)V
    //   167: getstatic 564	bdzt:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   170: astore 7
    //   172: aload_0
    //   173: aload 7
    //   175: putfield 193	beaa:mPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   178: aload 7
    //   180: ifnull +78 -> 258
    //   183: iload_2
    //   184: istore_1
    //   185: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +14 -> 202
    //   191: ldc 8
    //   193: iconst_2
    //   194: ldc_w 578
    //   197: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: iload_2
    //   201: istore_1
    //   202: aload 6
    //   204: monitorexit
    //   205: goto -90 -> 115
    //   208: astore 7
    //   210: aload 6
    //   212: monitorexit
    //   213: aload 7
    //   215: athrow
    //   216: astore 7
    //   218: aload 7
    //   220: invokevirtual 581	java/lang/InterruptedException:printStackTrace	()V
    //   223: iload_3
    //   224: istore_1
    //   225: goto -23 -> 202
    //   228: aload_0
    //   229: invokestatic 587	com/tencent/mobileqq/webprocess/WebAccelerateHelper:getInstance	()Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper;
    //   232: aload_0
    //   233: getfield 81	beaa:mInterface	Lcom/tencent/common/app/AppInterface;
    //   236: aload_0
    //   237: getfield 79	beaa:mInActivity	Landroid/app/Activity;
    //   240: aconst_null
    //   241: aload_0
    //   242: invokevirtual 591	beaa:myCommonJsPlugins	()Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper$CommonJsPluginFactory;
    //   245: aload_0
    //   246: getfield 102	beaa:mPluginList	Ljava/util/ArrayList;
    //   249: invokevirtual 595	com/tencent/mobileqq/webprocess/WebAccelerateHelper:createWebViewPluginEngine	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper$CommonJsPluginFactory;Ljava/util/List;)Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   252: putfield 193	beaa:mPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   255: goto -117 -> 138
    //   258: iconst_0
    //   259: istore_1
    //   260: goto -58 -> 202
    //   263: iconst_1
    //   264: istore_1
    //   265: goto -150 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	beaa
    //   52	213	1	i	int
    //   1	200	2	j	int
    //   46	178	3	k	int
    //   48	25	4	m	int
    //   29	116	5	localObject1	Object
    //   84	9	6	localWebViewPluginEngine1	WebViewPluginEngine
    //   142	6	6	localObject2	Object
    //   170	9	7	localWebViewPluginEngine2	WebViewPluginEngine
    //   208	6	7	localObject4	Object
    //   216	3	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   34	45	142	finally
    //   53	63	142	finally
    //   66	72	142	finally
    //   75	92	142	finally
    //   97	112	142	finally
    //   119	138	142	finally
    //   138	141	142	finally
    //   144	147	142	finally
    //   150	158	142	finally
    //   213	216	142	finally
    //   228	255	142	finally
    //   158	178	208	finally
    //   185	200	208	finally
    //   202	205	208	finally
    //   210	213	208	finally
    //   218	223	208	finally
    //   158	178	216	java/lang/InterruptedException
    //   185	200	216	java/lang/InterruptedException
  }
  
  public boolean isMainPageUseLocalFile()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.e;
    }
    return false;
  }
  
  public boolean ismPerfFirstLoadTag()
  {
    return this.mPerfFirstLoadTag;
  }
  
  protected WebAccelerateHelper.CommonJsPluginFactory myCommonJsPlugins()
  {
    return new WebAccelerateHelper.CommonJsPluginFactory();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback) {}
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return true;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public void onWebViewReady() {}
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  protected final void preInitPluginEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "preInitPluginEngine");
    }
    WebViewPluginEngine localWebViewPluginEngine;
    if ((bdzt.a(this.mInterface)) && (!bdzt.c))
    {
      localWebViewPluginEngine = bdzt.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      this.mPluginEngine = localWebViewPluginEngine;
      if (localWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "use reader preloaded web engine!");
        }
        bindAllJavaScript();
        this.mPluginEngine.a(this.mInterface, this.mInActivity, this.mPluginList);
        return;
      }
    }
    if ((bdzt.b(this.mInterface)) && (!bdzt.d))
    {
      localWebViewPluginEngine = bdzt.b;
      this.mPluginEngine = localWebViewPluginEngine;
      if (localWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "use comic preloaded web engine!");
        }
        bindAllJavaScript();
        this.mPluginEngine.a(this.mInterface, this.mInActivity, this.mPluginList);
        return;
      }
    }
    if ((this.mPluginEngine == null) && (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "use preloaded web engine!");
      }
      this.mPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      bindAllJavaScript();
      this.mPluginEngine.a(this.mInterface, this.mInActivity, this.mPluginList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "WebAccelerateHelper.isWebViewCache:" + WebAccelerateHelper.isWebViewCache + ",mPluginEngine=" + this.mPluginEngine);
    }
    ThreadManager.postImmediately(new AbsWebView.1(this), null, false);
  }
  
  public void refresh()
  {
    this.mWebview.reload();
  }
  
  public void setmPerfFirstLoadTag(boolean paramBoolean)
  {
    this.mPerfFirstLoadTag = paramBoolean;
  }
  
  public void setmTimeBeforeLoadUrl(long paramLong)
  {
    this.mTimeBeforeLoadUrl = paramLong;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void showProgressBar(boolean paramBoolean)
  {
    ProgressBar localProgressBar;
    if (this.mLoadProgress != null)
    {
      localProgressBar = this.mLoadProgress;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaa
 * JD-Core Version:    0.7.0.1
 */