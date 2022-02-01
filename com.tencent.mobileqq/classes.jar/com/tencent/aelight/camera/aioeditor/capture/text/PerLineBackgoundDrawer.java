package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;

public class PerLineBackgoundDrawer
  extends BaseBackgroundDrawer
{
  private final int b;
  
  public PerLineBackgoundDrawer(int paramInt1, int paramInt2)
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setColor(paramInt1);
    this.b = paramInt2;
  }
  
  public void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2)
  {
    if (paramCanvas != null)
    {
      if (paramRectF == null) {
        return;
      }
      float f1 = paramRectF.left;
      float f2 = this.b;
      float f3 = paramInt1;
      float f4 = paramRectF.top;
      float f5 = this.b;
      float f6 = paramInt2;
      paramCanvas.drawRect(f1 - f2 + f3, f4 - f5 + f6, paramRectF.right + this.b + f3, paramRectF.bottom + this.b + f6, this.a);
    }
  }
  
  public void a(Canvas paramCanvas, ArrayList<PerLineModel> paramArrayList, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.PerLineBackgoundDrawer
 * JD-Core Version:    0.7.0.1
 */