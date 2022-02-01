package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.mobileqq.biz.qcircle.R.styleable;

public class QFSRoundProgressView
  extends AppCompatImageView
{
  private int a;
  private int b;
  private Paint c;
  private Path d;
  private RectF e;
  private int f;
  private int g;
  private int h;
  private int i;
  private Rect j;
  private RectF k;
  private String l;
  private float m;
  private float n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private float w;
  private int x;
  private int y;
  private int z;
  
  public QFSRoundProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFSRoundProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QFSRoundProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    this.l = "0%";
    this.m = -90.0F;
    this.x = 0;
    this.z = 0;
    this.y = 0;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 100)) {
      return;
    }
    throw new RuntimeException("The progress should be between 0 and 100.");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(paramInt1);
    a(paramInt2);
    if (paramInt1 <= paramInt2) {
      return;
    }
    throw new RuntimeException("The startProgress should be less than endProgress.");
  }
  
  private void a(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.dm, paramInt, 0);
    this.q = paramContext.getDimensionPixelSize(R.styleable.dx, (int)TypedValue.applyDimension(2, 16.0F, getResources().getDisplayMetrics()));
    this.f = paramContext.getDimensionPixelSize(R.styleable.ds, (int)TypedValue.applyDimension(1, 4.0F, getResources().getDisplayMetrics()));
    this.g = paramContext.getDimensionPixelSize(R.styleable.dn, (int)TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics()));
    this.r = paramContext.getColor(R.styleable.dw, -16777216);
    this.t = paramContext.getColor(R.styleable.do, -16777216);
    this.h = paramContext.getColor(R.styleable.dv, -2147483648);
    this.i = paramContext.getColor(R.styleable.dt, 872415231);
    this.s = paramContext.getDimensionPixelSize(R.styleable.dr, (int)TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics()));
    this.u = paramContext.getColor(R.styleable.dp, -16777216);
    this.v = paramContext.getInt(R.styleable.du, 10);
    this.w = paramContext.getDimensionPixelSize(R.styleable.dq, (int)TypedValue.applyDimension(1, 35.0F, getResources().getDisplayMetrics()));
    paramContext.recycle();
  }
  
  private void a(Canvas paramCanvas)
  {
    this.c.setColor(this.t);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.s);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    paramCanvas.drawCircle(this.o, this.p, this.w, this.c);
    this.c.setColor(this.u);
    Object localObject = this.k;
    int i1 = this.o;
    float f1 = i1;
    float f2 = this.w;
    int i2 = this.p;
    ((RectF)localObject).set(f1 - f2, i2 - f2, i1 + f2, i2 + f2);
    paramCanvas.drawArc(this.k, this.m, this.n, false, this.c);
    this.c.setColor(this.r);
    this.c.setStyle(Paint.Style.FILL_AND_STROKE);
    this.c.setStrokeWidth(0.0F);
    this.c.setTextSize(this.q);
    localObject = this.c;
    String str = this.l;
    ((Paint)localObject).getTextBounds(str, 0, str.length(), this.j);
    paramCanvas.drawText(this.l, this.o - this.j.width() / 2.0F, this.p + this.j.height() / 2.0F, this.c);
  }
  
  private void b()
  {
    this.c = new Paint(1);
    this.d = new Path();
    this.e = new RectF();
    this.j = new Rect();
    this.k = new RectF();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.d.reset();
    this.e.set(getPaddingLeft(), getPaddingTop(), this.a - getPaddingRight(), this.b - getPaddingBottom());
    Object localObject = this.d;
    RectF localRectF = this.e;
    int i1 = this.f;
    ((Path)localObject).addRoundRect(localRectF, i1, i1, Path.Direction.CW);
    this.d.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.d);
    super.onDraw(paramCanvas);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(this.h);
    localObject = this.e;
    i1 = this.f;
    paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.c);
    this.c.setStrokeWidth(this.g);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(this.i);
    localObject = this.e;
    i1 = this.f;
    paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.c);
    a(paramCanvas);
    i1 = this.y;
    if (i1 < this.z)
    {
      this.y = (i1 + 1);
      i1 = this.y;
      this.n = (i1 * 3.6F);
      this.x = i1;
      paramCanvas = new StringBuilder();
      paramCanvas.append(this.y);
      paramCanvas.append("%");
      this.l = paramCanvas.toString();
      postInvalidateDelayed(this.v);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = View.MeasureSpec.getSize(paramInt1);
    this.b = View.MeasureSpec.getSize(paramInt2);
    this.o = (this.a >> 1);
    this.p = (this.b >> 1);
  }
  
  public void setCorner(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setCover(Drawable paramDrawable)
  {
    setImageDrawable(paramDrawable);
  }
  
  public void setProgress(int paramInt)
  {
    a(paramInt);
    this.n = (paramInt * 3.6F);
    this.x = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    this.l = localStringBuilder.toString();
    postInvalidate();
  }
  
  public void setProgressRange(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.y = paramInt1;
    this.z = paramInt2;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSRoundProgressView
 * JD-Core Version:    0.7.0.1
 */