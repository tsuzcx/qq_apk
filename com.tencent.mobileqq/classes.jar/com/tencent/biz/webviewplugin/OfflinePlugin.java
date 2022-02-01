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
import android.os.Message;
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
import com.tencent.util.QQToastUtil;
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
  private static boolean F = false;
  private static Context G;
  public static HashMap<String, OfflineUpdateStatus> e;
  static final int f = Build.VERSION.SDK_INT;
  public static ConcurrentHashMap<String, ArrayList<String>> r = new ConcurrentHashMap();
  public static HashMap<String, String> w = new HashMap();
  protected CopyOnWriteArrayList<String> A;
  public Runnable B = new OfflinePlugin.9(this);
  private AuthorizeConfig C;
  private String D;
  private String E;
  private boolean H = false;
  private View.OnClickListener I = new OfflinePlugin.7(this);
  private LoadedBack2 J = new OfflinePlugin.8(this);
  RelativeLayout a;
  LinearLayout b;
  TextView c;
  ProgressBar d;
  boolean g = false;
  boolean h = false;
  boolean i = false;
  public volatile int j = 0;
  public String k;
  public volatile int l = 0;
  public volatile boolean m = false;
  public volatile boolean n = false;
  public volatile long o = -1L;
  public volatile long p = -1L;
  public AtomicBoolean q = new AtomicBoolean(false);
  public OfflineWebResManager s;
  public HashSet<String> t = new HashSet(6);
  Handler u;
  public boolean v = false;
  public AtomicInteger x = new AtomicInteger(0);
  public String y = "";
  protected CopyOnWriteArraySet<String> z;
  
  public OfflinePlugin()
  {
    this.mPluginNameSpace = "offline";
  }
  
  private void a(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        paramMessage = (String)((Object[])(Object[])paramMessage.obj)[1];
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", 0);
        ((JSONObject)localObject).put("data", Util.c(paramMessage));
        callJs(this.k, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (Exception paramMessage)
      {
        Object localObject;
        continue;
      }
      try
      {
        paramMessage = new JSONObject();
        paramMessage.put("retcode", -1);
        paramMessage.put("msg", "error");
        callJs(this.k, new String[] { paramMessage.toString() });
        return;
      }
      catch (JSONException paramMessage)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("OfflinePlugin, batchCheckUpdate, JSONException :");
          ((StringBuilder)localObject).append(paramMessage);
          QLog.d("OfflinePluginQQ", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
  }
  
  private void a(Message paramMessage, Activity paramActivity, OfflineUpdateStatus paramOfflineUpdateStatus)
  {
    if (paramMessage.arg2 == 0)
    {
      paramOfflineUpdateStatus.a(3);
      if (paramActivity != null)
      {
        paramMessage = paramActivity.getResources().getDrawable(2130839558);
        paramMessage.setBounds(0, 0, 40, 40);
        paramActivity = this.c;
        if (paramActivity != null) {
          paramActivity.setCompoundDrawables(paramMessage, null, null, null);
        }
        paramMessage = this.c;
        if (paramMessage != null) {
          paramMessage.setText(paramOfflineUpdateStatus.d);
        }
        paramMessage = this.d;
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
        paramMessage = this.b;
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
      }
    }
    else
    {
      if ((paramMessage.arg2 != 5) && (paramMessage.arg2 != 7))
      {
        QQToastUtil.a(1, 2131893854);
        paramMessage = this.a;
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
        paramOfflineUpdateStatus.a(4);
        return;
      }
      paramMessage = this.a;
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
      paramOfflineUpdateStatus.a(4);
    }
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString1, String paramString2)
  {
    ThreadManager.post(new OfflinePlugin.6(this, paramString2, paramString1, paramCustomWebView), 8, null, false);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    String str = paramString3;
    if (G == null) {
      G = BaseApplication.getContext();
    }
    int i1;
    if (G != null) {
      i1 = NetworkUtil.getNetWorkType();
    } else {
      i1 = -1;
    }
    if ((!TextUtils.isEmpty(paramString3)) && ((str.startsWith("http")) || (str.startsWith("https"))))
    {
      int i2 = str.indexOf("?");
      paramString3 = str;
      if (i2 != -1) {
        paramString3 = str.substring(0, i2);
      }
    }
    else
    {
      paramString3 = "";
    }
    ReportController.b(null, "P_CliOper", "OfflineStatusReport", "", paramString2, paramString1, paramInt1, 1, paramInt2, paramString3, paramString4, paramString5, String.valueOf(i1));
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
  
  private boolean a(Activity paramActivity, OfflineUpdateStatus paramOfflineUpdateStatus)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText(paramOfflineUpdateStatus.c);
    }
    if (paramActivity == null) {
      return true;
    }
    paramActivity = paramActivity.getResources().getDrawable(2130846483);
    paramActivity.setBounds(0, 0, 40, 40);
    paramOfflineUpdateStatus = this.c;
    if (paramOfflineUpdateStatus != null) {
      paramOfflineUpdateStatus.setCompoundDrawables(paramActivity, null, null, null);
    }
    paramActivity = this.d;
    if (paramActivity != null) {
      paramActivity.setVisibility(0);
    }
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.setVisibility(0);
    }
    return false;
  }
  
  public static boolean a(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = b(paramCustomWebView);
    return (paramCustomWebView != null) && (paramCustomWebView.v);
  }
  
  public static OfflinePlugin b(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = paramCustomWebView.getPluginEngine();
    if (paramCustomWebView != null)
    {
      paramCustomWebView = paramCustomWebView.b("offline");
      if ((paramCustomWebView instanceof OfflinePlugin)) {
        return (OfflinePlugin)paramCustomWebView;
      }
    }
    return null;
  }
  
  private WebResourceResponse b(String paramString1, String paramString2)
  {
    String str = HtmlOffline.g(paramString1);
    boolean bool = TextUtils.isEmpty(this.D);
    Object localObject = null;
    int i1;
    if ((!bool) && (paramString2.equals(this.D)))
    {
      i1 = 0;
    }
    else
    {
      if (this.z == null) {
        this.z = new CopyOnWriteArraySet();
      }
      if (!this.z.contains(paramString2))
      {
        this.z.add(paramString2);
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
        Util.f(localStringBuilder.toString());
        bool = HtmlOffline.h(paramString2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OfflinePlugin_verifySign_");
        localStringBuilder.append(paramString2);
        Util.g(localStringBuilder.toString());
        if ((bool ^ true))
        {
          this.z.remove(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("OfflinePluginQQ", 2, "verfySign fail to reload");
          }
          return null;
        }
      }
      i1 = 1;
    }
    if ((this.j == 3) || (i1 != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OfflinePlugin_verifySingleFile_");
      localStringBuilder.append(str);
      Util.f(localStringBuilder.toString());
      bool = HtmlOffline.c(paramString2, paramString1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OfflinePlugin_verifySingleFile_");
      localStringBuilder.append(str);
      Util.g(localStringBuilder.toString());
      if ((bool ^ true))
      {
        if (i1 == 0)
        {
          this.n = true;
          e();
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
    Util.f(localStringBuilder.toString());
    paramString1 = HtmlOffline.b(paramString2, paramString1);
    if (paramString1 == null) {
      paramString1 = localObject;
    } else {
      paramString1 = new WebResourceResponse(paramString1.a, "utf-8", paramString1.b);
    }
    paramString2 = new StringBuilder();
    paramString2.append("OfflinePlugin_offlineGetResponse_");
    paramString2.append(str);
    Util.g(paramString2.toString());
    if (paramString1 != null)
    {
      this.H = true;
      if (i1 == 0) {
        this.v = true;
      }
    }
    return paramString1;
  }
  
  public static long c(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = b(paramCustomWebView);
    if (paramCustomWebView != null) {
      return paramCustomWebView.o;
    }
    return 0L;
  }
  
  public static long d(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = b(paramCustomWebView);
    if (paramCustomWebView != null) {
      return paramCustomWebView.p;
    }
    return 0L;
  }
  
  public static boolean e(CustomWebView paramCustomWebView)
  {
    paramCustomWebView = b(paramCustomWebView);
    return (paramCustomWebView != null) && (paramCustomWebView.n);
  }
  
  private void f()
  {
    this.u = new OfflinePlugin.2(this, Looper.getMainLooper());
  }
  
  public static void f(String paramString)
  {
    if (r == null) {
      r = new ConcurrentHashMap();
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new OfflinePlugin.10(paramString));
  }
  
  private void g()
  {
    if (this.mRuntime.d() == null) {
      return;
    }
    Object localObject = (ViewStub)this.mRuntime.d().findViewById(2131429742);
    if (localObject != null)
    {
      this.a = ((RelativeLayout)((ViewStub)localObject).inflate());
      localObject = this.a;
      if (localObject != null)
      {
        this.c = ((TextView)((RelativeLayout)localObject).findViewById(2131434933));
        this.b = ((LinearLayout)this.a.findViewById(2131434934));
        this.d = ((ProgressBar)this.a.findViewById(2131434926));
      }
    }
  }
  
  private Boolean h()
  {
    Object localObject2 = this.mRuntime;
    Object localObject1 = Boolean.valueOf(false);
    if (localObject2 == null)
    {
      QLog.e("OfflinePluginQQ", 1, "handleEvent error mRuntime == null");
      return localObject1;
    }
    Object localObject3 = this.mRuntime.d();
    localObject2 = this.mRuntime.a(this.mRuntime.d());
    if (localObject2 != null)
    {
      if (!(localObject2 instanceof WebUiUtils.QQBrowserBaseActivityInterface)) {
        return localObject1;
      }
      localObject2 = this.a;
      if (localObject2 != null) {
        ((RelativeLayout)localObject2).setVisibility(8);
      }
      if ((e != null) && (!TextUtils.isEmpty(this.E)))
      {
        localObject2 = (OfflineUpdateStatus)e.get(this.E);
        if (localObject2 != null)
        {
          g();
          ((OfflineUpdateStatus)localObject2).a(this.J);
          Object localObject4 = this.a;
          if (localObject4 != null) {
            ((RelativeLayout)localObject4).setVisibility(0);
          }
          localObject4 = this.b;
          if (localObject4 != null) {
            ((LinearLayout)localObject4).setOnClickListener(this.I);
          }
          int i1 = ((OfflineUpdateStatus)localObject2).c();
          if (i1 != 0)
          {
            if (i1 != 1)
            {
              if (i1 != 2)
              {
                if (i1 != 3)
                {
                  if (i1 != 4) {
                    return null;
                  }
                  localObject1 = this.a;
                  if (localObject1 != null)
                  {
                    ((RelativeLayout)localObject1).setVisibility(8);
                    return null;
                  }
                }
                else
                {
                  localObject4 = this.c;
                  if (localObject4 != null) {
                    ((TextView)localObject4).setText(((OfflineUpdateStatus)localObject2).d);
                  }
                  if (localObject3 == null) {
                    return localObject1;
                  }
                  localObject1 = ((Activity)localObject3).getResources().getDrawable(2130839558);
                  ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getMinimumWidth(), ((Drawable)localObject1).getMinimumHeight());
                  localObject2 = this.c;
                  if (localObject2 != null) {
                    ((TextView)localObject2).setCompoundDrawables((Drawable)localObject1, null, null, null);
                  }
                  localObject1 = this.d;
                  if (localObject1 != null) {
                    ((ProgressBar)localObject1).setVisibility(8);
                  }
                  localObject1 = this.b;
                  if (localObject1 != null)
                  {
                    ((LinearLayout)localObject1).setVisibility(0);
                    return null;
                  }
                }
              }
              else
              {
                localObject1 = this.d;
                if (localObject1 != null) {
                  ((ProgressBar)localObject1).setProgress(((OfflineUpdateStatus)localObject2).d());
                }
                localObject1 = this.d;
                if (localObject1 != null) {
                  ((ProgressBar)localObject1).setVisibility(0);
                }
                localObject1 = this.b;
                if (localObject1 != null)
                {
                  ((LinearLayout)localObject1).setVisibility(8);
                  return null;
                }
              }
            }
            else
            {
              localObject1 = this.c;
              if (localObject1 != null)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(((OfflineUpdateStatus)localObject2).e);
                ((StringBuilder)localObject3).append(((OfflineUpdateStatus)localObject2).d());
                ((StringBuilder)localObject3).append("%");
                ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
              }
              localObject1 = this.d;
              if (localObject1 != null) {
                ((ProgressBar)localObject1).setVisibility(0);
              }
              localObject1 = this.b;
              if (localObject1 != null)
              {
                ((LinearLayout)localObject1).setVisibility(0);
                return null;
              }
            }
          }
          else if (a((Activity)localObject3, (OfflineUpdateStatus)localObject2)) {
            return localObject1;
          }
        }
      }
      return null;
    }
    return localObject1;
  }
  
  public static void h(String paramString)
  {
    r.remove(paramString);
    paramString = SwiftBrowserOfflineHandler.b(paramString);
    if (paramString != null) {
      paramString.d();
    }
  }
  
  private boolean i(String paramString)
  {
    paramString = SwiftBrowserOfflineHandler.a(paramString);
    if (paramString != null)
    {
      paramString.b();
      if (SwiftBrowserOfflineHandler.g.get() == 4)
      {
        this.D = null;
        this.i = true;
        return true;
      }
    }
    return false;
  }
  
  private void j(String paramString)
  {
    if (this.p == -1L)
    {
      Object localObject = this.mRuntime.d();
      WebViewProvider localWebViewProvider = this.mRuntime.f();
      if (localWebViewProvider != null)
      {
        localObject = localWebViewProvider.getRedirect302Url();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.y = ((String)localObject);
        }
      }
      else if ((localObject instanceof WebUiUtils.OfflinePluginInterface))
      {
        localObject = ((WebUiUtils.OfflinePluginInterface)localObject).getRedirect302Url();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.y = ((String)localObject);
        }
      }
      localObject = HtmlOffline.g(this.y);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l1;
        if (((String)localObject).equalsIgnoreCase(paramString)) {
          l1 = System.currentTimeMillis();
        } else {
          l1 = -1L;
        }
        this.p = l1;
        if ((QLog.isColorLevel()) && (this.p != -1L)) {
          QLog.d("OfflinePluginQQ", 2, "read index offline res!");
        }
      }
    }
  }
  
  /* Error */
  public WebResourceResponse a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 619	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 623	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   7: ifnull +28 -> 35
    //   10: getstatic 623	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_2
    //   14: invokevirtual 626	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +18 -> 35
    //   20: getstatic 623	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_2
    //   24: invokevirtual 627	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 178	java/lang/String
    //   30: astore 13
    //   32: goto +178 -> 210
    //   35: new 219	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   42: astore 12
    //   44: aload 12
    //   46: aload_2
    //   47: invokestatic 631	com/tencent/biz/common/offline/OfflineEnvHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 12
    //   56: aload_2
    //   57: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 12
    //   63: ldc_w 633
    //   66: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 12
    //   72: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 12
    //   77: new 635	java/io/File
    //   80: dup
    //   81: aload 12
    //   83: invokespecial 636	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 639	java/io/File:exists	()Z
    //   89: istore 11
    //   91: iload 11
    //   93: ifne +5 -> 98
    //   96: aconst_null
    //   97: areturn
    //   98: new 641	java/io/BufferedInputStream
    //   101: dup
    //   102: new 643	java/io/FileInputStream
    //   105: dup
    //   106: aload 12
    //   108: invokespecial 644	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: invokespecial 647	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore 12
    //   116: aload 12
    //   118: astore 13
    //   120: aload 12
    //   122: invokestatic 652	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   125: astore 15
    //   127: aload 12
    //   129: astore 13
    //   131: getstatic 623	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   134: aload_2
    //   135: aload 15
    //   137: invokevirtual 655	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aload 15
    //   143: astore_2
    //   144: aload 12
    //   146: invokevirtual 658	java/io/BufferedInputStream:close	()V
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
    //   188: ldc 231
    //   190: iconst_1
    //   191: aload 14
    //   193: invokevirtual 661	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: invokestatic 392	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_2
    //   200: astore 13
    //   202: aload 12
    //   204: ifnull +6 -> 210
    //   207: goto -63 -> 144
    //   210: invokestatic 619	java/lang/System:currentTimeMillis	()J
    //   213: lstore 5
    //   215: aload 13
    //   217: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +5 -> 225
    //   223: aconst_null
    //   224: areturn
    //   225: new 180	org/json/JSONObject
    //   228: dup
    //   229: aload 13
    //   231: invokespecial 662	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   234: astore_2
    //   235: aload_1
    //   236: invokestatic 416	com/tencent/biz/common/offline/HtmlOffline:g	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 12
    //   241: aload_2
    //   242: aload 12
    //   244: invokevirtual 665	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: astore_2
    //   248: invokestatic 619	java/lang/System:currentTimeMillis	()J
    //   251: lstore 7
    //   253: getstatic 671	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   256: aconst_null
    //   257: invokevirtual 675	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   260: astore 13
    //   262: getstatic 678	mqq/app/MobileQQ:sProcessId	I
    //   265: bipush 7
    //   267: if_icmpne +40 -> 307
    //   270: aload 13
    //   272: ldc_w 680
    //   275: invokevirtual 686	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   278: astore 13
    //   280: aload 13
    //   282: instanceof 688
    //   285: ifeq +46 -> 331
    //   288: aload_0
    //   289: new 690	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   292: dup
    //   293: aload 13
    //   295: checkcast 688	com/tencent/common/app/AppInterface
    //   298: invokespecial 693	com/tencent/biz/webviewplugin/OfflineWebResManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   301: putfield 695	com/tencent/biz/webviewplugin/OfflinePlugin:s	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   304: goto +27 -> 331
    //   307: aload 13
    //   309: instanceof 688
    //   312: ifeq +19 -> 331
    //   315: aload_0
    //   316: new 690	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   319: dup
    //   320: aload 13
    //   322: checkcast 688	com/tencent/common/app/AppInterface
    //   325: invokespecial 693	com/tencent/biz/webviewplugin/OfflineWebResManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   328: putfield 695	com/tencent/biz/webviewplugin/OfflinePlugin:s	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   331: aload_0
    //   332: getfield 695	com/tencent/biz/webviewplugin/OfflinePlugin:s	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   335: ifnonnull +5 -> 340
    //   338: aconst_null
    //   339: areturn
    //   340: aload_0
    //   341: getfield 695	com/tencent/biz/webviewplugin/OfflinePlugin:s	Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   344: aload_2
    //   345: invokevirtual 698	com/tencent/biz/webviewplugin/OfflineWebResManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   348: astore 13
    //   350: invokestatic 619	java/lang/System:currentTimeMillis	()J
    //   353: lstore 9
    //   355: aload 13
    //   357: ifnonnull +5 -> 362
    //   360: aconst_null
    //   361: areturn
    //   362: new 635	java/io/File
    //   365: dup
    //   366: invokestatic 326	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   369: invokevirtual 702	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   372: ldc_w 704
    //   375: invokespecial 707	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   378: astore 14
    //   380: aload 14
    //   382: invokevirtual 639	java/io/File:exists	()Z
    //   385: ifne +13 -> 398
    //   388: aload 14
    //   390: invokevirtual 710	java/io/File:mkdirs	()Z
    //   393: ifne +5 -> 398
    //   396: aconst_null
    //   397: areturn
    //   398: ldc_w 712
    //   401: astore_2
    //   402: aload 12
    //   404: ldc_w 714
    //   407: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   410: ifeq +10 -> 420
    //   413: ldc_w 718
    //   416: astore_2
    //   417: goto +68 -> 485
    //   420: aload 12
    //   422: ldc_w 720
    //   425: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   428: ifeq +10 -> 438
    //   431: ldc_w 722
    //   434: astore_2
    //   435: goto +50 -> 485
    //   438: aload 12
    //   440: ldc_w 724
    //   443: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   446: ifne +242 -> 688
    //   449: aload 12
    //   451: ldc_w 726
    //   454: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   457: ifne +231 -> 688
    //   460: aload 12
    //   462: ldc_w 728
    //   465: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   468: ifne +220 -> 688
    //   471: aload 12
    //   473: ldc_w 730
    //   476: invokevirtual 716	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +6 -> 485
    //   482: goto +206 -> 688
    //   485: new 635	java/io/File
    //   488: dup
    //   489: aload 14
    //   491: aload 13
    //   493: getfield 735	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   496: invokespecial 707	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   499: astore 12
    //   501: aload 12
    //   503: invokevirtual 639	java/io/File:exists	()Z
    //   506: ifeq +191 -> 697
    //   509: new 469	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   512: dup
    //   513: aload_2
    //   514: ldc_w 475
    //   517: new 641	java/io/BufferedInputStream
    //   520: dup
    //   521: new 643	java/io/FileInputStream
    //   524: dup
    //   525: aload 12
    //   527: invokespecial 738	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   530: invokespecial 647	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   533: invokespecial 481	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   536: astore_2
    //   537: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +155 -> 695
    //   543: new 219	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   550: astore 12
    //   552: aload 12
    //   554: ldc_w 740
    //   557: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 12
    //   563: lload 5
    //   565: lload_3
    //   566: lsub
    //   567: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 12
    //   573: ldc_w 745
    //   576: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 12
    //   582: lload 7
    //   584: lload 5
    //   586: lsub
    //   587: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 12
    //   593: ldc_w 747
    //   596: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 12
    //   602: lload 9
    //   604: lload 7
    //   606: lsub
    //   607: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 12
    //   613: ldc_w 749
    //   616: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 12
    //   622: invokestatic 619	java/lang/System:currentTimeMillis	()J
    //   625: lload_3
    //   626: lsub
    //   627: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 12
    //   633: ldc_w 751
    //   636: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 12
    //   642: aload_1
    //   643: invokestatic 416	com/tencent/biz/common/offline/HtmlOffline:g	(Ljava/lang/String;)Ljava/lang/String;
    //   646: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: ldc 231
    //   652: iconst_2
    //   653: aload 12
    //   655: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload_2
    //   662: areturn
    //   663: aload 13
    //   665: ifnull +8 -> 673
    //   668: aload 13
    //   670: invokevirtual 658	java/io/BufferedInputStream:close	()V
    //   673: aload_1
    //   674: athrow
    //   675: astore_1
    //   676: ldc 231
    //   678: iconst_1
    //   679: ldc_w 753
    //   682: aload_1
    //   683: invokestatic 756	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aconst_null
    //   687: areturn
    //   688: ldc_w 758
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
        this.D = Uri.parse(paramString).getQueryParameter("_bid");
        if (this.E == null) {
          this.E = this.D;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (TextUtils.isEmpty(this.D))
      {
        localObject = this.C;
        if (localObject != null)
        {
          this.D = ((AuthorizeConfig)localObject).b(paramString);
          if (this.E == null) {
            this.E = this.D;
          }
          if (!TextUtils.isEmpty(this.D))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("_bid=");
            ((StringBuilder)localObject).append(this.D);
            localObject = HtmlOffline.a(paramString, ((StringBuilder)localObject).toString());
            break label163;
          }
        }
      }
      Object localObject = paramString;
      label163:
      if (i((String)localObject)) {
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
  
  public void a(String paramString, int paramInt)
  {
    this.j = paramInt;
    this.o = System.currentTimeMillis();
    Object localObject = (SwiftBrowserStatistics)getBrowserComponent(-2);
    if (localObject != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((SwiftBrowserStatistics)localObject).aS = bool;
    }
    if (!TextUtils.isEmpty(this.D))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OfflinePlugin handleSchemaRequest loadMode: ");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append(", bid: ");
        ((StringBuilder)localObject).append(this.D);
        ((StringBuilder)localObject).append(", cost: ");
        ((StringBuilder)localObject).append(this.l);
        QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject).toString());
      }
      b(paramString);
      a(this.D, "Offline_Check", this.l, 2, paramString, String.valueOf(this.j), "");
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(this.E)) {
      return;
    }
    Object localObject1 = this.mRuntime.d();
    if (localObject1 == null) {
      return;
    }
    if (e == null) {
      e = new HashMap();
    }
    if ((OfflineUpdateStatus)e.get(this.E) != null) {
      return;
    }
    Object localObject2 = new OfflineUpdateStatus(this.E);
    ((OfflineUpdateStatus)localObject2).a(this.J);
    Object localObject3 = paramJSONObject.optJSONObject("wording");
    if (localObject3 != null)
    {
      ((OfflineUpdateStatus)localObject2).c = ((JSONObject)localObject3).optString("nonWifiUpdatingText");
      ((OfflineUpdateStatus)localObject2).b = ((JSONObject)localObject3).optString("wifiUpdatingText");
      ((OfflineUpdateStatus)localObject2).d = ((JSONObject)localObject3).optString("updateCompletedText");
    }
    ((OfflineUpdateStatus)localObject2).e = ((Activity)localObject1).getResources().getString(2131893855);
    e.put(this.E, localObject2);
    localObject3 = paramJSONObject.optString("url");
    ((OfflineUpdateStatus)localObject2).f = ((String)localObject3);
    int i1 = paramJSONObject.optInt("filesize");
    ((OfflineUpdateStatus)localObject2).g = i1;
    paramJSONObject = this.b;
    if (paramJSONObject != null) {
      paramJSONObject.setOnClickListener(this.I);
    }
    if (NetworkUtil.isWifiConnected(((Activity)localObject1).getApplicationContext()))
    {
      ((OfflineUpdateStatus)localObject2).e = ((OfflineUpdateStatus)localObject2).b;
      paramJSONObject = ((OfflineUpdateStatus)localObject2).e;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i1 > 0))
      {
        g();
        ((OfflineUpdateStatus)localObject2).a(1);
        TextView localTextView = this.c;
        if (localTextView != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramJSONObject);
          localStringBuilder.append("0%");
          localTextView.setText(localStringBuilder.toString());
        }
        paramJSONObject = this.b;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.d;
        if (paramJSONObject != null) {
          paramJSONObject.setProgress(0);
        }
        paramJSONObject = this.d;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.a;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        HtmlOffline.a(((Activity)localObject1).getApplicationContext(), this.E, (String)localObject3, i1, (AsyncBack)localObject2);
        this.u.postDelayed(this.B, 2000L);
      }
    }
    else
    {
      paramJSONObject = ((OfflineUpdateStatus)localObject2).c;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i1 > 0))
      {
        g();
        ((OfflineUpdateStatus)localObject2).a(0);
        localObject1 = ((Activity)localObject1).getResources().getDrawable(2130846483);
        ((Drawable)localObject1).setBounds(0, 0, 40, 40);
        localObject2 = this.c;
        if (localObject2 != null) {
          ((TextView)localObject2).setCompoundDrawables((Drawable)localObject1, null, null, null);
        }
        localObject1 = this.c;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(paramJSONObject);
        }
        paramJSONObject = this.a;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.b;
        if (paramJSONObject != null) {
          paramJSONObject.setVisibility(0);
        }
        paramJSONObject = this.d;
        if (paramJSONObject != null) {
          paramJSONObject.setProgress(0);
        }
      }
    }
  }
  
  @TargetApi(11)
  public void b()
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
      int i1 = str1.indexOf("?");
      localObject = str1;
      if (i1 != -1) {
        localObject = str1.substring(0, i1);
      }
      a(localCustomWebView, str2, (String)localObject);
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
  
  protected void b(String paramString)
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
    if (!d(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp.");
    }
    HtmlOffline.a(paramString, this.mRuntime.b(), new OfflinePlugin.1(this));
  }
  
  public void c()
  {
    if ((e != null) && (!TextUtils.isEmpty(this.E)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)e.get(this.E);
      if (localOfflineUpdateStatus != null) {
        localOfflineUpdateStatus.a();
      }
    }
    e();
  }
  
  protected void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!d(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.a(paramString, this.mRuntime.b());
  }
  
  public String d()
  {
    return this.D;
  }
  
  protected boolean d(String paramString)
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
      localObject1 = this.C.c(paramString);
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
  
  public WebResourceResponse e(String paramString)
  {
    if (AppSetting.h) {
      return null;
    }
    if ((!this.i) && (!TextUtils.isEmpty(paramString)))
    {
      if (!paramString.startsWith("http")) {
        return null;
      }
      Object localObject2 = Uri.parse(paramString).getQueryParameter("_bid");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.D;
      }
      localObject2 = SwiftOfflineDataUtils.b(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject2).b)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadRes");
        }
        this.t.add(localObject1);
        return new WebResourceResponse(((SwiftOfflineDataUtils.OfflineData)localObject2).a, ((SwiftOfflineDataUtils.OfflineData)localObject2).c, new BufferedInputStream(new ByteArrayInputStream(((SwiftOfflineDataUtils.OfflineData)localObject2).b.getBytes())));
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        if (!((String)localObject1).equals(this.D)) {
          if (!this.q.get())
          {
            if (this.A == null) {
              this.A = new CopyOnWriteArrayList();
            }
            if (!this.A.contains(paramString)) {
              this.A.add(paramString);
            }
          }
          else
          {
            c(paramString);
          }
        }
        localObject2 = OfflineEnvHelper.b((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return null;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(File.separator);
        localObject2 = ((StringBuilder)localObject3).toString();
        String str = HtmlOffline.g(paramString);
        Object localObject4;
        if (((String)localObject1).equals(this.D))
        {
          localObject3 = (ArrayList)r.get(localObject1);
          if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
            break label560;
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
          if (((String)localObject1).equals(this.D)) {
            this.v = true;
          }
          localObject4 = ((WebResourceResponse)localObject2).getResponseHeaders();
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = new HashMap();
          }
          ((Map)localObject3).put("Access-Control-Allow-Origin", "*");
          ((WebResourceResponse)localObject2).setResponseHeaders((Map)localObject3);
          OfflineWebResManager.a(paramString);
          j(str);
        }
        if (localObject2 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Url(");
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(") uses the offline res");
          QLog.d("OfflinePluginQQ", 2, ((StringBuilder)localObject3).toString());
          this.t.add(localObject1);
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
    label560:
    return null;
  }
  
  protected void e()
  {
    if (this.mRuntime.d() == null) {
      return;
    }
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
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
  
  public String g(String paramString)
  {
    String str = OfflineEnvHelper.b(paramString);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
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
      return e(paramString);
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 2L)
    {
      paramString = h();
      if (paramString != null) {
        return paramString.booleanValue();
      }
    }
    else if (paramLong == 8589934594L)
    {
      this.q.set(true);
      ThreadManager.post(new OfflinePlugin.5(this), 5, null, false);
      paramString = this.s;
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
        paramString = this.s;
        if (paramString != null) {
          paramString.a(0);
        }
        b();
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
          SwiftOfflineDataUtils.OfflineData localOfflineData = SwiftOfflineDataUtils.b(paramString);
          if ((localOfflineData != null) && (!TextUtils.isEmpty(localOfflineData.b)))
          {
            handleSchemaRequest(paramString, SwiftWebViewUtils.b(paramString));
            paramMap.loadDataWithBaseURL(paramString, localOfflineData.b, "text/html", "utf-8", paramString);
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
          HtmlOffline.a(this.mRuntime.d(), paramString2, 1);
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
              break label712;
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
          F = true;
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
              break label712;
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
          this.k = paramString2.optString("callback");
          int i2 = paramString1.length();
          paramString2 = new ArrayList(i2);
          int i1 = 0;
          while (i1 < i2)
          {
            paramString2.add(paramString1.optString(i1));
            i1 += 1;
          }
          HtmlOffline.a(paramString2, this.mRuntime.b(), new OfflinePlugin.3(this, paramJsBridgeListener), true, false);
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
            callJs(this.k, new String[] { paramJsBridgeListener.toString() });
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
      label712:
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
    long l1 = System.currentTimeMillis();
    paramString2 = SwiftBrowserOfflineHandler.a(paramString1);
    if ((paramString2 != null) && (!paramString2.c()))
    {
      paramString2.a(new OfflinePlugin.4(this, l1, paramString1), paramString1);
      return true;
    }
    int i1;
    if (paramString2 != null) {
      i1 = paramString2.e.get();
    } else {
      i1 = 0;
    }
    a(paramString1, i1);
    return false;
  }
  
  public void onAppRuntimeReady(AppRuntime paramAppRuntime)
  {
    this.C = AuthorizeConfig.a();
    f();
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.g = true;
    if ((e != null) && (!TextUtils.isEmpty(this.E)))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)e.get(this.E);
      if (localOfflineUpdateStatus != null)
      {
        localOfflineUpdateStatus.b(this.J);
        if (localOfflineUpdateStatus.b() == 0) {
          e.remove(this.E);
        }
      }
      if (e.size() == 0) {
        e = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin
 * JD-Core Version:    0.7.0.1
 */