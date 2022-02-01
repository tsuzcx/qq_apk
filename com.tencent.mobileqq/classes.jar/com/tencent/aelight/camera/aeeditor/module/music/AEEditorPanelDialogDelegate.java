package com.tencent.aelight.camera.aeeditor.module.music;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class AEEditorPanelDialogDelegate
{
  private Dialog a;
  private View b;
  private AEEditorPanelDialogDelegate.DialogListener c;
  private boolean d;
  
  public AEEditorPanelDialogDelegate(Dialog paramDialog, View paramView, AEEditorPanelDialogDelegate.DialogListener paramDialogListener)
  {
    this.a = paramDialog;
    this.b = paramView;
    this.c = paramDialogListener;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((Dialog)localObject).getWindow() != null) {
      localObject = this.a.getWindow().getAttributes();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((WindowManager.LayoutParams)localObject).gravity = 81;
      ((WindowManager.LayoutParams)localObject).height = -1;
      ((WindowManager.LayoutParams)localObject).width = -1;
      this.a.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    this.a.setCancelable(false);
    this.a.setCanceledOnTouchOutside(false);
  }
  
  public void b()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      Object localObject = this.c;
      if (localObject != null) {
        ((AEEditorPanelDialogDelegate.DialogListener)localObject).a();
      }
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setDuration(200L);
      localAnimationSet.setFillAfter(true);
      this.b.startAnimation(localAnimationSet);
    }
  }
  
  public void c()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      if (this.d) {
        return;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation(localTranslateAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setDuration(200L);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setAnimationListener(new AEEditorPanelDialogDelegate.1(this));
      this.b.startAnimation(localAnimationSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorPanelDialogDelegate
 * JD-Core Version:    0.7.0.1
 */