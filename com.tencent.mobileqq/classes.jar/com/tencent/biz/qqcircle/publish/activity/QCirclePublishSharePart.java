package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleShareViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;

public class QCirclePublishSharePart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  public boolean a;
  private LinearLayout c;
  private CheckBox d;
  private QCircleShareViewModel e;
  
  private void i()
  {
    this.a = QCirclePluginConfig.a().z();
    QCircleShareViewModel localQCircleShareViewModel = this.e;
    boolean bool = this.a;
    localQCircleShareViewModel.b = bool;
    this.d.setChecked(bool);
  }
  
  private void l()
  {
    if (this.e == null) {
      this.e = ((QCircleShareViewModel)a(QCircleShareViewModel.class));
    }
    this.e.a.observe(j(), new QCirclePublishSharePart.1(this));
  }
  
  public String a()
  {
    return "[QcirclePublish]QCirclePublishSharePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    boolean bool = QCircleConfigHelper.a("qqcircle", "QcirclePublishEnableSyncQzone", Boolean.valueOf(false)).booleanValue();
    QLog.d("[QcirclePublish]QCirclePublishSharePart", 1, new Object[] { "enableSyncQzone:", Boolean.valueOf(bool) });
    Object localObject = paramView.findViewById(2131441887);
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    this.c = ((LinearLayout)paramView.findViewById(2131441889));
    this.c.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable1 = QCircleSkinHelper.getInstance().getDrawable(2130845342);
    Drawable localDrawable2 = QCircleSkinHelper.getInstance().getDrawable(2130845341);
    ((StateListDrawable)localObject).addState(new int[] { 16842912 }, localDrawable2);
    ((StateListDrawable)localObject).addState(new int[] { -16842912 }, localDrawable1);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable1);
    this.d = ((CheckBox)paramView.findViewById(2131441888));
    this.d.setOnClickListener(this);
    this.d.setBackgroundDrawable((Drawable)localObject);
    this.d.setGravity(16);
    l();
    i();
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131441889) || (i == 2131441888)) {
      this.e.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishSharePart
 * JD-Core Version:    0.7.0.1
 */