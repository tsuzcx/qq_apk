package com.tencent.aelight.camera.aioeditor.shortvideo.widget;

import android.graphics.Canvas;
import android.graphics.Paint;

class TCProgressBar$BlinkBlock
  extends TCProgressBar.Draw
{
  TCProgressBar$BlinkBlock(TCProgressBar paramTCProgressBar)
  {
    super(paramTCProgressBar);
  }
  
  void a(Canvas paramCanvas)
  {
    this.a.b.left = this.f;
    this.a.b.right = (this.f + this.g);
    this.a.a.setColor(this.a.m);
    paramCanvas.drawRect(this.a.b, this.a.a);
    super.a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.BlinkBlock
 * JD-Core Version:    0.7.0.1
 */