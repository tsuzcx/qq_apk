import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class awyq
{
  public static String a;
  public static String b;
  private String c;
  
  public awyq(String paramString)
  {
    this(paramString, 1);
  }
  
  public awyq(String paramString, int paramInt)
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
    long l = Math.min(bhlo.g(), bhlo.h());
    boolean bool = bhlo.d();
    if (bhlo.b() >= 2)
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
    //   50: ifne +51 -> 101
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
    //   79: ifne +22 -> 101
    //   82: aload 6
    //   84: astore 5
    //   86: iconst_0
    //   87: ifeq +11 -> 98
    //   90: new 114	java/lang/NullPointerException
    //   93: dup
    //   94: invokespecial 115	java/lang/NullPointerException:<init>	()V
    //   97: athrow
    //   98: aload 5
    //   100: areturn
    //   101: new 117	java/io/FileInputStream
    //   104: dup
    //   105: aload 5
    //   107: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   110: astore 5
    //   112: aload 5
    //   114: invokevirtual 125	java/io/InputStream:available	()I
    //   117: istore_2
    //   118: iload_2
    //   119: newarray byte
    //   121: astore_1
    //   122: aload 5
    //   124: aload_1
    //   125: invokevirtual 129	java/io/InputStream:read	([B)I
    //   128: istore_3
    //   129: iload_3
    //   130: iload_2
    //   131: if_icmpeq +32 -> 163
    //   134: ldc 31
    //   136: iconst_1
    //   137: new 43	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   144: iload_3
    //   145: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc 134
    //   150: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload_2
    //   154: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: ldc 31
    //   165: iconst_1
    //   166: new 43	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   173: ldc 136
    //   175: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload_3
    //   179: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload 5
    //   190: ifnull +8 -> 198
    //   193: aload 5
    //   195: invokevirtual 139	java/io/InputStream:close	()V
    //   198: aload_1
    //   199: areturn
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_1
    //   203: aload 6
    //   205: astore 5
    //   207: aload_1
    //   208: ifnull -110 -> 98
    //   211: aload_1
    //   212: invokevirtual 139	java/io/InputStream:close	()V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_1
    //   218: aconst_null
    //   219: areturn
    //   220: astore_1
    //   221: aconst_null
    //   222: astore 6
    //   224: aload 7
    //   226: astore_1
    //   227: aload_1
    //   228: astore 5
    //   230: aload 6
    //   232: ifnull -134 -> 98
    //   235: aload 6
    //   237: invokevirtual 139	java/io/InputStream:close	()V
    //   240: aload_1
    //   241: areturn
    //   242: astore 5
    //   244: aload_1
    //   245: areturn
    //   246: astore_1
    //   247: aconst_null
    //   248: areturn
    //   249: astore 5
    //   251: goto -53 -> 198
    //   254: astore_1
    //   255: aload 7
    //   257: astore_1
    //   258: aload 5
    //   260: astore 6
    //   262: goto -35 -> 227
    //   265: astore 6
    //   267: aload 5
    //   269: astore 6
    //   271: goto -44 -> 227
    //   274: astore_1
    //   275: aload 5
    //   277: astore_1
    //   278: goto -75 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	awyq
    //   0	281	1	paramString	String
    //   117	37	2	i	int
    //   128	51	3	j	int
    //   75	3	4	bool	boolean
    //   43	186	5	localObject1	Object
    //   242	1	5	localException1	java.lang.Exception
    //   249	27	5	localException2	java.lang.Exception
    //   4	257	6	localObject2	Object
    //   265	1	6	localObject3	Object
    //   269	1	6	localObject4	Object
    //   1	255	7	localObject5	Object
    //   39	7	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   31	41	200	java/lang/Exception
    //   45	77	200	java/lang/Exception
    //   101	112	200	java/lang/Exception
    //   211	215	217	java/lang/Exception
    //   31	41	220	finally
    //   45	77	220	finally
    //   101	112	220	finally
    //   235	240	242	java/lang/Exception
    //   90	98	246	java/lang/Exception
    //   193	198	249	java/lang/Exception
    //   112	122	254	finally
    //   122	129	265	finally
    //   134	163	265	finally
    //   163	188	265	finally
    //   112	122	274	java/lang/Exception
    //   122	129	274	java/lang/Exception
    //   134	163	274	java/lang/Exception
    //   163	188	274	java/lang/Exception
  }
  
  public awyk a(String paramString1, String paramString2)
  {
    awyk localawyk = new awyk();
    localawyk.b = a(this.c + a + File.separator + paramString1);
    localawyk.a = a(this.c + a + File.separator + paramString2);
    return localawyk;
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
    //   0	250	0	this	awyq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyq
 * JD-Core Version:    0.7.0.1
 */