package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

class ApolloUrlInterceptor$PreloadCGITask
{
  private ApolloSSOConfig.CGIConfig b;
  private ApolloUrlConnection c;
  private BridgeStream d;
  private AtomicBoolean e;
  private AtomicInteger f;
  private String g;
  private long h;
  private volatile boolean i;
  private HashMap<String, String> j;
  
  ApolloUrlInterceptor$PreloadCGITask(ApolloUrlInterceptor paramApolloUrlInterceptor, ApolloSSOConfig.CGIConfig paramCGIConfig)
  {
    this.b = paramCGIConfig;
    this.e = new AtomicBoolean(false);
    this.f = new AtomicInteger(0);
    this.j = new HashMap();
  }
  
  private void a(int paramInt, long paramLong)
  {
    try
    {
      if ((ApolloUrlInterceptor.a(this.a) != null) && (this.b != null))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("preloadSuccess", paramInt);
        localJSONObject.put("costTime", paramLong);
        ApolloUrlInterceptor.a(this.a).l.put(this.b.a, localJSONObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      if ((ApolloUrlInterceptor.a(this.a) != null) && (this.b != null))
      {
        JSONObject localJSONObject = ApolloUrlInterceptor.a(this.a).l.optJSONObject(this.b.a);
        if (localJSONObject != null)
        {
          localJSONObject.put("costTime", paramLong);
          ApolloUrlInterceptor.a(this.a).l.put(this.b.a, localJSONObject);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
    }
  }
  
  private void c()
  {
    ??? = this.b;
    if (??? != null)
    {
      if (!((ApolloSSOConfig.CGIConfig)???).a()) {
        return;
      }
      long l1 = System.currentTimeMillis();
      this.c = new ApolloUrlConnection(this.b.a, true, this.b, ApolloClientUtil.g(ApolloUrlInterceptor.e(this.a)));
      long l2 = System.currentTimeMillis();
      if (this.i) {
        return;
      }
      int m = this.c.a();
      this.f.set(1);
      int k = m;
      if (m == 0)
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b.a);
          ((StringBuilder)???).append(") connection connect cost = ");
          ((StringBuilder)???).append(System.currentTimeMillis() - l2);
          ((StringBuilder)???).append(" ms.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        l2 = System.currentTimeMillis();
        m = this.c.c();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b.a);
          ((StringBuilder)???).append(") connection response cost = ");
          ((StringBuilder)???).append(System.currentTimeMillis() - l2);
          ((StringBuilder)???).append(" ms.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        l2 = System.currentTimeMillis();
        Object localObject2 = this.c.d();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b.a);
          ((StringBuilder)???).append(") connection get header fields cost = ");
          ((StringBuilder)???).append(System.currentTimeMillis() - l2);
          ((StringBuilder)???).append(" ms.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        k = m;
        if (localObject2 != null)
        {
          if (((Map)localObject2).containsKey("Set-Cookie")) {
            ??? = "Set-Cookie";
          } else if (((Map)localObject2).containsKey("set-cookie")) {
            ??? = "set-cookie";
          } else {
            ??? = null;
          }
          if (!TextUtils.isEmpty((CharSequence)???))
          {
            ??? = (List)((Map)localObject2).get(???);
            ApolloClientUtil.a(this.b.a, (List)???);
          }
          ??? = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)???).hasNext())
          {
            Object localObject7 = (Map.Entry)((Iterator)???).next();
            localObject2 = (String)((Map.Entry)localObject7).getKey();
            localObject7 = (List)((Map.Entry)localObject7).getValue();
            if ((localObject7 != null) && (((List)localObject7).size() > 0)) {
              this.j.put(localObject2, ((List)localObject7).get(0));
            }
          }
          k = m;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("task(");
            ((StringBuilder)???).append(this.b.a);
            ((StringBuilder)???).append(") mHeaderMap:");
            ((StringBuilder)???).append(this.j);
            QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
            k = m;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("task(");
        ((StringBuilder)???).append(this.b.a);
        ((StringBuilder)???).append(") handleFlow_Connection: respCode = ");
        ((StringBuilder)???).append(k);
        ((StringBuilder)???).append(", cost ");
        ((StringBuilder)???).append(System.currentTimeMillis() - l1);
        ((StringBuilder)???).append(" ms.");
        QLog.d("[cmshow]Apollo_client_PreloadCGITask", 4, ((StringBuilder)???).toString());
      }
      if (ApolloUrlInterceptor.h(this.a))
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b.a);
          ((StringBuilder)???).append(") handleFlow_Connection: destroy before server response.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 6, ((StringBuilder)???).toString());
        }
        ??? = this.c;
        if (??? != null)
        {
          ((ApolloUrlConnection)???).b();
          this.c = null;
        }
        this.f.set(2);
        synchronized (this.f)
        {
          this.f.notifyAll();
          this.h = (System.currentTimeMillis() - l1);
          a(this.h);
          return;
        }
      }
      if (200 != k)
      {
        ??? = this.c;
        if (??? != null)
        {
          ((ApolloUrlConnection)???).b();
          this.c = null;
        }
        this.d = null;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b.a);
          ((StringBuilder)???).append(") handleFlow_Connection: response code not 200, response code = ");
          ((StringBuilder)???).append(k);
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 4, ((StringBuilder)???).toString());
        }
        this.f.set(2);
        synchronized (this.f)
        {
          this.f.notifyAll();
          this.h = (System.currentTimeMillis() - l1);
          a(this.h);
          return;
        }
      }
      if (this.i) {
        return;
      }
      ??? = this.c.a(this.e, null);
      if (??? == null)
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b.a);
          ((StringBuilder)???).append(") handleFlow_FirstLoad error:responseDataTuple is null!");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        this.d = null;
        this.f.set(2);
        synchronized (this.f)
        {
          this.f.notifyAll();
          this.h = (System.currentTimeMillis() - l1);
          a(this.h);
          return;
        }
      }
      if (this.i) {
        return;
      }
      this.d = new BridgeStream(null, ((ApolloUrlConnection.ResponseDataTuple)???).c, ((ApolloUrlConnection.ResponseDataTuple)???).b);
      this.f.set(2);
      synchronized (this.f)
      {
        this.f.notifyAll();
        this.h = (System.currentTimeMillis() - l1);
        a(this.h);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.b.a);
          ((StringBuilder)???).append(") mCostTime:");
          ((StringBuilder)???).append(this.h);
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        return;
      }
    }
  }
  
  public WebResourceResponse a(String paramString)
  {
    this.e.set(true);
    if (this.f.get() == 1)
    {
      try
      {
        synchronized (this.f)
        {
          if (this.f.get() == 1)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("getCgiResource(");
              localStringBuilder1.append(paramString);
              localStringBuilder1.append(") now wait for pendingWebResourceStream!");
              QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, localStringBuilder1.toString());
            }
            this.f.wait(200L);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getCgiResource");
        localStringBuilder2.append(localThrowable);
        QLog.e("[cmshow]Apollo_client_PreloadCGITask", 2, localStringBuilder2.toString());
      }
      throw paramString;
    }
    if (this.d != null)
    {
      if (TextUtils.isEmpty(this.g)) {
        this.g = ApolloClientUtil.a(paramString);
      }
      paramString = new WebResourceResponse(this.g, "utf-8", this.d);
      if (!this.j.isEmpty()) {
        paramString.setResponseHeaders(this.j);
      }
      a(1, this.h);
      this.i = true;
      this.d = null;
      return paramString;
    }
    this.i = true;
    a(0, this.h);
    return null;
  }
  
  public void a()
  {
    ApolloUrlConnection localApolloUrlConnection = this.c;
    if (localApolloUrlConnection != null)
    {
      localApolloUrlConnection.b();
      this.c = null;
    }
    if (this.d != null) {
      this.d = null;
    }
    QLog.d("[cmshow]Apollo_client_PreloadCGITask", 1, "PreloadCGITask onDestroy ");
  }
  
  public void b()
  {
    ThreadManagerV2.excute(new ApolloUrlInterceptor.PreloadCGITask.1(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.PreloadCGITask
 * JD-Core Version:    0.7.0.1
 */