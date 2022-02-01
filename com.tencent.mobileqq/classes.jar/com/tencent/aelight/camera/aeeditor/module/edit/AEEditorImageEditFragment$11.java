package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.log.AEQLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class AEEditorImageEditFragment$11
  implements WtTicketPromise
{
  AEEditorImageEditFragment$11(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    AEQLog.b("AEEditorImageEditFragment", "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    AEQLog.d("AEEditorImageEditFragment", paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    AEQLog.d("AEEditorImageEditFragment", paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.11
 * JD-Core Version:    0.7.0.1
 */