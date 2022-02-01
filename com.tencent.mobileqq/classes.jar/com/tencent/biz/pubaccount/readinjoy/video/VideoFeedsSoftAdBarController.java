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
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsSoftAdBarController;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoHolderHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsSoftAdBarController
  implements View.OnClickListener, IVideoFeedsSoftAdBarController
{
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoFeedsSoftAdBarDelegateBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase;
  private VideoFeedsSoftAdBarDelegateForNormal jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
  private VideoFeedsSoftAdBarDelegateForAd jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private VideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private VideoInfo jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  
  public VideoFeedsSoftAdBarController(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = AIOUtils.b(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd = new VideoFeedsSoftAdBarDelegateForAd();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal = new VideoFeedsSoftAdBarDelegateForNormal();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private VideoFeedsSoftAdBarDelegateBase a()
  {
    VideoFeedsSoftAdBarDelegateBase localVideoFeedsSoftAdBarDelegateBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase;
    if (localVideoFeedsSoftAdBarDelegateBase != null) {
      return localVideoFeedsSoftAdBarDelegateBase;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    } else if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mSoftAdType == 2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
    }
    localVideoFeedsSoftAdBarDelegateBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase;
    if (localVideoFeedsSoftAdBarDelegateBase != null) {
      localVideoFeedsSoftAdBarDelegateBase.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase;
  }
  
  public static void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (paramInt4 != -1) {
        localURLDrawableOptions.mUseMemoryCache = false;
      }
      localURLDrawableOptions.mRequestWidth = AIOUtils.b(paramInt2, paramActivity.getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.b(paramInt3, paramActivity.getResources());
      paramActivity = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramInt4 == 0)
      {
        paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
        paramActivity.setTag(new int[] { 0, 0, paramInt1, 1 });
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
      }
      else if (paramInt4 == 1)
      {
        paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
        paramActivity.setTag(new int[] { 0, 0, paramInt1, 3 });
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
      }
      else
      {
        paramActivity.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.i);
      }
      paramURLImageView.setImageDrawable(paramActivity);
      return;
    }
    catch (Exception paramURLImageView)
    {
      label230:
      break label230;
    }
    if (QLog.isColorLevel())
    {
      paramURLImageView = new StringBuilder();
      paramURLImageView.append("后台下发的url格式有问题：");
      paramURLImageView.append(paramString);
      QLog.d("VideoFeedsSoftAdBarController", 2, paramURLImageView.toString());
    }
  }
  
  private void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSamleGameShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = paramVideoItemHolder;
    for (;;)
    {
      try
      {
        if ((paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup == null) && (((IVideoHolderHelper)QRoute.api(IVideoHolderHelper.class)).isShortVideoItemHolder(paramVideoItemHolder)))
        {
          paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131380594)).inflate()).findViewById(2131380745)).inflate());
          int i = AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
          paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
          paramVideoItemHolder.g = ((URLImageView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368141));
          paramVideoItemHolder.I = ((TextView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368149));
          paramVideoItemHolder.J = ((TextView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368148));
          paramVideoItemHolder.t = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131370265);
          paramVideoItemHolder.u = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368147);
          paramVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368138));
          paramVideoItemHolder.jdField_v_of_type_AndroidViewView = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131368140);
          paramVideoItemHolder.K = ((TextView)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131367456));
          paramVideoItemHolder.w = paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131367474);
          paramVideoItemHolder.b = ((FrameLayout)paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.findViewById(2131362167));
        }
        if ((paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup != null) && (paramVideoItemHolder.g != null) && (paramVideoItemHolder.I != null) && (paramVideoItemHolder.J != null) && (paramVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (paramVideoItemHolder.u != null))
        {
          paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setVisibility(0);
          localObject = a();
          String str = "";
          if (localObject == null) {
            break label687;
          }
          localObject = a().a();
          a(paramVideoItemHolder.g, (String)localObject, this.jdField_a_of_type_Int, 18, 18, -1, this.jdField_a_of_type_AndroidAppActivity);
          if ((a() == null) || (a().b() == null)) {
            break label695;
          }
          localObject = a().b();
          paramVideoItemHolder.I.setText((CharSequence)localObject);
          paramVideoItemHolder.I.setVisibility(0);
          paramVideoItemHolder.g.setVisibility(0);
          localObject = str;
          if (a() != null) {
            localObject = a().a();
          }
          paramVideoItemHolder.b.setTag(paramVideoItemHolder);
          paramVideoItemHolder.b.setOnClickListener(this);
          paramVideoItemHolder.J.setText((CharSequence)localObject);
          paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setTag(paramVideoItemHolder);
          paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setOnClickListener(this);
          paramVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(paramVideoItemHolder);
          paramVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
          paramVideoItemHolder.u.setTag(paramVideoItemHolder);
          paramVideoItemHolder.u.setOnClickListener(this);
          ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideUpAnim(paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup, 200);
          if ((a() != null) && (!TextUtils.isEmpty(a().c())) && (paramVideoItemHolder.K != null)) {
            paramVideoItemHolder.K.setText(a().c());
          }
          if (a() != null)
          {
            a().a(paramVideoInfo, paramVideoItemHolder);
            return;
          }
        }
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoItemHolder = new StringBuilder();
        paramVideoItemHolder.append("show shunt bar error:");
        paramVideoItemHolder.append(paramVideoInfo.getMessage());
        QLog.e("VideoFeedsSoftAdBarController", 2, paramVideoItemHolder.toString());
      }
      return;
      label687:
      Object localObject = "";
      continue;
      label695:
      localObject = "";
    }
  }
  
  private void b(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSoftAdShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = paramVideoItemHolder;
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.b(paramVideoItemHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.c(paramVideoItemHolder);
      if (paramVideoItemHolder.y != null)
      {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideUpAnim(paramVideoItemHolder.y, 200);
        if (a() != null)
        {
          a().a(paramVideoInfo, paramVideoItemHolder);
          return;
        }
      }
    }
    catch (Throwable paramVideoInfo)
    {
      paramVideoItemHolder = new StringBuilder();
      paramVideoItemHolder.append("后台下发的url格式有问题：");
      paramVideoItemHolder.append(paramVideoInfo.getMessage());
      QLog.d("VideoFeedsSoftAdBarController", 2, paramVideoItemHolder.toString());
    }
  }
  
  private void b(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup != null) && (paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.getVisibility() == 0))
    {
      if ((this.jdField_a_of_type_Boolean) && (a() != null) && (a().a(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.a(this.jdField_a_of_type_Int);
      }
      return;
    }
    if ((paramVideoInfo != null) && (a() != null) && (a().a()) && (a().a(paramVideoInfo))) {
      a(paramVideoInfo, paramVideoItemHolder);
    }
  }
  
  private void c(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.y == null) || (paramVideoItemHolder.y.getVisibility() != 0) || ((this.jdField_a_of_type_Boolean) && (a() != null) && (a().a(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong)))) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.a(paramVideoItemHolder);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      label57:
      double d;
      int j;
      int i;
      break label57;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.f();
    QLog.d("VideoFeedsSoftAdBarController", 2, "big Card show error");
    return;
    if ((paramVideoInfo != null) && (a() != null) && (a().a()) && (a().a(paramVideoInfo)))
    {
      d = paramLong / 1000L;
      Double.isNaN(d);
      paramDouble = d * paramDouble / 100.0D;
      j = 0;
      i = j;
      if (paramVideoInfo != null)
      {
        i = j;
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null)
        {
          i = j;
          if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo != null)
          {
            i = j;
            if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.L == null) {}
          }
        }
      }
    }
    try
    {
      i = Integer.valueOf(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.L).intValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label248:
      break label248;
    }
    QLog.d("VideoFeedsSoftAdBarController", 2, "smallCardShowTime Format error");
    i = j;
    if ((paramDouble != 0.0D) && (paramDouble > i)) {
      b(paramVideoInfo, paramVideoItemHolder);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.b(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.J.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.u.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_v_of_type_AndroidViewView.setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.g.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.J.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.b(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.J.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.K.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.w.setVisibility(8);
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
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).b();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).b(paramVideoInfo);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).b(paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if (paramVideoItemHolder.d.getVisibility() == 0) {
      return;
    }
    if ((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramVideoInfo == null) {
      return;
    }
    try
    {
      if (a() == 3)
      {
        b(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
        return;
      }
      c(paramVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      label59:
      break label59;
    }
    QLog.d("VideoFeedsSoftAdBarController", 2, "tryToShowShuntBar error");
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.y != null))
    {
      paramVideoItemHolder.y.setVisibility(8);
      if ((a() instanceof VideoFeedsSoftAdBarDelegateForAd)) {
        ((VideoFeedsSoftAdBarDelegateForAd)a()).jdField_a_of_type_Boolean = false;
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.b();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("reset ex:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("VideoFeedsSoftAdBarController", 2, localStringBuilder2.toString());
      }
    }
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup != null))
    {
      paramVideoItemHolder.jdField_v_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((a() instanceof VideoFeedsSoftAdBarDelegateForAd)) {
        ((VideoFeedsSoftAdBarDelegateForAd)a()).jdField_a_of_type_Boolean = false;
      }
      try
      {
        d();
        return;
      }
      catch (Exception paramVideoItemHolder)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("reset ex:");
        localStringBuilder1.append(paramVideoItemHolder.getMessage());
        QLog.d("VideoFeedsSoftAdBarController", 2, localStringBuilder1.toString());
      }
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder1, VideoItemHolder paramVideoItemHolder2)
  {
    this.jdField_a_of_type_Boolean = false;
    VideoFeedsSoftAdBarDelegateForNormal localVideoFeedsSoftAdBarDelegateForNormal = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    localVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_Boolean = false;
    if (localVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.b = false;
    a(paramVideoItemHolder1);
    paramVideoItemHolder1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase;
    if (paramVideoItemHolder1 != null) {
      paramVideoItemHolder1.a();
    }
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoItemHolder2.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateBase = null;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {
      return;
    }
    if ((a() != null) && (paramVideoItemHolder != null))
    {
      VideoFeedsSoftAdBarDelegateBase localVideoFeedsSoftAdBarDelegateBase = a();
      double d = paramLong;
      Double.isNaN(d);
      localVideoFeedsSoftAdBarDelegateBase.a((d * paramDouble));
      if (((a() instanceof VideoFeedsSoftAdBarDelegateForAd)) && (((VideoFeedsSoftAdBarDelegateForAd)a()).jdField_a_of_type_Boolean)) {
        return;
      }
      a(paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, paramVideoItemHolder, paramDouble, paramLong);
    }
  }
  
  public void a(Object paramObject)
  {
    a((VideoInfo)paramObject);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).c();
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForAd)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarDelegateForNormal;
    if (localObject != null) {
      ((VideoFeedsSoftAdBarDelegateForNormal)localObject).d();
    }
  }
  
  public void onClick(View paramView)
  {
    if (a() != null) {
      a().onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController
 * JD-Core Version:    0.7.0.1
 */