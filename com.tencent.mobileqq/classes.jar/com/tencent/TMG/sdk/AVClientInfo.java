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
  static int mChip;
  static int mCoreNumber;
  static int mCpuArchitecture;
  static String mFeature;
  static String mHardware;
  static boolean mIsMarvell;
  static boolean mIsSupportSharpAudio;
  static boolean mIsSupportSharpVideo;
  static long mMaxCpuFreq;
  static int mOpenGLVersion;
  static String mProcessorName = "";
  static String mVendorId;
  public static Context m_Context;
  static boolean mfReadCpuInfo;
  static long mgMaxCpuFreq = 0L;
  static int mgNumCores;
  
  static
  {
    mFeature = "";
    mVendorId = null;
    mHardware = null;
    mCpuArchitecture = 5;
    mMaxCpuFreq = 0L;
    mCoreNumber = 1;
    mfReadCpuInfo = false;
    mOpenGLVersion = 2;
    mChip = 1;
    mIsSupportSharpAudio = true;
    mIsSupportSharpVideo = true;
    mIsMarvell = false;
    m_Context = null;
    mgNumCores = 0;
  }
  
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
    //   0: getstatic 64	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 11
    //   11: aconst_null
    //   12: astore 10
    //   14: ldc2_w 109
    //   17: lstore 4
    //   19: ldc 111
    //   21: fstore_0
    //   22: new 113	java/io/FileReader
    //   25: dup
    //   26: ldc 115
    //   28: invokespecial 118	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: astore 8
    //   33: new 120	java/io/BufferedReader
    //   36: dup
    //   37: aload 8
    //   39: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore 9
    //   44: aload 9
    //   46: invokevirtual 126	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 10
    //   51: aload 10
    //   53: ifnonnull +93 -> 146
    //   56: iconst_1
    //   57: putstatic 64	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
    //   60: aload 9
    //   62: ifnull +8 -> 70
    //   65: aload 9
    //   67: invokevirtual 129	java/io/BufferedReader:close	()V
    //   70: lload 4
    //   72: lstore 6
    //   74: fload_0
    //   75: fstore_1
    //   76: aload 8
    //   78: ifnull +14 -> 92
    //   81: aload 8
    //   83: invokevirtual 130	java/io/FileReader:close	()V
    //   86: fload_0
    //   87: fstore_1
    //   88: lload 4
    //   90: lstore 6
    //   92: invokestatic 133	com/tencent/TMG/sdk/AVClientInfo:readNumCores	()I
    //   95: istore_2
    //   96: iload_2
    //   97: ifle +720 -> 817
    //   100: iload_2
    //   101: putstatic 62	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   104: invokestatic 137	com/tencent/TMG/sdk/AVClientInfo:readMaxCpuFreq	()J
    //   107: lstore 4
    //   109: lload 4
    //   111: lconst_0
    //   112: lcmp
    //   113: ifle +720 -> 833
    //   116: lload 4
    //   118: putstatic 60	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   121: getstatic 62	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   124: ifle +11 -> 135
    //   127: getstatic 60	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   130: lconst_0
    //   131: lcmp
    //   132: ifgt +766 -> 898
    //   135: iconst_0
    //   136: putstatic 64	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
    //   139: invokestatic 140	com/tencent/TMG/sdk/AVClientInfo:readCpuArchitecture	()I
    //   142: putstatic 68	com/tencent/TMG/sdk/AVClientInfo:mChip	I
    //   145: return
    //   146: aload 10
    //   148: ldc 142
    //   150: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   153: ifeq +97 -> 250
    //   156: aload 10
    //   158: bipush 58
    //   160: invokevirtual 152	java/lang/String:indexOf	(I)I
    //   163: istore_2
    //   164: iload_2
    //   165: iconst_1
    //   166: if_icmple -122 -> 44
    //   169: aload 10
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: aload 10
    //   176: invokevirtual 155	java/lang/String:length	()I
    //   179: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   182: putstatic 50	com/tencent/TMG/sdk/AVClientInfo:mProcessorName	Ljava/lang/String;
    //   185: getstatic 50	com/tencent/TMG/sdk/AVClientInfo:mProcessorName	Ljava/lang/String;
    //   188: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   191: putstatic 50	com/tencent/TMG/sdk/AVClientInfo:mProcessorName	Ljava/lang/String;
    //   194: goto -150 -> 44
    //   197: astore 10
    //   199: aload 9
    //   201: ifnull +8 -> 209
    //   204: aload 9
    //   206: invokevirtual 129	java/io/BufferedReader:close	()V
    //   209: lload 4
    //   211: lstore 6
    //   213: fload_0
    //   214: fstore_1
    //   215: aload 8
    //   217: ifnull -125 -> 92
    //   220: aload 8
    //   222: invokevirtual 130	java/io/FileReader:close	()V
    //   225: lload 4
    //   227: lstore 6
    //   229: fload_0
    //   230: fstore_1
    //   231: goto -139 -> 92
    //   234: astore 8
    //   236: aload 8
    //   238: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   241: lload 4
    //   243: lstore 6
    //   245: fload_0
    //   246: fstore_1
    //   247: goto -155 -> 92
    //   250: aload 10
    //   252: ldc 167
    //   254: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   257: ifeq +191 -> 448
    //   260: aload 10
    //   262: bipush 58
    //   264: invokevirtual 152	java/lang/String:indexOf	(I)I
    //   267: istore_2
    //   268: iload_2
    //   269: iconst_1
    //   270: if_icmple +49 -> 319
    //   273: aload 10
    //   275: iload_2
    //   276: iconst_1
    //   277: iadd
    //   278: aload 10
    //   280: invokevirtual 155	java/lang/String:length	()I
    //   283: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   286: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   289: astore 11
    //   291: aload 11
    //   293: ifnull +26 -> 319
    //   296: aload 11
    //   298: invokevirtual 155	java/lang/String:length	()I
    //   301: ifle +18 -> 319
    //   304: aload 11
    //   306: ldc 169
    //   308: invokevirtual 172	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   311: ifeq +78 -> 389
    //   314: bipush 8
    //   316: putstatic 58	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   319: aload 10
    //   321: ldc 174
    //   323: invokevirtual 178	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: ifeq -282 -> 44
    //   329: iconst_5
    //   330: putstatic 58	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   333: goto -289 -> 44
    //   336: astore 10
    //   338: aload 9
    //   340: ifnull +8 -> 348
    //   343: aload 9
    //   345: invokevirtual 129	java/io/BufferedReader:close	()V
    //   348: lload 4
    //   350: lstore 6
    //   352: fload_0
    //   353: fstore_1
    //   354: aload 8
    //   356: ifnull -264 -> 92
    //   359: aload 8
    //   361: invokevirtual 130	java/io/FileReader:close	()V
    //   364: lload 4
    //   366: lstore 6
    //   368: fload_0
    //   369: fstore_1
    //   370: goto -278 -> 92
    //   373: astore 8
    //   375: aload 8
    //   377: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   380: lload 4
    //   382: lstore 6
    //   384: fload_0
    //   385: fstore_1
    //   386: goto -294 -> 92
    //   389: aload 11
    //   391: invokestatic 184	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   394: l2i
    //   395: putstatic 58	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   398: goto -79 -> 319
    //   401: astore 12
    //   403: iconst_1
    //   404: istore_2
    //   405: aload 11
    //   407: invokevirtual 155	java/lang/String:length	()I
    //   410: istore_3
    //   411: iload_2
    //   412: iload_3
    //   413: if_icmpge -94 -> 319
    //   416: aload 11
    //   418: iconst_0
    //   419: aload 11
    //   421: invokevirtual 155	java/lang/String:length	()I
    //   424: iload_2
    //   425: isub
    //   426: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   429: invokestatic 184	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   432: l2i
    //   433: putstatic 58	com/tencent/TMG/sdk/AVClientInfo:mCpuArchitecture	I
    //   436: goto -117 -> 319
    //   439: astore 12
    //   441: iload_2
    //   442: iconst_1
    //   443: iadd
    //   444: istore_2
    //   445: goto -40 -> 405
    //   448: aload 10
    //   450: ldc 186
    //   452: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   455: ifeq +91 -> 546
    //   458: aload 10
    //   460: bipush 58
    //   462: invokevirtual 152	java/lang/String:indexOf	(I)I
    //   465: istore_2
    //   466: iload_2
    //   467: iconst_1
    //   468: if_icmple -424 -> 44
    //   471: aload 10
    //   473: iload_2
    //   474: iconst_1
    //   475: iadd
    //   476: aload 10
    //   478: invokevirtual 155	java/lang/String:length	()I
    //   481: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   484: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   487: putstatic 52	com/tencent/TMG/sdk/AVClientInfo:mFeature	Ljava/lang/String;
    //   490: goto -446 -> 44
    //   493: astore 10
    //   495: aload 9
    //   497: ifnull +8 -> 505
    //   500: aload 9
    //   502: invokevirtual 129	java/io/BufferedReader:close	()V
    //   505: lload 4
    //   507: lstore 6
    //   509: fload_0
    //   510: fstore_1
    //   511: aload 8
    //   513: ifnull -421 -> 92
    //   516: aload 8
    //   518: invokevirtual 130	java/io/FileReader:close	()V
    //   521: lload 4
    //   523: lstore 6
    //   525: fload_0
    //   526: fstore_1
    //   527: goto -435 -> 92
    //   530: astore 8
    //   532: aload 8
    //   534: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   537: lload 4
    //   539: lstore 6
    //   541: fload_0
    //   542: fstore_1
    //   543: goto -451 -> 92
    //   546: aload 10
    //   548: ldc 188
    //   550: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   553: ifeq +71 -> 624
    //   556: aload 10
    //   558: bipush 58
    //   560: invokevirtual 152	java/lang/String:indexOf	(I)I
    //   563: istore_2
    //   564: iload_2
    //   565: iconst_1
    //   566: if_icmple -522 -> 44
    //   569: aload 10
    //   571: iload_2
    //   572: iconst_1
    //   573: iadd
    //   574: aload 10
    //   576: invokevirtual 155	java/lang/String:length	()I
    //   579: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   582: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   585: putstatic 54	com/tencent/TMG/sdk/AVClientInfo:mVendorId	Ljava/lang/String;
    //   588: goto -544 -> 44
    //   591: astore 11
    //   593: aload 9
    //   595: astore 10
    //   597: aload 11
    //   599: astore 9
    //   601: aload 10
    //   603: ifnull +8 -> 611
    //   606: aload 10
    //   608: invokevirtual 129	java/io/BufferedReader:close	()V
    //   611: aload 8
    //   613: ifnull +8 -> 621
    //   616: aload 8
    //   618: invokevirtual 130	java/io/FileReader:close	()V
    //   621: aload 9
    //   623: athrow
    //   624: aload 10
    //   626: ldc 190
    //   628: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   631: ifeq +28 -> 659
    //   634: aload 10
    //   636: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   639: putstatic 56	com/tencent/TMG/sdk/AVClientInfo:mHardware	Ljava/lang/String;
    //   642: aload 10
    //   644: ldc 192
    //   646: invokevirtual 178	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   649: ifeq -605 -> 44
    //   652: iconst_1
    //   653: putstatic 74	com/tencent/TMG/sdk/AVClientInfo:mIsMarvell	Z
    //   656: goto -612 -> 44
    //   659: aload 10
    //   661: ldc 194
    //   663: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   666: ifeq +67 -> 733
    //   669: aload 10
    //   671: bipush 58
    //   673: invokevirtual 152	java/lang/String:indexOf	(I)I
    //   676: istore_2
    //   677: iload_2
    //   678: iconst_1
    //   679: if_icmple -635 -> 44
    //   682: aload 10
    //   684: iload_2
    //   685: iconst_1
    //   686: iadd
    //   687: aload 10
    //   689: invokevirtual 155	java/lang/String:length	()I
    //   692: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   695: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   698: astore 10
    //   700: aload 10
    //   702: invokestatic 184	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   705: lstore 6
    //   707: lload 6
    //   709: lconst_0
    //   710: lcmp
    //   711: iflt -667 -> 44
    //   714: lconst_1
    //   715: lload 6
    //   717: ladd
    //   718: lload 4
    //   720: lcmp
    //   721: ifle -677 -> 44
    //   724: lconst_1
    //   725: lload 6
    //   727: ladd
    //   728: lstore 4
    //   730: goto -686 -> 44
    //   733: aload 10
    //   735: ldc 196
    //   737: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   740: ifeq -696 -> 44
    //   743: aload 10
    //   745: bipush 58
    //   747: invokevirtual 152	java/lang/String:indexOf	(I)I
    //   750: istore_2
    //   751: iload_2
    //   752: iconst_1
    //   753: if_icmple -709 -> 44
    //   756: aload 10
    //   758: iload_2
    //   759: iconst_1
    //   760: iadd
    //   761: aload 10
    //   763: invokevirtual 155	java/lang/String:length	()I
    //   766: invokevirtual 159	java/lang/String:substring	(II)Ljava/lang/String;
    //   769: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   772: astore 10
    //   774: aload 10
    //   776: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   779: fstore_1
    //   780: fload_1
    //   781: fload_0
    //   782: fcmpl
    //   783: ifle +211 -> 994
    //   786: fload_1
    //   787: fstore_0
    //   788: goto -744 -> 44
    //   791: astore 8
    //   793: aload 8
    //   795: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   798: lload 4
    //   800: lstore 6
    //   802: fload_0
    //   803: fstore_1
    //   804: goto -712 -> 92
    //   807: astore 8
    //   809: aload 8
    //   811: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   814: goto -193 -> 621
    //   817: lload 6
    //   819: lconst_0
    //   820: lcmp
    //   821: ifle -717 -> 104
    //   824: lload 6
    //   826: l2i
    //   827: putstatic 62	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   830: goto -726 -> 104
    //   833: fload_1
    //   834: fconst_0
    //   835: fcmpl
    //   836: ifle -715 -> 121
    //   839: fload_1
    //   840: ldc 203
    //   842: fcmpg
    //   843: ifge +20 -> 863
    //   846: fload_1
    //   847: f2d
    //   848: ldc2_w 204
    //   851: dmul
    //   852: ldc2_w 206
    //   855: dmul
    //   856: d2l
    //   857: putstatic 60	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   860: goto -739 -> 121
    //   863: fload_1
    //   864: ldc 208
    //   866: fcmpl
    //   867: ifle +20 -> 887
    //   870: fload_1
    //   871: f2d
    //   872: ldc2_w 209
    //   875: ddiv
    //   876: ldc2_w 206
    //   879: dmul
    //   880: d2l
    //   881: putstatic 60	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   884: goto -763 -> 121
    //   887: ldc 211
    //   889: fload_1
    //   890: fmul
    //   891: f2l
    //   892: putstatic 60	com/tencent/TMG/sdk/AVClientInfo:mMaxCpuFreq	J
    //   895: goto -774 -> 121
    //   898: iconst_1
    //   899: putstatic 64	com/tencent/TMG/sdk/AVClientInfo:mfReadCpuInfo	Z
    //   902: goto -763 -> 139
    //   905: astore 10
    //   907: goto -863 -> 44
    //   910: astore 10
    //   912: goto -868 -> 44
    //   915: astore 9
    //   917: aconst_null
    //   918: astore 8
    //   920: aconst_null
    //   921: astore 10
    //   923: goto -322 -> 601
    //   926: astore 9
    //   928: aconst_null
    //   929: astore 10
    //   931: goto -330 -> 601
    //   934: astore 8
    //   936: aconst_null
    //   937: astore 8
    //   939: aconst_null
    //   940: astore 9
    //   942: goto -447 -> 495
    //   945: astore 9
    //   947: aconst_null
    //   948: astore 9
    //   950: goto -455 -> 495
    //   953: astore 8
    //   955: aconst_null
    //   956: astore 8
    //   958: aconst_null
    //   959: astore 9
    //   961: goto -623 -> 338
    //   964: astore 9
    //   966: aconst_null
    //   967: astore 9
    //   969: goto -631 -> 338
    //   972: astore 8
    //   974: aload 10
    //   976: astore 9
    //   978: aload 11
    //   980: astore 8
    //   982: goto -783 -> 199
    //   985: astore 9
    //   987: aload 10
    //   989: astore 9
    //   991: goto -792 -> 199
    //   994: goto -206 -> 788
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	782	0	f1	float
    //   75	815	1	f2	float
    //   95	666	2	i	int
    //   410	4	3	j	int
    //   17	782	4	l1	long
    //   72	753	6	l2	long
    //   31	190	8	localFileReader	java.io.FileReader
    //   234	126	8	localException1	Exception
    //   373	144	8	localException2	Exception
    //   530	87	8	localException3	Exception
    //   791	3	8	localException4	Exception
    //   807	3	8	localException5	Exception
    //   918	1	8	localObject1	Object
    //   934	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   937	1	8	localObject2	Object
    //   953	1	8	localIOException1	java.io.IOException
    //   956	1	8	localObject3	Object
    //   972	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   980	1	8	localObject4	Object
    //   42	580	9	localObject5	Object
    //   915	1	9	localObject6	Object
    //   926	1	9	localObject7	Object
    //   940	1	9	localObject8	Object
    //   945	1	9	localNumberFormatException2	java.lang.NumberFormatException
    //   948	12	9	localObject9	Object
    //   964	1	9	localIOException2	java.io.IOException
    //   967	10	9	localObject10	Object
    //   985	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   989	1	9	localObject11	Object
    //   12	163	10	str1	String
    //   197	123	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   336	141	10	localIOException3	java.io.IOException
    //   493	82	10	localNumberFormatException3	java.lang.NumberFormatException
    //   595	180	10	localObject12	Object
    //   905	1	10	localNumberFormatException4	java.lang.NumberFormatException
    //   910	1	10	localNumberFormatException5	java.lang.NumberFormatException
    //   921	67	10	localObject13	Object
    //   9	411	11	str2	String
    //   591	388	11	localObject14	Object
    //   401	1	12	localNumberFormatException6	java.lang.NumberFormatException
    //   439	1	12	localNumberFormatException7	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   44	51	197	java/io/FileNotFoundException
    //   56	60	197	java/io/FileNotFoundException
    //   146	164	197	java/io/FileNotFoundException
    //   169	194	197	java/io/FileNotFoundException
    //   250	268	197	java/io/FileNotFoundException
    //   273	291	197	java/io/FileNotFoundException
    //   296	319	197	java/io/FileNotFoundException
    //   319	333	197	java/io/FileNotFoundException
    //   389	398	197	java/io/FileNotFoundException
    //   405	411	197	java/io/FileNotFoundException
    //   416	436	197	java/io/FileNotFoundException
    //   448	466	197	java/io/FileNotFoundException
    //   471	490	197	java/io/FileNotFoundException
    //   546	564	197	java/io/FileNotFoundException
    //   569	588	197	java/io/FileNotFoundException
    //   624	656	197	java/io/FileNotFoundException
    //   659	677	197	java/io/FileNotFoundException
    //   682	700	197	java/io/FileNotFoundException
    //   700	707	197	java/io/FileNotFoundException
    //   733	751	197	java/io/FileNotFoundException
    //   756	774	197	java/io/FileNotFoundException
    //   774	780	197	java/io/FileNotFoundException
    //   204	209	234	java/lang/Exception
    //   220	225	234	java/lang/Exception
    //   44	51	336	java/io/IOException
    //   56	60	336	java/io/IOException
    //   146	164	336	java/io/IOException
    //   169	194	336	java/io/IOException
    //   250	268	336	java/io/IOException
    //   273	291	336	java/io/IOException
    //   296	319	336	java/io/IOException
    //   319	333	336	java/io/IOException
    //   389	398	336	java/io/IOException
    //   405	411	336	java/io/IOException
    //   416	436	336	java/io/IOException
    //   448	466	336	java/io/IOException
    //   471	490	336	java/io/IOException
    //   546	564	336	java/io/IOException
    //   569	588	336	java/io/IOException
    //   624	656	336	java/io/IOException
    //   659	677	336	java/io/IOException
    //   682	700	336	java/io/IOException
    //   700	707	336	java/io/IOException
    //   733	751	336	java/io/IOException
    //   756	774	336	java/io/IOException
    //   774	780	336	java/io/IOException
    //   343	348	373	java/lang/Exception
    //   359	364	373	java/lang/Exception
    //   389	398	401	java/lang/NumberFormatException
    //   416	436	439	java/lang/NumberFormatException
    //   44	51	493	java/lang/NumberFormatException
    //   56	60	493	java/lang/NumberFormatException
    //   146	164	493	java/lang/NumberFormatException
    //   169	194	493	java/lang/NumberFormatException
    //   250	268	493	java/lang/NumberFormatException
    //   273	291	493	java/lang/NumberFormatException
    //   296	319	493	java/lang/NumberFormatException
    //   319	333	493	java/lang/NumberFormatException
    //   405	411	493	java/lang/NumberFormatException
    //   448	466	493	java/lang/NumberFormatException
    //   471	490	493	java/lang/NumberFormatException
    //   546	564	493	java/lang/NumberFormatException
    //   569	588	493	java/lang/NumberFormatException
    //   624	656	493	java/lang/NumberFormatException
    //   659	677	493	java/lang/NumberFormatException
    //   682	700	493	java/lang/NumberFormatException
    //   733	751	493	java/lang/NumberFormatException
    //   756	774	493	java/lang/NumberFormatException
    //   500	505	530	java/lang/Exception
    //   516	521	530	java/lang/Exception
    //   44	51	591	finally
    //   56	60	591	finally
    //   146	164	591	finally
    //   169	194	591	finally
    //   250	268	591	finally
    //   273	291	591	finally
    //   296	319	591	finally
    //   319	333	591	finally
    //   389	398	591	finally
    //   405	411	591	finally
    //   416	436	591	finally
    //   448	466	591	finally
    //   471	490	591	finally
    //   546	564	591	finally
    //   569	588	591	finally
    //   624	656	591	finally
    //   659	677	591	finally
    //   682	700	591	finally
    //   700	707	591	finally
    //   733	751	591	finally
    //   756	774	591	finally
    //   774	780	591	finally
    //   65	70	791	java/lang/Exception
    //   81	86	791	java/lang/Exception
    //   606	611	807	java/lang/Exception
    //   616	621	807	java/lang/Exception
    //   700	707	905	java/lang/NumberFormatException
    //   774	780	910	java/lang/NumberFormatException
    //   22	33	915	finally
    //   33	44	926	finally
    //   22	33	934	java/lang/NumberFormatException
    //   33	44	945	java/lang/NumberFormatException
    //   22	33	953	java/io/IOException
    //   33	44	964	java/io/IOException
    //   22	33	972	java/io/FileNotFoundException
    //   33	44	985	java/io/FileNotFoundException
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
    //   14: new 113	java/io/FileReader
    //   17: dup
    //   18: ldc 245
    //   20: invokespecial 118	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   23: astore 4
    //   25: new 120	java/io/BufferedReader
    //   28: dup
    //   29: aload 4
    //   31: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore 5
    //   36: lload_2
    //   37: lstore_0
    //   38: aload 5
    //   40: ifnull +48 -> 88
    //   43: aload 5
    //   45: invokevirtual 126	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 6
    //   50: aload 6
    //   52: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +289 -> 344
    //   58: aload 6
    //   60: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   63: astore 6
    //   65: lload_2
    //   66: lstore_0
    //   67: aload 6
    //   69: ifnull +19 -> 88
    //   72: lload_2
    //   73: lstore_0
    //   74: aload 6
    //   76: invokevirtual 155	java/lang/String:length	()I
    //   79: ifle +9 -> 88
    //   82: aload 6
    //   84: invokestatic 184	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   87: lstore_0
    //   88: aload 5
    //   90: ifnull +8 -> 98
    //   93: aload 5
    //   95: invokevirtual 129	java/io/BufferedReader:close	()V
    //   98: lload_0
    //   99: lstore_2
    //   100: aload 4
    //   102: ifnull +10 -> 112
    //   105: aload 4
    //   107: invokevirtual 130	java/io/FileReader:close	()V
    //   110: lload_0
    //   111: lstore_2
    //   112: lload_2
    //   113: lreturn
    //   114: astore 4
    //   116: aload 4
    //   118: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   121: lload_0
    //   122: lreturn
    //   123: astore 4
    //   125: aconst_null
    //   126: astore 6
    //   128: aload 5
    //   130: astore 4
    //   132: aload 6
    //   134: astore 5
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 129	java/io/BufferedReader:close	()V
    //   146: aload 4
    //   148: ifnull -36 -> 112
    //   151: aload 4
    //   153: invokevirtual 130	java/io/FileReader:close	()V
    //   156: lconst_0
    //   157: lreturn
    //   158: astore 4
    //   160: aload 4
    //   162: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   165: lconst_0
    //   166: lreturn
    //   167: astore 4
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 7
    //   174: astore 5
    //   176: aload 5
    //   178: ifnull +8 -> 186
    //   181: aload 5
    //   183: invokevirtual 129	java/io/BufferedReader:close	()V
    //   186: aload 4
    //   188: ifnull -76 -> 112
    //   191: aload 4
    //   193: invokevirtual 130	java/io/FileReader:close	()V
    //   196: lconst_0
    //   197: lreturn
    //   198: astore 4
    //   200: aload 4
    //   202: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   205: lconst_0
    //   206: lreturn
    //   207: astore 4
    //   209: aconst_null
    //   210: astore 4
    //   212: aload 8
    //   214: astore 5
    //   216: aload 5
    //   218: ifnull +8 -> 226
    //   221: aload 5
    //   223: invokevirtual 129	java/io/BufferedReader:close	()V
    //   226: aload 4
    //   228: ifnull -116 -> 112
    //   231: aload 4
    //   233: invokevirtual 130	java/io/FileReader:close	()V
    //   236: lconst_0
    //   237: lreturn
    //   238: astore 4
    //   240: aload 4
    //   242: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   245: lconst_0
    //   246: lreturn
    //   247: astore 5
    //   249: aconst_null
    //   250: astore 4
    //   252: aload 6
    //   254: ifnull +8 -> 262
    //   257: aload 6
    //   259: invokevirtual 129	java/io/BufferedReader:close	()V
    //   262: aload 4
    //   264: ifnull +8 -> 272
    //   267: aload 4
    //   269: invokevirtual 130	java/io/FileReader:close	()V
    //   272: aload 5
    //   274: athrow
    //   275: astore 4
    //   277: aload 4
    //   279: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   282: goto -10 -> 272
    //   285: astore 5
    //   287: goto -35 -> 252
    //   290: astore 7
    //   292: aload 5
    //   294: astore 6
    //   296: aload 7
    //   298: astore 5
    //   300: goto -48 -> 252
    //   303: astore 5
    //   305: aload 8
    //   307: astore 5
    //   309: goto -93 -> 216
    //   312: astore 6
    //   314: goto -98 -> 216
    //   317: astore 5
    //   319: aload 7
    //   321: astore 5
    //   323: goto -147 -> 176
    //   326: astore 6
    //   328: goto -152 -> 176
    //   331: astore 5
    //   333: aconst_null
    //   334: astore 5
    //   336: goto -200 -> 136
    //   339: astore 6
    //   341: goto -205 -> 136
    //   344: ldc 48
    //   346: astore 6
    //   348: goto -283 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	85	0	l1	long
    //   13	100	2	l2	long
    //   23	83	4	localFileReader	java.io.FileReader
    //   114	3	4	localException1	Exception
    //   123	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   130	22	4	localObject1	Object
    //   158	3	4	localException2	Exception
    //   167	1	4	localIOException1	java.io.IOException
    //   170	22	4	localObject2	Object
    //   198	3	4	localException3	Exception
    //   207	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   210	22	4	localObject3	Object
    //   238	3	4	localException4	Exception
    //   250	18	4	localObject4	Object
    //   275	3	4	localException5	Exception
    //   10	212	5	localObject5	Object
    //   247	26	5	localObject6	Object
    //   285	8	5	localObject7	Object
    //   298	1	5	localObject8	Object
    //   303	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   307	1	5	localObject9	Object
    //   317	1	5	localIOException2	java.io.IOException
    //   321	1	5	localObject10	Object
    //   331	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   334	1	5	localObject11	Object
    //   7	288	6	localObject12	Object
    //   312	1	6	localNumberFormatException3	java.lang.NumberFormatException
    //   326	1	6	localIOException3	java.io.IOException
    //   339	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   346	1	6	str	String
    //   1	172	7	localObject13	Object
    //   290	30	7	localObject14	Object
    //   4	302	8	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   93	98	114	java/lang/Exception
    //   105	110	114	java/lang/Exception
    //   14	25	123	java/io/FileNotFoundException
    //   141	146	158	java/lang/Exception
    //   151	156	158	java/lang/Exception
    //   14	25	167	java/io/IOException
    //   181	186	198	java/lang/Exception
    //   191	196	198	java/lang/Exception
    //   14	25	207	java/lang/NumberFormatException
    //   221	226	238	java/lang/Exception
    //   231	236	238	java/lang/Exception
    //   14	25	247	finally
    //   257	262	275	java/lang/Exception
    //   267	272	275	java/lang/Exception
    //   25	36	285	finally
    //   43	65	290	finally
    //   74	88	290	finally
    //   25	36	303	java/lang/NumberFormatException
    //   43	65	312	java/lang/NumberFormatException
    //   74	88	312	java/lang/NumberFormatException
    //   25	36	317	java/io/IOException
    //   43	65	326	java/io/IOException
    //   74	88	326	java/io/IOException
    //   25	36	331	java/io/FileNotFoundException
    //   43	65	339	java/io/FileNotFoundException
    //   74	88	339	java/io/FileNotFoundException
  }
  
  public static String getDeviceIdentifier()
  {
    try
    {
      m_Context = ((Application)Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      if (AVDeviceHelper.getDeviceIdentifier(m_Context).length() != 0) {
        return AVDeviceHelper.getDeviceIdentifier(m_Context);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return "UNKOWN";
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceNameForConfigSystem()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
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
      if (AVDeviceHelper.doRead(m_Context).length() != 0) {
        return AVDeviceHelper.doRead(m_Context);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
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
    return "model(" + Build.MODEL + ") Mnfc(" + Build.MANUFACTURER + ") dev(" + Build.VERSION.INCREMENTAL + ") sdk(" + Build.VERSION.SDK_INT + ") gl(" + mOpenGLVersion + ")";
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
  
  public static String getPackageName()
  {
    String str = "UNKOWN";
    int i;
    Iterator localIterator;
    try
    {
      m_Context = ((Application)Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      if (m_Context == null)
      {
        QLog.e("AVClientInfo", 0, "getPackageName context is null");
        return "UNKOWN";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      i = Process.myPid();
      localIterator = ((ActivityManager)m_Context.getSystemService("activity")).getRunningAppProcesses().iterator();
    }
    if (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.pid != i) {
        break label134;
      }
      str = localRunningAppProcessInfo.processName;
    }
    label134:
    for (;;)
    {
      break;
      QLog.e("AVClientInfo", 0, "getPackageName context is not null");
      return str;
    }
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
    //   1: astore 6
    //   3: getstatic 62	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   6: iconst_1
    //   7: if_icmpge +8 -> 15
    //   10: bipush 8
    //   12: putstatic 62	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   15: iconst_0
    //   16: istore_0
    //   17: aconst_null
    //   18: astore 7
    //   20: lconst_0
    //   21: lstore_1
    //   22: lload_1
    //   23: lstore_3
    //   24: iload_0
    //   25: getstatic 62	com/tencent/TMG/sdk/AVClientInfo:mCoreNumber	I
    //   28: if_icmpge +139 -> 167
    //   31: new 113	java/io/FileReader
    //   34: dup
    //   35: new 214	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 423
    //   45: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_0
    //   49: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc_w 425
    //   55: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 118	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: new 120	java/io/BufferedReader
    //   69: dup
    //   70: aload 5
    //   72: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   75: astore 7
    //   77: lload_1
    //   78: lstore_3
    //   79: aload 7
    //   81: ifnull +48 -> 129
    //   84: aload 7
    //   86: invokevirtual 126	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 6
    //   91: aload 6
    //   93: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifne +226 -> 322
    //   99: aload 6
    //   101: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   104: astore 6
    //   106: lload_1
    //   107: lstore_3
    //   108: aload 6
    //   110: ifnull +19 -> 129
    //   113: lload_1
    //   114: lstore_3
    //   115: aload 6
    //   117: invokevirtual 155	java/lang/String:length	()I
    //   120: ifle +9 -> 129
    //   123: aload 6
    //   125: invokestatic 184	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   128: lstore_3
    //   129: aload 7
    //   131: ifnull +8 -> 139
    //   134: aload 7
    //   136: invokevirtual 129	java/io/BufferedReader:close	()V
    //   139: aload 5
    //   141: ifnull +8 -> 149
    //   144: aload 5
    //   146: invokevirtual 130	java/io/FileReader:close	()V
    //   149: aload 7
    //   151: astore 6
    //   153: lload_3
    //   154: lstore_1
    //   155: aload 5
    //   157: astore 7
    //   159: lload_1
    //   160: lconst_0
    //   161: lcmp
    //   162: ifle +121 -> 283
    //   165: lload_1
    //   166: lstore_3
    //   167: lload_3
    //   168: lreturn
    //   169: astore 6
    //   171: aload 6
    //   173: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   176: aload 7
    //   178: astore 6
    //   180: aload 5
    //   182: astore 7
    //   184: lload_3
    //   185: lstore_1
    //   186: goto -27 -> 159
    //   189: astore 6
    //   191: aload 7
    //   193: astore 6
    //   195: aload 5
    //   197: astore 7
    //   199: aload 6
    //   201: ifnull +8 -> 209
    //   204: aload 6
    //   206: invokevirtual 129	java/io/BufferedReader:close	()V
    //   209: aload 7
    //   211: ifnull +8 -> 219
    //   214: aload 7
    //   216: invokevirtual 130	java/io/FileReader:close	()V
    //   219: lconst_0
    //   220: lstore_1
    //   221: goto -62 -> 159
    //   224: astore 5
    //   226: aload 5
    //   228: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   231: lconst_0
    //   232: lstore_1
    //   233: goto -74 -> 159
    //   236: astore 8
    //   238: aload 7
    //   240: astore 6
    //   242: aload 5
    //   244: astore 7
    //   246: aload 8
    //   248: astore 5
    //   250: aload 6
    //   252: ifnull +8 -> 260
    //   255: aload 6
    //   257: invokevirtual 129	java/io/BufferedReader:close	()V
    //   260: aload 7
    //   262: ifnull +8 -> 270
    //   265: aload 7
    //   267: invokevirtual 130	java/io/FileReader:close	()V
    //   270: aload 5
    //   272: athrow
    //   273: astore 6
    //   275: aload 6
    //   277: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   280: goto -10 -> 270
    //   283: iload_0
    //   284: iconst_1
    //   285: iadd
    //   286: istore_0
    //   287: goto -265 -> 22
    //   290: astore 5
    //   292: goto -42 -> 250
    //   295: astore 8
    //   297: aload 5
    //   299: astore 7
    //   301: aload 8
    //   303: astore 5
    //   305: goto -55 -> 250
    //   308: astore 5
    //   310: goto -111 -> 199
    //   313: astore 7
    //   315: aload 5
    //   317: astore 7
    //   319: goto -120 -> 199
    //   322: ldc 48
    //   324: astore 6
    //   326: goto -220 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	271	0	i	int
    //   21	212	1	l1	long
    //   23	162	3	l2	long
    //   64	132	5	localFileReader	java.io.FileReader
    //   224	19	5	localException1	Exception
    //   248	23	5	localObject1	Object
    //   290	8	5	localObject2	Object
    //   303	1	5	localObject3	Object
    //   308	8	5	localException2	Exception
    //   1	151	6	localObject4	Object
    //   169	3	6	localException3	Exception
    //   178	1	6	localObject5	Object
    //   189	1	6	localException4	Exception
    //   193	63	6	localObject6	Object
    //   273	3	6	localException5	Exception
    //   324	1	6	str	String
    //   18	282	7	localObject7	Object
    //   313	1	7	localException6	Exception
    //   317	1	7	localObject8	Object
    //   236	11	8	localObject9	Object
    //   295	7	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   134	139	169	java/lang/Exception
    //   144	149	169	java/lang/Exception
    //   84	106	189	java/lang/Exception
    //   115	129	189	java/lang/Exception
    //   204	209	224	java/lang/Exception
    //   214	219	224	java/lang/Exception
    //   84	106	236	finally
    //   115	129	236	finally
    //   255	260	273	java/lang/Exception
    //   265	270	273	java/lang/Exception
    //   31	66	290	finally
    //   66	77	295	finally
    //   31	66	308	java/lang/Exception
    //   66	77	313	java/lang/Exception
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new AVClientInfo.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
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
    int i = 1;
    if (Build.VERSION.SDK_INT > 9) {
      i = 2;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVClientInfo
 * JD-Core Version:    0.7.0.1
 */