package com.tencent.imsdk.conversation;

import com.tencent.imsdk.message.DraftMessage;
import com.tencent.imsdk.message.Message;
import java.util.ArrayList;
import java.util.List;

public class Conversation
{
  private static final int CONVERSATION_TYPE_C2C = 1;
  private static final int CONVERSATION_TYPE_GROUP = 2;
  private long activeTime;
  private String c2cFaceUrl;
  private String c2cNickname;
  private long c2cReadTimestamp;
  private long c2cReceiptTimestamp;
  private String c2cRemark;
  private String c2cUserID;
  private List<ConversationAtInfo> conversationAtInfoList = new ArrayList();
  private ConversationKey conversationKey;
  private int conversationType;
  private DraftMessage draftMessage;
  private String groupFaceUrl;
  private String groupID;
  private long groupLastSequence;
  private int groupMessageReceiveOption;
  private String groupName;
  private long groupReadSequence;
  private long groupRevokeTimestamp;
  private String groupType;
  private Message lastMessage;
  private boolean pinned = false;
  private long unreadMessageCount;
  private int userMessageReceiveOption;
  
  protected void addConversationAtInfoList(ConversationAtInfo paramConversationAtInfo)
  {
    this.conversationAtInfoList.add(paramConversationAtInfo);
  }
  
  public String getC2cFaceUrl()
  {
    return this.c2cFaceUrl;
  }
  
  public String getC2cNickname()
  {
    return this.c2cNickname;
  }
  
  public long getC2cReadTimestamp()
  {
    return this.c2cReadTimestamp;
  }
  
  public long getC2cReceiptTimestamp()
  {
    return this.c2cReceiptTimestamp;
  }
  
  public String getC2cRemark()
  {
    return this.c2cRemark;
  }
  
  public String getC2cUserID()
  {
    return this.c2cUserID;
  }
  
  public List<ConversationAtInfo> getConversationAtInfoList()
  {
    return this.conversationAtInfoList;
  }
  
  public ConversationKey getConversationKey()
  {
    ConversationKey localConversationKey = new ConversationKey();
    localConversationKey.setConversationType(this.conversationType);
    int i = this.conversationType;
    if (1 == i)
    {
      localConversationKey.setConversationID(this.c2cUserID);
      return localConversationKey;
    }
    if (2 == i) {
      localConversationKey.setConversationID(this.groupID);
    }
    return localConversationKey;
  }
  
  public int getConversationType()
  {
    return this.conversationType;
  }
  
  public DraftMessage getDraftMessage()
  {
    return this.draftMessage;
  }
  
  public String getGroupFaceUrl()
  {
    return this.groupFaceUrl;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public long getGroupLastSequence()
  {
    return this.groupLastSequence;
  }
  
  public int getGroupMessageReceiveOption()
  {
    return this.groupMessageReceiveOption;
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public long getGroupReadSequence()
  {
    return this.groupReadSequence;
  }
  
  public long getGroupRevokeTimestamp()
  {
    return this.groupRevokeTimestamp;
  }
  
  public String getGroupType()
  {
    return this.groupType;
  }
  
  public Message getLastMessage()
  {
    return this.lastMessage;
  }
  
  public long getUnreadMessageCount()
  {
    return this.unreadMessageCount;
  }
  
  public int getUserMessageReceiveOption()
  {
    return this.userMessageReceiveOption;
  }
  
  public boolean isPinned()
  {
    return this.pinned;
  }
  
  public void setPinned(boolean paramBoolean)
  {
    this.pinned = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.Conversation
 * JD-Core Version:    0.7.0.1
 */