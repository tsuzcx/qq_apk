package com.tencent.biz.videostory.capture.widgets;

import android.view.View;

public class ScaleTransformer
  implements VideoStoryScrollItemTransformer
{
  private float jdField_a_of_type_Float = 0.8F;
  private Pivot jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsPivot = Pivot.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private Pivot jdField_b_of_type_ComTencentBizVideostoryCaptureWidgetsPivot = Pivot.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsPivot.a(paramView);
    this.jdField_b_of_type_ComTencentBizVideostoryCaptureWidgetsPivot.a(paramView);
    paramFloat = Math.abs(paramFloat);
    paramFloat = this.jdField_a_of_type_Float + this.jdField_b_of_type_Float * (1.0F - paramFloat);
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.ScaleTransformer
 * JD-Core Version:    0.7.0.1
 */