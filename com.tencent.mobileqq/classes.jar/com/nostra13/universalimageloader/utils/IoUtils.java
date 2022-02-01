package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils
{
  public static final int CONTINUE_LOADING_PERCENTAGE = 75;
  public static final int DEFAULT_BUFFER_SIZE = 32768;
  public static final int DEFAULT_IMAGE_TOTAL_SIZE = 512000;
  
  public static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static boolean copyStream(InputStream paramInputStream, OutputStream paramOutputStream, IoUtils.CopyListener paramCopyListener)
  {
    return copyStream(paramInputStream, paramOutputStream, paramCopyListener, 32768);
  }
  
  public static boolean copyStream(InputStream paramInputStream, OutputStream paramOutputStream, IoUtils.CopyListener paramCopyListener, int paramInt)
  {
    int j = paramInputStream.available();
    int i = j;
    if (j <= 0) {
      i = 512000;
    }
    byte[] arrayOfByte = new byte[paramInt];
    if (shouldStopLoading(paramCopyListener, 0, i)) {
      return false;
    }
    j = 0;
    int k;
    do
    {
      k = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (k == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, k);
      k = j + k;
      j = k;
    } while (!shouldStopLoading(paramCopyListener, k, i));
    return false;
    paramOutputStream.flush();
    return true;
  }
  
  /* Error */
  public static void readAndCloseStream(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 9
    //   2: newarray byte
    //   4: astore_2
    //   5: aload_0
    //   6: aload_2
    //   7: iconst_0
    //   8: ldc 9
    //   10: invokevirtual 44	java/io/InputStream:read	([BII)I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_m1
    //   16: if_icmpeq +13 -> 29
    //   19: goto -14 -> 5
    //   22: astore_2
    //   23: aload_0
    //   24: invokestatic 59	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   27: aload_2
    //   28: athrow
    //   29: aload_0
    //   30: invokestatic 59	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   33: return
    //   34: astore_2
    //   35: goto -6 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramInputStream	InputStream
    //   13	4	1	i	int
    //   4	3	2	arrayOfByte	byte[]
    //   22	6	2	localObject	Object
    //   34	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   5	14	22	finally
    //   5	14	34	java/io/IOException
  }
  
  private static boolean shouldStopLoading(IoUtils.CopyListener paramCopyListener, int paramInt1, int paramInt2)
  {
    return (paramCopyListener != null) && (!paramCopyListener.onBytesCopied(paramInt1, paramInt2)) && (paramInt1 * 100 / paramInt2 < 75);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.IoUtils
 * JD-Core Version:    0.7.0.1
 */