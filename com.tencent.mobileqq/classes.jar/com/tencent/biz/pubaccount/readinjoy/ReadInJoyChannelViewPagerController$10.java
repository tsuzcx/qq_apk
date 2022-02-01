package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;

class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  ReadInJoyChannelViewPagerController$10(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController, int paramInt) {}
  
  public void run()
  {
    ReadInJoyChannelViewPagerController.b(this.this$0, true);
    ReadInJoyChannelViewPagerController.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)ReadInJoyChannelViewPagerController.b(this.this$0).get(this.a);
    ReadInJoyChannelViewPagerController.b(this.this$0, localTabChannelCoverInfo);
    ReadInJoyChannelViewPagerController.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    ReadInJoyChannelViewPagerController.a(this.this$0).setCurrentItem(ReadInJoyChannelViewPagerController.a, false);
    ReadInJoyChannelViewPagerController.a(this.this$0).a(this.a, ReadInJoyChannelViewPagerController.a, new ReadInJoyChannelViewPagerController.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */