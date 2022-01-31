package com.tencent.mobileqq.activity;

import adyg;
import adyh;
import adyi;
import adyj;
import alkl;
import alpo;
import alzf;
import amab;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import azmj;
import bcjl;
import bcjs;
import bdee;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class TroopGagActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public adyj a;
  alkl jdField_a_of_type_Alkl = new adyg(this);
  amab jdField_a_of_type_Amab = new adyh(this);
  public View a;
  public LinearLayout a;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  public Switch a;
  public XListView a;
  public String a;
  public List<adyi> a;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TroopManager)this.app.getManager(52);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.c(this.jdField_a_of_type_JavaLangString);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131559760, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131364643));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = View.inflate(this, 2131561364, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298280), 0, getResources().getDimensionPixelSize(2131298280), getResources().getDimensionPixelSize(2131298277));
    ((TextView)localObject).setTextAppearance(this, 2131755966);
    ((TextView)localObject).setText(getResources().getString(2131696627));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.b = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561364, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.addView(this.jdField_a_of_type_AndroidViewView);
    localObject = View.inflate(this, 2131559745, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)((View)localObject).findViewById(2131376448));
    bcjs localbcjs = ((bcjl)this.app.getManager(48)).a(this.jdField_a_of_type_JavaLangString);
    if ((localbcjs != null) && (localbcjs.a != 0L))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.b.addView((View)localObject);
      localObject = View.inflate(this, 2131561364, null);
      this.b.addView((View)localObject);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.b);
      this.jdField_a_of_type_Adyj = new adyj(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Adyj);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838591);
      super.setContentView(paramBundle);
      setTitle(alpo.a(2131715770));
      if (!bdee.d(BaseApplication.getContext())) {
        QQToast.a(this, 2131694764, 0).b(getTitleBarHeight());
      }
      addObserver(this.jdField_a_of_type_Alkl);
      addObserver(this.jdField_a_of_type_Amab);
      long l = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.jdField_a_of_type_JavaLangString, 0L);
      if (System.currentTimeMillis() - l <= 86400000L) {
        break label710;
      }
      paramBundle = (TroopManager)this.app.getManager(52);
      if (paramBundle == null) {
        break label710;
      }
      paramBundle = paramBundle.b(this.jdField_a_of_type_JavaLangString);
      ((alzf)this.app.a(20)).a(true, this.jdField_a_of_type_JavaLangString, paramBundle.troopcode, 8);
    }
    label710:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ThreadManager.post(new TroopGagActivity.1(this, (bcjl)this.app.getManager(48)), 8, null, false);
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
    if (this.jdField_a_of_type_Adyj != null) {
      this.jdField_a_of_type_Adyj.c();
    }
    removeObserver(this.jdField_a_of_type_Alkl);
    removeObserver(this.jdField_a_of_type_Amab);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (bcjl)this.app.getManager(48);
    if (paramBoolean)
    {
      paramCompoundButton.a(this.jdField_a_of_type_JavaLangString, 268435455L);
      azmj.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", paramCompoundButton.a(this.jdField_a_of_type_JavaLangString), "", "");
      return;
    }
    paramCompoundButton.a(this.jdField_a_of_type_JavaLangString, 0L);
    azmj.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, this.jdField_a_of_type_JavaLangString + "", paramCompoundButton.a(this.jdField_a_of_type_JavaLangString), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity
 * JD-Core Version:    0.7.0.1
 */