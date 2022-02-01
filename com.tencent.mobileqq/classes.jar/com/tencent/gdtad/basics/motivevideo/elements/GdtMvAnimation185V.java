package com.tencent.gdtad.basics.motivevideo.elements;

import android.content.Context;
import android.view.View;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

public class GdtMvAnimation185V
  extends GdtMvViewAnimationAbs
{
  protected GdtMvAnimation185V(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("185V doAnimation ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" targetMode ");
    ((StringBuilder)localObject).append(paramInt);
    GdtLog.b("GdtMotiveVideoAd", ((StringBuilder)localObject).toString());
    if (this.a != null)
    {
      localObject = (GdtMvAniData185V)this.a;
      a();
      if (paramInt == 1)
      {
        a(((GdtMvAniData185V)localObject).a, ((GdtMvAniData185V)localObject).b, 0);
        a(((GdtMvAniData185V)localObject).o, ((GdtMvAniData185V)localObject).p, ((GdtMvAniData185V)localObject).q);
        return;
      }
      a(((GdtMvAniData185V)localObject).a, -((GdtMvAniData185V)localObject).b, 0);
      a(((GdtMvAniData185V)localObject).o, -((GdtMvAniData185V)localObject).p, -((GdtMvAniData185V)localObject).q);
    }
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    GdtMvAniData185V localGdtMvAniData185V = new GdtMvAniData185V();
    localGdtMvAniData185V.a = paramView1;
    localGdtMvAniData185V.o = paramView2;
    localGdtMvAniData185V.r = paramView3;
    localGdtMvAniData185V.b = GdtUIUtils.b(-306, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData185V.p = GdtUIUtils.b(-406, 1334, GdtUIUtils.d(this.b));
    localGdtMvAniData185V.q = GdtUIUtils.b(125, 750, GdtUIUtils.e(this.b));
    float f = GdtUIUtils.b(400, 750, GdtUIUtils.e(this.b));
    if (f > 0.0F)
    {
      localGdtMvAniData185V.s = (Float.valueOf(f * 1.0F / GdtUIUtils.e(this.b)).floatValue() - 1.0F);
      localGdtMvAniData185V.t = localGdtMvAniData185V.s;
    }
    localGdtMvAniData185V.u = GdtUIUtils.b(50, 750, GdtUIUtils.e(this.b));
    localGdtMvAniData185V.v = GdtUIUtils.b(-100, 1334, GdtUIUtils.d(this.b));
    a(localGdtMvAniData185V, paramView4);
    this.a = localGdtMvAniData185V;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAnimation185V
 * JD-Core Version:    0.7.0.1
 */