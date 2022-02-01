package com.tencent.aelight.camera.aioeditor.capture.view;

import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QIMProviderContainerView$6
  implements Runnable
{
  public void run()
  {
    int j = this.this$0.a.getChildCount();
    VideoFilterTools.a();
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (QIMProviderContainerView.a(this.this$0).a(i))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    ThreadManager.getUIHandler().post(new QIMProviderContainerView.6.1(this, bool1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.6
 * JD-Core Version:    0.7.0.1
 */