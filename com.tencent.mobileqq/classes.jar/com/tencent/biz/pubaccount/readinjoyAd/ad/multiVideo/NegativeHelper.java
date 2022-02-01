package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.IAdapter;
import com.tencent.widget.KandianPopupWindowForAd;
import java.util.ArrayList;

public class NegativeHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private IAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoIAdapter;
  private KandianPopupWindowForAd jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd;
  
  public NegativeHelper(Activity paramActivity, IAdapter paramIAdapter)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoIAdapter = paramIAdapter;
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = new KandianPopupWindowForAd(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    NegativeHelper.2 local2 = new NegativeHelper.2(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a()) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a();
    }
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.b = false;
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoInfo.a != null) && (paramVideoInfo.a.e != null))
    {
      int i = 0;
      while (i < paramVideoInfo.a.e.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_Long = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_Long;
        localDislikeInfo.jdField_a_of_type_JavaLangString = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_JavaLangString;
        localArrayList.add(localDislikeInfo);
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      NativeAdUtils.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a(paramView, local2);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper
 * JD-Core Version:    0.7.0.1
 */