package com.tencent.biz.pubaccount.readinjoy.view.widget;

import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabBar$onPageChangeListener$1$onPageSelected$1
  implements Runnable
{
  RIJXTabBar$onPageChangeListener$1$onPageSelected$1(RIJXTabBar.onPageChangeListener.1 param1, int paramInt) {}
  
  public final void run()
  {
    List localList = RIJXTabFrameUtils.a();
    if ((this.a >= 0) && (this.a < localList.size()) && (((TabChannelCoverInfo)localList.get(this.a)).isImmersive)) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.a.a(bool, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar.onPageChangeListener.1.onPageSelected.1
 * JD-Core Version:    0.7.0.1
 */