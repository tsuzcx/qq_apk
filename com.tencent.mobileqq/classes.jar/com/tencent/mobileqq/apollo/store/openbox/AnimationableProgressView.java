package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;

public class AnimationableProgressView
  extends View
{
  private int a;
  private int b;
  private Path c;
  private RectF d;
  private Paint e;
  private int f = 5;
  private int g = 3;
  private float h;
  private String i;
  private float j;
  private int k;
  private int l;
  private int m;
  private int n;
  private long o;
  private long p;
  private int q;
  
  public AnimationableProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AnimationableProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.e = new Paint(1);
    this.e.setStyle(Paint.Style.STROKE);
    this.l = -3946292;
    this.m = -1;
    this.n = -1972505;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.g = paramInt1;
    this.f = paramInt2;
    this.o = paramLong1;
    this.p = paramLong2;
    if ((this.g >= 0) && (this.f > 0) && (this.a != 0))
    {
      if (this.b == 0) {
        return;
      }
      if (this.p > 0L)
      {
        if (this.o > 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131898519));
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131898521));
          this.i = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131898516));
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(this.f);
          this.i = ((StringBuilder)localObject).toString();
        }
        this.q = -34816;
      }
      else
      {
        this.q = -16777216;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131898518));
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131898517));
        this.i = ((StringBuilder)localObject).toString();
        if (this.g > 0)
        {
          if (this.c == null) {
            this.c = new Path();
          }
          this.c.reset();
          paramInt1 = this.a * this.g / this.f;
          this.c.moveTo(this.k, this.b);
          localObject = this.c;
          paramInt2 = this.b;
          int i1 = this.k;
          ((Path)localObject).arcTo(new RectF(0.0F, paramInt2 - i1 * 2, i1 * 2, paramInt2), 90.0F, 90.0F);
          localObject = this.c;
          paramInt2 = this.k;
          ((Path)localObject).arcTo(new RectF(0.0F, 0.0F, paramInt2 * 2, paramInt2 * 2), 180.0F, 90.0F);
          if (this.g >= this.f)
          {
            localObject = this.c;
            paramInt1 = this.a;
            paramInt2 = this.k;
            ((Path)localObject).arcTo(new RectF(paramInt1 - paramInt2 * 2, 0.0F, paramInt1, paramInt2 * 2), -90.0F, 90.0F);
            localObject = this.c;
            paramInt1 = this.a;
            paramInt2 = this.k;
            f1 = paramInt1 - paramInt2 * 2;
            i1 = this.b;
            ((Path)localObject).arcTo(new RectF(f1, i1 - paramInt2 * 2, paramInt1, i1), 0.0F, 90.0F);
          }
          else
          {
            localObject = this.c;
            f1 = paramInt1;
            ((Path)localObject).lineTo(f1, 0.0F);
            this.c.lineTo(f1, this.b);
          }
          this.c.close();
        }
      }
      this.e.setTextSize(getResources().getDisplayMetrics().density * 14.0F);
      if (TextUtils.isEmpty(this.i))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131898520));
        this.i = ((StringBuilder)localObject).toString();
      }
      float f1 = this.e.measureText(this.i);
      this.h = ((this.a - f1) / 2.0F);
      Object localObject = this.e.getFontMetrics();
      this.j = ((this.b - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F);
      super.invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if ((this.p <= 0L) && (this.o <= 0L) && (this.d != null))
    {
      this.e.setColor(this.m);
      this.e.setStyle(Paint.Style.FILL);
      RectF localRectF = this.d;
      int i1 = this.k;
      paramCanvas.drawRoundRect(localRectF, i1, i1, this.e);
      if (this.c != null)
      {
        this.e.setColor(this.n);
        this.e.setStyle(Paint.Style.FILL);
        paramCanvas.drawPath(this.c, this.e);
      }
      this.e.setColor(this.l);
      this.e.setStyle(Paint.Style.STROKE);
      localRectF = this.d;
      i1 = this.k;
      paramCanvas.drawRoundRect(localRectF, i1, i1, this.e);
    }
    if (!TextUtils.isEmpty(this.i))
    {
      this.e.setColor(this.q);
      paramCanvas.drawText(this.i, this.h, this.j, this.e);
    }
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.a) || (paramInt2 != this.b))
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.k = ((int)(this.b * 0.16F));
      a(this.g, this.f, this.o, this.p);
      if (this.d == null) {
        this.d = new RectF();
      }
      RectF localRectF = this.d;
      localRectF.left = 0.0F;
      localRectF.right = this.a;
      localRectF.top = 0.0F;
      localRectF.bottom = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.AnimationableProgressView
 * JD-Core Version:    0.7.0.1
 */