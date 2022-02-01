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
    try
    {
      PagRenderWorker.access$200(this.this$0, this);
      PagRenderWorker localPagRenderWorker;
      if (PagRenderWorker.access$000(this.this$0) != null)
      {
        localPagRenderWorker = this.this$0;
        if ((!PagRenderWorker.access$300(this.this$0)) || (!PagRenderWorker.access$000(this.this$0).isRunning())) {
          break label174;
        }
      }
      label174:
      for (boolean bool = true;; bool = false)
      {
        PagRenderWorker.access$302(localPagRenderWorker, bool);
        PagRenderWorker.access$000(this.this$0).cancel();
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
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtils.b("PagRenderWorker", localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.3
 * JD-Core Version:    0.7.0.1
 */