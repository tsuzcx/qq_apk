package com.tencent.mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ef.f;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.nz.m;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;
import java.util.Locale;

public class aa
{
  private u a;
  private m b;
  private volatile String c;
  
  public aa(u paramu)
  {
    this.a = paramu;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public void a(ConsoleMessage paramConsoleMessage)
  {
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Luggage.AppBrandWebViewClient");
    localStringBuilder.append(String.format(Locale.ENGLISH, ":page[%s %s]", new Object[] { this.a.getAppId(), this.a.an() }));
    f.a(paramConsoleMessage, localStringBuilder.toString());
  }
  
  public void a(@NonNull u paramu)
  {
    this.a = paramu;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean a(SslCertificate paramSslCertificate)
  {
    if (this.a.q() == null) {
      return false;
    }
    if (this.b == null) {
      this.b = j.b((com.tencent.luggage.wxa.nz.a)this.a.q().b(com.tencent.luggage.wxa.nz.a.class));
    }
    if (this.b == null) {
      return false;
    }
    Object localObject = paramSslCertificate.getIssuedTo().getDName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subjectDN: ");
    localStringBuilder.append((String)localObject);
    com.tencent.luggage.wxa.qz.o.e("Luggage.AppBrandWebViewClient", localStringBuilder.toString());
    try
    {
      localObject = paramSslCertificate.getClass().getDeclaredField("mX509Certificate");
      ((Field)localObject).setAccessible(true);
      paramSslCertificate = (X509Certificate)((Field)localObject).get(paramSslCertificate);
      try
      {
        this.b.checkServerTrusted(new X509Certificate[] { paramSslCertificate }, "generic");
        return true;
      }
      catch (Exception paramSslCertificate)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Certificate check failed: ");
        ((StringBuilder)localObject).append(paramSslCertificate);
        com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandWebViewClient", ((StringBuilder)localObject).toString());
        return false;
      }
      return false;
    }
    catch (Exception paramSslCertificate)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandWebViewClient", "Certificate check failed: ", new Object[] { paramSslCertificate });
    }
  }
  
  public void b(String paramString) {}
  
  public void c(String paramString) {}
  
  public void d(String paramString) {}
  
  public WebResourceResponse e(String paramString)
  {
    i locali = null;
    WebResourceResponse localWebResourceResponse = null;
    if (paramString == null) {
      return null;
    }
    if (!this.a.d()) {
      return null;
    }
    Object localObject = this.c;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandWebViewClient", "getAppResourceResponse with reqURL[%s], hostURL isEmpty", new Object[] { paramString });
      return null;
    }
    if (paramString.startsWith((String)localObject))
    {
      localWebResourceResponse = ad.b(this.a.q(), paramString.replaceFirst((String)localObject, ""));
      localObject = localWebResourceResponse;
      if (localWebResourceResponse == null)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandWebViewClient", "getAppResourceResponse %s not found", new Object[] { paramString });
        localWebResourceResponse = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
        localObject = localWebResourceResponse;
        if (Build.VERSION.SDK_INT >= 21)
        {
          localWebResourceResponse.setStatusCodeAndReasonPhrase(404, "NotFound");
          localObject = localWebResourceResponse;
        }
      }
    }
    else
    {
      localObject = locali;
      if (URLUtil.isAboutUrl(paramString)) {
        return localObject;
      }
      localObject = locali;
      if (URLUtil.isHttpUrl(paramString)) {
        return localObject;
      }
      localObject = locali;
      if (URLUtil.isHttpsUrl(paramString)) {
        return localObject;
      }
      if (URLUtil.isDataUrl(paramString)) {
        return null;
      }
      locali = new i();
      this.a.q().z().b(paramString, locali);
      localObject = localWebResourceResponse;
      if (locali.a != null) {
        localObject = new WebResourceResponse("", "", new com.tencent.luggage.util.a((ByteBuffer)locali.a));
      }
    }
    com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", new Object[] { paramString });
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa
 * JD-Core Version:    0.7.0.1
 */