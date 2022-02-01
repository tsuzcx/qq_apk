package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VideoFeedsSoftAdBarController
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsSoftAdBarController.VideoFeedsSoftAdBarDelegateBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase;
  private VideoFeedsSoftAdBarDelegateForNormal jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
  private VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder;
  private VideoFeedsSoftAdBarDelegateForAd jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  
  public VideoFeedsSoftAdBarController(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = AIOUtils.a(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd = new VideoFeedsSoftAdBarDelegateForAd();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal = new VideoFeedsSoftAdBarDelegateForNormal();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private VideoFeedsSoftAdBarController.VideoFeedsSoftAdBarDelegateBase a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd) {
      do
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase;
      } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSamleGameShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = paramVideoItemHolder;
    try
    {
      Object localObject;
      if ((paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup == null) && ((paramVideoItemHolder instanceof ShortVideoItemHolder)))
      {
        paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131381337)).inflate()).findViewById(2131381494)).inflate());
        int i = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
        paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
        paramVideoItemHolder.g = ((URLImageView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368390));
        paramVideoItemHolder.H = ((TextView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368398));
        paramVideoItemHolder.I = ((TextView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368397));
        paramVideoItemHolder.t = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131370612);
        paramVideoItemHolder.u = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368396);
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368387));
        paramVideoItemHolder.jdField_v_of_type_AndroidViewView = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368389);
        paramVideoItemHolder.J = ((TextView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131367703));
        paramVideoItemHolder.w = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131367717);
        paramVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131362137));
      }
      if ((paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup != null) && (paramVideoItemHolder.g != null) && (paramVideoItemHolder.H != null) && (paramVideoItemHolder.I != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView != null) && (paramVideoItemHolder.u != null))
      {
        paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject = "";
        if (a() != null) {
          localObject = a().a();
        }
        a(paramVideoItemHolder.g, (String)localObject, this.jdField_a_of_type_Int, 18, 18, -1, this.jdField_a_of_type_AndroidAppActivity);
        String str = "";
        localObject = str;
        if (a() != null)
        {
          localObject = str;
          if (a().b() != null) {
            localObject = a().b();
          }
        }
        paramVideoItemHolder.H.setText((CharSequence)localObject);
        paramVideoItemHolder.H.setVisibility(0);
        paramVideoItemHolder.g.setVisibility(0);
        localObject = "";
        if (a() != null) {
          localObject = a().a();
        }
        paramVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
        paramVideoItemHolder.I.setText((CharSequence)localObject);
        paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setOnClickListener(this);
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
        paramVideoItemHolder.u.setTag(paramVideoItemHolder);
        paramVideoItemHolder.u.setOnClickListener(this);
        VideoFeedsHelper.a(paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup, 200);
        if ((a() != null) && (!TextUtils.isEmpty(a().c())) && (paramVideoItemHolder.J != null)) {
          paramVideoItemHolder.J.setText(a().c());
        }
        if (a() != null) {
          a().a(paramVideoInfo, paramVideoItemHolder);
        }
      }
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      QLog.e("VideoFeedsSoftAdBarController", 2, "show shunt bar error:" + paramVideoInfo.getMessage());
    }
  }
  
  public static void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (paramInt4 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawableOptions.mRequestWidth = AIOUtils.a(paramInt2, paramActivity.getResources());
          localURLDrawableOptions.mRequestHeight = AIOUtils.a(paramInt3, paramActivity.getResources());
          paramActivity = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
          if (paramInt4 != 0) {
            continue;
          }
          paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
          paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
          paramActivity.setTag(new int[] { 0, 0, paramInt1, 1 });
          paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          paramActivity.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
          continue;
        }
        paramURLImageView.setImageDrawable(paramActivity);
        return;
        if (paramInt4 != 1) {
          continue;
        }
        paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
        paramActivity.setTag(new int[] { 0, 0, paramInt1, 3 });
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSoftAdShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = paramVideoItemHolder;
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.b(paramVideoItemHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.c(paramVideoItemHolder);
      if (paramVideoItemHolder.y != null)
      {
        VideoFeedsHelper.a(paramVideoItemHolder.y, 200);
        if (a() != null) {
          a().a(paramVideoInfo, paramVideoItemHolder);
        }
      }
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramVideoInfo.getMessage());
    }
  }
  
  private void b(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup != null) && (paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
      if ((this.jdField_a_of_type_Boolean) && (a() != null) && (a().a(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_Int);
      }
    }
    while ((paramVideoInfo == null) || (a() == null) || (!a().a()) || (!a().a(paramVideoInfo))) {
      return;
    }
    a(paramVideoInfo, paramVideoItemHolder);
  }
  
  private void c(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.y != null) && (paramVideoItemHolder.y.getVisibility() == 0)) {
      if ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong))) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.a(paramVideoItemHolder);
        return;
      }
      catch (Exception paramVideoInfo)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.f();
        QLog.d("VideoFeedsSoftAdBarController", 2, "big Card show error");
        return;
      }
      if ((paramVideoInfo == null) || (a() == null) || (!a().a()) || (!a().a(paramVideoInfo))) {
        continue;
      }
      paramDouble = paramLong / 1000L * paramDouble / 100.0D;
      int j = 0;
      int i = j;
      if (paramVideoInfo != null)
      {
        i = j;
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
        {
          i = j;
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
          {
            i = j;
            if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K == null) {}
          }
        }
      }
      try
      {
        i = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K).intValue();
        if ((paramDouble == 0.0D) || (paramDouble <= i)) {
          continue;
        }
        b(paramVideoInfo, paramVideoItemHolder);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.d("VideoFeedsSoftAdBarController", 2, "smallCardShowTime Format error");
          i = j;
        }
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.a(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.I.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.u.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_v_of_type_AndroidViewView.setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.g.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.I.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.I.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.J.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.w.setVisibility(8);
  }
  
  public int a()
  {
    if (a() != null) {
      return a().a();
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.c();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.b();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.b(paramVideoInfo);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.b(paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if (paramVideoItemHolder.d.getVisibility() == 0) {}
    while (((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))) || (paramVideoInfo == null)) {
      return;
    }
    try
    {
      if (a() == 3)
      {
        b(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
        return;
      }
    }
    catch (Throwable paramVideoInfo)
    {
      QLog.d("VideoFeedsSoftAdBarController", 2, "tryToShowShuntBar error");
      return;
    }
    c(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.y != null))
    {
      paramVideoItemHolder.y.setVisibility(8);
      if ((a() instanceof VideoFeedsSoftAdBarDelegateForAd)) {
        ((VideoFeedsSoftAdBarDelegateForAd)a()).jdField_a_of_type_Boolean = false;
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.b();
      if ((paramVideoItemHolder != null) && (paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup != null))
      {
        paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setVisibility(8);
        if ((a() instanceof VideoFeedsSoftAdBarDelegateForAd)) {
          ((VideoFeedsSoftAdBarDelegateForAd)a()).jdField_a_of_type_Boolean = false;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          d();
          return;
        }
        catch (Exception paramVideoItemHolder)
        {
          QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramVideoItemHolder.getMessage());
        }
        localException = localException;
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + localException.getMessage());
      }
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder1, VideoItemHolder paramVideoItemHolder2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.b = false;
    a(paramVideoItemHolder1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase.a();
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoItemHolder2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$VideoFeedsSoftAdBarDelegateBase = null;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        return;
      } while ((a() == null) || (paramVideoItemHolder == null));
      a().a((paramLong * paramDouble));
    } while (((a() instanceof VideoFeedsSoftAdBarDelegateForAd)) && (((VideoFeedsSoftAdBarDelegateForAd)a()).jdField_a_of_type_Boolean));
    a(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.c();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.e();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.d();
    }
  }
  
  public void onClick(View paramView)
  {
    if (a() != null) {
      a().onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController
 * JD-Core Version:    0.7.0.1
 */