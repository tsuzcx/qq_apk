package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.SquareRoundImageUtils;

public class ImageProgressMask
  extends View
{
  private Paint a;
  private Path b;
  private float c;
  private RectF d;
  private int e;
  private int f;
  
  public ImageProgressMask(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ImageProgressMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImageProgressMask(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Paint();
    this.a.setColor(getResources().getColor(2131165801));
    this.a.setAntiAlias(true);
    this.b = new Path();
    this.d = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    if (Build.VERSION.SDK_INT <= 16) {
      setLayerType(1, null);
    }
  }
  
  public float getProgress()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.b);
      if ((this.e == 0) && (this.f == 0))
      {
        this.e = getWidth();
        this.f = getHeight();
        this.d = new RectF(0.0F, this.f * this.c, this.e, this.f);
      }
      paramCanvas.drawRect(this.d, this.a);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    catch (Exception localException)
    {
      label98:
      break label98;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))) {
      this.b = SquareRoundImageUtils.a(paramInt1, paramInt2);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.c = paramFloat;
    this.e = getWidth();
    this.f = getHeight();
    int i = this.f;
    this.d = new RectF(0.0F, i * this.c, this.e, i);
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.ImageProgressMask
 * JD-Core Version:    0.7.0.1
 */