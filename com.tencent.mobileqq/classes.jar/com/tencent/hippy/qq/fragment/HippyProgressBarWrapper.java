package com.tencent.hippy.qq.fragment;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;

public class HippyProgressBarWrapper
{
  private WebViewProgressBar mProgressBar;
  private WebViewProgressBarController mProgressBarController;
  
  public void hideProgressBar()
  {
    WebViewProgressBarController localWebViewProgressBarController = this.mProgressBarController;
    if ((localWebViewProgressBarController != null) && (localWebViewProgressBarController.d() != 2)) {
      this.mProgressBarController.a((byte)2);
    }
  }
  
  public void initProgressBar(ViewGroup paramViewGroup)
  {
    if (this.mProgressBar != null) {
      return;
    }
    this.mProgressBar = new WebViewProgressBar(paramViewGroup.getContext());
    this.mProgressBar.setId(2131440738);
    this.mProgressBarController = new WebViewProgressBarController();
    this.mProgressBarController.a(this.mProgressBar);
    this.mProgressBar.setController(this.mProgressBarController);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, Utils.a(3.0F, paramViewGroup.getContext().getResources()));
    paramViewGroup.addView(this.mProgressBar, localLayoutParams);
  }
  
  public void startProgressBar()
  {
    WebViewProgressBarController localWebViewProgressBarController = this.mProgressBarController;
    if ((localWebViewProgressBarController != null) && (localWebViewProgressBarController.d() != 0)) {
      this.mProgressBarController.a((byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.HippyProgressBarWrapper
 * JD-Core Version:    0.7.0.1
 */