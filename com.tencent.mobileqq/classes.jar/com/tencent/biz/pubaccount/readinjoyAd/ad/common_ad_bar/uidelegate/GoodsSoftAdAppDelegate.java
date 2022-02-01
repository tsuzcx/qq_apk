package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.ReadInJoyAdActionManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.FeedBackClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class GoodsSoftAdAppDelegate
  extends IUIDelegate
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJDownloadView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public GoodsSoftAdAppDelegate(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(AdClickPos paramAdClickPos)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(paramAdClickPos);
      ReadInJoyAdActionManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext, 35, 1, 4, null);
    }
  }
  
  public int a()
  {
    return 2131562845;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368343));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378784));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365517));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366743));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365856));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setInFloatingBar(true);
    }
  }
  
  public void b()
  {
    a(new View[] { this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_b_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new GoodsSoftAdAppDelegate.1(this));
  }
  
  public void b(AdData paramAdData)
  {
    super.b(paramAdData);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (paramAdData != null))
    {
      if (paramAdData.b == null) {
        return;
      }
      String str1 = paramAdData.b.optString("adImg", "");
      String str2 = paramAdData.b.optString("goodsName", "");
      String str3 = paramAdData.b.optString("buttonTxt", "");
      ReadInJoyCommonSoftAdUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetImageView, str1, 8, 30, -1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str3);
      paramAdData = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
      if (paramAdData == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setAdvertisementInfo(paramAdData);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle(RoundProgressStyle.FastWebSoftAd);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    ReadInJoyAdReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 35, 1, 4);
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
    switch (paramView.getId())
    {
    default: 
    case 2131366743: 
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCallbackFeedBackClickListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCallbackFeedBackClickListener.b();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adClickPos = AdClickPos.SoftAdClose;
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 35, 1, 4);
        return;
      }
      break;
    case 2131365856: 
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(AdClickPos.SoftAdClickBtn, 8);
          return;
        }
        a(AdClickPos.SoftAdClickBtn);
        return;
      }
      break;
    case 2131365517: 
    case 2131368343: 
    case 2131378784: 
      a(AdClickPos.SoftAdComponent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate
 * JD-Core Version:    0.7.0.1
 */