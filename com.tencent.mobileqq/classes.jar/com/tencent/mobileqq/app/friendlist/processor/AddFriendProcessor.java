package com.tencent.mobileqq.app.friendlist.processor;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddFriendResp;
import friendlist.EAddFriendSourceID;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class AddFriendProcessor
  extends BaseFriendProcessor
{
  public AddFriendProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onAddFriendSuccess(AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendProcessor", 2, "onAddFriendSuccess called");
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    int j = 0;
    boolean bool1 = paramToServiceMsg.getBoolean("auto_send", false);
    int k = paramToServiceMsg.getInt("source_id");
    String str1 = paramToServiceMsg.getString("uin");
    int m = paramToServiceMsg.getInt("friend_setting");
    boolean bool2 = paramToServiceMsg.getBoolean("contact_bothway");
    String str2 = paramToServiceMsg.getString("remark");
    int i = j;
    if (bool1)
    {
      i = j;
      if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(paramAddFriendResp.adduinsetting, k, bool2)) {
        i = 1;
      }
    }
    if ((bool1) && (i != 0) && (paramAddFriendResp.adduin != 0L)) {
      ((FriendListHandler)((AppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid, k, paramToServiceMsg.getString("src_name"), true, false, -1L);
    } else if (EAddFriendSourceID.a(k)) {
      ((IPhoneContactService)this.mApp.getRuntimeService(IPhoneContactService.class, "")).makePhoneContactAddInfo(str1, m, str2);
    }
    try
    {
      ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a().a(str1);
      return;
    }
    catch (Throwable paramAddFriendResp)
    {
      paramAddFriendResp.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.AddFriendProcessor
 * JD-Core Version:    0.7.0.1
 */