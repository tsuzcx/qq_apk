package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopActivity$6
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    paramView = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
    long l = 0L;
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    case 0: 
      for (i = 0;; i = 1)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, -paramInt);
        paramView = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART);
        if (i == 0) {
          break;
        }
        paramView.a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(Conversation.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(1009));
        }
        return;
        paramInt = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(NotificationView.class);
        MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(TroopNotifyAndRecommendView.class);
        if (paramView != null) {
          paramView.sendEmptyMessage(1014);
        }
        if (localMqqHandler != null) {
          localMqqHandler.sendEmptyMessage(1014);
        }
      }
    }
    paramInt = i;
    if (paramView != null)
    {
      i = RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
      paramView.c();
      paramView.b();
      paramView.a(1);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(TroopNotifyAndRecommendView.class);
      paramInt = i;
      if (paramView != null)
      {
        paramView.sendEmptyMessage(105);
        paramInt = i;
      }
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getMessageFacade().b(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
    if ((paramView == null) || (paramView.size() == 0)) {
      l = 0L;
    }
    for (i = 1;; i = 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app, "CliOper", "", "", "Grp_recommend", "Grp_recom_empty", 0, 0, "", "", "", "");
      ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_del", 0, 0, "", "", "", "");
      break;
      l = ((MessageForSystemMsg)paramView.get(paramView.size() - 1)).getSystemMsg().msg_time.get() * 1000L;
    }
    paramView.a(AppConstants.TROOP_NOTIFICATION_UIN, 9000, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.6
 * JD-Core Version:    0.7.0.1
 */