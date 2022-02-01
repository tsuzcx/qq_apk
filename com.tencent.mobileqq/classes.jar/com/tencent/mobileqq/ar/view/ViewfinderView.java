package com.tencent.mobileqq.ar.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public final class ViewfinderView
  extends View
{
  private final Paint a = new Paint(1);
  private final int b;
  private Rect c = new Rect();
  private int d = 18;
  private Bitmap e;
  private int f;
  private int g;
  private int h = 0;
  private int i;
  private int j;
  private int k;
  private String l;
  private int m;
  private boolean n;
  private float o;
  private float p;
  private Rect q;
  private String r;
  private List<AIRect> s;
  private ValueAnimator t;
  private float u;
  private boolean v = true;
  private Rect w = new Rect();
  private RectF x = new RectF();
  private Rect y = new Rect();
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = BitmapFactory.decodeResource(paramContext.getResources(), 2130846323);
    this.d = this.e.getHeight();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewfinderView);
    this.f = paramAttributeSet.getDimensionPixelSize(4, a(paramContext, 3.0F));
    int i1 = this.f;
    if ((i1 & 0x1) != 0) {
      this.f = (i1 + 1);
    }
    this.g = paramAttributeSet.getDimensionPixelSize(1, a(paramContext, 16.0F));
    this.i = paramAttributeSet.getDimensionPixelSize(3, a(paramContext, 2.0F));
    this.k = paramAttributeSet.getColor(0, Color.parseColor("#12B7F5"));
    this.j = paramAttributeSet.getColor(2, -16776961);
    this.b = paramAttributeSet.getColor(14, Color.parseColor("#000000"));
    this.l = paramAttributeSet.getString(16);
    if (TextUtils.isEmpty(this.l)) {
      this.l = HardCodeUtil.a(2131913644);
    }
    this.m = paramAttributeSet.getColor(15, Color.parseColor("#FFFFFF"));
    this.n = paramAttributeSet.getBoolean(19, false);
    this.o = paramAttributeSet.getDimensionPixelSize(17, a(paramContext, 20.0F));
    this.p = paramAttributeSet.getDimensionPixelSize(18, b(paramContext, 14.0F));
    this.h = a(paramContext, 8.0F);
    paramAttributeSet.recycle();
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(Rect paramRect, Canvas paramCanvas)
  {
    this.a.reset();
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(this.k);
    this.a.setAntiAlias(true);
    this.w.set(paramRect.left - this.h, paramRect.top - this.h, paramRect.right + this.h, paramRect.bottom + this.h);
    this.x.set(this.w.left, this.w.top, this.w.left + this.g, this.w.top + this.f);
    paramRect = this.x;
    int i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.x.set(this.w.left, this.w.top, this.w.left + this.f, this.w.top + this.g);
    paramRect = this.x;
    i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.x.set(this.w.right - this.g, this.w.top, this.w.right, this.w.top + this.f);
    paramRect = this.x;
    i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.x.set(this.w.right - this.f, this.w.top, this.w.right, this.w.top + this.g);
    paramRect = this.x;
    i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.x.set(this.w.left, this.w.bottom - this.g, this.w.left + this.f, this.w.bottom);
    paramRect = this.x;
    i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.x.set(this.w.left, this.w.bottom - this.f, this.w.left + this.g, this.w.bottom);
    paramRect = this.x;
    i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.x.set(this.w.right - this.g, this.w.bottom - this.f, this.w.right, this.w.bottom);
    paramRect = this.x;
    i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.x.set(this.w.right - this.f, this.w.bottom - this.g, this.w.right, this.w.bottom);
    paramRect = this.x;
    i1 = this.f;
    paramCanvas.drawRoundRect(paramRect, i1 / 2, i1 / 2, this.a);
    this.a.reset();
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  private void b(Rect paramRect, Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipRect(paramRect);
    if (this.t == null)
    {
      this.t = ValueAnimator.ofFloat(new float[] { paramRect.top - this.d, paramRect.bottom - this.d });
      this.t.setDuration(3000L);
      this.t.setRepeatCount(-1);
      this.t.setRepeatMode(1);
      this.t.setInterpolator(new LinearInterpolator());
      this.t.addUpdateListener(new ViewfinderView.1(this, paramRect));
      this.v = true;
    }
    if (this.v)
    {
      this.t.start();
      this.v = false;
    }
    this.a.setAntiAlias(true);
    this.a.setDither(true);
    this.a.setFilterBitmap(true);
    this.c.set(paramRect.left, (int)this.u, paramRect.right, (int)this.u + this.d);
    paramCanvas.drawBitmap(this.e, null, this.c, this.a);
    paramCanvas.restore();
    this.a.reset();
  }
  
  private void c(Rect paramRect, Canvas paramCanvas)
  {
    if (this.n)
    {
      this.a.setAntiAlias(true);
      this.a.setTextSize(this.p);
      this.a.setColor(this.m);
      this.a.setTextAlign(Paint.Align.CENTER);
      Object localObject = this.a;
      String str = this.l;
      ((Paint)localObject).getTextBounds(str, 0, str.length(), this.y);
      localObject = this.l;
      paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), paramRect.centerX(), paramRect.centerY() + paramRect.height() / 2 + this.o + this.y.height(), this.a);
      this.a.reset();
    }
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.t;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.t = null;
    }
  }
  
  public void onDetachedFromWindow()
  {
    QLog.d("viewFinderView", 1, "onDetachedFromWindow ");
    super.onDetachedFromWindow();
    a();
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    if (localObject == null) {
      return;
    }
    paramCanvas.getWidth();
    paramCanvas.getHeight();
    this.a.setColor(this.b);
    this.a.setAntiAlias(true);
    a((Rect)localObject, paramCanvas);
    b((Rect)localObject, paramCanvas);
    c((Rect)localObject, paramCanvas);
    localObject = this.s;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AIRect localAIRect = (AIRect)((Iterator)localObject).next();
        this.a.setColor(-65536);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(4.0F);
        paramCanvas.drawRect(localAIRect.b, this.a);
      }
    }
    if (!TextUtils.isEmpty(this.r))
    {
      localObject = new TextPaint();
      ((TextPaint)localObject).setColor(-65536);
      ((TextPaint)localObject).setStyle(Paint.Style.FILL);
      ((TextPaint)localObject).setStrokeWidth(2.0F);
      ((TextPaint)localObject).setTextSize(AIOUtils.b(12.0F, getResources()));
      paramCanvas.drawText(this.r, 90.0F, 90.0F, (Paint)localObject);
    }
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVisibilityChanged ");
    localStringBuilder.append(paramInt);
    QLog.d("viewFinderView", 2, localStringBuilder.toString());
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      a();
    }
  }
  
  public void setDetectRect(List<AIRect> paramList)
  {
    this.s = paramList;
    postInvalidate();
  }
  
  public void setMiniText(String paramString)
  {
    this.r = paramString;
    postInvalidate();
  }
  
  public void setRect(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.q)))
    {
      this.q = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      paramRect = this.t;
      if (paramRect != null)
      {
        paramRect.cancel();
        this.t = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ViewfinderView
 * JD-Core Version:    0.7.0.1
 */