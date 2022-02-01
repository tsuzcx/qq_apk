package com.tencent.gdtad.api.motivevideo;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;

class GdtMVCellingStyleController$1
  implements ValueAnimator.AnimatorUpdateListener
{
  GdtMVCellingStyleController$1(GdtMVCellingStyleController paramGdtMVCellingStyleController, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    int i = this.jdField_a_of_type_Int;
    paramValueAnimator.topMargin = ((int)(f * this.b) + i);
    if (((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin <= GdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController)) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin >= GdtMVCellingStyleController.b(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController))) && (GdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController).a))
    {
      GdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController);
      return;
    }
    GdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController.a((this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin - GdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController)) * 1.0F / (GdtMVCellingStyleController.b(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController) - GdtMVCellingStyleController.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMVCellingStyleController)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMVCellingStyleController.1
 * JD-Core Version:    0.7.0.1
 */