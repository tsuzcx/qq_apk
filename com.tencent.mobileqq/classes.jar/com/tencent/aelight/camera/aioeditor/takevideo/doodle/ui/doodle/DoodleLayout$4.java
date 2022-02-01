package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.DoodlePanelListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.PenMode;
import com.tencent.aelight.camera.log.AEQLog;

class DoodleLayout$4
  implements DoodlePanel.DoodlePanelListener
{
  DoodleLayout$4(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.e();
  }
  
  public void a(float paramFloat)
  {
    if (this.a.a() != null)
    {
      this.a.a(paramFloat);
      this.a.s();
    }
  }
  
  public void a(int paramInt)
  {
    LineLayer localLineLayer = this.a.a();
    if (localLineLayer != null)
    {
      this.a.a(paramInt);
      this.a.s();
      if (localLineLayer.e())
      {
        AEQLog.b("DoodleLayout", "onSelectColor when in mosaic mode, change to the before mode: ");
        DoodleLayout.a(this.a, DoodlePanel.PenMode.FREE_DRAW);
      }
    }
  }
  
  public void a(DoodlePanel.PenMode paramPenMode)
  {
    DoodleLayout.a(this.a, paramPenMode);
  }
  
  public void b()
  {
    DoodleLayout.a(this.a, 0);
    if (!this.a.a.b()) {
      this.a.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.4
 * JD-Core Version:    0.7.0.1
 */