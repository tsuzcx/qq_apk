package com.tencent.aelight.camera.qipc.api.impl;

import com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectIpcModule;
import com.tencent.aelight.camera.qipc.api.IAEEditorEffectIpc;
import com.tencent.mobileqq.qipc.QIPCModule;

public class AEEditorEffectIpcImpl
  implements IAEEditorEffectIpc
{
  public QIPCModule getAEEditorEffectQIPCModule()
  {
    return AEEditorEffectIpcModule.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qipc.api.impl.AEEditorEffectIpcImpl
 * JD-Core Version:    0.7.0.1
 */