package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.p;

class e$1
  implements Runnable
{
  e$1(e parame, Matrix paramMatrix, Bitmap paramBitmap, TextureView paramTextureView, p paramp) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = e.a(this.e, this.a, this.b, this.c.getWidth(), this.c.getHeight());
      localObject = localBitmap;
    }
    catch (Error localError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("takePhoto error ");
      localStringBuilder.append(localError);
      TXCLog.w("TXCVideoRender", localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("takePhoto error ");
      localStringBuilder.append(localException);
      TXCLog.w("TXCVideoRender", localStringBuilder.toString());
    }
    p localp = this.d;
    if (localp != null) {
      localp.onTakePhotoComplete(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.e.1
 * JD-Core Version:    0.7.0.1
 */