package com.tencent.imsdk.conversation;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.List;

public class ConversationManager
{
  private static final String TAG = "ConversationManager";
  private ConversationListener mConversationListener;
  private ConversationListener mInternalConversationListener;
  
  public static ConversationManager getInstance()
  {
    return ConversationManager.ConversationManagerHolder.access$000();
  }
  
  private void initInternalConversationListener()
  {
    if (this.mInternalConversationListener == null) {
      this.mInternalConversationListener = new ConversationManager.1(this);
    }
    nativeSetConversationListener(this.mInternalConversationListener);
  }
  
  public void deleteConversation(ConversationKey paramConversationKey, boolean paramBoolean, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteConversation(paramConversationKey, paramBoolean, paramIMCallback);
  }
  
  public void getConversationInfo(ConversationKey paramConversationKey, IMCallback<Conversation> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetConversationInfo(paramConversationKey, paramIMCallback);
  }
  
  public void getConversationList(long paramLong, int paramInt, IMCallback<ConversationResult> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetConversationList(paramLong, paramInt, paramIMCallback);
  }
  
  public void getConversationList(List<ConversationKey> paramList, IMCallback<List<Conversation>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetConversations(paramList, paramIMCallback);
  }
  
  public void getTotalUnreadMessageCount(IMCallback<Long> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetTotalUnreadMessageCount(paramIMCallback);
  }
  
  public void init()
  {
    initInternalConversationListener();
  }
  
  protected native void nativeDeleteConversation(ConversationKey paramConversationKey, boolean paramBoolean, IMCallback paramIMCallback);
  
  protected native void nativeGetConversationInfo(ConversationKey paramConversationKey, IMCallback paramIMCallback);
  
  protected native void nativeGetConversationList(long paramLong, int paramInt, IMCallback paramIMCallback);
  
  protected native void nativeGetConversations(List<ConversationKey> paramList, IMCallback paramIMCallback);
  
  protected native void nativeGetTotalUnreadMessageCount(IMCallback paramIMCallback);
  
  protected native void nativePinConversation(ConversationKey paramConversationKey, boolean paramBoolean, IMCallback paramIMCallback);
  
  protected native void nativeSetConversationDraft(ConversationKey paramConversationKey, DraftMessage paramDraftMessage, IMCallback paramIMCallback);
  
  protected native void nativeSetConversationListener(ConversationListener paramConversationListener);
  
  public void pinConversation(ConversationKey paramConversationKey, boolean paramBoolean, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativePinConversation(paramConversationKey, paramBoolean, paramIMCallback);
  }
  
  public void setConversationDraft(ConversationKey paramConversationKey, DraftMessage paramDraftMessage, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetConversationDraft(paramConversationKey, paramDraftMessage, paramIMCallback);
  }
  
  public void setConversationListener(ConversationListener paramConversationListener)
  {
    this.mConversationListener = paramConversationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationManager
 * JD-Core Version:    0.7.0.1
 */