package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import java.util.concurrent.atomic.AtomicBoolean;

class VideoStoryAIScenePart$7
  implements Animation.AnimationListener
{
  VideoStoryAIScenePart$7(VideoStoryAIScenePart paramVideoStoryAIScenePart, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoStoryAIScenePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart, false);
    VideoStoryAIScenePart.b(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart).setVisibility(8);
    VideoStoryAIScenePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!VideoStoryAIScenePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart).get()))
    {
      VideoStoryAIScenePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
    }
    VideoStoryAIScenePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart).a(851971, new Object[0]);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    VideoStoryAIScenePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.7
 * JD-Core Version:    0.7.0.1
 */