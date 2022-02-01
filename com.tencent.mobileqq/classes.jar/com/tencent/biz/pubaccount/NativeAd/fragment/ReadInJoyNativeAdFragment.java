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
import bhnv;
import bjwq;
import blir;
import blji;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
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
import nyq;
import nys;
import nyt;
import nyu;
import nyv;
import nyw;
import nyx;
import nyy;
import nzi;
import nzj;
import nzq;
import org.json.JSONArray;
import org.json.JSONObject;
import sun;
import uyg;

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
  private blir jdField_a_of_type_Blir;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private AdModuleAdapter jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<nyy> jdField_a_of_type_JavaUtilArrayList;
  private nyq jdField_a_of_type_Nyq;
  private uyg jdField_a_of_type_Uyg;
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
        this.jdField_a_of_type_Nyq = nyq.a(((JSONObject)localObject).optString("bannerInfo"));
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("pageInfoList");
        if (i < ((JSONArray)localObject).length())
        {
          nyy localnyy = nyy.a(getActivity().app, ((JSONArray)localObject).getJSONObject(i));
          if (localnyy != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localnyy);
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            getActivity().finish();
          }
          nzq.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 1, 1, 0);
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
    if ((paramDownloadInfo == null) || (this.jdField_a_of_type_Nyq == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_Nyq.f)) || (TextUtils.isEmpty(this.jdField_a_of_type_Nyq.d))) {}
    while ((!paramDownloadInfo.e.equals(this.jdField_a_of_type_Nyq.f)) || (!paramDownloadInfo.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Nyq.d))) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Nyq != null) && (this.jdField_a_of_type_Nyq.jdField_a_of_type_Int == 1))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378902).setVisibility(8);
        }
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380543);
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380544);
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
      if (this.jdField_a_of_type_Nyq.a()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_Nyq.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage((URL)localObject1);
      if (sun.a().a((URL)localObject1)) {
        this.jdField_c_of_type_Int = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nyq.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(this);
        AppNetConnInfo.registerConnectionChangeReceiver(getActivity(), this);
        return;
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_Uyg = new nyu(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setPublicAccountImageDownListener(this.jdField_a_of_type_Uyg);
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
    if ((this.jdField_c_of_type_Int == 3) && (this.jdField_a_of_type_Nyq != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nyq.jdField_a_of_type_JavaLangString))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdFragment", 2, "retry download icon");
      }
    }
    try
    {
      URL localURL = new URL(this.jdField_a_of_type_Nyq.jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_Blir = ((blir)blji.a(getActivity(), null));
      this.jdField_a_of_type_Blir.a(2131717189, 5);
      this.jdField_a_of_type_Blir.a(2131717191, 5);
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.a(new nyv(this));
      this.jdField_a_of_type_Blir.a(new nyw(this));
    }
    if (!this.jdField_a_of_type_Blir.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Blir.show();
    }
  }
  
  private void e()
  {
    if (!bhnv.g(getActivity()))
    {
      QQToast.a(getActivity(), 1, getString(2131717088), 0).b(0);
      return;
    }
    if (bhnv.h(getActivity()))
    {
      f();
      return;
    }
    g();
  }
  
  private void f()
  {
    nzq.a(getActivity(), this.jdField_a_of_type_Nyq, this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717188));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839325);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    this.jdField_b_of_type_Int = 3;
    nzq.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void g()
  {
    if (!getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = nzq.a(getActivity(), null, getString(2131717196), new nyx(this), getString(2131717197), new nyt(this), getString(2131717198));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      bjwq.a().a(this.jdField_a_of_type_Nyq.d);
      QQToast.a(getActivity(), 1, getString(2131717199), 0).b(0);
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
      if (this.jdField_a_of_type_Nyq != null) {
        if (this.jdField_a_of_type_Nyq.jdField_b_of_type_Int == 2)
        {
          Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
          localIntent.putExtra("url", this.jdField_a_of_type_Nyq.jdField_c_of_type_JavaLangString);
          startActivity(localIntent);
          nzq.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 3, 0);
        }
        else if (this.jdField_a_of_type_Nyq.jdField_b_of_type_Int == 1)
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
            nzq.a(getActivity(), this.jdField_a_of_type_Nyq.f);
            nzq.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 1, 0);
            break;
          case 2: 
            nzq.a(this.jdField_a_of_type_Nyq);
            nzq.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131560225, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(getActivity()).inflate(2131560224, null);
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
      nzi localnzi = (nzi)getActivity().app.getManager(248);
      if (localnzi != null) {
        localnzi.a();
      }
    }
    if ((this.jdField_a_of_type_Nyq != null) && (this.jdField_a_of_type_Nyq.jdField_b_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Nyq.jdField_a_of_type_Int != 1) {
        break label131;
      }
      bjwq.a().b(this);
      AppNetConnInfo.unregisterNetInfoHandler(this);
      if (this.jdField_b_of_type_Int == 3) {
        bjwq.a().a(this.jdField_a_of_type_Nyq.d);
      }
    }
    for (;;)
    {
      nzq.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 4, 1, this.d);
      return;
      label131:
      if (this.jdField_a_of_type_Nyq.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter.a();
        if (nzq.a(getActivity(), this.jdField_a_of_type_Nyq) >= 0) {
          bjwq.a().a(this.jdField_a_of_type_Nyq.d);
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
      nzq.a(getActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
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
    if ((this.jdField_a_of_type_Nyq != null) && (this.jdField_a_of_type_Nyq.jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Nyq.jdField_b_of_type_Int != 2) {
        break label106;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717202));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {}
      label106:
      try
      {
        int i = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
        ((nyy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        if (i + 1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          ((nyy)this.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).b();
        }
        return;
      }
      catch (Exception localException) {}
      if (this.jdField_a_of_type_Nyq.jdField_b_of_type_Int == 1) {
        if (nzq.a(getActivity(), this.jdField_a_of_type_Nyq.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717200));
          this.jdField_b_of_type_Int = 1;
        }
        else if (nzj.a(getActivity(), this.jdField_a_of_type_Nyq.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717193));
          this.jdField_b_of_type_Int = 2;
        }
        else if (this.jdField_b_of_type_Int != 3)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717187));
          this.jdField_b_of_type_Int = 0;
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)localViewGroup.findViewById(2131371340));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter = new AdModuleAdapter(getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Nyq, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new nys(this));
    localViewGroup.findViewById(2131364586).setOnClickListener(this);
    localViewGroup.findViewById(2131366567).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localViewGroup.findViewById(2131378900));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewGroup.findViewById(2131365703));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)localViewGroup.findViewById(2131365715));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131365712));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131373053));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(getResources().getColor(2131165367));
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