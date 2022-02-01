package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.DownloadInfoListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
  public SecurityPickproofActivity()
  {
    this.jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=436";
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713648);
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
        this.jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=442";
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
      setTitle(2131718967);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363985));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131366030);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380645));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380400));
      return;
      setTitle(2131694915);
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718966);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718965);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694913);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131718966);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718965);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694913);
  }
  
  protected IUniformDownloadMgr a()
  {
    return (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562985);
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
    this.jdField_a_of_type_Boolean = JumpQqPimSecureUtil.a(this);
    if ((this.d) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.jdField_b_of_type_Boolean = JumpQqPimSecureUtil.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (a().isExistedDownloadOfUrl(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718949);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718965);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719472);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694909);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131694908);
      }
    }
    if ((JumpQqPimSecureUtil.c(this)) || ((this.d) && (!JumpQqPimSecureUtil.e(this))))
    {
      if (a().isExistedDownloadOfUrl(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718949);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718965);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131718968);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718964);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694908);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694910);
      return;
    }
    if (this.d)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694912);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694913);
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
      if ((!this.jdField_a_of_type_Boolean) || (JumpQqPimSecureUtil.c(this)) || ((this.d) && (!JumpQqPimSecureUtil.e(this))))
      {
        if ((this.d) && (JumpQqPimSecureUtil.d(this)))
        {
          JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
          ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        }
        else
        {
          ThreadManager.executeOnNetWorkThread(new SecurityPickproofActivity.1(this));
          this.jdField_c_of_type_Boolean = true;
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718949);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (this.d)
          {
            if ("https://qqwx.qq.com/s?aid=index&g_f=442".equals(this.jdField_a_of_type_JavaLangString)) {
              ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
            } else if ("https://qqwx.qq.com/s?aid=index&g_f=460".equals(this.jdField_a_of_type_JavaLangString)) {
              ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
            }
          }
          else if (JumpQqPimSecureUtil.c(this)) {
            ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
          }
        }
      }
      else if (this.d)
      {
        JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      }
      else
      {
        JumpQqPimSecureUtil.a(this, "mobileqq", 9109505);
        ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onRespDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.resultCode == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramDownloadInfo.respContentLength);
      if ((NetworkUtil.d(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        paramDownloadInfo.putString("big_brother_source_key", "biz_src_safe");
        paramDownloadInfo.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        a().startDownload(this.jdField_a_of_type_JavaLangString, paramDownloadInfo);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */