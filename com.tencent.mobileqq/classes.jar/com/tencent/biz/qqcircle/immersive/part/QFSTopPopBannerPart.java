package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.api.IDataManager;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.mobileqq.winkpublish.event.PopBannerEvent;
import com.tencent.mobileqq.winkpublish.event.WinkDraftStatusEvent;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QFSTopPopBannerPart
  extends QFSBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private boolean a;
  private String b;
  private String c;
  private String d;
  private String e;
  private long f;
  private View g;
  private RoundCornerImageView h;
  private TextView i;
  private Button j;
  private Button k;
  private FeedCloudMeta.StUser l;
  
  public QFSTopPopBannerPart(FeedCloudMeta.StUser paramStUser)
  {
    this.l = paramStUser;
  }
  
  private void a(PopBannerEvent paramPopBannerEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSTopPopBannerPart", 1, new Object[] { "handlePopBannerEvent: event.getCurTab: ", Integer.valueOf(paramPopBannerEvent.getCurTab()) });
    }
    WinkDraftStatusEvent localWinkDraftStatusEvent = new WinkDraftStatusEvent(paramPopBannerEvent.getMissionId());
    localWinkDraftStatusEvent.setToastStatus(2);
    SimpleEventBus.getInstance().dispatchEvent(localWinkDraftStatusEvent);
    if ((paramPopBannerEvent.getCurTab() == 1) && (paramPopBannerEvent.isSuccess()))
    {
      f();
      return;
    }
    this.a = paramPopBannerEvent.isSuccess();
    this.b = paramPopBannerEvent.getMissionId();
    this.e = paramPopBannerEvent.getClientKey();
    this.c = paramPopBannerEvent.getCoverUrl();
    this.d = paramPopBannerEvent.getFeedId();
    this.f = paramPopBannerEvent.getCreateTime();
    a(this.a, this.c);
  }
  
  private void a(WinkDraftStatusEvent paramWinkDraftStatusEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSTopPopBannerPart", 1, new Object[] { "[handleDraftEvent] event: ", paramWinkDraftStatusEvent });
    }
    String str = paramWinkDraftStatusEvent.getMissionId();
    if (paramWinkDraftStatusEvent.getUploadStatus() != -1) {
      ((IDataManager)QRoute.api(IDataManager.class)).updateUploadStatus(HostDataTransUtils.getLongAccountUin(), str, paramWinkDraftStatusEvent.getUploadStatus());
    }
    if (paramWinkDraftStatusEvent.getToastStatus() != -1) {
      ((IDataManager)QRoute.api(IDataManager.class)).updateToastStatus(HostDataTransUtils.getLongAccountUin(), str, paramWinkDraftStatusEvent.getToastStatus());
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleLayerBean.setFeed(paramStFeed);
    localQCircleLayerBean.setTransInitBean(localQCircleInitBean);
    localQCircleLayerBean.setSingleFeed(true);
    QCircleLauncher.a(g(), localQCircleLayerBean);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    b(paramString);
    paramString = this.j;
    int m;
    if (paramBoolean) {
      m = 8;
    } else {
      m = 0;
    }
    paramString.setVisibility(m);
    if (paramBoolean) {
      paramString = this.i.getResources().getString(2131895930);
    } else {
      paramString = this.i.getResources().getString(2131895929);
    }
    a(paramString);
    e();
  }
  
  private void b(View paramView)
  {
    VideoReport.setElementId(paramView, "em_xsj_publish_success");
    VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSTopPopBannerPart", 1, new Object[] { "[setLocalCover] localCoverUrl: ", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Option localOption = new Option();
    localOption.setUrl(paramString).setTargetView(this.h).setPredecode(true).setRequestWidth(ViewUtils.dip2px(44.0F)).setRequestHeight(ViewUtils.dip2px(60.0F));
    QCircleFeedPicLoader.g().loadImage(localOption, new QFSTopPopBannerPart.1(this));
  }
  
  private void d(View paramView)
  {
    VideoReport.setElementId(paramView, "em_xsj_publish_fail");
    VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
  }
  
  private void n()
  {
    if ((this.a) && (!TextUtils.isEmpty(this.d)))
    {
      q();
      return;
    }
    r();
  }
  
  private void o()
  {
    if (this.a) {
      p();
    }
  }
  
  private void p()
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetFeedDetailRequest(this.d, HostDataTransUtils.getAccount(), this.f, true), new QFSTopPopBannerPart.3(this));
  }
  
  private void q()
  {
    Object localObject = new QCircleLayerBean();
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(this.d);
    localStFeed.createTime.set(this.f);
    localStFeed.poster.set(this.l);
    ((QCircleLayerBean)localObject).setFeed(localStFeed);
    QCircleLauncher.a(g(), (QCircleInitBean)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[gotoDetailPage] feedId: ");
    ((StringBuilder)localObject).append(this.d);
    QLog.d("QFSTopPopBannerPart", 1, ((StringBuilder)localObject).toString());
  }
  
  private void r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reTryPublish] clientKey: ");
    localStringBuilder.append(this.e);
    QLog.d("QFSTopPopBannerPart", 1, localStringBuilder.toString());
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).restoreAndResumeTask(this.e);
    ((IDataManager)QRoute.api(IDataManager.class)).updateToastStatus(HostDataTransUtils.getLongAccountUin(), this.b, -1);
  }
  
  private void s()
  {
    Object localObject = ((IDataManager)QRoute.api(IDataManager.class)).getLastData(HostDataTransUtils.getLongAccountUin());
    if (!(localObject instanceof DraftBean)) {
      return;
    }
    localObject = (DraftBean)localObject;
    int m = ((DraftBean)localObject).getUploadStatus();
    int n = ((DraftBean)localObject).getToastStatus();
    if (QLog.isColorLevel()) {
      QLog.d("QFSTopPopBannerPart", 1, new Object[] { "[checkExceptionMission] missionId: ", ((DraftBean)localObject).getMissionId(), ", uploadStatus: ", Integer.valueOf(m), ", toastStatus: ", Integer.valueOf(n) });
    }
    if (((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).hasRunningTask())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFSTopPopBannerPart", 1, "[checkExceptionMission] has task running.");
      }
      return;
    }
    if (((m == 1) || (m == 2) || (m == 3)) && (n != 2))
    {
      this.e = ((DraftBean)localObject).getClientKey();
      a(false, ((DraftBean)localObject).getCoverUrl());
      ((IDataManager)QRoute.api(IDataManager.class)).updateToastStatus(HostDataTransUtils.getLongAccountUin(), ((DraftBean)localObject).getMissionId(), 2);
    }
  }
  
  public String a()
  {
    return "QFSTopPopBannerPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.g = paramView.findViewById(2131442028);
    this.h = ((RoundCornerImageView)paramView.findViewById(2131442030));
    this.i = ((TextView)paramView.findViewById(2131442031));
    this.j = ((Button)paramView.findViewById(2131442032));
    this.k = ((Button)paramView.findViewById(2131442029));
    this.h.setCorner(ViewUtils.dip2px(8.0F));
    this.h.setBorder(true);
    this.h.setColor(872415231);
    this.h.setBorderWidth(ViewUtils.dpToPx(1.0F));
    d();
    s();
    b(this.g);
    d(this.j);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.i.setText(paramString);
    }
  }
  
  public void d()
  {
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  public void e()
  {
    View localView = this.g;
    if (localView != null)
    {
      localView.setVisibility(0);
      RFThreadManager.getUIHandler().postDelayed(new QFSTopPopBannerPart.2(this), 6000L);
    }
  }
  
  public void f()
  {
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PopBannerEvent.class);
    localArrayList.add(WinkDraftStatusEvent.class);
    return localArrayList;
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
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442032) {
      n();
    } else if (paramView.getId() == 2131442028) {
      o();
    }
    f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof PopBannerEvent))
    {
      a((PopBannerEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof WinkDraftStatusEvent)) {
      a((WinkDraftStatusEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart
 * JD-Core Version:    0.7.0.1
 */