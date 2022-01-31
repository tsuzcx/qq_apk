package com.tencent.image;

import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  protected static char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static MessageDigest messagedigest = null;
  
  static
  {
    try
    {
      messagedigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = hexDigits[((paramByte & 0xF0) >> 4)];
    char c2 = hexDigits[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static String bufferToHex(byte[] paramArrayOfByte)
  {
    return bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] byteArrayToMd5(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    messagedigest.update(paramString.getBytes());
    return messagedigest.digest();
  }
  
  public static String getMd5(Object paramObject)
  {
    String str = "";
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    for (;;)
    {
      try
      {
        if ((paramObject instanceof String))
        {
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = new FileInputStream((String)paramObject);
          paramObject = str;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramObject = getStreamMD5String((InputStream)localObject1);
          }
          localObject3 = paramObject;
        }
      }
      catch (FileNotFoundException paramObject)
      {
        localObject3 = localObject2;
        paramObject.printStackTrace();
        localObject3 = "";
        if (localObject2 == null) {
          continue;
        }
        try
        {
          localObject2.close();
          return "";
        }
        catch (IOException paramObject)
        {
          paramObject.printStackTrace();
          return "";
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label190;
        }
      }
      try
      {
        ((InputStream)localObject1).close();
        localObject3 = paramObject;
        return localObject3;
      }
      catch (IOException paramObject)
      {
        paramObject.printStackTrace();
        return "";
      }
      localObject2 = localObject4;
      localObject3 = localObject5;
      if ((paramObject instanceof FileDescriptor))
      {
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = new FileInputStream((FileDescriptor)paramObject);
      }
      else
      {
        localObject2 = localObject4;
        localObject3 = localObject5;
        if ((paramObject instanceof byte[]))
        {
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = new ByteArrayInputStream((byte[])paramObject);
        }
      }
    }
    try
    {
      ((InputStream)localObject3).close();
      label190:
      throw paramObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public static String getStreamMD5String(InputStream paramInputStream)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = localObject4;
    if (paramInputStream != null) {}
    try
    {
      long l1 = paramInputStream.available();
      localObject3 = new byte[4096];
      while (l1 > 0L)
      {
        long l3 = paramInputStream.read((byte[])localObject3);
        if (l3 == -1L) {
          break;
        }
        long l2 = l3;
        if (l3 > l1) {
          l2 = l1;
        }
        l1 -= l2;
        messagedigest.update(ByteBuffer.wrap((byte[])localObject3, 0, (int)l2));
      }
      try
      {
        String str;
        paramInputStream.close();
        throw localObject2;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localObject3 = localObject4;
      if (paramInputStream != null) {}
      do
      {
        try
        {
          paramInputStream.close();
          localObject3 = localObject4;
          return localObject3;
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
          return null;
        }
        paramInputStream.close();
        localObject3 = messagedigest.digest();
        if (localObject3 != null) {
          str = bufferToHex((byte[])localObject3);
        }
        localObject3 = str;
      } while (paramInputStream == null);
      try
      {
        paramInputStream.close();
        return str;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
        return str;
      }
    }
    finally
    {
      if (paramInputStream == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.MD5Util
 * JD-Core Version:    0.7.0.1
 */