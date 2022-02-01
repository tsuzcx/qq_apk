package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.shortvideo.util.AudioResample;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class SegmentClipUtils
{
  private static boolean a(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    if (!c(paramInt1, paramInt2, paramMAudioData1, paramMAudioData2)) {
      return b(paramInt1, paramInt2, paramMAudioData1, paramMAudioData2);
    }
    return true;
  }
  
  /* Error */
  private static boolean a(SlideItemInfo paramSlideItemInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifgt +14 -> 20
    //   9: aload_0
    //   10: getfield 29	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifgt +5 -> 20
    //   18: iconst_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 29	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   24: aload_0
    //   25: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   28: lcmp
    //   29: ifge +5 -> 34
    //   32: iconst_1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 29	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   38: aload_0
    //   39: getfield 31	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   42: lcmp
    //   43: ifle +11 -> 54
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 31	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   51: putfield 29	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   54: aload_0
    //   55: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   58: lconst_0
    //   59: lcmp
    //   60: ifgt +8 -> 68
    //   63: aload_0
    //   64: lconst_0
    //   65: putfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   68: aload_0
    //   69: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   72: lconst_0
    //   73: lcmp
    //   74: ifne +26 -> 100
    //   77: aload_0
    //   78: getfield 29	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   81: aload_0
    //   82: getfield 31	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   85: lcmp
    //   86: ifne +14 -> 100
    //   89: aload_0
    //   90: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   93: ldc 35
    //   95: if_icmpne +5 -> 100
    //   98: iconst_1
    //   99: ireturn
    //   100: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +59 -> 162
    //   106: new 43	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   113: astore 16
    //   115: aload 16
    //   117: ldc 46
    //   119: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 16
    //   125: aload_0
    //   126: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   129: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 16
    //   135: ldc 55
    //   137: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 16
    //   143: aload_0
    //   144: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   147: invokevirtual 61	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 63
    //   153: iconst_2
    //   154: aload 16
    //   156: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   166: ifne +9 -> 175
    //   169: aload_0
    //   170: ldc 35
    //   172: putfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   175: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +59 -> 237
    //   181: new 43	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   188: astore 16
    //   190: aload 16
    //   192: ldc 73
    //   194: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 16
    //   200: aload_0
    //   201: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   204: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 16
    //   210: ldc 55
    //   212: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 16
    //   218: aload_0
    //   219: getfield 58	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   222: invokevirtual 61	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: ldc 63
    //   228: iconst_2
    //   229: aload 16
    //   231: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_0
    //   238: getfield 27	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   241: l2f
    //   242: fconst_1
    //   243: fmul
    //   244: aload_0
    //   245: getfield 31	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   248: l2f
    //   249: fdiv
    //   250: fstore_1
    //   251: aload_0
    //   252: getfield 29	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   255: l2f
    //   256: fconst_1
    //   257: fmul
    //   258: aload_0
    //   259: getfield 31	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   262: l2f
    //   263: fdiv
    //   264: fstore_2
    //   265: new 43	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   272: astore 16
    //   274: aload 16
    //   276: aload_0
    //   277: getfield 77	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   280: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 16
    //   286: ldc 79
    //   288: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 16
    //   294: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: astore 18
    //   299: aload 18
    //   301: invokestatic 84	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   304: ifeq +9 -> 313
    //   307: aload 18
    //   309: invokestatic 86	com/tencent/mobileqq/filemanager/util/FileUtil:c	(Ljava/lang/String;)Z
    //   312: pop
    //   313: new 88	java/io/File
    //   316: dup
    //   317: aload_0
    //   318: getfield 77	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   321: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   324: astore 17
    //   326: aload 17
    //   328: invokevirtual 95	java/io/File:length	()J
    //   331: lstore 10
    //   333: lload 10
    //   335: ldc2_w 96
    //   338: lrem
    //   339: lconst_0
    //   340: lcmp
    //   341: ifeq +45 -> 386
    //   344: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +39 -> 386
    //   350: new 43	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   357: astore 16
    //   359: aload 16
    //   361: ldc 99
    //   363: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 16
    //   369: lload 10
    //   371: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: ldc 63
    //   377: iconst_2
    //   378: aload 16
    //   380: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 105	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: lload 10
    //   388: l2f
    //   389: fstore_3
    //   390: fload_1
    //   391: fload_3
    //   392: fmul
    //   393: f2l
    //   394: lstore 8
    //   396: fload_3
    //   397: fload_2
    //   398: fmul
    //   399: f2l
    //   400: lstore 6
    //   402: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +71 -> 476
    //   408: new 43	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   415: astore 16
    //   417: aload 16
    //   419: ldc 107
    //   421: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 16
    //   427: lload 8
    //   429: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 16
    //   435: ldc 109
    //   437: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 16
    //   443: lload 6
    //   445: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 16
    //   451: ldc 111
    //   453: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 16
    //   459: lload 10
    //   461: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc 63
    //   467: iconst_2
    //   468: aload 16
    //   470: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: sipush 2048
    //   479: i2l
    //   480: lstore 12
    //   482: lload 8
    //   484: lload 8
    //   486: lload 12
    //   488: lrem
    //   489: lsub
    //   490: lstore 8
    //   492: lload 6
    //   494: lload 12
    //   496: lload 6
    //   498: lload 12
    //   500: lrem
    //   501: lsub
    //   502: ladd
    //   503: lstore 14
    //   505: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +71 -> 579
    //   511: new 43	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   518: astore 16
    //   520: aload 16
    //   522: ldc 113
    //   524: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 16
    //   530: lload 8
    //   532: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 16
    //   538: ldc 109
    //   540: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 16
    //   546: lload 14
    //   548: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload 16
    //   554: ldc 111
    //   556: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 16
    //   562: lload 10
    //   564: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 63
    //   570: iconst_2
    //   571: aload 16
    //   573: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: lconst_0
    //   580: lstore 12
    //   582: lload 8
    //   584: lstore 6
    //   586: lload 8
    //   588: lconst_0
    //   589: lcmp
    //   590: ifgt +6 -> 596
    //   593: lconst_0
    //   594: lstore 6
    //   596: lload 14
    //   598: lstore 8
    //   600: lload 14
    //   602: lload 10
    //   604: lcmp
    //   605: iflt +7 -> 612
    //   608: lload 10
    //   610: lstore 8
    //   612: lload 8
    //   614: lload 6
    //   616: lsub
    //   617: lstore 8
    //   619: sipush 2048
    //   622: newarray byte
    //   624: astore 19
    //   626: aconst_null
    //   627: astore 16
    //   629: new 115	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData
    //   632: dup
    //   633: aconst_null
    //   634: invokespecial 118	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:<init>	(Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$1;)V
    //   637: astore 20
    //   639: new 115	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData
    //   642: dup
    //   643: aconst_null
    //   644: invokespecial 118	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:<init>	(Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$1;)V
    //   647: astore 21
    //   649: ldc 119
    //   651: aload_0
    //   652: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   655: i2f
    //   656: fdiv
    //   657: invokestatic 125	java/lang/Math:round	(F)I
    //   660: sipush 2048
    //   663: imul
    //   664: istore 4
    //   666: aload 21
    //   668: iconst_0
    //   669: putfield 127	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_Int	I
    //   672: aload 21
    //   674: iload 4
    //   676: newarray byte
    //   678: putfield 130	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_ArrayOfByte	[B
    //   681: aload 21
    //   683: iload 4
    //   685: putfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   688: new 134	java/io/FileInputStream
    //   691: dup
    //   692: aload 17
    //   694: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   697: astore 17
    //   699: aload 17
    //   701: lload 6
    //   703: invokevirtual 141	java/io/FileInputStream:skip	(J)J
    //   706: lstore 10
    //   708: lload 10
    //   710: lload 6
    //   712: lcmp
    //   713: ifeq +10 -> 723
    //   716: aload 17
    //   718: invokevirtual 144	java/io/FileInputStream:close	()V
    //   721: iconst_0
    //   722: ireturn
    //   723: new 146	java/io/FileOutputStream
    //   726: dup
    //   727: aload 18
    //   729: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   732: astore 16
    //   734: lload 12
    //   736: lstore 6
    //   738: lload 6
    //   740: lload 8
    //   742: lcmp
    //   743: ifge +174 -> 917
    //   746: aload 17
    //   748: aload 19
    //   750: invokevirtual 151	java/io/FileInputStream:read	([B)I
    //   753: istore 4
    //   755: iload 4
    //   757: ifle -19 -> 738
    //   760: lload 8
    //   762: lload 6
    //   764: lsub
    //   765: l2i
    //   766: istore 5
    //   768: iload 4
    //   770: iload 5
    //   772: if_icmpge +74 -> 846
    //   775: aload_0
    //   776: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   779: ldc 35
    //   781: if_icmpeq +52 -> 833
    //   784: aload 20
    //   786: aload 19
    //   788: iconst_0
    //   789: iload 4
    //   791: invokevirtual 154	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:a	([BII)V
    //   794: aload_0
    //   795: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   798: ldc 35
    //   800: aload 20
    //   802: aload 21
    //   804: invokestatic 156	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils:a	(IILcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;)Z
    //   807: ifeq +274 -> 1081
    //   810: aload 16
    //   812: aload 21
    //   814: getfield 130	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_ArrayOfByte	[B
    //   817: aload 21
    //   819: getfield 127	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_Int	I
    //   822: aload 21
    //   824: getfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   827: invokevirtual 159	java/io/FileOutputStream:write	([BII)V
    //   830: goto +251 -> 1081
    //   833: aload 16
    //   835: aload 19
    //   837: iconst_0
    //   838: iload 4
    //   840: invokevirtual 159	java/io/FileOutputStream:write	([BII)V
    //   843: goto +238 -> 1081
    //   846: aload_0
    //   847: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   850: ldc 35
    //   852: if_icmpeq +52 -> 904
    //   855: aload 20
    //   857: aload 19
    //   859: iconst_0
    //   860: iload 5
    //   862: invokevirtual 154	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:a	([BII)V
    //   865: aload_0
    //   866: getfield 34	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   869: ldc 35
    //   871: aload 20
    //   873: aload 21
    //   875: invokestatic 156	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils:a	(IILcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;)Z
    //   878: ifeq +203 -> 1081
    //   881: aload 16
    //   883: aload 21
    //   885: getfield 130	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_ArrayOfByte	[B
    //   888: aload 21
    //   890: getfield 127	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_Int	I
    //   893: aload 21
    //   895: getfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   898: invokevirtual 159	java/io/FileOutputStream:write	([BII)V
    //   901: goto +180 -> 1081
    //   904: aload 16
    //   906: aload 19
    //   908: iconst_0
    //   909: iload 5
    //   911: invokevirtual 159	java/io/FileOutputStream:write	([BII)V
    //   914: goto +167 -> 1081
    //   917: aload_0
    //   918: aload 18
    //   920: putfield 77	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   923: aload 17
    //   925: invokevirtual 144	java/io/FileInputStream:close	()V
    //   928: aload 16
    //   930: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   933: iconst_1
    //   934: ireturn
    //   935: astore_0
    //   936: goto +86 -> 1022
    //   939: astore_0
    //   940: goto +14 -> 954
    //   943: astore_0
    //   944: aconst_null
    //   945: astore 16
    //   947: goto +75 -> 1022
    //   950: astore_0
    //   951: aconst_null
    //   952: astore 16
    //   954: aload_0
    //   955: astore 18
    //   957: aload 17
    //   959: astore_0
    //   960: goto +26 -> 986
    //   963: astore_0
    //   964: aconst_null
    //   965: astore 16
    //   967: aload 16
    //   969: astore 17
    //   971: goto +51 -> 1022
    //   974: astore 18
    //   976: aconst_null
    //   977: astore 17
    //   979: aload 16
    //   981: astore_0
    //   982: aload 17
    //   984: astore 16
    //   986: aload 18
    //   988: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   991: aload_0
    //   992: ifnull +10 -> 1002
    //   995: aload_0
    //   996: invokevirtual 144	java/io/FileInputStream:close	()V
    //   999: goto +3 -> 1002
    //   1002: aload 16
    //   1004: ifnull +8 -> 1012
    //   1007: aload 16
    //   1009: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   1012: iconst_0
    //   1013: ireturn
    //   1014: astore 18
    //   1016: aload_0
    //   1017: astore 17
    //   1019: aload 18
    //   1021: astore_0
    //   1022: aload 17
    //   1024: ifnull +11 -> 1035
    //   1027: aload 17
    //   1029: invokevirtual 144	java/io/FileInputStream:close	()V
    //   1032: goto +3 -> 1035
    //   1035: aload 16
    //   1037: ifnull +8 -> 1045
    //   1040: aload 16
    //   1042: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   1045: goto +5 -> 1050
    //   1048: aload_0
    //   1049: athrow
    //   1050: goto -2 -> 1048
    //   1053: astore_0
    //   1054: iconst_0
    //   1055: ireturn
    //   1056: astore_0
    //   1057: goto -129 -> 928
    //   1060: astore_0
    //   1061: goto -128 -> 933
    //   1064: astore_0
    //   1065: goto -63 -> 1002
    //   1068: astore_0
    //   1069: iconst_0
    //   1070: ireturn
    //   1071: astore 17
    //   1073: goto -38 -> 1035
    //   1076: astore 16
    //   1078: goto -33 -> 1045
    //   1081: lload 6
    //   1083: iload 4
    //   1085: i2l
    //   1086: ladd
    //   1087: lstore 6
    //   1089: goto -351 -> 738
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1092	0	paramSlideItemInfo	SlideItemInfo
    //   250	141	1	f1	float
    //   264	134	2	f2	float
    //   389	8	3	f3	float
    //   664	420	4	i	int
    //   766	144	5	j	int
    //   400	688	6	l1	long
    //   394	367	8	l2	long
    //   331	378	10	l3	long
    //   480	255	12	l4	long
    //   503	98	14	l5	long
    //   113	928	16	localObject1	Object
    //   1076	1	16	localIOException1	java.io.IOException
    //   324	704	17	localObject2	Object
    //   1071	1	17	localIOException2	java.io.IOException
    //   297	659	18	localObject3	Object
    //   974	13	18	localException	java.lang.Exception
    //   1014	6	18	localObject4	Object
    //   624	283	19	arrayOfByte	byte[]
    //   637	235	20	localMAudioData1	SegmentClipUtils.MAudioData
    //   647	247	21	localMAudioData2	SegmentClipUtils.MAudioData
    // Exception table:
    //   from	to	target	type
    //   746	755	935	finally
    //   775	830	935	finally
    //   833	843	935	finally
    //   846	901	935	finally
    //   904	914	935	finally
    //   917	923	935	finally
    //   746	755	939	java/lang/Exception
    //   775	830	939	java/lang/Exception
    //   833	843	939	java/lang/Exception
    //   846	901	939	java/lang/Exception
    //   904	914	939	java/lang/Exception
    //   917	923	939	java/lang/Exception
    //   699	708	943	finally
    //   723	734	943	finally
    //   699	708	950	java/lang/Exception
    //   723	734	950	java/lang/Exception
    //   688	699	963	finally
    //   688	699	974	java/lang/Exception
    //   986	991	1014	finally
    //   716	721	1053	java/io/IOException
    //   923	928	1056	java/io/IOException
    //   928	933	1060	java/io/IOException
    //   995	999	1064	java/io/IOException
    //   1007	1012	1068	java/io/IOException
    //   1027	1032	1071	java/io/IOException
    //   1040	1045	1076	java/io/IOException
  }
  
  public static boolean a(List<SlideItemInfo> paramList)
  {
    return true;
  }
  
  /* Error */
  private static boolean b(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   4: aload_2
    //   5: getfield 127	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_Int	I
    //   8: isub
    //   9: istore 4
    //   11: new 168	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_2
    //   16: getfield 130	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_ArrayOfByte	[B
    //   19: aload_2
    //   20: getfield 127	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_Int	I
    //   23: aload_2
    //   24: getfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   27: invokespecial 170	java/io/ByteArrayInputStream:<init>	([BII)V
    //   30: astore 10
    //   32: new 172	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: invokespecial 173	java/io/ByteArrayOutputStream:<init>	()V
    //   39: astore 9
    //   41: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   44: lstore 5
    //   46: new 180	com/tencent/biz/qqstory/utils/ffmpeg/resampling/SSRC
    //   49: dup
    //   50: aload 10
    //   52: aload 9
    //   54: iload_0
    //   55: iload_1
    //   56: iconst_2
    //   57: iconst_2
    //   58: iconst_1
    //   59: iload 4
    //   61: dconst_0
    //   62: iconst_0
    //   63: iconst_1
    //   64: invokespecial 183	com/tencent/biz/qqstory/utils/ffmpeg/resampling/SSRC:<init>	(Ljava/io/InputStream;Ljava/io/OutputStream;IIIIIIDIZ)V
    //   67: pop
    //   68: iload 4
    //   70: i2f
    //   71: fconst_1
    //   72: fmul
    //   73: iload_0
    //   74: i2f
    //   75: fdiv
    //   76: iload_1
    //   77: i2f
    //   78: fmul
    //   79: f2i
    //   80: istore_0
    //   81: aload_3
    //   82: iconst_0
    //   83: putfield 127	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_Int	I
    //   86: aload_3
    //   87: aload 9
    //   89: invokevirtual 187	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   92: putfield 130	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_ArrayOfByte	[B
    //   95: aload_3
    //   96: aload 9
    //   98: invokevirtual 191	java/io/ByteArrayOutputStream:size	()I
    //   101: putfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   104: aload_3
    //   105: getfield 130	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_a_of_type_ArrayOfByte	[B
    //   108: arraylength
    //   109: aload_3
    //   110: getfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   113: if_icmpne +104 -> 217
    //   116: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   119: lstore 7
    //   121: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +81 -> 205
    //   127: new 43	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   134: astore_2
    //   135: aload_2
    //   136: ldc 193
    //   138: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_2
    //   143: iload_0
    //   144: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: ldc 195
    //   151: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_2
    //   156: aload_3
    //   157: getfield 132	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:jdField_b_of_type_Int	I
    //   160: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: ldc 197
    //   167: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_2
    //   172: lload 7
    //   174: lload 5
    //   176: lsub
    //   177: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_2
    //   182: ldc 199
    //   184: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_2
    //   189: iload 4
    //   191: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 63
    //   197: iconst_2
    //   198: aload_2
    //   199: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 71	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 10
    //   207: invokevirtual 200	java/io/ByteArrayInputStream:close	()V
    //   210: aload 9
    //   212: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: new 203	java/lang/RuntimeException
    //   220: dup
    //   221: ldc 205
    //   223: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   226: athrow
    //   227: astore_2
    //   228: goto +8 -> 236
    //   231: astore_2
    //   232: goto +20 -> 252
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   240: aload 10
    //   242: invokevirtual 200	java/io/ByteArrayInputStream:close	()V
    //   245: aload 9
    //   247: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   250: iconst_0
    //   251: ireturn
    //   252: aload 10
    //   254: invokevirtual 200	java/io/ByteArrayInputStream:close	()V
    //   257: aload 9
    //   259: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   262: aload_2
    //   263: athrow
    //   264: astore_2
    //   265: goto -55 -> 210
    //   268: astore_2
    //   269: iconst_1
    //   270: ireturn
    //   271: astore_2
    //   272: goto -27 -> 245
    //   275: astore_2
    //   276: iconst_0
    //   277: ireturn
    //   278: astore_3
    //   279: goto -22 -> 257
    //   282: astore_3
    //   283: goto -21 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramInt1	int
    //   0	286	1	paramInt2	int
    //   0	286	2	paramMAudioData1	SegmentClipUtils.MAudioData
    //   0	286	3	paramMAudioData2	SegmentClipUtils.MAudioData
    //   9	181	4	i	int
    //   44	131	5	l1	long
    //   119	54	7	l2	long
    //   39	219	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   30	223	10	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   81	205	227	java/io/IOException
    //   217	227	227	java/io/IOException
    //   41	68	231	finally
    //   81	205	231	finally
    //   217	227	231	finally
    //   236	240	231	finally
    //   41	68	235	java/io/IOException
    //   205	210	264	java/io/IOException
    //   210	215	268	java/io/IOException
    //   240	245	271	java/io/IOException
    //   245	250	275	java/io/IOException
    //   252	257	278	java/io/IOException
    //   257	262	282	java/io/IOException
  }
  
  public static boolean b(List<SlideItemInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if ((localSlideItemInfo.jdField_b_of_type_Int == 1) && (localSlideItemInfo.jdField_a_of_type_Boolean) && (!a(localSlideItemInfo))) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean c(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    if (d(paramInt1, paramInt2, paramMAudioData1, paramMAudioData2)) {
      return true;
    }
    try
    {
      int i = paramMAudioData1.jdField_b_of_type_Int - paramMAudioData1.jdField_a_of_type_Int;
      int j = (int)(i * 1.0F / paramInt1 * paramInt2);
      long l1 = System.currentTimeMillis();
      paramInt1 = AudioResample.nativeResample(paramInt1, paramInt2, paramMAudioData1.jdField_a_of_type_ArrayOfByte, paramMAudioData1.jdField_b_of_type_Int, paramMAudioData2.jdField_a_of_type_ArrayOfByte, paramMAudioData2.jdField_a_of_type_ArrayOfByte.length, -1);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramMAudioData1 = new StringBuilder();
        paramMAudioData1.append("convertAudioDataQuick:  sizeOut=");
        paramMAudioData1.append(paramInt1);
        paramMAudioData1.append(" cost: ");
        paramMAudioData1.append(l2 - l1);
        paramMAudioData1.append(" ms quickChunkSize:");
        paramMAudioData1.append(j);
        paramMAudioData1.append(" result:");
        paramMAudioData1.append(paramInt1 * 2);
        paramMAudioData1.append(" inChunkLength:");
        paramMAudioData1.append(i);
        QLog.i("SegmentClipUtils", 2, paramMAudioData1.toString());
      }
      if (paramInt1 > 0)
      {
        paramMAudioData2.jdField_a_of_type_Int = 0;
        paramMAudioData2.jdField_b_of_type_Int = (paramInt1 * 2);
        return true;
      }
    }
    catch (UnsatisfiedLinkError paramMAudioData1)
    {
      paramMAudioData1.printStackTrace();
    }
    return false;
  }
  
  private static boolean d(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    if ((paramInt1 == 48000) && (paramInt2 == 44100))
    {
      float f = (paramInt1 - paramInt2) * 1.0F / paramInt1;
      int m = paramMAudioData1.jdField_b_of_type_Int - paramMAudioData1.jdField_a_of_type_Int;
      int n = m / 2;
      int i1 = (int)(f * n);
      int i2 = n - i1;
      int i3 = i2 / i1;
      long l1 = System.currentTimeMillis();
      paramInt2 = 0;
      int i = 0;
      int j = 0;
      int k;
      for (paramInt1 = 0; paramInt2 < n; paramInt1 = k)
      {
        if ((j == i3) && (paramInt1 < i1))
        {
          k = paramInt1 + 1;
          paramInt1 = 0;
        }
        else
        {
          byte[] arrayOfByte1 = paramMAudioData2.jdField_a_of_type_ArrayOfByte;
          k = i * 2;
          byte[] arrayOfByte2 = paramMAudioData1.jdField_a_of_type_ArrayOfByte;
          int i4 = paramInt2 * 2;
          arrayOfByte1[k] = arrayOfByte2[i4];
          paramMAudioData2.jdField_a_of_type_ArrayOfByte[(k + 1)] = paramMAudioData1.jdField_a_of_type_ArrayOfByte[(i4 + 1)];
          i += 1;
          j += 1;
          k = paramInt1;
          paramInt1 = j;
        }
        paramInt2 += 1;
        j = paramInt1;
      }
      long l2 = System.currentTimeMillis();
      paramMAudioData2.jdField_a_of_type_Int = 0;
      paramMAudioData2.jdField_b_of_type_Int = (i * 2);
      if (QLog.isColorLevel())
      {
        paramMAudioData1 = new StringBuilder();
        paramMAudioData1.append("convert48KTo441KB:  k=");
        paramMAudioData1.append(i);
        paramMAudioData1.append(" cost: ");
        paramMAudioData1.append(l2 - l1);
        paramMAudioData1.append(" ms diff:");
        paramMAudioData1.append(i1);
        paramMAudioData1.append(" remain:");
        paramMAudioData1.append(i2);
        paramMAudioData1.append(" inChunkLength:");
        paramMAudioData1.append(m);
        QLog.i("SegmentClipUtils", 2, paramMAudioData1.toString());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.SegmentClipUtils
 * JD-Core Version:    0.7.0.1
 */