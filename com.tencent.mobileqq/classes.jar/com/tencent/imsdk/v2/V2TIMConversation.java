package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationAtInfo;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.message.DraftMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class V2TIMConversation
{
  static final String CONVERSATION_C2C_PREFIX = "c2c_";
  static final String CONVERSATION_GROUP_PREFIX = "group_";
  public static final int CONVERSATION_TYPE_INVALID = 0;
  public static final int V2TIM_C2C = 1;
  public static final int V2TIM_GROUP = 2;
  private Conversation conversation;
  
  public String getConversationID()
  {
    Object localObject = this.conversation;
    if (localObject != null)
    {
      if (((Conversation)localObject).getConversationKey().getConversationType() == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("c2c_");
        ((StringBuilder)localObject).append(this.conversation.getConversationKey().getConversationID());
        return ((StringBuilder)localObject).toString();
      }
      if (this.conversation.getConversationKey().getConversationType() == 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("group_");
        ((StringBuilder)localObject).append(this.conversation.getConversationKey().getConversationID());
        return ((StringBuilder)localObject).toString();
      }
      return "";
    }
    return null;
  }
  
  public String getDraftText()
  {
    Object localObject = this.conversation;
    String str = null;
    if (localObject == null) {
      return null;
    }
    localObject = ((Conversation)localObject).getDraftMessage();
    if (localObject == null) {
      return null;
    }
    localObject = ((DraftMessage)localObject).getUserDefinedData();
    if (localObject != null) {
      str = new String((byte[])localObject);
    }
    return str;
  }
  
  public long getDraftTimestamp()
  {
    Object localObject = this.conversation;
    if (localObject == null) {
      return 0L;
    }
    localObject = ((Conversation)localObject).getDraftMessage();
    if (localObject == null) {
      return 0L;
    }
    return ((DraftMessage)localObject).getEditTime();
  }
  
  public String getFaceUrl()
  {
    if (this.conversation != null)
    {
      if (getType() == 1) {
        return this.conversation.getC2cFaceUrl();
      }
      if (getType() == 2) {
        return this.conversation.getGroupFaceUrl();
      }
    }
    return null;
  }
  
  public List<V2TIMGroupAtInfo> getGroupAtInfoList()
  {
    if (this.conversation == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.conversation.getConversationAtInfoList().iterator();
    while (localIterator.hasNext())
    {
      ConversationAtInfo localConversationAtInfo = (ConversationAtInfo)localIterator.next();
      V2TIMGroupAtInfo localV2TIMGroupAtInfo = new V2TIMGroupAtInfo();
      localV2TIMGroupAtInfo.setConversationGroupAtInfo(localConversationAtInfo);
      localArrayList.add(localV2TIMGroupAtInfo);
    }
    return localArrayList;
  }
  
  public String getGroupID()
  {
    Conversation localConversation = this.conversation;
    if (localConversation == null) {
      return null;
    }
    if (localConversation.getConversationType() == 2) {
      return this.conversation.getGroupID();
    }
    return null;
  }
  
  public String getGroupType()
  {
    Object localObject = this.conversation;
    if (localObject == null) {
      return null;
    }
    String str = ((Conversation)localObject).getGroupType();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (str.equals("Private")) {
      return "Work";
    }
    localObject = str;
    if (str.equals("ChatRoom")) {
      localObject = "Meeting";
    }
    return localObject;
  }
  
  public V2TIMMessage getLastMessage()
  {
    Object localObject = this.conversation;
    if ((localObject != null) && (((Conversation)localObject).getLastMessage() != null))
    {
      localObject = new V2TIMMessage();
      ((V2TIMMessage)localObject).setMessage(this.conversation.getLastMessage());
      return localObject;
    }
    return null;
  }
  
  public int getRecvOpt()
  {
    if (this.conversation != null)
    {
      int i;
      if (getType() == 1)
      {
        i = this.conversation.getUserMessageReceiveOption();
        if (i == 1) {
          return 0;
        }
        if (i == 2) {
          return 1;
        }
        if (i == 3) {
          return 2;
        }
      }
      else if (getType() == 2)
      {
        i = this.conversation.getGroupMessageReceiveOption();
        if (i == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
          return 0;
        }
        if (i == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
          return 1;
        }
        if (i == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  public String getShowName()
  {
    Conversation localConversation = this.conversation;
    if (localConversation == null) {
      return null;
    }
    if (localConversation.getConversationType() == 2) {
      return this.conversation.getGroupName();
    }
    if (this.conversation.getConversationType() == 1)
    {
      if (!TextUtils.isEmpty(this.conversation.getC2cRemark())) {
        return this.conversation.getC2cRemark();
      }
      if (!TextUtils.isEmpty(this.conversation.getC2cNickname())) {
        return this.conversation.getC2cNickname();
      }
      return this.conversation.getC2cUserID();
    }
    return null;
  }
  
  public int getType()
  {
    Conversation localConversation = this.conversation;
    if (localConversation != null) {
      return localConversation.getConversationType();
    }
    return 0;
  }
  
  public int getUnreadCount()
  {
    Conversation localConversation = this.conversation;
    if (localConversation != null) {
      return (int)localConversation.getUnreadMessageCount();
    }
    return 0;
  }
  
  public String getUserID()
  {
    Conversation localConversation = this.conversation;
    if (localConversation == null) {
      return null;
    }
    if (localConversation.getConversationType() == 1) {
      return this.conversation.getC2cUserID();
    }
    return null;
  }
  
  public boolean isPinned()
  {
    Conversation localConversation = this.conversation;
    if (localConversation == null) {
      return false;
    }
    return localConversation.isPinned();
  }
  
  void setConversation(Conversation paramConversation)
  {
    this.conversation = paramConversation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversation
 * JD-Core Version:    0.7.0.1
 */