package com.tencent.aelight.camera.aeeditor.util;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import java.util.concurrent.CountDownLatch;

final class AEEditorTextPagUtils$1
  implements ApplyMaterialTask.MaterialStatusCallback
{
  AEEditorTextPagUtils$1(CountDownLatch paramCountDownLatch) {}
  
  public void a(@NonNull ApplyMaterialTask.Status paramStatus, int paramInt)
  {
    if ((paramStatus == ApplyMaterialTask.Status.SUCCEEDED) || (paramStatus == ApplyMaterialTask.Status.FAILED)) {
      this.a.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils.1
 * JD-Core Version:    0.7.0.1
 */