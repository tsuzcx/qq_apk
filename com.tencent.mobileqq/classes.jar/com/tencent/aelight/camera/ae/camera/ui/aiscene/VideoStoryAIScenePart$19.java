package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;

class VideoStoryAIScenePart$19
  implements Runnable
{
  VideoStoryAIScenePart$19(VideoStoryAIScenePart paramVideoStoryAIScenePart) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    VideoStoryAIScenePart.m(this.this$0).s().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.19
 * JD-Core Version:    0.7.0.1
 */