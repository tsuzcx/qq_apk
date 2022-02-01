package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$1
  implements View.OnClickListener
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$1(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str;
      if (!this.a.mUIStyleHandler.a.a)
      {
        str = this.a.mSwiftTitleUI.c.getText().toString();
        this.a.webView.loadUrl("javascript:onRightBtn(\"" + str + "\")");
      }
      else if (PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a) == 1001)
      {
        ThreadManager.executeOnSubThread(new PublicAccountBrowserImpl.PublicAccountBrowserFragment.1.1(this));
        this.a.getActivity().finish();
      }
      else
      {
        onClick(paramView);
        continue;
        if (!this.a.mUIStyleHandler.a.a)
        {
          str = this.a.mSwiftTitleUI.a.getText().toString();
          if (str.equals(PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a).getStringExtra("leftViewText"))) {
            this.a.doOnBackEvent();
          } else {
            this.a.webView.loadUrl("javascript:onLeftBtn(\"" + str + "\")");
          }
        }
        else
        {
          onClick(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */