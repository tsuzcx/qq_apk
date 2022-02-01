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
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("images", new ArrayList(Collections.singletonList(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a())));
      QZoneShareManager.publishToQzone(AECaptureContext.a(), this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject, null, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a());
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.b())
    {
      localObject = QZoneHelper.UserInfo.getInstance();
      QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_AndroidAppActivity, (QZoneHelper.UserInfo)localObject, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */