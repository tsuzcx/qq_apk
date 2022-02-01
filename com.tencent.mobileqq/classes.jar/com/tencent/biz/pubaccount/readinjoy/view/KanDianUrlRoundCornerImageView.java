package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class KanDianUrlRoundCornerImageView
  extends KandianUrlImageView
{
  private int a = 0;
  
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
  
  public void onDraw(Canvas paramCanvas)
  {
    Path localPath;
    if (this.a > 0)
    {
      localPath = new Path();
      localPath.addRoundRect(new RectF(new Rect(0, 0, getWidth(), getHeight())), this.a, this.a, Path.Direction.CCW);
      if (Build.VERSION.SDK_INT < 28) {
        break label76;
      }
      paramCanvas.clipPath(localPath);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      label76:
      paramCanvas.clipPath(localPath, Region.Op.REPLACE);
    }
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */