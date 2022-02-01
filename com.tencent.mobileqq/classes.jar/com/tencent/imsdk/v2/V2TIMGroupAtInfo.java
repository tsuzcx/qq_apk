package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationAtInfo;
import java.io.Serializable;

public class V2TIMGroupAtInfo
  implements Serializable
{
  public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
  public static final int TIM_AT_ALL = 2;
  public static final int TIM_AT_ALL_AT_ME = 3;
  public static final int TIM_AT_ME = 1;
  public static final int TIM_AT_UNKNOWN = 0;
  private ConversationAtInfo conversationAtInfo;
  
  public int getAtType()
  {
    ConversationAtInfo localConversationAtInfo = this.conversationAtInfo;
    if (localConversationAtInfo == null) {
      return 0;
    }
    return localConversationAtInfo.getAtType();
  }
  
  public long getSeq()
  {
    ConversationAtInfo localConversationAtInfo = this.conversationAtInfo;
    if (localConversationAtInfo == null) {
      return -1L;
    }
    return localConversationAtInfo.getAtMessageSequence();
  }
  
  protected void setConversationGroupAtInfo(ConversationAtInfo paramConversationAtInfo)
  {
    this.conversationAtInfo = paramConversationAtInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupAtInfo
 * JD-Core Version:    0.7.0.1
 */