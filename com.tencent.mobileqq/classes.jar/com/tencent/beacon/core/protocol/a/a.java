package com.tencent.beacon.core.protocol.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

public final class a
{
  public static byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = null;
    Object localObject = null;
    if (paramInt == 1)
    {
      localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      ZipInputStream localZipInputStream = new ZipInputStream(localByteArrayInputStream);
      paramArrayOfByte = (byte[])localObject;
      while (localZipInputStream.getNextEntry() != null)
      {
        paramArrayOfByte = new byte[1024];
        localObject = new ByteArrayOutputStream();
        for (;;)
        {
          paramInt = localZipInputStream.read(paramArrayOfByte, 0, 1024);
          if (paramInt == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject).write(paramArrayOfByte, 0, paramInt);
        }
        paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
        ((ByteArrayOutputStream)localObject).flush();
        ((ByteArrayOutputStream)localObject).close();
      }
      localZipInputStream.close();
      localByteArrayInputStream.close();
      localObject = paramArrayOfByte;
    }
    do
    {
      return localObject;
      localObject = localByteArrayInputStream;
    } while (paramInt != 2);
    return a(paramArrayOfByte);
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.a.a
 * JD-Core Version:    0.7.0.1
 */