import android.os.Process;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class bexo
{
  public static int a;
  public static bexp a;
  private static final bexq jdField_a_of_type_Bexq = new bexq(bexp.class, 30);
  private static Map<String, bexp> jdField_a_of_type_JavaUtilMap;
  static int[] jdField_a_of_type_ArrayOfInt;
  static int[] b;
  
  static
  {
    jdField_a_of_type_Bexp = a();
    jdField_a_of_type_JavaUtilMap = new HashMap(30);
    jdField_a_of_type_ArrayOfInt = new int[17];
    b = new int[17];
    jdField_a_of_type_Int = -1;
  }
  
  public static long a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1L;
    }
    long l = ((Long)paramString[1]).longValue();
    return ((Long)paramString[2]).longValue() + l;
  }
  
  public static bexp a()
  {
    return (bexp)jdField_a_of_type_Bexq.a(bexp.class);
  }
  
  private static final RandomAccessFile a(String paramString)
  {
    try
    {
      if (paramString.equals("-2")) {
        return new RandomAccessFile("/proc/stat", "r");
      }
      if (paramString.equals("-1"))
      {
        paramString = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
        return paramString;
      }
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
      paramString = new RandomAccessFile("/proc/" + Process.myPid() + "/task/" + paramString + "/stat", "r");
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static Object[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 117	bexo:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   6: astore 21
    //   8: invokestatic 122	bexj:a	()Lbexj;
    //   11: sipush 1024
    //   14: invokevirtual 125	bexj:a	(I)[B
    //   17: astore 22
    //   19: aload 21
    //   21: lconst_0
    //   22: invokevirtual 129	java/io/RandomAccessFile:seek	(J)V
    //   25: aload 21
    //   27: aload 22
    //   29: invokevirtual 133	java/io/RandomAccessFile:read	([B)I
    //   32: istore 4
    //   34: iconst_0
    //   35: istore_3
    //   36: goto +662 -> 698
    //   39: iload_2
    //   40: istore_1
    //   41: iload_2
    //   42: iload 4
    //   44: if_icmpge +690 -> 734
    //   47: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   50: iload_3
    //   51: iload_2
    //   52: iastore
    //   53: iload_2
    //   54: istore_1
    //   55: goto +679 -> 734
    //   58: iload_1
    //   59: iload 4
    //   61: if_icmpge +695 -> 756
    //   64: getstatic 40	bexo:b	[I
    //   67: iload_3
    //   68: iload_1
    //   69: iastore
    //   70: goto +686 -> 756
    //   73: iload_3
    //   74: bipush 17
    //   76: if_icmpne +557 -> 633
    //   79: ldc 65
    //   81: aload_0
    //   82: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifne +236 -> 321
    //   88: new 67	java/lang/String
    //   91: dup
    //   92: aload 22
    //   94: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   97: iconst_1
    //   98: iaload
    //   99: iconst_1
    //   100: iadd
    //   101: getstatic 40	bexo:b	[I
    //   104: iconst_1
    //   105: iaload
    //   106: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   109: iconst_1
    //   110: iaload
    //   111: isub
    //   112: iconst_1
    //   113: isub
    //   114: invokespecial 136	java/lang/String:<init>	([BII)V
    //   117: astore 23
    //   119: new 67	java/lang/String
    //   122: dup
    //   123: aload 22
    //   125: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   128: bipush 13
    //   130: iaload
    //   131: getstatic 40	bexo:b	[I
    //   134: bipush 13
    //   136: iaload
    //   137: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   140: bipush 13
    //   142: iaload
    //   143: isub
    //   144: invokespecial 136	java/lang/String:<init>	([BII)V
    //   147: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: lstore 5
    //   152: new 67	java/lang/String
    //   155: dup
    //   156: aload 22
    //   158: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   161: bipush 15
    //   163: iaload
    //   164: getstatic 40	bexo:b	[I
    //   167: bipush 15
    //   169: iaload
    //   170: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   173: bipush 15
    //   175: iaload
    //   176: isub
    //   177: invokespecial 136	java/lang/String:<init>	([BII)V
    //   180: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: lstore 7
    //   185: new 67	java/lang/String
    //   188: dup
    //   189: aload 22
    //   191: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   194: bipush 14
    //   196: iaload
    //   197: getstatic 40	bexo:b	[I
    //   200: bipush 14
    //   202: iaload
    //   203: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   206: bipush 14
    //   208: iaload
    //   209: isub
    //   210: invokespecial 136	java/lang/String:<init>	([BII)V
    //   213: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   216: lstore 9
    //   218: new 67	java/lang/String
    //   221: dup
    //   222: aload 22
    //   224: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   227: bipush 16
    //   229: iaload
    //   230: getstatic 40	bexo:b	[I
    //   233: bipush 16
    //   235: iaload
    //   236: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   239: bipush 16
    //   241: iaload
    //   242: isub
    //   243: invokespecial 136	java/lang/String:<init>	([BII)V
    //   246: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: lstore 11
    //   251: aload 23
    //   253: ifnull +50 -> 303
    //   256: iconst_3
    //   257: anewarray 4	java/lang/Object
    //   260: astore_0
    //   261: aload_0
    //   262: iconst_0
    //   263: aload 23
    //   265: aastore
    //   266: aload_0
    //   267: iconst_1
    //   268: lload 5
    //   270: lload 7
    //   272: ladd
    //   273: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: aastore
    //   277: aload_0
    //   278: iconst_2
    //   279: lload 9
    //   281: lload 11
    //   283: ladd
    //   284: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   287: aastore
    //   288: invokestatic 122	bexj:a	()Lbexj;
    //   291: aload 22
    //   293: invokevirtual 146	bexj:a	([B)V
    //   296: aload 21
    //   298: invokevirtual 149	java/io/RandomAccessFile:close	()V
    //   301: aload_0
    //   302: areturn
    //   303: invokestatic 122	bexj:a	()Lbexj;
    //   306: aload 22
    //   308: invokevirtual 146	bexj:a	([B)V
    //   311: aload 21
    //   313: invokevirtual 149	java/io/RandomAccessFile:close	()V
    //   316: aconst_null
    //   317: areturn
    //   318: astore_0
    //   319: aconst_null
    //   320: areturn
    //   321: new 67	java/lang/String
    //   324: dup
    //   325: aload 22
    //   327: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   330: iconst_4
    //   331: iaload
    //   332: getstatic 40	bexo:b	[I
    //   335: iconst_4
    //   336: iaload
    //   337: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   340: iconst_4
    //   341: iaload
    //   342: isub
    //   343: invokespecial 136	java/lang/String:<init>	([BII)V
    //   346: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   349: lstore 5
    //   351: new 67	java/lang/String
    //   354: dup
    //   355: aload 22
    //   357: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   360: iconst_1
    //   361: iaload
    //   362: getstatic 40	bexo:b	[I
    //   365: iconst_1
    //   366: iaload
    //   367: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   370: iconst_1
    //   371: iaload
    //   372: isub
    //   373: invokespecial 136	java/lang/String:<init>	([BII)V
    //   376: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   379: lstore 7
    //   381: new 67	java/lang/String
    //   384: dup
    //   385: aload 22
    //   387: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   390: iconst_2
    //   391: iaload
    //   392: getstatic 40	bexo:b	[I
    //   395: iconst_2
    //   396: iaload
    //   397: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   400: iconst_2
    //   401: iaload
    //   402: isub
    //   403: invokespecial 136	java/lang/String:<init>	([BII)V
    //   406: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   409: lstore 9
    //   411: new 67	java/lang/String
    //   414: dup
    //   415: aload 22
    //   417: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   420: iconst_3
    //   421: iaload
    //   422: getstatic 40	bexo:b	[I
    //   425: iconst_3
    //   426: iaload
    //   427: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   430: iconst_3
    //   431: iaload
    //   432: isub
    //   433: invokespecial 136	java/lang/String:<init>	([BII)V
    //   436: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   439: lstore 11
    //   441: new 67	java/lang/String
    //   444: dup
    //   445: aload 22
    //   447: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   450: iconst_5
    //   451: iaload
    //   452: getstatic 40	bexo:b	[I
    //   455: iconst_5
    //   456: iaload
    //   457: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   460: iconst_5
    //   461: iaload
    //   462: isub
    //   463: invokespecial 136	java/lang/String:<init>	([BII)V
    //   466: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   469: lstore 13
    //   471: new 67	java/lang/String
    //   474: dup
    //   475: aload 22
    //   477: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   480: bipush 6
    //   482: iaload
    //   483: getstatic 40	bexo:b	[I
    //   486: bipush 6
    //   488: iaload
    //   489: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   492: bipush 6
    //   494: iaload
    //   495: isub
    //   496: invokespecial 136	java/lang/String:<init>	([BII)V
    //   499: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   502: lstore 15
    //   504: new 67	java/lang/String
    //   507: dup
    //   508: aload 22
    //   510: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   513: bipush 7
    //   515: iaload
    //   516: getstatic 40	bexo:b	[I
    //   519: bipush 7
    //   521: iaload
    //   522: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   525: bipush 7
    //   527: iaload
    //   528: isub
    //   529: invokespecial 136	java/lang/String:<init>	([BII)V
    //   532: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   535: lstore 17
    //   537: new 67	java/lang/String
    //   540: dup
    //   541: aload 22
    //   543: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   546: bipush 8
    //   548: iaload
    //   549: getstatic 40	bexo:b	[I
    //   552: bipush 8
    //   554: iaload
    //   555: getstatic 38	bexo:jdField_a_of_type_ArrayOfInt	[I
    //   558: bipush 8
    //   560: iaload
    //   561: isub
    //   562: invokespecial 136	java/lang/String:<init>	([BII)V
    //   565: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   568: lstore 19
    //   570: iconst_3
    //   571: anewarray 4	java/lang/Object
    //   574: astore_0
    //   575: aload_0
    //   576: iconst_0
    //   577: ldc 151
    //   579: aastore
    //   580: aload_0
    //   581: iconst_1
    //   582: lload 5
    //   584: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   587: aastore
    //   588: aload_0
    //   589: iconst_2
    //   590: lload 7
    //   592: lload 9
    //   594: ladd
    //   595: lload 11
    //   597: ladd
    //   598: lload 13
    //   600: ladd
    //   601: lload 15
    //   603: ladd
    //   604: lload 17
    //   606: ladd
    //   607: lload 19
    //   609: ladd
    //   610: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   613: aastore
    //   614: invokestatic 122	bexj:a	()Lbexj;
    //   617: aload 22
    //   619: invokevirtual 146	bexj:a	([B)V
    //   622: aload 21
    //   624: invokevirtual 149	java/io/RandomAccessFile:close	()V
    //   627: aload_0
    //   628: areturn
    //   629: astore 21
    //   631: aload_0
    //   632: areturn
    //   633: invokestatic 122	bexj:a	()Lbexj;
    //   636: aload 22
    //   638: invokevirtual 146	bexj:a	([B)V
    //   641: aload 21
    //   643: invokevirtual 149	java/io/RandomAccessFile:close	()V
    //   646: aconst_null
    //   647: areturn
    //   648: astore_0
    //   649: invokestatic 122	bexj:a	()Lbexj;
    //   652: aload 22
    //   654: invokevirtual 146	bexj:a	([B)V
    //   657: aload 21
    //   659: invokevirtual 149	java/io/RandomAccessFile:close	()V
    //   662: goto -16 -> 646
    //   665: astore_0
    //   666: goto -20 -> 646
    //   669: astore_0
    //   670: invokestatic 122	bexj:a	()Lbexj;
    //   673: aload 22
    //   675: invokevirtual 146	bexj:a	([B)V
    //   678: aload 21
    //   680: invokevirtual 149	java/io/RandomAccessFile:close	()V
    //   683: aload_0
    //   684: athrow
    //   685: astore 21
    //   687: aload_0
    //   688: areturn
    //   689: astore_0
    //   690: goto -44 -> 646
    //   693: astore 21
    //   695: goto -12 -> 683
    //   698: iload_1
    //   699: iload 4
    //   701: if_icmpge -628 -> 73
    //   704: iload_3
    //   705: bipush 17
    //   707: if_icmpge -634 -> 73
    //   710: iload_1
    //   711: istore_2
    //   712: iload_2
    //   713: iload 4
    //   715: if_icmpge -676 -> 39
    //   718: aload 22
    //   720: iload_2
    //   721: baload
    //   722: bipush 32
    //   724: if_icmpne -685 -> 39
    //   727: iload_2
    //   728: iconst_1
    //   729: iadd
    //   730: istore_2
    //   731: goto -19 -> 712
    //   734: iload_1
    //   735: iload 4
    //   737: if_icmpge -679 -> 58
    //   740: aload 22
    //   742: iload_1
    //   743: baload
    //   744: bipush 32
    //   746: if_icmpeq -688 -> 58
    //   749: iload_1
    //   750: iconst_1
    //   751: iadd
    //   752: istore_1
    //   753: goto -19 -> 734
    //   756: iload_3
    //   757: iconst_1
    //   758: iadd
    //   759: istore_3
    //   760: goto -62 -> 698
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	paramString	String
    //   1	752	1	i	int
    //   39	692	2	j	int
    //   35	725	3	k	int
    //   32	706	4	m	int
    //   150	433	5	l1	long
    //   183	408	7	l2	long
    //   216	377	9	l3	long
    //   249	347	11	l4	long
    //   469	130	13	l5	long
    //   502	100	15	l6	long
    //   535	70	17	l7	long
    //   568	40	19	l8	long
    //   6	617	21	localRandomAccessFile	RandomAccessFile
    //   629	50	21	localException1	java.lang.Exception
    //   685	1	21	localException2	java.lang.Exception
    //   693	1	21	localException3	java.lang.Exception
    //   17	724	22	arrayOfByte	byte[]
    //   117	147	23	str	String
    // Exception table:
    //   from	to	target	type
    //   311	316	318	java/lang/Exception
    //   622	627	629	java/lang/Exception
    //   19	34	648	java/lang/Exception
    //   47	53	648	java/lang/Exception
    //   64	70	648	java/lang/Exception
    //   79	251	648	java/lang/Exception
    //   256	261	648	java/lang/Exception
    //   266	288	648	java/lang/Exception
    //   321	575	648	java/lang/Exception
    //   580	614	648	java/lang/Exception
    //   657	662	665	java/lang/Exception
    //   19	34	669	finally
    //   47	53	669	finally
    //   64	70	669	finally
    //   79	251	669	finally
    //   256	261	669	finally
    //   266	288	669	finally
    //   321	575	669	finally
    //   580	614	669	finally
    //   296	301	685	java/lang/Exception
    //   641	646	689	java/lang/Exception
    //   678	683	693	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexo
 * JD-Core Version:    0.7.0.1
 */