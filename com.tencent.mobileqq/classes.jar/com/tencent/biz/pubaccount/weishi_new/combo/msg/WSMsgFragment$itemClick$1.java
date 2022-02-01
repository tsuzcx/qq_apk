package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData.SectionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$itemClick$1", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$SchemeJumpListener;", "onJump", "", "actionId", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragment$itemClick$1
  implements WSMsgFragment.SchemeJumpListener
{
  WSMsgFragment$itemClick$1(WSMsgSectionData paramWSMsgSectionData) {}
  
  public void a(int paramInt)
  {
    WSMsgSectionData.SectionInfo localSectionInfo = this.a.c();
    Intrinsics.checkExpressionValueIsNotNull(localSectionInfo, "data.section");
    WSMsgBeaconReport.a(String.valueOf(localSectionInfo.a()), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment.itemClick.1
 * JD-Core Version:    0.7.0.1
 */