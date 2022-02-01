package com.tencent.mobileqq.activity.aio.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;

class DiscussChatPie$8$3
  implements DialogInterface.OnClickListener
{
  DiscussChatPie$8$3(DiscussChatPie.8 param8, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie$8.a.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie$8.a.a.getProxyManager().a();
    RecentUser localRecentUser = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.a(localRecentUser);
    }
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie$8.a.a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie$8.a.K();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.8.3
 * JD-Core Version:    0.7.0.1
 */