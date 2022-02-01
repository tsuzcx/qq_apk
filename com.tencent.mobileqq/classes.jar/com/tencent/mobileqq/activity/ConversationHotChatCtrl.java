package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.app.Constants.LogoutReason;

public class ConversationHotChatCtrl
{
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = null;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = null;
  public QQCustomDialog a;
  public QQProgressDialog a;
  
  public ConversationHotChatCtrl(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    HotChatManager localHotChatManager = localQQAppInterface.getHotChatMng(false);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramRecentUser.uin)))
    {
      localHotChatManager.a(paramRecentUser.uin);
      HotChatInfo localHotChatInfo = localHotChatManager.a(paramRecentUser.uin);
      if (localHotChatInfo != null)
      {
        int i;
        if (localHotChatInfo.state != 0)
        {
          if (localHotChatInfo.isWifiHotChat) {
            i = 1;
          } else {
            i = 2;
          }
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004D2A", "0X8004D2A", i, 0, "", "", "", "");
          return;
        }
        if (localHotChatInfo.adminLevel == 0)
        {
          if ((localHotChatInfo.ownerUin != null) && (localHotChatInfo.ownerUin.equals(localQQAppInterface.getCurrentAccountUin()))) {
            return;
          }
          if (localHotChatInfo.isWifiHotChat) {
            i = 1;
          } else {
            i = 2;
          }
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004D29", "0X8004D29", i, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new ConversationHotChatCtrl.1(this, localBaseActivity);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = HotChatHelper.a(localHotChatManager.a(paramRecentUser.uin), new ConversationHotChatCtrl.2(this, localHotChatInfo, localQQAppInterface, localBaseActivity));
        }
      }
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationHotChatCtrl
 * JD-Core Version:    0.7.0.1
 */