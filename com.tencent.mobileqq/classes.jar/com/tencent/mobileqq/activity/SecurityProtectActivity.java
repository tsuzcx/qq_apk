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
import anzj;
import asjz;
import aure;
import bdll;
import bhmn;
import bhnj;
import bhnv;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SecurityProtectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bhmn
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
    this.jdField_b_of_type_JavaLangString = anzj.a(2131712572);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  public boolean a(asjz paramasjz)
  {
    if (paramasjz.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramasjz.e);
      if ((bhnv.d(getActivity())) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramasjz = new Bundle();
        paramasjz.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramasjz.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        paramasjz.putString("big_brother_source_key", "biz_src_safe");
        paramasjz.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        aure.a().b(this.jdField_a_of_type_JavaLangString, paramasjz);
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562889);
    setTitle(2131717810);
    this.rightViewText.setVisibility(8);
    this.leftView.setText(2131717815);
    this.leftView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379148));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367800));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377429));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131380341));
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
    this.jdField_a_of_type_Boolean = bhnj.a(this);
    this.jdField_b_of_type_Boolean = bhnj.b(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849643);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717805);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131717800);
      if (!this.jdField_b_of_type_Boolean) {
        break label192;
      }
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      bdll.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849644);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717807);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131717801);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849642);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717802);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131717806);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717803);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        ((LinearLayout)findViewById(2131365733)).setVisibility(0);
        bdll.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
      }
      else if (!this.jdField_b_of_type_Boolean)
      {
        bhnj.a(this, "mobileqq", 7798785);
        bdll.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
      }
      else
      {
        bhnj.a(this, "mobileqq", 8716289);
        bdll.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */