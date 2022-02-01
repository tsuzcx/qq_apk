package com.tencent.aelight.camera.ae.cmshow;

import android.support.annotation.Nullable;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AECMShowPhotoPreviewFragment$1
  implements AECMShowRequestController.Callback
{
  AECMShowPhotoPreviewFragment$1(AECMShowPhotoPreviewFragment paramAECMShowPhotoPreviewFragment) {}
  
  public void a(int paramInt, @Nullable CmShowDataWrapper paramCmShowDataWrapper)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AECMShowRequestController.onComplete], resultCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", dataWrapper=");
    localStringBuilder.append(paramCmShowDataWrapper);
    AEQLog.a("AECMShowPhotoPreviewFragment", localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AECMShowPhotoPreviewFragment.1.2(this, paramInt, paramCmShowDataWrapper));
  }
  
  public void d(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AECMShowPhotoPreviewFragment.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */