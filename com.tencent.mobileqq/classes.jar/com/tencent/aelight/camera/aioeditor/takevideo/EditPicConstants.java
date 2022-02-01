package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.mobileqq.app.FilePathConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicConstants
{
  public static String a;
  
  public static boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FilePathConstants.a);
    ((StringBuilder)localObject).append("QQEditPic");
    ((StringBuilder)localObject).append(File.separator);
    a = ((StringBuilder)localObject).toString();
    localObject = new File(a);
    boolean bool1 = ((File)localObject).mkdirs();
    boolean bool2 = ((File)localObject).isDirectory();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thumbFilesDirPath=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" isdir=");
      ((StringBuilder)localObject).append(bool2);
      QLog.e("initDirs", 2, ((StringBuilder)localObject).toString());
    }
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicConstants
 * JD-Core Version:    0.7.0.1
 */