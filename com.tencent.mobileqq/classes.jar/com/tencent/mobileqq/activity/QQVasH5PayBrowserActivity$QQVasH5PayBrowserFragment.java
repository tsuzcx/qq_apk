package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import bcfj;
import bcfm;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import wim;

public class QQVasH5PayBrowserActivity$QQVasH5PayBrowserFragment
  extends WebViewFragment
{
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    int j = paramViewGroup.getChildCount();
    int i = 0;
    label12:
    View localView;
    if (i < j)
    {
      localView = paramViewGroup.getChildAt(i);
      if (!(localView instanceof ViewGroup)) {
        break label54;
      }
      localView.setBackgroundColor(0);
      a((ViewGroup)localView);
    }
    for (;;)
    {
      i += 1;
      break label12;
      break;
      label54:
      localView.setBackgroundColor(0);
    }
  }
  
  @TargetApi(11)
  private void i()
  {
    if (super.getWebView() != null)
    {
      if ((this.jdField_a_of_type_Bcfm.a & 0x80000) == 0L) {
        break label223;
      }
      this.jdField_a_of_type_Bcfj.a.setVisibility(8);
      Intent localIntent = a();
      if ((localIntent == null) || (!localIntent.getBooleanExtra("from_qreader", false))) {
        break label172;
      }
      a((ViewGroup)getActivity().getWindow().getDecorView());
      if ((this.jdField_a_of_type_Bcfj.c instanceof RefreshView)) {
        ((RefreshView)this.jdField_a_of_type_Bcfj.c).a(false);
      }
      if (this.jdField_a_of_type_Bcfj.b != null) {
        this.jdField_a_of_type_Bcfj.b.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() == null) {
        break label195;
      }
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.setLayerType(1, null);
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setBackgroundColor(0);
      }
      catch (Exception localException)
      {
        label172:
        localException.printStackTrace();
        continue;
      }
      m(true);
      super.getWebView().setVisibility(4);
      return;
      super.getActivity().getWindow().setBackgroundDrawableResource(2131167087);
      break;
      label195:
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setLayerType(1, null);
        continue;
        label223:
        if (this.jdField_a_of_type_Bcfj.b != null) {
          this.jdField_a_of_type_Bcfj.b.setVisibility(0);
        }
      }
    }
  }
  
  public int a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "QQVasH5PayBrowserActivity doCreateLoopStep_Final: ");
    }
    int i = super.a(paramBundle);
    super.getWebView().setVisibility(0);
    return i;
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    wim.a(1, 2131695563);
    super.getActivity().finish();
  }
  
  @TargetApi(11)
  public int d(Bundle paramBundle)
  {
    int i = super.d(paramBundle);
    i();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment
 * JD-Core Version:    0.7.0.1
 */