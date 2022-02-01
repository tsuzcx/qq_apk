package com.tencent.gdtad.api.motivevideo;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

public class GdtMvAnimation585V
  extends GdtMvViewAnimationAbs
{
  private Runnable a;
  
  protected GdtMvAnimation585V(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    GdtLog.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs + " targetMode " + paramInt);
    GdtMvAniData585V localGdtMvAniData585V;
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs != null)
    {
      localGdtMvAniData585V = (GdtMvAniData585V)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs;
      a();
      if (paramInt == 1)
      {
        if (localGdtMvAniData585V.jdField_a_of_type_AndroidViewView != null) {
          localGdtMvAniData585V.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localGdtMvAniData585V.jdField_f_of_type_AndroidViewView, localGdtMvAniData585V.j, localGdtMvAniData585V.k);
        a(localGdtMvAniData585V.jdField_e_of_type_AndroidViewView, localGdtMvAniData585V.jdField_g_of_type_Int, localGdtMvAniData585V.h);
        a(localGdtMvAniData585V.jdField_b_of_type_AndroidViewView, localGdtMvAniData585V.jdField_a_of_type_Int, localGdtMvAniData585V.jdField_b_of_type_Int);
        a(localGdtMvAniData585V.jdField_d_of_type_AndroidViewView, localGdtMvAniData585V.jdField_e_of_type_Int, localGdtMvAniData585V.jdField_f_of_type_Int);
        a(localGdtMvAniData585V.jdField_c_of_type_AndroidViewView, localGdtMvAniData585V.jdField_c_of_type_Int, localGdtMvAniData585V.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localGdtMvAniData585V.jdField_f_of_type_AndroidViewView, -localGdtMvAniData585V.j, -localGdtMvAniData585V.k);
    a(localGdtMvAniData585V.jdField_e_of_type_AndroidViewView, -localGdtMvAniData585V.jdField_g_of_type_Int, -localGdtMvAniData585V.h);
    a(localGdtMvAniData585V.jdField_b_of_type_AndroidViewView, -localGdtMvAniData585V.jdField_a_of_type_Int, -localGdtMvAniData585V.jdField_b_of_type_Int);
    a(localGdtMvAniData585V.jdField_d_of_type_AndroidViewView, -localGdtMvAniData585V.jdField_e_of_type_Int, -localGdtMvAniData585V.jdField_f_of_type_Int);
    a(localGdtMvAniData585V.jdField_c_of_type_AndroidViewView, -localGdtMvAniData585V.jdField_c_of_type_Int, -localGdtMvAniData585V.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    GdtMvAniData585V localGdtMvAniData585V = new GdtMvAniData585V();
    localGdtMvAniData585V.jdField_a_of_type_AndroidViewView = paramView1;
    localGdtMvAniData585V.jdField_f_of_type_AndroidViewView = paramView3;
    localGdtMvAniData585V.jdField_g_of_type_AndroidViewView = paramView2;
    localGdtMvAniData585V.j = GdtUIUtils.a(-406, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.k = GdtUIUtils.a(125, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    float f = GdtUIUtils.a(220, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localGdtMvAniData585V.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localGdtMvAniData585V.jdField_b_of_type_Float = localGdtMvAniData585V.jdField_a_of_type_Float;
    }
    localGdtMvAniData585V.l = GdtUIUtils.a(50, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.m = GdtUIUtils.a(50, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_b_of_type_AndroidViewView = paramView4;
    localGdtMvAniData585V.jdField_c_of_type_AndroidViewView = paramView5;
    localGdtMvAniData585V.jdField_d_of_type_AndroidViewView = paramView6;
    localGdtMvAniData585V.jdField_e_of_type_AndroidViewView = paramView7;
    localGdtMvAniData585V.jdField_a_of_type_Int = GdtUIUtils.a(-618, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_b_of_type_Int = GdtUIUtils.a(275, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_c_of_type_Int = GdtUIUtils.a(-457, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_d_of_type_Int = ((GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - GdtUIUtils.a(196, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext)));
    localGdtMvAniData585V.jdField_e_of_type_Int = GdtUIUtils.a(-451, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_f_of_type_Int = ((GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - GdtUIUtils.a(196, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext)));
    localGdtMvAniData585V.jdField_g_of_type_Int = GdtUIUtils.a(-440, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.h = ((GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - GdtUIUtils.a(196, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localGdtMvAniData585V, paramView8);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs = localGdtMvAniData585V;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V
 * JD-Core Version:    0.7.0.1
 */