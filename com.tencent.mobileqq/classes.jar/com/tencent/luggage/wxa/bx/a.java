package com.tencent.luggage.wxa.bx;

import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.wxa.jw.b;
import com.tencent.luggage.wxa.qz.o;
import java.io.InputStream;

public class a
{
  public static int a(InputStream paramInputStream)
  {
    try
    {
      int i = b.a(paramInputStream);
      return i;
    }
    catch (Exception paramInputStream)
    {
      o.b("Luggage.ImageInfoUtils", "getExifOrientation with stream, e = %s", new Object[] { paramInputStream });
    }
    return 0;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 32	com/tencent/luggage/wxa/rt/k:h	(Ljava/lang/String;)Z
    //   4: ifne +12 -> 16
    //   7: ldc 14
    //   9: ldc 34
    //   11: invokestatic 37	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokestatic 40	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore 4
    //   22: aconst_null
    //   23: astore_2
    //   24: aload 4
    //   26: invokestatic 12	com/tencent/luggage/wxa/jw/b:a	(Ljava/io/InputStream;)I
    //   29: istore_1
    //   30: aload 4
    //   32: ifnull +8 -> 40
    //   35: aload 4
    //   37: invokevirtual 46	java/io/InputStream:close	()V
    //   40: iload_1
    //   41: ireturn
    //   42: astore_3
    //   43: goto +8 -> 51
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: athrow
    //   51: aload 4
    //   53: ifnull +20 -> 73
    //   56: aload_2
    //   57: ifnull +11 -> 68
    //   60: aload 4
    //   62: invokevirtual 46	java/io/InputStream:close	()V
    //   65: goto +8 -> 73
    //   68: aload 4
    //   70: invokevirtual 46	java/io/InputStream:close	()V
    //   73: aload_3
    //   74: athrow
    //   75: astore_2
    //   76: ldc 14
    //   78: ldc 48
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: aload_2
    //   91: aastore
    //   92: invokestatic 22	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_2
    //   98: goto -25 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   29	12	1	i	int
    //   23	34	2	localObject1	Object
    //   75	16	2	localException	Exception
    //   97	1	2	localThrowable1	java.lang.Throwable
    //   42	1	3	localObject2	Object
    //   46	28	3	localThrowable2	java.lang.Throwable
    //   20	49	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	42	finally
    //   49	51	42	finally
    //   24	30	46	java/lang/Throwable
    //   16	22	75	java/lang/Exception
    //   35	40	75	java/lang/Exception
    //   60	65	75	java/lang/Exception
    //   68	73	75	java/lang/Exception
    //   73	75	75	java/lang/Exception
    //   60	65	97	java/lang/Throwable
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "up";
    case 8: 
      return "left";
    case 7: 
      return "right-mirrored";
    case 6: 
      return "right";
    case 5: 
      return "left-mirrored";
    case 4: 
      return "down-mirrored";
    case 3: 
      return "down";
    case 2: 
      return "up-mirrored";
    }
    return "up";
  }
  
  public static boolean a(BitmapFactory.Options paramOptions)
  {
    if (paramOptions == null) {
      return false;
    }
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null) {
      return false;
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0) {
      return true;
    }
    return paramOptions.indexOf("jpeg") >= 0;
  }
  
  public static String b(BitmapFactory.Options paramOptions)
  {
    if (paramOptions == null) {
      return "unknown";
    }
    paramOptions = paramOptions.outMimeType;
    if (paramOptions == null) {
      return "unknown";
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0) {
      return "jpeg";
    }
    if (paramOptions.indexOf("jpeg") >= 0) {
      return "jpeg";
    }
    if (paramOptions.indexOf("png") >= 0) {
      return "png";
    }
    if (paramOptions.indexOf("gif") >= 0) {
      return "gif";
    }
    return "unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bx.a
 * JD-Core Version:    0.7.0.1
 */