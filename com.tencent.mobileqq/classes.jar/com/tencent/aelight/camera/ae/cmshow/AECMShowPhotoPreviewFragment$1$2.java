package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;

class AECMShowPhotoPreviewFragment$1$2
  implements Runnable
{
  AECMShowPhotoPreviewFragment$1$2(AECMShowPhotoPreviewFragment.1 param1, int paramInt, CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    if ((this.a == 1) && (this.b != null))
    {
      if (!AECMShowPhotoPreviewFragment.b(this.c.a))
      {
        AECMShowPhotoPreviewFragment.a(this.c.a.getBaseActivity(), this.b);
        return;
      }
      AECMShowPhotoPreviewFragment.a(this.c.a, this.b);
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.c.a, 2);
    AECMShowPhotoPreviewFragment.a(this.c.a, System.currentTimeMillis());
    AEBaseDataReporter.a().e(1);
    if (this.a == 4)
    {
      AECMShowPhotoPreviewFragment.a(this.c.a).a(2, this.c.a.getString(2064187407));
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.c.a).a(2, this.c.a.getString(2064187653));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment.1.2
 * JD-Core Version:    0.7.0.1
 */