package com.dataline.activities;

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
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import mqq.app.MobileQQ;

public class LiteAdvanceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
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
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a()
  {
    setContentView(2131559006);
    Object localObject1 = (ImageView)findViewById(2131368343);
    Object localObject2 = (TextView)findViewById(2131368773);
    TextView localTextView1 = (TextView)findViewById(2131365169);
    TextView localTextView2 = (TextView)findViewById(2131372112);
    TextView localTextView3 = (TextView)findViewById(2131372113);
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      ((ImageView)localObject1).setBackgroundResource(2130844282);
      ((TextView)localObject2).setText(2131693779);
      localTextView1.setText(2131693731);
      localTextView2.setText(2131693754);
      localTextView3.setText(2131693755);
    }
    else if (i == 1)
    {
      ((ImageView)localObject1).setBackgroundResource(2130844277);
      ((TextView)localObject2).setText(2131693780);
      localTextView1.setText(2131693732);
      localTextView2.setText(2131693733);
      localTextView3.setText(2131693734);
    }
    setTitle(2131695182);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380860);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131362240);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364676);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376305));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(FMSettings.a().getDefaultRecvPath());
    this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377845));
    this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new LiteAdvanceActivity.1(this));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377841));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new LiteAdvanceActivity.2(this));
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131372401));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new LiteAdvanceActivity.3(this));
    if (ChatActivityConstants.jdField_a_of_type_Boolean)
    {
      localObject2 = this.leftView.getText().toString();
      localObject1 = localObject2;
      if (!getString(2131690529).equals(localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131706273));
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131706274));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      this.leftView.setContentDescription((CharSequence)localObject1);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      localSharedPreferences.edit().putBoolean("auto_receive_files", paramBoolean).commit();
      return;
    }
    if (i == 1) {
      localSharedPreferences.edit().putBoolean("auto_receive_files_ipad", paramBoolean).commit();
    }
  }
  
  private boolean a()
  {
    Object localObject = this.app.getProxyManager().a();
    String str = this.jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if ((str != null) && (str.length() != 0) && (localObject != null))
    {
      localObject = ((RecentUserProxy)localObject).b(str, 6000);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop ru == null, return false.");
        }
        return false;
      }
      if (((RecentUser)localObject).showUpTime > 0L) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isChatAtTop result is: ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "isChatAtTop params error, return false.");
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.app.getProxyManager().a();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.length() != 0) && (localRecentUserProxy != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setChatAtTop top: ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" uin: ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" userType: ");
        ((StringBuilder)localObject).append(6000);
        QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
      }
      RecentUser localRecentUser = localRecentUserProxy.b(str, 6000);
      Object localObject = localRecentUser;
      if (localRecentUser == null) {
        localObject = new RecentUser(str, 6000);
      }
      if (paramBoolean) {
        ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
      } else {
        ((RecentUser)localObject).showUpTime = 0L;
      }
      localRecentUserProxy.b((RecentUser)localObject);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "setChatAtTop params error, return false.");
    }
    return false;
  }
  
  private void b()
  {
    String str = getString(2131693704);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getResources().getString(2131693710), 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new LiteAdvanceActivity.4(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      localSharedPreferences.edit().putBoolean("dl_pc_online_notify", paramBoolean).commit();
      return;
    }
    if (i == 1) {
      localSharedPreferences.edit().putBoolean("dl_ipad_online_notify", paramBoolean).commit();
    }
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int i = this.jdField_a_of_type_Int;
    boolean bool = false;
    if (i == 0) {
      return localSharedPreferences.getBoolean("auto_receive_files", false);
    }
    if (i == 1) {
      bool = localSharedPreferences.getBoolean("auto_receive_files_ipad", false);
    }
    return bool;
  }
  
  private void c()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      FMToastUtil.a(2131719713);
      return;
    }
    try
    {
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByLiteAdvance(this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean c()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int i = this.jdField_a_of_type_Int;
    boolean bool = true;
    if (i == 0) {
      return localSharedPreferences.getBoolean("dl_pc_online_notify", true);
    }
    if (i == 1) {
      bool = localSharedPreferences.getBoolean("dl_ipad_online_notify", true);
    }
    return bool;
  }
  
  private void d()
  {
    b();
  }
  
  private void e()
  {
    HardCodeUtil.a(2131706272);
    if (FileManagerUtil.a(this, getString(2131693779)))
    {
      this.app.getApp().getString(2131692087);
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      FileManagerUtil.a(this.app, this, "jump_shortcut_dataline", getString(2131693779), 2130844282);
      DataLineReportUtil.q(this.app);
      return;
    }
    if (i == 1)
    {
      FileManagerUtil.a(this.app, this, "jump_shortcut_dataline", getString(2131693779), 2130844282);
      DataLineReportUtil.q(this.app);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("targetUin");
    paramBundle = this.jdField_a_of_type_JavaLangString;
    if ((paramBundle != null) && (paramBundle.length() != 0))
    {
      if (this.jdField_a_of_type_JavaLangString.equals(AppConstants.DATALINE_IPAD_UIN)) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
    }
    this.jdField_a_of_type_Boolean = b();
    this.jdField_b_of_type_Boolean = c();
    this.jdField_c_of_type_Boolean = a();
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362240)
    {
      if (i != 2131364676)
      {
        if (i == 2131380860)
        {
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckviewrecvfile");
          c();
        }
      }
      else {
        d();
      }
    }
    else {
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */