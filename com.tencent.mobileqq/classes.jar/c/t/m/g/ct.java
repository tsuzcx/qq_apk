package c.t.m.g;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.zip.GZIPOutputStream;

public final class ct
{
  private static final byte[] a = new byte[0];
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = a(paramString.getBytes("UTF-8"));
      paramString = cr.a(paramString, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
      if (!f.a.a(paramString))
      {
        paramString = Base64.encode(paramString, 2);
        if (!f.a.a(paramString)) {
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      cl.b("SosoLocUtils", paramString.toString());
      return a;
    }
    return a;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject1 = localObject2;
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return localObject1;
  }
  
  public static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(Integer.toHexString(localObject[i] & 0xFF)).append("");
        i += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "abcdefgh" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ct
 * JD-Core Version:    0.7.0.1
 */