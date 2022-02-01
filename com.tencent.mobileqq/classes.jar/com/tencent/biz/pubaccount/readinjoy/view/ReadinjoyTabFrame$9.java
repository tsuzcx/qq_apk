package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

class ReadinjoyTabFrame$9
  implements Runnable
{
  ReadinjoyTabFrame$9(ReadinjoyTabFrame paramReadinjoyTabFrame, ReadInJoyBaseFragment paramReadInJoyBaseFragment) {}
  
  public void run()
  {
    if (this.a.getActivity() != null) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", true, NetConnInfoCenter.getServerTimeMillis() - ReadinjoyTabFrame.a(this.this$0), 0L, null, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.9
 * JD-Core Version:    0.7.0.1
 */