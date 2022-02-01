package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySocializeRecommendFollowView$1
  implements ViewBase.OnClickListener
{
  ReadInJoySocializeRecommendFollowView$1(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ReadInJoySocializeRecommendFollowView.a(this.a, false);
    ReadInJoySocializeRecommendFollowView.a(this.a);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800984B", "0X800984B", 0, 0, "1", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.1
 * JD-Core Version:    0.7.0.1
 */