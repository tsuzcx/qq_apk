package com.tencent.mobileqq.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bhmn
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
    this.jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=436";
    this.jdField_b_of_type_JavaLangString = anzj.a(2131712573);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", bhnj.f(this));
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
        this.jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=442";
        bdll.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
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
      setTitle(2131717821);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363786));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365733);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380135));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379886));
      return;
      setTitle(2131694363);
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131717820);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717819);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694361);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131717820);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717819);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694361);
  }
  
  public boolean a(asjz paramasjz)
  {
    if (paramasjz.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramasjz.e);
      if ((bhnv.d(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
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
    runOnUiThread(new SecurityPickproofActivity.2(this));
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
    super.setContentView(2131562888);
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
    this.jdField_a_of_type_Boolean = bhnj.a(this);
    if ((this.d) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.jdField_b_of_type_Boolean = bhnj.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (aure.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717803);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717819);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131718314);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694357);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131694356);
      }
    }
    if ((bhnj.c(this)) || ((this.d) && (!bhnj.e(this))))
    {
      if (aure.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717803);
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
        if (bhnj.d(this))
        {
          c();
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717819);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131717822);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717818);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694356);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694358);
      return;
    }
    if (this.d)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694360);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694361);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
      if ((!this.jdField_a_of_type_Boolean) || (bhnj.c(this)) || ((this.d) && (!bhnj.e(this))))
      {
        if ((this.d) && (bhnj.d(this)))
        {
          bhnj.a(this, "mobileqq", 11862017);
          bdll.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        }
        else
        {
          ThreadManager.executeOnNetWorkThread(new SecurityPickproofActivity.1(this));
          this.jdField_c_of_type_Boolean = true;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717803);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (this.d)
          {
            if ("https://qqwx.qq.com/s?aid=index&g_f=442".equals(this.jdField_a_of_type_JavaLangString)) {
              bdll.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
            } else if ("https://qqwx.qq.com/s?aid=index&g_f=460".equals(this.jdField_a_of_type_JavaLangString)) {
              bdll.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
            }
          }
          else if (bhnj.c(this)) {
            bdll.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
          } else {
            bdll.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
          }
        }
      }
      else if (this.d)
      {
        bhnj.a(this, "mobileqq", 11862017);
        bdll.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      }
      else
      {
        bhnj.a(this, "mobileqq", 9109505);
        bdll.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
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
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */