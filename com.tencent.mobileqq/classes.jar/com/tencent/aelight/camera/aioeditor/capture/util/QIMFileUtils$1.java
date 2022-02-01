package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class QIMFileUtils$1
  implements Runnable
{
  QIMFileUtils$1(File paramFile, String paramString1, String paramString2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getPath());
    localStringBuilder.append(File.separator);
    FileUtils.writeFile(localStringBuilder.toString(), this.b, this.c);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("paster config save to file ");
      localStringBuilder.append(this.a.getPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.b);
      QLog.i("QIMFileUtils", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils.1
 * JD-Core Version:    0.7.0.1
 */