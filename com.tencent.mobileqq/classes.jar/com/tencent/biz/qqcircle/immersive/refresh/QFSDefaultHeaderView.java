package com.tencent.biz.qqcircle.immersive.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;

public class QFSDefaultHeaderView
  extends View
  implements IQFSRefreshView
{
  private RectF a;
  private int b;
  private int c;
  private float d;
  private int e;
  private int f;
  private float g;
  private boolean h;
  private Paint i;
  private Paint.FontMetrics j;
  private float k;
  private float l;
  private String m = HardCodeUtil.a(2131916802);
  private boolean n = true;
  private boolean o = false;
  private int p;
  private boolean q = false;
  private boolean r = false;
  private Paint s = new Paint(1);
  private Path t;
  private int u;
  private int v;
  private String w = HardCodeUtil.a(2131916802);
  private String x = HardCodeUtil.a(2131916804);
  private String y = HardCodeUtil.a(2131916801);
  private String z = HardCodeUtil.a(2131916805);
  
  public QFSDefaultHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFSDefaultHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.s.setStyle(Paint.Style.STROKE);
    this.s.setStrokeWidth(ViewUtils.a(1.5F));
    this.s.setStrokeCap(Paint.Cap.ROUND);
    this.s.setColor(-12303292);
    this.i = new Paint(1);
    this.i.setTextSize(ViewUtils.a(16.0F));
    this.i.setColor(-12303292);
    this.i.setTextAlign(Paint.Align.CENTER);
    this.j = this.i.getFontMetrics();
    this.t = new Path();
    this.b = ViewUtils.a(28.0F);
    this.c = this.b;
    this.u = ViewUtils.a(170.0F);
    this.v = ViewUtils.a(50.0F);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.gravity = 17;
    setLayoutParams(paramContext);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawText(this.m, this.k, this.l, this.i);
    paramCanvas.restore();
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5)
  {
    double d1 = Math.atan2(paramFloat2 - paramFloat4, paramFloat1 - paramFloat3) * 180.0D / 3.141592653589793D;
    double d2 = paramInt;
    Double.isNaN(d2);
    double d4 = (d1 + d2) * 3.141592653589793D / 180.0D;
    Double.isNaN(d2);
    d2 = (d1 - d2) * 3.141592653589793D / 180.0D;
    d1 = paramFloat5;
    double d3 = Math.cos(d4);
    Double.isNaN(d1);
    d3 *= d1;
    d4 = Math.sin(d4);
    Double.isNaN(d1);
    d4 *= d1;
    Path localPath = new Path();
    double d5 = paramFloat1;
    Double.isNaN(d5);
    paramFloat5 = (float)(d5 - d3);
    d5 = paramFloat2;
    Double.isNaN(d5);
    localPath.moveTo(paramFloat5, (float)(d5 - d4));
    localPath.moveTo(paramFloat1, paramFloat2);
    localPath.lineTo(paramFloat3, paramFloat4);
    d5 = paramFloat3;
    Double.isNaN(d5);
    paramFloat1 = (float)(d3 + d5);
    d3 = paramFloat4;
    Double.isNaN(d3);
    localPath.moveTo(paramFloat1, (float)(d4 + d3));
    localPath.lineTo(paramFloat3, paramFloat4);
    d4 = Math.cos(d2);
    Double.isNaN(d1);
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    Double.isNaN(d5);
    paramFloat1 = (float)(d5 + d4 * d1);
    Double.isNaN(d3);
    localPath.lineTo(paramFloat1, (float)(d3 + d1 * d2));
    paramCanvas.drawPath(localPath, this.s);
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.g, this.a.centerX(), this.a.centerY());
    this.t.reset();
    this.t.arcTo(this.a, 280.0F, this.d, true);
    paramCanvas.drawPath(this.t, this.s);
    paramCanvas.restore();
    if (this.h)
    {
      if (this.g >= 360.0F) {
        this.g = 0.0F;
      }
      this.g += 10.0F;
      invalidate();
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (!this.r) {
      return;
    }
    paramCanvas.save();
    this.t.reset();
    this.t.moveTo(this.a.centerX() - this.b / 2 + ViewUtils.a(4.0F), this.a.centerY());
    this.t.lineTo(this.a.centerX() - ViewUtils.a(2.0F), this.a.centerY() + this.b / 2 - ViewUtils.a(8.0F));
    this.t.lineTo(this.a.centerX() + this.b / 2 - ViewUtils.a(6.0F), this.a.centerY() - ViewUtils.a(6.0F));
    paramCanvas.drawPath(this.t, this.s);
    paramCanvas.restore();
  }
  
  private void d(Canvas paramCanvas)
  {
    if (!this.n) {
      return;
    }
    paramCanvas.save();
    paramCanvas.rotate(this.p, this.a.centerX(), this.a.centerY());
    a(paramCanvas, this.e + this.b / 2, this.f + ViewUtils.a(4.0F), this.e + this.b / 2, this.f + this.c - ViewUtils.a(4.0F), 40, 30.0F);
    if (this.q)
    {
      if (this.o)
      {
        this.p -= 15;
        if (this.p <= -180)
        {
          this.p = -180;
          this.q = false;
        }
      }
      else
      {
        this.p += 15;
        if (this.p >= 0)
        {
          this.p = 0;
          this.q = false;
        }
      }
      invalidate();
    }
    paramCanvas.restore();
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    this.g = 0.0F;
    this.d = 0.0F;
    this.n = true;
    this.p = 0;
    this.r = false;
    this.q = false;
    this.o = false;
    this.m = this.w;
    this.h = false;
    invalidate();
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, float paramFloat)
  {
    this.d = (340.0F * paramFloat);
    if (paramFloat >= 1.0F)
    {
      this.m = this.x;
      if (!this.o)
      {
        this.o = true;
        this.q = true;
      }
    }
    else
    {
      this.m = this.w;
      if (this.o)
      {
        this.o = false;
        this.q = true;
      }
    }
    invalidate();
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, boolean paramBoolean)
  {
    this.h = false;
    this.g = 0.0F;
    this.n = false;
    this.r = true;
    this.m = this.z;
    invalidate();
  }
  
  public void b(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    this.h = true;
    this.n = false;
    this.r = false;
    this.m = this.y;
    invalidate();
  }
  
  public View getRefreshView()
  {
    return this;
  }
  
  public int getStartRefreshDistance()
  {
    return 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b(paramCanvas);
    d(paramCanvas);
    a(paramCanvas);
    c(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = resolveSize(this.v, paramInt2);
    int i1 = this.v;
    paramInt1 = paramInt2;
    if (paramInt2 < i1) {
      paramInt1 = i1;
    }
    setMeasuredDimension(this.u, paramInt1);
    this.f = ((getMeasuredHeight() - this.c) / 2);
    this.e = ViewUtils.a(20.0F);
    paramInt1 = this.e;
    float f1 = paramInt1;
    paramInt2 = this.f;
    this.a = new RectF(f1, paramInt2, paramInt1 + this.b, paramInt2 + this.c);
    this.k = ((getMeasuredWidth() - ViewUtils.a(50.0F)) / 2 + ViewUtils.a(50.0F));
    f1 = this.j.bottom;
    float f2 = this.j.top;
    this.l = ((getMeasuredHeight() - (f1 - f2)) / 2.0F - this.j.top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSDefaultHeaderView
 * JD-Core Version:    0.7.0.1
 */