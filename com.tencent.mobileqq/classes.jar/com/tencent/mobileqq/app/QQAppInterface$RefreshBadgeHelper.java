package com.tencent.mobileqq.app;

import java.util.concurrent.ConcurrentLinkedQueue;

class QQAppInterface$RefreshBadgeHelper
{
  public static final int MAX_RUNNING_TASK = 3;
  ConcurrentLinkedQueue<QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable> mGenerateIconRunners = new ConcurrentLinkedQueue();
  private int mLastUnreadCount = -1;
  volatile int mRunningTaskNum = 0;
  
  QQAppInterface$RefreshBadgeHelper(QQAppInterface paramQQAppInterface) {}
  
  private void addGenIconTask(QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable paramRefreshBadgeRunnable)
  {
    this.mGenerateIconRunners.offer(paramRefreshBadgeRunnable);
    runNext();
  }
  
  private void runNext()
  {
    if (this.mRunningTaskNum < 3)
    {
      QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable localRefreshBadgeRunnable = (QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable)this.mGenerateIconRunners.poll();
      if (localRefreshBadgeRunnable != null)
      {
        this.mRunningTaskNum += 1;
        ThreadManager.excute(localRefreshBadgeRunnable, 16, null, false);
      }
    }
  }
  
  public void refreshAppBadge()
  {
    addGenIconTask(new QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.RefreshBadgeHelper
 * JD-Core Version:    0.7.0.1
 */