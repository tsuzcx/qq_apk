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
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public Long a;
  String jdField_a_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=407";
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public SecurityProtectActivity()
  {
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713605);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
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
    super.setContentView(2131562805);
    setTitle(2131718672);
    this.rightViewText.setVisibility(8);
    this.leftView.setText(2131718677);
    this.leftView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378990));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367929));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377309));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131380109));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setFocusable(true);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.c == true)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = JumpQqPimSecureUtil.a(this);
    this.jdField_b_of_type_Boolean = JumpQqPimSecureUtil.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849970);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718667);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718662);
    }
    else if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849971);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718669);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718663);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849969);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718664);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718668);
    }
    String str;
    if (this.jdField_b_of_type_Boolean) {
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_Boolean) {
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
    if (this.c == true) {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369202)
    {
      if (i == 2131380109) {
        if (!this.jdField_a_of_type_Boolean)
        {
          ThreadManager.executeOnNetWorkThread(new SecurityProtectActivity.1(this));
          this.c = true;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718665);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          ((LinearLayout)findViewById(2131365860)).setVisibility(0);
          ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
        }
        else if (!this.jdField_b_of_type_Boolean)
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
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramDownloadInfo.respContentLength);
      if ((NetworkUtil.isNetSupport(getActivity())) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.jdField_b_of_type_JavaLangString);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        paramDownloadInfo.putString("big_brother_source_key", "biz_src_safe");
        paramDownloadInfo.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(this.jdField_a_of_type_JavaLangString, paramDownloadInfo);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */