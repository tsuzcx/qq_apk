package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.config.ByteBuffer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;

public class DynamicUtils
{
  /* Error */
  private static int a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 23	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: new 25	com/tencent/richmedia/videocompress/VideoConverterConfig
    //   8: dup
    //   9: invokespecial 26	com/tencent/richmedia/videocompress/VideoConverterConfig:<init>	()V
    //   12: astore 9
    //   14: aload 9
    //   16: iload_3
    //   17: putfield 30	com/tencent/richmedia/videocompress/VideoConverterConfig:destWidth	I
    //   20: aload 9
    //   22: iload_3
    //   23: putfield 33	com/tencent/richmedia/videocompress/VideoConverterConfig:destHeight	I
    //   26: aload 9
    //   28: ldc 35
    //   30: putfield 39	com/tencent/richmedia/videocompress/VideoConverterConfig:rotate	Ljava/lang/String;
    //   33: aload 9
    //   35: iload 4
    //   37: putfield 42	com/tencent/richmedia/videocompress/VideoConverterConfig:destQmax	I
    //   40: aload_1
    //   41: aload_2
    //   42: aload 9
    //   44: invokestatic 45	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/richmedia/videocompress/VideoConverterConfig;)[Ljava/lang/String;
    //   47: astore 10
    //   49: aload 10
    //   51: ifnonnull +8 -> 59
    //   54: ldc 47
    //   56: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 56	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   63: astore_0
    //   64: invokestatic 62	com/tencent/mobileqq/shortvideo/VideoEnvironment:getShortVideoSoLibName	()Ljava/lang/String;
    //   67: astore 11
    //   69: new 64	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc 67
    //   80: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: ldc 73
    //   93: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_1
    //   98: aload 11
    //   100: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_1
    //   105: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   111: aconst_null
    //   112: astore_1
    //   113: aconst_null
    //   114: astore 13
    //   116: aconst_null
    //   117: astore 9
    //   119: aconst_null
    //   120: astore 12
    //   122: iconst_0
    //   123: istore_3
    //   124: new 78	java/lang/ProcessBuilder
    //   127: dup
    //   128: iconst_0
    //   129: anewarray 80	java/lang/String
    //   132: invokespecial 83	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   135: astore 14
    //   137: aload 14
    //   139: iconst_1
    //   140: invokevirtual 87	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   143: pop
    //   144: new 89	java/util/ArrayList
    //   147: dup
    //   148: invokespecial 90	java/util/ArrayList:<init>	()V
    //   151: astore 15
    //   153: new 64	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   160: astore 16
    //   162: aload 16
    //   164: aload_0
    //   165: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 16
    //   171: ldc 92
    //   173: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 15
    //   179: aload 16
    //   181: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokeinterface 98 2 0
    //   189: pop
    //   190: new 64	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   197: astore 16
    //   199: aload 16
    //   201: ldc 100
    //   203: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 16
    //   209: aload 15
    //   211: iconst_0
    //   212: invokeinterface 104 2 0
    //   217: checkcast 80	java/lang/String
    //   220: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 16
    //   226: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   232: aload 10
    //   234: arraylength
    //   235: istore 4
    //   237: iload_3
    //   238: iload 4
    //   240: if_icmpge +22 -> 262
    //   243: aload 15
    //   245: aload 10
    //   247: iload_3
    //   248: aaload
    //   249: invokeinterface 98 2 0
    //   254: pop
    //   255: iload_3
    //   256: iconst_1
    //   257: iadd
    //   258: istore_3
    //   259: goto -22 -> 237
    //   262: new 64	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   269: astore 10
    //   271: aload 10
    //   273: aload_0
    //   274: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 10
    //   280: aload 11
    //   282: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 15
    //   288: aload 10
    //   290: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokeinterface 98 2 0
    //   298: pop
    //   299: aload 14
    //   301: aload 15
    //   303: invokevirtual 108	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   306: pop
    //   307: new 64	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   314: astore_0
    //   315: aload_0
    //   316: ldc 110
    //   318: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_0
    //   323: aload 15
    //   325: aload 15
    //   327: invokeinterface 114 1 0
    //   332: iconst_1
    //   333: isub
    //   334: invokeinterface 104 2 0
    //   339: checkcast 80	java/lang/String
    //   342: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_0
    //   347: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   353: aload 14
    //   355: invokevirtual 118	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   358: astore 10
    //   360: aload 10
    //   362: invokevirtual 124	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   365: astore_0
    //   366: new 126	java/io/InputStreamReader
    //   369: dup
    //   370: aload_0
    //   371: invokespecial 129	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   374: astore_1
    //   375: new 131	java/io/BufferedReader
    //   378: dup
    //   379: aload_1
    //   380: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   383: astore 9
    //   385: aload 10
    //   387: invokevirtual 137	java/lang/Process:waitFor	()I
    //   390: pop
    //   391: aload 10
    //   393: invokevirtual 140	java/lang/Process:exitValue	()I
    //   396: istore_3
    //   397: new 64	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   404: astore 11
    //   406: aload 11
    //   408: ldc 142
    //   410: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 11
    //   416: iload_3
    //   417: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 11
    //   423: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   429: aload 9
    //   431: invokevirtual 148	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   434: astore 11
    //   436: aload 11
    //   438: ifnull +39 -> 477
    //   441: new 64	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   448: astore 12
    //   450: aload 12
    //   452: ldc 150
    //   454: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 12
    //   460: aload 11
    //   462: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 12
    //   468: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   474: goto -45 -> 429
    //   477: aload 10
    //   479: invokevirtual 153	java/lang/Process:destroy	()V
    //   482: ldc 155
    //   484: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   487: aload_0
    //   488: ifnull +7 -> 495
    //   491: aload_0
    //   492: invokevirtual 160	java/io/InputStream:close	()V
    //   495: aload_1
    //   496: invokevirtual 161	java/io/InputStreamReader:close	()V
    //   499: aload 9
    //   501: invokevirtual 162	java/io/BufferedReader:close	()V
    //   504: goto +596 -> 1100
    //   507: astore_2
    //   508: goto +55 -> 563
    //   511: astore 11
    //   513: goto +70 -> 583
    //   516: astore 11
    //   518: goto +89 -> 607
    //   521: astore 11
    //   523: goto +108 -> 631
    //   526: astore_2
    //   527: aconst_null
    //   528: astore 9
    //   530: goto +33 -> 563
    //   533: astore 11
    //   535: aconst_null
    //   536: astore 9
    //   538: goto +45 -> 583
    //   541: astore 11
    //   543: aconst_null
    //   544: astore 9
    //   546: goto +61 -> 607
    //   549: astore 11
    //   551: aconst_null
    //   552: astore 9
    //   554: goto +77 -> 631
    //   557: astore_2
    //   558: aconst_null
    //   559: astore_1
    //   560: aload_1
    //   561: astore 9
    //   563: aload_0
    //   564: astore 10
    //   566: aload 9
    //   568: astore_0
    //   569: aload 10
    //   571: astore 9
    //   573: goto +633 -> 1206
    //   576: astore 11
    //   578: aconst_null
    //   579: astore_1
    //   580: aload_1
    //   581: astore 9
    //   583: aload 9
    //   585: astore 10
    //   587: aload 11
    //   589: astore 13
    //   591: aload_1
    //   592: astore 11
    //   594: aload_0
    //   595: astore 12
    //   597: goto +68 -> 665
    //   600: astore 11
    //   602: aconst_null
    //   603: astore_1
    //   604: aload_1
    //   605: astore 9
    //   607: aload 9
    //   609: astore 10
    //   611: aload 11
    //   613: astore 13
    //   615: aload_1
    //   616: astore 11
    //   618: aload_0
    //   619: astore 12
    //   621: goto +198 -> 819
    //   624: astore 11
    //   626: aconst_null
    //   627: astore_1
    //   628: aload_1
    //   629: astore 9
    //   631: aload 9
    //   633: astore 10
    //   635: aload 11
    //   637: astore 13
    //   639: aload_1
    //   640: astore 11
    //   642: aload_0
    //   643: astore 12
    //   645: goto +322 -> 967
    //   648: astore_2
    //   649: aconst_null
    //   650: astore_1
    //   651: aload_1
    //   652: astore_0
    //   653: goto +553 -> 1206
    //   656: astore 13
    //   658: aconst_null
    //   659: astore 11
    //   661: aload 11
    //   663: astore 10
    //   665: sipush -1003
    //   668: istore 4
    //   670: aload 10
    //   672: astore_0
    //   673: aload 11
    //   675: astore_1
    //   676: aload 12
    //   678: astore 9
    //   680: aload 13
    //   682: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   685: aload 10
    //   687: astore_0
    //   688: aload 11
    //   690: astore_1
    //   691: aload 12
    //   693: astore 9
    //   695: new 64	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   702: astore 14
    //   704: aload 10
    //   706: astore_0
    //   707: aload 11
    //   709: astore_1
    //   710: aload 12
    //   712: astore 9
    //   714: aload 14
    //   716: ldc 167
    //   718: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload 10
    //   724: astore_0
    //   725: aload 11
    //   727: astore_1
    //   728: aload 12
    //   730: astore 9
    //   732: aload 14
    //   734: aload 13
    //   736: invokevirtual 168	java/lang/Exception:toString	()Ljava/lang/String;
    //   739: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload 10
    //   745: astore_0
    //   746: aload 11
    //   748: astore_1
    //   749: aload 12
    //   751: astore 9
    //   753: aload 14
    //   755: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   761: aload 12
    //   763: ifnull +14 -> 777
    //   766: iload 4
    //   768: istore_3
    //   769: aload 12
    //   771: invokevirtual 160	java/io/InputStream:close	()V
    //   774: goto +3 -> 777
    //   777: aload 11
    //   779: ifnull +479 -> 1258
    //   782: iload 4
    //   784: istore_3
    //   785: aload 11
    //   787: invokevirtual 161	java/io/InputStreamReader:close	()V
    //   790: goto +468 -> 1258
    //   793: iload 4
    //   795: istore_3
    //   796: aload 10
    //   798: invokevirtual 162	java/io/BufferedReader:close	()V
    //   801: iload 4
    //   803: istore_3
    //   804: goto +296 -> 1100
    //   807: astore 13
    //   809: aconst_null
    //   810: astore 11
    //   812: aload 11
    //   814: astore 10
    //   816: aload_1
    //   817: astore 12
    //   819: sipush -1002
    //   822: istore 4
    //   824: aload 10
    //   826: astore_0
    //   827: aload 11
    //   829: astore_1
    //   830: aload 12
    //   832: astore 9
    //   834: aload 13
    //   836: invokevirtual 169	java/lang/InterruptedException:printStackTrace	()V
    //   839: aload 10
    //   841: astore_0
    //   842: aload 11
    //   844: astore_1
    //   845: aload 12
    //   847: astore 9
    //   849: new 64	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   856: astore 14
    //   858: aload 10
    //   860: astore_0
    //   861: aload 11
    //   863: astore_1
    //   864: aload 12
    //   866: astore 9
    //   868: aload 14
    //   870: ldc 171
    //   872: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: aload 10
    //   878: astore_0
    //   879: aload 11
    //   881: astore_1
    //   882: aload 12
    //   884: astore 9
    //   886: aload 14
    //   888: aload 13
    //   890: invokevirtual 172	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   893: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 10
    //   899: astore_0
    //   900: aload 11
    //   902: astore_1
    //   903: aload 12
    //   905: astore 9
    //   907: aload 14
    //   909: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   915: aload 12
    //   917: ifnull +11 -> 928
    //   920: iload 4
    //   922: istore_3
    //   923: aload 12
    //   925: invokevirtual 160	java/io/InputStream:close	()V
    //   928: aload 11
    //   930: ifnull +11 -> 941
    //   933: iload 4
    //   935: istore_3
    //   936: aload 11
    //   938: invokevirtual 161	java/io/InputStreamReader:close	()V
    //   941: iload 4
    //   943: istore_3
    //   944: aload 10
    //   946: ifnull +154 -> 1100
    //   949: goto -156 -> 793
    //   952: astore_0
    //   953: aconst_null
    //   954: astore 11
    //   956: aload 11
    //   958: astore 10
    //   960: aload 13
    //   962: astore 12
    //   964: aload_0
    //   965: astore 13
    //   967: sipush -1001
    //   970: istore 4
    //   972: aload 10
    //   974: astore_0
    //   975: aload 11
    //   977: astore_1
    //   978: aload 12
    //   980: astore 9
    //   982: aload 13
    //   984: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   987: aload 10
    //   989: astore_0
    //   990: aload 11
    //   992: astore_1
    //   993: aload 12
    //   995: astore 9
    //   997: new 64	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1004: astore 14
    //   1006: aload 10
    //   1008: astore_0
    //   1009: aload 11
    //   1011: astore_1
    //   1012: aload 12
    //   1014: astore 9
    //   1016: aload 14
    //   1018: ldc 175
    //   1020: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload 10
    //   1026: astore_0
    //   1027: aload 11
    //   1029: astore_1
    //   1030: aload 12
    //   1032: astore 9
    //   1034: aload 14
    //   1036: aload 13
    //   1038: invokevirtual 176	java/io/IOException:toString	()Ljava/lang/String;
    //   1041: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload 10
    //   1047: astore_0
    //   1048: aload 11
    //   1050: astore_1
    //   1051: aload 12
    //   1053: astore 9
    //   1055: aload 14
    //   1057: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   1063: aload 12
    //   1065: ifnull +11 -> 1076
    //   1068: iload 4
    //   1070: istore_3
    //   1071: aload 12
    //   1073: invokevirtual 160	java/io/InputStream:close	()V
    //   1076: aload 11
    //   1078: ifnull +11 -> 1089
    //   1081: iload 4
    //   1083: istore_3
    //   1084: aload 11
    //   1086: invokevirtual 161	java/io/InputStreamReader:close	()V
    //   1089: iload 4
    //   1091: istore_3
    //   1092: aload 10
    //   1094: ifnull +6 -> 1100
    //   1097: goto -304 -> 793
    //   1100: invokestatic 23	java/lang/System:currentTimeMillis	()J
    //   1103: lstore 7
    //   1105: new 64	java/lang/StringBuilder
    //   1108: dup
    //   1109: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1112: astore_0
    //   1113: aload_0
    //   1114: ldc 178
    //   1116: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload_0
    //   1121: lload 7
    //   1123: lload 5
    //   1125: lsub
    //   1126: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: aload_0
    //   1131: ldc 183
    //   1133: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: pop
    //   1137: aload_0
    //   1138: iload_3
    //   1139: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload_0
    //   1144: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   1150: iload_3
    //   1151: ifeq +52 -> 1203
    //   1154: new 185	java/io/File
    //   1157: dup
    //   1158: aload_2
    //   1159: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   1162: astore_0
    //   1163: aload_0
    //   1164: invokevirtual 191	java/io/File:exists	()Z
    //   1167: ifeq +36 -> 1203
    //   1170: aload_0
    //   1171: invokevirtual 194	java/io/File:delete	()Z
    //   1174: pop
    //   1175: new 64	java/lang/StringBuilder
    //   1178: dup
    //   1179: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1182: astore_0
    //   1183: aload_0
    //   1184: ldc 196
    //   1186: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: aload_0
    //   1191: iload_3
    //   1192: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: aload_0
    //   1197: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1200: invokestatic 50	com/tencent/mobileqq/avatar/dynamicavatar/DynamicUtils:a	(Ljava/lang/String;)V
    //   1203: iload_3
    //   1204: ireturn
    //   1205: astore_2
    //   1206: aload 9
    //   1208: ifnull +8 -> 1216
    //   1211: aload 9
    //   1213: invokevirtual 160	java/io/InputStream:close	()V
    //   1216: aload_1
    //   1217: ifnull +7 -> 1224
    //   1220: aload_1
    //   1221: invokevirtual 161	java/io/InputStreamReader:close	()V
    //   1224: aload_0
    //   1225: ifnull +7 -> 1232
    //   1228: aload_0
    //   1229: invokevirtual 162	java/io/BufferedReader:close	()V
    //   1232: goto +5 -> 1237
    //   1235: aload_2
    //   1236: athrow
    //   1237: goto -2 -> 1235
    //   1240: astore_0
    //   1241: goto -737 -> 504
    //   1244: astore_0
    //   1245: goto +10 -> 1255
    //   1248: astore_0
    //   1249: iload_3
    //   1250: ireturn
    //   1251: astore_0
    //   1252: goto -20 -> 1232
    //   1255: goto -155 -> 1100
    //   1258: iload 4
    //   1260: istore_3
    //   1261: aload 10
    //   1263: ifnull -163 -> 1100
    //   1266: goto -473 -> 793
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1269	0	paramContext	Context
    //   0	1269	1	paramString1	String
    //   0	1269	2	paramString2	String
    //   0	1269	3	paramInt1	int
    //   0	1269	4	paramInt2	int
    //   3	1121	5	l1	long
    //   1103	19	7	l2	long
    //   12	1200	9	localObject1	Object
    //   47	1215	10	localObject2	Object
    //   67	394	11	localObject3	Object
    //   511	1	11	localException1	java.lang.Exception
    //   516	1	11	localInterruptedException1	java.lang.InterruptedException
    //   521	1	11	localIOException1	java.io.IOException
    //   533	1	11	localException2	java.lang.Exception
    //   541	1	11	localInterruptedException2	java.lang.InterruptedException
    //   549	1	11	localIOException2	java.io.IOException
    //   576	12	11	localException3	java.lang.Exception
    //   592	1	11	str1	String
    //   600	12	11	localInterruptedException3	java.lang.InterruptedException
    //   616	1	11	str2	String
    //   624	12	11	localIOException3	java.io.IOException
    //   640	445	11	str3	String
    //   120	952	12	localObject4	Object
    //   114	524	13	localObject5	Object
    //   656	79	13	localException4	java.lang.Exception
    //   807	154	13	localInterruptedException4	java.lang.InterruptedException
    //   965	72	13	localContext	Context
    //   135	921	14	localObject6	Object
    //   151	175	15	localArrayList	java.util.ArrayList
    //   160	65	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   385	429	507	finally
    //   429	436	507	finally
    //   441	474	507	finally
    //   477	487	507	finally
    //   385	429	511	java/lang/Exception
    //   429	436	511	java/lang/Exception
    //   441	474	511	java/lang/Exception
    //   477	487	511	java/lang/Exception
    //   385	429	516	java/lang/InterruptedException
    //   429	436	516	java/lang/InterruptedException
    //   441	474	516	java/lang/InterruptedException
    //   477	487	516	java/lang/InterruptedException
    //   385	429	521	java/io/IOException
    //   429	436	521	java/io/IOException
    //   441	474	521	java/io/IOException
    //   477	487	521	java/io/IOException
    //   375	385	526	finally
    //   375	385	533	java/lang/Exception
    //   375	385	541	java/lang/InterruptedException
    //   375	385	549	java/io/IOException
    //   366	375	557	finally
    //   366	375	576	java/lang/Exception
    //   366	375	600	java/lang/InterruptedException
    //   366	375	624	java/io/IOException
    //   124	237	648	finally
    //   243	255	648	finally
    //   262	366	648	finally
    //   124	237	656	java/lang/Exception
    //   243	255	656	java/lang/Exception
    //   262	366	656	java/lang/Exception
    //   124	237	807	java/lang/InterruptedException
    //   243	255	807	java/lang/InterruptedException
    //   262	366	807	java/lang/InterruptedException
    //   124	237	952	java/io/IOException
    //   243	255	952	java/io/IOException
    //   262	366	952	java/io/IOException
    //   680	685	1205	finally
    //   695	704	1205	finally
    //   714	722	1205	finally
    //   732	743	1205	finally
    //   753	761	1205	finally
    //   834	839	1205	finally
    //   849	858	1205	finally
    //   868	876	1205	finally
    //   886	897	1205	finally
    //   907	915	1205	finally
    //   982	987	1205	finally
    //   997	1006	1205	finally
    //   1016	1024	1205	finally
    //   1034	1045	1205	finally
    //   1055	1063	1205	finally
    //   491	495	1240	java/io/IOException
    //   495	504	1240	java/io/IOException
    //   769	774	1244	java/io/IOException
    //   785	790	1244	java/io/IOException
    //   796	801	1244	java/io/IOException
    //   923	928	1244	java/io/IOException
    //   936	941	1244	java/io/IOException
    //   1071	1076	1244	java/io/IOException
    //   1084	1089	1244	java/io/IOException
    //   1154	1203	1248	java/lang/Exception
    //   1211	1216	1251	java/io/IOException
    //   1220	1224	1251	java/io/IOException
    //   1228	1232	1251	java/io/IOException
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    return a(paramString1, paramString2, paramInt, paramContext, 25);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt1, Context paramContext, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    if (ShortVideoTrimmer.initVideoTrim(paramContext))
    {
      VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(paramString1);
      localVideoConverterConfig.destWidth = paramInt1;
      localVideoConverterConfig.destHeight = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.i("DynamicUtils", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
      }
      paramInt2 = a(paramContext, paramString1, paramString2, paramInt1, paramInt2);
      long l2 = System.currentTimeMillis();
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        long l3 = new File(paramString1).length();
        long l4 = new File(paramString2).length();
        paramInt1 = paramInt2;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("CompressTask，step: ShortVideoTrimmer compress ret = ");
          paramString1.append(paramInt2);
          paramString1.append(", cost:");
          paramString1.append(l2 - l1);
          paramString1.append("ms, fileSourceSize=");
          paramString1.append(l3);
          paramString1.append(", fileTargetSize=");
          paramString1.append(l4);
          QLog.i("DynamicUtils", 2, paramString1.toString());
          return paramInt2;
        }
      }
    }
    else
    {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap2;
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
      }
      localBitmap2 = null;
    }
    if (localBitmap2 != null)
    {
      Paint localPaint = new Paint(7);
      localBitmap2.eraseColor(0);
      Canvas localCanvas = new Canvas(localBitmap2);
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setColor(Color.parseColor("#38000000"));
      localCanvas.drawRect(localRect, localPaint);
      localPaint.setColor(0);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      localCanvas.drawCircle(paramInt1 * 0.5F, paramInt2 * 0.5F, paramInt3, localPaint);
    }
    return localBitmap2;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Object localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      try
      {
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        Paint localPaint = new Paint(6);
        localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt1, paramInt2), localPaint);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        paramBitmap = (Bitmap)localObject;
        localObject = localOutOfMemoryError2;
      }
      if (!QLog.isColorLevel()) {
        return paramBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      paramBitmap = null;
    }
    QLog.i("qqBaseActivity", 2, localOutOfMemoryError1.getMessage(), localOutOfMemoryError1);
    return paramBitmap;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = new File(paramString);
      if (((File)localObject1).exists())
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((File)localObject1).getParent());
        ((StringBuilder)localObject2).append("/dynamicAvatar_");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        ((StringBuilder)localObject2).append(".mp4");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          return localObject1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDynamicAvatarCompressPath: sourcePath=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("/n compressPath=");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.i("DynamicUtils", 2, ((StringBuilder)localObject1).toString());
        return localObject2;
      }
    }
    Object localObject1 = null;
    return localObject1;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    ThreadManager.post(new DynamicUtils.1(paramAppInterface, paramString, paramInt), 2, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = 48;
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = paramInt1;
    paramString = new ByteBuffer();
    paramString.a(paramInt2);
    paramString.a(paramInt3);
    localTransferRequest.mExtentionInfo = paramString.a();
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicUtils", 2, paramString);
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 > 0L)
    {
      if (paramLong2 <= 0L) {
        return false;
      }
      Calendar localCalendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
      localCalendar1.setTimeInMillis(paramLong1);
      Calendar localCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
      localCalendar2.setTimeInMillis(paramLong2);
      return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
    }
    return false;
  }
  
  private static String[] a(String paramString1, String paramString2, VideoConverterConfig paramVideoConverterConfig)
  {
    String str;
    if (ShortVideoTrimmer.getCpuCores() >= 2) {
      str = "2";
    } else {
      str = "1";
    }
    Object localObject = new StringBuilder(String.valueOf(paramVideoConverterConfig.destWidth));
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(String.valueOf(paramVideoConverterConfig.destHeight));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[@] generateCommand threads=");
    localStringBuilder.append(str);
    localStringBuilder.append("  resolution=");
    localStringBuilder.append((String)localObject);
    a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("rotate=");
    localStringBuilder.append(paramVideoConverterConfig.rotate);
    return new String[] { "-d", "-y", "-threads", str, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", localStringBuilder.toString(), "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramVideoConverterConfig.destQmax), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", localObject, "-movflags", "faststart", paramString2 };
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    AppIntefaceReportWrap.a(paramAppInterface, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils
 * JD-Core Version:    0.7.0.1
 */