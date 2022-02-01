package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.conversation.ConversationListener;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class V2TIMConversationManagerImpl
  extends V2TIMConversationManager
{
  private ConversationListener mConversationListener;
  private V2TIMConversationListener mV2TIMConversationListener;
  
  private V2TIMConversationManagerImpl()
  {
    initListener();
  }
  
  static V2TIMConversationManagerImpl getInstance()
  {
    return V2TIMConversationManagerImpl.V2TIMConversationManagerImplHolder.access$100();
  }
  
  private void initListener()
  {
    if (this.mConversationListener == null) {
      this.mConversationListener = new V2TIMConversationManagerImpl.1(this);
    }
    ConversationManager.getInstance().setConversationListener(this.mConversationListener);
  }
  
  public void deleteConversation(String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "conversationID is empty");
      }
      return;
    }
    paramString = getConversationKey(paramString);
    ConversationManager.getInstance().deleteConversation(paramString, true, new V2TIMConversationManagerImpl.8(this, paramV2TIMCallback));
  }
  
  public void getConversation(String paramString, V2TIMValueCallback<V2TIMConversation> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "conversationID is empty");
      }
      return;
    }
    paramString = getConversationKey(paramString);
    paramV2TIMValueCallback = new V2TIMConversationManagerImpl.6(this, paramV2TIMValueCallback);
    ConversationManager.getInstance().getConversationInfo(paramString, new V2TIMConversationManagerImpl.7(this, paramV2TIMValueCallback));
  }
  
  protected ConversationKey getConversationKey(String paramString)
  {
    ConversationKey localConversationKey = new ConversationKey();
    if (paramString.indexOf("c2c_") == 0)
    {
      paramString = paramString.substring(4);
      localConversationKey.setConversationType(1);
      localConversationKey.setConversationID(paramString);
      return localConversationKey;
    }
    if (paramString.indexOf("group_") == 0)
    {
      paramString = paramString.substring(6);
      localConversationKey.setConversationType(2);
      localConversationKey.setConversationID(paramString);
    }
    return localConversationKey;
  }
  
  public void getConversationList(long paramLong, int paramInt, V2TIMValueCallback<V2TIMConversationResult> paramV2TIMValueCallback)
  {
    paramV2TIMValueCallback = new V2TIMConversationManagerImpl.2(this, paramV2TIMValueCallback);
    ConversationManager.getInstance().getConversationList(paramLong, paramInt, new V2TIMConversationManagerImpl.3(this, paramV2TIMValueCallback));
  }
  
  public void getConversationList(List<String> paramList, V2TIMValueCallback<List<V2TIMConversation>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(getConversationKey((String)paramList.next()));
      }
      paramList = new V2TIMConversationManagerImpl.4(this, paramV2TIMValueCallback);
      ConversationManager.getInstance().getConversationList(localArrayList, new V2TIMConversationManagerImpl.5(this, paramList));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "conversationIDList cannot be empty");
    }
  }
  
  public void getTotalUnreadMessageCount(V2TIMValueCallback<Long> paramV2TIMValueCallback)
  {
    ConversationManager.getInstance().getTotalUnreadMessageCount(new V2TIMConversationManagerImpl.11(this, paramV2TIMValueCallback));
  }
  
  public void pinConversation(String paramString, boolean paramBoolean, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "conversationID is empty");
      }
      return;
    }
    paramString = getConversationKey(paramString);
    ConversationManager.getInstance().pinConversation(paramString, paramBoolean, new V2TIMConversationManagerImpl.10(this, paramV2TIMCallback));
  }
  
  public void setConversationDraft(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "conversationID is empty");
      }
      return;
    }
    paramString1 = getConversationKey(paramString1);
    DraftMessage localDraftMessage = new DraftMessage();
    if (paramString2 != null) {
      localDraftMessage.setUserDefinedData(paramString2.getBytes());
    }
    ConversationManager.getInstance().setConversationDraft(paramString1, localDraftMessage, new V2TIMConversationManagerImpl.9(this, paramV2TIMCallback));
  }
  
  public void setConversationListener(V2TIMConversationListener paramV2TIMConversationListener)
  {
    this.mV2TIMConversationListener = paramV2TIMConversationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMConversationManagerImpl
 * JD-Core Version:    0.7.0.1
 */