package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class MediaPlayer$2
  implements Runnable
{
  MediaPlayer$2(MediaPlayer paramMediaPlayer) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   4: invokevirtual 28	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:a	()V
    //   7: aload_0
    //   8: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   11: getfield 32	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:P	I
    //   14: iconst_4
    //   15: if_icmpne +15 -> 30
    //   18: aload_0
    //   19: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   22: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:w	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler;
    //   25: iconst_1
    //   26: invokevirtual 42	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler:sendEmptyMessage	(I)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   34: invokestatic 45	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:a	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;)Ljava/util/concurrent/CountDownLatch;
    //   37: invokevirtual 50	java/util/concurrent/CountDownLatch:countDown	()V
    //   40: return
    //   41: astore_1
    //   42: goto +119 -> 161
    //   45: astore_1
    //   46: ldc 52
    //   48: ldc 54
    //   50: aload_1
    //   51: invokestatic 60	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   54: pop
    //   55: aload_0
    //   56: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   59: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:w	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler;
    //   62: aload_0
    //   63: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   66: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:w	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler;
    //   69: bipush 100
    //   71: iconst_1
    //   72: iconst_0
    //   73: invokevirtual 64	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler:obtainMessage	(III)Landroid/os/Message;
    //   76: invokevirtual 68	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler:sendMessage	(Landroid/os/Message;)Z
    //   79: pop
    //   80: goto -50 -> 30
    //   83: astore_1
    //   84: ldc 52
    //   86: ldc 70
    //   88: aload_1
    //   89: invokestatic 60	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   92: pop
    //   93: aload_0
    //   94: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   97: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:w	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler;
    //   100: aload_0
    //   101: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   104: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:w	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler;
    //   107: bipush 100
    //   109: iconst_1
    //   110: iconst_0
    //   111: invokevirtual 64	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler:obtainMessage	(III)Landroid/os/Message;
    //   114: invokevirtual 68	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler:sendMessage	(Landroid/os/Message;)Z
    //   117: pop
    //   118: goto -88 -> 30
    //   121: astore_1
    //   122: ldc 52
    //   124: ldc 72
    //   126: aload_1
    //   127: invokestatic 60	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: aload_0
    //   132: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   135: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:w	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler;
    //   138: aload_0
    //   139: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   142: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:w	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler;
    //   145: bipush 100
    //   147: iconst_1
    //   148: sipush -1004
    //   151: invokevirtual 64	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler:obtainMessage	(III)Landroid/os/Message;
    //   154: invokevirtual 68	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$EventHandler:sendMessage	(Landroid/os/Message;)Z
    //   157: pop
    //   158: goto -128 -> 30
    //   161: aload_0
    //   162: getfield 12	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$2:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
    //   165: invokestatic 45	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:a	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;)Ljava/util/concurrent/CountDownLatch;
    //   168: invokevirtual 50	java/util/concurrent/CountDownLatch:countDown	()V
    //   171: goto +5 -> 176
    //   174: aload_1
    //   175: athrow
    //   176: goto -2 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	2
    //   41	1	1	localObject	Object
    //   45	6	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   83	6	1	localIllegalStateException	java.lang.IllegalStateException
    //   121	54	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	30	41	finally
    //   46	80	41	finally
    //   84	118	41	finally
    //   122	158	41	finally
    //   0	30	45	java/lang/IllegalArgumentException
    //   0	30	83	java/lang/IllegalStateException
    //   0	30	121	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */