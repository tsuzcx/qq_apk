import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.SetRichSigRes;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetAutoInfoResp;
import friendlist.GetOnlineInfoResp;
import friendlist.GetUserAddFriendSettingResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.RspBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.UdcUinData;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.BindContactsFriendInfo;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aniu
  extends anio
{
  private short a;
  
  public aniu(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
    this.jdField_a_of_type_Short = 20002;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, CheckUpdateResp paramCheckUpdateResp)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && (QLog.isColorLevel())) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate ok resultcode = " + paramFromServiceMsg.getResultCode());
    }
    if (((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && (QLog.isColorLevel())) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate timeout resultcode = " + paramFromServiceMsg.getResultCode());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.handleCheckUpdate(paramCheckUpdateResp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager();
    if ((anux.a) && (bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (!bbgh.b()) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a(i);
      if (i != 1) {
        break;
      }
      bgbo.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a();
      return;
    }
    bgbo.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleInfoOpenId ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label221;
      }
    }
    label221:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, i);
      paramToServiceMsg = paramToServiceMsg.extraData;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        paramArrayOfByte = new oidb_0x5e1.RspBody();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
          break;
        }
        paramFromServiceMsg = new String(((oidb_0x5e1.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0)).bytes_nick.get().toByteArray());
        paramToServiceMsg.putString("nick_name", paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleInfoOpenId " + paramFromServiceMsg);
        }
        bool1 = true;
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "", paramFromServiceMsg);
            bool1 = bool2;
            continue;
            bool1 = false;
          }
        }
      }
      a(74, bool1, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    if ((paramGetUserAddFriendSettingResp != null) && (paramGetUserAddFriendSettingResp.result == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleAddFriendSetting " + paramGetUserAddFriendSettingResp.queryuinsetting + ", " + paramGetUserAddFriendSettingResp.contact_bothway_friend + ", " + paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      }
      paramToServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramToServiceMsg.putLong("query_friend_uin", paramGetUserAddFriendSettingResp.queryuin);
      paramToServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramToServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      a(12, true, paramToServiceMsg);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleAddFriendSetting ");
      if (paramGetUserAddFriendSettingResp == null) {
        break label176;
      }
    }
    label176:
    for (int i = paramGetUserAddFriendSettingResp.result;; i = -10000)
    {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, i);
      a(12, false, paramToServiceMsg);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    paramObject = (GetAutoInfoResp)paramObject;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (paramObject.errorCode == 0))
    {
      paramToServiceMsg.putInt("group_id", paramObject.cGroupID);
      paramToServiceMsg.putString("nick_name", paramObject.strRemark);
      a(33, true, paramToServiceMsg);
      return;
    }
    a(33, false, paramToServiceMsg);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = true;
    String str1 = paramToServiceMsg.extraData.getString("uin");
    String str2 = paramToServiceMsg.extraData.getString("com_value");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("notify_plugin");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str1;
    paramToServiceMsg[1] = str2;
    if (1000 == paramFromServiceMsg.getResultCode())
    {
      paramFromServiceMsg = (ChangeFriendNameRes)paramObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.cResult == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(str1, str2, true);
        paramToServiceMsg[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        a(27, true, paramToServiceMsg);
        if (bool2)
        {
          paramToServiceMsg = new Intent("action_set_remark_plugin");
          paramToServiceMsg.putExtra("uin", str1);
          paramToServiceMsg.putExtra("remark", str2);
          paramToServiceMsg.putExtra("is_suc", bool1);
          BaseApplicationImpl.getContext().sendBroadcast(paramToServiceMsg);
        }
        return;
      }
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        label178:
        a(27, false, paramToServiceMsg);
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      paramToServiceMsg[2] = Byte.valueOf(-1);
      break label178;
      paramToServiceMsg[2] = Byte.valueOf(-1);
      a(27, false, paramToServiceMsg);
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SetRichSigRes)paramObject;
      if (paramObject.cResult == 0)
      {
        amsw localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localamsw != null)
        {
          byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("sig_value");
          if (paramObject.dwTime == 0L) {
            paramObject.dwTime = 1L;
          }
          paramFromServiceMsg = localamsw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          }
          if (paramToServiceMsg.timestamp != paramObject.dwTime)
          {
            paramToServiceMsg.setRichBuffer(arrayOfByte, paramObject.dwTime);
            localamsw.a(paramToServiceMsg);
          }
        }
        a(28, true, null);
        return;
      }
      a(28, false, Integer.valueOf(paramObject.cResult));
      return;
    }
    a(28, false, null);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new cmd0xcf0.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int j = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int i;
    if (j == 0)
    {
      i = paramToServiceMsg.uint32_total_bind_contacts_frd_num.get();
      paramToServiceMsg = paramToServiceMsg.rpt_msg_bind_contacts_frds.get();
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramFromServiceMsg = new ArrayList(paramToServiceMsg.size());
        paramObject = paramToServiceMsg.iterator();
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (!paramObject.hasNext()) {
            break;
          }
          paramToServiceMsg = (cmd0xcf0.BindContactsFriendInfo)paramObject.next();
          if ((paramToServiceMsg != null) && (paramToServiceMsg.uint64_uin.get() != 0L)) {
            paramFromServiceMsg.add(String.valueOf(paramToServiceMsg.uint64_uin.get()));
          }
        }
      }
      paramToServiceMsg = null;
      paramFromServiceMsg = (avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(i, paramToServiceMsg);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg == null)
        {
          paramFromServiceMsg = "null";
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, String.format("handleGetFriendsHasBindPhone [%s, %s, %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramFromServiceMsg }));
        }
      }
      else {
        if (j != 0) {
          break label259;
        }
      }
      label259:
      for (boolean bool = true;; bool = false)
      {
        a(121, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        return;
        paramFromServiceMsg = Integer.valueOf(paramToServiceMsg.size());
        break;
      }
      i = 0;
      paramToServiceMsg = null;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch success=" + bool);
      }
      if (!bool) {}
    }
    label783:
    label789:
    label795:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label783;
        }
        bool = true;
        if (!paramToServiceMsg.uint32_result.has()) {
          break label789;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch result=" + bool);
        }
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i = paramToServiceMsg.get();
          int k = paramToServiceMsg.getInt();
          j = paramToServiceMsg.getShort();
          paramFromServiceMsg = new HashMap(j);
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch cNickCut=" + i + " dwNextUin=" + k + " wSimpleInfoNum=" + j);
          }
          if (k == -1)
          {
            paramObject = new StringBuffer();
            i = 0;
            if (i < j)
            {
              String str = String.valueOf(bftf.a(paramToServiceMsg.getInt()));
              k = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldNum=");
                paramObject.append(k);
              }
              if (k != 1) {
                break label767;
              }
              k = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldID=");
                paramObject.append(k);
              }
              if (k != this.jdField_a_of_type_Short) {
                break label767;
              }
              Object localObject = new byte[paramToServiceMsg.getShort()];
              paramToServiceMsg.get((byte[])localObject);
              localObject = new String((byte[])localObject);
              if (QLog.isColorLevel())
              {
                paramObject.append(" uin=");
                paramObject.append(str.substring(0, 4));
                paramObject.append(" nick=");
                paramObject.append(bftf.a((String)localObject));
              }
              paramFromServiceMsg.put(str, localObject);
              break label767;
            }
            if (!QLog.isColorLevel()) {
              break label795;
            }
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramObject.toString());
            break label795;
            a(75, bool, paramFromServiceMsg);
            return;
          }
          bool = false;
          continue;
        }
        j = i;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
          i = j;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        j = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch e", paramToServiceMsg);
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i = j;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        j = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch ex", paramToServiceMsg);
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i = j;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
      }
      a(75, false, Integer.valueOf(i));
      return;
      int j = 0;
      continue;
      label767:
      int i = (short)(i + 1);
      continue;
      bool = false;
      break;
      bool = false;
      continue;
      i = -1;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType", 1L);
    if (l == 0L)
    {
      paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("dwUin"));
      if (paramObject != null) {
        break label76;
      }
      a(68, false, new Object[] { Long.valueOf(l), paramToServiceMsg });
    }
    label76:
    while (!(paramObject instanceof GetOnlineInfoResp))
    {
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("strMobile");
      break;
    }
    paramFromServiceMsg = (GetOnlineInfoResp)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleOnlineInfo, uin = " + StringUtil.getSimpleUinForPrint(paramToServiceMsg) + ", result = " + paramFromServiceMsg.result + ", itermType = " + paramFromServiceMsg.iTermType + ", netType = " + paramFromServiceMsg.eNetworkType + ", abi = " + paramFromServiceMsg.uAbiFlag + ", status = " + paramFromServiceMsg.dwStatus + ", strTermDesc = " + paramFromServiceMsg.strTermDesc);
    }
    if ((l == 0L) && (paramFromServiceMsg.result == 0)) {
      ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      paramFromServiceMsg.dwInterval *= 1000L;
      if (paramFromServiceMsg.dwInterval < 15000L) {
        paramFromServiceMsg.dwInterval = 15000L;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.intervalGetOnlineInfo = paramFromServiceMsg.dwInterval;
      a(68, true, new Object[] { Long.valueOf(l), paramToServiceMsg, paramFromServiceMsg });
      return;
      if ((l == 1L) && (paramFromServiceMsg.result == 0)) {
        ((avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("friendlist.GetAutoInfoReq".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      do
      {
        return;
        if ("ProfileService.ChangeFriendName".equals(str))
        {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("ProfileService.SetRichSig".equals(str))
        {
          e(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x77c".equals(str));
      if ("friendlist.getUserAddFriendSetting".equals(str))
      {
        a(paramToServiceMsg, (GetUserAddFriendSettingResp)paramObject);
        return;
      }
      if ("ProfileService.CheckUpdateReq".equals(str))
      {
        a(paramFromServiceMsg, (CheckUpdateResp)paramObject);
        return;
      }
      if ("OidbSvc.0xcf0_0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5e1_8".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("OidbSvc.0x49d_107".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"friendlist.GetOnlineInfoReq".equals(str));
    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean a(String paramString)
  {
    return ("friendlist.GetAutoInfoReq".equals(paramString)) || ("ProfileService.ChangeFriendName".equals(paramString)) || ("ProfileService.SetRichSig".equals(paramString)) || ("OidbSvc.0x77c".equals(paramString)) || ("friendlist.getUserAddFriendSetting".equals(paramString)) || ("ProfileService.CheckUpdateReq".equals(paramString)) || ("OidbSvc.0xcf0_0".equals(paramString)) || ("OidbSvc.0x5e1_8".equals(paramString)) || ("OidbSvc.0x49d_107".equals(paramString)) || ("friendlist.GetOnlineInfoReq".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aniu
 * JD-Core Version:    0.7.0.1
 */