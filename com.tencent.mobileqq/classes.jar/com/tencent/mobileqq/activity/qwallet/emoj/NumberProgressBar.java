package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import azvv;

public class NumberProgressBar
  extends View
{
  public static final int PROGRESS_FACTOR = -360;
  public static final String PROGRESS_PROPERTY = "progress";
  protected final RectF arcElements;
  protected final Paint paint;
  protected float progress;
  protected String progressTitle;
  private Rect rec;
  protected int ringColor = -1;
  protected int ringWidth;
  private LinearGradient shader;
  
  public NumberProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NumberProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ringWidth = azvv.a(paramContext, 5.0F);
    this.progressTitle = "xx";
    this.progress = 0.0F;
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.arcElements = new RectF();
    this.rec = new Rect();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = Math.min(paramCanvas.getHeight(), paramCanvas.getWidth()) / 2 - this.ringWidth / 2;
    float f2 = (paramCanvas.getWidth() - f1 * 2.0F) / 2.0F;
    float f3 = (paramCanvas.getHeight() - f1 * 2.0F) / 2.0F;
    int i = this.ringWidth / 2;
    float f4 = i;
    float f5 = i;
    float f6 = i;
    float f7 = i;
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(this.ringWidth);
    this.paint.setStrokeCap(Paint.Cap.ROUND);
    this.arcElements.set(f4 + f2, f5 + f3, f2 + f1 * 2.0F - f6, f1 * 2.0F + f3 - f7);
    this.paint.setColor(1073741823);
    paramCanvas.drawArc(this.arcElements, 0.0F, 360.0F, false, this.paint);
    if (this.ringColor != 0)
    {
      this.paint.setColor(this.ringColor);
      paramCanvas.drawArc(this.arcElements, -90.0F, -this.progress, false, this.paint);
    }
    String str;
    int j;
    for (;;)
    {
      i = -(int)(this.progress / 3.6D);
      str = i + "%";
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(-1);
      this.paint.setTextSize(azvv.c(getContext(), 16.0F));
      this.paint.getTextBounds(str, 0, str.length(), this.rec);
      i = this.rec.width();
      j = this.rec.height();
      if ((this.progressTitle == null) || (this.progressTitle.isEmpty())) {
        break;
      }
      paramCanvas.drawText(str, (paramCanvas.getWidth() - i) / 2, (j + paramCanvas.getHeight()) / 2, this.paint);
      this.paint.setTextSize(azvv.c(getContext(), 16.0F));
      return;
      paramCanvas.drawArc(this.arcElements, -90.0F, -this.progress, false, this.paint);
    }
    paramCanvas.drawText(str, (paramCanvas.getWidth() - i) / 2, (j + paramCanvas.getHeight()) / 2, this.paint);
  }
  
  public void setProgress(float paramFloat)
  {
    this.progress = (-360.0F * paramFloat);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.NumberProgressBar
 * JD-Core Version:    0.7.0.1
 */