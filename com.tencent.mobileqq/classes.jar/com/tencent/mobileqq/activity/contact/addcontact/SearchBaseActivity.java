package com.tencent.mobileqq.activity.contact.addcontact;

import ahhs;
import ahht;
import ahhu;
import ahhv;
import ahhw;
import alud;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.regex.Pattern;

public class SearchBaseActivity
  extends FragmentActivity
{
  public static final Pattern a;
  public static final Pattern b = Pattern.compile("[^0-9]");
  public static final Pattern c = Pattern.compile("^1[0-9]{2}\\d{8}$");
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new ahhw(this);
  public Button a;
  public EditText a;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public SearchBaseFragment a;
  protected String d;
  public final int g = 64;
  public int h;
  protected int i;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected SearchBaseFragment a()
  {
    return new SearchBaseFragment();
  }
  
  public boolean a(boolean paramBoolean, View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager == null) || (paramView == null)) {
      return false;
    }
    if (localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0))
    {
      if (paramBoolean) {
        paramView.clearFocus();
      }
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("from_key"))
    {
      this.h = localIntent.getIntExtra("from_key", 0);
      this.d = localIntent.getStringExtra("last_key_words");
      this.jdField_a_of_type_Int = localIntent.getIntExtra("jump_src_key", 1);
    }
    if (localIntent.hasExtra("fromType")) {
      this.i = localIntent.getIntExtra("fromType", -1);
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363522));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131166911));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahhs(this));
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getText());
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365851));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(getResources().getString(2131689716));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, getResources().getDimension(2131298850));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new ahht(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367817));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ahhu(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368709));
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131713999));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ahhv(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561258);
    paramBundle = super.findViewById(2131376034);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    super.getWindow().setBackgroundDrawable(null);
    b();
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment instanceof ClassificationSearchFragment)) {
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(this.i);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("from_key", this.h);
    paramBundle.putString("last_key_words", this.d);
    paramBundle.putString("start_search_key", getIntent().getStringExtra("start_search_key"));
    paramBundle.putBoolean("auto_add_and_prohibit_auto_search", getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.setArguments(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.jdField_a_of_type_AndroidOsHandler);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131364736, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment);
    paramBundle.commit();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ViewFactory.a().a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    setContentBackgroundResource(2130838593);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */