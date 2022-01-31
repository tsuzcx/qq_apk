package com.tencent.map.sdk.engine.jni;

import com.tencent.map.lib.thread.AsyncTask;

final class JNICallback$1
  extends AsyncTask<Void, Void, Void>
{
  JNICallback$1(JNICallback paramJNICallback, String paramString, byte[] paramArrayOfByte) {}
  
  /* Error */
  private Void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 30	java/io/File
    //   5: dup
    //   6: new 32	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: getfield 17	com/tencent/map/sdk/engine/jni/JNICallback$1:a	Ljava/lang/String;
    //   17: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 39
    //   22: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 50	java/io/File:exists	()Z
    //   38: ifne +9 -> 47
    //   41: aload 5
    //   43: invokevirtual 53	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 55	java/io/FileOutputStream
    //   50: dup
    //   51: aload 5
    //   53: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_3
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: aload_0
    //   61: getfield 19	com/tencent/map/sdk/engine/jni/JNICallback$1:b	[B
    //   64: invokevirtual 62	java/io/FileOutputStream:write	([B)V
    //   67: iconst_1
    //   68: istore_1
    //   69: aload_3
    //   70: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   73: iload_1
    //   74: ifeq +20 -> 94
    //   77: aload 5
    //   79: new 30	java/io/File
    //   82: dup
    //   83: aload_0
    //   84: getfield 17	com/tencent/map/sdk/engine/jni/JNICallback$1:a	Ljava/lang/String;
    //   87: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 69	java/io/File:renameTo	(Ljava/io/File;)Z
    //   93: pop
    //   94: aconst_null
    //   95: areturn
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   101: goto -28 -> 73
    //   104: astore 4
    //   106: aconst_null
    //   107: astore_3
    //   108: aload_3
    //   109: astore_2
    //   110: aload 4
    //   112: invokevirtual 73	java/io/FileNotFoundException:printStackTrace	()V
    //   115: aload_3
    //   116: ifnull +101 -> 217
    //   119: aload_3
    //   120: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   123: iconst_0
    //   124: istore_1
    //   125: goto -52 -> 73
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   133: iconst_0
    //   134: istore_1
    //   135: goto -62 -> 73
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_3
    //   142: aload_3
    //   143: astore_2
    //   144: aload 4
    //   146: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   149: aload_3
    //   150: ifnull +67 -> 217
    //   153: aload_3
    //   154: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   157: iconst_0
    //   158: istore_1
    //   159: goto -86 -> 73
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   167: iconst_0
    //   168: istore_1
    //   169: goto -96 -> 73
    //   172: astore 4
    //   174: aload_2
    //   175: astore_3
    //   176: aload 4
    //   178: astore_2
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   187: aload_2
    //   188: athrow
    //   189: astore_3
    //   190: aload_3
    //   191: invokevirtual 72	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore 4
    //   199: aload_2
    //   200: astore_3
    //   201: aload 4
    //   203: astore_2
    //   204: goto -25 -> 179
    //   207: astore 4
    //   209: goto -67 -> 142
    //   212: astore 4
    //   214: goto -106 -> 108
    //   217: iconst_0
    //   218: istore_1
    //   219: goto -146 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	1
    //   68	151	1	i	int
    //   1	58	2	localObject1	java.lang.Object
    //   96	2	2	localIOException1	java.io.IOException
    //   109	1	2	localObject2	java.lang.Object
    //   128	2	2	localIOException2	java.io.IOException
    //   143	1	2	localObject3	java.lang.Object
    //   162	13	2	localIOException3	java.io.IOException
    //   178	26	2	localObject4	java.lang.Object
    //   56	128	3	localObject5	java.lang.Object
    //   189	2	3	localIOException4	java.io.IOException
    //   200	1	3	localObject6	java.lang.Object
    //   104	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   138	7	4	localIOException5	java.io.IOException
    //   172	5	4	localObject7	java.lang.Object
    //   197	5	4	localObject8	java.lang.Object
    //   207	1	4	localIOException6	java.io.IOException
    //   212	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   31	47	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   69	73	96	java/io/IOException
    //   33	47	104	java/io/FileNotFoundException
    //   47	57	104	java/io/FileNotFoundException
    //   119	123	128	java/io/IOException
    //   33	47	138	java/io/IOException
    //   47	57	138	java/io/IOException
    //   153	157	162	java/io/IOException
    //   33	47	172	finally
    //   47	57	172	finally
    //   183	187	189	java/io/IOException
    //   59	67	197	finally
    //   110	115	197	finally
    //   144	149	197	finally
    //   59	67	207	java/io/IOException
    //   59	67	212	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.JNICallback.1
 * JD-Core Version:    0.7.0.1
 */