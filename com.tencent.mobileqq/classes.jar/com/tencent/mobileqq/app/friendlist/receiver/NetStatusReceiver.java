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
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool4 = true;
    boolean bool2;
    if ((bool1) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("key_show_to_friends", true);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("set network switch isSuccess = ");
      paramToServiceMsg.append(bool2);
      paramToServiceMsg.append("; isShowedToFriends = ");
      paramToServiceMsg.append(bool3);
      QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
    }
    bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label208;
        }
        bool1 = bool4;
        if (bool1) {
          this.a.setVisibilityForNetWorkStatus(bool3, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("handleSetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        }
        bool1 = false;
      }
      bool2 = bool3;
      if (!bool1) {
        bool2 = this.a.getVisibilityForNetWorkStatus(false);
      }
      a(75, bool1, Boolean.valueOf(bool2));
      return;
      label208:
      bool1 = false;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool6 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    boolean bool4 = true;
    boolean bool3;
    if ((bool2) && (paramObject != null)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    bool2 = bool3;
    if (bool3) {
      bool3 = bool5;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool3 = bool5;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool3 = bool5;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label269;
        }
        bool2 = true;
        bool1 = bool6;
        if (bool2)
        {
          bool3 = bool5;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool3 = bool5;
          paramToServiceMsg.getInt();
          bool3 = bool5;
          if (paramToServiceMsg.get() != 0) {
            break label275;
          }
          bool1 = bool4;
          bool3 = bool1;
          this.a.setVisibilityForNetWorkStatus(bool1, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("handleGetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        }
        bool2 = false;
        bool1 = bool3;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("get network switch isSuccess = ");
        paramToServiceMsg.append(bool2);
        paramToServiceMsg.append("; isShowedToFriends = ");
        paramToServiceMsg.append(bool1);
        QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
      }
      if (!bool2) {
        bool1 = this.a.getVisibilityForNetWorkStatus(false);
      }
      a(76, bool2, Boolean.valueOf(bool1));
      return;
      label269:
      bool2 = false;
      continue;
      label275:
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
    if ("OidbSvc.0x491_107".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x490_107".equals(str)) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.NetStatusReceiver
 * JD-Core Version:    0.7.0.1
 */