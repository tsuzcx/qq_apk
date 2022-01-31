package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import nth;
import ntj;
import osg;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(nth paramnth, int paramInt) {}
  
  public void run()
  {
    nth.b(this.this$0, true);
    nth.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)nth.b(this.this$0).get(this.a);
    nth.b(this.this$0, localTabChannelCoverInfo);
    nth.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    nth.a(this.this$0).setCurrentItem(nth.a, false);
    nth.a(this.this$0).a(this.a, nth.a, new ntj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */