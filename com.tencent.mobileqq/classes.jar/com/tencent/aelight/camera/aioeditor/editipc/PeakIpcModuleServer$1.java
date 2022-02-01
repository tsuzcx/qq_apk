package com.tencent.aelight.camera.aioeditor.editipc;

import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PeakIpcModuleServer$1
  implements Runnable
{
  PeakIpcModuleServer$1(PeakIpcModuleServer paramPeakIpcModuleServer, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = SVUtils.a(this.a, "jpg");
    if ((!FileUtils.fileExistsAndNotEmpty((String)localObject)) && (!FileUtils.copyFile(this.b, (String)localObject)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("copy thumbPath fail, exist: ");
      ((StringBuilder)localObject).append(FileUtils.fileExistsAndNotEmpty(this.b));
      QLog.e("PeakIpcModuleServer", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer.1
 * JD-Core Version:    0.7.0.1
 */