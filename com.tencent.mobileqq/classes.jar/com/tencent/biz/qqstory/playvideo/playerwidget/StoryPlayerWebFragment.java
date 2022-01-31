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
import bcfg;
import bcfx;
import bcga;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import nau;
import uiy;
import uiz;
import ved;

public class StoryPlayerWebFragment
  extends WebViewFragment
{
  public BroadcastReceiver a;
  public uiz a;
  
  public StoryPlayerWebFragment()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new uiy(this);
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
  
  public void a(uiz paramuiz)
  {
    this.jdField_a_of_type_Uiz = paramuiz;
  }
  
  public boolean a()
  {
    ved.b("StoryPlayerWebFragment", "showPreview()");
    nau.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_Bcfx.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_Bcga.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.a(this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bcga.B);
    this.p = true;
    this.q = false;
    F();
    ved.b("StoryPlayerWebFragment", "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    this.jdField_a_of_type_Bcfx.c = true;
    this.jdField_a_of_type_Bcfx.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetProgressBar;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_Bcfx.a(this.h);
    this.jdField_a_of_type_Bcfx.b = false;
    nau.b("Web_qqbrowser_ShowPreview");
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Bcfg.a("web_view_long_click", false);
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
    ved.b("StoryPlayerWebFragment", "onDestroy()");
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onPause()
  {
    super.onPause();
    ved.b("StoryPlayerWebFragment", "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    ved.b("StoryPlayerWebFragment", "onResume()");
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment
 * JD-Core Version:    0.7.0.1
 */