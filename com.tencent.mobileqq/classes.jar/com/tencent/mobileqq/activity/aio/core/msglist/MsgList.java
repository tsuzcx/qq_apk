package com.tencent.mobileqq.activity.aio.core.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;

public class MsgList
{
  private final UnreadTask jdField_a_of_type_ComTencentMobileqqActivityAioCoreUnreadTask;
  private final BaseMsgLoader jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader;
  private final MsgListRefresher jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher;
  private final ListUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI;
  private final Scroller jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller;
  private final MsgListRegister jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistMsgListRegister;
  
  MsgList(@NonNull AIOContext paramAIOContext, @NonNull ListUI paramListUI, @NonNull Scroller paramScroller, @NonNull BaseMsgLoader paramBaseMsgLoader, @NonNull UnreadTask paramUnreadTask, @NonNull MsgListRefresher paramMsgListRefresher)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI = paramListUI;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller = paramScroller;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader = paramBaseMsgLoader;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreUnreadTask = paramUnreadTask;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher = paramMsgListRefresher;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistMsgListRegister = new MsgListRegister(paramAIOContext);
    paramMsgListRefresher.a(paramListUI);
  }
  
  public UnreadTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreUnreadTask;
  }
  
  public BaseMsgLoader a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistMsgListRegister.a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistBaseMsgLoader;
  }
  
  public MsgListRefresher a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgListRefresher;
  }
  
  public ListUI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI;
  }
  
  public Scroller a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller;
  }
  
  public MsgListRegister a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMsglistMsgListRegister;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgList
 * JD-Core Version:    0.7.0.1
 */