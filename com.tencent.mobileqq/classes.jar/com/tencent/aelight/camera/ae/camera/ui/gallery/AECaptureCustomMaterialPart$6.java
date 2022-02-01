package com.tencent.aelight.camera.ae.camera.ui.gallery;

class AECaptureCustomMaterialPart$6
  implements Runnable
{
  AECaptureCustomMaterialPart$6(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   4: invokestatic 51	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:i	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   7: ifle +435 -> 442
    //   10: aload_0
    //   11: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   14: invokestatic 54	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:j	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   17: ifgt +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   25: astore 6
    //   27: aload 6
    //   29: aload_0
    //   30: getfield 16	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:a	Ljava/lang/String;
    //   33: aload 6
    //   35: invokestatic 54	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:j	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   38: aload_0
    //   39: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   42: invokestatic 51	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:i	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   45: invokestatic 57	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   48: astore 7
    //   50: aload 7
    //   52: ifnonnull +4 -> 56
    //   55: return
    //   56: iconst_0
    //   57: istore_1
    //   58: iconst_0
    //   59: istore_2
    //   60: ldc 59
    //   62: ldc 61
    //   64: invokestatic 66	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 16	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:a	Ljava/lang/String;
    //   71: invokestatic 72	com/tencent/mobileqq/utils/BaseImageUtil:h	(Ljava/lang/String;)I
    //   74: istore_3
    //   75: aload 7
    //   77: astore 6
    //   79: iload_3
    //   80: ifeq +94 -> 174
    //   83: new 74	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   90: astore 6
    //   92: aload 6
    //   94: ldc 77
    //   96: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 6
    //   102: iload_3
    //   103: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: ldc 59
    //   109: aload 6
    //   111: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 66	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: new 89	android/graphics/Matrix
    //   120: dup
    //   121: invokespecial 90	android/graphics/Matrix:<init>	()V
    //   124: astore 6
    //   126: aload 7
    //   128: invokevirtual 96	android/graphics/Bitmap:getWidth	()I
    //   131: istore 4
    //   133: aload 7
    //   135: invokevirtual 99	android/graphics/Bitmap:getHeight	()I
    //   138: istore 5
    //   140: aload 6
    //   142: iload_3
    //   143: i2f
    //   144: iload 4
    //   146: i2f
    //   147: fconst_2
    //   148: fdiv
    //   149: iload 5
    //   151: i2f
    //   152: fconst_2
    //   153: fdiv
    //   154: invokevirtual 103	android/graphics/Matrix:postRotate	(FFF)Z
    //   157: pop
    //   158: aload 7
    //   160: iconst_0
    //   161: iconst_0
    //   162: iload 4
    //   164: iload 5
    //   166: aload 6
    //   168: iconst_1
    //   169: invokestatic 107	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   172: astore 6
    //   174: aload 6
    //   176: astore 8
    //   178: aload 6
    //   180: invokevirtual 96	android/graphics/Bitmap:getWidth	()I
    //   183: aload 6
    //   185: invokevirtual 99	android/graphics/Bitmap:getHeight	()I
    //   188: aload_0
    //   189: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   192: invokestatic 54	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:j	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   195: aload_0
    //   196: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   199: invokestatic 51	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:i	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   202: invokestatic 110	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	(IIII)Z
    //   205: ifeq +51 -> 256
    //   208: ldc 59
    //   210: ldc 112
    //   212: invokestatic 66	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   219: invokestatic 54	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:j	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   222: aload_0
    //   223: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   226: invokestatic 51	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:i	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)I
    //   229: getstatic 118	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   232: invokestatic 121	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   235: astore 7
    //   237: aload 7
    //   239: ldc 123
    //   241: invokestatic 128	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   244: invokevirtual 132	android/graphics/Bitmap:eraseColor	(I)V
    //   247: aload 7
    //   249: aload 6
    //   251: invokestatic 137	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   254: astore 8
    //   256: new 139	java/io/FileOutputStream
    //   259: dup
    //   260: invokestatic 35	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	()Ljava/lang/String;
    //   263: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   266: astore 6
    //   268: aload 6
    //   270: astore 7
    //   272: aload 8
    //   274: getstatic 147	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   277: bipush 100
    //   279: aload 6
    //   281: invokevirtual 151	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   284: pop
    //   285: aload 6
    //   287: astore 7
    //   289: new 74	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   296: astore 8
    //   298: aload 6
    //   300: astore 7
    //   302: aload 8
    //   304: ldc 153
    //   306: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 6
    //   312: astore 7
    //   314: aload 8
    //   316: invokestatic 35	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:a	()Ljava/lang/String;
    //   319: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 6
    //   325: astore 7
    //   327: ldc 59
    //   329: aload 8
    //   331: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 66	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: iconst_1
    //   338: istore_1
    //   339: aload 6
    //   341: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   344: goto +60 -> 404
    //   347: astore 8
    //   349: goto +16 -> 365
    //   352: astore 6
    //   354: aconst_null
    //   355: astore 7
    //   357: goto +72 -> 429
    //   360: astore 8
    //   362: aconst_null
    //   363: astore 6
    //   365: aload 6
    //   367: astore 7
    //   369: ldc 59
    //   371: aload 8
    //   373: invokestatic 159	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   376: aload 6
    //   378: astore 7
    //   380: aload_0
    //   381: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   384: invokestatic 26	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:k	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;
    //   387: invokevirtual 32	com/tencent/aelight/camera/ae/AEPituCameraUnit:am	()Lcom/tencent/aelight/camera/ae/camera/ui/AECaptureController;
    //   390: aconst_null
    //   391: invokevirtual 40	com/tencent/aelight/camera/ae/camera/ui/AECaptureController:a	(Ljava/lang/String;)V
    //   394: aload 6
    //   396: ifnull +8 -> 404
    //   399: iload_2
    //   400: istore_1
    //   401: goto -62 -> 339
    //   404: iload_1
    //   405: ifeq +21 -> 426
    //   408: aload_0
    //   409: getfield 14	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6:this$0	Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;
    //   412: invokestatic 26	com/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart:k	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart;)Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;
    //   415: new 161	com/tencent/aelight/camera/ae/camera/ui/gallery/-$$Lambda$AECaptureCustomMaterialPart$6$z1xikecvr3lkFDAESyjBZtM5DiM
    //   418: dup
    //   419: aload_0
    //   420: invokespecial 163	com/tencent/aelight/camera/ae/camera/ui/gallery/-$$Lambda$AECaptureCustomMaterialPart$6$z1xikecvr3lkFDAESyjBZtM5DiM:<init>	(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/AECaptureCustomMaterialPart$6;)V
    //   423: invokevirtual 166	com/tencent/aelight/camera/ae/AEPituCameraUnit:a	(Ljava/lang/Runnable;)V
    //   426: return
    //   427: astore 6
    //   429: aload 7
    //   431: ifnull +8 -> 439
    //   434: aload 7
    //   436: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   439: aload 6
    //   441: athrow
    //   442: return
    //   443: astore 6
    //   445: goto -41 -> 404
    //   448: astore 7
    //   450: goto -11 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	this	6
    //   57	348	1	i	int
    //   59	341	2	j	int
    //   74	69	3	k	int
    //   131	32	4	m	int
    //   138	27	5	n	int
    //   25	315	6	localObject1	Object
    //   352	1	6	localObject2	Object
    //   363	32	6	localObject3	Object
    //   427	13	6	localObject4	Object
    //   443	1	6	localIOException1	java.io.IOException
    //   48	387	7	localObject5	Object
    //   448	1	7	localIOException2	java.io.IOException
    //   176	154	8	localObject6	Object
    //   347	1	8	localIOException3	java.io.IOException
    //   360	12	8	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   272	285	347	java/io/IOException
    //   289	298	347	java/io/IOException
    //   302	310	347	java/io/IOException
    //   314	323	347	java/io/IOException
    //   327	337	347	java/io/IOException
    //   256	268	352	finally
    //   256	268	360	java/io/IOException
    //   272	285	427	finally
    //   289	298	427	finally
    //   302	310	427	finally
    //   314	323	427	finally
    //   327	337	427	finally
    //   369	376	427	finally
    //   380	394	427	finally
    //   339	344	443	java/io/IOException
    //   434	439	448	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.6
 * JD-Core Version:    0.7.0.1
 */