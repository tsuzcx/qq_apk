package com.tencent.imsdk.v2;

public abstract class V2TIMSimpleMsgListener
{
  public void onRecvC2CCustomMessage(String paramString, V2TIMUserInfo paramV2TIMUserInfo, byte[] paramArrayOfByte) {}
  
  public void onRecvC2CTextMessage(String paramString1, V2TIMUserInfo paramV2TIMUserInfo, String paramString2) {}
  
  public void onRecvGroupCustomMessage(String paramString1, String paramString2, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, byte[] paramArrayOfByte) {}
  
  public void onRecvGroupTextMessage(String paramString1, String paramString2, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, String paramString3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSimpleMsgListener
 * JD-Core Version:    0.7.0.1
 */