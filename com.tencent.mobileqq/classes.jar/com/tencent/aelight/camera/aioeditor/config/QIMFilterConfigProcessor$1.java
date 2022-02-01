package com.tencent.aelight.camera.aioeditor.config;

import com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier.ConfigDownloadCallback;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;

class QIMFilterConfigProcessor$1
  implements ConfigSimplifier.ConfigDownloadCallback
{
  QIMFilterConfigProcessor$1(QIMFilterConfigProcessor paramQIMFilterConfigProcessor) {}
  
  public void a(String paramString)
  {
    ((IVideoFilterTools)QRoute.api(IVideoFilterTools.class)).updateQQShortVideoFilterConfig(BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.config.QIMFilterConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */