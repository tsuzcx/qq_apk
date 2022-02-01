package com.tencent.biz.qqcircle.flutter.layer;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.bizparts.danmaku.QCircleAbsDanmakuPart;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

public class QCircleFlutterDanmakuLayer
  extends QCircleAbsDanmakuPart
{
  private FrameLayout a;
  
  public QCircleFlutterDanmakuLayer(Context paramContext)
  {
    this.a = new FrameLayout(paramContext);
    a(this.a);
  }
  
  public String a()
  {
    return "QCircleFlutterDanmakuView";
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    QCircleCommentInfo localQCircleCommentInfo = new QCircleCommentInfo();
    localQCircleCommentInfo.b = paramQCircleExtraTypeInfo.mFeed;
    localQCircleCommentInfo.c = paramQCircleExtraTypeInfo;
    paramQCircleExtraTypeInfo = new QCircleDanmakuEvent(11, localQCircleCommentInfo);
    SimpleEventBus.getInstance().dispatchEvent(paramQCircleExtraTypeInfo);
  }
  
  public Context g()
  {
    return QCircleSkinHelper.getInstance().getContext();
  }
  
  public void i()
  {
    QCircleDanmakuEvent localQCircleDanmakuEvent = new QCircleDanmakuEvent(2);
    SimpleEventBus.getInstance().dispatchEvent(localQCircleDanmakuEvent);
  }
  
  protected boolean r()
  {
    return false;
  }
  
  public FrameLayout s()
  {
    return this.a;
  }
  
  public void t()
  {
    QCircleDanmakuEvent localQCircleDanmakuEvent = new QCircleDanmakuEvent(5);
    SimpleEventBus.getInstance().dispatchEvent(localQCircleDanmakuEvent);
  }
  
  public void u()
  {
    QCircleDanmakuEvent localQCircleDanmakuEvent = new QCircleDanmakuEvent(6);
    SimpleEventBus.getInstance().dispatchEvent(localQCircleDanmakuEvent);
  }
  
  public void v()
  {
    QLog.d("QCircleFlutterDanmakuView", 2, "[handlerBackEvent] activity back...");
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterDanmakuLayer
 * JD-Core Version:    0.7.0.1
 */