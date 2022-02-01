package com.tencent.biz.pubaccount.api;

import java.util.ArrayList;

public abstract class IPublicAccountObserver$OnCallback
{
  public void onDestroy() {}
  
  public void onDownPublicAccount() {}
  
  public void onDynamicListGet(boolean paramBoolean, int paramInt) {}
  
  public void onFollowPublicAccount(int paramInt, Object paramObject) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, int paramInt) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString) {}
  
  public void onGetGuideFriends(boolean paramBoolean, ArrayList<Long> paramArrayList) {}
  
  public void onGetHistoryMsgRet(int paramInt) {}
  
  public void onGetPublicAccountSubscribeStatus(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void onPublicAccountNotification(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onSetPublicAccountSubscribeStatus(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void onSetRecvMsgState(boolean paramBoolean, Object paramObject) {}
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject) {}
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString) {}
  
  public void onUpdateFunctionFlag(boolean paramBoolean, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onUpdateRecommendList(boolean paramBoolean) {}
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback
 * JD-Core Version:    0.7.0.1
 */