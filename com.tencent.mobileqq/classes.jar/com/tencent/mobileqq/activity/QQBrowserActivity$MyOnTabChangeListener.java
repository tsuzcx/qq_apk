package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import mqq.util.WeakReference;

class QQBrowserActivity$MyOnTabChangeListener
  implements TabBarView.OnTabChangeListener
{
  final WeakReference<QQBrowserActivity> a;
  
  QQBrowserActivity$MyOnTabChangeListener(QQBrowserActivity paramQQBrowserActivity)
  {
    this.a = new WeakReference(paramQQBrowserActivity);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.a.get();
    if (localQQBrowserActivity == null) {}
    while (paramInt1 == paramInt2) {
      return;
    }
    QQBrowserActivity.switchFragment(paramInt2, localQQBrowserActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.MyOnTabChangeListener
 * JD-Core Version:    0.7.0.1
 */