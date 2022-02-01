package com.tencent.biz.pubaccount.readinjoy.push;

import com.tencent.TMG.utils.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import qii;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyManager$showPushNotifyDialogForWeb$param$1$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  RIJPushNotifyManager$showPushNotifyDialogForWeb$param$1$1(RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1 param1, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    this.this$0.$callback.a(this.$buttonId, paramInt);
    QLog.i("RIJPushNotifyManager", 1, " resultCallback buttonId: " + this.$buttonId + " errorCode: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1.1
 * JD-Core Version:    0.7.0.1
 */