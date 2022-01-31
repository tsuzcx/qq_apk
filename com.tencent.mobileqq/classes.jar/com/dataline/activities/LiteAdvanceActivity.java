package com.dataline.activities;

import acew;
import aekt;
import aljq;
import alpo;
import amjk;
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
import armo;
import armz;
import arni;
import azmy;
import bhpy;
import bhql;
import cg;
import ch;
import ci;
import cj;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import dl;
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
    this.jdField_a_of_type_JavaLangString = aljq.z;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a()
  {
    setContentView(2131558969);
    Object localObject1 = (ImageView)findViewById(2131367808);
    Object localObject2 = (TextView)findViewById(2131368224);
    TextView localTextView1 = (TextView)findViewById(2131364770);
    TextView localTextView2 = (TextView)findViewById(2131371364);
    TextView localTextView3 = (TextView)findViewById(2131371365);
    if (this.jdField_a_of_type_Int == 0)
    {
      ((ImageView)localObject1).setBackgroundResource(2130843762);
      ((TextView)localObject2).setText(2131694081);
      localTextView1.setText(2131694033);
      localTextView2.setText(2131694056);
      localTextView3.setText(2131694057);
    }
    for (;;)
    {
      setTitle(2131695694);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131379891);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131362122);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131364309);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375490));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(armo.a().b());
      this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131376950));
      this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new cg(this));
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131376947));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ch(this));
      this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131371647));
      this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ci(this));
      if (acew.S)
      {
        localObject2 = this.leftView.getText().toString();
        localObject1 = localObject2;
        if (!getString(2131690382).equals(localObject2)) {
          localObject1 = alpo.a(2131706568) + (String)localObject2 + alpo.a(2131706569);
        }
        this.leftView.setContentDescription((CharSequence)localObject1);
      }
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((ImageView)localObject1).setBackgroundResource(2130843760);
        ((TextView)localObject2).setText(2131694082);
        localTextView1.setText(2131694034);
        localTextView2.setText(2131694035);
        localTextView3.setText(2131694036);
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
        localObject = ((amjk)localObject).b(str, 6000);
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
    amjk localamjk = this.app.a().a();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str == null) || (str.length() == 0) || (localamjk == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop params error, return false.");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop top: " + paramBoolean + " uin: " + str + " userType: " + 6000);
    }
    RecentUser localRecentUser2 = localamjk.b(str, 6000);
    RecentUser localRecentUser1 = localRecentUser2;
    if (localRecentUser2 == null) {
      localRecentUser1 = new RecentUser(str, 6000);
    }
    if (paramBoolean) {}
    for (localRecentUser1.showUpTime = (System.currentTimeMillis() / 1000L);; localRecentUser1.showUpTime = 0L)
    {
      localamjk.a(localRecentUser1);
      return true;
    }
  }
  
  private void b()
  {
    String str = getString(2131694007);
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    localbhpy.a(str);
    localbhpy.a(getResources().getString(2131694012), 3);
    localbhpy.c(2131690648);
    localbhpy.a(new cj(this, localbhpy));
    localbhpy.show();
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
      armz.a(2131720879);
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
    alpo.a(2131706567);
    if (arni.a(this, getString(2131694081))) {
      this.app.getApp().getString(2131692290);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        arni.a(this.app, this, "jump_shortcut_dataline", getString(2131694081), 2130843762);
        dl.q(this.app);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    arni.a(this.app, this, "jump_shortcut_dataline", getString(2131694081), 2130843762);
    dl.q(this.app);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Intent localIntent = aekt.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
      if (this.jdField_a_of_type_JavaLangString.equals(aljq.A)) {
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
      this.jdField_a_of_type_JavaLangString = aljq.z;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379891: 
      azmy.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckviewrecvfile");
      c();
      return;
    case 2131362122: 
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */