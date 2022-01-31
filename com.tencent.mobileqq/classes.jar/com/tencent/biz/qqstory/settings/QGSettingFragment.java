package com.tencent.biz.qqstory.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import wcr;
import wcs;
import wct;

public class QGSettingFragment
  extends IphoneTitleBarFragment
{
  private static boolean a;
  private static boolean b;
  private static boolean c;
  protected FormSwitchItem a;
  protected FormSwitchItem b;
  protected FormSwitchItem c;
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    localEditor.putBoolean("qg_sdcard_so_local", paramBoolean);
    localEditor.apply();
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    localEditor.putBoolean("qg_libs_so_local", paramBoolean);
    localEditor.apply();
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public static void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
    localEditor.putBoolean("qg_js_debug", paramBoolean);
    localEditor.apply();
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static boolean c()
  {
    return false;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131376218));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131369415));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131368993));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(b());
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new wcr(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new wcs(this));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(c());
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new wct(this));
  }
  
  public int getContentLayoutId()
  {
    return 2131561554;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle("QG设置");
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QGSettingFragment
 * JD-Core Version:    0.7.0.1
 */