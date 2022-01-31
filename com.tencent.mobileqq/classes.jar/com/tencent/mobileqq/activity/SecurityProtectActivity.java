package com.tencent.mobileqq.activity;

import alpo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import apnb;
import aqwa;
import azmj;
import bdcx;
import bddt;
import bdee;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class SecurityProtectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bdcx
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
    this.jdField_b_of_type_JavaLangString = alpo.a(2131714072);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  public boolean a(apnb paramapnb)
  {
    if (paramapnb.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramapnb.e);
      if ((bdee.d(getActivity())) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramapnb = new Bundle();
        paramapnb.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramapnb.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        paramapnb.putString("big_brother_source_key", "biz_src_safe");
        paramapnb.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        aqwa.a().b(this.jdField_a_of_type_JavaLangString, paramapnb);
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
    super.setContentView(2131562599);
    setTitle(2131719652);
    this.rightViewText.setVisibility(8);
    this.leftView.setText(2131719658);
    this.leftView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378084));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367412));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376445));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379173));
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
    this.jdField_a_of_type_Boolean = bddt.a(this);
    this.jdField_b_of_type_Boolean = bddt.b(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849020);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719646);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719640);
      if (!this.jdField_b_of_type_Boolean) {
        break label192;
      }
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      azmj.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849021);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719648);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719641);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849019);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719642);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719647);
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
    case 2131379173: 
      if (!this.jdField_a_of_type_Boolean)
      {
        ThreadManager.executeOnNetWorkThread(new SecurityProtectActivity.1(this));
        this.c = true;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719643);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        ((LinearLayout)findViewById(2131365450)).setVisibility(0);
        azmj.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        bddt.a(this, "mobileqq", 7798785);
        azmj.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
        return;
      }
      bddt.a(this, "mobileqq", 8716289);
      azmj.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */