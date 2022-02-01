package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.qphone.base.util.QLog;

class QIMInformationPasterManager$3
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  QIMInformationPasterManager$3(QIMInformationPasterManager paramQIMInformationPasterManager) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, InformationFacePackage.Item paramItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" item:");
      localStringBuilder.append(paramItem.toString());
      QLog.d("QIMInformationPasterManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.3
 * JD-Core Version:    0.7.0.1
 */