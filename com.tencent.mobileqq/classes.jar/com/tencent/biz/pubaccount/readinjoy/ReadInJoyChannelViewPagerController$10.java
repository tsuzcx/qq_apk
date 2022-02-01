package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import ohp;
import ohr;
import pfa;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(ohp paramohp, int paramInt) {}
  
  public void run()
  {
    ohp.b(this.this$0, true);
    ohp.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)ohp.b(this.this$0).get(this.a);
    ohp.b(this.this$0, localTabChannelCoverInfo);
    ohp.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    ohp.a(this.this$0).setCurrentItem(ohp.a, false);
    ohp.a(this.this$0).a(this.a, ohp.a, new ohr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */