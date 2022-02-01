package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.events.QFSPushTenTimesEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBaseFeedPresenterEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoReplayEvent;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.manager.QFSFeedShareButtonManager;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.biz.qqcircle.immersive.utils.QFSShareInfoUtils;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushReportReqInterceptor;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCirclePushBubbleView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QFSFeedChildInteractPresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener, Observer<FeedBlockData>, SimpleEventReceiver
{
  private int A = 0;
  private QCircleInteractor B = new QFSFeedChildInteractPresenter.2(this);
  private final int i = 5;
  private View j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private ImageView o;
  private ImageView p;
  private QCircleRecommendImageView q;
  private QCircleRocketView r;
  private QCirclePushBubbleView s;
  private ImageView t;
  private TextView u;
  private QCircleAvatarView v;
  private QFSPlusFollowView w;
  private boolean x = false;
  private boolean y = false;
  private QFSFeedShareButtonManager z;
  
  private void a(int paramInt)
  {
    TextView localTextView = this.m;
    if ((localTextView != null) && (paramInt >= 0))
    {
      if (paramInt == 0)
      {
        localTextView.setText(2131895872);
        this.m.setTextSize(12.0F);
        return;
      }
      localTextView.setText(QFSCommonUtil.a(paramInt));
      this.m.setTextSize(13.0F);
      return;
    }
    QLog.d("QFSFeedChildInteractPresenter", 1, "[updatePushFeedDataText] mFeedPushText should not be null.");
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(f()).setfpageid(Integer.valueOf(h()).intValue()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QFSFeedChildInteractPresenter", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(View paramView, String paramString)
  {
    if ((this.h != null) && (this.h.b() != null) && (paramView != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      VideoReport.setElementId(paramView, paramString);
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.putAll(QCirclePluginReportUtil.a(this.h));
      localMap.put("xsj_feed_index", Integer.valueOf(this.d + 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.h.b().id.get());
      VideoReport.setElementReuseIdentifier(paramView, localStringBuilder.toString());
      VideoReport.setElementParams(this, localMap);
      VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
    }
  }
  
  private void a(View paramView, String paramString, Map<String, Object> paramMap)
  {
    if ((this.h != null) && (this.c != null) && (paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.putAll(QCirclePluginReportUtil.a(this.h));
      localMap.put("xsj_feed_index", Integer.valueOf(this.d + 1));
      localMap.put("xsj_target_qq", ((FeedCloudMeta.StFeed)this.c).poster.id.get());
      localMap.putAll(paramMap);
      VideoReport.reportEvent(paramString, paramView, localMap);
      return;
    }
    QLog.d("QFSFeedChildInteractPresenter", 1, "dtReportCustomReport : mFeedBlockData, mData, view or eventId is null. ");
  }
  
  private void a(QFSCommentSendEvent paramQFSCommentSendEvent)
  {
    if (!((FeedCloudMeta.StFeed)this.c).id.get().equals(paramQFSCommentSendEvent.mFeed.id.get())) {
      return;
    }
    n();
  }
  
  private void a(QFSPushTenTimesEvent paramQFSPushTenTimesEvent)
  {
    if (!((FeedCloudMeta.StFeed)this.c).id.get().equals(paramQFSPushTenTimesEvent.mFeed.id.get())) {
      return;
    }
    n();
  }
  
  private void a(QFSPicPositionChangeEvent paramQFSPicPositionChangeEvent)
  {
    if (((this.c instanceof FeedCloudMeta.StFeed)) && (TextUtils.equals(((FeedCloudMeta.StFeed)this.c).id.get(), paramQFSPicPositionChangeEvent.a()))) {
      this.A = paramQFSPicPositionChangeEvent.b();
    }
  }
  
  private void a(@NonNull QFSPlusFollowView paramQFSPlusFollowView)
  {
    paramQFSPlusFollowView.setItemReportListener(new QFSFeedChildInteractPresenter.1(this, paramQFSPlusFollowView));
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof QQCircleFeedBase.StFeedBusiReqData)) {
      a(((QQCircleFeedBase.StFeedBusiReqData)paramObject).pushList.totalClickCount.get());
    }
  }
  
  private void b(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    QFSPlusFollowView localQFSPlusFollowView = this.w;
    if (localQFSPlusFollowView == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[updateAuthorFollowView] author attention view not be null.");
      return;
    }
    localQFSPlusFollowView.setUserData((FeedCloudMeta.StUser)paramStFeed.poster.get(), paramStFeed);
  }
  
  private void c(View paramView)
  {
    if (QCircleConfigHelper.aq() == 0)
    {
      this.w = ((QFSPlusFollowView)paramView.findViewById(2131433356));
      this.w.setFollowedDismiss(true);
      a(this.w);
    }
  }
  
  private void c(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.k == null)
    {
      QLog.d("PL-QFSFeedChildInteractPresenter", 1, "[updateFeedLike] video like text should not be null.");
      return;
    }
    if (this.o == null)
    {
      QLog.d("PL-QFSFeedChildInteractPresenter", 1, "[updateFeedLike] mLikeImg should not be null.");
      return;
    }
    if (paramStFeed.likeInfo.count.get() == 0) {
      this.k.setText(2131895845);
    } else {
      this.k.setText(QFSCommonUtil.a(paramStFeed.likeInfo.count.get()));
    }
    boolean bool;
    if (paramStFeed.likeInfo.status.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.x = bool;
    QLog.d("PL-QFSFeedChildInteractPresenter", 1, new Object[] { "[updateFeedLike] is liked: ", Boolean.valueOf(this.x) });
    paramStFeed = this.o.getContext().getResources();
    int i1;
    if (this.x) {
      i1 = 2130845101;
    } else {
      i1 = 2130845100;
    }
    paramStFeed = paramStFeed.getDrawable(i1);
    this.o.setImageDrawable(paramStFeed);
  }
  
  private void d(View paramView)
  {
    this.m = ((TextView)paramView.findViewById(2131436511));
    this.q = ((QCircleRecommendImageView)paramView.findViewById(2131436387));
    this.q.setPageType(5);
    this.q.setEnableCancelPush(true);
    this.r = ((QCircleRocketView)paramView.findViewById(2131431107));
    this.s = ((QCirclePushBubbleView)paramView.findViewById(2131431106));
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    if (this.q != null)
    {
      if (QCirclePluginUtil.d(paramStFeed.poster.id.get())) {
        this.q.setVisibility(8);
      } else {
        this.q.setVisibility(0);
      }
      this.q.setFeedData(new FeedBlockData(paramStFeed), 5);
      localObject = new QCirclePushReportReqInterceptor();
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.putAll(QCirclePluginReportUtil.a(this.h));
      localMap.put("xsj_feed_index", Integer.valueOf(this.d + 1));
      localMap.put("xsj_target_qq", ((FeedCloudMeta.StFeed)this.c).poster.id.get());
      ((QCirclePushReportReqInterceptor)localObject).a("ev_xsj_push", this.f, localMap);
      this.q.setPushReportReqInterceptor((QCirclePushReportReqInterceptor)localObject);
    }
    Object localObject = this.r;
    if (localObject != null)
    {
      ((QCircleRocketView)localObject).setFeedId(paramStFeed.id.get());
      this.r.setPageType(5);
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((QCirclePushBubbleView)localObject).setFeed(paramStFeed);
      this.s.setPageType(5);
      this.s.setExtraTypeInfo(e());
      this.s.setReportBean(i());
      this.s.setInteractor(this.B);
      this.s.setVisibility(8);
    }
    paramStFeed = QCirclePushInfoManager.a().a(paramStFeed.id.get());
    if (paramStFeed != null) {
      a(paramStFeed.totalClickCount.get());
    }
  }
  
  private void e(View paramView)
  {
    a(4, 2, e(), "");
    b(paramView);
  }
  
  private void e(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.l == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[updateFeedCommentText] video comment text should not be null.");
      return;
    }
    QLog.d("QFSFeedChildInteractPresenter", 1, new Object[] { "[updateFeedCommentText] data: ", Integer.valueOf(paramStFeed.commentCount.get()), " | feed id: ", h(paramStFeed), " | hash code: ", Integer.valueOf(hashCode()) });
    if (paramStFeed.commentCount.get() == 0)
    {
      this.l.setText(2131895652);
      this.l.setTextSize(12.0F);
      return;
    }
    this.l.setText(QFSCommonUtil.a(paramStFeed.commentCount.get()));
    this.l.setTextSize(13.0F);
  }
  
  private void f(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.n == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[updateFeedShareText] share text should not be null.");
      return;
    }
    if (this.t == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[updateFeedShareText] mShareImg should not be null.");
      return;
    }
    if (paramStFeed.share.sharedCount.get() == 0)
    {
      this.n.setText(2131895910);
      this.n.setTextSize(12.0F);
    }
    else
    {
      this.n.setText(QFSCommonUtil.a(paramStFeed.share.sharedCount.get()));
      this.n.setTextSize(13.0F);
    }
    a(this.t, "em_xsj_share_button");
  }
  
  private void g(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.v == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[updateAuthorAvatarView] author avatar view not be null.");
      return;
    }
    if (paramStFeed == null) {
      paramStFeed = null;
    } else {
      paramStFeed = paramStFeed.poster;
    }
    if (paramStFeed == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[updateAuthorAvatarView] user info should not be null.");
      return;
    }
    this.v.setUser(paramStFeed);
    a(this.v, "em_xsj_author_avatar");
  }
  
  private String h(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return "";
    }
    return paramStFeed.id.get();
  }
  
  private void k()
  {
    if (this.c == null) {
      return;
    }
    boolean bool = this.x ^ true;
    QLog.d("PL-QFSFeedChildInteractPresenter", 1, new Object[] { "[handleVideoLike] request like state: ", Boolean.valueOf(bool) });
    QCirclePolyLikeManager.a((FeedCloudMeta.StFeed)this.c, bool);
    if (this.x) {
      a(39, 2, e(), "");
    } else {
      a(36, 2, e(), "");
    }
    HashMap localHashMap = new HashMap();
    String str;
    if (this.x) {
      str = "cancel";
    } else {
      str = "like";
    }
    localHashMap.put("xsj_action_type", str);
    localHashMap.put("xsj_clck_type", "clck");
    a(this.f, "ev_xsj_like_work", localHashMap);
  }
  
  private void l()
  {
    if (this.a == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[openSharePanel] feed ioc should not be null.");
      return;
    }
    QCircleShareInfo localQCircleShareInfo = QFSShareInfoUtils.a((FeedCloudMeta.StFeed)this.c);
    localQCircleShareInfo.a = this.h;
    localQCircleShareInfo.c.mDataPosition = this.d;
    if (((FeedCloudMeta.StFeed)this.c).type.get() == 2) {
      localQCircleShareInfo.e = this.A;
    }
    localQCircleShareInfo.b = ((FeedCloudMeta.StFeed)this.c);
    localQCircleShareInfo.r = i();
    if ((i() != null) && ("pg_ks_explore_page".equals(Integer.valueOf(i().getPageId())))) {
      localQCircleShareInfo.l = true;
    }
    this.a.a("event_open_share", new Object[] { localQCircleShareInfo });
    o();
    this.y = true;
    a(21, 2, e(), "");
  }
  
  private void m()
  {
    if (this.a == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[openCommentPanel] feed ioc should not be null.");
      return;
    }
    QCircleCommentInfo localQCircleCommentInfo = new QCircleCommentInfo();
    localQCircleCommentInfo.a = this.h;
    localQCircleCommentInfo.b = ((FeedCloudMeta.StFeed)this.c);
    localQCircleCommentInfo.k = i();
    localQCircleCommentInfo.h = 100;
    localQCircleCommentInfo.c = e();
    localQCircleCommentInfo.c.mDataPosition = this.d;
    this.a.a("event_open_comment", new Object[] { localQCircleCommentInfo });
    a(6, 2, e(), "");
  }
  
  private void n()
  {
    if (!(this.c instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    if (this.y) {
      return;
    }
    RFThreadManager.getUIHandler().post(new QFSFeedChildInteractPresenter.3(this));
  }
  
  private void o()
  {
    QFSFeedShareButtonManager localQFSFeedShareButtonManager = this.z;
    if (localQFSFeedShareButtonManager == null) {
      return;
    }
    localQFSFeedShareButtonManager.a();
    this.z = null;
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.v = ((QCircleAvatarView)paramView.findViewById(2131433355));
    this.j = paramView.findViewById(2131433389);
    this.k = ((TextView)paramView.findViewById(2131433366));
    this.l = ((TextView)paramView.findViewById(2131433363));
    this.n = ((TextView)paramView.findViewById(2131433370));
    this.u = ((TextView)paramView.findViewById(2131436511));
    this.o = ((ImageView)paramView.findViewById(2131433402));
    this.p = ((ImageView)paramView.findViewById(2131433361));
    this.t = ((ImageView)paramView.findViewById(2131436572));
    this.v.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.t.setOnClickListener(this);
    d(paramView);
    c(paramView);
  }
  
  protected void a(QFSBaseFeedPresenterEvent paramQFSBaseFeedPresenterEvent)
  {
    super.a(paramQFSBaseFeedPresenterEvent);
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSVideoReplayEvent))
    {
      n();
      return;
    }
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSPicPositionChangeEvent)) {
      a((QFSPicPositionChangeEvent)paramQFSBaseFeedPresenterEvent);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.busiData.get() != null))
    {
      Object localObject = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(paramStFeed.busiData.get().toByteArray());
        localObject = ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList;
        QCirclePushInfoManager.a().a(paramStFeed.id.get(), (FeedCloudMeta.StPushList)localObject);
        if (localObject != null)
        {
          a(paramStFeed, ((FeedCloudMeta.StPushList)localObject).totalClickCount.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if (this.u == null) {
      return;
    }
    if (QCirclePluginUtil.d(paramStFeed.poster.id.get()))
    {
      this.q.setVisibility(8);
      this.u.setVisibility(8);
      return;
    }
    if (paramInt > 0)
    {
      this.u.setText(QCirclePluginUtil.d(paramInt));
      return;
    }
    paramStFeed = this.u;
    paramStFeed.setText(paramStFeed.getResources().getString(2131895872));
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    View localView = this.j;
    if (localView == null) {
      return;
    }
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localView.setVisibility(i1);
  }
  
  void b(View paramView)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setFeed((FeedCloudMeta.StFeed)this.c);
    localQCircleInitBean.setUser((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)this.c).poster.get());
    localQCircleInitBean.setFromReportBean(i().clone());
    QCircleLauncher.b(paramView.getContext(), localQCircleInitBean);
  }
  
  public void b(FeedBlockData paramFeedBlockData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[onChanged] onChanged...");
    }
    if (paramFeedBlockData == null) {
      return;
    }
    c(paramFeedBlockData.b());
    e(paramFeedBlockData.b());
    a(paramFeedBlockData.a("DITTO_FEED_BUSI_REQ_DATA"));
    f(paramFeedBlockData.b());
    b(paramFeedBlockData.b());
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    if (paramStFeed == null)
    {
      QLog.d("QFSFeedChildInteractPresenter", 1, "[onBindData] data should not be null.");
      return;
    }
    a(false);
    c(paramStFeed);
    e(paramStFeed);
    d(paramStFeed);
    f(paramStFeed);
    b(paramStFeed);
    g(paramStFeed);
    QCircleRecommendImageView localQCircleRecommendImageView = this.q;
    if ((localQCircleRecommendImageView != null) && (this.u != null))
    {
      localQCircleRecommendImageView.setFeedData(new FeedBlockData(paramStFeed), 5);
      this.q.setExtraTypeInfo(this.g);
      if (QCirclePluginUtil.d(paramStFeed.poster.id.get()))
      {
        this.q.setVisibility(8);
        this.u.setVisibility(8);
      }
      else
      {
        this.q.setVisibility(0);
        this.u.setVisibility(0);
        a(paramStFeed);
      }
    }
    QCircleFeedDataCenter.a().a(new FeedBlockData(paramStFeed), this);
  }
  
  public void c()
  {
    super.c();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.c(paramQFSFeedSelectInfo);
    o();
  }
  
  public void d()
  {
    super.d();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    o();
    this.y = false;
  }
  
  public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QFSCommentSendEvent.class);
    localArrayList.add(QFSPushTenTimesEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    int i1;
    if (paramView == null) {
      i1 = -1;
    } else {
      i1 = paramView.getId();
    }
    if (i1 == 2131433402) {
      k();
    } else if (i1 == 2131433361) {
      m();
    } else if (i1 == 2131436572) {
      l();
    } else if (i1 == 2131433355) {
      e(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QFSCommentSendEvent)) {
      a((QFSCommentSendEvent)paramSimpleBaseEvent);
    }
    if ((paramSimpleBaseEvent instanceof QFSPushTenTimesEvent)) {
      a((QFSPushTenTimesEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildInteractPresenter
 * JD-Core Version:    0.7.0.1
 */