package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishKeyboardEvent;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;

public class QCircleTitlePart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  protected ActionSheet a;
  private QCirclePublishViewModel c;
  private ImageView d;
  private TextView e;
  private boolean f = false;
  
  private void l()
  {
    if (this.c == null) {
      this.c = ((QCirclePublishViewModel)a(QCirclePublishViewModel.class));
    }
    this.c.e.observe(j(), new QCircleTitlePart.1(this));
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleTitlePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.d = ((ImageView)paramView.findViewById(2131441719));
    this.e = ((TextView)paramView.findViewById(2131441820));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.e.setEnabled(false);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.d);
    }
    l();
  }
  
  public boolean ah_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.l);
    localStringBuilder.append("");
    QCirclePublishReport.a(15, 12, 0, localStringBuilder.toString(), "");
    if ((!this.c.f()) && (!this.c.e())) {
      return false;
    }
    if (!this.c.l())
    {
      i();
      return true;
    }
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public void i()
  {
    if (j().getActivity() == null) {
      return;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      return;
    }
    this.a = ActionSheet.a(g());
    if (this.c.f())
    {
      localObject = QCircleConfigHelper.a("QZoneTextSetting", "qcirclePublishVideoEditInProgressMessage", "视频合成中，是否确认退出?");
      QCircleCustomDialog.a(g(), (String)localObject, null, 2131887648, 2131887629, new QCircleTitlePart.2(this), new QCircleTitlePart.3(this)).show();
      return;
    }
    if (this.c.e())
    {
      this.a.a(2131895864);
      this.a.a(2131895860, 1);
      this.a.a(2131895867, 1);
    }
    this.a.e(2131887648);
    this.a.a(new QCircleTitlePart.4(this));
    if ((!c().isFinishing()) && (!this.a.isShowing())) {
      this.a.show();
    }
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
    if (i == 2131441719)
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishKeyboardEvent(false));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.l);
      localStringBuilder.append("");
      QCirclePublishReport.a(15, 12, 0, localStringBuilder.toString(), "");
      if ((!this.c.f()) && (!this.c.e()))
      {
        QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLIC_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.c.w), QCircleReportHelper.newEntry("ext1", "nothingSave"), QCircleReportHelper.newEntry("ret_code", "0") }));
        c().finish();
      }
      else
      {
        i();
      }
    }
    else if (i == 2131441820)
    {
      if (!this.c.j())
      {
        QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_CLICK_SEND_MOOD, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.c.w), QCircleReportHelper.newEntry("ret_code", "-80000008") }));
        QCircleToast.a(2131895837, 1);
      }
      else if (!this.f)
      {
        this.f = true;
        this.c.a(j());
        QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_CLICK_SEND_MOOD, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.c.w), QCircleReportHelper.newEntry("ret_code", "0") }));
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishKeyboardEvent(false));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleTitlePart
 * JD-Core Version:    0.7.0.1
 */