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
  XListView a;
  TroopGagActivity.TroopGagMemberAdapter b;
  String c;
  TroopInfo d;
  LinearLayout e;
  View f;
  LinearLayout g;
  Switch h;
  List<TroopGagActivity.GagMemInfo> i = new ArrayList();
  TroopGagObserver j = new TroopGagActivity.2(this);
  TroopObserver k = new TroopGagActivity.3(this);
  
  private boolean a(String paramString)
  {
    Object localObject = this.d;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator)))
    {
      localObject = this.d.Administrator.split("\\|");
      if (localObject != null)
      {
        int n = localObject.length;
        int m = 0;
        while (m < n)
        {
          if (localObject[m].equalsIgnoreCase(paramString)) {
            return true;
          }
          m += 1;
        }
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(this.d.troopowneruin)) && (paramString.equals(this.d.troopowneruin));
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
    this.c = getIntent().getStringExtra("troopuin");
    this.d = paramBundle.g(this.c);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131625941, null);
    this.a = ((XListView)paramBundle.findViewById(2131431170));
    this.a.setVerticalScrollBarEnabled(false);
    this.a.setDivider(null);
    this.a.setFocusable(false);
    this.e = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.e.setOrientation(1);
    localObject = View.inflate(this, 2131627926, null);
    this.e.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131299241), 0, getResources().getDimensionPixelSize(2131299241), getResources().getDimensionPixelSize(2131299236));
    ((TextView)localObject).setTextAppearance(this, 2131953519);
    ((TextView)localObject).setText(getResources().getString(2131893919));
    this.e.addView((View)localObject);
    this.g = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.g.setOrientation(1);
    this.f = View.inflate(this, 2131627926, null);
    this.f.setVisibility(8);
    this.g.addView(this.f);
    localObject = View.inflate(this, 2131625926, null);
    this.h = ((Switch)((View)localObject).findViewById(2131445700));
    TroopGagInfo localTroopGagInfo = ((TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).b(this.c);
    if ((localTroopGagInfo != null) && (localTroopGagInfo.b != 0L)) {
      this.h.setChecked(true);
    } else {
      this.h.setChecked(false);
    }
    this.h.setOnCheckedChangeListener(this);
    this.g.addView((View)localObject);
    localObject = View.inflate(this, 2131627926, null);
    this.g.addView((View)localObject);
    this.a.addFooterView(this.g);
    this.b = new TroopGagActivity.TroopGagMemberAdapter(this);
    this.a.setAdapter(this.b);
    this.a.setBackgroundResource(2130838958);
    super.setContentView(paramBundle);
    setTitle(HardCodeUtil.a(2131912657));
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.makeText(this, 2131892102, 0).show(getTitleBarHeight());
    }
    addObserver(this.j);
    addObserver(this.k);
    paramBundle = new StringBuilder();
    paramBundle.append("last_update_time");
    paramBundle.append(this.app.getCurrentAccountUin());
    paramBundle = getSharedPreferences(paramBundle.toString(), 4);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_last_update_time");
    ((StringBuilder)localObject).append(this.c);
    long l = paramBundle.getLong(((StringBuilder)localObject).toString(), 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.f(this.c);
        ((ITroopMemberListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(true, this.c, paramBundle.troopcode, 8);
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
    TroopGagActivity.TroopGagMemberAdapter localTroopGagMemberAdapter = this.b;
    if (localTroopGagMemberAdapter != null) {
      localTroopGagMemberAdapter.c();
    }
    removeObserver(this.j);
    removeObserver(this.k);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = (ITroopGagHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_GAG_HANDLER);
    TroopGagMgr localTroopGagMgr = (TroopGagMgr)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      ((ITroopGagHandler)localObject).a(this.c, 268435455L);
      localObject = this.app;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, localStringBuilder.toString(), localTroopGagMgr.a(this.c), "", "");
    }
    else
    {
      ((ITroopGagHandler)localObject).a(this.c, 0L);
      localObject = this.app;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, localStringBuilder.toString(), localTroopGagMgr.a(this.c), "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity
 * JD-Core Version:    0.7.0.1
 */