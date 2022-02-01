package com.tencent.biz.qcircleshadow.lib.listener;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public abstract interface QCircleAEEditorGenerateResultListener
{
  public abstract void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo);
  
  public abstract void onAETavSessionExportError(String paramString1, int paramInt, String paramString2);
  
  public abstract void onAETavSessionExporting(String paramString, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener
 * JD-Core Version:    0.7.0.1
 */