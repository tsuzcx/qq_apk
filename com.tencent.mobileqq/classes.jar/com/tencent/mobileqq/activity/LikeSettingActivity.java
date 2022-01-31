package com.tencent.mobileqq.activity;

import ablj;
import ablk;
import abll;
import actj;
import ajti;
import ajto;
import ajya;
import ajzq;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import asza;
import atbe;
import atbf;
import auww;
import auwx;
import axqy;
import bbqd;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class LikeSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, auwx
{
  public ajti a;
  ajto jdField_a_of_type_Ajto = new ablj(this);
  public ajzq a;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abll(this);
  atbf jdField_a_of_type_Atbf = new ablk(this);
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
    boolean bool = ((asza)this.app.getManager(161)).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    bool = this.app.o();
    a(this.c.a(), bool);
    this.c.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.b.setOnCheckedChangeListener(null);
    Object localObject = this.b;
    if (this.jdField_a_of_type_Ajzq.c()) {}
    for (int i = 0;; i = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(i);
      this.b.setChecked(this.jdField_a_of_type_Ajzq.a());
      this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.d.setOnCheckedChangeListener(null);
      this.d.setChecked(this.jdField_a_of_type_Ajzq.c());
      this.d.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      i = PraiseManager.a(this.app);
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(i, true, "from_like_setting");
        if (localObject != null)
        {
          i = actj.a(34.0F, super.getResources());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), ((auww)localObject).b), i, i);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      ThreadManager.post(new LikeSettingActivity.4(this), 5, null, true);
      return;
    }
  }
  
  public void a(int paramInt1, auww paramauww, int paramInt2, String paramString)
  {
    if ((paramInt1 == PraiseManager.a(this.app)) && (paramauww != null))
    {
      paramInt1 = actj.a(34.0F, super.getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), paramauww.b), paramInt1, paramInt1);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560860);
    setTitle(ajya.a(2131706111));
    setLeftViewName(2131690572);
    this.jdField_a_of_type_Ajzq = ((ajzq)this.app.getManager(186));
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager = ((PraiseManager)this.app.getManager(209));
    this.jdField_a_of_type_Ajti = ((ajti)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131370963));
    this.b = ((FormSwitchItem)super.findViewById(2131370964));
    this.c = ((FormSwitchItem)super.findViewById(2131369191));
    this.d = ((FormSwitchItem)super.findViewById(2131370965));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131371397));
    a();
    this.app.addObserver(this.jdField_a_of_type_Ajto);
    this.app.addObserver(this.jdField_a_of_type_Atbf);
    this.app.u();
    this.jdField_a_of_type_Ajti.n();
    this.jdField_a_of_type_Ajti.m();
    ((atbe)this.app.a(66)).b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Ajto);
    this.app.removeObserver(this.jdField_a_of_type_Atbf);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.b(this);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this, QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserWithoutAD(this, bbqd.a(this, "praise", ""), 536870912L, paramView, false, -1);
    axqy.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity
 * JD-Core Version:    0.7.0.1
 */