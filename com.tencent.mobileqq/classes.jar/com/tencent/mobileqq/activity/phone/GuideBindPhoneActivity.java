package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class GuideBindPhoneActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString = "http://kf.qq.com/touch/faq/120307IVnEni150407eEv2IF.html?platform=14&_wv=0";
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBooleanExtra("req_write", false);; bool = false)
    {
      setContentView(2130969023);
      setTitle("手机通讯录", getString(2131435648));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364768));
      this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      float f = FontSettingManager.a();
      if (f > 17.0F)
      {
        paramBundle = (ImageView)findViewById(2131364765);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        localLayoutParams.topMargin /= (int)(f - 16.0F);
        paramBundle.setLayoutParams(localLayoutParams);
      }
      if (bool)
      {
        setTitle("保存到通讯录", getString(2131435648));
        ((TextView)findViewById(2131364766)).setText(2131435649);
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8006EFB", "0X8006EFB", 0, 0, "", "", "", "");
      return true;
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("hide_more_button", true);
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    startActivity(paramView);
    ReportController.b(this.app, "CliOper", "", "", "0X8006EFC", "0X8006EFC", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity
 * JD-Core Version:    0.7.0.1
 */