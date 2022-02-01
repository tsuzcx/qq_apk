package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class QQBrowserSwipeLayout$1
  implements Runnable
{
  QQBrowserSwipeLayout$1(QQBrowserSwipeLayout paramQQBrowserSwipeLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFling:");
      localStringBuilder.append(QQBrowserSwipeLayout.a(this.this$0));
      QLog.d("QQBrowserSwipeLayout", 2, localStringBuilder.toString());
    }
    if (!QQBrowserSwipeLayout.b(this.this$0)) {
      QQBrowserSwipeLayout.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserSwipeLayout.1
 * JD-Core Version:    0.7.0.1
 */