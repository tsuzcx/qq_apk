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
  public QQCustomDialog a = null;
  public QQProgressDialog b = null;
  private HotChatObserver c = null;
  private Conversation d = null;
  
  public ConversationHotChatCtrl(Conversation paramConversation)
  {
    this.d = paramConversation;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.b = null;
    }
    if (this.c != null) {
      this.d.s().removeObserver(this.c);
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    QQAppInterface localQQAppInterface = this.d.s();
    BaseActivity localBaseActivity = (BaseActivity)this.d.P();
    HotChatManager localHotChatManager = localQQAppInterface.getHotChatMng(false);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramRecentUser.uin)))
    {
      localHotChatManager.g(paramRecentUser.uin);
      HotChatInfo localHotChatInfo = localHotChatManager.c(paramRecentUser.uin);
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
          if (this.c == null) {
            this.c = new ConversationHotChatCtrl.1(this, localBaseActivity);
          }
          this.a = HotChatHelper.a(localHotChatManager.c(paramRecentUser.uin), new ConversationHotChatCtrl.2(this, localHotChatInfo, localQQAppInterface, localBaseActivity));
        }
      }
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationHotChatCtrl
 * JD-Core Version:    0.7.0.1
 */