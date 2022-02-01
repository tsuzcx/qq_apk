package com.tencent.aelight.camera.aeeditor.module.filter;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

class AEEditorResourceManager$4
  implements Runnable
{
  AEEditorResourceManager$4(AEEditorResourceManager paramAEEditorResourceManager) {}
  
  public void run()
  {
    AEEditorResourceManager.a(this.this$0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEEditorResourceManager.b(this.this$0));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(".nomedia");
    localObject = ((StringBuilder)localObject).toString();
    if (!new File((String)localObject).exists()) {
      try
      {
        FileUtils.createFile((String)localObject);
        return;
      }
      catch (IOException localIOException)
      {
        AEQLog.a(AEEditorResourceManager.c(this.this$0), "loadAssets", localIOException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.4
 * JD-Core Version:    0.7.0.1
 */