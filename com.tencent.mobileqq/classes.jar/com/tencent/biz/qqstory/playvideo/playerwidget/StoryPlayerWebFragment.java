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
import beeh;
import beey;
import befb;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import ndq;
import vxq;
import vxr;
import wsv;

public class StoryPlayerWebFragment
  extends WebViewFragment
{
  public BroadcastReceiver a;
  public vxr a;
  
  public StoryPlayerWebFragment()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vxq(this);
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
  
  public void a(vxr paramvxr)
  {
    this.jdField_a_of_type_Vxr = paramvxr;
  }
  
  public boolean a()
  {
    wsv.b("StoryPlayerWebFragment", "showPreview()");
    ndq.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_Beey.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_Befb.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.a(this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.D);
    this.p = true;
    this.q = false;
    G();
    wsv.b("StoryPlayerWebFragment", "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    this.jdField_a_of_type_Beey.c = true;
    this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetProgressBar;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_Beey.a(this.g);
    this.jdField_a_of_type_Beey.b = false;
    ndq.b("Web_qqbrowser_ShowPreview");
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Beeh.a("web_view_long_click", false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new IntentFilter();
    paramViewGroup.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup, "com.tencent.msg.permission.pushnotify", null);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    wsv.b("StoryPlayerWebFragment", "onDestroy()");
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onPause()
  {
    super.onPause();
    wsv.b("StoryPlayerWebFragment", "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    wsv.b("StoryPlayerWebFragment", "onResume()");
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment
 * JD-Core Version:    0.7.0.1
 */