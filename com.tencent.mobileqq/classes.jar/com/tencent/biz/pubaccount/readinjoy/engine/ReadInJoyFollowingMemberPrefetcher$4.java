package com.tencent.biz.pubaccount.readinjoy.engine;

import java.lang.ref.WeakReference;
import pvi;
import pvm;
import qfq;

public class ReadInJoyFollowingMemberPrefetcher$4
  implements Runnable
{
  public ReadInJoyFollowingMemberPrefetcher$4(pvi parampvi, boolean paramBoolean) {}
  
  public void run()
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following members");
    }
    qfq localqfq = (qfq)pvi.a(this.this$0).get();
    if (localqfq != null)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadInJoyFollowingMemberPrefetcher", 2, "preload all following members, force=" + this.a);
      }
      try
      {
        if ((pvi.b(this.this$0).get() == null) || (pvi.a(this.this$0)))
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following member when appinterface is null or uninitialized!");
          }
          return;
        }
        pvi.a(this.this$0, true);
        pvm.a().a(this.this$0);
        this.this$0.c();
        localqfq.a(1000, 1, true);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.4
 * JD-Core Version:    0.7.0.1
 */