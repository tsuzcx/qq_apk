package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.data.NativeAdVideoSetting;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class NativeAdVideoContainer
  extends RelativeLayout
  implements View.OnClickListener, ReadInJoyNativeAdAppVideoView.VideoFullScreenListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdModuleVideo jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo;
  private AdRatingBar jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar;
  private NativeAdVideoContainer.VideoFullScreenListener jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer$VideoFullScreenListener;
  private ReadInJoyNativeAdAppVideoView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public NativeAdVideoContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NativeAdVideoContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NativeAdVideoContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(getContext(), 2131560071, this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView = ((ReadInJoyNativeAdAppVideoView)findViewById(2131362180));
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.getLayoutParams();
    paramContext.height = ((int)(getResources().getDisplayMetrics().widthPixels * 0.5626F));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setOnVideoFullScreen(this);
    f();
    g();
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt, Integer paramInteger)
  {
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(1).b(17).b(paramInteger).a(paramAdvertisementInfo).c(paramInt));
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView.getId();
    Object localObject = new AdJumpParams();
    ((AdJumpParams)localObject).b = true;
    localObject = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 4, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt), (AdJumpParams)localObject);
    localObject = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localObject, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    int i = paramView.getId();
    if ((i != 2131362172) && (i != 2131362133))
    {
      if ((i != 2131362176) && (i != 2131362135))
      {
        if (i == 2131362139) {
          paramInt = 4;
        } else if ((i == 2131362174) || (i == 2131362112) || (i == 2131370522)) {
          paramInt = 8;
        }
      }
      else {
        paramInt = 3;
      }
    }
    else {
      paramInt = 2;
    }
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramInt, (Integer)localObject);
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      paramReadInJoyHeadImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramReadInJoyHeadImageView)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resetHeadImage() ERROR e = ");
        ((StringBuilder)localObject).append(paramReadInJoyHeadImageView.getMessage());
        QLog.d("NativeAdVideoContainer", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362140));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362172));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362176));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362174));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370522));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362175));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar = ((AdRatingBar)findViewById(2131375987));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370530));
    this.f = ((TextView)findViewById(2131362138));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362142));
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362133));
    this.c = ((TextView)findViewById(2131362135));
    this.d = ((TextView)findViewById(2131362139));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131368861));
    this.e = ((TextView)findViewById(2131362112));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((AdvertisementInfo)localObject).mAdCorporateLogo))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView);
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView);
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName))
      {
        this.c.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt))
      {
        this.d.setVisibility(0);
        this.d.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt);
      }
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdScoreNum >= 8))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setStar(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdScoreNum / 2.0F);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setVisibility(8);
      }
      localObject = ReadInJoyAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.f.setText((CharSequence)localObject);
        this.f.setVisibility(0);
        return;
      }
      this.f.setVisibility(8);
    }
  }
  
  public void a()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b();
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    a(paramView, 9);
  }
  
  public void a(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = paramAdModuleVideo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    NativeAdVideoSetting localNativeAdVideoSetting = new NativeAdVideoSetting();
    localNativeAdVideoSetting.a = false;
    localNativeAdVideoSetting.b = true;
    localNativeAdVideoSetting.c = true;
    localNativeAdVideoSetting.d = false;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setAdSetting(localNativeAdVideoSetting);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoData(paramAdModuleVideo, paramAdvertisementInfo, paramAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setVisibility(8);
    h();
  }
  
  public boolean a()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if (localReadInJoyNativeAdAppVideoView != null) {
      return localReadInJoyNativeAdAppVideoView.a();
    }
    return false;
  }
  
  public void b()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.b(getContext());
    }
  }
  
  public void c()
  {
    ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if (localReadInJoyNativeAdAppVideoView != null) {
      localReadInJoyNativeAdAppVideoView.a();
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if ((localObject != null) && (((ReadInJoyNativeAdAppVideoView)localObject).a()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setisFullScreen(false, 8);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer$VideoFullScreenListener;
      if (localObject != null) {
        ((NativeAdVideoContainer.VideoFullScreenListener)localObject).a();
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
    if ((localObject != null) && (!((ReadInJoyNativeAdAppVideoView)localObject).a()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setisFullScreen(true, 8);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer$VideoFullScreenListener;
      if (localObject != null) {
        ((NativeAdVideoContainer.VideoFullScreenListener)localObject).b();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    a(paramView, 1000);
  }
  
  public void setOnVideoFullScreen(NativeAdVideoContainer.VideoFullScreenListener paramVideoFullScreenListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer$VideoFullScreenListener = paramVideoFullScreenListener;
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoPlayPositon(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdVideoContainer
 * JD-Core Version:    0.7.0.1
 */