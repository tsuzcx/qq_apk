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
  private NativeAdVideoContainer a;
  private AdModuleVideo b;
  private AdvertisementInfo c;
  private AppInterface d;
  private long e = 0L;
  private ImageButton f;
  private ImageButton g;
  private NativeAdDislikeHelper h;
  private RelativeLayout i;
  private ReadInJoyHeadImageView j;
  private TextView k;
  private TextView l;
  private ArrayList<DislikeInfo> m = new ArrayList();
  
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
      localObject = URLDrawable.getDrawable(new URL(this.c.mAdCorporateLogo), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
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
    AdvertisementInfo localAdvertisementInfo = this.c;
    if (localAdvertisementInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo)) {
      a(this.j);
    } else {
      this.j.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.c.mAdCorporateImageName)) {
      this.k.setText(this.c.mAdCorporateImageName);
    }
  }
  
  private void d()
  {
    Object localObject = getArguments();
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)((Bundle)localObject).getParcelable("param_ad_info");
    if ((((Bundle)localObject).containsKey("param_ad_info_dislike")) && (((Bundle)localObject).get("param_ad_info_dislike") != null)) {
      this.m = ((ArrayList)((Bundle)localObject).get("param_ad_info_dislike"));
    }
    this.e = ((Bundle)localObject).getLong("param_ad_app_info_video_playposition");
    if (localAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdAppFragment", 2, "PARAM_AD_INFO: null");
      }
      getBaseActivity().finish();
      return;
    }
    this.c = localAdvertisementInfo;
    try
    {
      this.b = new AdModuleVideo();
      this.b.r = localAdvertisementInfo.mAdImg;
      this.b.p = localAdvertisementInfo.mAdVideoUrl;
      this.b.q = localAdvertisementInfo.mVideoDuration;
      this.b.s = 1;
      this.b.t = "";
      localObject = new AdModuleVideo.AdAppInfo();
      this.b.u = ((AdModuleVideo.AdAppInfo)localObject);
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
    this.i.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  public void b()
  {
    this.i.setVisibility(0);
    this.g.setVisibility(8);
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
      QQToast.makeText(getBaseActivity(), -1, getString(2131897939), 0).show(getBaseActivity().getTitleBarHeight());
    }
  }
  
  public boolean onBackEvent()
  {
    NativeAdVideoContainer localNativeAdVideoContainer = this.a;
    if ((localNativeAdVideoContainer != null) && (localNativeAdVideoContainer.f()))
    {
      this.a.d();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n != 2131438109)
    {
      if (n != 2131445775)
      {
        Integer localInteger = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(getBaseActivity(), this.c, null, 4, true);
        int i1 = paramView.getId();
        n = 1000;
        if (i1 == 2131427713) {
          n = 2;
        } else if (i1 == 2131427715) {
          n = 3;
        } else if (i1 == 2131427692) {
          n = 8;
        }
        NativeAdVideoContainer.a(getBaseActivity(), this.c, n, localInteger);
        return;
      }
      this.h.a(this.c, this.m);
      return;
    }
    paramView = this.a;
    if ((paramView != null) && (paramView.f()))
    {
      this.a.d();
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
    int n = getResources().getConfiguration().orientation;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((QQAppInterface)getBaseActivity().getAppInterface());
    if (this.d == null) {
      this.d = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    }
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626287, paramViewGroup, false);
    this.a = ((NativeAdVideoContainer)paramLayoutInflater.findViewById(2131439138));
    paramViewGroup = this.a;
    if (paramViewGroup != null)
    {
      paramViewGroup.setVideoPlayPositon(this.e);
      this.a.a(this.b, this.c, this.d);
      this.a.setOnVideoFullScreen(this);
    }
    this.f = ((ImageButton)paramLayoutInflater.findViewById(2131438109));
    this.f.setOnClickListener(this);
    this.g = ((ImageButton)paramLayoutInflater.findViewById(2131445775));
    this.g.setOnClickListener(this);
    this.g.setVisibility(0);
    this.h = new NativeAdDislikeHelper(getBaseActivity(), this.d);
    this.i = ((RelativeLayout)paramLayoutInflater.findViewById(2131437805));
    this.j = ((ReadInJoyHeadImageView)paramLayoutInflater.findViewById(2131427713));
    this.k = ((TextView)paramLayoutInflater.findViewById(2131427715));
    this.l = ((TextView)paramLayoutInflater.findViewById(2131427692));
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    NativeAdVideoContainer localNativeAdVideoContainer = this.a;
    if (localNativeAdVideoContainer != null) {
      localNativeAdVideoContainer.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    NativeAdVideoContainer localNativeAdVideoContainer = this.a;
    if (localNativeAdVideoContainer != null) {
      localNativeAdVideoContainer.a();
    }
  }
  
  public void onResume()
  {
    NativeAdVideoContainer localNativeAdVideoContainer = this.a;
    if (localNativeAdVideoContainer != null) {
      localNativeAdVideoContainer.b();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment
 * JD-Core Version:    0.7.0.1
 */