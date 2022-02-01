package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.requests.QCircleTabPopUpGetRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabPopUpSetRequest;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.QCircleSplashUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.ArrayList;
import qqcircle.QQCircleSwitch.GetCirclePopupSwitchRsp;
import qqcircle.QQCircleSwitch.StPopup;

public class QFSMainTabTipPart
  extends QFSBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private boolean a = false;
  private String b = "";
  private String c = "";
  private boolean d;
  private boolean e;
  private ImageView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private Button j;
  private RoundCorneredRelativeLayout k;
  private View l;
  private PopupWindow m;
  private QCircleFolderBean n;
  
  private void a(QCircleFeedVideoControlEvent paramQCircleFeedVideoControlEvent)
  {
    if (!paramQCircleFeedVideoControlEvent.isPlay()) {
      return;
    }
    b(true);
    QLog.d("QFSMainTabTipPart", 1, "QCircleFeedVideoControlEvent received");
  }
  
  private void a(String paramString)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleTabPopUpSetRequest(paramString), new QFSMainTabTipPart.3(this, paramString));
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
    QLog.d("QFSMainTabTipPart", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (paramLong != 0L) {
        return;
      }
      if ("1".equals(paramGetCirclePopupSwitchRsp.enable.get()))
      {
        this.b = paramGetCirclePopupSwitchRsp.popup.title.get();
        this.c = paramGetCirclePopupSwitchRsp.popup.subtitle.get();
        if (this.d)
        {
          e();
          return;
        }
        this.a = true;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = QCircleConfigHelper.k();
    G().postDelayed(new QFSMainTabTipPart.1(this, paramBoolean), i1);
  }
  
  private void d()
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleTabPopUpGetRequest(), new QFSMainTabTipPart.2(this));
  }
  
  private void e()
  {
    if (F() == null) {
      return;
    }
    this.l = LayoutInflater.from(g()).inflate(2131627146, null);
    this.h = ((TextView)this.l.findViewById(2131442017));
    if (!TextUtils.isEmpty(this.b)) {
      this.h.setText(this.b);
    }
    this.i = ((TextView)this.l.findViewById(2131442018));
    if (!TextUtils.isEmpty(this.c)) {
      this.i.setText(this.c);
    }
    this.k = ((RoundCorneredRelativeLayout)this.l.findViewById(2131442016));
    this.k.setRadius(ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F), 0.0F, 0.0F);
    this.f = ((ImageView)this.l.findViewById(2131442014));
    this.g = ((ImageView)this.l.findViewById(2131433859));
    Object localObject = new Option().setUrl("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8811/popup/qvideo_noskin_popup_bg_card.png").setTargetView(this.g).setPredecode(true).setRequestWidth(ViewUtils.dpToPx(352.0F)).setRequestHeight(ViewUtils.dpToPx(181.0F));
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
    this.j = ((Button)this.l.findViewById(2131433860));
    this.f.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.m = new PopupWindow(this.l, -1, -1, true);
    localObject = LayoutInflater.from(g()).inflate(2131627125, null);
    this.m.showAtLocation((View)localObject, 80, 0, 0);
    QLog.d("QFSMainTabTipPart", 1, "mPopWindow show!");
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(1).setExt6("2"));
  }
  
  private void f()
  {
    View localView = this.l;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      a("0");
      QLog.i("QFSMainTabTipPart", 1, "exit do noting");
    }
  }
  
  public String a()
  {
    return "QFSMainTabTipPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(m(), paramView, E());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedVideoControlEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    if (QCircleConfigHelper.a(HostDataTransUtils.isStudyMode())) {
      return;
    }
    this.n = ((QCircleFolderBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    if (!QCircleSplashUtils.a(this.n)) {
      b(true);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    G().removeCallbacksAndMessages(null);
    f();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.d = false;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.d = true;
    if (this.a) {
      e();
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    if ((this.e) && (QCircleConfigHelper.a(HostDataTransUtils.isStudyMode())))
    {
      if (c() == null) {
        return;
      }
      if (QCircleHostGlobalInfo.getByShareOpenQCircle())
      {
        QCircleHostGlobalInfo.setByShareOpenQCircle(false);
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
    int i1 = paramView.getId();
    if (i1 == 2131442014)
    {
      a("0");
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(3).setExt6("2"));
    }
    else if (i1 == 2131433860)
    {
      a("1");
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(2).setExt6("2"));
    }
    this.m.dismiss();
    QLog.d("QFSMainTabTipPart", 1, "mPopWindow is closed!");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedVideoControlEvent)) {
      a((QCircleFeedVideoControlEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart
 * JD-Core Version:    0.7.0.1
 */