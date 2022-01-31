package com.tencent.mobileqq.app;

import java.util.concurrent.ConcurrentLinkedQueue;

class QQAppInterface$RefreshBadgeHelper
{
  volatile int jdField_a_of_type_Int = 0;
  ConcurrentLinkedQueue<QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private int b = -1;
  
  QQAppInterface$RefreshBadgeHelper(QQAppInterface paramQQAppInterface) {}
  
  private void a(QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable paramRefreshBadgeRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramRefreshBadgeRunnable);
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Int < 3)
    {
      QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable localRefreshBadgeRunnable = (QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localRefreshBadgeRunnable != null)
      {
        this.jdField_a_of_type_Int += 1;
        ThreadManager.excute(localRefreshBadgeRunnable, 16, null, false);
      }
    }
  }
  
  public void a()
  {
    a(new QQAppInterface.RefreshBadgeHelper.RefreshBadgeRunnable(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.RefreshBadgeHelper
 * JD-Core Version:    0.7.0.1
 */