package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import bihn;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import nwo;
import xpl;
import xpm;
import ykq;

public class StoryPlayerWebFragment
  extends WebViewFragment
{
  public BroadcastReceiver a;
  public xpm a;
  
  public StoryPlayerWebFragment()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new xpl(this);
  }
  
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
  
  public void a(xpm paramxpm)
  {
    this.jdField_a_of_type_Xpm = paramxpm;
  }
  
  public void initWebView()
  {
    super.initWebView();
    this.mSetting.a("web_view_long_click", false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new IntentFilter();
    paramViewGroup.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup, "com.tencent.msg.permission.pushnotify", null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ykq.b("StoryPlayerWebFragment", "onDestroy()");
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onPause()
  {
    super.onPause();
    ykq.b("StoryPlayerWebFragment", "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    ykq.b("StoryPlayerWebFragment", "onResume()");
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
  
  public boolean showPreview()
  {
    ykq.b("StoryPlayerWebFragment", "showPreview()");
    nwo.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.mUIStyleHandler.initUIStyle(this.intent);
    this.mUIStyle.mFloatBarRulesFromUrl = 0L;
    this.contentView.a(this.mUIStyleHandler.mUIStyle.mIsDisableRefreshView);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    setImmersiveStatus();
    ykq.b("StoryPlayerWebFragment", "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    this.mUIStyleHandler.mIsShownPreview = true;
    this.mUIStyleHandler.waitting = this.contentView.jdField_a_of_type_AndroidWidgetProgressBar;
    this.contentView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.mUIStyleHandler.needTitlebarTransparent(this.mUrl);
    this.mUIStyleHandler.canWebViewOverScroll = false;
    nwo.b("Web_qqbrowser_ShowPreview");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment
 * JD-Core Version:    0.7.0.1
 */