package com.tencent.mobileqq.activity.contact.newfriend.poke;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xd51.Oidb_0xd51.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.AddtionInfo;

public class NewFriendNotifyPokeHandler
  extends BusinessHandler
{
  protected NewFriendNotifyPokeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (bool1)
      {
        paramFromServiceMsg = (byte[])paramObject;
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.d("NewFriendNotifyPokeHandler", 1, "handleSetPoke()  e =", paramFromServiceMsg);
          continue;
          bool2 = false;
        }
      }
      if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
        break;
      }
      bool2 = true;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendNotifyPokeHandler", 2, new Object[] { "handleSetPoke() isSuccess = ", Boolean.valueOf(bool2) });
      }
      notifyUI(1, bool2, paramObject);
      return;
    }
  }
  
  public void a(String paramString)
  {
    Oidb_0xd51.ReqBody localReqBody = new Oidb_0xd51.ReqBody();
    localReqBody.appid.set(10002L);
    localReqBody.frd_uin.set(Long.valueOf(paramString).longValue());
    localReqBody.add_direction.set(2);
    localReqBody.ext_sns_type.set(27);
    paramString = new FrdSysMsg.AddtionInfo();
    paramString.uint32_poke.set(0);
    localReqBody.bytes_poke_friend.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendNotifyPokeHandler", 2, "setPoked() poke = 1, format = 1");
    }
    sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd51", 3409, 16, localReqBody.toByteArray()));
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.oidb_0xd51");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return NewFriendNotifyPokeObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      QLog.d("NewFriendNotifyPokeHandler", 4, new Object[] { "onReceive() req.cmd = ", paramToServiceMsg.getServiceCmd() });
    }
    while (!"OidbSvc.oidb_0xd51".equals(paramToServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeHandler
 * JD-Core Version:    0.7.0.1
 */