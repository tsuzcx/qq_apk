package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.regex.Pattern;

public class SearchBaseActivity
  extends BaseActivity
{
  public static final Pattern a;
  public static final Pattern b = Pattern.compile("[^0-9]");
  public static final Pattern c = Pattern.compile("^1[0-9]{2}\\d{8}$");
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new SearchBaseActivity.5(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  SearchBaseFragment jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment;
  protected String d;
  public final int g = 64;
  protected int h;
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
  
  protected boolean a(boolean paramBoolean, View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (paramView == null) {
        return false;
      }
      if (localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0))
      {
        if (paramBoolean) {
          paramView.clearFocus();
        }
        return true;
      }
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
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363868));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131167064));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SearchBaseActivity.1(this));
    if (AppSetting.d)
    {
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      localButton.setContentDescription(localButton.getText());
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(getResources().getString(2131689667));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, getResources().getDimension(2131299108));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new SearchBaseActivity.2(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368340));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new SearchBaseActivity.3(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369289));
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713529));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SearchBaseActivity.4(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561419);
    paramBundle = super.findViewById(2131376809);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    super.getWindow().setBackgroundDrawable(null);
    b();
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment = a();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment;
    if ((paramBundle instanceof ClassificationSearchFragment)) {
      ((ClassificationSearchFragment)paramBundle).a(this.i);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("from_key", this.h);
    paramBundle.putString("last_key_words", this.d);
    paramBundle.putString("start_search_key", getIntent().getStringExtra("start_search_key"));
    paramBundle.putBoolean("auto_add_and_prohibit_auto_search", getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.setArguments(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.jdField_a_of_type_AndroidOsHandler);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131365132, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment);
    paramBundle.commit();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ViewFactory.a().a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    setContentBackgroundResource(2130838740);
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
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */