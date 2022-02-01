package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.model.RIJUGCAccountCreateModule.UGCAccountCreateCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "ugcAccountCreateResult"}, k=3, mv={1, 1, 16})
final class RIJTabFrameBase$requestUgcAccountCreate$1
  implements RIJUGCAccountCreateModule.UGCAccountCreateCallback
{
  RIJTabFrameBase$requestUgcAccountCreate$1(RIJTabFrameBase paramRIJTabFrameBase) {}
  
  public final void a(int paramInt)
  {
    if (paramInt == 0) {
      this.a.j();
    }
    QLog.d("ReadInJoyTabFrame", 2, "ugcAccountCreateResult result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.requestUgcAccountCreate.1
 * JD-Core Version:    0.7.0.1
 */