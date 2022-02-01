package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.MessageReceipt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMMessageManagerImpl$1
  extends MessageListener
{
  V2TIMMessageManagerImpl$1(V2TIMMessageManagerImpl paramV2TIMMessageManagerImpl) {}
  
  public void onReceiveMessageModified(List<Message> paramList) {}
  
  public void onReceiveMessageReceipt(List<MessageReceipt> arg1)
  {
    ArrayList localArrayList = new ArrayList();
    ??? = ???.iterator();
    Object localObject2;
    while (???.hasNext())
    {
      localObject2 = (MessageReceipt)???.next();
      V2TIMMessageReceipt localV2TIMMessageReceipt = new V2TIMMessageReceipt();
      localV2TIMMessageReceipt.setMessageReceipt((MessageReceipt)localObject2);
      localArrayList.add(localV2TIMMessageReceipt);
    }
    synchronized (V2TIMMessageManagerImpl.access$200(this.this$0))
    {
      localObject2 = V2TIMMessageManagerImpl.access$300(this.this$0).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((V2TIMAdvancedMsgListener)((Iterator)localObject2).next()).onRecvC2CReadReceipt(localArrayList);
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void onReceiveMessageRevoked(List<MessageKey> arg1)
  {
    if (??? != null)
    {
      if (???.isEmpty()) {
        return;
      }
      MessageKey localMessageKey = (MessageKey)???.get(0);
      synchronized (V2TIMMessageManagerImpl.access$200(this.this$0))
      {
        Iterator localIterator = V2TIMMessageManagerImpl.access$300(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((V2TIMAdvancedMsgListener)localIterator.next()).onRecvMessageRevoked(localMessageKey.getMessageID());
        }
        return;
      }
    }
  }
  
  public void onReceiveNewMessage(List<Message> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = (Message)paramList.get(0);
      paramList = new V2TIMMessage();
      paramList.setMessage((Message)localObject);
      localObject = V2TIMSignalingManagerImpl.getInstance().processSignalingMessage(paramList);
      if ((localObject != null) && (((V2TIMSignalingInfo)localObject).isOnlineUserOnly())) {
        return;
      }
      this.this$0.onRecvNewMessage(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */