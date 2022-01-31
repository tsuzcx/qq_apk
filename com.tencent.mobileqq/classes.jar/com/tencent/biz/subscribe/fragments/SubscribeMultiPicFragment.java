package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import common.config.service.QzoneConfig;
import vxs;
import vxy;
import vya;
import wcw;
import wcx;
import wfz;
import wye;

public class SubscribeMultiPicFragment
  extends SubscribeBaseFragment
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private vxy jdField_a_of_type_Vxy;
  private View b;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.mContentView.findViewById(2131299261));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131303731));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131302884);
    this.b = this.mContentView.findViewById(2131303050);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131302989));
    this.jdField_c_of_type_AndroidViewView = this.mContentView.findViewById(2131303382);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    this.jdField_a_of_type_Vxy = new vxy(localBundle);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Vxy);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new vxs(localBundle));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new vya(localBundle));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new wcw(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    this.b.setOnClickListener(new wcx(this));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Vxy != null) && (this.jdField_a_of_type_Vxy.a() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a() != null)) {
      wye.a(this.jdField_a_of_type_Vxy.a().poster.id.get(), "auth_" + wfz.a(this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a()), "read", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", this.jdField_a_of_type_Vxy.a().id.get() });
    }
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
    if (this.jdField_a_of_type_Vxy != null) {
      this.jdField_a_of_type_Vxy.a(paramStFeed);
    }
  }
  
  protected void a(View paramView) {}
  
  public View b()
  {
    return this.jdField_c_of_type_AndroidViewView;
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
    return 2131493126;
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
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.c();
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