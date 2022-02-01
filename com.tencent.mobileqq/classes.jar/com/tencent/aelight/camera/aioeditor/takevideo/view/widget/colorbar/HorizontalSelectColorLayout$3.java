package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar;

import android.view.View;
import android.view.View.OnClickListener;

class HorizontalSelectColorLayout$3
  implements View.OnClickListener
{
  HorizontalSelectColorLayout$3(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {
      return;
    }
    if (this.a.i != null) {
      this.a.i.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.3
 * JD-Core Version:    0.7.0.1
 */