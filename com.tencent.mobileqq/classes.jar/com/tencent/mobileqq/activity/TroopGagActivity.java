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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagHandler;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
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
import mqq.app.AppRuntime;

public class TroopGagActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TroopGagActivity.TroopGagMemberAdapter jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopGagActivity.3(this);
  TroopGagObserver jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiTroopGagObserver = new TroopGagActivity.2(this);
  Switch jdField_a_of_type_ComTencentWidgetSwitch;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  List<TroopGagActivity.GagMemInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  LinearLayout b;
  
  private boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.split("\\|");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].equalsIgnoreCase(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramBundle.c(this.jdField_a_of_type_JavaLangString);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131559898, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131365037));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = View.inflate(this, 2131561565, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298527), 0, getResources().getDimensionPixelSize(2131298527), getResources().getDimensionPixelSize(2131298522));
    ((TextView)localObject).setTextAppearance(this, 2131756356);
    ((TextView)localObject).setText(getResources().getString(2131696153));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.b = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561565, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.addView(this.jdField_a_of_type_AndroidViewView);
    localObject = View.inflate(this, 2131559883, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)((View)localObject).findViewById(2131377312));
    TroopGagInfo localTroopGagInfo = ((TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    if ((localTroopGagInfo != null) && (localTroopGagInfo.a != 0L)) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
    } else {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
    this.b.addView((View)localObject);
    localObject = View.inflate(this, 2131561565, null);
    this.b.addView((View)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter = new TroopGagActivity.TroopGagMemberAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838739);
    super.setContentView(paramBundle);
    setTitle(HardCodeUtil.a(2131715169));
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this, 2131694422, 0).b(getTitleBarHeight());
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiTroopGagObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    paramBundle = new StringBuilder();
    paramBundle.append("last_update_time");
    paramBundle.append(this.app.getCurrentAccountUin());
    paramBundle = getSharedPreferences(paramBundle.toString(), 4);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_last_update_time");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    long l = paramBundle.getLong(((StringBuilder)localObject).toString(), 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.b(this.jdField_a_of_type_JavaLangString);
        ((ITroopMemberListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(true, this.jdField_a_of_type_JavaLangString, paramBundle.troopcode, 8);
        bool = true;
        break label673;
      }
    }
    boolean bool = false;
    label673:
    if (!bool) {
      ThreadManager.post(new TroopGagActivity.1(this, (TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)), 8, null, false);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate: isRequestedTroopList=");
      paramBundle.append(bool);
      QLog.d("TroopGagActivity", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    TroopGagActivity.TroopGagMemberAdapter localTroopGagMemberAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter;
    if (localTroopGagMemberAdapter != null) {
      localTroopGagMemberAdapter.c();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiTroopGagObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = (ITroopGagHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_GAG_HANDLER);
    TroopGagMgr localTroopGagMgr = (TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      ((ITroopGagHandler)localObject).a(this.jdField_a_of_type_JavaLangString, 268435455L);
      localObject = this.app;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, localStringBuilder.toString(), localTroopGagMgr.a(this.jdField_a_of_type_JavaLangString), "", "");
    }
    else
    {
      ((ITroopGagHandler)localObject).a(this.jdField_a_of_type_JavaLangString, 0L);
      localObject = this.app;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, localStringBuilder.toString(), localTroopGagMgr.a(this.jdField_a_of_type_JavaLangString), "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity
 * JD-Core Version:    0.7.0.1
 */