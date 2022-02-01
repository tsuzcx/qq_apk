package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;

class TXCGLSurfaceView$5
  implements Runnable
{
  TXCGLSurfaceView$5(TXCGLSurfaceView paramTXCGLSurfaceView, ByteBuffer paramByteBuffer, Bitmap paramBitmap, int paramInt1, int paramInt2, o paramo) {}
  
  public void run()
  {
    Object localObject1 = null;
    try
    {
      this.a.position(0);
      this.b.copyPixelsFromBuffer(this.a);
      Object localObject2 = new Matrix();
      ((Matrix)localObject2).setScale(1.0F, -1.0F);
      localObject2 = Bitmap.createBitmap(this.b, 0, 0, this.c, this.d, (Matrix)localObject2, false);
      localObject1 = localObject2;
    }
    catch (Error localError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("takePhoto error ");
      localStringBuilder.append(localError);
      TXCLog.w("TXCGLSurfaceView", localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("takePhoto error ");
      localStringBuilder.append(localException);
      TXCLog.w("TXCGLSurfaceView", localStringBuilder.toString());
    }
    this.e.onTakePhotoComplete(localObject1);
    this.b.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */