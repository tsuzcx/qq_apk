package com.dataline.activities;

import Override;
import achd;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import anzj;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PrinterBindTipActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private String jdField_a_of_type_JavaLangString;
  
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
    super.getWindow().setBackgroundDrawableResource(2131165429);
    super.setContentView(2131559586);
    super.setTitle(anzj.a(2131707300));
    super.setLeftViewName(2131691414);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363478));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("printer_bind_url");
    this.jdField_a_of_type_Long = paramBundle.getIntExtra("din", 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    achd.a();
    achd.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 5, 0, 0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromQrcode", true);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      super.startActivity(localIntent);
    }
    super.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.dataline.activities.PrinterBindTipActivity
 * JD-Core Version:    0.7.0.1
 */