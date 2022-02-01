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
  public final int a;
  public volatile long a;
  volatile WebResourceResponse jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = null;
  public String a;
  public Thread a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  public boolean a;
  public final int b;
  public volatile long b;
  String jdField_b_of_type_JavaLangString;
  public AtomicBoolean b;
  boolean jdField_b_of_type_Boolean = false;
  public final int c;
  public volatile long c;
  public volatile String c;
  public volatile boolean c;
  public final int d;
  public volatile long d;
  public final int e;
  private long e;
  
  public PubAccountWebViewHttpBridge()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Int = 4;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = "null";
    this.jdField_e_of_type_Long = 0L;
  }
  
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
    int j = 1;
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          break label348;
        }
        paramIntent = a();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("get cookie cost: ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
          QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject1 = paramIntent;
        if (TextUtils.isEmpty(paramIntent))
        {
          if (QLog.isColorLevel()) {
            QLog.w("PubAccountWebViewHttpBridge", 2, " cookie is null!");
          }
          this.jdField_c_of_type_JavaLangString = "Cookie_Not_Valid";
          localObject1 = paramIntent;
        }
        paramIntent = (HttpURLConnection)new URL(this.jdField_a_of_type_JavaLangString).openConnection();
        if (paramIntent == null) {}
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PubAccountWebViewHttpBridge", 2, "HttpURLConnection is null!");
          }
          this.jdField_c_of_type_JavaLangString = "URLConnection_NULL";
          return null;
        }
        catch (Exception localException1) {}
        paramIntent.setConnectTimeout(15000);
        paramIntent.setReadTimeout(15000);
        i = 0;
        paramIntent.setInstanceFollowRedirects(false);
        paramIntent.setRequestProperty("Cookie", (String)localObject1);
        paramIntent.setRequestProperty("Accept-Encoding", "gzip");
        paramIntent.setRequestProperty("User-Agent", SwiftWebViewUtils.a(SwiftWebViewUtils.c("httpAsync 1.0"), "", false));
        int k = paramIntent.getResponseCode();
        this.jdField_c_of_type_JavaLangString = String.valueOf(k);
        if (k != 200) {
          i = 1;
        }
        if (k == 200)
        {
          this.jdField_b_of_type_JavaLangString = paramIntent.getHeaderField("Content-Length");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("length is ");
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
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
      int i = j;
      Object localObject2 = paramIntent;
      if (paramIntent != null)
      {
        paramIntent.disconnect();
        localObject2 = paramIntent;
        i = j;
      }
      if (i != 0) {
        return null;
      }
      return localObject2;
      label348:
      localObject2 = "";
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "now notify all thread!");
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        return;
      }
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2)) {
      return;
    }
    long l = System.currentTimeMillis();
    HttpURLConnection localHttpURLConnection = a(null);
    if (localHttpURLConnection == null) {
      return;
    }
    a(l, localHttpURLConnection, true);
  }
  
  public WebResourceResponse a(String arg1, int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    int i = NetUtil.a(null);
    JSONObject localJSONObject = new JSONObject();
    long l = System.currentTimeMillis();
    Object localObject4;
    try
    {
      Uri localUri = Uri.parse(this.jdField_a_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        try
        {
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
          {
            if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
            {
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
              if (QLog.isColorLevel()) {
                QLog.d("PubAccountWebViewHttpBridge", 2, "now wait for response!");
              }
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(30000L);
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
        ???.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
        QLog.d("PubAccountWebViewHttpBridge", 2, ???.toString());
      }
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PubAccountWebViewHttpBridge", 2, " some thing goes wrong！ WebResourceResponse is null!", ???);
      }
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PubAccountWebViewHttpBridge", 2, "asyncMode: 1, some thing goes wrong！ WebResourceResponse is null!");
      }
    }
    else
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(3, 4))
      {
        if (QLog.isColorLevel()) {
          QLog.w("PubAccountWebViewHttpBridge", 2, "can not use response !");
        }
        this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = null;
      }
      else
      {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - l);
      this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_e_of_type_Long);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("return reponse for url, wait for : ");
        ???.append(System.currentTimeMillis() - l);
        ???.append(", from click: ");
        ???.append(this.jdField_c_of_type_Long);
        ???.append(" , cache size=");
        ???.append(this.jdField_d_of_type_Long);
        ???.append("  ,cururl=");
        ???.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("PubAccountWebViewHttpBridge", 2, ???.toString());
      }
      try
      {
        localJSONObject.put("waitResponseTime", this.jdField_b_of_type_Long);
        localJSONObject.put("clickReadinjoyTime", this.jdField_c_of_type_Long);
        localJSONObject.put("loadedSize", this.jdField_d_of_type_Long);
        localJSONObject.put("platform", "android");
        localJSONObject.put("position", paramInt);
      }
      catch (JSONException ???)
      {
        ???.printStackTrace();
      }
      ??? = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(i);
      ???.publicAccountReportClickEvent(null, "", "0X8007775", "0X8007775", 0, 0, (String)localObject3, ((StringBuilder)localObject4).toString(), localJSONObject.toString(), this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangString = "";
    return this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse;
  }
  
  public String a()
  {
    return SwiftBrowserCookieMonster.c(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PubAccountWebViewHttpBridge", 2, "async http get cost too much time, now destroy!");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangThread = null;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  void a(long paramLong, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_Long = paramHttpURLConnection.getContentLength();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = Formatter.formatFileSize(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_d_of_type_Long);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("data encoding: ");
          ((StringBuilder)localObject2).append(paramHttpURLConnection.getContentEncoding());
          ((StringBuilder)localObject2).append(" now read content: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" reportWebsiteLength: ");
          ((StringBuilder)localObject2).append(this.jdField_d_of_type_Long);
          QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject1 = paramHttpURLConnection.getInputStream();
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PubAccountWebViewHttpBridge", 2, "inputstream or contentType goes wrong!");
          }
          this.jdField_c_of_type_JavaLangString = "InputStream_Error";
          throw new RuntimeException("InputStream is null!");
        }
        if ("gzip".equalsIgnoreCase(paramHttpURLConnection.getContentEncoding())) {
          localObject1 = new BufferedInputStream(new GZIPInputStream((InputStream)localObject1));
        } else {
          localObject1 = new BufferedInputStream((InputStream)localObject1);
        }
        long l = System.currentTimeMillis();
        if (paramBoolean)
        {
          Object localObject4 = new byte[10240];
          localObject2 = null;
          int j = 0;
          int i = 0;
          if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            i = ((BufferedInputStream)localObject1).read((byte[])localObject4);
            if (i != -1)
            {
              j += i;
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = new ByteArrayOutputStream();
              }
              ((ByteArrayOutputStream)localObject3).write((byte[])localObject4, 0, i);
              Thread.sleep(20L);
              localObject2 = localObject3;
              continue;
            }
          }
          this.jdField_d_of_type_Long = j;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("now read data: ");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(", now is ShouldIntercept: ");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
            QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject3).toString());
          }
          if ((i != -1) || (j <= 0)) {
            break label635;
          }
          if (QLog.isColorLevel()) {
            QLog.i("PubAccountWebViewHttpBridge", 2, "now read all data!");
          }
          paramHttpURLConnection.disconnect();
          this.jdField_c_of_type_JavaLangString = "Read_All_Data";
          localObject1 = null;
          if (localObject2 == null) {
            break label638;
          }
          localObject3 = new BufferedInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()));
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("read byte stream cost : ");
            ((StringBuilder)localObject4).append(System.currentTimeMillis() - l);
            ((StringBuilder)localObject4).append(", total cost: ");
            ((StringBuilder)localObject4).append(System.currentTimeMillis() - paramLong);
            QLog.d("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject4).toString());
          }
          this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = new WebResourceResponse(a(this.jdField_a_of_type_JavaLangString), "utf-8", new PubAccountWebViewHttpBridge.BridgeStream(this, (BufferedInputStream)localObject3, (BufferedInputStream)localObject1, (ByteArrayOutputStream)localObject2, paramHttpURLConnection));
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
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(new PubAccountWebViewHttpBridge.1(this), "PubAccountWebViewHttpBridge", 5);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("now prepare async get ");
        localStringBuilder.append(Util.b(paramString, new String[0]));
        QLog.i("PubAccountWebViewHttpBridge", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaLangThread.start();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountWebViewHttpBridge
 * JD-Core Version:    0.7.0.1
 */