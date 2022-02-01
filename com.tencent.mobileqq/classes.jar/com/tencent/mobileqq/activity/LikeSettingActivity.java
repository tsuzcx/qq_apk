package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.INearByGeneralManager;
import com.tencent.mobileqq.nearby.INearbyRelevantHandler;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LikeSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, PraiseManager.OnPraiseLoadListener
{
  LikeRankingListManager a;
  PraiseManager b;
  FormSwitchItem c;
  FormSwitchItem d;
  FormSwitchItem e;
  FormSwitchItem f;
  FormSimpleItem g;
  CardHandler h;
  CardObserver i = new LikeSettingActivity.1(this);
  NearbyRelevantObserver j = new LikeSettingActivity.2(this);
  CompoundButton.OnCheckedChangeListener k = new LikeSettingActivity.3(this);
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.k);
  }
  
  void a()
  {
    boolean bool = ((INearByGeneralManager)this.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).a();
    this.c.setOnCheckedChangeListener(null);
    a(this.c.getSwitch(), bool);
    this.c.setOnCheckedChangeListener(this.k);
    bool = this.app.getLocZanAllowedForPeople();
    a(this.e.getSwitch(), bool);
    this.e.setOnCheckedChangeListener(this.k);
    this.d.setOnCheckedChangeListener(null);
    Object localObject = this.d;
    if (this.a.e()) {
      m = 0;
    } else {
      m = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(m);
    this.d.setChecked(this.a.c());
    this.d.setOnCheckedChangeListener(this.k);
    this.f.setOnCheckedChangeListener(null);
    this.f.setChecked(this.a.e());
    this.f.setOnCheckedChangeListener(this.k);
    int m = PraiseManager.a(this.app);
    if (m > 0)
    {
      this.b.a(this);
      localObject = this.b.a(m, true, "from_like_setting");
      if (localObject != null)
      {
        m = AIOUtils.b(34.0F, super.getResources());
        this.g.setRightIcon(new BitmapDrawable(super.getResources(), ((PraiseInfo)localObject).h), m, m);
      }
    }
    this.g.setOnClickListener(this);
    ThreadManager.post(new LikeSettingActivity.4(this), 5, null, true);
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if ((paramInt1 == PraiseManager.a(this.app)) && (paramPraiseInfo != null))
    {
      paramInt1 = AIOUtils.b(34.0F, super.getResources());
      this.g.setRightIcon(new BitmapDrawable(super.getResources(), paramPraiseInfo.h), paramInt1, paramInt1);
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
    setContentView(2131627543);
    setTitle(HardCodeUtil.a(2131904057));
    setLeftViewName(2131887625);
    this.a = ((LikeRankingListManager)this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER));
    this.b = ((PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER));
    this.h = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.c = ((FormSwitchItem)super.findViewById(2131439471));
    this.d = ((FormSwitchItem)super.findViewById(2131439472));
    this.e = ((FormSwitchItem)super.findViewById(2131437190));
    this.f = ((FormSwitchItem)super.findViewById(2131439473));
    this.g = ((FormSimpleItem)super.findViewById(2131440007));
    a();
    this.app.addObserver(this.i);
    this.app.addObserver(this.j);
    this.app.getZanSwitches();
    this.h.i();
    this.h.e();
    ((INearbyRelevantHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.i);
    this.app.removeObserver(this.j);
    this.b.b(this);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    VasWebviewUtil.b(this, VasWebviewUtil.b(IndividuationUrlHelper.a(this, "praise", ""), 51), 536870912L, localIntent, false, -1);
    ReportController.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity
 * JD-Core Version:    0.7.0.1
 */