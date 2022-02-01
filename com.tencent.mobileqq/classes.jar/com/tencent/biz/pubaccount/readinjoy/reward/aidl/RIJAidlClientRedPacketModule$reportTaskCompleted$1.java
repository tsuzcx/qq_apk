package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import qxx;
import qyq;
import qyt;
import qyy;
import qyz;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJAidlClientRedPacketModule$reportTaskCompleted$1
  extends Lambda
  implements Function0<Unit>
{
  public RIJAidlClientRedPacketModule$reportTaskCompleted$1(String paramString, int paramInt, qxx paramqxx)
  {
    super(0);
  }
  
  public final void invoke()
  {
    qyq localqyq = qyy.a(qyy.a);
    if (localqyq != null) {
      localqyq.a(this.$rowKey, this.$type, (qyt)new qyz(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule.reportTaskCompleted.1
 * JD-Core Version:    0.7.0.1
 */