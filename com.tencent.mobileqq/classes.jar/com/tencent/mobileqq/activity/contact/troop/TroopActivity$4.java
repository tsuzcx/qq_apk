package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class TroopActivity$4
  implements View.OnClickListener
{
  TroopActivity$4(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    int i = GroupSystemMsgController.a().a(this.a.app);
    MqqHandler localMqqHandler1 = this.a.app.getHandler(NotificationView.class);
    MqqHandler localMqqHandler2 = this.a.app.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendEmptyMessage(1014);
    }
    if (localMqqHandler2 != null) {
      localMqqHandler2.sendEmptyMessage(1014);
    }
    this.a.app.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, -i);
    ((RecentManagerFor3rdPart)this.a.app.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART)).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
    localMqqHandler1 = this.a.app.getHandler(Conversation.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendMessage(localMqqHandler1.obtainMessage(1009));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.4
 * JD-Core Version:    0.7.0.1
 */