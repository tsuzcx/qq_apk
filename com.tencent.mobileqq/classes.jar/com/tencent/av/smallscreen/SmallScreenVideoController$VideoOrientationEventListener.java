package com.tencent.av.smallscreen;

import android.content.Context;
import android.view.Display;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$VideoOrientationEventListener
  extends AbstractOrientationEventListener
{
  public SmallScreenVideoController$VideoOrientationEventListener(SmallScreenVideoController paramSmallScreenVideoController, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i;
    try
    {
      i = (this.a.jdField_a_of_type_AndroidViewDisplay.getRotation() * 90 + paramInt) % 360;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onVideoOrientationChanged e = ");
        localStringBuilder.append(localException);
        QLog.e("SmallScreenVideoController", 2, localStringBuilder.toString());
      }
      i = 0;
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c(i);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(paramInt, paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setRotation(paramInt);
    }
    this.a.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.VideoOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */