package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class DiscussListUI
  extends ListUI
{
  public DiscussListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussListUI", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_a_of_type_Long);
      paramListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      if (paramListView != null)
      {
        if (paramListView.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, paramListView.jdField_a_of_type_Long, paramListView.jdField_b_of_type_Long, paramListView.c, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
          paramListView.j();
          return true;
        }
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = false;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.f = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.f = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    a(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.DiscussListUI
 * JD-Core Version:    0.7.0.1
 */