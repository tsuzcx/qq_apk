package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.HashMap;

public class QCircleFolderActivityChipPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private View a;
  private View c;
  private View d;
  private View e;
  private View f;
  private SquareImageView g;
  private ImageView h;
  private TextView i;
  private ImageView j;
  private ImageView k;
  private ReportBean<QCircleReportBean> l;
  private boolean m = false;
  private boolean n = false;
  private QCircleFuelAnimationEvent o;
  
  private void a(QCircleFuelAnimationEvent paramQCircleFuelAnimationEvent)
  {
    QCircleFuelAnimationManager.a().a(paramQCircleFuelAnimationEvent.getPublishTask());
    QCircleFuelAnimationManager.a().a(this.h, this.k, this.g, false);
  }
  
  private boolean i()
  {
    return f() == 3;
  }
  
  public String a()
  {
    return "QCircleFolderActivityChipPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = paramView.findViewById(2131440957);
    this.c = paramView.findViewById(2131440955);
    this.d = paramView.findViewById(2131440940);
    this.d.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.d);
    }
    this.e = paramView.findViewById(2131440947);
    this.e.setOnClickListener(this);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(4).setSubActionType(1));
    this.f = paramView.findViewById(2131440938);
    this.g = ((SquareImageView)paramView.findViewById(2131440946));
    this.h = ((ImageView)paramView.findViewById(2131441684));
    this.i = ((TextView)paramView.findViewById(2131441687));
    this.j = ((ImageView)paramView.findViewById(2131441686));
    this.k = ((ImageView)paramView.findViewById(2131441685));
    this.f.setOnClickListener(this);
    this.g.setImageDrawable(QCirclePluginGlobalInfo.a(HostDataTransUtils.getAccount()));
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.l = paramReportBean;
  }
  
  public QCircleReportBean d()
  {
    if (this.b != null) {
      return QCircleReportBean.getReportBean("QCircleFolderActivityChipPart", this.b).clone();
    }
    ReportBean localReportBean = this.l;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleFolderActivityChipPart", (QCircleReportBean)localReportBean.getReportBean()).clone();
    }
    return new QCircleReportBean();
  }
  
  protected int f()
  {
    if (this.b != null) {
      return QCircleReportBean.getPageId(a(), this.b);
    }
    if (this.l != null) {
      return QCircleReportBean.getPageId(a(), (QCircleReportBean)this.l.getReportBean());
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFuelAnimationEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.m = true;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.m = false;
    if (this.n)
    {
      this.h.postDelayed(new QCircleFolderActivityChipPart.2(this), 1000L);
      this.n = false;
    }
    RFThreadManager.execute(new QCircleFolderActivityChipPart.3(this), RFThreadManager.FILE);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (i()) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    int i1 = paramView.getId();
    if (i1 == 2131440940)
    {
      c().onBackPressed();
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(21).setSubActionType(1).setThrActionType(0).setExt1((String)localObject));
    }
    else if (i1 == 2131440947)
    {
      if (QCircleFlutterUtils.a())
      {
        localObject = new QCircleSchemeBean();
        HashMap localHashMap = new HashMap();
        localHashMap.put("backbehavior", "0");
        ((QCircleSchemeBean)localObject).setAttrs(localHashMap);
        ((QCircleSchemeBean)localObject).setSchemeAction("opencirclesearch");
        QCircleSchemeLauncher.b(g(), (QCircleSchemeBean)localObject);
      }
      else
      {
        QCircleLauncher.a(c(), QCircleJsUrlConfig.a, null, -1);
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(4).setSubActionType(2));
    }
    else if ((i1 == 2131440938) || (i1 == 2131440946))
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(21).setSubActionType(2).setThrActionType(0).setExt1((String)localObject));
      localObject = new QCircleInitBean();
      ((QCircleInitBean)localObject).setUin(HostDataTransUtils.getAccount());
      ((QCircleInitBean)localObject).setFromReportBean(d().clone());
      QCircleLauncher.b(g(), (QCircleInitBean)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFuelAnimationEvent)) {
      this.h.postDelayed(new QCircleFolderActivityChipPart.1(this, paramSimpleBaseEvent), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart
 * JD-Core Version:    0.7.0.1
 */