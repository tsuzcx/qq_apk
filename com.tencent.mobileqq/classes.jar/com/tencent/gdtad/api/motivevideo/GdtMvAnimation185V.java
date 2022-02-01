package com.tencent.gdtad.api.motivevideo;

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
    GdtLog.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs + " targetMode " + paramInt);
    GdtMvAniData185V localGdtMvAniData185V;
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs != null)
    {
      localGdtMvAniData185V = (GdtMvAniData185V)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs;
      a();
      if (paramInt == 1)
      {
        a(localGdtMvAniData185V.jdField_a_of_type_AndroidViewView, localGdtMvAniData185V.jdField_a_of_type_Int, 0);
        a(localGdtMvAniData185V.f, localGdtMvAniData185V.j, localGdtMvAniData185V.k);
      }
    }
    else
    {
      return;
    }
    a(localGdtMvAniData185V.jdField_a_of_type_AndroidViewView, -localGdtMvAniData185V.jdField_a_of_type_Int, 0);
    a(localGdtMvAniData185V.f, -localGdtMvAniData185V.j, -localGdtMvAniData185V.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    GdtMvAniData185V localGdtMvAniData185V = new GdtMvAniData185V();
    localGdtMvAniData185V.jdField_a_of_type_AndroidViewView = paramView1;
    localGdtMvAniData185V.f = paramView2;
    localGdtMvAniData185V.g = paramView3;
    localGdtMvAniData185V.jdField_a_of_type_Int = GdtUIUtils.a(-306, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185V.j = GdtUIUtils.a(-406, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185V.k = GdtUIUtils.a(125, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    float f = GdtUIUtils.a(400, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localGdtMvAniData185V.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localGdtMvAniData185V.b = localGdtMvAniData185V.jdField_a_of_type_Float;
    }
    localGdtMvAniData185V.l = GdtUIUtils.a(50, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localGdtMvAniData185V.m = GdtUIUtils.a(-100, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    a(localGdtMvAniData185V, paramView4);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAniDataAbs = localGdtMvAniData185V;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvAnimation185V
 * JD-Core Version:    0.7.0.1
 */