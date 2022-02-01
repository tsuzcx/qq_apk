package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

class VoicePrintUtils$VoicePrintDrawable
  extends Drawable
{
  Paint a = new Paint(6);
  Bitmap b;
  Rect c;
  int d;
  boolean e;
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    this.b = paramBitmap;
    this.c = new Rect(0, 0, paramInt, paramBitmap.getHeight());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.b == null)
    {
      QLog.e("VoicePrintView", 1, "onDraw(), bmp==null");
      return;
    }
    int i = 0;
    if (this.e)
    {
      i = paramCanvas.save();
      paramCanvas.scale(-1.0F, 1.0F, this.d / 2.0F, getBounds().exactCenterY());
    }
    paramCanvas.drawBitmap(this.b, this.c, getBounds(), this.a);
    if (this.e) {
      paramCanvas.restoreToCount(i);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.a.getAlpha())
    {
      this.a.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintDrawable
 * JD-Core Version:    0.7.0.1
 */