package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

public final class ap
  extends aj
{
  private int A;
  private long B = 0L;
  private String C;
  private a D = new a((byte)0);
  private boolean E = false;
  private an F;
  long o;
  boolean p = false;
  int q = 0;
  boolean r = false;
  private HttpURLConnection s;
  private DataOutputStream t;
  private DataInputStream u;
  private ao v;
  private String w;
  private boolean x;
  private boolean y;
  private String z = "";
  
  public ap(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    this.w = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (x.g() == 2)
    {
      i = x.a.a("direct_access_time_out", 1000, 60000, 15000);
      if (paramInt >= i) {
        break label145;
      }
    }
    for (;;)
    {
      this.f = cn.a(paramInt, 200, 60000, 10000);
      this.g = paramString3;
      return;
      i = x.a.a("direct_access_time_out", 1000, 60000, 10000);
      break;
      label145:
      paramInt = i;
    }
  }
  
  private void a(int paramInt)
    throws IOException
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
      this.D.f = SystemClock.elapsedRealtime();
    }
    j = i;
  }
  
  private void b()
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
            break label207;
          }
          i = 1;
        }
      }
    }
    label207:
    for (;;)
    {
      break;
      if (i == 0) {
        this.s.setRequestProperty("Host", this.w);
      }
      this.s.setRequestProperty("Halley", this.g + "-" + this.q + "-" + System.currentTimeMillis());
      if (this.p)
      {
        this.s.setRequestProperty("X-Online-Host", this.w);
        this.s.setRequestProperty("x-tx-host", this.w);
      }
      return;
    }
  }
  
  private void c()
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
  
  public final ao a()
  {
    int m = 1;
    int j = 1;
    int k = 1;
    int i = 1;
    this.m = System.currentTimeMillis();
    this.o = SystemClock.elapsedRealtime();
    this.D.a = this.o;
    this.v = new ao(0, "");
    label1322:
    label1604:
    label1609:
    label1614:
    for (;;)
    {
      try
      {
        Object localObject1 = new URL(this.b);
        this.x = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        this.y = cn.d(((URL)localObject1).getHost());
        if (this.x) {
          if ((this.p) && (x.k() != null))
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(x.k());
            localObject3 = localObject1;
            if (this.y)
            {
              this.F = new an(this.w);
              ((HttpsURLConnection)localObject1).setSSLSocketFactory(this.F);
              ((HttpsURLConnection)localObject1).setHostnameVerifier(new am(this.w));
              localObject3 = localObject1;
            }
            this.s = ((HttpURLConnection)localObject3);
            localObject3 = this.s;
            if (!this.c) {
              break label1614;
            }
            localObject1 = "GET";
            ((HttpURLConnection)localObject3).setRequestMethod((String)localObject1);
            this.s.setConnectTimeout(this.f);
            this.s.setReadTimeout(this.f);
            this.s.setUseCaches(false);
            this.s.setDoInput(true);
            this.s.setInstanceFollowRedirects(false);
            b();
            if ((!this.c) && (!cn.a(this.e)))
            {
              this.s.setDoOutput(true);
              this.B = this.e.length;
            }
            this.D.b = SystemClock.elapsedRealtime();
            this.s.connect();
            this.D.c = SystemClock.elapsedRealtime();
            if ((!this.c) && (!cn.a(this.e)))
            {
              this.t = new DataOutputStream(this.s.getOutputStream());
              this.t.write(this.e);
              this.t.flush();
            }
            this.D.d = SystemClock.elapsedRealtime();
            n = this.s.getResponseCode();
            this.D.e = SystemClock.elapsedRealtime();
            this.v.c = n;
            this.z = this.s.getContentType();
            localObject1 = new HashMap();
            localObject3 = this.s.getHeaderFields().entrySet().iterator();
            if (!((Iterator)localObject3).hasNext()) {
              continue;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            if (localEntry.getKey() == null) {
              continue;
            }
            ((Map)localObject1).put(localEntry.getKey(), ((List)localEntry.getValue()).get(0));
            continue;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.v.a = -300;
        c();
        this.o = (SystemClock.elapsedRealtime() - this.o);
        this.D.a();
        if ((this.v.a != 0) && (x.h()) && (this.v.a != -20))
        {
          if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1370;
          }
          if (i != 0) {
            this.C = cn.c(this.w);
          }
        }
        return this.v;
        HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)localMalformedURLException.openConnection();
        continue;
        if ((this.p) && (x.k() != null))
        {
          localObject3 = (HttpURLConnection)localHttpsURLConnection.openConnection(x.k());
          continue;
        }
        Object localObject3 = (HttpURLConnection)localHttpsURLConnection.openConnection();
        continue;
        this.v.a(localHttpsURLConnection);
        if ((this.v.c < 200) || (this.v.c >= 300)) {
          break label1322;
        }
        this.A = this.s.getContentLength();
        n = x.a.a("app_receive_pack_size", 524288, 10485760, 2097152);
        if (this.A < 0)
        {
          a(n);
          c();
          this.o = (SystemClock.elapsedRealtime() - this.o);
          this.D.a();
          if ((this.v.a == 0) || (!x.h()) || (this.v.a == -20)) {
            continue;
          }
          if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1365;
          }
          i = m;
          if (i == 0) {
            continue;
          }
          this.C = cn.c(this.w);
          continue;
        }
        if (this.A == 0)
        {
          this.v.d = null;
          this.D.f = SystemClock.elapsedRealtime();
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int n;
        localThrowable.printStackTrace();
        this.v.a = -287;
        this.v.b = (localThrowable.getClass().getSimpleName() + "(" + localThrowable.getLocalizedMessage() + ")");
        if (((this.F != null) && (this.F.a)) || ((this.x) && (this.v.b.toLowerCase().contains("cannot verify hostname")))) {
          break label1622;
        }
        if ((!this.x) || (!this.v.b.toLowerCase().contains("not verified"))) {
          break label1375;
        }
        break label1622;
        if (x.h()) {
          break label1380;
        }
        this.v.a = -4;
        c();
        this.o = (SystemClock.elapsedRealtime() - this.o);
        this.D.a();
        if ((this.v.a == 0) || (!x.h()) || (this.v.a == -20)) {
          continue;
        }
        if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
          break label1604;
        }
        i = j;
        if (i == 0) {
          continue;
        }
        this.C = cn.c(this.w);
        continue;
        if (this.A > n)
        {
          this.v.a = -303;
          this.v.b = this.A;
          continue;
        }
      }
      finally
      {
        c();
        this.o = (SystemClock.elapsedRealtime() - this.o);
        this.D.a();
        if ((this.v.a != 0) && (x.h()) && (this.v.a != -20))
        {
          if (x.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1609;
          }
          i = k;
          if (i != 0) {
            this.C = cn.c(this.w);
          }
        }
      }
      try
      {
        byte[] arrayOfByte = new byte[this.A];
        this.u = new DataInputStream(this.s.getInputStream());
        this.u.readFully(arrayOfByte);
        this.v.d = arrayOfByte;
        this.D.f = SystemClock.elapsedRealtime();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.v.a = -306;
        this.v.b = this.A;
      }
      continue;
      label1365:
      label1622:
      if ((this.v.c >= 300) && (this.v.c < 400))
      {
        this.h = this.v.a("location");
        continue;
        i = 0;
        continue;
        label1370:
        i = 0;
        continue;
        label1375:
        i = 0;
        continue;
        label1380:
        if (i != 0)
        {
          this.v.a = -289;
        }
        else
        {
          this.i = true;
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
              continue;
              i = 0;
              continue;
              i = 0;
              continue;
              str = "POST";
              continue;
              i = 1;
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
      paramMap1 = new HashMap();
      paramMap1.putAll(paramMap2);
      if (this.m != 0L) {
        paramMap1.put("B84", this.m);
      }
      paramMap1.put("B87", this.z);
      paramMap1.put("B88", this.A);
      paramMap1.put("B90", this.D.g);
      paramMap1.put("B91", this.D.h);
      paramMap1.put("B92", this.D.i);
      paramMap1.put("B93", this.D.j);
      paramMap1.put("B94", this.D.k);
      if (!TextUtils.isEmpty(this.h)) {
        paramMap1.put("B47", this.h);
      }
      if (!TextUtils.isEmpty(this.C)) {
        paramMap1.put("B41", this.C);
      }
      if (this.v.a == 0) {
        break label485;
      }
      i = this.v.a;
    }
    for (;;)
    {
      if ((this.r) && (i != -4)) {
        break label514;
      }
      cl.b("HLHttpDirect", m.c(), i, this.v.b, localHashMap, paramMap1, this.i);
      return;
      localHashMap.put("B96", this.B);
      break;
      label485:
      if (this.v.c == 200) {
        i = 0;
      } else {
        i = this.v.c;
      }
    }
    label514:
    cl.a("HLHttpDirect", m.c(), i, this.v.b, localHashMap, paramMap1, this.i);
  }
  
  public final void a(boolean paramBoolean) {}
  
  static final class a
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    long g = -1L;
    long h = -1L;
    long i = -1L;
    long j = -1L;
    long k = -1L;
    
    public final void a()
    {
      long l2 = -1L;
      this.g = (this.b - this.a);
      this.h = (this.c - this.b);
      this.i = (this.d - this.c);
      this.j = (this.e - this.d);
      this.k = (this.f - this.e);
      long l1 = this.g;
      if (l1 >= 0L)
      {
        this.g = l1;
        l1 = this.h;
        if (l1 < 0L) {
          break label164;
        }
        label96:
        this.h = l1;
        l1 = this.i;
        if (l1 < 0L) {
          break label171;
        }
        label112:
        this.i = l1;
        l1 = this.j;
        if (l1 < 0L) {
          break label178;
        }
      }
      for (;;)
      {
        this.j = l1;
        long l3 = this.k;
        l1 = l2;
        if (l3 >= 0L) {
          l1 = l3;
        }
        this.k = l1;
        return;
        l1 = -1L;
        break;
        label164:
        l1 = -1L;
        break label96;
        label171:
        l1 = -1L;
        break label112;
        label178:
        l1 = -1L;
      }
    }
    
    public final String toString()
    {
      return "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ap
 * JD-Core Version:    0.7.0.1
 */