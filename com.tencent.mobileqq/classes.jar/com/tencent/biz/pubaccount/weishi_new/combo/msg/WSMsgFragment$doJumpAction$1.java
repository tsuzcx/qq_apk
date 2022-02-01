package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import UserGrowth.stMsgContentPersonInfo;
import UserGrowth.stNotifyMsg;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$doJumpAction$1", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$SchemeJumpListener;", "onJump", "", "actionId", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragment$doJumpAction$1
  implements WSMsgFragment.SchemeJumpListener
{
  WSMsgFragment$doJumpAction$1(WSMsgSectionData paramWSMsgSectionData) {}
  
  public void a(int paramInt)
  {
    String str1 = this.a.d().msgID;
    Intrinsics.checkExpressionValueIsNotNull(str1, "data.msgInfo.msgID");
    int i = this.a.b();
    Object localObject = this.a.d().oper;
    if (localObject != null)
    {
      localObject = ((stMsgContentPersonInfo)localObject).PID;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    String str2 = this.a.d().contentFeedID;
    Intrinsics.checkExpressionValueIsNotNull(str2, "data.msgInfo.contentFeedID");
    WSMsgBeaconReport.a(str1, String.valueOf(i), (String)localObject, paramInt, str2, this.a.d().flag, this.a.d().delFlag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment.doJumpAction.1
 * JD-Core Version:    0.7.0.1
 */