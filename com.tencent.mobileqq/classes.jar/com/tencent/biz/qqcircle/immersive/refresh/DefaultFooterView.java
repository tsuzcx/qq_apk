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

public class DefaultFooterView
  extends View
  implements IQFSRefreshView
{
  private boolean a;
  private RectF b;
  private int c;
  private int d;
  private int e;
  private int f;
  private float g;
  private float h;
  private Paint i;
  private Paint.FontMetrics j;
  private float k;
  private float l;
  private String m = HardCodeUtil.a(2131889531);
  private String n = HardCodeUtil.a(2131889535);
  private String o = HardCodeUtil.a(2131889529);
  private String p = HardCodeUtil.a(2131889528);
  private String q = HardCodeUtil.a(2131889530);
  private String r = this.m;
  private boolean s = true;
  private boolean t = true;
  private int u;
  private boolean v = false;
  private boolean w = false;
  private Paint x = new Paint(1);
  private int y;
  private int z;
  
  public DefaultFooterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DefaultFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(ViewUtils.a(1.5F));
    this.x.setStrokeCap(Paint.Cap.ROUND);
    this.x.setColor(-12303292);
    this.i = new Paint(1);
    this.i.setTextSize(ViewUtils.a(16.0F));
    this.i.setColor(-12303292);
    this.i.setTextAlign(Paint.Align.CENTER);
    this.j = this.i.getFontMetrics();
    this.c = ViewUtils.a(30.0F);
    this.d = this.c;
    this.z = ViewUtils.a(50.0F);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.gravity = 17;
    setLayoutParams(paramContext);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawText(this.r, this.k, this.l, this.i);
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
    paramCanvas.drawPath(localPath, this.x);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (!this.w) {
      return;
    }
    paramCanvas.save();
    paramCanvas.rotate(this.g, this.b.centerX(), this.b.centerY());
    this.h += 1.0F;
    if (this.h == 3.0F)
    {
      float f1 = this.g;
      if (f1 < 360.0F) {
        f1 += 30.0F;
      } else {
        f1 = 0.0F;
      }
      this.g = f1;
      this.h = 0.0F;
    }
    int i1 = 0;
    while (i1 < 12)
    {
      i1 += 1;
      int i2 = i1 * 255 / 11;
      this.x.setAlpha(i2);
      paramCanvas.drawLine(this.b.centerX(), this.b.centerY() - this.d / 3, this.b.centerX(), this.b.centerY() - this.c / 6, this.x);
      paramCanvas.rotate(30.0F, this.b.centerX(), this.b.centerY());
    }
    paramCanvas.restore();
    if (this.a) {
      invalidate();
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (!this.s) {
      return;
    }
    paramCanvas.save();
    paramCanvas.rotate(this.u, this.b.centerX(), this.b.centerY());
    a(paramCanvas, this.e + this.c / 2, this.b.bottom - ViewUtils.a(4.0F), this.e + this.c / 2, this.f + ViewUtils.a(4.0F), 40, 30.0F);
    if (this.v)
    {
      if (this.t)
      {
        this.u -= 15;
        if (this.u <= -180)
        {
          this.u = -180;
          this.v = false;
        }
      }
      else
      {
        this.u += 15;
        if (this.u >= 0)
        {
          this.u = 0;
          this.v = false;
        }
      }
      invalidate();
    }
    paramCanvas.restore();
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    this.g = 0.0F;
    this.s = true;
    this.u = 0;
    this.w = false;
    this.v = false;
    this.t = true;
    this.r = this.m;
    this.a = false;
    this.x.setColor(-12303292);
    invalidate();
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, float paramFloat)
  {
    if (paramFloat >= 1.0F)
    {
      this.r = this.n;
      if (!this.t)
      {
        this.t = true;
        this.v = true;
      }
    }
    else
    {
      this.r = this.m;
      if (this.t)
      {
        this.t = false;
        this.v = true;
      }
    }
    invalidate();
  }
  
  public void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a = false;
      this.r = this.p;
      return;
    }
    this.s = false;
    this.w = false;
    this.r = this.q;
  }
  
  public void b(QFSPullRefreshLayout paramQFSPullRefreshLayout)
  {
    this.a = true;
    this.s = false;
    this.w = true;
    this.r = this.o;
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
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = (int)this.i.measureText(this.r);
    this.y = ((i3 / 2 + this.c + ViewUtils.a(20.0F)) * 2);
    int i1 = resolveSize(this.y, paramInt1);
    int i2 = this.y;
    paramInt1 = i1;
    if (i1 < i2) {
      paramInt1 = i2;
    }
    i1 = resolveSize(this.z, paramInt2);
    i2 = this.z;
    paramInt2 = i1;
    if (i1 < i2) {
      paramInt2 = i2;
    }
    setMeasuredDimension(paramInt1, paramInt2);
    this.f = ((getMeasuredHeight() - this.d) / 2);
    this.e = ((getMeasuredWidth() - i3) / 2 - this.c - ViewUtils.a(20.0F));
    paramInt1 = this.e;
    float f1 = paramInt1;
    paramInt2 = this.f;
    this.b = new RectF(f1, paramInt2, paramInt1 + this.c, paramInt2 + this.d);
    this.k = (getMeasuredWidth() / 2);
    f1 = this.j.bottom;
    float f2 = this.j.top;
    this.l = ((getMeasuredHeight() - (f1 - f2)) / 2.0F - this.j.top);
  }
  
  public void setCircleColor(int paramInt)
  {
    this.x.setColor(paramInt);
  }
  
  public void setFinishText(String paramString)
  {
    this.p = paramString;
  }
  
  public void setLoadingText(String paramString)
  {
    this.o = paramString;
  }
  
  public void setNoDataText(String paramString)
  {
    this.q = paramString;
  }
  
  public void setReleaseText(String paramString)
  {
    this.n = paramString;
  }
  
  public void setStartText(String paramString)
  {
    this.m = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    this.i.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.DefaultFooterView
 * JD-Core Version:    0.7.0.1
 */