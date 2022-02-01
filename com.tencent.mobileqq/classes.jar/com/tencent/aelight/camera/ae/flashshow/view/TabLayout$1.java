package com.tencent.aelight.camera.ae.flashshow.view;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.aelight.camera.log.AEQLog;

class TabLayout$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TabLayout$1(TabLayout paramTabLayout) {}
  
  public void onGlobalLayout()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trigger on global layout, begin update animate dot to position: ");
    localStringBuilder.append(TabLayout.a(this.a));
    AEQLog.b("FS_TabLayout", localStringBuilder.toString());
    TabLayout.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.TabLayout.1
 * JD-Core Version:    0.7.0.1
 */