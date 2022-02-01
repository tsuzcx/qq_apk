package com.tencent.av.wtogether.view;

import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.qphone.base.util.QLog;

class QGroupListContentView$2
  extends AutomatorObserver
{
  QGroupListContentView$2(QGroupListContentView paramQGroupListContentView) {}
  
  protected void a(int paramInt)
  {
    if (paramInt != 2) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCacheInited ");
      localStringBuilder.append(paramInt);
      QLog.d("QGroupListContentView", 2, localStringBuilder.toString());
    }
    if (this.a.d != null) {
      this.a.d.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupListContentView.2
 * JD-Core Version:    0.7.0.1
 */