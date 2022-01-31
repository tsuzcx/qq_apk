package com.dataline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class PrinterBindTipActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private String jdField_a_of_type_JavaLangString;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131492895);
    super.setContentView(2130969191);
    super.setTitle("如何绑定");
    super.setLeftViewName(2131427781);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365552));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("printer_bind_url");
    this.jdField_a_of_type_Long = paramBundle.getIntExtra("din", 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    SmartDeviceReport.a();
    SmartDeviceReport.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 5, 0, 0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("key_isReadModeEnabled", true);
      paramView.putExtra("fromQrcode", true);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      super.startActivity(paramView);
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.activities.PrinterBindTipActivity
 * JD-Core Version:    0.7.0.1
 */