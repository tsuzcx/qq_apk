package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.IColorSelectListener;

class DoodlePanel$1
  implements DoodleColorAndModeView.IColorSelectListener
{
  DoodlePanel$1(DoodlePanel paramDoodlePanel) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (DoodlePanel.a(this.a) != null)
    {
      if (paramInt1 == 0)
      {
        DoodlePanel.a(this.a).a(DoodlePanel.PenMode.MOSAIC);
        return;
      }
      if (paramInt1 == 1) {
        DoodlePanel.a(this.a).a(paramInt2);
      }
    }
  }
  
  public void a(DoodlePanel.PenMode paramPenMode)
  {
    if (DoodlePanel.a(this.a) != null) {
      DoodlePanel.a(this.a).a(paramPenMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.1
 * JD-Core Version:    0.7.0.1
 */