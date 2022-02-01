package com.tencent.biz;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.widget.QQMapView;

class PoiMapActivity$3
  implements Animation.AnimationListener
{
  PoiMapActivity$3(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, int paramInt, TranslateAnimation paramTranslateAnimation2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).getLayoutParams();
    int i;
    int j;
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      i = this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHeight();
      j = this.jdField_a_of_type_Int;
      localLayoutParams.height = (i + j);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(j / 2, true);
    }
    else if (paramAnimation == this.b)
    {
      i = this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHeight();
      j = this.jdField_a_of_type_Int;
      localLayoutParams.height = (i - j);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(-j / 2, true);
    }
    localLayoutParams1.height = -1;
    localLayoutParams2.height = -1;
    PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setLayoutParams(localLayoutParams2);
    PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setLayoutParams(localLayoutParams1);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.setLayoutParams(localLayoutParams);
    PoiMapActivity.c(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setEnabled(true);
    if ((this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) && (paramAnimation == this.b)) {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.e();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.3
 * JD-Core Version:    0.7.0.1
 */