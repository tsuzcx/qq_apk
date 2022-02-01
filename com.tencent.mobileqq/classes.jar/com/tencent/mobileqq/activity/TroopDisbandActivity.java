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
  private AvatarObserver A = new TroopDisbandActivity.8(this);
  protected TextView a;
  protected View b;
  protected ImageView c;
  protected TextView d;
  protected View e;
  protected GridView f;
  protected TextView g;
  protected Button h;
  protected Button i;
  protected TroopInfo j;
  protected String k;
  protected String l;
  protected String m;
  protected long n;
  protected int o;
  protected int p;
  protected TroopDisbandActivity.MemberGridAdapter q;
  protected int r;
  protected int s;
  protected long t;
  protected ArrayList<String> u;
  protected String v;
  protected QQProgressNotifier w;
  protected String x = "";
  TroopObserver y = new TroopDisbandActivity.6(this);
  TroopMngObserver z = new TroopDisbandActivity.7(this);
  
  private void c()
  {
    this.a = ((TextView)findViewById(2131448042));
    this.c = ((ImageView)findViewById(2131447928));
    this.b = findViewById(2131447930);
    this.d = ((TextView)findViewById(2131447929));
    this.e = findViewById(2131447926);
    this.f = ((GridView)findViewById(2131447927));
    this.f.setFocusable(false);
    this.f.setClickable(false);
    this.f.setEnabled(false);
    this.g = ((TextView)findViewById(2131447931));
    this.h = ((Button)findViewById(2131448112));
    this.h.setOnClickListener(this);
    this.i = ((Button)findViewById(2131447925));
    this.i.setOnClickListener(this);
    this.q = new TroopDisbandActivity.MemberGridAdapter(this);
    this.f.setAdapter(this.q);
    this.r = (getResources().getDimensionPixelSize(2131297708) * 2);
    this.r += this.e.getPaddingLeft() + this.e.getPaddingRight();
    this.r += getResources().getDimensionPixelSize(2131299961) * 2;
    this.s = getResources().getDimensionPixelSize(2131299959);
    b();
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TroopManager)localObject).f(this.k);
    }
    this.j = ((TroopInfo)localObject);
    a(this.j, true);
  }
  
  private void d()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131627374);
    ((TextView)localReportDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131431907);
    String str = HardCodeUtil.a(2131912556);
    localTextView1.setText(getString(2131888017, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131892267);
    localTextView3.setText(2131887648);
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
    String str1 = getString(2131888717);
    String str2 = getString(2131888016);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str1);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setPositiveButton(getString(2131888015), new TroopDisbandActivity.4(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131888183));
    localQQCustomDialog.setNegativeButton(getString(2131887648), new TroopDisbandActivity.5(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131888182));
    localQQCustomDialog.show();
    ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    Object localObject = getIntent().getExtras();
    this.k = ((Bundle)localObject).getString("troop_uin");
    this.m = ((Bundle)localObject).getString("troop_code");
    this.l = ((Bundle)localObject).getString("uinname");
    this.n = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
    this.o = ((Bundle)localObject).getInt("troop_auth_submit_time");
    this.x = ((Bundle)localObject).getString("from");
    try
    {
      long l1 = Long.parseLong(this.k);
      if (l1 <= 0L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("troopuin = ");
          ((StringBuilder)localObject).append(l1);
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
      localStringBuilder.append(this.k);
      localStringBuilder.append(", mTroopName=");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", mTroopCode= ");
      localStringBuilder.append(this.m);
      QLog.i("Q.troopdisband.disband", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    this.j = paramTroopInfo;
    paramTroopInfo = this.j;
    if (paramTroopInfo != null)
    {
      this.m = paramTroopInfo.troopcode;
      this.l = this.j.getTroopDisplayName();
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("initTroopTips groupInfo mTroopUin =");
        paramTroopInfo.append(this.k);
        paramTroopInfo.append(", wMemberNum=");
        paramTroopInfo.append(this.j.wMemberNum);
        paramTroopInfo.append(", troopCreateTime = ");
        paramTroopInfo.append(this.j.troopCreateTime);
        QLog.i("Q.troopdisband.disband", 2, paramTroopInfo.toString());
      }
      this.d.setText(String.format(getString(2131917426), new Object[] { Integer.valueOf(this.j.wMemberNum) }));
      if (this.j.wMemberNum <= 1)
      {
        this.g.setText(2131917433);
        this.a.setText(2131917428);
        this.c.setVisibility(8);
        this.b.setClickable(false);
        this.e.setClickable(false);
        this.q.a();
        this.h.setVisibility(8);
        return;
      }
      this.c.setVisibility(0);
      if (AppSetting.e) {
        this.e.setClickable(false);
      } else {
        this.e.setOnClickListener(this);
      }
      this.b.setOnClickListener(this);
      this.g.setText(2131917432);
      this.a.setText(2131917427);
      if (paramBoolean)
      {
        this.q.a(this.j.getSomeMemberUins());
        ThreadManager.post(new TroopDisbandActivity.1(this), 5, null, true);
      }
    }
    else
    {
      this.d.setText("");
      this.g.setText("");
      this.c.setVisibility(8);
      this.b.setClickable(false);
    }
  }
  
  protected void b()
  {
    int i3 = getResources().getDisplayMetrics().widthPixels;
    int i2 = (i3 - this.r - this.s * 5) / 6;
    int i1 = i2;
    if (i2 > 125) {
      i1 = 125;
    }
    this.f.setColumnWidth(i1);
    Object localObject = this.f.getLayoutParams();
    if (localObject != null) {
      ((ViewGroup.LayoutParams)localObject).height = (i1 + 4);
    }
    this.q.a(i1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initListItemSize|width = ");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(", columnWidth = ");
      ((StringBuilder)localObject).append(i1);
      QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initListItemSize|list.width = ");
      ((StringBuilder)localObject).append(this.f.getWidth());
      ((StringBuilder)localObject).append(", list.height = ");
      ((StringBuilder)localObject).append(this.f.getHeight());
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
    setContentViewB(2131627898);
    setTitle(2131914219);
    a();
    this.t = 0L;
    this.u = new ArrayList();
    this.v = this.app.getCurrentAccountUin();
    addObserver(this.z);
    addObserver(this.y);
    addObserver(this.A);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.z);
    removeObserver(this.y);
    removeObserver(this.A);
    QQProgressNotifier localQQProgressNotifier = this.w;
    if (localQQProgressNotifier != null)
    {
      localQQProgressNotifier.b();
      this.w = null;
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
        if (this.w == null) {
          this.w = new QQProgressNotifier(this);
        }
        this.w.a(1, str, 1500);
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
    case 2131448112: 
      Object localObject1 = this.j;
      int i1;
      if ((localObject1 != null) && (((TroopInfo)localObject1).wMemberNum <= 1)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (this.w == null) {
        this.w = new QQProgressNotifier(this);
      }
      if ((i1 != 0) && (NetworkUtil.isNetSupport(this)))
      {
        localObject1 = (ITroopMemberListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
        if (localObject1 != null)
        {
          if ((this.p & 0x2) == 0) {
            try
            {
              long l1 = Long.parseLong(this.k);
              this.p |= 0x2;
              this.t = 0L;
              this.u.clear();
              ((ITroopMemberListHandler)localObject1).a(l1, this.t, 4, 0, 0);
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.troopdisband.disband", 2, localException1.toString());
              }
            }
          }
          this.w.b(0, 2131917424, 1000);
        }
        else
        {
          this.w.b(2, 2131917425, 1500);
        }
      }
      else if (i1 != 0)
      {
        this.w.b(2, 2131892157, 1500);
      }
      else
      {
        this.w.b(2, 2131917429, 1500);
      }
      ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
      if ("troopMemberCardMoreInfoPage".equals(this.x)) {
        new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("transfer_clk").a(new String[] { this.k }).a();
      }
      break;
    case 2131447926: 
    case 2131447930: 
      localObject2 = this.j;
      if (localObject2 != null) {
        localObject2 = ((TroopInfo)localObject2).troopuin;
      } else {
        localObject2 = this.k;
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
    if (((this.n & 0x800) == 0L) && (this.o == 0)) {
      e();
    } else {
      d();
    }
    if ("troopMemberCardMoreInfoPage".equals(this.x)) {
      new ReportTask(this.app).a("dc00899").b("Grp_mem_card").c("more").d("dissolve_clk").a(new String[] { this.k }).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */