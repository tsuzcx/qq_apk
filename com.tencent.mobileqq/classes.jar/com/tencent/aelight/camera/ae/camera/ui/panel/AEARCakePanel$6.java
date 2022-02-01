package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

class AEARCakePanel$6
  implements Runnable
{
  AEARCakePanel$6(AEARCakePanel paramAEARCakePanel, List paramList) {}
  
  public void run()
  {
    if (AEARCakePanel.a(this.this$0) != null) {
      AEARCakePanel.a(this.this$0).a(327699, new Object[] { Boolean.valueOf(AEARCakePanel.a(this.this$0)) });
    }
    if (this.this$0.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake : select positon :");
      localStringBuilder.append(AEARCakeMaterialManager.a().a());
      AEQLog.a("AEARCakePanel", localStringBuilder.toString());
      this.this$0.a.a(this.a, AEARCakeMaterialManager.a().a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.6
 * JD-Core Version:    0.7.0.1
 */