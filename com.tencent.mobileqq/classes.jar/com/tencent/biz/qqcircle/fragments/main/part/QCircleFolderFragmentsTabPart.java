package com.tencent.biz.qqcircle.fragments.main.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QCircleFolderFragmentsTabPart
  extends QCircleFolderFragmentsPart
{
  private View a;
  private View c;
  private QCircleFolderBean d;
  private boolean e = true;
  
  private void l()
  {
    FeedCloudMeta.StUser localStUser = QCirclePluginGlobalInfo.c();
    if (localStUser == null) {
      return;
    }
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setFromReportBean(d().clone());
    QCircleLauncher.f(g(), localQCircleInitBean);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(localStUser.id.get()).setActionType(11).setSubActionType(2).setThrActionType(2).setPageId(f()));
  }
  
  public void a(View paramView)
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    super.a(paramView);
    if ((c() != null) && (c().getIntent() != null) && ((c().getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleFolderBean)))
    {
      this.d = ((QCircleFolderBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
      c().overridePendingTransition(2130772504, 2130772505);
    }
    this.a = paramView.findViewById(2131440940);
    View localView = this.a;
    if (localView != null) {
      localView.setVisibility(8);
    }
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.a);
    }
    this.c = paramView.findViewById(2131441703);
    paramView = this.c;
    if (paramView != null)
    {
      paramView.setVisibility(0);
      this.c.setOnClickListener(this);
    }
  }
  
  public boolean ah_()
  {
    return super.ah_();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList(super.getEventClass());
    localArrayList.add(QCircleFrameEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    super.h();
    c().overridePendingTransition(2130772504, 2130772505);
  }
  
  public void k()
  {
    super.k();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (!this.e)
    {
      paramActivity = new QCircleFrameEvent();
      paramActivity.mIsNeedExposeTab = true;
      SimpleEventBus.getInstance().dispatchEvent(paramActivity);
    }
    this.e = false;
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131441703) {
      l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.part.QCircleFolderFragmentsTabPart
 * JD-Core Version:    0.7.0.1
 */