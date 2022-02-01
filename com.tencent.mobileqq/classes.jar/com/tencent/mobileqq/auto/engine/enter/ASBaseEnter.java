package com.tencent.mobileqq.auto.engine.enter;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.auto.engine.enter.impl.IASEnter;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.util.EventControlUtils;
import cooperation.qqcircle.report.ASEngineQualityReport;
import cooperation.qqcircle.report.ASEngineQualityReport.ReportData;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public abstract class ASBaseEnter
  implements SimpleEventReceiver, IASEnter
{
  protected ASPluginBean a;
  protected ASPluginManager b;
  private boolean c;
  
  public ASBaseEnter(ASPluginBean paramASPluginBean)
  {
    this.a = paramASPluginBean;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void a(ASEngineEnterEvent paramASEngineEnterEvent)
  {
    if (!paramASEngineEnterEvent.getBusinessKey().equals(this.a.getBusinessKey())) {
      return;
    }
    if (this.c) {
      return;
    }
    if (paramASEngineEnterEvent.isSuccess())
    {
      this.c = true;
      ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.a.getBusinessKey()).setPluginVersion(this.a.getVersionCode()).setPluginType(this.a.getType()).setRetCode(paramASEngineEnterEvent.getResultCode()).setExt2(String.valueOf(paramASEngineEnterEvent.hasPreload())).setEventId("autoshadow_plugin_load_result").setTimeCost(paramASEngineEnterEvent.getLoadCostTime()));
      String str = ASDynamicEngine.a(this.a.getBusinessKey());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSuccess event:");
      localStringBuilder.append(paramASEngineEnterEvent);
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  private void d(ASEnterBean paramASEnterBean)
  {
    if (this.b == null) {
      this.b = new ASPluginManager(this.a);
    }
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.a.getBusinessKey()).setPluginVersion(this.a.getVersionCode()).setPluginType(this.a.getType()).setEventId("autoshadow_plugin_enter"));
    this.b.a(paramASEnterBean);
  }
  
  private void e(ASEnterBean paramASEnterBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ASDynamicEngine_");
    localStringBuilder.append(paramASEnterBean.getBusinessKey());
    QLog.d(localStringBuilder.toString(), 1, "plugin not load");
    paramASEnterBean = new Intent();
    paramASEnterBean.addFlags(268435456);
    paramASEnterBean.setClass(MobileQQ.getContext(), QPublicTransFragmentActivity.class);
    paramASEnterBean.putExtra("public_fragment_class", b());
    paramASEnterBean.putExtra("public_fragment_window_feature", 1);
    BaseApplication.getContext().startActivity(paramASEnterBean);
  }
  
  protected abstract String a(String paramString, HashMap<String, String> paramHashMap);
  
  public void a(ASEnterBean paramASEnterBean)
  {
    if (paramASEnterBean == null)
    {
      QLog.d("ASDynamicEngine", 1, "enterBean is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSEngineEnter ");
    localStringBuilder.append(paramASEnterBean.getBusinessKey());
    if (!EventControlUtils.a(localStringBuilder.toString(), 1000L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ASDynamicEngine_");
      localStringBuilder.append(paramASEnterBean.getBusinessKey());
      QLog.d(localStringBuilder.toString(), 1, "FSPluginEngineEnter interval 1000");
      return;
    }
    if (a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ASDynamicEngine_");
      localStringBuilder.append(paramASEnterBean.getBusinessKey());
      QLog.d(localStringBuilder.toString(), 1, "enterMainProcess");
      a_(paramASEnterBean);
      return;
    }
    c(paramASEnterBean);
  }
  
  protected boolean a()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  protected void a_(ASEnterBean paramASEnterBean)
  {
    if (!ASDynamicEngineFactory.a(paramASEnterBean.getBusinessKey()).j())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ASDynamicEngine_");
      localStringBuilder.append(paramASEnterBean.getBusinessKey());
      QLog.d(localStringBuilder.toString(), 1, "FSPluginEngineEnter hasNeverEnter plugin enterLoading page");
      e(paramASEnterBean);
      paramASEnterBean.setLoadAction(1002);
    }
    paramASEnterBean.setLoadAction(1001);
    paramASEnterBean.setStartTime(System.currentTimeMillis());
    d(paramASEnterBean);
  }
  
  protected abstract String b();
  
  protected void c(ASEnterBean paramASEnterBean)
  {
    if (TextUtils.isEmpty(paramASEnterBean.getSchemeAction())) {
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), ((IJumpApi)QRoute.api(IJumpApi.class)).getJumpActivityClass());
    localIntent.setData(Uri.parse(a(paramASEnterBean.getSchemeAction(), paramASEnterBean.getAttrs())));
    localIntent.addFlags(268435456);
    BaseApplication.getContext().startActivity(localIntent);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ASEngineEnterEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ASEngineEnterEvent)) {
      a((ASEngineEnterEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.ASBaseEnter
 * JD-Core Version:    0.7.0.1
 */