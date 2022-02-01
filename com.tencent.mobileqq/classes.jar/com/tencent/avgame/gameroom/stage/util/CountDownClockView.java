package com.tencent.avgame.gameroom.stage.util;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class CountDownClockView
  extends ImageView
  implements IBaseCountDownClockView
{
  private static final String b = "com.tencent.avgame.gameroom.stage.util.CountDownClockView";
  ValueAnimator a;
  private int c;
  private int d;
  private RectF e = new RectF();
  private Paint f = new Paint();
  private Path g = new Path();
  private Paint h = new Paint();
  private RectF i = new RectF();
  private RectF j = new RectF();
  private IBaseCountDownClockView.OnCountDownListener k;
  private int l = 0;
  private final int m = -90;
  private final int n = 360;
  
  public CountDownClockView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CountDownClockView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CountDownClockView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.f.setColor(-469632);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setFlags(1);
    setBackgroundResource(2130838782);
    this.h.setColor(-1831);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setFlags(1);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.translate(this.c * 0.5F, this.d * 0.5625F);
    paramCanvas.drawArc(this.e, -90.0F, this.l, true, this.f);
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.l);
    c(paramCanvas);
    paramCanvas.restore();
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.g, this.h);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (paramLong2 > paramLong1) {
      return;
    }
    ValueAnimator localValueAnimator = this.a;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    double d1 = paramLong2 * 360L;
    Double.isNaN(d1);
    double d2 = paramLong1;
    Double.isNaN(d2);
    this.a = ValueAnimator.ofInt(new int[] { (int)(d1 * 1.0D / d2), 360 }).setDuration(paramLong1 - paramLong2);
    this.a.setInterpolator(new LinearInterpolator());
    this.a.addUpdateListener(new CountDownClockView.1(this));
    ValueAnimatorUtil.a();
    this.a.start();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    a(paramCanvas);
    c(paramCanvas);
    b(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = this.c;
    if ((paramInt3 == 0) || (paramInt3 != paramInt1))
    {
      this.c = paramInt1;
      this.d = paramInt2;
      this.g.reset();
      float f1 = this.c * 0.025F;
      Object localObject = this.g;
      float f2 = -f1;
      ((Path)localObject).moveTo(f2, 0.0F);
      this.i.set(f2, f2, f1, f1);
      this.g.addArc(this.i, 180.0F, -180.0F);
      this.g.lineTo(f1, this.c * -0.1625F);
      localObject = this.j;
      paramInt1 = this.c;
      ((RectF)localObject).set(f2, paramInt1 * -0.1875F, f1, paramInt1 * -0.1375F);
      this.g.addArc(this.j, 0.0F, -180.0F);
      this.g.lineTo(f2, 0.0F);
      f1 = this.c * 0.1875F;
      localObject = this.e;
      f2 = -f1;
      ((RectF)localObject).set(f2, f2, f1, f1);
    }
  }
  
  public void setOnTimeEndListener(IBaseCountDownClockView.OnCountDownListener paramOnCountDownListener)
  {
    this.k = paramOnCountDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.CountDownClockView
 * JD-Core Version:    0.7.0.1
 */