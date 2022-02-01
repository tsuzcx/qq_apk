package com.tencent.aelight.camera.aeeditor.module.music;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AEEditorPanelDialogDelegate$1
  implements Animation.AnimationListener
{
  AEEditorPanelDialogDelegate$1(AEEditorPanelDialogDelegate paramAEEditorPanelDialogDelegate) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEEditorPanelDialogDelegate.a(this.a, false);
    AEEditorPanelDialogDelegate.b(this.a).post(new AEEditorPanelDialogDelegate.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEEditorPanelDialogDelegate.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorPanelDialogDelegate.1
 * JD-Core Version:    0.7.0.1
 */