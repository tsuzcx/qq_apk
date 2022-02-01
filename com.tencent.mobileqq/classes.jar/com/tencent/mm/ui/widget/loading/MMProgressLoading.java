package com.tencent.mm.ui.widget.loading;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class MMProgressLoading
  extends View
{
  private Paint a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public MMProgressLoading(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public MMProgressLoading(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public MMProgressLoading(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.a = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ProgressLoading, paramInt, 0);
      this.b = paramContext.getColor(R.styleable.ProgressLoading_loadProgressColor, getResources().getColor(2131165364));
      this.c = paramContext.getInt(R.styleable.ProgressLoading_loadMax, 100);
      this.e = paramContext.getInt(R.styleable.ProgressLoading_loadprogress, 0);
      this.d = paramContext.getInt(R.styleable.ProgressLoading_loadStartAngle, -90);
      paramContext.recycle();
    }
  }
  
  public int getProgress()
  {
    return this.e;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    double d1 = getWidth() / 2;
    Double.isNaN(d1);
    int j = (int)(d1 * 0.175D);
    int k = i - j / 2 - 1;
    int m = getResources().getColor(2131165350);
    Object localObject = this.a;
    float f1 = j;
    ((Paint)localObject).setStrokeWidth(f1);
    this.a.setColor(m);
    this.a.setAlpha(127);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    float f2 = i;
    float f3 = k;
    paramCanvas.drawCircle(f2, f2, f3, this.a);
    this.a.setStrokeWidth(f1);
    this.a.setColor(this.b);
    this.a.setAlpha(51);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(f2, f2, f3, this.a);
    this.a.setStrokeWidth(f1);
    this.a.setStrokeCap(Paint.Cap.ROUND);
    this.a.setColor(this.b);
    f1 = i - k;
    f2 = i + k;
    localObject = new RectF(f1, f1, f2, f2);
    i = this.e * 360 / this.c;
    paramCanvas.drawArc((RectF)localObject, this.d, i, false, this.a);
  }
  
  public void setProgress(int paramInt)
  {
    this.e = Math.max(0, paramInt);
    this.e = Math.min(paramInt, this.c);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.loading.MMProgressLoading
 * JD-Core Version:    0.7.0.1
 */