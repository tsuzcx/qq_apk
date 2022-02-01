package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.InformationPasterChangeListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.qphone.base.util.QLog;

class QIMInformationPasterManager$2$1
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  QIMInformationPasterManager$2$1(QIMInformationPasterManager.2 param2) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, InformationFacePackage.Item paramItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSucess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" item:");
      localStringBuilder.append(paramItem);
      QLog.d("QIMInformationPasterManager", 2, localStringBuilder.toString());
    }
    if (paramItem.a() != null) {
      paramItem.a().a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.2.1
 * JD-Core Version:    0.7.0.1
 */