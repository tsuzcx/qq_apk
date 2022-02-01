package com.tencent.mobileqq.activity;

import com.tencent.qqperf.opt.clearmemory.MemoryClearManager.IClearMemoryListener;
import java.lang.ref.WeakReference;

class QQSettingMe$ClearDynamicDrawable
  implements MemoryClearManager.IClearMemoryListener
{
  WeakReference<QQSettingMe> a;
  
  public QQSettingMe$ClearDynamicDrawable(QQSettingMe paramQQSettingMe)
  {
    this.a = new WeakReference(paramQQSettingMe);
  }
  
  public int a()
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.a.get();
    if (localQQSettingMe != null) {
      return localQQSettingMe.a();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.ClearDynamicDrawable
 * JD-Core Version:    0.7.0.1
 */