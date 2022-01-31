package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;

public class KanDianUrlRoundCornerImageView
  extends KandianUrlImageView
{
  private int b;
  
  public KanDianUrlRoundCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public KanDianUrlRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KanDianUrlRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b > 0)
    {
      Path localPath = new Path();
      localPath.addRoundRect(new RectF(new Rect(0, 0, getWidth(), getHeight())), this.b, this.b, Path.Direction.CCW);
      paramCanvas.clipPath(localPath, Region.Op.REPLACE);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */