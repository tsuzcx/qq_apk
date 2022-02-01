package com.google.android.exoplayer2;

import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
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
  
  public void run()
  {
    label147:
    for (;;)
    {
      try
      {
        this.renderer.render(this.positionUs, this.elapsedTimeUs);
        this.renderersEnded = this.renderer.isEnded();
        if ((!this.renderer.isReady()) && (!this.renderer.isEnded())) {
          if (ExoPlayerImplInternal.access$500(this.this$0, this.renderer))
          {
            break label147;
            this.rendererReadyOrEnded = bool;
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      catch (Exception localException)
      {
        if ((this.renderer instanceof MediaCodecRenderer))
        {
          this.exceptionThrown = ExoPlaybackException.createForRenderer(localException, ((MediaCodecRenderer)this.renderer).getRenderIndex());
          return;
        }
        this.exceptionThrown = ExoPlaybackException.createForUnexpected(localException);
      }
      finally
      {
        this.latch.countDown();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal.RendererRunnable
 * JD-Core Version:    0.7.0.1
 */