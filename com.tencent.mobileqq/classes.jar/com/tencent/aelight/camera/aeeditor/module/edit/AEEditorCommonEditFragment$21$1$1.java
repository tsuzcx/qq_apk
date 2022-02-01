package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.PAG;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

class AEEditorCommonEditFragment$21$1$1
  implements Runnable
{
  AEEditorCommonEditFragment$21$1$1(AEEditorCommonEditFragment.21.1 param1, NetResp paramNetResp) {}
  
  public void run()
  {
    if (this.a != null)
    {
      localObject = AEBaseDataReporter.a();
      boolean bool;
      if (this.a.mResult == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((AEBaseDataReporter)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.a.mErrCode, this.a.reqCost);
    }
    Object localObject = AEEditorPath.EDITOR.PAG.c;
    if (new File((String)localObject).exists()) {
      try
      {
        FileUtils.uncompressZip((String)localObject, AEEditorPath.EDITOR.PAG.b, false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AEEditorPath.EDITOR.PAG.b);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(".nomedia");
        FileUtils.createFile(((StringBuilder)localObject).toString());
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.21.1.1
 * JD-Core Version:    0.7.0.1
 */