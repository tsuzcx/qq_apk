package c.t.m.g;

import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
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

public final class ak
  extends ae
{
  boolean A = false;
  private HttpURLConnection B;
  private DataOutputStream C;
  private DataInputStream D;
  private String E;
  private ai F;
  aj o;
  boolean p;
  boolean q;
  String r = "";
  int s;
  long t = 0L;
  String u;
  a v = new a((byte)0);
  long w;
  boolean x = false;
  boolean y = false;
  int z = 0;
  
  public ak(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    this.E = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (o.g() == 2)
    {
      i = v.a("direct_access_time_out", 1000, 60000, 15000);
      if (paramInt >= i) {
        break label145;
      }
    }
    for (;;)
    {
      this.f = ch.a(paramInt, 200, 60000, 10000);
      this.g = paramString3;
      return;
      i = v.a("direct_access_time_out", 1000, 60000, 10000);
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
        localBufferedInputStream = new BufferedInputStream(this.B.getInputStream());
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
        this.o.a = -306;
        this.o.b = ("no-content-length:" + j);
        return;
      }
      catch (Exception localException1)
      {
        this.o.a = -287;
        this.o.b = "read without content-length error";
        return;
      }
      try
      {
        k = localBufferedInputStream.read(arrayOfByte);
        if (k == -1) {
          break label218;
        }
        j = i;
        localByteArrayOutputStream.write(arrayOfByte, 0, k);
        k = i + k;
        i = k;
        if (k > paramInt)
        {
          j = k;
          this.o.a = -303;
          j = k;
          this.o.b = "no-content-length";
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
      this.o.d = localByteArrayOutputStream.toByteArray();
      j = i;
      this.v.f = SystemClock.elapsedRealtime();
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
          this.B.addRequestProperty(str1, str2);
          if (!str1.toLowerCase().contains("host")) {
            break label225;
          }
          i = 1;
        }
      }
    }
    label225:
    for (;;)
    {
      break;
      if (i == 0) {
        this.B.setRequestProperty("Host", this.E);
      }
      this.B.setRequestProperty("Halley", this.g + "-" + this.z + "-" + System.currentTimeMillis());
      if (this.y) {
        this.B.setRequestProperty("Connection", "close");
      }
      if (this.x)
      {
        this.B.setRequestProperty("X-Online-Host", this.E);
        this.B.setRequestProperty("x-tx-host", this.E);
      }
      return;
    }
  }
  
  private void c()
  {
    try
    {
      if (this.B != null) {
        this.B.disconnect();
      }
      if (this.C != null) {
        this.C.close();
      }
      if (this.D != null) {
        this.D.close();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final aj a()
  {
    int j = 1;
    this.m = System.currentTimeMillis();
    this.w = SystemClock.elapsedRealtime();
    this.v.a = this.w;
    this.o = new aj(0, "");
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new URL(this.b);
        this.p = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        this.q = ch.d(((URL)localObject1).getHost());
        if (this.p) {
          if ((this.x) && (o.k() != null))
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(o.k());
            localObject3 = localObject1;
            if (this.q)
            {
              this.F = new ai(this.E);
              ((HttpsURLConnection)localObject1).setSSLSocketFactory(this.F);
              ((HttpsURLConnection)localObject1).setHostnameVerifier(new ah(this.E));
              localObject3 = localObject1;
            }
            this.B = ((HttpURLConnection)localObject3);
            localObject3 = this.B;
            if (!this.c) {
              break label1356;
            }
            localObject1 = "GET";
            ((HttpURLConnection)localObject3).setRequestMethod((String)localObject1);
            this.B.setConnectTimeout(this.f);
            this.B.setReadTimeout(this.f);
            this.B.setUseCaches(false);
            this.B.setDoInput(true);
            this.B.setInstanceFollowRedirects(false);
            b();
            if ((!this.c) && (!ch.a(this.e)))
            {
              this.B.setDoOutput(true);
              this.t = this.e.length;
            }
            this.v.b = SystemClock.elapsedRealtime();
            this.B.connect();
            this.v.c = SystemClock.elapsedRealtime();
            if ((!this.c) && (!ch.a(this.e)))
            {
              this.C = new DataOutputStream(this.B.getOutputStream());
              this.C.write(this.e);
              this.C.flush();
            }
            this.v.d = SystemClock.elapsedRealtime();
            i = this.B.getResponseCode();
            this.v.e = SystemClock.elapsedRealtime();
            this.o.c = i;
            this.r = this.B.getContentType();
            localObject1 = new HashMap();
            localObject3 = this.B.getHeaderFields().entrySet().iterator();
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
        this.o.a = -300;
        return this.o;
        HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)localMalformedURLException.openConnection(Proxy.NO_PROXY);
        continue;
        if ((this.x) && (o.k() != null))
        {
          localObject3 = (HttpURLConnection)localHttpsURLConnection.openConnection(o.k());
          continue;
        }
        Object localObject3 = (HttpURLConnection)localHttpsURLConnection.openConnection(Proxy.NO_PROXY);
        continue;
        this.o.a(localHttpsURLConnection);
        if ((this.o.c < 200) || (this.o.c >= 300)) {
          break label1059;
        }
        this.s = this.B.getContentLength();
        i = v.a("app_receive_pack_size", 524288, 10485760, 2097152);
        if (this.s < 0)
        {
          a(i);
          c();
          this.w = (SystemClock.elapsedRealtime() - this.w);
          this.v.a();
          continue;
        }
        if (this.s == 0)
        {
          this.o.d = null;
          this.v.f = SystemClock.elapsedRealtime();
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        this.o.a = -287;
        this.o.b = (localThrowable.getClass().getSimpleName() + "(" + localThrowable.getLocalizedMessage() + ")");
        if (this.F != null)
        {
          i = j;
          if (this.F.a) {}
        }
        else if (this.p)
        {
          i = j;
          if (this.o.b.toLowerCase().contains("cannot verify hostname")) {}
        }
        else
        {
          if ((!this.p) || (!this.o.b.toLowerCase().contains("not verified"))) {
            break label1116;
          }
          i = j;
        }
        if (o.h()) {
          break label1121;
        }
        this.o.a = -4;
        c();
        this.w = (SystemClock.elapsedRealtime() - this.w);
        this.v.a();
        continue;
        if (this.s > i)
        {
          this.o.a = -303;
          this.o.b = this.s;
          continue;
        }
      }
      finally
      {
        c();
        this.w = (SystemClock.elapsedRealtime() - this.w);
        this.v.a();
      }
      try
      {
        byte[] arrayOfByte = new byte[this.s];
        this.D = new DataInputStream(this.B.getInputStream());
        this.D.readFully(arrayOfByte);
        this.o.d = arrayOfByte;
        this.v.f = SystemClock.elapsedRealtime();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.o.a = -306;
        this.o.b = this.s;
      }
      continue;
      label1059:
      label1356:
      if ((this.o.c >= 300) && (this.o.c < 400))
      {
        this.h = this.o.a("location");
      }
      else
      {
        this.u = ch.c(this.E);
        continue;
        label1116:
        i = 0;
        continue;
        label1121:
        if (i != 0)
        {
          this.o.a = -289;
        }
        else
        {
          this.i = true;
          if (this.v.e == 0L) {
            this.u = ch.c(this.E);
          }
          if ((localOutOfMemoryError.getMessage() != null) && (localOutOfMemoryError.getMessage().toLowerCase().contains("permission")))
          {
            this.o.a = -281;
            this.o.b = "no permission";
          }
          else if ((localOutOfMemoryError instanceof UnknownHostException))
          {
            this.o.a = -284;
          }
          else if ((localOutOfMemoryError instanceof ConnectException))
          {
            this.o.a = -42;
          }
          else
          {
            String str;
            if ((localOutOfMemoryError instanceof SocketTimeoutException))
            {
              str = localOutOfMemoryError.getLocalizedMessage();
              if ((str != null) && ((str.toLowerCase().contains("connect")) || (str.toLowerCase().contains("connection")))) {
                this.o.a = -10;
              } else {
                this.o.a = -13;
              }
            }
            else if ((str instanceof SocketException))
            {
              this.o.a = -41;
            }
            else if ((str instanceof IOException))
            {
              this.o.a = -286;
              continue;
              str = "POST";
            }
          }
        }
      }
    }
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
 * Qualified Name:     c.t.m.g.ak
 * JD-Core Version:    0.7.0.1
 */