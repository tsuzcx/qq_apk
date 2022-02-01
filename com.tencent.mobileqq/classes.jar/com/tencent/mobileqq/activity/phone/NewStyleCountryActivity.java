package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NewStyleCountryActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private NewStyleCountryActivity.CountryAdapter jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$CountryAdapter;
  NewStyleCountryActivity.SearchDialog jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$SearchDialog;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<PhoneCodeUtils.CountryCode> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  LinkedHashMap<String, Integer> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  View b;
  private View c;
  
  private View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131562757, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)DisplayUtils.a(BaseApplication.getContext(), 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new NewStyleCountryActivity.ItemViewHolder(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365275));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364607));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (NewStyleCountryActivity.ItemViewHolder)paramView.getTag();
    if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$SearchDialog;
      if ((localObject != null) && (((NewStyleCountryActivity.SearchDialog)localObject).isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$SearchDialog.dismiss();
      }
      this.countryCode = paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode.c;
      localObject = new Intent();
      ((Intent)localObject).putExtra("k_name", paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode.b);
      ((Intent)localObject).putExtra("k_code", paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode.c);
      ((Intent)localObject).putExtra("k_english_name", paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode.d);
      setResult(-1, (Intent)localObject);
      finish();
    }
  }
  
  void a(View paramView, PhoneCodeUtils.CountryCode paramCountryCode)
  {
    paramView = (NewStyleCountryActivity.ItemViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramCountryCode.b);
    boolean bool = Utils.a(paramCountryCode.c, this.countryCode);
    int j = 0;
    int i;
    if ((bool) && (Utils.a(paramCountryCode.b, this.jdField_a_of_type_JavaLangString))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    if (paramView.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != i) {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode = paramCountryCode;
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
    super.doOnCreate(paramBundle);
    setContentView(2131562755);
    getWindow().setBackgroundDrawableResource(2131165793);
    setTitleText(2131716636);
    setBackListener();
    setProgressBarVisible(false);
    this.countryCode = getIntent().getStringExtra("k_code");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("k_name");
    String[] arrayOfString = getResources().getStringArray(2130968653);
    Object localObject = PhoneCodeUtils.a(Utils.a(this, "internationalCode.json"));
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle;
    localObject = PhoneCodeUtils.a(arrayOfString, this.jdField_a_of_type_JavaUtilArrayList);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramBundle;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378864);
    this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365276));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setDivider(null);
    this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131561408, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.c.findViewById(2131363868).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    AccessibilityUtil.b(this.c);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$CountryAdapter = new NewStyleCountryActivity.CountryAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$CountryAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368760));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(arrayOfString, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$SearchDialog = new NewStyleCountryActivity.SearchDialog(this, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$SearchDialog.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      float f = -i;
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation1.setAnimationListener(new NewStyleCountryActivity.1(this));
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setAnimationListener(new NewStyleCountryActivity.2(this, i));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity$SearchDialog.setOnDismissListener(new NewStyleCountryActivity.3(this, i, localTranslateAnimation2));
      this.b.startAnimation(localTranslateAnimation1);
    }
    else
    {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    PinnedDividerListView localPinnedDividerListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
    localPinnedDividerListView.setSelection(localPinnedDividerListView.getHeaderViewsCount() + ((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString)).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity
 * JD-Core Version:    0.7.0.1
 */