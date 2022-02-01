package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class NegativeHelper$1
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  NegativeHelper$1(NegativeHelper paramNegativeHelper, AdvertisementInfo paramAdvertisementInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = NegativeHelper.a(this.b);
    paramInt = 0;
    QQToast.makeText(paramView, 0, 2131892901, 0).show();
    long l;
    if ((paramObject != null) && ((paramObject instanceof DislikeInfo))) {
      l = ((DislikeInfo)paramObject).e;
    } else {
      l = 0L;
    }
    Object localObject2 = "";
    for (Object localObject1 = ""; paramInt < paramArrayList.size(); localObject1 = paramView)
    {
      DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
      paramObject = localObject2;
      paramView = (View)localObject1;
      if (localDislikeInfo != null)
      {
        paramView = new StringBuilder();
        paramView.append((String)localObject2);
        paramView.append(localDislikeInfo.e);
        localObject2 = paramView.toString();
        paramView = new StringBuilder();
        paramView.append((String)localObject1);
        paramView.append(localDislikeInfo.c);
        localObject1 = paramView.toString();
        paramObject = localObject2;
        paramView = (View)localObject1;
        if (paramInt != paramArrayList.size() - 1)
        {
          paramView = new StringBuilder();
          paramView.append((String)localObject2);
          paramView.append(",");
          paramObject = paramView.toString();
          paramView = new StringBuilder();
          paramView.append((String)localObject1);
          paramView.append(",");
          paramView = paramView.toString();
        }
      }
      paramInt += 1;
      localObject2 = paramObject;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(NegativeHelper.a(this.b)).a(3).b(5).a(this.a).a(l).a((String)localObject2).b((String)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper.1
 * JD-Core Version:    0.7.0.1
 */