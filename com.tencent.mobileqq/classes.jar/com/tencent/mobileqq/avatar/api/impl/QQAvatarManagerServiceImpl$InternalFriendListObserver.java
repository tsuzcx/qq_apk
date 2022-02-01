package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class QQAvatarManagerServiceImpl$InternalFriendListObserver
  extends AvatarObserver
{
  private QQAvatarManagerServiceImpl$InternalFriendListObserver(QQAvatarManagerServiceImpl paramQQAvatarManagerServiceImpl) {}
  
  public void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.notifyFaceDrawableUI(8, paramBoolean, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    this.a.notifyFaceDrawableUI(1, paramBoolean, new Object[] { paramString });
  }
  
  public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    this.a.notifyFaceDrawableUI(2, paramBoolean, new Object[] { paramString });
  }
  
  public void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.notifyFaceDrawableUI(5, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
  }
  
  public void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.notifyFaceDrawableUI(4, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
  }
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    this.a.notifyFaceDrawableUI(3, paramBoolean, new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl.InternalFriendListObserver
 * JD-Core Version:    0.7.0.1
 */