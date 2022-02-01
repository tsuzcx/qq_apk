import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.friendlist.receiver.MakeFriendReceiver.1;
import com.tencent.mobileqq.app.friendlist.receiver.MakeFriendReceiver.2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddFriendResp;
import friendlist.DelFriendResp;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.friend.AddContactVerifyInfo.AddFriendVerifyInfo;
import tencent.im.oidb.cmd0x829.oidb_0x829.AddFrdInfo;
import tencent.im.oidb.cmd0x829.oidb_0x829.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aniz
  extends anio
{
  public aniz(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, DelFriendResp paramDelFriendResp)
  {
    if (paramDelFriendResp.errorCode != 0)
    {
      a(15, false, null);
      return;
    }
    paramFromServiceMsg = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.b();
    }
    ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(String.valueOf(paramDelFriendResp.deluin));
    azxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDelFriendResp.deluin + "");
    bdcj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDelFriendResp.deluin + "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(String.valueOf(paramDelFriendResp.deluin), true);
    paramFromServiceMsg = (awhw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.d.put("" + paramDelFriendResp.deluin, Integer.valueOf(1));
    }
    a(15, true, Long.valueOf(paramDelFriendResp.deluin));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int j = paramToServiceMsg.extraData.getInt("bType");
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lToMID"));
    int k = paramToServiceMsg.extraData.getByte("bGroupId");
    int i = j;
    if (j == 1) {
      i = 2;
    }
    if (i == 0)
    {
      paramToServiceMsg.extraData.getString("strNickName");
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.addFriendToFriendList(str, k, 3999, null, false, false, -1L);
    }
    paramToServiceMsg = str + "_answer_added_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
    bful.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramToServiceMsg, i);
    a(10, true, new Object[] { str, Integer.valueOf(i) });
  }
  
  private void a(AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramToServiceMsg.extraData);
    if (paramAddFriendResp == null) {
      a(11, false, localBundle);
    }
    Object localObject;
    for (;;)
    {
      return;
      localBundle.putInt("resultCode", paramAddFriendResp.result);
      localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
      if (paramAddFriendResp.verify != null)
      {
        localObject = new AddContactVerifyInfo.AddFriendVerifyInfo();
        try
        {
          ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).mergeFrom(paramAddFriendResp.verify);
          if (((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_url.has())
          {
            String str1 = ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_url.get();
            if (!TextUtils.isEmpty(str1))
            {
              localBundle.putString("security_check_url", str1);
              localBundle.putString("security_check_buffer", ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_verify_info.get());
              a(120, true, localBundle);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleAddFriend, needSecCheck");
              return;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("FriendListHandler.BaseHandlerReceiver", 1, "handleAddFriend, ", localException);
          }
        }
      }
    }
    if (paramAddFriendResp.result == 0)
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      boolean bool1 = paramToServiceMsg.getBoolean("auto_send", false);
      int j = paramToServiceMsg.getInt("source_id");
      localObject = paramToServiceMsg.getString("uin");
      int k = paramToServiceMsg.getInt("friend_setting");
      boolean bool2 = paramToServiceMsg.getBoolean("contact_bothway");
      String str2 = paramToServiceMsg.getString("remark");
      int i;
      if ((bool1) && (AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, j, bool2))) {
        i = 1;
      }
      for (;;)
      {
        if ((bool1) && (i != 0) && (paramAddFriendResp.adduin != 0L)) {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.addFriendToFriendList(String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid, j, paramToServiceMsg.getString("src_name"), true, false, -1L);
        }
        try
        {
          for (;;)
          {
            ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a().a((String)localObject);
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("$handleAddFriend|autoSend=").append(bool1).append(",uin").append(paramAddFriendResp.adduin).append(",sourceId=").append(j).append(",beBothWay=").append(bool2).append(",successDirectly=").append(AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, j, bool2));
              QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
            }
            localBundle.putByteArray("sig", paramAddFriendResp.sig);
            localBundle.putString("result_uin", String.valueOf(paramAddFriendResp.adduin));
            if ((!bool1) || (i == 0)) {
              break label532;
            }
            bool1 = true;
            localBundle.putBoolean("addDirect", bool1);
            a(11, true, localBundle);
            return;
            i = 0;
            break;
            if (boex.a(j)) {
              ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a((String)localObject, k, str2);
            }
          }
        }
        catch (Throwable paramToServiceMsg)
        {
          for (;;)
          {
            paramToServiceMsg.printStackTrace();
            continue;
            label532:
            bool1 = false;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "ErrorString" + paramAddFriendResp.ErrorString + "resultCode" + paramAddFriendResp.result);
    }
    a(11, true, localBundle);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((QLog.isColorLevel()) && (paramFromServiceMsg != null)) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend sso resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool2;
    oidb_0x829.RspBody localRspBody;
    ArrayList localArrayList1;
    int j;
    ArrayList localArrayList2;
    String str;
    int k;
    int m;
    PhoneContactManagerImp localPhoneContactManagerImp;
    boolean bool1;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      localRspBody = new oidb_0x829.RspBody();
      localArrayList1 = (ArrayList)paramToServiceMsg.extraData.getSerializable("phones");
      j = Integer.valueOf(paramToServiceMsg.extraData.getInt("package", -1)).intValue();
      localArrayList2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("resultList");
      str = paramToServiceMsg.extraData.getString("verifyMsg");
      k = Integer.valueOf(paramToServiceMsg.extraData.getInt("sourceId")).intValue();
      m = j * 30;
      localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      bool1 = bool2;
      if (bool2)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        paramToServiceMsg = FriendListHandler.parseSSOPkg(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if (paramToServiceMsg == null) {
          break label484;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend oidb result code: " + i);
        }
        if (i != 0) {
          break label451;
        }
        bool2 = true;
        label251:
        bool1 = bool2;
        if (!bool2) {}
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool1 = bool2;
      }
      catch (Exception paramToServiceMsg)
      {
        label451:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend RspBody mergeFrom failed.");
        bool1 = false;
        paramToServiceMsg.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend isSuccess: " + bool1);
      }
      if (!bool1) {
        break label563;
      }
      if (!localRspBody.rpt_add_frd_info.has()) {
        break label490;
      }
      i = 0;
      if (i >= localRspBody.rpt_add_frd_info.size()) {
        break label490;
      }
      paramToServiceMsg = (oidb_0x829.AddFrdInfo)localRspBody.rpt_add_frd_info.get(i);
      paramFromServiceMsg = new FriendListHandler.AddBatchPhoneFriendResult();
      paramFromServiceMsg.mobile = paramToServiceMsg.bytes_mobile.get().toStringUtf8();
      paramFromServiceMsg.remark = paramToServiceMsg.bytes_remark.get().toStringUtf8();
      paramFromServiceMsg.allowType = paramToServiceMsg.uint32_allow_type.get();
      paramFromServiceMsg.sendReqFlag = paramToServiceMsg.uint32_send_req_flag.get();
      paramFromServiceMsg.sendResult = paramToServiceMsg.uint32_send_result.get();
      localArrayList2.add(paramFromServiceMsg);
      i += 1;
      continue;
      bool2 = false;
      break;
      bool2 = false;
      break label251;
      label484:
      bool1 = false;
    }
    label490:
    if ((j != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (m < localArrayList1.size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new MakeFriendReceiver.1(this, localArrayList1, str, j, k, localArrayList2));
      return;
    }
    localPhoneContactManagerImp.a(localArrayList1, localArrayList2, k);
    a(110, true, localArrayList2);
    return;
    label563:
    if ((j != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (m < localArrayList1.size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new MakeFriendReceiver.2(this, localArrayList1, str, j, k, localArrayList2));
      return;
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localPhoneContactManagerImp.a(localArrayList1, localArrayList2, k);
      a(110, true, localArrayList2);
      return;
    }
    a(110, false, null);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("friendlist.addFriend".equals(str)) {
      a((AddFriendResp)paramObject, paramToServiceMsg);
    }
    do
    {
      return;
      if ("friendlist.delFriend".equals(str))
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (DelFriendResp)paramObject);
          return;
        }
        a(15, false, null);
        return;
      }
      if ("BumpSvc.ReqComfirmContactFriend".equals(str))
      {
        if (paramFromServiceMsg.isSuccess())
        {
          a(paramToServiceMsg, true);
          return;
        }
        a(10, false, null);
        return;
      }
    } while (!"OidbSvc.0x829_1".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean a(String paramString)
  {
    return ("friendlist.addFriend".equals(paramString)) || ("friendlist.delFriend".equals(paramString)) || ("BumpSvc.ReqComfirmContactFriend".equals(paramString)) || ("OidbSvc.0x829_1".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aniz
 * JD-Core Version:    0.7.0.1
 */