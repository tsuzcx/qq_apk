package com.tencent.aelight.camera.ae.flashshow;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class AEFlashShowCameraLauncher$1
  implements Runnable
{
  AEFlashShowCameraLauncher$1(AEFlashShowCameraLauncher paramAEFlashShowCameraLauncher, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      boolean bool = AEFlashShowCameraLauncher.a(this.this$0, (QQAppInterface)localObject, BaseApplicationImpl.getContext());
      SLog.a("AEFlashShowCameraLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(this.a), Boolean.valueOf(bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraLauncher.1
 * JD-Core Version:    0.7.0.1
 */