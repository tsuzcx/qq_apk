package com.dataline.activities;

import Override;
import admg;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import aoxz;
import audf;
import audr;
import auea;
import bdlq;
import bkzi;
import bkzz;
import cl;
import cm;
import cn;
import co;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import dq;
import mqq.app.MobileQQ;

public class LiteAdvanceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  protected String a;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private boolean jdField_c_of_type_Boolean;
  
  public LiteAdvanceActivity()
  {
    this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a()
  {
    setContentView(2131559071);
    Object localObject1 = (ImageView)findViewById(2131368381);
    Object localObject2 = (TextView)findViewById(2131368819);
    TextView localTextView1 = (TextView)findViewById(2131365157);
    TextView localTextView2 = (TextView)findViewById(2131372225);
    TextView localTextView3 = (TextView)findViewById(2131372226);
    if (this.jdField_a_of_type_Int == 0)
    {
      ((ImageView)localObject1).setBackgroundResource(2130844186);
      ((TextView)localObject2).setText(2131693667);
      localTextView1.setText(2131693619);
      localTextView2.setText(2131693642);
      localTextView3.setText(2131693643);
    }
    for (;;)
    {
      setTitle(2131694951);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131381161);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131362195);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131364674);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376420));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(audf.a().b());
      this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131378011));
      this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new cl(this));
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131378008));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new cm(this));
      this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131372512));
      this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new cn(this));
      if (admg.jdField_a_of_type_Boolean)
      {
        localObject2 = this.leftView.getText().toString();
        localObject1 = localObject2;
        if (!getString(2131690499).equals(localObject2)) {
          localObject1 = anvx.a(2131705679) + (String)localObject2 + anvx.a(2131705680);
        }
        this.leftView.setContentDescription((CharSequence)localObject1);
      }
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((ImageView)localObject1).setBackgroundResource(2130844184);
        ((TextView)localObject2).setText(2131693668);
        localTextView1.setText(2131693620);
        localTextView2.setText(2131693621);
        localTextView3.setText(2131693622);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.jdField_a_of_type_Int == 0) {
      localSharedPreferences.edit().putBoolean("auto_receive_files", paramBoolean).commit();
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    localSharedPreferences.edit().putBoolean("auto_receive_files_ipad", paramBoolean).commit();
  }
  
  private boolean a()
  {
    Object localObject = this.app.getProxyManager().a();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str == null) || (str.length() == 0) || (localObject == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop params error, return false.");
      }
    }
    do
    {
      return false;
      localObject = (RecentUser)((aoxz)localObject).findRecentUser(str, 6000);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop ru == null, return false.");
    return false;
    if (((RecentUser)localObject).showUpTime > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop result is: " + bool);
      }
      return bool;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    aoxz localaoxz = this.app.getProxyManager().a();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str == null) || (str.length() == 0) || (localaoxz == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop params error, return false.");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop top: " + paramBoolean + " uin: " + str + " userType: " + 6000);
    }
    RecentUser localRecentUser2 = (RecentUser)localaoxz.findRecentUser(str, 6000);
    RecentUser localRecentUser1 = localRecentUser2;
    if (localRecentUser2 == null) {
      localRecentUser1 = new RecentUser(str, 6000);
    }
    if (paramBoolean) {}
    for (localRecentUser1.showUpTime = (System.currentTimeMillis() / 1000L);; localRecentUser1.showUpTime = 0L)
    {
      localaoxz.saveRecentUser(localRecentUser1);
      return true;
    }
  }
  
  private void b()
  {
    String str = getString(2131693593);
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    localbkzi.a(str);
    localbkzi.a(getResources().getString(2131693598), 3);
    localbkzi.c(2131690697);
    localbkzi.a(new co(this, localbkzi));
    localbkzi.show();
  }
  
  private void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.jdField_a_of_type_Int == 0) {
      localSharedPreferences.edit().putBoolean("dl_pc_online_notify", paramBoolean).commit();
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    localSharedPreferences.edit().putBoolean("dl_ipad_online_notify", paramBoolean).commit();
  }
  
  private boolean b()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.jdField_a_of_type_Int == 0) {
      bool = localSharedPreferences.getBoolean("auto_receive_files", false);
    }
    while (this.jdField_a_of_type_Int != 1) {
      return bool;
    }
    return localSharedPreferences.getBoolean("auto_receive_files_ipad", false);
  }
  
  private void c()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      audr.a(2131719418);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("localSdCardfile", 0);
      localIntent.putExtra("open_with_qq_images", true);
      startActivityForResult(localIntent, 103);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean c()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    if (this.jdField_a_of_type_Int == 0) {
      bool = localSharedPreferences.getBoolean("dl_pc_online_notify", true);
    }
    while (this.jdField_a_of_type_Int != 1) {
      return bool;
    }
    return localSharedPreferences.getBoolean("dl_ipad_online_notify", true);
  }
  
  private void d()
  {
    b();
  }
  
  private void e()
  {
    anvx.a(2131705678);
    if (auea.a(this, getString(2131693667))) {
      this.app.getApp().getString(2131692037);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        auea.a(this.app, this, "jump_shortcut_dataline", getString(2131693667), 2130844186);
        dq.q(this.app);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    auea.a(this.app, this, "jump_shortcut_dataline", getString(2131693667), 2130844186);
    dq.q(this.app);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0)) {
      if (this.jdField_a_of_type_JavaLangString.equals(AppConstants.DATALINE_IPAD_UIN)) {
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = b();
      this.jdField_b_of_type_Boolean = c();
      this.jdField_c_of_type_Boolean = a();
      a();
      return true;
      this.jdField_a_of_type_Int = 0;
      continue;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
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
      bdlq.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckviewrecvfile");
      c();
      continue;
      e();
      continue;
      d();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */