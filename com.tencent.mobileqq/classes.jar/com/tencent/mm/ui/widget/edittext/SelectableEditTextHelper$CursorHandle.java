package com.tencent.mm.ui.widget.edittext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;

class SelectableEditTextHelper$CursorHandle
  extends View
{
  private PopupWindow b;
  private Paint c;
  private int d = SelectableEditTextHelper.C(this.a) / 2;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int[] m;
  private int[] n;
  
  public SelectableEditTextHelper$CursorHandle(SelectableEditTextHelper paramSelectableEditTextHelper, boolean paramBoolean)
  {
    super(SelectableEditTextHelper.x(paramSelectableEditTextHelper));
    int i1 = this.d;
    this.e = (i1 * 2);
    this.f = (i1 * 2);
    this.g = 25;
    this.m = new int[2];
    this.n = new int[2];
    this.h = paramBoolean;
    this.c = new Paint(1);
    this.c.setColor(SelectableEditTextHelper.D(paramSelectableEditTextHelper));
    this.b = new PopupWindow(this);
    this.b.setClippingEnabled(false);
    this.b.setWidth(this.e + this.g * 2);
    this.b.setHeight(this.f + this.g / 2);
    invalidate();
  }
  
  private int a(int paramInt, Layout paramLayout)
  {
    int i1 = paramLayout.getLineBottom(paramLayout.getLineForOffset(paramInt)) + getExtraY();
    int i2 = this.n[1] + SelectableEditTextHelper.k(this.a).getHeight() - SelectableEditTextHelper.k(this.a).getPaddingBottom();
    paramInt = i1;
    if (i1 > i2) {
      paramInt = i2;
    }
    paramLayout = this.n;
    i1 = paramInt;
    if (paramInt < paramLayout[1]) {
      i1 = paramLayout[1];
    }
    return i1;
  }
  
  private void a()
  {
    this.h ^= true;
    invalidate();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.b.isShowing())
      {
        this.b.update(paramInt1, paramInt2, -1, -1);
        return;
      }
      this.b.showAtLocation(SelectableEditTextHelper.k(this.a), 0, paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      f.e("SelectableEditTextHelper", "cursor error!: %s.", new Object[] { localException.getMessage() });
    }
  }
  
  private void b()
  {
    SelectableEditTextHelper.k(this.a).getLocationInWindow(this.n);
    Layout localLayout = SelectableEditTextHelper.k(this.a).getLayout();
    if (this.h)
    {
      i1 = a(SelectableEditTextHelper.y(this.a).mStart, localLayout);
      a((int)localLayout.getPrimaryHorizontal(SelectableEditTextHelper.y(this.a).mStart) - this.e + getExtraX(), i1);
      return;
    }
    int i1 = a(SelectableEditTextHelper.y(this.a).mEnd, localLayout);
    a((int)localLayout.getPrimaryHorizontal(SelectableEditTextHelper.y(this.a).mEnd) + getExtraX(), i1);
  }
  
  public void dismiss()
  {
    this.b.dismiss();
  }
  
  public int getExtraX()
  {
    return this.n[0] - this.g + SelectableEditTextHelper.k(this.a).getPaddingLeft();
  }
  
  public int getExtraY()
  {
    return this.n[1] + SelectableEditTextHelper.k(this.a).getPaddingTop() - SelectableEditTextHelper.B(this.a);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = this.d;
    paramCanvas.drawCircle(this.g + i1, i1, i1, this.c);
    if (this.h)
    {
      i1 = this.d;
      i2 = this.g;
      paramCanvas.drawRect(i1 + i2, 0.0F, i1 * 2 + i2, i1, this.c);
      return;
    }
    i1 = this.g;
    float f1 = i1;
    int i2 = this.d;
    paramCanvas.drawRect(f1, 0.0F, i1 + i2, i2, this.c);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
        }
        else
        {
          SelectableEditTextHelper localSelectableEditTextHelper = this.a;
          SelectableEditTextHelper.a(localSelectableEditTextHelper, SelectableEditTextHelper.n(localSelectableEditTextHelper));
          i1 = (int)paramMotionEvent.getRawX();
          int i2 = (int)paramMotionEvent.getRawY();
          update(i1 - this.m[0], i2 + this.j - this.f - SelectableEditTextHelper.E(this.a) + SelectableEditTextHelper.B(this.a));
          SelectableEditTextHelper.e(this.a, this.h ^ true).b();
          return true;
        }
      }
      paramMotionEvent = this.a;
      SelectableEditTextHelper.b(paramMotionEvent, SelectableEditTextHelper.n(paramMotionEvent));
      return true;
    }
    this.k = SelectableEditTextHelper.y(this.a).mStart;
    this.l = SelectableEditTextHelper.y(this.a).mEnd;
    this.i = ((int)paramMotionEvent.getX());
    this.j = ((int)paramMotionEvent.getY());
    SelectableEditTextHelper.k(this.a).getLocationInWindow(this.m);
    return true;
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    SelectableEditTextHelper.k(this.a).getLocationInWindow(this.n);
    int i1;
    if (this.h) {
      i1 = this.e;
    } else {
      i1 = 0;
    }
    int i2 = getExtraX();
    paramInt2 += getExtraY();
    int[] arrayOfInt = this.n;
    if (paramInt2 < arrayOfInt[1]) {
      return;
    }
    if (paramInt2 > arrayOfInt[1] + SelectableEditTextHelper.k(this.a).getHeight() - SelectableEditTextHelper.k(this.a).getPaddingBottom() + g.a(SelectableEditTextHelper.x(this.a), 5)) {
      return;
    }
    a(paramInt1 - i1 + i2, paramInt2);
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    SelectableEditTextHelper.k(this.a).getLocationInWindow(this.n);
    int i1;
    if (this.h) {
      i1 = SelectableEditTextHelper.y(this.a).mStart;
    } else {
      i1 = SelectableEditTextHelper.y(this.a).mEnd;
    }
    int i2 = this.n[1];
    paramInt1 = TextLayoutUtil.getHysteresisOffset(SelectableEditTextHelper.k(this.a), paramInt1, paramInt2 - i2, i1);
    if (paramInt1 != i1)
    {
      SelectableEditTextHelper.t(this.a);
      CursorHandle localCursorHandle;
      if (this.h)
      {
        if (paramInt1 > this.l)
        {
          localCursorHandle = SelectableEditTextHelper.e(this.a, false);
          a();
          localCursorHandle.a();
          paramInt2 = this.l;
          this.k = paramInt2;
          SelectableEditTextHelper.b(this.a, paramInt2, paramInt1);
          localCursorHandle.b();
        }
        else
        {
          SelectableEditTextHelper.b(this.a, paramInt1, -1);
        }
        b();
        return;
      }
      paramInt2 = this.k;
      if (paramInt1 < paramInt2)
      {
        localCursorHandle = SelectableEditTextHelper.e(this.a, true);
        localCursorHandle.a();
        a();
        paramInt2 = this.k;
        this.l = paramInt2;
        SelectableEditTextHelper.b(this.a, paramInt1, paramInt2);
        localCursorHandle.b();
      }
      else
      {
        SelectableEditTextHelper.b(this.a, paramInt2, paramInt1);
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.CursorHandle
 * JD-Core Version:    0.7.0.1
 */