package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import ntk;
import ntm;
import osj;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(ntk paramntk, int paramInt) {}
  
  public void run()
  {
    ntk.b(this.this$0, true);
    ntk.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)ntk.b(this.this$0).get(this.a);
    ntk.b(this.this$0, localTabChannelCoverInfo);
    ntk.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    ntk.a(this.this$0).setCurrentItem(ntk.a, false);
    ntk.a(this.this$0).a(this.a, ntk.a, new ntm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */