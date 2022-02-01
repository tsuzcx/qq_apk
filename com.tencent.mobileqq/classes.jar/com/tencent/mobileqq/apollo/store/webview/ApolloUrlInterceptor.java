package com.tencent.mobileqq.apollo.store.webview;

import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ApolloUrlInterceptor
  implements Handler.Callback, BridgeStream.IBridgeStreamCallback
{
  public static String a = HardCodeUtil.a(2131898770);
  private static long m = new Random().nextInt(263167);
  private ConcurrentHashMap<String, ApolloUrlInterceptor.PreloadCGITask> A = new ConcurrentHashMap();
  public final String b;
  private final AtomicInteger c = new AtomicInteger(0);
  private final AtomicBoolean d = new AtomicBoolean(false);
  private final AtomicBoolean e = new AtomicBoolean(false);
  private final AtomicBoolean f = new AtomicBoolean(false);
  private final AtomicBoolean g = new AtomicBoolean(false);
  private final AtomicBoolean h = new AtomicBoolean(false);
  private final AtomicBoolean i = new AtomicBoolean(false);
  private final AtomicBoolean j = new AtomicBoolean(false);
  private final String k;
  private volatile boolean l = false;
  private String n;
  private volatile CustomWebView o;
  private String p;
  private final Handler q = new Handler(Looper.getMainLooper(), this);
  private volatile ApolloUrlConnection r;
  private Message s;
  private volatile InputStream t;
  private boolean u = true;
  private String v;
  private ApolloWebStatistics w = new ApolloWebStatistics();
  private boolean x;
  private String y;
  private boolean z;
  
  public ApolloUrlInterceptor(String paramString1, String paramString2)
  {
    this.k = paramString2;
    long l1 = m;
    m = 1L + l1;
    this.b = String.valueOf(l1);
    this.n = ApolloClientUtil.a(paramString1, "apollo_task_id", String.valueOf(this.b));
    this.p = this.n;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("task(");
      paramString2.append(this.b);
      paramString2.append(") create:id=");
      paramString2.append(this.b);
      paramString2.append(", url = ");
      paramString2.append(paramString1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramString2.toString());
    }
  }
  
  public static ApolloUrlInterceptor a(boolean paramBoolean, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class);
      String str = ((ApolloWebDataHandlerImpl)localObject).getApolloClientId(paramString);
      if (((ApolloWebDataHandlerImpl)localObject).isApolloClientId(str))
      {
        paramString = new ApolloUrlInterceptor(paramString, str);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createInterceptor startSessionNewThread:");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(",use:");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
        }
        paramString.a(paramBoolean);
        return paramString;
      }
    }
    return null;
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.c.compareAndSet(paramInt1, paramInt2))
    {
      if (paramBoolean) {
        synchronized (this.c)
        {
          this.c.notify();
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean a(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((i1 != 3) && (i1 != 5))
        {
          if (i1 != 255)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("msg.what ");
              localStringBuilder.append(paramMessage.what);
              QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
            }
            return true;
          }
          e();
        }
        else
        {
          f();
        }
      }
      else if (paramMessage.arg1 == 1) {
        g();
      } else if (paramMessage.arg1 == 2) {
        d(paramMessage);
      }
    }
    else if (paramMessage.arg1 == 1) {
      h();
    } else if (paramMessage.arg1 == 2) {
      e(paramMessage);
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = this.c.get();
    if (3 == i1) {
      return;
    }
    this.o = null;
    this.t = null;
    this.y = null;
    if (this.s != null) {
      this.s = null;
    }
    if ((!paramBoolean) && (!k()))
    {
      this.q.removeMessages(255);
      if (this.i.compareAndSet(false, true))
      {
        this.q.sendEmptyMessageDelayed(10, 6000L);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b);
          ((StringBuilder)???).append(") waiting for destroy, current state =");
          ((StringBuilder)???).append(i1);
          ((StringBuilder)???).append(".");
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)???).toString());
        }
      }
      return;
    }
    if ((this.r != null) && (!paramBoolean))
    {
      this.r.b();
      this.r = null;
    }
    this.c.set(3);
    synchronized (this.c)
    {
      this.c.notify();
      this.q.removeMessages(10);
      this.i.set(false);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("task(");
        ((StringBuilder)???).append(this.b);
        ((StringBuilder)???).append(") final destroy, force=");
        ((StringBuilder)???).append(paramBoolean);
        ((StringBuilder)???).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)???).toString());
      }
      this.q.removeMessages(255);
      ??? = this.A.values().iterator();
      while (((Iterator)???).hasNext()) {
        ((ApolloUrlInterceptor.PreloadCGITask)((Iterator)???).next()).a();
      }
      this.A.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private boolean b(Message paramMessage)
  {
    if ((paramMessage.what > 0) && (paramMessage.what < 7) && (!this.e.get()))
    {
      this.s = Message.obtain(paramMessage);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("task(");
        localStringBuilder.append(this.b);
        localStringBuilder.append(") handleMessage: client not ready, core msg = ");
        localStringBuilder.append(paramMessage.what);
        localStringBuilder.append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  private boolean c(Message paramMessage)
  {
    if (10 == paramMessage.what)
    {
      b(true);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("task(");
        paramMessage.append(this.b);
        paramMessage.append(") handleMessage:force destroy.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
      }
      return true;
    }
    return false;
  }
  
  private WebResourceResponse d(String paramString)
  {
    ApolloWebDataHandlerImpl localApolloWebDataHandlerImpl = (ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class);
    if ((this.o != null) && (localApolloWebDataHandlerImpl.isCmdResourceUrl(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getClientResource isCmdResourceUrl url:");
      localStringBuilder.append(paramString);
      f(localStringBuilder.toString());
      paramString = localApolloWebDataHandlerImpl.getApolloCmdResource(paramString, this.k);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  private void d()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((localObject1 != null) && (!TextUtils.isEmpty(this.k)))
    {
      Object localObject2 = (ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class);
      ((ApolloWebDataHandlerImpl)localObject2).preLoadSSOCmd(BaseApplicationImpl.getContext(), this.k, this.p, (AppInterface)localObject1, this.w);
      localObject1 = ((ApolloWebDataHandlerImpl)localObject2).getCGIConfigs(this.k);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ApolloSSOConfig.CGIConfig)((Iterator)localObject1).next();
          if (((ApolloSSOConfig.CGIConfig)localObject2).a())
          {
            ApolloUrlInterceptor.PreloadCGITask localPreloadCGITask = new ApolloUrlInterceptor.PreloadCGITask(this, (ApolloSSOConfig.CGIConfig)localObject2);
            this.A.put(((ApolloSSOConfig.CGIConfig)localObject2).a, localPreloadCGITask);
            localPreloadCGITask.b();
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preloadSSOData use:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void d(Message paramMessage)
  {
    if (this.f.compareAndSet(false, true))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("task(\" + id + \") handleClientCoreMessage_FirstLoad with cache, url:");
        localStringBuilder.append(this.p);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
      }
      this.z = true;
      this.w.k = System.currentTimeMillis();
      if (this.o != null)
      {
        if (this.o.getX5WebViewExtension() != null)
        {
          this.o.loadDataWithBaseURL(this.p, (String)paramMessage.obj, "text/html", "utf-8", this.p);
          return;
        }
        this.o.loadUrlOriginal(this.p);
        QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_FIRST_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
      }
    }
    else if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("task(");
      paramMessage.append(this.b);
      paramMessage.append(") FIRST_LOAD_WITH_CACHE load url was invoked.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
    }
  }
  
  private WebResourceResponse e(String paramString)
  {
    if ((this.o != null) && (!this.A.isEmpty()))
    {
      Iterator localIterator = this.A.values().iterator();
      while (localIterator.hasNext())
      {
        ApolloUrlInterceptor.PreloadCGITask localPreloadCGITask = (ApolloUrlInterceptor.PreloadCGITask)localIterator.next();
        if (paramString.contains(ApolloUrlInterceptor.PreloadCGITask.a(localPreloadCGITask).a))
        {
          WebResourceResponse localWebResourceResponse = localPreloadCGITask.a(paramString);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getClientResource getCGIResource url:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" resourceResponse:");
          localStringBuilder.append(localWebResourceResponse);
          f(localStringBuilder.toString());
          this.A.remove(ApolloUrlInterceptor.PreloadCGITask.a(localPreloadCGITask).a);
          if (localWebResourceResponse != null) {
            return localWebResourceResponse;
          }
        }
      }
    }
    return null;
  }
  
  private void e()
  {
    if ((this.e.get()) && (!j()) && (!TextUtils.isEmpty(a))) {
      Toast.makeText(BaseApplicationImpl.getContext(), a, 1).show();
    }
  }
  
  private void e(Message paramMessage)
  {
    if (this.g.compareAndSet(false, true))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      paramMessage = (String)paramMessage.obj;
      this.w.k = System.currentTimeMillis();
      if (this.o != null)
      {
        if (this.o.getX5WebViewExtension() != null)
        {
          localObject = this.o;
          String str = this.p;
          ((CustomWebView)localObject).loadDataWithBaseURL(str, paramMessage, "text/html", "utf-8", str);
          return;
        }
        this.o.loadUrlOriginal(this.p);
        QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_PRE_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
      }
    }
    else if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("task(");
      paramMessage.append(this.b);
      paramMessage.append(") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
    }
  }
  
  private void f()
  {
    if (this.f.compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "handleClientCoreMessage_ConnectionError: load src url.");
      }
      if (this.o != null) {
        this.o.loadUrlOriginal(this.p);
      }
    }
  }
  
  private void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramString);
    }
  }
  
  private void g()
  {
    StringBuilder localStringBuilder;
    if (this.d.get())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("task(");
        localStringBuilder.append(this.b);
        localStringBuilder.append(") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_CACHE.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.b);
      localStringBuilder.append(") handleClientCoreMessage_FirstLoad:url was not invoked.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    StringBuilder localStringBuilder;
    if (this.f.compareAndSet(false, true))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("task(");
        localStringBuilder.append(this.b);
        localStringBuilder.append(") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
      }
      this.w.k = System.currentTimeMillis();
      if (this.o != null) {
        this.o.loadUrlOriginal(this.p);
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.b);
      localStringBuilder.append(") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
    }
  }
  
  private WebResourceResponse i()
  {
    if ((this.t == null) && (!TextUtils.isEmpty(this.y)))
    {
      try
      {
        this.t = new ByteArrayInputStream(this.y.getBytes("UTF-8"));
        this.z = true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localThrowable, new Object[0]);
      }
      f("task(\" + id + \") pendingWebResourceStream is null but mHtmlContent is not null!");
    }
    if (this.t != null)
    {
      WebResourceResponse localWebResourceResponse;
      if (!j())
      {
        localWebResourceResponse = new WebResourceResponse(ApolloClientUtil.a(this.p), "utf-8", this.t);
        this.h.set(true);
      }
      else
      {
        f("task(\" + id + \") getClientResource error: session is destroyed!");
        localWebResourceResponse = null;
      }
      if (this.z) {
        this.z = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(\" + id + \") getClientResource ret webResourceResponse:");
      localStringBuilder.append(localWebResourceResponse);
      f(localStringBuilder.toString());
      this.t = null;
      return localWebResourceResponse;
    }
    return null;
  }
  
  private boolean j()
  {
    return (3 == this.c.get()) || (this.i.get());
  }
  
  private boolean k()
  {
    if ((!this.j.get()) && (!this.h.get())) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.b);
      localStringBuilder.append(") canDestroy:false, isWaitingForSessionThread=");
      localStringBuilder.append(this.j.get());
      localStringBuilder.append(", isWaitingForBlinkCloseStream=");
      localStringBuilder.append(this.h.get());
      localStringBuilder.append(" isWaitingForDestroy:");
      localStringBuilder.append(this.i);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  private boolean l()
  {
    if ((this.i.get()) && (k()))
    {
      this.q.sendEmptyMessage(10);
      return true;
    }
    return false;
  }
  
  private void m()
  {
    if (1 != this.c.get())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(") runDataTask error:sessionState=");
        ((StringBuilder)localObject1).append(this.c.get());
        ((StringBuilder)localObject1).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      this.x = true;
      this.j.set(false);
      this.q.sendEmptyMessage(3);
      return;
    }
    this.q.removeMessages(255);
    long l1 = System.currentTimeMillis();
    this.v = ApolloClientUtil.f(this.p);
    if (TextUtils.isEmpty(this.v))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(") runDataTask error:fileName is null");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      this.x = true;
      this.j.set(false);
      this.q.sendEmptyMessage(3);
      return;
    }
    Object localObject1 = ApolloClientUtil.e(this.v);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("task(");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(") runDataTask url is ");
      ((StringBuilder)localObject2).append(this.p);
      ((StringBuilder)localObject2).append(" filePath is ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new File((String)localObject1);
    localObject1 = ApolloClientUtil.a((File)localObject2);
    this.w.e = (System.currentTimeMillis() - l1);
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
    boolean bool2;
    if (bool1)
    {
      long l2 = System.currentTimeMillis();
      if (!((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).verifyCache(this.k, (String)localObject1))
      {
        localObject1 = null;
        ((File)localObject2).delete();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("task(");
          ((StringBuilder)localObject2).append(this.b);
          ((StringBuilder)localObject2).append(") runDataTask md5 not match delete localFile! url is ");
          ((StringBuilder)localObject2).append(this.p);
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
        }
        this.w.i = 1;
        bool1 = false;
      }
      else
      {
        this.w.i = 2;
      }
      this.w.f = (System.currentTimeMillis() - l2);
      localObject2 = localObject1;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("verify use:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l2);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
        bool2 = bool1;
      }
    }
    else
    {
      this.w.i = 0;
      bool2 = bool1;
      localObject2 = localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get LocalFile use:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.q.obtainMessage(1);
    this.s = ((Message)localObject1);
    if (bool2)
    {
      ((Message)localObject1).arg1 = 2;
      ((Message)localObject1).obj = localObject2;
      this.q.sendMessage((Message)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(") runDataTask hasHtmlCache:");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      this.y = ((String)localObject2);
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task(");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append(") runDataTask has no cache, do first load flow.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
      }
      ((Message)localObject1).arg1 = 1;
      this.q.sendMessage((Message)localObject1);
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
      {
        if (!TextUtils.isEmpty(a)) {
          this.q.sendEmptyMessageDelayed(255, 1500L);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("task(");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append(") runDataTask error:network is not valid!");
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 1, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        n();
      }
    }
    a(1, 2, true);
    this.j.set(false);
    if ((l()) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(") runDataTask:send force destroy message.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void n()
  {
    long l1 = System.currentTimeMillis();
    this.r = new ApolloUrlConnection(this.p, true, null, null);
    long l2 = System.currentTimeMillis();
    int i2 = this.r.a();
    int i1 = i2;
    Object localObject;
    if (i2 == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(") connection connect cost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
        ((StringBuilder)localObject).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      l2 = System.currentTimeMillis();
      i2 = this.r.c();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(") connection response cost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
        ((StringBuilder)localObject).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      l2 = System.currentTimeMillis();
      Map localMap = this.r.d();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(") connection get header fields cost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
        ((StringBuilder)localObject).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      i1 = i2;
      if (localMap != null)
      {
        localObject = "Set-Cookie";
        if (!localMap.containsKey("Set-Cookie")) {
          if (localMap.containsKey("set-cookie")) {
            localObject = "set-cookie";
          } else {
            localObject = null;
          }
        }
        i1 = i2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (List)localMap.get(localObject);
          ApolloClientUtil.a(this.p, (List)localObject);
          i1 = i2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task(");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(") handleFlow_Connection: respCode = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", cost ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      ((StringBuilder)localObject).append(" ms.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject).toString());
    }
    if (j())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(") handleFlow_Connection: destroy before server response.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 6, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (200 != i1)
    {
      if (this.u)
      {
        this.q.removeMessages(1);
        localObject = this.q.obtainMessage(5);
        ((Message)localObject).arg1 = i1;
        this.q.sendMessage((Message)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(") handleFlow_Connection: response code not 200, response code = ");
        ((StringBuilder)localObject).append(i1);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    o();
  }
  
  private void o()
  {
    Object localObject1 = this.r.a(this.d, null);
    int i1 = 2;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(") handleFlow_FirstLoad error:responseDataTuple is null!");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      this.x = true;
      this.q.sendEmptyMessage(3);
      return;
    }
    this.t = new BridgeStream(this, ((ApolloUrlConnection.ResponseDataTuple)localObject1).c, ((ApolloUrlConnection.ResponseDataTuple)localObject1).b);
    Object localObject2;
    if (((ApolloUrlConnection.ResponseDataTuple)localObject1).a)
    {
      try
      {
        localObject1 = ((ApolloUrlConnection.ResponseDataTuple)localObject1).c.toString("UTF-8");
        try
        {
          this.y = ((String)localObject1);
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable1) {}
        this.t = null;
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task(");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append(") handleFlow_FirstLoad error:");
        ((StringBuilder)localObject2).append(localThrowable2.getMessage());
        ((StringBuilder)localObject2).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject2 = null;
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(") handleFlow_FirstLoad:hasCacheData=");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(".");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject1).toString());
    }
    this.q.removeMessages(1);
    localObject1 = this.q.obtainMessage(2);
    ((Message)localObject1).obj = localObject2;
    if (!bool) {
      i1 = 1;
    }
    ((Message)localObject1).arg1 = i1;
    this.s = ((Message)localObject1);
    this.q.sendMessage((Message)localObject1);
    if ((bool) && (!this.l))
    {
      long l1 = System.currentTimeMillis();
      ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).saveHtml(this.p, (String)localObject2);
      this.l = true;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(") handleFlow_FirstLoad :save htmlString ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        ((StringBuilder)localObject1).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.c.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(") start error:sessionState=");
        ((StringBuilder)localObject).append(this.c.get());
        ((StringBuilder)localObject).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task(");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(") now post task flow task.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
    }
    this.j.set(true);
    if (paramBoolean)
    {
      ThreadManager.postImmediately(new ApolloUrlInterceptor.1(this), null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    Object localObject = this.w;
    long l1 = System.currentTimeMillis();
    ((ApolloWebStatistics)localObject).g = l1;
    d();
    m();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runDataTask use:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
    }
    this.w.h = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    if (this.t != null) {
      this.t = null;
    }
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    if (bool2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.b);
      localStringBuilder.append(") onClose:readComplete:");
      localStringBuilder.append(paramBoolean);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 1, localStringBuilder.toString());
    }
    long l1 = System.currentTimeMillis();
    if ((paramBoolean) && (paramByteArrayOutputStream != null))
    {
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloUrlInterceptor.2(this, paramByteArrayOutputStream), 3000L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.b);
      localStringBuilder.append(") onClose error:readComplete =");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", outputStream is null -> ");
      if (paramByteArrayOutputStream == null) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      localStringBuilder.append(paramBoolean);
      QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 6, localStringBuilder.toString());
    }
    this.h.set(false);
    if (l())
    {
      paramByteArrayOutputStream = new StringBuilder();
      paramByteArrayOutputStream.append("task(");
      paramByteArrayOutputStream.append(this.b);
      paramByteArrayOutputStream.append(") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramByteArrayOutputStream.toString());
    }
    if (QLog.isColorLevel())
    {
      paramByteArrayOutputStream = new StringBuilder();
      paramByteArrayOutputStream.append("task(");
      paramByteArrayOutputStream.append(this.b);
      paramByteArrayOutputStream.append(") onClose cost ");
      paramByteArrayOutputStream.append(System.currentTimeMillis() - l1);
      paramByteArrayOutputStream.append(" ms.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 6, paramByteArrayOutputStream.toString());
    }
  }
  
  public boolean a()
  {
    return this.x ^ true;
  }
  
  public boolean a(CustomWebView paramCustomWebView)
  {
    if (this.o == null)
    {
      this.o = paramCustomWebView;
      paramCustomWebView = new StringBuilder();
      paramCustomWebView.append("task(");
      paramCustomWebView.append(this.b);
      paramCustomWebView.append(") bind client.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramCustomWebView.toString());
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(this.p);
      paramString = Uri.parse(paramString);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localUri.getHost());
      ((StringBuilder)localObject1).append(localUri.getPath());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString.getHost());
      ((StringBuilder)localObject2).append(paramString.getPath());
      localObject2 = ((StringBuilder)localObject2).toString();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject1;
        if (!((String)localObject1).endsWith("/"))
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append("/");
          paramString = paramString.toString();
        }
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("/");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject1);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isMatchCurrentUrl error:");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public ApolloWebStatistics b()
  {
    return this.w;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = this.x;
    boolean bool1 = false;
    if ((!bool2) && (a(paramString)) && (this.e.compareAndSet(false, true)))
    {
      this.p = ApolloClientUtil.a(paramString, "apollo_task_id", String.valueOf(this.b));
      this.w.j = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("task(");
        paramString.append(this.b);
        paramString.append(") onWebViewInited: mPendingClientCoreMessage not null:");
        if (this.s != null) {
          bool1 = true;
        }
        paramString.append(bool1);
        paramString.append(",currUrl:");
        paramString.append(this.p);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramString.toString());
      }
      paramString = this.s;
      if (paramString != null)
      {
        this.s = null;
        handleMessage(paramString);
        return true;
      }
      if (this.c.get() == 0) {
        a(true);
      }
      return true;
    }
    return false;
  }
  
  public Object c(String arg1)
  {
    if (this.x) {
      return null;
    }
    Object localObject1 = d(???);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = e(???);
    if (localObject1 != null) {
      return localObject1;
    }
    if (!a(???))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(")  getClientResource error:isMatchCurrentUrl false, url = ");
      ((StringBuilder)localObject1).append(???);
      f(((StringBuilder)localObject1).toString());
      return null;
    }
    if (this.d.get())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(")  getClientResource error:wasInterceptInvoked true, url = ");
      ((StringBuilder)localObject1).append(???);
      f(((StringBuilder)localObject1).toString());
    }
    localObject1 = this.d;
    boolean bool = false;
    if (!((AtomicBoolean)localObject1).compareAndSet(false, true))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(")  onClientRequestResource error:Intercept was already invoked, url = ");
      ((StringBuilder)localObject1).append(???);
      f(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("task(");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(")  getClientResource:url = ");
    ((StringBuilder)localObject1).append(???);
    f(((StringBuilder)localObject1).toString());
    long l1 = System.currentTimeMillis();
    if (this.c.get() == 1)
    {
      try
      {
        synchronized (this.c)
        {
          if (this.c.get() == 1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("task(");
            ((StringBuilder)localObject1).append(this.b);
            ((StringBuilder)localObject1).append(") now wait for pendingWebResourceStream!");
            f(((StringBuilder)localObject1).toString());
            this.c.wait(30000L);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("task(");
        localStringBuilder.append(this.b);
        localStringBuilder.append(") wait for pendingWebResourceStream failed");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
      }
      throw localThrowable;
    }
    else
    {
      ??? = new StringBuilder();
      ???.append("task(");
      ???.append(this.b);
      ???.append(") is not in running state: ");
      ???.append(this.c);
      f(???.toString());
    }
    ??? = new StringBuilder();
    ???.append("task(");
    ???.append(this.b);
    ???.append(") have pending stream? -> ");
    if (this.t != null) {
      bool = true;
    }
    ???.append(bool);
    ???.append(", cost ");
    ???.append(System.currentTimeMillis() - l1);
    ???.append("ms.");
    f(???.toString());
    ??? = i();
    if (??? != null) {
      return ???;
    }
    f("task(\" + id + \") getClientResource ret webResourceResponse:null ");
    return null;
  }
  
  public void c()
  {
    b(false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (c(paramMessage)) {
      return true;
    }
    if (j())
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("task(");
        paramMessage.append(this.b);
        paramMessage.append(") handleMessage error: is destroyed or waiting for destroy.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.b);
      localStringBuilder.append(") handleMessage: msg what = ");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(".");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
    }
    if (b(paramMessage)) {
      return true;
    }
    if (paramMessage == this.s) {
      this.s = null;
    }
    return a(paramMessage) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor
 * JD-Core Version:    0.7.0.1
 */