package com.tencent.avgame.gamelogic.handler;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.avgame.business.handler.AVGameBusinessHandler;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.NotifyDispatcher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tencent.im.oidb.submsgtype0x138.Submsgtype0x138.MsgBody;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;

public class GameRoomPushHandler
  extends AVGameBusinessHandler
{
  public GameRoomPushHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static MsgType0x210 a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      MsgType0x210 localMsgType0x210 = new MsgType0x210();
      localMsgType0x210.readFrom(paramArrayOfByte);
      return localMsgType0x210;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static AvGameNotify.NotifyMsg a(MsgType0x210 paramMsgType0x210)
  {
    Submsgtype0x138.MsgBody localMsgBody = new Submsgtype0x138.MsgBody();
    Object localObject = null;
    AvGameNotify.NotifyMsg localNotifyMsg = null;
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if ((localMsgBody.uint32_bussi_type.get() == 1) && (localMsgBody.bytes_msg_data.get() != null))
      {
        paramMsgType0x210 = new AvGameNotify.NotifyMsg();
        try
        {
          localNotifyMsg = (AvGameNotify.NotifyMsg)paramMsgType0x210.mergeFrom(localMsgBody.bytes_msg_data.get().toByteArray());
          return localNotifyMsg;
        }
        catch (Exception localException1) {}catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          break label154;
        }
      }
      else
      {
        QLog.d("avgame_logic.GameRoomPushHandler", 1, String.format("parseNotifyMsg err %d %s", new Object[] { Integer.valueOf(localMsgBody.uint32_bussi_type.get()), localMsgBody.bytes_msg_data.get() }));
        return null;
      }
    }
    catch (Exception localException3)
    {
      paramMsgType0x210 = localInvalidProtocolBufferMicroException1;
      Exception localException2 = localException3;
      QLog.d("avgame_logic.GameRoomPushHandler", 1, new Object[] { "parseNotifyMsg ex=", localException2.getMessage(), localException2 });
      return paramMsgType0x210;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      paramMsgType0x210 = localException3;
      label154:
      QLog.d("avgame_logic.GameRoomPushHandler", 1, new Object[] { "parseNotifyMsg ex=", localInvalidProtocolBufferMicroException2.getMessage(), localInvalidProtocolBufferMicroException2 });
    }
    return paramMsgType0x210;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (SvcReqPushMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "req", new SvcReqPushMsg());
    if (paramObject == null) {
      paramToServiceMsg = null;
    } else {
      paramToServiceMsg = paramObject.vMsgInfos;
    }
    int i;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.d("avgame_logic.GameRoomPushHandler", 1, "handleOnlinePush doesn't has msgInfos return");
      return;
    }
    Iterator localIterator = paramToServiceMsg.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MsgInfo)localIterator.next();
      i = ((MsgInfo)localObject).shMsgType;
      long l = paramObject.lUin;
      if (paramFromServiceMsg.getUin() == null) {
        paramToServiceMsg = this.appRuntime.getAccount();
      } else {
        paramToServiceMsg = paramFromServiceMsg.getUin();
      }
      Long.valueOf(paramToServiceMsg).longValue();
      if (528 == i)
      {
        paramToServiceMsg = a(((MsgInfo)localObject).vMsg);
        if ((paramToServiceMsg.vProtobuf != null) && (paramToServiceMsg.uSubMsgType == 312L))
        {
          localObject = a(paramToServiceMsg);
          if (localObject != null) {
            paramToServiceMsg = GameUtil.a(((AvGameNotify.NotifyMsg)localObject).type.get());
          } else {
            paramToServiceMsg = "null";
          }
          QLog.d("avgame_logic.GameRoomPushHandler", 1, new Object[] { "handleOnlinePush type=", paramToServiceMsg });
          if (localObject != null) {
            NotifyDispatcher.a((BaseAVGameAppInterface)this.appRuntime, (AvGameNotify.NotifyMsg)localObject);
          }
        }
      }
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OnlinePush.ReqPush");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OnlinePush.ReqPush".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.handler.GameRoomPushHandler
 * JD-Core Version:    0.7.0.1
 */