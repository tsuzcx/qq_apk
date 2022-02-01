package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QCirclePublishStatusBoxPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private View a;
  private TextView c;
  private ViewStub d;
  private FeedCloudMeta.StUser e;
  
  public QCirclePublishStatusBoxPart(FeedCloudMeta.StUser paramStUser)
  {
    this.e = paramStUser;
  }
  
  private void a(QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent)
  {
    RFThreadManager.getUIHandler().post(new QCirclePublishStatusBoxPart.1(this, paramQCirclePublishBoxStatusEvent));
  }
  
  private void a(String paramString)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  private void i()
  {
    if ((F() != null) && (this.d == null))
    {
      this.d = ((ViewStub)F().findViewById(2131441823));
      this.a = this.d.inflate();
      this.a.setOnClickListener(this);
      this.c = ((TextView)this.a.findViewById(2131441821));
    }
  }
  
  public String a()
  {
    return "QCirclePublishStatusBoxPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(j(), paramView, E());
    SimpleEventBus.getInstance().registerReceiver(this);
    QCircleTaskQueue.a().b();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
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
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441823)
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(16).setSubActionType(2).setThrActionType(0).setPageId(f()));
      QCircleLauncher.a(g());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishBoxStatusEvent)) {
      a((QCirclePublishBoxStatusEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart
 * JD-Core Version:    0.7.0.1
 */