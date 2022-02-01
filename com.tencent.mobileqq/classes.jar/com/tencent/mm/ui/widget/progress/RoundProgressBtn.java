package com.tencent.mm.ui.widget.progress;

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
import com.tencent.mm.ui.g;

public class RoundProgressBtn
  extends View
{
  public static final int FILL = 1;
  public static final int STROKE = 0;
  private Paint a;
  private int b;
  private float c;
  private int d;
  private float e;
  private int f;
  private int g;
  private int h;
  private int i = 0;
  private int j = 0;
  private int k = g.b(getContext(), 2131296317);
  
  public RoundProgressBtn(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public RoundProgressBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.a = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundProgressBtn, paramInt, 0);
      this.b = paramContext.getColor(R.styleable.RoundProgressBtn_roundColor, getContext().getResources().getColor(2131167884));
      this.c = paramContext.getDimension(R.styleable.RoundProgressBtn_roundwidth, 0.0F);
      this.d = paramContext.getColor(R.styleable.RoundProgressBtn_progressColor, getContext().getResources().getColor(2131168455));
      this.e = paramContext.getDimension(R.styleable.RoundProgressBtn_progressWidth, this.c);
      this.f = paramContext.getInt(R.styleable.RoundProgressBtn_max, 100);
      this.h = paramContext.getInt(R.styleable.RoundProgressBtn_progress, 0);
      this.g = paramContext.getInt(R.styleable.RoundProgressBtn_startAngle, -90);
      paramContext.recycle();
    }
  }
  
  public int getProgress()
  {
    return this.h;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = getWidth() / 2;
    if (this.c == 0.0F)
    {
      double d1 = getWidth() / 2;
      Double.isNaN(d1);
      this.c = ((int)(d1 * 0.167D));
    }
    float f2 = this.c;
    this.e = f2;
    this.i = ((int)f2);
    float f1 = m;
    this.j = ((int)(0.667F * f1));
    int n = (int)(f1 - f2 / 2.0F);
    this.a.setStrokeWidth(f2);
    this.a.setColor(this.b);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(f1, f1, n, this.a);
    this.a.setStrokeWidth(this.e);
    this.a.setStrokeCap(Paint.Cap.ROUND);
    this.a.setColor(this.d);
    f2 = m - n;
    float f3 = n + m;
    RectF localRectF = new RectF(f2, f2, f3, f3);
    n = this.h * 360 / this.f;
    paramCanvas.drawArc(localRectF, this.g, n, false, this.a);
    this.a.setStrokeWidth(0.0F);
    this.a.setStyle(Paint.Style.FILL);
    f2 = this.c;
    n = this.j;
    paramCanvas.drawRect(f1 - f2 * 1.5F, m - n / 2, f1 - f2 * 0.5F, n / 2 + m, this.a);
    n = this.i;
    f2 = n;
    int i1 = this.j;
    paramCanvas.drawRect(f1 + f2 * 0.5F, m - i1 / 2, f1 + n * 1.5F, m + i1 / 2, this.a);
  }
  
  public void setProgress(int paramInt)
  {
    this.h = Math.max(0, paramInt);
    this.h = Math.min(paramInt, this.f);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */