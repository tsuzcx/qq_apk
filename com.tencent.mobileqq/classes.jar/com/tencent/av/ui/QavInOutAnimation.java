package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.UITools;
import java.lang.ref.SoftReference;

public class QavInOutAnimation
{
  Animation.AnimationListener A = null;
  Animation.AnimationListener B = null;
  Animation.AnimationListener C = null;
  int a = 0;
  View b = null;
  View c = null;
  View d = null;
  View e = null;
  View f = null;
  View g = null;
  View h = null;
  QavPanel i = null;
  Animation j = null;
  Animation k = null;
  Animation l = null;
  Animation m = null;
  Animation n = null;
  Animation o = null;
  Animation p = null;
  Animation q = null;
  Animation r = null;
  Animation s = null;
  Animation t = null;
  Animation u = null;
  Animation v = null;
  SoftReference<Context> w = null;
  VideoController x = null;
  QavInOutAnimation.QavInAnimationListener y = null;
  QavInOutAnimation.QavOutAnimationListener z = null;
  
  public QavInOutAnimation(Context paramContext, VideoController paramVideoController, int paramInt, QavPanel paramQavPanel, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6)
  {
    this.w = new SoftReference(paramContext);
    this.x = paramVideoController;
    this.a = paramInt;
    this.i = paramQavPanel;
    this.b = paramView1;
    this.c = paramView2;
    this.d = paramView3;
    this.e = paramView4;
    this.f = paramView5;
    this.h = paramView6;
    this.j = new AlphaAnimation(0.0F, 0.0F);
    this.j.setDuration(500L);
    this.k = new AlphaAnimation(0.0F, 0.0F);
    this.k.setDuration(500L);
    paramVideoController = new DecelerateInterpolator();
    paramQavPanel = new AccelerateInterpolator();
    this.l = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    paramView1 = this.l;
    long l1 = 620;
    paramView1.setDuration(l1);
    this.l.setInterpolator(paramVideoController);
    this.q = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    this.q.setDuration(l1);
    this.q.setInterpolator(paramQavPanel);
    paramInt = UITools.a(paramContext);
    int i1;
    if (paramInt <= 320)
    {
      i1 = paramContext.getResources().getDimensionPixelSize(2131298464);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131298460);
    }
    for (;;)
    {
      break;
      if (paramInt <= 480)
      {
        i1 = paramContext.getResources().getDimensionPixelSize(2131298465);
        paramInt = paramContext.getResources().getDimensionPixelSize(2131298461);
      }
      else
      {
        i1 = paramContext.getResources().getDimensionPixelSize(2131298467);
        paramInt = paramContext.getResources().getDimensionPixelSize(2131298463);
      }
    }
    float f1 = -(i1 + paramInt);
    this.m = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, f1, 1, 0.0F);
    this.m.setDuration(l1);
    this.m.setInterpolator(paramVideoController);
    this.r = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 0, f1);
    this.r.setDuration(l1);
    this.r.setInterpolator(paramQavPanel);
    this.n = new AlphaAnimation(0.0F, 1.0F);
    this.n.setDuration(l1);
    this.s = new AlphaAnimation(1.0F, 0.0F);
    this.s.setDuration(l1);
    this.o = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.o.setDuration(l1);
    this.o.setInterpolator(paramVideoController);
    this.t = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.t.setDuration(l1);
    this.t.setInterpolator(paramQavPanel);
    this.u = new AlphaAnimation(0.0F, 0.0F);
    this.u.setDuration(l1);
    this.p = new AlphaAnimation(0.0F, 0.0F);
    this.p.setDuration(l1);
    this.v = new AlphaAnimation(0.0F, 0.0F);
    this.v.setDuration(l1);
    this.A = new QavInOutAnimation.InAnimationListener(this);
    this.B = new QavInOutAnimation.InDelayAnimationListener(this);
    this.C = new QavInOutAnimation.OutAnimationListener(this);
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(QavInOutAnimation.QavInAnimationListener paramQavInAnimationListener)
  {
    this.y = paramQavInAnimationListener;
    paramQavInAnimationListener = this.x;
    if ((paramQavInAnimationListener != null) && (paramQavInAnimationListener.k() != null) && (!this.x.k().bD) && (this.i != null))
    {
      paramQavInAnimationListener = this.o;
      if ((paramQavInAnimationListener != null) && (this.j != null))
      {
        paramQavInAnimationListener.setAnimationListener(this.A);
        this.j.setAnimationListener(this.B);
        this.i.startAnimation(this.j);
        paramQavInAnimationListener = this.b;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.k);
        }
        paramQavInAnimationListener = this.c;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.k);
        }
        paramQavInAnimationListener = this.d;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.k);
        }
        paramQavInAnimationListener = this.e;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.k);
        }
        paramQavInAnimationListener = this.f;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.k);
        }
        paramQavInAnimationListener = this.h;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.k);
        }
        return;
      }
    }
    paramQavInAnimationListener = this.y;
    if (paramQavInAnimationListener != null)
    {
      paramQavInAnimationListener.a();
      this.y.b();
    }
  }
  
  public void a(QavInOutAnimation.QavOutAnimationListener paramQavOutAnimationListener)
  {
    this.z = paramQavOutAnimationListener;
    paramQavOutAnimationListener = this.x;
    if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.k() != null) && (!this.x.k().bE))
    {
      QavPanel localQavPanel = this.i;
      if (localQavPanel != null)
      {
        paramQavOutAnimationListener = this.t;
        if (paramQavOutAnimationListener != null)
        {
          if (localQavPanel.getVisibility() != 0) {
            paramQavOutAnimationListener = this.u;
          }
          paramQavOutAnimationListener.setAnimationListener(this.C);
          this.i.startAnimation(paramQavOutAnimationListener);
          if (this.i.getWave() != null) {
            this.i.getWave().startAnimation(this.v);
          }
          paramQavOutAnimationListener = this.b;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.b.startAnimation(this.q);
          }
          paramQavOutAnimationListener = this.c;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.c.startAnimation(this.r);
          }
          paramQavOutAnimationListener = this.d;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.d.startAnimation(this.r);
          }
          paramQavOutAnimationListener = this.e;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.e.startAnimation(this.s);
          }
          paramQavOutAnimationListener = this.f;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.f.startAnimation(this.s);
          }
          paramQavOutAnimationListener = this.h;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.h.startAnimation(this.s);
          }
          this.x.k().bE = true;
          return;
        }
      }
    }
    paramQavOutAnimationListener = this.x;
    if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.k() != null))
    {
      this.x.k().bD = false;
      this.x.k().bE = false;
    }
    paramQavOutAnimationListener = this.z;
    if (paramQavOutAnimationListener != null)
    {
      paramQavOutAnimationListener.a();
      this.z.b();
    }
  }
  
  public void b()
  {
    this.w = null;
    this.x = null;
    Animation localAnimation = this.l;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.m;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.n;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.o;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.p;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.q;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.r;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.s;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.t;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.u;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.v;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.u = null;
    this.v = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
    this.i = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavInOutAnimation
 * JD-Core Version:    0.7.0.1
 */