package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;

class AEEditorCommonEditFragment$21$1
  implements HttpEngineTask.IHttpEngineTask
{
  AEEditorCommonEditFragment$21$1(AEEditorCommonEditFragment.21 param21) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask) {}
  
  public void onResp(NetResp paramNetResp)
  {
    ThreadManager.excute(new AEEditorCommonEditFragment.21.1.1(this, paramNetResp), 64, null, true);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.21.1
 * JD-Core Version:    0.7.0.1
 */