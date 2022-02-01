package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMAdvancedMsgListener
{
  public void onRecvC2CReadReceipt(List<V2TIMMessageReceipt> paramList) {}
  
  public void onRecvMessageRevoked(String paramString) {}
  
  public void onRecvNewMessage(V2TIMMessage paramV2TIMMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
 * JD-Core Version:    0.7.0.1
 */