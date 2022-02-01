package com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas;

import cooperation.vip.VasResultCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalItemView$exposureResultCallback$1", "Lcooperation/vip/VasResultCallback;", "", "onResult", "", "result", "(Ljava/lang/Boolean;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWSVerticalItemView$exposureResultCallback$1
  implements VasResultCallback<Boolean>
{
  public void a(@Nullable Boolean paramBoolean)
  {
    paramBoolean = VasAdvWSVerticalItemView.a(this.a);
    if (paramBoolean != null) {
      paramBoolean.isGdtAdImpressionReport = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalItemView.exposureResultCallback.1
 * JD-Core Version:    0.7.0.1
 */