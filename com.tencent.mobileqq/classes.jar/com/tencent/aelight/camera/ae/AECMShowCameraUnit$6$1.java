package com.tencent.aelight.camera.ae;

import android.animation.Animator;
import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AECMShowCameraUnit$6$1
  extends D8SafeAnimatorListener
{
  AECMShowCameraUnit$6$1(AECMShowCameraUnit.6 param6) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowCameraUnit.d(this.a.this$0).setAlpha(1.0F);
    AECMShowCameraUnit.h(this.a.this$0).setAlpha(255);
    AECMShowCameraUnit.j(this.a.this$0).setVisibility(8);
    AEQLog.a(this.a.this$0.a, "MakeFaceSucc -> onAnimationEnd: 设置为蓝色背景");
    AECMShowCameraUnit.d(this.a.this$0).setBackgroundDrawable(this.a.this$0.s().getResources().getDrawable(2063925267));
    AECMShowCameraUnit.d(this.a.this$0).setTextColor(-1);
    AECMShowCameraUnit.d(this.a.this$0).setText(2064187647);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowCameraUnit.g(this.a.this$0).setVisibility(8);
    AECMShowCameraUnit.d(this.a.this$0).setAlpha(0.0F);
    AECMShowCameraUnit.d(this.a.this$0).setTag(Integer.valueOf(1));
    AECMShowCameraUnit.d(this.a.this$0).setClickable(true);
    AEQLog.a(this.a.this$0.a, "MakeFaceSucc -> onAnimationStart: 设置为蓝色背景");
    AECMShowCameraUnit.d(this.a.this$0).setBackgroundDrawable(this.a.this$0.s().getResources().getDrawable(2063925267));
    AECMShowCameraUnit.d(this.a.this$0).setTextColor(-1);
    AECMShowCameraUnit.d(this.a.this$0).setText(2064187647);
    AECMShowCameraUnit.d(this.a.this$0).setVisibility(0);
    AECMShowCameraUnit.h(this.a.this$0).setImageDrawable(this.a.this$0.s().getResources().getDrawable(2063925302));
    AECMShowCameraUnit.h(this.a.this$0).setTag(Integer.valueOf(4));
    AECMShowCameraUnit.h(this.a.this$0).setAlpha(0);
    AECMShowCameraUnit.h(this.a.this$0).setVisibility(0);
    AECMShowCameraUnit.h(this.a.this$0).setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.6.1
 * JD-Core Version:    0.7.0.1
 */