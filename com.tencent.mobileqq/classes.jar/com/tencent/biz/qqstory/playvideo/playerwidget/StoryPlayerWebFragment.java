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
import biqp;
import birg;
import birj;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import noe;
import xzf;
import xzg;
import yuk;

public class StoryPlayerWebFragment
  extends WebViewFragment
{
  public BroadcastReceiver a;
  public xzg a;
  
  public StoryPlayerWebFragment()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new xzf(this);
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
  
  public void a(xzg paramxzg)
  {
    this.jdField_a_of_type_Xzg = paramxzg;
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
    yuk.b("StoryPlayerWebFragment", "onDestroy()");
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onPause()
  {
    super.onPause();
    yuk.b("StoryPlayerWebFragment", "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    yuk.b("StoryPlayerWebFragment", "onResume()");
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
  
  public boolean showPreview()
  {
    yuk.b("StoryPlayerWebFragment", "showPreview()");
    noe.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.mUIStyleHandler.a(this.intent);
    this.mUIStyle.c = 0L;
    this.contentView.a(this.mUIStyleHandler.jdField_a_of_type_Birj.D);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    setImmersiveStatus();
    yuk.b("StoryPlayerWebFragment", "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    this.mUIStyleHandler.c = true;
    this.mUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar = this.contentView.jdField_a_of_type_AndroidWidgetProgressBar;
    this.contentView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.mUIStyleHandler.a(this.mUrl);
    this.mUIStyleHandler.b = false;
    noe.b("Web_qqbrowser_ShowPreview");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment
 * JD-Core Version:    0.7.0.1
 */