package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public abstract interface IAEEditorGenerateResultListener
{
  public abstract void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo);
  
  public abstract void onAETavSessionExportError(String paramString1, int paramInt, String paramString2);
  
  public abstract void onAETavSessionExporting(String paramString, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAEEditorGenerateResultListener
 * JD-Core Version:    0.7.0.1
 */