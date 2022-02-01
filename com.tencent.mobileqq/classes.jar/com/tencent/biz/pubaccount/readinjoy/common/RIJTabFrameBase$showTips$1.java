package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCTipsUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJTabFrameBase$showTips$1
  implements Runnable
{
  RIJTabFrameBase$showTips$1(RIJTabFrameBase paramRIJTabFrameBase) {}
  
  public final void run()
  {
    this.this$0.B_();
    if ((RIJUgcUtils.m()) && (RIJTabFrameBase.a.a()))
    {
      RIJUGCTipsUtils.a((Activity)this.this$0.a());
      RIJUGCAddAccountFragment.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.showTips.1
 * JD-Core Version:    0.7.0.1
 */