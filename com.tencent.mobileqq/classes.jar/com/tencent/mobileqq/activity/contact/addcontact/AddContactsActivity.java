package com.tencent.mobileqq.activity.contact.addcontact;

import ahft;
import ahfu;
import ahfz;
import ahga;
import ahhc;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
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
import aojx;
import azqh;
import azqs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;
import swe;

public class AddContactsActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  public ahhc a;
  Handler jdField_a_of_type_AndroidOsHandler = new ahga(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new ahft(this);
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AddContactsView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView;
  private ContactBaseView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
  private PublicView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView;
  private TroopView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView;
  public boolean a;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  private boolean jdField_b_of_type_Boolean;
  private RadioButton jdField_c_of_type_AndroidWidgetRadioButton;
  private boolean jdField_c_of_type_Boolean;
  
  public AddContactsActivity()
  {
    this.jdField_a_of_type_Ahhc = new ahfu(this);
  }
  
  @TargetApi(14)
  private void a()
  {
    ((TextView)findViewById(2131368670)).setText(2131689628);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376034));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368681));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131362088));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131377369));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131377371));
    this.jdField_c_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131377370));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("S968T")) || (str.contains("A0001")) || (str.contains("B9388"))) {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setPadding(0, 0, 0, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddContactsActivity", 2, "initView  model = " + str);
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetRadioButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131364716));
      return;
      this.jdField_c_of_type_AndroidWidgetRadioButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130849101));
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
    boolean bool = true;
    String str = aojx.a(this.app.getCurrentAccountUin(), "add_contact_page_public_account_switch");
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
  
  private void c()
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
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView = new AddContactsView(this.jdField_a_of_type_Ahhc);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView = new TroopView(this.jdField_a_of_type_Ahhc);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.setNavStickyListener(new ahfz(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView);
    azqs.b(this.app, "dc00899", "Grp_find_new", "", "grptab", "exp", 0, 0, "", "", "", "");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView = new PublicView(this.jdField_a_of_type_Ahhc);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView);
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
    super.setContentView(2131560780);
    getWindow().setBackgroundDrawable(null);
    b();
    a();
    c();
    azqh.a(getApplicationContext()).reportKVEvent("AddContactsActivity", null);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView.d();
    }
    super.doOnDestroy();
    swe.a().a();
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
    do
    {
      return;
      onBackEvent();
      return;
    } while (1 != a());
    paramView = new Intent(this, SearchContactsActivity.class);
    paramView.putExtra("from_key", a());
    paramView.putExtra("fromType", 13);
    startActivity(paramView);
    overridePendingTransition(0, 0);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */