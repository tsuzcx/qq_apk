package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.tofumsg.TofuHelper;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import friendlist.DelFriendResp;
import java.util.concurrent.ConcurrentHashMap;

public class MakeFriendReceiver
  extends BaseHandlerReceiver
{
  public MakeFriendReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
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
    paramFromServiceMsg = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.onFriendListChanged();
    }
    ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(String.valueOf(paramDelFriendResp.deluin));
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDelFriendResp.deluin);
    localStringBuilder.append("");
    IceBreakingUtil.a(paramFromServiceMsg, localStringBuilder.toString());
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDelFriendResp.deluin);
    localStringBuilder.append("");
    TofuHelper.a(paramFromServiceMsg, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(String.valueOf(paramDelFriendResp.deluin), true);
    paramFromServiceMsg = (INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    if (paramFromServiceMsg != null)
    {
      paramFromServiceMsg = paramFromServiceMsg.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramDelFriendResp.deluin);
      paramFromServiceMsg.put(localStringBuilder.toString(), Integer.valueOf(1));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_answer_added_");
    localStringBuilder.append(paramToServiceMsg.extraData.getLong("infotime", 0L));
    localStringBuilder.append(paramToServiceMsg.extraData.getLong("dbid", 0L));
    paramToServiceMsg = localStringBuilder.toString();
    ContactConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramToServiceMsg, i);
    a(10, true, new Object[] { str, Integer.valueOf(i) });
  }
  
  public boolean a(String paramString)
  {
    return ("friendlist.delFriend".equals(paramString)) || ("BumpSvc.ReqComfirmContactFriend".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.MakeFriendReceiver
 * JD-Core Version:    0.7.0.1
 */