package com.tencent.aelight.camera.aioeditor.capture.text;

import com.tencent.qphone.base.util.QLog;

class CaptureComboText$2
  implements DynamicTextConfigManager.IDynamicTextResDownloadCallback
{
  CaptureComboText$2(CaptureComboText paramCaptureComboText) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("CaptureComboText onUpdateProgress, progress is : ");
      paramString.append(paramFloat);
      QLog.i("QComboDText", 2, paramString.toString());
    }
    CaptureComboText.a(this.a, paramFloat);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("CaptureComboText onDownloadFinish, success: ");
      paramString.append(paramBoolean);
      QLog.i("QComboDText", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      CaptureComboText.a(this.a, 3);
      this.a.b();
      return;
    }
    CaptureComboText.a(this.a, 2);
    this.a.a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.CaptureComboText.2
 * JD-Core Version:    0.7.0.1
 */