package com.tencent.biz.qqstory.storyHome.discover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

public class RoundCornerImageView
  extends PressDarkImageView
{
  private Path e = new Path();
  private Paint f = new Paint();
  private int g = Color.parseColor("#FFD5D5D5");
  private int h;
  private boolean i = false;
  private int j = 0;
  
  public RoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f.setColor(this.g);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setAntiAlias(true);
    this.f.setFilterBitmap(true);
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setLayerType(2, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      super.setLayerType(1, null);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.e == null) {
      this.e = new Path();
    }
    this.e.reset();
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int k = getHeight();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + m, getPaddingTop() + (k - n - i1));
    k = this.j;
    if (k <= 0) {
      k = m / 30;
    }
    Path localPath = this.e;
    float f1 = k;
    localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CCW);
    this.e.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.e);
    super.draw(paramCanvas);
    if (this.i)
    {
      this.f.setColor(this.g);
      k = this.h;
      if (k != 0) {
        this.f.setStrokeWidth(k);
      }
      this.e.reset();
      this.e.addRoundRect(localRectF, f1, f1, Path.Direction.CCW);
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.f);
    }
  }
  
  public void setBorder(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt > 0)
    {
      this.j = paramInt;
      return;
    }
    throw new IllegalArgumentException("should not be less than 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */