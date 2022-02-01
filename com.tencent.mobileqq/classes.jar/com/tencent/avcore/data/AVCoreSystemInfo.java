package com.tencent.avcore.data;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.avcore.util.AVCoreLog;
import java.io.File;

public class AVCoreSystemInfo
{
  public static final int CHIP_ARM_V5 = 1;
  public static final int CHIP_ARM_V6 = 2;
  public static final int CHIP_ARM_V7_NENO = 4;
  public static final int CHIP_ARM_V7_NO_NENO = 3;
  public static final int CHIP_ARM_V8 = 5;
  public static final int CHIP_MIPS = 6;
  public static final int CHIP_UNKNOWN = 0;
  public static final int CHIP_X86 = 7;
  public static final String TAG = "AVCoreSystemInfo";
  public static int mChip = 1;
  public static int mCoreNumber = 1;
  public static int mCpuArchitecture = 5;
  public static String mFeature = "";
  public static String mHardware;
  public static boolean mHasReadMemInfo = false;
  public static boolean mIsMarvell = false;
  public static boolean mIsSupportSharpAudio = true;
  public static boolean mIsSupportSharpVideo = true;
  public static long mMaxCpuFreq = 0L;
  public static long mMemoryTotal = 0L;
  public static int mOpenGLVersion = 2;
  public static String mProcessorName = "";
  public static String mVendorId;
  public static boolean mfReadCpuInfo = false;
  static long mgMaxCpuFreq = 0L;
  static int mgNumCores;
  private static String strCPUModel;
  public int mDisplayHeight = 240;
  public int mDisplayWidth = 320;
  public int mScreenHeight = 480;
  public int mScreenWidth = 320;
  
  static
  {
    getCpuInfo();
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
    //   0: getstatic 90	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: ldc2_w 91
    //   11: lstore 7
    //   13: ldc 93
    //   15: fstore_2
    //   16: new 95	java/lang/StringBuilder
    //   19: dup
    //   20: sipush 1024
    //   23: invokespecial 98	java/lang/StringBuilder:<init>	(I)V
    //   26: astore 19
    //   28: new 100	java/io/BufferedReader
    //   31: dup
    //   32: new 102	java/io/FileReader
    //   35: dup
    //   36: ldc 104
    //   38: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore 18
    //   46: lload 7
    //   48: lstore 11
    //   50: lload 7
    //   52: lstore 13
    //   54: lload 7
    //   56: lstore 15
    //   58: aload 18
    //   60: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 20
    //   65: aload 20
    //   67: ifnonnull +55 -> 122
    //   70: iconst_1
    //   71: putstatic 90	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   74: lload 7
    //   76: lstore 9
    //   78: fload_2
    //   79: fstore_3
    //   80: aload 18
    //   82: invokevirtual 116	java/io/BufferedReader:close	()V
    //   85: lload 7
    //   87: lstore 9
    //   89: goto +1794 -> 1883
    //   92: astore 18
    //   94: aload 18
    //   96: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   99: fload_3
    //   100: fstore_2
    //   101: goto +1782 -> 1883
    //   104: fload_2
    //   105: fstore 4
    //   107: goto +1677 -> 1784
    //   110: fload_2
    //   111: fstore 4
    //   113: goto +1705 -> 1818
    //   116: fload_2
    //   117: fstore 4
    //   119: goto +1733 -> 1852
    //   122: lload 7
    //   124: lstore 11
    //   126: lload 7
    //   128: lstore 13
    //   130: lload 7
    //   132: lstore 15
    //   134: aload 20
    //   136: ldc 121
    //   138: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   141: istore 17
    //   143: iload 17
    //   145: ifeq +56 -> 201
    //   148: aload 20
    //   150: bipush 58
    //   152: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   155: istore 5
    //   157: lload 7
    //   159: lstore 9
    //   161: iload 5
    //   163: iconst_1
    //   164: if_icmple +1380 -> 1544
    //   167: aload 20
    //   169: iload 5
    //   171: iconst_1
    //   172: iadd
    //   173: aload 20
    //   175: invokevirtual 134	java/lang/String:length	()I
    //   178: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   181: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   184: ldc 143
    //   186: ldc 31
    //   188: invokevirtual 147	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   191: putstatic 149	com/tencent/avcore/data/AVCoreSystemInfo:strCPUModel	Ljava/lang/String;
    //   194: lload 7
    //   196: lstore 9
    //   198: goto +1346 -> 1544
    //   201: lload 7
    //   203: lstore 11
    //   205: lload 7
    //   207: lstore 13
    //   209: lload 7
    //   211: lstore 15
    //   213: aload 20
    //   215: ldc 151
    //   217: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   220: istore 17
    //   222: iload 17
    //   224: ifeq +106 -> 330
    //   227: aload 20
    //   229: bipush 58
    //   231: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   234: istore 5
    //   236: lload 7
    //   238: lstore 9
    //   240: iload 5
    //   242: iconst_1
    //   243: if_icmple +1301 -> 1544
    //   246: aload 20
    //   248: iload 5
    //   250: iconst_1
    //   251: iadd
    //   252: aload 20
    //   254: invokevirtual 134	java/lang/String:length	()I
    //   257: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   260: putstatic 78	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   263: getstatic 78	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   266: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   269: putstatic 78	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   272: lload 7
    //   274: lstore 9
    //   276: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   279: ifeq +1265 -> 1544
    //   282: aload 19
    //   284: ldc 159
    //   286: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 19
    //   292: getstatic 78	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   295: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 19
    //   301: ldc 165
    //   303: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 19
    //   309: aload 20
    //   311: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 19
    //   317: ldc 167
    //   319: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: lload 7
    //   325: lstore 9
    //   327: goto +1217 -> 1544
    //   330: lload 7
    //   332: lstore 11
    //   334: lload 7
    //   336: lstore 13
    //   338: lload 7
    //   340: lstore 15
    //   342: aload 20
    //   344: ldc 169
    //   346: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   349: ifeq +422 -> 771
    //   352: lload 7
    //   354: lstore 11
    //   356: lload 7
    //   358: lstore 13
    //   360: lload 7
    //   362: lstore 15
    //   364: aload 20
    //   366: bipush 58
    //   368: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   371: istore 5
    //   373: lload 7
    //   375: lstore 9
    //   377: iload 5
    //   379: iconst_1
    //   380: if_icmple +215 -> 595
    //   383: lload 7
    //   385: lstore 11
    //   387: lload 7
    //   389: lstore 13
    //   391: lload 7
    //   393: lstore 15
    //   395: aload 20
    //   397: iload 5
    //   399: iconst_1
    //   400: iadd
    //   401: aload 20
    //   403: invokevirtual 134	java/lang/String:length	()I
    //   406: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   409: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   412: astore 21
    //   414: lload 7
    //   416: lstore 9
    //   418: aload 21
    //   420: ifnull +175 -> 595
    //   423: lload 7
    //   425: lstore 9
    //   427: lload 7
    //   429: lstore 11
    //   431: lload 7
    //   433: lstore 13
    //   435: lload 7
    //   437: lstore 15
    //   439: aload 21
    //   441: invokevirtual 134	java/lang/String:length	()I
    //   444: ifle +151 -> 595
    //   447: lload 7
    //   449: lstore 11
    //   451: lload 7
    //   453: lstore 13
    //   455: lload 7
    //   457: lstore 15
    //   459: aload 21
    //   461: ldc 171
    //   463: invokevirtual 174	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   466: istore 17
    //   468: iload 17
    //   470: ifeq +15 -> 485
    //   473: bipush 8
    //   475: putstatic 176	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   478: lload 7
    //   480: lstore 9
    //   482: goto +113 -> 595
    //   485: aload 21
    //   487: invokestatic 182	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   490: l2i
    //   491: putstatic 176	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   494: lload 7
    //   496: lstore 9
    //   498: goto +97 -> 595
    //   501: iconst_1
    //   502: istore 5
    //   504: lload 7
    //   506: lstore 11
    //   508: lload 7
    //   510: lstore 13
    //   512: lload 7
    //   514: lstore 15
    //   516: aload 21
    //   518: invokevirtual 134	java/lang/String:length	()I
    //   521: istore 6
    //   523: lload 7
    //   525: lstore 9
    //   527: iload 5
    //   529: iload 6
    //   531: if_icmpge +64 -> 595
    //   534: lload 7
    //   536: lstore 11
    //   538: lload 7
    //   540: lstore 13
    //   542: aload 21
    //   544: iconst_0
    //   545: aload 21
    //   547: invokevirtual 134	java/lang/String:length	()I
    //   550: iload 5
    //   552: isub
    //   553: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   556: astore 22
    //   558: lload 7
    //   560: lstore 13
    //   562: lload 13
    //   564: lstore 9
    //   566: lload 13
    //   568: lstore 11
    //   570: aload 22
    //   572: invokestatic 182	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   575: l2i
    //   576: putstatic 176	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   579: lload 13
    //   581: lstore 7
    //   583: goto +16 -> 599
    //   586: iload 5
    //   588: iconst_1
    //   589: iadd
    //   590: istore 5
    //   592: goto -88 -> 504
    //   595: lload 9
    //   597: lstore 7
    //   599: lload 7
    //   601: lstore 9
    //   603: lload 7
    //   605: lstore 11
    //   607: lload 7
    //   609: lstore 15
    //   611: aload 20
    //   613: ldc 184
    //   615: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   618: ifeq +19 -> 637
    //   621: lload 7
    //   623: lstore 9
    //   625: lload 7
    //   627: lstore 11
    //   629: lload 7
    //   631: lstore 15
    //   633: iconst_5
    //   634: putstatic 176	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   637: fload_2
    //   638: fstore_3
    //   639: lload 7
    //   641: lstore 13
    //   643: lload 7
    //   645: lstore 9
    //   647: lload 7
    //   649: lstore 11
    //   651: lload 7
    //   653: lstore 15
    //   655: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   658: ifeq +1018 -> 1676
    //   661: lload 7
    //   663: lstore 9
    //   665: lload 7
    //   667: lstore 11
    //   669: lload 7
    //   671: lstore 15
    //   673: aload 19
    //   675: ldc 190
    //   677: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: lload 7
    //   683: lstore 9
    //   685: lload 7
    //   687: lstore 11
    //   689: lload 7
    //   691: lstore 15
    //   693: aload 19
    //   695: getstatic 176	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   698: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: lload 7
    //   704: lstore 9
    //   706: lload 7
    //   708: lstore 11
    //   710: lload 7
    //   712: lstore 15
    //   714: aload 19
    //   716: ldc 165
    //   718: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: lload 7
    //   724: lstore 9
    //   726: lload 7
    //   728: lstore 11
    //   730: lload 7
    //   732: lstore 15
    //   734: aload 19
    //   736: aload 20
    //   738: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: lload 7
    //   744: lstore 9
    //   746: lload 7
    //   748: lstore 11
    //   750: lload 7
    //   752: lstore 15
    //   754: aload 19
    //   756: ldc 167
    //   758: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: fload_2
    //   763: fstore_3
    //   764: lload 7
    //   766: lstore 13
    //   768: goto +908 -> 1676
    //   771: lload 7
    //   773: lstore 9
    //   775: lload 7
    //   777: lstore 11
    //   779: lload 7
    //   781: lstore 15
    //   783: aload 20
    //   785: ldc 195
    //   787: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   790: ifeq +196 -> 986
    //   793: lload 7
    //   795: lstore 9
    //   797: lload 7
    //   799: lstore 11
    //   801: lload 7
    //   803: lstore 15
    //   805: aload 20
    //   807: bipush 58
    //   809: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   812: istore 5
    //   814: iload 5
    //   816: iconst_1
    //   817: if_icmple +35 -> 852
    //   820: lload 7
    //   822: lstore 9
    //   824: lload 7
    //   826: lstore 11
    //   828: lload 7
    //   830: lstore 15
    //   832: aload 20
    //   834: iload 5
    //   836: iconst_1
    //   837: iadd
    //   838: aload 20
    //   840: invokevirtual 134	java/lang/String:length	()I
    //   843: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   846: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   849: putstatic 197	com/tencent/avcore/data/AVCoreSystemInfo:mFeature	Ljava/lang/String;
    //   852: fload_2
    //   853: fstore_3
    //   854: lload 7
    //   856: lstore 13
    //   858: lload 7
    //   860: lstore 9
    //   862: lload 7
    //   864: lstore 11
    //   866: lload 7
    //   868: lstore 15
    //   870: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   873: ifeq +803 -> 1676
    //   876: lload 7
    //   878: lstore 9
    //   880: lload 7
    //   882: lstore 11
    //   884: lload 7
    //   886: lstore 15
    //   888: aload 19
    //   890: ldc 199
    //   892: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: lload 7
    //   898: lstore 9
    //   900: lload 7
    //   902: lstore 11
    //   904: lload 7
    //   906: lstore 15
    //   908: aload 19
    //   910: getstatic 197	com/tencent/avcore/data/AVCoreSystemInfo:mFeature	Ljava/lang/String;
    //   913: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: lload 7
    //   919: lstore 9
    //   921: lload 7
    //   923: lstore 11
    //   925: lload 7
    //   927: lstore 15
    //   929: aload 19
    //   931: ldc 165
    //   933: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: lload 7
    //   939: lstore 9
    //   941: lload 7
    //   943: lstore 11
    //   945: lload 7
    //   947: lstore 15
    //   949: aload 19
    //   951: aload 20
    //   953: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: lload 7
    //   959: lstore 9
    //   961: lload 7
    //   963: lstore 11
    //   965: lload 7
    //   967: lstore 15
    //   969: aload 19
    //   971: ldc 167
    //   973: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: fload_2
    //   978: fstore_3
    //   979: lload 7
    //   981: lstore 13
    //   983: goto +693 -> 1676
    //   986: lload 7
    //   988: lstore 9
    //   990: lload 7
    //   992: lstore 11
    //   994: lload 7
    //   996: lstore 15
    //   998: aload 20
    //   1000: ldc 201
    //   1002: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1005: ifeq +196 -> 1201
    //   1008: lload 7
    //   1010: lstore 9
    //   1012: lload 7
    //   1014: lstore 11
    //   1016: lload 7
    //   1018: lstore 15
    //   1020: aload 20
    //   1022: bipush 58
    //   1024: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   1027: istore 5
    //   1029: iload 5
    //   1031: iconst_1
    //   1032: if_icmple +35 -> 1067
    //   1035: lload 7
    //   1037: lstore 9
    //   1039: lload 7
    //   1041: lstore 11
    //   1043: lload 7
    //   1045: lstore 15
    //   1047: aload 20
    //   1049: iload 5
    //   1051: iconst_1
    //   1052: iadd
    //   1053: aload 20
    //   1055: invokevirtual 134	java/lang/String:length	()I
    //   1058: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   1061: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   1064: putstatic 203	com/tencent/avcore/data/AVCoreSystemInfo:mVendorId	Ljava/lang/String;
    //   1067: fload_2
    //   1068: fstore_3
    //   1069: lload 7
    //   1071: lstore 13
    //   1073: lload 7
    //   1075: lstore 9
    //   1077: lload 7
    //   1079: lstore 11
    //   1081: lload 7
    //   1083: lstore 15
    //   1085: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1088: ifeq +588 -> 1676
    //   1091: lload 7
    //   1093: lstore 9
    //   1095: lload 7
    //   1097: lstore 11
    //   1099: lload 7
    //   1101: lstore 15
    //   1103: aload 19
    //   1105: ldc 205
    //   1107: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: lload 7
    //   1113: lstore 9
    //   1115: lload 7
    //   1117: lstore 11
    //   1119: lload 7
    //   1121: lstore 15
    //   1123: aload 19
    //   1125: getstatic 203	com/tencent/avcore/data/AVCoreSystemInfo:mVendorId	Ljava/lang/String;
    //   1128: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: lload 7
    //   1134: lstore 9
    //   1136: lload 7
    //   1138: lstore 11
    //   1140: lload 7
    //   1142: lstore 15
    //   1144: aload 19
    //   1146: ldc 165
    //   1148: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: lload 7
    //   1154: lstore 9
    //   1156: lload 7
    //   1158: lstore 11
    //   1160: lload 7
    //   1162: lstore 15
    //   1164: aload 19
    //   1166: aload 20
    //   1168: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: pop
    //   1172: lload 7
    //   1174: lstore 9
    //   1176: lload 7
    //   1178: lstore 11
    //   1180: lload 7
    //   1182: lstore 15
    //   1184: aload 19
    //   1186: ldc 167
    //   1188: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: pop
    //   1192: fload_2
    //   1193: fstore_3
    //   1194: lload 7
    //   1196: lstore 13
    //   1198: goto +478 -> 1676
    //   1201: lload 7
    //   1203: lstore 9
    //   1205: lload 7
    //   1207: lstore 11
    //   1209: lload 7
    //   1211: lstore 15
    //   1213: aload 20
    //   1215: ldc 121
    //   1217: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1220: ifeq +195 -> 1415
    //   1223: lload 7
    //   1225: lstore 9
    //   1227: lload 7
    //   1229: lstore 11
    //   1231: lload 7
    //   1233: lstore 15
    //   1235: aload 20
    //   1237: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   1240: putstatic 207	com/tencent/avcore/data/AVCoreSystemInfo:mHardware	Ljava/lang/String;
    //   1243: lload 7
    //   1245: lstore 9
    //   1247: lload 7
    //   1249: lstore 11
    //   1251: lload 7
    //   1253: lstore 15
    //   1255: aload 20
    //   1257: ldc 209
    //   1259: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1262: ifeq +19 -> 1281
    //   1265: lload 7
    //   1267: lstore 9
    //   1269: lload 7
    //   1271: lstore 11
    //   1273: lload 7
    //   1275: lstore 15
    //   1277: iconst_1
    //   1278: putstatic 211	com/tencent/avcore/data/AVCoreSystemInfo:mIsMarvell	Z
    //   1281: fload_2
    //   1282: fstore_3
    //   1283: lload 7
    //   1285: lstore 13
    //   1287: lload 7
    //   1289: lstore 9
    //   1291: lload 7
    //   1293: lstore 11
    //   1295: lload 7
    //   1297: lstore 15
    //   1299: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1302: ifeq +374 -> 1676
    //   1305: lload 7
    //   1307: lstore 9
    //   1309: lload 7
    //   1311: lstore 11
    //   1313: lload 7
    //   1315: lstore 15
    //   1317: aload 19
    //   1319: ldc 213
    //   1321: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: lload 7
    //   1327: lstore 9
    //   1329: lload 7
    //   1331: lstore 11
    //   1333: lload 7
    //   1335: lstore 15
    //   1337: aload 19
    //   1339: getstatic 211	com/tencent/avcore/data/AVCoreSystemInfo:mIsMarvell	Z
    //   1342: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: lload 7
    //   1348: lstore 9
    //   1350: lload 7
    //   1352: lstore 11
    //   1354: lload 7
    //   1356: lstore 15
    //   1358: aload 19
    //   1360: ldc 165
    //   1362: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: lload 7
    //   1368: lstore 9
    //   1370: lload 7
    //   1372: lstore 11
    //   1374: lload 7
    //   1376: lstore 15
    //   1378: aload 19
    //   1380: aload 20
    //   1382: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: lload 7
    //   1388: lstore 9
    //   1390: lload 7
    //   1392: lstore 11
    //   1394: lload 7
    //   1396: lstore 15
    //   1398: aload 19
    //   1400: ldc 167
    //   1402: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: fload_2
    //   1407: fstore_3
    //   1408: lload 7
    //   1410: lstore 13
    //   1412: goto +264 -> 1676
    //   1415: lload 7
    //   1417: lstore 9
    //   1419: lload 7
    //   1421: lstore 11
    //   1423: lload 7
    //   1425: lstore 15
    //   1427: aload 20
    //   1429: ldc 218
    //   1431: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1434: ifeq +119 -> 1553
    //   1437: lload 7
    //   1439: lstore 9
    //   1441: lload 7
    //   1443: lstore 11
    //   1445: lload 7
    //   1447: lstore 15
    //   1449: aload 20
    //   1451: bipush 58
    //   1453: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   1456: istore 5
    //   1458: fload_2
    //   1459: fstore_3
    //   1460: lload 7
    //   1462: lstore 13
    //   1464: iload 5
    //   1466: iconst_1
    //   1467: if_icmple +209 -> 1676
    //   1470: lload 7
    //   1472: lstore 9
    //   1474: lload 7
    //   1476: lstore 11
    //   1478: lload 7
    //   1480: lstore 15
    //   1482: aload 20
    //   1484: iload 5
    //   1486: iconst_1
    //   1487: iadd
    //   1488: aload 20
    //   1490: invokevirtual 134	java/lang/String:length	()I
    //   1493: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   1496: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   1499: astore 20
    //   1501: lload 7
    //   1503: lstore 9
    //   1505: lload 7
    //   1507: lstore 11
    //   1509: aload 20
    //   1511: invokestatic 182	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1514: lstore 13
    //   1516: lload 13
    //   1518: lconst_0
    //   1519: lcmp
    //   1520: iflt +20 -> 1540
    //   1523: lconst_1
    //   1524: lload 13
    //   1526: ladd
    //   1527: lstore 9
    //   1529: lload 9
    //   1531: lload 7
    //   1533: lcmp
    //   1534: ifle +6 -> 1540
    //   1537: goto +7 -> 1544
    //   1540: lload 7
    //   1542: lstore 9
    //   1544: fload_2
    //   1545: fstore_3
    //   1546: lload 9
    //   1548: lstore 13
    //   1550: goto +126 -> 1676
    //   1553: fload_2
    //   1554: fstore_3
    //   1555: lload 7
    //   1557: lstore 13
    //   1559: lload 7
    //   1561: lstore 9
    //   1563: lload 7
    //   1565: lstore 11
    //   1567: lload 7
    //   1569: lstore 15
    //   1571: aload 20
    //   1573: ldc 220
    //   1575: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1578: ifeq +98 -> 1676
    //   1581: lload 7
    //   1583: lstore 9
    //   1585: lload 7
    //   1587: lstore 11
    //   1589: lload 7
    //   1591: lstore 15
    //   1593: aload 20
    //   1595: bipush 58
    //   1597: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   1600: istore 5
    //   1602: fload_2
    //   1603: fstore_3
    //   1604: lload 7
    //   1606: lstore 13
    //   1608: iload 5
    //   1610: iconst_1
    //   1611: if_icmple +65 -> 1676
    //   1614: lload 7
    //   1616: lstore 9
    //   1618: lload 7
    //   1620: lstore 11
    //   1622: lload 7
    //   1624: lstore 15
    //   1626: aload 20
    //   1628: iload 5
    //   1630: iconst_1
    //   1631: iadd
    //   1632: aload 20
    //   1634: invokevirtual 134	java/lang/String:length	()I
    //   1637: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   1640: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   1643: astore 20
    //   1645: lload 7
    //   1647: lstore 9
    //   1649: lload 7
    //   1651: lstore 11
    //   1653: aload 20
    //   1655: invokestatic 226	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1658: fstore_3
    //   1659: fload_3
    //   1660: fload_2
    //   1661: fcmpl
    //   1662: ifle +8 -> 1670
    //   1665: fload_3
    //   1666: fstore_2
    //   1667: goto +3 -> 1670
    //   1670: lload 7
    //   1672: lstore 13
    //   1674: fload_2
    //   1675: fstore_3
    //   1676: lload 13
    //   1678: lstore 7
    //   1680: fload_3
    //   1681: fstore_2
    //   1682: goto -1636 -> 46
    //   1685: lload 15
    //   1687: lstore 7
    //   1689: fload_2
    //   1690: fstore 4
    //   1692: goto +92 -> 1784
    //   1695: lload 11
    //   1697: lstore 7
    //   1699: fload_2
    //   1700: fstore 4
    //   1702: goto +116 -> 1818
    //   1705: lload 9
    //   1707: lstore 7
    //   1709: fload_2
    //   1710: fstore 4
    //   1712: goto +140 -> 1852
    //   1715: astore 19
    //   1717: goto +38 -> 1755
    //   1720: lload 15
    //   1722: lstore 7
    //   1724: fload_2
    //   1725: fstore 4
    //   1727: goto +57 -> 1784
    //   1730: lload 13
    //   1732: lstore 7
    //   1734: fload_2
    //   1735: fstore 4
    //   1737: goto +81 -> 1818
    //   1740: lload 11
    //   1742: lstore 7
    //   1744: fload_2
    //   1745: fstore 4
    //   1747: goto +105 -> 1852
    //   1750: astore 19
    //   1752: aconst_null
    //   1753: astore 18
    //   1755: aload 18
    //   1757: ifnull +18 -> 1775
    //   1760: aload 18
    //   1762: invokevirtual 116	java/io/BufferedReader:close	()V
    //   1765: goto +10 -> 1775
    //   1768: astore 18
    //   1770: aload 18
    //   1772: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   1775: aload 19
    //   1777: athrow
    //   1778: aconst_null
    //   1779: astore 18
    //   1781: fload_2
    //   1782: fstore 4
    //   1784: lload 7
    //   1786: lstore 9
    //   1788: fload 4
    //   1790: fstore_2
    //   1791: aload 18
    //   1793: ifnull +90 -> 1883
    //   1796: lload 7
    //   1798: lstore 9
    //   1800: fload 4
    //   1802: fstore_3
    //   1803: aload 18
    //   1805: invokevirtual 116	java/io/BufferedReader:close	()V
    //   1808: lload 7
    //   1810: lstore 9
    //   1812: fload 4
    //   1814: fstore_2
    //   1815: goto +68 -> 1883
    //   1818: lload 7
    //   1820: lstore 9
    //   1822: fload 4
    //   1824: fstore_2
    //   1825: aload 18
    //   1827: ifnull +56 -> 1883
    //   1830: lload 7
    //   1832: lstore 9
    //   1834: fload 4
    //   1836: fstore_3
    //   1837: aload 18
    //   1839: invokevirtual 116	java/io/BufferedReader:close	()V
    //   1842: lload 7
    //   1844: lstore 9
    //   1846: fload 4
    //   1848: fstore_2
    //   1849: goto +34 -> 1883
    //   1852: lload 7
    //   1854: lstore 9
    //   1856: fload 4
    //   1858: fstore_2
    //   1859: aload 18
    //   1861: ifnull +22 -> 1883
    //   1864: lload 7
    //   1866: lstore 9
    //   1868: fload 4
    //   1870: fstore_3
    //   1871: aload 18
    //   1873: invokevirtual 116	java/io/BufferedReader:close	()V
    //   1876: fload 4
    //   1878: fstore_2
    //   1879: lload 7
    //   1881: lstore 9
    //   1883: invokestatic 229	com/tencent/avcore/data/AVCoreSystemInfo:readNumCores	()I
    //   1886: istore 5
    //   1888: iload 5
    //   1890: ifle +42 -> 1932
    //   1893: iload 5
    //   1895: putstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   1898: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1901: ifeq +75 -> 1976
    //   1904: aload 19
    //   1906: ldc 233
    //   1908: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: pop
    //   1912: aload 19
    //   1914: getstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   1917: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1920: pop
    //   1921: aload 19
    //   1923: ldc 167
    //   1925: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1928: pop
    //   1929: goto +47 -> 1976
    //   1932: lload 9
    //   1934: lconst_0
    //   1935: lcmp
    //   1936: ifle +40 -> 1976
    //   1939: lload 9
    //   1941: l2i
    //   1942: putstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   1945: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1948: ifeq +28 -> 1976
    //   1951: aload 19
    //   1953: ldc 235
    //   1955: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: pop
    //   1959: aload 19
    //   1961: getstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   1964: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1967: pop
    //   1968: aload 19
    //   1970: ldc 167
    //   1972: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: pop
    //   1976: invokestatic 239	com/tencent/avcore/data/AVCoreSystemInfo:readMaxCpuFreq	()J
    //   1979: lstore 7
    //   1981: lload 7
    //   1983: lconst_0
    //   1984: lcmp
    //   1985: ifle +42 -> 2027
    //   1988: lload 7
    //   1990: putstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   1993: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1996: ifeq +141 -> 2137
    //   1999: aload 19
    //   2001: ldc 243
    //   2003: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: pop
    //   2007: aload 19
    //   2009: getstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   2012: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2015: pop
    //   2016: aload 19
    //   2018: ldc 167
    //   2020: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2023: pop
    //   2024: goto +113 -> 2137
    //   2027: fload_2
    //   2028: fconst_0
    //   2029: fcmpl
    //   2030: ifle +107 -> 2137
    //   2033: fload_2
    //   2034: ldc 247
    //   2036: fcmpg
    //   2037: ifge +27 -> 2064
    //   2040: fload_2
    //   2041: f2d
    //   2042: dstore_0
    //   2043: dload_0
    //   2044: invokestatic 253	java/lang/Double:isNaN	(D)Z
    //   2047: pop
    //   2048: dload_0
    //   2049: ldc2_w 254
    //   2052: dmul
    //   2053: ldc2_w 256
    //   2056: dmul
    //   2057: d2l
    //   2058: putstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   2061: goto +44 -> 2105
    //   2064: fload_2
    //   2065: ldc_w 258
    //   2068: fcmpl
    //   2069: ifle +27 -> 2096
    //   2072: fload_2
    //   2073: f2d
    //   2074: dstore_0
    //   2075: dload_0
    //   2076: invokestatic 253	java/lang/Double:isNaN	(D)Z
    //   2079: pop
    //   2080: dload_0
    //   2081: ldc2_w 259
    //   2084: ddiv
    //   2085: ldc2_w 256
    //   2088: dmul
    //   2089: d2l
    //   2090: putstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   2093: goto +12 -> 2105
    //   2096: fload_2
    //   2097: ldc_w 261
    //   2100: fmul
    //   2101: f2l
    //   2102: putstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   2105: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   2108: ifeq +29 -> 2137
    //   2111: aload 19
    //   2113: ldc_w 263
    //   2116: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: pop
    //   2120: aload 19
    //   2122: getstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   2125: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2128: pop
    //   2129: aload 19
    //   2131: ldc 167
    //   2133: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: pop
    //   2137: getstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   2140: ifle +21 -> 2161
    //   2143: getstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   2146: lconst_0
    //   2147: lcmp
    //   2148: ifgt +6 -> 2154
    //   2151: goto +10 -> 2161
    //   2154: iconst_1
    //   2155: putstatic 90	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   2158: goto +57 -> 2215
    //   2161: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   2164: ifeq +47 -> 2211
    //   2167: aload 19
    //   2169: ldc_w 265
    //   2172: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2175: pop
    //   2176: aload 19
    //   2178: getstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   2181: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2184: pop
    //   2185: aload 19
    //   2187: ldc_w 267
    //   2190: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: pop
    //   2194: aload 19
    //   2196: getstatic 241	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   2199: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2202: pop
    //   2203: aload 19
    //   2205: ldc 167
    //   2207: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2210: pop
    //   2211: iconst_0
    //   2212: putstatic 90	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   2215: invokestatic 270	com/tencent/avcore/data/AVCoreSystemInfo:readCpuArchitecture	()I
    //   2218: putstatic 82	com/tencent/avcore/data/AVCoreSystemInfo:mChip	I
    //   2221: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   2224: ifeq +75 -> 2299
    //   2227: aload 19
    //   2229: ldc_w 272
    //   2232: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: pop
    //   2236: aload 19
    //   2238: getstatic 82	com/tencent/avcore/data/AVCoreSystemInfo:mChip	I
    //   2241: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2244: pop
    //   2245: aload 19
    //   2247: ldc_w 274
    //   2250: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: pop
    //   2254: aload 19
    //   2256: getstatic 276	com/tencent/avcore/data/AVCoreSystemInfo:mIsSupportSharpVideo	Z
    //   2259: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2262: pop
    //   2263: aload 19
    //   2265: ldc_w 278
    //   2268: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: pop
    //   2272: aload 19
    //   2274: getstatic 280	com/tencent/avcore/data/AVCoreSystemInfo:mIsSupportSharpAudio	Z
    //   2277: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2280: pop
    //   2281: aload 19
    //   2283: ldc 167
    //   2285: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: pop
    //   2289: ldc 25
    //   2291: aload 19
    //   2293: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2296: invokestatic 287	com/tencent/avcore/util/AVCoreLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2299: return
    //   2300: astore 18
    //   2302: goto +93 -> 2395
    //   2305: astore 18
    //   2307: goto +79 -> 2386
    //   2310: astore 18
    //   2312: goto -534 -> 1778
    //   2315: astore 20
    //   2317: goto -577 -> 1740
    //   2320: astore 20
    //   2322: goto -592 -> 1730
    //   2325: astore 20
    //   2327: goto -607 -> 1720
    //   2330: astore 20
    //   2332: goto -2216 -> 116
    //   2335: astore 20
    //   2337: goto -2227 -> 110
    //   2340: astore 20
    //   2342: goto -2238 -> 104
    //   2345: astore 22
    //   2347: goto -1846 -> 501
    //   2350: astore 22
    //   2352: goto -1766 -> 586
    //   2355: astore 22
    //   2357: goto -1771 -> 586
    //   2360: astore 20
    //   2362: goto -657 -> 1705
    //   2365: astore 20
    //   2367: goto -672 -> 1695
    //   2370: astore 20
    //   2372: goto -687 -> 1685
    //   2375: astore 20
    //   2377: fload_2
    //   2378: fstore_3
    //   2379: lload 7
    //   2381: lstore 13
    //   2383: goto -707 -> 1676
    //   2386: aconst_null
    //   2387: astore 18
    //   2389: fload_2
    //   2390: fstore 4
    //   2392: goto -574 -> 1818
    //   2395: aconst_null
    //   2396: astore 18
    //   2398: fload_2
    //   2399: fstore 4
    //   2401: goto -549 -> 1852
    // Local variable table:
    //   start	length	slot	name	signature
    //   2042	39	0	d	double
    //   15	2384	2	f1	float
    //   79	2300	3	f2	float
    //   105	2295	4	f3	float
    //   155	1739	5	i	int
    //   521	11	6	j	int
    //   11	2369	7	l1	long
    //   76	1864	9	l2	long
    //   48	1693	11	l3	long
    //   52	2330	13	l4	long
    //   56	1665	15	l5	long
    //   141	328	17	bool	boolean
    //   44	37	18	localBufferedReader	java.io.BufferedReader
    //   92	3	18	localIOException1	java.io.IOException
    //   1753	8	18	localObject1	Object
    //   1768	3	18	localIOException2	java.io.IOException
    //   1779	93	18	localObject2	Object
    //   2300	1	18	localFileNotFoundException1	java.io.FileNotFoundException
    //   2305	1	18	localIOException3	java.io.IOException
    //   2310	1	18	localNumberFormatException1	java.lang.NumberFormatException
    //   2387	10	18	localObject3	Object
    //   26	1373	19	localStringBuilder	StringBuilder
    //   1715	1	19	localObject4	Object
    //   1750	542	19	localObject5	Object
    //   63	1591	20	str1	String
    //   2315	1	20	localFileNotFoundException2	java.io.FileNotFoundException
    //   2320	1	20	localIOException4	java.io.IOException
    //   2325	1	20	localNumberFormatException2	java.lang.NumberFormatException
    //   2330	1	20	localFileNotFoundException3	java.io.FileNotFoundException
    //   2335	1	20	localIOException5	java.io.IOException
    //   2340	1	20	localNumberFormatException3	java.lang.NumberFormatException
    //   2360	1	20	localFileNotFoundException4	java.io.FileNotFoundException
    //   2365	1	20	localIOException6	java.io.IOException
    //   2370	1	20	localNumberFormatException4	java.lang.NumberFormatException
    //   2375	1	20	localNumberFormatException5	java.lang.NumberFormatException
    //   412	134	21	str2	String
    //   556	15	22	str3	String
    //   2345	1	22	localNumberFormatException6	java.lang.NumberFormatException
    //   2350	1	22	localNumberFormatException7	java.lang.NumberFormatException
    //   2355	1	22	localNumberFormatException8	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   80	85	92	java/io/IOException
    //   1803	1808	92	java/io/IOException
    //   1837	1842	92	java/io/IOException
    //   1871	1876	92	java/io/IOException
    //   58	65	1715	finally
    //   70	74	1715	finally
    //   134	143	1715	finally
    //   148	157	1715	finally
    //   167	194	1715	finally
    //   213	222	1715	finally
    //   227	236	1715	finally
    //   246	272	1715	finally
    //   276	323	1715	finally
    //   342	352	1715	finally
    //   364	373	1715	finally
    //   395	414	1715	finally
    //   439	447	1715	finally
    //   459	468	1715	finally
    //   473	478	1715	finally
    //   485	494	1715	finally
    //   516	523	1715	finally
    //   542	558	1715	finally
    //   570	579	1715	finally
    //   611	621	1715	finally
    //   633	637	1715	finally
    //   655	661	1715	finally
    //   673	681	1715	finally
    //   693	702	1715	finally
    //   714	722	1715	finally
    //   734	742	1715	finally
    //   754	762	1715	finally
    //   783	793	1715	finally
    //   805	814	1715	finally
    //   832	852	1715	finally
    //   870	876	1715	finally
    //   888	896	1715	finally
    //   908	917	1715	finally
    //   929	937	1715	finally
    //   949	957	1715	finally
    //   969	977	1715	finally
    //   998	1008	1715	finally
    //   1020	1029	1715	finally
    //   1047	1067	1715	finally
    //   1085	1091	1715	finally
    //   1103	1111	1715	finally
    //   1123	1132	1715	finally
    //   1144	1152	1715	finally
    //   1164	1172	1715	finally
    //   1184	1192	1715	finally
    //   1213	1223	1715	finally
    //   1235	1243	1715	finally
    //   1255	1265	1715	finally
    //   1277	1281	1715	finally
    //   1299	1305	1715	finally
    //   1317	1325	1715	finally
    //   1337	1346	1715	finally
    //   1358	1366	1715	finally
    //   1378	1386	1715	finally
    //   1398	1406	1715	finally
    //   1427	1437	1715	finally
    //   1449	1458	1715	finally
    //   1482	1501	1715	finally
    //   1509	1516	1715	finally
    //   1571	1581	1715	finally
    //   1593	1602	1715	finally
    //   1626	1645	1715	finally
    //   1653	1659	1715	finally
    //   28	46	1750	finally
    //   1760	1765	1768	java/io/IOException
    //   28	46	2300	java/io/FileNotFoundException
    //   28	46	2305	java/io/IOException
    //   28	46	2310	java/lang/NumberFormatException
    //   58	65	2315	java/io/FileNotFoundException
    //   134	143	2315	java/io/FileNotFoundException
    //   213	222	2315	java/io/FileNotFoundException
    //   342	352	2315	java/io/FileNotFoundException
    //   364	373	2315	java/io/FileNotFoundException
    //   395	414	2315	java/io/FileNotFoundException
    //   439	447	2315	java/io/FileNotFoundException
    //   459	468	2315	java/io/FileNotFoundException
    //   516	523	2315	java/io/FileNotFoundException
    //   542	558	2315	java/io/FileNotFoundException
    //   58	65	2320	java/io/IOException
    //   134	143	2320	java/io/IOException
    //   213	222	2320	java/io/IOException
    //   342	352	2320	java/io/IOException
    //   364	373	2320	java/io/IOException
    //   395	414	2320	java/io/IOException
    //   439	447	2320	java/io/IOException
    //   459	468	2320	java/io/IOException
    //   516	523	2320	java/io/IOException
    //   542	558	2320	java/io/IOException
    //   58	65	2325	java/lang/NumberFormatException
    //   134	143	2325	java/lang/NumberFormatException
    //   213	222	2325	java/lang/NumberFormatException
    //   342	352	2325	java/lang/NumberFormatException
    //   364	373	2325	java/lang/NumberFormatException
    //   395	414	2325	java/lang/NumberFormatException
    //   439	447	2325	java/lang/NumberFormatException
    //   459	468	2325	java/lang/NumberFormatException
    //   516	523	2325	java/lang/NumberFormatException
    //   70	74	2330	java/io/FileNotFoundException
    //   148	157	2330	java/io/FileNotFoundException
    //   167	194	2330	java/io/FileNotFoundException
    //   227	236	2330	java/io/FileNotFoundException
    //   246	272	2330	java/io/FileNotFoundException
    //   276	323	2330	java/io/FileNotFoundException
    //   473	478	2330	java/io/FileNotFoundException
    //   485	494	2330	java/io/FileNotFoundException
    //   70	74	2335	java/io/IOException
    //   148	157	2335	java/io/IOException
    //   167	194	2335	java/io/IOException
    //   227	236	2335	java/io/IOException
    //   246	272	2335	java/io/IOException
    //   276	323	2335	java/io/IOException
    //   473	478	2335	java/io/IOException
    //   485	494	2335	java/io/IOException
    //   70	74	2340	java/lang/NumberFormatException
    //   148	157	2340	java/lang/NumberFormatException
    //   167	194	2340	java/lang/NumberFormatException
    //   227	236	2340	java/lang/NumberFormatException
    //   246	272	2340	java/lang/NumberFormatException
    //   276	323	2340	java/lang/NumberFormatException
    //   473	478	2340	java/lang/NumberFormatException
    //   485	494	2345	java/lang/NumberFormatException
    //   542	558	2350	java/lang/NumberFormatException
    //   570	579	2355	java/lang/NumberFormatException
    //   570	579	2360	java/io/FileNotFoundException
    //   611	621	2360	java/io/FileNotFoundException
    //   633	637	2360	java/io/FileNotFoundException
    //   655	661	2360	java/io/FileNotFoundException
    //   673	681	2360	java/io/FileNotFoundException
    //   693	702	2360	java/io/FileNotFoundException
    //   714	722	2360	java/io/FileNotFoundException
    //   734	742	2360	java/io/FileNotFoundException
    //   754	762	2360	java/io/FileNotFoundException
    //   783	793	2360	java/io/FileNotFoundException
    //   805	814	2360	java/io/FileNotFoundException
    //   832	852	2360	java/io/FileNotFoundException
    //   870	876	2360	java/io/FileNotFoundException
    //   888	896	2360	java/io/FileNotFoundException
    //   908	917	2360	java/io/FileNotFoundException
    //   929	937	2360	java/io/FileNotFoundException
    //   949	957	2360	java/io/FileNotFoundException
    //   969	977	2360	java/io/FileNotFoundException
    //   998	1008	2360	java/io/FileNotFoundException
    //   1020	1029	2360	java/io/FileNotFoundException
    //   1047	1067	2360	java/io/FileNotFoundException
    //   1085	1091	2360	java/io/FileNotFoundException
    //   1103	1111	2360	java/io/FileNotFoundException
    //   1123	1132	2360	java/io/FileNotFoundException
    //   1144	1152	2360	java/io/FileNotFoundException
    //   1164	1172	2360	java/io/FileNotFoundException
    //   1184	1192	2360	java/io/FileNotFoundException
    //   1213	1223	2360	java/io/FileNotFoundException
    //   1235	1243	2360	java/io/FileNotFoundException
    //   1255	1265	2360	java/io/FileNotFoundException
    //   1277	1281	2360	java/io/FileNotFoundException
    //   1299	1305	2360	java/io/FileNotFoundException
    //   1317	1325	2360	java/io/FileNotFoundException
    //   1337	1346	2360	java/io/FileNotFoundException
    //   1358	1366	2360	java/io/FileNotFoundException
    //   1378	1386	2360	java/io/FileNotFoundException
    //   1398	1406	2360	java/io/FileNotFoundException
    //   1427	1437	2360	java/io/FileNotFoundException
    //   1449	1458	2360	java/io/FileNotFoundException
    //   1482	1501	2360	java/io/FileNotFoundException
    //   1509	1516	2360	java/io/FileNotFoundException
    //   1571	1581	2360	java/io/FileNotFoundException
    //   1593	1602	2360	java/io/FileNotFoundException
    //   1626	1645	2360	java/io/FileNotFoundException
    //   1653	1659	2360	java/io/FileNotFoundException
    //   570	579	2365	java/io/IOException
    //   611	621	2365	java/io/IOException
    //   633	637	2365	java/io/IOException
    //   655	661	2365	java/io/IOException
    //   673	681	2365	java/io/IOException
    //   693	702	2365	java/io/IOException
    //   714	722	2365	java/io/IOException
    //   734	742	2365	java/io/IOException
    //   754	762	2365	java/io/IOException
    //   783	793	2365	java/io/IOException
    //   805	814	2365	java/io/IOException
    //   832	852	2365	java/io/IOException
    //   870	876	2365	java/io/IOException
    //   888	896	2365	java/io/IOException
    //   908	917	2365	java/io/IOException
    //   929	937	2365	java/io/IOException
    //   949	957	2365	java/io/IOException
    //   969	977	2365	java/io/IOException
    //   998	1008	2365	java/io/IOException
    //   1020	1029	2365	java/io/IOException
    //   1047	1067	2365	java/io/IOException
    //   1085	1091	2365	java/io/IOException
    //   1103	1111	2365	java/io/IOException
    //   1123	1132	2365	java/io/IOException
    //   1144	1152	2365	java/io/IOException
    //   1164	1172	2365	java/io/IOException
    //   1184	1192	2365	java/io/IOException
    //   1213	1223	2365	java/io/IOException
    //   1235	1243	2365	java/io/IOException
    //   1255	1265	2365	java/io/IOException
    //   1277	1281	2365	java/io/IOException
    //   1299	1305	2365	java/io/IOException
    //   1317	1325	2365	java/io/IOException
    //   1337	1346	2365	java/io/IOException
    //   1358	1366	2365	java/io/IOException
    //   1378	1386	2365	java/io/IOException
    //   1398	1406	2365	java/io/IOException
    //   1427	1437	2365	java/io/IOException
    //   1449	1458	2365	java/io/IOException
    //   1482	1501	2365	java/io/IOException
    //   1509	1516	2365	java/io/IOException
    //   1571	1581	2365	java/io/IOException
    //   1593	1602	2365	java/io/IOException
    //   1626	1645	2365	java/io/IOException
    //   1653	1659	2365	java/io/IOException
    //   611	621	2370	java/lang/NumberFormatException
    //   633	637	2370	java/lang/NumberFormatException
    //   655	661	2370	java/lang/NumberFormatException
    //   673	681	2370	java/lang/NumberFormatException
    //   693	702	2370	java/lang/NumberFormatException
    //   714	722	2370	java/lang/NumberFormatException
    //   734	742	2370	java/lang/NumberFormatException
    //   754	762	2370	java/lang/NumberFormatException
    //   783	793	2370	java/lang/NumberFormatException
    //   805	814	2370	java/lang/NumberFormatException
    //   832	852	2370	java/lang/NumberFormatException
    //   870	876	2370	java/lang/NumberFormatException
    //   888	896	2370	java/lang/NumberFormatException
    //   908	917	2370	java/lang/NumberFormatException
    //   929	937	2370	java/lang/NumberFormatException
    //   949	957	2370	java/lang/NumberFormatException
    //   969	977	2370	java/lang/NumberFormatException
    //   998	1008	2370	java/lang/NumberFormatException
    //   1020	1029	2370	java/lang/NumberFormatException
    //   1047	1067	2370	java/lang/NumberFormatException
    //   1085	1091	2370	java/lang/NumberFormatException
    //   1103	1111	2370	java/lang/NumberFormatException
    //   1123	1132	2370	java/lang/NumberFormatException
    //   1144	1152	2370	java/lang/NumberFormatException
    //   1164	1172	2370	java/lang/NumberFormatException
    //   1184	1192	2370	java/lang/NumberFormatException
    //   1213	1223	2370	java/lang/NumberFormatException
    //   1235	1243	2370	java/lang/NumberFormatException
    //   1255	1265	2370	java/lang/NumberFormatException
    //   1277	1281	2370	java/lang/NumberFormatException
    //   1299	1305	2370	java/lang/NumberFormatException
    //   1317	1325	2370	java/lang/NumberFormatException
    //   1337	1346	2370	java/lang/NumberFormatException
    //   1358	1366	2370	java/lang/NumberFormatException
    //   1378	1386	2370	java/lang/NumberFormatException
    //   1398	1406	2370	java/lang/NumberFormatException
    //   1427	1437	2370	java/lang/NumberFormatException
    //   1449	1458	2370	java/lang/NumberFormatException
    //   1482	1501	2370	java/lang/NumberFormatException
    //   1571	1581	2370	java/lang/NumberFormatException
    //   1593	1602	2370	java/lang/NumberFormatException
    //   1626	1645	2370	java/lang/NumberFormatException
    //   1509	1516	2375	java/lang/NumberFormatException
    //   1653	1659	2375	java/lang/NumberFormatException
  }
  
  public static String getCpuModel()
  {
    getCpuInfo();
    return strCPUModel;
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
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 5
    //   14: ldc 31
    //   16: astore 6
    //   18: new 100	java/io/BufferedReader
    //   21: dup
    //   22: new 102	java/io/FileReader
    //   25: dup
    //   26: ldc_w 307
    //   29: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 7
    //   44: aload 6
    //   46: astore 5
    //   48: aload 7
    //   50: invokestatic 312	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +10 -> 63
    //   56: aload 7
    //   58: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   61: astore 5
    //   63: lload_2
    //   64: lstore_0
    //   65: aload 5
    //   67: ifnull +19 -> 86
    //   70: lload_2
    //   71: lstore_0
    //   72: aload 5
    //   74: invokevirtual 134	java/lang/String:length	()I
    //   77: ifle +9 -> 86
    //   80: aload 5
    //   82: invokestatic 182	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   85: lstore_0
    //   86: lload_0
    //   87: lstore_2
    //   88: aload 4
    //   90: invokevirtual 116	java/io/BufferedReader:close	()V
    //   93: lload_0
    //   94: lreturn
    //   95: astore 4
    //   97: aload 4
    //   99: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   102: lload_2
    //   103: lreturn
    //   104: astore 6
    //   106: aload 4
    //   108: astore 5
    //   110: aload 6
    //   112: astore 4
    //   114: goto +14 -> 128
    //   117: goto +34 -> 151
    //   120: goto +43 -> 163
    //   123: goto +52 -> 175
    //   126: astore 4
    //   128: aload 5
    //   130: ifnull +18 -> 148
    //   133: aload 5
    //   135: invokevirtual 116	java/io/BufferedReader:close	()V
    //   138: goto +10 -> 148
    //   141: astore 5
    //   143: aload 5
    //   145: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   148: aload 4
    //   150: athrow
    //   151: aload 4
    //   153: ifnull +32 -> 185
    //   156: aload 4
    //   158: invokevirtual 116	java/io/BufferedReader:close	()V
    //   161: lconst_0
    //   162: lreturn
    //   163: aload 4
    //   165: ifnull +20 -> 185
    //   168: aload 4
    //   170: invokevirtual 116	java/io/BufferedReader:close	()V
    //   173: lconst_0
    //   174: lreturn
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 116	java/io/BufferedReader:close	()V
    //   185: lconst_0
    //   186: lreturn
    //   187: astore 4
    //   189: aload 9
    //   191: astore 4
    //   193: goto -18 -> 175
    //   196: astore 4
    //   198: aload 8
    //   200: astore 4
    //   202: goto -39 -> 163
    //   205: astore 4
    //   207: aload 7
    //   209: astore 4
    //   211: goto -60 -> 151
    //   214: astore 5
    //   216: goto -93 -> 123
    //   219: astore 5
    //   221: goto -101 -> 120
    //   224: astore 5
    //   226: goto -109 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   64	30	0	l1	long
    //   1	102	2	l2	long
    //   35	54	4	localBufferedReader	java.io.BufferedReader
    //   95	12	4	localIOException1	java.io.IOException
    //   112	1	4	localObject1	Object
    //   126	55	4	localObject2	Object
    //   187	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   191	1	4	localObject3	Object
    //   196	1	4	localIOException2	java.io.IOException
    //   200	1	4	localObject4	Object
    //   205	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   209	1	4	str1	String
    //   12	122	5	localObject5	Object
    //   141	3	5	localIOException3	java.io.IOException
    //   214	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   219	1	5	localIOException4	java.io.IOException
    //   224	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   16	29	6	str2	String
    //   104	7	6	localObject6	Object
    //   3	205	7	str3	String
    //   6	193	8	localObject7	Object
    //   9	181	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   156	161	95	java/io/IOException
    //   168	173	95	java/io/IOException
    //   180	185	95	java/io/IOException
    //   37	44	104	finally
    //   48	63	104	finally
    //   72	86	104	finally
    //   18	37	126	finally
    //   133	138	141	java/io/IOException
    //   18	37	187	java/io/FileNotFoundException
    //   18	37	196	java/io/IOException
    //   18	37	205	java/lang/NumberFormatException
    //   37	44	214	java/io/FileNotFoundException
    //   48	63	214	java/io/FileNotFoundException
    //   72	86	214	java/io/FileNotFoundException
    //   37	44	219	java/io/IOException
    //   48	63	219	java/io/IOException
    //   72	86	219	java/io/IOException
    //   37	44	224	java/lang/NumberFormatException
    //   48	63	224	java/lang/NumberFormatException
    //   72	86	224	java/lang/NumberFormatException
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
  
  public static String getFeature()
  {
    getCpuInfo();
    return mFeature;
  }
  
  public static boolean getIsMarvell()
  {
    getCpuInfo();
    return mIsMarvell;
  }
  
  public static long getMaxCpuFreq()
  {
    
    if (AVCoreLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMaxCpuFreq: ");
      localStringBuilder.append(Build.BRAND);
      localStringBuilder.append("|");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("|");
      localStringBuilder.append(mMaxCpuFreq);
      AVCoreLog.i("AVCoreSystemInfo", localStringBuilder.toString());
    }
    return mMaxCpuFreq;
  }
  
  /* Error */
  public static long getMemoryTotal()
  {
    // Byte code:
    //   0: getstatic 339	com/tencent/avcore/data/AVCoreSystemInfo:mHasReadMemInfo	Z
    //   3: ifeq +7 -> 10
    //   6: getstatic 341	com/tencent/avcore/data/AVCoreSystemInfo:mMemoryTotal	J
    //   9: lreturn
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_2
    //   15: new 100	java/io/BufferedReader
    //   18: dup
    //   19: new 102	java/io/FileReader
    //   22: dup
    //   23: ldc_w 343
    //   26: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   29: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnonnull +6 -> 45
    //   42: goto +109 -> 151
    //   45: aload_2
    //   46: ldc_w 345
    //   49: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -19 -> 33
    //   55: aload_2
    //   56: bipush 58
    //   58: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   61: istore_0
    //   62: iload_0
    //   63: iconst_1
    //   64: if_icmple +87 -> 151
    //   67: aload_2
    //   68: iload_0
    //   69: iconst_1
    //   70: iadd
    //   71: aload_2
    //   72: invokevirtual 134	java/lang/String:length	()I
    //   75: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   78: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   81: astore 4
    //   83: iconst_0
    //   84: istore_0
    //   85: iload_0
    //   86: aload_2
    //   87: invokevirtual 134	java/lang/String:length	()I
    //   90: if_icmpge +161 -> 251
    //   93: iload_0
    //   94: istore_1
    //   95: aload 4
    //   97: iload_0
    //   98: invokevirtual 349	java/lang/String:charAt	(I)C
    //   101: bipush 48
    //   103: if_icmplt +19 -> 122
    //   106: aload 4
    //   108: iload_0
    //   109: invokevirtual 349	java/lang/String:charAt	(I)C
    //   112: bipush 57
    //   114: if_icmple +130 -> 244
    //   117: iload_0
    //   118: istore_1
    //   119: goto +3 -> 122
    //   122: aload 4
    //   124: iconst_0
    //   125: iload_1
    //   126: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   129: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +17 -> 151
    //   137: aload_2
    //   138: invokevirtual 134	java/lang/String:length	()I
    //   141: ifle +10 -> 151
    //   144: aload_2
    //   145: invokestatic 182	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   148: putstatic 341	com/tencent/avcore/data/AVCoreSystemInfo:mMemoryTotal	J
    //   151: iconst_1
    //   152: putstatic 339	com/tencent/avcore/data/AVCoreSystemInfo:mHasReadMemInfo	Z
    //   155: aload_3
    //   156: invokevirtual 116	java/io/BufferedReader:close	()V
    //   159: goto +46 -> 205
    //   162: astore_2
    //   163: goto +46 -> 209
    //   166: goto +13 -> 179
    //   169: astore 4
    //   171: aload_2
    //   172: astore_3
    //   173: aload 4
    //   175: astore_2
    //   176: goto +33 -> 209
    //   179: aload_3
    //   180: astore_2
    //   181: ldc 25
    //   183: ldc_w 351
    //   186: invokestatic 354	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_3
    //   190: ifnull +15 -> 205
    //   193: aload_3
    //   194: invokevirtual 116	java/io/BufferedReader:close	()V
    //   197: goto +8 -> 205
    //   200: astore_2
    //   201: aload_2
    //   202: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   205: getstatic 341	com/tencent/avcore/data/AVCoreSystemInfo:mMemoryTotal	J
    //   208: lreturn
    //   209: aload_3
    //   210: ifnull +15 -> 225
    //   213: aload_3
    //   214: invokevirtual 116	java/io/BufferedReader:close	()V
    //   217: goto +8 -> 225
    //   220: astore_3
    //   221: aload_3
    //   222: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   225: goto +5 -> 230
    //   228: aload_2
    //   229: athrow
    //   230: goto -2 -> 228
    //   233: astore_2
    //   234: aload 4
    //   236: astore_3
    //   237: goto -58 -> 179
    //   240: astore_2
    //   241: goto -75 -> 166
    //   244: iload_0
    //   245: iconst_1
    //   246: iadd
    //   247: istore_0
    //   248: goto -163 -> 85
    //   251: iconst_0
    //   252: istore_1
    //   253: goto -131 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   61	187	0	i	int
    //   94	159	1	j	int
    //   14	131	2	str1	String
    //   162	10	2	localObject1	Object
    //   175	6	2	localObject2	Object
    //   200	29	2	localIOException1	java.io.IOException
    //   233	1	2	localException1	Exception
    //   240	1	2	localException2	Exception
    //   32	182	3	localObject3	Object
    //   220	2	3	localIOException2	java.io.IOException
    //   236	1	3	localObject4	Object
    //   11	112	4	str2	String
    //   169	66	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	38	162	finally
    //   45	62	162	finally
    //   67	83	162	finally
    //   85	93	162	finally
    //   95	117	162	finally
    //   122	133	162	finally
    //   137	151	162	finally
    //   151	155	162	finally
    //   15	33	169	finally
    //   181	189	169	finally
    //   155	159	200	java/io/IOException
    //   193	197	200	java/io/IOException
    //   213	217	220	java/io/IOException
    //   15	33	233	java/lang/Exception
    //   33	38	240	java/lang/Exception
    //   45	62	240	java/lang/Exception
    //   67	83	240	java/lang/Exception
    //   85	93	240	java/lang/Exception
    //   95	117	240	java/lang/Exception
    //   122	133	240	java/lang/Exception
    //   137	151	240	java/lang/Exception
    //   151	155	240	java/lang/Exception
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
  
  public static int getOpenGLVersion()
  {
    getCpuInfo();
    return mOpenGLVersion;
  }
  
  public static String getVendorId()
  {
    getCpuInfo();
    return mVendorId;
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
  
  public static boolean isNormalSharp()
  {
    getCpuInfo();
    return (mChip >= 3) && (mMaxCpuFreq / 1000L >= 800L);
  }
  
  public static boolean isSupportSharpAudio()
  {
    return true;
  }
  
  public static boolean isSupportSharpVideo()
  {
    return true;
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
    //   0: getstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   3: iconst_1
    //   4: if_icmpge +22 -> 26
    //   7: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 25
    //   15: ldc_w 428
    //   18: invokestatic 287	com/tencent/avcore/util/AVCoreLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: bipush 8
    //   23: putstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   26: iconst_0
    //   27: istore_0
    //   28: lconst_0
    //   29: lstore_2
    //   30: lload_2
    //   31: lstore 4
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_0
    //   36: getstatic 231	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   39: if_icmpge +418 -> 457
    //   42: aconst_null
    //   43: astore 11
    //   45: aconst_null
    //   46: astore 9
    //   48: ldc 31
    //   50: astore 10
    //   52: aload 9
    //   54: astore 8
    //   56: new 95	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   63: astore 12
    //   65: aload 9
    //   67: astore 8
    //   69: aload 12
    //   71: ldc_w 430
    //   74: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 9
    //   80: astore 8
    //   82: aload 12
    //   84: iload_0
    //   85: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 9
    //   91: astore 8
    //   93: aload 12
    //   95: ldc_w 432
    //   98: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 9
    //   104: astore 8
    //   106: new 100	java/io/BufferedReader
    //   109: dup
    //   110: new 102	java/io/FileReader
    //   113: dup
    //   114: aload 12
    //   116: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   122: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   125: astore 9
    //   127: aload 9
    //   129: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   132: astore 11
    //   134: aload 10
    //   136: astore 8
    //   138: aload 11
    //   140: invokestatic 312	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +10 -> 153
    //   146: aload 11
    //   148: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   151: astore 8
    //   153: lload_2
    //   154: lstore 6
    //   156: aload 8
    //   158: ifnull +21 -> 179
    //   161: lload_2
    //   162: lstore 6
    //   164: aload 8
    //   166: invokevirtual 134	java/lang/String:length	()I
    //   169: ifle +10 -> 179
    //   172: aload 8
    //   174: invokestatic 182	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   177: lstore 6
    //   179: aload 9
    //   181: invokevirtual 116	java/io/BufferedReader:close	()V
    //   184: lload 6
    //   186: lstore_2
    //   187: goto +148 -> 335
    //   190: astore 8
    //   192: aload 8
    //   194: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   197: lload 6
    //   199: lstore_2
    //   200: goto +135 -> 335
    //   203: astore 10
    //   205: aload 9
    //   207: astore 8
    //   209: aload 10
    //   211: astore 9
    //   213: goto +221 -> 434
    //   216: astore 10
    //   218: goto +14 -> 232
    //   221: astore 9
    //   223: goto +211 -> 434
    //   226: astore 10
    //   228: aload 11
    //   230: astore 9
    //   232: aload 9
    //   234: astore 8
    //   236: new 95	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   243: astore 11
    //   245: aload 9
    //   247: astore 8
    //   249: aload 11
    //   251: ldc_w 434
    //   254: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 9
    //   260: astore 8
    //   262: aload 11
    //   264: iload_0
    //   265: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 9
    //   271: astore 8
    //   273: aload 11
    //   275: ldc_w 436
    //   278: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 9
    //   284: astore 8
    //   286: aload 11
    //   288: aload 10
    //   290: invokevirtual 437	java/lang/Exception:toString	()Ljava/lang/String;
    //   293: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 9
    //   299: astore 8
    //   301: ldc 25
    //   303: aload 11
    //   305: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 354	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 9
    //   313: ifnull +18 -> 331
    //   316: aload 9
    //   318: invokevirtual 116	java/io/BufferedReader:close	()V
    //   321: goto +10 -> 331
    //   324: astore 8
    //   326: aload 8
    //   328: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   331: lconst_0
    //   332: lstore_2
    //   333: iconst_1
    //   334: istore_1
    //   335: lload 4
    //   337: lstore 6
    //   339: lload_2
    //   340: lload 4
    //   342: lcmp
    //   343: ifle +6 -> 349
    //   346: lload_2
    //   347: lstore 6
    //   349: invokestatic 157	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   352: ifeq +71 -> 423
    //   355: new 95	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   362: astore 8
    //   364: aload 8
    //   366: ldc_w 439
    //   369: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 8
    //   375: iload_0
    //   376: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 8
    //   382: ldc_w 441
    //   385: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 8
    //   391: lload_2
    //   392: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 8
    //   398: ldc_w 443
    //   401: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 8
    //   407: lload 6
    //   409: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc 25
    //   415: aload 8
    //   417: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 287	com/tencent/avcore/util/AVCoreLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: iload_0
    //   424: iconst_1
    //   425: iadd
    //   426: istore_0
    //   427: lload 6
    //   429: lstore 4
    //   431: goto -396 -> 35
    //   434: aload 8
    //   436: ifnull +18 -> 454
    //   439: aload 8
    //   441: invokevirtual 116	java/io/BufferedReader:close	()V
    //   444: goto +10 -> 454
    //   447: astore 8
    //   449: aload 8
    //   451: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   454: aload 9
    //   456: athrow
    //   457: iload_1
    //   458: ifeq +22 -> 480
    //   461: invokestatic 446	com/tencent/avcore/data/AVCoreSystemInfo:readMaxCpuFreqFromState	()J
    //   464: lstore 6
    //   466: lload 6
    //   468: lload_2
    //   469: lcmp
    //   470: ifle +10 -> 480
    //   473: lload 6
    //   475: lstore 4
    //   477: goto +3 -> 480
    //   480: new 95	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   487: astore 8
    //   489: aload 8
    //   491: ldc_w 448
    //   494: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 8
    //   500: lload 4
    //   502: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: ldc 25
    //   508: aload 8
    //   510: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 451	com/tencent/avcore/util/AVCoreLog:printAllUserLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: lload 4
    //   518: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	400	0	i	int
    //   34	424	1	j	int
    //   29	440	2	l1	long
    //   31	486	4	l2	long
    //   154	320	6	l3	long
    //   54	119	8	localObject1	Object
    //   190	3	8	localIOException1	java.io.IOException
    //   207	93	8	localObject2	Object
    //   324	3	8	localIOException2	java.io.IOException
    //   362	78	8	localStringBuilder1	StringBuilder
    //   447	3	8	localIOException3	java.io.IOException
    //   487	22	8	localStringBuilder2	StringBuilder
    //   46	166	9	localObject3	Object
    //   221	1	9	localObject4	Object
    //   230	225	9	localObject5	Object
    //   50	85	10	str	String
    //   203	7	10	localObject6	Object
    //   216	1	10	localException1	Exception
    //   226	63	10	localException2	Exception
    //   43	261	11	localObject7	Object
    //   63	52	12	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   179	184	190	java/io/IOException
    //   127	134	203	finally
    //   138	153	203	finally
    //   164	179	203	finally
    //   127	134	216	java/lang/Exception
    //   138	153	216	java/lang/Exception
    //   164	179	216	java/lang/Exception
    //   56	65	221	finally
    //   69	78	221	finally
    //   82	89	221	finally
    //   93	102	221	finally
    //   106	127	221	finally
    //   236	245	221	finally
    //   249	258	221	finally
    //   262	269	221	finally
    //   273	282	221	finally
    //   286	297	221	finally
    //   301	311	221	finally
    //   56	65	226	java/lang/Exception
    //   69	78	226	java/lang/Exception
    //   82	89	226	java/lang/Exception
    //   93	102	226	java/lang/Exception
    //   106	127	226	java/lang/Exception
    //   316	321	324	java/io/IOException
    //   439	444	447	java/io/IOException
  }
  
  /* Error */
  static long readMaxCpuFreqFromState()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: lconst_0
    //   4: lstore_3
    //   5: new 100	java/io/BufferedReader
    //   8: dup
    //   9: new 102	java/io/FileReader
    //   12: dup
    //   13: ldc_w 453
    //   16: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 9
    //   24: aload 9
    //   26: astore 7
    //   28: aload 9
    //   30: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 10
    //   35: aload 10
    //   37: astore 7
    //   39: aload 8
    //   41: astore 10
    //   43: aload 7
    //   45: astore 8
    //   47: aload 8
    //   49: ifnull +279 -> 328
    //   52: aload 9
    //   54: astore 7
    //   56: aload 9
    //   58: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 10
    //   63: aload 10
    //   65: astore 7
    //   67: goto -28 -> 39
    //   70: aload 9
    //   72: astore 7
    //   74: aload 10
    //   76: bipush 9
    //   78: invokevirtual 131	java/lang/String:indexOf	(I)I
    //   81: istore_0
    //   82: lload_3
    //   83: lstore_1
    //   84: iload_0
    //   85: iconst_m1
    //   86: if_icmpeq +47 -> 133
    //   89: aload 9
    //   91: astore 7
    //   93: aload 10
    //   95: iconst_0
    //   96: iload_0
    //   97: invokevirtual 138	java/lang/String:substring	(II)Ljava/lang/String;
    //   100: astore 8
    //   102: lload_3
    //   103: lstore_1
    //   104: aload 8
    //   106: ifnull +27 -> 133
    //   109: lload_3
    //   110: lstore_1
    //   111: aload 9
    //   113: astore 7
    //   115: aload 8
    //   117: invokevirtual 134	java/lang/String:length	()I
    //   120: ifle +13 -> 133
    //   123: aload 9
    //   125: astore 7
    //   127: aload 8
    //   129: invokestatic 182	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   132: lstore_1
    //   133: lload_1
    //   134: lstore 5
    //   136: aload 9
    //   138: invokevirtual 116	java/io/BufferedReader:close	()V
    //   141: goto +111 -> 252
    //   144: astore 7
    //   146: aload 7
    //   148: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   151: lload 5
    //   153: lstore_1
    //   154: goto +98 -> 252
    //   157: astore 10
    //   159: aload 9
    //   161: astore 8
    //   163: goto +16 -> 179
    //   166: astore 7
    //   168: aconst_null
    //   169: astore 8
    //   171: goto +128 -> 299
    //   174: astore 10
    //   176: aconst_null
    //   177: astore 8
    //   179: aload 8
    //   181: astore 7
    //   183: new 95	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   190: astore 9
    //   192: aload 8
    //   194: astore 7
    //   196: aload 9
    //   198: ldc_w 455
    //   201: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: astore 7
    //   209: aload 9
    //   211: aload 10
    //   213: invokevirtual 437	java/lang/Exception:toString	()Ljava/lang/String;
    //   216: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 8
    //   222: astore 7
    //   224: ldc 25
    //   226: aload 9
    //   228: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 460	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   234: pop
    //   235: lload_3
    //   236: lstore_1
    //   237: aload 8
    //   239: ifnull +13 -> 252
    //   242: lload_3
    //   243: lstore 5
    //   245: aload 8
    //   247: invokevirtual 116	java/io/BufferedReader:close	()V
    //   250: lload_3
    //   251: lstore_1
    //   252: new 95	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   259: astore 7
    //   261: aload 7
    //   263: ldc_w 462
    //   266: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 7
    //   272: lload_1
    //   273: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 25
    //   279: aload 7
    //   281: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 451	com/tencent/avcore/util/AVCoreLog:printAllUserLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: lload_1
    //   288: lreturn
    //   289: astore 9
    //   291: aload 7
    //   293: astore 8
    //   295: aload 9
    //   297: astore 7
    //   299: aload 8
    //   301: ifnull +18 -> 319
    //   304: aload 8
    //   306: invokevirtual 116	java/io/BufferedReader:close	()V
    //   309: goto +10 -> 319
    //   312: astore 8
    //   314: aload 8
    //   316: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   319: goto +6 -> 325
    //   322: aload 7
    //   324: athrow
    //   325: goto -3 -> 322
    //   328: aload 10
    //   330: ifnonnull -260 -> 70
    //   333: iconst_m1
    //   334: istore_0
    //   335: goto -253 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   81	254	0	i	int
    //   83	205	1	l1	long
    //   4	247	3	l2	long
    //   134	110	5	l3	long
    //   26	100	7	localObject1	Object
    //   144	3	7	localIOException1	java.io.IOException
    //   166	1	7	localObject2	Object
    //   181	142	7	localObject3	Object
    //   1	304	8	localObject4	Object
    //   312	3	8	localIOException2	java.io.IOException
    //   22	205	9	localObject5	Object
    //   289	7	9	localObject6	Object
    //   33	61	10	localObject7	Object
    //   157	1	10	localException1	Exception
    //   174	155	10	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   136	141	144	java/io/IOException
    //   245	250	144	java/io/IOException
    //   28	35	157	java/lang/Exception
    //   56	63	157	java/lang/Exception
    //   74	82	157	java/lang/Exception
    //   93	102	157	java/lang/Exception
    //   115	123	157	java/lang/Exception
    //   127	133	157	java/lang/Exception
    //   5	24	166	finally
    //   5	24	174	java/lang/Exception
    //   28	35	289	finally
    //   56	63	289	finally
    //   74	82	289	finally
    //   93	102	289	finally
    //   115	123	289	finally
    //   127	133	289	finally
    //   183	192	289	finally
    //   196	205	289	finally
    //   209	220	289	finally
    //   224	235	289	finally
    //   304	309	312	java/io/IOException
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new AVCoreSystemInfo.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 0;
  }
  
  public int getCameraFacing()
  {
    return 2;
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
    this.mDisplayWidth = paramInt1;
    this.mDisplayHeight = paramInt2;
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.data.AVCoreSystemInfo
 * JD-Core Version:    0.7.0.1
 */