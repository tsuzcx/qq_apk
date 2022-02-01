package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class QIMPtvTemplateManager$2
  implements Runnable
{
  QIMPtvTemplateManager$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QIMPtvTemplateManager.l().getPath());
    localStringBuilder.append(File.separator);
    FileUtils.writeFile(localStringBuilder.toString(), this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */