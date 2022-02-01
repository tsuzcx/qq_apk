package com.tencent.aelight.camera.ae.album.nocropper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.aelight.camera.impl.R.styleable;

public class AECropperGridView
  extends View
{
  private long a = 200L;
  private Paint b;
  private int c = 268435455;
  private int d = 200;
  private float e = 0.8F;
  private int f = 3;
  private boolean g = false;
  private Handler h;
  private Path i;
  private Runnable j = new AECropperGridView.1(this);
  
  public AECropperGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AECropperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  public AECropperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
      this.c = paramContext.getColor(0, this.c);
      this.e = paramContext.getFloat(1, 1.0F);
      float f2 = this.e * 255.0F;
      float f1;
      if (f2 < 0.0F)
      {
        f1 = 0.0F;
      }
      else
      {
        f1 = f2;
        if (f2 > 255.0F) {
          f1 = 255.0F;
        }
      }
      this.d = ((int)f1);
      this.f = paramContext.getDimensionPixelOffset(2, this.f);
      paramContext.recycle();
    }
    this.b = new Paint();
    this.b.setColor(this.c);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeCap(Paint.Cap.ROUND);
    this.b.setStrokeWidth(this.f);
    this.b.setAlpha(this.d);
    this.i = new Path();
    this.h = new Handler();
    if (isInEditMode()) {
      this.g = true;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.g) {
      return;
    }
    int k = paramCanvas.getWidth();
    int m = paramCanvas.getHeight();
    this.i.reset();
    Path localPath = this.i;
    float f2 = k / 3;
    localPath.moveTo(f2, 0.0F);
    localPath = this.i;
    float f1 = m;
    localPath.lineTo(f2, f1);
    localPath = this.i;
    f2 = k * 2 / 3;
    localPath.moveTo(f2, 0.0F);
    this.i.lineTo(f2, f1);
    localPath = this.i;
    f2 = m / 3;
    localPath.moveTo(0.0F, f2);
    localPath = this.i;
    f1 = k;
    localPath.lineTo(f1, f2);
    localPath = this.i;
    f2 = m * 2 / 3;
    localPath.moveTo(0.0F, f2);
    this.i.lineTo(f1, f2);
    paramCanvas.drawPath(this.i, this.b);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int k = getContext().getResources().getConfiguration().orientation;
    if ((k != 1) && (k != 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  public void setShowGrid(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      if (this.g)
      {
        this.h.removeCallbacks(this.j);
        setAlpha(this.e);
        invalidate();
        return;
      }
      this.h.postDelayed(this.j, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperGridView
 * JD-Core Version:    0.7.0.1
 */