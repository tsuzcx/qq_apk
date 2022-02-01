package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

class VideoFramesFetcher$FrameFetchRunnable
  implements Runnable
{
  VideoFramesFetcher$FrameFetchRunnable(VideoFramesFetcher paramVideoFramesFetcher) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/maxvideo/trim/TrimNative:isGetThumbnailReady	()Z
    //   3: ifne +50 -> 53
    //   6: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 32
    //   14: iconst_2
    //   15: ldc 34
    //   17: invokestatic 38	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aload_3
    //   22: getfield 44	alov:jdField_a_of_type_Int	I
    //   25: i2l
    //   26: aload_3
    //   27: getfield 47	alov:b	I
    //   30: i2l
    //   31: invokestatic 52	alog:b	(JJ)Landroid/graphics/Bitmap;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +69 -> 105
    //   39: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 32
    //   47: iconst_2
    //   48: ldc 54
    //   50: invokestatic 38	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   57: invokestatic 59	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   60: ifne +138 -> 198
    //   63: aload_0
    //   64: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   67: invokestatic 62	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   70: ifnull +128 -> 198
    //   73: aload_0
    //   74: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   77: invokestatic 62	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   80: invokeinterface 68 1 0
    //   85: checkcast 40	alov
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   93: invokestatic 59	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   96: istore_1
    //   97: iload_1
    //   98: ifeq -77 -> 21
    //   101: invokestatic 71	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   104: return
    //   105: new 73	alop
    //   108: dup
    //   109: invokespecial 74	alop:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: aload_2
    //   117: getstatic 80	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   120: iconst_1
    //   121: invokevirtual 86	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   124: putfield 89	alop:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   127: aload 4
    //   129: aload_3
    //   130: getfield 44	alov:jdField_a_of_type_Int	I
    //   133: aload_0
    //   134: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   137: invokestatic 92	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:b	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)I
    //   140: idiv
    //   141: putfield 93	alop:jdField_a_of_type_Int	I
    //   144: aload_2
    //   145: invokevirtual 96	android/graphics/Bitmap:recycle	()V
    //   148: aload_0
    //   149: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   152: invokestatic 99	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Lalok;
    //   155: aload 4
    //   157: invokevirtual 104	alok:a	(Lalop;)V
    //   160: aload_0
    //   161: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   164: invokestatic 107	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/ConcurrentHashMap;
    //   167: aload_3
    //   168: getfield 44	alov:jdField_a_of_type_Int	I
    //   171: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: goto -125 -> 53
    //   181: astore_2
    //   182: ldc 32
    //   184: iconst_2
    //   185: ldc 121
    //   187: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_2
    //   191: invokevirtual 127	java/lang/InterruptedException:printStackTrace	()V
    //   194: invokestatic 71	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   197: return
    //   198: invokestatic 71	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   201: return
    //   202: astore_2
    //   203: invokestatic 71	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   206: aload_2
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	FrameFetchRunnable
    //   96	2	1	bool	boolean
    //   34	111	2	localBitmap	android.graphics.Bitmap
    //   181	10	2	localInterruptedException	java.lang.InterruptedException
    //   202	5	2	localObject	Object
    //   21	147	3	localalov	alov
    //   112	44	4	localalop	alop
    // Exception table:
    //   from	to	target	type
    //   21	35	181	java/lang/InterruptedException
    //   39	53	181	java/lang/InterruptedException
    //   53	97	181	java/lang/InterruptedException
    //   105	178	181	java/lang/InterruptedException
    //   21	35	202	finally
    //   39	53	202	finally
    //   53	97	202	finally
    //   105	178	202	finally
    //   182	194	202	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher.FrameFetchRunnable
 * JD-Core Version:    0.7.0.1
 */