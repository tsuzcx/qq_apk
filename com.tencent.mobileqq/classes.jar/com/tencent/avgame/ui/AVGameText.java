package com.tencent.avgame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.qphone.base.util.QLog;

public class AVGameText
  extends View
{
  public static Typeface a;
  private Paint b;
  private String c = "";
  private AVGameText.Attribute d = new AVGameText.Attribute();
  
  public AVGameText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AVGameText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a()
  {
    this.b = new Paint(1);
    this.b.setTextSize(a(30.0F));
    this.b.setTypeface(getTypeface());
  }
  
  public static Typeface getTypeface()
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(AvGameResDownloadUtil.d());
      localStringBuilder1.append("GameFont.ttf");
      a = Typeface.createFromFile(localStringBuilder1.toString());
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("typeface path = ");
        localStringBuilder1.append(AvGameResDownloadUtil.d());
        localStringBuilder1.append("GameFont.ttf");
        QLog.d("AVGameText", 2, localStringBuilder1.toString());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("create typeface failed : ");
      localStringBuilder2.append(localRuntimeException.getMessage());
      QLog.e("AVGameText", 2, localStringBuilder2.toString());
    }
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    AVGameText.Attribute localAttribute = this.d;
    if (localAttribute != null)
    {
      if (!localAttribute.a()) {
        return;
      }
      float f1 = -this.b.getFontMetrics().ascent;
      f1 = getHeight() - (getHeight() - f1) / 2.0F;
      float f2 = (getWidth() - this.b.measureText(this.c)) / 2.0F;
      paramCanvas.save();
      this.b.setStyle(Paint.Style.FILL_AND_STROKE);
      this.b.setColor(Color.parseColor(this.d.b));
      this.b.setFakeBoldText(true);
      this.b.setShadowLayer(a(3.0F), 0.0F, a(1.0F), Color.parseColor("#33000000"));
      this.b.setStrokeWidth(a(4.0F));
      paramCanvas.drawText(this.c, f2, a(0.4F) + f1, this.b);
      this.b.setStyle(Paint.Style.FILL_AND_STROKE);
      this.b.setColor(Color.parseColor(this.d.a));
      this.b.setFakeBoldText(false);
      this.b.setMaskFilter(null);
      this.b.clearShadowLayer();
      this.b.setStrokeWidth(0.0F);
      paramCanvas.drawText(this.c, f2, f1, this.b);
      paramCanvas.restore();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)(this.b.measureText(this.c) + 0.5F) + a(8.0F), getMeasuredHeight());
  }
  
  public void setAttribute(String paramString1, String paramString2)
  {
    AVGameText.Attribute localAttribute = this.d;
    localAttribute.a = paramString1;
    localAttribute.b = paramString2;
  }
  
  public void setText(String paramString)
  {
    this.c = paramString;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameText
 * JD-Core Version:    0.7.0.1
 */