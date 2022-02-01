package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LikeSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, PraiseManager.OnPraiseLoadListener
{
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new LikeSettingActivity.3(this);
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new LikeSettingActivity.1(this);
  LikeRankingListManager jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager;
  NearbyRelevantObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new LikeSettingActivity.2(this);
  PraiseManager jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem b;
  FormSwitchItem c;
  FormSwitchItem d;
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  void a()
  {
    boolean bool = ((NearByGeneralManager)this.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    bool = this.app.getLocZanAllowedForPeople();
    a(this.c.a(), bool);
    this.c.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.b.setOnCheckedChangeListener(null);
    Object localObject = this.b;
    if (this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.c()) {}
    for (int i = 0;; i = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(i);
      this.b.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a());
      this.b.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.d.setOnCheckedChangeListener(null);
      this.d.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.c());
      this.d.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      i = PraiseManager.a(this.app);
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(i, true, "from_like_setting");
        if (localObject != null)
        {
          i = AIOUtils.a(34.0F, super.getResources());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), ((PraiseInfo)localObject).b), i, i);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      ThreadManager.post(new LikeSettingActivity.4(this), 5, null, true);
      return;
    }
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if ((paramInt1 == PraiseManager.a(this.app)) && (paramPraiseInfo != null))
    {
      paramInt1 = AIOUtils.a(34.0F, super.getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(new BitmapDrawable(super.getResources(), paramPraiseInfo.b), paramInt1, paramInt1);
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
    setContentView(2131561352);
    setTitle(HardCodeUtil.a(2131706137));
    setLeftViewName(2131690778);
    this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager = ((LikeRankingListManager)this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager = ((PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372429));
    this.b = ((FormSwitchItem)super.findViewById(2131372430));
    this.c = ((FormSwitchItem)super.findViewById(2131370370));
    this.d = ((FormSwitchItem)super.findViewById(2131372431));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131372896));
    a();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    this.app.getZanSwitches();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.g();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.e();
    ((NearbyRelevantHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.b(this);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "praise", ""), 536870912L, localIntent, false, -1);
    ReportController.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity
 * JD-Core Version:    0.7.0.1
 */