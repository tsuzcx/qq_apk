package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$1
  implements View.OnClickListener
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$1(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    TouchWebView localTouchWebView;
    StringBuilder localStringBuilder;
    if (i != 2131436180)
    {
      if (i != 2131436211)
      {
        onClick(paramView);
        return;
      }
      if (!this.a.getUIStyleHandler().f.a)
      {
        paramView = this.a.getSwiftTitleUI().f.getText().toString();
        localTouchWebView = PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:onRightBtn(\"");
        localStringBuilder.append(paramView);
        localStringBuilder.append("\")");
        localTouchWebView.loadUrl(localStringBuilder.toString());
        return;
      }
      if (PublicAccountBrowserImpl.PublicAccountBrowserFragment.b(this.a) == 1001)
      {
        ThreadManager.executeOnSubThread(new PublicAccountBrowserImpl.PublicAccountBrowserFragment.1.1(this));
        this.a.getActivity().finish();
        return;
      }
      onClick(paramView);
      return;
    }
    if (!this.a.getUIStyleHandler().f.a)
    {
      paramView = this.a.getSwiftTitleUI().d.getText().toString();
      if (paramView.equals(PublicAccountBrowserImpl.PublicAccountBrowserFragment.d(this.a).getStringExtra("leftViewText")))
      {
        this.a.doOnBackEvent();
        return;
      }
      localTouchWebView = PublicAccountBrowserImpl.PublicAccountBrowserFragment.e(this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:onLeftBtn(\"");
      localStringBuilder.append(paramView);
      localStringBuilder.append("\")");
      localTouchWebView.loadUrl(localStringBuilder.toString());
      return;
    }
    onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */