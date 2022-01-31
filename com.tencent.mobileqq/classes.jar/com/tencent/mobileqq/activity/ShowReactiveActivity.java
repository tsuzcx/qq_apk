package com.tencent.mobileqq.activity;

import accf;
import accg;
import actn;
import ajtk;
import ajtq;
import ajxn;
import ajyc;
import ajzv;
import amtf;
import amtg;
import amze;
import amzf;
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
import asaw;
import aswz;
import asxh;
import asxk;
import asxz;
import asya;
import axqw;
import bbev;
import bcpw;
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
  private ajtq jdField_a_of_type_Ajtq = new accg(this);
  ajxn jdField_a_of_type_Ajxn;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131362516));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131362521));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131362522));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370604));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)a(2131363306));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131375015));
    this.b = ((TextView)a(2131375016));
    amtf localamtf = amtg.a();
    boolean bool;
    label159:
    FormMutiItem localFormMutiItem;
    if (!TextUtils.isEmpty(localamtf.e))
    {
      if (ajzv.a()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localamtf.e);
      }
    }
    else
    {
      bool = ((ajxn)this.app.getManager(51)).a(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (bool) {
        break label431;
      }
      bool = true;
      ((FormSwitchItem)localObject).setChecked(bool);
      ((ajtk)this.app.a(2)).p();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        axqw.b(null, "dc00898", "", "", "0X800A1FC", "0X800A1FC", 0, 0, "", "", "", "");
      }
      localObject = aswz.a(this.app);
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      localObject = null;
      label256:
      asya localasya;
      int i;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localasya = (asya)localIterator.next();
        i = aswz.a(this.app, null, localasya.jdField_a_of_type_Long, localasya.jdField_b_of_type_Long, true);
      } while (i == 0);
      localFormMutiItem = (FormMutiItem)localLayoutInflater.inflate(2131561098, null);
      localFormMutiItem.setLeftIcon(a(i));
      localFormMutiItem.setFirstLineText(localasya.jdField_b_of_type_JavaLangString);
      localFormMutiItem.setSecondLineText(localasya.c);
      if (!a(localasya)) {
        break label436;
      }
      FormMutiItem.setNeedFocusBg(true);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setTag(localasya);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131690579));
      break;
      label431:
      bool = false;
      break label159;
      label436:
      FormMutiItem.setNeedFocusBg(false);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setSecondLineTextViewPaddingRight(actn.a(12.0F, getResources()));
    }
    if (localObject != null) {
      ((FormMutiItem)localObject).setBgType(3);
    }
    Object localObject = new asxh(this, 2130849117);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon((Drawable)localObject);
    ((asxh)localObject).a("");
    if (!TextUtils.isEmpty(localamtf.f)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(localamtf.f);
    }
    if (!TextUtils.isEmpty(localamtf.g)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(localamtf.g);
    }
    localObject = amzf.c();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new accf(this, (amze)localObject));
    if (((amze)localObject).a)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.b.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719390));
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
  
  private boolean a(asya paramasya)
  {
    return (paramasya.jdField_a_of_type_Asxz != null) && (!TextUtils.isEmpty(paramasya.jdField_a_of_type_Asxz.jdField_b_of_type_JavaLangString));
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
    super.setContentView(2131561097);
    setTitle(2131690578);
    this.jdField_a_of_type_Ajxn = ((ajxn)this.app.getManager(51));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("entry", 1);
    a();
    addObserver(this.jdField_a_of_type_Ajtq);
    axqw.b(null, "dc00898", "", "", "0X800A1FB", "0X800A1FB", 0, 0, "", "", "", "");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ajtq != null) {
      removeObserver(this.jdField_a_of_type_Ajtq);
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
    if (!bbev.d(getActivity()))
    {
      bcpw.a(getApplicationContext(), 2131719375, 1).a();
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
      axqw.b(paramCompoundButton, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(i), "", "", "");
      paramCompoundButton = (ajtk)this.app.a(2);
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
    if (paramView.getId() == 2131362516)
    {
      axqw.b(null, "dc00898", "", "", "0X800A1FD", "0X800A1FD", 0, 0, "", "", "", "");
      paramView = amtg.a().a();
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
        } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof asya)));
        paramView = (asya)paramView.getTag();
      } while (paramView == null);
      if (paramView.jdField_a_of_type_Long == 7L)
      {
        asaw.a(this.app, this, 2087, "1");
        return;
      }
    } while ((paramView.jdField_a_of_type_Asxz == null) || (TextUtils.isEmpty(paramView.jdField_a_of_type_Asxz.jdField_b_of_type_JavaLangString)));
    a(asxk.a(paramView.jdField_a_of_type_Asxz.jdField_b_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShowReactiveActivity
 * JD-Core Version:    0.7.0.1
 */