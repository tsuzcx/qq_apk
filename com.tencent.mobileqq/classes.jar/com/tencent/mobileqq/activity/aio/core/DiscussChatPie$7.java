package com.tencent.mobileqq.activity.aio.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;

class DiscussChatPie$7
  implements DialogInterface.OnClickListener
{
  DiscussChatPie$7(DiscussChatPie paramDiscussChatPie, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie.a.getProxyManager().a();
    RecentUser localRecentUser = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.a(localRecentUser);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreDiscussChatPie.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.7
 * JD-Core Version:    0.7.0.1
 */