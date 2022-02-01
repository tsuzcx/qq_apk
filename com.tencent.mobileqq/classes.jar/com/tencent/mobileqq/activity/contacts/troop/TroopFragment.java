package com.tencent.mobileqq.activity.contacts.troop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  protected ContactsTroopAdapter a;
  protected SwipPinnedHeaderExpandableListView b;
  protected TroopFragment.MyRoamSettingObserver c;
  protected TroopFragment.MyAvatarObserver d;
  protected TroopFragment.MyTroopObserver e;
  protected TroopFragment.MyTroopOnlinePushObserver f;
  protected TroopFragment.MyTroopModifyObserver g;
  protected TroopFragment.MyTroopMngObserver h;
  protected TroopFragment.MyMessageObserver i;
  protected boolean j;
  protected TroopUsingTimeReport k;
  protected boolean l;
  protected TroopCommonlyUsedObserver m = new TroopFragment.2(this);
  private AutomatorObserver n = new TroopFragment.3(this);
  
  private void k()
  {
    if (this.b != null)
    {
      ContactsTroopAdapter localContactsTroopAdapter = this.a;
      if (localContactsTroopAdapter != null) {
        localContactsTroopAdapter.b();
      }
      this.a = new ContactsTroopAdapter(this.w, this.s, this.b);
      this.b.setAdapter(this.a);
      this.b.setOnGroupClickListener(this.a);
    }
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "getView");
    }
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null)
    {
      this.b = new TroopFragment.ContactsPinnedHeaderExpandableListView(this.w);
      this.b.setId(2131441547);
      this.b.setSelector(2131168376);
      this.b.setNeedCheckSpringback(true);
      this.b.setGroupIndicator(null);
      this.b.setDivider(null);
      this.b.setPadding(0, 0, 0, AIOUtils.b(54.0F, getResources()));
      this.b.setClipToPadding(false);
      this.b.setScrollBarStyle(33554432);
      paramLayoutInflater = this.b;
      paramLayoutInflater.mForContacts = true;
      paramLayoutInflater.setOnScrollListener(this);
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.b);
      }
    }
    this.k = new TroopUsingTimeReport(this.s, null, "Grp_time", "Grp_contactlist", "visit_time");
    return this.b;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ContactsTroopAdapter)localObject).b();
    }
    e();
    localObject = this.k;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).c();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume:");
      localStringBuilder.append(paramBoolean);
      QLog.d("contacts.fragment.TroopFragment", 2, localStringBuilder.toString());
    }
    if (this.b == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.a == null) {
      k();
    }
    this.b.postDelayed(new TroopFragment.1(this), 200L);
    this.l = true;
    this.k.b();
    new ReportTask(this.s).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp").a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onPause");
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((SwipPinnedHeaderExpandableListView)localObject).hideCurShowingRightView();
    }
    localObject = this.a;
    if (localObject != null) {
      ((ContactsTroopAdapter)localObject).c();
    }
    if (paramBoolean) {
      e();
    }
    if (this.l) {
      this.k.c();
    }
  }
  
  public void bU_()
  {
    ((ITroopListHandler)this.s.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).b();
    this.j = true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "resetData");
    }
    k();
    if (this.v)
    {
      ContactsTroopAdapter localContactsTroopAdapter = this.a;
      if (localContactsTroopAdapter != null) {
        localContactsTroopAdapter.notifyDataSetChanged();
      }
    }
    this.k = new TroopUsingTimeReport(this.s, null, "Grp_time", "Grp_contactlist", "visit_time");
    if (isResumed()) {
      this.k.b();
    }
  }
  
  protected void d()
  {
    if (this.v)
    {
      if (this.c == null) {
        this.c = new TroopFragment.MyRoamSettingObserver(this);
      }
      if (this.d == null) {
        this.d = new TroopFragment.MyAvatarObserver(this);
      }
      if (this.e == null) {
        this.e = new TroopFragment.MyTroopObserver(this);
      }
      if (this.f == null) {
        this.f = new TroopFragment.MyTroopOnlinePushObserver(this);
      }
      if (this.g == null) {
        this.g = new TroopFragment.MyTroopModifyObserver(this);
      }
      if (this.h == null) {
        this.h = new TroopFragment.MyTroopMngObserver(this);
      }
      if (this.i == null) {
        this.i = new TroopFragment.MyMessageObserver(this);
      }
      this.s.addObserver(this.c);
      this.s.addObserver(this.d);
      this.s.addObserver(this.e);
      this.s.addObserver(this.f);
      this.s.addObserver(this.g);
      this.s.addObserver(this.h);
      this.s.addObserver(this.i);
      this.s.addObserver(this.m);
      this.s.addObserver(this.n);
    }
  }
  
  protected void e()
  {
    this.s.removeObserver(this.c);
    this.s.removeObserver(this.d);
    this.s.removeObserver(this.e);
    this.s.removeObserver(this.f);
    this.s.removeObserver(this.g);
    this.s.removeObserver(this.h);
    this.s.removeObserver(this.i);
    this.s.removeObserver(this.m);
    this.s.removeObserver(this.n);
  }
  
  public void f()
  {
    if (this.b != null)
    {
      ContactsTroopAdapter localContactsTroopAdapter = this.a;
      if (localContactsTroopAdapter != null)
      {
        localContactsTroopAdapter.g();
        if (this.b.getFirstVisiblePosition() > 0) {
          this.b.setSelection(0);
        }
      }
    }
  }
  
  public void g()
  {
    if (this.v)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ContactsTroopAdapter)localObject).c();
      }
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).c();
    }
    super.g();
  }
  
  public View getScrollableView()
  {
    return this.b;
  }
  
  void j()
  {
    ContactsTroopAdapter localContactsTroopAdapter = this.a;
    if (localContactsTroopAdapter != null) {
      localContactsTroopAdapter.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment
 * JD-Core Version:    0.7.0.1
 */