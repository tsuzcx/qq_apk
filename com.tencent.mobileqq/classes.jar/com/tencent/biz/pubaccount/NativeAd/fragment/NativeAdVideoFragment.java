package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo.AdAppInfo;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdDislikeHelper;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdVideoContainer;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdVideoContainer.VideoFullScreenListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NativeAdVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, NativeAdVideoContainer.VideoFullScreenListener
{
  private long jdField_a_of_type_Long = 0L;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdModuleVideo jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo;
  private NativeAdDislikeHelper jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper;
  private NativeAdVideoContainer jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  private ArrayList<DislikeInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public static void a(Activity paramActivity, Class<? extends NativeAdVideoFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtras(paramBundle);
      PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass);
      paramActivity.overridePendingTransition(0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppFragment", 2, "error");
    }
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
        QLog.d("ReadInJoyNativeAdAppFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void c()
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localAdvertisementInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo)) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
    }
  }
  
  private void d()
  {
    Object localObject = getArguments();
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)((Bundle)localObject).getParcelable("param_ad_info");
    if ((((Bundle)localObject).containsKey("param_ad_info_dislike")) && (((Bundle)localObject).get("param_ad_info_dislike") != null)) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((Bundle)localObject).get("param_ad_info_dislike"));
    }
    this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("param_ad_app_info_video_playposition");
    if (localAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdAppFragment", 2, "PARAM_AD_INFO: null");
      }
      getBaseActivity().finish();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = new AdModuleVideo();
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.e = localAdvertisementInfo.mAdImg;
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.jdField_d_of_type_JavaLangString = localAdvertisementInfo.mAdVideoUrl;
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.jdField_a_of_type_Long = localAdvertisementInfo.mVideoDuration;
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.f = "";
      localObject = new AdModuleVideo.AdAppInfo();
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo$AdAppInfo = ((AdModuleVideo.AdAppInfo)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      getBaseActivity().finish();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 9999) {
      return;
    }
    if (paramInt2 == -1) {
      QQToast.a(getBaseActivity(), -1, getString(2131699886), 0).b(getBaseActivity().getTitleBarHeight());
    }
  }
  
  public boolean onBackEvent()
  {
    NativeAdVideoContainer localNativeAdVideoContainer = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
    if ((localNativeAdVideoContainer != null) && (localNativeAdVideoContainer.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.d();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131370799)
    {
      if (i != 2131377376)
      {
        Integer localInteger = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 4, true);
        int j = paramView.getId();
        i = 1000;
        if (j == 2131362134) {
          i = 2;
        } else if (j == 2131362136) {
          i = 3;
        } else if (j == 2131362113) {
          i = 8;
        }
        NativeAdVideoContainer.a(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, i, localInteger);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
    if ((paramView != null) && (paramView.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.d();
      return;
    }
    getBaseActivity().finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (getResources().getConfiguration().orientation == 2) {
      return;
    }
    int i = getResources().getConfiguration().orientation;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((QQAppInterface)getBaseActivity().getAppInterface());
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    }
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560240, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer = ((NativeAdVideoContainer)paramLayoutInflater.findViewById(2131371711));
    paramViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
    if (paramViewGroup != null)
    {
      paramViewGroup.setVideoPlayPositon(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.setOnVideoFullScreen(this);
    }
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131370799));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131377376));
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper = new NativeAdDislikeHelper(getBaseActivity(), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131370532));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLayoutInflater.findViewById(2131362134));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131362136));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131362113));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    NativeAdVideoContainer localNativeAdVideoContainer = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
    if (localNativeAdVideoContainer != null) {
      localNativeAdVideoContainer.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    NativeAdVideoContainer localNativeAdVideoContainer = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
    if (localNativeAdVideoContainer != null) {
      localNativeAdVideoContainer.a();
    }
  }
  
  public void onResume()
  {
    NativeAdVideoContainer localNativeAdVideoContainer = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
    if (localNativeAdVideoContainer != null) {
      localNativeAdVideoContainer.b();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment
 * JD-Core Version:    0.7.0.1
 */