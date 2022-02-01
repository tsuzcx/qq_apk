package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.Conversation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMConversationManagerImpl$4
  implements V2TIMValueCallback<List<Conversation>>
{
  V2TIMConversationManagerImpl$4(V2TIMConversationManagerImpl paramV2TIMConversationManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<Conversation> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Conversation localConversation = (Conversation)paramList.next();
      V2TIMConversation localV2TIMConversation = new V2TIMConversation();
      localV2TIMConversation.setConversation(localConversation);
      localArrayList.add(localV2TIMConversation);
    }
    paramList = this.val$callback;
    if (paramList != null) {
      paramList.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */