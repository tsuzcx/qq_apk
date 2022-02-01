package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  protected int doStep()
  {
    QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.e();
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).c();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */