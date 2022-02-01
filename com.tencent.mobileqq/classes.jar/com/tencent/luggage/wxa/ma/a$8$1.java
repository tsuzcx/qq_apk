package com.tencent.luggage.wxa.ma;

import android.graphics.Bitmap;
import android.widget.ImageView;

class a$8$1
  implements Runnable
{
  a$8$1(a.8 param8, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      a.a(this.b.b).setImageBitmap(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a.8.1
 * JD-Core Version:    0.7.0.1
 */