package com.tencent.beacon.core;

import android.annotation.SuppressLint;
import com.tencent.beacon.core.e.d;

public class BeaconIdJNI
{
  /* Error */
  public static String a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 15	com/tencent/beacon/core/d/k:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/k;
    //   9: invokevirtual 19	com/tencent/beacon/core/d/k:f	()Z
    //   12: ifeq +9 -> 21
    //   15: getstatic 25	com/tencent/beacon/upload/UploadStrategy:DEFAULT_BEACON_ID_ENABLE	Z
    //   18: ifne +11 -> 29
    //   21: ldc 27
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: invokestatic 30	com/tencent/beacon/core/BeaconIdJNI:a	()V
    //   32: iload_1
    //   33: invokestatic 34	com/tencent/beacon/core/BeaconIdJNI:c	(I)[Ljava/lang/String;
    //   36: astore 4
    //   38: aload 4
    //   40: astore_3
    //   41: aload_3
    //   42: ifnonnull +84 -> 126
    //   45: aload_0
    //   46: invokestatic 39	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   49: ldc 41
    //   51: ldc 43
    //   53: invokevirtual 46	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 27
    //   58: astore_0
    //   59: goto -35 -> 24
    //   62: astore 4
    //   64: ldc 48
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 54	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: invokestatic 39	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   77: ldc 56
    //   79: ldc 58
    //   81: aload 4
    //   83: invokevirtual 61	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: goto -45 -> 41
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    //   95: astore 4
    //   97: invokestatic 30	com/tencent/beacon/core/BeaconIdJNI:a	()V
    //   100: iload_1
    //   101: invokestatic 34	com/tencent/beacon/core/BeaconIdJNI:c	(I)[Ljava/lang/String;
    //   104: astore 4
    //   106: aload 4
    //   108: astore_3
    //   109: goto -68 -> 41
    //   112: astore 4
    //   114: ldc 48
    //   116: iconst_0
    //   117: anewarray 4	java/lang/Object
    //   120: invokestatic 54	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: goto -82 -> 41
    //   126: aload_3
    //   127: invokestatic 66	com/tencent/beacon/core/e/j:a	([Ljava/lang/String;)V
    //   130: iconst_0
    //   131: istore_1
    //   132: iload_1
    //   133: aload_3
    //   134: arraylength
    //   135: if_icmpge +19 -> 154
    //   138: aload_3
    //   139: iload_1
    //   140: aload_3
    //   141: iload_1
    //   142: aaload
    //   143: invokestatic 69	com/tencent/beacon/core/e/j:a	(Ljava/lang/String;)Ljava/lang/String;
    //   146: aastore
    //   147: iload_1
    //   148: iconst_1
    //   149: iadd
    //   150: istore_1
    //   151: goto -19 -> 132
    //   154: new 71	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   161: astore_0
    //   162: iconst_0
    //   163: istore_1
    //   164: iload_1
    //   165: aload_3
    //   166: arraylength
    //   167: if_icmpge +118 -> 285
    //   170: iload_1
    //   171: iconst_1
    //   172: iadd
    //   173: istore_2
    //   174: iload_2
    //   175: bipush 10
    //   177: if_icmpne +40 -> 217
    //   180: aload_0
    //   181: ldc 76
    //   183: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iconst_1
    //   187: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: ldc 85
    //   192: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_0
    //   197: ldc 87
    //   199: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_3
    //   203: iload_1
    //   204: aaload
    //   205: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 85
    //   210: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: goto +134 -> 348
    //   217: iload_2
    //   218: bipush 10
    //   220: if_icmple +35 -> 255
    //   223: aload_0
    //   224: ldc 89
    //   226: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload_1
    //   230: iconst_2
    //   231: iadd
    //   232: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc 91
    //   237: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_3
    //   241: iload_1
    //   242: aaload
    //   243: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc 85
    //   248: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: goto +96 -> 348
    //   255: aload_0
    //   256: ldc 89
    //   258: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload_2
    //   262: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: ldc 91
    //   267: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_3
    //   271: iload_1
    //   272: aaload
    //   273: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc 85
    //   278: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: goto +66 -> 348
    //   285: aload_0
    //   286: iconst_0
    //   287: aload_0
    //   288: invokevirtual 95	java/lang/StringBuilder:length	()I
    //   291: iconst_1
    //   292: isub
    //   293: invokevirtual 99	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   296: astore_3
    //   297: aload_3
    //   298: astore_0
    //   299: aload_3
    //   300: ldc 101
    //   302: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   305: ifne +27 -> 332
    //   308: new 71	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   315: aload_3
    //   316: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc 109
    //   321: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iconst_1
    //   325: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: astore_0
    //   332: ldc 115
    //   334: iconst_1
    //   335: anewarray 4	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: aload_0
    //   341: aastore
    //   342: invokestatic 117	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: goto -321 -> 24
    //   348: iload_2
    //   349: istore_1
    //   350: goto -186 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramContext	android.content.Context
    //   0	353	1	paramInt	int
    //   173	176	2	i	int
    //   1	315	3	localObject	Object
    //   36	3	4	arrayOfString1	String[]
    //   62	20	4	localThrowable1	Throwable
    //   95	1	4	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   104	3	4	arrayOfString2	String[]
    //   112	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   29	38	62	java/lang/Throwable
    //   5	21	89	finally
    //   29	38	89	finally
    //   45	56	89	finally
    //   64	86	89	finally
    //   97	106	89	finally
    //   114	123	89	finally
    //   126	130	89	finally
    //   132	147	89	finally
    //   154	162	89	finally
    //   164	170	89	finally
    //   180	214	89	finally
    //   223	252	89	finally
    //   255	282	89	finally
    //   285	297	89	finally
    //   299	332	89	finally
    //   332	345	89	finally
    //   29	38	95	java/lang/UnsatisfiedLinkError
    //   97	106	112	java/lang/Throwable
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static void a()
  {
    try
    {
      System.loadLibrary("Qimei");
      return;
    }
    catch (Throwable localThrowable)
    {
      d.b("[beaconId] no libQimei.so!", new Object[0]);
      System.loadLibrary("Beacon");
    }
  }
  
  public static native String[] c(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.BeaconIdJNI
 * JD-Core Version:    0.7.0.1
 */