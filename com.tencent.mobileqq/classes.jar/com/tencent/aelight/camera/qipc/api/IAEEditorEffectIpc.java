package com.tencent.aelight.camera.qipc.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEEditorEffectIpc
  extends QRouteApi
{
  public static final String NAME = "AEEditorEffectIpcModule";
  
  public abstract QIPCModule getAEEditorEffectQIPCModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qipc.api.IAEEditorEffectIpc
 * JD-Core Version:    0.7.0.1
 */