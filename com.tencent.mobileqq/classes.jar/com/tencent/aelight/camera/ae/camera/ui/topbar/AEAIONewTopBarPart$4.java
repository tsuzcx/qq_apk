package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.log.AEQLog;

class AEAIONewTopBarPart$4
  implements Observer<Boolean>
{
  AEAIONewTopBarPart$4(AEAIONewTopBarPart paramAEAIONewTopBarPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【抠背开关】-> observe ->更新按钮状态:");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEVideoStoryTopBarPart", localStringBuilder.toString());
    if (paramBoolean == null) {
      return;
    }
    AEAIONewTopBarPart.e(this.a).setSelected(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart.4
 * JD-Core Version:    0.7.0.1
 */