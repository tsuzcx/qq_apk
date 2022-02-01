package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.videostory.support.VSReporter;

class VideoStoryAIScenePart$1
  extends Handler
{
  VideoStoryAIScenePart$1(VideoStoryAIScenePart paramVideoStoryAIScenePart, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      VSReporter.a("mystatus_shoot", "exp_recomm", 0, 0, new String[0]);
      this.a.a();
      return;
    }
    VSReporter.a("mystatus_shoot", "comp_recomm", 0, 0, new String[0]);
    paramMessage = paramMessage.getData();
    i = paramMessage.getInt("sceneLvOne");
    paramMessage = paramMessage.getString("sceneName");
    this.a.a(i, paramMessage, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.1
 * JD-Core Version:    0.7.0.1
 */