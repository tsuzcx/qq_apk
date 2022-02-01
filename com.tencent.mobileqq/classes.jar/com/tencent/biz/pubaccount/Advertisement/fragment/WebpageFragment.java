package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

public class WebpageFragment
  extends WebViewFragment
{
  private AdvertisementItem a;
  
  public static WebpageFragment a(Intent paramIntent)
  {
    WebpageFragment localWebpageFragment = new WebpageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localWebpageFragment.setArguments(localBundle);
    return localWebpageFragment;
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    this.a = paramAdvertisementItem;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new WebpageFragment.1(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReportController.a(null, "dc00898", "", this.a.a.a, "0X8008F6B", "0X8008F6B", 0, 0, this.a.a.c, "", "", this.a.a.b);
  }
  
  public void onResume()
  {
    super.onResume();
    QBaseActivity localQBaseActivity = super.getQBaseActivity();
    if (localQBaseActivity != null)
    {
      int i = localQBaseActivity.getWindow().getDecorView().getSystemUiVisibility();
      localQBaseActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment
 * JD-Core Version:    0.7.0.1
 */