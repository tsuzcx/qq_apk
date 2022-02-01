package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.adapter.QCircleTaskCenterAdapter;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;

public class QCircleTaskCenterPart
  extends QCircleBaseBlockPart
  implements SimpleEventReceiver
{
  private PopupWindow b;
  private QCircleTaskCenterAdapter e;
  private ReportBean<QCircleReportBean> f;
  
  private void n()
  {
    if (this.b == null)
    {
      this.b = new PopupWindow(be_(), -1, -1);
      this.b.setAnimationStyle(2131953021);
      this.b.setBackgroundDrawable(new ColorDrawable(0));
      this.b.setContentView(be_());
      this.b.setOutsideTouchable(true);
    }
  }
  
  public String a()
  {
    return "QCircleTaskCenterPart";
  }
  
  public void a(View paramView)
  {
    this.e = new QCircleTaskCenterAdapter(null);
    ReportBean localReportBean = this.f;
    if (localReportBean != null) {
      this.e.a(localReportBean);
    } else if (d() != null) {
      this.e.setReportBean(d());
    }
    r().add(this.e);
    super.a(paramView);
    be_().getRecyclerView().setBackgroundResource(2130845460);
    be_().setBackgroundResource(2131165579);
    be_().setOnClickListener(new QCircleTaskCenterPart.1(this));
    paramView = be_();
    double d = DisplayUtil.e();
    Double.isNaN(d);
    paramView.setPadding(0, (int)(d * 0.6D), 0, 0);
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.f = paramReportBean;
  }
  
  public boolean ah_()
  {
    PopupWindow localPopupWindow = this.b;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      m();
      return true;
    }
    return super.ah_();
  }
  
  protected int e()
  {
    if (this.a != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterPart", this.a);
    }
    ReportBean localReportBean = this.f;
    if (localReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterPart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  protected int f()
  {
    if (this.a != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterPart", this.a);
    }
    ReportBean localReportBean = this.f;
    if (localReportBean != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterPart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTaskCenterEvent.class);
    return localArrayList;
  }
  
  public void l()
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((PopupWindow)localObject).isShowing()))
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(8).setSubActionType(1).setThrActionType(0).setPageId(f()).setfPageId(e()));
      localObject = this.e;
      if (localObject != null) {
        ((QCircleTaskCenterAdapter)localObject).onRefreshData();
      }
      this.b.showAtLocation(be_().getRootView(), 81, 0, 0);
    }
  }
  
  public void m()
  {
    PopupWindow localPopupWindow = this.b;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.b.dismiss();
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    m();
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleTaskCenterEvent))
    {
      paramSimpleBaseEvent = (QCircleTaskCenterEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mPopContextHashCode != g().hashCode()) {
        return;
      }
      n();
      if (paramSimpleBaseEvent.mIsShowTaskPanel)
      {
        l();
        return;
      }
      m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart
 * JD-Core Version:    0.7.0.1
 */