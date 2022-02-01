package com.tencent.biz.qqcircle.share.operation;

import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleBarrageOperation
  extends QCircleBaseShareOperation
{
  public QCircleBarrageOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      QLog.d("QCircleBarrageShare", 1, new Object[] { "switchBarrage isBarrageOpen: ", Boolean.valueOf(r()) });
      int i;
      if (r()) {
        i = 10;
      } else {
        i = 9;
      }
      Object localObject = new QCircleDanmakuEvent(i);
      ((QCircleDanmakuEvent)localObject).feedId = f().b.id.get();
      SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
      QCircleSwitchConfigManager.a().a(r() ^ true);
      if (r()) {
        localObject = "close_bullet_screen";
      } else {
        localObject = "open_bullet_screen";
      }
      a((String)localObject, null);
      return;
    }
    a("QCircleBarrageShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleBarrageOperation
 * JD-Core Version:    0.7.0.1
 */