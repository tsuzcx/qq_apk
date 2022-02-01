package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import birg;
import birj;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import zyx;

public class QQVasH5PayBrowserActivity$QQVasH5PayBrowserFragment
  extends WebViewFragment
{
  @TargetApi(11)
  private void a()
  {
    if (super.getWebView() != null)
    {
      if ((this.mUIStyle.a & 0x80000) == 0L) {
        break label223;
      }
      this.mUIStyleHandler.a.setVisibility(8);
      Intent localIntent = getIntent();
      if ((localIntent == null) || (!localIntent.getBooleanExtra("from_qreader", false))) {
        break label172;
      }
      a((ViewGroup)getActivity().getWindow().getDecorView());
      if ((this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
        ((RefreshView)this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup).a(false);
      }
      if (this.mUIStyleHandler.jdField_c_of_type_AndroidViewView != null) {
        this.mUIStyleHandler.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.webView.getX5WebViewExtension() == null) {
        break label195;
      }
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 11) {
          this.webView.setLayerType(1, null);
        }
        this.webView.getView().setBackgroundColor(0);
      }
      catch (Exception localException)
      {
        label172:
        localException.printStackTrace();
        continue;
      }
      setRightButton(true);
      super.getWebView().setVisibility(4);
      return;
      super.getActivity().getWindow().setBackgroundDrawableResource(2131167247);
      break;
      label195:
      this.webView.setBackgroundColor(0);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.webView.setLayerType(1, null);
        continue;
        label223:
        if (this.mUIStyleHandler.jdField_c_of_type_AndroidViewView != null) {
          this.mUIStyleHandler.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
  }
  
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
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "QQVasH5PayBrowserActivity doCreateLoopStep_Final: ");
    }
    int i = super.doCreateLoopStep_Final(paramBundle);
    super.getWebView().setVisibility(0);
    return i;
  }
  
  @TargetApi(11)
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    a();
    return i;
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    zyx.a(1, 2131694654);
    super.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment
 * JD-Core Version:    0.7.0.1
 */