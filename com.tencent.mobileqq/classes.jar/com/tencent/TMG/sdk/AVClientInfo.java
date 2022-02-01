package com.tencent.TMG.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.TMG.config.Common;
import com.tencent.TMG.utils.AVDeviceHelper;
import com.tencent.TMG.utils.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class AVClientInfo
{
  public static final int CHIP_ARM_V5 = 1;
  public static final int CHIP_ARM_V6 = 2;
  public static final int CHIP_ARM_V7_NENO = 4;
  public static final int CHIP_ARM_V7_NO_NENO = 3;
  public static final int CHIP_ARM_V8 = 5;
  public static final int CHIP_MIPS = 6;
  public static final int CHIP_UNKNOW = 0;
  public static final int CHIP_X86 = 7;
  static final String TAG = "AVClientInfo";
  static int mChip = 1;
  static int mCoreNumber = 1;
  static int mCpuArchitecture = 5;
  static String mFeature = "";
  static String mHardware;
  static boolean mIsMarvell = false;
  static boolean mIsSupportSharpAudio = true;
  static boolean mIsSupportSharpVideo = true;
  static long mMaxCpuFreq = 0L;
  static int mOpenGLVersion = 2;
  static String mProcessorName = "";
  static String mVendorId;
  public static Context m_Context;
  static boolean mfReadCpuInfo = false;
  static long mgMaxCpuFreq;
  static int mgNumCores;
  
  public static void Init(Context paramContext)
  {
    m_Context = paramContext;
  }
  
  public static String getAppVersion()
  {
    return Common.getVersion(m_Context);
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
    //   0: getstatic 86	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
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
    //   25: astore 13
    //   27: new 98	java/io/BufferedReader
    //   30: dup
    //   31: aload 13
    //   33: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore 14
    //   38: aload 14
    //   40: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 15
    //   45: aload 15
    //   47: ifnonnull +48 -> 95
    //   50: iconst_1
    //   51: putstatic 86	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
    //   54: fload_2
    //   55: fstore_3
    //   56: lload 7
    //   58: lstore 9
    //   60: aload 14
    //   62: invokevirtual 107	java/io/BufferedReader:close	()V
    //   65: fload_2
    //   66: fstore_3
    //   67: lload 7
    //   69: lstore 9
    //   71: aload 13
    //   73: invokevirtual 108	java/io/FileReader:close	()V
    //   76: goto +757 -> 833
    //   79: astore 13
    //   81: aload 13
    //   83: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   86: fload_3
    //   87: fstore_2
    //   88: lload 9
    //   90: lstore 7
    //   92: goto +741 -> 833
    //   95: aload 15
    //   97: ldc 113
    //   99: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +47 -> 149
    //   105: aload 15
    //   107: bipush 58
    //   109: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   112: istore 5
    //   114: iload 5
    //   116: iconst_1
    //   117: if_icmple -79 -> 38
    //   120: aload 15
    //   122: iload 5
    //   124: iconst_1
    //   125: iadd
    //   126: aload 15
    //   128: invokevirtual 126	java/lang/String:length	()I
    //   131: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   134: putstatic 72	com/tencent/TMG/sdk/AVClientInfo:mProcessorName	Ljava/lang/String;
    //   137: getstatic 72	com/tencent/TMG/sdk/AVClientInfo:mProcessorName	Ljava/lang/String;
    //   140: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   143: putstatic 72	com/tencent/TMG/sdk/AVClientInfo:mProcessorName	Ljava/lang/String;
    //   146: goto -108 -> 38
    //   149: aload 15
    //   151: ldc 135
    //   153: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   156: ifeq +147 -> 303
    //   159: aload 15
    //   161: bipush 58
    //   163: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   166: istore 5
    //   168: iload 5
    //   170: iconst_1
    //   171: if_icmple +115 -> 286
    //   174: aload 15
    //   176: iload 5
    //   178: iconst_1
    //   179: iadd
    //   180: aload 15
    //   182: invokevirtual 126	java/lang/String:length	()I
    //   185: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   188: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   191: astore 16
    //   193: aload 16
    //   195: ifnull +91 -> 286
    //   198: aload 16
    //   200: invokevirtual 126	java/lang/String:length	()I
    //   203: ifle +83 -> 286
    //   206: aload 16
    //   208: ldc 137
    //   210: invokevirtual 140	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: ifeq +11 -> 224
    //   216: bipush 8
    //   218: putstatic 142	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   221: goto +65 -> 286
    //   224: aload 16
    //   226: invokestatic 148	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   229: l2i
    //   230: putstatic 142	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   233: goto +53 -> 286
    //   236: iconst_1
    //   237: istore 5
    //   239: aload 16
    //   241: invokevirtual 126	java/lang/String:length	()I
    //   244: istore 6
    //   246: iload 5
    //   248: iload 6
    //   250: if_icmpge +36 -> 286
    //   253: aload 16
    //   255: iconst_0
    //   256: aload 16
    //   258: invokevirtual 126	java/lang/String:length	()I
    //   261: iload 5
    //   263: isub
    //   264: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   267: invokestatic 148	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   270: l2i
    //   271: putstatic 142	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   274: goto +12 -> 286
    //   277: iload 5
    //   279: iconst_1
    //   280: iadd
    //   281: istore 5
    //   283: goto -44 -> 239
    //   286: aload 15
    //   288: ldc 150
    //   290: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   293: ifeq -255 -> 38
    //   296: iconst_5
    //   297: putstatic 142	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   300: goto -262 -> 38
    //   303: aload 15
    //   305: ldc 156
    //   307: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   310: ifeq +41 -> 351
    //   313: aload 15
    //   315: bipush 58
    //   317: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   320: istore 5
    //   322: iload 5
    //   324: iconst_1
    //   325: if_icmple -287 -> 38
    //   328: aload 15
    //   330: iload 5
    //   332: iconst_1
    //   333: iadd
    //   334: aload 15
    //   336: invokevirtual 126	java/lang/String:length	()I
    //   339: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   342: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   345: putstatic 158	com/tencent/TMG/sdk/AVClientInfo:mFeature	Ljava/lang/String;
    //   348: goto -310 -> 38
    //   351: aload 15
    //   353: ldc 160
    //   355: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   358: ifeq +41 -> 399
    //   361: aload 15
    //   363: bipush 58
    //   365: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   368: istore 5
    //   370: iload 5
    //   372: iconst_1
    //   373: if_icmple -335 -> 38
    //   376: aload 15
    //   378: iload 5
    //   380: iconst_1
    //   381: iadd
    //   382: aload 15
    //   384: invokevirtual 126	java/lang/String:length	()I
    //   387: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   390: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   393: putstatic 162	com/tencent/TMG/sdk/AVClientInfo:mVendorId	Ljava/lang/String;
    //   396: goto -358 -> 38
    //   399: aload 15
    //   401: ldc 164
    //   403: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   406: ifeq +28 -> 434
    //   409: aload 15
    //   411: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   414: putstatic 166	com/tencent/TMG/sdk/AVClientInfo:mHardware	Ljava/lang/String;
    //   417: aload 15
    //   419: ldc 168
    //   421: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   424: ifeq -386 -> 38
    //   427: iconst_1
    //   428: putstatic 170	com/tencent/TMG/sdk/AVClientInfo:mIsMarvell	Z
    //   431: goto -393 -> 38
    //   434: aload 15
    //   436: ldc 172
    //   438: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   441: ifeq +72 -> 513
    //   444: aload 15
    //   446: bipush 58
    //   448: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   451: istore 5
    //   453: iload 5
    //   455: iconst_1
    //   456: if_icmple -418 -> 38
    //   459: aload 15
    //   461: iload 5
    //   463: iconst_1
    //   464: iadd
    //   465: aload 15
    //   467: invokevirtual 126	java/lang/String:length	()I
    //   470: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   473: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   476: astore 15
    //   478: aload 15
    //   480: invokestatic 148	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   483: lstore 9
    //   485: lload 9
    //   487: lconst_0
    //   488: lcmp
    //   489: iflt -451 -> 38
    //   492: lload 9
    //   494: lconst_1
    //   495: ladd
    //   496: lstore 9
    //   498: lload 9
    //   500: lload 7
    //   502: lcmp
    //   503: ifle -465 -> 38
    //   506: lload 9
    //   508: lstore 7
    //   510: goto -472 -> 38
    //   513: aload 15
    //   515: ldc 174
    //   517: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   520: ifeq -482 -> 38
    //   523: aload 15
    //   525: bipush 58
    //   527: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   530: istore 5
    //   532: iload 5
    //   534: iconst_1
    //   535: if_icmple -497 -> 38
    //   538: aload 15
    //   540: iload 5
    //   542: iconst_1
    //   543: iadd
    //   544: aload 15
    //   546: invokevirtual 126	java/lang/String:length	()I
    //   549: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   552: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   555: astore 15
    //   557: aload 15
    //   559: invokestatic 180	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   562: fstore_3
    //   563: fload_3
    //   564: fload_2
    //   565: fcmpl
    //   566: ifle -528 -> 38
    //   569: fload_3
    //   570: fstore_2
    //   571: goto -533 -> 38
    //   574: astore 15
    //   576: goto +59 -> 635
    //   579: astore 15
    //   581: aconst_null
    //   582: astore 14
    //   584: goto +51 -> 635
    //   587: aconst_null
    //   588: astore 14
    //   590: fload_2
    //   591: fstore 4
    //   593: lload 7
    //   595: lstore 11
    //   597: goto +86 -> 683
    //   600: aconst_null
    //   601: astore 14
    //   603: fload_2
    //   604: fstore 4
    //   606: lload 7
    //   608: lstore 11
    //   610: goto +124 -> 734
    //   613: aconst_null
    //   614: astore 14
    //   616: fload_2
    //   617: fstore 4
    //   619: lload 7
    //   621: lstore 11
    //   623: goto +162 -> 785
    //   626: astore 15
    //   628: aconst_null
    //   629: astore 13
    //   631: aload 13
    //   633: astore 14
    //   635: aload 14
    //   637: ifnull +11 -> 648
    //   640: aload 14
    //   642: invokevirtual 107	java/io/BufferedReader:close	()V
    //   645: goto +3 -> 648
    //   648: aload 13
    //   650: ifnull +16 -> 666
    //   653: aload 13
    //   655: invokevirtual 108	java/io/FileReader:close	()V
    //   658: goto +8 -> 666
    //   661: aload 13
    //   663: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   666: aload 15
    //   668: athrow
    //   669: aconst_null
    //   670: astore 13
    //   672: aload 13
    //   674: astore 14
    //   676: lload 7
    //   678: lstore 11
    //   680: fload_2
    //   681: fstore 4
    //   683: aload 14
    //   685: ifnull +15 -> 700
    //   688: fload 4
    //   690: fstore_3
    //   691: lload 11
    //   693: lstore 9
    //   695: aload 14
    //   697: invokevirtual 107	java/io/BufferedReader:close	()V
    //   700: fload 4
    //   702: fstore_2
    //   703: lload 11
    //   705: lstore 7
    //   707: aload 13
    //   709: ifnull +124 -> 833
    //   712: fload 4
    //   714: fstore_3
    //   715: lload 11
    //   717: lstore 9
    //   719: aload 13
    //   721: invokevirtual 108	java/io/FileReader:close	()V
    //   724: fload 4
    //   726: fstore_2
    //   727: lload 11
    //   729: lstore 7
    //   731: goto +102 -> 833
    //   734: aload 14
    //   736: ifnull +15 -> 751
    //   739: fload 4
    //   741: fstore_3
    //   742: lload 11
    //   744: lstore 9
    //   746: aload 14
    //   748: invokevirtual 107	java/io/BufferedReader:close	()V
    //   751: fload 4
    //   753: fstore_2
    //   754: lload 11
    //   756: lstore 7
    //   758: aload 13
    //   760: ifnull +73 -> 833
    //   763: fload 4
    //   765: fstore_3
    //   766: lload 11
    //   768: lstore 9
    //   770: aload 13
    //   772: invokevirtual 108	java/io/FileReader:close	()V
    //   775: fload 4
    //   777: fstore_2
    //   778: lload 11
    //   780: lstore 7
    //   782: goto +51 -> 833
    //   785: aload 14
    //   787: ifnull +15 -> 802
    //   790: fload 4
    //   792: fstore_3
    //   793: lload 11
    //   795: lstore 9
    //   797: aload 14
    //   799: invokevirtual 107	java/io/BufferedReader:close	()V
    //   802: fload 4
    //   804: fstore_2
    //   805: lload 11
    //   807: lstore 7
    //   809: aload 13
    //   811: ifnull +22 -> 833
    //   814: fload 4
    //   816: fstore_3
    //   817: lload 11
    //   819: lstore 9
    //   821: aload 13
    //   823: invokevirtual 108	java/io/FileReader:close	()V
    //   826: lload 11
    //   828: lstore 7
    //   830: fload 4
    //   832: fstore_2
    //   833: invokestatic 183	com/tencent/TMG/sdk/AVClientInfo:readNumCores	()I
    //   836: istore 5
    //   838: iload 5
    //   840: ifle +11 -> 851
    //   843: iload 5
    //   845: putstatic 185	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   848: goto +16 -> 864
    //   851: lload 7
    //   853: lconst_0
    //   854: lcmp
    //   855: ifle +9 -> 864
    //   858: lload 7
    //   860: l2i
    //   861: putstatic 185	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   864: invokestatic 189	com/tencent/TMG/sdk/AVClientInfo:readMaxCpuFreq	()J
    //   867: lstore 7
    //   869: lload 7
    //   871: lconst_0
    //   872: lcmp
    //   873: ifle +11 -> 884
    //   876: lload 7
    //   878: putstatic 191	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   881: goto +79 -> 960
    //   884: fload_2
    //   885: fconst_0
    //   886: fcmpl
    //   887: ifle +73 -> 960
    //   890: fload_2
    //   891: ldc 192
    //   893: fcmpg
    //   894: ifge +27 -> 921
    //   897: fload_2
    //   898: f2d
    //   899: dstore_0
    //   900: dload_0
    //   901: invokestatic 198	java/lang/Double:isNaN	(D)Z
    //   904: pop
    //   905: dload_0
    //   906: ldc2_w 199
    //   909: dmul
    //   910: ldc2_w 201
    //   913: dmul
    //   914: d2l
    //   915: putstatic 191	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   918: goto +42 -> 960
    //   921: fload_2
    //   922: ldc 203
    //   924: fcmpl
    //   925: ifle +27 -> 952
    //   928: fload_2
    //   929: f2d
    //   930: dstore_0
    //   931: dload_0
    //   932: invokestatic 198	java/lang/Double:isNaN	(D)Z
    //   935: pop
    //   936: dload_0
    //   937: ldc2_w 204
    //   940: ddiv
    //   941: ldc2_w 201
    //   944: dmul
    //   945: d2l
    //   946: putstatic 191	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   949: goto +11 -> 960
    //   952: fload_2
    //   953: ldc 206
    //   955: fmul
    //   956: f2l
    //   957: putstatic 191	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   960: getstatic 185	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   963: ifle +21 -> 984
    //   966: getstatic 191	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   969: lconst_0
    //   970: lcmp
    //   971: ifgt +6 -> 977
    //   974: goto +10 -> 984
    //   977: iconst_1
    //   978: putstatic 86	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
    //   981: goto +7 -> 988
    //   984: iconst_0
    //   985: putstatic 86	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
    //   988: invokestatic 209	com/tencent/TMG/sdk/AVClientInfo:readCpuArchitecture	()I
    //   991: putstatic 76	com/tencent/TMG/sdk/AVClientInfo:mChip	I
    //   994: return
    //   995: astore 13
    //   997: goto +101 -> 1098
    //   1000: astore 13
    //   1002: goto +79 -> 1081
    //   1005: astore 13
    //   1007: goto -338 -> 669
    //   1010: astore 14
    //   1012: goto -399 -> 613
    //   1015: astore 14
    //   1017: goto -417 -> 600
    //   1020: astore 14
    //   1022: goto -435 -> 587
    //   1025: astore 15
    //   1027: fload_2
    //   1028: fstore 4
    //   1030: lload 7
    //   1032: lstore 11
    //   1034: goto -249 -> 785
    //   1037: astore 15
    //   1039: fload_2
    //   1040: fstore 4
    //   1042: lload 7
    //   1044: lstore 11
    //   1046: goto -312 -> 734
    //   1049: astore 15
    //   1051: fload_2
    //   1052: fstore 4
    //   1054: lload 7
    //   1056: lstore 11
    //   1058: goto -375 -> 683
    //   1061: astore 17
    //   1063: goto -827 -> 236
    //   1066: astore 17
    //   1068: goto -791 -> 277
    //   1071: astore 15
    //   1073: goto -1035 -> 38
    //   1076: astore 13
    //   1078: goto -417 -> 661
    //   1081: aconst_null
    //   1082: astore 13
    //   1084: aload 13
    //   1086: astore 14
    //   1088: fload_2
    //   1089: fstore 4
    //   1091: lload 7
    //   1093: lstore 11
    //   1095: goto -361 -> 734
    //   1098: aconst_null
    //   1099: astore 13
    //   1101: aload 13
    //   1103: astore 14
    //   1105: fload_2
    //   1106: fstore 4
    //   1108: lload 7
    //   1110: lstore 11
    //   1112: goto -327 -> 785
    // Local variable table:
    //   start	length	slot	name	signature
    //   899	38	0	d	double
    //   15	1091	2	f1	float
    //   55	762	3	f2	float
    //   591	516	4	f3	float
    //   112	732	5	i	int
    //   244	7	6	j	int
    //   11	1098	7	l1	long
    //   58	762	9	l2	long
    //   595	516	11	l3	long
    //   25	47	13	localFileReader	java.io.FileReader
    //   79	3	13	localException1	Exception
    //   629	193	13	localObject1	Object
    //   995	1	13	localFileNotFoundException1	java.io.FileNotFoundException
    //   1000	1	13	localIOException1	java.io.IOException
    //   1005	1	13	localNumberFormatException1	java.lang.NumberFormatException
    //   1076	1	13	localException2	Exception
    //   1082	20	13	localObject2	Object
    //   36	762	14	localObject3	Object
    //   1010	1	14	localFileNotFoundException2	java.io.FileNotFoundException
    //   1015	1	14	localIOException2	java.io.IOException
    //   1020	1	14	localNumberFormatException2	java.lang.NumberFormatException
    //   1086	18	14	localObject4	Object
    //   43	515	15	str1	String
    //   574	1	15	localObject5	Object
    //   579	1	15	localObject6	Object
    //   626	41	15	localObject7	Object
    //   1025	1	15	localFileNotFoundException3	java.io.FileNotFoundException
    //   1037	1	15	localIOException3	java.io.IOException
    //   1049	1	15	localNumberFormatException3	java.lang.NumberFormatException
    //   1071	1	15	localNumberFormatException4	java.lang.NumberFormatException
    //   191	66	16	str2	String
    //   1061	1	17	localNumberFormatException5	java.lang.NumberFormatException
    //   1066	1	17	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   60	65	79	java/lang/Exception
    //   71	76	79	java/lang/Exception
    //   695	700	79	java/lang/Exception
    //   719	724	79	java/lang/Exception
    //   746	751	79	java/lang/Exception
    //   770	775	79	java/lang/Exception
    //   797	802	79	java/lang/Exception
    //   821	826	79	java/lang/Exception
    //   38	45	574	finally
    //   50	54	574	finally
    //   95	114	574	finally
    //   120	146	574	finally
    //   149	168	574	finally
    //   174	193	574	finally
    //   198	221	574	finally
    //   224	233	574	finally
    //   239	246	574	finally
    //   253	274	574	finally
    //   286	300	574	finally
    //   303	322	574	finally
    //   328	348	574	finally
    //   351	370	574	finally
    //   376	396	574	finally
    //   399	431	574	finally
    //   434	453	574	finally
    //   459	478	574	finally
    //   478	485	574	finally
    //   513	532	574	finally
    //   538	557	574	finally
    //   557	563	574	finally
    //   27	38	579	finally
    //   16	27	626	finally
    //   16	27	995	java/io/FileNotFoundException
    //   16	27	1000	java/io/IOException
    //   16	27	1005	java/lang/NumberFormatException
    //   27	38	1010	java/io/FileNotFoundException
    //   27	38	1015	java/io/IOException
    //   27	38	1020	java/lang/NumberFormatException
    //   38	45	1025	java/io/FileNotFoundException
    //   50	54	1025	java/io/FileNotFoundException
    //   95	114	1025	java/io/FileNotFoundException
    //   120	146	1025	java/io/FileNotFoundException
    //   149	168	1025	java/io/FileNotFoundException
    //   174	193	1025	java/io/FileNotFoundException
    //   198	221	1025	java/io/FileNotFoundException
    //   224	233	1025	java/io/FileNotFoundException
    //   239	246	1025	java/io/FileNotFoundException
    //   253	274	1025	java/io/FileNotFoundException
    //   286	300	1025	java/io/FileNotFoundException
    //   303	322	1025	java/io/FileNotFoundException
    //   328	348	1025	java/io/FileNotFoundException
    //   351	370	1025	java/io/FileNotFoundException
    //   376	396	1025	java/io/FileNotFoundException
    //   399	431	1025	java/io/FileNotFoundException
    //   434	453	1025	java/io/FileNotFoundException
    //   459	478	1025	java/io/FileNotFoundException
    //   478	485	1025	java/io/FileNotFoundException
    //   513	532	1025	java/io/FileNotFoundException
    //   538	557	1025	java/io/FileNotFoundException
    //   557	563	1025	java/io/FileNotFoundException
    //   38	45	1037	java/io/IOException
    //   50	54	1037	java/io/IOException
    //   95	114	1037	java/io/IOException
    //   120	146	1037	java/io/IOException
    //   149	168	1037	java/io/IOException
    //   174	193	1037	java/io/IOException
    //   198	221	1037	java/io/IOException
    //   224	233	1037	java/io/IOException
    //   239	246	1037	java/io/IOException
    //   253	274	1037	java/io/IOException
    //   286	300	1037	java/io/IOException
    //   303	322	1037	java/io/IOException
    //   328	348	1037	java/io/IOException
    //   351	370	1037	java/io/IOException
    //   376	396	1037	java/io/IOException
    //   399	431	1037	java/io/IOException
    //   434	453	1037	java/io/IOException
    //   459	478	1037	java/io/IOException
    //   478	485	1037	java/io/IOException
    //   513	532	1037	java/io/IOException
    //   538	557	1037	java/io/IOException
    //   557	563	1037	java/io/IOException
    //   38	45	1049	java/lang/NumberFormatException
    //   50	54	1049	java/lang/NumberFormatException
    //   95	114	1049	java/lang/NumberFormatException
    //   120	146	1049	java/lang/NumberFormatException
    //   149	168	1049	java/lang/NumberFormatException
    //   174	193	1049	java/lang/NumberFormatException
    //   198	221	1049	java/lang/NumberFormatException
    //   239	246	1049	java/lang/NumberFormatException
    //   286	300	1049	java/lang/NumberFormatException
    //   303	322	1049	java/lang/NumberFormatException
    //   328	348	1049	java/lang/NumberFormatException
    //   351	370	1049	java/lang/NumberFormatException
    //   376	396	1049	java/lang/NumberFormatException
    //   399	431	1049	java/lang/NumberFormatException
    //   434	453	1049	java/lang/NumberFormatException
    //   459	478	1049	java/lang/NumberFormatException
    //   513	532	1049	java/lang/NumberFormatException
    //   538	557	1049	java/lang/NumberFormatException
    //   224	233	1061	java/lang/NumberFormatException
    //   253	274	1066	java/lang/NumberFormatException
    //   478	485	1071	java/lang/NumberFormatException
    //   557	563	1071	java/lang/NumberFormatException
    //   640	645	1076	java/lang/Exception
    //   653	658	1076	java/lang/Exception
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
    //   14: ldc 31
    //   16: astore 12
    //   18: new 91	java/io/FileReader
    //   21: dup
    //   22: ldc 243
    //   24: invokespecial 96	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   27: astore 6
    //   29: new 98	java/io/BufferedReader
    //   32: dup
    //   33: aload 6
    //   35: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore 7
    //   40: aload 7
    //   42: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore 9
    //   47: aload 12
    //   49: astore 8
    //   51: aload 9
    //   53: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +10 -> 66
    //   59: aload 9
    //   61: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   64: astore 8
    //   66: lload_2
    //   67: lstore_0
    //   68: aload 8
    //   70: ifnull +19 -> 89
    //   73: lload_2
    //   74: lstore_0
    //   75: aload 8
    //   77: invokevirtual 126	java/lang/String:length	()I
    //   80: ifle +9 -> 89
    //   83: aload 8
    //   85: invokestatic 148	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   88: lstore_0
    //   89: lload_0
    //   90: lstore 4
    //   92: aload 7
    //   94: invokevirtual 107	java/io/BufferedReader:close	()V
    //   97: lload_0
    //   98: lstore 4
    //   100: aload 6
    //   102: invokevirtual 108	java/io/FileReader:close	()V
    //   105: lload_0
    //   106: lreturn
    //   107: astore 6
    //   109: aload 6
    //   111: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   114: lload 4
    //   116: lreturn
    //   117: astore 9
    //   119: aload 7
    //   121: astore 8
    //   123: aload 9
    //   125: astore 7
    //   127: goto +22 -> 149
    //   130: goto +60 -> 190
    //   133: goto +85 -> 218
    //   136: goto +110 -> 246
    //   139: astore 7
    //   141: goto +8 -> 149
    //   144: astore 7
    //   146: aconst_null
    //   147: astore 6
    //   149: aload 8
    //   151: ifnull +11 -> 162
    //   154: aload 8
    //   156: invokevirtual 107	java/io/BufferedReader:close	()V
    //   159: goto +3 -> 162
    //   162: aload 6
    //   164: ifnull +16 -> 180
    //   167: aload 6
    //   169: invokevirtual 108	java/io/FileReader:close	()V
    //   172: goto +8 -> 180
    //   175: aload 6
    //   177: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   180: aload 7
    //   182: athrow
    //   183: aconst_null
    //   184: astore 6
    //   186: aload 9
    //   188: astore 7
    //   190: aload 7
    //   192: ifnull +11 -> 203
    //   195: lload_2
    //   196: lstore 4
    //   198: aload 7
    //   200: invokevirtual 107	java/io/BufferedReader:close	()V
    //   203: aload 6
    //   205: ifnull +67 -> 272
    //   208: lload_2
    //   209: lstore 4
    //   211: aload 6
    //   213: invokevirtual 108	java/io/FileReader:close	()V
    //   216: lconst_0
    //   217: lreturn
    //   218: aload 7
    //   220: ifnull +11 -> 231
    //   223: lload_2
    //   224: lstore 4
    //   226: aload 7
    //   228: invokevirtual 107	java/io/BufferedReader:close	()V
    //   231: aload 6
    //   233: ifnull +39 -> 272
    //   236: lload_2
    //   237: lstore 4
    //   239: aload 6
    //   241: invokevirtual 108	java/io/FileReader:close	()V
    //   244: lconst_0
    //   245: lreturn
    //   246: aload 7
    //   248: ifnull +11 -> 259
    //   251: lload_2
    //   252: lstore 4
    //   254: aload 7
    //   256: invokevirtual 107	java/io/BufferedReader:close	()V
    //   259: aload 6
    //   261: ifnull +11 -> 272
    //   264: lload_2
    //   265: lstore 4
    //   267: aload 6
    //   269: invokevirtual 108	java/io/FileReader:close	()V
    //   272: lconst_0
    //   273: lreturn
    //   274: astore 6
    //   276: goto +70 -> 346
    //   279: astore 6
    //   281: goto +55 -> 336
    //   284: astore 6
    //   286: goto -103 -> 183
    //   289: astore 7
    //   291: aload 11
    //   293: astore 7
    //   295: goto -49 -> 246
    //   298: astore 7
    //   300: aload 10
    //   302: astore 7
    //   304: goto -86 -> 218
    //   307: astore 7
    //   309: aload 9
    //   311: astore 7
    //   313: goto -123 -> 190
    //   316: astore 8
    //   318: goto -182 -> 136
    //   321: astore 8
    //   323: goto -190 -> 133
    //   326: astore 8
    //   328: goto -198 -> 130
    //   331: astore 6
    //   333: goto -158 -> 175
    //   336: aconst_null
    //   337: astore 6
    //   339: aload 10
    //   341: astore 7
    //   343: goto -125 -> 218
    //   346: aconst_null
    //   347: astore 6
    //   349: aload 11
    //   351: astore 7
    //   353: goto -107 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	39	0	l1	long
    //   13	252	2	l2	long
    //   90	176	4	l3	long
    //   27	74	6	localFileReader	java.io.FileReader
    //   107	3	6	localException1	Exception
    //   147	121	6	localObject1	Object
    //   274	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   279	1	6	localIOException1	java.io.IOException
    //   284	1	6	localNumberFormatException1	java.lang.NumberFormatException
    //   331	1	6	localException2	Exception
    //   337	11	6	localObject2	Object
    //   38	88	7	localObject3	Object
    //   139	1	7	localObject4	Object
    //   144	37	7	localObject5	Object
    //   188	67	7	localObject6	Object
    //   289	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   293	1	7	localObject7	Object
    //   298	1	7	localIOException2	java.io.IOException
    //   302	1	7	localObject8	Object
    //   307	1	7	localNumberFormatException2	java.lang.NumberFormatException
    //   311	41	7	localObject9	Object
    //   10	145	8	localObject10	Object
    //   316	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   321	1	8	localIOException3	java.io.IOException
    //   326	1	8	localNumberFormatException3	java.lang.NumberFormatException
    //   1	59	9	str1	String
    //   117	193	9	localObject11	Object
    //   4	336	10	localObject12	Object
    //   7	343	11	localObject13	Object
    //   16	32	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   92	97	107	java/lang/Exception
    //   100	105	107	java/lang/Exception
    //   198	203	107	java/lang/Exception
    //   211	216	107	java/lang/Exception
    //   226	231	107	java/lang/Exception
    //   239	244	107	java/lang/Exception
    //   254	259	107	java/lang/Exception
    //   267	272	107	java/lang/Exception
    //   40	47	117	finally
    //   51	66	117	finally
    //   75	89	117	finally
    //   29	40	139	finally
    //   18	29	144	finally
    //   18	29	274	java/io/FileNotFoundException
    //   18	29	279	java/io/IOException
    //   18	29	284	java/lang/NumberFormatException
    //   29	40	289	java/io/FileNotFoundException
    //   29	40	298	java/io/IOException
    //   29	40	307	java/lang/NumberFormatException
    //   40	47	316	java/io/FileNotFoundException
    //   51	66	316	java/io/FileNotFoundException
    //   75	89	316	java/io/FileNotFoundException
    //   40	47	321	java/io/IOException
    //   51	66	321	java/io/IOException
    //   75	89	321	java/io/IOException
    //   40	47	326	java/lang/NumberFormatException
    //   51	66	326	java/lang/NumberFormatException
    //   75	89	326	java/lang/NumberFormatException
    //   154	159	331	java/lang/Exception
    //   167	172	331	java/lang/Exception
  }
  
  public static String getDeviceIdentifier()
  {
    try
    {
      m_Context = ((Application)Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (AVDeviceHelper.getDeviceIdentifier(m_Context).length() != 0) {
      return AVDeviceHelper.getDeviceIdentifier(m_Context);
    }
    return "UNKOWN";
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
  
  public static int getDeviceType()
  {
    return 101;
  }
  
  public static String getIMEI()
  {
    try
    {
      m_Context = ((Application)Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (AVDeviceHelper.doRead(m_Context).length() != 0) {
      return AVDeviceHelper.doRead(m_Context);
    }
    return "UNKOWN";
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
  
  public static String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getOsType()
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
  
  public static String getPackageName()
  {
    try
    {
      m_Context = ((Application)Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject = m_Context;
    String str = "UNKOWN";
    if (localObject == null)
    {
      QLog.e("AVClientInfo", 0, "getPackageName context is null");
      return "UNKOWN";
    }
    int i = Process.myPid();
    localObject = ((ActivityManager)m_Context.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i) {
        str = localRunningAppProcessInfo.processName;
      }
    }
    QLog.e("AVClientInfo", 0, "getPackageName context is not null");
    return str;
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
    //   0: getstatic 185	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   3: iconst_1
    //   4: if_icmpge +8 -> 12
    //   7: bipush 8
    //   9: putstatic 185	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   12: iconst_0
    //   13: istore_0
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 5
    //   20: lconst_0
    //   21: lstore_1
    //   22: iload_0
    //   23: getstatic 185	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   26: if_icmpge +272 -> 298
    //   29: ldc 31
    //   31: astore 8
    //   33: new 212	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   40: astore 7
    //   42: aload 7
    //   44: ldc_w 427
    //   47: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: iload_0
    //   54: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 7
    //   60: ldc_w 429
    //   63: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: new 91	java/io/FileReader
    //   70: dup
    //   71: aload 7
    //   73: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 96	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   79: astore 7
    //   81: new 98	java/io/BufferedReader
    //   84: dup
    //   85: aload 7
    //   87: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   90: astore 6
    //   92: aload 6
    //   94: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   97: astore 9
    //   99: aload 8
    //   101: astore 5
    //   103: aload 9
    //   105: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +10 -> 118
    //   111: aload 9
    //   113: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   116: astore 5
    //   118: lload_1
    //   119: lstore_3
    //   120: aload 5
    //   122: ifnull +19 -> 141
    //   125: lload_1
    //   126: lstore_3
    //   127: aload 5
    //   129: invokevirtual 126	java/lang/String:length	()I
    //   132: ifle +9 -> 141
    //   135: aload 5
    //   137: invokestatic 148	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: lstore_3
    //   141: aload 6
    //   143: invokevirtual 107	java/io/BufferedReader:close	()V
    //   146: aload 7
    //   148: invokevirtual 108	java/io/FileReader:close	()V
    //   151: goto +10 -> 161
    //   154: astore 5
    //   156: aload 5
    //   158: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   161: aload 6
    //   163: astore 5
    //   165: aload 7
    //   167: astore 6
    //   169: lload_3
    //   170: lstore_1
    //   171: goto +112 -> 283
    //   174: astore 8
    //   176: aload 6
    //   178: astore 5
    //   180: aload 8
    //   182: astore 6
    //   184: goto +12 -> 196
    //   187: aload 6
    //   189: astore 5
    //   191: goto +8 -> 199
    //   194: astore 6
    //   196: goto +20 -> 216
    //   199: aload 7
    //   201: astore 6
    //   203: goto +47 -> 250
    //   206: astore 8
    //   208: aload 6
    //   210: astore 7
    //   212: aload 8
    //   214: astore 6
    //   216: aload 5
    //   218: ifnull +11 -> 229
    //   221: aload 5
    //   223: invokevirtual 107	java/io/BufferedReader:close	()V
    //   226: goto +3 -> 229
    //   229: aload 7
    //   231: ifnull +16 -> 247
    //   234: aload 7
    //   236: invokevirtual 108	java/io/FileReader:close	()V
    //   239: goto +8 -> 247
    //   242: aload 5
    //   244: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   247: aload 6
    //   249: athrow
    //   250: aload 5
    //   252: ifnull +11 -> 263
    //   255: aload 5
    //   257: invokevirtual 107	java/io/BufferedReader:close	()V
    //   260: goto +3 -> 263
    //   263: aload 6
    //   265: ifnull +16 -> 281
    //   268: aload 6
    //   270: invokevirtual 108	java/io/FileReader:close	()V
    //   273: goto +8 -> 281
    //   276: aload 7
    //   278: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   281: lconst_0
    //   282: lstore_1
    //   283: lload_1
    //   284: lconst_0
    //   285: lcmp
    //   286: ifle +5 -> 291
    //   289: lload_1
    //   290: lreturn
    //   291: iload_0
    //   292: iconst_1
    //   293: iadd
    //   294: istore_0
    //   295: goto -273 -> 22
    //   298: lload_1
    //   299: lreturn
    //   300: astore 7
    //   302: goto -52 -> 250
    //   305: astore 6
    //   307: goto -108 -> 199
    //   310: astore 5
    //   312: goto -125 -> 187
    //   315: astore 5
    //   317: goto -75 -> 242
    //   320: astore 7
    //   322: goto -46 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	282	0	i	int
    //   21	278	1	l1	long
    //   119	51	3	l2	long
    //   18	118	5	localObject1	Object
    //   154	3	5	localException1	Exception
    //   163	93	5	localObject2	Object
    //   310	1	5	localException2	Exception
    //   315	1	5	localException3	Exception
    //   15	173	6	localObject3	Object
    //   194	1	6	localObject4	Object
    //   201	68	6	localObject5	Object
    //   305	1	6	localException4	Exception
    //   40	237	7	localObject6	Object
    //   300	1	7	localException5	Exception
    //   320	1	7	localException6	Exception
    //   31	69	8	str1	String
    //   174	7	8	localObject7	Object
    //   206	7	8	localObject8	Object
    //   97	15	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   141	151	154	java/lang/Exception
    //   92	99	174	finally
    //   103	118	174	finally
    //   127	141	174	finally
    //   81	92	194	finally
    //   33	81	206	finally
    //   33	81	300	java/lang/Exception
    //   81	92	305	java/lang/Exception
    //   92	99	310	java/lang/Exception
    //   103	118	310	java/lang/Exception
    //   127	141	310	java/lang/Exception
    //   221	226	315	java/lang/Exception
    //   234	239	315	java/lang/Exception
    //   255	260	320	java/lang/Exception
    //   268	273	320	java/lang/Exception
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new AVClientInfo.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 0;
  }
  
  private static void sendBroadcast(String paramString1, String paramString2)
  {
    if (m_Context != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.TMG.floattipsview.ACTION_UPDATE_TIPS");
      localIntent.putExtra(paramString1, paramString2);
      m_Context.sendBroadcast(localIntent);
    }
  }
  
  public int getCameraFacing()
  {
    if (Build.VERSION.SDK_INT > 9) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVClientInfo
 * JD-Core Version:    0.7.0.1
 */