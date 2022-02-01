package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

final class JumpAdUtils$1
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  JumpAdUtils$1(Context paramContext, AdData paramAdData) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ((IFastWebPTSUtils)QRoute.api(IFastWebPTSUtils.class)).disLikeAd(this.a, this.b);
    if (((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime() != null) && (paramArrayList != null))
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      paramInt = 0;
      while (paramInt < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
        paramObject = localObject1;
        paramView = (View)localObject2;
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
          paramObject = localObject1;
          paramView = (View)localObject2;
          if (paramInt != paramArrayList.size() - 1)
          {
            paramView = new StringBuilder();
            paramView.append((String)localObject2);
            paramView.append(",");
            paramView = paramView.toString();
            paramObject = new StringBuilder();
            paramObject.append((String)localObject1);
            paramObject.append(",");
            paramObject = paramObject.toString();
          }
        }
        paramInt += 1;
        localObject1 = paramObject;
        localObject2 = paramView;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.a).a(3).b(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getNativeAdExposureOrigin(this.b)).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(this.b)).a((String)localObject2).b((String)localObject1).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.b)));
      paramView = this.a;
      QQToast.makeText(paramView, -1, paramView.getString(2131897939), 0).show(((BaseActivity)this.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils.1
 * JD-Core Version:    0.7.0.1
 */