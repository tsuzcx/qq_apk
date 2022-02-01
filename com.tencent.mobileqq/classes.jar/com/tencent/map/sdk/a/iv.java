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
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append("glGrid");
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append(i);
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append(j);
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 4) {
        return;
      }
      int i = paramArrayOfByte[0];
      paramArrayOfByte[0] = paramArrayOfByte[3];
      paramArrayOfByte[3] = i;
      i = paramArrayOfByte[1];
      paramArrayOfByte[1] = paramArrayOfByte[2];
      paramArrayOfByte[2] = i;
    }
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
    //   23: new 26	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   30: astore 10
    //   32: aload 10
    //   34: aload_0
    //   35: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 10
    //   41: ldc 59
    //   43: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 9
    //   49: iconst_0
    //   50: aload 10
    //   52: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: aastore
    //   56: new 26	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   63: astore 10
    //   65: aload 10
    //   67: aload_0
    //   68: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 10
    //   74: ldc 61
    //   76: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 9
    //   82: iconst_1
    //   83: aload 10
    //   85: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: aastore
    //   89: new 29	java/io/File
    //   92: dup
    //   93: aload 9
    //   95: iconst_1
    //   96: aaload
    //   97: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 67	java/io/File:exists	()Z
    //   105: ifne +12 -> 117
    //   108: aload_0
    //   109: invokestatic 72	com/tencent/map/sdk/a/om:a	(Ljava/io/File;)Z
    //   112: ifne +5 -> 117
    //   115: iconst_0
    //   116: ireturn
    //   117: new 74	java/io/RandomAccessFile
    //   120: dup
    //   121: aload_0
    //   122: ldc 76
    //   124: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore_0
    //   128: goto +5 -> 133
    //   131: aconst_null
    //   132: astore_0
    //   133: aload_0
    //   134: ifnonnull +5 -> 139
    //   137: iconst_0
    //   138: ireturn
    //   139: iload 4
    //   141: invokestatic 82	com/tencent/map/sdk/a/iv:a	(I)[B
    //   144: astore 10
    //   146: aload 10
    //   148: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   151: aload_0
    //   152: invokevirtual 88	java/io/RandomAccessFile:length	()J
    //   155: lstore 5
    //   157: aload_0
    //   158: lload 5
    //   160: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   163: aload_0
    //   164: aload 10
    //   166: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   169: aload_0
    //   170: aload_3
    //   171: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   174: goto +13 -> 187
    //   177: astore_3
    //   178: aload_0
    //   179: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   182: aload_3
    //   183: athrow
    //   184: lconst_0
    //   185: lstore 5
    //   187: aload_0
    //   188: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   191: new 29	java/io/File
    //   194: dup
    //   195: aload 9
    //   197: iconst_0
    //   198: aaload
    //   199: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 67	java/io/File:exists	()Z
    //   207: ifne +12 -> 219
    //   210: aload_0
    //   211: invokestatic 72	com/tencent/map/sdk/a/om:a	(Ljava/io/File;)Z
    //   214: ifne +5 -> 219
    //   217: iconst_0
    //   218: ireturn
    //   219: new 74	java/io/RandomAccessFile
    //   222: dup
    //   223: aload_0
    //   224: ldc 76
    //   226: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   229: astore_0
    //   230: goto +5 -> 235
    //   233: aconst_null
    //   234: astore_0
    //   235: aload_0
    //   236: ifnonnull +5 -> 241
    //   239: iconst_0
    //   240: ireturn
    //   241: aload_0
    //   242: invokevirtual 88	java/io/RandomAccessFile:length	()J
    //   245: lstore 7
    //   247: goto +6 -> 253
    //   250: lconst_0
    //   251: lstore 7
    //   253: lload 7
    //   255: lconst_0
    //   256: lcmp
    //   257: ifne +21 -> 278
    //   260: ldc 101
    //   262: newarray byte
    //   264: astore_3
    //   265: aload_3
    //   266: iconst_m1
    //   267: invokestatic 107	java/util/Arrays:fill	([BB)V
    //   270: aload_0
    //   271: aload_3
    //   272: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   275: goto +3 -> 278
    //   278: iload_1
    //   279: iload_2
    //   280: invokestatic 109	com/tencent/map/sdk/a/iv:a	(II)J
    //   283: lstore 7
    //   285: lload 7
    //   287: lconst_0
    //   288: lcmp
    //   289: ifge +9 -> 298
    //   292: aload_0
    //   293: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   296: iconst_0
    //   297: ireturn
    //   298: aload_0
    //   299: lload 7
    //   301: ldc2_w 110
    //   304: lmul
    //   305: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   308: lload 5
    //   310: l2i
    //   311: invokestatic 82	com/tencent/map/sdk/a/iv:a	(I)[B
    //   314: astore_3
    //   315: aload_3
    //   316: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   319: aload_0
    //   320: aload_3
    //   321: invokevirtual 95	java/io/RandomAccessFile:write	([B)V
    //   324: aload_0
    //   325: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   328: iconst_1
    //   329: ireturn
    //   330: astore_3
    //   331: aload_0
    //   332: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   335: aload_3
    //   336: athrow
    //   337: astore_0
    //   338: goto -207 -> 131
    //   341: astore_3
    //   342: goto -158 -> 184
    //   345: astore_3
    //   346: goto -159 -> 187
    //   349: astore_0
    //   350: goto -117 -> 233
    //   353: astore_3
    //   354: goto -104 -> 250
    //   357: astore_3
    //   358: goto -80 -> 278
    //   361: astore_3
    //   362: goto -54 -> 308
    //   365: astore_3
    //   366: goto -42 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	paramString	String
    //   0	369	1	paramInt1	int
    //   0	369	2	paramInt2	int
    //   0	369	3	paramArrayOfByte	byte[]
    //   8	132	4	i	int
    //   155	154	5	l1	long
    //   245	55	7	l2	long
    //   21	175	9	arrayOfString	String[]
    //   30	135	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   151	157	177	finally
    //   157	174	177	finally
    //   319	324	330	finally
    //   117	128	337	java/lang/Exception
    //   151	157	341	java/lang/Exception
    //   157	174	345	java/lang/Exception
    //   219	230	349	java/lang/Exception
    //   241	247	353	java/lang/Exception
    //   270	275	357	java/lang/Exception
    //   298	308	361	java/lang/Exception
    //   319	324	365	java/lang/Exception
  }
  
  private static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((paramInt & 0xFF000000) >> 24) };
  }
  
  /* Error */
  private static byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 57	java/lang/String
    //   4: astore 6
    //   6: new 26	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_0
    //   18: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 7
    //   24: ldc 59
    //   26: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: iconst_0
    //   33: aload 7
    //   35: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: aastore
    //   39: new 26	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   46: astore 7
    //   48: aload 7
    //   50: aload_0
    //   51: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 7
    //   57: ldc 61
    //   59: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 6
    //   65: iconst_1
    //   66: aload 7
    //   68: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: aastore
    //   72: new 29	java/io/File
    //   75: dup
    //   76: aload 6
    //   78: iconst_0
    //   79: aaload
    //   80: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 67	java/io/File:exists	()Z
    //   88: istore_3
    //   89: aconst_null
    //   90: astore 7
    //   92: iload_3
    //   93: ifeq +235 -> 328
    //   96: aload_0
    //   97: invokevirtual 118	java/io/File:length	()J
    //   100: lconst_0
    //   101: lcmp
    //   102: ifne +5 -> 107
    //   105: aconst_null
    //   106: areturn
    //   107: iload_1
    //   108: iload_2
    //   109: invokestatic 109	com/tencent/map/sdk/a/iv:a	(II)J
    //   112: lstore 4
    //   114: lload 4
    //   116: lconst_0
    //   117: lcmp
    //   118: ifge +5 -> 123
    //   121: aconst_null
    //   122: areturn
    //   123: iconst_4
    //   124: newarray byte
    //   126: astore 8
    //   128: new 74	java/io/RandomAccessFile
    //   131: dup
    //   132: aload_0
    //   133: ldc 120
    //   135: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   138: astore_0
    //   139: aload_0
    //   140: lload 4
    //   142: ldc2_w 110
    //   145: lmul
    //   146: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   149: aload_0
    //   150: aload 8
    //   152: iconst_0
    //   153: iconst_4
    //   154: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   157: pop
    //   158: aload_0
    //   159: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   162: aload 8
    //   164: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   167: aload 8
    //   169: invokestatic 127	com/tencent/map/sdk/a/iv:b	([B)I
    //   172: istore_1
    //   173: iload_1
    //   174: ifge +5 -> 179
    //   177: aconst_null
    //   178: areturn
    //   179: new 29	java/io/File
    //   182: dup
    //   183: aload 6
    //   185: iconst_1
    //   186: aaload
    //   187: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 67	java/io/File:exists	()Z
    //   195: ifne +5 -> 200
    //   198: aconst_null
    //   199: areturn
    //   200: new 74	java/io/RandomAccessFile
    //   203: dup
    //   204: aload_0
    //   205: ldc 120
    //   207: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   210: astore_0
    //   211: iload_1
    //   212: i2l
    //   213: lstore 4
    //   215: aload_0
    //   216: lload 4
    //   218: invokevirtual 92	java/io/RandomAccessFile:seek	(J)V
    //   221: aload_0
    //   222: aload 8
    //   224: iconst_0
    //   225: iconst_4
    //   226: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   229: pop
    //   230: aload 8
    //   232: invokestatic 84	com/tencent/map/sdk/a/iv:a	([B)V
    //   235: aload 8
    //   237: invokestatic 127	com/tencent/map/sdk/a/iv:b	([B)I
    //   240: istore_1
    //   241: iload_1
    //   242: ifgt +9 -> 251
    //   245: aload_0
    //   246: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   249: aconst_null
    //   250: areturn
    //   251: iload_1
    //   252: newarray byte
    //   254: astore 6
    //   256: aload_0
    //   257: aload 6
    //   259: iconst_0
    //   260: iload_1
    //   261: invokevirtual 124	java/io/RandomAccessFile:read	([BII)I
    //   264: pop
    //   265: aload_0
    //   266: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   269: aload 6
    //   271: areturn
    //   272: astore 6
    //   274: goto +16 -> 290
    //   277: astore 6
    //   279: aload 6
    //   281: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   284: aload_0
    //   285: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   288: aconst_null
    //   289: areturn
    //   290: aload_0
    //   291: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   294: aload 6
    //   296: athrow
    //   297: aconst_null
    //   298: astore_0
    //   299: aload_0
    //   300: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   303: aconst_null
    //   304: areturn
    //   305: astore 6
    //   307: goto +8 -> 315
    //   310: astore 6
    //   312: aload 7
    //   314: astore_0
    //   315: aload_0
    //   316: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   319: aload 6
    //   321: athrow
    //   322: aconst_null
    //   323: astore_0
    //   324: aload_0
    //   325: invokestatic 100	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   328: aconst_null
    //   329: areturn
    //   330: astore_0
    //   331: goto -9 -> 322
    //   334: astore 6
    //   336: goto -12 -> 324
    //   339: astore_0
    //   340: goto -43 -> 297
    //   343: astore 6
    //   345: goto -46 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramString	String
    //   0	348	1	paramInt1	int
    //   0	348	2	paramInt2	int
    //   88	5	3	bool	boolean
    //   112	105	4	l	long
    //   4	266	6	localObject1	Object
    //   272	1	6	localObject2	Object
    //   277	18	6	localIOException	java.io.IOException
    //   305	1	6	localObject3	Object
    //   310	10	6	localObject4	Object
    //   334	1	6	localException1	java.lang.Exception
    //   343	1	6	localException2	java.lang.Exception
    //   13	300	7	localStringBuilder	StringBuilder
    //   126	110	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   256	265	272	finally
    //   279	284	272	finally
    //   256	265	277	java/io/IOException
    //   139	158	305	finally
    //   128	139	310	finally
    //   128	139	330	java/lang/Exception
    //   139	158	334	java/lang/Exception
    //   200	211	339	java/lang/Exception
    //   215	230	343	java/lang/Exception
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
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return paramArrayOfByte[3] << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
  }
  
  public final File a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    int i = paramString1.lastIndexOf(File.separatorChar);
    String str = paramString1;
    Object localObject = paramString2;
    if (i >= 0)
    {
      str = paramString1.substring(0, i);
      localObject = paramString2;
      if (!TextUtils.isEmpty(str))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      str = paramString1.substring(i + 1);
    }
    paramString1 = a(str);
    if (paramString1 == null) {
      return new File((String)localObject, str);
    }
    paramString2 = new StringBuilder();
    paramString2.append((String)localObject);
    paramString2.append(a(paramString1[0], paramString1[1], paramString1[2]));
    paramString2 = paramString2.toString();
    if (!a(paramString2, paramString1[0], paramString1[1], paramArrayOfByte)) {
      return new File((String)localObject, str);
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(".dat");
    return new File(paramString1.toString());
  }
  
  public final boolean a(File paramFile)
  {
    return om.b(new File(this.b));
  }
  
  public final byte[] a(String paramString, File paramFile)
  {
    Object localObject = this.b;
    int i = paramString.lastIndexOf(File.separatorChar);
    String str = paramString;
    paramFile = (File)localObject;
    if (i >= 0)
    {
      str = paramString.substring(0, i);
      paramFile = (File)localObject;
      if (!TextUtils.isEmpty(str))
      {
        paramFile = new StringBuilder();
        paramFile.append((String)localObject);
        paramFile.append(File.separator);
        paramFile.append(str);
        paramFile = paramFile.toString();
      }
      str = paramString.substring(i + 1);
    }
    paramString = a(str);
    if (paramString == null) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(a(paramString[0], paramString[1], paramString[2]));
    return a(((StringBuilder)localObject).toString(), paramString[0], paramString[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.iv
 * JD-Core Version:    0.7.0.1
 */