package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0xc83.RspBody;
import tencent.im.oidb.cmd0xc85.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FriendChatReceiver
  extends BaseHandlerReceiver
{
  public FriendChatReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    cmd0xc83.RspBody localRspBody = new cmd0xc83.RspBody();
    FriendListHandler localFriendListHandler = this.b;
    int k = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (k != 0) {
      bool = false;
    }
    if ((bool) && (localRspBody.uint32_result.has()) && (localRspBody.uint32_result.get() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin", "");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("frdUin", "");
    int i;
    if (localRspBody.uint32_retry_interval.has()) {
      i = localRspBody.uint32_retry_interval.get();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      int j;
      if (localRspBody.uint32_result.has()) {
        j = localRspBody.uint32_result.get();
      } else {
        j = -1;
      }
      QLog.i("FriendReactive", 2, String.format("handleReqRecheckInHotReactive suc=%b oidb=%d result=%d interval=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
    }
    a(114, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    cmd0xc85.RspBody localRspBody = new cmd0xc85.RspBody();
    FriendListHandler localFriendListHandler = this.b;
    int m = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (m != 0) {
      bool = false;
    }
    int j;
    if ((bool) && (localRspBody.uint32_result.has()) && (localRspBody.uint32_result.get() == 0)) {
      j = 1;
    } else {
      j = 0;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin", "");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("frdUin", "");
    int i;
    if (localRspBody.uint32_recent_interaction_time.has()) {
      i = localRspBody.uint32_recent_interaction_time.get();
    } else {
      i = 0;
    }
    long l = i;
    if (i > 0) {
      l = 1000L * (86400 * i - 28800);
    }
    int k;
    if (l >= 0L) {
      k = 1;
    } else {
      k = 0;
    }
    bool = j & k;
    if (QLog.isColorLevel())
    {
      if (localRspBody.uint32_result.has()) {
        j = localRspBody.uint32_result.get();
      } else {
        j = -1;
      }
      QLog.i("IceBreak", 2, String.format("handleReqLastChatTime suc=%b oidb=%d result=%d ts=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) }));
    }
    a(115, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg, Long.valueOf(l) });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler.handleSetMessageNotificationSettingResp(). res=");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("tag_msg_notification", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MessageNotificationSettingManager.a(this.a);
    int j = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
        }
        paramFromServiceMsg.printStackTrace();
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        int i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("ssoPkg.uint32_result=");
          paramToServiceMsg.append(i);
          QLog.d("tag_hidden_chat", 2, paramToServiceMsg.toString());
        }
        if (i == 0)
        {
          i = 0;
          while (i < arrayOfString.length)
          {
            ((MessageNotificationSettingManager)localObject).a(arrayOfString[i], j, arrayOfBoolean[i]);
            i += 1;
          }
          bool = true;
          break label268;
        }
      }
    }
    boolean bool = false;
    label268:
    a(128, bool, new Object[] { arrayOfString, arrayOfBoolean, Integer.valueOf(j) });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler.handleSetHiddenChatResp(). res=");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("tag_hidden_chat", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramToServiceMsg.extraData.getStringArray("param_uins");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_chat_types");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
        }
        paramFromServiceMsg.printStackTrace();
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        int i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("ssoPkg.uint32_result=");
          paramToServiceMsg.append(i);
          QLog.d("tag_hidden_chat", 2, paramToServiceMsg.toString());
        }
        if (i == 0)
        {
          i = 0;
          while (i < localObject.length)
          {
            paramToServiceMsg = localObject[i];
            k = arrayOfBoolean[i];
            int j = arrayOfInt[i];
            paramToServiceMsg = new FriendsStatusUtil.UpdateFriendStatusItem(paramToServiceMsg, 13581, 21);
            if (k != 0) {
              paramToServiceMsg.a(new byte[1]);
            } else {
              paramToServiceMsg.a(null);
            }
            FriendsStatusUtil.a(this.a, paramToServiceMsg, null);
            i += 1;
          }
          k = 1;
          break label305;
        }
      }
    }
    int k = 0;
    label305:
    a(127, k, new Object[] { localObject, arrayOfBoolean });
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0xc83".equals(paramString)) || ("OidbSvc.0xc85".equals(paramString)) || ("OidbSvc.0x5d6_21".equals(paramString)) || ("OidbSvc.0x5d6_18".equals(paramString)) || ("OidbSvc.0x5d6_19".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0xc83".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc85".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x5d6_21".equals(str))
    {
      if (paramToServiceMsg.extraData.getInt("param_type") == 0)
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (("OidbSvc.0x5d6_18".equals(str)) || ("OidbSvc.0x5d6_19".equals(str))) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("param_type", -1);
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("param_status_item_list");
    boolean bool = paramToServiceMsg.extraData.getBoolean("param_notify_plugin", false);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x5d6ResponsePackage serviceType=");
      paramToServiceMsg.append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 4, paramToServiceMsg.toString());
    }
    if ((paramFromServiceMsg != null) && (paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage parse oidb_sso.OIDBSSOPkg failed.");
        }
        FriendsStatusUtil.a(i, false, localArrayList, null, this.a, bool);
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        int j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("ssoPkg.uint32_result=");
          paramFromServiceMsg.append(j);
          QLog.d("FriendListHandler.BaseHandlerReceiver", 4, paramFromServiceMsg.toString());
        }
        if (j == 0)
        {
          paramFromServiceMsg = new oidb_0x5d6.RspBody();
          try
          {
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            paramToServiceMsg = paramFromServiceMsg.rpt_msg_update_result.get();
            if ((paramToServiceMsg != null) && (!paramToServiceMsg.isEmpty()))
            {
              FriendsStatusUtil.a(i, true, localArrayList, paramToServiceMsg, this.a, bool);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage resultList null!");
            }
            FriendsStatusUtil.a(i, false, localArrayList, null, this.a, bool);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage res failed!");
            }
            FriendsStatusUtil.a(i, false, localArrayList, null, this.a, bool);
            paramToServiceMsg.printStackTrace();
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage uint32_result failed!");
        }
        FriendsStatusUtil.a(i, false, localArrayList, null, this.a, bool);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage res failed!");
      }
      FriendsStatusUtil.a(i, false, localArrayList, null, this.a, bool);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage req failed!");
    }
    FriendsStatusUtil.a(i, false, localArrayList, null, this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.FriendChatReceiver
 * JD-Core Version:    0.7.0.1
 */