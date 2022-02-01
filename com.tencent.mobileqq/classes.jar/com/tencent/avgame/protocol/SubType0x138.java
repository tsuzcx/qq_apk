package com.tencent.avgame.protocol;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.handler.GameRoomPushHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.Msg0X210SubTypeDecoder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMatchUserEnterRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMatchV2UserEnterRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;

public class SubType0x138
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    boolean bool = QLog.isColorLevel();
    paramArrayOfByte = Integer.valueOf(2);
    if (bool) {
      QLog.d("SubType0x138", 2, "SubType0x138 receive");
    }
    paramMsgType0x210 = GameRoomPushHandler.a(paramMsgType0x210);
    if (paramMsgType0x210 != null)
    {
      int i = paramMsgType0x210.type.get();
      if (i == 401)
      {
        GameUtil.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
        if (paramMsgType0x210.match_user_enter_room.has())
        {
          paramLong = ((AvGameNotify.NotifyMatchUserEnterRoom)paramMsgType0x210.match_user_enter_room.get()).roomid.get();
          ((AvGameRoomListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(AvGameRoomListHandler.a)).notifyUI(11, true, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) });
          return null;
        }
      }
      else
      {
        if (i == 402)
        {
          GameUtil.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
          ((AvGameRoomListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(AvGameRoomListHandler.a)).notifyUI(11, true, new Object[] { Integer.valueOf(1), Long.valueOf(0L) });
          return null;
        }
        if (i == 521)
        {
          GameUtil.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
          if (paramMsgType0x210.match_v2_user_enter_room.has())
          {
            paramLong = ((AvGameNotify.NotifyMatchV2UserEnterRoom)paramMsgType0x210.match_v2_user_enter_room.get()).roomid.get();
            ((AvGameRoomListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(AvGameRoomListHandler.a)).notifyUI(14, true, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) });
            return null;
          }
        }
        else if (i == 522)
        {
          GameUtil.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
          ((AvGameRoomListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(AvGameRoomListHandler.a)).notifyUI(14, true, new Object[] { Integer.valueOf(1), Long.valueOf(0L) });
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.protocol.SubType0x138
 * JD-Core Version:    0.7.0.1
 */