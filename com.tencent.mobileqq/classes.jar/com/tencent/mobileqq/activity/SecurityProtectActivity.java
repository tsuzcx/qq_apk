package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class SecurityProtectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.DownloadInfoListener
{
  String a = "https://qqwx.qq.com/s?aid=index&g_f=407";
  public String b = HardCodeUtil.a(2131911150);
  public Long c = Long.valueOf(0L);
  private ImageView d = null;
  private TextView e = null;
  private TextView f = null;
  private Button g = null;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
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
    super.setContentView(2131629250);
    setTitle(2131916173);
    this.rightViewText.setVisibility(8);
    this.leftView.setText(2131916178);
    this.leftView.setOnClickListener(this);
    this.d = ((ImageView)findViewById(2131447707));
    this.e = ((TextView)findViewById(2131434517));
    this.f = ((TextView)findViewById(2131445697));
    this.g = ((Button)findViewById(2131449023));
    this.g.setOnClickListener(this);
    this.g.setClickable(true);
    this.g.setFocusable(true);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.j == true)
    {
      finish();
      return;
    }
    this.h = JumpQqPimSecureUtil.a(this);
    this.i = JumpQqPimSecureUtil.b(this);
    if (!this.h)
    {
      this.d.setImageResource(2130851726);
      this.e.setText(2131916168);
      this.f.setVisibility(0);
      this.g.setText(2131916163);
    }
    else if (!this.i)
    {
      this.d.setImageResource(2130851727);
      this.e.setText(2131916170);
      this.f.setVisibility(4);
      this.g.setText(2131916164);
    }
    else
    {
      this.d.setImageResource(2130851725);
      this.e.setText(2131916165);
      this.f.setVisibility(4);
      this.g.setText(2131916169);
    }
    String str;
    if (this.i) {
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      break;
      if (this.h) {
        str = "qqpimsecure installed but not running";
      } else {
        str = "qqpimsecure not installed";
      }
    }
    ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.j == true) {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k != 2131436180)
    {
      if (k == 2131449023) {
        if (!this.h)
        {
          ThreadManager.executeOnNetWorkThread(new SecurityProtectActivity.1(this));
          this.j = true;
          this.e.setText(2131916166);
          this.f.setVisibility(4);
          this.g.setVisibility(8);
          ((LinearLayout)findViewById(2131432119)).setVisibility(0);
          ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
        }
        else if (!this.i)
        {
          JumpQqPimSecureUtil.a(this, "mobileqq", 7798785);
          ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
        }
        else
        {
          JumpQqPimSecureUtil.a(this, "mobileqq", 8716289);
          ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
        }
      }
    }
    else {
      finish();
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
      if ((NetworkUtil.isNetSupport(getActivity())) && (this.c.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.b);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.c.longValue());
        paramDownloadInfo.putString("big_brother_source_key", "biz_src_safe");
        paramDownloadInfo.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(this.a, paramDownloadInfo);
        return true;
      }
    }
    else
    {
      this.c = Long.valueOf(0L);
    }
    new Handler(Looper.getMainLooper()).post(new SecurityProtectActivity.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */