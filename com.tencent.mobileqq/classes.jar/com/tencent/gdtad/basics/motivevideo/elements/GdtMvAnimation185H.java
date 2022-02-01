package com.tencent.gdtad.basics.motivevideo.elements;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

public class GdtMvAnimation185H
  extends GdtMvViewAnimationAbs
{
  private Runnable d = new GdtMvAnimation185H.1(this);
  
  protected GdtMvAnimation185H(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("185H doAnimation ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" targetMode ");
    ((StringBuilder)localObject).append(paramInt);
    GdtLog.b("GdtMotiveVideoAd", ((StringBuilder)localObject).toString());
    if (this.a != null)
    {
      localObject = (GdtMvAniData185H)this.a;
      a();
      if (paramInt == 1)
      {
        if (((GdtMvAniData185H)localObject).a != null) {
          ((GdtMvAniData185H)localObject).a.setVisibility(4);
        }
        a(((GdtMvAniData185H)localObject).o, ((GdtMvAniData185H)localObject).p, ((GdtMvAniData185H)localObject).q, ((GdtMvAniData185H)localObject).n);
        a(((GdtMvAniData185H)localObject).k, ((GdtMvAniData185H)localObject).l, ((GdtMvAniData185H)localObject).m);
        a(((GdtMvAniData185H)localObject).b, ((GdtMvAniData185H)localObject).c, ((GdtMvAniData185H)localObject).d);
        a(((GdtMvAniData185H)localObject).h, ((GdtMvAniData185H)localObject).i, ((GdtMvAniData185H)localObject).j);
        a(((GdtMvAniData185H)localObject).e, ((GdtMvAniData185H)localObject).f, ((GdtMvAniData185H)localObject).g);
        return;
      }
      this.c.removeCallbacks(this.d);
      this.c.postDelayed(this.d, 300L);
      a(((GdtMvAniData185H)localObject).o, -((GdtMvAniData185H)localObject).p, -((GdtMvAniData185H)localObject).q, -((GdtMvAniData185H)localObject).n);
      a(((GdtMvAniData185H)localObject).k, -((GdtMvAniData185H)localObject).l, -((GdtMvAniData185H)localObject).m);
      a(((GdtMvAniData185H)localObject).b, -((GdtMvAniData185H)localObject).c, -((GdtMvAniData185H)localObject).d);
      a(((GdtMvAniData185H)localObject).h, -((GdtMvAniData185H)localObject).i, -((GdtMvAniData185H)localObject).j);
      a(((GdtMvAniData185H)localObject).e, -((GdtMvAniData185H)localObject).f, -((GdtMvAniData185H)localObject).g);
    }
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    GdtMvAniData185H localGdtMvAniData185H = new GdtMvAniData185H();
    localGdtMvAniData185H.a = paramView1;
    localGdtMvAniData185H.o = paramView3;
    localGdtMvAniData185H.r = paramView2;
    localGdtMvAniData185H.y = paramView8;
    localGdtMvAniData185H.p = GdtUIUtils.b(-85, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData185H.q = GdtUIUtils.b(-588, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData185H.n = GdtUIUtils.b(416, 1334, GdtUIUtils.d(this.b));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = GdtUIUtils.b(400, 1334, GdtUIUtils.d(this.b));
    if (f > 0.0F)
    {
      localGdtMvAniData185H.s = (Float.valueOf(f * 1.0F / GdtUIUtils.d(this.b)).floatValue() - 1.0F);
      localGdtMvAniData185H.t = localGdtMvAniData185H.s;
    }
    localGdtMvAniData185H.u = GdtUIUtils.b(50, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData185H.v = GdtUIUtils.b(50, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData185H.b = paramView4;
    localGdtMvAniData185H.e = paramView5;
    localGdtMvAniData185H.h = paramView6;
    localGdtMvAniData185H.k = paramView7;
    localGdtMvAniData185H.c = GdtUIUtils.b(-436, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData185H.d = GdtUIUtils.b(567, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData185H.f = GdtUIUtils.b(-275, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData185H.g = ((GdtUIUtils.d(this.b) - paramView5.getWidth()) / 2 - GdtUIUtils.b(196, 1334, GdtUIUtils.d(this.b)));
    localGdtMvAniData185H.i = GdtUIUtils.b(-269, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData185H.j = ((GdtUIUtils.d(this.b) - paramView6.getWidth()) / 2 - GdtUIUtils.b(196, 1334, GdtUIUtils.d(this.b)));
    localGdtMvAniData185H.l = GdtUIUtils.b(-257, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData185H.m = ((GdtUIUtils.d(this.b) - paramView7.getWidth()) / 2 - GdtUIUtils.b(196, 1334, GdtUIUtils.d(this.b)));
    a(localGdtMvAniData185H, paramView8);
    this.a = localGdtMvAniData185H;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAnimation185H
 * JD-Core Version:    0.7.0.1
 */