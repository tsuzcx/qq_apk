package c.t.m.g;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import javax.net.ssl.SSLException;

public final class ds
{
  public LinkedList<fk> a = null;
  public fm b = null;
  public fm c = null;
  public float d = 0.0F;
  public float e = 0.0F;
  public long f = 0L;
  public boolean g = true;
  public float h = 0.0F;
  public eb i;
  private final float j = 1.0F;
  private final float k = 0.6F;
  
  private static String a(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int n;
    int m;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      n = paramString.length;
      m = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (m < n)
      {
        str1 = paramString[m].trim();
        int i1 = str1.indexOf("charset=");
        if (-1 != i1) {
          str1 = str1.substring(i1 + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      m += 1;
    }
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt, ds.b paramb)
  {
    for (;;)
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
        int m = localHttpURLConnection.getResponseCode();
        switch (m)
        {
        case 200: 
          paramb.b("net sdk error: ".concat(String.valueOf(m)));
          localHttpURLConnection.disconnect();
          return;
          localObject = a(localHttpURLConnection.getHeaderField("content-type"));
          paramb.a(new String(a(localHttpURLConnection.getInputStream()), (String)localObject));
        }
      }
      catch (Throwable localThrowable)
      {
        if ((paramInt <= 0) && (((localThrowable instanceof GeneralSecurityException)) || ((localThrowable instanceof SSLException))))
        {
          paramString = paramString.replaceAll("https:", "http:");
          paramInt += 1;
        }
        else
        {
          paramb.b("tryTime=" + paramInt + "," + paramString + "," + Log.getStackTraceString(localThrowable));
          return;
        }
      }
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    byte[] arrayOfByte = dm.a().a(512);
    for (;;)
    {
      int m = paramInputStream.read(arrayOfByte);
      if (m == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, m);
    }
    paramInputStream.close();
    dm.a().a(arrayOfByte);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ds
 * JD-Core Version:    0.7.0.1
 */