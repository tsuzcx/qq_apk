package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.qqcircle.events.QCircleMessageNoticeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSNoticeSwitchEvent;
import com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel;
import com.tencent.biz.qqcircle.widgets.QFSMessageNoticeView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.ArrayList;

public class QFSMessageNoticePart
  extends QFSBasePart
  implements SimpleEventReceiver
{
  private static boolean a = true;
  private static boolean b = false;
  private QFSMessageNoticeView c;
  private QCircleMessageNoticeViewModel d;
  
  private void a(@NonNull ASEngineTabStatusEvent paramASEngineTabStatusEvent)
  {
    if (!TextUtils.equals("qcircle-app", paramASEngineTabStatusEvent.getBusinessKey())) {
      return;
    }
    if (!paramASEngineTabStatusEvent.isSelected()) {
      return;
    }
    a = true;
    QLog.d("QFSMessageNoticePart", 1, new Object[] { "[handlerEngineTabStatusEvent] update open notice flag: ", Boolean.valueOf(a) });
  }
  
  private void b(boolean paramBoolean)
  {
    a = paramBoolean;
    QFSMessageNoticeView localQFSMessageNoticeView = this.c;
    if (localQFSMessageNoticeView != null)
    {
      if (a)
      {
        d();
        this.c.setVisibility(0);
        return;
      }
      localQFSMessageNoticeView.setVisibility(8);
    }
  }
  
  public static void e()
  {
    if (!a)
    {
      SimpleEventBus.getInstance().dispatchEvent(new QFSNoticeSwitchEvent(true));
      a = true;
    }
  }
  
  public static void f()
  {
    if (a)
    {
      SimpleEventBus.getInstance().dispatchEvent(new QFSNoticeSwitchEvent(false));
      a = false;
    }
  }
  
  public static void n()
  {
    a = true;
    b = false;
  }
  
  public static void o()
  {
    b = true;
  }
  
  public static void p()
  {
    if (b)
    {
      f();
      b = false;
    }
  }
  
  private void q()
  {
    this.d = ((QCircleMessageNoticeViewModel)a(QCircleMessageNoticeViewModel.class));
    this.d.a(m());
    a = true;
  }
  
  public String a()
  {
    return "QFSMessageNoticePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.c = ((QFSMessageNoticeView)paramView.findViewById(2131433855));
  }
  
  public void a(QCircleMessageNoticeInfo paramQCircleMessageNoticeInfo)
  {
    if (this.c == null) {
      return;
    }
    int i = 8;
    if ((paramQCircleMessageNoticeInfo != null) && (a))
    {
      boolean bool = paramQCircleMessageNoticeInfo.f();
      QFSMessageNoticeView localQFSMessageNoticeView = this.c;
      if (bool) {
        i = 0;
      }
      localQFSMessageNoticeView.setVisibility(i);
      if (!bool) {
        return;
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(18).setSubActionType(1));
      this.c.setMessageData(paramQCircleMessageNoticeInfo);
      this.c.a();
      return;
    }
    this.c.setVisibility(8);
  }
  
  protected void d()
  {
    QLog.d("QFSMessageNoticePart", 1, "customRefreshData");
    if (this.d != null)
    {
      QLog.d("QFSMessageNoticePart", 1, "mMessageNoticeViewModel pullLastestInfo");
      this.d.a(c());
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleMessageNoticeEvent.class);
    localArrayList.add(QFSNoticeSwitchEvent.class);
    localArrayList.add(ASEngineTabStatusEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    q();
    d();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    d();
    QLog.d("QFSMessageNoticePart", 1, "[onActivityResumed] activity pause...");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleMessageNoticeEvent))
    {
      a(((QCircleMessageNoticeEvent)paramSimpleBaseEvent).mMessageNoticeInfo);
      QLog.d("QFSMessageNoticePart", 1, "onReceiveEvent, QCircleMessageNoticeEvent");
      return;
    }
    if ((paramSimpleBaseEvent instanceof QFSNoticeSwitchEvent))
    {
      boolean bool = ((QFSNoticeSwitchEvent)paramSimpleBaseEvent).getNoticeSwitch();
      b(bool);
      paramSimpleBaseEvent = new StringBuilder();
      paramSimpleBaseEvent.append("onReceiveEvent, QFSNoticeSwitchEvent, switch = ");
      paramSimpleBaseEvent.append(bool);
      QLog.d("QFSMessageNoticePart", 1, paramSimpleBaseEvent.toString());
      return;
    }
    if ((paramSimpleBaseEvent instanceof ASEngineTabStatusEvent)) {
      a((ASEngineTabStatusEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMessageNoticePart
 * JD-Core Version:    0.7.0.1
 */