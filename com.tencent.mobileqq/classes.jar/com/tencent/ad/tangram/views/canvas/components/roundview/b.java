package com.tencent.ad.tangram.views.canvas.components.roundview;

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
    Path localPath = this.mPath;
    RectF localRectF = this.mRectF;
    float f = this.radius;
    localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.mView;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (View)this.mView.get();
      int i = ((View)this.mView.get()).getWidth();
      int j = ((View)this.mView.get()).getHeight();
      if (Build.VERSION.SDK_INT < 21)
      {
        paramCanvas.clipPath(this.mPath);
        f = this.borderWidth;
        double d = f;
        Double.isNaN(d);
        int k = (int)(d * 1.5D);
        d = f;
        Double.isNaN(d);
        ((View)localObject).setPadding(k, (int)(d * 1.5D), (int)f / 2, (int)f / 2);
      }
      else
      {
        ((View)localObject).setClipToOutline(true);
        ((View)localObject).setOutlineProvider(new b.1(this, i, j));
      }
      float f = this.borderWidth;
      if (f > 0.0F)
      {
        localObject = new RectF(f, f, i - f, j - f);
        this.boarderPaint.setColor(this.borderColor);
        this.boarderPaint.setStyle(Paint.Style.STROKE);
        this.boarderPaint.setStrokeWidth(this.borderWidth);
        f = this.radius;
        paramCanvas.drawRoundRect((RectF)localObject, f, f, this.boarderPaint);
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    WeakReference localWeakReference = this.mView;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      paramInt1 = ((View)this.mView.get()).getWidth();
      paramInt2 = ((View)this.mView.get()).getHeight();
      if (Build.VERSION.SDK_INT < 21)
      {
        this.mRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
        resetRoundPath();
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.roundview.b
 * JD-Core Version:    0.7.0.1
 */