package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class BaseTextRegion
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public Bitmap i = null;
  public Typeface j = null;
  public int k = 2;
  
  public int a(float paramFloat)
  {
    return AIOUtils.b(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public int a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    while (m < paramInt)
    {
      localStringBuilder.append("我");
      m += 1;
    }
    TextPaint localTextPaint = new TextPaint();
    Object localObject = this.j;
    if (localObject != null) {
      localTextPaint.setTypeface((Typeface)localObject);
    }
    localTextPaint.setShadowLayer(a(3.0F), a(5.0F), a(5.0F), -1);
    paramInt = AIOUtils.b(100.0F, BaseApplicationImpl.getApplication().getResources());
    localTextPaint.setTextSize(paramInt);
    localObject = StaticLayoutWithMaxLines.a(localStringBuilder, 0, localStringBuilder.length(), localTextPaint, this.c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 1);
    if (localTextPaint.measureText(localStringBuilder.toString()) > this.c) {}
    while (((StaticLayout)localObject).getHeight() > this.d)
    {
      paramInt -= 1;
      break;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BaseTextRegion
 * JD-Core Version:    0.7.0.1
 */