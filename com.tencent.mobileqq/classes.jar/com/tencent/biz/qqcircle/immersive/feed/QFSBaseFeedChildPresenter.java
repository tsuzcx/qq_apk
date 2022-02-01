package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBaseFeedPresenterEvent;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.manager.IQFSLayerScrollerStatus;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public abstract class QFSBaseFeedChildPresenter<T>
  implements IQFSLayerScrollerStatus, SimpleEventReceiver
{
  protected IQFSFeedIoc a;
  protected View b;
  protected T c;
  protected int d;
  protected QFSFeedPresenterManager e;
  protected View f;
  protected QCircleExtraTypeInfo g;
  protected FeedBlockData h;
  
  private void a(QFSSeekEvent paramQFSSeekEvent)
  {
    Object localObject = this.c;
    if (!(localObject instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    if (!((FeedCloudMeta.StFeed)localObject).id.get().equals(paramQFSSeekEvent.mFeedId)) {
      return;
    }
    a(paramQFSSeekEvent.mIsOnSeek);
  }
  
  private Object k()
  {
    View localView = this.f;
    if (!(localView instanceof QCircleBaseWidgetView)) {
      return null;
    }
    return ((QCircleBaseWidgetView)localView).getReportBean();
  }
  
  public void a() {}
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(@NonNull View paramView)
  {
    this.f = paramView;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.g = paramQCircleExtraTypeInfo;
  }
  
  public void a(FeedBlockData paramFeedBlockData)
  {
    this.h = paramFeedBlockData;
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo) {}
  
  public void a(QFSFeedPresenterManager paramQFSFeedPresenterManager)
  {
    this.e = paramQFSFeedPresenterManager;
  }
  
  protected void a(QFSBaseFeedPresenterEvent paramQFSBaseFeedPresenterEvent) {}
  
  public void a(IQFSFeedIoc paramIQFSFeedIoc)
  {
    this.a = paramIQFSFeedIoc;
  }
  
  public void a(T paramT, int paramInt)
  {
    this.c = paramT;
    this.d = paramInt;
  }
  
  protected void a(boolean paramBoolean) {}
  
  public boolean a(QFSTouchBean paramQFSTouchBean)
  {
    return false;
  }
  
  public void b(QFSFeedSelectInfo paramQFSFeedSelectInfo) {}
  
  public void b(QFSBaseFeedPresenterEvent paramQFSBaseFeedPresenterEvent)
  {
    QFSFeedPresenterManager localQFSFeedPresenterManager = this.e;
    if (localQFSFeedPresenterManager == null) {
      return;
    }
    localQFSFeedPresenterManager.a(paramQFSBaseFeedPresenterEvent);
  }
  
  public boolean b()
  {
    IQFSFeedIoc localIQFSFeedIoc = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localIQFSFeedIoc != null)
    {
      int i = localIQFSFeedIoc.bk_();
      int j = this.a.bl_();
      int k = this.a.d();
      bool1 = bool2;
      if (i == this.d)
      {
        bool1 = bool2;
        if (j == k) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void c() {}
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo) {}
  
  public void d() {}
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo) {}
  
  public QCircleExtraTypeInfo e()
  {
    return this.g;
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo) {}
  
  public int f()
  {
    return i().getPageId();
  }
  
  public String g()
  {
    return i().getDtPageId();
  }
  
  public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFSSeekEvent.class);
    return localArrayList;
  }
  
  public String h()
  {
    return String.valueOf(i().getFromPageId());
  }
  
  public QCircleReportBean i()
  {
    Object localObject = k();
    if (!(localObject instanceof QCircleReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("QFSBaseFeedChildPresenter", 1, "getReportBean but FSReportBean is null");
        return new QCircleReportBean();
      }
      QLog.e("QFSBaseFeedChildPresenter", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (QCircleReportBean)localObject;
  }
  
  public void j() {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QFSSeekEvent)) {
      a((QFSSeekEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
 * JD-Core Version:    0.7.0.1
 */