package com.tencent.ad.tangram.canvas.views.canvas.components.roundview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

public class b
  implements a
{
  private Paint boarderPaint = new Paint(1);
  private int borderColor = -1;
  private float borderWidth;
  private Path mPath = new Path();
  private RectF mRectF = new RectF();
  private WeakReference<View> mView;
  private float radius;
  
  public b(WeakReference<View> paramWeakReference)
  {
    this.mView = paramWeakReference;
  }
  
  private void resetRoundPath()
  {
    this.mPath.reset();
    this.mPath.addRoundRect(this.mRectF, this.radius, this.radius, Path.Direction.CW);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.mView == null) || (this.mView.get() == null)) {}
    for (;;)
    {
      return;
      Object localObject = (View)this.mView.get();
      int i = ((View)this.mView.get()).getWidth();
      int j = ((View)this.mView.get()).getHeight();
      if (Build.VERSION.SDK_INT < 21)
      {
        paramCanvas.clipPath(this.mPath);
        ((View)localObject).setPadding((int)(this.borderWidth * 1.5D), (int)(this.borderWidth * 1.5D), (int)this.borderWidth / 2, (int)this.borderWidth / 2);
      }
      while (this.borderWidth > 0.0F)
      {
        localObject = new RectF(this.borderWidth, this.borderWidth, i - this.borderWidth, j - this.borderWidth);
        this.boarderPaint.setColor(this.borderColor);
        this.boarderPaint.setStyle(Paint.Style.STROKE);
        this.boarderPaint.setStrokeWidth(this.borderWidth);
        paramCanvas.drawRoundRect((RectF)localObject, this.radius, this.radius, this.boarderPaint);
        return;
        ((View)localObject).setClipToOutline(true);
        ((View)localObject).setOutlineProvider(new b.1(this, i, j));
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mView == null) || (this.mView.get() == null)) {}
    do
    {
      return;
      paramInt1 = ((View)this.mView.get()).getWidth();
      paramInt2 = ((View)this.mView.get()).getHeight();
    } while (Build.VERSION.SDK_INT >= 21);
    this.mRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    resetRoundPath();
  }
  
  public void setBorderColor(int paramInt)
  {
    this.borderColor = paramInt;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.borderWidth = paramFloat;
  }
  
  public void setRadius(float paramFloat)
  {
    this.radius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b
 * JD-Core Version:    0.7.0.1
 */