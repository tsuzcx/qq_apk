package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo.NegFeedback;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.KandianPopupWindowForAd;
import java.util.ArrayList;
import java.util.Iterator;

public class NegativeHelper
  implements INegativeHelper
{
  private Activity a;
  private IAdapter b;
  private KandianPopupWindowForAd c;
  
  public NegativeHelper(Activity paramActivity, IAdapter paramIAdapter)
  {
    this.a = paramActivity;
    this.b = paramIAdapter;
    this.c = new KandianPopupWindowForAd(paramActivity);
  }
  
  public void a()
  {
    KandianPopupWindowForAd localKandianPopupWindowForAd = this.c;
    if ((localKandianPopupWindowForAd != null) && (localKandianPopupWindowForAd.isShowing())) {
      this.c.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    NegativeHelper.3 local3 = new NegativeHelper.3(this, paramInt, paramVideoInfo);
    if (!this.c.a()) {
      this.c.b();
    }
    Object localObject = this.c;
    int i = 0;
    ((KandianPopupWindowForAd)localObject).k = false;
    localObject = new ArrayList();
    if ((paramVideoInfo.as != null) && (paramVideoInfo.as.P != null)) {
      while (i < paramVideoInfo.as.P.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.e = ((VideoAdInfo.NegFeedback)paramVideoInfo.as.P.get(i)).a;
        localDislikeInfo.c = ((VideoAdInfo.NegFeedback)paramVideoInfo.as.P.get(i)).b;
        ((ArrayList)localObject).add(localDislikeInfo);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0)
    {
      ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.as);
      if (this.c.a(paramInt, (ArrayList)localObject)) {
        this.c.a(paramView, local3);
      }
    }
  }
  
  public void a(View paramView, int paramInt, Object paramObject)
  {
    a(paramView, paramInt, (VideoInfo)paramObject);
  }
  
  public void a(View paramView, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramView != null) && (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdDislikeInfos != null))
    {
      if (paramAdvertisementInfo.mAdDislikeInfos.size() == 0) {
        return;
      }
      NegativeHelper.1 local1 = new NegativeHelper.1(this, paramAdvertisementInfo);
      if (!this.c.a()) {
        this.c.b();
      }
      this.c.k = false;
      ArrayList localArrayList = new ArrayList();
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos.iterator();
      while (paramAdvertisementInfo.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.g = localAdDislikeInfo.g;
        localDislikeInfo.d = localAdDislikeInfo.d;
        localDislikeInfo.e = localAdDislikeInfo.e;
        localDislikeInfo.f = localAdDislikeInfo.f;
        localDislikeInfo.c = localAdDislikeInfo.c;
        localArrayList.add(localDislikeInfo);
      }
      if ((localArrayList.size() > 0) && (this.c.a(0, localArrayList)))
      {
        this.c.a(new NegativeHelper.2(this));
        this.c.a(paramView, local1);
      }
      this.c.c();
    }
  }
  
  public void b()
  {
    KandianPopupWindowForAd localKandianPopupWindowForAd = this.c;
    if ((localKandianPopupWindowForAd != null) && (localKandianPopupWindowForAd.isShowing())) {
      this.c.dismiss();
    }
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper
 * JD-Core Version:    0.7.0.1
 */