package com.tencent.gdtad.basics.motivevideo.elements;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

public class GdtMvAnimation585V
  extends GdtMvViewAnimationAbs
{
  private Runnable d = new GdtMvAnimation585V.1(this);
  
  protected GdtMvAnimation585V(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("585V doAnimation ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" targetMode ");
    ((StringBuilder)localObject).append(paramInt);
    GdtLog.b("GdtMotiveVideoAd", ((StringBuilder)localObject).toString());
    if (this.a != null)
    {
      localObject = (GdtMvAniData585V)this.a;
      a();
      if (paramInt == 1)
      {
        if (((GdtMvAniData585V)localObject).a != null) {
          ((GdtMvAniData585V)localObject).a.setVisibility(4);
        }
        a(((GdtMvAniData585V)localObject).o, ((GdtMvAniData585V)localObject).p, ((GdtMvAniData585V)localObject).q);
        a(((GdtMvAniData585V)localObject).k, ((GdtMvAniData585V)localObject).l, ((GdtMvAniData585V)localObject).m);
        a(((GdtMvAniData585V)localObject).b, ((GdtMvAniData585V)localObject).c, ((GdtMvAniData585V)localObject).d);
        a(((GdtMvAniData585V)localObject).h, ((GdtMvAniData585V)localObject).i, ((GdtMvAniData585V)localObject).j);
        a(((GdtMvAniData585V)localObject).e, ((GdtMvAniData585V)localObject).f, ((GdtMvAniData585V)localObject).g);
        return;
      }
      this.c.removeCallbacks(this.d);
      this.c.postDelayed(this.d, 300L);
      a(((GdtMvAniData585V)localObject).o, -((GdtMvAniData585V)localObject).p, -((GdtMvAniData585V)localObject).q);
      a(((GdtMvAniData585V)localObject).k, -((GdtMvAniData585V)localObject).l, -((GdtMvAniData585V)localObject).m);
      a(((GdtMvAniData585V)localObject).b, -((GdtMvAniData585V)localObject).c, -((GdtMvAniData585V)localObject).d);
      a(((GdtMvAniData585V)localObject).h, -((GdtMvAniData585V)localObject).i, -((GdtMvAniData585V)localObject).j);
      a(((GdtMvAniData585V)localObject).e, -((GdtMvAniData585V)localObject).f, -((GdtMvAniData585V)localObject).g);
    }
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    GdtMvAniData585V localGdtMvAniData585V = new GdtMvAniData585V();
    localGdtMvAniData585V.a = paramView1;
    localGdtMvAniData585V.o = paramView3;
    localGdtMvAniData585V.r = paramView2;
    localGdtMvAniData585V.p = GdtUIUtils.b(-406, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData585V.q = GdtUIUtils.b(125, 750, GdtUIUtils.e(this.b));
    float f = GdtUIUtils.b(220, 750, GdtUIUtils.e(this.b));
    if (f > 0.0F)
    {
      localGdtMvAniData585V.s = (Float.valueOf(f * 1.0F / GdtUIUtils.e(this.b)).floatValue() - 1.0F);
      localGdtMvAniData585V.t = localGdtMvAniData585V.s;
    }
    localGdtMvAniData585V.u = GdtUIUtils.b(50, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData585V.v = GdtUIUtils.b(50, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData585V.b = paramView4;
    localGdtMvAniData585V.e = paramView5;
    localGdtMvAniData585V.h = paramView6;
    localGdtMvAniData585V.k = paramView7;
    localGdtMvAniData585V.c = GdtUIUtils.b(-618, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData585V.d = GdtUIUtils.b(275, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData585V.f = GdtUIUtils.b(-457, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData585V.g = ((GdtUIUtils.e(this.b) - paramView5.getWidth()) / 2 - GdtUIUtils.b(196, 750, GdtUIUtils.e(this.b)));
    localGdtMvAniData585V.i = GdtUIUtils.b(-451, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData585V.j = ((GdtUIUtils.e(this.b) - paramView6.getWidth()) / 2 - GdtUIUtils.b(196, 750, GdtUIUtils.e(this.b)));
    localGdtMvAniData585V.l = GdtUIUtils.b(-440, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData585V.m = ((GdtUIUtils.e(this.b) - paramView7.getWidth()) / 2 - GdtUIUtils.b(196, 750, GdtUIUtils.e(this.b)));
    a(localGdtMvAniData585V, paramView8);
    this.a = localGdtMvAniData585V;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAnimation585V
 * JD-Core Version:    0.7.0.1
 */