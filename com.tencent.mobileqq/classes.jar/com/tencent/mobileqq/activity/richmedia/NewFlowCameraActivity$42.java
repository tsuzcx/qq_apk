package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.widget.CircleProgress;
import java.util.concurrent.atomic.AtomicInteger;

class NewFlowCameraActivity$42
  implements Runnable
{
  NewFlowCameraActivity$42(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 3) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4))
    {
      if (this.this$0.k) {
        if (this.this$0.f >= 60000)
        {
          i = 10000;
          if (!this.this$0.D) {
            break label142;
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(i * 1.0F / (this.this$0.p * 10));
        }
      }
      for (;;)
      {
        if (this.a) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(100.0F);
        }
        return;
        i = this.this$0.f % 10000;
        break;
        i = this.this$0.f;
        break;
        label142:
        if (!NewFlowCameraActivity.k(this.this$0)) {
          break label181;
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(i * 1.0F / (NewFlowCameraActivity.d(this.this$0) * 10));
      }
      label181:
      CircleProgress localCircleProgress = this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
      float f = i;
      if (this.this$0.i) {}
      for (int i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c() + 1;; i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c())
      {
        localCircleProgress.setProgress(1.0F * f / i);
        break;
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.42
 * JD-Core Version:    0.7.0.1
 */