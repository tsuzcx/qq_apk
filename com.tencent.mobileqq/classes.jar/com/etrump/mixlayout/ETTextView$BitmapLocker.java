package com.etrump.mixlayout;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;

class ETTextView$BitmapLocker
{
  private Bitmap b;
  
  private ETTextView$BitmapLocker(ETTextView paramETTextView) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      int j = this.a.mFont.getSize() * 4;
      int i = paramInt2;
      if (paramInt2 < j) {
        i = j;
      }
      if ((this.b != null) && ((this.b.getHeight() < i) || (this.b.getWidth() < paramInt1) || (this.b.getHeight() > j + i)))
      {
        this.b.recycle();
        this.b = null;
      }
      if (this.b == null) {
        this.b = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
      }
      if (this.b != null) {
        this.b.setDensity(this.a.getResources().getDisplayMetrics().densityDpi);
      }
      return;
    }
    finally {}
  }
  
  Bitmap a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.BitmapLocker
 * JD-Core Version:    0.7.0.1
 */