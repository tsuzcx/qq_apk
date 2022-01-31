package com.tencent.mobileqq.activity;

import abvz;
import abwa;
import abwc;
import ajya;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import anvt;
import apdc;
import aptm;
import apwm;
import axqy;
import axua;
import bbdj;
import bbec;
import bbey;
import bbfj;
import bbgu;
import bcqf;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QQSettingCleanActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, apwm, bbec
{
  public static final String a;
  public static final ArrayList<String> a;
  public static final String[] a;
  public long a;
  public abwc a;
  public View a;
  public Button a;
  public LinearLayout a;
  public ProgressBar a;
  public TextView a;
  public bcqf a;
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
    jdField_a_of_type_JavaLangString = ajya.a(2131710770);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  }
  
  public QQSettingCleanActivity()
  {
    this.jdField_a_of_type_Abwc = new abwc(this);
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
    axua.a().post(new QQSettingCleanActivity.ScanSpaceTask(this));
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
    axqy.b(this.app, "dc00898", "", "", "0X8007911", "0X8007911", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
  }
  
  public boolean a(anvt paramanvt)
  {
    if (paramanvt.b == 0)
    {
      long l = paramanvt.e;
      if ((bbfj.d(this)) && (l > 0L))
      {
        paramanvt = new Bundle();
        paramanvt.putString("_filename_from_dlg", jdField_a_of_type_JavaLangString);
        paramanvt.putLong("_filesize_from_dlg", l);
        paramanvt.putString("big_brother_source_key", "biz_src_tmm");
        paramanvt.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_tmm");
        this.jdField_a_of_type_Boolean = true;
        runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 2));
        apdc.a().a("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", paramanvt, this);
      }
      return true;
    }
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 3));
    return true;
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle)
  {
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 4));
  }
  
  public void d(int paramInt, Bundle paramBundle) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561071);
    setTitle(getString(2131699414));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364228));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364227));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372866);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131372861);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131371144);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131362936);
    ((GradientDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#00d1a4"));
    ((GradientDrawable)this.jdField_b_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#fea356"));
    ((GradientDrawable)this.jdField_c_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#529eff"));
    ((GradientDrawable)this.jdField_d_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#e6e6e7"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373005));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar = ((CircleProgressBar)findViewById(2131375612));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372865));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372862));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371143));
    this.e = ((TextView)findViewById(2131362935));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376346));
    this.f = ((TextView)findViewById(2131364229));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131365365));
    axua.a().a(false);
    paramBundle = aptm.a().b();
    String str = aptm.a().a();
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
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      dismissDialog(1);
    }
    apdc.a().a("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean");
    axua.a();
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (axua.a().a())
    {
      axua.a().a(false);
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      axqy.b(this.app, "dc00898", "", "", "0X8007543", "0X8007543", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      paramView = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      paramView.putExtra("set_display_type", 2);
      getActivity().startActivity(paramView);
      return;
      axqy.b(this.app, "dc00898", "", "", "0X8007544", "0X8007544", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      if (bbey.a(this)) {
        break;
      }
      axqy.b(this.app, "dc00898", "", "", "0X8007912", "0X8007912", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      paramView = bbdj.a(this, 230).setTitle(getString(2131719711)).setMessage(getString(2131719723)).setPositiveButton(getString(2131719716), new abwa(this)).setNegativeButton(getString(2131690596), new abvz(this));
    } while ((paramView == null) || (paramView.isShowing()) || (isFinishing()));
    paramView.setCancelable(false);
    paramView.show();
    return;
    axqy.b(this.app, "dc00898", "", "", "0X8007913", "0X8007913", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
    bbey.a(this, "mobileqq", 9502721);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_Bcqf = null;
    this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
    this.jdField_a_of_type_Bcqf.a(getString(2131690811));
    this.jdField_a_of_type_Bcqf.c(true);
    this.jdField_a_of_type_Bcqf.a(false);
    this.jdField_a_of_type_Bcqf.b(true);
    return this.jdField_a_of_type_Bcqf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity
 * JD-Core Version:    0.7.0.1
 */