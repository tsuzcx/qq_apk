package com.huawei.updatesdk.a.a.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public abstract class d
{
  /* Error */
  public static java.lang.String a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: invokestatic 22	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +10 -> 20
    //   13: aload 6
    //   15: astore 5
    //   17: aload 5
    //   19: areturn
    //   20: aload_1
    //   21: invokestatic 28	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   24: astore 7
    //   26: new 30	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: sipush 1024
    //   40: newarray byte
    //   42: astore 8
    //   44: lconst_0
    //   45: lstore_3
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: aload 8
    //   51: invokevirtual 38	java/io/FileInputStream:read	([B)I
    //   54: istore_2
    //   55: iload_2
    //   56: iconst_m1
    //   57: if_icmpeq +22 -> 79
    //   60: aload_1
    //   61: astore_0
    //   62: aload 7
    //   64: aload 8
    //   66: iconst_0
    //   67: iload_2
    //   68: invokevirtual 42	java/security/MessageDigest:update	([BII)V
    //   71: lload_3
    //   72: iload_2
    //   73: i2l
    //   74: ladd
    //   75: lstore_3
    //   76: goto -30 -> 46
    //   79: aload 5
    //   81: astore_0
    //   82: lload_3
    //   83: lconst_0
    //   84: lcmp
    //   85: ifle +18 -> 103
    //   88: aload_1
    //   89: astore_0
    //   90: aload 7
    //   92: invokevirtual 46	java/security/MessageDigest:digest	()[B
    //   95: invokestatic 51	com/huawei/updatesdk/a/a/c/b:a	([B)Ljava/lang/String;
    //   98: astore 5
    //   100: aload 5
    //   102: astore_0
    //   103: aload_0
    //   104: astore 5
    //   106: aload_1
    //   107: ifnull -90 -> 17
    //   110: aload_1
    //   111: invokevirtual 55	java/io/FileInputStream:close	()V
    //   114: aload_0
    //   115: areturn
    //   116: astore_1
    //   117: ldc 57
    //   119: ldc 59
    //   121: invokestatic 65	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: areturn
    //   126: astore 5
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: astore_0
    //   132: ldc 57
    //   134: ldc 67
    //   136: aload 5
    //   138: invokestatic 70	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload 6
    //   143: astore 5
    //   145: aload_1
    //   146: ifnull -129 -> 17
    //   149: aload_1
    //   150: invokevirtual 55	java/io/FileInputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: ldc 57
    //   158: ldc 59
    //   160: invokestatic 65	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: astore_0
    //   171: ldc 57
    //   173: ldc 72
    //   175: aload 5
    //   177: invokestatic 70	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: aload 6
    //   182: astore 5
    //   184: aload_1
    //   185: ifnull -168 -> 17
    //   188: aload_1
    //   189: invokevirtual 55	java/io/FileInputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: ldc 57
    //   197: ldc 59
    //   199: invokestatic 65	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aconst_null
    //   203: areturn
    //   204: astore 5
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: astore_0
    //   210: ldc 57
    //   212: ldc 74
    //   214: aload 5
    //   216: invokestatic 70	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload 6
    //   221: astore 5
    //   223: aload_1
    //   224: ifnull -207 -> 17
    //   227: aload_1
    //   228: invokevirtual 55	java/io/FileInputStream:close	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: ldc 57
    //   236: ldc 59
    //   238: invokestatic 65	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aconst_null
    //   242: areturn
    //   243: astore 5
    //   245: aconst_null
    //   246: astore_1
    //   247: aload_1
    //   248: astore_0
    //   249: ldc 57
    //   251: ldc 76
    //   253: aload 5
    //   255: invokestatic 70	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload 6
    //   260: astore 5
    //   262: aload_1
    //   263: ifnull -246 -> 17
    //   266: aload_1
    //   267: invokevirtual 55	java/io/FileInputStream:close	()V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_0
    //   273: ldc 57
    //   275: ldc 59
    //   277: invokestatic 65	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aconst_null
    //   281: areturn
    //   282: astore 5
    //   284: aconst_null
    //   285: astore_1
    //   286: aload_1
    //   287: astore_0
    //   288: ldc 57
    //   290: ldc 78
    //   292: aload 5
    //   294: invokestatic 70	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   297: aload 6
    //   299: astore 5
    //   301: aload_1
    //   302: ifnull -285 -> 17
    //   305: aload_1
    //   306: invokevirtual 55	java/io/FileInputStream:close	()V
    //   309: aconst_null
    //   310: areturn
    //   311: astore_0
    //   312: ldc 57
    //   314: ldc 59
    //   316: invokestatic 65	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: astore_1
    //   322: aconst_null
    //   323: astore_0
    //   324: aload_0
    //   325: ifnull +7 -> 332
    //   328: aload_0
    //   329: invokevirtual 55	java/io/FileInputStream:close	()V
    //   332: aload_1
    //   333: athrow
    //   334: astore_0
    //   335: ldc 57
    //   337: ldc 59
    //   339: invokestatic 65	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: goto -10 -> 332
    //   345: astore_1
    //   346: goto -22 -> 324
    //   349: astore 5
    //   351: goto -65 -> 286
    //   354: astore 5
    //   356: goto -109 -> 247
    //   359: astore 5
    //   361: goto -153 -> 208
    //   364: astore 5
    //   366: goto -197 -> 169
    //   369: astore 5
    //   371: goto -241 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramString1	java.lang.String
    //   0	374	1	paramString2	java.lang.String
    //   54	19	2	i	int
    //   45	38	3	l	long
    //   1	104	5	localObject1	Object
    //   126	11	5	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   143	1	5	localObject2	Object
    //   165	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   182	1	5	localObject3	Object
    //   204	11	5	localIOException1	IOException
    //   221	1	5	localObject4	Object
    //   243	11	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   260	1	5	localObject5	Object
    //   282	11	5	localIndexOutOfBoundsException1	java.lang.IndexOutOfBoundsException
    //   299	1	5	localObject6	Object
    //   349	1	5	localIndexOutOfBoundsException2	java.lang.IndexOutOfBoundsException
    //   354	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   359	1	5	localIOException2	IOException
    //   364	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   369	1	5	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   4	294	6	localObject7	Object
    //   24	67	7	localMessageDigest	java.security.MessageDigest
    //   42	23	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   110	114	116	java/io/IOException
    //   20	35	126	java/security/NoSuchAlgorithmException
    //   149	153	155	java/io/IOException
    //   20	35	165	java/io/FileNotFoundException
    //   188	192	194	java/io/IOException
    //   20	35	204	java/io/IOException
    //   227	231	233	java/io/IOException
    //   20	35	243	java/lang/IllegalArgumentException
    //   266	270	272	java/io/IOException
    //   20	35	282	java/lang/IndexOutOfBoundsException
    //   305	309	311	java/io/IOException
    //   20	35	321	finally
    //   328	332	334	java/io/IOException
    //   37	44	345	finally
    //   48	55	345	finally
    //   62	71	345	finally
    //   90	100	345	finally
    //   132	141	345	finally
    //   171	180	345	finally
    //   210	219	345	finally
    //   249	258	345	finally
    //   288	297	345	finally
    //   37	44	349	java/lang/IndexOutOfBoundsException
    //   48	55	349	java/lang/IndexOutOfBoundsException
    //   62	71	349	java/lang/IndexOutOfBoundsException
    //   90	100	349	java/lang/IndexOutOfBoundsException
    //   37	44	354	java/lang/IllegalArgumentException
    //   48	55	354	java/lang/IllegalArgumentException
    //   62	71	354	java/lang/IllegalArgumentException
    //   90	100	354	java/lang/IllegalArgumentException
    //   37	44	359	java/io/IOException
    //   48	55	359	java/io/IOException
    //   62	71	359	java/io/IOException
    //   90	100	359	java/io/IOException
    //   37	44	364	java/io/FileNotFoundException
    //   48	55	364	java/io/FileNotFoundException
    //   62	71	364	java/io/FileNotFoundException
    //   90	100	364	java/io/FileNotFoundException
    //   37	44	369	java/security/NoSuchAlgorithmException
    //   48	55	369	java/security/NoSuchAlgorithmException
    //   62	71	369	java/security/NoSuchAlgorithmException
    //   90	100	369	java/security/NoSuchAlgorithmException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      a.a("FileUtil", "Closeable exception", paramCloseable);
    }
  }
  
  public static boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return true;
    }
    if (paramFile.isFile()) {
      return paramFile.delete();
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i = 0;
      int j = arrayOfFile.length;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.d
 * JD-Core Version:    0.7.0.1
 */