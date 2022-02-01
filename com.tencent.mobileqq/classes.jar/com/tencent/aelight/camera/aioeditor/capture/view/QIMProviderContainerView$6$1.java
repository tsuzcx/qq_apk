package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.res.Resources;
import com.tencent.mobileqq.troop.widget.RedDotImageView;

class QIMProviderContainerView$6$1
  implements Runnable
{
  QIMProviderContainerView$6$1(QIMProviderContainerView.6 param6, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a) && (!this.b.a.a()))
    {
      this.b.a.setReddotXOffsetDp(12);
      this.b.a.setReddotYOffsetDp(11);
      this.b.a.setRedDotDrawable(this.b.a.getResources().getDrawable(2130852589));
      this.b.a.a(true);
      return;
    }
    if ((!this.a) && (this.b.a.a())) {
      this.b.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.6.1
 * JD-Core Version:    0.7.0.1
 */