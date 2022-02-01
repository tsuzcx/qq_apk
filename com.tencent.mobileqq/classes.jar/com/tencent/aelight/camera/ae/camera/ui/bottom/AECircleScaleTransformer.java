package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.view.View;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.capture.widgets.Pivot;
import com.tencent.biz.videostory.capture.widgets.VideoStoryScrollItemTransformer;

public class AECircleScaleTransformer
  implements VideoStoryScrollItemTransformer
{
  private Pivot a = Pivot.a(1);
  private Pivot b = Pivot.b(1);
  private float c = 0.8F;
  private float d = 0.2F;
  
  public void a(View paramView, float paramFloat)
  {
    this.a.a(paramView);
    this.b.a(paramView);
    float f = Math.abs(paramFloat);
    f = this.c + this.d * (1.0F - f);
    paramView.setScaleX(f);
    paramView.setScaleY(f);
    Object localObject = paramView.findViewById(2063991592);
    View localView = paramView.findViewById(2063991606);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleScaleTransformer
 * JD-Core Version:    0.7.0.1
 */