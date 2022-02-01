package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import oqy;
import ora;
import pvj;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(oqy paramoqy, int paramInt) {}
  
  public void run()
  {
    oqy.b(this.this$0, true);
    oqy.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)oqy.b(this.this$0).get(this.a);
    oqy.b(this.this$0, localTabChannelCoverInfo);
    oqy.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    oqy.a(this.this$0).setCurrentItem(oqy.a, false);
    oqy.a(this.this$0).a(this.a, oqy.a, new ora(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */