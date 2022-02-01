package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSFrameEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QFSSimpleTabFragment
  extends QFSBaseLayerTabFragment
{
  protected QFSSimpleTabFragment(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    super(paramQCircleTabInfo, paramInt);
  }
  
  private void a(QFSFrameEvent paramQFSFrameEvent)
  {
    int i = paramQFSFrameEvent.mRefreshTab;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {}
        }
        else
        {
          if (this.u.c() != 40) {
            return;
          }
          M();
        }
      }
      else
      {
        if (this.u.c() != 41) {
          return;
        }
        M();
        return;
      }
    }
    M();
  }
  
  public int a()
  {
    String str;
    if ((this.u != null) && (this.u.a != null)) {
      str = this.u.a.dtPgID.get();
    } else {
      str = "";
    }
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFSSimpleTabFragment");
    localStringBuilder.append(this.u.b());
    return localStringBuilder.toString();
  }
  
  protected int c()
  {
    return 2131627120;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList2 = super.getEventClass();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(QFSFrameEvent.class);
    return localArrayList1;
  }
  
  protected int j()
  {
    return 0;
  }
  
  public void onPause()
  {
    QLog.d(b(), 1, "fs_lifecycle onPause");
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QFSFrameEvent)) {
      a((QFSFrameEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    QLog.d(b(), 1, "fs_lifecycle onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSSimpleTabFragment
 * JD-Core Version:    0.7.0.1
 */