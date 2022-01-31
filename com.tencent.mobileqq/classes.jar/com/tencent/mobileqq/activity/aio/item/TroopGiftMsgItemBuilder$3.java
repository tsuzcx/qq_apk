package com.tencent.mobileqq.activity.aio.item;

import agem;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.BubbleImageView;

public class TroopGiftMsgItemBuilder$3
  implements Runnable
{
  public TroopGiftMsgItemBuilder$3(agem paramagem, String paramString1, int paramInt, Bitmap paramBitmap, BubbleImageView paramBubbleImageView, String paramString2, SharedPreferences paramSharedPreferences, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc 53
    //   8: iconst_2
    //   9: new 55	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   16: ldc 58
    //   18: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   25: aload_0
    //   26: getfield 22	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: aload_0
    //   30: getfield 24	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_Int	I
    //   33: invokevirtual 67	agem:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   36: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   49: getfield 78	agem:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 84	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 90	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   58: invokevirtual 96	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   61: astore 6
    //   63: new 98	android/graphics/Matrix
    //   66: dup
    //   67: invokespecial 99	android/graphics/Matrix:<init>	()V
    //   70: astore 5
    //   72: aload 5
    //   74: fconst_1
    //   75: fconst_1
    //   76: invokevirtual 103	android/graphics/Matrix:postScale	(FF)Z
    //   79: pop
    //   80: aload_0
    //   81: getfield 26	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   84: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   87: istore_1
    //   88: aload_0
    //   89: getfield 26	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   92: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   95: istore_2
    //   96: aload_0
    //   97: getfield 26	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   100: iload_1
    //   101: i2d
    //   102: ldc2_w 113
    //   105: dmul
    //   106: d2i
    //   107: iload_2
    //   108: i2d
    //   109: ldc2_w 113
    //   112: dmul
    //   113: d2i
    //   114: iload_1
    //   115: iconst_1
    //   116: isub
    //   117: i2d
    //   118: ldc2_w 115
    //   121: dmul
    //   122: d2i
    //   123: iload_2
    //   124: iconst_1
    //   125: isub
    //   126: i2d
    //   127: ldc2_w 115
    //   130: dmul
    //   131: d2i
    //   132: aload 5
    //   134: iconst_1
    //   135: invokestatic 120	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   138: astore 5
    //   140: aload_0
    //   141: getfield 28	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView	Lcom/tencent/mobileqq/widget/BubbleImageView;
    //   144: invokevirtual 126	com/tencent/mobileqq/widget/BubbleImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   147: getfield 131	android/view/ViewGroup$LayoutParams:width	I
    //   150: istore_1
    //   151: ldc 132
    //   153: aload 6
    //   155: getfield 138	android/util/DisplayMetrics:density	F
    //   158: fmul
    //   159: f2i
    //   160: istore_2
    //   161: iload_1
    //   162: iload_2
    //   163: getstatic 144	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   166: invokestatic 147	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   169: astore 9
    //   171: new 149	android/graphics/Canvas
    //   174: dup
    //   175: aload 9
    //   177: invokespecial 152	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   180: astore 7
    //   182: new 154	android/graphics/Paint
    //   185: dup
    //   186: invokespecial 155	android/graphics/Paint:<init>	()V
    //   189: astore 6
    //   191: aload 6
    //   193: iconst_m1
    //   194: invokevirtual 159	android/graphics/Paint:setColor	(I)V
    //   197: aload 7
    //   199: fconst_0
    //   200: fconst_0
    //   201: iload_1
    //   202: i2f
    //   203: iload_2
    //   204: i2f
    //   205: aload 6
    //   207: invokevirtual 163	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   210: aload_0
    //   211: getfield 24	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_Int	I
    //   214: ifeq +83 -> 297
    //   217: new 149	android/graphics/Canvas
    //   220: dup
    //   221: aload 9
    //   223: invokespecial 152	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   226: astore 7
    //   228: aload 7
    //   230: aload 5
    //   232: new 165	android/graphics/Rect
    //   235: dup
    //   236: iconst_0
    //   237: iconst_0
    //   238: aload 5
    //   240: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   243: aload 5
    //   245: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   248: invokespecial 168	android/graphics/Rect:<init>	(IIII)V
    //   251: new 165	android/graphics/Rect
    //   254: dup
    //   255: iconst_0
    //   256: iconst_0
    //   257: iload_1
    //   258: iload_2
    //   259: invokespecial 168	android/graphics/Rect:<init>	(IIII)V
    //   262: aload 6
    //   264: invokevirtual 172	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   267: aload 6
    //   269: aload_0
    //   270: getfield 24	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_Int	I
    //   273: invokevirtual 159	android/graphics/Paint:setColor	(I)V
    //   276: aload 7
    //   278: fconst_0
    //   279: fconst_0
    //   280: aload 9
    //   282: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   285: i2f
    //   286: aload 9
    //   288: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   291: i2f
    //   292: aload 6
    //   294: invokevirtual 163	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   297: aload_0
    //   298: getfield 24	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_Int	I
    //   301: ifeq +10 -> 311
    //   304: aload 9
    //   306: bipush 60
    //   308: invokestatic 177	bdnl:a	(Landroid/graphics/Bitmap;I)V
    //   311: new 179	java/io/File
    //   314: dup
    //   315: new 55	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   322: getstatic 184	alof:aX	Ljava/lang/String;
    //   325: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc 186
    //   330: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 191	bdzf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   342: invokevirtual 197	java/io/File:mkdirs	()Z
    //   345: pop
    //   346: new 179	java/io/File
    //   349: dup
    //   350: aload_0
    //   351: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   354: aload_0
    //   355: getfield 22	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   358: aload_0
    //   359: getfield 24	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_Int	I
    //   362: invokevirtual 67	agem:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   365: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   368: astore 8
    //   370: aload 8
    //   372: invokevirtual 200	java/io/File:exists	()Z
    //   375: istore_3
    //   376: iload_3
    //   377: ifne +9 -> 386
    //   380: aload 8
    //   382: invokevirtual 203	java/io/File:createNewFile	()Z
    //   385: pop
    //   386: aconst_null
    //   387: astore 5
    //   389: aconst_null
    //   390: astore 7
    //   392: new 205	java/io/BufferedOutputStream
    //   395: dup
    //   396: new 207	java/io/FileOutputStream
    //   399: dup
    //   400: aload 8
    //   402: invokespecial 210	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   405: sipush 8192
    //   408: invokespecial 213	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   411: astore 6
    //   413: aload 6
    //   415: astore 5
    //   417: aload 9
    //   419: getstatic 219	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   422: bipush 100
    //   424: aload 6
    //   426: invokevirtual 223	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   429: istore 4
    //   431: aload_0
    //   432: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   435: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   438: aload_0
    //   439: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   442: iconst_0
    //   443: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   446: invokeinterface 238 3 0
    //   451: pop
    //   452: iload 4
    //   454: istore_3
    //   455: aload 6
    //   457: ifnull +11 -> 468
    //   460: aload 6
    //   462: invokevirtual 241	java/io/BufferedOutputStream:close	()V
    //   465: iload 4
    //   467: istore_3
    //   468: iload_3
    //   469: ifne +64 -> 533
    //   472: aload 8
    //   474: invokevirtual 200	java/io/File:exists	()Z
    //   477: ifeq +56 -> 533
    //   480: aload 8
    //   482: invokevirtual 244	java/io/File:delete	()Z
    //   485: pop
    //   486: aload_0
    //   487: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   490: getfield 247	agem:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   493: getstatic 248	agem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   496: iconst_0
    //   497: invokevirtual 254	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   500: astore 5
    //   502: aload 5
    //   504: invokeinterface 260 1 0
    //   509: aload_0
    //   510: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   513: lconst_0
    //   514: invokeinterface 266 4 0
    //   519: pop
    //   520: aload 5
    //   522: invokeinterface 260 1 0
    //   527: invokeinterface 269 1 0
    //   532: pop
    //   533: iload_3
    //   534: ifeq +41 -> 575
    //   537: aload_0
    //   538: getfield 32	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   541: invokeinterface 260 1 0
    //   546: aload_0
    //   547: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   550: aload_0
    //   551: getfield 34	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_Long	J
    //   554: invokeinterface 266 4 0
    //   559: pop
    //   560: aload_0
    //   561: getfield 32	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   564: invokeinterface 260 1 0
    //   569: invokeinterface 269 1 0
    //   574: pop
    //   575: invokestatic 272	agem:a	()Landroid/os/Handler;
    //   578: new 274	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3$1
    //   581: dup
    //   582: aload_0
    //   583: invokespecial 277	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3$1:<init>	(Lcom/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3;)V
    //   586: invokevirtual 283	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   589: pop
    //   590: aload_0
    //   591: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   594: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   597: aload_0
    //   598: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   601: iconst_0
    //   602: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   605: invokeinterface 238 3 0
    //   610: pop
    //   611: return
    //   612: astore 5
    //   614: aload 5
    //   616: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   619: goto -233 -> 386
    //   622: astore 5
    //   624: aload_0
    //   625: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   628: getfield 247	agem:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   631: getstatic 248	agem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   634: iconst_0
    //   635: invokevirtual 254	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   638: astore 6
    //   640: aload 6
    //   642: invokeinterface 260 1 0
    //   647: aload_0
    //   648: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   651: lconst_0
    //   652: invokeinterface 266 4 0
    //   657: pop
    //   658: aload 6
    //   660: invokeinterface 260 1 0
    //   665: invokeinterface 269 1 0
    //   670: pop
    //   671: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +15 -> 689
    //   677: ldc_w 288
    //   680: iconst_2
    //   681: aload 5
    //   683: invokevirtual 291	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   686: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_0
    //   690: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   693: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   696: aload_0
    //   697: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   700: iconst_0
    //   701: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   704: invokeinterface 238 3 0
    //   709: pop
    //   710: return
    //   711: astore 5
    //   713: iload 4
    //   715: istore_3
    //   716: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq -251 -> 468
    //   722: ldc_w 288
    //   725: iconst_2
    //   726: aload 5
    //   728: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   731: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   734: iload 4
    //   736: istore_3
    //   737: goto -269 -> 468
    //   740: astore 5
    //   742: aload_0
    //   743: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   746: getfield 247	agem:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   749: getstatic 248	agem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   752: iconst_0
    //   753: invokevirtual 254	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   756: astore 6
    //   758: aload 6
    //   760: invokeinterface 260 1 0
    //   765: aload_0
    //   766: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   769: lconst_0
    //   770: invokeinterface 266 4 0
    //   775: pop
    //   776: aload 6
    //   778: invokeinterface 260 1 0
    //   783: invokeinterface 269 1 0
    //   788: pop
    //   789: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   792: ifeq +15 -> 807
    //   795: ldc_w 288
    //   798: iconst_2
    //   799: aload 5
    //   801: invokevirtual 296	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   804: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: aload_0
    //   808: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   811: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   814: aload_0
    //   815: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   818: iconst_0
    //   819: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   822: invokeinterface 238 3 0
    //   827: pop
    //   828: return
    //   829: astore 7
    //   831: aconst_null
    //   832: astore 6
    //   834: aload 6
    //   836: astore 5
    //   838: aload_0
    //   839: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   842: getfield 247	agem:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   845: getstatic 248	agem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   848: iconst_0
    //   849: invokevirtual 254	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   852: astore 9
    //   854: aload 6
    //   856: astore 5
    //   858: aload 9
    //   860: invokeinterface 260 1 0
    //   865: aload_0
    //   866: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   869: lconst_0
    //   870: invokeinterface 266 4 0
    //   875: pop
    //   876: aload 6
    //   878: astore 5
    //   880: aload 9
    //   882: invokeinterface 260 1 0
    //   887: invokeinterface 269 1 0
    //   892: pop
    //   893: aload 6
    //   895: astore 5
    //   897: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +19 -> 919
    //   903: aload 6
    //   905: astore 5
    //   907: ldc_w 288
    //   910: iconst_2
    //   911: aload 7
    //   913: invokevirtual 291	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   916: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   919: aload_0
    //   920: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   923: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   926: aload_0
    //   927: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   930: iconst_0
    //   931: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   934: invokeinterface 238 3 0
    //   939: pop
    //   940: aload 6
    //   942: ifnull +290 -> 1232
    //   945: aload 6
    //   947: invokevirtual 241	java/io/BufferedOutputStream:close	()V
    //   950: iconst_0
    //   951: istore_3
    //   952: goto -484 -> 468
    //   955: astore 5
    //   957: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq +15 -> 975
    //   963: ldc_w 288
    //   966: iconst_2
    //   967: aload 5
    //   969: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   972: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: iconst_0
    //   976: istore_3
    //   977: goto -509 -> 468
    //   980: astore 5
    //   982: aload 7
    //   984: astore 6
    //   986: aload 5
    //   988: astore 7
    //   990: aload 6
    //   992: astore 5
    //   994: aload_0
    //   995: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   998: getfield 247	agem:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1001: getstatic 248	agem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1004: iconst_0
    //   1005: invokevirtual 254	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1008: astore 9
    //   1010: aload 6
    //   1012: astore 5
    //   1014: aload 9
    //   1016: invokeinterface 260 1 0
    //   1021: aload_0
    //   1022: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   1025: lconst_0
    //   1026: invokeinterface 266 4 0
    //   1031: pop
    //   1032: aload 6
    //   1034: astore 5
    //   1036: aload 9
    //   1038: invokeinterface 260 1 0
    //   1043: invokeinterface 269 1 0
    //   1048: pop
    //   1049: aload 6
    //   1051: astore 5
    //   1053: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1056: ifeq +19 -> 1075
    //   1059: aload 6
    //   1061: astore 5
    //   1063: ldc_w 288
    //   1066: iconst_2
    //   1067: aload 7
    //   1069: invokevirtual 296	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1072: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1075: aload_0
    //   1076: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   1079: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1082: aload_0
    //   1083: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   1086: iconst_0
    //   1087: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1090: invokeinterface 238 3 0
    //   1095: pop
    //   1096: aload 6
    //   1098: ifnull +134 -> 1232
    //   1101: aload 6
    //   1103: invokevirtual 241	java/io/BufferedOutputStream:close	()V
    //   1106: iconst_0
    //   1107: istore_3
    //   1108: goto -640 -> 468
    //   1111: astore 5
    //   1113: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1116: ifeq +121 -> 1237
    //   1119: ldc_w 288
    //   1122: iconst_2
    //   1123: aload 5
    //   1125: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1128: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1131: goto +106 -> 1237
    //   1134: aload_0
    //   1135: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   1138: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1141: aload_0
    //   1142: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   1145: iconst_0
    //   1146: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1149: invokeinterface 238 3 0
    //   1154: pop
    //   1155: aload 5
    //   1157: ifnull +8 -> 1165
    //   1160: aload 5
    //   1162: invokevirtual 241	java/io/BufferedOutputStream:close	()V
    //   1165: aload 6
    //   1167: athrow
    //   1168: astore 5
    //   1170: aload_0
    //   1171: getfield 20	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:this$0	Lagem;
    //   1174: getfield 226	agem:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1177: aload_0
    //   1178: getfield 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$3:b	Ljava/lang/String;
    //   1181: iconst_0
    //   1182: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1185: invokeinterface 238 3 0
    //   1190: pop
    //   1191: aload 5
    //   1193: athrow
    //   1194: astore 5
    //   1196: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1199: ifeq -34 -> 1165
    //   1202: ldc_w 288
    //   1205: iconst_2
    //   1206: aload 5
    //   1208: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1211: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: goto -49 -> 1165
    //   1217: astore 6
    //   1219: goto -85 -> 1134
    //   1222: astore 7
    //   1224: goto -234 -> 990
    //   1227: astore 7
    //   1229: goto -395 -> 834
    //   1232: iconst_0
    //   1233: istore_3
    //   1234: goto -766 -> 468
    //   1237: iconst_0
    //   1238: istore_3
    //   1239: goto -771 -> 468
    //   1242: astore 6
    //   1244: goto -110 -> 1134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1247	0	this	3
    //   87	171	1	i	int
    //   95	164	2	j	int
    //   375	864	3	bool1	boolean
    //   429	306	4	bool2	boolean
    //   70	451	5	localObject1	Object
    //   612	3	5	localIOException1	java.io.IOException
    //   622	60	5	localException1	java.lang.Exception
    //   711	16	5	localIOException2	java.io.IOException
    //   740	60	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   836	70	5	localObject2	Object
    //   955	13	5	localIOException3	java.io.IOException
    //   980	7	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   992	70	5	localObject3	Object
    //   1111	50	5	localIOException4	java.io.IOException
    //   1168	24	5	localObject4	Object
    //   1194	13	5	localIOException5	java.io.IOException
    //   61	1105	6	localObject5	Object
    //   1217	1	6	localObject6	Object
    //   1242	1	6	localObject7	Object
    //   180	211	7	localCanvas	android.graphics.Canvas
    //   829	154	7	localException2	java.lang.Exception
    //   988	80	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1222	1	7	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1227	1	7	localException3	java.lang.Exception
    //   368	113	8	localFile	java.io.File
    //   169	868	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   380	386	612	java/io/IOException
    //   0	45	622	java/lang/Exception
    //   45	297	622	java/lang/Exception
    //   297	311	622	java/lang/Exception
    //   311	376	622	java/lang/Exception
    //   380	386	622	java/lang/Exception
    //   431	452	622	java/lang/Exception
    //   460	465	622	java/lang/Exception
    //   472	533	622	java/lang/Exception
    //   537	575	622	java/lang/Exception
    //   575	590	622	java/lang/Exception
    //   614	619	622	java/lang/Exception
    //   716	734	622	java/lang/Exception
    //   919	940	622	java/lang/Exception
    //   945	950	622	java/lang/Exception
    //   957	975	622	java/lang/Exception
    //   1075	1096	622	java/lang/Exception
    //   1101	1106	622	java/lang/Exception
    //   1113	1131	622	java/lang/Exception
    //   1134	1155	622	java/lang/Exception
    //   1160	1165	622	java/lang/Exception
    //   1165	1168	622	java/lang/Exception
    //   1196	1214	622	java/lang/Exception
    //   460	465	711	java/io/IOException
    //   0	45	740	java/lang/OutOfMemoryError
    //   45	297	740	java/lang/OutOfMemoryError
    //   297	311	740	java/lang/OutOfMemoryError
    //   311	376	740	java/lang/OutOfMemoryError
    //   380	386	740	java/lang/OutOfMemoryError
    //   431	452	740	java/lang/OutOfMemoryError
    //   460	465	740	java/lang/OutOfMemoryError
    //   472	533	740	java/lang/OutOfMemoryError
    //   537	575	740	java/lang/OutOfMemoryError
    //   575	590	740	java/lang/OutOfMemoryError
    //   614	619	740	java/lang/OutOfMemoryError
    //   716	734	740	java/lang/OutOfMemoryError
    //   919	940	740	java/lang/OutOfMemoryError
    //   945	950	740	java/lang/OutOfMemoryError
    //   957	975	740	java/lang/OutOfMemoryError
    //   1075	1096	740	java/lang/OutOfMemoryError
    //   1101	1106	740	java/lang/OutOfMemoryError
    //   1113	1131	740	java/lang/OutOfMemoryError
    //   1134	1155	740	java/lang/OutOfMemoryError
    //   1160	1165	740	java/lang/OutOfMemoryError
    //   1165	1168	740	java/lang/OutOfMemoryError
    //   1196	1214	740	java/lang/OutOfMemoryError
    //   392	413	829	java/lang/Exception
    //   945	950	955	java/io/IOException
    //   392	413	980	java/lang/OutOfMemoryError
    //   1101	1106	1111	java/io/IOException
    //   0	45	1168	finally
    //   45	297	1168	finally
    //   297	311	1168	finally
    //   311	376	1168	finally
    //   380	386	1168	finally
    //   431	452	1168	finally
    //   460	465	1168	finally
    //   472	533	1168	finally
    //   537	575	1168	finally
    //   575	590	1168	finally
    //   614	619	1168	finally
    //   624	689	1168	finally
    //   716	734	1168	finally
    //   742	807	1168	finally
    //   919	940	1168	finally
    //   945	950	1168	finally
    //   957	975	1168	finally
    //   1075	1096	1168	finally
    //   1101	1106	1168	finally
    //   1113	1131	1168	finally
    //   1134	1155	1168	finally
    //   1160	1165	1168	finally
    //   1165	1168	1168	finally
    //   1196	1214	1168	finally
    //   1160	1165	1194	java/io/IOException
    //   417	431	1217	finally
    //   838	854	1217	finally
    //   858	876	1217	finally
    //   880	893	1217	finally
    //   897	903	1217	finally
    //   907	919	1217	finally
    //   417	431	1222	java/lang/OutOfMemoryError
    //   417	431	1227	java/lang/Exception
    //   392	413	1242	finally
    //   994	1010	1242	finally
    //   1014	1032	1242	finally
    //   1036	1049	1242	finally
    //   1053	1059	1242	finally
    //   1063	1075	1242	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */