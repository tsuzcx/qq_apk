package com.tencent.mobileqq.activity;

import Override;
import afsk;
import afsl;
import afsm;
import afsn;
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
import anua;
import anzj;
import aoip;
import aojs;
import bdll;
import bgsl;
import bgss;
import bhnv;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
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
  public afsn a;
  public View a;
  public LinearLayout a;
  anua jdField_a_of_type_Anua = new afsk(this);
  aojs jdField_a_of_type_Aojs = new afsl(this);
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  public Switch a;
  public XListView a;
  public String a;
  public List<afsm> a;
  LinearLayout b;
  
  public TroopGagActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator))
      {
        arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.split("\\|");
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
    return (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TroopManager)this.app.getManager(52);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.c(this.jdField_a_of_type_JavaLangString);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131559904, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131364907));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = View.inflate(this, 2131561658, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298375), 0, getResources().getDimensionPixelSize(2131298375), getResources().getDimensionPixelSize(2131298372));
    ((TextView)localObject).setTextAppearance(this, 2131755987);
    ((TextView)localObject).setText(getResources().getString(2131695497));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.b = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561658, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.addView(this.jdField_a_of_type_AndroidViewView);
    localObject = View.inflate(this, 2131559890, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)((View)localObject).findViewById(2131377432));
    bgss localbgss = ((bgsl)this.app.getManager(48)).a(this.jdField_a_of_type_JavaLangString);
    if ((localbgss != null) && (localbgss.a != 0L))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.b.addView((View)localObject);
      localObject = View.inflate(this, 2131561658, null);
      this.b.addView((View)localObject);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.b);
      this.jdField_a_of_type_Afsn = new afsn(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afsn);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838778);
      super.setContentView(paramBundle);
      setTitle(anzj.a(2131714172));
      if (!bhnv.d(BaseApplication.getContext())) {
        QQToast.a(this, 2131693963, 0).b(getTitleBarHeight());
      }
      addObserver(this.jdField_a_of_type_Anua);
      addObserver(this.jdField_a_of_type_Aojs);
      long l = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.jdField_a_of_type_JavaLangString, 0L);
      if (System.currentTimeMillis() - l <= 86400000L) {
        break label711;
      }
      paramBundle = (TroopManager)this.app.getManager(52);
      if (paramBundle == null) {
        break label711;
      }
      paramBundle = paramBundle.b(this.jdField_a_of_type_JavaLangString);
      ((aoip)this.app.a(20)).a(true, this.jdField_a_of_type_JavaLangString, paramBundle.troopcode, 8);
    }
    label711:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ThreadManager.post(new TroopGagActivity.1(this, (bgsl)this.app.getManager(48)), 8, null, false);
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
    if (this.jdField_a_of_type_Afsn != null) {
      this.jdField_a_of_type_Afsn.c();
    }
    removeObserver(this.jdField_a_of_type_Anua);
    removeObserver(this.jdField_a_of_type_Aojs);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bgsl localbgsl = (bgsl)this.app.getManager(48);
    if (paramBoolean)
    {
      localbgsl.a(this.jdField_a_of_type_JavaLangString, 268435455L);
      bdll.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", localbgsl.a(this.jdField_a_of_type_JavaLangString), "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      localbgsl.a(this.jdField_a_of_type_JavaLangString, 0L);
      bdll.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", localbgsl.a(this.jdField_a_of_type_JavaLangString), "", "");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity
 * JD-Core Version:    0.7.0.1
 */