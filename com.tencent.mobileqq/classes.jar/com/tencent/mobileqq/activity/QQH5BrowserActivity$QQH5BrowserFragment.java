package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.WebViewProgressBar;

public class QQH5BrowserActivity$QQH5BrowserFragment
  extends WebViewFragment
{
  private void a(Bundle paramBundle)
  {
    super.getQBaseActivity().getWindow().setFlags(1024, 1024);
    this.webView.setVerticalScrollBarEnabled(false);
    getUIStyleHandler().v.setVisibility(8);
    if ((getSwiftTitleUI().o.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      paramBundle = (RelativeLayout.LayoutParams)getSwiftTitleUI().o.getLayoutParams();
      paramBundle.height = ((int)UITools.a(BaseApplicationImpl.getApplication(), 60.0F));
      getSwiftTitleUI().o.setLayoutParams(paramBundle);
    }
    getSwiftTitleUI().o.setPadding(0, 0, 0, 0);
    int i = (int)UITools.a(BaseApplicationImpl.getApplication(), 12.0F);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.width = ((int)UITools.a(BaseApplicationImpl.getApplication(), 15.0F));
    paramBundle.height = ((int)UITools.a(BaseApplicationImpl.getApplication(), 15.0F));
    getSwiftTitleUI().d.setLayoutParams(paramBundle);
    getSwiftTitleUI().d.setBackgroundResource(2130849694);
    getSwiftTitleUI().d.setText("");
    paramBundle = getSwiftTitleUI().d.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getQBaseActivity().findViewById(2131445048);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.setMargins(i, i, 0, 0);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle = getSwiftTitleUI().h.getLayoutParams();
    paramBundle.width = ((int)UITools.a(BaseApplicationImpl.getApplication(), 22.0F));
    paramBundle.height = ((int)UITools.a(BaseApplicationImpl.getApplication(), 15.0F));
    getSwiftTitleUI().h.setLayoutParams(paramBundle);
    getSwiftTitleUI().h.setImageResource(2130850338);
    paramBundle = getSwiftTitleUI().h.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getQBaseActivity().findViewById(2131445049);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, i, i, 0);
    paramBundle.setLayoutParams(localLayoutParams);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QQH5BrowserActivity.QQH5BrowserFragment.1(this, this.webViewSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQH5BrowserActivity.QQH5BrowserFragment
 * JD-Core Version:    0.7.0.1
 */