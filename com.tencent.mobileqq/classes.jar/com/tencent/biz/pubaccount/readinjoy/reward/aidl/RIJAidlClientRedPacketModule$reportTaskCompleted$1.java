package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import rkd;
import rkw;
import rkz;
import rle;
import rlf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJAidlClientRedPacketModule$reportTaskCompleted$1
  extends Lambda
  implements Function0<Unit>
{
  public RIJAidlClientRedPacketModule$reportTaskCompleted$1(String paramString, int paramInt, rkd paramrkd)
  {
    super(0);
  }
  
  public final void invoke()
  {
    rkw localrkw = rle.a(rle.a);
    if (localrkw != null) {
      localrkw.a(this.$rowKey, this.$type, (rkz)new rlf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule.reportTaskCompleted.1
 * JD-Core Version:    0.7.0.1
 */