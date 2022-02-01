package com.tencent.biz.qqcircle.fragments.main.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.requests.QCircleTabPopUpGetRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabPopUpSetRequest;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import qqcircle.QQCircleSwitch.GetCirclePopupSwitchRsp;
import qqcircle.QQCircleSwitch.StPopup;

public class QCircleMainTabTipPart
  extends Part
  implements View.OnClickListener
{
  private static final String a = QCircleConfigHelper.a("qqcircle", "qqcircle_show_main_tab_tips_time", "8");
  private static final String b = QCircleConfigHelper.a("qqcircle", "qqcircle_hintbar_hide_interval", "0");
  private boolean c = false;
  private String d = "";
  private String e = "";
  private boolean f;
  private boolean g;
  private ViewStub h;
  private ImageView i;
  private TextView j;
  private TextView k;
  private View l;
  private View m;
  
  private void a(String paramString)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleTabPopUpSetRequest(paramString), new QCircleMainTabTipPart.3(this, paramString));
  }
  
  private void a(QQCircleSwitch.GetCirclePopupSwitchRsp paramGetCirclePopupSwitchRsp, BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong)
  {
    if (paramGetCirclePopupSwitchRsp == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleTabPopUpGetRequest traceId: ");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" retCode: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" rspEnable:");
    localStringBuilder.append(paramGetCirclePopupSwitchRsp.enable.get());
    QLog.d("QCircleMainTabTipPart", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (paramLong != 0L) {
        return;
      }
      if ("1".equals(paramGetCirclePopupSwitchRsp.enable.get()))
      {
        this.d = paramGetCirclePopupSwitchRsp.popup.title.get();
        this.e = paramGetCirclePopupSwitchRsp.popup.tips.get();
        if (this.f)
        {
          e();
          return;
        }
        this.c = true;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    int n;
    try
    {
      n = Integer.parseInt(a);
      break label21;
      n = Integer.parseInt(b);
      label21:
      n *= 1000;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      n = 0;
    }
    if ((n == 0) && (!paramBoolean)) {
      return;
    }
    G().postDelayed(new QCircleMainTabTipPart.1(this, paramBoolean), n);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      float f1 = ViewUtils.a(48.0F);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(((FrameLayout.LayoutParams)localObject).topMargin + f1));
        } else {
          ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(((FrameLayout.LayoutParams)localObject).topMargin - f1));
        }
        this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void d()
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleTabPopUpGetRequest(), new QCircleMainTabTipPart.2(this));
  }
  
  private void e()
  {
    f();
    i();
    this.c = false;
    b(false);
  }
  
  private void f()
  {
    if (this.h != null) {
      return;
    }
    View localView = F();
    if (localView == null) {
      return;
    }
    this.h = ((ViewStub)localView.findViewById(2131441745));
    this.l = localView.findViewById(2131440979);
    this.m = this.h.inflate().findViewById(2131441747);
    this.j = ((TextView)this.m.findViewById(2131441748));
    this.i = ((ImageView)this.m.findViewById(2131441746));
    this.k = ((TextView)this.m.findViewById(2131441744));
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private void i()
  {
    if (this.m.getVisibility() == 8)
    {
      if (!TextUtils.isEmpty(this.e)) {
        this.j.setText(this.e);
      }
      this.m.setVisibility(0);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      this.m.startAnimation(localAlphaAnimation);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(1).setExt6("1"));
      c(true);
    }
  }
  
  private void l()
  {
    if (this.m.getVisibility() == 0)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.m.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setAnimationListener(new QCircleMainTabTipPart.4(this));
    }
  }
  
  private void m()
  {
    View localView = this.m;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      a("0");
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(4).setExt6("1"));
      QLog.i("QCircleMainTabTipPart", 1, "exit do noting");
    }
  }
  
  public String a()
  {
    return "QCircleMainTabTipPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(j(), paramView, E());
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    if (QCircleConfigHelper.a(HostDataTransUtils.isStudyMode())) {
      return;
    }
    b(true);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    G().removeCallbacksAndMessages(null);
    m();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.f = false;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.f = true;
    if (!this.c) {
      return;
    }
    e();
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    if ((this.g) && (QCircleConfigHelper.a(HostDataTransUtils.isStudyMode())))
    {
      if (c() == null) {
        return;
      }
      c().finish();
      paramActivity = new QCircleFrameEvent();
      paramActivity.mTriggerSelectedQCircleTab = true;
      SimpleEventBus.getInstance().dispatchEvent(paramActivity);
    }
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n == 2131441746)
    {
      a("0");
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(3).setExt6("1"));
    }
    else if ((n == 2131441744) || (n == 2131441748))
    {
      a("1");
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(2).setExt6("1"));
    }
    l();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.part.QCircleMainTabTipPart
 * JD-Core Version:    0.7.0.1
 */