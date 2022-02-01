package com.tencent.biz.pubaccount.readinjoy.push;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isOpenPushNotify", "", "isDefaultOpen", "buttonId", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyManager$showPushNotifyDialogForWeb$param$1
  extends Lambda
  implements Function3<Boolean, Boolean, Integer, Unit>
{
  RIJPushNotifyManager$showPushNotifyDialogForWeb$param$1(RIJPushNotifyManager paramRIJPushNotifyManager, BaseActivity paramBaseActivity, String paramString, int paramInt1, RIJPushNotifyManager.IPushNotifyDialogCallback paramIPushNotifyDialogCallback, int paramInt2)
  {
    super(3);
  }
  
  public final void invoke(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3))
    {
      RIJPushNotifyManager.a(this.this$0, paramBoolean1, paramBoolean2, (Activity)this.$topActivity);
      RIJPushNotifyModule.a.a().a(paramBoolean1, paramBoolean2, this.$uniqueId, this.$bizType, (Function1)new RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1.1(this, paramInt));
      RIJPushNotifyManager.a(this.this$0, this.$bizType, this.$uniqueId, this.$guideType, paramInt, paramBoolean2);
      return;
    }
    if (paramInt == 3) {
      RIJPushNotifyManager.a(this.this$0, this.$bizType, this.$uniqueId, this.$guideType);
    }
    this.$callback.a(0, -1);
    QLog.i("RIJPushNotifyManager", 1, " resultCallback buttonId: " + paramInt + " errorCode: -1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1
 * JD-Core Version:    0.7.0.1
 */