package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class dy
  implements ey
{
  private byte[] a = new byte[512];
  
  public static SharedPreferences a(String paramString)
  {
    int i;
    if ("com.tencent.mobileqq".equals(dp.a().getPackageName())) {
      i = 4;
    } else {
      i = 0;
    }
    return dp.a().getSharedPreferences(paramString, i);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    if ((paramObject instanceof String)) {
      paramSharedPreferences.putString(paramString, (String)paramObject);
    } else if ((paramObject instanceof Integer)) {
      paramSharedPreferences.putInt(paramString, ((Integer)paramObject).intValue());
    } else if ((paramObject instanceof Boolean)) {
      paramSharedPreferences.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    } else if ((paramObject instanceof Float)) {
      paramSharedPreferences.putFloat(paramString, ((Float)paramObject).floatValue());
    } else if ((paramObject instanceof Long)) {
      paramSharedPreferences.putLong(paramString, ((Long)paramObject).longValue());
    } else {
      paramSharedPreferences.putString(paramString, paramObject.toString());
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramSharedPreferences.apply();
      return;
    }
    paramSharedPreferences.commit();
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    a(a(paramString1), paramString2, paramObject);
  }
  
  private byte[] a(InputStream paramInputStream)
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
  
  public static Object b(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return paramSharedPreferences.getString(paramString, (String)paramObject);
    }
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(paramSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
    }
    if ((paramObject instanceof Boolean)) {
      return Boolean.valueOf(paramSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
    }
    if ((paramObject instanceof Float)) {
      return Float.valueOf(paramSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
    }
    if ((paramObject instanceof Long)) {
      return Long.valueOf(paramSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
    }
    return null;
  }
  
  public static Object b(String paramString1, String paramString2, Object paramObject)
  {
    return b(a(paramString1), paramString2, paramObject);
  }
  
  private static String b(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i].trim();
        int k = str.indexOf("charset=");
        if (-1 != k) {
          return str.substring(k + 8, str.length());
        }
        i += 1;
      }
    }
    return "GBK";
  }
  
  public final Pair<byte[], String> a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    try
    {
      paramString.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
      paramString.setRequestMethod("POST");
      paramString.setConnectTimeout(10000);
      paramString.setDoOutput(true);
      paramString.setFixedLengthStreamingMode(paramArrayOfByte.length);
      Object localObject = paramString.getOutputStream();
      ((OutputStream)localObject).write(paramArrayOfByte);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      int i = paramString.getResponseCode();
      if (i == 200)
      {
        paramArrayOfByte = b(paramString.getHeaderField("content-type"));
        localObject = a(paramString.getInputStream());
        if ((localObject != null) && (localObject.length != 0))
        {
          paramArrayOfByte = Pair.create(localObject, paramArrayOfByte);
          return paramArrayOfByte;
        }
        paramArrayOfByte = Pair.create("{}".getBytes(), "utf-8");
        return paramArrayOfByte;
      }
      throw new IOException("net sdk error: ".concat(String.valueOf(i)));
    }
    finally
    {
      paramString.disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dy
 * JD-Core Version:    0.7.0.1
 */