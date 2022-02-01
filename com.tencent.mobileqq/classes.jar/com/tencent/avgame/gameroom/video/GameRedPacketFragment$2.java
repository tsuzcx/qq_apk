package com.tencent.avgame.gameroom.video;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewUIUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;

class GameRedPacketFragment$2
  extends WebKernelCallBackProxy
{
  GameRedPacketFragment$2(GameRedPacketFragment paramGameRedPacketFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    if (this.a.getActivity() != null)
    {
      if (this.a.getActivity().getIntent() == null) {
        return;
      }
      if (GameRedPacketFragment.e(this.a).getIntExtra("key_dialog_type", -1) != -1)
      {
        this.a.getActivity().getWindow().setFlags(1024, 1024);
        this.a.getUIStyleHandler().v.setVisibility(8);
        this.a.getUIStyle().a = true;
        WebViewUIUtils.b(this.a.getActivity());
        this.a.getWebTitleBarInterface().f(false);
      }
    }
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    super.onInitUIContent(paramBundle);
    this.a.getActivity().getWindow().setBackgroundDrawableResource(2131168376);
    if ((this.a.getUIStyleHandler().u instanceof RefreshView)) {
      ((RefreshView)this.a.getUIStyleHandler().u).a(false);
    }
    if (this.a.getUIStyleHandler().D != null) {
      this.a.getUIStyleHandler().D.setVisibility(8);
    }
    if (GameRedPacketFragment.a(this.a).getX5WebViewExtension() != null) {
      try
      {
        GameRedPacketFragment.b(this.a).getView().setBackgroundColor(0);
        GameRedPacketFragment.c(this.a).setBackgroundColor(0);
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } else {
      GameRedPacketFragment.d(this.a).setBackgroundColor(0);
    }
    this.a.contentView.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.GameRedPacketFragment.2
 * JD-Core Version:    0.7.0.1
 */