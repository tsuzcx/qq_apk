package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import nwm;
import nwo;
import owy;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(nwm paramnwm, int paramInt) {}
  
  public void run()
  {
    nwm.b(this.this$0, true);
    nwm.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)nwm.b(this.this$0).get(this.a);
    nwm.b(this.this$0, localTabChannelCoverInfo);
    nwm.a(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    nwm.a(this.this$0).setCurrentItem(nwm.a, false);
    nwm.a(this.this$0).a(this.a, nwm.a, new nwo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */