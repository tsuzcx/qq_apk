package com.tencent.biz.pubaccount.readinjoy.push;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import qps;
import qpv;
import qpw;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isOpenPushNotify", "", "isDefaultOpen", "buttonId", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJPushNotifyManager$showPushNotifyDialog$param$1
  extends Lambda
  implements Function3<Boolean, Boolean, Integer, Unit>
{
  public RIJPushNotifyManager$showPushNotifyDialog$param$1(qps paramqps, BaseActivity paramBaseActivity, String paramString, int paramInt1, int paramInt2)
  {
    super(3);
  }
  
  public final void invoke(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3))
    {
      qps.a(this.this$0, paramBoolean1, paramBoolean2, (Activity)this.$topActivity);
      qpv.a.a().a(paramBoolean1, paramBoolean2, this.$uniqueId, this.$bizType, (Function1)RIJPushNotifyManager.showPushNotifyDialog.param.1.1.INSTANCE);
      qps.a(this.this$0, this.$bizType, this.$uniqueId, this.$guideType, paramInt, paramBoolean2);
    }
    while (paramInt != 3) {
      return;
    }
    qps.a(this.this$0, this.$bizType, this.$uniqueId, this.$guideType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.showPushNotifyDialog.param.1
 * JD-Core Version:    0.7.0.1
 */