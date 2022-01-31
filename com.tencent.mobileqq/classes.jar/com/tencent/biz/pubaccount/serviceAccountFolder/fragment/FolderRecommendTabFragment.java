package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bdea;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import ssy;
import ybu;
import yei;
import zaj;

public class FolderRecommendTabFragment
  extends FolderBaseTabFragment
{
  protected ExtraTypeInfo a;
  private ComponentPageView a;
  private boolean b;
  private int jdField_c_of_type_Int = QzoneConfig.getInstance().getConfig("qqsubscribe", "RecommendBannerCheckDisplayInterval", 3);
  protected String c;
  private boolean jdField_c_of_type_Boolean;
  
  private boolean a()
  {
    long l = a();
    return System.currentTimeMillis() / 1000L - l > this.jdField_c_of_type_Int * 24 * 60 * 60;
  }
  
  public int a()
  {
    return jdField_b_of_type_Int;
  }
  
  public long a()
  {
    try
    {
      long l = Long.valueOf(bdea.a(BaseApplicationImpl.getContext(), "subscribe_recommend_banner_unlike_timestamp_" + this.jdField_c_of_type_JavaLangString)).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0L;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558706, null);
    }
    this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_b_of_type_Boolean = ybu.a();
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      ExtraTypeInfo localExtraTypeInfo2 = (ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      ExtraTypeInfo localExtraTypeInfo1 = localExtraTypeInfo2;
      if (localExtraTypeInfo2 == null) {
        localExtraTypeInfo1 = new ExtraTypeInfo();
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo(7004, localExtraTypeInfo1.sourceType);
    }
    b();
    QLog.d(FolderBaseTabFragment.a, 4, "initViewData:" + a());
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == a())
    {
      paramServiceAccountFolderActivityNew.a(false);
      if ((a()) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        zaj.a("auth_discover", "reco_exp", 0, 0, new String[0]);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375761));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    if (a()) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new ssy(this, null));
    }
    yei localyei = new yei(null);
    localyei.b(0);
    localyei.c(this.jdField_b_of_type_Boolean);
    localyei.b(false);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(localyei);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.c();
  }
  
  public void c()
  {
    long l = System.currentTimeMillis() / 1000L;
    bdea.a(BaseApplicationImpl.getContext(), "subscribe_recommend_banner_unlike_timestamp_" + this.jdField_c_of_type_JavaLangString, String.valueOf(l));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131558706, null);
    }
    this.jdField_b_of_type_Boolean = ybu.a();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      QLog.d(FolderBaseTabFragment.a, 4, "onCreateView:" + a());
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment
 * JD-Core Version:    0.7.0.1
 */