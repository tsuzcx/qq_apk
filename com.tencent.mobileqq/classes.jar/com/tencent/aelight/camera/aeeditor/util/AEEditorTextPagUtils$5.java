package com.tencent.aelight.camera.aeeditor.util;

import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;

final class AEEditorTextPagUtils$5
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorTextPagUtils$5(ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void a(int paramInt)
  {
    ApplyMaterialTask.MaterialStatusCallback localMaterialStatusCallback = this.a;
    ApplyMaterialTask.Status localStatus = ApplyMaterialTask.Status.ONGOING;
    double d = paramInt;
    Double.isNaN(d);
    localMaterialStatusCallback.a(localStatus, (int)(d * 0.34D + 66.0D));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils.5
 * JD-Core Version:    0.7.0.1
 */