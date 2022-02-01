package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QFSPublishStatusBoxPart
  extends QFSBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private View a;
  private TextView b;
  private ViewStub c;
  private FeedCloudMeta.StUser d;
  private boolean e = false;
  
  public QFSPublishStatusBoxPart(FeedCloudMeta.StUser paramStUser)
  {
    this.d = paramStUser;
  }
  
  private void a(QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent)
  {
    G().post(new QFSPublishStatusBoxPart.1(this, paramQCirclePublishBoxStatusEvent));
  }
  
  private void a(String paramString)
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  private void d()
  {
    if ((F() != null) && (this.c == null))
    {
      this.c = ((ViewStub)F().findViewById(2131441823));
      this.a = this.c.inflate();
      this.a.setOnClickListener(this);
      this.b = ((TextView)this.a.findViewById(2131441821));
    }
  }
  
  public String a()
  {
    return "QFSPublishStatusBoxPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(m(), paramView, E());
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
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(16).setSubActionType(2).setThrActionType(0).setPageId(i()));
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
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSPublishStatusBoxPart
 * JD-Core Version:    0.7.0.1
 */