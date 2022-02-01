package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AbsListView;

public class WebFastProteusViewAdBannerVideoCreator
  extends WebFastBaseProteusAdCreator
{
  public static boolean e = false;
  public static GdtHandler.Params f;
  public static long g = -2147483648L;
  WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder h = null;
  private int i = 0;
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void f()
  {
    a(false);
    f = null;
    g = -2147483648L;
  }
  
  private void i()
  {
    if ((this.i == 1) && ((this.c instanceof WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)))
    {
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.b((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.b((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c).setVisibility(8);
      }
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.c((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.c((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c).setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if ((this.i == 1) && ((this.c instanceof WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)))
    {
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.b((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.b((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c).setVisibility(0);
      }
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.c((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.c((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.c).setVisibility(0);
      }
    }
  }
  
  protected BaseItemViewHolder a(View paramView, BaseData paramBaseData)
  {
    if (this.h == null) {
      this.h = new WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder(this, paramView, paramBaseData, this.b);
    }
    return this.h;
  }
  
  public void a()
  {
    a(true);
    this.i = Aladdin.getConfig(341).getIntegerFromString("bottom_ad_style", 0);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.d == null) {
      return;
    }
    int j = this.d.aX;
    if (paramInt != 0) {
      return;
    }
    paramInt = paramAbsListView.getFirstVisiblePosition();
    int k = paramAbsListView.getLastVisiblePosition();
    if ((j >= paramInt) && (j <= k))
    {
      h();
      i();
      return;
    }
    g();
    j();
  }
  
  public boolean a(BaseData paramBaseData)
  {
    boolean bool;
    if ((paramBaseData != null) && (paramBaseData.aP == 17)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.d = paramBaseData;
    }
    return bool;
  }
  
  public int b(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      return FastWeqAdUtils.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return -1;
  }
  
  public void b()
  {
    super.b();
    f = null;
    g = -2147483648L;
    FastWebVideoPlayManager.a.b();
    i();
  }
  
  public void c()
  {
    super.c();
    FastWebVideoPlayManager.a.c();
  }
  
  public void d()
  {
    f();
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.h;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null))
    {
      FastWebVideoPlayManager.a.d();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.h).c();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.h, null);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "bottomView create - item:  onDestroy");
      this.h = null;
    }
  }
  
  public void e()
  {
    f();
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.h;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null))
    {
      FastWebVideoPlayManager.a.d();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.h).c();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.h, null);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "bottomView create - item:  onFinishPage");
      this.h = null;
    }
  }
  
  public void g()
  {
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.h;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null)) {
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.h).a(false);
    }
  }
  
  public void h()
  {
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.h;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null)) {
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.h).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator
 * JD-Core Version:    0.7.0.1
 */