package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class QimMusicSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int[] a = { 18, 14, 9, 12, 14, 18 };
  protected static final int b = a.length;
  protected static int c = 0;
  protected static int[] d = new int[b];
  protected static int e = 0;
  protected static int f = 0;
  protected Paint A = null;
  protected Paint B = null;
  float C = 0.0F;
  protected int g = 0;
  protected int h = 0;
  protected int i = 0;
  protected int j = 0;
  protected int k = 0;
  protected int l = 0;
  protected int m = 0;
  protected int n = 0;
  protected int o = 0;
  protected int p = 0;
  protected int q = 0;
  protected QimMusicSeekView.SeekListener r = null;
  protected Rect s = null;
  protected int t = 0;
  protected int u = 0;
  protected int v = 0;
  protected boolean w = false;
  protected Paint x = null;
  protected Paint y = null;
  protected Paint z = null;
  
  public QimMusicSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.t = ((int)DisplayUtils.a(paramContext, 8.0F));
    this.p = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.q = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.v = ((int)DisplayUtils.a(paramContext, 3.0F));
    c = (int)DisplayUtils.a(paramContext, 4.0F);
    f = (int)DisplayUtils.a(paramContext, 50.0F);
    e = (int)DisplayUtils.a(paramContext, 36.0F);
    int i1 = 0;
    while (i1 < b)
    {
      d[i1] = ((int)DisplayUtils.a(paramContext, a[i1]));
      i1 += 1;
    }
    paramContext = paramContext.getResources();
    this.x = new Paint();
    this.x.setAntiAlias(true);
    this.x.setColor(paramContext.getColor(2131165875));
    this.y = new Paint();
    this.y.setAntiAlias(true);
    this.y.setColor(paramContext.getColor(2131167113));
    this.z = new Paint();
    this.z.setAntiAlias(true);
    this.z.setColor(paramContext.getColor(2131168478));
    this.z.setStrokeWidth(1.0F);
    this.z.setStyle(Paint.Style.FILL);
    this.A = new Paint();
    this.A.setAntiAlias(true);
    this.A.setColor(paramContext.getColor(2131165741));
    this.A.setStyle(Paint.Style.FILL);
    this.B = new Paint();
    this.B.setAntiAlias(true);
    this.B.setColor(0);
    this.B.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    super.setOnTouchListener(this);
  }
  
  public void a(int paramInt)
  {
    this.k = ((int)(paramInt / 1000 * (c + this.p) * 2.5F));
    setPlayedPosition(-1);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Paint paramPaint)
  {
    RectF localRectF = new RectF();
    localRectF.left = paramInt1;
    localRectF.top = paramInt2;
    localRectF.bottom = paramInt4;
    localRectF.right = paramInt3;
    paramCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, paramPaint);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    Rect localRect = new Rect();
    localRect.left = paramInt1;
    localRect.top = paramInt2;
    localRect.bottom = paramInt4;
    localRect.right = paramInt3;
    paramCanvas.drawRect(localRect, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.x.setStrokeWidth(this.u);
    this.x.setStyle(Paint.Style.FILL);
    this.y.setStrokeWidth(this.u);
    this.y.setStyle(Paint.Style.FILL);
    int i2 = 0;
    int i5;
    int i6;
    int i4;
    int i7;
    Paint localPaint;
    for (int i1 = 0; i1 < this.h; i1 = i3)
    {
      i5 = this.m;
      i6 = this.k;
      i3 = i1 + 1;
      i4 = i5 - i6 + c * i3 + this.p * i1;
      i7 = this.i;
      if ((i4 > i5 + i7) && (i6 == this.j - i7)) {
        break;
      }
      if (i4 >= 0)
      {
        if (i4 > this.n) {
          break;
        }
        localPaint = this.z;
        if ((this.w) || (i4 <= this.s.left - this.p) || (i4 >= this.s.right))
        {
          i1 = d[(i1 % b)];
          i5 = (this.o - i1) / 2;
          a(paramCanvas, i4, i5, i4 + this.p, i5 + i1, 5.0F, localPaint);
        }
      }
    }
    this.x.setStrokeWidth(1.0F);
    this.x.setStyle(Paint.Style.FILL);
    a(paramCanvas, this.s.left - this.t, this.s.top, this.s.right + this.t, this.s.bottom, 10.0F, this.x);
    this.A.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    a(paramCanvas, this.s.left, this.s.top + this.q, this.s.right, this.s.bottom - this.q, this.A);
    this.A.setXfermode(null);
    this.x.setStrokeWidth(this.u);
    this.x.setStyle(Paint.Style.FILL);
    this.y.setStrokeWidth(this.u);
    this.y.setStyle(Paint.Style.FILL);
    int i3 = -1;
    i1 = i2;
    for (i2 = i3; i1 < this.h; i2 = i3)
    {
      i3 = this.m;
      i4 = this.k;
      i6 = i1 + 1;
      i5 = i3 - i4 + c * i6 + this.p * i1;
      i7 = this.i;
      if ((i5 > i3 + i7) && (i4 == this.j - i7)) {
        return;
      }
      if (i5 < 0)
      {
        i3 = i2;
      }
      else
      {
        if (i5 > this.n) {
          return;
        }
        if ((!this.w) && (i5 > this.s.left - this.p) && (i5 < this.s.right))
        {
          i4 = this.p + i5;
          if ((i5 < this.s.left) && (this.p + i5 > this.s.left))
          {
            i3 = this.s.left;
            i4 = this.p;
            i4 += i5;
          }
          else
          {
            i3 = i5;
          }
          if ((i5 < this.s.right) && (this.p + i5 > this.s.right))
          {
            i4 = this.s.right;
            i3 = i5;
          }
          if (i2 == -1) {
            i2 = i1;
          }
          if ((i1 >= i2) && (i1 < this.l + i2)) {
            localPaint = this.y;
          } else {
            localPaint = this.x;
          }
          i1 = d[(i1 % b)];
          i5 = (this.o - i1) / 2;
          a(paramCanvas, i3, i5, i4, i5 + i1, 5.0F, localPaint);
        }
        else
        {
          i3 = i2;
          if (!this.w) {
            break label867;
          }
          i3 = i2;
          if (i5 <= this.s.left - this.p) {
            break label867;
          }
          i3 = i2;
          if (i5 >= this.s.right) {
            break label867;
          }
          if (i2 == -1) {
            i2 = i1;
          }
          localPaint = this.x;
          i1 = d[(i1 % b)];
          i3 = (this.o - i1) / 2;
          a(paramCanvas, i5, i3, i5 + this.p, i3 + i1, 5.0F, localPaint);
        }
        i3 = i2;
      }
      label867:
      i1 = i6;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.n = super.getMeasuredWidth();
    this.o = (f + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.n, this.o);
    paramInt2 = this.n;
    paramInt1 = this.i;
    this.m = ((paramInt2 - paramInt1) / 2);
    int i1 = this.o;
    paramInt2 = f;
    i1 = (i1 - paramInt2) / 2;
    int i2 = this.m;
    this.s = new Rect(i2, i1, paramInt1 + i2, paramInt2 + i1);
    Object localObject = this.r;
    if (localObject != null) {
      ((QimMusicSeekView.SeekListener)localObject).a(this.m, this.i);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasure() mViewWidth: ");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(", mViewHeight = ");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append(", mVideoViewOffsetX = ");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(", mMusicMaxWidth = ");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
        this.w = true;
        float f1 = paramMotionEvent.getX();
        if (Math.abs(f1 - this.C) < 3.0F) {
          return true;
        }
        float f2 = (this.C - f1) / (c + this.p);
        i1 = Math.round(Math.abs(f2));
        if ((f2 > 0.0F) && (i1 >= 1)) {
          this.k += (c + this.p) * i1;
        } else if ((f2 < 0.0F) && (i1 >= 1)) {
          this.k -= (c + this.p) * i1;
        }
        if (i1 == 0) {
          return true;
        }
        if (this.k <= 0) {
          this.k = 0;
        }
        i1 = this.k;
        int i2 = this.j;
        int i3 = this.i;
        if (i1 >= i2 - i3) {
          this.k = (i2 - i3);
        }
        super.invalidate();
        paramView = this.r;
        if (paramView != null) {
          paramView.b(this.j, this.i, this.k);
        }
        this.C = f1;
        return false;
      }
      this.w = false;
      super.invalidate();
      paramView = this.r;
      if (paramView != null)
      {
        paramView.c(this.j, this.i, this.k);
        return false;
      }
    }
    else
    {
      this.w = false;
      this.C = paramMotionEvent.getX();
      paramView = this.r;
      if (paramView != null) {
        paramView.a(this.j, this.i, this.k);
      }
    }
    return false;
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.g = ((int)(paramInt1 * 2.5F));
    this.h = ((int)(paramInt2 * 2.5F));
    paramInt1 = c;
    int i1 = this.g;
    paramInt2 = this.p;
    this.i = (paramInt1 * i1 + (i1 - 1) * paramInt2);
    i1 = this.h;
    this.j = (paramInt1 * i1 + (i1 - 1) * paramInt2);
  }
  
  public void setOnSeekListener(QimMusicSeekView.SeekListener paramSeekListener)
  {
    this.r = paramSeekListener;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.l = paramInt;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QimMusicSeekView
 * JD-Core Version:    0.7.0.1
 */