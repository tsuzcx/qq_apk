package com.tencent.imsdk.message;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageCenter
{
  private static final String TAG = "MessageCenter";
  private Object mLockObject = new Object();
  private MessageListener mMessageListener;
  private CopyOnWriteArrayList<MessageListener> mMessageProxyListenerList = new CopyOnWriteArrayList();
  
  public static MessageCenter getInstance()
  {
    return MessageCenter.MessageCenterHolder.access$000();
  }
  
  private void initMessageListener()
  {
    this.mMessageListener = new MessageCenter.1(this);
    nativeSetMessageListener(this.mMessageListener);
  }
  
  public void addMessageListener(MessageListener paramMessageListener)
  {
    synchronized (this.mLockObject)
    {
      this.mMessageProxyListenerList.add(paramMessageListener);
      return;
    }
  }
  
  public void clearC2CHistoryMessage(String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeClearC2CHistoryMessage(paramString, paramIMCallback);
  }
  
  public void clearC2CLocalMessage(String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeClearC2CLocalMessage(paramString, paramIMCallback);
  }
  
  public void clearGroupHistoryMessage(String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeClearGroupHistoryMessage(paramString, paramIMCallback);
  }
  
  public void clearGroupLocalMessage(String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeClearGroupLocalMessage(paramString, paramIMCallback);
  }
  
  public void deleteCloudMessageList(List<MessageKey> paramList, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteCloudMessageList(paramList, paramIMCallback);
  }
  
  public void deleteLocalMessage(MessageKey paramMessageKey, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteLocalMessage(paramMessageKey, paramIMCallback);
  }
  
  public void downloadMessageElement(DownloadParam paramDownloadParam, IMCallback<DownloadProgressInfo> paramIMCallback, IMCallback paramIMCallback1)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback1 != null) {
        paramIMCallback1.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDownloadMessageElement(paramDownloadParam, paramIMCallback, paramIMCallback1);
  }
  
  public void downloadRelayMessageList(Message paramMessage, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDownloadRelayMessageList(paramMessage, paramIMCallback);
  }
  
  public void findMessageByMessageId(List<String> paramList, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeFindMessageByMessageID(paramList, paramIMCallback);
  }
  
  public void findMessageBySearchKey(MessageSearchParam paramMessageSearchParam, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeFindMessageBySearchKey(paramMessageSearchParam, paramIMCallback);
  }
  
  public void getC2CHistoryMessageList(String paramString, MessageKey paramMessageKey, int paramInt, boolean paramBoolean1, boolean paramBoolean2, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetC2CHistoryMessageList(paramString, paramMessageKey, paramInt, paramBoolean1, paramBoolean2, paramIMCallback);
  }
  
  public void getDownloadUrl(DownloadParam paramDownloadParam, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetDownloadUrl(paramDownloadParam, paramIMCallback);
  }
  
  public void getGroupHistoryMessageList(String paramString, MessageKey paramMessageKey, int paramInt, boolean paramBoolean1, boolean paramBoolean2, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetGroupHistoryMessageList(paramString, paramMessageKey, paramInt, paramBoolean1, paramBoolean2, paramIMCallback);
  }
  
  public void init()
  {
    initMessageListener();
  }
  
  public String insertLocalMessage(Message paramMessage, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return null;
    }
    return nativeInsertLocalMessage(paramMessage, paramIMCallback);
  }
  
  public boolean isMessagePeerRead(MessageKey paramMessageKey)
  {
    if (!BaseManager.getInstance().isInited())
    {
      IMLog.e("MessageCenter", "sdk not ini");
      return false;
    }
    return nativeIsMessagePeerRead(paramMessageKey);
  }
  
  public boolean isMessageSelfRead(MessageKey paramMessageKey)
  {
    if (!BaseManager.getInstance().isInited())
    {
      IMLog.e("MessageCenter", "sdk not ini");
      return false;
    }
    return nativeIsMessageSelfRead(paramMessageKey);
  }
  
  protected native void nativeClearC2CHistoryMessage(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeClearC2CLocalMessage(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeClearGroupHistoryMessage(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeClearGroupLocalMessage(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeDeleteCloudMessageList(List<MessageKey> paramList, IMCallback paramIMCallback);
  
  protected native void nativeDeleteLocalMessage(MessageKey paramMessageKey, IMCallback paramIMCallback);
  
  protected native void nativeDownloadMessageElement(DownloadParam paramDownloadParam, IMCallback paramIMCallback1, IMCallback paramIMCallback2);
  
  protected native void nativeDownloadRelayMessageList(Message paramMessage, IMCallback paramIMCallback);
  
  protected native void nativeFindMessageByMessageID(List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeFindMessageBySearchKey(MessageSearchParam paramMessageSearchParam, IMCallback paramIMCallback);
  
  protected native void nativeGetC2CHistoryMessageList(String paramString, MessageKey paramMessageKey, int paramInt, boolean paramBoolean1, boolean paramBoolean2, IMCallback paramIMCallback);
  
  protected native void nativeGetDownloadUrl(DownloadParam paramDownloadParam, IMCallback paramIMCallback);
  
  protected native void nativeGetGroupHistoryMessageList(String paramString, MessageKey paramMessageKey, int paramInt, boolean paramBoolean1, boolean paramBoolean2, IMCallback paramIMCallback);
  
  protected native String nativeInsertLocalMessage(Message paramMessage, IMCallback paramIMCallback);
  
  protected native boolean nativeIsMessagePeerRead(MessageKey paramMessageKey);
  
  protected native boolean nativeIsMessageSelfRead(MessageKey paramMessageKey);
  
  protected native void nativeRevokeMessage(MessageKey paramMessageKey, IMCallback paramIMCallback);
  
  protected native String nativeSendMessage(Message paramMessage, MessageUploadProgressCallback paramMessageUploadProgressCallback, IMCallback paramIMCallback);
  
  protected native void nativeSetC2CMessageRead(String paramString, long paramLong, IMCallback paramIMCallback);
  
  protected native void nativeSetGroupMessageRead(String paramString, long paramLong, IMCallback paramIMCallback);
  
  protected native void nativeSetLocalCustomNumber(Message paramMessage, int paramInt);
  
  protected native void nativeSetLocalCustomString(Message paramMessage, String paramString);
  
  protected native void nativeSetMessageListener(MessageListener paramMessageListener);
  
  public void revokeMessage(MessageKey paramMessageKey, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeRevokeMessage(paramMessageKey, paramIMCallback);
  }
  
  public String sendMessage(Message paramMessage, MessageUploadProgressCallback paramMessageUploadProgressCallback, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return null;
    }
    return nativeSendMessage(paramMessage, paramMessageUploadProgressCallback, paramIMCallback);
  }
  
  public void setC2CMessageRead(String paramString, long paramLong, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetC2CMessageRead(paramString, paramLong, paramIMCallback);
  }
  
  public void setGroupMessageRead(String paramString, long paramLong, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetGroupMessageRead(paramString, paramLong, paramIMCallback);
  }
  
  public void setLocalCustomNumber(Message paramMessage, int paramInt)
  {
    nativeSetLocalCustomNumber(paramMessage, paramInt);
  }
  
  public void setLocalCustomString(Message paramMessage, String paramString)
  {
    nativeSetLocalCustomString(paramMessage, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageCenter
 * JD-Core Version:    0.7.0.1
 */