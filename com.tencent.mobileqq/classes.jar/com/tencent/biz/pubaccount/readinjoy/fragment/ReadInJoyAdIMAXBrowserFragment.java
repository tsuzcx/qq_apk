package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import bieo;
import biur;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import mqq.app.AppRuntime;
import pxm;
import pxn;
import six;

public class ReadInJoyAdIMAXBrowserFragment
  extends WebViewFragment
{
  public long a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ActionEntity jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  public ReadInJoyAdIMAXBrowserFragment()
  {
    this.jdField_a_of_type_Long = 8996L;
  }
  
  private View.OnClickListener a()
  {
    return new pxn(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowAdType;
      if (i == 1001)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity = ActionEntity.ImaxVideo;
        return;
      }
    } while (i != 1002);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity = ActionEntity.ImaxPic;
  }
  
  private void b()
  {
    LiuHaiUtils.a(getActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getActivity());
    }
    if (LiuHaiUtils.b()) {}
    for (int i = LiuHaiUtils.b(getActivity());; i = 0)
    {
      if (this.mUIStyleHandler.mSwiftTitleUI.titleContainer != null) {
        this.mUIStyleHandler.mSwiftTitleUI.titleContainer.setVisibility(8);
      }
      if (this.mUIStyleHandler.mRootView != null) {
        adjustWebViewTopMargin(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296655), 0);
      }
      if (this.mUIStyleHandler.webviewWrapper == null) {
        return;
      }
      int j = UIUtils.dip2px(getActivity(), 30.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842969);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = UIUtils.dip2px(getActivity(), 15.0F);
      localLayoutParams.topMargin = (UIUtils.dip2px(getActivity(), 15.0F) + i);
      this.mUIStyleHandler.webviewWrapper.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new pxm(this));
      this.b = new ImageView(getActivity());
      this.b.setBackgroundResource(2130842971);
      localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = UIUtils.dip2px(getActivity(), 15.0F);
      localLayoutParams.topMargin = (i + UIUtils.dip2px(getActivity(), 15.0F));
      this.mUIStyleHandler.webviewWrapper.addView(this.b, localLayoutParams);
      this.b.setOnClickListener(a());
      return;
    }
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.mProgressBarController != null)) {
      this.mUIStyleHandler.mProgressBarController.a(false);
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.mRootView != null))
    {
      paramBundle = this.mUIStyleHandler.mRootView.findViewById(2131365186);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setVisibility(8);
    }
    six.b(getHostActivity());
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle instanceof ToolAppRuntime)) {
      this.jdField_a_of_type_MqqAppAppRuntime = paramBundle.getAppRuntime("modular_web");
    }
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)getIntent().getParcelableExtra("ad"));
    a();
    return i;
  }
  
  public int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    if (this.mUIStyleHandler != null)
    {
      this.mUIStyleHandler.mUIStyle.mIsDisableRefreshView = true;
      this.mUIStyleHandler.mUIStyle.needHideBottomBar = true;
      this.mUIStyle.isCurrentTitleTransparent = true;
    }
    six.b(getHostActivity());
    return super.doCreateLoopStep_InitData(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    six.b(getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */