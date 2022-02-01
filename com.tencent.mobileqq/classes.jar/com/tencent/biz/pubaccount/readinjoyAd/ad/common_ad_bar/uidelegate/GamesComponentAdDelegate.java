package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.GameGiftsImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.FeedBackClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class GamesComponentAdDelegate
  extends IUIDelegate
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GameGiftsImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView;
  private RIJDownloadView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public GamesComponentAdDelegate(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void a(AdData paramAdData)
  {
    boolean bool = FastWeqAdUtils.e(paramAdData);
    long l2 = 6L;
    long l1;
    if (bool)
    {
      l1 = 7L;
      long l3 = 3010203L;
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      break label77;
      if (FastWeqAdUtils.c(paramAdData))
      {
        l1 = 3010303L;
      }
      else if (FastWeqAdUtils.f(paramAdData))
      {
        l1 = 3010403L;
      }
      else
      {
        l1 = l2;
        if (!FastWeqAdUtils.g(paramAdData)) {
          break;
        }
        l1 = 3010503L;
      }
    }
    label77:
    AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
    if (localAdvertisementInfo == null) {
      return;
    }
    GameComponentReport.a(localAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdData), GameComponentReport.a(paramAdData, l1, l2, null, "1"), ReportAction.EXPOSE, ActionEntity.ArticleFloat, Integer.valueOf(0));
  }
  
  public int a()
  {
    return 2131559137;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368343));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378784));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView = ((GameGiftsImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367716));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367476));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365856));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366743));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setInFloatingBar(true);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.o == 1);
  }
  
  public void b()
  {
    a(new View[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_a_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new GamesComponentAdDelegate.1(this));
  }
  
  public void b(AdData paramAdData)
  {
    super.b(paramAdData);
    if (paramAdData.a != null)
    {
      ReadInJoyCommonSoftAdUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentImageURLImageView, paramAdData.a.k, 12, 48, -1);
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramAdData.a.jdField_a_of_type_JavaLangString);
      a(this.jdField_b_of_type_AndroidWidgetTextView, paramAdData.a.h);
      if (FastWeqAdUtils.c(paramAdData))
      {
        Object localObject = new ArrayList();
        if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.d)) {
          ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.d);
        }
        if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.e)) {
          ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.e);
        }
        if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.f)) {
          ((ArrayList)localObject).add(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.f);
        }
        if (((ArrayList)localObject).size() > 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setImages((ArrayList)localObject);
        }
        if (!TextUtils.isEmpty(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.g)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAdData.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo.g);
        }
        localObject = this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((localObject instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else if (FastWeqAdUtils.e(paramAdData))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barGameGiftsImageView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle(HorizontalProgressStyle.FastWebGameStyle);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    boolean bool = FastWeqAdUtils.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData);
    long l1 = 3010203L;
    long l3 = 6L;
    long l2;
    if (bool) {
      l2 = 7L;
    }
    for (;;)
    {
      break;
      if (FastWeqAdUtils.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData))
      {
        l1 = 3010303L;
        l2 = l3;
      }
      else if (FastWeqAdUtils.f(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData))
      {
        l1 = 3010403L;
        l2 = l3;
      }
      else
      {
        l2 = l3;
        if (FastWeqAdUtils.g(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData))
        {
          l1 = 3010503L;
          l2 = l3;
        }
      }
    }
    GameComponentReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(), ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData), GameComponentReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData, l1, l2, null, "1"), ReportAction.EXPOSE, ActionEntity.ArticleFloat, Integer.valueOf(0));
    super.d();
  }
  
  public void e()
  {
    super.e();
    RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.a();
    }
  }
  
  public void f()
  {
    super.f();
    RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    long l;
    if (i != 2131365856)
    {
      if (i != 2131366743) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCallbackFeedBackClickListener != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCallbackFeedBackClickListener.b();
        boolean bool = FastWeqAdUtils.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData);
        l = 3010208L;
        if (!bool) {
          for (;;)
          {
            if (FastWeqAdUtils.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData)) {
              l = 3010308L;
            } else if (FastWeqAdUtils.f(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData)) {
              l = 3010408L;
            } else if (FastWeqAdUtils.g(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData)) {
              l = 3010506L;
            }
          }
        }
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
        if (paramView != null)
        {
          paramView.adClickPos = AdClickPos.SoftAdClose;
          GameComponentReport.b(Integer.valueOf(0), paramView, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData), GameComponentReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData, l, 9L, null, "1"));
        }
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)
    {
      if ((!RIJAdDownloadExKt.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (!RIJAdDownloadExKt.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (!RIJAdDownloadExKt.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
      {
        paramView = Integer.valueOf(0);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          paramView = ReadInJoyAdJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        l = 3010404L;
        if (FastWeqAdUtils.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          l = 3010205L;
        }
        for (;;)
        {
          break;
          if (FastWeqAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            l = 3010305L;
          } else if (FastWeqAdUtils.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            l = 3010405L;
          } else if (FastWeqAdUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            l = 3010505L;
          }
        }
        GameComponentReport.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), GameComponentReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, l, 9L, "", "1"));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(AdClickPos.SoftAdClickBtn, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate
 * JD-Core Version:    0.7.0.1
 */