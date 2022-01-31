package com.tencent.mobileqq.armap.test;

import abao;
import abap;
import abaq;
import abar;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

public class ARWebTestActivity
  extends AbsBaseWebViewActivity
  implements Animation.AnimationListener
{
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  private boolean jdField_a_of_type_Boolean;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  private TouchWebView jdField_b_of_type_ComTencentBizUiTouchWebView;
  private boolean g;
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, "正在加载地图...", 800);
  }
  
  protected void a(WebView paramWebView, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ARWebTestActivity", 4, String.format(Locale.getDefault(), "onProgressChanged cost: %d  progress: %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), Integer.valueOf(paramInt) }));
    }
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ARWebTestActivity", 4, String.format(Locale.getDefault(), "onReceivedTitle cost: %d  title: %s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), paramString }));
    }
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ARWebTestActivity", 4, String.format(Locale.getDefault(), "onPageStarted cost: %d ", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) }));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ARWebTestActivity", 4, String.format(Locale.getDefault(), "onMapLoadFinished cost: %d url: %s mPageLoadFinished: %b, mUserClicked: %b", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), paramString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.g) }));
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.g)
    {
      b();
      return;
    }
    runOnUiThread(new abao(this));
  }
  
  public void b()
  {
    runOnUiThread(new abar(this));
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ARWebTestActivity", 4, String.format(Locale.getDefault(), "onPageFinished cost: %d  mUserClicked: %b", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), Boolean.valueOf(this.g) }));
    }
    runOnUiThread(new abap(this));
    this.jdField_b_of_type_ComTencentBizUiTouchWebView.postDelayed(new abaq(this, paramString), 15000L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2130970225);
    paramBundle = (FrameLayout)findViewById(2131367095);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369721));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363610));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369722));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizUiTouchWebView = b(paramBundle);
    this.jdField_b_of_type_ComTencentBizUiTouchWebView.loadUrl("http://mma.qq.com/dev-tmp/qqar-map/map.html");
    return bool;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ARWebTestActivity", 4, String.format(Locale.getDefault(), "onAnimationEnd cost: %d ", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) }));
    }
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      this.g = true;
      if (!this.jdField_a_of_type_Boolean) {
        break label78;
      }
      b();
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ARWebTestActivity", 4, String.format(Locale.getDefault(), "onClick cost: %d  mPageLoadFinished: %b", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
      }
      return;
      label78:
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.test.ARWebTestActivity
 * JD-Core Version:    0.7.0.1
 */