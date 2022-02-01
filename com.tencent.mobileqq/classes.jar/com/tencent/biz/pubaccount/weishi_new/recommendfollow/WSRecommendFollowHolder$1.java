package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class WSRecommendFollowHolder$1
  implements ActionSheet.OnButtonClickListener
{
  WSRecommendFollowHolder$1(WSRecommendFollowHolder paramWSRecommendFollowHolder) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.a(WSRecommendFollowHolder.a(this.a)))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    WSRecommendFollowHolder.c(this.a).a(WSRecommendFollowHolder.b(this.a).id, 2);
    WSRecommendFollowHolder.b(this.a).followStatus = 2;
    WSRecommendFollowHolder.d(this.a).setVisibility(0);
    WSRecommendFollowHolder.e(this.a).setVisibility(8);
    WSFollowBeaconReport.a("follow", WSRecommendFollowHolder.f(this.a) + 1, WSRecommendFollowHolder.b(this.a).id, WSReportEvent.ActionId.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowHolder.1
 * JD-Core Version:    0.7.0.1
 */