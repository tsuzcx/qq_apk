package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import java.lang.ref.WeakReference;

class ReadInJoyFollowingMemberPrefetcher$4
  implements Runnable
{
  ReadInJoyFollowingMemberPrefetcher$4(ReadInJoyFollowingMemberPrefetcher paramReadInJoyFollowingMemberPrefetcher, boolean paramBoolean) {}
  
  public void run()
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following members");
    }
    FollowListInfoModule localFollowListInfoModule = (FollowListInfoModule)ReadInJoyFollowingMemberPrefetcher.a(this.this$0).get();
    if (localFollowListInfoModule != null)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadInJoyFollowingMemberPrefetcher", 2, "preload all following members, force=" + this.a);
      }
      try
      {
        if ((ReadInJoyFollowingMemberPrefetcher.b(this.this$0).get() == null) || (ReadInJoyFollowingMemberPrefetcher.a(this.this$0)))
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following member when appinterface is null or uninitialized!");
          }
          return;
        }
        ReadInJoyFollowingMemberPrefetcher.a(this.this$0, true);
        ReadInJoyLogicEngineEventDispatcher.a().a(this.this$0);
        this.this$0.e();
        localFollowListInfoModule.a(1000, 1, true);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.4
 * JD-Core Version:    0.7.0.1
 */