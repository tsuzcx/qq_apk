package com.tencent.mobileqq.activity;

import abmc;
import abmd;
import abmf;
import ajjy;
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
import anff;
import aome;
import apbo;
import apeq;
import awqx;
import awtx;
import babr;
import bacj;
import badf;
import badq;
import bafb;
import bbms;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QQSettingCleanActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, apeq, bacj
{
  public static final String a;
  public static final ArrayList<String> a;
  public static final String[] a;
  public long a;
  public abmf a;
  public View a;
  public Button a;
  public LinearLayout a;
  public ProgressBar a;
  public TextView a;
  public bbms a;
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
    jdField_a_of_type_JavaLangString = ajjy.a(2131644971);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  }
  
  public QQSettingCleanActivity()
  {
    this.jdField_a_of_type_Abmf = new abmf(this);
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
    awtx.a().post(new QQSettingCleanActivity.ScanSpaceTask(this));
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
    awqx.b(this.app, "dc00898", "", "", "0X8007911", "0X8007911", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
  }
  
  public boolean a(anff paramanff)
  {
    if (paramanff.b == 0)
    {
      long l = paramanff.e;
      if ((badq.d(this)) && (l > 0L))
      {
        paramanff = new Bundle();
        paramanff.putString("_filename_from_dlg", jdField_a_of_type_JavaLangString);
        paramanff.putLong("_filesize_from_dlg", l);
        paramanff.putString("big_brother_source_key", "biz_src_tmm");
        paramanff.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_tmm");
        this.jdField_a_of_type_Boolean = true;
        runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 2));
        aome.a().a("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", paramanff, this);
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
    setContentView(2131495485);
    setTitle(getString(2131633635));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298671));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298670));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131307152);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131307147);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131305451);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131297397);
    ((GradientDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#00d1a4"));
    ((GradientDrawable)this.jdField_b_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#fea356"));
    ((GradientDrawable)this.jdField_c_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#529eff"));
    ((GradientDrawable)this.jdField_d_of_type_AndroidViewView.getBackground()).setColor(Color.parseColor("#e6e6e7"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307293));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar = ((CircleProgressBar)findViewById(2131309851));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307151));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307148));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305450));
    this.e = ((TextView)findViewById(2131297396));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131310552));
    this.f = ((TextView)findViewById(2131298672));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131299799));
    awtx.a().a(false);
    paramBundle = apbo.a().b();
    String str = apbo.a().a();
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
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      dismissDialog(1);
    }
    aome.a().a("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean");
    awtx.a();
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (awtx.a().a())
    {
      awtx.a().a(false);
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
      awqx.b(this.app, "dc00898", "", "", "0X8007543", "0X8007543", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      paramView = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      paramView.putExtra("set_display_type", 2);
      getActivity().startActivity(paramView);
      return;
      awqx.b(this.app, "dc00898", "", "", "0X8007544", "0X8007544", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      if (badf.a(this)) {
        break;
      }
      awqx.b(this.app, "dc00898", "", "", "0X8007912", "0X8007912", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      paramView = babr.a(this, 230).setTitle(getString(2131653816)).setMessage(getString(2131653828)).setPositiveButton(getString(2131653821), new abmd(this)).setNegativeButton(getString(2131625035), new abmc(this));
    } while ((paramView == null) || (paramView.isShowing()) || (isFinishing()));
    paramView.setCancelable(false);
    paramView.show();
    return;
    awqx.b(this.app, "dc00898", "", "", "0X8007913", "0X8007913", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
    badf.a(this, "mobileqq", 9502721);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_Bbms = null;
    this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
    this.jdField_a_of_type_Bbms.a(getString(2131625250));
    this.jdField_a_of_type_Bbms.c(true);
    this.jdField_a_of_type_Bbms.a(false);
    this.jdField_a_of_type_Bbms.b(true);
    return this.jdField_a_of_type_Bbms;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity
 * JD-Core Version:    0.7.0.1
 */