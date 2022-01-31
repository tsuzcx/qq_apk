package c.t.m.g;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLException;

public final class cv
{
  public Context a;
  public String b;
  public String c;
  String d;
  
  public cv(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString2;
    this.c = paramString1;
    this.d = paramString3;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  static void a(String paramString, byte[] paramArrayOfByte, a parama, int paramInt)
  {
    for (;;)
    {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
        Object localObject = localHttpURLConnection.getOutputStream();
        ((OutputStream)localObject).write(paramArrayOfByte);
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        int i = localHttpURLConnection.getResponseCode();
        switch (i)
        {
        case 200: 
          parama.a("net sdk error: ".concat(String.valueOf(i)));
          localHttpURLConnection.disconnect();
          return;
          localObject = b(localHttpURLConnection.getHeaderField("content-type"));
          new String(a(localHttpURLConnection.getInputStream()), (String)localObject);
          parama.a();
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
          parama.a(paramInt + "," + paramString + "," + Log.getStackTraceString(localThrowable));
          return;
        }
      }
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    byte[] arrayOfByte = new byte[256];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static String b(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cv
 * JD-Core Version:    0.7.0.1
 */