package com.tencent.aelight.camera.qqstory.api;

import com.tencent.aelight.camera.struct.editor.DoodleInfoLoadObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPtvTemplateManager
  extends QRouteApi
{
  public abstract void handleGetDoodleConfig(String paramString, BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean hasDownloadFailed();
  
  public abstract void initLocalDoodleInfo(AppInterface paramAppInterface, DoodleInfoLoadObserver paramDoodleInfoLoadObserver);
  
  public abstract boolean isDoodleConfigFileExist();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */