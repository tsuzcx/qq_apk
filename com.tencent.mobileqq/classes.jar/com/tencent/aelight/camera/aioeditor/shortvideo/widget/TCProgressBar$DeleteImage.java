package com.tencent.aelight.camera.aioeditor.shortvideo.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$DeleteImage
  extends TCProgressBar.Draw
{
  boolean a;
  int b = -1;
  float c = 0.0F;
  boolean d = false;
  int e = 0;
  int f;
  boolean g = true;
  int h = 0;
  int i;
  
  TCProgressBar$DeleteImage(TCProgressBar paramTCProgressBar)
  {
    super(paramTCProgressBar);
  }
  
  void a(Canvas paramCanvas)
  {
    this.j.y.left = this.k;
    this.j.y.right = (this.k + this.l);
    int k = this.j.y.top;
    int m = this.j.y.bottom;
    this.j.y.top = 0;
    this.j.y.bottom = this.i;
    if (this.a) {
      a(paramCanvas, this.j.f);
    } else {
      a(paramCanvas, this.j.g);
    }
    this.j.y.top = k;
    this.j.y.bottom = m;
    super.a(paramCanvas);
  }
  
  void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.j.i.setColor(-1);
      if (!this.a) {
        this.j.i.setColor(-65536);
      }
      paramCanvas.drawRect(this.j.y, this.j.i);
      return;
    }
    this.j.i.setFilterBitmap(true);
    paramCanvas.drawBitmap(paramBitmap, null, this.j.y, this.j.i);
    this.j.i.setFilterBitmap(false);
  }
  
  boolean a()
  {
    int m = this.f;
    int k = m;
    if (m < 0) {
      k = -m;
    }
    return k > 1;
  }
  
  boolean a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkBounds,x = ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(",x_coord = ");
      localStringBuilder.append(this.k);
      localStringBuilder.append(",x_coord + length = ");
      localStringBuilder.append(this.k + this.l);
      QLog.d("TCProgressBar", 2, localStringBuilder.toString());
    }
    return (paramFloat > this.k - 25) && (paramFloat < this.k + this.l + 25);
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            return true;
          }
        }
        else
        {
          this.f = ((int)(f1 - this.c));
          this.b = k;
          this.c = f1;
          this.e += 1;
          this.g = false;
          if (!a()) {
            break label131;
          }
          this.k += this.f;
          return true;
        }
      }
      this.d = false;
      this.c = 0.0F;
      this.g = true;
      return true;
    }
    else
    {
      this.d = true;
      this.b = k;
      this.c = f1;
      this.e = 0;
      this.a = false;
    }
    label131:
    return true;
  }
  
  int b()
  {
    return this.k + this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.DeleteImage
 * JD-Core Version:    0.7.0.1
 */