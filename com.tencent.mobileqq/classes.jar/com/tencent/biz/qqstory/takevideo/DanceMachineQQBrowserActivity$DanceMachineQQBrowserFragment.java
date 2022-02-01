package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bdbt;
import bdep;
import birg;
import blhq;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import yuu;
import zaj;
import zak;
import zal;

public class DanceMachineQQBrowserActivity$DanceMachineQQBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
  implements Handler.Callback, zak
{
  blhq jdField_a_of_type_Blhq = new blhq(this);
  private String jdField_a_of_type_JavaLangString;
  private zal jdField_a_of_type_Zal;
  private String b;
  private String c;
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    FadedButton localFadedButton = new FadedButton(getActivity());
    localFadedButton.setBackgroundResource(2130845939);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bdep.a(40.0F), bdep.a(40.0F));
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = bdep.a(35.0F);
    localFadedButton.setLayoutParams(localLayoutParams);
    localFadedButton.setOnClickListener(new yuu(this));
    paramRelativeLayout.addView(localFadedButton);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zal.a("share_VIDEO", null, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onShareVideoClick");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onBattleClick shareWebUrl : " + paramString1, " rank : " + paramString2 });
    }
    this.jdField_a_of_type_Zal.a("share_PK", paramString1, paramString2, this.c);
  }
  
  @TargetApi(11)
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    if (super.getWebView() != null) {
      this.mUIStyleHandler.a.setVisibility(8);
    }
    return i;
  }
  
  public int doCreateLoopStep_InitWebView(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitWebView(paramBundle);
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
    this.jdField_a_of_type_Zal.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Blhq.sendEmptyMessageDelayed(12, 30000L);
    paramBundle = getIntent().getExtras();
    this.b = paramBundle.getString("KEY_AUDIO_FILE_PATH");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("KEY_VIDEO_FILE_PATH");
    this.c = paramBundle.getString("dance_machine_score", "0");
    this.jdField_a_of_type_Zal = new zal();
    this.jdField_a_of_type_Zal.a(getActivity(), this.b, this.jdField_a_of_type_JavaLangString, this.mApp);
    bdbt.o = this.intent.getIntExtra("KEY_AUDIO_CHANNEL", bdbt.o);
    bdbt.n = this.intent.getIntExtra("KEY_BITRATE", bdbt.n);
    bdbt.p = this.intent.getIntExtra("KEY_AUDIO_FORMAT", bdbt.p);
    bdbt.q = this.intent.getIntExtra("KEY_SAMPLE_RATE", bdbt.q);
    zaj.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "fragment onCreate : " + System.currentTimeMillis());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Zal.a();
    zaj.a().a();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onPageFinished");
    }
    this.webView.setVisibility(0);
    a(this.contentView);
    this.jdField_a_of_type_Blhq.removeMessages(12);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onReceivedError ,   errorCode : " + paramInt + " errorDetail : " + paramString1 + " errorURL : " + paramString2);
    }
    this.jdField_a_of_type_Blhq.removeMessages(12);
    getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment
 * JD-Core Version:    0.7.0.1
 */