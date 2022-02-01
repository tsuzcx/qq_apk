package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;

class VideoStoryAIScenePart$18
  implements Runnable
{
  VideoStoryAIScenePart$18(VideoStoryAIScenePart paramVideoStoryAIScenePart, AEMaterialPanel paramAEMaterialPanel, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.getHeight();
    int j = this.jdField_a_of_type_Int;
    int k = VideoStoryAIScenePart.a(this.this$0).getMeasuredHeight();
    Object localObject = new int[2];
    VideoStoryAIScenePart.a(this.this$0).getLocationInWindow((int[])localObject);
    int m = localObject[1];
    localObject = VideoStoryAIScenePart.a(this.this$0);
    float f = j - i - k - 10 - m;
    localObject = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, f });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.b(this.this$0), "translationY", new float[] { 0.0F, f });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.b(this.this$0), "translationY", new float[] { 0.0F, f });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.18
 * JD-Core Version:    0.7.0.1
 */