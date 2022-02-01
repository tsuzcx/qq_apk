package com.tencent.mobileqq.activity;

import Override;
import aeri;
import aerj;
import aerl;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import anvx;
import asid;
import audf;
import auht;
import aulc;
import bdla;
import bdne;
import bhdj;
import bhed;
import bhez;
import bisl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class QQSettingCleanActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aulc, bhed
{
  public static final String a;
  public static final ArrayList<String> a;
  public static final String[] a;
  public long a;
  public aerl a;
  public View a;
  public Button a;
  public LinearLayout a;
  public ProgressBar a;
  public TextView a;
  public bisl a;
  public CircleProgressBar a;
  public boolean a;
  public long b;
  public View b;
  public Button b;
  public TextView b;
  public long c;
  public View c;
  public TextView c;
  public long d;
  public View d;
  public TextView d;
  public long e;
  public TextView e;
  public long f;
  public TextView f;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "sdcard/Tencent/MobileQQ", "sdcard/Tencent/QQ_Images", "sdcard/Tencent/QQfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/QQ_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business" };
    jdField_a_of_type_JavaLangString = anvx.a(2131710218);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  }
  
  public QQSettingCleanActivity()
  {
    this.jdField_a_of_type_Aerl = new aerl(this);
  }
  
  private String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return null;
    }
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L) {
      return String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F) }) + "K";
    }
    if (paramLong < 1073741824L) {
      return String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) }) + "M";
    }
    return String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) }) + "G";
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQSettingMsgHistoryActivity.class);
    localIntent.putExtra("set_display_type", 1);
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar.setPercent(0);
    bdne.a().post(new QQSettingCleanActivity.ScanSpaceTask(this));
  }
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = false;
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 4));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = false;
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 4));
    bdla.b(this.app, "dc00898", "", "", "0X8007911", "0X8007911", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle)
  {
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 4));
  }
  
  public void d(int paramInt, Bundle paramBundle) {}
  
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
    setContentView(2131561488);
    setTitle(getString(2131698818));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364657));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364656));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374170);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374165);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131372316);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131363143);
    ((GradientDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#00d1a4"));
    ((GradientDrawable)this.jdField_b_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#fea356"));
    ((GradientDrawable)this.jdField_c_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#529eff"));
    ((GradientDrawable)this.jdField_d_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#e6e6e7"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374341));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar = ((CircleProgressBar)findViewById(2131377076));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374169));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374166));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372315));
    this.e = ((TextView)findViewById(2131363142));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377910));
    this.f = ((TextView)findViewById(2131364658));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131365863));
    bdne.a().a(false);
    paramBundle = audf.a().b();
    String str = audf.a().a();
    jdField_a_of_type_JavaUtilArrayList.clear();
    if (!TextUtils.isEmpty(paramBundle))
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
      QLog.d("QQCleanActivity", 2, " need scan file path1 = " + paramBundle);
    }
    if (!TextUtils.isEmpty(str))
    {
      jdField_a_of_type_JavaUtilArrayList.add(str);
      QLog.d("QQCleanActivity", 2, " need scan file path2 = " + str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCleanActivity", 2, " need scan file path1 = " + paramBundle + " path2 = " + str);
    }
    a();
    ThreadManager.executeOnNetWorkThread(new QQSettingCleanActivity.GetApkSizeTask(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      dismissDialog(1);
    }
    auht.a().a("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean");
    bdne.a();
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (bdne.a().a())
    {
      bdne.a().a(false);
      a();
    }
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
      bdla.b(this.app, "dc00898", "", "", "0X8007543", "0X8007543", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      Object localObject = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      ((Intent)localObject).putExtra("set_display_type", 2);
      getActivity().startActivity((Intent)localObject);
      continue;
      bdla.b(this.app, "dc00898", "", "", "0X8007544", "0X8007544", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      if (!bhez.a(this))
      {
        bdla.b(this.app, "dc00898", "", "", "0X8007912", "0X8007912", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        localObject = bhdj.a(this, 230).setTitle(getString(2131718941)).setMessage(getString(2131718951)).setPositiveButton(getString(2131718945), new aerj(this)).setNegativeButton(getString(2131690697), new aeri(this));
        if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!isFinishing()))
        {
          ((Dialog)localObject).setCancelable(false);
          ((Dialog)localObject).show();
        }
      }
      else
      {
        bdla.b(this.app, "dc00898", "", "", "0X8007913", "0X8007913", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        bhez.a(this, "mobileqq", 9502721);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_Bisl = null;
    this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
    this.jdField_a_of_type_Bisl.a(getString(2131690828));
    this.jdField_a_of_type_Bisl.c(true);
    this.jdField_a_of_type_Bisl.a(false);
    this.jdField_a_of_type_Bisl.b(true);
    return this.jdField_a_of_type_Bisl;
  }
  
  public boolean onRespDownloadInfo(asid paramasid)
  {
    if (paramasid.b == 0)
    {
      long l = paramasid.e;
      if ((NetworkUtil.isNetSupport(this)) && (l > 0L))
      {
        paramasid = new Bundle();
        paramasid.putString("_filename_from_dlg", jdField_a_of_type_JavaLangString);
        paramasid.putLong("_filesize_from_dlg", l);
        paramasid.putString("big_brother_source_key", "biz_src_tmm");
        paramasid.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_tmm");
        this.jdField_a_of_type_Boolean = true;
        runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 2));
        auht.a().a("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", paramasid, this);
      }
      return true;
    }
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 3));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity
 * JD-Core Version:    0.7.0.1
 */