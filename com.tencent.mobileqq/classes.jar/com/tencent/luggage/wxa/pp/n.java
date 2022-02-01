package com.tencent.luggage.wxa.pp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.util.h;
import com.tencent.luggage.wxa.px.a;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class n
  extends FrameLayout
{
  private static final int a = 2131428601;
  private View b;
  private View c;
  private int d = -1;
  private boolean e = false;
  private final int[] f = new int[2];
  private a g;
  private WeakHashMap<View, n.b> h = new WeakHashMap();
  private Runnable i = new n.1(this);
  private final Runnable j = new n.2(this);
  private final Set<n.a> k = new HashSet();
  
  public n(Context paramContext, View paramView)
  {
    super(paramContext);
    super.setId(a);
    this.c = paramView;
  }
  
  public static n a(Activity paramActivity)
  {
    return (n)paramActivity.findViewById(a);
  }
  
  public static n a(View paramView)
  {
    return (n)paramView.getRootView().findViewById(a);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
  }
  
  private void b()
  {
    if (!ViewCompat.isLaidOut(this)) {
      return;
    }
    int i2 = 0;
    int n = 0;
    int i3 = 0;
    int i4;
    for (int i1 = 1; i2 < getChildCount(); i1 = i4)
    {
      View localView = getChildAt(i2);
      int m = n;
      int i5 = i3;
      i4 = i1;
      if (localView != null) {
        if (localView == this.c)
        {
          m = n;
          i5 = i3;
          i4 = i1;
        }
        else
        {
          n.b localb = (n.b)this.h.get(localView);
          if (localb == null)
          {
            m = n;
            i5 = i3;
            i4 = i1;
          }
          else
          {
            m = n;
            if (n == 0)
            {
              m = n;
              if (localb.b != 0)
              {
                m = n;
                if (localView.getVisibility() == 0)
                {
                  this.b = localView;
                  post(this.i);
                  m = 1;
                }
              }
            }
            if (localb.b == 0) {
              n = 1;
            } else {
              n = 0;
            }
            i5 = i3 | n;
            if (localView.getVisibility() != 0) {
              n = 1;
            } else {
              n = 0;
            }
            i4 = i1 & n;
            localb.b = localView.getVisibility();
          }
        }
      }
      i2 += 1;
      n = m;
      i3 = i5;
    }
    if ((n != 0) || ((i3 != 0) && (i1 != 0))) {
      post(this.j);
    }
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity = a(paramActivity);
    if (paramActivity != null) {
      paramActivity.a();
    }
  }
  
  @Nullable
  public static u c(@NonNull View paramView)
  {
    paramView = a(paramView);
    if (paramView == null) {
      return null;
    }
    if ((paramView.getOnLayoutListener() == null) || (!(paramView.getOnLayoutListener() instanceof u))) {
      paramView.setOnLayoutListener(new u());
    }
    return (u)paramView.getOnLayoutListener();
  }
  
  public void a()
  {
    View localView = this.b;
    if (localView != null)
    {
      localView.setVisibility(8);
      this.b = null;
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.b = null;
    }
    if (this != paramView.getParent())
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.b = paramView;
      localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      super.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new n.b(null);
      ((n.b)localObject).a = paramBoolean;
      this.h.put(paramView, localObject);
    }
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      View localView = this.b;
      if ((localView != null) && (localView.isShown()))
      {
        this.b.setVisibility(8);
        return true;
      }
      if (h.a(getContext())) {
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void addView(View paramView)
  {
    if ((paramView == this.c) || (paramView == this.b)) {
      super.addView(paramView);
    }
  }
  
  public void addView(View paramView, int paramInt)
  {
    if ((paramView == this.c) || (paramView == this.b)) {
      super.addView(paramView, paramInt);
    }
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView == this.c) || (paramView == this.b)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView == this.c) || (paramView == this.b)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView == this.c) || (paramView == this.b)) {
      super.addView(paramView, paramLayoutParams);
    }
  }
  
  protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    return false;
  }
  
  protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return false;
  }
  
  public void b(View paramView)
  {
    a(paramView, false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = (n.b)this.h.get(this.b);
    if ((localObject != null) && (((n.b)localObject).a))
    {
      localObject = this.b;
      if ((localObject != null) && (((View)localObject).isShown()) && (paramMotionEvent.getAction() == 0))
      {
        float f1 = paramMotionEvent.getRawY();
        this.b.getLocationOnScreen(this.f);
        float f2 = this.f[1];
        float f3 = this.b.getHeight();
        if ((f1 < f2) || (f1 > f3 + f2))
        {
          this.b.setVisibility(8);
          return true;
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View getCurrentBottomPanel()
  {
    return this.b;
  }
  
  public a getOnLayoutListener()
  {
    return this.g;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = true;
    b();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a locala = this.g;
    if (locala != null) {
      locala.a(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.e = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = this.d;
    if (m > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    this.h.remove(paramView);
  }
  
  public void setForceHeight(int paramInt)
  {
    int m;
    if (paramInt != this.d) {
      m = 1;
    } else {
      m = 0;
    }
    this.d = paramInt;
    if (m != 0)
    {
      if (!ViewCompat.isLaidOut(this)) {
        return;
      }
      if (this.e) {
        return;
      }
      requestLayout();
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnLayoutListener(a parama)
  {
    this.g = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.n
 * JD-Core Version:    0.7.0.1
 */