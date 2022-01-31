import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import java.io.File;

public class bekk
{
  public static int a;
  private static long a;
  private static long b;
  private static long c;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public static int a()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        return 0;
      }
      int k = b();
      if (k <= 0) {
        return -1;
      }
      int m = (int)(a() / 100000L);
      if (m <= 0) {
        return -1;
      }
      int n = (int)(b() / 1048576L);
      if (n <= 0) {
        return -1;
      }
      int j = (k * 200 + m * m * 10 + n / 1024 * (n / 1024) * 100) / 400;
      int i = j;
      if (j > 50) {
        i = 50;
      }
      besl.a("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel coreNum:" + k + " cpuFreq:" + m + " ramSize:" + n + " score:" + i);
      return i;
    }
    catch (Throwable localThrowable)
    {
      besl.d("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel error", localThrowable);
    }
    return -1;
  }
  
  public static long a()
  {
    if (jdField_a_of_type_Long == 0L) {
      a();
    }
    return jdField_a_of_type_Long;
  }
  
  private static void a()
  {
    a("cpuinfo_max_freq");
  }
  
  /* Error */
  private static void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 24	bekk:b	()I
    //   3: istore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: iload_1
    //   7: iload_2
    //   8: if_icmpge +312 -> 320
    //   11: new 83	java/io/FileReader
    //   14: dup
    //   15: new 37	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   22: ldc 85
    //   24: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_1
    //   28: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 87
    //   33: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 89	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: astore 6
    //   48: new 91	java/io/BufferedReader
    //   51: dup
    //   52: aload 6
    //   54: sipush 1024
    //   57: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: astore 5
    //   62: aload 5
    //   64: astore 7
    //   66: aload 6
    //   68: astore 9
    //   70: aload 5
    //   72: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: aload 8
    //   79: ifnull +111 -> 190
    //   82: aload 5
    //   84: astore 7
    //   86: aload 6
    //   88: astore 9
    //   90: aload 8
    //   92: invokestatic 103	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   95: lstore_3
    //   96: aload 5
    //   98: astore 7
    //   100: aload 6
    //   102: astore 9
    //   104: getstatic 72	bekk:jdField_a_of_type_Long	J
    //   107: lload_3
    //   108: lcmp
    //   109: ifge +15 -> 124
    //   112: aload 5
    //   114: astore 7
    //   116: aload 6
    //   118: astore 9
    //   120: lload_3
    //   121: putstatic 72	bekk:jdField_a_of_type_Long	J
    //   124: aload 5
    //   126: astore 7
    //   128: aload 6
    //   130: astore 9
    //   132: ldc 35
    //   134: invokestatic 109	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   137: ldc 111
    //   139: iconst_2
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: iload_1
    //   146: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: lload_3
    //   153: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   156: aastore
    //   157: invokestatic 126	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 64	besl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 5
    //   165: ifnull +8 -> 173
    //   168: aload 5
    //   170: invokevirtual 129	java/io/BufferedReader:close	()V
    //   173: aload 6
    //   175: ifnull +8 -> 183
    //   178: aload 6
    //   180: invokevirtual 130	java/io/FileReader:close	()V
    //   183: iload_1
    //   184: iconst_1
    //   185: iadd
    //   186: istore_1
    //   187: goto -181 -> 6
    //   190: lconst_0
    //   191: lstore_3
    //   192: goto -96 -> 96
    //   195: astore 5
    //   197: aload 5
    //   199: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   202: goto -29 -> 173
    //   205: astore 5
    //   207: aload 5
    //   209: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   212: goto -29 -> 183
    //   215: astore 8
    //   217: aload 5
    //   219: astore 7
    //   221: aload 6
    //   223: astore 9
    //   225: aload 8
    //   227: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 129	java/io/BufferedReader:close	()V
    //   240: aload 6
    //   242: ifnull -59 -> 183
    //   245: aload 6
    //   247: invokevirtual 130	java/io/FileReader:close	()V
    //   250: goto -67 -> 183
    //   253: astore 5
    //   255: aload 5
    //   257: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   260: goto -77 -> 183
    //   263: astore 5
    //   265: aload 5
    //   267: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   270: goto -30 -> 240
    //   273: astore_0
    //   274: aload 9
    //   276: astore 6
    //   278: aload 7
    //   280: ifnull +8 -> 288
    //   283: aload 7
    //   285: invokevirtual 129	java/io/BufferedReader:close	()V
    //   288: aload 6
    //   290: ifnull +8 -> 298
    //   293: aload 6
    //   295: invokevirtual 130	java/io/FileReader:close	()V
    //   298: aload_0
    //   299: athrow
    //   300: astore 5
    //   302: aload 5
    //   304: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   307: goto -19 -> 288
    //   310: astore 5
    //   312: aload 5
    //   314: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   317: goto -19 -> 298
    //   320: return
    //   321: astore_0
    //   322: aconst_null
    //   323: astore 7
    //   325: aconst_null
    //   326: astore 6
    //   328: goto -50 -> 278
    //   331: astore_0
    //   332: aconst_null
    //   333: astore 7
    //   335: goto -57 -> 278
    //   338: astore 8
    //   340: aconst_null
    //   341: astore 5
    //   343: aconst_null
    //   344: astore 6
    //   346: goto -129 -> 217
    //   349: astore 8
    //   351: aconst_null
    //   352: astore 5
    //   354: goto -137 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramString	java.lang.String
    //   5	182	1	i	int
    //   3	6	2	j	int
    //   95	97	3	l	long
    //   60	109	5	localBufferedReader	java.io.BufferedReader
    //   195	3	5	localException1	Exception
    //   205	31	5	localException2	Exception
    //   253	3	5	localException3	Exception
    //   263	3	5	localException4	Exception
    //   300	3	5	localException5	Exception
    //   310	3	5	localException6	Exception
    //   341	12	5	localObject1	Object
    //   46	299	6	localObject2	Object
    //   64	270	7	localObject3	Object
    //   75	16	8	str	java.lang.String
    //   215	11	8	localException7	Exception
    //   338	1	8	localException8	Exception
    //   349	1	8	localException9	Exception
    //   68	207	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   168	173	195	java/lang/Exception
    //   178	183	205	java/lang/Exception
    //   70	77	215	java/lang/Exception
    //   90	96	215	java/lang/Exception
    //   104	112	215	java/lang/Exception
    //   120	124	215	java/lang/Exception
    //   132	163	215	java/lang/Exception
    //   245	250	253	java/lang/Exception
    //   235	240	263	java/lang/Exception
    //   70	77	273	finally
    //   90	96	273	finally
    //   104	112	273	finally
    //   120	124	273	finally
    //   132	163	273	finally
    //   225	230	273	finally
    //   283	288	300	java/lang/Exception
    //   293	298	310	java/lang/Exception
    //   11	48	321	finally
    //   48	62	331	finally
    //   11	48	338	java/lang/Exception
    //   48	62	349	java/lang/Exception
  }
  
  public static int b()
  {
    return c();
  }
  
  /* Error */
  public static long b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: getstatic 137	bekk:b	J
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +138 -> 147
    //   12: new 83	java/io/FileReader
    //   15: dup
    //   16: ldc 139
    //   18: invokespecial 89	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 91	java/io/BufferedReader
    //   25: dup
    //   26: aload_1
    //   27: sipush 1024
    //   30: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +24 -> 64
    //   43: aload_2
    //   44: ldc 141
    //   46: invokevirtual 145	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_1
    //   50: aaload
    //   51: invokestatic 148	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   54: invokevirtual 151	java/lang/Long:longValue	()J
    //   57: ldc2_w 152
    //   60: lmul
    //   61: putstatic 137	bekk:b	J
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 129	java/io/BufferedReader:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 130	java/io/FileReader:close	()V
    //   80: getstatic 137	bekk:b	J
    //   83: lconst_0
    //   84: lcmp
    //   85: ifne +62 -> 147
    //   88: ldc2_w 154
    //   91: lreturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: lconst_0
    //   100: putstatic 137	bekk:b	J
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 129	java/io/BufferedReader:close	()V
    //   111: aload_1
    //   112: ifnull -32 -> 80
    //   115: aload_1
    //   116: invokevirtual 130	java/io/FileReader:close	()V
    //   119: goto -39 -> 80
    //   122: astore_0
    //   123: goto -43 -> 80
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 129	java/io/BufferedReader:close	()V
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 130	java/io/FileReader:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: getstatic 137	bekk:b	J
    //   150: lreturn
    //   151: astore_1
    //   152: goto -7 -> 145
    //   155: astore_0
    //   156: goto -27 -> 129
    //   159: astore_3
    //   160: aload_0
    //   161: astore_2
    //   162: aload_3
    //   163: astore_0
    //   164: goto -35 -> 129
    //   167: astore_3
    //   168: aload_0
    //   169: astore_2
    //   170: aload_3
    //   171: astore_0
    //   172: goto -43 -> 129
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -79 -> 99
    //   181: astore_2
    //   182: goto -83 -> 99
    //   185: astore_0
    //   186: goto -106 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	105	0	localObject1	Object
    //   122	1	0	localException1	Exception
    //   126	20	0	localObject2	Object
    //   155	6	0	localObject3	Object
    //   163	9	0	localObject4	Object
    //   175	1	0	localException2	Exception
    //   177	1	0	localObject5	Object
    //   185	1	0	localException3	Exception
    //   21	56	1	localFileReader	java.io.FileReader
    //   92	1	1	localException4	Exception
    //   96	46	1	localObject6	Object
    //   151	1	1	localException5	Exception
    //   1	169	2	localObject7	Object
    //   181	1	2	localException6	Exception
    //   159	4	3	localObject8	Object
    //   167	4	3	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   12	22	92	java/lang/Exception
    //   107	111	122	java/lang/Exception
    //   115	119	122	java/lang/Exception
    //   12	22	126	finally
    //   133	137	151	java/lang/Exception
    //   141	145	151	java/lang/Exception
    //   22	34	155	finally
    //   34	39	159	finally
    //   43	64	159	finally
    //   99	103	167	finally
    //   22	34	175	java/lang/Exception
    //   34	39	181	java/lang/Exception
    //   43	64	181	java/lang/Exception
    //   68	72	185	java/lang/Exception
    //   76	80	185	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public static final int c()
  {
    if (jdField_a_of_type_Int == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label28;
      }
    }
    label28:
    for (jdField_a_of_type_Int = Runtime.getRuntime().availableProcessors();; jdField_a_of_type_Int = d()) {
      return jdField_a_of_type_Int;
    }
  }
  
  /* Error */
  public static long c()
  {
    // Byte code:
    //   0: getstatic 174	bekk:c	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifle +7 -> 12
    //   8: getstatic 174	bekk:c	J
    //   11: lreturn
    //   12: iconst_0
    //   13: istore_0
    //   14: invokestatic 24	bekk:b	()I
    //   17: istore_1
    //   18: getstatic 174	bekk:c	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifgt +126 -> 149
    //   26: iload_0
    //   27: iload_1
    //   28: if_icmpge +121 -> 149
    //   31: aconst_null
    //   32: astore_3
    //   33: new 91	java/io/BufferedReader
    //   36: dup
    //   37: new 83	java/io/FileReader
    //   40: dup
    //   41: new 37	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   48: ldc 85
    //   50: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_0
    //   54: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc 176
    //   59: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 89	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   68: sipush 1024
    //   71: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +20 -> 101
    //   84: aload_3
    //   85: invokestatic 103	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   88: putstatic 174	bekk:c	J
    //   91: getstatic 174	bekk:c	J
    //   94: ldc2_w 152
    //   97: ldiv
    //   98: putstatic 174	bekk:c	J
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 129	java/io/BufferedReader:close	()V
    //   109: iload_0
    //   110: iconst_1
    //   111: iadd
    //   112: istore_0
    //   113: goto -95 -> 18
    //   116: astore_3
    //   117: aload_2
    //   118: ifnull -9 -> 109
    //   121: aload_2
    //   122: invokevirtual 129	java/io/BufferedReader:close	()V
    //   125: goto -16 -> 109
    //   128: astore_2
    //   129: goto -20 -> 109
    //   132: astore 4
    //   134: aload_2
    //   135: astore_3
    //   136: aload 4
    //   138: astore_2
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 129	java/io/BufferedReader:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: ldc 178
    //   151: new 37	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   158: ldc 180
    //   160: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: getstatic 174	bekk:c	J
    //   166: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: ldc 185
    //   171: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_0
    //   175: iconst_1
    //   176: isub
    //   177: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 64	besl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: getstatic 174	bekk:c	J
    //   189: lreturn
    //   190: astore_2
    //   191: goto -82 -> 109
    //   194: astore_3
    //   195: goto -48 -> 147
    //   198: astore_2
    //   199: goto -60 -> 139
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -88 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	164	0	i	int
    //   17	12	1	j	int
    //   74	48	2	localBufferedReader	java.io.BufferedReader
    //   128	7	2	localIOException1	java.io.IOException
    //   138	10	2	localObject1	Object
    //   190	1	2	localIOException2	java.io.IOException
    //   198	1	2	localObject2	Object
    //   202	1	2	localException1	Exception
    //   204	1	2	localObject3	Object
    //   32	53	3	str	java.lang.String
    //   116	1	3	localException2	Exception
    //   135	9	3	localObject4	Object
    //   194	1	3	localIOException3	java.io.IOException
    //   132	5	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   75	80	116	java/lang/Exception
    //   84	101	116	java/lang/Exception
    //   121	125	128	java/io/IOException
    //   75	80	132	finally
    //   84	101	132	finally
    //   105	109	190	java/io/IOException
    //   143	147	194	java/io/IOException
    //   33	75	198	finally
    //   33	75	202	java/lang/Exception
  }
  
  private static final int d()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new bekl()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekk
 * JD-Core Version:    0.7.0.1
 */