package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class PubAccountWebViewHttpBridge
{
  public boolean a = false;
  public String b = "";
  public Thread c;
  public final int d = 1;
  public final int e = 2;
  public final int f = 3;
  public final int g = 4;
  public final int h = -1;
  AtomicInteger i = new AtomicInteger(1);
  AtomicBoolean j = new AtomicBoolean(false);
  public AtomicBoolean k = new AtomicBoolean(false);
  volatile WebResourceResponse l = null;
  boolean m = false;
  String n;
  public volatile long o = 0L;
  public volatile long p = 0L;
  public volatile long q = 0L;
  public volatile boolean r = false;
  public volatile long s = 0L;
  public volatile String t = "null";
  private long u = 0L;
  
  private String a(String paramString)
  {
    paramString = Uri.parse(paramString).getPath();
    if (paramString.contains(".css")) {
      return "text/css";
    }
    if (paramString.contains(".js")) {
      return "application/x-javascript";
    }
    if ((!paramString.contains(".jpg")) && (!paramString.contains(".gif")) && (!paramString.contains(".png")) && (!paramString.contains(".jpeg"))) {
      return "text/html";
    }
    return "image/*";
  }
  
  private HttpURLConnection a(Intent paramIntent)
  {
    int i2 = 1;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        boolean bool = this.a;
        if (!bool) {
          break label348;
        }
        paramIntent = a();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("get cookie cost: ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
          QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject1 = paramIntent;
        if (TextUtils.isEmpty(paramIntent))
        {
          if (QLog.isColorLevel()) {
            QLog.w("PubAccountWebViewHttpBridge", 2, " cookie is null!");
          }
          this.t = "Cookie_Not_Valid";
          localObject1 = paramIntent;
        }
        paramIntent = (HttpURLConnection)new URL(this.b).openConnection();
        if (paramIntent == null) {}
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PubAccountWebViewHttpBridge", 2, "HttpURLConnection is null!");
          }
          this.t = "URLConnection_NULL";
          return null;
        }
        catch (Exception localException1) {}
        paramIntent.setConnectTimeout(15000);
        paramIntent.setReadTimeout(15000);
        i1 = 0;
        paramIntent.setInstanceFollowRedirects(false);
        paramIntent.setRequestProperty("Cookie", (String)localObject1);
        paramIntent.setRequestProperty("Accept-Encoding", "gzip");
        paramIntent.setRequestProperty("User-Agent", SwiftWebViewUtils.a(SwiftWebViewUtils.c("httpAsync 1.0"), "", false));
        int i3 = paramIntent.getResponseCode();
        this.t = String.valueOf(i3);
        if (i3 != 200) {
          i1 = 1;
        }
        if (i3 == 200)
        {
          this.n = paramIntent.getHeaderField("Content-Length");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("length is ");
            ((StringBuilder)localObject1).append(this.n);
            QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = paramIntent;
      }
      catch (Exception localException2)
      {
        paramIntent = null;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PubAccountWebViewHttpBridge", 2, "http async get handleEvent exception !!!!", localException2);
      }
      int i1 = i2;
      Object localObject2 = paramIntent;
      if (paramIntent != null)
      {
        paramIntent.disconnect();
        localObject2 = paramIntent;
        i1 = i2;
      }
      if (i1 != 0) {
        return null;
      }
      return localObject2;
      label348:
      localObject2 = "";
    }
  }
  
  private void c()
  {
    if (this.i.compareAndSet(2, 3)) {
      synchronized (this.i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "now notify all thread!");
        }
        this.i.notify();
        return;
      }
    }
  }
  
  private void d()
  {
    if (!this.i.compareAndSet(1, 2)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    HttpURLConnection localHttpURLConnection = a(null);
    if (localHttpURLConnection == null) {
      return;
    }
    a(l1, localHttpURLConnection, true);
  }
  
  public WebResourceResponse a(String arg1, int paramInt)
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    int i1 = NetUtil.a(null);
    JSONObject localJSONObject = new JSONObject();
    long l1 = System.currentTimeMillis();
    Object localObject4;
    try
    {
      Uri localUri = Uri.parse(this.b);
      ??? = Uri.parse(???);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localUri.getHost());
      ((StringBuilder)localObject1).append(localUri.getPath());
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(???.getHost());
      ((StringBuilder)localObject4).append(???.getPath());
      localObject4 = ((StringBuilder)localObject4).toString();
      if (!localUri.getHost().equalsIgnoreCase(???.getHost())) {
        return null;
      }
      ??? = (String)localObject1;
      if (!((String)localObject1).endsWith("/"))
      {
        ??? = new StringBuilder();
        ???.append((String)localObject1);
        ???.append("/");
        ??? = ???.toString();
      }
      localObject1 = localObject4;
      if (!((String)localObject4).endsWith("/"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject4);
        ((StringBuilder)localObject1).append("/");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (!???.equalsIgnoreCase((String)localObject1)) {
        return null;
      }
      if (this.i.get() == 2)
      {
        try
        {
          synchronized (this.i)
          {
            if ((this.i.get() == 2) && (!this.j.get()))
            {
              this.j.compareAndSet(false, true);
              if (QLog.isColorLevel()) {
                QLog.d("PubAccountWebViewHttpBridge", 2, "now wait for response!");
              }
              this.i.wait(30000L);
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          QLog.e("PubAccountWebViewHttpBridge", 1, "wait fror response failed", localInterruptedException);
        }
        throw localInterruptedException;
      }
      else if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("state not connecting: ");
        ???.append(this.i);
        QLog.d("PubAccountWebViewHttpBridge", 2, ???.toString());
      }
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PubAccountWebViewHttpBridge", 2, " some thing goes wrong！ WebResourceResponse is null!", ???);
      }
    }
    if (this.l == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PubAccountWebViewHttpBridge", 2, "asyncMode: 1, some thing goes wrong！ WebResourceResponse is null!");
      }
    }
    else
    {
      if (!this.i.compareAndSet(3, 4))
      {
        if (QLog.isColorLevel()) {
          QLog.w("PubAccountWebViewHttpBridge", 2, "can not use response !");
        }
        this.l = null;
      }
      else
      {
        this.r = true;
      }
      this.p = (System.currentTimeMillis() - l1);
      this.q = (System.currentTimeMillis() - this.u);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("return reponse for url, wait for : ");
        ???.append(System.currentTimeMillis() - l1);
        ???.append(", from click: ");
        ???.append(this.q);
        ???.append(" , cache size=");
        ???.append(this.s);
        ???.append("  ,cururl=");
        ???.append(this.b);
        QLog.d("PubAccountWebViewHttpBridge", 2, ???.toString());
      }
      try
      {
        localJSONObject.put("waitResponseTime", this.p);
        localJSONObject.put("clickReadinjoyTime", this.q);
        localJSONObject.put("loadedSize", this.s);
        localJSONObject.put("platform", "android");
        localJSONObject.put("position", paramInt);
      }
      catch (JSONException ???)
      {
        ???.printStackTrace();
      }
      ??? = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.r);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(i1);
      ???.publicAccountReportClickEvent(null, "", "0X8007775", "0X8007775", 0, 0, (String)localObject3, ((StringBuilder)localObject4).toString(), localJSONObject.toString(), this.n);
    }
    this.b = "";
    return this.l;
  }
  
  public String a()
  {
    return SwiftBrowserCookieMonster.d(this.b);
  }
  
  void a(long paramLong, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.s = paramHttpURLConnection.getContentLength();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = Formatter.formatFileSize(BaseApplicationImpl.getApplication().getApplicationContext(), this.s);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("data encoding: ");
          ((StringBuilder)localObject2).append(paramHttpURLConnection.getContentEncoding());
          ((StringBuilder)localObject2).append(" now read content: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" reportWebsiteLength: ");
          ((StringBuilder)localObject2).append(this.s);
          QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject1 = paramHttpURLConnection.getInputStream();
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PubAccountWebViewHttpBridge", 2, "inputstream or contentType goes wrong!");
          }
          this.t = "InputStream_Error";
          throw new RuntimeException("InputStream is null!");
        }
        if ("gzip".equalsIgnoreCase(paramHttpURLConnection.getContentEncoding())) {
          localObject1 = new BufferedInputStream(new GZIPInputStream((InputStream)localObject1));
        } else {
          localObject1 = new BufferedInputStream((InputStream)localObject1);
        }
        long l1 = System.currentTimeMillis();
        if (paramBoolean)
        {
          Object localObject4 = new byte[10240];
          localObject2 = null;
          int i2 = 0;
          int i1 = 0;
          if (!this.j.get())
          {
            i1 = ((BufferedInputStream)localObject1).read((byte[])localObject4);
            if (i1 != -1)
            {
              i2 += i1;
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = new ByteArrayOutputStream();
              }
              ((ByteArrayOutputStream)localObject3).write((byte[])localObject4, 0, i1);
              Thread.sleep(20L);
              localObject2 = localObject3;
              continue;
            }
          }
          this.s = i2;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("now read data: ");
            ((StringBuilder)localObject3).append(i2);
            ((StringBuilder)localObject3).append(", now is ShouldIntercept: ");
            ((StringBuilder)localObject3).append(this.j.get());
            QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject3).toString());
          }
          if ((i1 != -1) || (i2 <= 0)) {
            break label635;
          }
          if (QLog.isColorLevel()) {
            QLog.i("PubAccountWebViewHttpBridge", 2, "now read all data!");
          }
          paramHttpURLConnection.disconnect();
          this.t = "Read_All_Data";
          localObject1 = null;
          if (localObject2 == null) {
            break label638;
          }
          localObject3 = new BufferedInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()));
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("read byte stream cost : ");
            ((StringBuilder)localObject4).append(System.currentTimeMillis() - l1);
            ((StringBuilder)localObject4).append(", total cost: ");
            ((StringBuilder)localObject4).append(System.currentTimeMillis() - paramLong);
            QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject4).toString());
          }
          this.l = new WebResourceResponse(a(this.b), "utf-8", new PubAccountWebViewHttpBridge.BridgeStream(this, (BufferedInputStream)localObject3, (BufferedInputStream)localObject1, (ByteArrayOutputStream)localObject2, paramHttpURLConnection));
          if (QLog.isColorLevel())
          {
            paramHttpURLConnection = new StringBuilder();
            paramHttpURLConnection.append("swiftHttp get cost ");
            paramHttpURLConnection.append(System.currentTimeMillis() - paramLong);
            QLog.d("PubAccountWebViewHttpBridge", 2, paramHttpURLConnection.toString());
            paramHttpURLConnection = new StringBuilder();
            paramHttpURLConnection.append("Web_qqbrowser_http_async_get, cost ");
            paramHttpURLConnection.append(System.currentTimeMillis() - paramLong);
            QLog.d("QQBrowser_report", 2, paramHttpURLConnection.toString());
            return;
          }
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        QLog.e("PubAccountWebViewHttpBridge", 1, "swiftHttp read data exception !!!! ", paramHttpURLConnection);
      }
      return;
      label635:
      continue;
      label638:
      Object localObject3 = null;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.k.compareAndSet(false, true);
      this.u = System.currentTimeMillis();
      this.b = paramString;
      this.a = paramBoolean;
      this.c = ThreadManager.newFreeThread(new PubAccountWebViewHttpBridge.1(this), "PubAccountWebViewHttpBridge", 5);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("now prepare async get ");
        localStringBuilder.append(Util.b(paramString, new String[0]));
        QLog.i("PubAccountWebViewHttpBridge", 2, localStringBuilder.toString());
      }
      this.c.start();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    if (this.i.get() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PubAccountWebViewHttpBridge", 2, "async http get cost too much time, now destroy!");
      }
      this.i.set(-1);
      synchronized (this.i)
      {
        this.i.notify();
      }
    }
    this.i.set(-1);
    this.m = true;
    this.c = null;
    this.b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountWebViewHttpBridge
 * JD-Core Version:    0.7.0.1
 */