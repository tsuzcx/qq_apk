package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class StoryPlayerWebFragment
  extends WebViewFragment
{
  protected StoryPlayerWebFragment.StoryPlayerWebFragmentEventListener a;
  public BroadcastReceiver b = new StoryPlayerWebFragment.1(this);
  
  public static Intent a(Activity paramActivity, String paramString)
  {
    paramActivity = new Intent(paramActivity, StoryPlayerWebToolFragment.class);
    paramActivity.putExtra("url", paramString);
    paramActivity.putExtra("isFullScreen", true);
    return paramActivity;
  }
  
  public static StoryPlayerWebFragment a(Intent paramIntent)
  {
    StoryPlayerWebFragment localStoryPlayerWebFragment = new StoryPlayerWebFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localStoryPlayerWebFragment.setArguments(localBundle);
    return localStoryPlayerWebFragment;
  }
  
  public void a()
  {
    if (getUIStyleHandler().t) {
      return;
    }
    SLog.b("StoryPlayerWebFragment", "showPreview()");
    Util.f("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    getUIStyleHandler().a(this.intent);
    getUIStyle().e = 0L;
    this.contentView.a(getUIStyleHandler().f.O);
    getWebTitleBarInterface().d(true);
    getWebTitleBarInterface().b(false);
    getWebTitleBarInterface().c(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init view 1, cost = ");
    localStringBuilder.append((System.nanoTime() - l) / 1000000L);
    SLog.b("StoryPlayerWebFragment", localStringBuilder.toString());
    getUIStyleHandler().t = true;
    getUIStyleHandler().B = this.contentView.b;
    this.contentView.a.setVisibility(8);
    getUIStyleHandler().b(this.mUrl);
    getUIStyleHandler().d = false;
    Util.g("Web_qqbrowser_ShowPreview");
  }
  
  public void a(StoryPlayerWebFragment.StoryPlayerWebFragmentEventListener paramStoryPlayerWebFragmentEventListener)
  {
    this.a = paramStoryPlayerWebFragmentEventListener;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new StoryPlayerWebFragment.2(this, this.webViewSurface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new IntentFilter();
    paramViewGroup.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    getQBaseActivity().registerReceiver(this.b, paramViewGroup, "com.tencent.msg.permission.pushnotify", null);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SLog.b("StoryPlayerWebFragment", "onDestroy()");
    getQBaseActivity().unregisterReceiver(this.b);
  }
  
  public void onPause()
  {
    super.onPause();
    SLog.b("StoryPlayerWebFragment", "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    SLog.b("StoryPlayerWebFragment", "onResume()");
    QBaseActivity localQBaseActivity = super.getQBaseActivity();
    if (localQBaseActivity != null)
    {
      int i = localQBaseActivity.getWindow().getDecorView().getSystemUiVisibility();
      localQBaseActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment
 * JD-Core Version:    0.7.0.1
 */