package com.tencent.mobileqq.ark;

import aovw;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ArkHorizontalListView$1
  implements Runnable
{
  ArkHorizontalListView$1(ArkHorizontalListView paramArkHorizontalListView) {}
  
  public void run()
  {
    if ((ArkHorizontalListView.a(this.this$0) != null) && (ArkHorizontalListView.a(this.this$0).get() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkHorizontalListView", 2, "checkScrollToChild updateHeadBorder");
      }
      ((aovw)ArkHorizontalListView.a(this.this$0).get()).a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListView.1
 * JD-Core Version:    0.7.0.1
 */