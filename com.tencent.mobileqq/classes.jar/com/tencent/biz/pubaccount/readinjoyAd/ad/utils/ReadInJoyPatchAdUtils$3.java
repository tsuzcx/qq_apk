package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticlePatchStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFullPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.CountDownCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView.PatchAdListener;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class ReadInJoyPatchAdUtils$3
  implements ReadInJoyPatchAdView.PatchAdListener
{
  ReadInJoyPatchAdUtils$3(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, VideoUIManager paramVideoUIManager, VideoPlayManager paramVideoPlayManager, VideoUIManager.CountDownCallback paramCountDownCallback, VideoFullPlayController paramVideoFullPlayController, ReadInJoyPatchAdUtils.OnPatchPlayListener paramOnPatchPlayListener) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyPatchAdUtils.a, 2, "onStart: id = " + paramVideoPlayParam.a.mArticleID);
    }
    ReadInJoyPatchAdUtils.a(paramVideoPlayParam, paramInt, 1);
    ReadInJoyPatchAdUtils.b();
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramVideoPlayParam.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      paramVideoPlayParam = ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a, null, 3, true, null);
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(1).b(8).b(paramVideoPlayParam).c(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a));
      return;
      paramVideoPlayParam.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    int i = 1;
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {}
    for (;;)
    {
      return;
      if ((paramInt == 1) && (!paramVideoPlayParam.a.patchStatus.c.get()))
      {
        paramVideoPlayParam.a.patchStatus.c.set(true);
        paramInt = i;
      }
      while (paramInt != 0)
      {
        NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(2).b(4).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a).e(new JSONObject()));
        return;
        if ((paramInt == 2) && (!paramVideoPlayParam.a.patchStatus.d.get()))
        {
          paramVideoPlayParam.a.patchStatus.d.set(true);
          paramInt = i;
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(ReadInJoyPatchAdUtils.a, 2, "onCompletion: id = " + paramVideoPlayParam.a.mArticleID);
        }
        ReadInJoyPatchAdUtils.a(paramVideoPlayParam, paramInt1, 3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
        if (paramInt1 != 1) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a() != paramVideoPlayParam);
      switch (paramInt2)
      {
      default: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramVideoPlayParam);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      return;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback == null) || (paramInt2 != 0));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback.a(paramVideoPlayParam);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.c();
  }
  
  public void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(ReadInJoyPatchAdUtils.a, 2, "onResume: id = " + paramVideoPlayParam.a.mArticleID);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        ReadInJoyPatchAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2);
    ReadInJoyPatchAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager, false, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$CountDownCallback, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoyPatchAdUtils$OnPatchPlayListener);
  }
  
  public void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyPatchAdUtils.a, 2, "onPause: id = " + paramVideoPlayParam.a.mArticleID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
      }
      ReadInJoyPatchAdUtils.c();
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils.3
 * JD-Core Version:    0.7.0.1
 */