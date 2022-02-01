package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import bdla;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;
import nwo;
import oeq;
import oes;

public class WebpageFragment
  extends WebViewFragment
{
  private oeq a;
  
  public static WebpageFragment a(Intent paramIntent)
  {
    WebpageFragment localWebpageFragment = new WebpageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localWebpageFragment.setArguments(localBundle);
    return localWebpageFragment;
  }
  
  public void a(oeq paramoeq)
  {
    this.a = paramoeq;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bdla.a(null, "dc00898", "", this.a.a.a, "0X8008F6B", "0X8008F6B", 0, 0, this.a.a.c, "", "", this.a.a.b);
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
    nwo.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.mUIStyleHandler.initUIStyle(this.intent);
    this.mUIStyle.mFloatBarRulesFromUrl = 0L;
    this.contentView.a(this.mUIStyleHandler.mUIStyle.mIsDisableRefreshView);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    setImmersiveStatus();
    if (QLog.isColorLevel()) {
      QLog.d("WebpageFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    }
    this.mUIStyleHandler.mIsShownPreview = true;
    this.mUIStyleHandler.waitting = this.contentView.jdField_a_of_type_AndroidWidgetProgressBar;
    this.contentView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.mUIStyleHandler.needTitlebarTransparent(this.mUrl);
    this.mUIStyleHandler.canWebViewOverScroll = false;
    nwo.b("Web_qqbrowser_ShowPreview");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment
 * JD-Core Version:    0.7.0.1
 */