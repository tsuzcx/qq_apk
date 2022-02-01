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

class AECMShowCameraUnit$7$1
  extends D8SafeAnimatorListener
{
  AECMShowCameraUnit$7$1(AECMShowCameraUnit.7 param7) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowCameraUnit.d(this.a.this$0).setAlpha(1.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowCameraUnit.d(this.a.this$0).setTag(Integer.valueOf(2));
    AECMShowCameraUnit.d(this.a.this$0).setClickable(true);
    AEQLog.a(this.a.this$0.a, "MakeFaceFail -> animationStart: 设置为蓝色背景");
    AECMShowCameraUnit.d(this.a.this$0).setBackgroundDrawable(this.a.this$0.s().getResources().getDrawable(2063925267));
    AECMShowCameraUnit.d(this.a.this$0).setTextColor(-1);
    AECMShowCameraUnit.d(this.a.this$0).setText(2064187649);
    AECMShowCameraUnit.d(this.a.this$0).setVisibility(0);
    AECMShowCameraUnit.d(this.a.this$0).setAlpha(0.0F);
    if (this.a.a == 4) {
      AECMShowCameraUnit.j(this.a.this$0).a(2, this.a.this$0.s().getResources().getString(2064187407));
    } else {
      AECMShowCameraUnit.j(this.a.this$0).a(2, this.a.this$0.s().getResources().getString(2064187653));
    }
    AECMShowCameraUnit.g(this.a.this$0).setVisibility(8);
    AECMShowCameraUnit.h(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.7.1
 * JD-Core Version:    0.7.0.1
 */