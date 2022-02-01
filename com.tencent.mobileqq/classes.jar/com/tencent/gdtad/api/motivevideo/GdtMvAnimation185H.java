package com.tencent.gdtad.api.motivevideo;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

public class GdtMvAnimation185H
  extends GdtMvViewAnimationAbs
{
  private Runnable a;
  
  protected GdtMvAnimation185H(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    GdtLog.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs + " targetMode " + paramInt);
    GdtMvAniData185H localGdtMvAniData185H;
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs != null)
    {
      localGdtMvAniData185H = (GdtMvAniData185H)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs;
      a();
      if (paramInt == 1)
      {
        if (localGdtMvAniData185H.jdField_a_of_type_AndroidViewView != null) {
          localGdtMvAniData185H.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localGdtMvAniData185H.jdField_f_of_type_AndroidViewView, localGdtMvAniData185H.j, localGdtMvAniData185H.k, localGdtMvAniData185H.i);
        a(localGdtMvAniData185H.jdField_e_of_type_AndroidViewView, localGdtMvAniData185H.jdField_g_of_type_Int, localGdtMvAniData185H.jdField_h_of_type_Int);
        a(localGdtMvAniData185H.jdField_b_of_type_AndroidViewView, localGdtMvAniData185H.jdField_a_of_type_Int, localGdtMvAniData185H.jdField_b_of_type_Int);
        a(localGdtMvAniData185H.jdField_d_of_type_AndroidViewView, localGdtMvAniData185H.jdField_e_of_type_Int, localGdtMvAniData185H.jdField_f_of_type_Int);
        a(localGdtMvAniData185H.jdField_c_of_type_AndroidViewView, localGdtMvAniData185H.jdField_c_of_type_Int, localGdtMvAniData185H.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localGdtMvAniData185H.jdField_f_of_type_AndroidViewView, -localGdtMvAniData185H.j, -localGdtMvAniData185H.k, -localGdtMvAniData185H.i);
    a(localGdtMvAniData185H.jdField_e_of_type_AndroidViewView, -localGdtMvAniData185H.jdField_g_of_type_Int, -localGdtMvAniData185H.jdField_h_of_type_Int);
    a(localGdtMvAniData185H.jdField_b_of_type_AndroidViewView, -localGdtMvAniData185H.jdField_a_of_type_Int, -localGdtMvAniData185H.jdField_b_of_type_Int);
    a(localGdtMvAniData185H.jdField_d_of_type_AndroidViewView, -localGdtMvAniData185H.jdField_e_of_type_Int, -localGdtMvAniData185H.jdField_f_of_type_Int);
    a(localGdtMvAniData185H.jdField_c_of_type_AndroidViewView, -localGdtMvAniData185H.jdField_c_of_type_Int, -localGdtMvAniData185H.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    GdtMvAniData185H localGdtMvAniData185H = new GdtMvAniData185H();
    localGdtMvAniData185H.jdField_a_of_type_AndroidViewView = paramView1;
    localGdtMvAniData185H.jdField_f_of_type_AndroidViewView = paramView3;
    localGdtMvAniData185H.jdField_g_of_type_AndroidViewView = paramView2;
    localGdtMvAniData185H.jdField_h_of_type_AndroidViewView = paramView8;
    localGdtMvAniData185H.j = GdtUIUtils.a(-85, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.k = GdtUIUtils.a(-588, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.i = GdtUIUtils.a(416, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = GdtUIUtils.a(400, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localGdtMvAniData185H.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localGdtMvAniData185H.jdField_b_of_type_Float = localGdtMvAniData185H.jdField_a_of_type_Float;
    }
    localGdtMvAniData185H.l = GdtUIUtils.a(50, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.m = GdtUIUtils.a(50, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.jdField_b_of_type_AndroidViewView = paramView4;
    localGdtMvAniData185H.jdField_c_of_type_AndroidViewView = paramView5;
    localGdtMvAniData185H.jdField_d_of_type_AndroidViewView = paramView6;
    localGdtMvAniData185H.jdField_e_of_type_AndroidViewView = paramView7;
    localGdtMvAniData185H.jdField_a_of_type_Int = GdtUIUtils.a(-436, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.jdField_b_of_type_Int = GdtUIUtils.a(567, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.jdField_c_of_type_Int = GdtUIUtils.a(-275, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.jdField_d_of_type_Int = ((GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - GdtUIUtils.a(196, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    localGdtMvAniData185H.jdField_e_of_type_Int = GdtUIUtils.a(-269, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.jdField_f_of_type_Int = ((GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - GdtUIUtils.a(196, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    localGdtMvAniData185H.jdField_g_of_type_Int = GdtUIUtils.a(-257, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185H.jdField_h_of_type_Int = ((GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - GdtUIUtils.a(196, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localGdtMvAniData185H, paramView8);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs = localGdtMvAniData185H;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H
 * JD-Core Version:    0.7.0.1
 */