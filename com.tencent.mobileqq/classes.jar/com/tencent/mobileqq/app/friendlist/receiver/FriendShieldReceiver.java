package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FriendShieldReceiver
  extends BaseHandlerReceiver
{
  public FriendShieldReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getInt("setId") == 4051) {
      b(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    Object localObject1 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    Boolean localBoolean = Boolean.valueOf(false);
    paramToServiceMsg = "";
    long l2;
    int j;
    Object localObject2;
    boolean bool1;
    boolean bool2;
    if ((i == 1) && (paramRspBody.msg_set_friend_id.has()))
    {
      paramRspBody = (Oidb_0x5d1.SetFriendIdRsp)paramRspBody.msg_set_friend_id.get();
      l2 = paramRspBody.uint64_seq.get();
      j = paramRspBody.uint32_result.get();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FriendShield : handleSetFriendShieldFlagResp : uin : ");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" cmd:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("result : ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" newSeq:");
        ((StringBuilder)localObject2).append(l2);
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, ((StringBuilder)localObject2).toString());
      }
      if (j == 0)
      {
        localObject2 = ((FriendsManager)localObject1).m(String.valueOf(l1));
        paramRspBody = paramToServiceMsg;
        if (localObject2 != null)
        {
          ((Friends)localObject2).setShieldFlag(true);
          ((FriendsManager)localObject1).a((Friends)localObject2);
          paramRspBody = this.a.getCurrentAccountUin();
          localObject1 = HardCodeUtil.a(2131902866);
          l2 = MessageCache.c();
          localObject2 = MessageRecordFactory.a(-2012);
          ((MessageRecord)localObject2).init(paramRspBody, String.valueOf(l1), paramRspBody, (String)localObject1, l2, 0, 0, l2);
          ((MessageRecord)localObject2).msgtype = -2012;
          ((MessageRecord)localObject2).isread = true;
          this.a.getMessageFacade().a((MessageRecord)localObject2, paramRspBody);
          paramRspBody = paramToServiceMsg;
        }
      }
      else
      {
        paramRspBody = paramRspBody.bytes_error_msg.get().toStringUtf8();
      }
      if (j == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (j == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      a(55, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), localBoolean, paramRspBody });
      return;
    }
    if ((i == 2) && (paramRspBody.msg_clear_friend_id.has()))
    {
      paramRspBody = (Oidb_0x5d1.ClearFriendIdRsp)paramRspBody.msg_clear_friend_id.get();
      l2 = paramRspBody.uint64_seq.get();
      j = paramRspBody.uint32_result.get();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FriendShield : handleSetFriendShieldFlagResp : uin : ");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" cmd:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("result : ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" newSeq:");
        ((StringBuilder)localObject2).append(l2);
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, ((StringBuilder)localObject2).toString());
      }
      if (j == 0)
      {
        localObject2 = ((FriendsManager)localObject1).m(String.valueOf(l1));
        paramRspBody = paramToServiceMsg;
        if (localObject2 != null)
        {
          ((Friends)localObject2).setShieldFlag(false);
          ((FriendsManager)localObject1).a((Friends)localObject2);
          paramRspBody = this.a.getCurrentAccountUin();
          localObject1 = HardCodeUtil.a(2131902869);
          l2 = MessageCache.c();
          localObject2 = MessageRecordFactory.a(-2012);
          ((MessageRecord)localObject2).init(paramRspBody, String.valueOf(l1), paramRspBody, (String)localObject1, l2, 0, 0, l2);
          ((MessageRecord)localObject2).msgtype = -2012;
          ((MessageRecord)localObject2).isread = true;
          this.a.getMessageFacade().a((MessageRecord)localObject2, paramRspBody);
          paramRspBody = paramToServiceMsg;
        }
      }
      else
      {
        paramRspBody = paramRspBody.bytes_error_msg.get().toStringUtf8();
      }
      if (j == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = true;
      if (j != 0) {
        bool2 = false;
      }
      a(55, bool1, new Object[] { Long.valueOf(l1), localBoolean, Boolean.valueOf(bool2), localBoolean, paramRspBody });
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<---handleSetFriendShieldFlagResp : cmd:");
      paramToServiceMsg.append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("friendUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isSet");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("FriendShield : handleSetFriendShieldFlagError : uin : ");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(" isSet:");
      paramToServiceMsg.append(bool);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
    }
    a(55, false, new Object[] { Long.valueOf(l), Boolean.valueOf(bool), Boolean.valueOf(false), Boolean.valueOf(false), "" });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0x5d1.RspBody localRspBody = new Oidb_0x5d1.RspBody();
    if ((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramObject != null) && (paramObject.uint32_result.has()))
        {
          i = paramObject.uint32_result.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = ");
            paramFromServiceMsg.append(i);
            QLog.i("Q.troopgetnews.", 2, paramFromServiceMsg.toString());
          }
        }
        paramFromServiceMsg = localRspBody;
        if (paramObject != null)
        {
          paramFromServiceMsg = localRspBody;
          if (paramObject.bytes_bodybuffer.has())
          {
            paramFromServiceMsg = localRspBody;
            if (paramObject.bytes_bodybuffer.get() != null)
            {
              paramFromServiceMsg = paramObject.bytes_bodybuffer.get().toByteArray();
              try
              {
                localRspBody.mergeFrom((byte[])paramFromServiceMsg);
                paramFromServiceMsg = localRspBody;
              }
              catch (Exception paramObject)
              {
                paramFromServiceMsg = null;
                paramObject.printStackTrace();
              }
            }
          }
        }
        if (paramFromServiceMsg == null) {
          return;
        }
        int i = paramFromServiceMsg.uint32_id.get();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("FriendShield : setId:");
          paramObject.append(i);
          paramObject.append("hex:");
          paramObject.append("");
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramObject.toString());
        }
        if (i == 4051) {
          a(paramToServiceMsg, paramFromServiceMsg);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0x5d1_0| oidb_sso parseFrom byte ");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.d("Q.troopgetnews.", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(String paramString)
  {
    return "OidbSvc.0x5d1_0".equals(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x5d1_0".equals(paramFromServiceMsg.getServiceCmd())) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.FriendShieldReceiver
 * JD-Core Version:    0.7.0.1
 */