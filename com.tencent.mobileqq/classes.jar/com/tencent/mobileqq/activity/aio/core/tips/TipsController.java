package com.tencent.mobileqq.activity.aio.core.tips;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister;
import com.tencent.mobileqq.data.MessageRecord;

public class TipsController
{
  protected final AIOContext a;
  private MessageTips jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsMessageTips;
  private final MsgBox jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsMsgBox;
  private final TipsUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsTipsUI;
  private final TipsRegister jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTipsTipsRegister;
  
  public TipsController(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTipsTipsRegister = new TipsRegister(paramAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsMsgBox = new MsgBox(paramAIOContext, a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsTipsUI = new TipsUI(paramAIOContext);
  }
  
  public MessageTips a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsMessageTips == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsMessageTips = new MessageTips(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsMessageTips;
  }
  
  public MsgBox a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsMsgBox;
  }
  
  public TipsUI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsTipsUI;
  }
  
  public TipsRegister a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTipsTipsRegister;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsMsgBox.a();
  }
  
  public void a(MessageRecord paramMessageRecord, Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsMsgBox.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramMessageRecord, paramMessage);
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsMsgBox.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsTipsUI.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiTipsMsgBox.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.tips.TipsController
 * JD-Core Version:    0.7.0.1
 */