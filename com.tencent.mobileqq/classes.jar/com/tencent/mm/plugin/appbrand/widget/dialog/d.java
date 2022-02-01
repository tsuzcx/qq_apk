package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
  extends RelativeLayout
  implements l
{
  private int b = 0;
  private final s c = new s(Looper.getMainLooper());
  private final h d = new h(this);
  private final LinkedList<i> e = new LinkedList();
  private final View.OnClickListener f = new d.1(this);
  private final Runnable g = new d.2(this);
  private i h;
  private i i;
  private boolean j = false;
  private Set<k> k = new ArraySet();
  private final Set<j> l = new ArraySet();
  private final Set<j> m = new ArraySet();
  private boolean n = false;
  private boolean o = true;
  
  public d(@NonNull Context paramContext)
  {
    super(paramContext);
    setVisibility(4);
    setBackgroundColor(0);
    setOnClickListener(this.f);
    paramContext = (WindowManager)getContext().getSystemService("window");
    if (paramContext != null) {
      this.b = paramContext.getDefaultDisplay().getRotation();
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getParent() == null) {
        return;
      }
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  private void c()
  {
    i locali = (i)this.e.peekLast();
    if (locali == null)
    {
      setVisibility(8);
      return;
    }
    if (locali.f())
    {
      locali.e();
      b(locali);
    }
  }
  
  Animator a(Animator paramAnimator, Interpolator paramInterpolator)
  {
    paramAnimator.setInterpolator(paramInterpolator);
    return paramAnimator;
  }
  
  Animator a(View paramView, int paramInt)
  {
    if (paramInt == 2)
    {
      localObject1 = new AccelerateInterpolator();
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).playTogether(new Animator[] { a(ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramView.getHeight() }).setDuration(200L), (Interpolator)localObject1) });
      return localObject2;
    }
    Object localObject1 = AnimationUtils.loadInterpolator(paramView.getContext(), 2130772074);
    Object localObject2 = AnimationUtils.loadInterpolator(paramView.getContext(), 2130772071);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { a(ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.9F }).setDuration(220L), (Interpolator)localObject1), a(ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.9F }).setDuration(220L), (Interpolator)localObject1), a(ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(150L), (Interpolator)localObject2) });
    return localAnimatorSet;
  }
  
  @UiThread
  public void a()
  {
    if (this.d.b()) {
      this.d.a();
    }
    if (!this.e.isEmpty())
    {
      d.6 local6 = new d.6(this);
      while (!this.e.isEmpty()) {
        local6.apply(this.e.pollFirst());
      }
    }
    this.h = null;
    this.i = null;
    this.n = false;
    this.l.clear();
    this.m.clear();
    removeAllViewsInLayout();
    this.c.a(null);
    this.g.run();
  }
  
  public void a(i parami)
  {
    if (parami == null) {
      return;
    }
    o.d("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", new Object[] { parami.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.c.a(new d.3(this, parami));
      return;
    }
    com.tencent.luggage.util.h.a(getContext());
    if (this.d.b()) {
      this.d.a();
    }
    View localView = parami.getContentView();
    if (localView == null)
    {
      o.c("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", new Object[] { parami, Log.getStackTraceString(new Throwable()) });
      return;
    }
    if (localView.getParent() != this)
    {
      a(localView);
      RelativeLayout.LayoutParams localLayoutParams;
      if (parami.h() == 2)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(14);
      }
      else
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
      }
      addView(localView, localLayoutParams);
      if (this.i != parami)
      {
        localView.clearAnimation();
        if (parami.h() == 2) {
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772142));
        } else {
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772040));
        }
      }
      this.i = parami;
    }
    localView.setOnClickListener(this.f);
    this.e.add(parami);
    parami.a(this);
    setVisibility(0);
    if (this.o) {
      bringToFront();
    }
    this.d.a(Color.argb(127, 0, 0, 0), null);
    if ((!this.k.isEmpty()) && (!this.j))
    {
      parami = this.k.iterator();
      while (parami.hasNext()) {
        ((k)parami.next()).a(Boolean.valueOf(true));
      }
    }
    this.j = true;
  }
  
  public void a(j paramj)
  {
    if (paramj == null) {
      return;
    }
    this.l.add(paramj);
  }
  
  public void a(k paramk)
  {
    this.k.add(paramk);
  }
  
  public void b(i parami)
  {
    if (parami != null)
    {
      if (parami.getContentView() == null) {
        return;
      }
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        this.c.a(new d.4(this, parami));
        return;
      }
      if (parami.getContentView().getParent() != this) {
        return;
      }
      if (this.h == parami) {
        return;
      }
      this.h = parami;
      if (this.i == parami) {
        this.i = null;
      }
      View localView = parami.getContentView();
      localView.animate().cancel();
      localView.clearAnimation();
      Animator localAnimator = a(localView, parami.h());
      localAnimator.addListener(new d.5(this, localView, parami));
      localAnimator.start();
      if (this.e.size() <= 1) {
        this.d.a(0, this.g);
      }
      if ((!this.k.isEmpty()) && (this.j))
      {
        parami = this.k.iterator();
        while (parami.hasNext()) {
          ((k)parami.next()).a(Boolean.valueOf(false));
        }
      }
      this.j = false;
    }
  }
  
  public void b(j paramj)
  {
    if (paramj == null) {
      return;
    }
    if (!this.n)
    {
      this.l.remove(paramj);
      return;
    }
    this.m.add(paramj);
  }
  
  public void b(k paramk)
  {
    this.k.remove(paramk);
  }
  
  public boolean b()
  {
    i locali = (i)this.e.peekLast();
    if (locali == null)
    {
      setVisibility(8);
      return false;
    }
    if ((!locali.i()) && (locali.g()))
    {
      locali.e();
      b(locali);
    }
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() == 0) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @Nullable
  public i getCurrentDialog()
  {
    return (i)this.e.peekLast();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = (WindowManager)getContext().getSystemService("window");
    if (paramConfiguration != null)
    {
      int i1 = paramConfiguration.getDefaultDisplay().getRotation();
      if (this.b != i1)
      {
        this.b = i1;
        paramConfiguration = this.e.iterator();
        while (paramConfiguration.hasNext()) {
          ((i)paramConfiguration.next()).a(this.b);
        }
      }
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if (this.e.size() == 0) {
      this.d.a(0, this.g);
    }
  }
  
  public void setShouldBringSelfToFrontWhenDialogShown(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.d
 * JD-Core Version:    0.7.0.1
 */