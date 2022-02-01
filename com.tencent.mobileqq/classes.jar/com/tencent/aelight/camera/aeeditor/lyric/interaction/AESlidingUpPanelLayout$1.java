package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.view.View;
import android.view.View.OnClickListener;

class AESlidingUpPanelLayout$1
  implements View.OnClickListener
{
  AESlidingUpPanelLayout$1(AESlidingUpPanelLayout paramAESlidingUpPanelLayout) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isEnabled())
    {
      if (!this.a.a()) {
        return;
      }
      if ((AESlidingUpPanelLayout.a(this.a) != AESlidingUpPanelLayout.PanelState.EXPANDED) && (AESlidingUpPanelLayout.a(this.a) != AESlidingUpPanelLayout.PanelState.ANCHORED))
      {
        if (AESlidingUpPanelLayout.a(this.a) < 1.0F)
        {
          this.a.setPanelState(AESlidingUpPanelLayout.PanelState.ANCHORED);
          return;
        }
        this.a.setPanelState(AESlidingUpPanelLayout.PanelState.EXPANDED);
        return;
      }
      this.a.setPanelState(AESlidingUpPanelLayout.PanelState.COLLAPSED);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.AESlidingUpPanelLayout.1
 * JD-Core Version:    0.7.0.1
 */