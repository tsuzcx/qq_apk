package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class CaptureComboNormalPaster$1
  implements Runnable
{
  CaptureComboNormalPaster$1(CaptureComboNormalPaster paramCaptureComboNormalPaster, int paramInt) {}
  
  public void run()
  {
    DoodleLayout localDoodleLayout = DoodleLayoutConnector.a().a(this.a);
    if (localDoodleLayout != null) {
      CaptureComboNormalPaster.a(this.this$0.a, CaptureComboNormalPaster.a(this.this$0), ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, CaptureComboNormalPaster.a(this.this$0), CaptureComboNormalPaster.b(this.this$0), CaptureComboNormalPaster.c(this.this$0), CaptureComboNormalPaster.a(this.this$0), localDoodleLayout.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboNormalPaster.1
 * JD-Core Version:    0.7.0.1
 */