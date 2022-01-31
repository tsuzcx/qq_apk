package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import twx;
import twy;
import twz;
import txa;
import txb;
import txc;
import txf;

public class TroopDisbandActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  public long a;
  protected View a;
  protected Button a;
  protected GridView a;
  protected ImageView a;
  protected TextView a;
  public TroopDisbandActivity.MemberGridAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new txf(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new txc(this);
  public TroopInfo a;
  public QQProgressNotifier a;
  public String a;
  public ArrayList a;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371565));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371567));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371564);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371566));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371568);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131371569));
    this.jdField_a_of_type_AndroidWidgetGridView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371570));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371571));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131371572));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter = new TroopDisbandActivity.MemberGridAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter);
    this.jdField_c_of_type_Int = (getResources().getDimensionPixelSize(2131558535) * 2);
    this.jdField_c_of_type_Int += this.jdField_b_of_type_AndroidViewView.getPaddingLeft() + this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    this.jdField_c_of_type_Int += getResources().getDimensionPixelSize(2131558660) * 2;
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131558659);
    b();
    Object localObject = (TroopManager)this.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, true);
      return;
    }
  }
  
  private void d()
  {
    Dialog localDialog = new Dialog(this, 2131624516);
    localDialog.setContentView(2130970302);
    ((TextView)localDialog.findViewById(2131369987)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131369988);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131369989);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131369990);
    localTextView1.setText(getString(2131434521, new Object[] { "解散", "解散" }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131433016);
    localTextView3.setText(2131433015);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new twy(this, localDialog));
    localTextView3.setOnClickListener(new twz(this, localDialog));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void e()
  {
    String str1 = getString(2131434525);
    String str2 = getString(2131434520);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str1);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setPositiveButton(getString(2131434522), new txa(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131427392));
    localQQCustomDialog.setNegativeButton(getString(2131433015), new txb(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131427393));
    localQQCustomDialog.show();
    ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "initTroopTips groupInfo mTroopUin =" + this.jdField_a_of_type_JavaLangString + ", wMemberNum=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + ", troopCreateTime = " + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131435215), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum) }));
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum <= 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131435210);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131435213);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setClickable(false);
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a();
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (AppSetting.b) {
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131435211);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131435212);
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getSomeMemberUins());
        ThreadManager.post(new twx(this), 5, null, true);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(i);
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|width = " + k + ", columnWidth = " + i);
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|list.width = " + this.jdField_a_of_type_AndroidWidgetGridView.getWidth() + ", list.height = " + this.jdField_a_of_type_AndroidWidgetGridView.getHeight());
      }
      return;
      i = j;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewB(2130970651);
    setTitle(2131434523);
    a();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = this.app.getCurrentAccountUin();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1500);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131371565: 
    case 2131371566: 
    case 2131371567: 
    case 2131371569: 
    case 2131371570: 
    default: 
      return;
    case 2131371564: 
    case 2131371568: 
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {}
      for (paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;; paramView = this.jdField_a_of_type_JavaLangString)
      {
        startActivity(TroopMemberListActivity.a(this, paramView, 4));
        try
        {
          ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, paramView, "1", "0", "");
          return;
        }
        catch (Exception paramView)
        {
          return;
        }
      }
    case 2131371571: 
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum > 1)) {
        break;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      if ((i != 0) && (NetworkUtil.d(this)))
      {
        paramView = (TroopHandler)this.app.a(20);
        if (paramView != null) {
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
          paramView.a(l, this.jdField_b_of_type_Long, 4, 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131435216, 1000);
          ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
          if (!"troopMemberCardMoreInfoPage".equals(this.e)) {
            break;
          }
          new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("transfer_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
          return;
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.troopdisband.disband", 2, paramView.toString());
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131435217, 1500);
        continue;
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131434613, 1500);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131435209, 1500);
        }
      }
      if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0)) {
        d();
      }
      while ("troopMemberCardMoreInfoPage".equals(this.e))
      {
        new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("dissolve_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
        return;
        e();
      }
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */