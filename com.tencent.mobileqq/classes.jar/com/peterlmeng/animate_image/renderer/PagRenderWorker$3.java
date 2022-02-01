package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import org.libpag.PAGPlayer;
import org.libpag.PAGSurface;

class PagRenderWorker$3
  implements Runnable
{
  PagRenderWorker$3(PagRenderWorker paramPagRenderWorker) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        PagRenderWorker.access$200(this.this$0, this);
        if (PagRenderWorker.access$000(this.this$0) != null)
        {
          PagRenderWorker localPagRenderWorker = this.this$0;
          if ((!PagRenderWorker.access$300(this.this$0)) || (!PagRenderWorker.access$000(this.this$0).isRunning())) {
            break label188;
          }
          bool = true;
          PagRenderWorker.access$302(localPagRenderWorker, bool);
          PagRenderWorker.access$000(this.this$0).cancel();
        }
        if (this.this$0.surfaceTexture != null)
        {
          if ((Build.VERSION.SDK_INT >= 26) && (!this.this$0.surfaceTexture.isReleased())) {
            this.this$0.surfaceTexture.release();
          }
          this.this$0.entry.release();
        }
        if (this.this$0.pagSurface != null)
        {
          this.this$0.pagSurface.release();
          this.this$0.pagSurface = null;
        }
        if (this.this$0.pagPlayer != null)
        {
          this.this$0.pagPlayer.release();
          this.this$0.pagPlayer = null;
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtils.b("PagRenderWorker", localException.getMessage());
      }
      return;
      label188:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.3
 * JD-Core Version:    0.7.0.1
 */