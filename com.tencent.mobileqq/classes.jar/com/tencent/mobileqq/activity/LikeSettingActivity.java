package com.tencent.mobileqq.activity;

import Override;
import aegz;
import aeha;
import aehb;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anri;
import anvx;
import anxs;
import axnt;
import axpy;
import axpz;
import azti;
import aztj;
import bdla;
import bhnp;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LikeSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aztj
{
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aehb(this);
  public anri a;
  public anxs a;
  axpz jdField_a_of_type_Axpz = new aeha(this);
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aegz(this);
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
    boolean bool = ((axnt)this.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    bool = this.app.getLocZanAllowedForPeople();
    a(this.c.a(), bool);
    this.c.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.b.setOnCheckedChangeListener(null);
    Object localObject = this.b;
    if (this.jdField_a_of_type_Anxs.c()) {}
    for (int i = 0;; i = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(i);
      this.b.setChecked(this.jdField_a_of_type_Anxs.a());
      this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.d.setOnCheckedChangeListener(null);
      this.d.setChecked(this.jdField_a_of_type_Anxs.c());
      this.d.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      i = PraiseManager.a(this.app);
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(i, true, "from_like_setting");
        if (localObject != null)
        {
          i = AIOUtils.dp2px(34.0F, super.getResources());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), ((azti)localObject).b), i, i);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      ThreadManager.post(new LikeSettingActivity.4(this), 5, null, true);
      return;
    }
  }
  
  public void a(int paramInt1, azti paramazti, int paramInt2, String paramString)
  {
    if ((paramInt1 == PraiseManager.a(this.app)) && (paramazti != null))
    {
      paramInt1 = AIOUtils.dp2px(34.0F, super.getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), paramazti.b), paramInt1, paramInt1);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561247);
    setTitle(anvx.a(2131705594));
    setLeftViewName(2131690676);
    this.jdField_a_of_type_Anxs = ((anxs)this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager = ((PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER));
    this.jdField_a_of_type_Anri = ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372127));
    this.b = ((FormSwitchItem)super.findViewById(2131372128));
    this.c = ((FormSwitchItem)super.findViewById(2131370098));
    this.d = ((FormSwitchItem)super.findViewById(2131372129));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131372583));
    a();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.addObserver(this.jdField_a_of_type_Axpz);
    this.app.getZanSwitches();
    this.jdField_a_of_type_Anri.m();
    this.jdField_a_of_type_Anri.k();
    ((axpy)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_Axpz);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.b(this);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserWithoutAD(this, bhnp.a(this, "praise", ""), 536870912L, localIntent, false, -1);
    bdla.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity
 * JD-Core Version:    0.7.0.1
 */