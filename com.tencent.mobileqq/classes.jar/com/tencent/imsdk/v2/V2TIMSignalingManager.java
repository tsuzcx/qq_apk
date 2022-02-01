package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMSignalingManager
{
  static V2TIMSignalingManager getInstance()
  {
    return V2TIMSignalingManagerImpl.getInstance();
  }
  
  public abstract void accept(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
  
  public abstract void addInvitedSignaling(V2TIMSignalingInfo paramV2TIMSignalingInfo, V2TIMCallback paramV2TIMCallback);
  
  public abstract void addSignalingListener(V2TIMSignalingListener paramV2TIMSignalingListener);
  
  public abstract void cancel(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
  
  public abstract V2TIMSignalingInfo getSignalingInfo(V2TIMMessage paramV2TIMMessage);
  
  public abstract String invite(String paramString1, String paramString2, boolean paramBoolean, V2TIMOfflinePushInfo paramV2TIMOfflinePushInfo, int paramInt, V2TIMCallback paramV2TIMCallback);
  
  public abstract String inviteInGroup(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, int paramInt, V2TIMCallback paramV2TIMCallback);
  
  public abstract void reject(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
  
  public abstract void removeSignalingListener(V2TIMSignalingListener paramV2TIMSignalingListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManager
 * JD-Core Version:    0.7.0.1
 */