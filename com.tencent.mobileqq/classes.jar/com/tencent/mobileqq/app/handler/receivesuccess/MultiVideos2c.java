package com.tencent.mobileqq.app.handler.receivesuccess;

import SharpSvrPack.MultiVideoMsg;
import android.os.Bundle;
import com.tencent.av.VideoConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class MultiVideos2c
{
  public static void a(MessageHandler paramMessageHandler, FromServiceMsg paramFromServiceMsg)
  {
    if (("MultiVideo.s2c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (VideoConstants.a))
    {
      paramFromServiceMsg = (MultiVideoMsg)paramMessageHandler.decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg s2c, type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramFromServiceMsg.type), Short.valueOf(paramFromServiceMsg.csCmd) }));
      }
      if (paramFromServiceMsg.type >= 32) {
        return;
      }
      paramMessageHandler.n.getGAudioHandler().a(paramFromServiceMsg.video_buff);
      if (paramFromServiceMsg.type != 10)
      {
        ToServiceMsg localToServiceMsg = paramMessageHandler.createToServiceMsg("MultiVideo.s2cack");
        localToServiceMsg.extraData.putByte("ver", paramFromServiceMsg.ver);
        localToServiceMsg.extraData.putByte("type", paramFromServiceMsg.type);
        localToServiceMsg.extraData.putShort("cscmd", paramFromServiceMsg.csCmd);
        localToServiceMsg.extraData.putShort("subcmd", paramFromServiceMsg.subCmd);
        localToServiceMsg.extraData.putLong("from_uin", paramFromServiceMsg.from_uin);
        localToServiceMsg.extraData.putLong("to_uin", ((Long)paramFromServiceMsg.to_uin.get(0)).longValue());
        localToServiceMsg.extraData.putLong("msg_seq", paramFromServiceMsg.msg_seq);
        localToServiceMsg.extraData.putLong("msg_uid", paramFromServiceMsg.msg_uid);
        localToServiceMsg.extraData.putLong("msg_type", paramFromServiceMsg.msg_type);
        localToServiceMsg.extraData.putLong("msg_time", paramFromServiceMsg.msg_time);
        localToServiceMsg.extraData.putByteArray("video_buff", paramFromServiceMsg.video_buff);
        localToServiceMsg.extraData.putLong("msg_dataflag", paramFromServiceMsg.msg_dataflag);
        paramMessageHandler.send(localToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MultiVideos2c
 * JD-Core Version:    0.7.0.1
 */