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
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;
import ydu;
import yeg;
import yei;
import yjk;
import yjl;
import ykt;
import ymo;
import yod;
import zaj;

public class SubscribeMultiPicFragment
  extends SubscribeBaseFragment
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private yeg jdField_a_of_type_Yeg;
  private View b;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    localBundle.putSerializable("bundle_key_feed_extra_type_info", this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_Yeg = new yeg(localBundle);
    this.jdField_a_of_type_Yeg.a(getActivity().mSystemBarComp);
    if (this.jdField_a_of_type_Ykt != null) {
      this.jdField_a_of_type_Ykt.a(this.jdField_a_of_type_Yeg);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.mContentView.findViewById(2131364911));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131369666));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368710);
    this.b = this.mContentView.findViewById(2131368912);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131368837));
    this.jdField_c_of_type_AndroidViewView = this.mContentView.findViewById(2131369298);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Yeg);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new ydu(localBundle));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new yei(localBundle));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new yjk(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.c();
    this.b.setOnClickListener(new yjl(this));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Yeg != null) && (this.jdField_a_of_type_Yeg.a() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a() != null)) {
      zaj.a(this.jdField_a_of_type_Yeg.a().poster.id.get(), "auth_" + yod.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a()), "read", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", this.jdField_a_of_type_Yeg.a().id.get() });
    }
  }
  
  public int a()
  {
    return ImmersiveUtils.a(50.0F);
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
    if (this.jdField_a_of_type_Yeg != null) {
      this.jdField_a_of_type_Yeg.a(paramStFeed);
    }
  }
  
  protected void a(View paramView) {}
  
  public int[] a(int paramInt1, int paramInt2)
  {
    float f1 = 1.333333F;
    float f2 = paramInt2 / paramInt1;
    if (f2 > 1.333333F) {}
    for (;;)
    {
      paramInt1 = (int)(f1 * ImmersiveUtils.a());
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
    return 2131558712;
  }
  
  public boolean isNeedMiniMsg()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a())) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType == 9001))
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      MiniAppLauncher.startMiniApp(getActivity(), str, 2016, null, null);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.b();
    }
    ymo.a().a("subscribe_freshman_interaction_guide");
    ymo.a().a("subscribe_freshman_share_guide");
    if (this.jdField_a_of_type_Yeg != null) {
      this.jdField_a_of_type_Yeg.j();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment
 * JD-Core Version:    0.7.0.1
 */