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
  public String a = "https://qqwx.qq.com/s?aid=index&g_f=436";
  public String b = HardCodeUtil.a(2131911151);
  public Long c = Long.valueOf(0L);
  private Button d;
  private View e;
  private TextView f;
  private TextView g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private String l = "";
  
  private void b()
  {
    if (getIntent().hasExtra("fromSecurityPay")) {
      this.k = getIntent().getBooleanExtra("fromSecurityPay", false);
    }
    if (getIntent().hasExtra("options"))
    {
      String str = getIntent().getStringExtra("options");
      if (str != null) {
        try
        {
          this.k = new JSONObject(str).getBoolean("fromSecurityPay");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    if (this.k)
    {
      this.a = "https://qqwx.qq.com/s?aid=index&g_f=442";
      ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromSecurityPay = ");
      localStringBuilder.append(this.k);
      QLog.i("SecurityPickproofActivity", 2, localStringBuilder.toString());
    }
  }
  
  private void c()
  {
    if (this.k) {
      setTitle(2131916184);
    } else {
      setTitle(2131892630);
    }
    this.d = ((Button)findViewById(2131429866));
    this.d.setOnClickListener(this);
    this.e = findViewById(2131432119);
    this.e.setVisibility(8);
    this.f = ((TextView)findViewById(2131448809));
    this.g = ((TextView)findViewById(2131448510));
  }
  
  private void d()
  {
    if (this.i)
    {
      this.d.setText(2131916183);
      this.g.setText(2131916182);
      this.f.setText(2131892628);
      return;
    }
    this.d.setText(2131916183);
    this.g.setText(2131916182);
    this.f.setText(2131892628);
  }
  
  private JSONObject e()
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131629249);
    b();
    c();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.j)
    {
      finish();
      return;
    }
    this.h = JumpQqPimSecureUtil.a(this);
    if ((this.k) && (!this.h)) {
      this.a = "https://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.i = JumpQqPimSecureUtil.b(this);
    if (!this.h)
    {
      if (a().isExistedDownloadOfUrl(this.a))
      {
        this.j = true;
        this.g.setText(2131916166);
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        return;
      }
      this.d.setVisibility(0);
      this.f.setVisibility(0);
      this.e.setVisibility(8);
      if (this.k)
      {
        this.g.setText(2131916182);
        this.d.setText(2131916732);
      }
      else
      {
        this.d.setText(2131892623);
      }
      this.f.setText(2131892624);
      return;
    }
    if ((!JumpQqPimSecureUtil.c(this)) && ((!this.k) || (JumpQqPimSecureUtil.e(this))))
    {
      if (this.k)
      {
        d();
        return;
      }
      this.d.setText(2131892627);
      this.f.setText(2131892628);
      return;
    }
    if (a().isExistedDownloadOfUrl(this.a))
    {
      this.j = true;
      this.g.setText(2131916166);
      this.d.setVisibility(8);
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.d.setVisibility(0);
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    if (this.k)
    {
      if (JumpQqPimSecureUtil.d(this))
      {
        d();
        return;
      }
      this.g.setText(2131916182);
      this.d.setText(2131916185);
      this.f.setText(2131916181);
      return;
    }
    this.d.setText(2131892623);
    this.f.setText(2131892625);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.j == true) {
      finish();
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.k)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result", e().toString());
      setResult(-1, localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131429866)
    {
      this.l = this.g.getText().toString();
      if ((this.h) && (!JumpQqPimSecureUtil.c(this)) && ((!this.k) || (JumpQqPimSecureUtil.e(this))))
      {
        if (this.k)
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
      else if ((this.k) && (JumpQqPimSecureUtil.d(this)))
      {
        JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      }
      else
      {
        ThreadManager.executeOnNetWorkThread(new SecurityPickproofActivity.1(this));
        this.j = true;
        this.g.setText(2131916166);
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        if (this.k)
        {
          if ("https://qqwx.qq.com/s?aid=index&g_f=442".equals(this.a)) {
            ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
          } else if ("https://qqwx.qq.com/s?aid=index&g_f=460".equals(this.a)) {
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
    EventCollector.getInstance().onViewClicked(paramView);
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
      this.c = Long.valueOf(paramDownloadInfo.respContentLength);
      if ((NetworkUtil.isNetSupport(this)) && (this.c.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.b);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.c.longValue());
        paramDownloadInfo.putString("big_brother_source_key", "biz_src_safe");
        paramDownloadInfo.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        a().startDownload(this.a, paramDownloadInfo);
        return true;
      }
    }
    else
    {
      this.c = Long.valueOf(0L);
    }
    runOnUiThread(new SecurityPickproofActivity.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */