package com.dataline.activities;

import aaek;
import aciy;
import ajed;
import ajjy;
import akeu;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import apbo;
import apcb;
import apck;
import awrm;
import begr;
import behe;
import ce;
import cf;
import cg;
import ch;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import dj;
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
    this.jdField_a_of_type_JavaLangString = ajed.z;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a()
  {
    setContentView(2131493371);
    Object localObject1 = (ImageView)findViewById(2131302061);
    Object localObject2 = (TextView)findViewById(2131302466);
    TextView localTextView1 = (TextView)findViewById(2131299132);
    TextView localTextView2 = (TextView)findViewById(2131305358);
    TextView localTextView3 = (TextView)findViewById(2131305359);
    if (this.jdField_a_of_type_Int == 0)
    {
      ((ImageView)localObject1).setBackgroundResource(2130843326);
      ((TextView)localObject2).setText(2131628323);
      localTextView1.setText(2131628275);
      localTextView2.setText(2131628298);
      localTextView3.setText(2131628299);
    }
    for (;;)
    {
      setTitle(2131629854);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131313351);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131296577);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131298687);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131309274));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(apbo.a().b());
      this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131310655));
      this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ce(this));
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131310652));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new cf(this));
      this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131305635));
      this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new cg(this));
      if (aaek.S)
      {
        localObject2 = this.leftView.getText().toString();
        localObject1 = localObject2;
        if (!getString(2131624770).equals(localObject2)) {
          localObject1 = ajjy.a(2131640400) + (String)localObject2 + ajjy.a(2131640401);
        }
        this.leftView.setContentDescription((CharSequence)localObject1);
      }
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((ImageView)localObject1).setBackgroundResource(2130843324);
        ((TextView)localObject2).setText(2131628324);
        localTextView1.setText(2131628276);
        localTextView2.setText(2131628277);
        localTextView3.setText(2131628278);
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
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = this.app.a().a();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str == null) || (str.length() == 0) || (localObject == null))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop params error, return false.");
        bool2 = bool1;
      }
    }
    do
    {
      do
      {
        return bool2;
        localObject = ((akeu)localObject).b(str, 6000);
        if (localObject != null) {
          break;
        }
        bool2 = bool1;
      } while (!QLog.isColorLevel());
      QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop ru == null, return false.");
      return false;
      bool1 = bool2;
      if (((RecentUser)localObject).showUpTime > 0L) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop result is: " + bool1);
    return bool1;
  }
  
  private boolean a(boolean paramBoolean)
  {
    akeu localakeu = this.app.a().a();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str == null) || (str.length() == 0) || (localakeu == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop params error, return false.");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop top: " + paramBoolean + " uin: " + str + " userType: " + 6000);
    }
    RecentUser localRecentUser2 = localakeu.b(str, 6000);
    RecentUser localRecentUser1 = localRecentUser2;
    if (localRecentUser2 == null) {
      localRecentUser1 = new RecentUser(str, 6000);
    }
    if (paramBoolean) {}
    for (localRecentUser1.showUpTime = (System.currentTimeMillis() / 1000L);; localRecentUser1.showUpTime = 0L)
    {
      localakeu.a(localRecentUser1);
      return true;
    }
  }
  
  private void b()
  {
    String str = getString(2131628249);
    begr localbegr = (begr)behe.a(this, null);
    localbegr.a(str);
    localbegr.a(getResources().getString(2131628254), 3);
    localbegr.c(2131625035);
    localbegr.a(new ch(this, localbegr));
    localbegr.show();
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
      apcb.a(2131654437);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("localSdCardfile", 0);
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
    ajjy.a(2131640399);
    if (apck.a(this, getString(2131628323))) {
      this.app.getApp().getString(2131626628);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        apck.a(this.app, this, "jump_shortcut_dataline", getString(2131628323), 2130843326);
        dj.q(this.app);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    apck.a(this.app, this, "jump_shortcut_dataline", getString(2131628323), 2130843326);
    dj.q(this.app);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
      if (this.jdField_a_of_type_JavaLangString.equals(ajed.A)) {
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
      this.jdField_a_of_type_JavaLangString = ajed.z;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131313351: 
      awrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckviewrecvfile");
      c();
      return;
    case 2131296577: 
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */