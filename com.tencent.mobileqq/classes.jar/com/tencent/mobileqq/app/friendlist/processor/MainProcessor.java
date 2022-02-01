package com.tencent.mobileqq.app.friendlist.processor;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MainProcessor
  extends BaseFriendProcessor
{
  public MainProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onGetFriendInfoFinish(String paramString)
  {
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.d("IMCore.friend.MainProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
    }
    do
    {
      return;
      paramString = (PhoneContactManager)((QQAppInterface)this.mApp).getManager(QQManagerFactory.CONTACT_MANAGER);
    } while (paramString == null);
    paramString.f();
  }
  
  public void onGetFriendListFinish(boolean paramBoolean, ArrayList<String> paramArrayList, ExtRspData paramExtRspData)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.d("IMCore.friend.MainProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    paramArrayList = (QQAppInterface)this.mApp;
    paramExtRspData = (PhoneContactManagerImp)paramArrayList.getManager(QQManagerFactory.CONTACT_MANAGER);
    paramExtRspData.f();
    if (!paramBoolean) {
      paramExtRspData.b();
    }
    paramArrayList.notifyFriendListSynced();
    ((FriendListHandler)paramArrayList.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getGatheredContactsList(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.MainProcessor
 * JD-Core Version:    0.7.0.1
 */