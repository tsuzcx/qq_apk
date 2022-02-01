package com.tencent.biz.qqcircle.publish.outbox.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class PercentProgressBar
  extends ProgressBar
{
  String a;
  Paint b;
  private Rect c = new Rect();
  
  public PercentProgressBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PercentProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PercentProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = new Paint();
    this.b.setColor(-16777216);
    this.b.setTextSize(18.0F);
  }
  
  private void setText(int paramInt)
  {
    this.a = "";
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      this.c.setEmpty();
      this.b.getTextBounds(this.a, 0, this.a.length(), this.c);
      int i = getWidth() / 2;
      int j = this.c.centerX();
      int k = getHeight() / 2;
      int m = this.c.centerY();
      paramCanvas.drawText(this.a, i - j, k - m, this.b);
      return;
    }
    finally
    {
      paramCanvas = finally;
      throw paramCanvas;
    }
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      setText(paramInt);
      super.setProgress(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    try
    {
      setText(paramInt);
      super.setSecondaryProgress(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.widget.PercentProgressBar
 * JD-Core Version:    0.7.0.1
 */