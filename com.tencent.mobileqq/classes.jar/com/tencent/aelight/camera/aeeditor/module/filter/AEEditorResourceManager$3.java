package com.tencent.aelight.camera.aeeditor.module.filter;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.open.base.FileUtils;

final class AEEditorResourceManager$3
  implements Runnable
{
  public void run()
  {
    FileUtils.a(this.a, "camera/frame", AEEditorResourceManager.d);
    AEQLog.b("[AEEditor2]AEEditorResourceManager", "setupFrameEnv---pag file is successfully copied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.3
 * JD-Core Version:    0.7.0.1
 */