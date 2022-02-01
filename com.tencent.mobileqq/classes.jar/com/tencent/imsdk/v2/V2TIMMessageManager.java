package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMMessageManager
{
  static V2TIMMessageManager getInstance()
  {
    return V2TIMMessageManagerImpl.getInstance();
  }
  
  public abstract void addAdvancedMsgListener(V2TIMAdvancedMsgListener paramV2TIMAdvancedMsgListener);
  
  public abstract void clearC2CHistoryMessage(String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract void clearGroupHistoryMessage(String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract V2TIMMessage createCustomMessage(byte[] paramArrayOfByte);
  
  public abstract V2TIMMessage createCustomMessage(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2);
  
  public abstract V2TIMMessage createFaceMessage(int paramInt, byte[] paramArrayOfByte);
  
  public abstract V2TIMMessage createFileMessage(String paramString1, String paramString2);
  
  public abstract V2TIMMessage createForwardMessage(V2TIMMessage paramV2TIMMessage);
  
  public abstract V2TIMMessage createImageMessage(String paramString);
  
  public abstract V2TIMMessage createLocationMessage(String paramString, double paramDouble1, double paramDouble2);
  
  public abstract V2TIMMessage createMergerMessage(List<V2TIMMessage> paramList, String paramString1, List<String> paramList1, String paramString2);
  
  public abstract V2TIMMessage createSoundMessage(String paramString, int paramInt);
  
  public abstract V2TIMMessage createTextAtMessage(String paramString, List<String> paramList);
  
  public abstract V2TIMMessage createTextMessage(String paramString);
  
  public abstract V2TIMMessage createVideoMessage(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void deleteMessageFromLocalStorage(V2TIMMessage paramV2TIMMessage, V2TIMCallback paramV2TIMCallback);
  
  public abstract void deleteMessages(List<V2TIMMessage> paramList, V2TIMCallback paramV2TIMCallback);
  
  public abstract void findMessages(List<String> paramList, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback);
  
  public abstract void getC2CHistoryMessageList(String paramString, int paramInt, V2TIMMessage paramV2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback);
  
  public abstract void getC2CReceiveMessageOpt(List<String> paramList, V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>> paramV2TIMValueCallback);
  
  public abstract void getGroupHistoryMessageList(String paramString, int paramInt, V2TIMMessage paramV2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback);
  
  public abstract void getHistoryMessageList(V2TIMMessageListGetOption paramV2TIMMessageListGetOption, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback);
  
  public abstract String insertC2CMessageToLocalStorage(V2TIMMessage paramV2TIMMessage, String paramString1, String paramString2, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback);
  
  public abstract String insertGroupMessageToLocalStorage(V2TIMMessage paramV2TIMMessage, String paramString1, String paramString2, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback);
  
  public abstract void markC2CMessageAsRead(String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract void markGroupMessageAsRead(String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract void removeAdvancedMsgListener(V2TIMAdvancedMsgListener paramV2TIMAdvancedMsgListener);
  
  public abstract void revokeMessage(V2TIMMessage paramV2TIMMessage, V2TIMCallback paramV2TIMCallback);
  
  public abstract String sendMessage(V2TIMMessage paramV2TIMMessage, String paramString1, String paramString2, int paramInt, boolean paramBoolean, V2TIMOfflinePushInfo paramV2TIMOfflinePushInfo, V2TIMSendCallback<V2TIMMessage> paramV2TIMSendCallback);
  
  public abstract void setC2CReceiveMessageOpt(List<String> paramList, int paramInt, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setGroupReceiveMessageOpt(String paramString, int paramInt, V2TIMCallback paramV2TIMCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManager
 * JD-Core Version:    0.7.0.1
 */