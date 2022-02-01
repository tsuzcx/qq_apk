package com.tencent.liteav.basic.c;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

class e$4
  implements Runnable
{
  e$4(e parame, ByteBuffer paramByteBuffer, Bitmap paramBitmap, int paramInt1, int paramInt2, o paramo) {}
  
  public void run()
  {
    this.a.position(0);
    this.b.copyPixelsFromBuffer(this.a);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, -1.0F);
    localObject = Bitmap.createBitmap(this.b, 0, 0, this.c, this.d, (Matrix)localObject, false);
    this.e.onTakePhotoComplete((Bitmap)localObject);
    this.b.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.e.4
 * JD-Core Version:    0.7.0.1
 */