package com.tencent.mobileqq.activity.aio.intimate.view;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo.LoveAchievementItem;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;

class IntimateContentItemLoverAchievementView$1
  implements IntimateContentItemLoverAchievementView.CoupleAchievementItemListener
{
  IntimateContentItemLoverAchievementView$1(IntimateContentItemLoverAchievementView paramIntimateContentItemLoverAchievementView) {}
  
  public void a(View paramView, int paramInt, LoveAchievementInfo.LoveAchievementItem paramLoveAchievementItem)
  {
    paramView = FriendIntimateRelationshipConfProcessor.a().T;
    if (!TextUtils.isEmpty(paramView))
    {
      IntimateContentItemLoverAchievementView.a(this.a);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a.a, paramView, 2064, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView.1
 * JD-Core Version:    0.7.0.1
 */