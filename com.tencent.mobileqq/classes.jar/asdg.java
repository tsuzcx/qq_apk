import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class asdg
{
  public static String a;
  public static String b;
  private String c;
  
  public asdg(String paramString)
  {
    this(paramString, 1);
  }
  
  public asdg(String paramString, int paramInt)
  {
    this.c = paramString;
    a(paramInt);
  }
  
  public static String a()
  {
    return a(1);
  }
  
  public static String a(int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceResLoader", 2, "func getVideoPath begins.");
    }
    if ((b != null) && (paramInt == 1))
    {
      a = b;
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[1]. videoPath:" + a);
      }
      return a;
    }
    if ((paramInt == 2) || (paramInt == 3))
    {
      a = "video";
      return a;
    }
    long l = Math.min(bbdh.g(), bbdh.h());
    boolean bool = bbdh.d();
    if (bbdh.b() >= 2)
    {
      paramInt = i;
      if (l < 852L) {
        break label199;
      }
      if (!bool) {
        break label179;
      }
      a = "sbig";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[2]. videoPath:" + a);
      }
      b = a;
      return a;
      paramInt = 0;
      break;
      label179:
      if (paramInt != 0)
      {
        a = "xbig";
      }
      else
      {
        a = "big";
        continue;
        label199:
        if (l >= 640L)
        {
          if (paramInt != 0) {
            a = "xbig";
          } else {
            a = "big";
          }
        }
        else if (l >= 480L) {
          a = "big";
        } else {
          a = "small";
        }
      }
    }
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 31
    //   8: iconst_1
    //   9: new 43	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   16: ldc 96
    //   18: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: new 101	java/io/File
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 8
    //   41: aload 8
    //   43: astore 5
    //   45: aload 8
    //   47: invokevirtual 106	java/io/File:exists	()Z
    //   50: ifne +47 -> 97
    //   53: new 101	java/io/File
    //   56: dup
    //   57: aload_1
    //   58: ldc 83
    //   60: ldc 85
    //   62: invokevirtual 112	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 5
    //   70: aload 5
    //   72: invokevirtual 106	java/io/File:exists	()Z
    //   75: istore 4
    //   77: iload 4
    //   79: ifne +18 -> 97
    //   82: iconst_0
    //   83: ifeq +11 -> 94
    //   86: new 114	java/lang/NullPointerException
    //   89: dup
    //   90: invokespecial 115	java/lang/NullPointerException:<init>	()V
    //   93: athrow
    //   94: aload 6
    //   96: areturn
    //   97: new 117	java/io/FileInputStream
    //   100: dup
    //   101: aload 5
    //   103: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: astore 5
    //   108: aload 5
    //   110: invokevirtual 125	java/io/InputStream:available	()I
    //   113: istore_3
    //   114: iload_3
    //   115: newarray byte
    //   117: astore_1
    //   118: aload 5
    //   120: aload_1
    //   121: invokevirtual 129	java/io/InputStream:read	([B)I
    //   124: istore_2
    //   125: iload_2
    //   126: iload_3
    //   127: if_icmpeq +32 -> 159
    //   130: ldc 31
    //   132: iconst_1
    //   133: new 43	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   140: iload_2
    //   141: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc 134
    //   146: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload_3
    //   150: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: ldc 31
    //   161: iconst_1
    //   162: new 43	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   169: ldc 136
    //   171: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_2
    //   175: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 5
    //   186: ifnull +8 -> 194
    //   189: aload 5
    //   191: invokevirtual 139	java/io/InputStream:close	()V
    //   194: aload_1
    //   195: areturn
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull -106 -> 94
    //   203: aload_1
    //   204: invokevirtual 139	java/io/InputStream:close	()V
    //   207: aconst_null
    //   208: areturn
    //   209: astore_1
    //   210: aconst_null
    //   211: areturn
    //   212: astore_1
    //   213: aconst_null
    //   214: astore 5
    //   216: aload 7
    //   218: astore_1
    //   219: aload_1
    //   220: astore 6
    //   222: aload 5
    //   224: ifnull -130 -> 94
    //   227: aload 5
    //   229: invokevirtual 139	java/io/InputStream:close	()V
    //   232: aload_1
    //   233: areturn
    //   234: astore 5
    //   236: aload_1
    //   237: areturn
    //   238: astore_1
    //   239: aconst_null
    //   240: areturn
    //   241: astore 5
    //   243: goto -49 -> 194
    //   246: astore_1
    //   247: aload 7
    //   249: astore_1
    //   250: goto -31 -> 219
    //   253: astore 6
    //   255: goto -36 -> 219
    //   258: astore_1
    //   259: aload 5
    //   261: astore_1
    //   262: goto -63 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	asdg
    //   0	265	1	paramString	String
    //   124	51	2	i	int
    //   113	37	3	j	int
    //   75	3	4	bool	boolean
    //   43	185	5	localObject1	Object
    //   234	1	5	localException1	java.lang.Exception
    //   241	19	5	localException2	java.lang.Exception
    //   4	217	6	localObject2	Object
    //   253	1	6	localObject3	Object
    //   1	247	7	localObject4	Object
    //   39	7	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   31	41	196	java/lang/Exception
    //   45	77	196	java/lang/Exception
    //   97	108	196	java/lang/Exception
    //   203	207	209	java/lang/Exception
    //   31	41	212	finally
    //   45	77	212	finally
    //   97	108	212	finally
    //   227	232	234	java/lang/Exception
    //   86	94	238	java/lang/Exception
    //   189	194	241	java/lang/Exception
    //   108	118	246	finally
    //   118	125	253	finally
    //   130	159	253	finally
    //   159	184	253	finally
    //   108	118	258	java/lang/Exception
    //   118	125	258	java/lang/Exception
    //   130	159	258	java/lang/Exception
    //   159	184	258	java/lang/Exception
  }
  
  public asda a(String paramString1, String paramString2)
  {
    asda localasda = new asda();
    localasda.b = a(this.c + a + File.separator + paramString1);
    localasda.a = a(this.c + a + File.separator + paramString2);
    return localasda;
  }
  
  public String a(String paramString)
  {
    return c(this.c + a + File.separator + paramString);
  }
  
  public String b(String paramString)
  {
    return this.c + "audio" + File.separator + paramString;
  }
  
  /* Error */
  public String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 101	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: aload 5
    //   18: astore_3
    //   19: aload 5
    //   21: invokevirtual 106	java/io/File:exists	()Z
    //   24: ifne +45 -> 69
    //   27: new 101	java/io/File
    //   30: dup
    //   31: aload_1
    //   32: ldc 83
    //   34: ldc 85
    //   36: invokevirtual 112	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   39: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 106	java/io/File:exists	()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +20 -> 69
    //   52: aload 4
    //   54: astore_1
    //   55: iconst_0
    //   56: ifeq +11 -> 67
    //   59: new 114	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 115	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: aload_1
    //   68: areturn
    //   69: new 117	java/io/FileInputStream
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore 4
    //   79: aload 4
    //   81: astore_1
    //   82: aload 4
    //   84: invokevirtual 125	java/io/InputStream:available	()I
    //   87: newarray byte
    //   89: astore_3
    //   90: aload 4
    //   92: astore_1
    //   93: aload 4
    //   95: aload_3
    //   96: invokevirtual 129	java/io/InputStream:read	([B)I
    //   99: pop
    //   100: aload 4
    //   102: astore_1
    //   103: new 108	java/lang/String
    //   106: dup
    //   107: aload_3
    //   108: ldc 160
    //   110: invokespecial 163	java/lang/String:<init>	([BLjava/lang/String;)V
    //   113: astore_3
    //   114: aload 4
    //   116: astore_1
    //   117: aload_3
    //   118: ldc 165
    //   120: ldc 167
    //   122: invokevirtual 171	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 5
    //   129: astore_3
    //   130: aload_3
    //   131: astore_1
    //   132: aload 4
    //   134: ifnull -67 -> 67
    //   137: aload 4
    //   139: invokevirtual 139	java/io/InputStream:close	()V
    //   142: aload_3
    //   143: areturn
    //   144: astore_1
    //   145: aload_3
    //   146: areturn
    //   147: astore 5
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 6
    //   154: astore_3
    //   155: aload 4
    //   157: astore_1
    //   158: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +35 -> 196
    //   164: aload 4
    //   166: astore_1
    //   167: ldc 31
    //   169: iconst_2
    //   170: new 43	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   177: ldc 173
    //   179: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 5
    //   184: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_3
    //   197: astore_1
    //   198: aload 4
    //   200: ifnull -133 -> 67
    //   203: aload 4
    //   205: invokevirtual 139	java/io/InputStream:close	()V
    //   208: aload_3
    //   209: areturn
    //   210: astore_1
    //   211: aload_3
    //   212: areturn
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 139	java/io/InputStream:close	()V
    //   224: aload_3
    //   225: athrow
    //   226: astore_1
    //   227: aconst_null
    //   228: areturn
    //   229: astore_1
    //   230: goto -6 -> 224
    //   233: astore_3
    //   234: goto -18 -> 216
    //   237: astore 5
    //   239: aload 6
    //   241: astore_3
    //   242: goto -87 -> 155
    //   245: astore 5
    //   247: goto -92 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	asdg
    //   0	250	1	paramString	String
    //   47	2	2	bool	boolean
    //   18	194	3	localObject1	Object
    //   213	12	3	localObject2	Object
    //   233	1	3	localObject3	Object
    //   241	1	3	localObject4	Object
    //   4	200	4	localFileInputStream	java.io.FileInputStream
    //   14	114	5	localObject5	Object
    //   147	36	5	localException1	java.lang.Exception
    //   237	1	5	localException2	java.lang.Exception
    //   245	1	5	localException3	java.lang.Exception
    //   1	239	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   137	142	144	java/lang/Exception
    //   6	16	147	java/lang/Exception
    //   19	48	147	java/lang/Exception
    //   69	79	147	java/lang/Exception
    //   203	208	210	java/lang/Exception
    //   6	16	213	finally
    //   19	48	213	finally
    //   69	79	213	finally
    //   59	67	226	java/lang/Exception
    //   220	224	229	java/lang/Exception
    //   82	90	233	finally
    //   93	100	233	finally
    //   103	114	233	finally
    //   117	127	233	finally
    //   158	164	233	finally
    //   167	196	233	finally
    //   82	90	237	java/lang/Exception
    //   93	100	237	java/lang/Exception
    //   103	114	237	java/lang/Exception
    //   117	127	245	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asdg
 * JD-Core Version:    0.7.0.1
 */