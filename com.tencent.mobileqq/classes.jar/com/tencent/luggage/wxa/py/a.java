package com.tencent.luggage.wxa.py;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public final class a
{
  private final com.tencent.mm.plugin.appbrand.page.u a;
  private a.a b;
  
  public a(@NonNull com.tencent.mm.plugin.appbrand.page.u paramu)
  {
    this.a = paramu;
  }
  
  @UiThread
  public static boolean a(d paramd)
  {
    if (paramd == null) {
      return false;
    }
    e();
    paramd = (a.b)paramd.c(a.b.class);
    if (paramd != null) {
      return paramd.a();
    }
    return false;
  }
  
  @Nullable
  private a.a b()
  {
    Object localObject = this.b;
    if ((localObject != null) && (!a.a.a((a.a)localObject))) {
      return this.b;
    }
    this.b = null;
    localObject = this.a.ak().d();
    int i = 0;
    while (i < ((ViewGroup)localObject).getChildCount())
    {
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if ((localView instanceof a.a)) {
        return (a.a)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private a.a c()
  {
    ViewGroup localViewGroup = this.a.ak().d();
    a.a locala2 = b();
    a.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a.a(this.a.getContext());
      locala1.addOnAttachStateChangeListener(new a.1(this));
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.b = locala1;
    return locala1;
  }
  
  private void d()
  {
    b localb = this.a.ah();
    if (localb == null) {
      return;
    }
    a(localb.getTop() + localb.getMeasuredHeight());
  }
  
  private static void e()
  {
    if (com.tencent.luggage.wxa.pd.u.a()) {
      return;
    }
    throw new RuntimeException("Should be called on main-thread");
  }
  
  public void a(int paramInt)
  {
    a.a locala = b();
    if ((locala != null) && ((locala.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)locala.getLayoutParams();
      if (paramInt != localMarginLayoutParams.topMargin)
      {
        localMarginLayoutParams.topMargin = paramInt;
        locala.requestLayout();
      }
    }
  }
  
  @MainThread
  public void a(@NonNull View paramView)
  {
    if (this.a.d())
    {
      if (this.a.q() == null) {
        return;
      }
      e();
      a.a locala = c();
      d();
      paramView.setTag(2131428600, Boolean.valueOf(true));
      locala.addView(paramView);
      a.b.a(a.b.a(this.a.q())).add(this.a);
    }
  }
  
  @MainThread
  public boolean a()
  {
    boolean bool1 = this.a.d();
    boolean bool2 = false;
    int i = 0;
    if (!bool1) {
      return false;
    }
    e();
    a.a locala = this.b;
    bool1 = bool2;
    if (locala != null)
    {
      bool1 = bool2;
      if (ViewCompat.isAttachedToWindow(locala))
      {
        Object localObject = new LinkedList();
        View localView;
        while (i < locala.getChildCount())
        {
          localView = locala.getChildAt(i);
          if ((localView != null) && (Objects.equals(localView.getTag(2131428600), Boolean.TRUE))) {
            ((LinkedList)localObject).add(localView);
          }
          i += 1;
        }
        bool2 = ((LinkedList)localObject).isEmpty() ^ true;
        localObject = ((LinkedList)localObject).iterator();
        for (;;)
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localView = (View)((Iterator)localObject).next();
          localView.setVisibility(8);
          locala.removeView(localView);
        }
      }
    }
    if ((bool1) && (this.a.q() != null)) {
      a.b.a(a.b.a(this.a.q())).remove(this.a);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.py.a
 * JD-Core Version:    0.7.0.1
 */