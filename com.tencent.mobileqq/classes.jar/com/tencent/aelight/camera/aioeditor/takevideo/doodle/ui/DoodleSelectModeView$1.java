package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.PenMode;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.FunHandler;
import com.tencent.aelight.camera.log.AEQLog;

class DoodleSelectModeView$1
  implements EditButtonManager.FunHandler
{
  DoodleSelectModeView$1(DoodleSelectModeView paramDoodleSelectModeView) {}
  
  public void a(View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditButtonManager--handleFun--index=");
    localStringBuilder.append(paramInt);
    AEQLog.b("DoodleSelectModeView", localStringBuilder.toString());
    if (DoodleSelectModeView.a(this.a) != null)
    {
      localStringBuilder = null;
      switch (paramView.getId())
      {
      default: 
        paramView = localStringBuilder;
        break;
      case 2131364071: 
        paramView = DoodlePanel.PenMode.RECT;
        break;
      case 2131364044: 
        paramView = DoodlePanel.PenMode.ERASER;
        break;
      case 2131363997: 
        paramView = DoodlePanel.PenMode.FREE_DRAW;
        break;
      case 2131363968: 
        paramView = DoodlePanel.PenMode.LINE;
        break;
      case 2131363879: 
        paramView = DoodlePanel.PenMode.OVAL;
        break;
      case 2131363857: 
        paramView = DoodlePanel.PenMode.ARROW;
      }
      if (paramView != null) {
        DoodleSelectModeView.a(this.a).a(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView.1
 * JD-Core Version:    0.7.0.1
 */