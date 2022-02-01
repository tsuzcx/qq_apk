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
    //   1: astore_2
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
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_2
    //   40: ifnonnull +78 -> 118
    //   43: aload_0
    //   44: invokestatic 39	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   47: ldc 41
    //   49: ldc 43
    //   51: invokevirtual 46	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc 27
    //   56: astore_0
    //   57: goto -33 -> 24
    //   60: astore_3
    //   61: ldc 48
    //   63: iconst_0
    //   64: anewarray 4	java/lang/Object
    //   67: invokestatic 54	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: invokestatic 39	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   74: ldc 56
    //   76: ldc 58
    //   78: aload_3
    //   79: invokevirtual 61	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: goto -43 -> 39
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    //   91: astore_3
    //   92: invokestatic 30	com/tencent/beacon/core/BeaconIdJNI:a	()V
    //   95: iload_1
    //   96: invokestatic 34	com/tencent/beacon/core/BeaconIdJNI:c	(I)[Ljava/lang/String;
    //   99: astore_3
    //   100: aload_3
    //   101: astore_2
    //   102: goto -63 -> 39
    //   105: astore_3
    //   106: ldc 48
    //   108: iconst_0
    //   109: anewarray 4	java/lang/Object
    //   112: invokestatic 54	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: goto -76 -> 39
    //   118: aload_2
    //   119: invokestatic 66	com/tencent/beacon/core/e/j:a	([Ljava/lang/String;)V
    //   122: iconst_0
    //   123: istore_1
    //   124: iload_1
    //   125: aload_2
    //   126: arraylength
    //   127: if_icmpge +19 -> 146
    //   130: aload_2
    //   131: iload_1
    //   132: aload_2
    //   133: iload_1
    //   134: aaload
    //   135: invokestatic 69	com/tencent/beacon/core/e/j:a	(Ljava/lang/String;)Ljava/lang/String;
    //   138: aastore
    //   139: iload_1
    //   140: iconst_1
    //   141: iadd
    //   142: istore_1
    //   143: goto -19 -> 124
    //   146: new 71	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   153: ldc 76
    //   155: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_2
    //   159: iconst_0
    //   160: aaload
    //   161: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 82
    //   166: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: iconst_1
    //   171: aaload
    //   172: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 84
    //   177: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_2
    //   181: iconst_2
    //   182: aaload
    //   183: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc 86
    //   188: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: iconst_3
    //   193: aaload
    //   194: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 88
    //   199: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_2
    //   203: iconst_4
    //   204: aaload
    //   205: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 90
    //   210: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: iconst_5
    //   215: aaload
    //   216: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 92
    //   221: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_2
    //   225: bipush 6
    //   227: aaload
    //   228: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc 94
    //   233: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_2
    //   237: bipush 7
    //   239: aaload
    //   240: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 96
    //   245: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_2
    //   249: bipush 8
    //   251: aaload
    //   252: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 98
    //   257: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iconst_1
    //   261: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: astore_0
    //   265: ldc 103
    //   267: iconst_1
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload_0
    //   274: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aastore
    //   278: invokestatic 109	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: aload_0
    //   282: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: astore_0
    //   286: goto -262 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramContext	android.content.Context
    //   0	289	1	paramInt	int
    //   1	248	2	localObject	Object
    //   36	2	3	arrayOfString1	String[]
    //   60	19	3	localThrowable1	Throwable
    //   91	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   99	2	3	arrayOfString2	String[]
    //   105	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   29	37	60	java/lang/Throwable
    //   5	21	85	finally
    //   29	37	85	finally
    //   43	54	85	finally
    //   61	82	85	finally
    //   92	100	85	finally
    //   106	115	85	finally
    //   118	122	85	finally
    //   124	139	85	finally
    //   146	286	85	finally
    //   29	37	91	java/lang/UnsatisfiedLinkError
    //   92	100	105	java/lang/Throwable
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