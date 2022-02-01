package com.tencent.mobileqq.activity.aio.confess;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class ConfessHalfScreenActivity$ConfessBrowserFragment$ConfessUIStyleHandler
  extends SwiftBrowserUIStyleHandler
{
  ConfessHalfScreenActivity$ConfessBrowserFragment$ConfessUIStyleHandler(ConfessHalfScreenActivity.ConfessBrowserFragment paramConfessBrowserFragment) {}
  
  public void Y_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      WebView localWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
      localWebView.setId(2131381075);
      if (this.b != -1) {
        localWebView.setBackgroundColor(this.b);
      }
      Object localObject = (Activity)localWebView.getContext();
      if ((localObject instanceof ConfessHalfScreenActivity))
      {
        localObject = (ConfessHalfScreenActivity)localObject;
        ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment, ConfessHalfScreenActivity.a((ConfessHalfScreenActivity)localObject));
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initWebViewInContentView height=");
        ((StringBuilder)localObject).append(ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment));
        QLog.i("SwiftBrowserUIStyleHandler", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.c instanceof RelativeLayout))
      {
        localObject = new RelativeLayout.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment));
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.c.addView(localWebView, 0, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        this.c.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment)));
      }
      this.c.setOnClickListener(new ConfessHalfScreenActivity.ConfessBrowserFragment.ConfessUIStyleHandler.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment.ConfessUIStyleHandler
 * JD-Core Version:    0.7.0.1
 */