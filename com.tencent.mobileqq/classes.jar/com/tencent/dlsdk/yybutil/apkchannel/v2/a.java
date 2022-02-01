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
    //   0: aconst_null
    //   1: astore 5
    //   3: aload 5
    //   5: astore 4
    //   7: new 13	java/io/RandomAccessFile
    //   10: dup
    //   11: aload_0
    //   12: ldc 15
    //   14: invokespecial 19	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: invokestatic 24	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;)Lcom/tencent/dlsdk/yybutil/apkchannel/v2/b;
    //   24: astore_0
    //   25: aload_0
    //   26: getfield 29	com/tencent/dlsdk/yybutil/apkchannel/v2/b:a	Ljava/lang/Object;
    //   29: checkcast 31	java/nio/ByteBuffer
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 34	com/tencent/dlsdk/yybutil/apkchannel/v2/b:b	Ljava/lang/Object;
    //   38: checkcast 36	java/lang/Long
    //   41: invokevirtual 40	java/lang/Long:longValue	()J
    //   44: lstore_2
    //   45: aload 6
    //   47: lload_2
    //   48: invokestatic 45	com/tencent/dlsdk/yybutil/apkchannel/v2/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   51: ifne +55 -> 106
    //   54: aload 6
    //   56: aload 4
    //   58: lload_2
    //   59: invokestatic 48	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:a	(Ljava/nio/ByteBuffer;J)J
    //   62: invokestatic 51	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:a	(Ljava/io/RandomAccessFile;J)Lcom/tencent/dlsdk/yybutil/apkchannel/v2/b;
    //   65: getfield 29	com/tencent/dlsdk/yybutil/apkchannel/v2/b:a	Ljava/lang/Object;
    //   68: checkcast 31	java/nio/ByteBuffer
    //   71: iload_1
    //   72: invokestatic 54	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier:b	(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   75: astore 4
    //   77: aload 4
    //   79: invokevirtual 58	java/nio/ByteBuffer:remaining	()I
    //   82: newarray byte
    //   84: astore_0
    //   85: aload 4
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_0
    //   90: arraylength
    //   91: invokevirtual 62	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   94: pop
    //   95: aload 5
    //   97: astore 4
    //   99: aload 6
    //   101: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   104: aload_0
    //   105: areturn
    //   106: new 68	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier$SignatureNotFoundException
    //   109: dup
    //   110: ldc 70
    //   112: invokespecial 73	com/tencent/dlsdk/yybutil/apkchannel/v2/ApkSignatureSchemeV2Verifier$SignatureNotFoundException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: astore_0
    //   117: aload_0
    //   118: astore 4
    //   120: aload 6
    //   122: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   125: aload_0
    //   126: astore 4
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: aload 4
    //   133: ifnull +6 -> 139
    //   136: aload 4
    //   138: astore_0
    //   139: aload_0
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   0	141	1	paramInt	int
    //   44	15	2	l	long
    //   5	132	4	localObject1	Object
    //   1	95	5	localObject2	Object
    //   17	104	6	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   19	95	116	finally
    //   106	116	116	finally
    //   7	19	130	finally
    //   99	104	130	finally
    //   120	125	130	finally
    //   128	130	130	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.v2.a
 * JD-Core Version:    0.7.0.1
 */