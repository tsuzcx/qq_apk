package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

class DoodleColorAndModeView$ColorVH$1
  implements View.OnClickListener
{
  DoodleColorAndModeView$ColorVH$1(DoodleColorAndModeView.ColorVH paramColorVH, DoodleColorAndModeView paramDoodleColorAndModeView) {}
  
  public void onClick(View paramView)
  {
    if (DoodleColorAndModeView.h(this.b.a))
    {
      AEQLog.a("DoodleColorAndModeView", "click color item, but now is disable");
      return;
    }
    int i = this.b.getAdapterPosition();
    paramView = this.b.a;
    boolean bool;
    if (i >= DoodleColorAndModeView.d(this.b.a)) {
      bool = true;
    } else {
      bool = false;
    }
    DoodleColorAndModeView.a(paramView, bool);
    if (i < DoodleColorAndModeView.d(this.b.a))
    {
      if (DoodleColorAndModeView.c(this.b.a) != null) {
        DoodleColorAndModeView.c(this.b.a).a(0, 0);
      }
    }
    else
    {
      i = ((Integer)DoodleColorAndModeView.f(this.b.a).get(i - DoodleColorAndModeView.d(this.b.a))).intValue();
      if (DoodleColorAndModeView.c(this.b.a) != null) {
        DoodleColorAndModeView.c(this.b.a).a(1, i);
      }
      DoodleColorAndModeView.a(this.b.a, i);
    }
    DoodleColorAndModeView.i(this.b.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.ColorVH.1
 * JD-Core Version:    0.7.0.1
 */