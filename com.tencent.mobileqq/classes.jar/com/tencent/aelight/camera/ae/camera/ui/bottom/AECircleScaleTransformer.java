package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.view.View;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.capture.widgets.Pivot;
import com.tencent.biz.videostory.capture.widgets.VideoStoryScrollItemTransformer;

public class AECircleScaleTransformer
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
    float f = Math.abs(paramFloat);
    f = this.jdField_a_of_type_Float + this.jdField_b_of_type_Float * (1.0F - f);
    paramView.setScaleX(f);
    paramView.setScaleY(f);
    Object localObject = paramView.findViewById(2064122818);
    View localView = paramView.findViewById(2064122832);
    if (localObject != null) {
      ((View)localObject).setAlpha(Math.abs(paramFloat));
    }
    if (localView != null) {
      localView.setAlpha(Math.abs(paramFloat));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("position: ");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(" view: ");
    ((StringBuilder)localObject).append(paramView.toString());
    AEQLog.a("AECircleScaleTransformer", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleScaleTransformer
 * JD-Core Version:    0.7.0.1
 */