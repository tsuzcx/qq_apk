package com.tencent.biz.pubaccount.readinjoy.push.mvp;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyDialog$dismiss$1
  extends Lambda
  implements Function0<Unit>
{
  RIJPushNotifyDialog$dismiss$1(RIJPushNotifyDialog paramRIJPushNotifyDialog)
  {
    super(0);
  }
  
  public final void invoke()
  {
    RIJPushNotifyDialog.a(this.this$0).removeView(RIJPushNotifyDialog.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog.dismiss.1
 * JD-Core Version:    0.7.0.1
 */