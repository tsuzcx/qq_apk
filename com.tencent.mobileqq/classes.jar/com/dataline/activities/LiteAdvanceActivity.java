package com.dataline.activities;

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
import bx;
import by;
import bz;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
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
  private View c;
  
  public LiteAdvanceActivity()
  {
    this.jdField_a_of_type_JavaLangString = AppConstants.y;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a()
  {
    setContentView(2130968873);
    Object localObject1 = (ImageView)findViewById(2131362701);
    Object localObject2 = (TextView)findViewById(2131364095);
    TextView localTextView1 = (TextView)findViewById(2131363039);
    TextView localTextView2 = (TextView)findViewById(2131364097);
    TextView localTextView3 = (TextView)findViewById(2131364099);
    if (this.jdField_a_of_type_Int == 0)
    {
      ((ImageView)localObject1).setBackgroundResource(2130841551);
      ((TextView)localObject2).setText(2131427485);
      localTextView1.setText(2131427550);
      localTextView2.setText(2131427576);
      localTextView3.setText(2131427577);
    }
    for (;;)
    {
      setTitle(2131430001);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131364100);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131364102);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c = findViewById(2131364103);
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364101));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(FMSettings.a().b());
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131364096));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bx(this));
      this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131364098));
      this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new by(this));
      if (ChatActivityConstants.N)
      {
        localObject2 = this.leftView.getText().toString();
        localObject1 = localObject2;
        if (!getString(2131432397).equals(localObject2)) {
          localObject1 = "返回" + (String)localObject2 + "界面";
        }
        this.leftView.setContentDescription((CharSequence)localObject1);
      }
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((ImageView)localObject1).setBackgroundResource(2130841549);
        ((TextView)localObject2).setText(2131427486);
        localTextView1.setText(2131427551);
        localTextView2.setText(2131427574);
        localTextView3.setText(2131427575);
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
  
  private void b()
  {
    String str = getString(2131427570);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(str);
    localActionSheet.a(getResources().getString(2131427493), 3);
    localActionSheet.c(2131432998);
    localActionSheet.a(new bz(this, localActionSheet));
    localActionSheet.show();
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
  
  private void c()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      FMToastUtil.a(2131428201);
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
  
  private void d()
  {
    b();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      QQUtils.a(this.app, 2130841551, qfileJumpActivity.class.getName(), getString(2131427485), getTitleBarHeight(), this.jdField_a_of_type_AndroidOsHandler, 500);
      DataLineReportUtil.q(this.app);
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    QQUtils.a(this.app, 2130841549, qfileJumpActivity.class.getName(), getString(2131427486), getTitleBarHeight(), this.jdField_a_of_type_AndroidOsHandler, 500);
    DataLineReportUtil.q(this.app);
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
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0)) {
      if (this.jdField_a_of_type_JavaLangString.equals(AppConstants.z)) {
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = a();
      this.jdField_b_of_type_Boolean = b();
      a();
      return true;
      this.jdField_a_of_type_Int = 0;
      continue;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = AppConstants.y;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131364101: 
    default: 
      return;
    case 2131364100: 
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckviewrecvfile");
      c();
      return;
    case 2131364102: 
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */