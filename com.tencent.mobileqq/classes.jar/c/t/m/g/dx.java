package c.t.m.g;

import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class dx
  implements TencentHttpClient
{
  private byte[] a = new byte[512];
  
  private static String a(String paramString)
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
  
  private byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    for (;;)
    {
      int i = paramInputStream.read(this.a);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(this.a, 0, i);
    }
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public final Pair<byte[], String> postSync(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    for (;;)
    {
      try
      {
        paramString.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        paramString.setRequestMethod("POST");
        paramString.setConnectTimeout(10000);
        paramString.setDoOutput(true);
        paramString.setFixedLengthStreamingMode(paramArrayOfByte.length);
        localObject = paramString.getOutputStream();
        ((OutputStream)localObject).write(paramArrayOfByte);
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        int i = paramString.getResponseCode();
        switch (i)
        {
        case 200: 
          throw new IOException("net sdk error: ".concat(String.valueOf(i)));
        }
      }
      finally
      {
        paramString.disconnect();
      }
      paramArrayOfByte = a(paramString.getHeaderField("content-type"));
      Object localObject = a(paramString.getInputStream());
      if ((localObject == null) || (localObject.length == 0))
      {
        paramArrayOfByte = Pair.create("{}".getBytes(), "utf-8");
        paramString.disconnect();
        return paramArrayOfByte;
      }
      paramArrayOfByte = Pair.create(localObject, paramArrayOfByte);
      paramString.disconnect();
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dx
 * JD-Core Version:    0.7.0.1
 */