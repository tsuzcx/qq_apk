package com.tencent.aelight.camera.aioeditor.config;

import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier.ConfigDownloadCallback;
import com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager;
import com.tencent.mobileqq.qroute.QRoute;

class QIMTemplateConfigProcessor$1
  implements ConfigSimplifier.ConfigDownloadCallback
{
  QIMTemplateConfigProcessor$1(QIMTemplateConfigProcessor paramQIMTemplateConfigProcessor) {}
  
  public void a(String paramString)
  {
    ((IQIMPtvTemplateManager)QRoute.api(IQIMPtvTemplateManager.class)).handleGetServerConfig(paramString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.config.QIMTemplateConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */