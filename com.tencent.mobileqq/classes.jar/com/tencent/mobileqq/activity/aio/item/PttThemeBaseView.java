package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public abstract class PttThemeBaseView
  extends View
{
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected RectF g;
  protected RectF h;
  protected Xfermode i;
  protected PorterDuffXfermode j;
  protected Bitmap k;
  protected Canvas l;
  protected Bitmap m;
  protected Canvas n;
  protected int o = 1;
  protected int p = 0;
  protected Paint q;
  protected int r = -1;
  protected int s = -1;
  protected int t = 8;
  protected boolean u = false;
  
  public PttThemeBaseView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PttThemeBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PttThemeBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    if ((i1 == paramInt1) && (i2 == paramInt2)) {
      return paramBitmap;
    }
    paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initBitmap change width =");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" oldBitmapWidth =");
      localStringBuilder.append(i1);
      localStringBuilder.append(" oldBitmpHeight=");
      localStringBuilder.append(i2);
      QLog.d("PttBaseView", 2, localStringBuilder.toString());
    }
    return paramBitmap;
  }
  
  private void d()
  {
    this.n.drawColor(0, PorterDuff.Mode.CLEAR);
    int i1 = this.n.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    a(this.n);
    b(this.n);
    this.n.restoreToCount(i1);
  }
  
  protected void a(int paramInt)
  {
    this.q = new Paint();
    this.q.setAntiAlias(true);
    this.q.setStrokeWidth(this.o);
    this.i = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    this.j = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.t = Utils.a(paramInt, getContext().getResources());
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  protected abstract boolean a();
  
  public void b()
  {
    Bitmap localBitmap = this.k;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.k.recycle();
    }
    localBitmap = this.m;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.m.recycle();
    }
    this.k = null;
    this.m = null;
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (this.p != 0)
    {
      c();
      this.q.setXfermode(this.i);
      paramCanvas.drawBitmap(this.k, this.c, this.d, this.q);
      this.q.setXfermode(null);
    }
  }
  
  protected void c()
  {
    if ((this.l != null) && (this.k != null))
    {
      if (!this.u) {
        return;
      }
      this.q.setXfermode(this.j);
      this.l.drawPaint(this.q);
      this.q.setXfermode(null);
      this.q.setColor(this.p);
      this.l.drawRect(this.h, this.q);
    }
  }
  
  public int getThemeColor()
  {
    return this.p;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.g == null) || (this.u)) {
      this.g = new RectF(this.c, this.d, this.e, this.f);
    }
    if (a())
    {
      if (this.u)
      {
        d();
        this.u = false;
      }
      paramCanvas.save();
      paramCanvas.drawBitmap(this.m, null, this.h, this.q);
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout changed=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" bottom=");
      localStringBuilder.append(paramInt4);
      QLog.d("PttBaseView", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.r = ((getMeasuredWidth() - getPaddingRight() + getPaddingLeft()) / 2);
      this.s = ((getMeasuredHeight() + getPaddingTop() - getPaddingBottom()) / 2);
      if (this.r < 0) {
        this.r = 0;
      }
      if (this.s < 0) {
        this.s = 0;
      }
      paramInt2 = this.r;
      paramInt1 = this.t;
      this.c = (paramInt2 - paramInt1);
      this.e = (paramInt2 + paramInt1);
      paramInt2 = this.s;
      this.d = (paramInt2 - paramInt1);
      this.f = (paramInt2 + paramInt1);
      this.k = a(this.k, getMeasuredWidth(), getMeasuredHeight());
      this.l = new Canvas(this.k);
      this.m = a(this.m, getMeasuredWidth(), getMeasuredHeight());
      this.n = new Canvas(this.m);
      this.h = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      this.u = true;
    }
  }
  
  public void setThemeColor(int paramInt)
  {
    if (this.p != paramInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setThemeColor ");
        localStringBuilder.append(Integer.toHexString(this.p));
        QLog.d("PttBaseView", 2, localStringBuilder.toString());
      }
      this.p = paramInt;
      this.u = true;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
 * JD-Core Version:    0.7.0.1
 */