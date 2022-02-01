package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;

public class WebpageFragment
  extends WebViewFragment
{
  private AdvertisementItem a;
  
  public static WebpageFragment a(Intent paramIntent)
  {
    WebpageFragment localWebpageFragment = new WebpageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localWebpageFragment.setArguments(localBundle);
    return localWebpageFragment;
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    this.a = paramAdvertisementItem;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReportController.a(null, "dc00898", "", this.a.a.a, "0X8008F6B", "0X8008F6B", 0, 0, this.a.a.c, "", "", this.a.a.b);
  }
  
  public void onResume()
  {
    super.onResume();
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
  
  public boolean showPreview()
  {
    Util.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.mUIStyleHandler.a(this.intent);
    this.mUIStyle.c = 0L;
    this.contentView.a(this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.D);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    setImmersiveStatus();
    if (QLog.isColorLevel()) {
      QLog.d("WebpageFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    }
    this.mUIStyleHandler.c = true;
    this.mUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar = this.contentView.jdField_a_of_type_AndroidWidgetProgressBar;
    this.contentView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.mUIStyleHandler.a(this.mUrl);
    this.mUIStyleHandler.b = false;
    Util.b("Web_qqbrowser_ShowPreview");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment
 * JD-Core Version:    0.7.0.1
 */