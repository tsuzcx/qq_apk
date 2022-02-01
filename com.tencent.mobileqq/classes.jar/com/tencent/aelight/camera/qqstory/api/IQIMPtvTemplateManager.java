package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQIMPtvTemplateManager
  extends QRouteApi
{
  public abstract String getDoodleConfigAbsolutePath();
  
  public abstract String getTempFaceConfigZip();
  
  public abstract void handleGetServerConfig(String paramString, int paramInt);
  
  public abstract boolean isConfigFileExist();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */