package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import ogh;
import ogj;
import pmh;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(ogh paramogh, int paramInt) {}
  
  public void run()
  {
    ogh.b(this.this$0, true);
    ogh.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)ogh.b(this.this$0).get(this.a);
    ogh.b(this.this$0, localTabChannelCoverInfo);
    ogh.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    ogh.a(this.this$0).setCurrentItem(ogh.a, false);
    ogh.a(this.this$0).a(this.a, ogh.a, new ogj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */