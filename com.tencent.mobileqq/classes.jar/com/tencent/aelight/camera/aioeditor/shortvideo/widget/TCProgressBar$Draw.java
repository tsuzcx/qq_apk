package com.tencent.aelight.camera.aioeditor.shortvideo.widget;

import android.graphics.Canvas;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$Draw
{
  int k;
  int l;
  boolean m = true;
  boolean n = true;
  boolean o = false;
  
  TCProgressBar$Draw(TCProgressBar paramTCProgressBar) {}
  
  void a(Canvas paramCanvas)
  {
    this.o = false;
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
    int i = this.k;
    return (paramFloat > i) && (paramFloat < i + this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.Draw
 * JD-Core Version:    0.7.0.1
 */