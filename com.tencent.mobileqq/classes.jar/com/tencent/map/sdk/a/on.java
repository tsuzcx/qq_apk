package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

public final class on
{
  public static final long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream == null) {
      return -1L;
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      int i;
      for (long l = 0L;; l += i)
      {
        i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return l;
    }
    catch (IOException paramInputStream) {}
    return -1L;
  }
  
  public static void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public static final void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory())) {
        return true;
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  /* Error */
  public static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 75	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 77	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore 4
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: aload 4
    //   28: iconst_0
    //   29: sipush 4096
    //   32: invokevirtual 80	java/io/InputStream:read	([BII)I
    //   35: istore_1
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpeq +33 -> 71
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 81	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -28 -> 23
    //   54: astore_2
    //   55: aload_3
    //   56: astore_0
    //   57: aload_2
    //   58: astore_3
    //   59: aload_0
    //   60: astore_2
    //   61: aload_3
    //   62: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   65: aload_0
    //   66: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_3
    //   72: astore_2
    //   73: aload_3
    //   74: invokevirtual 89	java/io/ByteArrayOutputStream:flush	()V
    //   77: aload_3
    //   78: astore_2
    //   79: aload_3
    //   80: invokevirtual 93	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: astore_0
    //   84: aload_3
    //   85: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   88: aload_0
    //   89: areturn
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: invokestatic 86	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: goto -7 -> 93
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_0
    //   106: goto -47 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramInputStream	InputStream
    //   35	13	1	i	int
    //   15	28	2	localObject1	Object
    //   54	4	2	localThrowable1	java.lang.Throwable
    //   60	34	2	localObject2	Object
    //   13	72	3	localObject3	Object
    //   103	1	3	localThrowable2	java.lang.Throwable
    //   21	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	23	54	java/lang/Throwable
    //   25	36	54	java/lang/Throwable
    //   43	51	54	java/lang/Throwable
    //   73	77	54	java/lang/Throwable
    //   79	84	54	java/lang/Throwable
    //   6	14	90	finally
    //   16	23	99	finally
    //   25	36	99	finally
    //   43	51	99	finally
    //   61	65	99	finally
    //   73	77	99	finally
    //   79	84	99	finally
    //   6	14	103	java/lang/Throwable
  }
  
  public static final InputStream b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new File(paramString);
        if ((paramString.exists()) && (paramString.isFile()) && (paramString.canRead()))
        {
          paramString = new FileInputStream(paramString);
          return paramString;
        }
      }
      catch (IOException paramString) {}
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Stack localStack = new Stack();
    localStack.push(paramString);
    while (!localStack.isEmpty())
    {
      File localFile = new File((String)localStack.peek());
      if (localFile.exists())
      {
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          if ((paramString == null) || (paramString.length == 0))
          {
            localFile.delete();
            localStack.pop();
          }
          else
          {
            int j = paramString.length;
            int i = 0;
            label96:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label131;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label96;
              break;
              label131:
              localFile.delete();
            }
          }
        }
        else
        {
          localFile.delete();
          localStack.pop();
        }
      }
      else {
        localStack.pop();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.on
 * JD-Core Version:    0.7.0.1
 */