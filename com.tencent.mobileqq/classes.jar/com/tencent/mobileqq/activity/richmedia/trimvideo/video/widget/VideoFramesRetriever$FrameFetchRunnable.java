package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

class VideoFramesRetriever$FrameFetchRunnable
  implements Runnable
{
  VideoFramesRetriever$FrameFetchRunnable(VideoFramesRetriever paramVideoFramesRetriever) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   4: invokestatic 25	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Landroid/media/MediaMetadataRetriever;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   15: invokestatic 28	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Z
    //   18: ifne +393 -> 411
    //   21: aload_0
    //   22: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   25: invokestatic 31	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Ljava/util/concurrent/BlockingQueue;
    //   28: ifnull +383 -> 411
    //   31: aload_0
    //   32: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   35: invokestatic 31	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Ljava/util/concurrent/BlockingQueue;
    //   38: invokeinterface 37 1 0
    //   43: checkcast 39	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchTask
    //   46: astore 7
    //   48: aload_0
    //   49: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   52: invokestatic 28	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Z
    //   55: ifeq +4 -> 59
    //   58: return
    //   59: invokestatic 45	java/lang/System:currentTimeMillis	()J
    //   62: lstore 4
    //   64: aload_0
    //   65: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   68: invokestatic 25	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Landroid/media/MediaMetadataRetriever;
    //   71: aload 7
    //   73: getfield 48	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchTask:jdField_a_of_type_Int	I
    //   76: aload 7
    //   78: getfield 51	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchTask:b	I
    //   81: iadd
    //   82: iconst_2
    //   83: idiv
    //   84: i2l
    //   85: ldc2_w 52
    //   88: lmul
    //   89: invokevirtual 59	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   92: astore 8
    //   94: aload 8
    //   96: ifnonnull +20 -> 116
    //   99: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -91 -> 11
    //   105: ldc 67
    //   107: iconst_2
    //   108: ldc 69
    //   110: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: goto -102 -> 11
    //   116: aload 8
    //   118: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   121: aload 8
    //   123: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   126: if_icmple +295 -> 421
    //   129: iconst_1
    //   130: istore_2
    //   131: goto +3 -> 134
    //   134: iload_2
    //   135: ifeq +25 -> 160
    //   138: aload_0
    //   139: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   142: invokestatic 85	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)F
    //   145: fstore_1
    //   146: aload 8
    //   148: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   151: istore_3
    //   152: fload_1
    //   153: iload_3
    //   154: i2f
    //   155: fdiv
    //   156: fstore_1
    //   157: goto +20 -> 177
    //   160: aload_0
    //   161: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   164: invokestatic 85	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)F
    //   167: fstore_1
    //   168: aload 8
    //   170: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   173: istore_3
    //   174: goto -22 -> 152
    //   177: new 87	android/graphics/Matrix
    //   180: dup
    //   181: invokespecial 88	android/graphics/Matrix:<init>	()V
    //   184: astore 6
    //   186: aload 6
    //   188: fload_1
    //   189: fload_1
    //   190: invokevirtual 92	android/graphics/Matrix:postScale	(FF)Z
    //   193: pop
    //   194: iload_2
    //   195: ifeq +40 -> 235
    //   198: aload 8
    //   200: aload 8
    //   202: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   205: aload 8
    //   207: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   210: isub
    //   211: iconst_2
    //   212: idiv
    //   213: iconst_0
    //   214: aload 8
    //   216: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   219: aload 8
    //   221: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   224: aload 6
    //   226: iconst_1
    //   227: invokestatic 96	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   230: astore 6
    //   232: goto +37 -> 269
    //   235: aload 8
    //   237: iconst_0
    //   238: aload 8
    //   240: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   243: aload 8
    //   245: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   248: isub
    //   249: iconst_2
    //   250: idiv
    //   251: aload 8
    //   253: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   256: aload 8
    //   258: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   261: aload 6
    //   263: iconst_1
    //   264: invokestatic 96	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   267: astore 6
    //   269: aload 8
    //   271: invokevirtual 99	android/graphics/Bitmap:recycle	()V
    //   274: new 101	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame
    //   277: dup
    //   278: invokespecial 102	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:<init>	()V
    //   281: astore 8
    //   283: aload 8
    //   285: aload 6
    //   287: getstatic 108	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   290: iconst_1
    //   291: invokevirtual 112	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   294: putfield 115	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   297: aload 8
    //   299: aload 7
    //   301: getfield 48	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchTask:jdField_a_of_type_Int	I
    //   304: aload_0
    //   305: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   308: invokestatic 118	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:b	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)I
    //   311: idiv
    //   312: putfield 119	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:jdField_a_of_type_Int	I
    //   315: aload 6
    //   317: invokevirtual 99	android/graphics/Bitmap:recycle	()V
    //   320: new 121	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   327: astore 6
    //   329: aload 6
    //   331: ldc 124
    //   333: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 6
    //   339: invokestatic 45	java/lang/System:currentTimeMillis	()J
    //   342: lload 4
    //   344: lsub
    //   345: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: ldc 67
    //   351: iconst_1
    //   352: aload 6
    //   354: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 138	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload_0
    //   361: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   364: invokestatic 141	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter;
    //   367: aload 8
    //   369: invokevirtual 146	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame;)V
    //   372: aload_0
    //   373: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;
    //   376: invokestatic 149	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever;)Ljava/util/concurrent/ConcurrentHashMap;
    //   379: aload 7
    //   381: getfield 48	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesRetriever$FrameFetchTask:jdField_a_of_type_Int	I
    //   384: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: invokevirtual 161	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   390: pop
    //   391: goto -380 -> 11
    //   394: astore 6
    //   396: goto +16 -> 412
    //   399: astore 6
    //   401: ldc 67
    //   403: iconst_2
    //   404: ldc 163
    //   406: aload 6
    //   408: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   411: return
    //   412: goto +6 -> 418
    //   415: aload 6
    //   417: athrow
    //   418: goto -3 -> 415
    //   421: iconst_0
    //   422: istore_2
    //   423: goto -289 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	FrameFetchRunnable
    //   145	45	1	f	float
    //   130	293	2	i	int
    //   151	23	3	j	int
    //   62	281	4	l	long
    //   184	169	6	localObject1	Object
    //   394	1	6	localObject2	Object
    //   399	17	6	localThrowable	java.lang.Throwable
    //   46	334	7	localFrameFetchTask	VideoFramesRetriever.FrameFetchTask
    //   92	276	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	58	394	finally
    //   59	94	394	finally
    //   99	113	394	finally
    //   116	129	394	finally
    //   138	152	394	finally
    //   152	157	394	finally
    //   160	174	394	finally
    //   177	194	394	finally
    //   198	232	394	finally
    //   235	269	394	finally
    //   269	391	394	finally
    //   401	411	394	finally
    //   11	58	399	java/lang/Throwable
    //   59	94	399	java/lang/Throwable
    //   99	113	399	java/lang/Throwable
    //   116	129	399	java/lang/Throwable
    //   138	152	399	java/lang/Throwable
    //   152	157	399	java/lang/Throwable
    //   160	174	399	java/lang/Throwable
    //   177	194	399	java/lang/Throwable
    //   198	232	399	java/lang/Throwable
    //   235	269	399	java/lang/Throwable
    //   269	391	399	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever.FrameFetchRunnable
 * JD-Core Version:    0.7.0.1
 */