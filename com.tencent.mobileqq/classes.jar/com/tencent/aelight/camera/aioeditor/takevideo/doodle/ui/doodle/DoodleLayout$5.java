package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.DoodlePanelListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.PenMode;

class DoodleLayout$5
  implements DoodlePanel.DoodlePanelListener
{
  DoodleLayout$5(DoodleLayout paramDoodleLayout) {}
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    if (this.a.a() != null)
    {
      this.a.b(paramFloat);
      this.a.s();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.a() != null)
    {
      this.a.b(paramInt);
      this.a.s();
    }
  }
  
  public void a(DoodlePanel.PenMode paramPenMode)
  {
    DoodleLayout.b(this.a, paramPenMode);
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.5
 * JD-Core Version:    0.7.0.1
 */