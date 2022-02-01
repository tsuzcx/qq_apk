package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class TroopGagActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TroopGagActivity.TroopGagMemberAdapter jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopGagActivity.2(this);
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopGagActivity.3(this);
  Switch jdField_a_of_type_ComTencentWidgetSwitch;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  List<TroopGagActivity.GagMemInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  LinearLayout b;
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator))
      {
        arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.split("\\|");
        bool1 = bool2;
        if (arrayOfString != null)
        {
          j = arrayOfString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin));
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
    paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramBundle.c(this.jdField_a_of_type_JavaLangString);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131560026, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131365157));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = View.inflate(this, 2131561722, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298532), 0, getResources().getDimensionPixelSize(2131298532), getResources().getDimensionPixelSize(2131298527));
    ((TextView)localObject).setTextAppearance(this, 2131756006);
    ((TextView)localObject).setText(getResources().getString(2131696136));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.b = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561722, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.addView(this.jdField_a_of_type_AndroidViewView);
    localObject = View.inflate(this, 2131560012, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)((View)localObject).findViewById(2131377886));
    TroopGagMgr.TroopGagInfo localTroopGagInfo = ((TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    if ((localTroopGagInfo != null) && (localTroopGagInfo.a != 0L))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.b.addView((View)localObject);
      localObject = View.inflate(this, 2131561722, null);
      this.b.addView((View)localObject);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter = new TroopGagActivity.TroopGagMemberAdapter(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838979);
      super.setContentView(paramBundle);
      setTitle(HardCodeUtil.a(2131715246));
      if (!NetworkUtil.d(BaseApplication.getContext())) {
        QQToast.a(this, 2131694457, 0).b(getTitleBarHeight());
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      long l = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.jdField_a_of_type_JavaLangString, 0L);
      if (System.currentTimeMillis() - l <= 86400000L) {
        break label716;
      }
      paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramBundle == null) {
        break label716;
      }
      paramBundle = paramBundle.b(this.jdField_a_of_type_JavaLangString);
      ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(true, this.jdField_a_of_type_JavaLangString, paramBundle.troopcode, 8);
    }
    label716:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ThreadManager.post(new TroopGagActivity.1(this, (TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)), 8, null, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGagActivity", 2, "doOnCreate: isRequestedTroopList=" + bool);
      }
      return true;
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter.c();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    TroopGagMgr localTroopGagMgr = (TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    if (paramBoolean)
    {
      localTroopGagMgr.a(this.jdField_a_of_type_JavaLangString, 268435455L);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", localTroopGagMgr.a(this.jdField_a_of_type_JavaLangString), "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      localTroopGagMgr.a(this.jdField_a_of_type_JavaLangString, 0L);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", localTroopGagMgr.a(this.jdField_a_of_type_JavaLangString), "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity
 * JD-Core Version:    0.7.0.1
 */