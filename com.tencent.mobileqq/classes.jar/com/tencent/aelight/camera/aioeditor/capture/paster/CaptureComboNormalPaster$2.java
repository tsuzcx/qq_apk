package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class CaptureComboNormalPaster$2
  implements URLDrawable.URLDrawableListener
{
  CaptureComboNormalPaster$2(String paramString1, String paramString2, NormalFacePackage paramNormalFacePackage, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener, int paramInt3) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    CaptureComboNormalPaster.h.remove(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "applyNormalPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "urlDrawableListener onLoadSuccessed");
    }
    CaptureComboNormalPaster.a(paramURLDrawable, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    CaptureComboNormalPaster.h.remove(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboNormalPaster.2
 * JD-Core Version:    0.7.0.1
 */