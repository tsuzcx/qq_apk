package com.tencent.mm.vfs;

final class VFSNativeAPI
{
  private static final int ALL_SUPPORTED_FLAGS = 1603;
  private static final int O_ACCMODE = 3;
  private static final int O_APPEND = 1024;
  private static final int O_CREAT = 64;
  private static final int O_RDONLY = 0;
  private static final int O_RDWR = 2;
  private static final int O_TRUNC = 512;
  private static final int O_WRONLY = 1;
  private static final String TAG = "VFS.VFSNativeAPI";
  
  /* Error */
  static int openFd(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush -1604
    //   4: iand
    //   5: ifne +266 -> 271
    //   8: iload_1
    //   9: iconst_3
    //   10: iand
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +58 -> 71
    //   16: iload_2
    //   17: iconst_1
    //   18: if_icmpeq +47 -> 65
    //   21: iload_2
    //   22: iconst_2
    //   23: if_icmpne +9 -> 32
    //   26: ldc 36
    //   28: astore_3
    //   29: goto +45 -> 74
    //   32: new 38	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   39: astore_0
    //   40: aload_0
    //   41: ldc 41
    //   43: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_0
    //   48: iload_1
    //   49: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: new 50	java/lang/IllegalArgumentException
    //   56: dup
    //   57: aload_0
    //   58: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 57	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   64: athrow
    //   65: ldc 59
    //   67: astore_3
    //   68: goto +6 -> 74
    //   71: ldc 61
    //   73: astore_3
    //   74: aload_3
    //   75: astore 4
    //   77: iload_1
    //   78: sipush 512
    //   81: iand
    //   82: ifeq +34 -> 116
    //   85: new 38	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   92: astore 4
    //   94: aload 4
    //   96: aload_3
    //   97: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: ldc 63
    //   105: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 4
    //   111: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 4
    //   116: aload 4
    //   118: astore 5
    //   120: iload_1
    //   121: sipush 1024
    //   124: iand
    //   125: ifeq +31 -> 156
    //   128: new 38	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   135: astore_3
    //   136: aload_3
    //   137: aload 4
    //   139: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_3
    //   144: ldc 65
    //   146: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_3
    //   151: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 5
    //   156: aconst_null
    //   157: astore_3
    //   158: aconst_null
    //   159: astore 4
    //   161: aload_0
    //   162: aload 5
    //   164: invokestatic 71	com/tencent/mm/vfs/VFSFileOp:openFileDescriptor	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   167: astore 5
    //   169: aload 5
    //   171: astore_3
    //   172: aload 5
    //   174: ifnull +23 -> 197
    //   177: aload 5
    //   179: astore 4
    //   181: aload 5
    //   183: astore_3
    //   184: aload 5
    //   186: invokevirtual 77	android/os/ParcelFileDescriptor:detachFd	()I
    //   189: istore_1
    //   190: aload 5
    //   192: invokestatic 83	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Landroid/os/ParcelFileDescriptor;)V
    //   195: iload_1
    //   196: ireturn
    //   197: aload_3
    //   198: invokestatic 83	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Landroid/os/ParcelFileDescriptor;)V
    //   201: goto +61 -> 262
    //   204: astore_0
    //   205: goto +59 -> 264
    //   208: astore 5
    //   210: aload_3
    //   211: astore 4
    //   213: new 38	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   220: astore 6
    //   222: aload_3
    //   223: astore 4
    //   225: aload 6
    //   227: ldc 85
    //   229: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: astore 4
    //   236: aload 6
    //   238: aload_0
    //   239: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_3
    //   244: astore 4
    //   246: ldc 25
    //   248: iconst_1
    //   249: aload 6
    //   251: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aload 5
    //   256: invokestatic 91	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: goto -62 -> 197
    //   262: iconst_m1
    //   263: ireturn
    //   264: aload 4
    //   266: invokestatic 83	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Landroid/os/ParcelFileDescriptor;)V
    //   269: aload_0
    //   270: athrow
    //   271: new 38	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   278: astore_0
    //   279: aload_0
    //   280: ldc 93
    //   282: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_0
    //   287: iload_1
    //   288: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: new 50	java/lang/IllegalArgumentException
    //   295: dup
    //   296: aload_0
    //   297: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokespecial 57	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   303: astore_0
    //   304: goto +5 -> 309
    //   307: aload_0
    //   308: athrow
    //   309: goto -2 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString	String
    //   0	312	1	paramInt	int
    //   11	13	2	i	int
    //   28	216	3	localObject1	Object
    //   75	190	4	localObject2	Object
    //   118	73	5	localObject3	Object
    //   208	47	5	localIOException	java.io.IOException
    //   220	30	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   161	169	204	finally
    //   184	190	204	finally
    //   213	222	204	finally
    //   225	233	204	finally
    //   236	243	204	finally
    //   246	259	204	finally
    //   161	169	208	java/io/IOException
    //   184	190	208	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSNativeAPI
 * JD-Core Version:    0.7.0.1
 */