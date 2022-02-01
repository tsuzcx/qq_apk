package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager;
import java.io.File;

public class QIMPtvTemplateManagerImpl
  implements IQIMPtvTemplateManager
{
  public String getDoodleConfigAbsolutePath()
  {
    return QIMPtvTemplateManager.e.getAbsolutePath();
  }
  
  public String getTempFaceConfigZip()
  {
    return "temp_faceu_zip";
  }
  
  public void handleGetServerConfig(String paramString, int paramInt)
  {
    ((QIMPtvTemplateManager)QIMManager.a(3)).a(paramString, paramInt);
  }
  
  public boolean isConfigFileExist()
  {
    return QIMPtvTemplateManager.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.QIMPtvTemplateManagerImpl
 * JD-Core Version:    0.7.0.1
 */