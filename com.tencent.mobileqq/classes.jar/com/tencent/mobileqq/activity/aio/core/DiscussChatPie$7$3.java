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

class DiscussChatPie$7$3
  implements DialogInterface.OnClickListener
{
  DiscussChatPie$7$3(DiscussChatPie.7 param7, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((DiscussionManager)this.b.a.d.getManager(QQManagerFactory.DISCUSSION_MANAGER)).g(this.a);
    paramDialogInterface = this.b.a.d.getProxyManager().g();
    RecentUser localRecentUser = paramDialogInterface.c(this.a, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.a(localRecentUser);
    }
    ((DiscussionHandler)this.b.a.d.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b();
    this.b.a.L();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.7.3
 * JD-Core Version:    0.7.0.1
 */