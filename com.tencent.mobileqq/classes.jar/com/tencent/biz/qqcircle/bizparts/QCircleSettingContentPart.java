package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleSpecialFollowListBlock;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;

public class QCircleSettingContentPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private boolean a;
  private boolean c;
  private TextView d;
  private final QCircleSpecialFollowManager e = QCircleSpecialFollowManager.a();
  private ImageView f;
  
  private void i()
  {
    int i = this.e.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateSpecialCareCnt: ");
    ((StringBuilder)localObject).append(i);
    QLog.i("QCircleSettingContentPart", 4, ((StringBuilder)localObject).toString());
    if (i == 0)
    {
      this.d.setText("");
      return;
    }
    if (i < 100)
    {
      localObject = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ((TextView)localObject).setText(localStringBuilder.toString());
      return;
    }
    this.d.setText("99+");
  }
  
  private String l()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_homepage_feedback_url", "https://mma.qq.com/feedback/index.html");
  }
  
  public String a()
  {
    return "QCircleSettingContentPart";
  }
  
  public void a(View paramView)
  {
    QCircleSettingBean localQCircleSettingBean = (QCircleSettingBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    this.a = localQCircleSettingBean.canJumpProfile();
    this.c = localQCircleSettingBean.canSyncTroopARK();
    paramView.findViewById(2131441871).setOnClickListener(this);
    paramView.findViewById(2131441876).setOnClickListener(this);
    this.f = ((ImageView)paramView.findViewById(2131436618));
    this.f.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.f);
    }
    paramView.findViewById(2131441875).setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131441877));
    paramView.findViewById(2131441655).setOnClickListener(this);
    i();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleGoToCardSettingEvent.class);
    localArrayList.add(QCircleSpecialFollowUpdateEvent.class);
    localArrayList.add(QCircleSpecialFollowListLoadEvent.class);
    localArrayList.add(QCircleSyncToTroopSettingEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    QLog.i("QCircleSettingContentPart", 4, "onActivityCreated");
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    QLog.i("QCircleSettingContentPart", 4, "onActivityDestroyed");
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131441871)
    {
      localObject = new QCircleSettingBean();
      ((QCircleSettingBean)localObject).setCanJumpProfile(this.a);
      ((QCircleSettingBean)localObject).setCanSyncTroopARK(this.c);
      ((QCircleSettingBean)localObject).setFromReportBean(d().clone());
      QCircleLauncher.b(paramView.getContext(), (QCircleSettingBean)localObject);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(22).setThrActionType(2));
    }
    else if (i == 2131436618)
    {
      if ((!j().onBackEvent()) && (c() != null)) {
        c().finish();
      }
    }
    else if (i == 2131441876)
    {
      localObject = new QCircleInitBean();
      ((QCircleInitBean)localObject).setFromReportBean(d().clone());
      QCircleLauncher.d(paramView.getContext(), (QCircleInitBean)localObject);
    }
    else if (i == 2131441875)
    {
      localObject = new QCircleFollowUserBean();
      ((QCircleFollowUserBean)localObject).setFromReportBean(d());
      ((QCircleFollowUserBean)localObject).setAdapterClassName(QCircleSpecialFollowListBlock.class.getName());
      QCircleLauncher.a(g(), (QCircleFollowUserBean)localObject);
    }
    else if (i == 2131441655)
    {
      QCircleLauncher.a(g(), l(), null, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleGoToCardSettingEvent))
    {
      this.a = ((QCircleGoToCardSettingEvent)paramSimpleBaseEvent).mShowCard;
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleSyncToTroopSettingEvent))
    {
      this.c = ((QCircleSyncToTroopSettingEvent)paramSimpleBaseEvent).mCanSyncTroopARK;
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent))
    {
      i();
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleSpecialFollowListLoadEvent)) {
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSettingContentPart
 * JD-Core Version:    0.7.0.1
 */