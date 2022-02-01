package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;

public abstract class BaseBackgroundDrawer
{
  protected Paint a = new Paint();
  
  public BaseBackgroundDrawer()
  {
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
  }
  
  public abstract void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2);
  
  public abstract void a(Canvas paramCanvas, ArrayList<PerLineModel> paramArrayList, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BaseBackgroundDrawer
 * JD-Core Version:    0.7.0.1
 */