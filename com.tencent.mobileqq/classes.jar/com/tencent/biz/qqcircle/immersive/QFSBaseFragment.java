package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleTransActivityLifeEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;

public abstract class QFSBaseFragment
  extends QCircleBaseFragment
  implements SimpleEventReceiver
{
  private void a(@NonNull QCircleTransActivityLifeEvent paramQCircleTransActivityLifeEvent)
  {
    QLog.d("QFSBaseFragment", 1, new Object[] { "[handleFlutterPageEvent] event isPageOpenFlag: ", Integer.valueOf(paramQCircleTransActivityLifeEvent.getLifeEvent()) });
    int i = paramQCircleTransActivityLifeEvent.getLifeEvent();
    if (i == 0)
    {
      onStop();
      return;
    }
    if (i == 1) {
      onStart();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->doOnCreateView");
    QLog.d(str, 1, localStringBuilder.toString());
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected boolean bh_()
  {
    return true;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleTransActivityLifeEvent.class);
    return localArrayList;
  }
  
  public void m()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onBackPressed");
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public QCircleReportBean n()
  {
    Object localObject = super.getViewTagData();
    if (!(localObject instanceof QCircleReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("QFSBaseFragment", 1, "getReportBean but QCircleReportBean is null");
        return new QCircleReportBean().setPageId(a());
      }
      QLog.e("QFSBaseFragment", 1, "getReportBean but QCircleReportBean is null , debug");
      throw new RuntimeException("getReportBean but QCircleReportBean is null");
    }
    return (QCircleReportBean)localObject;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onAttach");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onDestroy");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onDetach()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onDetach");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onDetach();
  }
  
  public void onPause()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onPause");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleTransActivityLifeEvent)) {
      a((QCircleTransActivityLifeEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onResume");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onResume();
  }
  
  public void onStop()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onStop");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onStop();
  }
  
  protected boolean q()
  {
    return false;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->setUserVisibleHint:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    super.setUserVisibleHint(paramBoolean);
    RFThreadManager.getUIHandler().postDelayed(new QFSBaseFragment.1(this), 200L);
  }
  
  protected boolean v()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSBaseFragment
 * JD-Core Version:    0.7.0.1
 */