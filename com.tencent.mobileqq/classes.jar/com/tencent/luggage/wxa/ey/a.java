package com.tencent.luggage.wxa.ey;

import com.tencent.luggage.wxa.hd.b;
import com.tencent.luggage.wxa.qz.af;

public class a
{
  static int a;
  static String b;
  
  public static int a()
  {
    int j;
    if (b.c()) {
      j = 7;
    } else if (b.d()) {
      j = 3;
    } else {
      j = 1;
    }
    int i = b.e();
    int k;
    if (i > 16)
    {
      k = 15;
    }
    else
    {
      k = i;
      if (i < 1) {
        k = 1;
      }
    }
    int m = af.a(b(), 0) / 1000;
    if (k >= 8)
    {
      i = m * 4;
    }
    else if (k >= 4)
    {
      i = m * 2;
    }
    else
    {
      i = m;
      if (k > 1) {
        i = m * 3 >> 1;
      }
    }
    i /= 100;
    m = 200;
    if (i > 200) {
      i = m;
    } else if (i < 5) {
      i = 5;
    }
    m = i;
    if (i <= 5)
    {
      m = i;
      if (k >= 4) {
        m = 15;
      }
    }
    a = ((k << 4) + j << 8) + m;
    return a;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: new 38	java/io/BufferedReader
    //   3: dup
    //   4: new 40	com/tencent/luggage/wxa/rt/l
    //   7: dup
    //   8: ldc 42
    //   10: invokespecial 46	com/tencent/luggage/wxa/rt/l:<init>	(Ljava/lang/String;)V
    //   13: invokespecial 49	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: aload_1
    //   20: invokevirtual 52	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull +16 -> 41
    //   28: aload_1
    //   29: astore_0
    //   30: aload_2
    //   31: invokevirtual 57	java/lang/String:trim	()Ljava/lang/String;
    //   34: astore_2
    //   35: aload_1
    //   36: invokestatic 60	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   39: aload_2
    //   40: areturn
    //   41: aload_1
    //   42: astore_0
    //   43: new 62	java/lang/NullPointerException
    //   46: dup
    //   47: ldc 64
    //   49: invokespecial 65	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: astore_2
    //   54: goto +12 -> 66
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: goto +32 -> 92
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: astore_0
    //   68: ldc 67
    //   70: aload_2
    //   71: ldc 69
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokestatic 74	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_1
    //   81: invokestatic 60	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   84: ldc 76
    //   86: areturn
    //   87: astore_2
    //   88: aload_0
    //   89: astore_1
    //   90: aload_2
    //   91: astore_0
    //   92: aload_1
    //   93: invokestatic 60	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	25	0	localObject1	Object
    //   57	1	0	localObject2	Object
    //   67	30	0	localObject3	Object
    //   16	77	1	localObject4	Object
    //   23	17	2	str	String
    //   53	1	2	localThrowable1	java.lang.Throwable
    //   63	8	2	localThrowable2	java.lang.Throwable
    //   87	4	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   19	24	53	java/lang/Throwable
    //   30	35	53	java/lang/Throwable
    //   43	53	53	java/lang/Throwable
    //   0	17	57	finally
    //   0	17	63	java/lang/Throwable
    //   19	24	87	finally
    //   30	35	87	finally
    //   43	53	87	finally
    //   68	80	87	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ey.a
 * JD-Core Version:    0.7.0.1
 */