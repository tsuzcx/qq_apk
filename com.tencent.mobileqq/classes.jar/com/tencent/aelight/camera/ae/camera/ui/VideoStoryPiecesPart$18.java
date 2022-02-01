package com.tencent.aelight.camera.ae.camera.ui;

import android.animation.Animator;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class VideoStoryPiecesPart$18
  extends D8SafeAnimatorListener
{
  VideoStoryPiecesPart$18(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (VideoStoryPiecesPart.a(this.a) != null)
    {
      VideoStoryPiecesPart.a(this.a).setAlpha(1.0F);
      VideoStoryPiecesPart.a(this.a).setVisibility(4);
      VideoStoryPiecesPart.a(this.a).b().postValue(Boolean.valueOf(false));
    }
    VideoStoryPiecesPart.f(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.18
 * JD-Core Version:    0.7.0.1
 */