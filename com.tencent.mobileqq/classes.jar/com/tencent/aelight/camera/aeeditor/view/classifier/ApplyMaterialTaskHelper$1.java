package com.tencent.aelight.camera.aeeditor.view.classifier;

import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;

final class ApplyMaterialTaskHelper$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  ApplyMaterialTaskHelper$1(ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void a(int paramInt)
  {
    this.a.a(ApplyMaterialTask.Status.ONGOING, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    this.a.a(ApplyMaterialTask.Status.FAILED, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTaskHelper.1
 * JD-Core Version:    0.7.0.1
 */