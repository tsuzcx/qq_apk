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
  public static int mChip;
  public static int mCoreNumber;
  public static int mCpuArchitecture;
  public static String mFeature;
  public static String mHardware;
  public static boolean mHasReadMemInfo;
  public static boolean mIsMarvell;
  public static boolean mIsSupportSharpAudio;
  public static boolean mIsSupportSharpVideo;
  public static long mMaxCpuFreq;
  public static long mMemoryTotal;
  public static int mOpenGLVersion;
  public static String mProcessorName = "";
  public static String mVendorId;
  public static boolean mfReadCpuInfo;
  static long mgMaxCpuFreq = 0L;
  static int mgNumCores;
  private static String strCPUModel;
  public int mDisplayHeight = 240;
  public int mDisplayWidth = 320;
  public int mScreenHeight = 480;
  public int mScreenWidth = 320;
  
  static
  {
    mFeature = "";
    mVendorId = null;
    mHardware = null;
    mCpuArchitecture = 5;
    mMaxCpuFreq = 0L;
    mCoreNumber = 1;
    mfReadCpuInfo = false;
    mMemoryTotal = 0L;
    mHasReadMemInfo = false;
    mOpenGLVersion = 2;
    mChip = 1;
    mIsSupportSharpAudio = true;
    mIsSupportSharpVideo = true;
    mIsMarvell = false;
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
    //   0: getstatic 69	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 9
    //   11: ldc2_w 113
    //   14: lstore 4
    //   16: ldc 115
    //   18: fstore_0
    //   19: new 117	java/lang/StringBuilder
    //   22: dup
    //   23: sipush 1024
    //   26: invokespecial 120	java/lang/StringBuilder:<init>	(I)V
    //   29: astore 10
    //   31: new 122	java/io/BufferedReader
    //   34: dup
    //   35: new 124	java/io/FileReader
    //   38: dup
    //   39: ldc 126
    //   41: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 8
    //   49: aload 8
    //   51: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnonnull +268 -> 326
    //   61: iconst_1
    //   62: putstatic 69	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   65: lload 4
    //   67: lstore 6
    //   69: fload_0
    //   70: fstore_1
    //   71: aload 8
    //   73: ifnull +14 -> 87
    //   76: aload 8
    //   78: invokevirtual 138	java/io/BufferedReader:close	()V
    //   81: fload_0
    //   82: fstore_1
    //   83: lload 4
    //   85: lstore 6
    //   87: invokestatic 141	com/tencent/avcore/data/AVCoreSystemInfo:readNumCores	()I
    //   90: istore_2
    //   91: iload_2
    //   92: ifle +1158 -> 1250
    //   95: iload_2
    //   96: putstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   99: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   102: ifeq +28 -> 130
    //   105: aload 10
    //   107: ldc 149
    //   109: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: getstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   118: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: ldc 158
    //   126: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: invokestatic 162	com/tencent/avcore/data/AVCoreSystemInfo:readMaxCpuFreq	()J
    //   133: lstore 4
    //   135: lload 4
    //   137: lconst_0
    //   138: lcmp
    //   139: ifle +1159 -> 1298
    //   142: lload 4
    //   144: putstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   147: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   150: ifeq +28 -> 178
    //   153: aload 10
    //   155: ldc 164
    //   157: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 10
    //   163: getstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   166: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: ldc 158
    //   174: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: getstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   181: ifle +11 -> 192
    //   184: getstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   187: lconst_0
    //   188: lcmp
    //   189: ifgt +1209 -> 1398
    //   192: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   195: ifeq +45 -> 240
    //   198: aload 10
    //   200: ldc 169
    //   202: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: getstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   211: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 10
    //   217: ldc 171
    //   219: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 10
    //   225: getstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   228: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 10
    //   234: ldc 158
    //   236: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iconst_0
    //   241: putstatic 69	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   244: invokestatic 174	com/tencent/avcore/data/AVCoreSystemInfo:readCpuArchitecture	()I
    //   247: putstatic 77	com/tencent/avcore/data/AVCoreSystemInfo:mChip	I
    //   250: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   253: ifeq -246 -> 7
    //   256: aload 10
    //   258: ldc 176
    //   260: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 10
    //   266: getstatic 77	com/tencent/avcore/data/AVCoreSystemInfo:mChip	I
    //   269: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 10
    //   275: ldc 178
    //   277: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: getstatic 81	com/tencent/avcore/data/AVCoreSystemInfo:mIsSupportSharpVideo	Z
    //   286: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 10
    //   292: ldc 183
    //   294: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 10
    //   300: getstatic 79	com/tencent/avcore/data/AVCoreSystemInfo:mIsSupportSharpAudio	Z
    //   303: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 10
    //   309: ldc 158
    //   311: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 25
    //   317: aload 10
    //   319: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 190	com/tencent/avcore/util/AVCoreLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: return
    //   326: aload 9
    //   328: ldc 192
    //   330: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   333: ifeq +88 -> 421
    //   336: aload 9
    //   338: bipush 58
    //   340: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   343: istore_2
    //   344: iload_2
    //   345: iconst_1
    //   346: if_icmple -297 -> 49
    //   349: aload 9
    //   351: iload_2
    //   352: iconst_1
    //   353: iadd
    //   354: aload 9
    //   356: invokevirtual 205	java/lang/String:length	()I
    //   359: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   362: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   365: ldc 214
    //   367: ldc 53
    //   369: invokevirtual 218	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   372: putstatic 220	com/tencent/avcore/data/AVCoreSystemInfo:strCPUModel	Ljava/lang/String;
    //   375: goto -326 -> 49
    //   378: astore 9
    //   380: lload 4
    //   382: lstore 6
    //   384: fload_0
    //   385: fstore_1
    //   386: aload 8
    //   388: ifnull -301 -> 87
    //   391: aload 8
    //   393: invokevirtual 138	java/io/BufferedReader:close	()V
    //   396: lload 4
    //   398: lstore 6
    //   400: fload_0
    //   401: fstore_1
    //   402: goto -315 -> 87
    //   405: astore 8
    //   407: aload 8
    //   409: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   412: lload 4
    //   414: lstore 6
    //   416: fload_0
    //   417: fstore_1
    //   418: goto -331 -> 87
    //   421: aload 9
    //   423: ldc 225
    //   425: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   428: ifeq +134 -> 562
    //   431: aload 9
    //   433: bipush 58
    //   435: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   438: istore_2
    //   439: iload_2
    //   440: iconst_1
    //   441: if_icmple -392 -> 49
    //   444: aload 9
    //   446: iload_2
    //   447: iconst_1
    //   448: iadd
    //   449: aload 9
    //   451: invokevirtual 205	java/lang/String:length	()I
    //   454: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   457: putstatic 55	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   460: getstatic 55	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   463: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   466: putstatic 55	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   469: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   472: ifeq -423 -> 49
    //   475: aload 10
    //   477: ldc 227
    //   479: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 10
    //   485: getstatic 55	com/tencent/avcore/data/AVCoreSystemInfo:mProcessorName	Ljava/lang/String;
    //   488: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 10
    //   494: ldc 229
    //   496: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 10
    //   502: aload 9
    //   504: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 10
    //   510: ldc 158
    //   512: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: goto -467 -> 49
    //   519: astore 9
    //   521: lload 4
    //   523: lstore 6
    //   525: fload_0
    //   526: fstore_1
    //   527: aload 8
    //   529: ifnull -442 -> 87
    //   532: aload 8
    //   534: invokevirtual 138	java/io/BufferedReader:close	()V
    //   537: lload 4
    //   539: lstore 6
    //   541: fload_0
    //   542: fstore_1
    //   543: goto -456 -> 87
    //   546: astore 8
    //   548: aload 8
    //   550: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   553: lload 4
    //   555: lstore 6
    //   557: fload_0
    //   558: fstore_1
    //   559: goto -472 -> 87
    //   562: aload 9
    //   564: ldc 231
    //   566: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   569: ifeq +228 -> 797
    //   572: aload 9
    //   574: bipush 58
    //   576: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   579: istore_2
    //   580: iload_2
    //   581: iconst_1
    //   582: if_icmple +49 -> 631
    //   585: aload 9
    //   587: iload_2
    //   588: iconst_1
    //   589: iadd
    //   590: aload 9
    //   592: invokevirtual 205	java/lang/String:length	()I
    //   595: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   598: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   601: astore 11
    //   603: aload 11
    //   605: ifnull +26 -> 631
    //   608: aload 11
    //   610: invokevirtual 205	java/lang/String:length	()I
    //   613: ifle +18 -> 631
    //   616: aload 11
    //   618: ldc 233
    //   620: invokevirtual 236	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   623: ifeq +115 -> 738
    //   626: bipush 8
    //   628: putstatic 63	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   631: aload 9
    //   633: ldc 238
    //   635: invokevirtual 242	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   638: ifeq +7 -> 645
    //   641: iconst_5
    //   642: putstatic 63	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   645: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   648: ifeq -599 -> 49
    //   651: aload 10
    //   653: ldc 244
    //   655: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 10
    //   661: getstatic 63	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   664: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 10
    //   670: ldc 229
    //   672: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 10
    //   678: aload 9
    //   680: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 10
    //   686: ldc 158
    //   688: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: goto -643 -> 49
    //   695: astore 9
    //   697: lload 4
    //   699: lstore 6
    //   701: fload_0
    //   702: fstore_1
    //   703: aload 8
    //   705: ifnull -618 -> 87
    //   708: aload 8
    //   710: invokevirtual 138	java/io/BufferedReader:close	()V
    //   713: lload 4
    //   715: lstore 6
    //   717: fload_0
    //   718: fstore_1
    //   719: goto -632 -> 87
    //   722: astore 8
    //   724: aload 8
    //   726: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   729: lload 4
    //   731: lstore 6
    //   733: fload_0
    //   734: fstore_1
    //   735: goto -648 -> 87
    //   738: aload 11
    //   740: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   743: l2i
    //   744: putstatic 63	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   747: goto -116 -> 631
    //   750: astore 12
    //   752: iconst_1
    //   753: istore_2
    //   754: aload 11
    //   756: invokevirtual 205	java/lang/String:length	()I
    //   759: istore_3
    //   760: iload_2
    //   761: iload_3
    //   762: if_icmpge -131 -> 631
    //   765: aload 11
    //   767: iconst_0
    //   768: aload 11
    //   770: invokevirtual 205	java/lang/String:length	()I
    //   773: iload_2
    //   774: isub
    //   775: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   778: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   781: l2i
    //   782: putstatic 63	com/tencent/avcore/data/AVCoreSystemInfo:mCpuArchitecture	I
    //   785: goto -154 -> 631
    //   788: astore 12
    //   790: iload_2
    //   791: iconst_1
    //   792: iadd
    //   793: istore_2
    //   794: goto -40 -> 754
    //   797: aload 9
    //   799: ldc 252
    //   801: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   804: ifeq +108 -> 912
    //   807: aload 9
    //   809: bipush 58
    //   811: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   814: istore_2
    //   815: iload_2
    //   816: iconst_1
    //   817: if_icmple +22 -> 839
    //   820: aload 9
    //   822: iload_2
    //   823: iconst_1
    //   824: iadd
    //   825: aload 9
    //   827: invokevirtual 205	java/lang/String:length	()I
    //   830: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   833: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   836: putstatic 57	com/tencent/avcore/data/AVCoreSystemInfo:mFeature	Ljava/lang/String;
    //   839: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   842: ifeq -793 -> 49
    //   845: aload 10
    //   847: ldc 254
    //   849: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 10
    //   855: getstatic 57	com/tencent/avcore/data/AVCoreSystemInfo:mFeature	Ljava/lang/String;
    //   858: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: aload 10
    //   864: ldc 229
    //   866: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload 10
    //   872: aload 9
    //   874: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 10
    //   880: ldc 158
    //   882: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: goto -837 -> 49
    //   889: astore 10
    //   891: aload 8
    //   893: astore 9
    //   895: aload 10
    //   897: astore 8
    //   899: aload 9
    //   901: ifnull +8 -> 909
    //   904: aload 9
    //   906: invokevirtual 138	java/io/BufferedReader:close	()V
    //   909: aload 8
    //   911: athrow
    //   912: aload 9
    //   914: ldc_w 256
    //   917: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   920: ifeq +86 -> 1006
    //   923: aload 9
    //   925: bipush 58
    //   927: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   930: istore_2
    //   931: iload_2
    //   932: iconst_1
    //   933: if_icmple +22 -> 955
    //   936: aload 9
    //   938: iload_2
    //   939: iconst_1
    //   940: iadd
    //   941: aload 9
    //   943: invokevirtual 205	java/lang/String:length	()I
    //   946: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   949: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   952: putstatic 59	com/tencent/avcore/data/AVCoreSystemInfo:mVendorId	Ljava/lang/String;
    //   955: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   958: ifeq -909 -> 49
    //   961: aload 10
    //   963: ldc_w 258
    //   966: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: aload 10
    //   972: getstatic 59	com/tencent/avcore/data/AVCoreSystemInfo:mVendorId	Ljava/lang/String;
    //   975: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 10
    //   981: ldc 229
    //   983: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: aload 10
    //   989: aload 9
    //   991: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload 10
    //   997: ldc 158
    //   999: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: goto -954 -> 49
    //   1006: aload 9
    //   1008: ldc 192
    //   1010: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1013: ifeq +77 -> 1090
    //   1016: aload 9
    //   1018: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   1021: putstatic 61	com/tencent/avcore/data/AVCoreSystemInfo:mHardware	Ljava/lang/String;
    //   1024: aload 9
    //   1026: ldc_w 260
    //   1029: invokevirtual 242	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1032: ifeq +7 -> 1039
    //   1035: iconst_1
    //   1036: putstatic 83	com/tencent/avcore/data/AVCoreSystemInfo:mIsMarvell	Z
    //   1039: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1042: ifeq -993 -> 49
    //   1045: aload 10
    //   1047: ldc_w 262
    //   1050: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: aload 10
    //   1056: getstatic 83	com/tencent/avcore/data/AVCoreSystemInfo:mIsMarvell	Z
    //   1059: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload 10
    //   1065: ldc 229
    //   1067: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: pop
    //   1071: aload 10
    //   1073: aload 9
    //   1075: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: pop
    //   1079: aload 10
    //   1081: ldc 158
    //   1083: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: goto -1038 -> 49
    //   1090: aload 9
    //   1092: ldc_w 264
    //   1095: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1098: ifeq +67 -> 1165
    //   1101: aload 9
    //   1103: bipush 58
    //   1105: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   1108: istore_2
    //   1109: iload_2
    //   1110: iconst_1
    //   1111: if_icmple -1062 -> 49
    //   1114: aload 9
    //   1116: iload_2
    //   1117: iconst_1
    //   1118: iadd
    //   1119: aload 9
    //   1121: invokevirtual 205	java/lang/String:length	()I
    //   1124: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   1127: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   1130: astore 9
    //   1132: aload 9
    //   1134: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1137: lstore 6
    //   1139: lload 6
    //   1141: lconst_0
    //   1142: lcmp
    //   1143: iflt -1094 -> 49
    //   1146: lconst_1
    //   1147: lload 6
    //   1149: ladd
    //   1150: lload 4
    //   1152: lcmp
    //   1153: ifle -1104 -> 49
    //   1156: lconst_1
    //   1157: lload 6
    //   1159: ladd
    //   1160: lstore 4
    //   1162: goto -1113 -> 49
    //   1165: aload 9
    //   1167: ldc_w 266
    //   1170: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1173: ifeq -1124 -> 49
    //   1176: aload 9
    //   1178: bipush 58
    //   1180: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   1183: istore_2
    //   1184: iload_2
    //   1185: iconst_1
    //   1186: if_icmple -1137 -> 49
    //   1189: aload 9
    //   1191: iload_2
    //   1192: iconst_1
    //   1193: iadd
    //   1194: aload 9
    //   1196: invokevirtual 205	java/lang/String:length	()I
    //   1199: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   1202: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   1205: astore 9
    //   1207: aload 9
    //   1209: invokestatic 272	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1212: fstore_1
    //   1213: fload_1
    //   1214: fload_0
    //   1215: fcmpl
    //   1216: ifle +232 -> 1448
    //   1219: fload_1
    //   1220: fstore_0
    //   1221: goto -1172 -> 49
    //   1224: astore 8
    //   1226: aload 8
    //   1228: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   1231: lload 4
    //   1233: lstore 6
    //   1235: fload_0
    //   1236: fstore_1
    //   1237: goto -1150 -> 87
    //   1240: astore 9
    //   1242: aload 9
    //   1244: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   1247: goto -338 -> 909
    //   1250: lload 6
    //   1252: lconst_0
    //   1253: lcmp
    //   1254: ifle -1124 -> 130
    //   1257: lload 6
    //   1259: l2i
    //   1260: putstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   1263: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1266: ifeq -1136 -> 130
    //   1269: aload 10
    //   1271: ldc_w 274
    //   1274: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 10
    //   1280: getstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   1283: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload 10
    //   1289: ldc 158
    //   1291: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: goto -1165 -> 130
    //   1298: fload_1
    //   1299: fconst_0
    //   1300: fcmpl
    //   1301: ifle -1123 -> 178
    //   1304: fload_1
    //   1305: ldc_w 275
    //   1308: fcmpg
    //   1309: ifge +52 -> 1361
    //   1312: fload_1
    //   1313: f2d
    //   1314: ldc2_w 276
    //   1317: dmul
    //   1318: ldc2_w 278
    //   1321: dmul
    //   1322: d2l
    //   1323: putstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   1326: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   1329: ifeq -1151 -> 178
    //   1332: aload 10
    //   1334: ldc_w 281
    //   1337: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: pop
    //   1341: aload 10
    //   1343: getstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   1346: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1349: pop
    //   1350: aload 10
    //   1352: ldc 158
    //   1354: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: goto -1180 -> 178
    //   1361: fload_1
    //   1362: ldc_w 282
    //   1365: fcmpl
    //   1366: ifle +20 -> 1386
    //   1369: fload_1
    //   1370: f2d
    //   1371: ldc2_w 283
    //   1374: ddiv
    //   1375: ldc2_w 278
    //   1378: dmul
    //   1379: d2l
    //   1380: putstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   1383: goto -57 -> 1326
    //   1386: ldc_w 285
    //   1389: fload_1
    //   1390: fmul
    //   1391: f2l
    //   1392: putstatic 65	com/tencent/avcore/data/AVCoreSystemInfo:mMaxCpuFreq	J
    //   1395: goto -69 -> 1326
    //   1398: iconst_1
    //   1399: putstatic 69	com/tencent/avcore/data/AVCoreSystemInfo:mfReadCpuInfo	Z
    //   1402: goto -1158 -> 244
    //   1405: astore 9
    //   1407: goto -1358 -> 49
    //   1410: astore 9
    //   1412: goto -1363 -> 49
    //   1415: astore 8
    //   1417: aconst_null
    //   1418: astore 9
    //   1420: goto -521 -> 899
    //   1423: astore 8
    //   1425: aconst_null
    //   1426: astore 8
    //   1428: goto -731 -> 697
    //   1431: astore 8
    //   1433: aconst_null
    //   1434: astore 8
    //   1436: goto -915 -> 521
    //   1439: astore 8
    //   1441: aload 9
    //   1443: astore 8
    //   1445: goto -1065 -> 380
    //   1448: goto -227 -> 1221
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1218	0	f1	float
    //   70	1320	1	f2	float
    //   90	1104	2	i	int
    //   759	4	3	j	int
    //   14	1218	4	l1	long
    //   67	1191	6	l2	long
    //   47	345	8	localBufferedReader	java.io.BufferedReader
    //   405	128	8	localIOException1	java.io.IOException
    //   546	163	8	localIOException2	java.io.IOException
    //   722	170	8	localIOException3	java.io.IOException
    //   897	13	8	localObject1	Object
    //   1224	3	8	localIOException4	java.io.IOException
    //   1415	1	8	localObject2	Object
    //   1423	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1426	1	8	localObject3	Object
    //   1431	1	8	localIOException5	java.io.IOException
    //   1434	1	8	localObject4	Object
    //   1439	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1443	1	8	localObject5	Object
    //   9	346	9	str1	String
    //   378	125	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   519	160	9	localIOException6	java.io.IOException
    //   695	178	9	localNumberFormatException2	java.lang.NumberFormatException
    //   893	315	9	localObject6	Object
    //   1240	3	9	localIOException7	java.io.IOException
    //   1405	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   1410	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   1418	24	9	localObject7	Object
    //   29	850	10	localStringBuilder	java.lang.StringBuilder
    //   889	462	10	localObject8	Object
    //   601	168	11	str2	String
    //   750	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   788	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   49	56	378	java/io/FileNotFoundException
    //   61	65	378	java/io/FileNotFoundException
    //   326	344	378	java/io/FileNotFoundException
    //   349	375	378	java/io/FileNotFoundException
    //   421	439	378	java/io/FileNotFoundException
    //   444	516	378	java/io/FileNotFoundException
    //   562	580	378	java/io/FileNotFoundException
    //   585	603	378	java/io/FileNotFoundException
    //   608	631	378	java/io/FileNotFoundException
    //   631	645	378	java/io/FileNotFoundException
    //   645	692	378	java/io/FileNotFoundException
    //   738	747	378	java/io/FileNotFoundException
    //   754	760	378	java/io/FileNotFoundException
    //   765	785	378	java/io/FileNotFoundException
    //   797	815	378	java/io/FileNotFoundException
    //   820	839	378	java/io/FileNotFoundException
    //   839	886	378	java/io/FileNotFoundException
    //   912	931	378	java/io/FileNotFoundException
    //   936	955	378	java/io/FileNotFoundException
    //   955	1003	378	java/io/FileNotFoundException
    //   1006	1039	378	java/io/FileNotFoundException
    //   1039	1087	378	java/io/FileNotFoundException
    //   1090	1109	378	java/io/FileNotFoundException
    //   1114	1132	378	java/io/FileNotFoundException
    //   1132	1139	378	java/io/FileNotFoundException
    //   1165	1184	378	java/io/FileNotFoundException
    //   1189	1207	378	java/io/FileNotFoundException
    //   1207	1213	378	java/io/FileNotFoundException
    //   391	396	405	java/io/IOException
    //   49	56	519	java/io/IOException
    //   61	65	519	java/io/IOException
    //   326	344	519	java/io/IOException
    //   349	375	519	java/io/IOException
    //   421	439	519	java/io/IOException
    //   444	516	519	java/io/IOException
    //   562	580	519	java/io/IOException
    //   585	603	519	java/io/IOException
    //   608	631	519	java/io/IOException
    //   631	645	519	java/io/IOException
    //   645	692	519	java/io/IOException
    //   738	747	519	java/io/IOException
    //   754	760	519	java/io/IOException
    //   765	785	519	java/io/IOException
    //   797	815	519	java/io/IOException
    //   820	839	519	java/io/IOException
    //   839	886	519	java/io/IOException
    //   912	931	519	java/io/IOException
    //   936	955	519	java/io/IOException
    //   955	1003	519	java/io/IOException
    //   1006	1039	519	java/io/IOException
    //   1039	1087	519	java/io/IOException
    //   1090	1109	519	java/io/IOException
    //   1114	1132	519	java/io/IOException
    //   1132	1139	519	java/io/IOException
    //   1165	1184	519	java/io/IOException
    //   1189	1207	519	java/io/IOException
    //   1207	1213	519	java/io/IOException
    //   532	537	546	java/io/IOException
    //   49	56	695	java/lang/NumberFormatException
    //   61	65	695	java/lang/NumberFormatException
    //   326	344	695	java/lang/NumberFormatException
    //   349	375	695	java/lang/NumberFormatException
    //   421	439	695	java/lang/NumberFormatException
    //   444	516	695	java/lang/NumberFormatException
    //   562	580	695	java/lang/NumberFormatException
    //   585	603	695	java/lang/NumberFormatException
    //   608	631	695	java/lang/NumberFormatException
    //   631	645	695	java/lang/NumberFormatException
    //   645	692	695	java/lang/NumberFormatException
    //   754	760	695	java/lang/NumberFormatException
    //   797	815	695	java/lang/NumberFormatException
    //   820	839	695	java/lang/NumberFormatException
    //   839	886	695	java/lang/NumberFormatException
    //   912	931	695	java/lang/NumberFormatException
    //   936	955	695	java/lang/NumberFormatException
    //   955	1003	695	java/lang/NumberFormatException
    //   1006	1039	695	java/lang/NumberFormatException
    //   1039	1087	695	java/lang/NumberFormatException
    //   1090	1109	695	java/lang/NumberFormatException
    //   1114	1132	695	java/lang/NumberFormatException
    //   1165	1184	695	java/lang/NumberFormatException
    //   1189	1207	695	java/lang/NumberFormatException
    //   708	713	722	java/io/IOException
    //   738	747	750	java/lang/NumberFormatException
    //   765	785	788	java/lang/NumberFormatException
    //   49	56	889	finally
    //   61	65	889	finally
    //   326	344	889	finally
    //   349	375	889	finally
    //   421	439	889	finally
    //   444	516	889	finally
    //   562	580	889	finally
    //   585	603	889	finally
    //   608	631	889	finally
    //   631	645	889	finally
    //   645	692	889	finally
    //   738	747	889	finally
    //   754	760	889	finally
    //   765	785	889	finally
    //   797	815	889	finally
    //   820	839	889	finally
    //   839	886	889	finally
    //   912	931	889	finally
    //   936	955	889	finally
    //   955	1003	889	finally
    //   1006	1039	889	finally
    //   1039	1087	889	finally
    //   1090	1109	889	finally
    //   1114	1132	889	finally
    //   1132	1139	889	finally
    //   1165	1184	889	finally
    //   1189	1207	889	finally
    //   1207	1213	889	finally
    //   76	81	1224	java/io/IOException
    //   904	909	1240	java/io/IOException
    //   1132	1139	1405	java/lang/NumberFormatException
    //   1207	1213	1410	java/lang/NumberFormatException
    //   31	49	1415	finally
    //   31	49	1423	java/lang/NumberFormatException
    //   31	49	1431	java/io/IOException
    //   31	49	1439	java/io/FileNotFoundException
  }
  
  public static String getCpuModel()
  {
    getCpuInfo();
    return strCPUModel;
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
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 5
    //   11: new 122	java/io/BufferedReader
    //   14: dup
    //   15: new 124	java/io/FileReader
    //   18: dup
    //   19: ldc_w 305
    //   22: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore 4
    //   30: lload_2
    //   31: lstore_0
    //   32: aload 4
    //   34: ifnull +48 -> 82
    //   37: aload 4
    //   39: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload 5
    //   46: invokestatic 310	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +195 -> 244
    //   52: aload 5
    //   54: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   57: astore 5
    //   59: lload_2
    //   60: lstore_0
    //   61: aload 5
    //   63: ifnull +19 -> 82
    //   66: lload_2
    //   67: lstore_0
    //   68: aload 5
    //   70: invokevirtual 205	java/lang/String:length	()I
    //   73: ifle +9 -> 82
    //   76: aload 5
    //   78: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore_0
    //   82: lload_0
    //   83: lstore_2
    //   84: aload 4
    //   86: ifnull +10 -> 96
    //   89: aload 4
    //   91: invokevirtual 138	java/io/BufferedReader:close	()V
    //   94: lload_0
    //   95: lstore_2
    //   96: lload_2
    //   97: lreturn
    //   98: astore 4
    //   100: aload 4
    //   102: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   105: lload_0
    //   106: lreturn
    //   107: astore 4
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 4
    //   114: ifnull -18 -> 96
    //   117: aload 4
    //   119: invokevirtual 138	java/io/BufferedReader:close	()V
    //   122: lconst_0
    //   123: lreturn
    //   124: astore 4
    //   126: aload 4
    //   128: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   131: lconst_0
    //   132: lreturn
    //   133: astore 4
    //   135: aload 5
    //   137: astore 4
    //   139: aload 4
    //   141: ifnull -45 -> 96
    //   144: aload 4
    //   146: invokevirtual 138	java/io/BufferedReader:close	()V
    //   149: lconst_0
    //   150: lreturn
    //   151: astore 4
    //   153: aload 4
    //   155: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   158: lconst_0
    //   159: lreturn
    //   160: astore 4
    //   162: aload 6
    //   164: astore 4
    //   166: aload 4
    //   168: ifnull -72 -> 96
    //   171: aload 4
    //   173: invokevirtual 138	java/io/BufferedReader:close	()V
    //   176: lconst_0
    //   177: lreturn
    //   178: astore 4
    //   180: aload 4
    //   182: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   185: lconst_0
    //   186: lreturn
    //   187: astore 4
    //   189: aload 7
    //   191: astore 5
    //   193: aload 5
    //   195: ifnull +8 -> 203
    //   198: aload 5
    //   200: invokevirtual 138	java/io/BufferedReader:close	()V
    //   203: aload 4
    //   205: athrow
    //   206: astore 5
    //   208: aload 5
    //   210: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   213: goto -10 -> 203
    //   216: astore 6
    //   218: aload 4
    //   220: astore 5
    //   222: aload 6
    //   224: astore 4
    //   226: goto -33 -> 193
    //   229: astore 5
    //   231: goto -65 -> 166
    //   234: astore 5
    //   236: goto -97 -> 139
    //   239: astore 5
    //   241: goto -129 -> 112
    //   244: ldc 53
    //   246: astore 5
    //   248: goto -189 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	75	0	l1	long
    //   1	96	2	l2	long
    //   28	62	4	localBufferedReader	java.io.BufferedReader
    //   98	3	4	localIOException1	java.io.IOException
    //   107	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   110	8	4	localObject1	Object
    //   124	3	4	localIOException2	java.io.IOException
    //   133	1	4	localIOException3	java.io.IOException
    //   137	8	4	localObject2	Object
    //   151	3	4	localIOException4	java.io.IOException
    //   160	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   164	8	4	localObject3	Object
    //   178	3	4	localIOException5	java.io.IOException
    //   187	32	4	localObject4	Object
    //   224	1	4	localObject5	Object
    //   9	190	5	localObject6	Object
    //   206	3	5	localIOException6	java.io.IOException
    //   220	1	5	localObject7	Object
    //   229	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   234	1	5	localIOException7	java.io.IOException
    //   239	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   246	1	5	str	String
    //   3	160	6	localObject8	Object
    //   216	7	6	localObject9	Object
    //   6	184	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   89	94	98	java/io/IOException
    //   11	30	107	java/io/FileNotFoundException
    //   117	122	124	java/io/IOException
    //   11	30	133	java/io/IOException
    //   144	149	151	java/io/IOException
    //   11	30	160	java/lang/NumberFormatException
    //   171	176	178	java/io/IOException
    //   11	30	187	finally
    //   198	203	206	java/io/IOException
    //   37	59	216	finally
    //   68	82	216	finally
    //   37	59	229	java/lang/NumberFormatException
    //   68	82	229	java/lang/NumberFormatException
    //   37	59	234	java/io/IOException
    //   68	82	234	java/io/IOException
    //   37	59	239	java/io/FileNotFoundException
    //   68	82	239	java/io/FileNotFoundException
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceNameForConfigSystem()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
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
    
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("AVCoreSystemInfo", "getMaxCpuFreq: " + Build.BRAND + "|" + Build.MODEL + "|" + mMaxCpuFreq);
    }
    return mMaxCpuFreq;
  }
  
  /* Error */
  public static long getMemoryTotal()
  {
    // Byte code:
    //   0: getstatic 73	com/tencent/avcore/data/AVCoreSystemInfo:mHasReadMemInfo	Z
    //   3: ifeq +7 -> 10
    //   6: getstatic 71	com/tencent/avcore/data/AVCoreSystemInfo:mMemoryTotal	J
    //   9: lreturn
    //   10: aconst_null
    //   11: astore_2
    //   12: new 122	java/io/BufferedReader
    //   15: dup
    //   16: new 124	java/io/FileReader
    //   19: dup
    //   20: ldc_w 337
    //   23: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_3
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnonnull +21 -> 61
    //   43: aload_3
    //   44: astore_2
    //   45: iconst_1
    //   46: putstatic 73	com/tencent/avcore/data/AVCoreSystemInfo:mHasReadMemInfo	Z
    //   49: aload_3
    //   50: ifnull +7 -> 57
    //   53: aload_3
    //   54: invokevirtual 138	java/io/BufferedReader:close	()V
    //   57: getstatic 71	com/tencent/avcore/data/AVCoreSystemInfo:mMemoryTotal	J
    //   60: lreturn
    //   61: aload_3
    //   62: astore_2
    //   63: aload 4
    //   65: ldc_w 339
    //   68: invokevirtual 198	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq -41 -> 30
    //   74: aload_3
    //   75: astore_2
    //   76: aload 4
    //   78: bipush 58
    //   80: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   83: istore_0
    //   84: iload_0
    //   85: iconst_1
    //   86: if_icmple -43 -> 43
    //   89: aload_3
    //   90: astore_2
    //   91: aload 4
    //   93: iload_0
    //   94: iconst_1
    //   95: iadd
    //   96: aload 4
    //   98: invokevirtual 205	java/lang/String:length	()I
    //   101: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   104: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   107: astore 5
    //   109: iconst_0
    //   110: istore_0
    //   111: aload_3
    //   112: astore_2
    //   113: iload_0
    //   114: aload 4
    //   116: invokevirtual 205	java/lang/String:length	()I
    //   119: if_icmpge +161 -> 280
    //   122: iload_0
    //   123: istore_1
    //   124: aload_3
    //   125: astore_2
    //   126: aload 5
    //   128: iload_0
    //   129: invokevirtual 343	java/lang/String:charAt	(I)C
    //   132: bipush 48
    //   134: if_icmplt +18 -> 152
    //   137: aload_3
    //   138: astore_2
    //   139: aload 5
    //   141: iload_0
    //   142: invokevirtual 343	java/lang/String:charAt	(I)C
    //   145: bipush 57
    //   147: if_icmple +77 -> 224
    //   150: iload_0
    //   151: istore_1
    //   152: aload_3
    //   153: astore_2
    //   154: aload 5
    //   156: iconst_0
    //   157: iload_1
    //   158: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   161: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   164: astore 4
    //   166: aload 4
    //   168: ifnull -125 -> 43
    //   171: aload_3
    //   172: astore_2
    //   173: aload 4
    //   175: invokevirtual 205	java/lang/String:length	()I
    //   178: ifle -135 -> 43
    //   181: aload_3
    //   182: astore_2
    //   183: aload 4
    //   185: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   188: putstatic 71	com/tencent/avcore/data/AVCoreSystemInfo:mMemoryTotal	J
    //   191: goto -148 -> 43
    //   194: astore_2
    //   195: aload_3
    //   196: astore_2
    //   197: ldc 25
    //   199: ldc_w 345
    //   202: invokestatic 348	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_3
    //   206: ifnull -149 -> 57
    //   209: aload_3
    //   210: invokevirtual 138	java/io/BufferedReader:close	()V
    //   213: goto -156 -> 57
    //   216: astore_2
    //   217: aload_2
    //   218: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   221: goto -164 -> 57
    //   224: iload_0
    //   225: iconst_1
    //   226: iadd
    //   227: istore_0
    //   228: goto -117 -> 111
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   236: goto -179 -> 57
    //   239: astore 4
    //   241: aload_2
    //   242: astore_3
    //   243: aload 4
    //   245: astore_2
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 138	java/io/BufferedReader:close	()V
    //   254: aload_2
    //   255: athrow
    //   256: astore_3
    //   257: aload_3
    //   258: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   261: goto -7 -> 254
    //   264: astore 4
    //   266: aload_2
    //   267: astore_3
    //   268: aload 4
    //   270: astore_2
    //   271: goto -25 -> 246
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_3
    //   277: goto -82 -> 195
    //   280: iconst_0
    //   281: istore_1
    //   282: goto -130 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   83	145	0	i	int
    //   123	159	1	j	int
    //   11	172	2	localObject1	Object
    //   194	1	2	localException1	Exception
    //   196	1	2	localObject2	Object
    //   216	2	2	localIOException1	java.io.IOException
    //   231	11	2	localIOException2	java.io.IOException
    //   245	26	2	localObject3	Object
    //   274	1	2	localException2	Exception
    //   29	222	3	localObject4	Object
    //   256	2	3	localIOException3	java.io.IOException
    //   267	10	3	localObject5	Object
    //   36	148	4	str1	String
    //   239	5	4	localObject6	Object
    //   264	5	4	localObject7	Object
    //   107	48	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   32	38	194	java/lang/Exception
    //   45	49	194	java/lang/Exception
    //   63	74	194	java/lang/Exception
    //   76	84	194	java/lang/Exception
    //   91	109	194	java/lang/Exception
    //   113	122	194	java/lang/Exception
    //   126	137	194	java/lang/Exception
    //   139	150	194	java/lang/Exception
    //   154	166	194	java/lang/Exception
    //   173	181	194	java/lang/Exception
    //   183	191	194	java/lang/Exception
    //   209	213	216	java/io/IOException
    //   53	57	231	java/io/IOException
    //   12	30	239	finally
    //   250	254	256	java/io/IOException
    //   32	38	264	finally
    //   45	49	264	finally
    //   63	74	264	finally
    //   76	84	264	finally
    //   91	109	264	finally
    //   113	122	264	finally
    //   126	137	264	finally
    //   139	150	264	finally
    //   154	166	264	finally
    //   173	181	264	finally
    //   183	191	264	finally
    //   197	205	264	finally
    //   12	30	274	java/lang/Exception
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
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   5: iconst_1
    //   6: if_icmpge +22 -> 28
    //   9: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 25
    //   17: ldc_w 420
    //   20: invokestatic 190	com/tencent/avcore/util/AVCoreLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: bipush 8
    //   25: putstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   28: iconst_0
    //   29: istore_2
    //   30: lconst_0
    //   31: lstore 5
    //   33: lconst_0
    //   34: lstore_3
    //   35: iload_1
    //   36: getstatic 67	com/tencent/avcore/data/AVCoreSystemInfo:mCoreNumber	I
    //   39: if_icmpge +318 -> 357
    //   42: aconst_null
    //   43: astore 12
    //   45: new 122	java/io/BufferedReader
    //   48: dup
    //   49: new 124	java/io/FileReader
    //   52: dup
    //   53: new 117	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 422
    //   63: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 424
    //   73: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 11
    //   87: lload_3
    //   88: lstore 7
    //   90: aload 11
    //   92: ifnull +51 -> 143
    //   95: aload 11
    //   97: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   100: astore 12
    //   102: aload 12
    //   104: invokestatic 310	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +338 -> 445
    //   110: aload 12
    //   112: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   115: astore 12
    //   117: lload_3
    //   118: lstore 7
    //   120: aload 12
    //   122: ifnull +21 -> 143
    //   125: lload_3
    //   126: lstore 7
    //   128: aload 12
    //   130: invokevirtual 205	java/lang/String:length	()I
    //   133: ifle +10 -> 143
    //   136: aload 12
    //   138: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   141: lstore 7
    //   143: iload_2
    //   144: istore_0
    //   145: lload 7
    //   147: lstore_3
    //   148: aload 11
    //   150: ifnull +13 -> 163
    //   153: aload 11
    //   155: invokevirtual 138	java/io/BufferedReader:close	()V
    //   158: lload 7
    //   160: lstore_3
    //   161: iload_2
    //   162: istore_0
    //   163: lload 5
    //   165: lstore 7
    //   167: lload_3
    //   168: lload 5
    //   170: lcmp
    //   171: ifle +6 -> 177
    //   174: lload_3
    //   175: lstore 7
    //   177: invokestatic 147	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   180: ifeq +49 -> 229
    //   183: ldc 25
    //   185: new 117	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 426
    //   195: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_1
    //   199: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc_w 428
    //   205: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: lload_3
    //   209: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 430
    //   215: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: lload 7
    //   220: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 190	com/tencent/avcore/util/AVCoreLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iload_1
    //   230: iconst_1
    //   231: iadd
    //   232: istore_1
    //   233: iload_0
    //   234: istore_2
    //   235: lload 7
    //   237: lstore 5
    //   239: goto -204 -> 35
    //   242: astore 11
    //   244: aload 11
    //   246: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   249: iload_2
    //   250: istore_0
    //   251: lload 7
    //   253: lstore_3
    //   254: goto -91 -> 163
    //   257: astore 12
    //   259: aconst_null
    //   260: astore 11
    //   262: ldc 25
    //   264: new 117	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 432
    //   274: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload_1
    //   278: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc_w 434
    //   284: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 12
    //   289: invokevirtual 435	java/lang/Exception:toString	()Ljava/lang/String;
    //   292: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 348	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 11
    //   303: ifnull +8 -> 311
    //   306: aload 11
    //   308: invokevirtual 138	java/io/BufferedReader:close	()V
    //   311: iconst_1
    //   312: istore_0
    //   313: lconst_0
    //   314: lstore_3
    //   315: goto -152 -> 163
    //   318: astore 11
    //   320: aload 11
    //   322: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   325: iconst_1
    //   326: istore_0
    //   327: lconst_0
    //   328: lstore_3
    //   329: goto -166 -> 163
    //   332: astore 11
    //   334: aload 12
    //   336: ifnull +8 -> 344
    //   339: aload 12
    //   341: invokevirtual 138	java/io/BufferedReader:close	()V
    //   344: aload 11
    //   346: athrow
    //   347: astore 12
    //   349: aload 12
    //   351: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   354: goto -10 -> 344
    //   357: lload 5
    //   359: lstore 7
    //   361: iload_2
    //   362: ifeq +23 -> 385
    //   365: invokestatic 438	com/tencent/avcore/data/AVCoreSystemInfo:readMaxCpuFreqFromState	()J
    //   368: lstore 9
    //   370: lload 5
    //   372: lstore 7
    //   374: lload 9
    //   376: lload_3
    //   377: lcmp
    //   378: ifle +7 -> 385
    //   381: lload 9
    //   383: lstore 7
    //   385: ldc 25
    //   387: new 117	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 440
    //   397: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: lload 7
    //   402: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 443	com/tencent/avcore/util/AVCoreLog:printAllUserLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: lload 7
    //   413: lreturn
    //   414: astore 13
    //   416: aload 11
    //   418: astore 12
    //   420: aload 13
    //   422: astore 11
    //   424: goto -90 -> 334
    //   427: astore 13
    //   429: aload 11
    //   431: astore 12
    //   433: aload 13
    //   435: astore 11
    //   437: goto -103 -> 334
    //   440: astore 12
    //   442: goto -180 -> 262
    //   445: ldc 53
    //   447: astore 12
    //   449: goto -332 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   144	183	0	i	int
    //   1	277	1	j	int
    //   29	333	2	k	int
    //   34	343	3	l1	long
    //   31	340	5	l2	long
    //   88	324	7	l3	long
    //   368	14	9	l4	long
    //   85	69	11	localBufferedReader	java.io.BufferedReader
    //   242	3	11	localIOException1	java.io.IOException
    //   260	47	11	localObject1	Object
    //   318	3	11	localIOException2	java.io.IOException
    //   332	85	11	localObject2	Object
    //   422	14	11	localObject3	Object
    //   43	94	12	str1	String
    //   257	83	12	localException1	Exception
    //   347	3	12	localIOException3	java.io.IOException
    //   418	14	12	localObject4	Object
    //   440	1	12	localException2	Exception
    //   447	1	12	str2	String
    //   414	7	13	localObject5	Object
    //   427	7	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   153	158	242	java/io/IOException
    //   45	87	257	java/lang/Exception
    //   306	311	318	java/io/IOException
    //   45	87	332	finally
    //   339	344	347	java/io/IOException
    //   95	117	414	finally
    //   128	143	414	finally
    //   262	301	427	finally
    //   95	117	440	java/lang/Exception
    //   128	143	440	java/lang/Exception
  }
  
  /* Error */
  static long readMaxCpuFreqFromState()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: new 122	java/io/BufferedReader
    //   8: dup
    //   9: new 124	java/io/FileReader
    //   12: dup
    //   13: ldc_w 445
    //   16: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 9
    //   24: lload_3
    //   25: lstore_1
    //   26: aload 9
    //   28: ifnull +92 -> 120
    //   31: aload 9
    //   33: astore 7
    //   35: aload 9
    //   37: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnull +262 -> 306
    //   47: aload 9
    //   49: astore 7
    //   51: aload 9
    //   53: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 11
    //   58: aload 8
    //   60: astore 10
    //   62: aload 11
    //   64: astore 8
    //   66: goto -24 -> 42
    //   69: lload_3
    //   70: lstore_1
    //   71: iload_0
    //   72: iconst_m1
    //   73: if_icmpeq +47 -> 120
    //   76: aload 9
    //   78: astore 7
    //   80: aload 10
    //   82: iconst_0
    //   83: iload_0
    //   84: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   87: astore 8
    //   89: lload_3
    //   90: lstore_1
    //   91: aload 8
    //   93: ifnull +27 -> 120
    //   96: lload_3
    //   97: lstore_1
    //   98: aload 9
    //   100: astore 7
    //   102: aload 8
    //   104: invokevirtual 205	java/lang/String:length	()I
    //   107: ifle +13 -> 120
    //   110: aload 9
    //   112: astore 7
    //   114: aload 8
    //   116: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore_1
    //   120: lload_1
    //   121: lstore 5
    //   123: aload 9
    //   125: ifnull +11 -> 136
    //   128: aload 9
    //   130: invokevirtual 138	java/io/BufferedReader:close	()V
    //   133: lload_1
    //   134: lstore 5
    //   136: ldc 25
    //   138: new 117	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 447
    //   148: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 5
    //   153: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 443	com/tencent/avcore/util/AVCoreLog:printAllUserLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: lload 5
    //   164: lreturn
    //   165: aload 9
    //   167: astore 7
    //   169: aload 10
    //   171: bipush 9
    //   173: invokevirtual 202	java/lang/String:indexOf	(I)I
    //   176: istore_0
    //   177: goto -108 -> 69
    //   180: astore 7
    //   182: aload 7
    //   184: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   187: lload_1
    //   188: lstore 5
    //   190: goto -54 -> 136
    //   193: astore 10
    //   195: aconst_null
    //   196: astore 8
    //   198: aload 8
    //   200: astore 7
    //   202: ldc 25
    //   204: new 117	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 449
    //   214: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 10
    //   219: invokevirtual 435	java/lang/Exception:toString	()Ljava/lang/String;
    //   222: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 454	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   231: pop
    //   232: lload_3
    //   233: lstore 5
    //   235: aload 8
    //   237: ifnull -101 -> 136
    //   240: aload 8
    //   242: invokevirtual 138	java/io/BufferedReader:close	()V
    //   245: lload_3
    //   246: lstore 5
    //   248: goto -112 -> 136
    //   251: astore 7
    //   253: aload 7
    //   255: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   258: lload_3
    //   259: lstore 5
    //   261: goto -125 -> 136
    //   264: astore 8
    //   266: aconst_null
    //   267: astore 7
    //   269: aload 7
    //   271: ifnull +8 -> 279
    //   274: aload 7
    //   276: invokevirtual 138	java/io/BufferedReader:close	()V
    //   279: aload 8
    //   281: athrow
    //   282: astore 7
    //   284: aload 7
    //   286: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   289: goto -10 -> 279
    //   292: astore 8
    //   294: goto -25 -> 269
    //   297: astore 10
    //   299: aload 9
    //   301: astore 8
    //   303: goto -105 -> 198
    //   306: aload 10
    //   308: ifnonnull -143 -> 165
    //   311: iconst_m1
    //   312: istore_0
    //   313: goto -244 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	242	0	i	int
    //   25	163	1	l1	long
    //   1	258	3	l2	long
    //   121	139	5	l3	long
    //   33	135	7	localBufferedReader1	java.io.BufferedReader
    //   180	3	7	localIOException1	java.io.IOException
    //   200	1	7	localObject1	Object
    //   251	3	7	localIOException2	java.io.IOException
    //   267	8	7	localObject2	Object
    //   282	3	7	localIOException3	java.io.IOException
    //   40	201	8	localObject3	Object
    //   264	16	8	localObject4	Object
    //   292	1	8	localObject5	Object
    //   301	1	8	localBufferedReader2	java.io.BufferedReader
    //   22	278	9	localBufferedReader3	java.io.BufferedReader
    //   3	167	10	localObject6	Object
    //   193	25	10	localException1	Exception
    //   297	10	10	localException2	Exception
    //   56	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   128	133	180	java/io/IOException
    //   5	24	193	java/lang/Exception
    //   240	245	251	java/io/IOException
    //   5	24	264	finally
    //   274	279	282	java/io/IOException
    //   35	42	292	finally
    //   51	58	292	finally
    //   80	89	292	finally
    //   102	110	292	finally
    //   114	120	292	finally
    //   169	177	292	finally
    //   202	232	292	finally
    //   35	42	297	java/lang/Exception
    //   51	58	297	java/lang/Exception
    //   80	89	297	java/lang/Exception
    //   102	110	297	java/lang/Exception
    //   114	120	297	java/lang/Exception
    //   169	177	297	java/lang/Exception
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new AVCoreSystemInfo.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getCameraFacing()
  {
    return 2;
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
    this.mDisplayWidth = paramInt1;
    this.mDisplayHeight = paramInt2;
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.data.AVCoreSystemInfo
 * JD-Core Version:    0.7.0.1
 */