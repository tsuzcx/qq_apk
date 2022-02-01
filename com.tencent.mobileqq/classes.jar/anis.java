import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
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

public class anis
  extends anio
{
  public anis(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    cmd0xc83.RspBody localRspBody = new cmd0xc83.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int k = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (k != 0) {
      bool = false;
    }
    int i;
    if ((bool) && (localRspBody.uint32_result.has()) && (localRspBody.uint32_result.get() == 0))
    {
      bool = true;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin", "");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("frdUin", "");
      if (!localRspBody.uint32_retry_interval.has()) {
        break label222;
      }
      i = localRspBody.uint32_retry_interval.get();
      label113:
      if (QLog.isColorLevel()) {
        if (!localRspBody.uint32_result.has()) {
          break label228;
        }
      }
    }
    label222:
    label228:
    for (int j = localRspBody.uint32_result.get();; j = -1)
    {
      QLog.i("FriendReactive", 2, String.format("handleReqRecheckInHotReactive suc=%b oidb=%d result=%d interval=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      a(117, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i) });
      return;
      bool = false;
      break;
      i = 0;
      break label113;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    cmd0xc85.RspBody localRspBody = new cmd0xc85.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int m = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (m != 0) {
      bool = false;
    }
    int i;
    label113:
    long l;
    int k;
    if ((bool) && (localRspBody.uint32_result.has()) && (localRspBody.uint32_result.get() == 0))
    {
      j = 1;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin", "");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("frdUin", "");
      if (!localRspBody.uint32_recent_interaction_time.has()) {
        break label265;
      }
      i = localRspBody.uint32_recent_interaction_time.get();
      l = i;
      if (i > 0) {
        l = 1000L * (86400 * i - 28800);
      }
      if (l < 0L) {
        break label271;
      }
      k = 1;
      label149:
      bool = k & j;
      if (QLog.isColorLevel()) {
        if (!localRspBody.uint32_result.has()) {
          break label277;
        }
      }
    }
    label265:
    label271:
    label277:
    for (int j = localRspBody.uint32_result.get();; j = -1)
    {
      QLog.i("IceBreak", 2, String.format("handleReqLastChatTime suc=%b oidb=%d result=%d ts=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) }));
      a(118, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg, Long.valueOf(l) });
      return;
      j = 0;
      break;
      i = 0;
      break label113;
      k = 0;
      break label149;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("tag_msg_notification", 2, "FriendListHandler.handleSetMessageNotificationSettingResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    apka localapka = apka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        for (;;)
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
          }
          paramFromServiceMsg.printStackTrace();
        }
        bool = true;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          i = 0;
          while (i < arrayOfString.length)
          {
            localapka.a(arrayOfString[i], j, arrayOfBoolean[i]);
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      a(131, bool, new Object[] { arrayOfString, arrayOfBoolean, Integer.valueOf(j) });
      return;
      boolean bool = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("tag_hidden_chat", 2, "FriendListHandler.handleSetHiddenChatResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_chat_types");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int k;
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
        for (;;)
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
          }
          paramFromServiceMsg.printStackTrace();
          continue;
          paramToServiceMsg.a(null);
        }
        k = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          i = 0;
          for (;;)
          {
            if (i >= arrayOfString.length) {
              break label274;
            }
            paramToServiceMsg = arrayOfString[i];
            k = arrayOfBoolean[i];
            int j = arrayOfInt[i];
            paramToServiceMsg = new FriendsStatusUtil.UpdateFriendStatusItem(paramToServiceMsg, 13581, 21);
            if (k == 0) {
              break;
            }
            paramToServiceMsg.a(new byte[1]);
            FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, null);
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      label274:
      a(130, k, new Object[] { arrayOfString, arrayOfBoolean });
      return;
      int m = 0;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0xc83".equals(str)) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
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
    } while ((!"OidbSvc.0x5d6_18".equals(str)) && (!"OidbSvc.0x5d6_19".equals(str)));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0xc83".equals(paramString)) || ("OidbSvc.0xc85".equals(paramString)) || ("OidbSvc.0x5d6_21".equals(paramString)) || ("OidbSvc.0x5d6_18".equals(paramString)) || ("OidbSvc.0x5d6_19".equals(paramString));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("param_type", -1);
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("param_status_item_list");
    boolean bool = paramToServiceMsg.extraData.getBoolean("param_notify_plugin", false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage serviceType=" + i);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage req failed!");
      }
      FriendsStatusUtil.a(i, false, localArrayList, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage parse oidb_sso.OIDBSSOPkg failed.");
        }
        FriendsStatusUtil.a(i, false, localArrayList, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
        paramFromServiceMsg.printStackTrace();
      }
      int j = paramToServiceMsg.uint32_result.get();
      if (!QLog.isColorLevel()) {
        break label285;
      }
      QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "ssoPkg.uint32_result=" + j);
      label285:
      if (j != 0) {
        break label419;
      }
      paramFromServiceMsg = new oidb_0x5d6.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = paramFromServiceMsg.rpt_msg_update_result.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage resultList null!");
          }
          FriendsStatusUtil.a(i, false, localArrayList, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage res failed!");
        }
        FriendsStatusUtil.a(i, false, localArrayList, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
        paramToServiceMsg.printStackTrace();
        return;
      }
      FriendsStatusUtil.a(i, true, localArrayList, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
      return;
      label419:
      if (!QLog.isColorLevel()) {
        break label435;
      }
      QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage uint32_result failed!");
      label435:
      FriendsStatusUtil.a(i, false, localArrayList, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
    }
    if ((!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage res failed!");
      }
      FriendsStatusUtil.a(i, false, localArrayList, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anis
 * JD-Core Version:    0.7.0.1
 */