package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;
import com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kyk;
import kyl;
import kym;
import kyn;
import kyo;
import kyp;
import kyq;
import kyr;
import kys;
import kyt;
import kyu;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyNativeAdFragment
  extends PublicBaseFragment
  implements View.OnClickListener, INetInfoHandler, DownloadListener
{
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private AdModuleAdapter jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter;
  private BannerInfo jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private PublicAccountImageDownListener jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d = 1;
  
  private void a()
  {
    int i = 0;
    Object localObject = getArguments().getString("param_ad_json");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "checkData->" + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      getActivity().finish();
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("adId");
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("channelId");
        this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("info");
        this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("upslideType");
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo = BannerInfo.a(((JSONObject)localObject).optString("bannerInfo"));
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("pageInfoList");
        if (i < ((JSONArray)localObject).length())
        {
          AdModuleBase localAdModuleBase = AdModuleBase.a(getActivity().app, ((JSONArray)localObject).getJSONObject(i));
          if (localAdModuleBase != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localAdModuleBase);
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            getActivity().finish();
          }
          NativeAdUtils.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 1, 1, 0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        getActivity().finish();
        return;
      }
      i += 1;
    }
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.d)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d))) {}
    while ((!paramDownloadInfo.d.equals(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f)) || (!paramDownloadInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d))) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int == 1))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367241).setVisibility(8);
        }
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365593);
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365594);
        ((View)localObject2).setAlpha(0.0F);
        ((View)localObject2).setVisibility(0);
        ((View)localObject1).setAlpha(0.0F);
        ((View)localObject1).setVisibility(0);
        localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
        localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
        ((ObjectAnimator)localObject1).setDuration(1800L);
        ((ObjectAnimator)localObject1).setRepeatCount(-1);
        ((ObjectAnimator)localObject1).setRepeatMode(1);
        ((ObjectAnimator)localObject1).setStartDelay(100L);
        ((ObjectAnimator)localObject2).setDuration(1800L);
        ((ObjectAnimator)localObject2).setRepeatCount(-1);
        ((ObjectAnimator)localObject2).setRepeatMode(1);
        ((ObjectAnimator)localObject2).setStartDelay(240L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
        localAnimatorSet.start();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.a()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a((URL)localObject1);
      if (ImageManager.a().a((URL)localObject1)) {
        this.jdField_c_of_type_Int = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(this);
        AppNetConnInfo.registerConnectionChangeReceiver(getActivity(), this);
        return;
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener = new kyn(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setPublicAccountImageDownListener(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageDownListener);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_c_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_JavaLangString))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdFragment", 2, "retry download icon");
      }
    }
    try
    {
      URL localURL = new URL(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getActivity(), null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438724, 5);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438725, 5);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new kyo(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new kyp(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.g(getActivity()))
    {
      QQToast.a(getActivity(), 1, getString(2131438890), 0).b(0);
      return;
    }
    if (NetworkUtil.h(getActivity()))
    {
      f();
      return;
    }
    g();
  }
  
  private void f()
  {
    NativeAdUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo, this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131438718));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838526);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    this.jdField_b_of_type_Int = 3;
    NativeAdUtils.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void g()
  {
    if (!getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = NativeAdUtils.a(getActivity(), null, getString(2131438721), new kyu(this), getString(2131438722), new kyl(this), getString(2131438720));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      DownloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d);
      QQToast.a(getActivity(), 1, getString(2131438723), 0).b(0);
      ThreadManager.getUIHandler().post(new kym(this));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(2131034132, 0);
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        getActivity().doOnBackPressed();
        return;
        d();
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo == null);
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 2)
      {
        paramView = new Intent(getActivity(), QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_c_of_type_JavaLangString);
        startActivity(paramView);
        NativeAdUtils.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 3, 0);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int != 1);
    switch (this.jdField_b_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 0: 
      e();
      return;
    case 1: 
      NativeAdUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f);
      NativeAdUtils.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 1, 0);
      return;
    }
    NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo);
    NativeAdUtils.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969630, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(getActivity()).inflate(2130969629, null);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12, -1);
    ((ViewGroup)paramLayoutInflater).addView(paramViewGroup, paramBundle);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getActivity().app != null)
    {
      NativeAdPreloadManager localNativeAdPreloadManager = (NativeAdPreloadManager)getActivity().app.getManager(247);
      if (localNativeAdPreloadManager != null) {
        localNativeAdPreloadManager.a();
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int != 1) {
        break label131;
      }
      DownloadManager.a().b(this);
      AppNetConnInfo.unregisterNetInfoHandler(this);
      if (this.jdField_b_of_type_Int == 3) {
        DownloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d);
      }
    }
    for (;;)
    {
      NativeAdUtils.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 4, 1, this.d);
      return;
      label131:
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter.a();
        if (NativeAdUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo) >= 0) {
          DownloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new kyr(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new kyt(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new kyq(this));
      NativeAdUtils.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (a(localDownloadInfo)) {
        ThreadManager.getUIHandler().post(new kys(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2131034130);
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetMobile2None");
    }
    h();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetNone2Mobile");
    }
    h();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetWifi2Mobile");
    }
    h();
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetWifi2None");
    }
    h();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int != 2) {
        break label106;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131438715));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {}
      label106:
      try
      {
        int i = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
        ((AdModuleBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        if (i + 1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          ((AdModuleBase)this.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).b();
        }
        return;
      }
      catch (Exception localException) {}
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 1) {
        if (NativeAdUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131438719));
          this.jdField_b_of_type_Int = 1;
        }
        else if (NativeAdUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131438717));
          this.jdField_b_of_type_Int = 2;
        }
        else if (this.jdField_b_of_type_Int != 3)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131438716));
          this.jdField_b_of_type_Int = 0;
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)localViewGroup.findViewById(2131367246));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter = new AdModuleAdapter(getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new kyk(this));
    localViewGroup.findViewById(2131366838).setOnClickListener(this);
    localViewGroup.findViewById(2131367247).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localViewGroup.findViewById(2131367240));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewGroup.findViewById(2131367242));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)localViewGroup.findViewById(2131367243));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131367245));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131367244));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(getResources().getColor(2131493308));
    b();
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment
 * JD-Core Version:    0.7.0.1
 */