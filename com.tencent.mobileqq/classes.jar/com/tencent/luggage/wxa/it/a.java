package com.tencent.luggage.wxa.it;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.wxa.ir.b;

public class a
{
  protected ViewGroup a;
  protected com.tencent.luggage.wxa.iq.a b;
  protected int c = 80;
  private Context d;
  private ViewGroup e;
  private ViewGroup f;
  private b g;
  private boolean h;
  private Animation i;
  private Animation j;
  private boolean k;
  private Dialog l;
  private boolean m = true;
  private View.OnKeyListener n = new a.3(this);
  private final View.OnTouchListener o = new a.4(this);
  
  public a(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private Animation i()
  {
    int i1 = com.tencent.luggage.wxa.is.a.a(this.c, true);
    return AnimationUtils.loadAnimation(this.d, i1);
  }
  
  private Animation j()
  {
    int i1 = com.tencent.luggage.wxa.is.a.a(this.c, false);
    return AnimationUtils.loadAnimation(this.d, i1);
  }
  
  private void k()
  {
    Dialog localDialog = this.l;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  public View a(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  protected void a()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
    this.e = ((ViewGroup)LayoutInflater.from(this.d).inflate(2131625209, this.b.C, false));
    this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (this.b.Q != -1) {
      this.e.setBackgroundColor(this.b.Q);
    }
    this.a = ((ViewGroup)this.e.findViewById(2131431340));
    this.a.setLayoutParams(localLayoutParams);
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (h()) {
      localViewGroup = this.f;
    } else {
      localViewGroup = this.e;
    }
    localViewGroup.setFocusable(paramBoolean);
    localViewGroup.setFocusableInTouchMode(paramBoolean);
    if (paramBoolean)
    {
      localViewGroup.setOnKeyListener(this.n);
      return;
    }
    localViewGroup.setOnKeyListener(null);
  }
  
  protected a b(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).findViewById(2131439728);
      if (paramBoolean)
      {
        ((View)localObject).setOnTouchListener(this.o);
        return this;
      }
      ((View)localObject).setOnTouchListener(null);
    }
    return this;
  }
  
  protected void b()
  {
    this.j = i();
    this.i = j();
  }
  
  protected void c() {}
  
  public boolean d()
  {
    boolean bool2 = h();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((this.e.getParent() != null) || (this.k)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void e()
  {
    if (h())
    {
      k();
      return;
    }
    if (this.h) {
      return;
    }
    if (this.m)
    {
      this.i.setAnimationListener(new a.1(this));
      this.a.startAnimation(this.i);
    }
    else
    {
      f();
    }
    this.h = true;
  }
  
  public void f()
  {
    this.b.C.post(new a.2(this));
  }
  
  public void g()
  {
    Dialog localDialog = this.l;
    if (localDialog != null) {
      localDialog.setCancelable(this.b.T);
    }
  }
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.a
 * JD-Core Version:    0.7.0.1
 */