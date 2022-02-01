package com.tencent.biz.pubaccount.weishi_new;

import android.widget.TextView;
import anni;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;

public class WSHomeFragment$1
  implements Runnable
{
  WSHomeFragment$1(WSHomeFragment paramWSHomeFragment) {}
  
  public void run()
  {
    String str = anni.a(2131705608) + TaskMonitorManager.g().getMemeryUsage() + "%";
    if (WSHomeFragment.a(this.this$0) != null) {
      WSHomeFragment.a(this.this$0).setText(str);
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.1
 * JD-Core Version:    0.7.0.1
 */