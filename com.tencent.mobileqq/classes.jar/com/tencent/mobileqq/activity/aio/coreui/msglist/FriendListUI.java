package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.C2CMessageManager.C2CReplyContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class FriendListUI
  extends ListUI
{
  C2CMessageManager.C2CReplyContext a;
  
  public FriendListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a()
  {
    ThreadManager.post(new FriendListUI.1(this), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext.a(paramLong1, paramLong2, paramBoolean);
  }
  
  public void a(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    super.a(paramChatXListView, paramChatAdapter1);
    this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext = new C2CMessageManager.C2CReplyContext();
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext != null) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher != null))
    {
      ((C2CRoamMsgFetcher)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher).a();
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher = null;
    }
  }
  
  public void c()
  {
    super.c();
    if (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIRoamMsgFetcher = new C2CRoamMsgFetcher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListUI", 2, "FriendChatPie onViewCompleteVisableAndReleased");
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)) || (!Utils.b(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext.b)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext, this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageManager$C2CReplyContext.b = false;
        return true;
      }
      super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
      return true;
    }
    a(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI
 * JD-Core Version:    0.7.0.1
 */