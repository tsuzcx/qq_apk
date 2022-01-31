package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import trg;
import trh;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.DownloadInfoListener
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
    this.jdField_b_of_type_JavaLangString = "腾讯手机管家";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", JumpQqPimSecureUtil.f(this));
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
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
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
      setTitle(2131437469);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375033));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131371297);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371200));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371210));
      return;
      setTitle(2131437459);
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131437473);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131437470);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437464);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131437473);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131437470);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437464);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramDownloadInfo.e);
      if ((NetworkUtil.d(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        UniformDownloadMgr.a().b(this.jdField_a_of_type_JavaLangString, paramDownloadInfo);
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    }
    runOnUiThread(new trh(this));
    return true;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130971547);
    a();
    b();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_c_of_type_Boolean)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = JumpQqPimSecureUtil.a(this);
    if ((this.d) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_JavaLangString = "http://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.jdField_b_of_type_Boolean = JumpQqPimSecureUtil.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (UniformDownloadMgr.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131436658);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131437470);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131435413);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437462);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131437465);
      }
    }
    if ((JumpQqPimSecureUtil.c(this)) || ((this.d) && (!JumpQqPimSecureUtil.e(this))))
    {
      if (UniformDownloadMgr.a().a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131436658);
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
        if (JumpQqPimSecureUtil.d(this))
        {
          c();
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131437470);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131437474);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437475);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131437465);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437463);
      return;
    }
    if (this.d)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131437466);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437464);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_c_of_type_Boolean == true) {
      finish();
    }
  }
  
  protected boolean onBackEvent()
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
      if ((this.jdField_a_of_type_Boolean) && (!JumpQqPimSecureUtil.c(this)) && ((!this.d) || (JumpQqPimSecureUtil.e(this)))) {
        break label318;
      }
      if ((this.d) && (JumpQqPimSecureUtil.d(this)))
      {
        JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        return;
      }
      ThreadManager.executeOnNetWorkThread(new trg(this));
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131436658);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!this.d) {
        break;
      }
      if ("http://qqwx.qq.com/s?aid=index&g_f=442".equals(this.jdField_a_of_type_JavaLangString))
      {
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
        return;
      }
    } while (!"http://qqwx.qq.com/s?aid=index&g_f=460".equals(this.jdField_a_of_type_JavaLangString));
    ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
    return;
    if (JumpQqPimSecureUtil.c(this))
    {
      ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
    return;
    label318:
    if (this.d)
    {
      JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
      ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      return;
    }
    JumpQqPimSecureUtil.a(this, "mobileqq", 9109505);
    ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */