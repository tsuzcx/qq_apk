package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountAladdinUtils;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJTabFrameBase$markAccountCompleteAndShowToast$1
  implements Runnable
{
  RIJTabFrameBase$markAccountCompleteAndShowToast$1(RIJTabFrameBase paramRIJTabFrameBase) {}
  
  public final void run()
  {
    QQToast.a((Context)this.this$0.a(), 2, (CharSequence)RIJUGCAddAccountAladdinUtils.d(), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.markAccountCompleteAndShowToast.1
 * JD-Core Version:    0.7.0.1
 */