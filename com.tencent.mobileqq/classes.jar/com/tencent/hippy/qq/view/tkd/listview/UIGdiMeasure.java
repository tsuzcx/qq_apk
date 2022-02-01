package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Paint;
import android.text.TextUtils;

public class UIGdiMeasure
{
  private Paint mPaint;
  
  public UIGdiMeasure()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
  }
  
  public UIGdiMeasure(Paint paramPaint)
  {
    this.mPaint = paramPaint;
    this.mPaint.setAntiAlias(true);
  }
  
  public int breakText(String paramString, int paramInt, float[] paramArrayOfFloat)
  {
    this.mPaint.setAntiAlias(true);
    float f1 = getStringWidth("a");
    int m = Math.min((int)(paramInt * 2 / f1), paramString.length());
    if (m <= 0) {
      return 0;
    }
    float[] arrayOfFloat = new float[m];
    this.mPaint.getTextWidths(paramString.subSequence(0, m).toString(), arrayOfFloat);
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      i = (int)(i + arrayOfFloat[j]);
      if (i > paramInt)
      {
        k = i;
        break;
      }
      j += 1;
    }
    if (paramArrayOfFloat != null)
    {
      float f2 = k;
      if (j < m) {
        f1 = arrayOfFloat[j];
      } else {
        f1 = 0.0F;
      }
      paramArrayOfFloat[0] = (f2 - f1);
    }
    return j;
  }
  
  public float getCharHeight()
  {
    this.mPaint.setAntiAlias(true);
    return this.mPaint.getTextSize();
  }
  
  public float getStringWidth(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0.0F;
    }
    this.mPaint.setAntiAlias(true);
    return this.mPaint.measureText(paramString);
  }
  
  public void getStringWidthHeight(String paramString, HippyTKDUISize paramHippyTKDUISize)
  {
    paramHippyTKDUISize.mWidth = ((int)getStringWidth(paramString));
    paramHippyTKDUISize.mHeight = ((int)getCharHeight());
  }
  
  public int getStringWidthInt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    this.mPaint.setAntiAlias(true);
    return (int)Math.ceil(this.mPaint.measureText(paramString));
  }
  
  public void setFontSize(int paramInt)
  {
    this.mPaint.setTextSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.UIGdiMeasure
 * JD-Core Version:    0.7.0.1
 */