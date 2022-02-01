package com.tencent.dlsdk.yybutil.apkchannel.v2;

public class a
{
  public static byte[] a(String paramString)
  {
    return a(paramString, 1903261812);
  }
  
  /* Error */
  private static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 13	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 15
    //   7: invokespecial 19	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 24	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Lcom/tencent/dlsdk/yybutil/apkchannel/v2/b;
    //   15: astore 4
    //   17: aload 4
    //   19: getfield 29	com/tencent/dlsdk/yybutil/apkchannel/v2/b:a	Ljava/lang/Object;
    //   22: checkcast 31	java/nio/ByteBuffer
    //   25: astore 5
    //   27: aload 4
    //   29: getfield 34	com/tencent/dlsdk/yybutil/apkchannel/v2/b:b	Ljava/lang/Object;
    //   32: checkcast 36	java/lang/Long
    //   35: invokevirtual 40	java/lang/Long:longValue	()J
    //   38: lstore_2
    //   39: aload_0
    //   40: lload_2
    //   41: invokestatic 45	com/tencent/dlsdk/yybutil/apkchannel/v2/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   44: ifeq +34 -> 78
    //   47: new 47	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   50: dup
    //   51: ldc 49
    //   53: invokespecial 52	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: astore 4
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 56	java/io/RandomAccessFile:close	()V
    //   67: aload 4
    //   69: athrow
    //   70: astore_0
    //   71: aload 4
    //   73: ifnonnull +59 -> 132
    //   76: aload_0
    //   77: athrow
    //   78: aload_0
    //   79: aload 5
    //   81: lload_2
    //   82: invokestatic 59	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   85: invokestatic 62	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Lcom/tencent/dlsdk/yybutil/apkchannel/v2/b;
    //   88: getfield 29	com/tencent/dlsdk/yybutil/apkchannel/v2/b:a	Ljava/lang/Object;
    //   91: checkcast 31	java/nio/ByteBuffer
    //   94: iload_1
    //   95: invokestatic 65	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:b	(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   98: astore 4
    //   100: aload 4
    //   102: invokevirtual 69	java/nio/ByteBuffer:remaining	()I
    //   105: newarray byte
    //   107: astore 5
    //   109: aload 4
    //   111: aload 5
    //   113: iconst_0
    //   114: aload 5
    //   116: arraylength
    //   117: invokevirtual 73	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   120: pop
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 56	java/io/RandomAccessFile:close	()V
    //   129: aload 5
    //   131: areturn
    //   132: aload 4
    //   134: aload_0
    //   135: if_acmpeq +9 -> 144
    //   138: aload 4
    //   140: aload_0
    //   141: invokevirtual 79	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   144: aload 4
    //   146: astore_0
    //   147: goto -71 -> 76
    //   150: astore_0
    //   151: aconst_null
    //   152: astore 4
    //   154: goto -83 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramString	String
    //   0	157	1	paramInt	int
    //   38	44	2	l	long
    //   15	13	4	localb	b
    //   57	15	4	localObject1	Object
    //   98	55	4	localByteBuffer	java.nio.ByteBuffer
    //   25	105	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	57	57	finally
    //   78	121	57	finally
    //   63	67	70	finally
    //   67	70	70	finally
    //   0	11	150	finally
    //   125	129	150	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.v2.a
 * JD-Core Version:    0.7.0.1
 */