package com.tencent.mobileqq.activity;

import ajyc;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anvo;
import apcy;
import axqw;
import bbdo;
import bbek;
import bbev;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class SecurityProtectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bbdo
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  String jdField_a_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=407";
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public SecurityProtectActivity()
  {
    this.jdField_b_of_type_JavaLangString = ajyc.a(2131713689);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  public boolean a(anvo paramanvo)
  {
    if (paramanvo.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramanvo.e);
      if ((bbev.d(getActivity())) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramanvo = new Bundle();
        paramanvo.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramanvo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        paramanvo.putString("big_brother_source_key", "biz_src_safe");
        paramanvo.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        apcy.a().b(this.jdField_a_of_type_JavaLangString, paramanvo);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562396);
    setTitle(2131719160);
    this.rightViewText.setVisibility(8);
    this.leftView.setText(2131719166);
    this.leftView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377547));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367281));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375944));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378556));
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
    this.jdField_a_of_type_Boolean = bbek.a(this);
    this.jdField_b_of_type_Boolean = bbek.b(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848584);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719154);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719148);
      if (!this.jdField_b_of_type_Boolean) {
        break label192;
      }
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      axqw.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848585);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719156);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719149);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848583);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719150);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719155);
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
    default: 
      return;
    case 2131378556: 
      if (!this.jdField_a_of_type_Boolean)
      {
        ThreadManager.executeOnNetWorkThread(new SecurityProtectActivity.1(this));
        this.c = true;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719151);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        ((LinearLayout)findViewById(2131365366)).setVisibility(0);
        axqw.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        bbek.a(this, "mobileqq", 7798785);
        axqw.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
        return;
      }
      bbek.a(this, "mobileqq", 8716289);
      axqw.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */