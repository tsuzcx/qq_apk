package com.tencent.biz.pubaccount.readinjoy.engine;

import java.lang.ref.WeakReference;
import osi;
import osm;
import paq;

public class ReadInJoyFollowingMemberPrefetcher$4
  implements Runnable
{
  public ReadInJoyFollowingMemberPrefetcher$4(osi paramosi, boolean paramBoolean) {}
  
  public void run()
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following members");
    }
    paq localpaq = (paq)osi.a(this.this$0).get();
    if (localpaq != null)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadInJoyFollowingMemberPrefetcher", 2, "preload all following members, force=" + this.a);
      }
      try
      {
        if ((osi.b(this.this$0).get() == null) || (osi.a(this.this$0)))
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following member when appinterface is null or uninitialized!");
          }
          return;
        }
        osi.a(this.this$0, true);
        osm.a().a(this.this$0);
        this.this$0.b();
        localpaq.a(1000, 1, true);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.4
 * JD-Core Version:    0.7.0.1
 */