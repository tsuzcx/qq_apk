package com.tencent.aelight.camera.aioeditor.share.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Collections;

class AIOShareHelperImpl$3
  implements Runnable
{
  AIOShareHelperImpl$3(AIOShareHelperImpl paramAIOShareHelperImpl, AIOShareObject paramAIOShareObject, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject;
    if (this.a.g())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("images", new ArrayList(Collections.singletonList(this.a.b())));
      QZoneShareManager.publishToQzone(AECaptureContext.a(), this.b, (Bundle)localObject, null, this.a.a());
      return;
    }
    if (this.a.h())
    {
      localObject = QZoneHelper.UserInfo.getInstance();
      QZoneHelper.forwardToPublishMood(this.b, (QZoneHelper.UserInfo)localObject, this.a.b(), this.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */