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
  public static long a = -2147483648L;
  public static GdtHandler.Params a;
  public static boolean a = false;
  private int jdField_a_of_type_Int = 0;
  WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder = null;
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
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
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder instanceof WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)))
    {
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder).setVisibility(8);
      }
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder).setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder instanceof WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)))
    {
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder).setVisibility(0);
      }
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder).setVisibility(0);
      }
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      return FastWeqAdUtils.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return -1;
  }
  
  protected BaseItemViewHolder a(View paramView, BaseData paramBaseData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder = new WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder(this, paramView, paramBaseData, this.jdField_a_of_type_JavaLangRefWeakReference);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder;
  }
  
  public void a()
  {
    a(true);
    this.jdField_a_of_type_Int = Aladdin.getConfig(341).getIntegerFromString("bottom_ad_style", 0);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.x;
    if (paramInt != 0) {
      return;
    }
    paramInt = paramAbsListView.getFirstVisiblePosition();
    int j = paramAbsListView.getLastVisiblePosition();
    if ((i >= paramInt) && (i <= j))
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
    if ((paramBaseData != null) && (paramBaseData.u == 17)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData = paramBaseData;
    }
    return bool;
  }
  
  public void b()
  {
    super.b();
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
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
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null))
    {
      FastWebVideoPlayManager.a.d();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder, null);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "bottomView create - item:  onDestroy");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder = null;
    }
  }
  
  public void e()
  {
    f();
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null))
    {
      FastWebVideoPlayManager.a.d();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder, null);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "bottomView create - item:  onFinishPage");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder = null;
    }
  }
  
  public void g()
  {
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null)) {
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a(false);
    }
  }
  
  public void h()
  {
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder localProteusItemViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder;
    if ((localProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(localProteusItemViewHolder) != null)) {
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator
 * JD-Core Version:    0.7.0.1
 */