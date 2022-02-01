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
import biby;
import bjnw;
import bjon;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import oab;
import oad;
import oae;
import oaf;
import oag;
import oah;
import oai;
import oaj;
import oat;
import oau;
import obb;
import org.json.JSONArray;
import org.json.JSONObject;
import syn;
import vgd;

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
  private bjnw jdField_a_of_type_Bjnw;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private AdModuleAdapter jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<oaj> jdField_a_of_type_JavaUtilArrayList;
  private oab jdField_a_of_type_Oab;
  private vgd jdField_a_of_type_Vgd;
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
        this.jdField_a_of_type_Oab = oab.a(((JSONObject)localObject).optString("bannerInfo"));
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("pageInfoList");
        if (i < ((JSONArray)localObject).length())
        {
          oaj localoaj = oaj.a(getActivity().app, ((JSONArray)localObject).getJSONObject(i));
          if (localoaj != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localoaj);
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            getActivity().finish();
          }
          obb.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 1, 1, 0);
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
    if ((paramDownloadInfo == null) || (this.jdField_a_of_type_Oab == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Oab.f)) || (TextUtils.isEmpty(this.jdField_a_of_type_Oab.d))) {}
    while ((!paramDownloadInfo.e.equals(this.jdField_a_of_type_Oab.f)) || (!paramDownloadInfo.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Oab.d))) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Oab != null) && (this.jdField_a_of_type_Oab.jdField_a_of_type_Int == 1))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378673).setVisibility(8);
        }
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380267);
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380268);
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
      if (this.jdField_a_of_type_Oab.a()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_Oab.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage((URL)localObject1);
      if (syn.a().a((URL)localObject1)) {
        this.jdField_c_of_type_Int = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Oab.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(this);
        AppNetConnInfo.registerConnectionChangeReceiver(getActivity(), this);
        return;
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_Vgd = new oaf(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setPublicAccountImageDownListener(this.jdField_a_of_type_Vgd);
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
    if ((this.jdField_c_of_type_Int == 3) && (this.jdField_a_of_type_Oab != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Oab.jdField_a_of_type_JavaLangString))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdFragment", 2, "retry download icon");
      }
    }
    try
    {
      URL localURL = new URL(this.jdField_a_of_type_Oab.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bjnw == null)
    {
      this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(getActivity(), null));
      this.jdField_a_of_type_Bjnw.a(2131717422, 5);
      this.jdField_a_of_type_Bjnw.a(2131717424, 5);
      this.jdField_a_of_type_Bjnw.c(2131690620);
      this.jdField_a_of_type_Bjnw.a(new oag(this));
      this.jdField_a_of_type_Bjnw.a(new oah(this));
    }
    if (!this.jdField_a_of_type_Bjnw.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bjnw.show();
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetworkAvailable(getActivity()))
    {
      QQToast.a(getActivity(), 1, getString(2131717325), 0).b(0);
      return;
    }
    if (NetworkUtil.isWifiConnected(getActivity()))
    {
      f();
      return;
    }
    g();
  }
  
  private void f()
  {
    obb.a(getActivity(), this.jdField_a_of_type_Oab, this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717421));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839360);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    this.jdField_b_of_type_Int = 3;
    obb.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void g()
  {
    if (!getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = obb.a(getActivity(), null, getString(2131717429), new oai(this), getString(2131717430), new oae(this), getString(2131717431));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      biby.a().a(this.jdField_a_of_type_Oab.d);
      QQToast.a(getActivity(), 1, getString(2131717432), 0).b(0);
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.11(this));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(2130771992, 0);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      getActivity().doOnBackPressed();
      continue;
      d();
      continue;
      if (this.jdField_a_of_type_Oab != null) {
        if (this.jdField_a_of_type_Oab.jdField_b_of_type_Int == 2)
        {
          Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
          localIntent.putExtra("url", this.jdField_a_of_type_Oab.jdField_c_of_type_JavaLangString);
          startActivity(localIntent);
          obb.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 3, 0);
        }
        else if (this.jdField_a_of_type_Oab.jdField_b_of_type_Int == 1)
        {
          switch (this.jdField_b_of_type_Int)
          {
          case 3: 
          default: 
            break;
          case 0: 
            e();
            break;
          case 1: 
            obb.a(getActivity(), this.jdField_a_of_type_Oab.f);
            obb.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 1, 0);
            break;
          case 2: 
            obb.a(this.jdField_a_of_type_Oab);
            obb.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560232, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(getActivity()).inflate(2131560231, null);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12, -1);
    ((ViewGroup)paramLayoutInflater).addView(paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getActivity().app != null)
    {
      oat localoat = (oat)getActivity().app.getManager(248);
      if (localoat != null) {
        localoat.a();
      }
    }
    if ((this.jdField_a_of_type_Oab != null) && (this.jdField_a_of_type_Oab.jdField_b_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Oab.jdField_a_of_type_Int != 1) {
        break label131;
      }
      biby.a().b(this);
      AppNetConnInfo.unregisterNetInfoHandler(this);
      if (this.jdField_b_of_type_Int == 3) {
        biby.a().a(this.jdField_a_of_type_Oab.d);
      }
    }
    for (;;)
    {
      obb.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 4, 1, this.d);
      return;
      label131:
      if (this.jdField_a_of_type_Oab.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter.a();
        if (obb.a(getActivity(), this.jdField_a_of_type_Oab) >= 0) {
          biby.a().a(this.jdField_a_of_type_Oab.d);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.6(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.8(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.5(this));
      obb.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (a(localDownloadInfo)) {
        ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.7(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130771989);
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
    if ((this.jdField_a_of_type_Oab != null) && (this.jdField_a_of_type_Oab.jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Oab.jdField_b_of_type_Int != 2) {
        break label106;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717435));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {}
      label106:
      try
      {
        int i = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
        ((oaj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        if (i + 1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          ((oaj)this.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).b();
        }
        return;
      }
      catch (Exception localException) {}
      if (this.jdField_a_of_type_Oab.jdField_b_of_type_Int == 1) {
        if (obb.a(getActivity(), this.jdField_a_of_type_Oab.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717433));
          this.jdField_b_of_type_Int = 1;
        }
        else if (oau.a(getActivity(), this.jdField_a_of_type_Oab.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717426));
          this.jdField_b_of_type_Int = 2;
        }
        else if (this.jdField_b_of_type_Int != 3)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717420));
          this.jdField_b_of_type_Int = 0;
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)localViewGroup.findViewById(2131371309));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter = new AdModuleAdapter(getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Oab, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new oad(this));
    localViewGroup.findViewById(2131364617).setOnClickListener(this);
    localViewGroup.findViewById(2131366594).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localViewGroup.findViewById(2131378671));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewGroup.findViewById(2131365736));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)localViewGroup.findViewById(2131365748));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131365745));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131373023));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(getResources().getColor(2131165375));
    b();
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment
 * JD-Core Version:    0.7.0.1
 */