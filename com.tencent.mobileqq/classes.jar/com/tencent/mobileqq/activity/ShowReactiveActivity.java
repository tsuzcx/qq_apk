package com.tencent.mobileqq.activity;

import adxy;
import adxz;
import aepi;
import alpk;
import alpq;
import alto;
import alud;
import alvw;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import aoop;
import aooq;
import aovb;
import aovc;
import atwh;
import aush;
import ausp;
import auss;
import auth;
import auti;
import azqs;
import bdin;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.Iterator;

public class ShowReactiveActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int;
  private alpq jdField_a_of_type_Alpq = new adxz(this);
  alto jdField_a_of_type_Alto;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  TextView b;
  
  private void a()
  {
    setLeftViewName(2131690382);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131362537));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131362546));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131362547));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370927));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)a(2131363343));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131375538));
    this.b = ((TextView)a(2131375539));
    aoop localaoop = aooq.a();
    boolean bool;
    label159:
    FormMutiItem localFormMutiItem;
    if (!TextUtils.isEmpty(localaoop.e))
    {
      if (alvw.a()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localaoop.e);
      }
    }
    else
    {
      bool = ((alto)this.app.getManager(51)).a(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (bool) {
        break label431;
      }
      bool = true;
      ((FormSwitchItem)localObject).setChecked(bool);
      ((alpk)this.app.a(2)).q();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        azqs.b(null, "dc00898", "", "", "0X800A1FC", "0X800A1FC", 0, 0, "", "", "", "");
      }
      localObject = aush.a(this.app);
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      localObject = null;
      label256:
      auti localauti;
      int i;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localauti = (auti)localIterator.next();
        i = aush.a(this.app, null, localauti.jdField_a_of_type_Long, localauti.jdField_b_of_type_Long, true);
      } while (i == 0);
      localFormMutiItem = (FormMutiItem)localLayoutInflater.inflate(2131561302, null);
      localFormMutiItem.setLeftIcon(a(i));
      localFormMutiItem.setFirstLineText(localauti.jdField_b_of_type_JavaLangString);
      localFormMutiItem.setSecondLineText(localauti.c);
      if (!a(localauti)) {
        break label436;
      }
      FormMutiItem.setNeedFocusBg(true);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setTag(localauti);
      localFormMutiItem.setOnClickListener(this);
      localFormMutiItem.setRightIcon(getResources().getDrawable(2130839203));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormMutiItem);
      if (localObject == null) {
        localFormMutiItem.setBgType(1);
      }
      localObject = localFormMutiItem;
      break label256;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131690630));
      break;
      label431:
      bool = false;
      break label159;
      label436:
      FormMutiItem.setNeedFocusBg(false);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setSecondLineTextViewPaddingRight(aepi.a(12.0F, getResources()));
    }
    if (localObject != null) {
      ((FormMutiItem)localObject).setBgType(3);
    }
    Object localObject = new ausp(this, 2130849630);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon((Drawable)localObject);
    ((ausp)localObject).a("");
    if (!TextUtils.isEmpty(localaoop.f)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(localaoop.f);
    }
    if (!TextUtils.isEmpty(localaoop.g)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(localaoop.g);
    }
    localObject = aovc.c();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new adxy(this, (aovb)localObject));
    if (((aovb)localObject).a)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.b.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.c) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719899));
      }
      atwh.a("1", "1", "1", LpReportInfo_dc03950.getReportUserType(this.app));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.b.setVisibility(8);
    }
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    startActivity(localIntent);
  }
  
  private boolean a(auti paramauti)
  {
    return (paramauti.jdField_a_of_type_Auth != null) && (!TextUtils.isEmpty(paramauti.jdField_a_of_type_Auth.jdField_b_of_type_JavaLangString));
  }
  
  protected Drawable a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
    return localDrawable;
  }
  
  public <T extends View> T a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561301);
    setTitle(2131690629);
    this.jdField_a_of_type_Alto = ((alto)this.app.getManager(51));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("entry", 1);
    a();
    addObserver(this.jdField_a_of_type_Alpq);
    azqs.b(null, "dc00898", "", "", "0X800A1FB", "0X800A1FB", 0, 0, "", "", "", "");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Alpq != null) {
      removeObserver(this.jdField_a_of_type_Alpq);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!bdin.d(getActivity()))
    {
      QQToast.a(getApplicationContext(), 2131719884, 1).a();
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(paramCompoundButton, bool1);
    }
    while (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      return;
    }
    paramCompoundButton = this.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      azqs.b(paramCompoundButton, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(i), "", "", "");
      paramCompoundButton = (alpk)this.app.a(2);
      if (paramBoolean) {
        break label131;
      }
    }
    label131:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      paramCompoundButton.j(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362537)
    {
      azqs.b(null, "dc00898", "", "", "0X800A1FD", "0X800A1FD", 0, 0, "", "", "", "");
      paramView = aooq.a().a();
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("finish_animation_out_to_right", true);
      localIntent.putExtra("is_wrap_content", true);
      localIntent.putExtra("hide_left_button", false);
      startActivity(localIntent);
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof auti)));
        paramView = (auti)paramView.getTag();
      } while (paramView == null);
      if (paramView.jdField_a_of_type_Long == 7L)
      {
        atwh.a(this.app, this, 2087, "1");
        return;
      }
    } while ((paramView.jdField_a_of_type_Auth == null) || (TextUtils.isEmpty(paramView.jdField_a_of_type_Auth.jdField_b_of_type_JavaLangString)));
    a(auss.a(paramView.jdField_a_of_type_Auth.jdField_b_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShowReactiveActivity
 * JD-Core Version:    0.7.0.1
 */