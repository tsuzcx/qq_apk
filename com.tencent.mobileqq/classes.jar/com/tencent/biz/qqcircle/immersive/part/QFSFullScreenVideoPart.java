package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.Map;

public class QFSFullScreenVideoPart
  extends QFSBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private QCircleInitBean a;
  private QFSFullScreenVideoPresenter b = new QFSFullScreenVideoPresenter();
  private FrameLayout c;
  
  public QFSFullScreenVideoPart()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData != null)
    {
      Object localObject = this.c;
      if (localObject == null) {
        return;
      }
      VideoReport.setElementId(localObject, "em_xsj_multimedia");
      localObject = new QCircleDTParamBuilder().buildElementParams();
      ((Map)localObject).putAll(QCirclePluginReportUtil.a(paramFeedBlockData));
      ((Map)localObject).put("xsj_feed_index", Integer.valueOf(paramInt + 1));
      VideoReport.setElementParams(this.c, (Map)localObject);
      VideoReport.setElementExposePolicy(this.c, ExposurePolicy.REPORT_ALL);
      VideoReport.setElementEndExposePolicy(this.c, EndExposurePolicy.REPORT_ALL);
    }
  }
  
  public String a()
  {
    return "QFSFullScreenVideoPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    d();
  }
  
  public boolean ah_()
  {
    if (this.b != null) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVideoCurrentTimeEvent(this.b.a()));
    }
    return false;
  }
  
  protected void b(View paramView)
  {
    this.b.a(paramView);
    this.c = ((FrameLayout)paramView.findViewById(2131442033));
    this.c.setOnClickListener(this);
  }
  
  protected void d()
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_bundle_common_init_bean")))
    {
      this.a = ((QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
      QCircleInitBean localQCircleInitBean = this.a;
      if (localQCircleInitBean != null)
      {
        QFSFullScreenVideoPresenter localQFSFullScreenVideoPresenter = this.b;
        if (localQFSFullScreenVideoPresenter != null)
        {
          localQFSFullScreenVideoPresenter.a(localQCircleInitBean.getFeed());
          this.b.a(this.a.getDataPosInList());
          this.b.a(Long.valueOf(this.a.getVideoCurrentPosition()));
          a(new FeedBlockData(this.a.getFeed()), this.a.getDataPosInList());
          return;
        }
      }
      c().finish();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFSFullScreenCloseEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.b.b();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.b.c();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131442033))
    {
      QFSFullScreenVideoPresenter localQFSFullScreenVideoPresenter = this.b;
      if (localQFSFullScreenVideoPresenter != null) {
        localQFSFullScreenVideoPresenter.d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QFSFullScreenCloseEvent)) {
      c().onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSFullScreenVideoPart
 * JD-Core Version:    0.7.0.1
 */