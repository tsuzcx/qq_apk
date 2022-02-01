package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.c.o;

class d$6
  implements o
{
  d$6(d paramd, o paramo) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    o localo = this.a;
    if (localo != null) {
      localo.onTakePhotoComplete(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.d.6
 * JD-Core Version:    0.7.0.1
 */