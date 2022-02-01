package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public final class GdtQQReminderDemoFragment
  extends PublicBaseFragment
{
  private static int jdField_a_of_type_Int = -1;
  private static QQReminderSwitchObserver.QQReminderSwitchListener jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizQQReminderSwitchObserver$QQReminderSwitchListener = new GdtQQReminderDemoFragment.7();
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  
  public static void a(Activity paramActivity)
  {
    GdtLog.b("GdtQQReminderDemoFragment", "start");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivity.class, GdtQQReminderDemoFragment.class);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    Long localLong = Long.valueOf(System.currentTimeMillis() / 1000L + paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putString("busi_id", "bf15cdd9f2aa2b578f3af4c3e433f077");
    localBundle.putString("msg_id", paramString1);
    localBundle.putString("mn_reserved", paramString2);
    localBundle.putString("title", "标题三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
    localBundle.putString("content", "内容三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
    localBundle.putString("btn_text", "按钮三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
    localBundle.putInt("banner_type", 1);
    localBundle.putString("banner_url", "https://commontest-75179.gzc.vod.tencent-cloud.com/img/screenshotPic/47984b948f1dd2cb53a8f0c9d82a6761.jpg");
    localBundle.putLong("notice_time", localLong.longValue());
    localBundle.putString("title", DateFormat.format("yyyy-MM-dd HH:mm:ss", localLong.longValue() * 1000L).toString());
    localBundle.putString("content", paramString1);
    localBundle.putString("btn_text", paramString2);
    QQReminderAMSHelper.a(localBundle);
    b(paramString1);
  }
  
  private static void b(String paramString)
  {
    c(String.format("checkHasReminder %s %b", new Object[] { paramString, Boolean.valueOf(QQReminderAMSHelper.a(paramString)) }));
  }
  
  private static void c(String paramString)
  {
    GdtLog.b("GdtQQReminderDemoFragment", paramString);
    AdThreadManager.INSTANCE.post(new GdtQQReminderDemoFragment.8(paramString), 0);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new Button(getActivity());
    paramLayoutInflater.setText("getQQReminderSwitch");
    paramLayoutInflater.setOnClickListener(new GdtQQReminderDemoFragment.1(this));
    paramViewGroup = new Button(getActivity());
    paramViewGroup.setText("changeQQReminderSwitch");
    paramViewGroup.setOnClickListener(new GdtQQReminderDemoFragment.2(this));
    paramBundle = new Button(getActivity());
    paramBundle.setText("init");
    paramBundle.setOnClickListener(new GdtQQReminderDemoFragment.3(this));
    Button localButton1 = new Button(getActivity());
    localButton1.setText("runTasks");
    localButton1.setOnClickListener(new GdtQQReminderDemoFragment.4(this));
    Button localButton2 = new Button(getActivity());
    localButton2.setText("收到 push 消息");
    localButton2.setOnClickListener(new GdtQQReminderDemoFragment.5(this));
    this.jdField_a_of_type_AndroidWidgetEditText = new EditText(getActivity());
    this.jdField_a_of_type_AndroidWidgetEditText.setLines(1);
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(2);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint("addQQReminderMsg 延迟几秒(默认0秒)");
    Button localButton3 = new Button(getActivity());
    localButton3.setText("addQQReminderMsg");
    localButton3.setOnClickListener(new GdtQQReminderDemoFragment.6(this));
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setBackgroundColor(Color.parseColor("#DBDBDB"));
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(paramLayoutInflater);
    localLinearLayout.addView(paramViewGroup);
    localLinearLayout.addView(localButton3);
    localLinearLayout.addView(paramBundle);
    localLinearLayout.addView(localButton1);
    localLinearLayout.addView(localButton2);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetEditText);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localLinearLayout);
    return localLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment
 * JD-Core Version:    0.7.0.1
 */