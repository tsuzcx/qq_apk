package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.widget.AbsListView;

public class WebFastProteusViewAdBannerVideoCreator
  extends WebFastBaseProteusAdCreator
{
  public static long a;
  public static GdtHandler.Params a;
  public static boolean a;
  private int jdField_a_of_type_Int = 0;
  WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder = null;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Long = -2147483648L;
  }
  
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
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder instanceof WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)))
    {
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder).setVisibility(8);
      }
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder).setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder instanceof WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)))
    {
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder).setVisibility(0);
      }
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder) != null) {
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a((WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder).setVisibility(0);
      }
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      i = FastWeqAdUtils.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return i;
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.u;
    switch (paramInt)
    {
    default: 
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
    if ((paramBaseData != null) && (paramBaseData.s == 17)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      }
      return bool;
    }
  }
  
  public void b()
  {
    super.b();
    ReadinJoyActionUtil.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
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
    
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) != null))
    {
      FastWebVideoPlayManager.a.d();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder, null);
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "bottomView create - item:  onDestroy");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder = null;
    }
  }
  
  public void e()
  {
    
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) != null))
    {
      FastWebVideoPlayManager.a.d();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a();
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder, null);
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "bottomView create - item:  onFinishPage");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder = null;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) != null)) {
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a(false);
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder != null) && (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) != null)) {
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator
 * JD-Core Version:    0.7.0.1
 */