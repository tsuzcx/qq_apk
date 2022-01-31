package com.tencent.mobileqq.activity;

import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import apnb;
import aqwa;
import azmj;
import bdcx;
import bddt;
import bdee;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bdcx
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public SecurityPickproofActivity()
  {
    this.jdField_a_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=436";
    this.jdField_b_of_type_JavaLangString = alpo.a(2131714073);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", bddt.f(this));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a()
  {
    if (getIntent().hasExtra("fromSecurityPay")) {
      this.d = getIntent().getBooleanExtra("fromSecurityPay", false);
    }
    String str;
    if (getIntent().hasExtra("options"))
    {
      str = getIntent().getStringExtra("options");
      if (str == null) {}
    }
    try
    {
      this.d = new JSONObject(str).getBoolean("fromSecurityPay");
      if (this.d)
      {
        this.jdField_a_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=442";
        azmj.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPickproofActivity", 2, "fromSecurityPay = " + this.d);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    if (this.d) {
      setTitle(2131719666);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363562));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365450);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378981));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378776));
      return;
      setTitle(2131695339);
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719665);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719662);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695337);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131719665);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719662);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695337);
  }
  
  public boolean a(apnb paramapnb)
  {
    if (paramapnb.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramapnb.e);
      if ((bdee.d(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
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
    runOnUiThread(new SecurityPickproofActivity.2(this));
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562598);
    a();
    b();
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_c_of_type_Boolean)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = bddt.a(this);
    if ((this.d) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.jdField_b_of_type_Boolean = bddt.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (aqwa.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719643);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.d)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719662);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131720249);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695333);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131695332);
      }
    }
    if ((bddt.c(this)) || ((this.d) && (!bddt.e(this))))
    {
      if (aqwa.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719643);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.d)
      {
        if (bddt.d(this))
        {
          c();
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719662);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719667);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719661);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695332);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695334);
      return;
    }
    if (this.d)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131695336);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695337);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_c_of_type_Boolean == true) {
      finish();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.d)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result", a().toString());
      setResult(-1, localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
      if ((this.jdField_a_of_type_Boolean) && (!bddt.c(this)) && ((!this.d) || (bddt.e(this)))) {
        break label318;
      }
      if ((this.d) && (bddt.d(this)))
      {
        bddt.a(this, "mobileqq", 11862017);
        azmj.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        return;
      }
      ThreadManager.executeOnNetWorkThread(new SecurityPickproofActivity.1(this));
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719643);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!this.d) {
        break;
      }
      if ("http://qqwx.qq.com/s?aid=index&g_f=442".equals(this.jdField_a_of_type_JavaLangString))
      {
        azmj.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
        return;
      }
    } while (!"http://qqwx.qq.com/s?aid=index&g_f=460".equals(this.jdField_a_of_type_JavaLangString));
    azmj.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
    return;
    if (bddt.c(this))
    {
      azmj.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
      return;
    }
    azmj.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
    return;
    label318:
    if (this.d)
    {
      bddt.a(this, "mobileqq", 11862017);
      azmj.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      return;
    }
    bddt.a(this, "mobileqq", 9109505);
    azmj.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */