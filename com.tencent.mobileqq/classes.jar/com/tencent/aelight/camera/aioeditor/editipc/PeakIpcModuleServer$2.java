package com.tencent.aelight.camera.aioeditor.editipc;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class PeakIpcModuleServer$2
  implements Runnable
{
  PeakIpcModuleServer$2(PeakIpcModuleServer paramPeakIpcModuleServer, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.a.getMessageFacade().a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer.2
 * JD-Core Version:    0.7.0.1
 */