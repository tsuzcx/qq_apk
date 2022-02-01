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
    //   38: if_icmpeq +16 -> 54
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 81	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -28 -> 23
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: invokevirtual 84	java/io/ByteArrayOutputStream:flush	()V
    //   60: aload_3
    //   61: astore_2
    //   62: aload_3
    //   63: invokevirtual 88	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore_0
    //   67: aload_3
    //   68: invokestatic 90	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   71: aload_0
    //   72: areturn
    //   73: astore_2
    //   74: aload_3
    //   75: astore_0
    //   76: aload_2
    //   77: astore_3
    //   78: goto +12 -> 90
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_2
    //   84: goto +19 -> 103
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_2
    //   92: aload_3
    //   93: invokevirtual 93	java/lang/Throwable:printStackTrace	()V
    //   96: aload_0
    //   97: invokestatic 90	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aload_2
    //   104: invokestatic 90	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   107: goto +5 -> 112
    //   110: aload_0
    //   111: athrow
    //   112: goto -2 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramInputStream	InputStream
    //   35	13	1	i	int
    //   15	47	2	localObject1	Object
    //   73	4	2	localThrowable1	java.lang.Throwable
    //   83	21	2	localInputStream	InputStream
    //   13	65	3	localObject2	Object
    //   87	6	3	localThrowable2	java.lang.Throwable
    //   21	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	23	73	java/lang/Throwable
    //   25	36	73	java/lang/Throwable
    //   43	51	73	java/lang/Throwable
    //   56	60	73	java/lang/Throwable
    //   62	67	73	java/lang/Throwable
    //   6	14	81	finally
    //   6	14	87	java/lang/Throwable
    //   16	23	102	finally
    //   25	36	102	finally
    //   43	51	102	finally
    //   56	60	102	finally
    //   62	67	102	finally
    //   92	96	102	finally
  }
  
  public static final InputStream b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile()) && (paramString.canRead()))
      {
        paramString = new FileInputStream(paramString);
        return paramString;
      }
      return null;
    }
    catch (IOException paramString) {}
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
          if ((paramString != null) && (paramString.length != 0))
          {
            int j = paramString.length;
            int i = 0;
            while (i < j)
            {
              localFile = paramString[i];
              if (localFile.isDirectory()) {
                localStack.push(localFile.getAbsolutePath());
              } else {
                localFile.delete();
              }
              i += 1;
            }
          }
          else
          {
            localFile.delete();
            localStack.pop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.on
 * JD-Core Version:    0.7.0.1
 */