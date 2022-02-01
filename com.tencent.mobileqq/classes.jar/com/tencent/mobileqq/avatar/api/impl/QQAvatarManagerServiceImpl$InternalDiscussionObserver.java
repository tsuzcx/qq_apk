package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.avatar.observer.DiscussionAvatarObserver;

class QQAvatarManagerServiceImpl$InternalDiscussionObserver
  extends DiscussionAvatarObserver
{
  private QQAvatarManagerServiceImpl$InternalDiscussionObserver(QQAvatarManagerServiceImpl paramQQAvatarManagerServiceImpl) {}
  
  public void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.a.notifyDisFaceDrawableUI(1, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl.InternalDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */