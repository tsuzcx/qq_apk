package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$9$1(ReadInJoySocializeRecommendFollowView.9 param9) {}
  
  public void run()
  {
    ReadInJoySocializeRecommendFollowView.a(this.a.a).requestLayout();
    ReadInJoySocializeRecommendFollowView.a(this.a.a, true);
    if (!ReadInJoySocializeRecommendFollowView.a(this.a.a).mRecommendFollowInfos.b)
    {
      ReadInJoySocializeRecommendFollowView.a(this.a.a).mRecommendFollowInfos.b = true;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */