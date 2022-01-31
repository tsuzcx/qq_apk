package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import java.util.regex.Pattern;
import wny;
import wnz;
import woa;
import wob;
import woc;

public class SearchBaseActivity
  extends FragmentActivity
{
  public static final Pattern a;
  public static final Pattern b = Pattern.compile("[^0-9]");
  public static final Pattern c = Pattern.compile("^1[0-9]{2}\\d{8}$");
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new woc(this);
  public Button a;
  public EditText a;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public SearchBaseFragment a;
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
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368323));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131494226));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new wny(this));
    if (AppSetting.b) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getText());
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368324));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(getResources().getString(2131434376));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, getResources().getDimension(2131558462));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new wnz(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368325));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new woa(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371258));
    if (AppSetting.b) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("返回");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wob(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130970607);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.setArguments(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.jdField_a_of_type_AndroidOsHandler);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131362846, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment);
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
    setContentBackgroundResource(2130838219);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */