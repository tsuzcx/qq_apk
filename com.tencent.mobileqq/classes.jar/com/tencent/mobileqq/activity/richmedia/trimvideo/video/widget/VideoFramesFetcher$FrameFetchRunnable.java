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
    //   3: ifne +18 -> 21
    //   6: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 32
    //   14: iconst_2
    //   15: ldc 34
    //   17: invokestatic 38	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aload_0
    //   22: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   25: invokestatic 44	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:c	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   28: ifne +156 -> 184
    //   31: aload_0
    //   32: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   35: invokestatic 47	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:d	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   38: ifnull +146 -> 184
    //   41: aload_0
    //   42: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   45: invokestatic 47	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:d	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   48: invokeinterface 53 1 0
    //   53: checkcast 55	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchTask
    //   56: astore_2
    //   57: aload_0
    //   58: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   61: invokestatic 44	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:c	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   64: istore_1
    //   65: iload_1
    //   66: ifeq +7 -> 73
    //   69: invokestatic 58	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   72: return
    //   73: aload_2
    //   74: getfield 62	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchTask:b	I
    //   77: i2l
    //   78: aload_2
    //   79: getfield 64	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchTask:c	I
    //   82: i2l
    //   83: invokestatic 69	com/tencent/mobileqq/activity/richmedia/trimvideo/video/utils/ThumbnailUtils:b	(JJ)Landroid/graphics/Bitmap;
    //   86: astore_3
    //   87: aload_3
    //   88: ifnonnull +20 -> 108
    //   91: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -73 -> 21
    //   97: ldc 32
    //   99: iconst_2
    //   100: ldc 71
    //   102: invokestatic 38	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: goto -84 -> 21
    //   108: new 73	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame
    //   111: dup
    //   112: invokespecial 74	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:<init>	()V
    //   115: astore 4
    //   117: aload 4
    //   119: aload_3
    //   120: getstatic 80	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   123: iconst_1
    //   124: invokevirtual 86	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   127: putfield 90	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:a	Landroid/graphics/Bitmap;
    //   130: aload 4
    //   132: aload_2
    //   133: getfield 62	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchTask:b	I
    //   136: aload_0
    //   137: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   140: invokestatic 94	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:e	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)I
    //   143: idiv
    //   144: putfield 95	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:b	I
    //   147: aload_3
    //   148: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   151: aload_0
    //   152: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   155: invokestatic 102	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:f	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter;
    //   158: aload 4
    //   160: invokevirtual 107	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame;)V
    //   163: aload_0
    //   164: getfield 12	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   167: invokestatic 110	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:b	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/ConcurrentHashMap;
    //   170: aload_2
    //   171: getfield 62	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchTask:b	I
    //   174: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokevirtual 122	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: goto -160 -> 21
    //   184: invokestatic 58	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   187: return
    //   188: astore_2
    //   189: goto +19 -> 208
    //   192: astore_2
    //   193: ldc 32
    //   195: iconst_2
    //   196: ldc 124
    //   198: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_2
    //   202: invokevirtual 129	java/lang/InterruptedException:printStackTrace	()V
    //   205: goto -21 -> 184
    //   208: invokestatic 58	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   211: goto +5 -> 216
    //   214: aload_2
    //   215: athrow
    //   216: goto -2 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	FrameFetchRunnable
    //   64	2	1	bool	boolean
    //   56	115	2	localFrameFetchTask	VideoFramesFetcher.FrameFetchTask
    //   188	1	2	localObject	Object
    //   192	23	2	localInterruptedException	java.lang.InterruptedException
    //   86	62	3	localBitmap	android.graphics.Bitmap
    //   115	44	4	localFrame	FramesProcessor.Frame
    // Exception table:
    //   from	to	target	type
    //   21	65	188	finally
    //   73	87	188	finally
    //   91	105	188	finally
    //   108	181	188	finally
    //   193	205	188	finally
    //   21	65	192	java/lang/InterruptedException
    //   73	87	192	java/lang/InterruptedException
    //   91	105	192	java/lang/InterruptedException
    //   108	181	192	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher.FrameFetchRunnable
 * JD-Core Version:    0.7.0.1
 */