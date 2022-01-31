package com.dataline.activities;

import ajjy;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import yds;

public class PrinterBindTipActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private String jdField_a_of_type_JavaLangString;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131099823);
    super.setContentView(2131493831);
    super.setTitle(ajjy.a(2131642635));
    super.setLeftViewName(2131626036);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297679));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("printer_bind_url");
    this.jdField_a_of_type_Long = paramBundle.getIntExtra("din", 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    yds.a();
    yds.a(this.app, this.jdField_a_of_type_Long, "printer_hp", 5, 0, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.PrinterBindTipActivity
 * JD-Core Version:    0.7.0.1
 */