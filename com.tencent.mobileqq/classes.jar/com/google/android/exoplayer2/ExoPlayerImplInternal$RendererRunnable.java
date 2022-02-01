package com.google.android.exoplayer2;

import java.util.concurrent.CountDownLatch;

class ExoPlayerImplInternal$RendererRunnable
  implements Runnable
{
  long elapsedTimeUs;
  ExoPlaybackException exceptionThrown;
  CountDownLatch latch;
  long positionUs;
  Renderer renderer;
  boolean rendererReadyOrEnded;
  boolean renderersEnded;
  
  public ExoPlayerImplInternal$RendererRunnable(ExoPlayerImplInternal paramExoPlayerImplInternal, Renderer paramRenderer, long paramLong1, long paramLong2, CountDownLatch paramCountDownLatch)
  {
    this.renderer = paramRenderer;
    this.latch = paramCountDownLatch;
  }
  
  public ExoPlaybackException getExceptionThrown()
  {
    return this.exceptionThrown;
  }
  
  public Renderer getRenderer()
  {
    return this.renderer;
  }
  
  public boolean isEnded()
  {
    return this.renderersEnded;
  }
  
  public boolean rendererReadyOrEnded()
  {
    return this.rendererReadyOrEnded;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderer	Lcom/google/android/exoplayer2/Renderer;
    //   4: aload_0
    //   5: getfield 49	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:positionUs	J
    //   8: aload_0
    //   9: getfield 51	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:elapsedTimeUs	J
    //   12: invokeinterface 57 5 0
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 29	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderer	Lcom/google/android/exoplayer2/Renderer;
    //   22: invokeinterface 59 1 0
    //   27: putfield 42	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderersEnded	Z
    //   30: aload_0
    //   31: getfield 29	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderer	Lcom/google/android/exoplayer2/Renderer;
    //   34: invokeinterface 62 1 0
    //   39: ifne +106 -> 145
    //   42: aload_0
    //   43: getfield 29	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderer	Lcom/google/android/exoplayer2/Renderer;
    //   46: invokeinterface 59 1 0
    //   51: ifne +94 -> 145
    //   54: aload_0
    //   55: getfield 24	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:this$0	Lcom/google/android/exoplayer2/ExoPlayerImplInternal;
    //   58: aload_0
    //   59: getfield 29	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderer	Lcom/google/android/exoplayer2/Renderer;
    //   62: invokestatic 68	com/google/android/exoplayer2/ExoPlayerImplInternal:access$500	(Lcom/google/android/exoplayer2/ExoPlayerImplInternal;Lcom/google/android/exoplayer2/Renderer;)Z
    //   65: ifeq +75 -> 140
    //   68: goto +77 -> 145
    //   71: aload_0
    //   72: iload_1
    //   73: putfield 44	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:rendererReadyOrEnded	Z
    //   76: goto +47 -> 123
    //   79: astore_2
    //   80: goto +51 -> 131
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 29	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderer	Lcom/google/android/exoplayer2/Renderer;
    //   88: instanceof 70
    //   91: ifeq +24 -> 115
    //   94: aload_0
    //   95: aload_2
    //   96: aload_0
    //   97: getfield 29	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:renderer	Lcom/google/android/exoplayer2/Renderer;
    //   100: checkcast 70	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer
    //   103: invokevirtual 74	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:getRenderIndex	()I
    //   106: invokestatic 80	com/google/android/exoplayer2/ExoPlaybackException:createForRenderer	(Ljava/lang/Exception;I)Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   109: putfield 36	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:exceptionThrown	Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   112: goto +11 -> 123
    //   115: aload_0
    //   116: aload_2
    //   117: invokestatic 84	com/google/android/exoplayer2/ExoPlaybackException:createForUnexpected	(Ljava/lang/Exception;)Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   120: putfield 36	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:exceptionThrown	Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   123: aload_0
    //   124: getfield 31	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:latch	Ljava/util/concurrent/CountDownLatch;
    //   127: invokevirtual 89	java/util/concurrent/CountDownLatch:countDown	()V
    //   130: return
    //   131: aload_0
    //   132: getfield 31	com/google/android/exoplayer2/ExoPlayerImplInternal$RendererRunnable:latch	Ljava/util/concurrent/CountDownLatch;
    //   135: invokevirtual 89	java/util/concurrent/CountDownLatch:countDown	()V
    //   138: aload_2
    //   139: athrow
    //   140: iconst_0
    //   141: istore_1
    //   142: goto -71 -> 71
    //   145: iconst_1
    //   146: istore_1
    //   147: goto -76 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	RendererRunnable
    //   72	75	1	bool	boolean
    //   79	1	2	localObject	Object
    //   83	56	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	68	79	finally
    //   71	76	79	finally
    //   84	112	79	finally
    //   115	123	79	finally
    //   0	68	83	java/lang/Exception
    //   71	76	83	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal.RendererRunnable
 * JD-Core Version:    0.7.0.1
 */