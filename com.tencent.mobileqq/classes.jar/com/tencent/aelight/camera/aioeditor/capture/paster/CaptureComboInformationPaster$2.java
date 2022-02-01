package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class CaptureComboInformationPaster$2
  implements URLDrawable.URLDrawableListener
{
  CaptureComboInformationPaster$2(CaptureComboInformationPaster paramCaptureComboInformationPaster, String paramString, URLDrawable paramURLDrawable, IFaceSelectedListener paramIFaceSelectedListener) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    CaptureComboInformationPaster.h.remove(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureComboInformationPaster", 2, "applyApngInfoPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    CaptureComboInformationPaster.h.remove(this.a);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    CaptureComboInformationPaster.a(this.d, this.b, this.a, 1, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboInformationPaster.2
 * JD-Core Version:    0.7.0.1
 */