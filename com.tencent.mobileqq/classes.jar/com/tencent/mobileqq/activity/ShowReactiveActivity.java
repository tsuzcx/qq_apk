package com.tencent.mobileqq.activity;

import accb;
import accc;
import actj;
import ajti;
import ajto;
import ajxl;
import ajya;
import ajzt;
import amte;
import amtf;
import amzl;
import amzm;
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
import asay;
import asxb;
import asxj;
import asxm;
import asyb;
import asyc;
import axqy;
import bbfj;
import bcql;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.Iterator;

public class ShowReactiveActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int;
  private ajto jdField_a_of_type_Ajto = new accc(this);
  ajxl jdField_a_of_type_Ajxl;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  TextView b;
  
  private void a()
  {
    setLeftViewName(2131690331);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131362515));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131362520));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131362521));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370603));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)a(2131363305));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131375017));
    this.b = ((TextView)a(2131375018));
    amte localamte = amtf.a();
    boolean bool;
    label159:
    FormMutiItem localFormMutiItem;
    if (!TextUtils.isEmpty(localamte.e))
    {
      if (ajzt.a()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localamte.e);
      }
    }
    else
    {
      bool = ((ajxl)this.app.getManager(51)).a(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (bool) {
        break label431;
      }
      bool = true;
      ((FormSwitchItem)localObject).setChecked(bool);
      ((ajti)this.app.a(2)).p();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        axqy.b(null, "dc00898", "", "", "0X800A1FC", "0X800A1FC", 0, 0, "", "", "", "");
      }
      localObject = asxb.a(this.app);
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      localObject = null;
      label256:
      asyc localasyc;
      int i;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localasyc = (asyc)localIterator.next();
        i = asxb.a(this.app, null, localasyc.jdField_a_of_type_Long, localasyc.jdField_b_of_type_Long, true);
      } while (i == 0);
      localFormMutiItem = (FormMutiItem)localLayoutInflater.inflate(2131561097, null);
      localFormMutiItem.setLeftIcon(a(i));
      localFormMutiItem.setFirstLineText(localasyc.jdField_b_of_type_JavaLangString);
      localFormMutiItem.setSecondLineText(localasyc.c);
      if (!a(localasyc)) {
        break label436;
      }
      FormMutiItem.setNeedFocusBg(true);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setTag(localasyc);
      localFormMutiItem.setOnClickListener(this);
      localFormMutiItem.setRightIcon(getResources().getDrawable(2130839118));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormMutiItem);
      if (localObject == null) {
        localFormMutiItem.setBgType(1);
      }
      localObject = localFormMutiItem;
      break label256;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131690579));
      break;
      label431:
      bool = false;
      break label159;
      label436:
      FormMutiItem.setNeedFocusBg(false);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setSecondLineTextViewPaddingRight(actj.a(12.0F, getResources()));
    }
    if (localObject != null) {
      ((FormMutiItem)localObject).setBgType(3);
    }
    Object localObject = new asxj(this, 2130849126);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon((Drawable)localObject);
    ((asxj)localObject).a("");
    if (!TextUtils.isEmpty(localamte.f)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(localamte.f);
    }
    if (!TextUtils.isEmpty(localamte.g)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(localamte.g);
    }
    localObject = amzm.c();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new accb(this, (amzl)localObject));
    if (((amzl)localObject).a)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.b.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719401));
      }
      LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", "1", "1"));
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
  
  private boolean a(asyc paramasyc)
  {
    return (paramasyc.jdField_a_of_type_Asyb != null) && (!TextUtils.isEmpty(paramasyc.jdField_a_of_type_Asyb.jdField_b_of_type_JavaLangString));
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
    super.setContentView(2131561096);
    setTitle(2131690578);
    this.jdField_a_of_type_Ajxl = ((ajxl)this.app.getManager(51));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("entry", 1);
    a();
    addObserver(this.jdField_a_of_type_Ajto);
    axqy.b(null, "dc00898", "", "", "0X800A1FB", "0X800A1FB", 0, 0, "", "", "", "");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ajto != null) {
      removeObserver(this.jdField_a_of_type_Ajto);
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
    if (!bbfj.d(getActivity()))
    {
      bcql.a(getApplicationContext(), 2131719386, 1).a();
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
      axqy.b(paramCompoundButton, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(i), "", "", "");
      paramCompoundButton = (ajti)this.app.a(2);
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
    if (paramView.getId() == 2131362515)
    {
      axqy.b(null, "dc00898", "", "", "0X800A1FD", "0X800A1FD", 0, 0, "", "", "", "");
      paramView = amtf.a().a();
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
        } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof asyc)));
        paramView = (asyc)paramView.getTag();
      } while (paramView == null);
      if (paramView.jdField_a_of_type_Long == 7L)
      {
        asay.a(this.app, this, 2087, "1");
        return;
      }
    } while ((paramView.jdField_a_of_type_Asyb == null) || (TextUtils.isEmpty(paramView.jdField_a_of_type_Asyb.jdField_b_of_type_JavaLangString)));
    a(asxm.a(paramView.jdField_a_of_type_Asyb.jdField_b_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShowReactiveActivity
 * JD-Core Version:    0.7.0.1
 */