package com.tencent.biz.pubaccount.readinjoy.struct;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toByteArray", "", "Ljava/io/Serializable;", "toSerializable", "T", "([B)Ljava/lang/Object;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class RIJSerializableKtxKt
{
  /* Error */
  @org.jetbrains.annotations.Nullable
  public static final <T> T a(@org.jetbrains.annotations.NotNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc 32
    //   6: invokestatic 38	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: new 40	java/io/ObjectInputStream
    //   12: dup
    //   13: new 42	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 46	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: checkcast 48	java/io/InputStream
    //   24: invokespecial 51	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: checkcast 53	java/io/Closeable
    //   30: astore 5
    //   32: aconst_null
    //   33: checkcast 30	java/lang/Throwable
    //   36: astore_3
    //   37: aload 5
    //   39: checkcast 40	java/io/ObjectInputStream
    //   42: invokevirtual 57	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: instanceof 59
    //   52: ifne +5 -> 57
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: checkcast 59	java/util/ArrayList
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull +28 -> 91
    //   66: aload_0
    //   67: checkcast 61	java/util/List
    //   70: invokestatic 67	kotlin/collections/CollectionsKt:firstOrNull	(Ljava/util/List;)Ljava/lang/Object;
    //   73: astore_0
    //   74: aload_3
    //   75: astore_1
    //   76: aload_0
    //   77: astore_2
    //   78: getstatic 73	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   81: astore 4
    //   83: aload 5
    //   85: aload_3
    //   86: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: areturn
    //   91: aconst_null
    //   92: astore_0
    //   93: goto -19 -> 74
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_3
    //   100: astore_1
    //   101: aload_0
    //   102: astore_2
    //   103: aload_3
    //   104: athrow
    //   105: astore_3
    //   106: aload_2
    //   107: astore_0
    //   108: aload_3
    //   109: astore_2
    //   110: aload 5
    //   112: aload_1
    //   113: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: aload_2
    //   117: athrow
    //   118: astore_1
    //   119: ldc 81
    //   121: iconst_1
    //   122: new 83	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   129: ldc 88
    //   131: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_0
    //   145: areturn
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -30 -> 119
    //   152: astore_1
    //   153: goto -34 -> 119
    //   156: astore_2
    //   157: aload_3
    //   158: astore_1
    //   159: aload 4
    //   161: astore_0
    //   162: goto -52 -> 110
    //   165: astore_3
    //   166: goto -67 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramArrayOfByte	byte[]
    //   45	68	1	localObject1	Object
    //   118	17	1	localIOException1	java.io.IOException
    //   146	1	1	localIOException2	java.io.IOException
    //   152	1	1	localIOException3	java.io.IOException
    //   158	1	1	localObject2	Object
    //   77	40	2	localObject3	Object
    //   156	1	2	localObject4	Object
    //   36	50	3	localThrowable1	java.lang.Throwable
    //   96	8	3	localThrowable2	java.lang.Throwable
    //   105	53	3	localObject5	Object
    //   165	1	3	localThrowable3	java.lang.Throwable
    //   1	159	4	localUnit	kotlin.Unit
    //   30	81	5	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   37	46	96	java/lang/Throwable
    //   48	55	96	java/lang/Throwable
    //   57	62	96	java/lang/Throwable
    //   66	74	96	java/lang/Throwable
    //   78	83	105	finally
    //   103	105	105	finally
    //   110	118	118	java/io/IOException
    //   9	37	146	java/io/IOException
    //   83	89	152	java/io/IOException
    //   37	46	156	finally
    //   48	55	156	finally
    //   57	62	156	finally
    //   66	74	156	finally
    //   78	83	165	java/lang/Throwable
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public static final byte[] a(@org.jetbrains.annotations.NotNull java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 113
    //   3: invokestatic 38	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 115	[B
    //   10: astore_3
    //   11: aload_3
    //   12: astore_1
    //   13: new 117	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 118	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 6
    //   22: aload_3
    //   23: astore_1
    //   24: new 120	java/io/ObjectOutputStream
    //   27: dup
    //   28: aload 6
    //   30: checkcast 122	java/io/OutputStream
    //   33: invokespecial 125	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: checkcast 53	java/io/Closeable
    //   39: astore 5
    //   41: aload_3
    //   42: astore_1
    //   43: aconst_null
    //   44: checkcast 30	java/lang/Throwable
    //   47: astore 4
    //   49: aload_3
    //   50: astore_1
    //   51: aload_3
    //   52: astore_2
    //   53: aload 5
    //   55: checkcast 120	java/io/ObjectOutputStream
    //   58: astore 7
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: astore_2
    //   64: aload 7
    //   66: iconst_1
    //   67: anewarray 127	java/io/Serializable
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: aastore
    //   74: invokestatic 131	kotlin/collections/CollectionsKt:arrayListOf	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   77: invokevirtual 135	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   80: aload_3
    //   81: astore_1
    //   82: aload_3
    //   83: astore_2
    //   84: aload 7
    //   86: invokevirtual 138	java/io/ObjectOutputStream:flush	()V
    //   89: aload_3
    //   90: astore_1
    //   91: aload_3
    //   92: astore_2
    //   93: aload 6
    //   95: invokevirtual 141	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   98: astore_0
    //   99: aload_0
    //   100: astore_1
    //   101: aload_0
    //   102: astore_2
    //   103: getstatic 73	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   106: astore_3
    //   107: aload_0
    //   108: astore_1
    //   109: aload 5
    //   111: aload 4
    //   113: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: aload_0
    //   117: areturn
    //   118: astore_2
    //   119: aload_1
    //   120: astore_0
    //   121: aload_2
    //   122: athrow
    //   123: astore_1
    //   124: aload 5
    //   126: aload_2
    //   127: invokestatic 79	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: ldc 81
    //   135: iconst_1
    //   136: new 83	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   143: ldc 143
    //   145: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: areturn
    //   160: astore_2
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: astore_1
    //   165: goto -32 -> 133
    //   168: astore_1
    //   169: aload_2
    //   170: astore_0
    //   171: aload 4
    //   173: astore_2
    //   174: goto -50 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramSerializable	java.io.Serializable
    //   12	108	1	localObject1	Object
    //   123	8	1	localObject2	Object
    //   132	30	1	localIOException1	java.io.IOException
    //   164	1	1	localObject3	Object
    //   168	1	1	localObject4	Object
    //   52	51	2	localObject5	Object
    //   118	9	2	localThrowable1	java.lang.Throwable
    //   160	10	2	localIOException2	java.io.IOException
    //   173	1	2	localThrowable2	java.lang.Throwable
    //   10	97	3	localObject6	Object
    //   47	125	4	localThrowable3	java.lang.Throwable
    //   39	86	5	localCloseable	java.io.Closeable
    //   20	74	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   58	27	7	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   53	60	118	java/lang/Throwable
    //   64	80	118	java/lang/Throwable
    //   84	89	118	java/lang/Throwable
    //   93	99	118	java/lang/Throwable
    //   103	107	118	java/lang/Throwable
    //   121	123	123	finally
    //   124	132	132	java/io/IOException
    //   13	22	160	java/io/IOException
    //   24	41	160	java/io/IOException
    //   43	49	160	java/io/IOException
    //   109	116	160	java/io/IOException
    //   53	60	168	finally
    //   64	80	168	finally
    //   84	89	168	finally
    //   93	99	168	finally
    //   103	107	168	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.RIJSerializableKtxKt
 * JD-Core Version:    0.7.0.1
 */