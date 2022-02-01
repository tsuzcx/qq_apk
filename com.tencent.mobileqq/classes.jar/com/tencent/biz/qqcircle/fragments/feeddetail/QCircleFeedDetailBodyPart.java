package com.tencent.biz.qqcircle.fragments.feeddetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.util.RFWCompactUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVisitor;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;

public class QCircleFeedDetailBodyPart
  extends QCircleBaseBlockPart
  implements SimpleEventReceiver
{
  private QCircleFeedDetailModel b;
  private QCircleInitBean e;
  private QCircleInsFeedAdapter f;
  private QCirclePolyLikeAniView g;
  private QCirclePolyLikeFrameLayout h;
  private View i;
  private int j = 0;
  private TextView k;
  private QCircleFullScreenStatusView l;
  private boolean m;
  private boolean n;
  
  public QCircleFeedDetailBodyPart(int paramInt)
  {
    super(paramInt, null, 1, 1);
  }
  
  private void a(ResponseBean paramResponseBean)
  {
    if (paramResponseBean != null)
    {
      if (this.m) {
        return;
      }
      if ((this.n) && (!a(paramResponseBean.a)))
      {
        this.m = false;
        return;
      }
      if (paramResponseBean.c == null)
      {
        c(paramResponseBean);
        this.m = true;
        return;
      }
      if (d(paramResponseBean))
      {
        c(paramResponseBean);
        this.m = true;
        return;
      }
      paramResponseBean = this.l;
      if (paramResponseBean != null) {
        paramResponseBean.c();
      }
      this.m = false;
    }
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if ((this.f != null) && (paramQCircleFeedEvent.mState == 3)) {
      c().finish();
    }
  }
  
  private boolean a(long paramLong)
  {
    return paramLong == 10014L;
  }
  
  private void b(View paramView)
  {
    this.g = ((QCirclePolyLikeAniView)paramView.findViewById(2131441777));
    this.i = paramView.findViewById(2131440940);
    this.k = ((TextView)paramView.findViewById(2131448446));
    d(paramView);
    if ((bd_() instanceof QCircleBaseFragment)) {
      bd_().a(this.i);
    }
    this.i.setOnClickListener(new QCircleFeedDetailBodyPart.2(this));
    be_().getRecyclerView().setTransDispatchDelegate(RFWCompactUtil.a());
    paramView = this.f;
    if ((paramView != null) && (paramView.g() != null) && (this.e != null))
    {
      this.f.g().c((int)this.e.getVideoCurrentPosition());
      this.f.d(this.e.getDataPosInList());
    }
  }
  
  private void b(ResponseBean paramResponseBean)
  {
    Object localObject;
    if ((paramResponseBean.c instanceof FeedCloudRead.StGetFeedDetailRsp))
    {
      localObject = new ArrayList();
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((FeedCloudRead.StGetFeedDetailRsp)paramResponseBean.c).feed.get();
      ((ArrayList)localObject).add(new FeedBlockData(localStFeed).c());
      QCircleCommentBusiness.a().a(localStFeed.id.get(), (ArrayList)localStFeed.vecComment.get());
      this.f.setDatas((List)localObject);
    }
    if ((paramResponseBean.c instanceof FeedCloudRead.StGetFeedListRsp))
    {
      localObject = (FeedCloudRead.StGetFeedListRsp)paramResponseBean.c;
      long l1 = paramResponseBean.a;
      boolean bool = false;
      int i1;
      if (l1 == 0L) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (!paramResponseBean.d)
        {
          paramResponseBean = new FeedCloudMeta.StFeed();
          paramResponseBean.dittoFeed.dittoId.set(-1);
          ((FeedCloudRead.StGetFeedListRsp)localObject).vecFeed.get().add(0, paramResponseBean);
        }
        this.f.addAll(QCircleTransFormHelper.a(((FeedCloudRead.StGetFeedListRsp)localObject).vecFeed.get()));
      }
      paramResponseBean = this.f;
      if ((paramResponseBean.getLoadInfo().a()) || (i1 == 0)) {
        bool = true;
      }
      paramResponseBean.notifyLoadingComplete(true, bool);
    }
  }
  
  private void c(ResponseBean paramResponseBean)
  {
    if (this.l != null)
    {
      if (a(paramResponseBean.a)) {
        this.l.a("");
      } else {
        this.l.b(paramResponseBean.b);
      }
      QLog.w("BlockPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramResponseBean.a), paramResponseBean.b }));
      this.f.clearData();
      this.f.notifyDataSetChanged();
    }
  }
  
  private void d(View paramView)
  {
    QCircleInitBean localQCircleInitBean = this.e;
    if (localQCircleInitBean != null)
    {
      if (localQCircleInitBean.getPolyLike() == null) {
        return;
      }
      paramView = ((ViewStub)paramView.findViewById(2131431109)).inflate();
      paramView.setVisibility(8);
      this.h = ((QCirclePolyLikeFrameLayout)paramView.findViewById(2131436665));
      this.h.setIsContentDetail(true);
      this.h.setAniView(this.g);
    }
  }
  
  private boolean d(ResponseBean paramResponseBean)
  {
    return (!paramResponseBean.d) && (paramResponseBean.a != 0L);
  }
  
  private void m()
  {
    String str1 = g().getResources().getString(2131895713);
    String str2 = g().getResources().getString(2131895712);
    if (be_() != null)
    {
      be_().getRecyclerView().addOnScrollListener(new QCircleFeedDetailBodyPart.1(this, str2, str1));
      be_().setEnableRefresh(this.e.isSingleFeed() ^ true);
    }
  }
  
  private void n()
  {
    QCircleInitBean localQCircleInitBean = this.e;
    if (localQCircleInitBean != null)
    {
      QCirclePolyLikeAniView localQCirclePolyLikeAniView = this.g;
      if ((localQCirclePolyLikeAniView != null) && (this.h != null)) {
        localQCirclePolyLikeAniView.a(localQCircleInitBean.getPolyLike(), this.h.getZanView(), this.h.getPolyEndView(), true, null, false);
      }
    }
  }
  
  private void o()
  {
    this.l = new QCircleFullScreenStatusView(g());
    this.l.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.l.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_feed"), QCircleConfigHelper.T(), QCircleConfigHelper.Q());
    this.l.setOnRetryClickListener(new QCircleFeedDetailBodyPart.3(this));
    be_().setStatusViewInterface(this.l);
  }
  
  private void p()
  {
    this.f = new QCircleInsFeedAdapter(new Bundle());
    Object localObject = new QCircleExtraTypeInfo();
    ((QCircleExtraTypeInfo)localObject).pageType = 69;
    ((QCircleExtraTypeInfo)localObject).mGlobalViewModelKey = String.valueOf(69);
    this.f.a((QCircleExtraTypeInfo)localObject);
    this.f.setInteractor(s());
    this.f.b(false);
    QCircleFeedDataCenter.a().a(String.valueOf(((QCircleExtraTypeInfo)localObject).mGlobalViewModelKey), this.b);
    QCircleInitBean localQCircleInitBean = this.e;
    if (localQCircleInitBean != null) {
      localQCircleInitBean.setExtraTypeInfo((QCircleExtraTypeInfo)localObject);
    }
    this.f.setOnLoadDataDelegate(new QCircleFeedDetailBodyPart.4(this));
    localObject = this.e;
    if ((localObject != null) && (((QCircleInitBean)localObject).getFeed() != null))
    {
      localObject = this.e.getFeed();
      ((FeedCloudMeta.StFeed)localObject).visitorInfo.viewDesc.set("");
      this.f.b((FeedCloudMeta.StFeed)localObject);
      this.n = true;
    }
    this.f.setReportBean(d());
    this.c.add(this.f);
  }
  
  private void q()
  {
    this.b.b().observe(bd_(), new QCircleFeedDetailBodyPart.5(this));
  }
  
  private QCircleInteractor s()
  {
    return new QCircleFeedDetailBodyPart.6(this);
  }
  
  public void a(View paramView)
  {
    this.b = ((QCircleFeedDetailModel)a(QCircleFeedDetailModel.class));
    if ((c() != null) && (c().getIntent() != null)) {
      this.e = ((QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    }
    p();
    super.a(paramView);
    b(paramView);
    n();
    o();
    m();
    q();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public boolean l()
  {
    QCircleInitBean localQCircleInitBean = this.e;
    return (localQCircleInitBean != null) && (localQCircleInitBean.isSingleFeed());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(54).setSubActionType(1).setThrActionType(1).setPageId(d().getPageId()).setfPageId(d().getFromPageId()));
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart
 * JD-Core Version:    0.7.0.1
 */