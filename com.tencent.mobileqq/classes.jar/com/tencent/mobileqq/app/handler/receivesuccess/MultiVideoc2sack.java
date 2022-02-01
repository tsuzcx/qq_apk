package com.tencent.mobileqq.app.handler.receivesuccess;

import SharpSvrPack.MultiVideoMsg;
import com.tencent.av.VideoConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MultiVideoc2sack
{
  public static void a(MessageHandler paramMessageHandler, FromServiceMsg paramFromServiceMsg)
  {
    if (("MultiVideo.c2sack".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (VideoConstants.a))
    {
      paramFromServiceMsg = (MultiVideoMsg)paramMessageHandler.decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg c2sack, type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramFromServiceMsg.type), Short.valueOf(paramFromServiceMsg.csCmd) }));
      }
      if (paramFromServiceMsg.type >= 32) {
        return;
      }
      paramMessageHandler.n.getGAudioHandler().b(paramFromServiceMsg.video_buff);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MultiVideoc2sack
 * JD-Core Version:    0.7.0.1
 */