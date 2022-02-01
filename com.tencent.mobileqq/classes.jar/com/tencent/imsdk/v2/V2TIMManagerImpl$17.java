package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.MessageReceipt;
import java.util.Iterator;
import java.util.List;

class V2TIMManagerImpl$17
  extends MessageListener
{
  V2TIMManagerImpl$17(V2TIMManagerImpl paramV2TIMManagerImpl) {}
  
  public void onReceiveMessageModified(List<Message> paramList) {}
  
  public void onReceiveMessageReceipt(List<MessageReceipt> paramList) {}
  
  public void onReceiveMessageRevoked(List<MessageKey> paramList) {}
  
  public void onReceiveNewMessage(List<Message> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ??? = (Message)paramList.get(0);
      int i = ((Message)???).getMessageType();
      V2TIMMessage localV2TIMMessage = new V2TIMMessage();
      localV2TIMMessage.setMessage((Message)???);
      int j = localV2TIMMessage.getElemType();
      int k = Message.MESSAGE_TYPE_C2C;
      V2TIMUserInfo localV2TIMUserInfo = null;
      if (i == k)
      {
        localV2TIMUserInfo = new V2TIMUserInfo();
        localV2TIMUserInfo.setUserID(localV2TIMMessage.getSender());
        localV2TIMUserInfo.setNickName(localV2TIMMessage.getNickName());
        localV2TIMUserInfo.setFaceUrl(localV2TIMMessage.getFaceUrl());
        paramList = null;
      }
      else if (i == Message.MESSAGE_TYPE_GROUP)
      {
        paramList = new V2TIMGroupMemberInfo();
        ??? = new GroupMemberInfo();
        ((GroupMemberInfo)???).setGroupID(((Message)???).getGroupID());
        ((GroupMemberInfo)???).setUserID(((Message)???).getSenderUserID());
        ((GroupMemberInfo)???).setNickname(((Message)???).getNickName());
        ((GroupMemberInfo)???).setNameCard(((Message)???).getNameCard());
        ((GroupMemberInfo)???).setFaceUrl(((Message)???).getFaceUrl());
        ((GroupMemberInfo)???).setFriendRemark(((Message)???).getFriendRemark());
        paramList.setGroupMemberInfo((GroupMemberInfo)???);
      }
      else
      {
        paramList = null;
      }
      Object localObject3;
      Object localObject4;
      if (j == 1)
      {
        localObject3 = localV2TIMMessage.getTextElem();
        synchronized (V2TIMManagerImpl.access$100(this.this$0))
        {
          localObject4 = V2TIMManagerImpl.access$200(this.this$0).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            V2TIMSimpleMsgListener localV2TIMSimpleMsgListener = (V2TIMSimpleMsgListener)((Iterator)localObject4).next();
            if (i == Message.MESSAGE_TYPE_C2C) {
              localV2TIMSimpleMsgListener.onRecvC2CTextMessage(localV2TIMMessage.getMsgID(), localV2TIMUserInfo, ((V2TIMTextElem)localObject3).getText());
            } else if (i == Message.MESSAGE_TYPE_GROUP) {
              localV2TIMSimpleMsgListener.onRecvGroupTextMessage(localV2TIMMessage.getMsgID(), ((Message)???).getGroupID(), paramList, ((V2TIMTextElem)localObject3).getText());
            }
          }
          return;
        }
      }
      if (j == 2)
      {
        ??? = localV2TIMMessage.getCustomElem();
        synchronized (V2TIMManagerImpl.access$100(this.this$0))
        {
          localObject3 = V2TIMManagerImpl.access$200(this.this$0).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (V2TIMSimpleMsgListener)((Iterator)localObject3).next();
            if (i == Message.MESSAGE_TYPE_C2C) {
              ((V2TIMSimpleMsgListener)localObject4).onRecvC2CCustomMessage(localV2TIMMessage.getMsgID(), localV2TIMUserInfo, ((V2TIMCustomElem)???).getData());
            } else if (i == Message.MESSAGE_TYPE_GROUP) {
              ((V2TIMSimpleMsgListener)localObject4).onRecvGroupCustomMessage(localV2TIMMessage.getMsgID(), localV2TIMMessage.getGroupID(), paramList, ((V2TIMCustomElem)???).getData());
            }
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.17
 * JD-Core Version:    0.7.0.1
 */