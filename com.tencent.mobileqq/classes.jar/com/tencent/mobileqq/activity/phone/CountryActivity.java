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
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.AssetsUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CountryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private CountryActivity.CountryAdapter jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$CountryAdapter;
  CountryActivity.SearchDialog jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$SearchDialog;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  ArrayList<PhoneCodeUtils.CountryCode> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  LinkedHashMap<String, Integer> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  View b;
  private View c;
  
  static void a(View paramView, PhoneCodeUtils.CountryCode paramCountryCode)
  {
    paramView = (CountryActivity.ItemViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramCountryCode.b);
    TextView localTextView = paramView.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(paramCountryCode.c);
    localTextView.setText(localStringBuilder.toString());
    paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode = paramCountryCode;
  }
  
  private static View b(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559546, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)DisplayUtils.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new CountryActivity.ItemViewHolder(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365275));
    paramLayoutInflater.b = ((TextView)paramViewGroup.findViewById(2131365274));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (CountryActivity.ItemViewHolder)paramView.getTag();
    if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$SearchDialog;
      if ((localObject != null) && (((CountryActivity.SearchDialog)localObject).isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$SearchDialog.dismiss();
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("k_name", paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode.b);
      ((Intent)localObject).putExtra("k_code", paramView.jdField_a_of_type_ComTencentMobileqqUtilsPhoneCodeUtils$CountryCode.c);
      setResult(-1, (Intent)localObject);
      finish();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559544);
    String[] arrayOfString = getResources().getStringArray(2130968653);
    Object localObject = PhoneCodeUtils.a(AssetsUtil.a(this, "internationalCode.json"));
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
    setTitle(HardCodeUtil.a(2131702780));
    this.leftView.setText(2131690706);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376636);
    this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365276));
    this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131562770, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.c.setPadding(0, 0, 40, 0);
    this.c.findViewById(2131363868).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    AccessibilityUtil.b(this.c);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$CountryAdapter = new CountryActivity.CountryAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$CountryAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368760));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(arrayOfString, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$SearchDialog = new CountryActivity.SearchDialog(this, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$SearchDialog.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      float f = -i;
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation1.setAnimationListener(new CountryActivity.1(this));
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setAnimationListener(new CountryActivity.2(this, i));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$SearchDialog.setOnDismissListener(new CountryActivity.3(this, i, localTranslateAnimation2));
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
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity
 * JD-Core Version:    0.7.0.1
 */