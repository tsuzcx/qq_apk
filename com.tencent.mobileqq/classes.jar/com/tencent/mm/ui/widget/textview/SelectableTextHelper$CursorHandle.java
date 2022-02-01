package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.ui.f;

class SelectableTextHelper$CursorHandle
  extends View
{
  private PopupWindow b;
  private Paint c;
  private int d = SelectableTextHelper.t(this.a) / 2;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int[] m;
  private Rect n;
  private Point o;
  private boolean p;
  private int[] q;
  
  SelectableTextHelper$CursorHandle(SelectableTextHelper paramSelectableTextHelper, boolean paramBoolean)
  {
    super(SelectableTextHelper.u(paramSelectableTextHelper));
    int i1 = this.d;
    this.e = (i1 * 2);
    this.f = (i1 * 2);
    this.g = 25;
    this.m = new int[2];
    this.n = new Rect();
    this.o = new Point();
    this.p = false;
    this.q = new int[2];
    this.h = paramBoolean;
    this.c = new Paint(1);
    this.c.setColor(SelectableTextHelper.u(paramSelectableTextHelper).getResources().getColor(SelectableTextHelper.v(paramSelectableTextHelper)));
    this.b = new PopupWindow(this);
    this.b.setClippingEnabled(false);
    this.b.setWidth(this.e + this.g * 2);
    this.b.setHeight(this.f + this.g / 2);
  }
  
  private int a()
  {
    int i1;
    if (this.h) {
      i1 = SelectableTextHelper.e(this.a).a;
    } else {
      i1 = SelectableTextHelper.e(this.a).b;
    }
    TextPaint localTextPaint = TextLayoutUtil.getPaint(SelectableTextHelper.f(this.a));
    int i2 = 0;
    if (localTextPaint != null)
    {
      i3 = TextLayoutUtil.getLineBaseline(SelectableTextHelper.f(this.a), TextLayoutUtil.getLineForOffset(SelectableTextHelper.f(this.a), i1)) + (int)localTextPaint.getFontMetrics().descent;
      i2 = (int)TextLayoutUtil.getPrimaryHorizontal(SelectableTextHelper.f(this.a), i1);
      i1 = i3;
    }
    else
    {
      i3 = 0;
      i1 = i2;
      i2 = i3;
    }
    SelectableTextHelper.f(this.a).getLocationInWindow(this.m);
    int i3 = i1;
    if (!this.h) {
      i3 = a(i2, i1)[1];
    }
    return i3 + getExtraY();
  }
  
  private int[] a(int paramInt1, int paramInt2)
  {
    int i2 = paramInt1;
    int i1 = paramInt2;
    if (paramInt1 == 0)
    {
      i2 = paramInt1;
      i1 = paramInt2;
      if (SelectableTextHelper.e(this.a).b > 1)
      {
        SelectableTextHelper.f(this.a).getLocationInWindow(this.m);
        TextPaint localTextPaint = TextLayoutUtil.getPaint(SelectableTextHelper.f(this.a));
        i2 = paramInt1;
        i1 = paramInt2;
        if (localTextPaint != null)
        {
          paramInt1 = (int)localTextPaint.getFontMetrics().descent;
          paramInt2 = TextLayoutUtil.getLineForOffset(SelectableTextHelper.f(this.a), SelectableTextHelper.e(this.a).b - 1);
          i2 = (int)TextLayoutUtil.getLineWidth(SelectableTextHelper.f(this.a), paramInt2);
          i1 = paramInt1 + TextLayoutUtil.getLineBaseline(SelectableTextHelper.f(this.a), TextLayoutUtil.getLineForOffset(SelectableTextHelper.f(this.a), SelectableTextHelper.e(this.a).b - 1));
        }
      }
    }
    return new int[] { i2, i1 };
  }
  
  private void b()
  {
    this.h ^= true;
    invalidate();
  }
  
  private void c()
  {
    SelectableTextHelper.f(this.a).getLocationInWindow(this.m);
    Object localObject = TextLayoutUtil.getPaint(SelectableTextHelper.f(this.a));
    if (localObject != null)
    {
      int i1 = (int)((TextPaint)localObject).getFontMetrics().descent;
      if (this.h)
      {
        this.b.update((int)TextLayoutUtil.getPrimaryHorizontal(SelectableTextHelper.f(this.a), SelectableTextHelper.e(this.a).a) - this.e + getExtraX(), TextLayoutUtil.getLineBaseline(SelectableTextHelper.f(this.a), TextLayoutUtil.getLineForOffset(SelectableTextHelper.f(this.a), SelectableTextHelper.e(this.a).a)) + i1 + getExtraY(), -1, -1);
        return;
      }
      localObject = a((int)TextLayoutUtil.getPrimaryHorizontal(SelectableTextHelper.f(this.a), SelectableTextHelper.e(this.a).b), TextLayoutUtil.getLineBaseline(SelectableTextHelper.f(this.a), TextLayoutUtil.getLineForOffset(SelectableTextHelper.f(this.a), SelectableTextHelper.e(this.a).b)) + i1);
      i1 = localObject[0];
      int i2 = localObject[1];
      this.b.update(i1 + getExtraX(), i2 + getExtraY(), -1, -1);
    }
  }
  
  public void dismiss()
  {
    this.b.dismiss();
  }
  
  public int getExtraX()
  {
    return this.m[0] - this.g + SelectableTextHelper.f(this.a).getPaddingLeft();
  }
  
  public int getExtraY()
  {
    return this.m[1] + SelectableTextHelper.f(this.a).getPaddingTop();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (SelectableTextHelper.d(this.a) != null)
    {
      i1 = a();
      if (SelectableTextHelper.f(this.a).getGlobalVisibleRect(this.n, this.o))
      {
        if (i1 >= this.n.bottom)
        {
          if (this.h)
          {
            f.b("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
            this.a.resetSelectionInfo();
            this.a.setMenuHide(true);
            this.a.setCursorHide(true);
            this.a.hideSelectView();
            SelectableTextHelper.d(this.a).dismiss();
          }
          f.b("SelectableTextHelper", "cursor invisible.", new Object[0]);
          return;
        }
        if (i1 <= this.n.top)
        {
          if (!this.h)
          {
            f.b("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
            this.a.resetSelectionInfo();
            this.a.setMenuHide(true);
            this.a.setCursorHide(true);
            this.a.hideSelectView();
            SelectableTextHelper.d(this.a).dismiss();
          }
          f.b("SelectableTextHelper", "cursor invisible.", new Object[0]);
        }
      }
      else
      {
        f.b("SelectableTextHelper", "view invisible.", new Object[0]);
        return;
      }
    }
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
          if (SelectableTextHelper.d(this.a) != null)
          {
            SelectableTextHelper.d(this.a).onSwitchMenu();
            SelectableTextHelper.d(this.a).dismiss();
          }
          this.a.hideOperateMenu();
          i1 = (int)paramMotionEvent.getRawX();
          int i2 = (int)paramMotionEvent.getRawY();
          if (SelectableTextHelper.d(this.a) == null) {
            update(i1 - this.q[0], i2 + this.j - this.f - SelectableTextHelper.w(this.a));
          } else {
            update(i1 - this.q[0] + this.d, i2 + this.j - this.f - SelectableTextHelper.w(this.a));
          }
          if (SelectableTextHelper.d(this.a) == null) {
            break label404;
          }
          SelectableTextHelper.d(this.a).onSwitchMenuFinish();
          return true;
        }
      }
      if ((SelectableTextHelper.d(this.a) != null) && (!this.p))
      {
        this.p = true;
        SelectableTextHelper.d(this.a).onSwitchMenu();
        if (SelectableTextHelper.e(this.a).b - SelectableTextHelper.e(this.a).a == TextLayoutUtil.getText(SelectableTextHelper.f(this.a)).length())
        {
          SelectableTextHelper.d(this.a).open(SelectableTextHelper.f(this.a));
          this.a.setMenuHide(true);
          this.a.hideOperateMenu();
        }
        else
        {
          SelectableTextHelper.d(this.a).dismiss();
          this.a.setMenuHide(false);
          this.a.showOperateMenu();
        }
        SelectableTextHelper.d(this.a).onSwitchMenuFinish();
        return true;
      }
      if (!this.a.menuIsHide())
      {
        this.a.showOperateMenu();
        return true;
      }
    }
    else
    {
      this.k = SelectableTextHelper.e(this.a).a;
      this.l = SelectableTextHelper.e(this.a).b;
      this.i = ((int)paramMotionEvent.getX());
      this.j = ((int)paramMotionEvent.getY());
      this.p = false;
      SelectableTextHelper.f(this.a).getLocationInWindow(this.q);
    }
    label404:
    return true;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.b.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOutsideTouchable(boolean paramBoolean)
  {
    this.b.setOutsideTouchable(paramBoolean);
  }
  
  public void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
  {
    this.b.setTouchInterceptor(paramOnTouchListener);
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    SelectableTextHelper.f(this.a).getLocationInWindow(this.m);
    int i1;
    if (this.h) {
      i1 = this.e;
    } else {
      i1 = 0;
    }
    int i3 = paramInt1;
    int i2 = paramInt2;
    if (!this.h)
    {
      int[] arrayOfInt = a(paramInt1, paramInt2);
      i3 = arrayOfInt[0];
      i2 = arrayOfInt[1];
    }
    try
    {
      this.b.showAtLocation(SelectableTextHelper.f(this.a), 0, i3 - i1 + getExtraX(), i2 + getExtraY());
      return;
    }
    catch (Exception localException)
    {
      f.e("SelectableTextHelper", "error! message: %s.", new Object[] { localException.getMessage() });
    }
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    SelectableTextHelper.f(this.a).getLocationInWindow(this.m);
    int i1;
    if (this.h) {
      i1 = SelectableTextHelper.e(this.a).a;
    } else {
      i1 = SelectableTextHelper.e(this.a).b;
    }
    int i2 = this.m[1];
    paramInt1 = TextLayoutUtil.getHysteresisOffset(SelectableTextHelper.f(this.a), paramInt1, paramInt2 - i2, i1);
    if (paramInt1 != i1)
    {
      this.a.resetSelectionInfo();
      CursorHandle localCursorHandle;
      if (this.h)
      {
        if (paramInt1 > this.l)
        {
          localCursorHandle = SelectableTextHelper.f(this.a, false);
          b();
          localCursorHandle.b();
          paramInt2 = this.l;
          this.k = paramInt2;
          this.a.selectText(paramInt2, paramInt1);
          localCursorHandle.c();
        }
        else
        {
          this.a.selectText(paramInt1, -1);
        }
        c();
        return;
      }
      paramInt2 = this.k;
      if (paramInt1 < paramInt2)
      {
        localCursorHandle = SelectableTextHelper.f(this.a, true);
        localCursorHandle.b();
        b();
        paramInt2 = this.k;
        this.l = paramInt2;
        this.a.selectText(paramInt1, paramInt2);
        localCursorHandle.c();
      }
      else
      {
        this.a.selectText(paramInt2, paramInt1);
      }
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.CursorHandle
 * JD-Core Version:    0.7.0.1
 */