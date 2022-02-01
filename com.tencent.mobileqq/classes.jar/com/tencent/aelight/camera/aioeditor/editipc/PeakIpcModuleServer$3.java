package com.tencent.aelight.camera.aioeditor.editipc;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;

class PeakIpcModuleServer$3
  implements Runnable
{
  PeakIpcModuleServer$3(PeakIpcModuleServer paramPeakIpcModuleServer, QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.a.getMessageFacade().h(this.b.frienduin, this.b.istroop, this.b.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer.3
 * JD-Core Version:    0.7.0.1
 */