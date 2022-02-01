package com.tencent.mobileqq.activity.contact.addcontact;

import Override;
import ahww;
import ahwx;
import ahxc;
import ahxd;
import ahyg;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
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
import aptd;
import bcdu;
import bcef;
import bcoo;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;
import ued;

public class AddContactsActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  public ahyg a;
  Handler jdField_a_of_type_AndroidOsHandler = new ahxd(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new ahww(this);
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AddContactsView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView;
  private ContactBaseView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
  private TroopView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView;
  private PublicView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView;
  public boolean a;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  private boolean jdField_b_of_type_Boolean;
  private RadioButton jdField_c_of_type_AndroidWidgetRadioButton;
  private boolean jdField_c_of_type_Boolean;
  
  public AddContactsActivity()
  {
    this.jdField_a_of_type_Ahyg = new ahwx(this);
  }
  
  @TargetApi(14)
  private void a()
  {
    ((TextView)findViewById(2131369115)).setText(2131689550);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376679));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369068));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131695584));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369126));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131362155));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131378118));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131378120));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131378119));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    if (bcoo.d()) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(4);
    }
    b();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetRadioButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365016));
      return;
      this.jdField_c_of_type_AndroidWidgetRadioButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130849563));
      int i = this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingRight();
      if (!TextHook.getInstance().isDefault()) {
        i = 0;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setPadding(this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingLeft(), this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingTop(), i, this.jdField_c_of_type_AndroidWidgetRadioButton.getPaddingBottom());
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, AddContactsActivity.class);
    localIntent.putExtra("tab_index_key", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(ContactBaseView paramContactBaseView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != paramContactBaseView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.h();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView = paramContactBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.g();
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
    if (QLog.isColorLevel()) {
      QLog.i("AddContactsActivity", 2, "adaptTabContainerPaddingByModel  model = " + str);
    }
  }
  
  private void c()
  {
    boolean bool = true;
    String str = aptd.a(this.app.getCurrentAccountUin(), "add_contact_page_public_account_switch");
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.Activity", 2, "public account switch config is: " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        if (new JSONObject(str).optInt("showPublicTab") == 1)
        {
          this.jdField_c_of_type_Boolean = bool;
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("addContacts.Activity", 2, "public account switch config is: " + QLog.getStackTraceString(localJSONException));
      }
      bool = false;
    }
  }
  
  private void d()
  {
    switch (getIntent().getIntExtra("tab_index_key", 0))
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      return;
    case 1: 
      this.jdField_b_of_type_AndroidWidgetRadioButton.setChecked(true);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetRadioButton.setChecked(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView = new AddContactsView(this.jdField_a_of_type_Ahyg);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView = new TroopView(this.jdField_a_of_type_Ahyg);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView.setNavStickyListener(new ahxc(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView);
    bcef.b(this.app, "dc00899", "Grp_find_new", "", "grptab", "exp", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView = new PublicView(this.jdField_a_of_type_Ahyg);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView instanceof AddContactsView)) {
      return 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView instanceof TroopView)) {
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putParcelable("android:support:fragments", null);
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131560885);
    getWindow().setBackgroundDrawable(null);
    c();
    a();
    d();
    bcdu.a(getApplicationContext()).reportKVEvent("AddContactsActivity", null);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.d();
    }
    super.doOnDestroy();
    ued.a().a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.g();
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.h();
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    return true;
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
      onBackEvent();
      continue;
      if (1 == a())
      {
        Intent localIntent = new Intent(this, SearchContactsActivity.class);
        localIntent.putExtra("from_key", a());
        localIntent.putExtra("fromType", 13);
        startActivity(localIntent);
        overridePendingTransition(0, 0);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */