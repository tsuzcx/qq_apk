package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class AIOSearchBarHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private C2CMessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog;
  private TroopAllMessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog;
  private MessageRoamManager jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
  private boolean jdField_a_of_type_Boolean;
  
  AIOSearchBarHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    boolean bool;
    if ((!(paramBaseChatPie instanceof FriendChatPie)) && (!(paramBaseChatPie instanceof TroopChatPie))) {
      bool = false;
    } else {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent().getExtras();
    if (localObject == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("uin");
    localSessionInfo.jdField_a_of_type_Int = ((Bundle)localObject).getInt("uintype");
    localSessionInfo.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("troop_uin");
    localSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    localSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject instanceof FriendChatPie))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog = new C2CMessageSearchDialog(((BaseChatPie)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.l());
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.a.setOnItemLongClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.a.setOnItemClickListener(new AIOSearchBarHelper.2(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog = new TroopAllMessageSearchDialog(((BaseChatPie)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.l());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.a.setOnItemLongClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.a.setOnItemClickListener(new AIOSearchBarHelper.3(this));
  }
  
  private void a(MessageItem paramMessageItem)
  {
    paramMessageItem = paramMessageItem.a;
    if ((paramMessageItem instanceof ChatMessage))
    {
      MultiMsgManager.a().b((ChatMessage)paramMessageItem, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramMessageItem.time;
    int i = paramMessageItem.istroop;
    long l2 = paramMessageItem.shmsgseq;
    if (i == 1) {
      l1 = l2;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(l1);
  }
  
  public String getTag()
  {
    return "AIOSearchBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369231) && (this.jdField_a_of_type_Boolean))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject;
      if (paramInt != 4)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15) {
            return;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
          if (localObject != null) {
            ((MessageRoamManager)localObject).a(hashCode());
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog;
          if ((localObject != null) && (((TroopAllMessageSearchDialog)localObject).isShowing()))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.dismiss();
            this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog = null;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog;
          if ((localObject != null) && (((C2CMessageSearchDialog)localObject).isShowing()))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.dismiss();
            this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog = null;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent().getExtras();
        if (localObject == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager = ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
        ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, (Bundle)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper
 * JD-Core Version:    0.7.0.1
 */