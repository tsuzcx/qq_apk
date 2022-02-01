package com.tencent.biz.pubaccount.readinjoy.push.mvp;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import qor;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJPushNotifyDialog$dismiss$1
  extends Lambda
  implements Function0<Unit>
{
  public RIJPushNotifyDialog$dismiss$1(qor paramqor)
  {
    super(0);
  }
  
  public final void invoke()
  {
    qor.a(this.this$0).removeView(qor.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog.dismiss.1
 * JD-Core Version:    0.7.0.1
 */