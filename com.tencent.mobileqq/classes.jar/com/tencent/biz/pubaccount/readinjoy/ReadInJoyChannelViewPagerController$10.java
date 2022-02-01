package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import ojc;
import oje;
import pkm;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(ojc paramojc, int paramInt) {}
  
  public void run()
  {
    ojc.b(this.this$0, true);
    ojc.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)ojc.b(this.this$0).get(this.a);
    ojc.b(this.this$0, localTabChannelCoverInfo);
    ojc.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    ojc.a(this.this$0).setCurrentItem(ojc.a, false);
    ojc.a(this.this$0).a(this.a, ojc.a, new oje(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */