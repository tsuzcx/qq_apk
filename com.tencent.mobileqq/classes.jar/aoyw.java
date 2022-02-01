import android.os.Build.VERSION;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class aoyw
{
  private static aoyy a;
  
  static
  {
    if ((aoyv.a("HUAWEI")) && (Build.VERSION.SDK_INT >= 23) && (aosl.a())) {
      a = null;
    }
  }
  
  /* Error */
  public static int a(aoyy paramaoyy, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: aload_1
    //   8: invokestatic 33	bgsp:a	(Ljava/lang/String;)Z
    //   11: istore 4
    //   13: iload 4
    //   15: ifeq +11 -> 26
    //   18: bipush 252
    //   20: istore_2
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: aload_0
    //   27: invokeinterface 38 1 0
    //   32: astore 5
    //   34: aload_0
    //   35: invokeinterface 41 1 0
    //   40: astore_0
    //   41: aload 5
    //   43: aload_0
    //   44: aload 5
    //   46: aload_0
    //   47: aload 5
    //   49: invokestatic 46	aovv:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: aload_1
    //   53: invokestatic 49	aovv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   56: istore_3
    //   57: iload_3
    //   58: istore_2
    //   59: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq -41 -> 21
    //   65: ldc 56
    //   67: iconst_2
    //   68: new 58	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   75: ldc 63
    //   77: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 69
    //   86: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload_3
    //   90: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iload_3
    //   100: istore_2
    //   101: goto -80 -> 21
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramaoyy	aoyy
    //   0	110	1	paramString	String
    //   20	81	2	i	int
    //   56	44	3	j	int
    //   11	3	4	bool	boolean
    //   32	16	5	str	String
    // Exception table:
    //   from	to	target	type
    //   7	13	104	finally
    //   26	57	104	finally
    //   59	99	104	finally
  }
  
  /* Error */
  public static int a(aoyy paramaoyy, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +21 -> 25
    //   7: aload_1
    //   8: invokestatic 33	bgsp:a	(Ljava/lang/String;)Z
    //   11: ifne +14 -> 25
    //   14: aload_2
    //   15: invokestatic 33	bgsp:a	(Ljava/lang/String;)Z
    //   18: istore 4
    //   20: iload 4
    //   22: ifeq +10 -> 32
    //   25: iconst_m1
    //   26: istore_3
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: aload_0
    //   33: invokeinterface 38 1 0
    //   38: astore 5
    //   40: aload_0
    //   41: invokeinterface 41 1 0
    //   46: astore 6
    //   48: aload_0
    //   49: invokeinterface 87 1 0
    //   54: astore 8
    //   56: aload_0
    //   57: invokeinterface 90 1 0
    //   62: astore 7
    //   64: aload 7
    //   66: ifnull +730 -> 796
    //   69: aload 7
    //   71: invokeinterface 96 1 0
    //   76: ifne +6 -> 82
    //   79: goto +717 -> 796
    //   82: ldc 56
    //   84: iconst_2
    //   85: new 58	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   92: ldc 98
    //   94: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 100
    //   103: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_2
    //   107: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 5
    //   118: aload 6
    //   120: aload 5
    //   122: aload_2
    //   123: invokestatic 106	aovv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: aload 5
    //   129: aload 6
    //   131: aload 5
    //   133: aload 6
    //   135: aload 5
    //   137: invokestatic 46	aovv:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: invokestatic 108	aovv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: invokestatic 113	aovr:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: new 58	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   153: aload 5
    //   155: aload 6
    //   157: aload 5
    //   159: aload 6
    //   161: aload 5
    //   163: invokestatic 46	aovv:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 108	aovv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   169: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   175: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 8
    //   180: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_0
    //   187: new 115	java/io/File
    //   190: dup
    //   191: aload_0
    //   192: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: astore_2
    //   196: aload_2
    //   197: invokevirtual 125	java/io/File:exists	()Z
    //   200: ifeq +525 -> 725
    //   203: new 127	java/util/HashMap
    //   206: dup
    //   207: invokespecial 128	java/util/HashMap:<init>	()V
    //   210: pop
    //   211: aload_2
    //   212: invokestatic 133	bgmg:b	(Ljava/io/File;)Ljava/lang/String;
    //   215: aload 7
    //   217: invokestatic 136	aoyw:a	(Ljava/lang/String;Ljava/util/List;)Ljava/util/HashMap;
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 137	java/util/HashMap:size	()I
    //   225: ifle +470 -> 695
    //   228: aload_0
    //   229: invokevirtual 141	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   232: invokeinterface 147 1 0
    //   237: astore_1
    //   238: aload_1
    //   239: invokeinterface 152 1 0
    //   244: ifeq +522 -> 766
    //   247: aload_1
    //   248: invokeinterface 156 1 0
    //   253: checkcast 158	java/util/Map$Entry
    //   256: astore_2
    //   257: ldc 160
    //   259: astore_0
    //   260: aload_2
    //   261: invokeinterface 163 1 0
    //   266: checkcast 165	java/lang/String
    //   269: astore 8
    //   271: aload 7
    //   273: aload 8
    //   275: invokeinterface 169 2 0
    //   280: ifeq +67 -> 347
    //   283: new 58	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   290: aload 5
    //   292: aload 6
    //   294: aload 5
    //   296: aload 6
    //   298: aload 5
    //   300: invokestatic 46	aovv:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: invokestatic 108	aovv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   312: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 8
    //   317: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 171
    //   322: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore_0
    //   329: aload 5
    //   331: aload 6
    //   333: aload 8
    //   335: aload_2
    //   336: invokeinterface 174 1 0
    //   341: checkcast 165	java/lang/String
    //   344: invokestatic 106	aovv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   347: new 115	java/io/File
    //   350: dup
    //   351: aload_0
    //   352: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   355: astore 8
    //   357: ldc 56
    //   359: iconst_2
    //   360: new 58	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   367: ldc 176
    //   369: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload 8
    //   384: invokevirtual 125	java/io/File:exists	()Z
    //   387: ifeq +267 -> 654
    //   390: aload_0
    //   391: invokestatic 181	azby:a	(Ljava/lang/String;)Ljava/lang/String;
    //   394: astore 9
    //   396: aload_2
    //   397: invokeinterface 174 1 0
    //   402: checkcast 165	java/lang/String
    //   405: astore_2
    //   406: aload_2
    //   407: aload 9
    //   409: invokevirtual 184	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   412: ifne -174 -> 238
    //   415: aload 8
    //   417: invokevirtual 187	java/io/File:delete	()Z
    //   420: pop
    //   421: ldc 56
    //   423: iconst_2
    //   424: new 58	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   431: ldc 189
    //   433: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: bipush 253
    //   438: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   441: ldc 191
    //   443: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_0
    //   447: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc 193
    //   452: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 9
    //   457: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc 195
    //   462: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_2
    //   466: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: bipush 253
    //   477: istore_3
    //   478: goto -451 -> 27
    //   481: astore_0
    //   482: bipush 250
    //   484: istore_3
    //   485: aload 5
    //   487: aload 6
    //   489: aload 5
    //   491: aload 6
    //   493: aload 5
    //   495: invokestatic 46	aovv:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   498: invokestatic 108	aovv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   501: iconst_0
    //   502: invokestatic 198	bgmg:a	(Ljava/lang/String;Z)V
    //   505: new 115	java/io/File
    //   508: dup
    //   509: aload_1
    //   510: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: astore_0
    //   514: aload_0
    //   515: invokevirtual 125	java/io/File:exists	()Z
    //   518: ifeq +8 -> 526
    //   521: aload_0
    //   522: invokevirtual 187	java/io/File:delete	()Z
    //   525: pop
    //   526: ldc 56
    //   528: iconst_2
    //   529: new 58	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   536: ldc 200
    //   538: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: bipush 250
    //   543: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc 202
    //   548: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_1
    //   552: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: goto -534 -> 27
    //   564: astore_0
    //   565: ldc 2
    //   567: monitorexit
    //   568: aload_0
    //   569: athrow
    //   570: astore_0
    //   571: bipush 251
    //   573: istore_3
    //   574: ldc 56
    //   576: iconst_2
    //   577: new 58	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   584: ldc 204
    //   586: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: bipush 251
    //   591: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: ldc 202
    //   596: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_1
    //   600: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: goto -582 -> 27
    //   612: astore_0
    //   613: bipush 251
    //   615: istore_3
    //   616: ldc 56
    //   618: iconst_2
    //   619: new 58	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   626: ldc 204
    //   628: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: bipush 251
    //   633: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: ldc 202
    //   638: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_1
    //   642: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: goto -624 -> 27
    //   654: bipush 254
    //   656: istore_3
    //   657: ldc 56
    //   659: iconst_2
    //   660: new 58	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   667: ldc 206
    //   669: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: bipush 254
    //   674: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: ldc 191
    //   679: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload_0
    //   683: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: goto -665 -> 27
    //   695: iconst_m1
    //   696: istore_3
    //   697: ldc 56
    //   699: iconst_2
    //   700: new 58	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   707: ldc 208
    //   709: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: iconst_m1
    //   713: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: goto -695 -> 27
    //   725: bipush 254
    //   727: istore_3
    //   728: ldc 56
    //   730: iconst_2
    //   731: new 58	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   738: ldc 206
    //   740: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: bipush 254
    //   745: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: ldc 210
    //   750: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: aload_0
    //   754: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: goto -736 -> 27
    //   766: iconst_0
    //   767: istore_3
    //   768: ldc 56
    //   770: iconst_2
    //   771: new 58	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   778: ldc 212
    //   780: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: iconst_0
    //   784: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   787: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: goto -766 -> 27
    //   796: iconst_m1
    //   797: istore_3
    //   798: goto -771 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	801	0	paramaoyy	aoyy
    //   0	801	1	paramString1	String
    //   0	801	2	paramString2	String
    //   26	772	3	i	int
    //   18	3	4	bool	boolean
    //   38	456	5	str1	String
    //   46	446	6	str2	String
    //   62	210	7	localList	List
    //   54	362	8	localObject	Object
    //   394	62	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   126	146	481	java/io/IOException
    //   7	20	564	finally
    //   32	64	564	finally
    //   69	79	564	finally
    //   82	126	564	finally
    //   126	146	564	finally
    //   146	211	564	finally
    //   211	221	564	finally
    //   221	238	564	finally
    //   238	257	564	finally
    //   260	271	564	finally
    //   271	347	564	finally
    //   347	475	564	finally
    //   485	526	564	finally
    //   526	561	564	finally
    //   574	609	564	finally
    //   616	651	564	finally
    //   657	692	564	finally
    //   697	722	564	finally
    //   728	763	564	finally
    //   768	793	564	finally
    //   211	221	570	java/io/IOException
    //   211	221	612	java/lang/OutOfMemoryError
  }
  
  public static aoyy a()
  {
    return a;
  }
  
  private static HashMap<String, String> a(String paramString, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramList)
      {
        XmlPullParser localXmlPullParser;
        QLog.e("ArCoreNativeSoManager", 2, "parseSoMd5FromXmlConfig failed. error = " + paramList.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      break label161;
      str = localXmlPullParser.getName();
      if (paramList.contains(str))
      {
        localHashMap.put(str, localXmlPullParser.nextText());
        label161:
        while (i == 1)
        {
          String str;
          QLog.d("ArCoreNativeSoManager", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
          return localHashMap;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public static boolean a(aoyy paramaoyy)
  {
    if (paramaoyy == null) {
      return false;
    }
    Object localObject = paramaoyy.a();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!a(paramaoyy, (String)((Iterator)localObject).next())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(aoyy paramaoyy, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaoyy != null) {}
    for (;;)
    {
      try
      {
        bool1 = bgsp.a(paramString);
        if (bool1)
        {
          bool1 = bool2;
          return bool1;
        }
        String str1 = paramaoyy.a();
        String str2 = paramaoyy.b();
        paramaoyy = aovv.a(str1, str2, aovv.b(str1, str2, str1)) + File.separator + paramString + ".so";
        File localFile = new File(paramaoyy);
        if (QLog.isColorLevel()) {
          QLog.d("ArCoreNativeSoManager", 2, "isSoFileExist soFile=" + paramaoyy + ", exist=" + localFile.exists());
        }
        if (localFile.exists())
        {
          paramString = aovv.b(str1, str2, paramString);
          str1 = azby.a(paramaoyy);
          if (paramString.equalsIgnoreCase(str1))
          {
            bool1 = true;
            continue;
          }
          QLog.i("ArCoreNativeSoManager", 2, "isSoFileExist. check md5 failed. soFilename = " + paramaoyy + ", md5FromConfig = " + paramString + ", md5FromCalc = " + str1);
          bool1 = bool2;
          continue;
        }
        QLog.i("ArCoreNativeSoManager", 2, "isSoFileExist. so not exist. soFilename = " + paramaoyy);
      }
      finally {}
      bool1 = bool2;
    }
  }
  
  public static boolean b(aoyy paramaoyy)
  {
    if (paramaoyy == null) {
      return false;
    }
    String str1 = paramaoyy.a();
    String str2 = paramaoyy.b();
    paramaoyy = paramaoyy.a();
    if ((paramaoyy == null) || (paramaoyy.size() == 0)) {
      return false;
    }
    paramaoyy = paramaoyy.iterator();
    while (paramaoyy.hasNext())
    {
      String str3 = (String)paramaoyy.next();
      if (!new File(aovv.a(str1, str2, aovv.b(str1, str2, str1)) + File.separator + str3 + ".so").exists())
      {
        QLog.i("ArCoreNativeSoManager", 2, "isAllFileExists. name not exist.");
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyw
 * JD-Core Version:    0.7.0.1
 */