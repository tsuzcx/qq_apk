package com.tencent.mobileqq.activity;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anvx;
import asid;
import auht;
import bdla;
import bhed;
import bhez;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SecurityProtectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bhed
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  String jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=407";
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public SecurityProtectActivity()
  {
    this.jdField_b_of_type_JavaLangString = anvx.a(2131713151);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562839);
    setTitle(2131718433);
    this.rightViewText.setVisibility(8);
    this.leftView.setText(2131718438);
    this.leftView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379211));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367968));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377465));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131380402));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setFocusable(true);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.c == true)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = bhez.a(this);
    this.jdField_b_of_type_Boolean = bhez.b(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849648);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718428);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718423);
      if (!this.jdField_b_of_type_Boolean) {
        break label192;
      }
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      bdla.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849649);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718430);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131718424);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849647);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718425);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718429);
      break;
      label192:
      if (this.jdField_a_of_type_Boolean) {
        str = "qqpimsecure installed but not running";
      } else {
        str = "qqpimsecure not installed";
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.c == true) {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        ThreadManager.executeOnNetWorkThread(new SecurityProtectActivity.1(this));
        this.c = true;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718426);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        ((LinearLayout)findViewById(2131365863)).setVisibility(0);
        bdla.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
      }
      else if (!this.jdField_b_of_type_Boolean)
      {
        bhez.a(this, "mobileqq", 7798785);
        bdla.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
      }
      else
      {
        bhez.a(this, "mobileqq", 8716289);
        bdla.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
        continue;
        finish();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onRespDownloadInfo(asid paramasid)
  {
    if (paramasid.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramasid.e);
      if ((NetworkUtil.isNetSupport(getActivity())) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramasid = new Bundle();
        paramasid.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramasid.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        paramasid.putString("big_brother_source_key", "biz_src_safe");
        paramasid.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        auht.a().b(this.jdField_a_of_type_JavaLangString, paramasid);
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    }
    new Handler(Looper.getMainLooper()).post(new SecurityProtectActivity.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */