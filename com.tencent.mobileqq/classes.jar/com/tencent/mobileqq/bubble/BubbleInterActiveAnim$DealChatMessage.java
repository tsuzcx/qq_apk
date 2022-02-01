package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class BubbleInterActiveAnim$DealChatMessage
{
  private int jdField_a_of_type_Int;
  private BaseBubbleBuilder.ViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private BubbleInterActiveAnim.FindOriginalMsg jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$FindOriginalMsg;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public BubbleInterActiveAnim$DealChatMessage(MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner, boolean paramBoolean, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.b = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
  }
  
  public DealChatMessage a()
  {
    if (!(this.jdField_a_of_type_JavaLangObject instanceof ChatMessage))
    {
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    Object localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(), this.jdField_a_of_type_Int));
    if ((localObject instanceof BaseBubbleBuilder.ViewHolder)) {
      localObject = (BaseBubbleBuilder.ViewHolder)localObject;
    } else {
      localObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject);
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$FindOriginalMsg = new BubbleInterActiveAnim.FindOriginalMsg(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.b, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$FindOriginalMsg.a())
    {
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public BubbleInterActiveAnim.FindOriginalMsg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$FindOriginalMsg;
  }
  
  public ChatMessage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.DealChatMessage
 * JD-Core Version:    0.7.0.1
 */