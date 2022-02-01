package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.PenMode;

class DoodleColorAndModeView$ColorListAdapter$1
  implements DoodleSelectModeView.ISelectModeListener
{
  DoodleColorAndModeView$ColorListAdapter$1(DoodleColorAndModeView.ColorListAdapter paramColorListAdapter) {}
  
  public void a(DoodlePanel.PenMode paramPenMode)
  {
    DoodleColorAndModeView localDoodleColorAndModeView = this.a.a;
    boolean bool;
    if (paramPenMode != DoodlePanel.PenMode.ERASER) {
      bool = true;
    } else {
      bool = false;
    }
    localDoodleColorAndModeView.a(bool);
    if (DoodleColorAndModeView.a(this.a.a) != null) {
      DoodleColorAndModeView.a(this.a.a).a(paramPenMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.ColorListAdapter.1
 * JD-Core Version:    0.7.0.1
 */