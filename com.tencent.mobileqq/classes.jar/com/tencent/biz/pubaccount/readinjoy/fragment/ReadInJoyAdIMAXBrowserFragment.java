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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.util.LiuHaiUtils;
import mqq.app.AppRuntime;

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
    return new ReadInJoyAdIMAXBrowserFragment.2(this);
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
      if (this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a != null) {
        this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.setVisibility(8);
      }
      if (this.mUIStyleHandler.d != null) {
        adjustWebViewTopMargin(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296674), 0);
      }
      if (this.mUIStyleHandler.c == null) {
        return;
      }
      int j = UIUtils.a(getActivity(), 30.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843124);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = UIUtils.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (UIUtils.a(getActivity(), 15.0F) + i);
      this.mUIStyleHandler.c.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyAdIMAXBrowserFragment.1(this));
      this.b = new ImageView(getActivity());
      this.b.setBackgroundResource(2130843126);
      localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = UIUtils.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (i + UIUtils.a(getActivity(), 15.0F));
      this.mUIStyleHandler.c.addView(this.b, localLayoutParams);
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
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null)) {
      this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(false);
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.d != null))
    {
      paramBundle = this.mUIStyleHandler.d.findViewById(2131365324);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setVisibility(8);
    }
    VideoFeedsHelper.b(getHostActivity());
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
      this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.D = true;
      this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.f = true;
      this.mUIStyle.n = true;
    }
    VideoFeedsHelper.b(getHostActivity());
    return super.doCreateLoopStep_InitData(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    VideoFeedsHelper.b(getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */