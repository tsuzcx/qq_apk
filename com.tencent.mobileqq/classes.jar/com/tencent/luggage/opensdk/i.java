package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/OpenSDKTicketTransferProtocol;", "Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol;", "()V", "TAG", "", "checkIsWechatSupportFeatures", "", "feature", "checkWechatFacialRecognitionVerifyCapability", "Lkotlin/Triple;", "", "invoke", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "request", "Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;", "newCall", "support", "Constants", "Helper", "RealCall", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class i
  implements a
{
  public static final i a = new i();
  
  private final d<String> b(a.c paramc)
  {
    paramc = h.a().b((b)new i.c(paramc));
    Intrinsics.checkExpressionValueIsNotNull(paramc, "pipeline().`$logic`<Stri…n@`$logic` null\n        }");
    return paramc;
  }
  
  @NotNull
  public d<String> a(@NotNull a.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "request");
    return b(paramc);
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: getstatic 92	com/tencent/luggage/opensdk/i$d:a	Lcom/tencent/luggage/opensdk/i$d;
    //   3: astore 5
    //   5: invokestatic 97	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   8: astore_3
    //   9: aload_3
    //   10: ldc 99
    //   12: invokestatic 73	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_3
    //   16: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: ldc 107
    //   21: invokestatic 113	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 119	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: checkcast 121	java/io/Closeable
    //   34: astore 6
    //   36: aconst_null
    //   37: checkcast 87	java/lang/Throwable
    //   40: astore 4
    //   42: aload 4
    //   44: astore_3
    //   45: aload 6
    //   47: checkcast 123	android/database/Cursor
    //   50: astore 7
    //   52: aload 7
    //   54: ifnull +49 -> 103
    //   57: aload 4
    //   59: astore_3
    //   60: aload 7
    //   62: invokeinterface 126 1 0
    //   67: ifeq +36 -> 103
    //   70: aload 4
    //   72: astore_3
    //   73: aload 7
    //   75: aload 7
    //   77: ldc 127
    //   79: invokeinterface 131 2 0
    //   84: invokeinterface 135 2 0
    //   89: istore_1
    //   90: iload_1
    //   91: ifle +12 -> 103
    //   94: aload 6
    //   96: aload 4
    //   98: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   101: iconst_1
    //   102: ireturn
    //   103: aload 4
    //   105: astore_3
    //   106: getstatic 147	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   109: astore 7
    //   111: aload 6
    //   113: aload 4
    //   115: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   118: goto +60 -> 178
    //   121: astore 4
    //   123: goto +11 -> 134
    //   126: astore 4
    //   128: aload 4
    //   130: astore_3
    //   131: aload 4
    //   133: athrow
    //   134: aload 6
    //   136: aload_3
    //   137: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   140: aload 4
    //   142: athrow
    //   143: astore_3
    //   144: new 149	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   151: astore 4
    //   153: aload 4
    //   155: ldc 152
    //   157: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 4
    //   163: aload_3
    //   164: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 161
    //   170: aload 4
    //   172: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 170	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: invokestatic 97	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   181: astore_3
    //   182: aload_3
    //   183: ldc 99
    //   185: invokestatic 73	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   188: aload 5
    //   190: aload_3
    //   191: invokevirtual 174	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   194: ldc 176
    //   196: sipush 128
    //   199: invokevirtual 182	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   202: getfield 188	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   205: ldc 190
    //   207: invokevirtual 196	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   210: invokevirtual 199	com/tencent/luggage/opensdk/i$d:a	(Ljava/lang/Object;)Z
    //   213: istore_2
    //   214: iload_2
    //   215: ireturn
    //   216: astore_3
    //   217: new 149	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   224: astore 4
    //   226: aload 4
    //   228: ldc 201
    //   230: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: aload_3
    //   237: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: ldc 161
    //   243: aload 4
    //   245: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 170	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: iconst_0
    //   252: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	i
    //   89	2	1	i	int
    //   213	2	2	bool	boolean
    //   8	129	3	localObject1	Object
    //   143	21	3	localThrowable1	java.lang.Throwable
    //   181	10	3	localContext	android.content.Context
    //   216	21	3	localThrowable2	java.lang.Throwable
    //   40	74	4	localThrowable3	java.lang.Throwable
    //   121	1	4	localObject2	Object
    //   126	15	4	localThrowable4	java.lang.Throwable
    //   151	93	4	localStringBuilder	java.lang.StringBuilder
    //   3	186	5	locald	i.d
    //   34	101	6	localCloseable	java.io.Closeable
    //   50	60	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   45	52	121	finally
    //   60	70	121	finally
    //   73	90	121	finally
    //   106	111	121	finally
    //   131	134	121	finally
    //   45	52	126	java/lang/Throwable
    //   60	70	126	java/lang/Throwable
    //   73	90	126	java/lang/Throwable
    //   106	111	126	java/lang/Throwable
    //   5	42	143	java/lang/Throwable
    //   94	101	143	java/lang/Throwable
    //   111	118	143	java/lang/Throwable
    //   134	143	143	java/lang/Throwable
    //   178	214	216	java/lang/Throwable
  }
  
  /* Error */
  public final boolean a(@NotNull String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 203
    //   3: invokestatic 80	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: invokestatic 97	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   9: astore_3
    //   10: aload_3
    //   11: ldc 99
    //   13: invokestatic 73	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_3
    //   17: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: ldc 205
    //   22: invokestatic 113	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: aconst_null
    //   26: aconst_null
    //   27: iconst_1
    //   28: anewarray 207	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: aconst_null
    //   36: invokevirtual 119	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: checkcast 121	java/io/Closeable
    //   42: astore 5
    //   44: aconst_null
    //   45: checkcast 87	java/lang/Throwable
    //   48: astore 4
    //   50: aload 4
    //   52: astore_3
    //   53: aload 5
    //   55: checkcast 123	android/database/Cursor
    //   58: astore 6
    //   60: aload 6
    //   62: ifnull +49 -> 111
    //   65: aload 4
    //   67: astore_3
    //   68: aload 6
    //   70: invokeinterface 126 1 0
    //   75: ifeq +36 -> 111
    //   78: aload 4
    //   80: astore_3
    //   81: aload 6
    //   83: aload 6
    //   85: ldc 127
    //   87: invokeinterface 131 2 0
    //   92: invokeinterface 135 2 0
    //   97: istore_2
    //   98: iload_2
    //   99: ifle +12 -> 111
    //   102: aload 5
    //   104: aload 4
    //   106: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   109: iconst_1
    //   110: ireturn
    //   111: aload 4
    //   113: astore_3
    //   114: getstatic 147	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   117: astore 6
    //   119: aload 5
    //   121: aload 4
    //   123: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore 4
    //   130: goto +11 -> 141
    //   133: astore 4
    //   135: aload 4
    //   137: astore_3
    //   138: aload 4
    //   140: athrow
    //   141: aload 5
    //   143: aload_3
    //   144: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   147: aload 4
    //   149: athrow
    //   150: astore_3
    //   151: new 149	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   158: astore 4
    //   160: aload 4
    //   162: ldc 209
    //   164: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 4
    //   170: aload_1
    //   171: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 4
    //   177: ldc 211
    //   179: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 4
    //   185: aload_3
    //   186: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: ldc 161
    //   192: aload 4
    //   194: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 170	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iconst_0
    //   201: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	i
    //   0	202	1	paramString	String
    //   97	2	2	i	int
    //   9	135	3	localObject1	Object
    //   150	36	3	localThrowable1	java.lang.Throwable
    //   48	74	4	localThrowable2	java.lang.Throwable
    //   128	1	4	localObject2	Object
    //   133	15	4	localThrowable3	java.lang.Throwable
    //   158	35	4	localStringBuilder	java.lang.StringBuilder
    //   42	100	5	localCloseable	java.io.Closeable
    //   58	60	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   53	60	128	finally
    //   68	78	128	finally
    //   81	98	128	finally
    //   114	119	128	finally
    //   138	141	128	finally
    //   53	60	133	java/lang/Throwable
    //   68	78	133	java/lang/Throwable
    //   81	98	133	java/lang/Throwable
    //   114	119	133	java/lang/Throwable
    //   6	50	150	java/lang/Throwable
    //   102	109	150	java/lang/Throwable
    //   119	126	150	java/lang/Throwable
    //   141	150	150	java/lang/Throwable
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public final kotlin.Triple<java.lang.Integer, String, java.lang.Integer> b()
  {
    // Byte code:
    //   0: invokestatic 97	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 99
    //   7: invokestatic 73	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: ldc 215
    //   16: invokestatic 113	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual 119	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: checkcast 121	java/io/Closeable
    //   29: astore_3
    //   30: aconst_null
    //   31: checkcast 87	java/lang/Throwable
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_3
    //   38: checkcast 123	android/database/Cursor
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +88 -> 133
    //   48: aload_2
    //   49: astore_1
    //   50: aload 4
    //   52: invokeinterface 126 1 0
    //   57: ifeq +76 -> 133
    //   60: aload_2
    //   61: astore_1
    //   62: new 217	kotlin/Triple
    //   65: dup
    //   66: aload 4
    //   68: aload 4
    //   70: ldc 219
    //   72: invokeinterface 131 2 0
    //   77: invokeinterface 135 2 0
    //   82: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aload 4
    //   87: aload 4
    //   89: ldc 227
    //   91: invokeinterface 131 2 0
    //   96: invokeinterface 231 2 0
    //   101: aload 4
    //   103: aload 4
    //   105: ldc 233
    //   107: invokeinterface 131 2 0
    //   112: invokeinterface 135 2 0
    //   117: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: invokespecial 236	kotlin/Triple:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   123: astore 4
    //   125: aload_3
    //   126: aload_2
    //   127: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   130: aload 4
    //   132: areturn
    //   133: aload_2
    //   134: astore_1
    //   135: getstatic 147	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   138: astore 4
    //   140: aload_3
    //   141: aload_2
    //   142: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_2
    //   148: goto +8 -> 156
    //   151: astore_2
    //   152: aload_2
    //   153: astore_1
    //   154: aload_2
    //   155: athrow
    //   156: aload_3
    //   157: aload_1
    //   158: invokestatic 141	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: new 149	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   171: astore_2
    //   172: aload_2
    //   173: ldc 238
    //   175: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: aload_1
    //   181: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 161
    //   187: aload_2
    //   188: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 170	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aconst_null
    //   195: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	i
    //   3	155	1	localObject1	Object
    //   163	18	1	localThrowable1	java.lang.Throwable
    //   34	108	2	localThrowable2	java.lang.Throwable
    //   147	1	2	localObject2	Object
    //   151	11	2	localThrowable3	java.lang.Throwable
    //   171	17	2	localStringBuilder	java.lang.StringBuilder
    //   29	128	3	localCloseable	java.io.Closeable
    //   41	98	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	147	finally
    //   50	60	147	finally
    //   62	125	147	finally
    //   135	140	147	finally
    //   154	156	147	finally
    //   37	43	151	java/lang/Throwable
    //   50	60	151	java/lang/Throwable
    //   62	125	151	java/lang/Throwable
    //   135	140	151	java/lang/Throwable
    //   0	35	163	java/lang/Throwable
    //   125	130	163	java/lang/Throwable
    //   140	145	163	java/lang/Throwable
    //   156	163	163	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i
 * JD-Core Version:    0.7.0.1
 */