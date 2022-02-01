package com.tencent.avgame.ui;

import android.graphics.RectF;
import androidx.annotation.NonNull;

public class RoundEmptyRectRelativeLayout$ClipRoundRect
{
  private RectF a;
  private float[] b;
  
  public RoundEmptyRectRelativeLayout$ClipRoundRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.a = new RectF(paramFloat1, paramFloat2, paramFloat3 + paramFloat1, paramFloat4 + paramFloat2);
    this.b = new float[] { paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5 };
  }
  
  @NonNull
  public String toString()
  {
    RectF localRectF = this.a;
    if (localRectF != null) {
      return localRectF.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.RoundEmptyRectRelativeLayout.ClipRoundRect
 * JD-Core Version:    0.7.0.1
 */