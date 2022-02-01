package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.CommodityAdapter;
import com.tencent.biz.subscribe.bizdapters.MultiPicHeaderBlock;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class SubscribeMultiPicFragment
  extends SubscribeBaseFragment
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MultiPicHeaderBlock jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock;
  private BlockContainer jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
  private View b;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    localBundle.putSerializable("bundle_key_feed_extra_type_info", this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock = new MultiPicHeaderBlock(localBundle);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock.a(getActivity().mSystemBarComp);
    if (this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock);
    }
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131365447));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370610));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131369580);
    this.b = this.mContentView.findViewById(2131369807);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369721));
    this.jdField_c_of_type_AndroidViewView = this.mContentView.findViewById(2131370210);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(new CommodityAdapter(localBundle));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(new RelativeFeedsAdapter(localBundle));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new SubscribeMultiPicFragment.1(this));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
    this.b.setOnClickListener(new SubscribeMultiPicFragment.2(this));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock.a() != null) && (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a() != null)) {
      VSReporter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock.a().poster.id.get(), "auth_" + SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a()), "read", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock.a().id.get() });
    }
  }
  
  public int a()
  {
    return ImmersiveUtils.dpToPx(50.0F);
  }
  
  protected View a()
  {
    return this.b;
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock.a(paramStFeed);
    }
  }
  
  protected void a(View paramView) {}
  
  protected boolean a()
  {
    return true;
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    float f1 = 1.333333F;
    float f2 = paramInt2 / paramInt1;
    if (f2 > 1.333333F) {}
    for (;;)
    {
      paramInt1 = (int)(f1 * ImmersiveUtils.getScreenWidth());
      return new int[] { (int)(paramInt1 / f2), paramInt1 };
      f1 = f2;
    }
  }
  
  public View b()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    ThreadManager.getSubThreadHandler().post(new SubscribeMultiPicFragment.3(this, paramStFeed));
  }
  
  public View c()
  {
    return this.b;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    hideTitleBar();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131558849;
  }
  
  public boolean isWrapContent()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null) && (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a())) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType == 9001))
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getActivity(), str, 2016, null, null);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.b();
    }
    TimeAndCountHelper.a().a("subscribe_freshman_interaction_guide");
    TimeAndCountHelper.a().a("subscribe_freshman_share_guide");
    if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersMultiPicHeaderBlock.g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment
 * JD-Core Version:    0.7.0.1
 */