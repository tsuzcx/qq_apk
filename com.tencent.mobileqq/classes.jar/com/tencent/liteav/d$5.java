package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.opengl.p;

class d$5
  implements p
{
  d$5(d paramd, p paramp) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    p localp = this.a;
    if (localp != null) {
      localp.onTakePhotoComplete(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.5
 * JD-Core Version:    0.7.0.1
 */