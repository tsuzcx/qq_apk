package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMSignalingListener
{
  public void onInvitationCancelled(String paramString1, String paramString2, String paramString3) {}
  
  public void onInvitationTimeout(String paramString, List<String> paramList) {}
  
  public void onInviteeAccepted(String paramString1, String paramString2, String paramString3) {}
  
  public void onInviteeRejected(String paramString1, String paramString2, String paramString3) {}
  
  public void onReceiveNewInvitation(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingListener
 * JD-Core Version:    0.7.0.1
 */