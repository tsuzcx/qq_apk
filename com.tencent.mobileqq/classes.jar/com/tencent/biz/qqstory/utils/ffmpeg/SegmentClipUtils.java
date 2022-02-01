package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.shortvideo.util.AudioResample;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class SegmentClipUtils
{
  public static final int MAX_AUDIO_FRAME_SIZE = 1024;
  private static final int METHOD = -1;
  private static final int SWR_DITHER_NONE = 0;
  private static final int SWR_DITHER_NS = 64;
  private static final int SWR_DITHER_NS_F_WEIGHTED = 66;
  private static final int SWR_DITHER_NS_HIGH_SHIBATA = 71;
  private static final int SWR_DITHER_NS_IMPROVED_E_WEIGHTED = 68;
  private static final int SWR_DITHER_NS_LIPSHITZ = 65;
  private static final int SWR_DITHER_NS_LOW_SHIBATA = 70;
  private static final int SWR_DITHER_NS_MODIFIED_E_WEIGHTED = 67;
  private static final int SWR_DITHER_NS_SHIBATA = 69;
  private static final int SWR_DITHER_RECTANGULAR = 1;
  private static final int SWR_DITHER_TRIANGULAR = 2;
  private static final int SWR_DITHER_TRIANGULAR_HIGHPASS = 3;
  public static final String TAG = "SegmentClipUtils";
  private static final boolean USE_TEST = false;
  
  public static boolean clipAudio(List<SlideItemInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if ((localSlideItemInfo.jdField_b_of_type_Int == 1) && (localSlideItemInfo.jdField_a_of_type_Boolean) && (!clipAudioItem(localSlideItemInfo))) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private static boolean clipAudioItem(SlideItemInfo paramSlideItemInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifgt +18 -> 24
    //   9: aload_0
    //   10: getfield 86	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifgt +9 -> 24
    //   18: iconst_1
    //   19: istore 13
    //   21: iload 13
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 86	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   28: aload_0
    //   29: getfield 83	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   32: lcmp
    //   33: ifge +5 -> 38
    //   36: iconst_1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 86	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   42: aload_0
    //   43: getfield 88	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   46: lcmp
    //   47: ifle +11 -> 58
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 88	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   55: putfield 86	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   58: aload_0
    //   59: getfield 83	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifgt +8 -> 72
    //   67: aload_0
    //   68: lconst_0
    //   69: putfield 83	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   72: aload_0
    //   73: getfield 83	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   76: lconst_0
    //   77: lcmp
    //   78: ifne +26 -> 104
    //   81: aload_0
    //   82: getfield 86	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   85: aload_0
    //   86: getfield 88	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   89: lcmp
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   97: ldc 91
    //   99: if_icmpne +5 -> 104
    //   102: iconst_1
    //   103: ireturn
    //   104: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +43 -> 150
    //   110: ldc 37
    //   112: iconst_2
    //   113: new 98	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   120: ldc 101
    //   122: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   129: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc 110
    //   134: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   141: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   144: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   154: ifne +9 -> 163
    //   157: aload_0
    //   158: ldc 91
    //   160: putfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   163: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +43 -> 209
    //   169: ldc 37
    //   171: iconst_2
    //   172: new 98	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   179: ldc 123
    //   181: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   188: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc 110
    //   193: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Boolean	Z
    //   200: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   203: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_0
    //   210: getfield 83	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   213: l2f
    //   214: fconst_1
    //   215: fmul
    //   216: aload_0
    //   217: getfield 88	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   220: l2f
    //   221: fdiv
    //   222: fstore_1
    //   223: aload_0
    //   224: getfield 86	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   227: l2f
    //   228: fconst_1
    //   229: fmul
    //   230: aload_0
    //   231: getfield 88	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_Long	J
    //   234: l2f
    //   235: fdiv
    //   236: fstore_2
    //   237: new 98	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: getfield 126	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   248: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 128
    //   253: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore 19
    //   261: aload 19
    //   263: invokestatic 133	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   266: ifeq +9 -> 275
    //   269: aload 19
    //   271: invokestatic 135	com/tencent/mobileqq/filemanager/util/FileUtil:c	(Ljava/lang/String;)Z
    //   274: pop
    //   275: new 137	java/io/File
    //   278: dup
    //   279: aload_0
    //   280: getfield 126	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   283: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: astore 14
    //   288: aload 14
    //   290: invokevirtual 144	java/io/File:length	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: ldc2_w 145
    //   300: lrem
    //   301: lconst_0
    //   302: lcmp
    //   303: ifeq +35 -> 338
    //   306: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +29 -> 338
    //   312: ldc 37
    //   314: iconst_2
    //   315: new 98	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   322: ldc 148
    //   324: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: lload 7
    //   329: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: fload_1
    //   339: lload 7
    //   341: l2f
    //   342: fmul
    //   343: f2l
    //   344: lstore 5
    //   346: lload 7
    //   348: l2f
    //   349: fload_2
    //   350: fmul
    //   351: f2l
    //   352: lstore 9
    //   354: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +49 -> 406
    //   360: ldc 37
    //   362: iconst_2
    //   363: new 98	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   370: ldc 156
    //   372: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 5
    //   377: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: ldc 158
    //   382: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: lload 9
    //   387: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: ldc 160
    //   392: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: lload 7
    //   397: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: lload 5
    //   408: lload 5
    //   410: sipush 2048
    //   413: i2l
    //   414: lrem
    //   415: lsub
    //   416: lstore 5
    //   418: lload 9
    //   420: sipush 2048
    //   423: i2l
    //   424: lload 9
    //   426: sipush 2048
    //   429: i2l
    //   430: lrem
    //   431: lsub
    //   432: ladd
    //   433: lstore 9
    //   435: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +49 -> 487
    //   441: ldc 37
    //   443: iconst_2
    //   444: new 98	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   451: ldc 162
    //   453: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: lload 5
    //   458: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   461: ldc 158
    //   463: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: lload 9
    //   468: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: ldc 160
    //   473: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: lload 7
    //   478: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: lload 5
    //   489: lconst_0
    //   490: lcmp
    //   491: ifgt +510 -> 1001
    //   494: lconst_0
    //   495: lstore 5
    //   497: lload 9
    //   499: lload 7
    //   501: lcmp
    //   502: iflt +492 -> 994
    //   505: lload 7
    //   507: lload 5
    //   509: lsub
    //   510: lstore 9
    //   512: lconst_0
    //   513: lstore 7
    //   515: sipush 2048
    //   518: newarray byte
    //   520: astore 18
    //   522: new 164	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData
    //   525: dup
    //   526: aconst_null
    //   527: invokespecial 167	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:<init>	(Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$1;)V
    //   530: astore 17
    //   532: new 164	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData
    //   535: dup
    //   536: aconst_null
    //   537: invokespecial 167	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:<init>	(Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$1;)V
    //   540: astore 16
    //   542: ldc 168
    //   544: aload_0
    //   545: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   548: i2f
    //   549: fdiv
    //   550: invokestatic 174	java/lang/Math:round	(F)I
    //   553: sipush 2048
    //   556: imul
    //   557: istore_3
    //   558: aload 16
    //   560: iconst_0
    //   561: putfield 177	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:offset	I
    //   564: aload 16
    //   566: iload_3
    //   567: newarray byte
    //   569: putfield 181	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:data	[B
    //   572: aload 16
    //   574: iload_3
    //   575: putfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   578: new 186	java/io/FileInputStream
    //   581: dup
    //   582: aload 14
    //   584: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   587: astore 15
    //   589: aload 15
    //   591: lload 5
    //   593: invokevirtual 193	java/io/FileInputStream:skip	(J)J
    //   596: lstore 11
    //   598: lload 11
    //   600: lload 5
    //   602: lcmp
    //   603: ifeq +31 -> 634
    //   606: iconst_0
    //   607: istore 13
    //   609: aload 15
    //   611: ifnull +8 -> 619
    //   614: aload 15
    //   616: invokevirtual 196	java/io/FileInputStream:close	()V
    //   619: iconst_0
    //   620: ifeq -599 -> 21
    //   623: new 198	java/lang/NullPointerException
    //   626: dup
    //   627: invokespecial 199	java/lang/NullPointerException:<init>	()V
    //   630: athrow
    //   631: astore_0
    //   632: iconst_0
    //   633: ireturn
    //   634: new 201	java/io/FileOutputStream
    //   637: dup
    //   638: aload 19
    //   640: invokespecial 202	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   643: astore 14
    //   645: lload 7
    //   647: lstore 5
    //   649: lload 5
    //   651: lload 9
    //   653: lcmp
    //   654: ifge +227 -> 881
    //   657: aload 15
    //   659: aload 18
    //   661: invokevirtual 206	java/io/FileInputStream:read	([B)I
    //   664: istore 4
    //   666: iload 4
    //   668: ifle -19 -> 649
    //   671: lload 9
    //   673: lload 5
    //   675: lsub
    //   676: l2i
    //   677: istore_3
    //   678: iload 4
    //   680: iload_3
    //   681: if_icmpge +108 -> 789
    //   684: aload_0
    //   685: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   688: ldc 91
    //   690: if_icmpeq +52 -> 742
    //   693: aload 17
    //   695: aload 18
    //   697: iconst_0
    //   698: iload 4
    //   700: invokevirtual 210	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:set	([BII)V
    //   703: aload_0
    //   704: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   707: ldc 91
    //   709: aload 17
    //   711: aload 16
    //   713: invokestatic 214	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils:convertAudioData	(IILcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;)Z
    //   716: ifeq +288 -> 1004
    //   719: aload 14
    //   721: aload 16
    //   723: getfield 181	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:data	[B
    //   726: aload 16
    //   728: getfield 177	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:offset	I
    //   731: aload 16
    //   733: getfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   736: invokevirtual 217	java/io/FileOutputStream:write	([BII)V
    //   739: goto +265 -> 1004
    //   742: aload 14
    //   744: aload 18
    //   746: iconst_0
    //   747: iload 4
    //   749: invokevirtual 217	java/io/FileOutputStream:write	([BII)V
    //   752: goto +252 -> 1004
    //   755: astore 16
    //   757: aload 15
    //   759: astore_0
    //   760: aload 16
    //   762: astore 15
    //   764: aload 15
    //   766: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   769: aload_0
    //   770: ifnull +7 -> 777
    //   773: aload_0
    //   774: invokevirtual 196	java/io/FileInputStream:close	()V
    //   777: aload 14
    //   779: ifnull +8 -> 787
    //   782: aload 14
    //   784: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   787: iconst_0
    //   788: ireturn
    //   789: aload_0
    //   790: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   793: ldc 91
    //   795: if_icmpeq +74 -> 869
    //   798: aload 17
    //   800: aload 18
    //   802: iconst_0
    //   803: iload_3
    //   804: invokevirtual 210	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:set	([BII)V
    //   807: aload_0
    //   808: getfield 90	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Int	I
    //   811: ldc 91
    //   813: aload 17
    //   815: aload 16
    //   817: invokestatic 214	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils:convertAudioData	(IILcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;Lcom/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData;)Z
    //   820: ifeq +184 -> 1004
    //   823: aload 14
    //   825: aload 16
    //   827: getfield 181	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:data	[B
    //   830: aload 16
    //   832: getfield 177	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:offset	I
    //   835: aload 16
    //   837: getfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   840: invokevirtual 217	java/io/FileOutputStream:write	([BII)V
    //   843: goto +161 -> 1004
    //   846: astore_0
    //   847: aload 15
    //   849: ifnull +8 -> 857
    //   852: aload 15
    //   854: invokevirtual 196	java/io/FileInputStream:close	()V
    //   857: aload 14
    //   859: ifnull +8 -> 867
    //   862: aload 14
    //   864: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   867: aload_0
    //   868: athrow
    //   869: aload 14
    //   871: aload 18
    //   873: iconst_0
    //   874: iload_3
    //   875: invokevirtual 217	java/io/FileOutputStream:write	([BII)V
    //   878: goto +126 -> 1004
    //   881: aload_0
    //   882: aload 19
    //   884: putfield 126	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Ljava/lang/String;
    //   887: iconst_1
    //   888: istore 13
    //   890: aload 15
    //   892: ifnull +8 -> 900
    //   895: aload 15
    //   897: invokevirtual 196	java/io/FileInputStream:close	()V
    //   900: aload 14
    //   902: ifnull -881 -> 21
    //   905: aload 14
    //   907: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   910: iconst_1
    //   911: ireturn
    //   912: astore_0
    //   913: iconst_1
    //   914: ireturn
    //   915: astore_0
    //   916: goto -297 -> 619
    //   919: astore_0
    //   920: goto -20 -> 900
    //   923: astore_0
    //   924: goto -147 -> 777
    //   927: astore_0
    //   928: goto -141 -> 787
    //   931: astore 15
    //   933: goto -76 -> 857
    //   936: astore 14
    //   938: goto -71 -> 867
    //   941: astore_0
    //   942: aconst_null
    //   943: astore 15
    //   945: aconst_null
    //   946: astore 14
    //   948: goto -101 -> 847
    //   951: astore_0
    //   952: aconst_null
    //   953: astore 14
    //   955: goto -108 -> 847
    //   958: astore 16
    //   960: aload_0
    //   961: astore 15
    //   963: aload 16
    //   965: astore_0
    //   966: goto -119 -> 847
    //   969: astore 15
    //   971: aconst_null
    //   972: astore_0
    //   973: aconst_null
    //   974: astore 14
    //   976: goto -212 -> 764
    //   979: astore 16
    //   981: aconst_null
    //   982: astore 14
    //   984: aload 15
    //   986: astore_0
    //   987: aload 16
    //   989: astore 15
    //   991: goto -227 -> 764
    //   994: lload 9
    //   996: lstore 7
    //   998: goto -493 -> 505
    //   1001: goto -504 -> 497
    //   1004: lload 5
    //   1006: iload 4
    //   1008: i2l
    //   1009: ladd
    //   1010: lstore 5
    //   1012: goto -363 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	paramSlideItemInfo	SlideItemInfo
    //   222	117	1	f1	float
    //   236	114	2	f2	float
    //   557	318	3	i	int
    //   664	343	4	j	int
    //   344	667	5	l1	long
    //   293	704	7	l2	long
    //   352	643	9	l3	long
    //   596	3	11	l4	long
    //   19	870	13	bool	boolean
    //   286	620	14	localObject1	Object
    //   936	1	14	localIOException1	java.io.IOException
    //   946	37	14	localObject2	Object
    //   587	309	15	localObject3	Object
    //   931	1	15	localIOException2	java.io.IOException
    //   943	19	15	localSlideItemInfo	SlideItemInfo
    //   969	16	15	localException1	java.lang.Exception
    //   989	1	15	localException2	java.lang.Exception
    //   540	192	16	localMAudioData1	SegmentClipUtils.MAudioData
    //   755	81	16	localException3	java.lang.Exception
    //   958	6	16	localObject4	Object
    //   979	9	16	localException4	java.lang.Exception
    //   530	284	17	localMAudioData2	SegmentClipUtils.MAudioData
    //   520	352	18	arrayOfByte	byte[]
    //   259	624	19	str	String
    // Exception table:
    //   from	to	target	type
    //   623	631	631	java/io/IOException
    //   657	666	755	java/lang/Exception
    //   684	739	755	java/lang/Exception
    //   742	752	755	java/lang/Exception
    //   789	843	755	java/lang/Exception
    //   869	878	755	java/lang/Exception
    //   881	887	755	java/lang/Exception
    //   657	666	846	finally
    //   684	739	846	finally
    //   742	752	846	finally
    //   789	843	846	finally
    //   869	878	846	finally
    //   881	887	846	finally
    //   905	910	912	java/io/IOException
    //   614	619	915	java/io/IOException
    //   895	900	919	java/io/IOException
    //   773	777	923	java/io/IOException
    //   782	787	927	java/io/IOException
    //   852	857	931	java/io/IOException
    //   862	867	936	java/io/IOException
    //   578	589	941	finally
    //   589	598	951	finally
    //   634	645	951	finally
    //   764	769	958	finally
    //   578	589	969	java/lang/Exception
    //   589	598	979	java/lang/Exception
    //   634	645	979	java/lang/Exception
  }
  
  public static boolean clipVideo(List<SlideItemInfo> paramList)
  {
    return true;
  }
  
  private static boolean convert48KTo441KB(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    if ((paramInt1 == 48000) && (paramInt2 == 44100))
    {
      float f = (paramInt1 - paramInt2) * 1.0F / paramInt1;
      int k = paramMAudioData1.size - paramMAudioData1.offset;
      int m = k / 2;
      int n = (int)(f * m);
      int i1 = (m - n) / n;
      long l1 = System.currentTimeMillis();
      paramInt2 = 0;
      paramInt1 = 0;
      int j = 0;
      int i = 0;
      if (paramInt2 < m)
      {
        if ((paramInt1 != i1) || (i >= n))
        {
          paramMAudioData2.data[(j * 2)] = paramMAudioData1.data[(paramInt2 * 2)];
          paramMAudioData2.data[(j * 2 + 1)] = paramMAudioData1.data[(paramInt2 * 2 + 1)];
          j += 1;
          paramInt1 += 1;
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          paramInt1 = 0;
          i += 1;
        }
      }
      long l2 = System.currentTimeMillis();
      paramMAudioData2.offset = 0;
      paramMAudioData2.size = (j * 2);
      if (QLog.isColorLevel()) {
        QLog.i("SegmentClipUtils", 2, "convert48KTo441KB:  k=" + j + " cost: " + (l2 - l1) + " ms diff:" + n + " remain:" + (m - n) + " inChunkLength:" + k);
      }
      return true;
    }
    return false;
  }
  
  private static boolean convertAudioData(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    if (!convertAudioDataQuick(paramInt1, paramInt2, paramMAudioData1, paramMAudioData2)) {
      return convertAudioDataSlow(paramInt1, paramInt2, paramMAudioData1, paramMAudioData2);
    }
    return true;
  }
  
  private static boolean convertAudioDataQuick(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    if (convert48KTo441KB(paramInt1, paramInt2, paramMAudioData1, paramMAudioData2)) {
      return true;
    }
    try
    {
      int i = paramMAudioData1.size - paramMAudioData1.offset;
      int j = (int)(i * 1.0F / paramInt1 * paramInt2);
      long l1 = System.currentTimeMillis();
      paramInt1 = AudioResample.nativeResample(paramInt1, paramInt2, paramMAudioData1.data, paramMAudioData1.size, paramMAudioData2.data, paramMAudioData2.data.length, -1);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("SegmentClipUtils", 2, "convertAudioDataQuick:  sizeOut=" + paramInt1 + " cost: " + (l2 - l1) + " ms quickChunkSize:" + j + " result:" + paramInt1 * 2 + " inChunkLength:" + i);
      }
      if (paramInt1 > 0)
      {
        paramMAudioData2.offset = 0;
        paramMAudioData2.size = (paramInt1 * 2);
        return true;
      }
    }
    catch (UnsatisfiedLinkError paramMAudioData1)
    {
      paramMAudioData1.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private static boolean convertAudioDataSlow(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   4: aload_2
    //   5: getfield 177	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:offset	I
    //   8: isub
    //   9: istore 4
    //   11: new 264	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_2
    //   16: getfield 181	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:data	[B
    //   19: aload_2
    //   20: getfield 177	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:offset	I
    //   23: aload_2
    //   24: getfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   27: invokespecial 266	java/io/ByteArrayInputStream:<init>	([BII)V
    //   30: astore 9
    //   32: new 268	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: invokespecial 269	java/io/ByteArrayOutputStream:<init>	()V
    //   39: astore_2
    //   40: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   43: lstore 5
    //   45: new 271	com/tencent/biz/qqstory/utils/ffmpeg/resampling/SSRC
    //   48: dup
    //   49: aload 9
    //   51: aload_2
    //   52: iload_0
    //   53: iload_1
    //   54: iconst_2
    //   55: iconst_2
    //   56: iconst_1
    //   57: iload 4
    //   59: dconst_0
    //   60: iconst_0
    //   61: iconst_1
    //   62: invokespecial 274	com/tencent/biz/qqstory/utils/ffmpeg/resampling/SSRC:<init>	(Ljava/io/InputStream;Ljava/io/OutputStream;IIIIIIDIZ)V
    //   65: pop
    //   66: iload 4
    //   68: i2f
    //   69: fconst_1
    //   70: fmul
    //   71: iload_0
    //   72: i2f
    //   73: fdiv
    //   74: iload_1
    //   75: i2f
    //   76: fmul
    //   77: f2i
    //   78: istore_0
    //   79: aload_3
    //   80: iconst_0
    //   81: putfield 177	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:offset	I
    //   84: aload_3
    //   85: aload_2
    //   86: invokevirtual 278	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: putfield 181	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:data	[B
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 281	java/io/ByteArrayOutputStream:size	()I
    //   97: putfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   100: aload_3
    //   101: getfield 181	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:data	[B
    //   104: arraylength
    //   105: aload_3
    //   106: getfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   109: if_icmpeq +30 -> 139
    //   112: new 283	java/lang/RuntimeException
    //   115: dup
    //   116: ldc_w 285
    //   119: invokespecial 286	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore_3
    //   124: aload_3
    //   125: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   128: aload 9
    //   130: invokevirtual 288	java/io/ByteArrayInputStream:close	()V
    //   133: aload_2
    //   134: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   142: lstore 7
    //   144: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +66 -> 213
    //   150: ldc 37
    //   152: iconst_2
    //   153: new 98	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 291
    //   163: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_0
    //   167: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 293
    //   173: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_3
    //   177: getfield 184	com/tencent/biz/qqstory/utils/ffmpeg/SegmentClipUtils$MAudioData:size	I
    //   180: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 233
    //   185: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload 7
    //   190: lload 5
    //   192: lsub
    //   193: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: ldc_w 295
    //   199: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload 4
    //   204: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload 9
    //   215: invokevirtual 288	java/io/ByteArrayInputStream:close	()V
    //   218: aload_2
    //   219: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore_2
    //   225: iconst_1
    //   226: ireturn
    //   227: astore_3
    //   228: aload 9
    //   230: invokevirtual 288	java/io/ByteArrayInputStream:close	()V
    //   233: aload_2
    //   234: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   237: aload_3
    //   238: athrow
    //   239: astore_3
    //   240: goto -22 -> 218
    //   243: astore_3
    //   244: goto -111 -> 133
    //   247: astore_2
    //   248: goto -111 -> 137
    //   251: astore 9
    //   253: goto -20 -> 233
    //   256: astore_2
    //   257: goto -20 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramInt1	int
    //   0	260	1	paramInt2	int
    //   0	260	2	paramMAudioData1	SegmentClipUtils.MAudioData
    //   0	260	3	paramMAudioData2	SegmentClipUtils.MAudioData
    //   9	194	4	i	int
    //   43	148	5	l1	long
    //   142	47	7	l2	long
    //   30	199	9	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   251	1	9	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   40	123	123	java/io/IOException
    //   139	213	123	java/io/IOException
    //   218	222	224	java/io/IOException
    //   40	123	227	finally
    //   124	128	227	finally
    //   139	213	227	finally
    //   213	218	239	java/io/IOException
    //   128	133	243	java/io/IOException
    //   133	137	247	java/io/IOException
    //   228	233	251	java/io/IOException
    //   233	237	256	java/io/IOException
  }
  
  private static boolean hookTest(int paramInt1, int paramInt2, SegmentClipUtils.MAudioData paramMAudioData1, SegmentClipUtils.MAudioData paramMAudioData2)
  {
    paramMAudioData2.data = paramMAudioData1.data;
    paramMAudioData2.size = paramMAudioData1.size;
    paramMAudioData2.offset = paramMAudioData1.offset;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.SegmentClipUtils
 * JD-Core Version:    0.7.0.1
 */