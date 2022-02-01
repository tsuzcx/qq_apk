package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EditProviderPart$3
  implements Runnable
{
  EditProviderPart$3(EditProviderPart paramEditProviderPart, List paramList) {}
  
  public void run()
  {
    if (EditProviderPart.g(this.this$0) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditProviderPart", 2, "EditVideoState is not idle");
      }
      return;
    }
    if ((this.this$0.u != null) && (EditProviderPart.h(this.this$0) != null))
    {
      this.this$0.t.d(18);
      EditProviderPart.h(this.this$0).setVisibility(0);
      EditProviderPart.h(this.this$0).getViewTreeObserver().addOnGlobalLayoutListener(new EditProviderPart.3.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "initTransitionRecommendView postDelayed null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.3
 * JD-Core Version:    0.7.0.1
 */