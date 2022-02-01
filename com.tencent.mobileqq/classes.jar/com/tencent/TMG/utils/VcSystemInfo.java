package com.tencent.TMG.utils;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;

public class VcSystemInfo
{
  public static final int CHIP_ARM_V5 = 1;
  public static final int CHIP_ARM_V6 = 2;
  public static final int CHIP_ARM_V7_NENO = 4;
  public static final int CHIP_ARM_V7_NO_NENO = 3;
  public static final int CHIP_ARM_V8 = 5;
  public static final int CHIP_MIPS = 6;
  public static final int CHIP_UNKNOW = 0;
  public static final int CHIP_X86 = 7;
  static final String TAG = "VcSystemInfo";
  static int mChip = 1;
  static int mCoreNumber = 1;
  static int mCpuArchitecture = 5;
  static long mCurrCpuFreq = 0L;
  static String mFeature = "";
  static String mHardware;
  static boolean mIsMarvell = false;
  static boolean mIsSupportSharpAudio = true;
  static boolean mIsSupportSharpVideo = true;
  static long mMaxCpuFreq = 0L;
  static int mOpenGLVersion = 2;
  static String mProcessorName = "";
  static String mVendorId;
  static boolean mfReadCpuInfo = false;
  static long mgMaxCpuFreq;
  static int mgNumCores;
  int mScreenHeight = 480;
  int mScreenWidth = 320;
  public int mdispHeight = 240;
  public int mdispWidth = 320;
  
  public static String getCPUName()
  {
    getCpuInfo();
    return mProcessorName;
  }
  
  public static int getCpuArchitecture()
  {
    getCpuInfo();
    return mChip;
  }
  
  /* Error */
  public static void getCpuInfo()
  {
    // Byte code:
    //   0: getstatic 86	com/tencent/TMG/utils/VcSystemInfo:mfReadCpuInfo	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: ldc2_w 87
    //   11: lstore 7
    //   13: ldc 89
    //   15: fstore_2
    //   16: new 91	java/io/FileReader
    //   19: dup
    //   20: ldc 93
    //   22: invokespecial 96	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: astore 14
    //   27: new 98	java/io/BufferedReader
    //   30: dup
    //   31: aload 14
    //   33: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore 15
    //   38: aload 15
    //   40: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 16
    //   45: aload 16
    //   47: ifnonnull +48 -> 95
    //   50: iconst_1
    //   51: putstatic 86	com/tencent/TMG/utils/VcSystemInfo:mfReadCpuInfo	Z
    //   54: fload_2
    //   55: fstore_3
    //   56: lload 7
    //   58: lstore 9
    //   60: aload 15
    //   62: invokevirtual 107	java/io/BufferedReader:close	()V
    //   65: fload_2
    //   66: fstore_3
    //   67: lload 7
    //   69: lstore 9
    //   71: aload 14
    //   73: invokevirtual 108	java/io/FileReader:close	()V
    //   76: goto +1042 -> 1118
    //   79: astore 14
    //   81: aload 14
    //   83: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   86: fload_3
    //   87: fstore_2
    //   88: lload 9
    //   90: lstore 7
    //   92: goto +1026 -> 1118
    //   95: aload 16
    //   97: ldc 113
    //   99: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: istore 13
    //   104: iload 13
    //   106: ifeq +106 -> 212
    //   109: aload 16
    //   111: bipush 58
    //   113: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   116: istore 5
    //   118: iload 5
    //   120: iconst_1
    //   121: if_icmple -83 -> 38
    //   124: aload 16
    //   126: iload 5
    //   128: iconst_1
    //   129: iadd
    //   130: aload 16
    //   132: invokevirtual 126	java/lang/String:length	()I
    //   135: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   138: putstatic 72	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   141: getstatic 72	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   144: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   147: putstatic 72	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   150: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   153: ifeq -115 -> 38
    //   156: new 141	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   163: astore 17
    //   165: aload 17
    //   167: ldc 144
    //   169: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 17
    //   175: getstatic 72	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   178: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 17
    //   184: ldc 150
    //   186: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 17
    //   192: aload 16
    //   194: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: ldc 25
    //   200: iconst_0
    //   201: aload 17
    //   203: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: goto -171 -> 38
    //   212: aload 16
    //   214: ldc 159
    //   216: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   219: ifeq +192 -> 411
    //   222: aload 16
    //   224: bipush 58
    //   226: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   229: istore 5
    //   231: iload 5
    //   233: iconst_1
    //   234: if_icmple +101 -> 335
    //   237: aload 16
    //   239: iload 5
    //   241: iconst_1
    //   242: iadd
    //   243: aload 16
    //   245: invokevirtual 126	java/lang/String:length	()I
    //   248: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   251: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   254: astore 17
    //   256: aload 17
    //   258: ifnull +77 -> 335
    //   261: aload 17
    //   263: invokevirtual 126	java/lang/String:length	()I
    //   266: istore 5
    //   268: iload 5
    //   270: ifle +65 -> 335
    //   273: aload 17
    //   275: invokestatic 165	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   278: l2i
    //   279: putstatic 167	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   282: goto +53 -> 335
    //   285: iconst_1
    //   286: istore 5
    //   288: aload 17
    //   290: invokevirtual 126	java/lang/String:length	()I
    //   293: istore 6
    //   295: iload 5
    //   297: iload 6
    //   299: if_icmpge +36 -> 335
    //   302: aload 17
    //   304: iconst_0
    //   305: aload 17
    //   307: invokevirtual 126	java/lang/String:length	()I
    //   310: iload 5
    //   312: isub
    //   313: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   316: invokestatic 165	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   319: l2i
    //   320: putstatic 167	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   323: goto +12 -> 335
    //   326: iload 5
    //   328: iconst_1
    //   329: iadd
    //   330: istore 5
    //   332: goto -44 -> 288
    //   335: aload 16
    //   337: ldc 169
    //   339: invokevirtual 173	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   342: ifeq +7 -> 349
    //   345: iconst_5
    //   346: putstatic 167	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   349: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   352: ifeq -314 -> 38
    //   355: new 141	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   362: astore 17
    //   364: aload 17
    //   366: ldc 175
    //   368: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 17
    //   374: getstatic 167	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   377: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 17
    //   383: ldc 150
    //   385: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 17
    //   391: aload 16
    //   393: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 25
    //   399: iconst_0
    //   400: aload 17
    //   402: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: goto -370 -> 38
    //   411: aload 16
    //   413: ldc 180
    //   415: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   418: ifeq +100 -> 518
    //   421: aload 16
    //   423: bipush 58
    //   425: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   428: istore 5
    //   430: iload 5
    //   432: iconst_1
    //   433: if_icmple +23 -> 456
    //   436: aload 16
    //   438: iload 5
    //   440: iconst_1
    //   441: iadd
    //   442: aload 16
    //   444: invokevirtual 126	java/lang/String:length	()I
    //   447: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   450: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   453: putstatic 182	com/tencent/TMG/utils/VcSystemInfo:mFeature	Ljava/lang/String;
    //   456: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   459: ifeq -421 -> 38
    //   462: new 141	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   469: astore 17
    //   471: aload 17
    //   473: ldc 184
    //   475: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 17
    //   481: getstatic 182	com/tencent/TMG/utils/VcSystemInfo:mFeature	Ljava/lang/String;
    //   484: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 17
    //   490: ldc 150
    //   492: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 17
    //   498: aload 16
    //   500: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: ldc 25
    //   506: iconst_0
    //   507: aload 17
    //   509: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: goto -477 -> 38
    //   518: aload 16
    //   520: ldc 186
    //   522: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   525: ifeq +100 -> 625
    //   528: aload 16
    //   530: bipush 58
    //   532: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   535: istore 5
    //   537: iload 5
    //   539: iconst_1
    //   540: if_icmple +23 -> 563
    //   543: aload 16
    //   545: iload 5
    //   547: iconst_1
    //   548: iadd
    //   549: aload 16
    //   551: invokevirtual 126	java/lang/String:length	()I
    //   554: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   557: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   560: putstatic 188	com/tencent/TMG/utils/VcSystemInfo:mVendorId	Ljava/lang/String;
    //   563: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   566: ifeq -528 -> 38
    //   569: new 141	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   576: astore 17
    //   578: aload 17
    //   580: ldc 190
    //   582: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 17
    //   588: getstatic 188	com/tencent/TMG/utils/VcSystemInfo:mVendorId	Ljava/lang/String;
    //   591: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 17
    //   597: ldc 150
    //   599: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload 17
    //   605: aload 16
    //   607: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: ldc 25
    //   613: iconst_0
    //   614: aload 17
    //   616: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: goto -584 -> 38
    //   625: aload 16
    //   627: ldc 192
    //   629: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   632: ifeq +87 -> 719
    //   635: aload 16
    //   637: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   640: putstatic 194	com/tencent/TMG/utils/VcSystemInfo:mHardware	Ljava/lang/String;
    //   643: aload 16
    //   645: ldc 196
    //   647: invokevirtual 173	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   650: ifeq +7 -> 657
    //   653: iconst_1
    //   654: putstatic 198	com/tencent/TMG/utils/VcSystemInfo:mIsMarvell	Z
    //   657: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   660: ifeq -622 -> 38
    //   663: new 141	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   670: astore 17
    //   672: aload 17
    //   674: ldc 200
    //   676: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 17
    //   682: getstatic 198	com/tencent/TMG/utils/VcSystemInfo:mIsMarvell	Z
    //   685: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 17
    //   691: ldc 150
    //   693: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 17
    //   699: aload 16
    //   701: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: ldc 25
    //   707: iconst_0
    //   708: aload 17
    //   710: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: goto -678 -> 38
    //   719: aload 16
    //   721: ldc 205
    //   723: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   726: ifeq +72 -> 798
    //   729: aload 16
    //   731: bipush 58
    //   733: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   736: istore 5
    //   738: iload 5
    //   740: iconst_1
    //   741: if_icmple -703 -> 38
    //   744: aload 16
    //   746: iload 5
    //   748: iconst_1
    //   749: iadd
    //   750: aload 16
    //   752: invokevirtual 126	java/lang/String:length	()I
    //   755: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   758: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   761: astore 16
    //   763: aload 16
    //   765: invokestatic 165	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   768: lstore 9
    //   770: lload 9
    //   772: lconst_0
    //   773: lcmp
    //   774: iflt -736 -> 38
    //   777: lload 9
    //   779: lconst_1
    //   780: ladd
    //   781: lstore 9
    //   783: lload 9
    //   785: lload 7
    //   787: lcmp
    //   788: ifle -750 -> 38
    //   791: lload 9
    //   793: lstore 7
    //   795: goto -757 -> 38
    //   798: aload 16
    //   800: ldc 207
    //   802: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   805: ifeq -767 -> 38
    //   808: aload 16
    //   810: bipush 58
    //   812: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   815: istore 5
    //   817: iload 5
    //   819: iconst_1
    //   820: if_icmple -782 -> 38
    //   823: aload 16
    //   825: iload 5
    //   827: iconst_1
    //   828: iadd
    //   829: aload 16
    //   831: invokevirtual 126	java/lang/String:length	()I
    //   834: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   837: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   840: astore 16
    //   842: aload 16
    //   844: invokestatic 213	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   847: fstore_3
    //   848: fload_3
    //   849: fload_2
    //   850: fcmpl
    //   851: ifle -813 -> 38
    //   854: fload_3
    //   855: fstore_2
    //   856: goto -818 -> 38
    //   859: astore 16
    //   861: goto +59 -> 920
    //   864: astore 16
    //   866: aconst_null
    //   867: astore 15
    //   869: goto +51 -> 920
    //   872: aconst_null
    //   873: astore 15
    //   875: fload_2
    //   876: fstore 4
    //   878: lload 7
    //   880: lstore 11
    //   882: goto +86 -> 968
    //   885: aconst_null
    //   886: astore 15
    //   888: fload_2
    //   889: fstore 4
    //   891: lload 7
    //   893: lstore 11
    //   895: goto +124 -> 1019
    //   898: aconst_null
    //   899: astore 15
    //   901: fload_2
    //   902: fstore 4
    //   904: lload 7
    //   906: lstore 11
    //   908: goto +162 -> 1070
    //   911: astore 16
    //   913: aconst_null
    //   914: astore 14
    //   916: aload 14
    //   918: astore 15
    //   920: aload 15
    //   922: ifnull +11 -> 933
    //   925: aload 15
    //   927: invokevirtual 107	java/io/BufferedReader:close	()V
    //   930: goto +3 -> 933
    //   933: aload 14
    //   935: ifnull +16 -> 951
    //   938: aload 14
    //   940: invokevirtual 108	java/io/FileReader:close	()V
    //   943: goto +8 -> 951
    //   946: aload 14
    //   948: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   951: aload 16
    //   953: athrow
    //   954: aconst_null
    //   955: astore 14
    //   957: aload 14
    //   959: astore 15
    //   961: lload 7
    //   963: lstore 11
    //   965: fload_2
    //   966: fstore 4
    //   968: aload 15
    //   970: ifnull +15 -> 985
    //   973: fload 4
    //   975: fstore_3
    //   976: lload 11
    //   978: lstore 9
    //   980: aload 15
    //   982: invokevirtual 107	java/io/BufferedReader:close	()V
    //   985: fload 4
    //   987: fstore_2
    //   988: lload 11
    //   990: lstore 7
    //   992: aload 14
    //   994: ifnull +124 -> 1118
    //   997: fload 4
    //   999: fstore_3
    //   1000: lload 11
    //   1002: lstore 9
    //   1004: aload 14
    //   1006: invokevirtual 108	java/io/FileReader:close	()V
    //   1009: fload 4
    //   1011: fstore_2
    //   1012: lload 11
    //   1014: lstore 7
    //   1016: goto +102 -> 1118
    //   1019: aload 15
    //   1021: ifnull +15 -> 1036
    //   1024: fload 4
    //   1026: fstore_3
    //   1027: lload 11
    //   1029: lstore 9
    //   1031: aload 15
    //   1033: invokevirtual 107	java/io/BufferedReader:close	()V
    //   1036: fload 4
    //   1038: fstore_2
    //   1039: lload 11
    //   1041: lstore 7
    //   1043: aload 14
    //   1045: ifnull +73 -> 1118
    //   1048: fload 4
    //   1050: fstore_3
    //   1051: lload 11
    //   1053: lstore 9
    //   1055: aload 14
    //   1057: invokevirtual 108	java/io/FileReader:close	()V
    //   1060: fload 4
    //   1062: fstore_2
    //   1063: lload 11
    //   1065: lstore 7
    //   1067: goto +51 -> 1118
    //   1070: aload 15
    //   1072: ifnull +15 -> 1087
    //   1075: fload 4
    //   1077: fstore_3
    //   1078: lload 11
    //   1080: lstore 9
    //   1082: aload 15
    //   1084: invokevirtual 107	java/io/BufferedReader:close	()V
    //   1087: fload 4
    //   1089: fstore_2
    //   1090: lload 11
    //   1092: lstore 7
    //   1094: aload 14
    //   1096: ifnull +22 -> 1118
    //   1099: fload 4
    //   1101: fstore_3
    //   1102: lload 11
    //   1104: lstore 9
    //   1106: aload 14
    //   1108: invokevirtual 108	java/io/FileReader:close	()V
    //   1111: lload 11
    //   1113: lstore 7
    //   1115: fload 4
    //   1117: fstore_2
    //   1118: invokestatic 217	com/tencent/TMG/utils/VcSystemInfo:readMaxCpuFreq	()J
    //   1121: lstore 9
    //   1123: lload 9
    //   1125: lconst_0
    //   1126: lcmp
    //   1127: ifle +54 -> 1181
    //   1130: lload 9
    //   1132: putstatic 219	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1135: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1138: ifeq +159 -> 1297
    //   1141: new 141	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1148: astore 14
    //   1150: aload 14
    //   1152: ldc 221
    //   1154: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: pop
    //   1158: aload 14
    //   1160: getstatic 219	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1163: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: ldc 25
    //   1169: iconst_0
    //   1170: aload 14
    //   1172: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1178: goto +119 -> 1297
    //   1181: fload_2
    //   1182: fconst_0
    //   1183: fcmpl
    //   1184: ifle +113 -> 1297
    //   1187: ldc 225
    //   1189: fload_2
    //   1190: fmul
    //   1191: f2l
    //   1192: putstatic 219	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1195: fload_2
    //   1196: ldc 226
    //   1198: fcmpg
    //   1199: ifge +27 -> 1226
    //   1202: fload_2
    //   1203: f2d
    //   1204: dstore_0
    //   1205: dload_0
    //   1206: invokestatic 232	java/lang/Double:isNaN	(D)Z
    //   1209: pop
    //   1210: dload_0
    //   1211: ldc2_w 233
    //   1214: dmul
    //   1215: ldc2_w 235
    //   1218: dmul
    //   1219: d2l
    //   1220: putstatic 219	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1223: goto +31 -> 1254
    //   1226: fload_2
    //   1227: ldc 237
    //   1229: fcmpl
    //   1230: ifle +24 -> 1254
    //   1233: fload_2
    //   1234: f2d
    //   1235: dstore_0
    //   1236: dload_0
    //   1237: invokestatic 232	java/lang/Double:isNaN	(D)Z
    //   1240: pop
    //   1241: dload_0
    //   1242: ldc2_w 238
    //   1245: ddiv
    //   1246: ldc2_w 235
    //   1249: dmul
    //   1250: d2l
    //   1251: putstatic 219	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1254: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1257: ifeq +40 -> 1297
    //   1260: new 141	java/lang/StringBuilder
    //   1263: dup
    //   1264: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1267: astore 14
    //   1269: aload 14
    //   1271: ldc 241
    //   1273: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: aload 14
    //   1279: getstatic 219	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1282: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: ldc 25
    //   1288: iconst_0
    //   1289: aload 14
    //   1291: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1294: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1297: invokestatic 244	com/tencent/TMG/utils/VcSystemInfo:getCurrentCpuFreq	()J
    //   1300: lstore 9
    //   1302: lload 9
    //   1304: lconst_0
    //   1305: lcmp
    //   1306: ifle +51 -> 1357
    //   1309: lload 9
    //   1311: putstatic 246	com/tencent/TMG/utils/VcSystemInfo:mCurrCpuFreq	J
    //   1314: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1317: ifeq +40 -> 1357
    //   1320: new 141	java/lang/StringBuilder
    //   1323: dup
    //   1324: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1327: astore 14
    //   1329: aload 14
    //   1331: ldc 248
    //   1333: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: aload 14
    //   1339: getstatic 246	com/tencent/TMG/utils/VcSystemInfo:mCurrCpuFreq	J
    //   1342: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: ldc 25
    //   1348: iconst_0
    //   1349: aload 14
    //   1351: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1354: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1357: invokestatic 251	com/tencent/TMG/utils/VcSystemInfo:readNumCores	()I
    //   1360: istore 5
    //   1362: iload 5
    //   1364: ifle +54 -> 1418
    //   1367: iload 5
    //   1369: putstatic 253	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   1372: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1375: ifeq +100 -> 1475
    //   1378: new 141	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1385: astore 14
    //   1387: aload 14
    //   1389: ldc 255
    //   1391: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: pop
    //   1395: aload 14
    //   1397: getstatic 253	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   1400: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: ldc 25
    //   1406: iconst_0
    //   1407: aload 14
    //   1409: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1412: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1415: goto +60 -> 1475
    //   1418: lload 7
    //   1420: lconst_0
    //   1421: lcmp
    //   1422: ifle +53 -> 1475
    //   1425: lload 7
    //   1427: l2i
    //   1428: putstatic 253	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   1431: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1434: ifeq +41 -> 1475
    //   1437: new 141	java/lang/StringBuilder
    //   1440: dup
    //   1441: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1444: astore 14
    //   1446: aload 14
    //   1448: ldc_w 257
    //   1451: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: pop
    //   1455: aload 14
    //   1457: getstatic 253	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   1460: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: ldc 25
    //   1466: iconst_0
    //   1467: aload 14
    //   1469: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1472: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1475: invokestatic 260	com/tencent/TMG/utils/VcSystemInfo:readCpuArchitecture	()I
    //   1478: putstatic 76	com/tencent/TMG/utils/VcSystemInfo:mChip	I
    //   1481: invokestatic 263	com/tencent/TMG/utils/VcSystemInfo:readSupportSharpAudio	()Z
    //   1484: putstatic 265	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpAudio	Z
    //   1487: getstatic 265	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpAudio	Z
    //   1490: ifeq +10 -> 1500
    //   1493: iconst_1
    //   1494: putstatic 267	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpVideo	Z
    //   1497: goto +7 -> 1504
    //   1500: iconst_0
    //   1501: putstatic 267	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpVideo	Z
    //   1504: invokestatic 139	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1507: ifeq +77 -> 1584
    //   1510: new 141	java/lang/StringBuilder
    //   1513: dup
    //   1514: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1517: astore 14
    //   1519: aload 14
    //   1521: ldc_w 269
    //   1524: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: pop
    //   1528: aload 14
    //   1530: getstatic 76	com/tencent/TMG/utils/VcSystemInfo:mChip	I
    //   1533: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1536: pop
    //   1537: aload 14
    //   1539: ldc_w 271
    //   1542: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: pop
    //   1546: aload 14
    //   1548: getstatic 267	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpVideo	Z
    //   1551: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1554: pop
    //   1555: aload 14
    //   1557: ldc_w 273
    //   1560: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload 14
    //   1566: getstatic 265	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpAudio	Z
    //   1569: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1572: pop
    //   1573: ldc 25
    //   1575: iconst_0
    //   1576: aload 14
    //   1578: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1581: invokestatic 157	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1584: return
    //   1585: astore 14
    //   1587: goto +101 -> 1688
    //   1590: astore 14
    //   1592: goto +79 -> 1671
    //   1595: astore 14
    //   1597: goto -643 -> 954
    //   1600: astore 15
    //   1602: goto -704 -> 898
    //   1605: astore 15
    //   1607: goto -722 -> 885
    //   1610: astore 15
    //   1612: goto -740 -> 872
    //   1615: astore 16
    //   1617: fload_2
    //   1618: fstore 4
    //   1620: lload 7
    //   1622: lstore 11
    //   1624: goto -554 -> 1070
    //   1627: astore 16
    //   1629: fload_2
    //   1630: fstore 4
    //   1632: lload 7
    //   1634: lstore 11
    //   1636: goto -617 -> 1019
    //   1639: astore 16
    //   1641: fload_2
    //   1642: fstore 4
    //   1644: lload 7
    //   1646: lstore 11
    //   1648: goto -680 -> 968
    //   1651: astore 18
    //   1653: goto -1368 -> 285
    //   1656: astore 18
    //   1658: goto -1332 -> 326
    //   1661: astore 16
    //   1663: goto -1625 -> 38
    //   1666: astore 14
    //   1668: goto -722 -> 946
    //   1671: aconst_null
    //   1672: astore 14
    //   1674: aload 14
    //   1676: astore 15
    //   1678: fload_2
    //   1679: fstore 4
    //   1681: lload 7
    //   1683: lstore 11
    //   1685: goto -666 -> 1019
    //   1688: aconst_null
    //   1689: astore 14
    //   1691: aload 14
    //   1693: astore 15
    //   1695: fload_2
    //   1696: fstore 4
    //   1698: lload 7
    //   1700: lstore 11
    //   1702: goto -632 -> 1070
    // Local variable table:
    //   start	length	slot	name	signature
    //   1204	38	0	d	double
    //   15	1681	2	f1	float
    //   55	1047	3	f2	float
    //   876	821	4	f3	float
    //   116	1252	5	i	int
    //   293	7	6	j	int
    //   11	1688	7	l1	long
    //   58	1252	9	l2	long
    //   880	821	11	l3	long
    //   102	3	13	bool	boolean
    //   25	47	14	localFileReader	java.io.FileReader
    //   79	3	14	localException1	Exception
    //   914	663	14	localStringBuilder	StringBuilder
    //   1585	1	14	localFileNotFoundException1	java.io.FileNotFoundException
    //   1590	1	14	localIOException1	java.io.IOException
    //   1595	1	14	localNumberFormatException1	java.lang.NumberFormatException
    //   1666	1	14	localException2	Exception
    //   1672	20	14	localObject1	Object
    //   36	1047	15	localObject2	Object
    //   1600	1	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   1605	1	15	localIOException2	java.io.IOException
    //   1610	1	15	localNumberFormatException2	java.lang.NumberFormatException
    //   1676	18	15	localObject3	Object
    //   43	800	16	str	String
    //   859	1	16	localObject4	Object
    //   864	1	16	localObject5	Object
    //   911	41	16	localObject6	Object
    //   1615	1	16	localFileNotFoundException3	java.io.FileNotFoundException
    //   1627	1	16	localIOException3	java.io.IOException
    //   1639	1	16	localNumberFormatException3	java.lang.NumberFormatException
    //   1661	1	16	localNumberFormatException4	java.lang.NumberFormatException
    //   163	546	17	localObject7	Object
    //   1651	1	18	localNumberFormatException5	java.lang.NumberFormatException
    //   1656	1	18	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   60	65	79	java/lang/Exception
    //   71	76	79	java/lang/Exception
    //   980	985	79	java/lang/Exception
    //   1004	1009	79	java/lang/Exception
    //   1031	1036	79	java/lang/Exception
    //   1055	1060	79	java/lang/Exception
    //   1082	1087	79	java/lang/Exception
    //   1106	1111	79	java/lang/Exception
    //   38	45	859	finally
    //   50	54	859	finally
    //   95	104	859	finally
    //   109	118	859	finally
    //   124	209	859	finally
    //   212	231	859	finally
    //   237	256	859	finally
    //   261	268	859	finally
    //   273	282	859	finally
    //   288	295	859	finally
    //   302	323	859	finally
    //   335	349	859	finally
    //   349	408	859	finally
    //   411	430	859	finally
    //   436	456	859	finally
    //   456	515	859	finally
    //   518	537	859	finally
    //   543	563	859	finally
    //   563	622	859	finally
    //   625	657	859	finally
    //   657	716	859	finally
    //   719	738	859	finally
    //   744	763	859	finally
    //   763	770	859	finally
    //   798	817	859	finally
    //   823	842	859	finally
    //   842	848	859	finally
    //   27	38	864	finally
    //   16	27	911	finally
    //   16	27	1585	java/io/FileNotFoundException
    //   16	27	1590	java/io/IOException
    //   16	27	1595	java/lang/NumberFormatException
    //   27	38	1600	java/io/FileNotFoundException
    //   27	38	1605	java/io/IOException
    //   27	38	1610	java/lang/NumberFormatException
    //   38	45	1615	java/io/FileNotFoundException
    //   50	54	1615	java/io/FileNotFoundException
    //   95	104	1615	java/io/FileNotFoundException
    //   109	118	1615	java/io/FileNotFoundException
    //   124	209	1615	java/io/FileNotFoundException
    //   212	231	1615	java/io/FileNotFoundException
    //   237	256	1615	java/io/FileNotFoundException
    //   261	268	1615	java/io/FileNotFoundException
    //   273	282	1615	java/io/FileNotFoundException
    //   288	295	1615	java/io/FileNotFoundException
    //   302	323	1615	java/io/FileNotFoundException
    //   335	349	1615	java/io/FileNotFoundException
    //   349	408	1615	java/io/FileNotFoundException
    //   411	430	1615	java/io/FileNotFoundException
    //   436	456	1615	java/io/FileNotFoundException
    //   456	515	1615	java/io/FileNotFoundException
    //   518	537	1615	java/io/FileNotFoundException
    //   543	563	1615	java/io/FileNotFoundException
    //   563	622	1615	java/io/FileNotFoundException
    //   625	657	1615	java/io/FileNotFoundException
    //   657	716	1615	java/io/FileNotFoundException
    //   719	738	1615	java/io/FileNotFoundException
    //   744	763	1615	java/io/FileNotFoundException
    //   763	770	1615	java/io/FileNotFoundException
    //   798	817	1615	java/io/FileNotFoundException
    //   823	842	1615	java/io/FileNotFoundException
    //   842	848	1615	java/io/FileNotFoundException
    //   38	45	1627	java/io/IOException
    //   50	54	1627	java/io/IOException
    //   95	104	1627	java/io/IOException
    //   109	118	1627	java/io/IOException
    //   124	209	1627	java/io/IOException
    //   212	231	1627	java/io/IOException
    //   237	256	1627	java/io/IOException
    //   261	268	1627	java/io/IOException
    //   273	282	1627	java/io/IOException
    //   288	295	1627	java/io/IOException
    //   302	323	1627	java/io/IOException
    //   335	349	1627	java/io/IOException
    //   349	408	1627	java/io/IOException
    //   411	430	1627	java/io/IOException
    //   436	456	1627	java/io/IOException
    //   456	515	1627	java/io/IOException
    //   518	537	1627	java/io/IOException
    //   543	563	1627	java/io/IOException
    //   563	622	1627	java/io/IOException
    //   625	657	1627	java/io/IOException
    //   657	716	1627	java/io/IOException
    //   719	738	1627	java/io/IOException
    //   744	763	1627	java/io/IOException
    //   763	770	1627	java/io/IOException
    //   798	817	1627	java/io/IOException
    //   823	842	1627	java/io/IOException
    //   842	848	1627	java/io/IOException
    //   38	45	1639	java/lang/NumberFormatException
    //   50	54	1639	java/lang/NumberFormatException
    //   95	104	1639	java/lang/NumberFormatException
    //   109	118	1639	java/lang/NumberFormatException
    //   124	209	1639	java/lang/NumberFormatException
    //   212	231	1639	java/lang/NumberFormatException
    //   237	256	1639	java/lang/NumberFormatException
    //   261	268	1639	java/lang/NumberFormatException
    //   288	295	1639	java/lang/NumberFormatException
    //   335	349	1639	java/lang/NumberFormatException
    //   349	408	1639	java/lang/NumberFormatException
    //   411	430	1639	java/lang/NumberFormatException
    //   436	456	1639	java/lang/NumberFormatException
    //   456	515	1639	java/lang/NumberFormatException
    //   518	537	1639	java/lang/NumberFormatException
    //   543	563	1639	java/lang/NumberFormatException
    //   563	622	1639	java/lang/NumberFormatException
    //   625	657	1639	java/lang/NumberFormatException
    //   657	716	1639	java/lang/NumberFormatException
    //   719	738	1639	java/lang/NumberFormatException
    //   744	763	1639	java/lang/NumberFormatException
    //   798	817	1639	java/lang/NumberFormatException
    //   823	842	1639	java/lang/NumberFormatException
    //   273	282	1651	java/lang/NumberFormatException
    //   302	323	1656	java/lang/NumberFormatException
    //   763	770	1661	java/lang/NumberFormatException
    //   842	848	1661	java/lang/NumberFormatException
    //   925	930	1666	java/lang/Exception
    //   938	943	1666	java/lang/Exception
  }
  
  public static String getCpuReport()
  {
    getCpuInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prcs(");
    localStringBuilder.append(mProcessorName);
    localStringBuilder.append(") arch(");
    localStringBuilder.append(mCpuArchitecture);
    localStringBuilder.append(") hard(");
    localStringBuilder.append(mHardware);
    localStringBuilder.append(") chip(");
    localStringBuilder.append(mChip);
    localStringBuilder.append(") freq(");
    localStringBuilder.append(mMaxCpuFreq);
    localStringBuilder.append(") num(");
    localStringBuilder.append(mCoreNumber);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 8
    //   12: lconst_0
    //   13: lstore_2
    //   14: ldc 35
    //   16: astore 12
    //   18: new 91	java/io/FileReader
    //   21: dup
    //   22: ldc_w 290
    //   25: invokespecial 96	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   28: astore 6
    //   30: new 98	java/io/BufferedReader
    //   33: dup
    //   34: aload 6
    //   36: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 9
    //   48: aload 12
    //   50: astore 8
    //   52: aload 9
    //   54: ifnull +22 -> 76
    //   57: aload 12
    //   59: astore 8
    //   61: aload 9
    //   63: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +10 -> 76
    //   69: aload 9
    //   71: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   74: astore 8
    //   76: lload_2
    //   77: lstore_0
    //   78: aload 8
    //   80: ifnull +19 -> 99
    //   83: lload_2
    //   84: lstore_0
    //   85: aload 8
    //   87: invokevirtual 126	java/lang/String:length	()I
    //   90: ifle +9 -> 99
    //   93: aload 8
    //   95: invokestatic 165	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   98: lstore_0
    //   99: lload_0
    //   100: lstore 4
    //   102: aload 7
    //   104: invokevirtual 107	java/io/BufferedReader:close	()V
    //   107: lload_0
    //   108: lstore 4
    //   110: aload 6
    //   112: invokevirtual 108	java/io/FileReader:close	()V
    //   115: lload_0
    //   116: lreturn
    //   117: astore 6
    //   119: aload 6
    //   121: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   124: lload 4
    //   126: lreturn
    //   127: astore 9
    //   129: aload 7
    //   131: astore 8
    //   133: aload 9
    //   135: astore 7
    //   137: goto +22 -> 159
    //   140: goto +60 -> 200
    //   143: goto +85 -> 228
    //   146: goto +110 -> 256
    //   149: astore 7
    //   151: goto +8 -> 159
    //   154: astore 7
    //   156: aconst_null
    //   157: astore 6
    //   159: aload 8
    //   161: ifnull +11 -> 172
    //   164: aload 8
    //   166: invokevirtual 107	java/io/BufferedReader:close	()V
    //   169: goto +3 -> 172
    //   172: aload 6
    //   174: ifnull +16 -> 190
    //   177: aload 6
    //   179: invokevirtual 108	java/io/FileReader:close	()V
    //   182: goto +8 -> 190
    //   185: aload 6
    //   187: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   190: aload 7
    //   192: athrow
    //   193: aconst_null
    //   194: astore 6
    //   196: aload 9
    //   198: astore 7
    //   200: aload 7
    //   202: ifnull +11 -> 213
    //   205: lload_2
    //   206: lstore 4
    //   208: aload 7
    //   210: invokevirtual 107	java/io/BufferedReader:close	()V
    //   213: aload 6
    //   215: ifnull +67 -> 282
    //   218: lload_2
    //   219: lstore 4
    //   221: aload 6
    //   223: invokevirtual 108	java/io/FileReader:close	()V
    //   226: lconst_0
    //   227: lreturn
    //   228: aload 7
    //   230: ifnull +11 -> 241
    //   233: lload_2
    //   234: lstore 4
    //   236: aload 7
    //   238: invokevirtual 107	java/io/BufferedReader:close	()V
    //   241: aload 6
    //   243: ifnull +39 -> 282
    //   246: lload_2
    //   247: lstore 4
    //   249: aload 6
    //   251: invokevirtual 108	java/io/FileReader:close	()V
    //   254: lconst_0
    //   255: lreturn
    //   256: aload 7
    //   258: ifnull +11 -> 269
    //   261: lload_2
    //   262: lstore 4
    //   264: aload 7
    //   266: invokevirtual 107	java/io/BufferedReader:close	()V
    //   269: aload 6
    //   271: ifnull +11 -> 282
    //   274: lload_2
    //   275: lstore 4
    //   277: aload 6
    //   279: invokevirtual 108	java/io/FileReader:close	()V
    //   282: lconst_0
    //   283: lreturn
    //   284: astore 6
    //   286: goto +70 -> 356
    //   289: astore 6
    //   291: goto +55 -> 346
    //   294: astore 6
    //   296: goto -103 -> 193
    //   299: astore 7
    //   301: aload 11
    //   303: astore 7
    //   305: goto -49 -> 256
    //   308: astore 7
    //   310: aload 10
    //   312: astore 7
    //   314: goto -86 -> 228
    //   317: astore 7
    //   319: aload 9
    //   321: astore 7
    //   323: goto -123 -> 200
    //   326: astore 8
    //   328: goto -182 -> 146
    //   331: astore 8
    //   333: goto -190 -> 143
    //   336: astore 8
    //   338: goto -198 -> 140
    //   341: astore 6
    //   343: goto -158 -> 185
    //   346: aconst_null
    //   347: astore 6
    //   349: aload 10
    //   351: astore 7
    //   353: goto -125 -> 228
    //   356: aconst_null
    //   357: astore 6
    //   359: aload 11
    //   361: astore 7
    //   363: goto -107 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   77	39	0	l1	long
    //   13	262	2	l2	long
    //   100	176	4	l3	long
    //   28	83	6	localFileReader	java.io.FileReader
    //   117	3	6	localException1	Exception
    //   157	121	6	localObject1	Object
    //   284	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   289	1	6	localIOException1	java.io.IOException
    //   294	1	6	localNumberFormatException1	java.lang.NumberFormatException
    //   341	1	6	localException2	Exception
    //   347	11	6	localObject2	Object
    //   39	97	7	localObject3	Object
    //   149	1	7	localObject4	Object
    //   154	37	7	localObject5	Object
    //   198	67	7	localObject6	Object
    //   299	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   303	1	7	localObject7	Object
    //   308	1	7	localIOException2	java.io.IOException
    //   312	1	7	localObject8	Object
    //   317	1	7	localNumberFormatException2	java.lang.NumberFormatException
    //   321	41	7	localObject9	Object
    //   10	155	8	localObject10	Object
    //   326	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   331	1	8	localIOException3	java.io.IOException
    //   336	1	8	localNumberFormatException3	java.lang.NumberFormatException
    //   1	69	9	str1	String
    //   127	193	9	localObject11	Object
    //   4	346	10	localObject12	Object
    //   7	353	11	localObject13	Object
    //   16	42	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   102	107	117	java/lang/Exception
    //   110	115	117	java/lang/Exception
    //   208	213	117	java/lang/Exception
    //   221	226	117	java/lang/Exception
    //   236	241	117	java/lang/Exception
    //   249	254	117	java/lang/Exception
    //   264	269	117	java/lang/Exception
    //   277	282	117	java/lang/Exception
    //   41	48	127	finally
    //   61	76	127	finally
    //   85	99	127	finally
    //   30	41	149	finally
    //   18	30	154	finally
    //   18	30	284	java/io/FileNotFoundException
    //   18	30	289	java/io/IOException
    //   18	30	294	java/lang/NumberFormatException
    //   30	41	299	java/io/FileNotFoundException
    //   30	41	308	java/io/IOException
    //   30	41	317	java/lang/NumberFormatException
    //   41	48	326	java/io/FileNotFoundException
    //   61	76	326	java/io/FileNotFoundException
    //   85	99	326	java/io/FileNotFoundException
    //   41	48	331	java/io/IOException
    //   61	76	331	java/io/IOException
    //   85	99	331	java/io/IOException
    //   41	48	336	java/lang/NumberFormatException
    //   61	76	336	java/lang/NumberFormatException
    //   85	99	336	java/lang/NumberFormatException
    //   164	169	341	java/lang/Exception
    //   177	182	341	java/lang/Exception
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceNameForConfigSystem()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MODEL);
    return localStringBuilder.toString();
  }
  
  public static long getMaxCpuFreq()
  {
    getCpuInfo();
    return mMaxCpuFreq;
  }
  
  public static String getModelReport()
  {
    getCpuInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("model(");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(") Mnfc(");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(") dev(");
    localStringBuilder.append(Build.VERSION.INCREMENTAL);
    localStringBuilder.append(") sdk(");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append(") gl(");
    localStringBuilder.append(mOpenGLVersion);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static int getNumCores()
  {
    getCpuInfo();
    return mCoreNumber;
  }
  
  public static boolean hasFeature(String paramString)
  {
    try
    {
      if ((mFeature == null) || (mFeature.equals(""))) {
        getCpuInfo();
      }
      int i = mFeature.indexOf(paramString);
      if (i > 0) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      label34:
      break label34;
    }
    return false;
  }
  
  public static boolean isBeautySupported()
  {
    return ((hasFeature("neon")) || (hasFeature("asimd"))) && (getNumCores() >= 2) && (getCpuArchitecture() >= 4);
  }
  
  public static boolean isLowLevelDevice()
  {
    if (Build.VERSION.SDK_INT < 11) {
      return true;
    }
    if (mgNumCores == 0) {
      mgNumCores = getNumCores();
    }
    if (mgMaxCpuFreq == 0L) {
      mgMaxCpuFreq = getMaxCpuFreq();
    }
    return (mgNumCores <= 1) && (mgMaxCpuFreq <= 1025000L);
  }
  
  public static boolean isNeonSupported()
  {
    return (hasFeature("neon")) || (hasFeature("asimd"));
  }
  
  public static boolean isNormalSharp()
  {
    getCpuInfo();
    return (mChip >= 3) && (mMaxCpuFreq / 1000L >= 800L) && (Build.VERSION.SDK_INT >= 9);
  }
  
  public static boolean isSupportSharpAudio()
  {
    getCpuInfo();
    return mIsSupportSharpAudio;
  }
  
  public static boolean isSupportSharpVideo()
  {
    
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isSupportSharpVideo] [CpuInfo] mProcessorName=");
      localStringBuilder.append(mProcessorName);
      localStringBuilder.append(" \nmCpuArchitecture=");
      localStringBuilder.append(mCpuArchitecture);
      localStringBuilder.append(" \nmFeature=");
      localStringBuilder.append(mFeature);
      localStringBuilder.append(" \nmVendorId=");
      localStringBuilder.append(mVendorId);
      localStringBuilder.append(" \nmMaxCpuFreq=");
      localStringBuilder.append(mMaxCpuFreq);
      localStringBuilder.append(" \nmCoreNumber=");
      localStringBuilder.append(mCoreNumber);
      localStringBuilder.append(" \nmOpenGLVersion=");
      localStringBuilder.append(mOpenGLVersion);
      localStringBuilder.append(" \nmIsMarvell=");
      localStringBuilder.append(mIsMarvell);
      localStringBuilder.append(" \nChip=");
      localStringBuilder.append(mChip);
      localStringBuilder.append(", Video=");
      localStringBuilder.append(mIsSupportSharpVideo);
      localStringBuilder.append(", Audio=");
      localStringBuilder.append(mIsSupportSharpAudio);
      localStringBuilder.append(" \ndevModel=");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append(" \ndevVersion=");
      localStringBuilder.append(Build.VERSION.INCREMENTAL);
      localStringBuilder.append(" \ndevManufacturer=");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(" \nsdkVersion=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append(" \n");
      QLog.d("VcSystemInfo", 0, localStringBuilder.toString());
    }
    return mIsSupportSharpVideo;
  }
  
  static int readCpuArchitecture()
  {
    if (mProcessorName.contains("ARMv6")) {
      return 2;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
      return 4;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("armeabi")) {
      return 2;
    }
    if ((mCpuArchitecture == 7) && (mFeature.indexOf("neon") < 0))
    {
      long l = getMaxCpuFreq();
      i = getNumCores();
      if ((l < 1100000L) || (i < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    int i = mCpuArchitecture;
    if (i != 5)
    {
      if (i != 6)
      {
        if (i != 7)
        {
          if (i != 8)
          {
            String str = mVendorId;
            if ((str != null) && ((str.equalsIgnoreCase("AuthenticAMD")) || (mVendorId.equalsIgnoreCase("GenuineIntel")))) {
              return 7;
            }
            return 0;
          }
          return 5;
        }
        return 4;
      }
      return 2;
    }
    return 1;
  }
  
  /* Error */
  static long readMaxCpuFreq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 8
    //   12: lconst_0
    //   13: lstore_2
    //   14: ldc 35
    //   16: astore 12
    //   18: new 91	java/io/FileReader
    //   21: dup
    //   22: ldc_w 416
    //   25: invokespecial 96	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   28: astore 6
    //   30: new 98	java/io/BufferedReader
    //   33: dup
    //   34: aload 6
    //   36: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 9
    //   48: aload 12
    //   50: astore 8
    //   52: aload 9
    //   54: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +10 -> 67
    //   60: aload 9
    //   62: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   65: astore 8
    //   67: lload_2
    //   68: lstore_0
    //   69: aload 8
    //   71: ifnull +19 -> 90
    //   74: lload_2
    //   75: lstore_0
    //   76: aload 8
    //   78: invokevirtual 126	java/lang/String:length	()I
    //   81: ifle +9 -> 90
    //   84: aload 8
    //   86: invokestatic 165	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   89: lstore_0
    //   90: lload_0
    //   91: lstore 4
    //   93: aload 7
    //   95: invokevirtual 107	java/io/BufferedReader:close	()V
    //   98: lload_0
    //   99: lstore 4
    //   101: aload 6
    //   103: invokevirtual 108	java/io/FileReader:close	()V
    //   106: lload_0
    //   107: lreturn
    //   108: astore 6
    //   110: aload 6
    //   112: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   115: lload 4
    //   117: lreturn
    //   118: astore 9
    //   120: aload 7
    //   122: astore 8
    //   124: aload 9
    //   126: astore 7
    //   128: goto +22 -> 150
    //   131: goto +60 -> 191
    //   134: goto +85 -> 219
    //   137: goto +110 -> 247
    //   140: astore 7
    //   142: goto +8 -> 150
    //   145: astore 7
    //   147: aconst_null
    //   148: astore 6
    //   150: aload 8
    //   152: ifnull +11 -> 163
    //   155: aload 8
    //   157: invokevirtual 107	java/io/BufferedReader:close	()V
    //   160: goto +3 -> 163
    //   163: aload 6
    //   165: ifnull +16 -> 181
    //   168: aload 6
    //   170: invokevirtual 108	java/io/FileReader:close	()V
    //   173: goto +8 -> 181
    //   176: aload 6
    //   178: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   181: aload 7
    //   183: athrow
    //   184: aconst_null
    //   185: astore 6
    //   187: aload 9
    //   189: astore 7
    //   191: aload 7
    //   193: ifnull +11 -> 204
    //   196: lload_2
    //   197: lstore 4
    //   199: aload 7
    //   201: invokevirtual 107	java/io/BufferedReader:close	()V
    //   204: aload 6
    //   206: ifnull +67 -> 273
    //   209: lload_2
    //   210: lstore 4
    //   212: aload 6
    //   214: invokevirtual 108	java/io/FileReader:close	()V
    //   217: lconst_0
    //   218: lreturn
    //   219: aload 7
    //   221: ifnull +11 -> 232
    //   224: lload_2
    //   225: lstore 4
    //   227: aload 7
    //   229: invokevirtual 107	java/io/BufferedReader:close	()V
    //   232: aload 6
    //   234: ifnull +39 -> 273
    //   237: lload_2
    //   238: lstore 4
    //   240: aload 6
    //   242: invokevirtual 108	java/io/FileReader:close	()V
    //   245: lconst_0
    //   246: lreturn
    //   247: aload 7
    //   249: ifnull +11 -> 260
    //   252: lload_2
    //   253: lstore 4
    //   255: aload 7
    //   257: invokevirtual 107	java/io/BufferedReader:close	()V
    //   260: aload 6
    //   262: ifnull +11 -> 273
    //   265: lload_2
    //   266: lstore 4
    //   268: aload 6
    //   270: invokevirtual 108	java/io/FileReader:close	()V
    //   273: lconst_0
    //   274: lreturn
    //   275: astore 6
    //   277: goto +70 -> 347
    //   280: astore 6
    //   282: goto +55 -> 337
    //   285: astore 6
    //   287: goto -103 -> 184
    //   290: astore 7
    //   292: aload 11
    //   294: astore 7
    //   296: goto -49 -> 247
    //   299: astore 7
    //   301: aload 10
    //   303: astore 7
    //   305: goto -86 -> 219
    //   308: astore 7
    //   310: aload 9
    //   312: astore 7
    //   314: goto -123 -> 191
    //   317: astore 8
    //   319: goto -182 -> 137
    //   322: astore 8
    //   324: goto -190 -> 134
    //   327: astore 8
    //   329: goto -198 -> 131
    //   332: astore 6
    //   334: goto -158 -> 176
    //   337: aconst_null
    //   338: astore 6
    //   340: aload 10
    //   342: astore 7
    //   344: goto -125 -> 219
    //   347: aconst_null
    //   348: astore 6
    //   350: aload 11
    //   352: astore 7
    //   354: goto -107 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   68	39	0	l1	long
    //   13	253	2	l2	long
    //   91	176	4	l3	long
    //   28	74	6	localFileReader	java.io.FileReader
    //   108	3	6	localException1	Exception
    //   148	121	6	localObject1	Object
    //   275	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   280	1	6	localIOException1	java.io.IOException
    //   285	1	6	localNumberFormatException1	java.lang.NumberFormatException
    //   332	1	6	localException2	Exception
    //   338	11	6	localObject2	Object
    //   39	88	7	localObject3	Object
    //   140	1	7	localObject4	Object
    //   145	37	7	localObject5	Object
    //   189	67	7	localObject6	Object
    //   290	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   294	1	7	localObject7	Object
    //   299	1	7	localIOException2	java.io.IOException
    //   303	1	7	localObject8	Object
    //   308	1	7	localNumberFormatException2	java.lang.NumberFormatException
    //   312	41	7	localObject9	Object
    //   10	146	8	localObject10	Object
    //   317	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   322	1	8	localIOException3	java.io.IOException
    //   327	1	8	localNumberFormatException3	java.lang.NumberFormatException
    //   1	60	9	str1	String
    //   118	193	9	localObject11	Object
    //   4	337	10	localObject12	Object
    //   7	344	11	localObject13	Object
    //   16	33	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   93	98	108	java/lang/Exception
    //   101	106	108	java/lang/Exception
    //   199	204	108	java/lang/Exception
    //   212	217	108	java/lang/Exception
    //   227	232	108	java/lang/Exception
    //   240	245	108	java/lang/Exception
    //   255	260	108	java/lang/Exception
    //   268	273	108	java/lang/Exception
    //   41	48	118	finally
    //   52	67	118	finally
    //   76	90	118	finally
    //   30	41	140	finally
    //   18	30	145	finally
    //   18	30	275	java/io/FileNotFoundException
    //   18	30	280	java/io/IOException
    //   18	30	285	java/lang/NumberFormatException
    //   30	41	290	java/io/FileNotFoundException
    //   30	41	299	java/io/IOException
    //   30	41	308	java/lang/NumberFormatException
    //   41	48	317	java/io/FileNotFoundException
    //   52	67	317	java/io/FileNotFoundException
    //   76	90	317	java/io/FileNotFoundException
    //   41	48	322	java/io/IOException
    //   52	67	322	java/io/IOException
    //   76	90	322	java/io/IOException
    //   41	48	327	java/lang/NumberFormatException
    //   52	67	327	java/lang/NumberFormatException
    //   76	90	327	java/lang/NumberFormatException
    //   155	160	332	java/lang/Exception
    //   168	173	332	java/lang/Exception
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new VcSystemInfo.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 0;
  }
  
  static boolean readSupportSharpAudio()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.INCREMENTAL;
    String str3 = Build.MANUFACTURER;
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Model: ");
      localStringBuilder.append(str1);
      localStringBuilder.append("\nVersion: ");
      localStringBuilder.append(str2);
      localStringBuilder.append("\nManufacturer: ");
      localStringBuilder.append(str3);
      localStringBuilder.append("\nSDK Version: ");
      localStringBuilder.append(i);
      QLog.d("VcSystemInfo", 0, localStringBuilder.toString());
    }
    if ((mChip >= 1) && (i >= 8))
    {
      if ((str3.equalsIgnoreCase("HUAWEI")) && (str1.equalsIgnoreCase("C8500")))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("VcSystemInfo", 0, "DEVICE_NOT_SUPPORT");
          return false;
        }
      }
      else if ((str3.equalsIgnoreCase("Samsung")) && (str1.equalsIgnoreCase("GT-I5508")))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("VcSystemInfo", 0, "DEVICE_NOT_SUPPORT");
          return false;
        }
      }
      else if ((str3.equalsIgnoreCase("FIH")) && (str1.equalsIgnoreCase("SH8128U")))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("VcSystemInfo", 0, "DEVICE_NOT_SUPPORT");
          return false;
        }
      }
      else {
        return true;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 0, "CHIP or SDK NOT_SUPPORT");
    }
    return false;
  }
  
  public int getCameraFacing()
  {
    if (Build.VERSION.SDK_INT > 9) {
      return 2;
    }
    return 1;
  }
  
  public int getOsType()
  {
    int k = 200;
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT > 20) {
        return 200;
      }
      int i = 0;
      int j = str.charAt(0);
      int m = str.charAt(2);
      if (str.length() >= 5) {
        i = str.charAt(4);
      }
      switch (j)
      {
      default: 
        return 200;
      case 53: 
        j = k;
        if (m == 48) {
          return 118;
        }
        break;
      case 52: 
        if (m == 48) {
          return 113;
        }
        if (m == 49) {
          return 114;
        }
        if (m == 50) {
          return 115;
        }
        if (m == 51) {
          return 116;
        }
        j = k;
        if (m == 52) {
          return 117;
        }
        break;
      case 51: 
        if (m == 48) {
          return 110;
        }
        if (m == 49) {
          return 111;
        }
        j = k;
        if (m == 50) {
          return 112;
        }
        break;
      case 50: 
        if (m == 48)
        {
          if (i == 49) {
            return 105;
          }
          return 104;
        }
        if (m == 49) {
          return 106;
        }
        if (m == 50)
        {
          if (i == 49) {
            return 108;
          }
          return 107;
        }
        j = k;
        if (m == 51)
        {
          j = k;
          if (i >= 48)
          {
            j = k;
            if (i <= 57) {
              return 109;
            }
          }
        }
        break;
      case 49: 
        if (m == 49) {
          return 101;
        }
        if (m == 53) {
          return 102;
        }
        j = k;
        if (m == 54) {
          j = 103;
        }
        break;
      }
      return j;
    }
    catch (Exception localException) {}
    return 200;
  }
  
  public void setDispSize(int paramInt1, int paramInt2)
  {
    this.mdispWidth = paramInt1;
    this.mdispHeight = paramInt2;
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */