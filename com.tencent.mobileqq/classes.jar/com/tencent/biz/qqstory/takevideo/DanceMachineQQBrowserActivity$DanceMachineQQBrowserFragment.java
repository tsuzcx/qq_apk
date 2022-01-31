package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.takevideo.dancemachine.DanceMachinePKManager;
import com.tencent.biz.qqstory.takevideo.dancemachine.DanceMachinePKManager.PKButtonClickListener;
import com.tencent.biz.qqstory.takevideo.dancemachine.PKVideoSharer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.WeakReferenceHandler;
import ocn;

public class DanceMachineQQBrowserActivity$DanceMachineQQBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
  implements Handler.Callback, DanceMachinePKManager.PKButtonClickListener
{
  private PKVideoSharer jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachinePKVideoSharer;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    FadedButton localFadedButton = new FadedButton(getActivity());
    localFadedButton.setBackgroundResource(2130843179);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ScreenUtil.a(40.0F), ScreenUtil.a(40.0F));
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = ScreenUtil.a(35.0F);
    localFadedButton.setLayoutParams(localLayoutParams);
    localFadedButton.setOnClickListener(new ocn(this));
    paramRelativeLayout.addView(localFadedButton);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onReceivedError ,   errorCode : " + paramInt + " errorDetail : " + paramString1 + " errorURL : " + paramString2);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(12);
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
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(12);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onBattleClick shareWebUrl : " + paramString1, " rank : " + paramString2 });
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachinePKVideoSharer.a("share_PK", paramString1, paramString2, this.c);
  }
  
  @TargetApi(11)
  protected int c(Bundle paramBundle)
  {
    int i = super.c(paramBundle);
    if (super.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.setVisibility(8);
    }
    return i;
  }
  
  protected int d(Bundle paramBundle)
  {
    int i = super.d(paramBundle);
    a().setVisibility(8);
    return i;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachinePKVideoSharer.a("share_VIDEO", null, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onShareVideoClick");
    }
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachinePKVideoSharer.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(12, 30000L);
    paramBundle = a().getExtras();
    this.b = paramBundle.getString("KEY_AUDIO_FILE_PATH");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("KEY_VIDEO_FILE_PATH");
    this.c = paramBundle.getString("dance_machine_score", "0");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachinePKVideoSharer = new PKVideoSharer();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachinePKVideoSharer.a(getActivity(), this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    CodecParam.o = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_AUDIO_CHANNEL", CodecParam.o);
    CodecParam.n = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_BITRATE", CodecParam.n);
    CodecParam.p = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_AUDIO_FORMAT", CodecParam.p);
    CodecParam.q = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_SAMPLE_RATE", CodecParam.q);
    DanceMachinePKManager.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "fragment onCreate : " + System.currentTimeMillis());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachinePKVideoSharer.a();
    DanceMachinePKManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment
 * JD-Core Version:    0.7.0.1
 */