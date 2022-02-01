package com.tencent.comic.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import org.json.JSONObject;

@KeepClassConstructor
public class QQComicTitleBarView
  extends SwiftIphoneTitleBarUI
{
  private boolean h = true;
  private boolean i = true;
  private boolean j = true;
  
  public QQComicTitleBarView(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
    paramSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidAppActivity.getIntent();
    int k = paramSwiftBrowserUIStyleHandler.getIntExtra("key_subtab", 0);
    paramSwiftBrowserUIStyleHandler.removeExtra("key_subtab");
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Int != k) {
      g(k);
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup).a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.f = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      this.h = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("txtclr") ^ true);
      this.i = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("titleclr") ^ true);
      this.j = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.has("bgclr") ^ true);
    }
    if (this.j)
    {
      int k = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
      int m = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
      int n = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
      int i1 = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(n, k, i1, m);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().c(true);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a(true);
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a() == null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().b(false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a() != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a().setBackgroundColor(-4210753);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.i = true;
        }
      }
    }
    if ((!this.j) || (!this.i) || (!this.h)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject, true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.d & 0x20) != 0L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      a("", this.c.getResources().getString(1996881921), "", false, 0, 0, null, null, null);
      this.c.setOnClickListener(new QQComicTitleBarView.1(this));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.d & 0x40) != 0L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 15.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.b == -1)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x1000000) <= 0L) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.d & 1L) <= 0L)) {
        b(255);
      } else {
        b(0);
      }
    }
    else {
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.b);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.b.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.c.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      if (this.h) {
        f(-1);
      }
      if (this.i) {
        d(-1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130851213, 2130851214, 2130851215);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167381);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(14);
      }
    }
    else
    {
      if (this.h) {
        f(-16777216);
      }
      if (this.i) {
        d(-16777216);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(1996685327, 1996685328, 1996685329);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(1996554241);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(14);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTitleBarView
 * JD-Core Version:    0.7.0.1
 */