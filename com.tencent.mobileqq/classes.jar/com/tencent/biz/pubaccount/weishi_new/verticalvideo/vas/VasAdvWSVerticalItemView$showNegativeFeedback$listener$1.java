package com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas;

import com.tencent.ad.tangram.AdError;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.gdtad.api.feedback.GdtFeedbackListener;
import com.tencent.gdtad.api.feedback.GdtFeedbackResultParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "params", "Lcom/tencent/gdtad/api/feedback/GdtFeedbackResultParams;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class VasAdvWSVerticalItemView$showNegativeFeedback$listener$1
  implements GdtFeedbackListener
{
  VasAdvWSVerticalItemView$showNegativeFeedback$listener$1(VasAdvWSVerticalItemView paramVasAdvWSVerticalItemView) {}
  
  public final void a(GdtFeedbackResultParams paramGdtFeedbackResultParams)
  {
    if (paramGdtFeedbackResultParams != null)
    {
      localObject = paramGdtFeedbackResultParams.a;
      if ((localObject != null) && (((AdError)localObject).getErrorCode() == 0))
      {
        if (paramGdtFeedbackResultParams.b != 3) {
          return;
        }
        paramGdtFeedbackResultParams = this.a.e;
        if (paramGdtFeedbackResultParams == null) {
          return;
        }
        paramGdtFeedbackResultParams = paramGdtFeedbackResultParams.b();
        if (paramGdtFeedbackResultParams == null) {
          return;
        }
        paramGdtFeedbackResultParams.removeItem(VasAdvWSVerticalItemView.a(this.a));
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[showNegativeFeedback::onResult] start feedback view fail, errorCode=");
    if (paramGdtFeedbackResultParams != null)
    {
      paramGdtFeedbackResultParams = paramGdtFeedbackResultParams.a;
      if (paramGdtFeedbackResultParams != null)
      {
        paramGdtFeedbackResultParams = Integer.valueOf(paramGdtFeedbackResultParams.getErrorCode());
        break label102;
      }
    }
    paramGdtFeedbackResultParams = null;
    label102:
    ((StringBuilder)localObject).append(paramGdtFeedbackResultParams);
    QLog.i("VasAdvWSVerticalItemView", 4, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalItemView.showNegativeFeedback.listener.1
 * JD-Core Version:    0.7.0.1
 */