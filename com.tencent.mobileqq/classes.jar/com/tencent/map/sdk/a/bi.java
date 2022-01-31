package com.tencent.map.sdk.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

public final class bi
  extends bc
{
  private long A = 0L;
  private String B;
  private bi.a C = new bi.a((byte)0);
  private boolean D = false;
  private bg E;
  long o;
  boolean p = false;
  int q = 0;
  boolean r = false;
  private HttpURLConnection s;
  private DataOutputStream t;
  private DataInputStream u;
  private bh v;
  private String w;
  private boolean x;
  private boolean y;
  private int z;
  
  public bi(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    this.w = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (ao.g() == 2)
    {
      i = as.a("direct_access_time_out", 1000, 60000, 15000);
      int j = i;
      if (paramInt < i) {
        j = paramInt;
      }
      this.f = dg.a(j, 200, 60000, 10000);
      if (this.b.length() <= 8) {
        break label204;
      }
      if ((this.b.charAt(7) != '[') && (this.b.charAt(8) != '[')) {
        break label199;
      }
      paramBoolean = true;
    }
    label164:
    label199:
    label204:
    for (this.g = a(paramInt, paramBoolean);; this.g = a(paramInt, false))
    {
      this.h = paramString3;
      return;
      i = as.a("direct_access_time_out", 1000, 60000, 10000);
      break;
      paramBoolean = false;
      break label164;
    }
  }
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if ((ao.h() == 2) && (paramBoolean))
    {
      i = as.a("direct_access_conn_time_out", 1000, 60000, 2000);
      if (paramInt >= i) {
        break label60;
      }
    }
    for (;;)
    {
      return dg.a(paramInt, 200, 60000, 10000);
      i = as.a("direct_access_conn_time_out", 1000, 60000, 10000);
      break;
      label60:
      paramInt = i;
    }
  }
  
  private void a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        localBufferedInputStream = new BufferedInputStream(this.s.getInputStream());
        localByteArrayOutputStream = new ByteArrayOutputStream();
        arrayOfByte = new byte[4096];
        i = 0;
        j = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          BufferedInputStream localBufferedInputStream;
          ByteArrayOutputStream localByteArrayOutputStream;
          byte[] arrayOfByte;
          int i;
          int k;
          localByteArrayOutputStream.close();
          return;
        }
        catch (Exception localException2)
        {
          int j;
          return;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        j = 0;
        this.v.a = -306;
        this.v.b = "no-content-length:".concat(String.valueOf(j));
        return;
      }
      catch (Exception localException1)
      {
        this.v.a = -287;
        this.v.b = "read without content-length error";
        return;
      }
      try
      {
        k = localBufferedInputStream.read(arrayOfByte);
        if (k == -1) {
          break label211;
        }
        j = i;
        localByteArrayOutputStream.write(arrayOfByte, 0, k);
        k = i + k;
        i = k;
        if (k > paramInt)
        {
          j = k;
          this.v.a = -303;
          j = k;
          this.v.b = "no-content-length";
          paramInt = m;
          i = k;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        continue;
        paramInt = 1;
      }
    }
    if (paramInt != 0)
    {
      j = i;
      this.v.d = localByteArrayOutputStream.toByteArray();
      j = i;
      this.C.f = SystemClock.elapsedRealtime();
    }
    j = i;
  }
  
  private void c()
  {
    int j = 0;
    int i = j;
    if (this.d != null)
    {
      i = j;
      if (this.d.size() > 0)
      {
        Iterator localIterator = this.d.keySet().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)this.d.get(str1);
          this.s.addRequestProperty(str1, str2);
          if (!str1.toLowerCase().contains("host")) {
            break label209;
          }
          i = 1;
        }
      }
    }
    label209:
    for (;;)
    {
      break;
      if (i == 0) {
        this.s.setRequestProperty("Host", this.w);
      }
      this.s.setRequestProperty("Halley", this.h + "-" + this.q + "-" + System.currentTimeMillis());
      if (this.p)
      {
        this.s.setRequestProperty("X-Online-Host", this.w);
        this.s.setRequestProperty("x-tx-host", this.w);
      }
      return;
    }
  }
  
  private boolean d()
  {
    if (this.m)
    {
      this.v.a = -20;
      this.o = (SystemClock.elapsedRealtime() - this.o);
      this.C.a();
      return true;
    }
    return false;
  }
  
  private void e()
  {
    try
    {
      if (this.s != null) {
        this.s.disconnect();
      }
      if (this.t != null) {
        this.t.close();
      }
      if (this.u != null) {
        this.u.close();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final bh a()
  {
    int i1 = 1;
    int i = 1;
    int m = 1;
    int j = 1;
    int k = 1;
    int n = 1;
    this.o = SystemClock.elapsedRealtime();
    this.C.a = this.o;
    this.v = new bh(0, "");
    label2048:
    for (;;)
    {
      try
      {
        if (d())
        {
          localObject3 = this.v;
          e();
          this.o = (SystemClock.elapsedRealtime() - this.o);
          this.C.a();
          localObject1 = localObject3;
          if (this.v.a != 0)
          {
            localObject1 = localObject3;
            if (ao.i())
            {
              localObject1 = localObject3;
              if (this.v.a != -20)
              {
                if (as.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                  continue;
                }
                i = n;
                localObject1 = localObject3;
                if (i != 0)
                {
                  this.B = dg.c(this.w);
                  localObject1 = localObject3;
                }
              }
            }
          }
          return localObject1;
          i = 0;
          continue;
        }
        Object localObject1 = new URL(this.b);
        this.x = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        this.y = dg.d(((URL)localObject1).getHost());
        if (this.x)
        {
          if ((this.p) && (ao.l() != null))
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(ao.l());
            localObject3 = localObject1;
            if (this.y)
            {
              this.E = new bg(this.w);
              ((HttpsURLConnection)localObject1).setSSLSocketFactory(this.E);
              ((HttpsURLConnection)localObject1).setHostnameVerifier(new bf(this.w));
              localObject3 = localObject1;
            }
            this.s = ((HttpURLConnection)localObject3);
            localObject3 = this.s;
            if (!this.c) {
              break label2053;
            }
            localObject1 = "GET";
            ((HttpURLConnection)localObject3).setRequestMethod((String)localObject1);
            this.s.setConnectTimeout(this.g);
            this.s.setReadTimeout(this.f);
            this.s.setUseCaches(false);
            this.s.setDoInput(true);
            this.s.setInstanceFollowRedirects(false);
            c();
            if ((!this.c) && (!dg.a(this.e)))
            {
              this.s.setDoOutput(true);
              this.A = this.e.length;
            }
            this.C.b = SystemClock.elapsedRealtime();
            this.s.connect();
            this.C.c = SystemClock.elapsedRealtime();
            if (d())
            {
              localObject3 = this.v;
              e();
              this.o = (SystemClock.elapsedRealtime() - this.o);
              this.C.a();
              localObject1 = localObject3;
              if (this.v.a == 0) {
                continue;
              }
              localObject1 = localObject3;
              if (!ao.i()) {
                continue;
              }
              localObject1 = localObject3;
              if (this.v.a == -20) {
                continue;
              }
              if (as.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                break label2061;
              }
              i = i1;
              localObject1 = localObject3;
              if (i == 0) {
                continue;
              }
              this.B = dg.c(this.w);
              return localObject3;
            }
          }
          else
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection();
            continue;
          }
        }
        else
        {
          if ((this.p) && (ao.l() != null))
          {
            localObject3 = (HttpURLConnection)((URL)localObject1).openConnection(ao.l());
            continue;
          }
          localObject3 = (HttpURLConnection)((URL)localObject1).openConnection();
          continue;
        }
        if ((!this.c) && (!dg.a(this.e)))
        {
          this.t = new DataOutputStream(this.s.getOutputStream());
          this.t.write(this.e);
          this.t.flush();
        }
        this.C.d = SystemClock.elapsedRealtime();
        n = this.s.getResponseCode();
        this.C.e = SystemClock.elapsedRealtime();
        this.v.c = n;
        this.s.getContentType();
        localObject1 = new HashMap();
        Object localObject3 = this.s.getHeaderFields().entrySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          if (localEntry.getKey() == null) {
            continue;
          }
          ((Map)localObject1).put(localEntry.getKey(), ((List)localEntry.getValue()).get(0));
          continue;
        }
        try
        {
          byte[] arrayOfByte = new byte[this.z];
          this.u = new DataInputStream(this.s.getInputStream());
          this.u.readFully(arrayOfByte);
          this.v.d = arrayOfByte;
          this.C.f = SystemClock.elapsedRealtime();
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.v.a = -306;
          this.v.b = this.z;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.v.a = -300;
        e();
        this.o = (SystemClock.elapsedRealtime() - this.o);
        this.C.a();
        if ((this.v.a != 0) && (ao.i()) && (this.v.a != -20))
        {
          if (as.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1589;
          }
          if (i != 0) {
            this.B = dg.c(this.w);
          }
        }
        return this.v;
        this.v.a(localMalformedURLException);
        if ((this.v.c < 200) || (this.v.c >= 300)) {
          break label1541;
        }
        this.z = this.s.getContentLength();
        n = as.a("app_receive_pack_size", 524288, 10485760, 2097152);
        if (this.z < 0)
        {
          a(n);
          e();
          this.o = (SystemClock.elapsedRealtime() - this.o);
          this.C.a();
          if ((this.v.a == 0) || (!ao.i()) || (this.v.a == -20)) {
            continue;
          }
          if (as.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1584;
          }
          i = m;
          if (i == 0) {
            continue;
          }
          this.B = dg.c(this.w);
          continue;
        }
        if (this.z == 0)
        {
          this.v.d = new byte[0];
          this.C.f = SystemClock.elapsedRealtime();
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        this.v.a = -287;
        this.v.b = (localThrowable.getClass().getSimpleName() + "(" + localThrowable.getLocalizedMessage() + ")");
        if ((this.x) && (this.v.b.toLowerCase().contains("cannot verify hostname"))) {
          break label2066;
        }
        if ((!this.x) || (!this.v.b.toLowerCase().contains("not verified"))) {
          break label1594;
        }
        break label2066;
        if (ao.i()) {
          break label1599;
        }
        this.v.a = -4;
        e();
        this.o = (SystemClock.elapsedRealtime() - this.o);
        this.C.a();
        if ((this.v.a == 0) || (!ao.i()) || (this.v.a == -20)) {
          continue;
        }
        if (as.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
          break label2043;
        }
        i = j;
        if (i == 0) {
          continue;
        }
        this.B = dg.c(this.w);
        continue;
        if (this.z > n)
        {
          this.v.a = -303;
          this.v.b = this.z;
          continue;
        }
      }
      finally
      {
        e();
        this.o = (SystemClock.elapsedRealtime() - this.o);
        this.C.a();
        if ((this.v.a != 0) && (ao.i()) && (this.v.a != -20))
        {
          if (as.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label2048;
          }
          i = k;
          if (i != 0) {
            this.B = dg.c(this.w);
          }
        }
      }
      continue;
      label1541:
      label2053:
      label2061:
      label2066:
      if ((this.v.c >= 300) && (this.v.c < 400))
      {
        this.i = this.v.a("location");
        continue;
        label1584:
        i = 0;
        continue;
        label1589:
        i = 0;
        continue;
        label1594:
        i = 0;
        continue;
        label1599:
        if (this.m)
        {
          this.v.a = -20;
        }
        else if (i != 0)
        {
          this.v.a = -289;
        }
        else if ((localOutOfMemoryError instanceof SSLHandshakeException))
        {
          this.v.a = -290;
        }
        else if (((localOutOfMemoryError instanceof SSLKeyException)) || ((localOutOfMemoryError instanceof SSLPeerUnverifiedException)) || ((localOutOfMemoryError instanceof SSLProtocolException)))
        {
          this.v.a = -291;
        }
        else
        {
          this.j = true;
          if ((localOutOfMemoryError.getMessage() != null) && (localOutOfMemoryError.getMessage().toLowerCase().contains("permission")))
          {
            this.v.a = -281;
            this.v.b = "no permission";
          }
          else if ((localOutOfMemoryError instanceof UnknownHostException))
          {
            this.v.a = -284;
          }
          else if ((localOutOfMemoryError instanceof ConnectException))
          {
            this.v.a = -42;
          }
          else
          {
            String str;
            if ((localOutOfMemoryError instanceof SocketTimeoutException))
            {
              str = localOutOfMemoryError.getLocalizedMessage();
              if ((str != null) && ((str.toLowerCase().contains("connect")) || (str.toLowerCase().contains("connection")))) {
                this.v.a = -10;
              } else {
                this.v.a = -13;
              }
            }
            else if ((str instanceof SocketException))
            {
              this.v.a = -41;
            }
            else if ((str instanceof IOException))
            {
              this.v.a = -286;
              if ((this.x) && (this.E != null) && (this.E.a))
              {
                if (this.v.b.contains("SSLHandshakeException"))
                {
                  this.v.a = -290;
                }
                else if (this.v.b.contains("SocketTimeoutException"))
                {
                  this.v.a = -10;
                }
                else if ((str instanceof InterruptedIOException))
                {
                  this.v.a = -292;
                  this.j = false;
                }
                else
                {
                  this.v.a = -293;
                }
              }
              else if ((str instanceof InterruptedIOException))
              {
                this.v.a = -292;
                this.j = false;
                continue;
                label2043:
                i = 0;
                continue;
                i = 0;
                continue;
                str = "POST";
                continue;
                i = 0;
                continue;
                i = 1;
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap1);
    localHashMap.put("B59", this.o);
    if (this.x) {
      localHashMap.put("B85", "1");
    }
    int i;
    if (this.c)
    {
      localHashMap.put("B95", "1");
      if (!this.y) {
        localHashMap.put("B23", "1");
      }
      localHashMap.put("B220", ao.h());
      paramMap1 = new HashMap();
      paramMap1.putAll(paramMap2);
      paramMap1.put("B88", this.z);
      paramMap1.put("B90", this.C.g);
      paramMap1.put("B91", this.C.h);
      paramMap1.put("B92", this.C.i);
      paramMap1.put("B93", this.C.j);
      paramMap1.put("B94", this.C.k);
      if (!TextUtils.isEmpty(this.i)) {
        paramMap1.put("B47", this.i);
      }
      if (!TextUtils.isEmpty(this.B)) {
        paramMap1.put("B41", this.B);
      }
      if (this.v.a == 0) {
        break label462;
      }
      i = this.v.a;
    }
    for (;;)
    {
      if ((this.r) && (i != -4)) {
        break label491;
      }
      dd.b("HLHttpDirect", ac.c(), i, this.v.b, localHashMap, paramMap1, this.j);
      return;
      localHashMap.put("B96", this.A);
      break;
      label462:
      if (this.v.c == 200) {
        i = 0;
      } else {
        i = this.v.c;
      }
    }
    label491:
    dd.a("HLHttpDirect", ac.c(), i, this.v.b, localHashMap, paramMap1, this.j);
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean b()
  {
    this.m = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bi
 * JD-Core Version:    0.7.0.1
 */