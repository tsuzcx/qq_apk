package com.tencent.imcore.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.api.IOnLinePushMessageProcessorService;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.ContactUtils;

public class OnLinePushMessageProcessorServiceImpl
  implements IOnLinePushMessageProcessorService
{
  public void changeBuddyOnline(AppInterface paramAppInterface, long paramLong)
  {
    ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramLong);
  }
  
  public String getPhoneNumByUin(AppInterface paramAppInterface, String paramString)
  {
    return ContactUtils.c(paramAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.api.impl.OnLinePushMessageProcessorServiceImpl
 * JD-Core Version:    0.7.0.1
 */