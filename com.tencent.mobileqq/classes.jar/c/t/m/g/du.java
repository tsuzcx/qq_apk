package c.t.m.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLException;

public final class du
{
  private long A = 30000L;
  private String B = "6.0.5.8";
  private String C = "201207";
  private String D = this.B;
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public String j;
  public long k;
  public boolean l = true;
  public boolean m = true;
  public boolean n = true;
  public int o = -2;
  public Pair<String, String> p;
  private final ea q;
  private String r;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private long z = 20000L;
  
  public du(ea paramea)
  {
    this.q = paramea;
  }
  
  private static String a(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i2 = paramString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramString[i1].trim();
        int i3 = str.indexOf("charset=");
        if (-1 != i3) {
          return str.substring(i3 + 8, str.length());
        }
        i1 += 1;
      }
    }
    return "GBK";
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt, du.b paramb)
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
      localHttpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.setRequestProperty("Connection", "close");
      Object localObject = localHttpURLConnection.getOutputStream();
      ((OutputStream)localObject).write(paramArrayOfByte);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      int i1 = localHttpURLConnection.getResponseCode();
      if (i1 != 200)
      {
        paramb.b("net sdk error: ".concat(String.valueOf(i1)));
      }
      else
      {
        localObject = a(localHttpURLConnection.getHeaderField("content-type"));
        paramb.a(new String(a(localHttpURLConnection.getInputStream()), (String)localObject));
      }
      localHttpURLConnection.disconnect();
      return;
    }
    catch (Throwable localThrowable)
    {
      while ((paramInt <= 0) && (((localThrowable instanceof GeneralSecurityException)) || ((localThrowable instanceof SSLException))))
      {
        paramString = paramString.replaceAll("https:", "http:");
        paramInt += 1;
      }
      paramArrayOfByte = new StringBuilder("tryTime=");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append(",");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(",");
      paramArrayOfByte.append(Log.getStackTraceString(localThrowable));
      paramb.b(paramArrayOfByte.toString());
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    byte[] arrayOfByte = dn.a().a(512);
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i1);
    }
    paramInputStream.close();
    dn.a().a(arrayOfByte);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "0123456789ABCDEF";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String c()
  {
    if ((!TextUtils.isEmpty(this.e)) && (!this.e.contains("0000"))) {
      return this.e;
    }
    return "0123456789ABCDEF";
  }
  
  public final String d()
  {
    String str2 = this.B;
    String str1 = str2;
    if (str2 == null) {
      str1 = "None";
    }
    return str1;
  }
  
  public final String e()
  {
    String str2 = this.C;
    String str1 = str2;
    if (str2 == null) {
      str1 = "None";
    }
    return str1;
  }
  
  public final String f()
  {
    if (this.r == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(a());
      localStringBuilder.append("_");
      localStringBuilder.append(b());
      localStringBuilder.append("_");
      localStringBuilder.append(c());
      localStringBuilder.append("_QQGeoLocation");
      this.r = co.d(localStringBuilder.toString());
    }
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.du
 * JD-Core Version:    0.7.0.1
 */