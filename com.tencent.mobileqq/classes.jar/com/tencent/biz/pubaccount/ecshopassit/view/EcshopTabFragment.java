package com.tencent.biz.pubaccount.ecshopassit.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class EcshopTabFragment
  extends PublicBaseFragment
{
  private static final String b = EcshopTabFragment.class.getSimpleName();
  public int a;
  public EcshopNewPageWebViewBuilder a;
  private EcshopWebview a;
  public String a;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = EcshopWebviewPool.a().a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    }
    paramView = (RefreshView)paramView.findViewById(2131366103);
    paramView.setDelayBeforeScrollBack(500L);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setOnOverScrollHandler(paramView);
    paramView.addView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopNewPageWebViewBuilder = new EcshopTabFragment.1(this, getActivity(), getActivity(), EcshopUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopNewPageWebViewBuilder.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopNewPageWebViewBuilder).a(null, EcshopUtils.a(), null);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setDrawingCacheEnabled(true);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview != null) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString))) {
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131562059, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopNewPageWebViewBuilder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopNewPageWebViewBuilder.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopTabFragment
 * JD-Core Version:    0.7.0.1
 */