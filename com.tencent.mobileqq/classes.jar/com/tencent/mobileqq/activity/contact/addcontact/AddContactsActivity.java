package com.tencent.mobileqq.activity.contact.addcontact;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AddContactsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new AddContactsActivity.4(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new AddContactsActivity.1(this);
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AddContactsView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView;
  ContactBaseView.IAddContactContext jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext = new AddContactsActivity.2(this);
  private ContactBaseView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
  private TroopView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView;
  private PublicView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView;
  boolean jdField_a_of_type_Boolean;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  private boolean jdField_b_of_type_Boolean;
  private RadioButton jdField_c_of_type_AndroidWidgetRadioButton;
  private boolean jdField_c_of_type_Boolean = false;
  
  @TargetApi(14)
  private void a()
  {
    ((TextView)findViewById(2131369249)).setText(2131689589);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376809));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131696099));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369260));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131362205));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131378223));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131378225));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131378224));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    if (StudyModeManager.d()) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(4);
    }
    b();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRadioButton.setVisibility(0);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetRadioButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130849978));
      int i = this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingRight();
      if (!TextHook.getInstance().isDefault()) {
        i = 0;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setPadding(this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingLeft(), this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingTop(), i, this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingBottom());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365113));
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, AddContactsActivity.class);
    localIntent.putExtra("tab_index_key", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(ContactBaseView paramContactBaseView)
  {
    ContactBaseView localContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
    if (localContactBaseView != paramContactBaseView)
    {
      if (localContactBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.h();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView = paramContactBaseView;
      paramContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
      if (paramContactBaseView != null)
      {
        paramContactBaseView.g();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.b();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView);
      }
    }
  }
  
  private void b()
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("S968T")) || (str.contains("A0001")) || (str.contains("B9388")) || (str.equals("MI 2")) || (str.contains("LENOVO K900")) || (str.contains("VIVO X3L"))) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setPadding(0, 0, 0, 0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adaptTabContainerPaddingByModel  model = ");
      localStringBuilder.append(str);
      QLog.i("AddContactsActivity", 2, localStringBuilder.toString());
    }
  }
  
  private void c()
  {
    String str = CfgProcess.a(this.app.getCurrentAccountUin(), "add_contact_page_public_account_switch");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("public account switch config is: ");
      localStringBuilder.append(str);
      QLog.i("addContacts.Activity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        int i = new JSONObject(str).optInt("showPublicTab");
        bool = true;
        if (i != 1) {
          break label143;
        }
        this.jdField_c_of_type_Boolean = bool;
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("public account switch config is: ");
          localStringBuilder.append(QLog.getStackTraceString(localJSONException));
          QLog.i("addContacts.Activity", 2, localStringBuilder.toString());
        }
      }
      return;
      label143:
      boolean bool = false;
    }
  }
  
  private void d()
  {
    int i = getIntent().getIntExtra("tab_index_key", 0);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.jdField_c_of_type_AndroidWidgetRadioButton.setChecked(true);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setChecked(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView = new AddContactsView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView = new TroopView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView.setNavStickyListener(new AddContactsActivity.3(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView);
    ReportController.b(this.app, "dc00899", "Grp_find_new", "", "grptab", "exp", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView = new PublicView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView);
  }
  
  int a()
  {
    ContactBaseView localContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
    if ((localContactBaseView instanceof AddContactsView)) {
      return 0;
    }
    if ((localContactBaseView instanceof TroopView)) {
      return 1;
    }
    return 2;
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    ContactBaseView localContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
    if (localContactBaseView != null) {
      localContactBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putParcelable("android:support:fragments", null);
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131560895);
    getWindow().setBackgroundDrawable(null);
    c();
    a();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView;
    if (localObject != null) {
      ((AddContactsView)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView;
    if (localObject != null) {
      ((TroopView)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView;
    if (localObject != null) {
      ((PublicView)localObject).d();
    }
    super.doOnDestroy();
    ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).resetAttribute();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ContactBaseView localContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
    if (localContactBaseView != null) {
      localContactBaseView.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ContactBaseView localContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
    if (localContactBaseView != null) {
      localContactBaseView.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ContactBaseView localContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
    if (localContactBaseView != null) {
      localContactBaseView.g();
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    ContactBaseView localContactBaseView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
    if (localContactBaseView != null) {
      localContactBaseView.h();
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369202)
    {
      if ((i == 2131369260) && (1 == a()))
      {
        Intent localIntent = new Intent(this, SearchContactsActivity.class);
        localIntent.putExtra("from_key", a());
        localIntent.putExtra("fromType", 13);
        startActivity(localIntent);
        overridePendingTransition(0, 0);
      }
    }
    else {
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */