package com.tencent.map.sdk.a;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public final class iv
  implements oe.a
{
  private final int a = 128;
  private String b;
  
  public iv(String paramString)
  {
    this.b = paramString;
  }
  
  private static long a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 128 * 128L + paramInt2 % 128;
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt1 /= 128;
    paramInt2 /= 128;
    int i = paramInt1 / 10;
    int j = paramInt2 / 10;
    localStringBuilder.append(File.separatorChar).append("glGrid").append(File.separatorChar).append(paramInt3).append(File.separatorChar).append(i).append(File.separatorChar).append(j).append(File.separatorChar).append(paramInt3).append("_").append(paramInt1).append("_").append(paramInt2);
    return localStringBuilder.toString();
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 4)) {
      return;
    }
    int i = paramArrayOfByte[0];
    paramArrayOfByte[0] = paramArrayOfByte[3];
    paramArrayOfByte[3] = i;
    i = paramArrayOfByte[1];
    paramArrayOfByte[1] = paramArrayOfByte[2];
    paramArrayOfByte[2] = i;
  }
  
  /* Error */
  private static boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_3
    //   7: arraylength
    //   8: istore 4
    //   10: iload 4
    //   12: ifgt +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: iconst_2
    //   18: anewarray 57	java/lang/String
    //   21: astore 9
    //   23: aload 9
    //   25: iconst_0
    //   26: new 26	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   33: aload_0
    //   34: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 59
    //   39: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aastore
    //   46: aload 9
    //   48: iconst_1
    //   49: new 26	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   56: aload_0
    //   57: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 61
    //   62: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aastore
    //   69: new 29	java/io/File
    //   72: dup
    //   73: aload 9
    //   75: iconst_1
    //   76: aaload
    //   77: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 67	java/io/File:exists	()Z
    //   85: ifne +12 -> 97
    //   88: aload_0
    //   89: invokestatic 72	com/tencent/map/sdk/a/om:a	(Ljava/io/File;)Z
    //   92: ifne +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: new 74	java/io/RandomAccessFile
    //   100: dup
    //   101: aload_0
    //   102: ldc 76
    //   104: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   107: astore_0
    //   108: aload_0
    //   109: ifnonnull +11 -> 120
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -9 -> 108
    //   120: iload 4
    //   122: invokestatic 82	com/tencent/map/sdk/a/iv:a	(I)[B
    //   125: astore 10
    //   127: aload 10
    //   129: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   132: aload_0
    //   133: invokevirtual 88	java/io/RandomAccessFile:length	()J
    //   136: lstore 5
    //   138: aload_0
    //   139: lload 5
    //   141: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   144: aload_0
    //   145: aload 10
    //   147: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   150: aload_0
    //   151: aload_3
    //   152: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   155: aload_0
    //   156: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   159: new 29	java/io/File
    //   162: dup
    //   163: aload 9
    //   165: iconst_0
    //   166: aaload
    //   167: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 67	java/io/File:exists	()Z
    //   175: ifne +30 -> 205
    //   178: aload_0
    //   179: invokestatic 72	com/tencent/map/sdk/a/om:a	(Ljava/io/File;)Z
    //   182: ifne +23 -> 205
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_3
    //   188: lconst_0
    //   189: lstore 5
    //   191: aload_0
    //   192: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   195: goto -36 -> 159
    //   198: astore_3
    //   199: aload_0
    //   200: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   203: aload_3
    //   204: athrow
    //   205: new 74	java/io/RandomAccessFile
    //   208: dup
    //   209: aload_0
    //   210: ldc 76
    //   212: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   215: astore_0
    //   216: aload_0
    //   217: ifnonnull +11 -> 228
    //   220: iconst_0
    //   221: ireturn
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_0
    //   225: goto -9 -> 216
    //   228: aload_0
    //   229: invokevirtual 88	java/io/RandomAccessFile:length	()J
    //   232: lstore 7
    //   234: lload 7
    //   236: lconst_0
    //   237: lcmp
    //   238: ifne +18 -> 256
    //   241: ldc 101
    //   243: newarray byte
    //   245: astore_3
    //   246: aload_3
    //   247: iconst_m1
    //   248: invokestatic 107	java/util/Arrays:fill	([BB)V
    //   251: aload_0
    //   252: aload_3
    //   253: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   256: iload_1
    //   257: iload_2
    //   258: invokestatic 109	com/tencent/map/sdk/a/iv:a	(II)J
    //   261: lstore 7
    //   263: lload 7
    //   265: lconst_0
    //   266: lcmp
    //   267: ifge +16 -> 283
    //   270: aload_0
    //   271: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_3
    //   277: lconst_0
    //   278: lstore 7
    //   280: goto -46 -> 234
    //   283: aload_0
    //   284: ldc2_w 110
    //   287: lload 7
    //   289: lmul
    //   290: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   293: lload 5
    //   295: l2i
    //   296: invokestatic 82	com/tencent/map/sdk/a/iv:a	(I)[B
    //   299: astore_3
    //   300: aload_3
    //   301: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   304: aload_0
    //   305: aload_3
    //   306: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   309: aload_0
    //   310: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   313: iconst_1
    //   314: ireturn
    //   315: astore_3
    //   316: aload_0
    //   317: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   320: goto -7 -> 313
    //   323: astore_3
    //   324: aload_0
    //   325: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   328: aload_3
    //   329: athrow
    //   330: astore_3
    //   331: goto -75 -> 256
    //   334: astore_3
    //   335: goto -42 -> 293
    //   338: astore_3
    //   339: goto -148 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramString	String
    //   0	342	1	paramInt1	int
    //   0	342	2	paramInt2	int
    //   0	342	3	paramArrayOfByte	byte[]
    //   8	113	4	i	int
    //   136	158	5	l1	long
    //   232	56	7	l2	long
    //   21	143	9	arrayOfString	String[]
    //   125	21	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   97	108	114	java/lang/Exception
    //   132	138	187	java/lang/Exception
    //   132	138	198	finally
    //   138	155	198	finally
    //   205	216	222	java/lang/Exception
    //   228	234	276	java/lang/Exception
    //   304	309	315	java/lang/Exception
    //   304	309	323	finally
    //   251	256	330	java/lang/Exception
    //   283	293	334	java/lang/Exception
    //   138	155	338	java/lang/Exception
  }
  
  private static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
  }
  
  /* Error */
  private static byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 57	java/lang/String
    //   4: astore 6
    //   6: aload 6
    //   8: iconst_0
    //   9: new 26	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 59
    //   22: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: aastore
    //   29: aload 6
    //   31: iconst_1
    //   32: new 26	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   39: aload_0
    //   40: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 61
    //   45: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aastore
    //   52: new 29	java/io/File
    //   55: dup
    //   56: aload 6
    //   58: iconst_0
    //   59: aaload
    //   60: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 67	java/io/File:exists	()Z
    //   68: ifeq +12 -> 80
    //   71: aload_0
    //   72: invokevirtual 118	java/io/File:length	()J
    //   75: lconst_0
    //   76: lcmp
    //   77: ifne +5 -> 82
    //   80: aconst_null
    //   81: areturn
    //   82: iload_1
    //   83: iload_2
    //   84: invokestatic 109	com/tencent/map/sdk/a/iv:a	(II)J
    //   87: lstore_3
    //   88: lload_3
    //   89: lconst_0
    //   90: lcmp
    //   91: iflt -11 -> 80
    //   94: iconst_4
    //   95: newarray byte
    //   97: astore 5
    //   99: new 74	java/io/RandomAccessFile
    //   102: dup
    //   103: aload_0
    //   104: ldc 120
    //   106: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   109: astore_0
    //   110: aload_0
    //   111: lload_3
    //   112: ldc2_w 110
    //   115: lmul
    //   116: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   119: aload_0
    //   120: aload 5
    //   122: iconst_0
    //   123: iconst_4
    //   124: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   127: pop
    //   128: aload_0
    //   129: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   132: aload 5
    //   134: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   137: aload 5
    //   139: invokestatic 127	com/tencent/map/sdk/a/iv:b	([B)I
    //   142: istore_1
    //   143: iload_1
    //   144: iflt -64 -> 80
    //   147: new 29	java/io/File
    //   150: dup
    //   151: aload 6
    //   153: iconst_1
    //   154: aaload
    //   155: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 67	java/io/File:exists	()Z
    //   163: ifeq -83 -> 80
    //   166: new 74	java/io/RandomAccessFile
    //   169: dup
    //   170: aload_0
    //   171: ldc 120
    //   173: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   176: astore_0
    //   177: iload_1
    //   178: i2l
    //   179: lstore_3
    //   180: aload_0
    //   181: lload_3
    //   182: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   185: aload_0
    //   186: aload 5
    //   188: iconst_0
    //   189: iconst_4
    //   190: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   193: pop
    //   194: aload 5
    //   196: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   199: aload 5
    //   201: invokestatic 127	com/tencent/map/sdk/a/iv:b	([B)I
    //   204: istore_1
    //   205: iload_1
    //   206: ifgt +42 -> 248
    //   209: aload_0
    //   210: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_0
    //   219: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore 6
    //   228: aload_0
    //   229: astore 5
    //   231: aload 6
    //   233: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   236: aload 5
    //   238: athrow
    //   239: astore_0
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_0
    //   243: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   246: aconst_null
    //   247: areturn
    //   248: iload_1
    //   249: newarray byte
    //   251: astore 5
    //   253: aload_0
    //   254: aload 5
    //   256: iconst_0
    //   257: iload_1
    //   258: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   261: pop
    //   262: aload_0
    //   263: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   266: aload 5
    //   268: areturn
    //   269: astore 5
    //   271: aload 5
    //   273: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   276: aload_0
    //   277: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   280: aconst_null
    //   281: areturn
    //   282: astore 5
    //   284: aload_0
    //   285: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   288: aload 5
    //   290: athrow
    //   291: astore 5
    //   293: goto -51 -> 242
    //   296: astore 5
    //   298: aload_0
    //   299: astore 6
    //   301: goto -70 -> 231
    //   304: astore 5
    //   306: goto -88 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   0	309	1	paramInt1	int
    //   0	309	2	paramInt2	int
    //   87	95	3	l	long
    //   97	170	5	localObject1	Object
    //   269	3	5	localIOException	java.io.IOException
    //   282	7	5	localObject2	Object
    //   291	1	5	localException1	java.lang.Exception
    //   296	1	5	localObject3	Object
    //   304	1	5	localException2	java.lang.Exception
    //   4	296	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   99	110	215	java/lang/Exception
    //   99	110	224	finally
    //   166	177	239	java/lang/Exception
    //   253	262	269	java/io/IOException
    //   253	262	282	finally
    //   271	276	282	finally
    //   180	194	291	java/lang/Exception
    //   110	128	296	finally
    //   110	128	304	java/lang/Exception
  }
  
  private static int[] a(String paramString)
  {
    paramString = paramString.split("-");
    if (paramString.length < 3) {
      return null;
    }
    int[] arrayOfInt = new int[3];
    int i = 0;
    while (i < 3) {
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        or.a(Log.getStackTraceString(paramString));
        return null;
      }
    }
    return arrayOfInt;
  }
  
  private static int b(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  public final File a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    int i = paramString1.lastIndexOf(File.separatorChar);
    String str2 = paramString1;
    String str1 = paramString2;
    if (i >= 0)
    {
      str2 = paramString1.substring(0, i);
      str1 = paramString2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = paramString2 + File.separator + str2;
      }
      str2 = paramString1.substring(i + 1);
    }
    paramString1 = a(str2);
    if (paramString1 == null) {
      return new File(str1, str2);
    }
    paramString2 = str1 + a(paramString1[0], paramString1[1], paramString1[2]);
    if (!a(paramString2, paramString1[0], paramString1[1], paramArrayOfByte)) {
      return new File(str1, str2);
    }
    return new File(paramString2 + ".dat");
  }
  
  public final boolean a(File paramFile)
  {
    return om.b(new File(this.b));
  }
  
  public final byte[] a(String paramString, File paramFile)
  {
    String str1 = this.b;
    int i = paramString.lastIndexOf(File.separatorChar);
    paramFile = str1;
    String str2 = paramString;
    if (i >= 0)
    {
      str2 = paramString.substring(0, i);
      paramFile = str1;
      if (!TextUtils.isEmpty(str2)) {
        paramFile = str1 + File.separator + str2;
      }
      str2 = paramString.substring(i + 1);
    }
    paramString = a(str2);
    if (paramString == null) {
      return null;
    }
    return a(paramFile + a(paramString[0], paramString[1], paramString[2]), paramString[0], paramString[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.iv
 * JD-Core Version:    0.7.0.1
 */