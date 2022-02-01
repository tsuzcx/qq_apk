package com.tencent.gdtad.api.feedback;

import android.app.Dialog;
import android.view.Window;

class GdtFeedbackFragment$1
  implements Runnable
{
  GdtFeedbackFragment$1(GdtFeedbackFragment paramGdtFeedbackFragment) {}
  
  public void run()
  {
    if ((this.this$0.getDialog() != null) && (this.this$0.getDialog().getWindow() != null)) {
      this.this$0.getDialog().getWindow().setWindowAnimations(GdtFeedbackFragment.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackFragment.1
 * JD-Core Version:    0.7.0.1
 */