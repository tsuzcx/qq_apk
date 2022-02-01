package com.tencent.aelight.camera.ae.camera.ui.gallery;

class AECaptureCustomMaterialPart$3
  implements Runnable
{
  AECaptureCustomMaterialPart$3(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   4: invokestatic 28	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   7: ifle +363 -> 370
    //   10: aload_0
    //   11: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   14: invokestatic 31	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:b	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   17: ifgt +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   25: astore 4
    //   27: aload 4
    //   29: aload_0
    //   30: getfield 16	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:a	Ljava/lang/String;
    //   33: aload 4
    //   35: invokestatic 31	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:b	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   38: aload_0
    //   39: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   42: invokestatic 28	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   45: invokestatic 34	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnonnull +4 -> 56
    //   55: return
    //   56: ldc 36
    //   58: ldc 38
    //   60: invokestatic 43	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 16	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:a	Ljava/lang/String;
    //   67: invokestatic 49	com/tencent/mobileqq/utils/BaseImageUtil:c	(Ljava/lang/String;)I
    //   70: istore_1
    //   71: aload 5
    //   73: astore 4
    //   75: iload_1
    //   76: ifeq +88 -> 164
    //   79: new 51	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   86: astore 4
    //   88: aload 4
    //   90: ldc 54
    //   92: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 4
    //   98: iload_1
    //   99: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc 36
    //   105: aload 4
    //   107: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 43	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: new 67	android/graphics/Matrix
    //   116: dup
    //   117: invokespecial 68	android/graphics/Matrix:<init>	()V
    //   120: astore 4
    //   122: aload 5
    //   124: invokevirtual 74	android/graphics/Bitmap:getWidth	()I
    //   127: istore_2
    //   128: aload 5
    //   130: invokevirtual 77	android/graphics/Bitmap:getHeight	()I
    //   133: istore_3
    //   134: aload 4
    //   136: iload_1
    //   137: i2f
    //   138: iload_2
    //   139: i2f
    //   140: fconst_2
    //   141: fdiv
    //   142: iload_3
    //   143: i2f
    //   144: fconst_2
    //   145: fdiv
    //   146: invokevirtual 81	android/graphics/Matrix:postRotate	(FFF)Z
    //   149: pop
    //   150: aload 5
    //   152: iconst_0
    //   153: iconst_0
    //   154: iload_2
    //   155: iload_3
    //   156: aload 4
    //   158: iconst_1
    //   159: invokestatic 85	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   162: astore 4
    //   164: aload 4
    //   166: astore 6
    //   168: aload 4
    //   170: invokevirtual 74	android/graphics/Bitmap:getWidth	()I
    //   173: aload 4
    //   175: invokevirtual 77	android/graphics/Bitmap:getHeight	()I
    //   178: aload_0
    //   179: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   182: invokestatic 31	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:b	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   185: aload_0
    //   186: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   189: invokestatic 28	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   192: invokestatic 88	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(IIII)Z
    //   195: ifeq +51 -> 246
    //   198: ldc 36
    //   200: ldc 90
    //   202: invokestatic 43	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_0
    //   206: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   209: invokestatic 31	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:b	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   212: aload_0
    //   213: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   216: invokestatic 28	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   219: getstatic 96	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   222: invokestatic 99	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   225: astore 5
    //   227: aload 5
    //   229: ldc 101
    //   231: invokestatic 106	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   234: invokevirtual 110	android/graphics/Bitmap:eraseColor	(I)V
    //   237: aload 5
    //   239: aload 4
    //   241: invokestatic 115	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   244: astore 6
    //   246: new 117	java/io/FileOutputStream
    //   249: dup
    //   250: invokestatic 119	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	()Ljava/lang/String;
    //   253: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   256: astore 4
    //   258: aload 4
    //   260: astore 5
    //   262: aload 6
    //   264: getstatic 128	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   267: bipush 100
    //   269: aload 4
    //   271: invokevirtual 132	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   274: pop
    //   275: aload 4
    //   277: astore 5
    //   279: aload_0
    //   280: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   283: invokestatic 135	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;
    //   286: invokevirtual 140	com/tencent/aelight/camera/ae/AEPituCameraUnit:a	()Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;
    //   289: invokestatic 119	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	()Ljava/lang/String;
    //   292: invokevirtual 144	com/tencent/aelight/camera/ae/camera/ui/AECaptureController:a	(Ljava/lang/String;)V
    //   295: aload 4
    //   297: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   300: return
    //   301: astore 6
    //   303: goto +16 -> 319
    //   306: astore 4
    //   308: aconst_null
    //   309: astore 5
    //   311: goto +46 -> 357
    //   314: astore 6
    //   316: aconst_null
    //   317: astore 4
    //   319: aload 4
    //   321: astore 5
    //   323: aload 6
    //   325: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   328: aload 4
    //   330: astore 5
    //   332: aload_0
    //   333: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$3:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   336: invokestatic 135	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;
    //   339: invokevirtual 140	com/tencent/aelight/camera/ae/AEPituCameraUnit:a	()Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;
    //   342: aconst_null
    //   343: invokevirtual 144	com/tencent/aelight/camera/ae/camera/ui/AECaptureController:a	(Ljava/lang/String;)V
    //   346: aload 4
    //   348: ifnull +6 -> 354
    //   351: goto -56 -> 295
    //   354: return
    //   355: astore 4
    //   357: aload 5
    //   359: ifnull +8 -> 367
    //   362: aload 5
    //   364: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   367: aload 4
    //   369: athrow
    //   370: return
    //   371: astore 4
    //   373: return
    //   374: astore 5
    //   376: goto -9 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	3
    //   70	67	1	i	int
    //   127	28	2	j	int
    //   133	23	3	k	int
    //   25	271	4	localObject1	Object
    //   306	1	4	localObject2	Object
    //   317	30	4	localObject3	Object
    //   355	13	4	localObject4	Object
    //   371	1	4	localIOException1	java.io.IOException
    //   48	315	5	localObject5	Object
    //   374	1	5	localIOException2	java.io.IOException
    //   166	97	6	localObject6	Object
    //   301	1	6	localIOException3	java.io.IOException
    //   314	10	6	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   262	275	301	java/io/IOException
    //   279	295	301	java/io/IOException
    //   246	258	306	finally
    //   246	258	314	java/io/IOException
    //   262	275	355	finally
    //   279	295	355	finally
    //   323	328	355	finally
    //   332	346	355	finally
    //   295	300	371	java/io/IOException
    //   362	367	374	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.3
 * JD-Core Version:    0.7.0.1
 */