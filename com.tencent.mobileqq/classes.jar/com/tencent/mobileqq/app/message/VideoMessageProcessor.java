package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Intent;
import com.tencent.av.core.AVMsgUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.OnLinePushParamReturnMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;

public class VideoMessageProcessor
  extends BaseMessageProcessor
{
  public VideoMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
    try
    {
      paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader)paramArrayOfByte.msg_msg_header.get();
      if (paramArrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgHeader failed");
        }
        return;
      }
      long l1 = paramArrayOfByte.uint64_to_uin.get();
      long l2 = paramArrayOfByte.uint64_room_id.get();
      paramArrayOfByte = new Intent();
      paramArrayOfByte.setAction("tencent.video.q2v.AudioEngineReady");
      paramArrayOfByte.putExtra("uin", String.valueOf(l1));
      paramArrayOfByte.putExtra("c2cuin", l1);
      paramArrayOfByte.putExtra("c2croomid", l2);
      this.a.getApp().sendBroadcast(paramArrayOfByte);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("ACTION_OPPOSITE_AUDIO_ENGINE_READY Send video c2c broadcast: selfUin = ");
      paramArrayOfByte.append(l1);
      paramArrayOfByte.append(" roomid = ");
      paramArrayOfByte.append(l2);
      QLog.d("svenxu", 1, paramArrayOfByte.toString());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgBody failed", paramArrayOfByte);
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt != 11) {
      return;
    }
    a(paramArrayOfByte);
  }
  
  public OnLinePushParamReturnMsg a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    if (paramInt != 9002)
    {
      if (paramInt == 9003) {
        if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null))
        {
          boolean bool = AVMsgUtil.a(paramMsgInfo.vMsg);
          ((QQAppInterface)this.a).getMsgHandler().a(paramSvcReqPushMsg.lUin, paramMsgInfo.vMsg, paramMsgInfo.lFromUin, (int)paramMsgInfo.uMsgTime, bool);
        }
        else
        {
          a(getClass().getName(), paramInt);
        }
      }
    }
    else if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
      a(paramSvcReqPushMsg.lUin, paramMsgInfo.vMsg, paramMsgInfo.lFromUin, (int)paramMsgInfo.uMsgTime);
    } else {
      a(getClass().getName(), paramInt);
    }
    return new OnLinePushParamReturnMsg(null, true);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 3001) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((byte[])paramVarArgs[2], 11);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.VideoMessageProcessor
 * JD-Core Version:    0.7.0.1
 */