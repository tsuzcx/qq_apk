package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RoundRectLinearLayout
  extends LinearLayout
{
  private Paint a = new Paint();
  private int b;
  private int c;
  private Path d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private int i;
  private int j;
  private Path k;
  
  public RoundRectLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.a.setAntiAlias(true);
    this.a.setColor(-1);
    this.a.setStyle(Paint.Style.FILL);
  }
  
  public RoundRectLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setAntiAlias(true);
    this.a.setColor(-1);
    this.a.setStyle(Paint.Style.FILL);
  }
  
  private void a()
  {
    if (this.d == null) {
      this.d = new Path();
    }
    this.d.reset();
    if (this.g)
    {
      this.d.moveTo(0.0F, this.c);
      this.d.lineTo(0.0F, 0.0F);
    }
    else
    {
      this.d.moveTo(this.f + 0, this.c - 0);
      localPath = this.d;
      f1 = 0;
      m = this.c;
      n = this.f;
      localPath.arcTo(new RectF(f1, m - n * 2 - 0, n * 2 + 0, m - 0), 90.0F, 90.0F);
      localPath = this.d;
      m = this.f;
      localPath.arcTo(new RectF(f1, f1, m * 2 + 0, m * 2 + 0), 180.0F, 90.0F);
    }
    Path localPath = this.d;
    int m = this.b;
    int n = this.f;
    localPath.arcTo(new RectF(m - n * 2 - 0, 0, m - 0, n * 2 + 0), -90.0F, 90.0F);
    localPath = this.d;
    m = this.b;
    n = this.f;
    float f1 = m - n * 2 - 0;
    int i1 = this.c;
    localPath.arcTo(new RectF(f1, i1 - n * 2 - 0, m - 0, i1 - 0), 0.0F, 90.0F);
    this.d.close();
    if (this.i > 0)
    {
      this.k = new Path();
      this.k.reset();
      localPath = this.k;
      m = this.j;
      localPath.moveTo(this.i + m, this.c - m);
      localPath = this.k;
      m = this.j;
      f1 = m;
      n = this.c;
      i1 = this.i;
      localPath.arcTo(new RectF(f1, n - i1 * 2 - m, i1 * 2 + m, n - m), 90.0F, 90.0F);
      localPath = this.k;
      m = this.j;
      f1 = m;
      float f2 = m;
      n = this.i;
      localPath.arcTo(new RectF(f1, f2, n * 2 + m, m + n * 2), 180.0F, 90.0F);
      localPath = this.k;
      m = this.b;
      n = this.i;
      i1 = this.j;
      localPath.arcTo(new RectF(m - n * 2 - i1, i1, m - i1, i1 + n * 2), -90.0F, 90.0F);
      localPath = this.k;
      m = this.b;
      n = this.i;
      i1 = this.j;
      f1 = m - n * 2 - i1;
      int i2 = this.c;
      localPath.arcTo(new RectF(f1, i2 - n * 2 - i1, m - i1, i2 - i1), 0.0F, 90.0F);
      this.k.close();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.d != null)
    {
      this.a.setColor(this.e);
      this.a.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.d, this.a);
    }
    if ((this.i > 0) && (this.k != null))
    {
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setStrokeWidth(this.i);
      this.a.setColor(this.h);
      paramCanvas.drawPath(this.k, this.a);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.b) || (paramInt2 != this.c))
    {
      this.b = paramInt1;
      this.c = paramInt2;
      a();
    }
  }
  
  public void setInnerRoundRect(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
  }
  
  public void setRoundRect(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.f != paramInt1)
    {
      this.f = paramInt1;
      a();
    }
    this.e = paramInt2;
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout
 * JD-Core Version:    0.7.0.1
 */