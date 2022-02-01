package com.tencent.mobileqq.activity;

import Override;
import afcc;
import afcd;
import afce;
import afcf;
import afcg;
import afcj;
import afck;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import anvi;
import anvx;
import aoep;
import aofu;
import bdla;
import bdlf;
import bhdj;
import biso;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

public class TroopDisbandActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  public long a;
  public afck a;
  protected View a;
  protected Button a;
  protected GridView a;
  protected ImageView a;
  protected TextView a;
  private anvi jdField_a_of_type_Anvi = new afcj(this);
  aofu jdField_a_of_type_Aofu = new afcg(this);
  public biso a;
  public TroopInfo a;
  public String a;
  public ArrayList<String> a;
  public int b;
  public long b;
  protected View b;
  protected Button b;
  protected TextView b;
  public String b;
  protected int c;
  protected TextView c;
  public String c;
  protected int d;
  public String d;
  protected String e = "";
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379553));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379439));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379441);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379440));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131379437);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131379438));
    this.jdField_a_of_type_AndroidWidgetGridView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379442));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379617));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131379436));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_Afck = new afck(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Afck);
    this.jdField_c_of_type_Int = (getResources().getDimensionPixelSize(2131297263) * 2);
    this.jdField_c_of_type_Int += this.jdField_b_of_type_AndroidViewView.getPaddingLeft() + this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    this.jdField_c_of_type_Int += getResources().getDimensionPixelSize(2131299114) * 2;
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131299112);
    b();
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, true);
      return;
    }
  }
  
  private void d()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755829);
    localReportDialog.setContentView(2131561082);
    ((TextView)localReportDialog.findViewById(2131365682)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    String str = anvx.a(2131714650);
    localTextView1.setText(getString(2131691044, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694399);
    localTextView3.setText(2131690697);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new afcc(this, localReportDialog));
    localTextView3.setOnClickListener(new afcd(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void e()
  {
    String str1 = getString(2131691717);
    String str2 = getString(2131691043);
    QQCustomDialog localQQCustomDialog = bhdj.a(this, 230);
    localQQCustomDialog.setTitle(str1);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setPositiveButton(getString(2131691042), new afce(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131691209));
    localQQCustomDialog.setNegativeButton(getString(2131690697), new afcf(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131691208));
    localQQCustomDialog.show();
    bdla.b(this.app, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    Bundle localBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_c_of_type_JavaLangString = localBundle.getString("troop_code");
    this.jdField_b_of_type_JavaLangString = localBundle.getString("uinname");
    this.jdField_a_of_type_Long = localBundle.getLong("TROOP_INFO_FLAG_EXT");
    this.jdField_a_of_type_Int = localBundle.getInt("troop_auth_submit_time");
    this.e = localBundle.getString("from");
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      if (l <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.disband", 2, "troopuin = " + l + " is illegal");
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.disband", 2, localException.toString());
        }
        finish();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.disband", 2, "onCreate intent params mTroopUin= " + this.jdField_a_of_type_JavaLangString + ", mTroopName=" + this.jdField_b_of_type_JavaLangString + ", mTroopCode= " + this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "initTroopTips groupInfo mTroopUin =" + this.jdField_a_of_type_JavaLangString + ", wMemberNum=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum + ", troopCreateTime = " + this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719525), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum) }));
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum <= 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131719532);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719527);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setClickable(false);
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
        this.jdField_a_of_type_Afck.a();
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (AppSetting.c) {
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131719531);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719526);
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_Afck.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getSomeMemberUins());
        ThreadManager.post(new TroopDisbandActivity.1(this), 5, null, true);
        return;
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
  
  protected void b()
  {
    int i = 125;
    int k = getResources().getDisplayMetrics().widthPixels;
    int j = (k - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int * 5) / 6;
    if (j > 125) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i);
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + 4);
      }
      this.jdField_a_of_type_Afck.a(i);
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|width = " + k + ", columnWidth = " + i);
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|list.width = " + this.jdField_a_of_type_AndroidWidgetGridView.getWidth() + ", list.height = " + this.jdField_a_of_type_AndroidWidgetGridView.getHeight());
      }
      return;
      i = j;
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
    setContentViewB(2131561577);
    setTitle(2131716593);
    a();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = this.app.getCurrentAccountUin();
    addObserver(this.jdField_a_of_type_Aofu);
    addObserver(this.jdField_a_of_type_Anvi);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Aofu);
    removeObserver(this.jdField_a_of_type_Anvi);
    if (this.jdField_a_of_type_Biso != null)
    {
      this.jdField_a_of_type_Biso.b();
      this.jdField_a_of_type_Biso = null;
    }
    super.doOnDestroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if ((paramInt1 == 0) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "onActivityResult|REQUEST_FOR_TROOP_TRANSFER|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if (!bool) {
        break label127;
      }
      localIntent = new Intent();
      localIntent.putExtra("fin_tip_msg", str);
      localIntent.putExtra("uin", paramIntent);
      setResult(paramInt2, localIntent);
      finish();
    }
    label127:
    while (TextUtils.isEmpty(str))
    {
      Intent localIntent;
      return;
    }
    if (this.jdField_a_of_type_Biso == null) {
      this.jdField_a_of_type_Biso = new biso(this);
    }
    this.jdField_a_of_type_Biso.a(1, str, 1500);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131379437: 
    case 2131379441: 
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {}
      for (String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;; localObject = this.jdField_a_of_type_JavaLangString)
      {
        for (;;)
        {
          startActivity(TroopMemberListActivity.a(this, str, 4));
          try
          {
            bdla.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, str, "1", "0", "");
          }
          catch (Exception localException1) {}
        }
        break;
      }
    case 2131379617: 
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum > 1)) {
        break;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (this.jdField_a_of_type_Biso == null) {
        this.jdField_a_of_type_Biso = new biso(this);
      }
      if ((i != 0) && (NetworkUtil.isNetSupport(this)))
      {
        localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (localObject != null) {
          if ((this.jdField_b_of_type_Int & 0x2) != 0) {}
        }
      }
      for (;;)
      {
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
          this.jdField_b_of_type_Int |= 0x2;
          this.jdField_b_of_type_Long = 0L;
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          ((aoep)localObject).a(l, this.jdField_b_of_type_Long, 4, 0, 0);
          this.jdField_a_of_type_Biso.b(0, 2131719523, 1000);
          bdla.b(this.app, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
          if (!"troopMemberCardMoreInfoPage".equals(this.e)) {
            break;
          }
          new bdlf(this.app).a("dc00899").b("Grp_mem_card").c("more").d("transfer_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.troopdisband.disband", 2, localException2.toString());
          continue;
        }
        this.jdField_a_of_type_Biso.b(2, 2131719524, 1500);
        continue;
        if (i != 0) {
          this.jdField_a_of_type_Biso.b(2, 2131694305, 1500);
        } else {
          this.jdField_a_of_type_Biso.b(2, 2131719528, 1500);
        }
      }
      if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0)) {
        d();
      }
      for (;;)
      {
        if (!"troopMemberCardMoreInfoPage".equals(this.e)) {
          break label542;
        }
        new bdlf(this.app).a("dc00899").b("Grp_mem_card").c("more").d("dissolve_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
        break;
        e();
      }
      label542:
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */