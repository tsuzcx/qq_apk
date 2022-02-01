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
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private AEEditorPanelDialogDelegate.DialogListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate$DialogListener;
  private boolean jdField_a_of_type_Boolean;
  
  public AEEditorPanelDialogDelegate(Dialog paramDialog, View paramView, AEEditorPanelDialogDelegate.DialogListener paramDialogListener)
  {
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate$DialogListener = paramDialogListener;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if (localObject == null) {
      return;
    }
    if (((Dialog)localObject).getWindow() != null) {
      localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((WindowManager.LayoutParams)localObject).gravity = 81;
      ((WindowManager.LayoutParams)localObject).height = -1;
      ((WindowManager.LayoutParams)localObject).width = -1;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    }
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate$DialogListener;
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
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
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
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorPanelDialogDelegate
 * JD-Core Version:    0.7.0.1
 */