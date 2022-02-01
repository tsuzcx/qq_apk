package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QQNotifyLoadingDialog
  extends ReportDialog
{
  Context jdField_a_of_type_AndroidContentContext = null;
  Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable = null;
  
  public QQNotifyLoadingDialog(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    super.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setContentView(LayoutInflater.from(paramContext).inflate(2131560915, null));
    paramContext = getWindow();
    if (paramContext != null)
    {
      paramContext.setLayout(-1, -1);
      paramContext.setBackgroundDrawable(new ColorDrawable(0));
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramContext.addFlags(67108864);
      }
    }
    setCanceledOnTouchOutside(false);
    paramContext = (ImageView)super.findViewById(2131373723);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -1.0F, 2, 1.0F, 1, 0.0F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setDuration(800L);
    localTranslateAnimation.setRepeatCount(-1);
    paramContext.startAnimation(localTranslateAnimation);
    super.setCancelable(false);
  }
  
  public void dismiss()
  {
    super.dismiss();
    Animatable localAnimatable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      try
      {
        dismiss();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
        }
      }
      catch (Exception paramKeyEvent)
      {
        if (QLog.isDevelopLevel()) {
          paramKeyEvent.printStackTrace();
        }
      }
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)((Context)localObject).getResources().getDrawable(2130839406));
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
      if (localObject != null) {
        ((Animatable)localObject).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyLoadingDialog
 * JD-Core Version:    0.7.0.1
 */