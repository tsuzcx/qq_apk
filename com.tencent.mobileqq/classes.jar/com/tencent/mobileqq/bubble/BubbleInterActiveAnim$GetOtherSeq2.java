package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class BubbleInterActiveAnim$GetOtherSeq2
{
  private long jdField_a_of_type_Long;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BubbleConfig jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private BubbleConfig jdField_b_of_type_ComTencentMobileqqBubbleBubbleConfig;
  private String jdField_b_of_type_JavaLangString;
  
  public BubbleInterActiveAnim$GetOtherSeq2(MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, String paramString1, BubbleConfig paramBubbleConfig1, long paramLong1, long paramLong2, ChatMessage paramChatMessage, String paramString2, BubbleConfig paramBubbleConfig2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig = paramBubbleConfig1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleConfig = paramBubbleConfig2;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public GetOtherSeq2 a()
  {
    boolean bool = BubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleConfig);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (bool))
    {
      if (this.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
      }
      this.jdField_b_of_type_Long = BubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Long != -1L) && (this.jdField_b_of_type_Long != -1L))
    {
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.GetOtherSeq2
 * JD-Core Version:    0.7.0.1
 */