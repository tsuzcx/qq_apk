package com.tencent.biz.pubaccount.weishi_new.operationh5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCClientHelper;
import com.tencent.biz.pubaccount.weishi_new.operationh5.report.WSOperationH5BeaconReporter;
import com.tencent.biz.pubaccount.weishi_new.operationh5.report.WSOperationH5ReportParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewUIUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;

public class WSOperationWebViewFragment
  extends WebViewFragment
{
  OperationTitleBarView a;
  WSOperationH5BeaconReporter b;
  boolean c = false;
  
  private void a()
  {
    b();
    c();
  }
  
  private void b()
  {
    if (getActivity() != null)
    {
      if (getActivity().getIntent() == null) {
        return;
      }
      getActivity().getWindow().setFlags(1024, 1024);
      getUIStyleHandler().v.setVisibility(8);
      getUIStyle().a = true;
      WebViewUIUtils.b(super.getActivity());
      getWebTitleBarInterface().f(false);
    }
  }
  
  private void c()
  {
    this.a = new OperationTitleBarView(requireActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(10);
    getUIStyleHandler().u.addView(this.a, localLayoutParams);
    getUIStyleHandler().d = false;
    this.a.setOperationTitleClickListener(new WSOperationWebViewFragment.2(this));
    this.webView.addScrollChangedListener(new WSOperationWebViewFragment.3(this));
  }
  
  private void d()
  {
    String str1 = this.intent.getStringExtra("spid");
    String str2 = this.intent.getStringExtra("web_test_id");
    String str3 = this.intent.getStringExtra("web_url");
    String str4 = this.intent.getStringExtra("share_scenes_from");
    this.b = new WSOperationH5BeaconReporter(new WSOperationH5ReportParams(str1, str2, str3, str4));
    Bundle localBundle = new Bundle();
    localBundle.putString("web_url", str3);
    localBundle.putString("spid", str1);
    localBundle.putString("web_test_id", str2);
    localBundle.putString("scenes_channel_from", str4);
    WSPublicAccReport.getInstance().enterPublicAccReport(null, 1, "from_operation_h5", localBundle);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new WSOperationWebViewFragment.1(this, this.webViewSurface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    d();
    this.b.a();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.b.d();
    this.b.b();
    WSPublicAccReport.getInstance().closePublicAccReport(1);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    WSIPCClientHelper.a().a("action_write_back_feed");
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.c)
    {
      this.b.a();
      this.c = false;
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b.c();
    WSIPCClientHelper.a().a("action_req_aio_list_operation_feed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.WSOperationWebViewFragment
 * JD-Core Version:    0.7.0.1
 */