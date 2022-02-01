package com.tencent.biz.qqcircle.publish.outbox;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.publish.outbox.banner.NetStateCheckBanner;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import cooperation.qqcircle.utils.NetworkState;
import java.util.ArrayList;

public class QCirclePublishQueueNetStateBannerPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  NetStateCheckBanner a;
  
  public String a()
  {
    return "QcirclePublish]QCircleTitlePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((NetStateCheckBanner)paramView.findViewById(2131443229));
    this.a.getBannerTextView().setTextColor(g().getResources().getColor(2131167091));
    this.a.getBannerTextView().setText(2131892264);
    this.a.getView().setBackgroundResource(2130842412);
    this.a.getView().setMinimumHeight(ViewUtils.a(42.0F));
    this.a.setOnClickListener(new QCirclePublishQueueNetStateBannerPart.1(this));
    this.a.getBannerCloseButton().setImageResource(2130845198);
    if (!NetworkState.isNetSupport()) {
      this.a.setVisibility(0);
    }
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
  
  public void onClick(View paramView) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueueNetStateBannerPart
 * JD-Core Version:    0.7.0.1
 */