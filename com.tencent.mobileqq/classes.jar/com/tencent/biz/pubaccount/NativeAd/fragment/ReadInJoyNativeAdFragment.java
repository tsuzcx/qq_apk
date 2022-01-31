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
import badq;
import bbmy;
import bcgn;
import bcgo;
import begr;
import behe;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nac;
import nae;
import naf;
import nag;
import nah;
import nai;
import naj;
import nak;
import nau;
import nbe;
import org.json.JSONArray;
import org.json.JSONObject;
import rcv;
import sch;

public class ReadInJoyNativeAdFragment
  extends PublicBaseFragment
  implements View.OnClickListener, bcgn, INetInfoHandler
{
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private begr jdField_a_of_type_Begr;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private AdModuleAdapter jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<nak> jdField_a_of_type_JavaUtilArrayList;
  private nac jdField_a_of_type_Nac;
  private sch jdField_a_of_type_Sch;
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
        this.jdField_a_of_type_Nac = nac.a(((JSONObject)localObject).optString("bannerInfo"));
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("pageInfoList");
        if (i < ((JSONArray)localObject).length())
        {
          nak localnak = nak.a(getActivity().app, ((JSONArray)localObject).getJSONObject(i));
          if (localnak != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localnak);
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            getActivity().finish();
          }
          nbe.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 1, 1, 0);
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
    if ((paramDownloadInfo == null) || (this.jdField_a_of_type_Nac == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Nac.f)) || (TextUtils.isEmpty(this.jdField_a_of_type_Nac.d))) {}
    while ((!paramDownloadInfo.e.equals(this.jdField_a_of_type_Nac.f)) || (!paramDownloadInfo.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Nac.d))) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Nac != null) && (this.jdField_a_of_type_Nac.jdField_a_of_type_Int == 1))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311508).setVisibility(8);
        }
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131312925);
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131312926);
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
      if (this.jdField_a_of_type_Nac.a()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_Nac.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a((URL)localObject1);
      if (rcv.a().a((URL)localObject1)) {
        this.jdField_c_of_type_Int = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nac.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(this);
        AppNetConnInfo.registerConnectionChangeReceiver(getActivity(), this);
        return;
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_Sch = new nag(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setPublicAccountImageDownListener(this.jdField_a_of_type_Sch);
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
    if ((this.jdField_c_of_type_Int == 3) && (this.jdField_a_of_type_Nac != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nac.jdField_a_of_type_JavaLangString))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdFragment", 2, "retry download icon");
      }
    }
    try
    {
      URL localURL = new URL(this.jdField_a_of_type_Nac.jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = ((begr)behe.a(getActivity(), null));
      this.jdField_a_of_type_Begr.a(2131652658, 5);
      this.jdField_a_of_type_Begr.a(2131652660, 5);
      this.jdField_a_of_type_Begr.c(2131625035);
      this.jdField_a_of_type_Begr.a(new nah(this));
      this.jdField_a_of_type_Begr.a(new nai(this));
    }
    if (!this.jdField_a_of_type_Begr.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Begr.show();
    }
  }
  
  private void e()
  {
    if (!badq.g(getActivity()))
    {
      bbmy.a(getActivity(), 1, getString(2131652572), 0).b(0);
      return;
    }
    if (badq.h(getActivity()))
    {
      f();
      return;
    }
    g();
  }
  
  private void f()
  {
    nbe.a(getActivity(), this.jdField_a_of_type_Nac, this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131652657));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839032);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    this.jdField_b_of_type_Int = 3;
    nbe.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void g()
  {
    if (!getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = nbe.a(getActivity(), null, getString(2131652665), new naj(this), getString(2131652666), new naf(this), getString(2131652667));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      bcgo.a().a(this.jdField_a_of_type_Nac.d);
      bbmy.a(getActivity(), 1, getString(2131652668), 0).b(0);
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
    do
    {
      do
      {
        return;
        getActivity().doOnBackPressed();
        return;
        d();
        return;
      } while (this.jdField_a_of_type_Nac == null);
      if (this.jdField_a_of_type_Nac.jdField_b_of_type_Int == 2)
      {
        paramView = new Intent(getActivity(), QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_Nac.jdField_c_of_type_JavaLangString);
        startActivity(paramView);
        nbe.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 3, 0);
        return;
      }
    } while (this.jdField_a_of_type_Nac.jdField_b_of_type_Int != 1);
    switch (this.jdField_b_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 0: 
      e();
      return;
    case 1: 
      nbe.a(getActivity(), this.jdField_a_of_type_Nac.f);
      nbe.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 1, 0);
      return;
    }
    nbe.a(this.jdField_a_of_type_Nac);
    nbe.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131494402, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(getActivity()).inflate(2131494401, null);
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
      nau localnau = (nau)getActivity().app.getManager(248);
      if (localnau != null) {
        localnau.a();
      }
    }
    if ((this.jdField_a_of_type_Nac != null) && (this.jdField_a_of_type_Nac.jdField_b_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Nac.jdField_a_of_type_Int != 1) {
        break label131;
      }
      bcgo.a().b(this);
      AppNetConnInfo.unregisterNetInfoHandler(this);
      if (this.jdField_b_of_type_Int == 3) {
        bcgo.a().a(this.jdField_a_of_type_Nac.d);
      }
    }
    for (;;)
    {
      nbe.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 4, 1, this.d);
      return;
      label131:
      if (this.jdField_a_of_type_Nac.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter.a();
        if (nbe.a(getActivity(), this.jdField_a_of_type_Nac) >= 0) {
          bcgo.a().a(this.jdField_a_of_type_Nac.d);
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
      nbe.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
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
    if ((this.jdField_a_of_type_Nac != null) && (this.jdField_a_of_type_Nac.jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Nac.jdField_b_of_type_Int != 2) {
        break label106;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131652671));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {}
      label106:
      try
      {
        int i = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
        ((nak)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        if (i + 1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          ((nak)this.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).b();
        }
        return;
      }
      catch (Exception localException) {}
      if (this.jdField_a_of_type_Nac.jdField_b_of_type_Int == 1) {
        if (nbe.a(getActivity(), this.jdField_a_of_type_Nac.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131652669));
          this.jdField_b_of_type_Int = 1;
        }
        else if (nbe.a(getActivity(), this.jdField_a_of_type_Nac))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131652662));
          this.jdField_b_of_type_Int = 2;
        }
        else if (this.jdField_b_of_type_Int != 3)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131652656));
          this.jdField_b_of_type_Int = 0;
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)localViewGroup.findViewById(2131304698));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter = new AdModuleAdapter(getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Nac, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new nae(this));
    localViewGroup.findViewById(2131298703).setOnClickListener(this);
    localViewGroup.findViewById(2131300573).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localViewGroup.findViewById(2131311504));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewGroup.findViewById(2131299771));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)localViewGroup.findViewById(2131299782));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131299779));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131306312));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(getResources().getColor(2131099760));
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