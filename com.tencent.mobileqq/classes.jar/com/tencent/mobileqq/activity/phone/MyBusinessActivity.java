package com.tencent.mobileqq.activity.phone;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class MyBusinessActivity
  extends PublicAccountBrowser
{
  public static void a(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit().putBoolean("MyBusinessActivity_NeedRefreshPage", paramBoolean).commit();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).getBoolean("MyBusinessActivity_NeedRefreshPage", false))
    {
      WebViewFragment localWebViewFragment = b();
      if ((localWebViewFragment != null) && (localWebViewFragment.a != null)) {
        localWebViewFragment.a.reload();
      }
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.MyBusinessActivity
 * JD-Core Version:    0.7.0.1
 */