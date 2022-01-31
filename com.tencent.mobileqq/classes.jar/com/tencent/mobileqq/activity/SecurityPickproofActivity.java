package com.tencent.mobileqq.activity;

import ajya;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anvt;
import apdc;
import axqy;
import bbec;
import bbey;
import bbfj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bbec
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
    this.jdField_b_of_type_JavaLangString = ajya.a(2131713701);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", bbey.f(this));
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
        axqy.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
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
      setTitle(2131719185);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363519));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365365);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378379));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378209));
      return;
      setTitle(2131695181);
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719184);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719181);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695179);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131719184);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719181);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695179);
  }
  
  public boolean a(anvt paramanvt)
  {
    if (paramanvt.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramanvt.e);
      if ((bbfj.d(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramanvt = new Bundle();
        paramanvt.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramanvt.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        paramanvt.putString("big_brother_source_key", "biz_src_safe");
        paramanvt.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        apdc.a().b(this.jdField_a_of_type_JavaLangString, paramanvt);
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
    super.setContentView(2131562394);
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
    this.jdField_a_of_type_Boolean = bbey.a(this);
    if ((this.d) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.jdField_b_of_type_Boolean = bbey.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (apdc.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719162);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719181);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719716);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695175);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131695174);
      }
    }
    if ((bbey.c(this)) || ((this.d) && (!bbey.e(this))))
    {
      if (apdc.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719162);
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
        if (bbey.d(this))
        {
          c();
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719181);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719186);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719180);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695174);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695176);
      return;
    }
    if (this.d)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131695178);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695179);
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
      if ((this.jdField_a_of_type_Boolean) && (!bbey.c(this)) && ((!this.d) || (bbey.e(this)))) {
        break label318;
      }
      if ((this.d) && (bbey.d(this)))
      {
        bbey.a(this, "mobileqq", 11862017);
        axqy.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        return;
      }
      ThreadManager.executeOnNetWorkThread(new SecurityPickproofActivity.1(this));
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719162);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!this.d) {
        break;
      }
      if ("http://qqwx.qq.com/s?aid=index&g_f=442".equals(this.jdField_a_of_type_JavaLangString))
      {
        axqy.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
        return;
      }
    } while (!"http://qqwx.qq.com/s?aid=index&g_f=460".equals(this.jdField_a_of_type_JavaLangString));
    axqy.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
    return;
    if (bbey.c(this))
    {
      axqy.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
    return;
    label318:
    if (this.d)
    {
      bbey.a(this, "mobileqq", 11862017);
      axqy.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      return;
    }
    bbey.a(this, "mobileqq", 9109505);
    axqy.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */