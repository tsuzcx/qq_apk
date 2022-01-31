package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

class BoringView$BoringViewImpl
  extends View
{
  private int mBackgroundColor = 0;
  private Paint mBackgroundPaint;
  private int mBorderBottomLeftRadius = 0;
  private int mBorderBottomRightRadius = 0;
  private int mBorderColor = -16777216;
  private Paint mBorderPaint;
  private int mBorderTopLeftRadius = 0;
  private int mBorderTopRightRadius = 0;
  private int mBorderWidth = 0;
  
  public BoringView$BoringViewImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mBackgroundColor != 0)
    {
      if (this.mBackgroundPaint == null)
      {
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setAntiAlias(true);
      }
      this.mBackgroundPaint.setColor(this.mBackgroundColor);
      VirtualViewUtils.drawBackground(paramCanvas, this.mBackgroundPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
    super.onDraw(paramCanvas);
    if (this.mBorderWidth > 0)
    {
      if (this.mBorderPaint == null)
      {
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
      }
      this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
      this.mBorderPaint.setColor(this.mBorderColor);
      VirtualViewUtils.drawBorder(paramCanvas, this.mBorderPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public void setBorderBottomLeftRadius(int paramInt)
  {
    this.mBorderBottomLeftRadius = paramInt;
  }
  
  public void setBorderBottomRightRadius(int paramInt)
  {
    this.mBorderBottomRightRadius = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
  }
  
  public void setBorderTopLeftRadius(int paramInt)
  {
    this.mBorderTopLeftRadius = paramInt;
  }
  
  public void setBorderTopRightRadius(int paramInt)
  {
    this.mBorderTopRightRadius = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.BoringView.BoringViewImpl
 * JD-Core Version:    0.7.0.1
 */