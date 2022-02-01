package com.tencent.dlsdk.yybutil.apkchannel.a;

import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

public final class a
{
  private static final b a = new b(101010256L);
  
  private static byte[] a(RandomAccessFile paramRandomAccessFile)
  {
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = a.a();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      int j = 1;
      if (i == -1)
      {
        i = 0;
      }
      else
      {
        if ((i != arrayOfByte[0]) || (paramRandomAccessFile.read() != arrayOfByte[1]) || (paramRandomAccessFile.read() != arrayOfByte[2]) || (paramRandomAccessFile.read() != arrayOfByte[3])) {
          break label154;
        }
        i = j;
      }
      if (i != 0)
      {
        paramRandomAccessFile.seek(l + 16L + 4L);
        arrayOfByte = new byte[2];
        paramRandomAccessFile.readFully(arrayOfByte);
        i = new c(arrayOfByte).b();
        if (i == 0) {
          return null;
        }
        arrayOfByte = new byte[i];
        paramRandomAccessFile.read(arrayOfByte);
        return arrayOfByte;
      }
      throw new ZipException("archive is not a ZIP archive");
      label154:
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return null;
      }
      paramString = new RandomAccessFile(paramString, "r");
      if (paramString.length() == 0L)
      {
        paramString.close();
        System.out.println("ERROR:[ZipEocdCommentTool]Your file length is zero!");
        return null;
      }
      byte[] arrayOfByte = a(paramString);
      paramString.close();
      return arrayOfByte;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.a.a
 * JD-Core Version:    0.7.0.1
 */