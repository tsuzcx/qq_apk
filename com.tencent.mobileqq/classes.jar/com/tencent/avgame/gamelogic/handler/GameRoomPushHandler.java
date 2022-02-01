package com.tencent.avgame.gamelogic.handler;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.AVGameBusinessHandler;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.NotifyDispatcher;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
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
  
  public static AvGameNotify.NotifyMsg a(MsgType0x210 paramMsgType0x210)
  {
    localObject3 = null;
    localObject2 = null;
    Object localObject1 = new Submsgtype0x138.MsgBody();
    try
    {
      ((Submsgtype0x138.MsgBody)localObject1).mergeFrom(paramMsgType0x210.vProtobuf);
      if ((((Submsgtype0x138.MsgBody)localObject1).uint32_bussi_type.get() == 1) && (((Submsgtype0x138.MsgBody)localObject1).bytes_msg_data.get() != null)) {
        paramMsgType0x210 = new AvGameNotify.NotifyMsg();
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      paramMsgType0x210 = localObject2;
      QLog.d("avgame_logic.GameRoomPushHandler", 1, new Object[] { "parseNotifyMsg ex=", localInvalidProtocolBufferMicroException1.getMessage(), localInvalidProtocolBufferMicroException1 });
      return paramMsgType0x210;
    }
    catch (Exception localException1)
    {
      paramMsgType0x210 = localObject3;
      QLog.d("avgame_logic.GameRoomPushHandler", 1, new Object[] { "parseNotifyMsg ex=", localException1.getMessage(), localException1 });
      return paramMsgType0x210;
    }
    try
    {
      localObject1 = (AvGameNotify.NotifyMsg)paramMsgType0x210.mergeFrom(((Submsgtype0x138.MsgBody)localObject1).bytes_msg_data.get().toByteArray());
      return localObject1;
    }
    catch (Exception localException2)
    {
      break label144;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      break label113;
    }
    QLog.d("avgame_logic.GameRoomPushHandler", 1, String.format("parseNotifyMsg err %d %s", new Object[] { Integer.valueOf(((Submsgtype0x138.MsgBody)localObject1).uint32_bussi_type.get()), ((Submsgtype0x138.MsgBody)localObject1).bytes_msg_data.get() }));
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (SvcReqPushMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "req", new SvcReqPushMsg());
    if (paramObject == null)
    {
      paramToServiceMsg = null;
      if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label69;
      }
      QLog.d("avgame_logic.GameRoomPushHandler", 1, "handleOnlinePush doesn't has msgInfos return");
      return;
      paramToServiceMsg = paramObject.vMsgInfos;
      break;
    }
    label69:
    Iterator localIterator = paramToServiceMsg.iterator();
    label75:
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (MsgInfo)localIterator.next();
      i = ((MsgInfo)localObject).shMsgType;
      long l = paramObject.lUin;
      if (paramFromServiceMsg.getUin() != null) {
        break label230;
      }
      paramToServiceMsg = Long.valueOf(this.appRuntime.getAccount());
      label128:
      paramToServiceMsg.longValue();
      if (528 == i)
      {
        paramToServiceMsg = OnLinePushMessageProcessor.a(((MsgInfo)localObject).vMsg);
        if ((paramToServiceMsg.vProtobuf != null) && (paramToServiceMsg.uSubMsgType == 312L))
        {
          localObject = a(paramToServiceMsg);
          if (localObject == null) {
            break label241;
          }
        }
      }
    }
    label230:
    label241:
    for (paramToServiceMsg = GameUtil.a(((AvGameNotify.NotifyMsg)localObject).type.get());; paramToServiceMsg = "null")
    {
      QLog.d("avgame_logic.GameRoomPushHandler", 1, new Object[] { "handleOnlinePush type=", paramToServiceMsg });
      if (localObject == null) {
        break label75;
      }
      NotifyDispatcher.a((AVGameAppInterface)this.appRuntime, (AvGameNotify.NotifyMsg)localObject);
      break label75;
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      break label128;
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
  
  public Class<? extends BusinessObserver> observerClass()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.handler.GameRoomPushHandler
 * JD-Core Version:    0.7.0.1
 */