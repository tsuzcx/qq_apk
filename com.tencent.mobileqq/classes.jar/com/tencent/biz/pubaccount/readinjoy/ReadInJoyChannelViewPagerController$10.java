package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import nia;
import nic;
import ogy;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(nia paramnia, int paramInt) {}
  
  public void run()
  {
    nia.b(this.this$0, true);
    nia.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)nia.b(this.this$0).get(this.a);
    nia.b(this.this$0, localTabChannelCoverInfo);
    nia.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    nia.a(this.this$0).setCurrentItem(nia.a, false);
    nia.a(this.this$0).a(this.a, nia.a, new nic(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */