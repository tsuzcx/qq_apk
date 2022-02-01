package com.tencent.biz.qqcircle.fragments.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleMessageNoticeBubbleBlock;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.bizparts.QCircleTopAuthPart;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedListRefreshEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.events.QCircleMessageNoticeEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleCounter.SmallRedPointInfoExt;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;

public class QCircleFolderFollowTabFragment
  extends QCircleBaseTabFragment
{
  public static String B = "QCircleFolderFollowTabFragment";
  private QCircleTopAuthPart F;
  private boolean G;
  private QCircleFolderTabView H;
  
  public QCircleFolderFollowTabFragment(int paramInt)
  {
    super(paramInt);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.m == null) {
        return;
      }
      ArrayList localArrayList = this.m.getDataList();
      if (localArrayList == null) {
        return;
      }
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)localArrayList.get(i)).b();
        if ((paramString.equals(localStFeed.poster.id.get())) && (this.n != null))
        {
          this.n.c(localStFeed.id.get());
          return;
        }
        i -= 1;
      }
    }
  }
  
  private void aj()
  {
    QCirclePluginInitHelper.preloadQZoneProcess();
    QCirclePluginInitHelper.preloadToolProgress();
    QCirclePluginInitHelper.preloadPeakProcess(getContext());
    if ((this.m instanceof QCircleInsFeedAdapter)) {
      ((QCircleInsFeedAdapter)this.m).e();
    }
    QCirclePluginInitHelper.getInstance().preloadHippy();
  }
  
  private void ak()
  {
    if (!bg_())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleEeveeRedPoint_");
      localStringBuilder.append(B);
      QLog.d(localStringBuilder.toString(), 1, "[clearLocalRedPoint] return. isRealVisibleToUser = false");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleEeveeRedPoint_");
    localStringBuilder.append(B);
    QLog.d(localStringBuilder.toString(), 1, "[clearLocalRedPoint]");
    RFThreadManager.execute(new QCircleFolderFollowTabFragment.2(this));
  }
  
  private void al()
  {
    if (!bg_())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleEeveeRedPoint_");
      localStringBuilder.append(B);
      QLog.d(localStringBuilder.toString(), 1, "[sendClearOuterEntranceRedPointRequest] return. isRealVisibleToUser = false");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleEeveeRedPoint_");
    localStringBuilder.append(B);
    QLog.d(localStringBuilder.toString(), 1, "[sendClearOuterEntranceRedPointRequest] ");
    RFThreadManager.execute(new QCircleFolderFollowTabFragment.4(this));
  }
  
  private void b(long paramLong)
  {
    if (!bg_())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleEeveeRedPoint_");
      localStringBuilder.append(B);
      QLog.d(localStringBuilder.toString(), 1, "[sendClearFollowTabRedPointRequest] return. isRealVisibleToUser = false");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleEeveeRedPoint_");
    localStringBuilder.append(B);
    QLog.d(localStringBuilder.toString(), 1, "[sendClearFollowTabRedPointRequest]");
    RFThreadManager.execute(new QCircleFolderFollowTabFragment.3(this, paramLong));
  }
  
  protected int A()
  {
    return 1;
  }
  
  protected List<MultiViewBlock> B()
  {
    ArrayList localArrayList = new ArrayList();
    this.x = new QCircleMessageNoticeBubbleBlock(new Bundle());
    this.x.a(this.t);
    this.x.a(n());
    localArrayList.add(this.x);
    return localArrayList;
  }
  
  protected void J()
  {
    super.J();
  }
  
  protected void K()
  {
    super.K();
    ak();
    al();
    if (bg_())
    {
      long l1 = EeveeRedpointUtil.getFollowTabFeedListLastPreRspTimestamp();
      long l2 = EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp();
      if (l1 > l2) {
        b(l1);
      }
      String str = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setUserVisibleHint] followTabFeedListLastPreRspTimestamp: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", followTabFeedListLastRspTimestamp: ");
      localStringBuilder.append(l2);
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  public String N()
  {
    return d;
  }
  
  public void O()
  {
    if (bg_())
    {
      ab();
      return;
    }
    ae();
    ad();
  }
  
  protected void T()
  {
    super.T();
    ad();
  }
  
  protected void Z()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      Object localObject = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      int i = ((QCircleFolderBean)localObject).getQQCircleUnreadRedNum();
      boolean bool2 = false;
      if (i > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.t = bool1;
      if (this.t)
      {
        if (((QCircleFolderBean)localObject).getQQCircleUnreadRedNum() > EeveeRedpointUtil.getFolderMessageNoticeBubbleLastExposeNum()) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.u = bool1;
      }
      this.A = ((QCircleFolderBean)localObject).getRedDotTransInfo();
      ae();
      boolean bool1 = bool2;
      if (!this.v)
      {
        bool1 = bool2;
        if (!this.u) {
          bool1 = true;
        }
      }
      this.s = bool1;
      localObject = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableMemCache:");
      localStringBuilder.append(this.s);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = this.H;
    if (localObject != null) {
      ((QCircleFolderTabView)localObject).a(false);
    }
    long l1 = EeveeRedpointUtil.getFollowTabFeedListLastPreRspTimestamp();
    long l2 = EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp();
    if (l1 > l2) {
      b(l1);
    }
    if (!TextUtils.isEmpty(y()))
    {
      W();
      QLog.d(B, 1, "need showRefreshUpdateTips");
    }
    localObject = B;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPageSelected] followTabFeedListLastPreRspTimestamp: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", followTabFeedListLastRspTimestamp: ");
    localStringBuilder.append(l2);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    super.a(paramUIStateData);
    if ((paramUIStateData != null) && (!paramUIStateData.i()))
    {
      QLog.d(B, 1, "handleFeedDataRsp is refresh clearLocalRedPoint");
      ak();
    }
  }
  
  protected void a(List<Part> paramList)
  {
    super.a(paramList);
    this.F = new QCircleTopAuthPart();
    this.F.a(n());
    paramList.add(this.F);
  }
  
  public void ad()
  {
    if ((this.w) && (!aa()))
    {
      this.H = t();
      if (this.H != null)
      {
        if (!this.g)
        {
          this.w = false;
          this.H.b();
        }
        String str = B;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkNeedShowRedDot result:");
        localStringBuilder.append(this.g ^ true);
        QLog.d(str, 1, localStringBuilder.toString());
        return;
      }
      getMainHandler().postDelayed(new QCircleFolderFollowTabFragment.1(this), 100L);
    }
  }
  
  public void ae()
  {
    QQCircleCounter.RedPointInfo localRedPointInfo = QCircleHostRedPointHelper.getSmallRedPointInfotByAppid("circle_entrance");
    boolean bool = true;
    if (localRedPointInfo != null)
    {
      List localList = localRedPointInfo.rptRedInfo.get();
      if ((localList != null) && (localList.size() > 0))
      {
        this.z = new QQCircleFeedBase.StPageRedPointInfo();
        this.z.redType.set(localRedPointInfo.redType.get());
        this.z.setHasFlag(true);
        break label75;
      }
    }
    bool = false;
    label75:
    this.v = bool;
    this.w = this.v;
  }
  
  public String b()
  {
    return B;
  }
  
  protected String f()
  {
    return "pg_xsj_following_page";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    localArrayList.add(QCircleFeedListRefreshEvent.class);
    localArrayList.add(QCircleMessageNoticeEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    QCirclePluginInitHelper.cancelQzoneAlive();
    QCirclePluginInitHelper.cancelPeakAlive(getContext());
    super.onDestroy();
    com.tencent.mobileqq.qcircle.api.constant.QCircleConstants.a = false;
    QCircleFolderTabView localQCircleFolderTabView = this.H;
    if (localQCircleFolderTabView != null) {
      localQCircleFolderTabView.d();
    }
  }
  
  public void onDetach()
  {
    QLog.d(B, 1, "QCircleFolderFollowTabFragment->onDetach");
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    QCircleFolderTabView localQCircleFolderTabView = this.H;
    if (localQCircleFolderTabView != null) {
      localQCircleFolderTabView.e();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      paramSimpleBaseEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mState == 3)
      {
        if (this.n != null) {
          this.n.c(paramSimpleBaseEvent.mTargetId);
        }
      }
      else if (paramSimpleBaseEvent.mState == 6) {
        a(paramSimpleBaseEvent.mTargetId);
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent))
    {
      G();
      if (!this.G)
      {
        aj();
        this.G = true;
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCircleFeedListRefreshEvent))
    {
      if (((QCircleFeedListRefreshEvent)paramSimpleBaseEvent).mPageType == 1) {
        b(false);
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCircleMessageNoticeEvent))
    {
      a(((QCircleMessageNoticeEvent)paramSimpleBaseEvent).mMessageNoticeInfo);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(1));
    }
  }
  
  protected boolean x()
  {
    return z() ^ true;
  }
  
  protected String y()
  {
    QQCircleCounter.RedPointInfo localRedPointInfo = QCircleHostRedPointHelper.getSmallRedPointInfotByAppid("circle_entrance");
    if ((localRedPointInfo != null) && (localRedPointInfo.smallRedInfoExt.has()))
    {
      String str = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadRefreshUpdateTips:");
      localStringBuilder.append(localRedPointInfo.smallRedInfoExt.unreadMsg.get());
      QLog.d(str, 2, localStringBuilder.toString());
      return localRedPointInfo.smallRedInfoExt.unreadMsg.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */