package com.tencent.biz.qqstory.storyHome.discover;

import android.content.Context;
import android.graphics.Canvas;
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
  private Path a = new Path();
  private int b;
  
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
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    super.setLayerType(1, null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a == null) {
      this.a = new Path();
    }
    this.a.reset();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + i, j - k - m + getPaddingTop());
    if (this.b > 0) {
      i = this.b;
    }
    for (;;)
    {
      this.a.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      this.a.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.a);
      super.draw(paramCanvas);
      return;
      i /= 30;
    }
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */