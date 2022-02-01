package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import java.lang.ref.WeakReference;

class CaptureComboInformationPaster$DownloadProgressCallback
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  private float a;
  private WeakReference<CaptureComboInformationPaster> b;
  
  public CaptureComboInformationPaster$DownloadProgressCallback(CaptureComboInformationPaster paramCaptureComboInformationPaster)
  {
    this.b = new WeakReference(paramCaptureComboInformationPaster);
  }
  
  public float a()
  {
    return this.a;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.a = paramFloat;
  }
  
  public void a(boolean paramBoolean, String paramString, InformationFacePackage.Item paramItem)
  {
    if (paramBoolean)
    {
      this.a = 1.0F;
      if (this.b.get() != null) {
        ((CaptureComboInformationPaster)this.b.get()).b();
      }
    }
    else
    {
      this.a = 0.0F;
      if (this.b.get() != null) {
        ((CaptureComboInformationPaster)this.b.get()).a(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboInformationPaster.DownloadProgressCallback
 * JD-Core Version:    0.7.0.1
 */