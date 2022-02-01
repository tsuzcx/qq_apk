package com.huawei.hms.framework.network.grs.d;

public class c
{
  private static final String a = "c";
  
  /* Error */
  public static String a(String paramString, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 19
    //   9: areturn
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: new 21	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 25	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore 5
    //   24: aload_1
    //   25: invokevirtual 31	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   28: aload_0
    //   29: invokevirtual 37	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   32: astore_1
    //   33: aload_1
    //   34: astore_3
    //   35: aload_1
    //   36: astore 4
    //   38: sipush 8192
    //   41: newarray byte
    //   43: astore 6
    //   45: aload_1
    //   46: astore_3
    //   47: aload_1
    //   48: astore 4
    //   50: aload_1
    //   51: aload 6
    //   53: invokevirtual 43	java/io/InputStream:read	([B)I
    //   56: istore_2
    //   57: iload_2
    //   58: iconst_m1
    //   59: if_icmpeq +20 -> 79
    //   62: aload_1
    //   63: astore_3
    //   64: aload_1
    //   65: astore 4
    //   67: aload 5
    //   69: aload 6
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 47	java/io/ByteArrayOutputStream:write	([BII)V
    //   76: goto -31 -> 45
    //   79: aload_1
    //   80: astore_3
    //   81: aload_1
    //   82: astore 4
    //   84: aload 5
    //   86: invokevirtual 50	java/io/ByteArrayOutputStream:flush	()V
    //   89: aload_1
    //   90: astore_3
    //   91: aload_1
    //   92: astore 4
    //   94: aload 5
    //   96: invokevirtual 54	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   99: astore 6
    //   101: aload_1
    //   102: astore_3
    //   103: aload_1
    //   104: astore 4
    //   106: new 56	java/lang/String
    //   109: dup
    //   110: aload 6
    //   112: ldc 58
    //   114: invokespecial 61	java/lang/String:<init>	([BLjava/lang/String;)V
    //   117: astore 6
    //   119: aload 5
    //   121: invokestatic 67	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/OutputStream;)V
    //   124: aload_1
    //   125: invokestatic 70	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/InputStream;)V
    //   128: aload 6
    //   130: areturn
    //   131: aload 4
    //   133: astore_3
    //   134: getstatic 72	com/huawei/hms/framework/network/grs/d/c:a	Ljava/lang/String;
    //   137: astore_1
    //   138: aload 4
    //   140: astore_3
    //   141: aload_1
    //   142: ldc 74
    //   144: iconst_1
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: aastore
    //   152: invokestatic 80	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload 5
    //   157: invokestatic 67	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/OutputStream;)V
    //   160: aload 4
    //   162: invokestatic 70	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/InputStream;)V
    //   165: ldc 19
    //   167: areturn
    //   168: astore_0
    //   169: aload 5
    //   171: invokestatic 67	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/OutputStream;)V
    //   174: aload_3
    //   175: invokestatic 70	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/InputStream;)V
    //   178: goto +5 -> 183
    //   181: aload_0
    //   182: athrow
    //   183: goto -2 -> 181
    //   186: astore_1
    //   187: goto -56 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString	String
    //   0	190	1	paramContext	android.content.Context
    //   56	17	2	i	int
    //   14	161	3	localContext1	android.content.Context
    //   11	150	4	localContext2	android.content.Context
    //   22	148	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   43	86	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	33	168	finally
    //   38	45	168	finally
    //   50	57	168	finally
    //   67	76	168	finally
    //   84	89	168	finally
    //   94	101	168	finally
    //   106	119	168	finally
    //   134	138	168	finally
    //   141	155	168	finally
    //   24	33	186	java/io/IOException
    //   38	45	186	java/io/IOException
    //   50	57	186	java/io/IOException
    //   67	76	186	java/io/IOException
    //   84	89	186	java/io/IOException
    //   94	101	186	java/io/IOException
    //   106	119	186	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d.c
 * JD-Core Version:    0.7.0.1
 */