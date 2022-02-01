package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;

public class QQVasH5PayBrowserActivity$QQVasH5PayBrowserFragment
  extends WebViewFragment
{
  @TargetApi(11)
  private void a()
  {
    if (super.getWebView() != null)
    {
      if ((getUIStyle().c & 0x80000) != 0L)
      {
        getUIStyleHandler().v.setVisibility(8);
        Intent localIntent = getIntent();
        if ((localIntent != null) && (localIntent.getBooleanExtra("from_qreader", false))) {
          a((ViewGroup)getActivity().getWindow().getDecorView());
        } else {
          super.getActivity().getWindow().setBackgroundDrawableResource(2131168376);
        }
        if ((getUIStyleHandler().u instanceof RefreshView)) {
          ((RefreshView)getUIStyleHandler().u).a(false);
        }
        if (getUIStyleHandler().D != null) {
          getUIStyleHandler().D.setVisibility(8);
        }
        if (this.webView.getX5WebViewExtension() != null)
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
            localException.printStackTrace();
          }
        }
        else
        {
          this.webView.setBackgroundColor(0);
          if (Build.VERSION.SDK_INT >= 11) {
            this.webView.setLayerType(1, null);
          }
        }
      }
      else if (getUIStyleHandler().D != null)
      {
        getUIStyleHandler().D.setVisibility(0);
      }
      getWebTitleBarInterface().e(true);
      super.getWebView().setVisibility(4);
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        localView.setBackgroundColor(0);
        a((ViewGroup)localView);
      }
      else
      {
        localView.setBackgroundColor(0);
      }
      i += 1;
    }
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment.1(this, this.webViewSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment
 * JD-Core Version:    0.7.0.1
 */