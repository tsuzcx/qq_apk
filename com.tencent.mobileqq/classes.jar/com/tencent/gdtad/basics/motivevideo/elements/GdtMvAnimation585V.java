package com.tencent.gdtad.basics.motivevideo.elements;

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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("585V doAnimation ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAniDataAbs);
    ((StringBuilder)localObject).append(" targetMode ");
    ((StringBuilder)localObject).append(paramInt);
    GdtLog.b("GdtMotiveVideoAd", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAniDataAbs != null)
    {
      localObject = (GdtMvAniData585V)this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAniDataAbs;
      a();
      if (paramInt == 1)
      {
        if (((GdtMvAniData585V)localObject).jdField_a_of_type_AndroidViewView != null) {
          ((GdtMvAniData585V)localObject).jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(((GdtMvAniData585V)localObject).jdField_f_of_type_AndroidViewView, ((GdtMvAniData585V)localObject).j, ((GdtMvAniData585V)localObject).k);
        a(((GdtMvAniData585V)localObject).jdField_e_of_type_AndroidViewView, ((GdtMvAniData585V)localObject).jdField_g_of_type_Int, ((GdtMvAniData585V)localObject).h);
        a(((GdtMvAniData585V)localObject).jdField_b_of_type_AndroidViewView, ((GdtMvAniData585V)localObject).jdField_a_of_type_Int, ((GdtMvAniData585V)localObject).jdField_b_of_type_Int);
        a(((GdtMvAniData585V)localObject).jdField_d_of_type_AndroidViewView, ((GdtMvAniData585V)localObject).jdField_e_of_type_Int, ((GdtMvAniData585V)localObject).jdField_f_of_type_Int);
        a(((GdtMvAniData585V)localObject).jdField_c_of_type_AndroidViewView, ((GdtMvAniData585V)localObject).jdField_c_of_type_Int, ((GdtMvAniData585V)localObject).jdField_d_of_type_Int);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
      a(((GdtMvAniData585V)localObject).jdField_f_of_type_AndroidViewView, -((GdtMvAniData585V)localObject).j, -((GdtMvAniData585V)localObject).k);
      a(((GdtMvAniData585V)localObject).jdField_e_of_type_AndroidViewView, -((GdtMvAniData585V)localObject).jdField_g_of_type_Int, -((GdtMvAniData585V)localObject).h);
      a(((GdtMvAniData585V)localObject).jdField_b_of_type_AndroidViewView, -((GdtMvAniData585V)localObject).jdField_a_of_type_Int, -((GdtMvAniData585V)localObject).jdField_b_of_type_Int);
      a(((GdtMvAniData585V)localObject).jdField_d_of_type_AndroidViewView, -((GdtMvAniData585V)localObject).jdField_e_of_type_Int, -((GdtMvAniData585V)localObject).jdField_f_of_type_Int);
      a(((GdtMvAniData585V)localObject).jdField_c_of_type_AndroidViewView, -((GdtMvAniData585V)localObject).jdField_c_of_type_Int, -((GdtMvAniData585V)localObject).jdField_d_of_type_Int);
    }
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    GdtMvAniData585V localGdtMvAniData585V = new GdtMvAniData585V();
    localGdtMvAniData585V.jdField_a_of_type_AndroidViewView = paramView1;
    localGdtMvAniData585V.jdField_f_of_type_AndroidViewView = paramView3;
    localGdtMvAniData585V.jdField_g_of_type_AndroidViewView = paramView2;
    localGdtMvAniData585V.j = GdtUIUtils.a(-406, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.k = GdtUIUtils.a(125, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    float f = GdtUIUtils.a(220, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localGdtMvAniData585V.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localGdtMvAniData585V.jdField_b_of_type_Float = localGdtMvAniData585V.jdField_a_of_type_Float;
    }
    localGdtMvAniData585V.l = GdtUIUtils.a(50, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.m = GdtUIUtils.a(50, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_b_of_type_AndroidViewView = paramView4;
    localGdtMvAniData585V.jdField_c_of_type_AndroidViewView = paramView5;
    localGdtMvAniData585V.jdField_d_of_type_AndroidViewView = paramView6;
    localGdtMvAniData585V.jdField_e_of_type_AndroidViewView = paramView7;
    localGdtMvAniData585V.jdField_a_of_type_Int = GdtUIUtils.a(-618, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_b_of_type_Int = GdtUIUtils.a(275, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_c_of_type_Int = GdtUIUtils.a(-457, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_d_of_type_Int = ((GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - GdtUIUtils.a(196, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    localGdtMvAniData585V.jdField_e_of_type_Int = GdtUIUtils.a(-451, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.jdField_f_of_type_Int = ((GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - GdtUIUtils.a(196, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    localGdtMvAniData585V.jdField_g_of_type_Int = GdtUIUtils.a(-440, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData585V.h = ((GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - GdtUIUtils.a(196, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localGdtMvAniData585V, paramView8);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAniDataAbs = localGdtMvAniData585V;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAnimation585V
 * JD-Core Version:    0.7.0.1
 */