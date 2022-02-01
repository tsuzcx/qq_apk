package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.ui.i;

public class f
{
  private boolean A;
  private boolean B = false;
  int a = 2147483647;
  private final f.f b = new f.f(this, null);
  private final f.e c = new f.e(this, null);
  private final f.d d = new f.d(this, null);
  private final f.b e = new f.b(this, null);
  private Context f;
  private j g;
  private ListAdapter h;
  private f.a i;
  private int j = -2;
  private int k = -2;
  private int l;
  private int m;
  private boolean n;
  private boolean o = false;
  private boolean p = false;
  private View q;
  private int r = 0;
  private DataSetObserver s;
  private View t;
  private Drawable u;
  private AdapterView.OnItemClickListener v;
  private AdapterView.OnItemSelectedListener w;
  private Runnable x;
  private Handler y = new Handler();
  private Rect z = new Rect();
  
  public f(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.f = paramContext;
    this.g = new j(paramContext);
    this.g.setInputMethodMode(1);
  }
  
  private void h()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.q);
      }
    }
  }
  
  private int i()
  {
    Object localObject1 = this.i;
    boolean bool = true;
    if (localObject1 == null)
    {
      Object localObject3 = this.f;
      this.x = new f.1(this);
      this.i = new f.a((Context)localObject3, this.A ^ true, null);
      localObject1 = this.u;
      if (localObject1 != null) {
        this.i.setSelector((Drawable)localObject1);
      }
      this.i.setAdapter(this.h);
      this.i.setOnItemClickListener(this.v);
      this.i.setFocusable(true);
      this.i.setFocusableInTouchMode(true);
      this.i.setDivider(null);
      this.i.setDividerHeight(0);
      this.i.setOnItemSelectedListener(new f.2(this));
      this.i.setOnScrollListener(this.d);
      localObject1 = this.w;
      if (localObject1 != null) {
        this.i.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject1);
      }
      Object localObject2 = this.i;
      View localView = this.q;
      localObject1 = localObject2;
      if (localView != null)
      {
        h();
        localObject1 = new FrameLayout((Context)localObject3);
        localObject3 = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
        i1 = this.r;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Invalid hint position ");
            ((StringBuilder)localObject2).append(this.r);
            com.tencent.mm.ui.f.e("ListPopupWindow", ((StringBuilder)localObject2).toString(), new Object[0]);
          }
          else
          {
            localLayoutParams.gravity = 80;
            ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            ((FrameLayout)localObject1).addView(localView, localLayoutParams);
          }
        }
        else
        {
          localLayoutParams.gravity = 48;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          ((FrameLayout)localObject1).addView(localView, localLayoutParams);
        }
        localView.measure(View.MeasureSpec.makeMeasureSpec(this.k, -2147483648), 0);
      }
      this.g.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = this.q;
      if (localObject1 != null)
      {
        i1 = ((View)localObject1).getMeasuredHeight();
        break label391;
      }
    }
    int i1 = 0;
    label391:
    localObject1 = this.g.getBackground();
    int i2;
    int i3;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(this.z);
      i2 = this.z.top + this.z.bottom;
      i3 = i2;
      if (!this.n)
      {
        this.m = (-this.z.top);
        i3 = i2;
      }
    }
    else
    {
      this.z.setEmpty();
      i3 = 0;
    }
    if (this.g.getInputMethodMode() != 2) {
      bool = false;
    }
    int i4 = a(a(), this.m, bool);
    if ((!this.o) && (this.j != -1))
    {
      i2 = this.k;
      if (i2 != -2) {
        if (i2 != -1) {
          i2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
      }
      for (;;)
      {
        break;
        i2 = View.MeasureSpec.makeMeasureSpec(this.f.getResources().getDisplayMetrics().widthPixels - (this.z.left + this.z.right), 1073741824);
        continue;
        i2 = View.MeasureSpec.makeMeasureSpec(this.f.getResources().getDisplayMetrics().widthPixels - (this.z.left + this.z.right), -2147483648);
      }
      i4 = this.i.a(i2, 0, -1, i4 - i1, -1);
      i2 = i1;
      if (i4 > 0) {
        i2 = i1 + i3;
      }
      return i4 + i2;
    }
    return i4 + i3;
  }
  
  public int a(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    paramView.getLocationOnScreen(new int[2]);
    int i2 = localRect.bottom;
    int i1 = i2;
    if (paramBoolean)
    {
      paramView.getContext().getResources();
      paramView = i.a(paramView.getContext());
      i1 = i2;
      if (paramView != null) {
        i1 = paramView.y;
      }
    }
    i1 -= paramInt;
    paramInt = i1;
    if (this.g.getBackground() != null)
    {
      this.g.getBackground().getPadding(this.z);
      paramInt = i1 - (this.z.top + this.z.bottom);
    }
    return paramInt;
  }
  
  public View a()
  {
    return this.t;
  }
  
  public void a(int paramInt)
  {
    this.g.setAnimationStyle(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.g.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.t = paramView;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.v = paramOnItemClickListener;
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = this.s;
    if (localDataSetObserver == null)
    {
      this.s = new f.c(this, null);
    }
    else
    {
      ListAdapter localListAdapter = this.h;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    this.h = paramListAdapter;
    if (this.h != null) {
      paramListAdapter.registerDataSetObserver(this.s);
    }
    paramListAdapter = this.i;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(this.h);
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.g.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
    this.g.setFocusable(this.A);
  }
  
  public void b()
  {
    int i2 = i();
    boolean bool3 = f();
    boolean bool4 = this.g.isShowing();
    boolean bool2 = true;
    boolean bool1 = true;
    int i3 = -1;
    if (bool4)
    {
      int i4 = this.k;
      if (i4 == -1)
      {
        i1 = -1;
      }
      else
      {
        i1 = i4;
        if (i4 == -2) {
          i1 = a().getWidth();
        }
      }
      i4 = this.j;
      if (i4 == -1)
      {
        if (!bool3) {
          i2 = -1;
        }
        if (bool3)
        {
          localj = this.g;
          if (this.k != -1) {
            i3 = 0;
          }
          localj.setWindowLayoutMode(i3, 0);
        }
        else
        {
          localj = this.g;
          if (this.k == -1) {
            i3 = -1;
          } else {
            i3 = 0;
          }
          localj.setWindowLayoutMode(i3, -1);
        }
      }
      else if (i4 != -2)
      {
        i2 = i4;
      }
      this.g.update(i1, i2);
      localj = this.g;
      if ((this.p) || (this.o)) {
        bool1 = false;
      }
      localj.setOutsideTouchable(bool1);
      if (this.B)
      {
        this.g.showAtLocation(a(), 17, 0, 0);
        return;
      }
      this.g.showAtLocation(a(), 53, this.l, this.m);
      return;
    }
    int i1 = this.k;
    if (i1 == -1)
    {
      i1 = -1;
    }
    else
    {
      if (i1 == -2) {
        this.g.setWidth(a().getWidth());
      } else {
        this.g.setWidth(i1);
      }
      i1 = 0;
    }
    i3 = this.j;
    if (i3 == -1)
    {
      i2 = -1;
    }
    else
    {
      if (i3 == -2) {
        this.g.setHeight(i2);
      } else {
        this.g.setHeight(i3);
      }
      i2 = 0;
    }
    this.g.setWindowLayoutMode(i1, i2);
    j localj = this.g;
    if ((!this.p) && (!this.o)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localj.setOutsideTouchable(bool1);
    this.g.setTouchInterceptor(this.c);
    if (this.B) {
      this.g.showAtLocation(a(), 17, 0, 0);
    } else {
      this.g.showAtLocation(a(), 53, this.l, this.m);
    }
    this.i.setSelection(-1);
    if ((!this.A) || (this.i.isInTouchMode())) {
      d();
    }
    if (!this.A) {
      this.y.post(this.e);
    }
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void c()
  {
    this.g.dismiss();
    h();
    this.g.setContentView(null);
    this.i = null;
    this.y.removeCallbacks(this.b);
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
    this.n = true;
  }
  
  public void d()
  {
    f.a locala = this.i;
    if (locala != null)
    {
      f.a.a(locala, true);
      locala.requestLayout();
    }
  }
  
  public void d(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void e(int paramInt)
  {
    Drawable localDrawable = this.g.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.z);
      this.k = (this.z.left + this.z.right + paramInt);
      return;
    }
    d(paramInt);
  }
  
  public boolean e()
  {
    return this.g.isShowing();
  }
  
  public void f(int paramInt)
  {
    this.g.setInputMethodMode(paramInt);
  }
  
  public boolean f()
  {
    return this.g.getInputMethodMode() == 2;
  }
  
  public ListView g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.f
 * JD-Core Version:    0.7.0.1
 */