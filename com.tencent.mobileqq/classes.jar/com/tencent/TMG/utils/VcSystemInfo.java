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
  static int mChip;
  static int mCoreNumber;
  static int mCpuArchitecture;
  static long mCurrCpuFreq;
  static String mFeature;
  static String mHardware;
  static boolean mIsMarvell;
  static boolean mIsSupportSharpAudio;
  static boolean mIsSupportSharpVideo;
  static long mMaxCpuFreq;
  static int mOpenGLVersion;
  static String mProcessorName = "";
  static String mVendorId;
  static boolean mfReadCpuInfo;
  static long mgMaxCpuFreq = 0L;
  static int mgNumCores;
  int mScreenHeight = 480;
  int mScreenWidth = 320;
  public int mdispHeight = 240;
  public int mdispWidth = 320;
  
  static
  {
    mFeature = "";
    mVendorId = null;
    mHardware = null;
    mCpuArchitecture = 5;
    mMaxCpuFreq = 0L;
    mCoreNumber = 1;
    mCurrCpuFreq = 0L;
    mfReadCpuInfo = false;
    mOpenGLVersion = 2;
    mChip = 1;
    mIsSupportSharpAudio = true;
    mIsSupportSharpVideo = true;
    mIsMarvell = false;
    mgNumCores = 0;
  }
  
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
    //   0: getstatic 69	com/tencent/TMG/utils/VcSystemInfo:mfReadCpuInfo	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 9
    //   11: ldc2_w 111
    //   14: lstore 4
    //   16: ldc 113
    //   18: fstore_0
    //   19: new 115	java/io/FileReader
    //   22: dup
    //   23: ldc 117
    //   25: invokespecial 120	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   28: astore 8
    //   30: new 122	java/io/BufferedReader
    //   33: dup
    //   34: aload 8
    //   36: invokespecial 125	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore 9
    //   41: aload 9
    //   43: invokevirtual 128	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 10
    //   48: aload 10
    //   50: ifnonnull +262 -> 312
    //   53: iconst_1
    //   54: putstatic 69	com/tencent/TMG/utils/VcSystemInfo:mfReadCpuInfo	Z
    //   57: aload 9
    //   59: ifnull +8 -> 67
    //   62: aload 9
    //   64: invokevirtual 131	java/io/BufferedReader:close	()V
    //   67: lload 4
    //   69: lstore 6
    //   71: fload_0
    //   72: fstore_1
    //   73: aload 8
    //   75: ifnull +14 -> 89
    //   78: aload 8
    //   80: invokevirtual 132	java/io/FileReader:close	()V
    //   83: fload_0
    //   84: fstore_1
    //   85: lload 4
    //   87: lstore 6
    //   89: invokestatic 136	com/tencent/TMG/utils/VcSystemInfo:readMaxCpuFreq	()J
    //   92: lstore 4
    //   94: lload 4
    //   96: lconst_0
    //   97: lcmp
    //   98: ifle +1084 -> 1182
    //   101: lload 4
    //   103: putstatic 63	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   106: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   109: ifeq +30 -> 139
    //   112: ldc 25
    //   114: iconst_0
    //   115: new 144	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   122: ldc 147
    //   124: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 63	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   130: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   133: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: invokestatic 164	com/tencent/TMG/utils/VcSystemInfo:getCurrentCpuFreq	()J
    //   142: lstore 4
    //   144: lload 4
    //   146: lconst_0
    //   147: lcmp
    //   148: ifle +41 -> 189
    //   151: lload 4
    //   153: putstatic 67	com/tencent/TMG/utils/VcSystemInfo:mCurrCpuFreq	J
    //   156: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   159: ifeq +30 -> 189
    //   162: ldc 25
    //   164: iconst_0
    //   165: new 144	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   172: ldc 166
    //   174: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: getstatic 67	com/tencent/TMG/utils/VcSystemInfo:mCurrCpuFreq	J
    //   180: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   183: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: invokestatic 169	com/tencent/TMG/utils/VcSystemInfo:readNumCores	()I
    //   192: istore_2
    //   193: iload_2
    //   194: ifle +1087 -> 1281
    //   197: iload_2
    //   198: putstatic 65	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   201: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   204: ifeq +30 -> 234
    //   207: ldc 25
    //   209: iconst_0
    //   210: new 144	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   217: ldc 171
    //   219: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 65	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   225: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: invokestatic 177	com/tencent/TMG/utils/VcSystemInfo:readCpuArchitecture	()I
    //   237: putstatic 73	com/tencent/TMG/utils/VcSystemInfo:mChip	I
    //   240: invokestatic 180	com/tencent/TMG/utils/VcSystemInfo:readSupportSharpAudio	()Z
    //   243: putstatic 75	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpAudio	Z
    //   246: getstatic 75	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpAudio	Z
    //   249: ifeq +1082 -> 1331
    //   252: iconst_1
    //   253: putstatic 77	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpVideo	Z
    //   256: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   259: ifeq -252 -> 7
    //   262: ldc 25
    //   264: iconst_0
    //   265: new 144	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   272: ldc 182
    //   274: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 73	com/tencent/TMG/utils/VcSystemInfo:mChip	I
    //   280: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc 184
    //   285: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: getstatic 77	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpVideo	Z
    //   291: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   294: ldc 189
    //   296: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: getstatic 75	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpAudio	Z
    //   302: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   305: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: return
    //   312: aload 10
    //   314: ldc 191
    //   316: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   319: ifeq +140 -> 459
    //   322: aload 10
    //   324: bipush 58
    //   326: invokevirtual 201	java/lang/String:indexOf	(I)I
    //   329: istore_2
    //   330: iload_2
    //   331: iconst_1
    //   332: if_icmple -291 -> 41
    //   335: aload 10
    //   337: iload_2
    //   338: iconst_1
    //   339: iadd
    //   340: aload 10
    //   342: invokevirtual 204	java/lang/String:length	()I
    //   345: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   348: putstatic 53	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   351: getstatic 53	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   354: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   357: putstatic 53	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   360: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   363: ifeq -322 -> 41
    //   366: ldc 25
    //   368: iconst_0
    //   369: new 144	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   376: ldc 213
    //   378: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: getstatic 53	com/tencent/TMG/utils/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   384: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc 215
    //   389: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 10
    //   394: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: goto -362 -> 41
    //   406: astore 10
    //   408: aload 9
    //   410: ifnull +8 -> 418
    //   413: aload 9
    //   415: invokevirtual 131	java/io/BufferedReader:close	()V
    //   418: lload 4
    //   420: lstore 6
    //   422: fload_0
    //   423: fstore_1
    //   424: aload 8
    //   426: ifnull -337 -> 89
    //   429: aload 8
    //   431: invokevirtual 132	java/io/FileReader:close	()V
    //   434: lload 4
    //   436: lstore 6
    //   438: fload_0
    //   439: fstore_1
    //   440: goto -351 -> 89
    //   443: astore 8
    //   445: aload 8
    //   447: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   450: lload 4
    //   452: lstore 6
    //   454: fload_0
    //   455: fstore_1
    //   456: goto -367 -> 89
    //   459: aload 10
    //   461: ldc 220
    //   463: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   466: ifeq +218 -> 684
    //   469: aload 10
    //   471: bipush 58
    //   473: invokevirtual 201	java/lang/String:indexOf	(I)I
    //   476: istore_2
    //   477: iload_2
    //   478: iconst_1
    //   479: if_icmple +45 -> 524
    //   482: aload 10
    //   484: iload_2
    //   485: iconst_1
    //   486: iadd
    //   487: aload 10
    //   489: invokevirtual 204	java/lang/String:length	()I
    //   492: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   495: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   498: astore 11
    //   500: aload 11
    //   502: ifnull +22 -> 524
    //   505: aload 11
    //   507: invokevirtual 204	java/lang/String:length	()I
    //   510: istore_2
    //   511: iload_2
    //   512: ifle +12 -> 524
    //   515: aload 11
    //   517: invokestatic 226	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   520: l2i
    //   521: putstatic 61	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   524: aload 10
    //   526: ldc 228
    //   528: invokevirtual 232	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   531: ifeq +7 -> 538
    //   534: iconst_5
    //   535: putstatic 61	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   538: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   541: ifeq -500 -> 41
    //   544: ldc 25
    //   546: iconst_0
    //   547: new 144	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   554: ldc 234
    //   556: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: getstatic 61	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   562: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: ldc 215
    //   567: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload 10
    //   572: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: goto -540 -> 41
    //   584: astore 10
    //   586: aload 9
    //   588: ifnull +8 -> 596
    //   591: aload 9
    //   593: invokevirtual 131	java/io/BufferedReader:close	()V
    //   596: lload 4
    //   598: lstore 6
    //   600: fload_0
    //   601: fstore_1
    //   602: aload 8
    //   604: ifnull -515 -> 89
    //   607: aload 8
    //   609: invokevirtual 132	java/io/FileReader:close	()V
    //   612: lload 4
    //   614: lstore 6
    //   616: fload_0
    //   617: fstore_1
    //   618: goto -529 -> 89
    //   621: astore 8
    //   623: aload 8
    //   625: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   628: lload 4
    //   630: lstore 6
    //   632: fload_0
    //   633: fstore_1
    //   634: goto -545 -> 89
    //   637: astore 12
    //   639: iconst_1
    //   640: istore_2
    //   641: aload 11
    //   643: invokevirtual 204	java/lang/String:length	()I
    //   646: istore_3
    //   647: iload_2
    //   648: iload_3
    //   649: if_icmpge -125 -> 524
    //   652: aload 11
    //   654: iconst_0
    //   655: aload 11
    //   657: invokevirtual 204	java/lang/String:length	()I
    //   660: iload_2
    //   661: isub
    //   662: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   665: invokestatic 226	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   668: l2i
    //   669: putstatic 61	com/tencent/TMG/utils/VcSystemInfo:mCpuArchitecture	I
    //   672: goto -148 -> 524
    //   675: astore 12
    //   677: iload_2
    //   678: iconst_1
    //   679: iadd
    //   680: istore_2
    //   681: goto -40 -> 641
    //   684: aload 10
    //   686: ldc 236
    //   688: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   691: ifeq +134 -> 825
    //   694: aload 10
    //   696: bipush 58
    //   698: invokevirtual 201	java/lang/String:indexOf	(I)I
    //   701: istore_2
    //   702: iload_2
    //   703: iconst_1
    //   704: if_icmple +22 -> 726
    //   707: aload 10
    //   709: iload_2
    //   710: iconst_1
    //   711: iadd
    //   712: aload 10
    //   714: invokevirtual 204	java/lang/String:length	()I
    //   717: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   720: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   723: putstatic 55	com/tencent/TMG/utils/VcSystemInfo:mFeature	Ljava/lang/String;
    //   726: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   729: ifeq -688 -> 41
    //   732: ldc 25
    //   734: iconst_0
    //   735: new 144	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   742: ldc 238
    //   744: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: getstatic 55	com/tencent/TMG/utils/VcSystemInfo:mFeature	Ljava/lang/String;
    //   750: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc 215
    //   755: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 10
    //   760: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: goto -728 -> 41
    //   772: astore 10
    //   774: aload 9
    //   776: ifnull +8 -> 784
    //   779: aload 9
    //   781: invokevirtual 131	java/io/BufferedReader:close	()V
    //   784: lload 4
    //   786: lstore 6
    //   788: fload_0
    //   789: fstore_1
    //   790: aload 8
    //   792: ifnull -703 -> 89
    //   795: aload 8
    //   797: invokevirtual 132	java/io/FileReader:close	()V
    //   800: lload 4
    //   802: lstore 6
    //   804: fload_0
    //   805: fstore_1
    //   806: goto -717 -> 89
    //   809: astore 8
    //   811: aload 8
    //   813: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   816: lload 4
    //   818: lstore 6
    //   820: fload_0
    //   821: fstore_1
    //   822: goto -733 -> 89
    //   825: aload 10
    //   827: ldc 240
    //   829: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   832: ifeq +114 -> 946
    //   835: aload 10
    //   837: bipush 58
    //   839: invokevirtual 201	java/lang/String:indexOf	(I)I
    //   842: istore_2
    //   843: iload_2
    //   844: iconst_1
    //   845: if_icmple +22 -> 867
    //   848: aload 10
    //   850: iload_2
    //   851: iconst_1
    //   852: iadd
    //   853: aload 10
    //   855: invokevirtual 204	java/lang/String:length	()I
    //   858: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   861: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   864: putstatic 57	com/tencent/TMG/utils/VcSystemInfo:mVendorId	Ljava/lang/String;
    //   867: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   870: ifeq -829 -> 41
    //   873: ldc 25
    //   875: iconst_0
    //   876: new 144	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   883: ldc 242
    //   885: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: getstatic 57	com/tencent/TMG/utils/VcSystemInfo:mVendorId	Ljava/lang/String;
    //   891: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: ldc 215
    //   896: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload 10
    //   901: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -869 -> 41
    //   913: astore 11
    //   915: aload 9
    //   917: astore 10
    //   919: aload 11
    //   921: astore 9
    //   923: aload 10
    //   925: ifnull +8 -> 933
    //   928: aload 10
    //   930: invokevirtual 131	java/io/BufferedReader:close	()V
    //   933: aload 8
    //   935: ifnull +8 -> 943
    //   938: aload 8
    //   940: invokevirtual 132	java/io/FileReader:close	()V
    //   943: aload 9
    //   945: athrow
    //   946: aload 10
    //   948: ldc 244
    //   950: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   953: ifeq +71 -> 1024
    //   956: aload 10
    //   958: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   961: putstatic 59	com/tencent/TMG/utils/VcSystemInfo:mHardware	Ljava/lang/String;
    //   964: aload 10
    //   966: ldc 246
    //   968: invokevirtual 232	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   971: ifeq +7 -> 978
    //   974: iconst_1
    //   975: putstatic 79	com/tencent/TMG/utils/VcSystemInfo:mIsMarvell	Z
    //   978: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   981: ifeq -940 -> 41
    //   984: ldc 25
    //   986: iconst_0
    //   987: new 144	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   994: ldc 248
    //   996: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: getstatic 79	com/tencent/TMG/utils/VcSystemInfo:mIsMarvell	Z
    //   1002: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1005: ldc 215
    //   1007: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload 10
    //   1012: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: goto -980 -> 41
    //   1024: aload 10
    //   1026: ldc 250
    //   1028: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1031: ifeq +67 -> 1098
    //   1034: aload 10
    //   1036: bipush 58
    //   1038: invokevirtual 201	java/lang/String:indexOf	(I)I
    //   1041: istore_2
    //   1042: iload_2
    //   1043: iconst_1
    //   1044: if_icmple -1003 -> 41
    //   1047: aload 10
    //   1049: iload_2
    //   1050: iconst_1
    //   1051: iadd
    //   1052: aload 10
    //   1054: invokevirtual 204	java/lang/String:length	()I
    //   1057: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   1060: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   1063: astore 10
    //   1065: aload 10
    //   1067: invokestatic 226	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1070: lstore 6
    //   1072: lload 6
    //   1074: lconst_0
    //   1075: lcmp
    //   1076: iflt -1035 -> 41
    //   1079: lconst_1
    //   1080: lload 6
    //   1082: ladd
    //   1083: lload 4
    //   1085: lcmp
    //   1086: ifle -1045 -> 41
    //   1089: lconst_1
    //   1090: lload 6
    //   1092: ladd
    //   1093: lstore 4
    //   1095: goto -1054 -> 41
    //   1098: aload 10
    //   1100: ldc 252
    //   1102: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1105: ifeq -1064 -> 41
    //   1108: aload 10
    //   1110: bipush 58
    //   1112: invokevirtual 201	java/lang/String:indexOf	(I)I
    //   1115: istore_2
    //   1116: iload_2
    //   1117: iconst_1
    //   1118: if_icmple -1077 -> 41
    //   1121: aload 10
    //   1123: iload_2
    //   1124: iconst_1
    //   1125: iadd
    //   1126: aload 10
    //   1128: invokevirtual 204	java/lang/String:length	()I
    //   1131: invokevirtual 208	java/lang/String:substring	(II)Ljava/lang/String;
    //   1134: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   1137: astore 10
    //   1139: aload 10
    //   1141: invokestatic 258	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1144: fstore_1
    //   1145: fload_1
    //   1146: fload_0
    //   1147: fcmpl
    //   1148: ifle +281 -> 1429
    //   1151: fload_1
    //   1152: fstore_0
    //   1153: goto -1112 -> 41
    //   1156: astore 8
    //   1158: aload 8
    //   1160: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   1163: lload 4
    //   1165: lstore 6
    //   1167: fload_0
    //   1168: fstore_1
    //   1169: goto -1080 -> 89
    //   1172: astore 8
    //   1174: aload 8
    //   1176: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   1179: goto -236 -> 943
    //   1182: fload_1
    //   1183: fconst_0
    //   1184: fcmpl
    //   1185: ifle -1046 -> 139
    //   1188: ldc_w 259
    //   1191: fload_1
    //   1192: fmul
    //   1193: f2l
    //   1194: putstatic 63	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1197: fload_1
    //   1198: ldc_w 260
    //   1201: fcmpg
    //   1202: ifge +54 -> 1256
    //   1205: fload_1
    //   1206: f2d
    //   1207: ldc2_w 261
    //   1210: dmul
    //   1211: ldc2_w 263
    //   1214: dmul
    //   1215: d2l
    //   1216: putstatic 63	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1219: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1222: ifeq -1083 -> 139
    //   1225: ldc 25
    //   1227: iconst_0
    //   1228: new 144	java/lang/StringBuilder
    //   1231: dup
    //   1232: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   1235: ldc_w 266
    //   1238: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: getstatic 63	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1244: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1253: goto -1114 -> 139
    //   1256: fload_1
    //   1257: ldc_w 267
    //   1260: fcmpl
    //   1261: ifle -42 -> 1219
    //   1264: fload_1
    //   1265: f2d
    //   1266: ldc2_w 268
    //   1269: ddiv
    //   1270: ldc2_w 263
    //   1273: dmul
    //   1274: d2l
    //   1275: putstatic 63	com/tencent/TMG/utils/VcSystemInfo:mMaxCpuFreq	J
    //   1278: goto -59 -> 1219
    //   1281: lload 6
    //   1283: lconst_0
    //   1284: lcmp
    //   1285: ifle -1051 -> 234
    //   1288: lload 6
    //   1290: l2i
    //   1291: putstatic 65	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   1294: invokestatic 142	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1297: ifeq -1063 -> 234
    //   1300: ldc 25
    //   1302: iconst_0
    //   1303: new 144	java/lang/StringBuilder
    //   1306: dup
    //   1307: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   1310: ldc_w 271
    //   1313: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: getstatic 65	com/tencent/TMG/utils/VcSystemInfo:mCoreNumber	I
    //   1319: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1322: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1328: goto -1094 -> 234
    //   1331: iconst_0
    //   1332: putstatic 77	com/tencent/TMG/utils/VcSystemInfo:mIsSupportSharpVideo	Z
    //   1335: goto -1079 -> 256
    //   1338: astore 10
    //   1340: goto -1299 -> 41
    //   1343: astore 10
    //   1345: goto -1304 -> 41
    //   1348: astore 9
    //   1350: aconst_null
    //   1351: astore 8
    //   1353: aconst_null
    //   1354: astore 10
    //   1356: goto -433 -> 923
    //   1359: astore 9
    //   1361: aconst_null
    //   1362: astore 10
    //   1364: goto -441 -> 923
    //   1367: astore 8
    //   1369: aconst_null
    //   1370: astore 8
    //   1372: aconst_null
    //   1373: astore 9
    //   1375: goto -601 -> 774
    //   1378: astore 9
    //   1380: aconst_null
    //   1381: astore 9
    //   1383: goto -609 -> 774
    //   1386: astore 8
    //   1388: aconst_null
    //   1389: astore 8
    //   1391: aconst_null
    //   1392: astore 9
    //   1394: goto -808 -> 586
    //   1397: astore 9
    //   1399: aconst_null
    //   1400: astore 9
    //   1402: goto -816 -> 586
    //   1405: astore 8
    //   1407: aconst_null
    //   1408: astore 10
    //   1410: aload 9
    //   1412: astore 8
    //   1414: aload 10
    //   1416: astore 9
    //   1418: goto -1010 -> 408
    //   1421: astore 9
    //   1423: aconst_null
    //   1424: astore 9
    //   1426: goto -1018 -> 408
    //   1429: goto -276 -> 1153
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1150	0	f1	float
    //   72	1193	1	f2	float
    //   192	934	2	i	int
    //   646	4	3	j	int
    //   14	1150	4	l1	long
    //   69	1220	6	l2	long
    //   28	402	8	localFileReader	java.io.FileReader
    //   443	165	8	localException1	Exception
    //   621	175	8	localException2	Exception
    //   809	130	8	localException3	Exception
    //   1156	3	8	localException4	Exception
    //   1172	3	8	localException5	Exception
    //   1351	1	8	localObject1	Object
    //   1367	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1370	1	8	localObject2	Object
    //   1386	1	8	localIOException1	java.io.IOException
    //   1389	1	8	localObject3	Object
    //   1405	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1412	1	8	localObject4	Object
    //   9	935	9	localObject5	Object
    //   1348	1	9	localObject6	Object
    //   1359	1	9	localObject7	Object
    //   1373	1	9	localObject8	Object
    //   1378	1	9	localNumberFormatException2	java.lang.NumberFormatException
    //   1381	12	9	localObject9	Object
    //   1397	1	9	localIOException2	java.io.IOException
    //   1400	17	9	localObject10	Object
    //   1421	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   1424	1	9	localObject11	Object
    //   46	347	10	str1	String
    //   406	165	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   584	175	10	localIOException3	java.io.IOException
    //   772	128	10	localNumberFormatException3	java.lang.NumberFormatException
    //   917	223	10	localObject12	Object
    //   1338	1	10	localNumberFormatException4	java.lang.NumberFormatException
    //   1343	1	10	localNumberFormatException5	java.lang.NumberFormatException
    //   1354	61	10	localObject13	Object
    //   498	158	11	str2	String
    //   913	7	11	localObject14	Object
    //   637	1	12	localNumberFormatException6	java.lang.NumberFormatException
    //   675	1	12	localNumberFormatException7	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   41	48	406	java/io/FileNotFoundException
    //   53	57	406	java/io/FileNotFoundException
    //   312	330	406	java/io/FileNotFoundException
    //   335	403	406	java/io/FileNotFoundException
    //   459	477	406	java/io/FileNotFoundException
    //   482	500	406	java/io/FileNotFoundException
    //   505	511	406	java/io/FileNotFoundException
    //   515	524	406	java/io/FileNotFoundException
    //   524	538	406	java/io/FileNotFoundException
    //   538	581	406	java/io/FileNotFoundException
    //   641	647	406	java/io/FileNotFoundException
    //   652	672	406	java/io/FileNotFoundException
    //   684	702	406	java/io/FileNotFoundException
    //   707	726	406	java/io/FileNotFoundException
    //   726	769	406	java/io/FileNotFoundException
    //   825	843	406	java/io/FileNotFoundException
    //   848	867	406	java/io/FileNotFoundException
    //   867	910	406	java/io/FileNotFoundException
    //   946	978	406	java/io/FileNotFoundException
    //   978	1021	406	java/io/FileNotFoundException
    //   1024	1042	406	java/io/FileNotFoundException
    //   1047	1065	406	java/io/FileNotFoundException
    //   1065	1072	406	java/io/FileNotFoundException
    //   1098	1116	406	java/io/FileNotFoundException
    //   1121	1139	406	java/io/FileNotFoundException
    //   1139	1145	406	java/io/FileNotFoundException
    //   413	418	443	java/lang/Exception
    //   429	434	443	java/lang/Exception
    //   41	48	584	java/io/IOException
    //   53	57	584	java/io/IOException
    //   312	330	584	java/io/IOException
    //   335	403	584	java/io/IOException
    //   459	477	584	java/io/IOException
    //   482	500	584	java/io/IOException
    //   505	511	584	java/io/IOException
    //   515	524	584	java/io/IOException
    //   524	538	584	java/io/IOException
    //   538	581	584	java/io/IOException
    //   641	647	584	java/io/IOException
    //   652	672	584	java/io/IOException
    //   684	702	584	java/io/IOException
    //   707	726	584	java/io/IOException
    //   726	769	584	java/io/IOException
    //   825	843	584	java/io/IOException
    //   848	867	584	java/io/IOException
    //   867	910	584	java/io/IOException
    //   946	978	584	java/io/IOException
    //   978	1021	584	java/io/IOException
    //   1024	1042	584	java/io/IOException
    //   1047	1065	584	java/io/IOException
    //   1065	1072	584	java/io/IOException
    //   1098	1116	584	java/io/IOException
    //   1121	1139	584	java/io/IOException
    //   1139	1145	584	java/io/IOException
    //   591	596	621	java/lang/Exception
    //   607	612	621	java/lang/Exception
    //   515	524	637	java/lang/NumberFormatException
    //   652	672	675	java/lang/NumberFormatException
    //   41	48	772	java/lang/NumberFormatException
    //   53	57	772	java/lang/NumberFormatException
    //   312	330	772	java/lang/NumberFormatException
    //   335	403	772	java/lang/NumberFormatException
    //   459	477	772	java/lang/NumberFormatException
    //   482	500	772	java/lang/NumberFormatException
    //   505	511	772	java/lang/NumberFormatException
    //   524	538	772	java/lang/NumberFormatException
    //   538	581	772	java/lang/NumberFormatException
    //   641	647	772	java/lang/NumberFormatException
    //   684	702	772	java/lang/NumberFormatException
    //   707	726	772	java/lang/NumberFormatException
    //   726	769	772	java/lang/NumberFormatException
    //   825	843	772	java/lang/NumberFormatException
    //   848	867	772	java/lang/NumberFormatException
    //   867	910	772	java/lang/NumberFormatException
    //   946	978	772	java/lang/NumberFormatException
    //   978	1021	772	java/lang/NumberFormatException
    //   1024	1042	772	java/lang/NumberFormatException
    //   1047	1065	772	java/lang/NumberFormatException
    //   1098	1116	772	java/lang/NumberFormatException
    //   1121	1139	772	java/lang/NumberFormatException
    //   779	784	809	java/lang/Exception
    //   795	800	809	java/lang/Exception
    //   41	48	913	finally
    //   53	57	913	finally
    //   312	330	913	finally
    //   335	403	913	finally
    //   459	477	913	finally
    //   482	500	913	finally
    //   505	511	913	finally
    //   515	524	913	finally
    //   524	538	913	finally
    //   538	581	913	finally
    //   641	647	913	finally
    //   652	672	913	finally
    //   684	702	913	finally
    //   707	726	913	finally
    //   726	769	913	finally
    //   825	843	913	finally
    //   848	867	913	finally
    //   867	910	913	finally
    //   946	978	913	finally
    //   978	1021	913	finally
    //   1024	1042	913	finally
    //   1047	1065	913	finally
    //   1065	1072	913	finally
    //   1098	1116	913	finally
    //   1121	1139	913	finally
    //   1139	1145	913	finally
    //   62	67	1156	java/lang/Exception
    //   78	83	1156	java/lang/Exception
    //   928	933	1172	java/lang/Exception
    //   938	943	1172	java/lang/Exception
    //   1065	1072	1338	java/lang/NumberFormatException
    //   1139	1145	1343	java/lang/NumberFormatException
    //   19	30	1348	finally
    //   30	41	1359	finally
    //   19	30	1367	java/lang/NumberFormatException
    //   30	41	1378	java/lang/NumberFormatException
    //   19	30	1386	java/io/IOException
    //   30	41	1397	java/io/IOException
    //   19	30	1405	java/io/FileNotFoundException
    //   30	41	1421	java/io/FileNotFoundException
  }
  
  public static String getCpuReport()
  {
    getCpuInfo();
    return "prcs(" + mProcessorName + ") arch(" + mCpuArchitecture + ") hard(" + mHardware + ") chip(" + mChip + ") freq(" + mMaxCpuFreq + ") num(" + mCoreNumber + ")";
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: lconst_0
    //   13: lstore_2
    //   14: new 115	java/io/FileReader
    //   17: dup
    //   18: ldc_w 288
    //   21: invokespecial 120	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: astore 4
    //   26: new 122	java/io/BufferedReader
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 125	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore 5
    //   37: lload_2
    //   38: lstore_0
    //   39: aload 5
    //   41: ifnull +53 -> 94
    //   44: aload 5
    //   46: invokevirtual 128	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 6
    //   51: aload 6
    //   53: ifnull +297 -> 350
    //   56: aload 6
    //   58: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +289 -> 350
    //   64: aload 6
    //   66: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   69: astore 6
    //   71: lload_2
    //   72: lstore_0
    //   73: aload 6
    //   75: ifnull +19 -> 94
    //   78: lload_2
    //   79: lstore_0
    //   80: aload 6
    //   82: invokevirtual 204	java/lang/String:length	()I
    //   85: ifle +9 -> 94
    //   88: aload 6
    //   90: invokestatic 226	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   93: lstore_0
    //   94: aload 5
    //   96: ifnull +8 -> 104
    //   99: aload 5
    //   101: invokevirtual 131	java/io/BufferedReader:close	()V
    //   104: lload_0
    //   105: lstore_2
    //   106: aload 4
    //   108: ifnull +10 -> 118
    //   111: aload 4
    //   113: invokevirtual 132	java/io/FileReader:close	()V
    //   116: lload_0
    //   117: lstore_2
    //   118: lload_2
    //   119: lreturn
    //   120: astore 4
    //   122: aload 4
    //   124: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   127: lload_0
    //   128: lreturn
    //   129: astore 4
    //   131: aconst_null
    //   132: astore 6
    //   134: aload 5
    //   136: astore 4
    //   138: aload 6
    //   140: astore 5
    //   142: aload 5
    //   144: ifnull +8 -> 152
    //   147: aload 5
    //   149: invokevirtual 131	java/io/BufferedReader:close	()V
    //   152: aload 4
    //   154: ifnull -36 -> 118
    //   157: aload 4
    //   159: invokevirtual 132	java/io/FileReader:close	()V
    //   162: lconst_0
    //   163: lreturn
    //   164: astore 4
    //   166: aload 4
    //   168: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   171: lconst_0
    //   172: lreturn
    //   173: astore 4
    //   175: aconst_null
    //   176: astore 4
    //   178: aload 7
    //   180: astore 5
    //   182: aload 5
    //   184: ifnull +8 -> 192
    //   187: aload 5
    //   189: invokevirtual 131	java/io/BufferedReader:close	()V
    //   192: aload 4
    //   194: ifnull -76 -> 118
    //   197: aload 4
    //   199: invokevirtual 132	java/io/FileReader:close	()V
    //   202: lconst_0
    //   203: lreturn
    //   204: astore 4
    //   206: aload 4
    //   208: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   211: lconst_0
    //   212: lreturn
    //   213: astore 4
    //   215: aconst_null
    //   216: astore 4
    //   218: aload 8
    //   220: astore 5
    //   222: aload 5
    //   224: ifnull +8 -> 232
    //   227: aload 5
    //   229: invokevirtual 131	java/io/BufferedReader:close	()V
    //   232: aload 4
    //   234: ifnull -116 -> 118
    //   237: aload 4
    //   239: invokevirtual 132	java/io/FileReader:close	()V
    //   242: lconst_0
    //   243: lreturn
    //   244: astore 4
    //   246: aload 4
    //   248: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   251: lconst_0
    //   252: lreturn
    //   253: astore 5
    //   255: aconst_null
    //   256: astore 4
    //   258: aload 6
    //   260: ifnull +8 -> 268
    //   263: aload 6
    //   265: invokevirtual 131	java/io/BufferedReader:close	()V
    //   268: aload 4
    //   270: ifnull +8 -> 278
    //   273: aload 4
    //   275: invokevirtual 132	java/io/FileReader:close	()V
    //   278: aload 5
    //   280: athrow
    //   281: astore 4
    //   283: aload 4
    //   285: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   288: goto -10 -> 278
    //   291: astore 5
    //   293: goto -35 -> 258
    //   296: astore 7
    //   298: aload 5
    //   300: astore 6
    //   302: aload 7
    //   304: astore 5
    //   306: goto -48 -> 258
    //   309: astore 5
    //   311: aload 8
    //   313: astore 5
    //   315: goto -93 -> 222
    //   318: astore 6
    //   320: goto -98 -> 222
    //   323: astore 5
    //   325: aload 7
    //   327: astore 5
    //   329: goto -147 -> 182
    //   332: astore 6
    //   334: goto -152 -> 182
    //   337: astore 5
    //   339: aconst_null
    //   340: astore 5
    //   342: goto -200 -> 142
    //   345: astore 6
    //   347: goto -205 -> 142
    //   350: ldc 51
    //   352: astore 6
    //   354: goto -283 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	90	0	l1	long
    //   13	106	2	l2	long
    //   24	88	4	localFileReader	java.io.FileReader
    //   120	3	4	localException1	Exception
    //   129	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   136	22	4	localObject1	Object
    //   164	3	4	localException2	Exception
    //   173	1	4	localIOException1	java.io.IOException
    //   176	22	4	localObject2	Object
    //   204	3	4	localException3	Exception
    //   213	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   216	22	4	localObject3	Object
    //   244	3	4	localException4	Exception
    //   256	18	4	localObject4	Object
    //   281	3	4	localException5	Exception
    //   10	218	5	localObject5	Object
    //   253	26	5	localObject6	Object
    //   291	8	5	localObject7	Object
    //   304	1	5	localObject8	Object
    //   309	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   313	1	5	localObject9	Object
    //   323	1	5	localIOException2	java.io.IOException
    //   327	1	5	localObject10	Object
    //   337	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   340	1	5	localObject11	Object
    //   7	294	6	localObject12	Object
    //   318	1	6	localNumberFormatException3	java.lang.NumberFormatException
    //   332	1	6	localIOException3	java.io.IOException
    //   345	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   352	1	6	str	String
    //   1	178	7	localObject13	Object
    //   296	30	7	localObject14	Object
    //   4	308	8	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   99	104	120	java/lang/Exception
    //   111	116	120	java/lang/Exception
    //   14	26	129	java/io/FileNotFoundException
    //   147	152	164	java/lang/Exception
    //   157	162	164	java/lang/Exception
    //   14	26	173	java/io/IOException
    //   187	192	204	java/lang/Exception
    //   197	202	204	java/lang/Exception
    //   14	26	213	java/lang/NumberFormatException
    //   227	232	244	java/lang/Exception
    //   237	242	244	java/lang/Exception
    //   14	26	253	finally
    //   263	268	281	java/lang/Exception
    //   273	278	281	java/lang/Exception
    //   26	37	291	finally
    //   44	51	296	finally
    //   56	71	296	finally
    //   80	94	296	finally
    //   26	37	309	java/lang/NumberFormatException
    //   44	51	318	java/lang/NumberFormatException
    //   56	71	318	java/lang/NumberFormatException
    //   80	94	318	java/lang/NumberFormatException
    //   26	37	323	java/io/IOException
    //   44	51	332	java/io/IOException
    //   56	71	332	java/io/IOException
    //   80	94	332	java/io/IOException
    //   26	37	337	java/io/FileNotFoundException
    //   44	51	345	java/io/FileNotFoundException
    //   56	71	345	java/io/FileNotFoundException
    //   80	94	345	java/io/FileNotFoundException
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceNameForConfigSystem()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  public static long getMaxCpuFreq()
  {
    getCpuInfo();
    return mMaxCpuFreq;
  }
  
  public static String getModelReport()
  {
    getCpuInfo();
    return "model(" + Build.MODEL + ") Mnfc(" + Build.MANUFACTURER + ") dev(" + Build.VERSION.INCREMENTAL + ") sdk(" + Build.VERSION.SDK_INT + ") gl(" + mOpenGLVersion + ")";
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
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isBeautySupported()
  {
    return ((hasFeature("neon")) || (hasFeature("asimd"))) && (getNumCores() >= 2) && (getCpuArchitecture() >= 4);
  }
  
  public static boolean isLowLevelDevice()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (mgNumCores == 0) {
        mgNumCores = getNumCores();
      }
      if (mgMaxCpuFreq == 0L) {
        mgMaxCpuFreq = getMaxCpuFreq();
      }
    } while ((mgNumCores <= 1) && (mgMaxCpuFreq <= 1025000L));
    return false;
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
    
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 0, "[isSupportSharpVideo] [CpuInfo] mProcessorName=" + mProcessorName + " \nmCpuArchitecture=" + mCpuArchitecture + " \nmFeature=" + mFeature + " \nmVendorId=" + mVendorId + " \nmMaxCpuFreq=" + mMaxCpuFreq + " \nmCoreNumber=" + mCoreNumber + " \nmOpenGLVersion=" + mOpenGLVersion + " \nmIsMarvell=" + mIsMarvell + " \nChip=" + mChip + ", Video=" + mIsSupportSharpVideo + ", Audio=" + mIsSupportSharpAudio + " \ndevModel=" + Build.MODEL + " \ndevVersion=" + Build.VERSION.INCREMENTAL + " \ndevManufacturer=" + Build.MANUFACTURER + " \nsdkVersion=" + Build.VERSION.SDK_INT + " \n");
    }
    return mIsSupportSharpVideo;
  }
  
  static int readCpuArchitecture()
  {
    if (mProcessorName.contains("ARMv6")) {}
    do
    {
      return 2;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
        return 4;
      }
    } while (Build.CPU_ABI.equalsIgnoreCase("armeabi"));
    if ((mCpuArchitecture == 7) && (mFeature.indexOf("neon") < 0))
    {
      long l = getMaxCpuFreq();
      int i = getNumCores();
      if ((l < 1100000L) || (i < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    switch (mCpuArchitecture)
    {
    case 6: 
    default: 
      if ((mVendorId != null) && ((mVendorId.equalsIgnoreCase("AuthenticAMD")) || (mVendorId.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
  
  /* Error */
  static long readMaxCpuFreq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: lconst_0
    //   13: lstore_2
    //   14: new 115	java/io/FileReader
    //   17: dup
    //   18: ldc_w 408
    //   21: invokespecial 120	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: astore 4
    //   26: new 122	java/io/BufferedReader
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 125	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore 5
    //   37: lload_2
    //   38: lstore_0
    //   39: aload 5
    //   41: ifnull +48 -> 89
    //   44: aload 5
    //   46: invokevirtual 128	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 6
    //   51: aload 6
    //   53: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +289 -> 345
    //   59: aload 6
    //   61: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   64: astore 6
    //   66: lload_2
    //   67: lstore_0
    //   68: aload 6
    //   70: ifnull +19 -> 89
    //   73: lload_2
    //   74: lstore_0
    //   75: aload 6
    //   77: invokevirtual 204	java/lang/String:length	()I
    //   80: ifle +9 -> 89
    //   83: aload 6
    //   85: invokestatic 226	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   88: lstore_0
    //   89: aload 5
    //   91: ifnull +8 -> 99
    //   94: aload 5
    //   96: invokevirtual 131	java/io/BufferedReader:close	()V
    //   99: lload_0
    //   100: lstore_2
    //   101: aload 4
    //   103: ifnull +10 -> 113
    //   106: aload 4
    //   108: invokevirtual 132	java/io/FileReader:close	()V
    //   111: lload_0
    //   112: lstore_2
    //   113: lload_2
    //   114: lreturn
    //   115: astore 4
    //   117: aload 4
    //   119: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   122: lload_0
    //   123: lreturn
    //   124: astore 4
    //   126: aconst_null
    //   127: astore 6
    //   129: aload 5
    //   131: astore 4
    //   133: aload 6
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +8 -> 147
    //   142: aload 5
    //   144: invokevirtual 131	java/io/BufferedReader:close	()V
    //   147: aload 4
    //   149: ifnull -36 -> 113
    //   152: aload 4
    //   154: invokevirtual 132	java/io/FileReader:close	()V
    //   157: lconst_0
    //   158: lreturn
    //   159: astore 4
    //   161: aload 4
    //   163: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   166: lconst_0
    //   167: lreturn
    //   168: astore 4
    //   170: aconst_null
    //   171: astore 4
    //   173: aload 7
    //   175: astore 5
    //   177: aload 5
    //   179: ifnull +8 -> 187
    //   182: aload 5
    //   184: invokevirtual 131	java/io/BufferedReader:close	()V
    //   187: aload 4
    //   189: ifnull -76 -> 113
    //   192: aload 4
    //   194: invokevirtual 132	java/io/FileReader:close	()V
    //   197: lconst_0
    //   198: lreturn
    //   199: astore 4
    //   201: aload 4
    //   203: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   206: lconst_0
    //   207: lreturn
    //   208: astore 4
    //   210: aconst_null
    //   211: astore 4
    //   213: aload 8
    //   215: astore 5
    //   217: aload 5
    //   219: ifnull +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 131	java/io/BufferedReader:close	()V
    //   227: aload 4
    //   229: ifnull -116 -> 113
    //   232: aload 4
    //   234: invokevirtual 132	java/io/FileReader:close	()V
    //   237: lconst_0
    //   238: lreturn
    //   239: astore 4
    //   241: aload 4
    //   243: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   246: lconst_0
    //   247: lreturn
    //   248: astore 5
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 6
    //   255: ifnull +8 -> 263
    //   258: aload 6
    //   260: invokevirtual 131	java/io/BufferedReader:close	()V
    //   263: aload 4
    //   265: ifnull +8 -> 273
    //   268: aload 4
    //   270: invokevirtual 132	java/io/FileReader:close	()V
    //   273: aload 5
    //   275: athrow
    //   276: astore 4
    //   278: aload 4
    //   280: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   283: goto -10 -> 273
    //   286: astore 5
    //   288: goto -35 -> 253
    //   291: astore 7
    //   293: aload 5
    //   295: astore 6
    //   297: aload 7
    //   299: astore 5
    //   301: goto -48 -> 253
    //   304: astore 5
    //   306: aload 8
    //   308: astore 5
    //   310: goto -93 -> 217
    //   313: astore 6
    //   315: goto -98 -> 217
    //   318: astore 5
    //   320: aload 7
    //   322: astore 5
    //   324: goto -147 -> 177
    //   327: astore 6
    //   329: goto -152 -> 177
    //   332: astore 5
    //   334: aconst_null
    //   335: astore 5
    //   337: goto -200 -> 137
    //   340: astore 6
    //   342: goto -205 -> 137
    //   345: ldc 51
    //   347: astore 6
    //   349: goto -283 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	85	0	l1	long
    //   13	101	2	l2	long
    //   24	83	4	localFileReader	java.io.FileReader
    //   115	3	4	localException1	Exception
    //   124	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   131	22	4	localObject1	Object
    //   159	3	4	localException2	Exception
    //   168	1	4	localIOException1	java.io.IOException
    //   171	22	4	localObject2	Object
    //   199	3	4	localException3	Exception
    //   208	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   211	22	4	localObject3	Object
    //   239	3	4	localException4	Exception
    //   251	18	4	localObject4	Object
    //   276	3	4	localException5	Exception
    //   10	213	5	localObject5	Object
    //   248	26	5	localObject6	Object
    //   286	8	5	localObject7	Object
    //   299	1	5	localObject8	Object
    //   304	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   308	1	5	localObject9	Object
    //   318	1	5	localIOException2	java.io.IOException
    //   322	1	5	localObject10	Object
    //   332	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   335	1	5	localObject11	Object
    //   7	289	6	localObject12	Object
    //   313	1	6	localNumberFormatException3	java.lang.NumberFormatException
    //   327	1	6	localIOException3	java.io.IOException
    //   340	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   347	1	6	str	String
    //   1	173	7	localObject13	Object
    //   291	30	7	localObject14	Object
    //   4	303	8	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   94	99	115	java/lang/Exception
    //   106	111	115	java/lang/Exception
    //   14	26	124	java/io/FileNotFoundException
    //   142	147	159	java/lang/Exception
    //   152	157	159	java/lang/Exception
    //   14	26	168	java/io/IOException
    //   182	187	199	java/lang/Exception
    //   192	197	199	java/lang/Exception
    //   14	26	208	java/lang/NumberFormatException
    //   222	227	239	java/lang/Exception
    //   232	237	239	java/lang/Exception
    //   14	26	248	finally
    //   258	263	276	java/lang/Exception
    //   268	273	276	java/lang/Exception
    //   26	37	286	finally
    //   44	66	291	finally
    //   75	89	291	finally
    //   26	37	304	java/lang/NumberFormatException
    //   44	66	313	java/lang/NumberFormatException
    //   75	89	313	java/lang/NumberFormatException
    //   26	37	318	java/io/IOException
    //   44	66	327	java/io/IOException
    //   75	89	327	java/io/IOException
    //   26	37	332	java/io/FileNotFoundException
    //   44	66	340	java/io/FileNotFoundException
    //   75	89	340	java/io/FileNotFoundException
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new VcSystemInfo.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  static boolean readSupportSharpAudio()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.INCREMENTAL;
    String str3 = Build.MANUFACTURER;
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.d("VcSystemInfo", 0, "Model: " + str1 + "\nVersion: " + str2 + "\nManufacturer: " + str3 + "\nSDK Version: " + i);
    }
    if ((mChip < 1) || (i < 8)) {
      if (QLog.isColorLevel()) {
        QLog.d("VcSystemInfo", 0, "CHIP or SDK NOT_SUPPORT");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if ((!str3.equalsIgnoreCase("HUAWEI")) || (!str1.equalsIgnoreCase("C8500"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VcSystemInfo", 0, "DEVICE_NOT_SUPPORT");
        return false;
        if ((!str3.equalsIgnoreCase("Samsung")) || (!str1.equalsIgnoreCase("GT-I5508"))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VcSystemInfo", 0, "DEVICE_NOT_SUPPORT");
      return false;
      if ((!str3.equalsIgnoreCase("FIH")) || (!str1.equalsIgnoreCase("SH8128U"))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VcSystemInfo", 0, "DEVICE_NOT_SUPPORT");
    return false;
    return true;
  }
  
  public int getCameraFacing()
  {
    int i = 1;
    if (Build.VERSION.SDK_INT > 9) {
      i = 2;
    }
    return i;
  }
  
  public int getOsType()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        int j = str.charAt(0);
        int k = str.charAt(2);
        int i = 0;
        if (str.length() >= 5) {
          i = str.charAt(4);
        }
        switch (j)
        {
        default: 
          return 200;
        case 49: 
          if (k == 49) {
            return 101;
          }
          if (k == 53) {
            return 102;
          }
          if (k == 54) {
            return 103;
          }
          break;
        case 50: 
          if (k == 48)
          {
            if (i == 49) {
              return 105;
            }
            return 104;
          }
          if (k == 49) {
            return 106;
          }
          if (k == 50)
          {
            if (i == 49) {
              return 108;
            }
            return 107;
          }
          if ((k == 51) && (i >= 48) && (i <= 57)) {
            return 109;
          }
          break;
        case 51: 
          if (k == 48) {
            return 110;
          }
          if (k == 49) {
            return 111;
          }
          if (k == 50) {
            return 112;
          }
          break;
        case 52: 
          if (k == 48) {
            return 113;
          }
          if (k == 49) {
            return 114;
          }
          if (k == 50) {
            return 115;
          }
          if (k == 51) {
            return 116;
          }
          if (k == 52) {
            return 117;
          }
          break;
        case 53: 
          if (k == 48) {
            return 118;
          }
          break;
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.utils.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */