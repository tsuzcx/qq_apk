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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
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
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopDisbandActivity.8(this);
  protected TroopInfo a;
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopDisbandActivity.7(this);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379305));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379191));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379193);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379192));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131379189);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131379190));
    this.jdField_a_of_type_AndroidWidgetGridView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379194));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379372));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131379188));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter = new TroopDisbandActivity.MemberGridAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter);
    this.jdField_c_of_type_Int = (getResources().getDimensionPixelSize(2131297277) * 2);
    this.jdField_c_of_type_Int += this.jdField_b_of_type_AndroidViewView.getPaddingLeft() + this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    this.jdField_c_of_type_Int += getResources().getDimensionPixelSize(2131299208) * 2;
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131299206);
    b();
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
    a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, true);
  }
  
  private void d()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
    localReportDialog.setContentView(2131561033);
    ((TextView)localReportDialog.findViewById(2131365681)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    String str = HardCodeUtil.a(2131715068);
    localTextView1.setText(getString(2131691071, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694583);
    localTextView3.setText(2131690728);
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
    String str1 = getString(2131691755);
    String str2 = getString(2131691070);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str1);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setPositiveButton(getString(2131691069), new TroopDisbandActivity.4(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131691237));
    localQQCustomDialog.setNegativeButton(getString(2131690728), new TroopDisbandActivity.5(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131691236));
    localQQCustomDialog.show();
    ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    Object localObject = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("troop_uin");
    this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("troop_code");
    this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("uinname");
    this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_auth_submit_time");
    this.e = ((Bundle)localObject).getString("from");
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      if (l <= 0L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("troopuin = ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(" is illegal");
          QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, localException.toString());
      }
      finish();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate intent params mTroopUin= ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", mTroopName=");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", mTroopCode= ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      QLog.i("Q.troopdisband.disband", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (paramTroopInfo != null)
    {
      this.jdField_c_of_type_JavaLangString = paramTroopInfo.troopcode;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("initTroopTips groupInfo mTroopUin =");
        paramTroopInfo.append(this.jdField_a_of_type_JavaLangString);
        paramTroopInfo.append(", wMemberNum=");
        paramTroopInfo.append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum);
        paramTroopInfo.append(", troopCreateTime = ");
        paramTroopInfo.append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime);
        QLog.i("Q.troopdisband.disband", 2, paramTroopInfo.toString());
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719821), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum) }));
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum <= 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131719828);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719823);
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
      } else {
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131719827);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719822);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getSomeMemberUins());
        ThreadManager.post(new TroopDisbandActivity.1(this), 5, null, true);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
    }
  }
  
  protected void b()
  {
    int k = getResources().getDisplayMetrics().widthPixels;
    int j = (k - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int * 5) / 6;
    int i = j;
    if (j > 125) {
      i = 125;
    }
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i);
    Object localObject = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    if (localObject != null) {
      ((ViewGroup.LayoutParams)localObject).height = (i + 4);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.a(i);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initListItemSize|width = ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", columnWidth = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initListItemSize|list.width = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetGridView.getWidth());
      ((StringBuilder)localObject).append(", list.height = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetGridView.getHeight());
      QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewB(2131561537);
    setTitle(2131716747);
    a();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = this.app.getCurrentAccountUin();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    QQProgressNotifier localQQProgressNotifier = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
    if (localQQProgressNotifier != null)
    {
      localQQProgressNotifier.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResult|REQUEST_FOR_TROOP_TRANSFER|isNeedFinish = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", strTip = ");
        ((StringBuilder)localObject).append(str);
        QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("fin_tip_msg", str);
        ((Intent)localObject).putExtra("uin", paramIntent);
        setResult(paramInt2, (Intent)localObject);
        finish();
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1500);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379372: 
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      int i;
      if ((localObject1 != null) && (((TroopInfo)localObject1).wMemberNum <= 1)) {
        i = 0;
      } else {
        i = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      if ((i != 0) && (NetworkUtil.isNetSupport(this)))
      {
        localObject1 = (ITroopMemberListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
        if (localObject1 != null)
        {
          if ((this.jdField_b_of_type_Int & 0x2) == 0) {
            try
            {
              long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
              this.jdField_b_of_type_Int |= 0x2;
              this.jdField_b_of_type_Long = 0L;
              this.jdField_a_of_type_JavaUtilArrayList.clear();
              ((ITroopMemberListHandler)localObject1).a(l, this.jdField_b_of_type_Long, 4, 0, 0);
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.troopdisband.disband", 2, localException1.toString());
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131719819, 1000);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131719820, 1500);
        }
      }
      else if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694475, 1500);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131719824, 1500);
      }
      ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
      if ("troopMemberCardMoreInfoPage".equals(this.e)) {
        new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("transfer_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
      }
      break;
    case 2131379189: 
    case 2131379193: 
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localObject2 != null) {
        localObject2 = ((TroopInfo)localObject2).troopuin;
      } else {
        localObject2 = this.jdField_a_of_type_JavaLangString;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", (String)localObject2);
      localIntent.putExtra("param_from", 4);
      RouteUtils.a(this, localIntent, "/troop/memberlist/TroopMemberList");
    }
    try
    {
      ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, (String)localObject2, "1", "0", "");
    }
    catch (Exception localException2)
    {
      break label573;
    }
    if (((this.jdField_a_of_type_Long & 0x800) == 0L) && (this.jdField_a_of_type_Int == 0)) {
      e();
    } else {
      d();
    }
    if ("troopMemberCardMoreInfoPage".equals(this.e)) {
      new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("dissolve_clk").a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    }
    label573:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */