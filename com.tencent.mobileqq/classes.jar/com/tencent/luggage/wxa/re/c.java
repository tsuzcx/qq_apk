package com.tencent.luggage.wxa.re;

import android.os.Build;
import com.tencent.luggage.wxa.hd.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class c
{
  private static Boolean a;
  private static Boolean b;
  private static Boolean c;
  private static Boolean d;
  private static Boolean e;
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/luggage/wxa/re/c:a	Ljava/lang/Boolean;
    //   3: ifnonnull +121 -> 124
    //   6: aconst_null
    //   7: astore_0
    //   8: aconst_null
    //   9: astore_1
    //   10: new 20	com/tencent/luggage/wxa/rt/i
    //   13: dup
    //   14: invokestatic 26	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   17: ldc 28
    //   19: invokespecial 32	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: invokestatic 37	com/tencent/luggage/wxa/rt/k:a	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/InputStream;
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: astore_0
    //   30: new 39	java/util/Properties
    //   33: dup
    //   34: invokespecial 41	java/util/Properties:<init>	()V
    //   37: astore_3
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: astore_0
    //   42: aload_3
    //   43: aload_2
    //   44: invokevirtual 45	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: aload_3
    //   52: ldc 47
    //   54: invokevirtual 51	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   57: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   60: putstatic 18	com/tencent/luggage/wxa/re/c:a	Ljava/lang/Boolean;
    //   63: aload_2
    //   64: ifnull +60 -> 124
    //   67: aload_2
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 62	java/io/InputStream:close	()V
    //   73: goto +51 -> 124
    //   76: astore_0
    //   77: goto +37 -> 114
    //   80: astore_2
    //   81: aload_0
    //   82: astore_1
    //   83: ldc 64
    //   85: ldc 66
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_2
    //   94: aastore
    //   95: invokestatic 71	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_0
    //   99: astore_1
    //   100: iconst_0
    //   101: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   104: putstatic 18	com/tencent/luggage/wxa/re/c:a	Ljava/lang/Boolean;
    //   107: aload_0
    //   108: ifnull +16 -> 124
    //   111: goto -42 -> 69
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 62	java/io/InputStream:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: getstatic 18	com/tencent/luggage/wxa/re/c:a	Ljava/lang/Boolean;
    //   127: invokevirtual 74	java/lang/Boolean:booleanValue	()Z
    //   130: ireturn
    //   131: astore_0
    //   132: goto -8 -> 124
    //   135: astore_1
    //   136: goto -14 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	63	0	localObject1	Object
    //   76	47	0	localObject2	Object
    //   131	1	0	localException1	Exception
    //   9	110	1	localObject3	Object
    //   135	1	1	localException2	Exception
    //   25	43	2	localInputStream	java.io.InputStream
    //   80	14	2	localException3	Exception
    //   37	15	3	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   10	26	76	finally
    //   30	38	76	finally
    //   42	47	76	finally
    //   51	63	76	finally
    //   83	98	76	finally
    //   100	107	76	finally
    //   10	26	80	java/lang/Exception
    //   30	38	80	java/lang/Exception
    //   42	47	80	java/lang/Exception
    //   51	63	80	java/lang/Exception
    //   69	73	131	java/lang/Exception
    //   118	122	135	java/lang/Exception
  }
  
  public static boolean b()
  {
    String str = Build.BRAND;
    return (!af.c(str)) && (str.toLowerCase().contains("xiaomi"));
  }
  
  /* Error */
  public static boolean c()
  {
    // Byte code:
    //   0: getstatic 99	com/tencent/luggage/wxa/re/c:b	Ljava/lang/Boolean;
    //   3: ifnonnull +154 -> 157
    //   6: aconst_null
    //   7: astore_0
    //   8: aconst_null
    //   9: astore_1
    //   10: new 20	com/tencent/luggage/wxa/rt/i
    //   13: dup
    //   14: invokestatic 26	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   17: ldc 28
    //   19: invokespecial 32	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: invokestatic 37	com/tencent/luggage/wxa/rt/k:a	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/InputStream;
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: astore_0
    //   30: new 39	java/util/Properties
    //   33: dup
    //   34: invokespecial 41	java/util/Properties:<init>	()V
    //   37: astore_3
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: astore_0
    //   42: aload_3
    //   43: aload_2
    //   44: invokevirtual 45	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: ldc 64
    //   53: ldc 101
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_3
    //   62: ldc 47
    //   64: ldc 103
    //   66: invokevirtual 107	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: aastore
    //   70: invokestatic 71	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_2
    //   74: astore_1
    //   75: aload_2
    //   76: astore_0
    //   77: aload_3
    //   78: ldc 47
    //   80: ldc 103
    //   82: invokevirtual 107	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: ldc 109
    //   87: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   93: putstatic 99	com/tencent/luggage/wxa/re/c:b	Ljava/lang/Boolean;
    //   96: aload_2
    //   97: ifnull +60 -> 157
    //   100: aload_2
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 62	java/io/InputStream:close	()V
    //   106: goto +51 -> 157
    //   109: astore_0
    //   110: goto +37 -> 147
    //   113: astore_2
    //   114: aload_0
    //   115: astore_1
    //   116: ldc 64
    //   118: ldc 66
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_2
    //   127: aastore
    //   128: invokestatic 71	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: astore_1
    //   133: iconst_0
    //   134: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   137: putstatic 99	com/tencent/luggage/wxa/re/c:b	Ljava/lang/Boolean;
    //   140: aload_0
    //   141: ifnull +16 -> 157
    //   144: goto -42 -> 102
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 62	java/io/InputStream:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: getstatic 99	com/tencent/luggage/wxa/re/c:b	Ljava/lang/Boolean;
    //   160: invokevirtual 74	java/lang/Boolean:booleanValue	()Z
    //   163: ireturn
    //   164: astore_0
    //   165: goto -8 -> 157
    //   168: astore_1
    //   169: goto -14 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	96	0	localObject1	Object
    //   109	47	0	localObject2	Object
    //   164	1	0	localException1	Exception
    //   9	143	1	localObject3	Object
    //   168	1	1	localException2	Exception
    //   25	76	2	localInputStream	java.io.InputStream
    //   113	14	2	localException3	Exception
    //   37	41	3	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   10	26	109	finally
    //   30	38	109	finally
    //   42	47	109	finally
    //   51	73	109	finally
    //   77	96	109	finally
    //   116	131	109	finally
    //   133	140	109	finally
    //   10	26	113	java/lang/Exception
    //   30	38	113	java/lang/Exception
    //   42	47	113	java/lang/Exception
    //   51	73	113	java/lang/Exception
    //   77	96	113	java/lang/Exception
    //   102	106	164	java/lang/Exception
    //   151	155	168	java/lang/Exception
  }
  
  public static boolean d()
  {
    boolean bool2 = b();
    boolean bool1 = false;
    if (bool2) {
      try
      {
        int i = h.a("persist.sys.muiltdisplay_type", 0);
        if (i == 2) {
          bool1 = true;
        }
        return bool1;
      }
      catch (Exception localException)
      {
        o.a("Vendor.MIUI", localException, "get muiltdisplay_type failed", new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.re.c
 * JD-Core Version:    0.7.0.1
 */