package com.tencent.luggage.wxa.pq;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
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
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.luggage.wxa.qz.s;

class f
{
  private boolean A;
  private boolean B = false;
  int a = 2147483647;
  private Context b;
  private PopupWindow c;
  private ListAdapter d;
  private f.a e;
  private int f = -2;
  private int g = -2;
  private int h;
  private int i;
  private boolean j;
  private boolean k = false;
  private boolean l = false;
  private View m;
  private int n = 0;
  private DataSetObserver o;
  private View p;
  private Drawable q;
  private AdapterView.OnItemClickListener r;
  private AdapterView.OnItemSelectedListener s;
  private final f.f t = new f.f(this, null);
  private final f.e u = new f.e(this, null);
  private final f.d v = new f.d(this, null);
  private final f.b w = new f.b(this, null);
  private Runnable x;
  private s y = new s();
  private Rect z = new Rect();
  
  public f(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.b = paramContext;
    this.c = new PopupWindow(paramContext);
    this.c.setInputMethodMode(1);
    paramContext = this.b.getResources().getConfiguration().locale;
  }
  
  private void j()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.m);
      }
    }
  }
  
  private int k()
  {
    Object localObject1 = this.e;
    boolean bool = true;
    if (localObject1 == null)
    {
      Object localObject3 = this.b;
      this.x = new f.1(this);
      this.e = new f.a((Context)localObject3, this.A ^ true);
      localObject1 = this.q;
      if (localObject1 != null) {
        this.e.setSelector((Drawable)localObject1);
      }
      this.e.setAdapter(this.d);
      this.e.setOnItemClickListener(this.r);
      this.e.setFocusable(true);
      this.e.setFocusableInTouchMode(true);
      this.e.setDivider(null);
      this.e.setDividerHeight(0);
      this.e.setOnItemSelectedListener(new f.2(this));
      this.e.setOnScrollListener(this.v);
      localObject1 = this.s;
      if (localObject1 != null) {
        this.e.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject1);
      }
      Object localObject2 = this.e;
      View localView = this.m;
      localObject1 = localObject2;
      if (localView != null)
      {
        j();
        localObject1 = new FrameLayout((Context)localObject3);
        localObject3 = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
        i1 = this.n;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Invalid hint position ");
            ((StringBuilder)localObject2).append(this.n);
            Log.e("ListPopupWindow", ((StringBuilder)localObject2).toString());
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
        localView.measure(View.MeasureSpec.makeMeasureSpec(this.g, -2147483648), 0);
      }
      this.c.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = (ViewGroup)this.c.getContentView();
      localObject1 = this.m;
      if (localObject1 != null)
      {
        i1 = ((View)localObject1).getMeasuredHeight();
        break label400;
      }
    }
    int i1 = 0;
    label400:
    localObject1 = this.c.getBackground();
    int i2;
    int i3;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(this.z);
      i2 = this.z.top + this.z.bottom;
      i3 = i2;
      if (!this.j)
      {
        this.i = (-this.z.top);
        i3 = i2;
      }
    }
    else
    {
      this.z.setEmpty();
      i3 = 0;
    }
    if (this.c.getInputMethodMode() != 2) {
      bool = false;
    }
    int i4 = a(b(), this.i, bool);
    if ((!this.k) && (this.f != -1))
    {
      i2 = this.g;
      if (i2 != -2) {
        if (i2 != -1) {
          i2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
      }
      for (;;)
      {
        break;
        i2 = View.MeasureSpec.makeMeasureSpec(this.b.getResources().getDisplayMetrics().widthPixels - (this.z.left + this.z.right), 1073741824);
        continue;
        i2 = View.MeasureSpec.makeMeasureSpec(this.b.getResources().getDisplayMetrics().widthPixels - (this.z.left + this.z.right), -2147483648);
      }
      i4 = this.e.a(i2, 0, -1, i4 - i1, -1);
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
    int i1 = localRect.bottom;
    if (paramBoolean) {
      i1 = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    i1 -= paramInt;
    paramInt = i1;
    if (this.c.getBackground() != null)
    {
      this.c.getBackground().getPadding(this.z);
      paramInt = i1 - (this.z.top + this.z.bottom);
    }
    return paramInt;
  }
  
  public void a()
  {
    int i2 = k();
    boolean bool3 = h();
    boolean bool4 = this.c.isShowing();
    boolean bool2 = true;
    boolean bool1 = true;
    int i3 = -1;
    if (bool4)
    {
      int i4 = this.g;
      if (i4 == -1)
      {
        i1 = -1;
      }
      else
      {
        i1 = i4;
        if (i4 == -2) {
          i1 = b().getWidth();
        }
      }
      i4 = this.f;
      if (i4 == -1)
      {
        if (!bool3) {
          i2 = -1;
        }
        if (bool3)
        {
          localPopupWindow = this.c;
          if (this.g != -1) {
            i3 = 0;
          }
          localPopupWindow.setWindowLayoutMode(i3, 0);
        }
        else
        {
          localPopupWindow = this.c;
          if (this.g == -1) {
            i3 = -1;
          } else {
            i3 = 0;
          }
          localPopupWindow.setWindowLayoutMode(i3, -1);
        }
      }
      else if (i4 != -2)
      {
        i2 = i4;
      }
      this.c.update(i1, i2);
      localPopupWindow = this.c;
      if ((this.l) || (this.k)) {
        bool1 = false;
      }
      localPopupWindow.setOutsideTouchable(bool1);
      if (this.B)
      {
        this.c.showAtLocation(b(), 17, 0, 0);
        return;
      }
      this.c.update(b(), this.h, this.i, this.c.getWidth(), this.c.getHeight());
      return;
    }
    int i1 = this.g;
    if (i1 == -1)
    {
      i1 = -1;
    }
    else
    {
      if (i1 == -2) {
        this.c.setWidth(b().getWidth());
      } else {
        this.c.setWidth(i1);
      }
      i1 = 0;
    }
    i3 = this.f;
    if (i3 == -1)
    {
      i2 = -1;
    }
    else
    {
      if (i3 == -2) {
        this.c.setHeight(i2);
      } else {
        this.c.setHeight(i3);
      }
      i2 = 0;
    }
    this.c.setWindowLayoutMode(i1, i2);
    PopupWindow localPopupWindow = this.c;
    if ((!this.l) && (!this.k)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localPopupWindow.setOutsideTouchable(bool1);
    this.c.setTouchInterceptor(this.u);
    if (this.B) {
      this.c.showAtLocation(b(), 17, 0, 0);
    } else if (Build.VERSION.SDK_INT >= 19) {
      this.c.showAsDropDown(b(), this.h, this.i, 53);
    } else {
      this.c.showAtLocation(b(), 53, this.h, this.i);
    }
    this.e.setSelection(-1);
    if ((!this.A) || (this.e.isInTouchMode())) {
      f();
    }
    if (!this.A) {
      this.y.a(this.w);
    }
  }
  
  public void a(int paramInt)
  {
    this.c.setAnimationStyle(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.c.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.p = paramView;
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = this.o;
    if (localDataSetObserver == null)
    {
      this.o = new f.c(this, null);
    }
    else
    {
      ListAdapter localListAdapter = this.d;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    this.d = paramListAdapter;
    if (this.d != null) {
      paramListAdapter.registerDataSetObserver(this.o);
    }
    paramListAdapter = this.e;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(this.d);
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.c.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = true;
    this.c.setFocusable(paramBoolean);
  }
  
  public View b()
  {
    return this.p;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public int c()
  {
    if (!this.j) {
      return 0;
    }
    return this.i;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
    this.j = true;
  }
  
  public void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void e()
  {
    this.c.dismiss();
    j();
    this.c.setContentView(null);
    this.e = null;
    this.y.b(this.t);
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void f()
  {
    f.a locala = this.e;
    if (locala != null)
    {
      f.a.a(locala, true);
      locala.requestLayout();
    }
  }
  
  public void f(int paramInt)
  {
    this.c.setInputMethodMode(paramInt);
  }
  
  public boolean g()
  {
    return this.c.isShowing();
  }
  
  public boolean h()
  {
    return this.c.getInputMethodMode() == 2;
  }
  
  public ListView i()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.f
 * JD-Core Version:    0.7.0.1
 */