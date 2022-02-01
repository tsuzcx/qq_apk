package com.tencent.aelight.camera.api.impl;

import android.support.annotation.Nullable;
import com.tencent.aelight.camera.aeeditor.AEEditorProcessManager;
import com.tencent.aelight.camera.api.IAEEditorProcess;

public class AEEditorProcessImpl
  implements IAEEditorProcess
{
  public void clean()
  {
    AEEditorProcessManager.a().c();
  }
  
  public boolean isGenerateWorking()
  {
    return AEEditorProcessManager.a().d();
  }
  
  public void requestGenerateVideo(@Nullable String paramString)
  {
    AEEditorProcessManager.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEEditorProcessImpl
 * JD-Core Version:    0.7.0.1
 */