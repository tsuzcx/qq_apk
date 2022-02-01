package com.tencent.biz.qqcircle.immersive.tab;

import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSTabFragmentIoc;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerTabPart;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class QFSBaseLayerTabFragment
  extends QFSBaseTabFragment
{
  protected QFSLayerTabPart c;
  protected IQFSTabFragmentIoc d;
  private long e;
  
  protected QFSBaseLayerTabFragment(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    super(paramQCircleTabInfo, paramInt);
  }
  
  private void a(QCircleFrameEvent paramQCircleFrameEvent)
  {
    if ((getContext() != null) && (getContext().hashCode() != paramQCircleFrameEvent.mHashCode)) {
      b(paramQCircleFrameEvent.mRefreshTab);
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0) {
      x();
    }
  }
  
  public void B() {}
  
  public void L()
  {
    QLog.d(b(), 1, "scrollToTop");
    try
    {
      this.c.q().getViewPager2().setCurrentItem(0);
      return;
    }
    catch (Exception localException)
    {
      String str = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTop exception:");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  public void M()
  {
    QLog.d(b(), 1, "scrollToTop");
    try
    {
      if (this.d != null) {
        this.d.a("event_hide_comment", new Object[0]);
      }
      this.c.x();
      return;
    }
    catch (Exception localException)
    {
      String str = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTop exception:");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    QFSLayerTabPart localQFSLayerTabPart = this.c;
    if (localQFSLayerTabPart != null) {
      localQFSLayerTabPart.b(true);
    }
  }
  
  public void a(IQFSTabFragmentIoc paramIQFSTabFragmentIoc)
  {
    this.d = paramIQFSTabFragmentIoc;
  }
  
  public void a(Boolean paramBoolean)
  {
    u().q().setRefreshEnable(paramBoolean.booleanValue());
  }
  
  public void bm_()
  {
    QLog.d(b(), 1, "refreshData");
    QFSLayerTabPart localQFSLayerTabPart = this.c;
    if (localQFSLayerTabPart != null) {
      localQFSLayerTabPart.a(false, false);
    }
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.c = new QFSLayerTabPart(this.u);
    this.c.a(this.d);
    this.c.c(this.v);
    localArrayList.add(this.c);
    return localArrayList;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleFrameEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleFrameEvent)) {
      a((QCircleFrameEvent)paramSimpleBaseEvent);
    }
  }
  
  public QFSLayerTabPart u()
  {
    return this.c;
  }
  
  protected void x()
  {
    if ((System.currentTimeMillis() - this.e > 1000L) && (this.c != null))
    {
      M();
      this.e = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseLayerTabFragment
 * JD-Core Version:    0.7.0.1
 */