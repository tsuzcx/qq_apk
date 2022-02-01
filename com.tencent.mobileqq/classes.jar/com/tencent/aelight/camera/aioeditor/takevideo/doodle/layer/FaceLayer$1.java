package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import java.util.ArrayList;

class FaceLayer$1
  implements Runnable
{
  FaceLayer$1(FaceLayer paramFaceLayer, ArrayList paramArrayList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 27
    //   2: astore 6
    //   4: iconst_0
    //   5: istore_1
    //   6: iload_1
    //   7: aload_0
    //   8: getfield 16	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:a	Ljava/util/ArrayList;
    //   11: invokevirtual 33	java/util/ArrayList:size	()I
    //   14: if_icmpge +755 -> 769
    //   17: aload_0
    //   18: getfield 16	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:a	Ljava/util/ArrayList;
    //   21: iload_1
    //   22: invokevirtual 37	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   25: checkcast 39	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData
    //   28: astore 9
    //   30: aload 9
    //   32: getfield 43	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   35: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +6 -> 44
    //   41: goto +677 -> 718
    //   44: aload 9
    //   46: getfield 53	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   49: istore_2
    //   50: aconst_null
    //   51: astore 8
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne +77 -> 132
    //   58: getstatic 59	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   61: invokevirtual 63	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   64: aload 9
    //   66: getfield 43	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: ldc 65
    //   71: getstatic 70	com/tencent/mobileqq/urldrawable/URLDrawableHelperConstants:a	Landroid/graphics/drawable/Drawable;
    //   74: iconst_1
    //   75: newarray int
    //   77: dup
    //   78: iconst_0
    //   79: bipush 13
    //   81: iastore
    //   82: ldc 65
    //   84: aconst_null
    //   85: invokestatic 76	com/tencent/mobileqq/vas/VasApngUtil:getApngDrawable	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;[ILjava/lang/String;Landroid/os/Bundle;)Lcom/tencent/image/URLDrawable;
    //   88: astore 5
    //   90: aload 8
    //   92: astore 4
    //   94: aload 5
    //   96: ifnull +33 -> 129
    //   99: aload 5
    //   101: invokevirtual 81	com/tencent/image/URLDrawable:getStatus	()I
    //   104: iconst_1
    //   105: if_icmpeq +8 -> 113
    //   108: aload 5
    //   110: invokevirtual 84	com/tencent/image/URLDrawable:restartDownload	()V
    //   113: aload 5
    //   115: aload_0
    //   116: getfield 14	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:this$0	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;
    //   119: invokestatic 89	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;)Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView;
    //   122: invokevirtual 95	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   125: aload 5
    //   127: astore 4
    //   129: goto +221 -> 350
    //   132: new 97	java/io/BufferedInputStream
    //   135: dup
    //   136: new 99	java/io/FileInputStream
    //   139: dup
    //   140: aload 9
    //   142: getfield 43	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   145: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   148: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   151: astore 5
    //   153: aload 5
    //   155: astore 4
    //   157: new 107	android/graphics/drawable/BitmapDrawable
    //   160: dup
    //   161: aconst_null
    //   162: aload 5
    //   164: aconst_null
    //   165: aconst_null
    //   166: invokestatic 113	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   169: invokespecial 116	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   172: astore 7
    //   174: aload 5
    //   176: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   179: aload 7
    //   181: astore 4
    //   183: goto +167 -> 350
    //   186: astore 4
    //   188: goto +17 -> 205
    //   191: astore 4
    //   193: aload 4
    //   195: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   198: aload 7
    //   200: astore 4
    //   202: goto +148 -> 350
    //   205: aload 4
    //   207: athrow
    //   208: astore 7
    //   210: goto +21 -> 231
    //   213: astore 7
    //   215: goto +78 -> 293
    //   218: astore 4
    //   220: aconst_null
    //   221: astore 6
    //   223: goto +512 -> 735
    //   226: astore 7
    //   228: aconst_null
    //   229: astore 5
    //   231: aload 5
    //   233: astore 4
    //   235: getstatic 124	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   238: aload 6
    //   240: aload 7
    //   242: invokestatic 129	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: aload 8
    //   247: astore 4
    //   249: aload 5
    //   251: ifnull -122 -> 129
    //   254: aload 5
    //   256: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   259: aload 8
    //   261: astore 4
    //   263: goto -134 -> 129
    //   266: astore 4
    //   268: goto +17 -> 285
    //   271: astore 4
    //   273: aload 4
    //   275: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   278: aload 8
    //   280: astore 4
    //   282: goto -153 -> 129
    //   285: aload 4
    //   287: athrow
    //   288: astore 7
    //   290: aconst_null
    //   291: astore 5
    //   293: aload 5
    //   295: astore 4
    //   297: getstatic 124	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   300: aload 6
    //   302: aload 7
    //   304: invokestatic 129	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload 8
    //   309: astore 4
    //   311: aload 5
    //   313: ifnull -184 -> 129
    //   316: aload 5
    //   318: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   321: aload 8
    //   323: astore 4
    //   325: goto -196 -> 129
    //   328: astore 4
    //   330: goto +17 -> 347
    //   333: astore 4
    //   335: aload 4
    //   337: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   340: aload 8
    //   342: astore 4
    //   344: goto -215 -> 129
    //   347: aload 4
    //   349: athrow
    //   350: aload 4
    //   352: ifnull -311 -> 41
    //   355: aload 9
    //   357: getfield 132	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   360: getfield 138	android/graphics/RectF:left	F
    //   363: f2i
    //   364: istore_2
    //   365: aload 9
    //   367: getfield 132	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   370: getfield 141	android/graphics/RectF:right	F
    //   373: f2i
    //   374: istore_3
    //   375: aload 4
    //   377: iload_2
    //   378: aload 9
    //   380: getfield 132	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   383: getfield 144	android/graphics/RectF:top	F
    //   386: f2i
    //   387: iload_3
    //   388: aload 9
    //   390: getfield 132	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   393: getfield 147	android/graphics/RectF:bottom	F
    //   396: f2i
    //   397: invokevirtual 151	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   400: aload 9
    //   402: getfield 154	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   405: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifeq +108 -> 516
    //   411: getstatic 124	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   414: ldc 156
    //   416: invokestatic 160	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: new 162	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$LayerParams
    //   422: dup
    //   423: aload 9
    //   425: getfield 165	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   428: getfield 170	android/graphics/PointF:x	F
    //   431: aload 9
    //   433: getfield 165	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   436: getfield 173	android/graphics/PointF:y	F
    //   439: aload 9
    //   441: getfield 175	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_Float	F
    //   444: aload 9
    //   446: getfield 177	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_b_of_type_Float	F
    //   449: aload 9
    //   451: getfield 179	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_c_of_type_Float	F
    //   454: aload 9
    //   456: getfield 181	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_d_of_type_Float	F
    //   459: aload 9
    //   461: getfield 184	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:e	F
    //   464: f2i
    //   465: aload 9
    //   467: getfield 186	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_f_of_type_Float	F
    //   470: f2i
    //   471: invokespecial 189	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$LayerParams:<init>	(FFFFFFII)V
    //   474: astore 5
    //   476: new 191	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceItem
    //   479: dup
    //   480: aload_0
    //   481: getfield 14	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:this$0	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;
    //   484: aload 4
    //   486: aload 5
    //   488: aload 9
    //   490: getfield 192	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   493: aload 9
    //   495: getfield 194	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   498: aload 9
    //   500: getfield 43	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   503: aload 9
    //   505: getfield 53	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   508: invokespecial 197	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceItem:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;Landroid/graphics/drawable/Drawable;Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$LayerParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   511: astore 4
    //   513: goto +163 -> 676
    //   516: getstatic 124	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   519: astore 5
    //   521: new 199	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   528: astore 7
    //   530: aload 7
    //   532: ldc 202
    //   534: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 7
    //   540: aload 9
    //   542: getfield 154	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   545: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 5
    //   551: aload 7
    //   553: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 160	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: new 162	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$LayerParams
    //   562: dup
    //   563: aload 9
    //   565: getfield 165	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   568: getfield 170	android/graphics/PointF:x	F
    //   571: aload 9
    //   573: getfield 165	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   576: getfield 173	android/graphics/PointF:y	F
    //   579: aload 9
    //   581: getfield 175	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_Float	F
    //   584: aload 9
    //   586: getfield 177	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_b_of_type_Float	F
    //   589: aload 9
    //   591: getfield 179	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_c_of_type_Float	F
    //   594: aload 9
    //   596: getfield 181	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_d_of_type_Float	F
    //   599: aload 9
    //   601: getfield 184	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:e	F
    //   604: f2i
    //   605: aload 9
    //   607: getfield 186	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_f_of_type_Float	F
    //   610: f2i
    //   611: aload 9
    //   613: getfield 154	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   616: aload 9
    //   618: getfield 213	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:g	I
    //   621: aload 9
    //   623: getfield 215	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_f_of_type_Int	I
    //   626: invokespecial 218	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$LayerParams:<init>	(FFFFFFIILjava/lang/String;II)V
    //   629: astore 5
    //   631: new 220	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceAndTextItem
    //   634: dup
    //   635: aload_0
    //   636: getfield 14	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:this$0	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;
    //   639: aload 4
    //   641: aload 5
    //   643: aload 9
    //   645: getfield 192	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   648: aload 9
    //   650: getfield 194	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   653: aload 9
    //   655: getfield 43	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   658: aload 9
    //   660: getfield 53	com/tencent/aelight/camera/aioeditor/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   663: invokespecial 221	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceAndTextItem:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;Landroid/graphics/drawable/Drawable;Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$LayerParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   666: astore 4
    //   668: aload 4
    //   670: checkcast 220	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceAndTextItem
    //   673: invokevirtual 223	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceAndTextItem:a	()V
    //   676: aload 4
    //   678: iconst_0
    //   679: putfield 225	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceItem:e	I
    //   682: aload 4
    //   684: iconst_1
    //   685: putfield 226	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceItem:jdField_f_of_type_Int	I
    //   688: aload 4
    //   690: getfield 229	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$FaceItem:a	Landroid/graphics/Matrix;
    //   693: aload_0
    //   694: getfield 14	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:this$0	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;
    //   697: invokestatic 232	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;)Landroid/graphics/Matrix;
    //   700: invokevirtual 238	android/graphics/Matrix:set	(Landroid/graphics/Matrix;)V
    //   703: aload_0
    //   704: getfield 14	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:this$0	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;
    //   707: getfield 241	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   710: aload 4
    //   712: invokeinterface 247 2 0
    //   717: pop
    //   718: iload_1
    //   719: iconst_1
    //   720: iadd
    //   721: istore_1
    //   722: goto -716 -> 6
    //   725: astore 5
    //   727: aload 4
    //   729: astore 6
    //   731: aload 5
    //   733: astore 4
    //   735: aload 6
    //   737: ifnull +29 -> 766
    //   740: aload 6
    //   742: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   745: goto +21 -> 766
    //   748: astore 4
    //   750: goto +13 -> 763
    //   753: astore 5
    //   755: aload 5
    //   757: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   760: goto +6 -> 766
    //   763: aload 4
    //   765: athrow
    //   766: aload 4
    //   768: athrow
    //   769: aload_0
    //   770: getfield 14	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer$1:this$0	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;
    //   773: invokestatic 249	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer:b	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/FaceLayer;)Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView;
    //   776: invokevirtual 254	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView:postInvalidate	()V
    //   779: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	this	1
    //   5	717	1	i	int
    //   49	329	2	j	int
    //   374	14	3	k	int
    //   92	90	4	localObject1	Object
    //   186	1	4	localObject2	Object
    //   191	3	4	localIOException1	java.io.IOException
    //   200	6	4	localObject3	Object
    //   218	1	4	localObject4	Object
    //   233	29	4	localObject5	Object
    //   266	1	4	localObject6	Object
    //   271	3	4	localIOException2	java.io.IOException
    //   280	44	4	localObject7	Object
    //   328	1	4	localObject8	Object
    //   333	3	4	localIOException3	java.io.IOException
    //   342	392	4	localObject9	Object
    //   748	19	4	localObject10	Object
    //   88	554	5	localObject11	Object
    //   725	7	5	localObject12	Object
    //   753	3	5	localIOException4	java.io.IOException
    //   2	739	6	localObject13	Object
    //   172	27	7	localBitmapDrawable	android.graphics.drawable.BitmapDrawable
    //   208	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   213	1	7	localIOException5	java.io.IOException
    //   226	15	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   288	15	7	localIOException6	java.io.IOException
    //   528	24	7	localStringBuilder	java.lang.StringBuilder
    //   51	290	8	localObject14	Object
    //   28	631	9	localPasterParcelData	com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData
    // Exception table:
    //   from	to	target	type
    //   174	179	186	finally
    //   193	198	186	finally
    //   174	179	191	java/io/IOException
    //   157	174	208	java/lang/OutOfMemoryError
    //   157	174	213	java/io/IOException
    //   132	153	218	finally
    //   132	153	226	java/lang/OutOfMemoryError
    //   254	259	266	finally
    //   273	278	266	finally
    //   254	259	271	java/io/IOException
    //   132	153	288	java/io/IOException
    //   316	321	328	finally
    //   335	340	328	finally
    //   316	321	333	java/io/IOException
    //   157	174	725	finally
    //   235	245	725	finally
    //   297	307	725	finally
    //   740	745	748	finally
    //   755	760	748	finally
    //   740	745	753	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.1
 * JD-Core Version:    0.7.0.1
 */