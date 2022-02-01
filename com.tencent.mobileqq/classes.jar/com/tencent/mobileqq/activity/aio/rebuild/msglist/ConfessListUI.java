package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.ConfessRefresher;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.app.QQAppInterface;

public class ConfessListUI
  extends ListUI
{
  public ConfessListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.f > 0) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.a = new ConfessRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a.getMessageFacade().a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessListUI
 * JD-Core Version:    0.7.0.1
 */