package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.DynamicChannelConfig;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ReadInJoyFragmentFactory
{
  static ReadInJoyFragmentFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory = null;
  WeakReference<ReadInJoyNewFeedsActivity> jdField_a_of_type_MqqUtilWeakReference = null;
  
  private Fragment a(TemplateFactory paramTemplateFactory, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Object localObject = null;
    DynamicChannelConfig localDynamicChannelConfig = paramTemplateFactory.a();
    paramTemplateFactory = localObject;
    if (localDynamicChannelConfig != null)
    {
      if (!TextUtils.isEmpty(localDynamicChannelConfig.b("cgi"))) {
        paramTemplateFactory = ReadInJoyCGIDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName);
      }
    }
    else {
      return paramTemplateFactory;
    }
    return ReadInJoyDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName);
  }
  
  public static ReadInJoyBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ReadInJoyRecommendFeedsFragment.a();
    case 1: 
      ReadInJoyVideoChannelFragment localReadInJoyVideoChannelFragment = new ReadInJoyVideoChannelFragment();
      localReadInJoyVideoChannelFragment.b(1002);
      return localReadInJoyVideoChannelFragment;
    case 2: 
      return ReadInJoyFollowFragment.a();
    }
    return ReadInJoySelfCenterViolaFragment.a("https://viola.qq.com/js/usercenter.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=usercenter&v_bid=3740&jump_source=2");
  }
  
  public static ReadInJoyFragmentFactory a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory = new ReadInJoyFragmentFactory();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory;
    }
    finally {}
  }
  
  private Fragment b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo.mChannelCoverId == ChannelCoverInfoModule.a()) {
      return c(paramTabChannelCoverInfo);
    }
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelCoverId)) {
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    }
    if (ViolaAccessHelper.b(paramTabChannelCoverInfo.mChannelCoverId)) {
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    }
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      return f(paramTabChannelCoverInfo);
    }
    return d(paramTabChannelCoverInfo);
  }
  
  private Fragment c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      return f(paramTabChannelCoverInfo);
    }
    return ReadInJoyRecommendFeedsFragment.a();
  }
  
  private Fragment d(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    switch (paramTabChannelCoverInfo.mChannelCoverId)
    {
    default: 
      return e(paramTabChannelCoverInfo);
    case 0: 
      return ReadInJoyRecommendFeedsFragment.a();
    case 56: 
      paramTabChannelCoverInfo = new ReadInJoyVideoChannelFragment();
      paramTabChannelCoverInfo.b(1003);
      return paramTabChannelCoverInfo;
    case 41726: 
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    case 41725: 
      return MultiVideoHelper.a(BaseApplicationImpl.getContext(), paramTabChannelCoverInfo);
    case 70: 
      return new ReadInJoyBBCircleFragment();
    case 41522: 
      return new ReadInJoyPicWaterFallFragment();
    case 41450: 
      return new ReadInJoyTribeChannelFragment();
    }
    ReadinjoyAdHippyFragment localReadinjoyAdHippyFragment = ReadinjoyAdHippyFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelVersion);
    localReadinjoyAdHippyFragment.a(paramTabChannelCoverInfo.mChannelJumpUrl);
    return localReadinjoyAdHippyFragment;
  }
  
  private Fragment e(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Object localObject;
    if (ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      localObject = f(paramTabChannelCoverInfo);
    }
    Fragment localFragment;
    do
    {
      return localObject;
      if (paramTabChannelCoverInfo.bid <= 0L) {
        break;
      }
      localObject = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramTabChannelCoverInfo.mChannelCoverId));
      if (localObject == null) {
        break;
      }
      localFragment = a((TemplateFactory)localObject, paramTabChannelCoverInfo);
      localObject = localFragment;
    } while (localFragment != null);
    return ReadInJoySubChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelType, paramTabChannelCoverInfo.mChannelCoverName);
  }
  
  private Fragment f(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ReadInJoyViolaChannelFragment localReadInJoyViolaChannelFragment = ReadInJoyViolaChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelVersion);
    if (paramTabChannelCoverInfo.mChannelCoverId == 41655) {
      localReadInJoyViolaChannelFragment.setArguments(MultiVideoHelper.a());
    }
    localReadInJoyViolaChannelFragment.a(paramTabChannelCoverInfo.mChannelJumpUrl);
    return localReadInJoyViolaChannelFragment;
  }
  
  public Fragment a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null)
    {
      QLog.d("ReadInJoyFragmentFactory", 1, "tabChannelCoverInfo is null.");
      return null;
    }
    QLog.d("ReadInJoyFragmentFactory", 1, new Object[] { "new Fragment, channelName = ", paramTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    Fragment localFragment = b(paramTabChannelCoverInfo);
    if ((localFragment instanceof ReadInJoyBaseFragment)) {
      ((ReadInJoyBaseFragment)localFragment).b(true);
    }
    RIJXTabFrameUtils.a.a(paramTabChannelCoverInfo, localFragment);
    return localFragment;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference.clear();
      this.jdField_a_of_type_MqqUtilWeakReference = null;
    }
  }
  
  public void a(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramReadInJoyNewFeedsActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentFactory
 * JD-Core Version:    0.7.0.1
 */