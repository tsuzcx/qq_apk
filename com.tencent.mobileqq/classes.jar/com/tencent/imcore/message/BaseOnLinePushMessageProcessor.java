package com.tencent.imcore.message;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.Msg0X210SubTypeDecoder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.message.OnLinePushMsgTypeProcessorDispatcher;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseOnLinePushMessageProcessor
  extends BaseMessageProcessor
{
  protected final MapClassGenerator<Long, Msg0X210SubTypeDecoder> t = new MapClassGeneratorImpl();
  
  public BaseOnLinePushMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    super(paramAppInterface, paramBaseMessageHandler);
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
      QLog.d("Q.msg.BaseMessageProcessor", 1, paramArrayOfByte, new Object[0]);
    }
    return null;
  }
  
  private OnLinePushParamReturnMsg b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.r.a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt)).a(OnLinePushMsgTypeProcessorDispatcher.b(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private boolean e(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 234L;
  }
  
  private boolean f(MsgType0x210 paramMsgType0x210)
  {
    return (paramMsgType0x210.uSubMsgType == 36L) && (paramMsgType0x210.stMsgInfo0x24 != null);
  }
  
  protected BaseOnLinePushMessageProcessor.ProcessOneMsg a(BaseOnLinePushMessageProcessor.ProcessOneMsgBuildParams paramProcessOneMsgBuildParams)
  {
    return new BaseOnLinePushMessageProcessor.ProcessOneMsg(this, paramProcessOneMsgBuildParams);
  }
  
  MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    MsgType0x210 localMsgType0x210 = a(paramMsgInfo.vMsg);
    if (!c(localMsgType0x210)) {
      return null;
    }
    if (f(localMsgType0x210))
    {
      a(localMsgType0x210);
      return null;
    }
    if (d(localMsgType0x210)) {
      return a(paramMsgInfo, paramLong, localMsgType0x210);
    }
    if (e(localMsgType0x210)) {
      b(localMsgType0x210);
    }
    return null;
  }
  
  MessageRecord a(MsgInfo paramMsgInfo, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    Msg0X210SubTypeDecoder localMsg0X210SubTypeDecoder = (Msg0X210SubTypeDecoder)this.t.a(Long.valueOf(paramMsgType0x210.uSubMsgType));
    if (localMsg0X210SubTypeDecoder != null) {
      return localMsg0X210SubTypeDecoder.a(this, paramMsgType0x210, paramLong, paramMsgType0x210.vProtobuf, paramMsgInfo);
    }
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 3001) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  protected void a(MsgType0x210 paramMsgType0x210) {}
  
  protected void a(SvcReqPushMsg paramSvcReqPushMsg) {}
  
  protected void a(FromServiceMsg paramFromServiceMsg, ArrayList<MessageRecord> paramArrayList, ArrayList<String> paramArrayList1, SvcReqPushMsg paramSvcReqPushMsg, ArrayList<DelMsgInfo> paramArrayList2, long paramLong, int paramInt) {}
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    a(paramSvcReqPushMsg);
    paramToServiceMsg = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
    if (localArrayList2 != null)
    {
      if (localArrayList2.size() <= 0) {
        return;
      }
      ArrayList localArrayList3 = new ArrayList();
      long l = paramSvcReqPushMsg.lUin;
      int i = paramSvcReqPushMsg.svrip;
      ArrayList localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (MsgInfo)localIterator.next();
        BaseOnLinePushMessageProcessor.ProcessOneMsgBuildParams localProcessOneMsgBuildParams = new BaseOnLinePushMessageProcessor.ProcessOneMsgBuildParams();
        localProcessOneMsgBuildParams.a = paramFromServiceMsg;
        localProcessOneMsgBuildParams.b = paramSvcReqPushMsg;
        localProcessOneMsgBuildParams.c = paramToServiceMsg;
        localProcessOneMsgBuildParams.d = localArrayList1;
        localProcessOneMsgBuildParams.e = localArrayList2;
        localProcessOneMsgBuildParams.f = localArrayList3;
        localProcessOneMsgBuildParams.g = l;
        localProcessOneMsgBuildParams.h = localArrayList4;
        localProcessOneMsgBuildParams.i = ((MsgInfo)localObject);
        localProcessOneMsgBuildParams.j = false;
        localObject = a(localProcessOneMsgBuildParams).c();
        if ((!((BaseOnLinePushMessageProcessor.ProcessOneMsg)localObject).a()) && (((BaseOnLinePushMessageProcessor.ProcessOneMsg)localObject).b())) {
          return;
        }
      }
      a(paramFromServiceMsg, localArrayList1, localArrayList4, paramSvcReqPushMsg, localArrayList3, l, i);
    }
  }
  
  protected void b(MsgType0x210 paramMsgType0x210) {}
  
  boolean c(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210 != null;
  }
  
  public boolean d(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.vProtobuf != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseOnLinePushMessageProcessor
 * JD-Core Version:    0.7.0.1
 */