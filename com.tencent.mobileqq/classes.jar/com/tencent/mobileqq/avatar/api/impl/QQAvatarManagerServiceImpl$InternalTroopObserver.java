package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;

class QQAvatarManagerServiceImpl$InternalTroopObserver
  extends TroopAvatarObserver
{
  private QQAvatarManagerServiceImpl$InternalTroopObserver(QQAvatarManagerServiceImpl paramQQAvatarManagerServiceImpl) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.a.notifyNewTroopDrawableUI(TroopAvatarObserver.TYPE_NOTIFY_GET_NEW_TROOP_HEAD, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl.InternalTroopObserver
 * JD-Core Version:    0.7.0.1
 */