import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bcfn
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  String c;
  String d;
  String e;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString = "";
  int g;
  int h;
  int i;
  int j;
  int k;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 4;
    jdField_d_of_type_Int = 8;
    jdField_e_of_type_Int = 16;
  }
  
  public bcfn()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  static int a()
  {
    try
    {
      int m = new File("/sys/devices/system/cpu/").listFiles(new bcfo()).length;
      return m;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if ("arm64-v8a".equalsIgnoreCase(paramString)) {
        return jdField_c_of_type_Int;
      }
      if ("armeabi-v7a".equalsIgnoreCase(paramString)) {
        return jdField_b_of_type_Int;
      }
      if (("armeabi".equalsIgnoreCase(paramString)) || (paramString.indexOf("arm") >= 0)) {
        return jdField_a_of_type_Int;
      }
      if (("x86".equalsIgnoreCase(paramString)) || (paramString.indexOf("x86") >= 0)) {
        return jdField_d_of_type_Int;
      }
    } while ((!"mips".equalsIgnoreCase(paramString)) && (paramString.indexOf("mips") < 0));
    return jdField_e_of_type_Int;
  }
  
  /* Error */
  static long a()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: new 97	java/io/BufferedReader
    //   8: dup
    //   9: new 99	java/io/FileReader
    //   12: dup
    //   13: ldc 101
    //   15: invokespecial 102	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 7
    //   23: lload_3
    //   24: lstore_1
    //   25: aload 7
    //   27: ifnull +92 -> 119
    //   30: aload 7
    //   32: astore 5
    //   34: aload 7
    //   36: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore 6
    //   41: aload 6
    //   43: ifnull +217 -> 260
    //   46: aload 7
    //   48: astore 5
    //   50: aload 7
    //   52: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 9
    //   57: aload 6
    //   59: astore 8
    //   61: aload 9
    //   63: astore 6
    //   65: goto -24 -> 41
    //   68: lload_3
    //   69: lstore_1
    //   70: iload_0
    //   71: iconst_m1
    //   72: if_icmpeq +47 -> 119
    //   75: aload 7
    //   77: astore 5
    //   79: aload 8
    //   81: iconst_0
    //   82: iload_0
    //   83: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   86: astore 6
    //   88: lload_3
    //   89: lstore_1
    //   90: aload 6
    //   92: ifnull +27 -> 119
    //   95: lload_3
    //   96: lstore_1
    //   97: aload 7
    //   99: astore 5
    //   101: aload 6
    //   103: invokevirtual 116	java/lang/String:length	()I
    //   106: ifle +13 -> 119
    //   109: aload 7
    //   111: astore 5
    //   113: aload 6
    //   115: invokestatic 122	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   118: lstore_1
    //   119: lload_1
    //   120: lstore_3
    //   121: aload 7
    //   123: ifnull +10 -> 133
    //   126: aload 7
    //   128: invokevirtual 125	java/io/BufferedReader:close	()V
    //   131: lload_1
    //   132: lstore_3
    //   133: lload_3
    //   134: lreturn
    //   135: aload 7
    //   137: astore 5
    //   139: aload 8
    //   141: bipush 9
    //   143: invokevirtual 128	java/lang/String:indexOf	(I)I
    //   146: istore_0
    //   147: goto -79 -> 68
    //   150: astore 5
    //   152: aload 5
    //   154: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   157: lload_1
    //   158: lreturn
    //   159: astore 8
    //   161: aconst_null
    //   162: astore 6
    //   164: aload 6
    //   166: astore 5
    //   168: ldc 133
    //   170: iconst_1
    //   171: new 135	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   178: ldc 138
    //   180: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 8
    //   185: invokevirtual 145	java/lang/Exception:toString	()Ljava/lang/String;
    //   188: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload 6
    //   199: ifnull -66 -> 133
    //   202: aload 6
    //   204: invokevirtual 125	java/io/BufferedReader:close	()V
    //   207: lconst_0
    //   208: lreturn
    //   209: astore 5
    //   211: aload 5
    //   213: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   216: lconst_0
    //   217: lreturn
    //   218: astore 6
    //   220: aconst_null
    //   221: astore 5
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 125	java/io/BufferedReader:close	()V
    //   233: aload 6
    //   235: athrow
    //   236: astore 5
    //   238: aload 5
    //   240: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   243: goto -10 -> 233
    //   246: astore 6
    //   248: goto -25 -> 223
    //   251: astore 8
    //   253: aload 7
    //   255: astore 6
    //   257: goto -93 -> 164
    //   260: aload 8
    //   262: ifnonnull -127 -> 135
    //   265: iconst_m1
    //   266: istore_0
    //   267: goto -199 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   70	197	0	m	int
    //   24	134	1	l1	long
    //   1	133	3	l2	long
    //   32	106	5	localBufferedReader1	java.io.BufferedReader
    //   150	3	5	localIOException1	java.io.IOException
    //   166	1	5	localObject1	Object
    //   209	3	5	localIOException2	java.io.IOException
    //   221	8	5	localObject2	Object
    //   236	3	5	localIOException3	java.io.IOException
    //   39	164	6	localObject3	Object
    //   218	16	6	localObject4	Object
    //   246	1	6	localObject5	Object
    //   255	1	6	localBufferedReader2	java.io.BufferedReader
    //   21	233	7	localBufferedReader3	java.io.BufferedReader
    //   3	137	8	localObject6	Object
    //   159	25	8	localException1	Exception
    //   251	10	8	localException2	Exception
    //   55	7	9	str	String
    // Exception table:
    //   from	to	target	type
    //   126	131	150	java/io/IOException
    //   5	23	159	java/lang/Exception
    //   202	207	209	java/io/IOException
    //   5	23	218	finally
    //   228	233	236	java/io/IOException
    //   34	41	246	finally
    //   50	57	246	finally
    //   79	88	246	finally
    //   101	109	246	finally
    //   113	119	246	finally
    //   139	147	246	finally
    //   168	197	246	finally
    //   34	41	251	java/lang/Exception
    //   50	57	251	java/lang/Exception
    //   79	88	251	java/lang/Exception
    //   101	109	251	java/lang/Exception
    //   113	119	251	java/lang/Exception
    //   139	147	251	java/lang/Exception
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 157	bcfn:jdField_b_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 10
    //   11: new 135	java/lang/StringBuilder
    //   14: dup
    //   15: sipush 1024
    //   18: invokespecial 160	java/lang/StringBuilder:<init>	(I)V
    //   21: pop
    //   22: ldc2_w 161
    //   25: lstore 5
    //   27: ldc 163
    //   29: fstore_1
    //   30: new 97	java/io/BufferedReader
    //   33: dup
    //   34: new 99	java/io/FileReader
    //   37: dup
    //   38: ldc 165
    //   40: invokespecial 102	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 9
    //   48: aload 9
    //   50: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 10
    //   55: aload 10
    //   57: ifnonnull +78 -> 135
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 157	bcfn:jdField_b_of_type_Boolean	Z
    //   65: lload 5
    //   67: lstore 7
    //   69: fload_1
    //   70: fstore_2
    //   71: aload 9
    //   73: ifnull +14 -> 87
    //   76: aload 9
    //   78: invokevirtual 125	java/io/BufferedReader:close	()V
    //   81: fload_1
    //   82: fstore_2
    //   83: lload 5
    //   85: lstore 7
    //   87: aload_0
    //   88: getfield 157	bcfn:jdField_b_of_type_Boolean	Z
    //   91: ifeq -84 -> 7
    //   94: invokestatic 167	bcfn:a	()I
    //   97: istore_3
    //   98: iload_3
    //   99: ifle +736 -> 835
    //   102: aload_0
    //   103: iload_3
    //   104: putfield 169	bcfn:k	I
    //   107: aload_0
    //   108: invokespecial 171	bcfn:b	()J
    //   111: lstore 5
    //   113: lload 5
    //   115: lconst_0
    //   116: lcmp
    //   117: ifle +737 -> 854
    //   120: aload_0
    //   121: lload 5
    //   123: putfield 173	bcfn:jdField_a_of_type_Long	J
    //   126: return
    //   127: astore 9
    //   129: aload 9
    //   131: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   134: return
    //   135: aload 10
    //   137: ldc 176
    //   139: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq +104 -> 246
    //   145: aload 10
    //   147: bipush 58
    //   149: invokevirtual 128	java/lang/String:indexOf	(I)I
    //   152: istore_3
    //   153: iload_3
    //   154: iconst_1
    //   155: if_icmple -107 -> 48
    //   158: aload_0
    //   159: aload 10
    //   161: iload_3
    //   162: iconst_1
    //   163: iadd
    //   164: aload 10
    //   166: invokevirtual 116	java/lang/String:length	()I
    //   169: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: putfield 41	bcfn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 41	bcfn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   180: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   183: putfield 41	bcfn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 41	bcfn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   191: getstatic 188	java/util/Locale:US	Ljava/util/Locale;
    //   194: invokevirtual 192	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   197: putfield 41	bcfn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   200: goto -152 -> 48
    //   203: astore 10
    //   205: lload 5
    //   207: lstore 7
    //   209: fload_1
    //   210: fstore_2
    //   211: aload 9
    //   213: ifnull -126 -> 87
    //   216: aload 9
    //   218: invokevirtual 125	java/io/BufferedReader:close	()V
    //   221: lload 5
    //   223: lstore 7
    //   225: fload_1
    //   226: fstore_2
    //   227: goto -140 -> 87
    //   230: astore 9
    //   232: aload 9
    //   234: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   237: lload 5
    //   239: lstore 7
    //   241: fload_1
    //   242: fstore_2
    //   243: goto -156 -> 87
    //   246: aload 10
    //   248: ldc 194
    //   250: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   253: ifeq +187 -> 440
    //   256: aload 10
    //   258: bipush 58
    //   260: invokevirtual 128	java/lang/String:indexOf	(I)I
    //   263: istore_3
    //   264: iload_3
    //   265: iconst_1
    //   266: if_icmple +50 -> 316
    //   269: aload 10
    //   271: iload_3
    //   272: iconst_1
    //   273: iadd
    //   274: aload 10
    //   276: invokevirtual 116	java/lang/String:length	()I
    //   279: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   282: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   285: astore 11
    //   287: aload 11
    //   289: ifnull +27 -> 316
    //   292: aload 11
    //   294: invokevirtual 116	java/lang/String:length	()I
    //   297: ifle +19 -> 316
    //   300: aload 11
    //   302: ldc 196
    //   304: invokevirtual 79	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   307: ifeq +70 -> 377
    //   310: aload_0
    //   311: bipush 8
    //   313: putfield 198	bcfn:j	I
    //   316: aload 10
    //   318: ldc 200
    //   320: invokevirtual 203	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   323: ifeq -275 -> 48
    //   326: aload_0
    //   327: iconst_5
    //   328: putfield 198	bcfn:j	I
    //   331: goto -283 -> 48
    //   334: astore 10
    //   336: lload 5
    //   338: lstore 7
    //   340: fload_1
    //   341: fstore_2
    //   342: aload 9
    //   344: ifnull -257 -> 87
    //   347: aload 9
    //   349: invokevirtual 125	java/io/BufferedReader:close	()V
    //   352: lload 5
    //   354: lstore 7
    //   356: fload_1
    //   357: fstore_2
    //   358: goto -271 -> 87
    //   361: astore 9
    //   363: aload 9
    //   365: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   368: lload 5
    //   370: lstore 7
    //   372: fload_1
    //   373: fstore_2
    //   374: goto -287 -> 87
    //   377: aload_0
    //   378: aload 11
    //   380: invokestatic 122	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   383: l2i
    //   384: putfield 198	bcfn:j	I
    //   387: goto -71 -> 316
    //   390: astore 12
    //   392: iconst_1
    //   393: istore_3
    //   394: aload 11
    //   396: invokevirtual 116	java/lang/String:length	()I
    //   399: istore 4
    //   401: iload_3
    //   402: iload 4
    //   404: if_icmpge -88 -> 316
    //   407: aload_0
    //   408: aload 11
    //   410: iconst_0
    //   411: aload 11
    //   413: invokevirtual 116	java/lang/String:length	()I
    //   416: iload_3
    //   417: isub
    //   418: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   421: invokestatic 122	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   424: l2i
    //   425: putfield 198	bcfn:j	I
    //   428: goto -112 -> 316
    //   431: astore 12
    //   433: iload_3
    //   434: iconst_1
    //   435: iadd
    //   436: istore_3
    //   437: goto -43 -> 394
    //   440: aload 10
    //   442: ldc 205
    //   444: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   447: ifeq +96 -> 543
    //   450: aload 10
    //   452: bipush 58
    //   454: invokevirtual 128	java/lang/String:indexOf	(I)I
    //   457: istore_3
    //   458: iload_3
    //   459: iconst_1
    //   460: if_icmple -412 -> 48
    //   463: aload_0
    //   464: aload 10
    //   466: iload_3
    //   467: iconst_1
    //   468: iadd
    //   469: aload 10
    //   471: invokevirtual 116	java/lang/String:length	()I
    //   474: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   477: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   480: putfield 43	bcfn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   483: aload_0
    //   484: aload_0
    //   485: getfield 43	bcfn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   488: getstatic 188	java/util/Locale:US	Ljava/util/Locale;
    //   491: invokevirtual 192	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   494: putfield 43	bcfn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   497: goto -449 -> 48
    //   500: astore 10
    //   502: lload 5
    //   504: lstore 7
    //   506: fload_1
    //   507: fstore_2
    //   508: aload 9
    //   510: ifnull -423 -> 87
    //   513: aload 9
    //   515: invokevirtual 125	java/io/BufferedReader:close	()V
    //   518: lload 5
    //   520: lstore 7
    //   522: fload_1
    //   523: fstore_2
    //   524: goto -437 -> 87
    //   527: astore 9
    //   529: aload 9
    //   531: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   534: lload 5
    //   536: lstore 7
    //   538: fload_1
    //   539: fstore_2
    //   540: goto -453 -> 87
    //   543: aload 10
    //   545: ldc 207
    //   547: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   550: ifeq +82 -> 632
    //   553: aload 10
    //   555: bipush 58
    //   557: invokevirtual 128	java/lang/String:indexOf	(I)I
    //   560: istore_3
    //   561: iload_3
    //   562: iconst_1
    //   563: if_icmple -515 -> 48
    //   566: aload_0
    //   567: aload 10
    //   569: iload_3
    //   570: iconst_1
    //   571: iadd
    //   572: aload 10
    //   574: invokevirtual 116	java/lang/String:length	()I
    //   577: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   580: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   583: putfield 45	bcfn:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   586: goto -538 -> 48
    //   589: astore 10
    //   591: lload 5
    //   593: lstore 7
    //   595: fload_1
    //   596: fstore_2
    //   597: aload 9
    //   599: ifnull -512 -> 87
    //   602: aload 9
    //   604: invokevirtual 125	java/io/BufferedReader:close	()V
    //   607: lload 5
    //   609: lstore 7
    //   611: fload_1
    //   612: fstore_2
    //   613: goto -526 -> 87
    //   616: astore 9
    //   618: aload 9
    //   620: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   623: lload 5
    //   625: lstore 7
    //   627: fload_1
    //   628: fstore_2
    //   629: goto -542 -> 87
    //   632: aload 10
    //   634: ldc 209
    //   636: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   639: ifeq +38 -> 677
    //   642: aload_0
    //   643: aload 10
    //   645: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   648: putfield 47	bcfn:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   651: goto -603 -> 48
    //   654: astore 11
    //   656: aload 9
    //   658: astore 10
    //   660: aload 11
    //   662: astore 9
    //   664: aload 10
    //   666: ifnull +8 -> 674
    //   669: aload 10
    //   671: invokevirtual 125	java/io/BufferedReader:close	()V
    //   674: aload 9
    //   676: athrow
    //   677: aload 10
    //   679: ldc 211
    //   681: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   684: ifeq +67 -> 751
    //   687: aload 10
    //   689: bipush 58
    //   691: invokevirtual 128	java/lang/String:indexOf	(I)I
    //   694: istore_3
    //   695: iload_3
    //   696: iconst_1
    //   697: if_icmple -649 -> 48
    //   700: aload 10
    //   702: iload_3
    //   703: iconst_1
    //   704: iadd
    //   705: aload 10
    //   707: invokevirtual 116	java/lang/String:length	()I
    //   710: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   713: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   716: astore 10
    //   718: aload 10
    //   720: invokestatic 122	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   723: lstore 7
    //   725: lload 7
    //   727: lconst_0
    //   728: lcmp
    //   729: iflt -681 -> 48
    //   732: lconst_1
    //   733: lload 7
    //   735: ladd
    //   736: lload 5
    //   738: lcmp
    //   739: ifle -691 -> 48
    //   742: lconst_1
    //   743: lload 7
    //   745: ladd
    //   746: lstore 5
    //   748: goto -700 -> 48
    //   751: aload 10
    //   753: ldc 213
    //   755: invokevirtual 179	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   758: ifeq -710 -> 48
    //   761: aload 10
    //   763: bipush 58
    //   765: invokevirtual 128	java/lang/String:indexOf	(I)I
    //   768: istore_3
    //   769: iload_3
    //   770: iconst_1
    //   771: if_icmple -723 -> 48
    //   774: aload 10
    //   776: iload_3
    //   777: iconst_1
    //   778: iadd
    //   779: aload 10
    //   781: invokevirtual 116	java/lang/String:length	()I
    //   784: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   787: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   790: astore 10
    //   792: aload 10
    //   794: invokestatic 219	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   797: fstore_2
    //   798: fload_2
    //   799: fload_1
    //   800: fcmpl
    //   801: ifle +166 -> 967
    //   804: fload_2
    //   805: fstore_1
    //   806: goto -758 -> 48
    //   809: astore 9
    //   811: aload 9
    //   813: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   816: lload 5
    //   818: lstore 7
    //   820: fload_1
    //   821: fstore_2
    //   822: goto -735 -> 87
    //   825: astore 10
    //   827: aload 10
    //   829: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   832: goto -158 -> 674
    //   835: lload 7
    //   837: lconst_0
    //   838: lcmp
    //   839: ifle -732 -> 107
    //   842: lload 7
    //   844: l2i
    //   845: istore_3
    //   846: aload_0
    //   847: iload_3
    //   848: putfield 169	bcfn:k	I
    //   851: goto -744 -> 107
    //   854: fload_2
    //   855: fconst_0
    //   856: fcmpl
    //   857: ifle -850 -> 7
    //   860: fload_2
    //   861: ldc 220
    //   863: fcmpg
    //   864: ifge +19 -> 883
    //   867: aload_0
    //   868: fload_2
    //   869: f2d
    //   870: ldc2_w 221
    //   873: dmul
    //   874: ldc2_w 223
    //   877: dmul
    //   878: d2l
    //   879: putfield 173	bcfn:jdField_a_of_type_Long	J
    //   882: return
    //   883: fload_2
    //   884: ldc 225
    //   886: fcmpl
    //   887: ifle +19 -> 906
    //   890: aload_0
    //   891: fload_2
    //   892: f2d
    //   893: ldc2_w 226
    //   896: ddiv
    //   897: ldc2_w 223
    //   900: dmul
    //   901: d2l
    //   902: putfield 173	bcfn:jdField_a_of_type_Long	J
    //   905: return
    //   906: aload_0
    //   907: ldc 228
    //   909: fload_2
    //   910: fmul
    //   911: f2l
    //   912: putfield 173	bcfn:jdField_a_of_type_Long	J
    //   915: return
    //   916: astore 10
    //   918: goto -870 -> 48
    //   921: astore 10
    //   923: goto -875 -> 48
    //   926: astore 9
    //   928: aconst_null
    //   929: astore 10
    //   931: goto -267 -> 664
    //   934: astore 9
    //   936: aconst_null
    //   937: astore 9
    //   939: goto -348 -> 591
    //   942: astore 9
    //   944: aconst_null
    //   945: astore 9
    //   947: goto -445 -> 502
    //   950: astore 9
    //   952: aconst_null
    //   953: astore 9
    //   955: goto -619 -> 336
    //   958: astore 9
    //   960: aload 10
    //   962: astore 9
    //   964: goto -759 -> 205
    //   967: goto -161 -> 806
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	970	0	this	bcfn
    //   29	792	1	f1	float
    //   70	840	2	f2	float
    //   97	751	3	m	int
    //   399	6	4	n	int
    //   25	792	5	l1	long
    //   67	776	7	l2	long
    //   46	31	9	localBufferedReader	java.io.BufferedReader
    //   127	90	9	localException1	Exception
    //   230	118	9	localIOException1	java.io.IOException
    //   361	153	9	localIOException2	java.io.IOException
    //   527	76	9	localIOException3	java.io.IOException
    //   616	41	9	localIOException4	java.io.IOException
    //   662	13	9	localObject1	Object
    //   809	3	9	localIOException5	java.io.IOException
    //   926	1	9	localObject2	Object
    //   934	1	9	localException2	Exception
    //   937	1	9	localObject3	Object
    //   942	1	9	localNumberFormatException1	java.lang.NumberFormatException
    //   945	1	9	localObject4	Object
    //   950	1	9	localIOException6	java.io.IOException
    //   953	1	9	localObject5	Object
    //   958	1	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   962	1	9	localObject6	Object
    //   9	156	10	str1	String
    //   203	114	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   334	136	10	localIOException7	java.io.IOException
    //   500	73	10	localNumberFormatException2	java.lang.NumberFormatException
    //   589	55	10	localException3	Exception
    //   658	135	10	localObject7	Object
    //   825	3	10	localIOException8	java.io.IOException
    //   916	1	10	localNumberFormatException3	java.lang.NumberFormatException
    //   921	1	10	localNumberFormatException4	java.lang.NumberFormatException
    //   929	32	10	localObject8	Object
    //   285	127	11	str2	String
    //   654	7	11	localObject9	Object
    //   390	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   431	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   94	98	127	java/lang/Exception
    //   102	107	127	java/lang/Exception
    //   107	113	127	java/lang/Exception
    //   120	126	127	java/lang/Exception
    //   846	851	127	java/lang/Exception
    //   867	882	127	java/lang/Exception
    //   890	905	127	java/lang/Exception
    //   906	915	127	java/lang/Exception
    //   48	55	203	java/io/FileNotFoundException
    //   60	65	203	java/io/FileNotFoundException
    //   135	153	203	java/io/FileNotFoundException
    //   158	200	203	java/io/FileNotFoundException
    //   246	264	203	java/io/FileNotFoundException
    //   269	287	203	java/io/FileNotFoundException
    //   292	316	203	java/io/FileNotFoundException
    //   316	331	203	java/io/FileNotFoundException
    //   377	387	203	java/io/FileNotFoundException
    //   394	401	203	java/io/FileNotFoundException
    //   407	428	203	java/io/FileNotFoundException
    //   440	458	203	java/io/FileNotFoundException
    //   463	497	203	java/io/FileNotFoundException
    //   543	561	203	java/io/FileNotFoundException
    //   566	586	203	java/io/FileNotFoundException
    //   632	651	203	java/io/FileNotFoundException
    //   677	695	203	java/io/FileNotFoundException
    //   700	718	203	java/io/FileNotFoundException
    //   718	725	203	java/io/FileNotFoundException
    //   751	769	203	java/io/FileNotFoundException
    //   774	792	203	java/io/FileNotFoundException
    //   792	798	203	java/io/FileNotFoundException
    //   216	221	230	java/io/IOException
    //   48	55	334	java/io/IOException
    //   60	65	334	java/io/IOException
    //   135	153	334	java/io/IOException
    //   158	200	334	java/io/IOException
    //   246	264	334	java/io/IOException
    //   269	287	334	java/io/IOException
    //   292	316	334	java/io/IOException
    //   316	331	334	java/io/IOException
    //   377	387	334	java/io/IOException
    //   394	401	334	java/io/IOException
    //   407	428	334	java/io/IOException
    //   440	458	334	java/io/IOException
    //   463	497	334	java/io/IOException
    //   543	561	334	java/io/IOException
    //   566	586	334	java/io/IOException
    //   632	651	334	java/io/IOException
    //   677	695	334	java/io/IOException
    //   700	718	334	java/io/IOException
    //   718	725	334	java/io/IOException
    //   751	769	334	java/io/IOException
    //   774	792	334	java/io/IOException
    //   792	798	334	java/io/IOException
    //   347	352	361	java/io/IOException
    //   377	387	390	java/lang/NumberFormatException
    //   407	428	431	java/lang/NumberFormatException
    //   48	55	500	java/lang/NumberFormatException
    //   60	65	500	java/lang/NumberFormatException
    //   135	153	500	java/lang/NumberFormatException
    //   158	200	500	java/lang/NumberFormatException
    //   246	264	500	java/lang/NumberFormatException
    //   269	287	500	java/lang/NumberFormatException
    //   292	316	500	java/lang/NumberFormatException
    //   316	331	500	java/lang/NumberFormatException
    //   394	401	500	java/lang/NumberFormatException
    //   440	458	500	java/lang/NumberFormatException
    //   463	497	500	java/lang/NumberFormatException
    //   543	561	500	java/lang/NumberFormatException
    //   566	586	500	java/lang/NumberFormatException
    //   632	651	500	java/lang/NumberFormatException
    //   677	695	500	java/lang/NumberFormatException
    //   700	718	500	java/lang/NumberFormatException
    //   751	769	500	java/lang/NumberFormatException
    //   774	792	500	java/lang/NumberFormatException
    //   513	518	527	java/io/IOException
    //   48	55	589	java/lang/Exception
    //   60	65	589	java/lang/Exception
    //   135	153	589	java/lang/Exception
    //   158	200	589	java/lang/Exception
    //   246	264	589	java/lang/Exception
    //   269	287	589	java/lang/Exception
    //   292	316	589	java/lang/Exception
    //   316	331	589	java/lang/Exception
    //   377	387	589	java/lang/Exception
    //   394	401	589	java/lang/Exception
    //   407	428	589	java/lang/Exception
    //   440	458	589	java/lang/Exception
    //   463	497	589	java/lang/Exception
    //   543	561	589	java/lang/Exception
    //   566	586	589	java/lang/Exception
    //   632	651	589	java/lang/Exception
    //   677	695	589	java/lang/Exception
    //   700	718	589	java/lang/Exception
    //   718	725	589	java/lang/Exception
    //   751	769	589	java/lang/Exception
    //   774	792	589	java/lang/Exception
    //   792	798	589	java/lang/Exception
    //   602	607	616	java/io/IOException
    //   48	55	654	finally
    //   60	65	654	finally
    //   135	153	654	finally
    //   158	200	654	finally
    //   246	264	654	finally
    //   269	287	654	finally
    //   292	316	654	finally
    //   316	331	654	finally
    //   377	387	654	finally
    //   394	401	654	finally
    //   407	428	654	finally
    //   440	458	654	finally
    //   463	497	654	finally
    //   543	561	654	finally
    //   566	586	654	finally
    //   632	651	654	finally
    //   677	695	654	finally
    //   700	718	654	finally
    //   718	725	654	finally
    //   751	769	654	finally
    //   774	792	654	finally
    //   792	798	654	finally
    //   76	81	809	java/io/IOException
    //   669	674	825	java/io/IOException
    //   718	725	916	java/lang/NumberFormatException
    //   792	798	921	java/lang/NumberFormatException
    //   30	48	926	finally
    //   30	48	934	java/lang/Exception
    //   30	48	942	java/lang/NumberFormatException
    //   30	48	950	java/io/IOException
    //   30	48	958	java/io/FileNotFoundException
  }
  
  /* Error */
  private long b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 169	bcfn:k	I
    //   6: iconst_1
    //   7: if_icmpge +23 -> 30
    //   10: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +11 -> 24
    //   16: ldc 133
    //   18: iconst_2
    //   19: ldc 234
    //   21: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_0
    //   25: bipush 8
    //   27: putfield 169	bcfn:k	I
    //   30: iconst_0
    //   31: istore_3
    //   32: lconst_0
    //   33: lstore 6
    //   35: lconst_0
    //   36: lstore 4
    //   38: iload_2
    //   39: aload_0
    //   40: getfield 169	bcfn:k	I
    //   43: if_icmpge +273 -> 316
    //   46: aconst_null
    //   47: astore 13
    //   49: new 97	java/io/BufferedReader
    //   52: dup
    //   53: new 99	java/io/FileReader
    //   56: dup
    //   57: new 135	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   64: ldc 238
    //   66: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload_2
    //   70: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc 243
    //   75: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 102	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   84: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   87: astore 12
    //   89: lload 4
    //   91: lstore 8
    //   93: aload 12
    //   95: ifnull +53 -> 148
    //   98: aload 12
    //   100: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   103: astore 13
    //   105: aload 13
    //   107: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +269 -> 379
    //   113: aload 13
    //   115: invokevirtual 182	java/lang/String:trim	()Ljava/lang/String;
    //   118: astore 13
    //   120: lload 4
    //   122: lstore 8
    //   124: aload 13
    //   126: ifnull +22 -> 148
    //   129: lload 4
    //   131: lstore 8
    //   133: aload 13
    //   135: invokevirtual 116	java/lang/String:length	()I
    //   138: ifle +10 -> 148
    //   141: aload 13
    //   143: invokestatic 122	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   146: lstore 8
    //   148: iload_3
    //   149: istore_1
    //   150: lload 8
    //   152: lstore 4
    //   154: aload 12
    //   156: ifnull +14 -> 170
    //   159: aload 12
    //   161: invokevirtual 125	java/io/BufferedReader:close	()V
    //   164: lload 8
    //   166: lstore 4
    //   168: iload_3
    //   169: istore_1
    //   170: lload 6
    //   172: lstore 8
    //   174: lload 4
    //   176: lload 6
    //   178: lcmp
    //   179: ifle +7 -> 186
    //   182: lload 4
    //   184: lstore 8
    //   186: iload_2
    //   187: iconst_1
    //   188: iadd
    //   189: istore_2
    //   190: iload_1
    //   191: istore_3
    //   192: lload 8
    //   194: lstore 6
    //   196: goto -158 -> 38
    //   199: astore 12
    //   201: aload 12
    //   203: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   206: iload_3
    //   207: istore_1
    //   208: lload 8
    //   210: lstore 4
    //   212: goto -42 -> 170
    //   215: astore 13
    //   217: aconst_null
    //   218: astore 12
    //   220: ldc 133
    //   222: iconst_1
    //   223: new 135	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   230: ldc 245
    //   232: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: iload_2
    //   236: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: ldc 247
    //   241: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 13
    //   246: invokevirtual 145	java/lang/Exception:toString	()Ljava/lang/String;
    //   249: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload 12
    //   260: ifnull +8 -> 268
    //   263: aload 12
    //   265: invokevirtual 125	java/io/BufferedReader:close	()V
    //   268: iconst_1
    //   269: istore_1
    //   270: lconst_0
    //   271: lstore 4
    //   273: goto -103 -> 170
    //   276: astore 12
    //   278: aload 12
    //   280: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   283: iconst_1
    //   284: istore_1
    //   285: lconst_0
    //   286: lstore 4
    //   288: goto -118 -> 170
    //   291: astore 12
    //   293: aload 13
    //   295: ifnull +8 -> 303
    //   298: aload 13
    //   300: invokevirtual 125	java/io/BufferedReader:close	()V
    //   303: aload 12
    //   305: athrow
    //   306: astore 13
    //   308: aload 13
    //   310: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   313: goto -10 -> 303
    //   316: lload 6
    //   318: lstore 8
    //   320: iload_3
    //   321: ifeq +24 -> 345
    //   324: invokestatic 249	bcfn:a	()J
    //   327: lstore 10
    //   329: lload 6
    //   331: lstore 8
    //   333: lload 10
    //   335: lload 4
    //   337: lcmp
    //   338: ifle +7 -> 345
    //   341: lload 10
    //   343: lstore 8
    //   345: lload 8
    //   347: lreturn
    //   348: astore 14
    //   350: aload 12
    //   352: astore 13
    //   354: aload 14
    //   356: astore 12
    //   358: goto -65 -> 293
    //   361: astore 14
    //   363: aload 12
    //   365: astore 13
    //   367: aload 14
    //   369: astore 12
    //   371: goto -78 -> 293
    //   374: astore 13
    //   376: goto -156 -> 220
    //   379: ldc 39
    //   381: astore 13
    //   383: goto -263 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	bcfn
    //   149	136	1	m	int
    //   1	235	2	n	int
    //   31	290	3	i1	int
    //   36	300	4	l1	long
    //   33	297	6	l2	long
    //   91	255	8	l3	long
    //   327	15	10	l4	long
    //   87	73	12	localBufferedReader	java.io.BufferedReader
    //   199	3	12	localIOException1	java.io.IOException
    //   218	46	12	localObject1	Object
    //   276	3	12	localIOException2	java.io.IOException
    //   291	60	12	localObject2	Object
    //   356	14	12	localObject3	Object
    //   47	95	13	str1	String
    //   215	84	13	localException1	Exception
    //   306	3	13	localIOException3	java.io.IOException
    //   352	14	13	localObject4	Object
    //   374	1	13	localException2	Exception
    //   381	1	13	str2	String
    //   348	7	14	localObject5	Object
    //   361	7	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   159	164	199	java/io/IOException
    //   49	89	215	java/lang/Exception
    //   263	268	276	java/io/IOException
    //   49	89	291	finally
    //   298	303	306	java/io/IOException
    //   98	120	348	finally
    //   133	148	348	finally
    //   220	258	361	finally
    //   98	120	374	java/lang/Exception
    //   133	148	374	java/lang/Exception
  }
  
  public static boolean b()
  {
    int i2 = a(Build.CPU_ABI);
    if (Build.VERSION.SDK_INT >= 21)
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      if (arrayOfString != null)
      {
        int i3 = arrayOfString.length;
        int n = 0;
        for (int m = 0;; m = i1 | m)
        {
          i1 = m;
          if (n >= i3) {
            break;
          }
          i1 = a(arrayOfString[n]);
          n += 1;
        }
      }
    }
    int i1 = 0;
    if ((i2 == jdField_d_of_type_Int) || ((jdField_d_of_type_Int & i1) == jdField_d_of_type_Int)) {}
    do
    {
      do
      {
        return false;
      } while ((i2 == jdField_e_of_type_Int) || ((jdField_e_of_type_Int & i1) == jdField_e_of_type_Int));
      if ((i2 == jdField_c_of_type_Int) || ((jdField_c_of_type_Int & i1) == jdField_c_of_type_Int)) {
        return true;
      }
      if ((i2 == jdField_b_of_type_Int) || ((jdField_b_of_type_Int & i1) == jdField_b_of_type_Int)) {
        return true;
      }
    } while ((i2 != jdField_a_of_type_Int) && ((i1 & jdField_a_of_type_Int) != jdField_a_of_type_Int));
    return true;
  }
  
  private boolean c()
  {
    Object localObject = System.getProperty("java.library.path");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return false;
      localObject = ((String)localObject).split(":");
      if ((localObject != null) && (localObject.length != 0))
      {
        int n = localObject.length;
        int m = 0;
        while (m < n)
        {
          String str = localObject[m];
          if (new File(str + File.separator + "libOpenCL.so").exists()) {
            return true;
          }
          m += 1;
        }
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    this.g = a(Build.CPU_ABI);
    this.h = a(Build.CPU_ABI2);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = Build.SUPPORTED_ABIS;
      if (localObject != null)
      {
        int m = 0;
        while (m < localObject.length)
        {
          this.i = (a(localObject[m]) | this.i);
          m += 1;
        }
      }
    }
    if (Build.BRAND == null)
    {
      localObject = "";
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (Build.MODEL != null) {
        break label792;
      }
      localObject = "";
      label100:
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      if ((this.g != jdField_d_of_type_Int) && ((this.i & jdField_d_of_type_Int) != jdField_d_of_type_Int)) {
        break label799;
      }
      this.jdField_f_of_type_Int = 7;
      if ((this.h == jdField_b_of_type_Int) || (this.h == jdField_a_of_type_Int) || ((this.i & jdField_b_of_type_Int) == jdField_b_of_type_Int) || ((this.i & jdField_b_of_type_Int) == jdField_b_of_type_Int)) {
        this.jdField_f_of_type_Int = 8;
      }
      label189:
      a();
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CPUReport", 2, "getCpuArch not found in android.Build infoArchId:" + this.j + " vendorId:" + this.jdField_e_of_type_JavaLangString);
        }
        if (this.jdField_f_of_type_Int == 0) {}
        switch (this.j)
        {
        default: 
          if ((this.jdField_e_of_type_JavaLangString != null) && ((this.jdField_e_of_type_JavaLangString.equalsIgnoreCase("AuthenticAMD")) || (this.jdField_e_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")))) {
            this.jdField_f_of_type_Int = 7;
          }
          label327:
          if ((this.jdField_f_of_type_Int == 4) && (this.jdField_c_of_type_JavaLangString.contains("aarch64")))
          {
            this.jdField_f_of_type_Int = 5;
            label352:
            if ((this.jdField_f_of_type_Int != 4) || (this.jdField_d_of_type_JavaLangString.contains("neon"))) {
              break label989;
            }
            this.jdField_f_of_type_Int = 3;
            if (QLog.isColorLevel()) {
              QLog.i("CPUReport", 2, "getCpuArch armv7a neon not supported " + this.jdField_a_of_type_JavaLangString + " " + this.jdField_b_of_type_JavaLangString);
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("cpuArch").append("=").append(this.jdField_f_of_type_Int).append('\n');
        localStringBuilder.append("CPU_ABI").append("=").append(this.g).append('\n');
        localStringBuilder.append("CPU_ABI2").append("=").append(this.h).append('\n');
        localStringBuilder.append("SUPPORTED_ABIS").append("=").append(this.i).append('\n');
        localStringBuilder.append("brand").append("=").append(this.jdField_a_of_type_JavaLangString).append('\n');
        localStringBuilder.append("model").append("=").append(this.jdField_b_of_type_JavaLangString).append('\n');
        localStringBuilder.append("infoProcessorName").append("=").append(this.jdField_c_of_type_JavaLangString).append('\n');
        localStringBuilder.append("infoArchitectureId").append("=").append(this.j).append('\n');
        localStringBuilder.append("infoVendorId").append("=").append(this.jdField_e_of_type_JavaLangString).append('\n');
        localStringBuilder.append("infoHardware").append("=").append(this.jdField_f_of_type_JavaLangString).append('\n');
        localStringBuilder.append("infoCoreNum").append("=").append(this.k).append('\n');
        localStringBuilder.append("infoMaxCoreFreq").append("=").append(this.jdField_a_of_type_Long).append('\n');
        localStringBuilder.append("doneReadCpuInfo").append("=").append(this.jdField_b_of_type_Boolean).append('\n');
        QLog.i("CPUReport", 2, localStringBuilder.toString());
      }
      return localStringBuilder.toString();
      localObject = Build.BRAND;
      break;
      label792:
      localObject = Build.BOARD;
      break label100;
      label799:
      if ((this.g == jdField_c_of_type_Int) || ((this.i & jdField_c_of_type_Int) == jdField_c_of_type_Int))
      {
        this.jdField_f_of_type_Int = 5;
        break label189;
      }
      if ((this.g == jdField_b_of_type_Int) || ((this.i & jdField_b_of_type_Int) == jdField_b_of_type_Int))
      {
        this.jdField_f_of_type_Int = 4;
        break label189;
      }
      if ((this.g == jdField_a_of_type_Int) || ((this.i & jdField_a_of_type_Int) == jdField_a_of_type_Int))
      {
        this.jdField_f_of_type_Int = 1;
        break label189;
      }
      if ((this.g != jdField_e_of_type_Int) && ((this.i & jdField_e_of_type_Int) != jdField_e_of_type_Int)) {
        break label189;
      }
      this.jdField_f_of_type_Int = 6;
      break label189;
      this.jdField_f_of_type_Int = 1;
      break label327;
      this.jdField_f_of_type_Int = 2;
      break label327;
      this.jdField_f_of_type_Int = 4;
      break label327;
      this.jdField_f_of_type_Int = 5;
      break label327;
      if ((this.jdField_f_of_type_Int != 1) || (!this.jdField_c_of_type_JavaLangString.contains("armv6"))) {
        break label352;
      }
      this.jdField_f_of_type_Int = 2;
      break label352;
      label989:
      if ((this.jdField_f_of_type_Int == 8) && (this.jdField_d_of_type_JavaLangString.contains("neon")))
      {
        this.jdField_f_of_type_Int = 9;
        if (QLog.isColorLevel()) {
          QLog.i("CPUReport", 2, "getCpuArch x86 neon supported " + this.jdField_a_of_type_JavaLangString + " " + this.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      a();
      this.jdField_a_of_type_Boolean = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuArch", String.valueOf(this.jdField_f_of_type_Int));
      localHashMap.put("CPU_ABI", String.valueOf(this.g));
      localHashMap.put("CPU_ABI2", String.valueOf(this.h));
      localHashMap.put("SUPPORTED_ABIS", String.valueOf(this.i));
      localHashMap.put("brand", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("model", this.jdField_b_of_type_JavaLangString);
      localHashMap.put("infoProcessorName", this.jdField_c_of_type_JavaLangString);
      localHashMap.put("infoArchitectureId", String.valueOf(this.j));
      localHashMap.put("infoVendorId", this.jdField_e_of_type_JavaLangString);
      localHashMap.put("infoHardware", this.jdField_f_of_type_JavaLangString);
      localHashMap.put("infoCoreNum", String.valueOf(this.k));
      localHashMap.put("infoMaxCoreFreq", Long.toString(this.jdField_a_of_type_Long));
      if (this.jdField_b_of_type_Boolean)
      {
        String str1 = "1";
        localHashMap.put("doneReadCpuInfo", str1);
        if (!this.jdField_a_of_type_Boolean) {
          break label289;
        }
        str1 = "1";
        localHashMap.put("doneGetField", str1);
        if (!c()) {
          break label296;
        }
        str1 = "1";
        localHashMap.put("hasOpenCLSo", str1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "CPUREPORT_730", true, 0L, 0L, localHashMap, "");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        continue;
        String str2 = "0";
        continue;
        label289:
        str2 = "0";
        continue;
        label296:
        str2 = "0";
      }
    }
  }
  
  public final boolean a()
  {
    return (this.jdField_f_of_type_Int == 5) || (this.jdField_f_of_type_Int == 4) || (this.jdField_f_of_type_Int == 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfn
 * JD-Core Version:    0.7.0.1
 */