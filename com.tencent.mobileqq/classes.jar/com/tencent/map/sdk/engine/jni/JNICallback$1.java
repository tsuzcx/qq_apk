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
    //   0: new 30	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 17	com/tencent/map/sdk/engine/jni/JNICallback$1:a	Ljava/lang/String;
    //   13: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: ldc 37
    //   20: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: new 39	java/io/File
    //   27: dup
    //   28: aload_2
    //   29: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aconst_null
    //   38: astore_3
    //   39: aload 5
    //   41: invokevirtual 50	java/io/File:exists	()Z
    //   44: ifne +9 -> 53
    //   47: aload 5
    //   49: invokevirtual 53	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: new 55	java/io/FileOutputStream
    //   56: dup
    //   57: aload 5
    //   59: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_0
    //   65: getfield 19	com/tencent/map/sdk/engine/jni/JNICallback$1:b	[B
    //   68: invokevirtual 62	java/io/FileOutputStream:write	([B)V
    //   71: iconst_1
    //   72: istore_1
    //   73: aload_2
    //   74: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   77: goto +90 -> 167
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   85: goto +82 -> 167
    //   88: astore 4
    //   90: aload_2
    //   91: astore_3
    //   92: aload 4
    //   94: astore_2
    //   95: goto +102 -> 197
    //   98: astore 4
    //   100: aload_2
    //   101: astore_3
    //   102: goto +18 -> 120
    //   105: astore 4
    //   107: aload_2
    //   108: astore_3
    //   109: goto +33 -> 142
    //   112: astore_2
    //   113: goto +84 -> 197
    //   116: astore 4
    //   118: aconst_null
    //   119: astore_3
    //   120: aload_3
    //   121: astore_2
    //   122: aload 4
    //   124: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   127: aload_3
    //   128: ifnull +37 -> 165
    //   131: aload_3
    //   132: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   135: goto +30 -> 165
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_3
    //   142: aload_3
    //   143: astore_2
    //   144: aload 4
    //   146: invokevirtual 69	java/io/FileNotFoundException:printStackTrace	()V
    //   149: aload_3
    //   150: ifnull +15 -> 165
    //   153: aload_3
    //   154: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   157: goto +8 -> 165
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   165: iconst_0
    //   166: istore_1
    //   167: iload_1
    //   168: ifeq +20 -> 188
    //   171: aload 5
    //   173: new 39	java/io/File
    //   176: dup
    //   177: aload_0
    //   178: getfield 17	com/tencent/map/sdk/engine/jni/JNICallback$1:a	Ljava/lang/String;
    //   181: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: invokevirtual 73	java/io/File:renameTo	(Ljava/io/File;)Z
    //   187: pop
    //   188: aconst_null
    //   189: areturn
    //   190: astore 4
    //   192: aload_2
    //   193: astore_3
    //   194: aload 4
    //   196: astore_2
    //   197: aload_3
    //   198: ifnull +15 -> 213
    //   201: aload_3
    //   202: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   205: goto +8 -> 213
    //   208: astore_3
    //   209: aload_3
    //   210: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   213: aload_2
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	1
    //   72	96	1	i	int
    //   7	67	2	localObject1	java.lang.Object
    //   80	11	2	localIOException1	java.io.IOException
    //   94	14	2	localObject2	java.lang.Object
    //   112	1	2	localObject3	java.lang.Object
    //   121	23	2	localObject4	java.lang.Object
    //   160	33	2	localIOException2	java.io.IOException
    //   196	18	2	localObject5	java.lang.Object
    //   38	164	3	localObject6	java.lang.Object
    //   208	2	3	localIOException3	java.io.IOException
    //   88	5	4	localObject7	java.lang.Object
    //   98	1	4	localIOException4	java.io.IOException
    //   105	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   116	7	4	localIOException5	java.io.IOException
    //   138	7	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   190	5	4	localObject8	java.lang.Object
    //   35	137	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   73	77	80	java/io/IOException
    //   63	71	88	finally
    //   63	71	98	java/io/IOException
    //   63	71	105	java/io/FileNotFoundException
    //   39	53	112	finally
    //   53	63	112	finally
    //   39	53	116	java/io/IOException
    //   53	63	116	java/io/IOException
    //   39	53	138	java/io/FileNotFoundException
    //   53	63	138	java/io/FileNotFoundException
    //   131	135	160	java/io/IOException
    //   153	157	160	java/io/IOException
    //   122	127	190	finally
    //   144	149	190	finally
    //   201	205	208	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.JNICallback.1
 * JD-Core Version:    0.7.0.1
 */