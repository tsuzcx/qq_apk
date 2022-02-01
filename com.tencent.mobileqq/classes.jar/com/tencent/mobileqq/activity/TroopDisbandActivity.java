package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

public class TroopDisbandActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected int a;
  protected long a;
  protected View a;
  protected Button a;
  protected GridView a;
  protected ImageView a;
  protected TextView a;
  protected TroopDisbandActivity.MemberGridAdapter a;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopDisbandActivity.7(this);
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopDisbandActivity.8(this);
  protected TroopInfo a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopDisbandActivity.6(this);
  protected QQProgressNotifier a;
  protected String a;
  protected ArrayList<String> a;
  protected int b;
  protected long b;
  protected View b;
  protected Button b;
  protected TextView b;
  protected String b;
  protected int c;
  protected TextView c;
  protected String c;
  protected int d;
  protected String d;
  protected String e = "";
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379976));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379862));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379864);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379863));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131379860);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131379861));
    this.jdField_a_of_type_AndroidWidgetGridView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379865));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131380043));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131379859));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter = new TroopDisbandActivity.MemberGridAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter);
    this.jdField_c_of_type_Int = (getResources().getDimensionPixelSize(2131297288) * 2);
    this.jdField_c_of_type_Int += this.jdField_b_of_type_AndroidViewView.getPaddingLeft() + this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    this.jdField_c_of_type_Int += getResources().getDimensionPixelSize(2131299200) * 2;
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131299198);
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
    ReportDialog localReportDialog = new ReportDialog(this, 2131755842);
    localReportDialog.setContentView(2131561170);
    ((TextView)localReportDialog.findViewById(2131365845)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365832);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365830);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365836);
    String str = HardCodeUtil.a(2131715145);
    localTextView1.setText(getString(2131691151, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694615);
    localTextView3.setText(2131690800);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new TroopDisbandActivity.2(this, localReportDialog));
    localTextView3.setOnClickListener(new TroopDisbandActivity.3(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void e()
  {
    String str1 = getString(2131691833);
    String str2 = getString(2131691150);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str1);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setPositiveButton(getString(2131691149), new TroopDisbandActivity.4(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131691316));
    localQQCustomDialog.setNegativeButton(getString(2131690800), new TroopDisbandActivity.5(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131691315));
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
  
  protected void a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "initTroopTips groupInfo mTroopUin =" + this.jdField_a_of_type_JavaLangString + ", wMemberNum=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum + ", troopCreateTime = " + this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131720089), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum) }));
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum <= 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131720096);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720091);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setClickable(false);
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a();
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (AppSetting.d) {
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131720095);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720090);
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getSomeMemberUins());
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
    setContentViewB(2131561694);
    setTitle(2131717088);
    a();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = this.app.getCurrentAccountUin();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1500);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131379860: 
    case 2131379864: 
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {}
      for (String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;; localObject = this.jdField_a_of_type_JavaLangString)
      {
        for (;;)
        {
          startActivity(TroopMemberListActivity.a(this, str, 4));
          try
          {
            ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, str, "1", "0", "");
          }
          catch (Exception localException1) {}
        }
        break;
      }
    case 2131380043: 
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum > 1)) {
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
        localObject = (TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
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
          ((TroopHandler)localObject).a(l, this.jdField_b_of_type_Long, 4, 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131720087, 1000);
          ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
          if (!"troopMemberCardMoreInfoPage".equals(this.e)) {
            break;
          }
          new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("transfer_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.troopdisband.disband", 2, localException2.toString());
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131720088, 1500);
        continue;
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694510, 1500);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131720092, 1500);
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
        new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("dissolve_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */