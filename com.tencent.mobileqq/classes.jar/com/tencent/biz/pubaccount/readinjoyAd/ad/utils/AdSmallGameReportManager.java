package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IAdSmallGameReportManager;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo.SmallMiniGameData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.CopyOnWriteArrayList;

public class AdSmallGameReportManager
  implements IAdSmallGameReportManager
{
  private CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList();
  
  public void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, int paramInt1, int paramInt2)
  {
    if ((this.a != null) && (paramIReadInJoyModel.k() != null) && (paramIReadInJoyModel.k().mSmallMiniGameInfo != null))
    {
      if (paramIReadInJoyModel.k().mSmallMiniGameInfo.y == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramIReadInJoyModel.k().mSmallMiniGameInfo.b);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(((SmallMiniGameInfo.SmallMiniGameData)paramIReadInJoyModel.k().mSmallMiniGameInfo.y.get(paramInt1)).a);
      localObject = ((StringBuilder)localObject).toString();
      if (!this.a.contains(localObject))
      {
        this.a.add(localObject);
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(paramContext, paramIReadInJoyModel.k(), paramIReadInJoyModel.r(), paramInt1, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdSmallGameReportManager
 * JD-Core Version:    0.7.0.1
 */