package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager;
import com.tencent.aelight.camera.struct.editor.DoodleInfoLoadObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;

public class PtvTemplateManagerImpl
  implements IPtvTemplateManager
{
  public void handleGetDoodleConfig(String paramString, BaseQQAppInterface paramBaseQQAppInterface)
  {
    PtvTemplateManager.a().a(paramString, (QQAppInterface)paramBaseQQAppInterface);
  }
  
  public boolean hasDownloadFailed()
  {
    return PtvTemplateManager.a().c();
  }
  
  public void initLocalDoodleInfo(AppInterface paramAppInterface, DoodleInfoLoadObserver paramDoodleInfoLoadObserver)
  {
    PtvTemplateManager.a().a(paramAppInterface, paramDoodleInfoLoadObserver);
  }
  
  public boolean isDoodleConfigFileExist()
  {
    return PtvTemplateManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.PtvTemplateManagerImpl
 * JD-Core Version:    0.7.0.1
 */