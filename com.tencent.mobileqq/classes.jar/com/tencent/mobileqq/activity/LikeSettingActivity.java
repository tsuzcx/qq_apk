package com.tencent.mobileqq.activity;

import adhb;
import adhc;
import adhd;
import aepi;
import alpk;
import alpq;
import alud;
import alvt;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import auug;
import auwm;
import auwn;
import awsr;
import awss;
import azqs;
import bdtg;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class LikeSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, awss
{
  public alpk a;
  alpq jdField_a_of_type_Alpq = new adhb(this);
  public alvt a;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adhd(this);
  auwn jdField_a_of_type_Auwn = new adhc(this);
  PraiseManager jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  public FormSwitchItem b;
  public FormSwitchItem c;
  public FormSwitchItem d;
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  void a()
  {
    boolean bool = ((auug)this.app.getManager(161)).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    bool = this.app.o();
    a(this.c.a(), bool);
    this.c.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.b.setOnCheckedChangeListener(null);
    Object localObject = this.b;
    if (this.jdField_a_of_type_Alvt.c()) {}
    for (int i = 0;; i = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(i);
      this.b.setChecked(this.jdField_a_of_type_Alvt.a());
      this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.d.setOnCheckedChangeListener(null);
      this.d.setChecked(this.jdField_a_of_type_Alvt.c());
      this.d.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      i = PraiseManager.a(this.app);
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(i, true, "from_like_setting");
        if (localObject != null)
        {
          i = aepi.a(34.0F, super.getResources());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), ((awsr)localObject).b), i, i);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      ThreadManager.post(new LikeSettingActivity.4(this), 5, null, true);
      return;
    }
  }
  
  public void a(int paramInt1, awsr paramawsr, int paramInt2, String paramString)
  {
    if ((paramInt1 == PraiseManager.a(this.app)) && (paramawsr != null))
    {
      paramInt1 = aepi.a(34.0F, super.getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), paramawsr.b), paramInt1, paramInt1);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561061);
    setTitle(alud.a(2131706495));
    setLeftViewName(2131690623);
    this.jdField_a_of_type_Alvt = ((alvt)this.app.getManager(186));
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager = ((PraiseManager)this.app.getManager(209));
    this.jdField_a_of_type_Alpk = ((alpk)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371293));
    this.b = ((FormSwitchItem)super.findViewById(2131371294));
    this.c = ((FormSwitchItem)super.findViewById(2131369442));
    this.d = ((FormSwitchItem)super.findViewById(2131371295));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131371733));
    a();
    this.app.addObserver(this.jdField_a_of_type_Alpq);
    this.app.addObserver(this.jdField_a_of_type_Auwn);
    this.app.u();
    this.jdField_a_of_type_Alpk.o();
    this.jdField_a_of_type_Alpk.m();
    ((auwm)this.app.a(66)).b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Alpq);
    this.app.removeObserver(this.jdField_a_of_type_Auwn);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.b(this);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this, QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserWithoutAD(this, bdtg.a(this, "praise", ""), 536870912L, paramView, false, -1);
    azqs.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity
 * JD-Core Version:    0.7.0.1
 */