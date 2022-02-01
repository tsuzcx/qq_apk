package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import UserGrowth.stMsgRedDotCount;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$onClick$3", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$SchemeJumpListener;", "onJump", "", "actionId", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragment$onClick$3
  implements WSMsgFragment.SchemeJumpListener
{
  WSMsgFragment$onClick$3(stMsgRedDotCount paramstMsgRedDotCount) {}
  
  public void a(int paramInt)
  {
    stMsgRedDotCount localstMsgRedDotCount = this.a;
    int i;
    if (localstMsgRedDotCount != null) {
      i = localstMsgRedDotCount.count;
    } else {
      i = 0;
    }
    WSMsgBeaconReport.b(i, 3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment.onClick.3
 * JD-Core Version:    0.7.0.1
 */