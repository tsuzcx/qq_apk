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
  protected String a = AppConstants.DATALINE_PC_UIN;
  int b = 0;
  public Handler c = new Handler();
  private Switch d;
  private Switch e;
  private Switch f;
  private boolean g;
  private boolean h;
  private boolean i;
  private View j;
  private View k;
  private View l;
  private TextView m;
  
  private void a()
  {
    setContentView(2131624640);
    Object localObject1 = (ImageView)findViewById(2131435219);
    Object localObject2 = (TextView)findViewById(2131435692);
    TextView localTextView1 = (TextView)findViewById(2131431322);
    TextView localTextView2 = (TextView)findViewById(2131439582);
    TextView localTextView3 = (TextView)findViewById(2131439583);
    int n = this.b;
    if (n == 0)
    {
      ((ImageView)localObject1).setBackgroundResource(2130845599);
      ((TextView)localObject2).setText(2131891354);
      localTextView1.setText(2131891306);
      localTextView2.setText(2131891329);
      localTextView3.setText(2131891330);
    }
    else if (n == 1)
    {
      ((ImageView)localObject1).setBackgroundResource(2130845594);
      ((TextView)localObject2).setText(2131891355);
      localTextView1.setText(2131891307);
      localTextView2.setText(2131891308);
      localTextView3.setText(2131891309);
    }
    setTitle(2131892915);
    this.j = findViewById(2131449841);
    this.j.setOnClickListener(this);
    this.k = findViewById(2131427821);
    this.k.setOnClickListener(this);
    this.l = findViewById(2131430765);
    this.l.setOnClickListener(this);
    this.m = ((TextView)findViewById(2131444516));
    this.m.setText(FMSettings.a().getDefaultRecvPath());
    this.f = ((Switch)findViewById(2131446319));
    this.f.setChecked(this.i);
    this.f.setOnCheckedChangeListener(new LiteAdvanceActivity.1(this));
    this.d = ((Switch)findViewById(2131446314));
    this.d.setChecked(this.g);
    this.d.setOnCheckedChangeListener(new LiteAdvanceActivity.2(this));
    this.e = ((Switch)findViewById(2131439922));
    this.e.setChecked(this.h);
    this.e.setOnCheckedChangeListener(new LiteAdvanceActivity.3(this));
    if (ChatActivityConstants.b)
    {
      localObject2 = this.leftView.getText().toString();
      localObject1 = localObject2;
      if (!getString(2131887440).equals(localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131901576));
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904135));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      this.leftView.setContentDescription((CharSequence)localObject1);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.app.getProxyManager().g();
    String str = this.a;
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
      RecentUser localRecentUser = localRecentUserProxy.c(str, 6000);
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
  
  private void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int n = this.b;
    if (n == 0)
    {
      localSharedPreferences.edit().putBoolean("auto_receive_files", paramBoolean).commit();
      return;
    }
    if (n == 1) {
      localSharedPreferences.edit().putBoolean("auto_receive_files_ipad", paramBoolean).commit();
    }
  }
  
  private boolean b()
  {
    Object localObject = this.app.getProxyManager().g();
    String str = this.a;
    boolean bool = false;
    if ((str != null) && (str.length() != 0) && (localObject != null))
    {
      localObject = ((RecentUserProxy)localObject).c(str, 6000);
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
  
  private void c()
  {
    String str = getString(2131891279);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getResources().getString(2131891285), 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new LiteAdvanceActivity.4(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void c(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int n = this.b;
    if (n == 0)
    {
      localSharedPreferences.edit().putBoolean("dl_pc_online_notify", paramBoolean).commit();
      return;
    }
    if (n == 1) {
      localSharedPreferences.edit().putBoolean("dl_ipad_online_notify", paramBoolean).commit();
    }
  }
  
  private boolean d()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int n = this.b;
    boolean bool = false;
    if (n == 0) {
      return localSharedPreferences.getBoolean("auto_receive_files", false);
    }
    if (n == 1) {
      bool = localSharedPreferences.getBoolean("auto_receive_files_ipad", false);
    }
    return bool;
  }
  
  private boolean e()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int n = this.b;
    boolean bool = true;
    if (n == 0) {
      return localSharedPreferences.getBoolean("dl_pc_online_notify", true);
    }
    if (n == 1) {
      bool = localSharedPreferences.getBoolean("dl_ipad_online_notify", true);
    }
    return bool;
  }
  
  private void f()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      FMToastUtil.a(2131917316);
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
  
  private void g()
  {
    c();
  }
  
  private void h()
  {
    HardCodeUtil.a(2131904134);
    if (FileManagerUtil.d(this, getString(2131891354)))
    {
      this.app.getApp().getString(2131889065);
      return;
    }
    int n = this.b;
    if (n == 0)
    {
      FileManagerUtil.a(this.app, this, "jump_shortcut_dataline", getString(2131891354), 2130845599);
      DataLineReportUtil.q(this.app);
      return;
    }
    if (n == 1)
    {
      FileManagerUtil.a(this.app, this, "jump_shortcut_dataline", getString(2131891354), 2130845599);
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
    this.a = getIntent().getStringExtra("targetUin");
    paramBundle = this.a;
    if ((paramBundle != null) && (paramBundle.length() != 0))
    {
      if (this.a.equals(AppConstants.DATALINE_IPAD_UIN)) {
        this.b = 1;
      } else {
        this.b = 0;
      }
    }
    else
    {
      this.b = 0;
      this.a = AppConstants.DATALINE_PC_UIN;
    }
    this.g = d();
    this.h = e();
    this.i = b();
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n != 2131427821)
    {
      if (n != 2131430765)
      {
        if (n == 2131449841)
        {
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckviewrecvfile");
          f();
        }
      }
      else {
        g();
      }
    }
    else {
      h();
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