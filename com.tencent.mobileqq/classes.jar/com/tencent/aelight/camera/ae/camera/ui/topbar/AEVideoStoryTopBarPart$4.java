package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.log.AEQLog;

class AEVideoStoryTopBarPart$4
  implements Observer<Boolean>
{
  AEVideoStoryTopBarPart$4(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【抠背开关】-> observe ->更新按钮状态:");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEVideoStoryTopBarPart", localStringBuilder.toString());
    if (paramBoolean == null) {
      return;
    }
    AEVideoStoryTopBarPart.j(this.a).setSelected(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.4
 * JD-Core Version:    0.7.0.1
 */