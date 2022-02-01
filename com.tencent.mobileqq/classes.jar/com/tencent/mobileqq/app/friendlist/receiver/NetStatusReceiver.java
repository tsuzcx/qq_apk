package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NetStatusReceiver
  extends BaseHandlerReceiver
{
  public NetStatusReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_show_to_friends", true);
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "set network switch isSuccess = " + bool1 + "; isShowedToFriends = " + bool2);
      }
      if (!bool1) {
        break label188;
      }
    }
    label188:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.a.setVisibilityForNetWorkStatus(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleSetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.a.getVisibilityForNetWorkStatus(false);
        a(76, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.a.setVisibilityForNetWorkStatus(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleGetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool3 = false;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "get network switch isSuccess = " + bool2 + "; isShowedToFriends = " + bool1);
      }
      if (!bool2) {
        bool1 = this.a.getVisibilityForNetWorkStatus(false);
      }
      a(77, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0x491_107".equals(paramString)) || ("OidbSvc.0x490_107".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0x491_107".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"OidbSvc.0x490_107".equals(str)) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.NetStatusReceiver
 * JD-Core Version:    0.7.0.1
 */