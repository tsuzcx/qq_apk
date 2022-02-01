package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;

public class MsgListBuilder
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private UnreadTask jdField_a_of_type_ComTencentMobileqqActivityAioCoreUnreadTask;
  private BaseMsgLoader jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader;
  private MsgListRefresher jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher;
  private ListUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI;
  private Scroller jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller;
  
  public MsgListBuilder(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public MsgList a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader = new BaseMsgLoader();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher = new MsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    }
    return new MsgList(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreUnreadTask, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher);
  }
  
  public MsgListBuilder a(UnreadTask paramUnreadTask)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreUnreadTask = paramUnreadTask;
    return this;
  }
  
  public MsgListBuilder a(BaseMsgLoader paramBaseMsgLoader)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader = paramBaseMsgLoader;
    return this;
  }
  
  public MsgListBuilder a(MsgListRefresher paramMsgListRefresher)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher = paramMsgListRefresher;
    return this;
  }
  
  public MsgListBuilder a(ListUI paramListUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI = paramListUI;
    return this;
  }
  
  public MsgListBuilder a(Scroller paramScroller)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller = paramScroller;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder
 * JD-Core Version:    0.7.0.1
 */