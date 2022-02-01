package com.tencent.biz.pubaccount.ecshopassit.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bieb;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import opg;
import opt;
import opu;
import opv;

public class EcshopTabFragment
  extends PublicBaseFragment
{
  private static final String b = EcshopTabFragment.class.getSimpleName();
  public int a;
  private EcshopWebview a;
  public String a;
  public opt a;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = opv.a().a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    paramView = (FrameLayout)paramView.findViewById(2131365163);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    }
    paramView.addView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    this.jdField_a_of_type_Opt = new opu(this, getActivity(), getActivity(), opg.a(), this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Opt.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new bieb(this.jdField_a_of_type_Opt).a(null, opg.a(), null);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setDrawingCacheEnabled(true);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview != null) && (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.loadUrl(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "【setData】");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(EcshopTabFragment paramEcshopTabFragment)
  {
    if (paramEcshopTabFragment == null) {}
    while ((!this.jdField_a_of_type_JavaLangString.equals(paramEcshopTabFragment.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Int != paramEcshopTabFragment.jdField_a_of_type_Int)) {
      return false;
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561922, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Opt != null) {
      this.jdField_a_of_type_Opt.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopTabFragment
 * JD-Core Version:    0.7.0.1
 */