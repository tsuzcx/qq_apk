import android.os.Environment;
import java.io.File;

public class atdc
{
  public static String a()
  {
    return c() + "now_download_temp_QQ.apk";
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (!paramString.getParentFile().exists()) {
        a(paramString.getParent());
      }
      paramString.mkdir();
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || ("".equalsIgnoreCase(paramString))) {
      return false;
    }
    return new File(paramString).delete();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!"com.tencent.now".equals(paramString2)) {}
    while (!b(b())) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_1
    //   8: iconst_0
    //   9: istore 5
    //   11: ldc 60
    //   13: aload_2
    //   14: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokestatic 69	atdc:b	(Ljava/lang/String;)Z
    //   26: ifeq -6 -> 20
    //   29: invokestatic 67	atdc:b	()Ljava/lang/String;
    //   32: invokestatic 69	atdc:b	(Ljava/lang/String;)Z
    //   35: ifeq +5 -> 40
    //   38: iconst_1
    //   39: ireturn
    //   40: invokestatic 76	atdc:a	()Ljava/lang/String;
    //   43: astore 8
    //   45: aload 8
    //   47: invokestatic 69	atdc:b	(Ljava/lang/String;)Z
    //   50: ifeq +9 -> 59
    //   53: aload 8
    //   55: invokestatic 78	atdc:a	(Ljava/lang/String;)Z
    //   58: pop
    //   59: new 28	java/io/File
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore_0
    //   68: new 28	java/io/File
    //   71: dup
    //   72: aload 8
    //   74: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore_2
    //   78: aload_2
    //   79: invokevirtual 81	java/io/File:createNewFile	()Z
    //   82: pop
    //   83: new 83	java/io/FileInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_0
    //   92: new 88	java/io/FileOutputStream
    //   95: dup
    //   96: aload_2
    //   97: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   100: astore_1
    //   101: sipush 1024
    //   104: newarray byte
    //   106: astore_2
    //   107: aload_0
    //   108: aload_2
    //   109: invokevirtual 95	java/io/InputStream:read	([B)I
    //   112: istore_3
    //   113: iload_3
    //   114: iconst_m1
    //   115: if_icmpeq +58 -> 173
    //   118: aload_1
    //   119: aload_2
    //   120: iconst_0
    //   121: iload_3
    //   122: invokevirtual 101	java/io/OutputStream:write	([BII)V
    //   125: goto -18 -> 107
    //   128: astore_2
    //   129: aload_1
    //   130: astore_2
    //   131: aload_0
    //   132: astore_1
    //   133: aload_2
    //   134: astore_0
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 104	java/io/OutputStream:close	()V
    //   143: iload 5
    //   145: istore 4
    //   147: aload_1
    //   148: ifnull +11 -> 159
    //   151: aload_1
    //   152: invokevirtual 105	java/io/InputStream:close	()V
    //   155: iload 5
    //   157: istore 4
    //   159: iload 4
    //   161: ifne +134 -> 295
    //   164: aload 8
    //   166: invokestatic 78	atdc:a	(Ljava/lang/String;)Z
    //   169: pop
    //   170: iload 4
    //   172: ireturn
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 104	java/io/OutputStream:close	()V
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 105	java/io/InputStream:close	()V
    //   189: iconst_1
    //   190: istore 4
    //   192: goto -33 -> 159
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   200: iconst_1
    //   201: istore 4
    //   203: goto -44 -> 159
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   211: iload 5
    //   213: istore 4
    //   215: goto -56 -> 159
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_0
    //   221: aload 7
    //   223: astore_1
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 104	java/io/OutputStream:close	()V
    //   232: iload 5
    //   234: istore 4
    //   236: aload_0
    //   237: ifnull -78 -> 159
    //   240: aload_0
    //   241: invokevirtual 105	java/io/InputStream:close	()V
    //   244: iload 5
    //   246: istore 4
    //   248: goto -89 -> 159
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   256: iload 5
    //   258: istore 4
    //   260: goto -101 -> 159
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_0
    //   266: aload 6
    //   268: astore_2
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 104	java/io/OutputStream:close	()V
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 105	java/io/InputStream:close	()V
    //   285: aload_1
    //   286: athrow
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   292: goto -7 -> 285
    //   295: aload 8
    //   297: invokestatic 67	atdc:b	()Ljava/lang/String;
    //   300: invokestatic 110	atdc:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   303: pop
    //   304: iload 4
    //   306: ireturn
    //   307: astore_0
    //   308: iconst_0
    //   309: ireturn
    //   310: astore_1
    //   311: aload 6
    //   313: astore_2
    //   314: goto -45 -> 269
    //   317: astore 6
    //   319: aload_1
    //   320: astore_2
    //   321: aload 6
    //   323: astore_1
    //   324: goto -55 -> 269
    //   327: astore_1
    //   328: aload 7
    //   330: astore_1
    //   331: goto -107 -> 224
    //   334: astore_2
    //   335: goto -111 -> 224
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -206 -> 135
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_2
    //   347: aload_0
    //   348: astore_1
    //   349: aload_2
    //   350: astore_0
    //   351: goto -216 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramString1	String
    //   0	354	1	paramString2	String
    //   0	354	2	paramString3	String
    //   112	10	3	i	int
    //   145	160	4	bool1	boolean
    //   9	248	5	bool2	boolean
    //   4	308	6	localObject1	Object
    //   317	5	6	localObject2	Object
    //   1	328	7	localObject3	Object
    //   43	253	8	str	String
    // Exception table:
    //   from	to	target	type
    //   101	107	128	java/io/FileNotFoundException
    //   107	113	128	java/io/FileNotFoundException
    //   118	125	128	java/io/FileNotFoundException
    //   177	181	195	java/io/IOException
    //   185	189	195	java/io/IOException
    //   139	143	206	java/io/IOException
    //   151	155	206	java/io/IOException
    //   83	92	218	java/io/IOException
    //   228	232	251	java/io/IOException
    //   240	244	251	java/io/IOException
    //   83	92	263	finally
    //   273	277	287	java/io/IOException
    //   281	285	287	java/io/IOException
    //   78	83	307	java/io/IOException
    //   92	101	310	finally
    //   101	107	317	finally
    //   107	113	317	finally
    //   118	125	317	finally
    //   92	101	327	java/io/IOException
    //   101	107	334	java/io/IOException
    //   107	113	334	java/io/IOException
    //   118	125	334	java/io/IOException
    //   83	92	338	java/io/FileNotFoundException
    //   92	101	344	java/io/FileNotFoundException
  }
  
  public static String b()
  {
    return c() + "now_download_common.apk";
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString == null) || ("".equalsIgnoreCase(paramString))) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if (!b(paramString1)) {
      return false;
    }
    return new File(paramString1).renameTo(new File(paramString2));
  }
  
  private static String c()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/now/";
    a(str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdc
 * JD-Core Version:    0.7.0.1
 */