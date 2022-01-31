package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import azds;
import azgq;
import beey;
import bhow;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import wtf;
import wyu;
import wyv;
import wyw;

public class DanceMachineQQBrowserActivity$DanceMachineQQBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
  implements Handler.Callback, wyv
{
  bhow jdField_a_of_type_Bhow = new bhow(this);
  private String jdField_a_of_type_JavaLangString;
  private wyw jdField_a_of_type_Wyw;
  private String b;
  private String c;
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    FadedButton localFadedButton = new FadedButton(getActivity());
    localFadedButton.setBackgroundResource(2130845454);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(azgq.a(40.0F), azgq.a(40.0F));
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = azgq.a(35.0F);
    localFadedButton.setLayoutParams(localLayoutParams);
    localFadedButton.setOnClickListener(new wtf(this));
    paramRelativeLayout.addView(localFadedButton);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onReceivedError ,   errorCode : " + paramInt + " errorDetail : " + paramString1 + " errorURL : " + paramString2);
    }
    this.jdField_a_of_type_Bhow.removeMessages(12);
    getActivity().finish();
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onPageFinished");
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
    this.jdField_a_of_type_Bhow.removeMessages(12);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onBattleClick shareWebUrl : " + paramString1, " rank : " + paramString2 });
    }
    this.jdField_a_of_type_Wyw.a("share_PK", paramString1, paramString2, this.c);
  }
  
  public void ac_()
  {
    this.jdField_a_of_type_Wyw.a("share_VIDEO", null, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onShareVideoClick");
    }
  }
  
  @TargetApi(11)
  public int d(Bundle paramBundle)
  {
    int i = super.d(paramBundle);
    if (super.getWebView() != null) {
      this.jdField_a_of_type_Beey.a.setVisibility(8);
    }
    return i;
  }
  
  public int e(Bundle paramBundle)
  {
    int i = super.e(paramBundle);
    getWebView().setVisibility(8);
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "Page TimeOut");
      }
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Wyw.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(12, 30000L);
    paramBundle = a().getExtras();
    this.b = paramBundle.getString("KEY_AUDIO_FILE_PATH");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("KEY_VIDEO_FILE_PATH");
    this.c = paramBundle.getString("dance_machine_score", "0");
    this.jdField_a_of_type_Wyw = new wyw();
    this.jdField_a_of_type_Wyw.a(getActivity(), this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    azds.o = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_AUDIO_CHANNEL", azds.o);
    azds.n = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_BITRATE", azds.n);
    azds.p = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_AUDIO_FORMAT", azds.p);
    azds.q = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_SAMPLE_RATE", azds.q);
    wyu.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "fragment onCreate : " + System.currentTimeMillis());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Wyw.a();
    wyu.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment
 * JD-Core Version:    0.7.0.1
 */