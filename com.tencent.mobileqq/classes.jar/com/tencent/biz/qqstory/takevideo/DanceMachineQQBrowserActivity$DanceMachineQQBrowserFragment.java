package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axim;
import axlk;
import bcfx;
import bfob;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import ven;
import vkc;
import vkd;
import vke;

public class DanceMachineQQBrowserActivity$DanceMachineQQBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
  implements Handler.Callback, vkd
{
  bfob jdField_a_of_type_Bfob = new bfob(this);
  private String jdField_a_of_type_JavaLangString;
  private vke jdField_a_of_type_Vke;
  private String b;
  private String c;
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    FadedButton localFadedButton = new FadedButton(getActivity());
    localFadedButton.setBackgroundResource(2130845089);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(axlk.a(40.0F), axlk.a(40.0F));
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = axlk.a(35.0F);
    localFadedButton.setLayoutParams(localLayoutParams);
    localFadedButton.setOnClickListener(new ven(this));
    paramRelativeLayout.addView(localFadedButton);
  }
  
  public void U_()
  {
    this.jdField_a_of_type_Vke.a("share_VIDEO", null, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onShareVideoClick");
    }
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onReceivedError ,   errorCode : " + paramInt + " errorDetail : " + paramString1 + " errorURL : " + paramString2);
    }
    this.jdField_a_of_type_Bfob.removeMessages(12);
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
    this.jdField_a_of_type_Bfob.removeMessages(12);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onBattleClick shareWebUrl : " + paramString1, " rank : " + paramString2 });
    }
    this.jdField_a_of_type_Vke.a("share_PK", paramString1, paramString2, this.c);
  }
  
  @TargetApi(11)
  public int d(Bundle paramBundle)
  {
    int i = super.d(paramBundle);
    if (super.getWebView() != null) {
      this.jdField_a_of_type_Bcfx.a.setVisibility(8);
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
    this.jdField_a_of_type_Vke.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(12, 30000L);
    paramBundle = a().getExtras();
    this.b = paramBundle.getString("KEY_AUDIO_FILE_PATH");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("KEY_VIDEO_FILE_PATH");
    this.c = paramBundle.getString("dance_machine_score", "0");
    this.jdField_a_of_type_Vke = new vke();
    this.jdField_a_of_type_Vke.a(getActivity(), this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    axim.o = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_AUDIO_CHANNEL", axim.o);
    axim.n = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_BITRATE", axim.n);
    axim.p = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_AUDIO_FORMAT", axim.p);
    axim.q = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_SAMPLE_RATE", axim.q);
    vkc.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "fragment onCreate : " + System.currentTimeMillis());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Vke.a();
    vkc.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment
 * JD-Core Version:    0.7.0.1
 */