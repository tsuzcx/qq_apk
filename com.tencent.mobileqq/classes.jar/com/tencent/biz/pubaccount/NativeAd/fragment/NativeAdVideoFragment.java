package com.tencent.biz.pubaccount.NativeAd.fragment;

import adxr;
import alvx;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bfol;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdVideoContainer;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import oar;
import oas;
import oaw;
import obj;
import uhs;

public class NativeAdVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, obj
{
  private long jdField_a_of_type_Long;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NativeAdVideoContainer jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<DislikeInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private oar jdField_a_of_type_Oar;
  private oaw jdField_a_of_type_Oaw;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public static void a(Activity paramActivity, Class<? extends NativeAdVideoFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdAppFragment", 2, "error");
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtras(paramBundle);
    adxr.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass);
    paramActivity.overridePendingTransition(0, 0);
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
      ((URLDrawable)localObject).setDecodeHandler(bfol.a);
      paramReadInJoyHeadImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramReadInJoyHeadImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyNativeAdAppFragment", 2, "resetHeadImage() ERROR e = " + paramReadInJoyHeadImageView.getMessage());
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo)) {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
      }
      while (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      }
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
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
    try
    {
      this.jdField_a_of_type_Oar = new oar();
      this.jdField_a_of_type_Oar.e = localAdvertisementInfo.mAdImg;
      this.jdField_a_of_type_Oar.jdField_d_of_type_JavaLangString = localAdvertisementInfo.mAdVideoUrl;
      this.jdField_a_of_type_Oar.jdField_a_of_type_Long = localAdvertisementInfo.mVideoDuration;
      this.jdField_a_of_type_Oar.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_Oar.f = "";
      localObject = new oas();
      this.jdField_a_of_type_Oar.jdField_a_of_type_Oas = ((oas)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      getActivity().finish();
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
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    QQToast.a(getActivity(), -1, getString(2131698823), 0).b(getActivity().getTitleBarHeight());
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.d();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int j;
    int i;
    switch (paramView.getId())
    {
    default: 
      uhs.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 4, true);
      j = paramView.getId();
      i = 1000;
      if (j == 2131362081) {
        i = 2;
      }
      break;
    }
    for (;;)
    {
      NativeAdVideoContainer.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, i);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.jdField_a_of_type_Oaw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_JavaUtilArrayList);
        continue;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.a())) {
          this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.d();
        } else {
          getActivity().finish();
        }
      }
      if (j == 2131362083) {
        i = 3;
      } else if (j == 2131362057) {
        i = 8;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (getResources().getConfiguration().orientation == 2) {}
    while (getResources().getConfiguration().orientation != 1) {
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = alvx.a();
    }
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560234, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer = ((NativeAdVideoContainer)paramLayoutInflater.findViewById(2131371630));
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.setVideoPlayPositon(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.a(this.jdField_a_of_type_Oar, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.setOnVideoFullScreen(this);
    }
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131370707));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131377271));
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_Oaw = new oaw(getActivity(), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131370433));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramLayoutInflater.findViewById(2131362081));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131362083));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131362057));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    c();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.a();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdVideoContainer.b();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment
 * JD-Core Version:    0.7.0.1
 */