package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean.QCircleActionBean;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.comment.QCircleReplyItemView;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.ExtraInfoInterface;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushReportReqInterceptor;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.OnDismissListener;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper.CommentInputListener;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCirclePushBubbleView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class QCircleCommentPanelPart
  extends QCircleBasePart
  implements View.OnClickListener, ExtraInfoInterface, OnCommentElementClickListener, SimpleEventReceiver
{
  private SoftKeyboardStateHelper A;
  private QCircleCommentHelper.CommentInputListener B;
  private ReportBean<QCircleReportBean> C;
  private ViewStub D;
  private ImageView E;
  private Activity F;
  private QCircleInteractor G = new QCircleCommentPanelPart.6(this);
  private RelativeLayout a;
  private QCircleSlidBottomView c;
  private QCircleBlockContainer d;
  private QCircleCommentPanelBlock e;
  private FrameLayout f;
  private ImageView g;
  private QCircleCommentInfo h;
  private TextView i;
  private TextView j;
  private List<FeedCloudMeta.StComment> k;
  private QCirclePolyLikeFrameLayout l;
  private ImageView m;
  private QCircleRecommendImageView n;
  private QCirclePolyLikeAniView o;
  private QCircleRocketView p;
  private QCirclePushBubbleView q;
  private QCirclePanelLoadingView r;
  private FrameLayout s;
  private LinearLayout t;
  private QCircleExtraTypeInfo u;
  private int v;
  private FeedCloudMeta.StFeed w;
  private FeedCloudMeta.StComment x;
  private FeedCloudMeta.StReply y;
  private boolean z;
  
  private void A()
  {
    Object localObject1 = this.t;
    if (localObject1 == null) {
      return;
    }
    ((LinearLayout)localObject1).setVisibility(8);
    localObject1 = this.d;
    if (localObject1 != null) {
      ((QCircleBlockContainer)localObject1).setVisibility(0);
    }
    localObject1 = (TextView)this.t.findViewById(2131438908);
    if (localObject1 != null)
    {
      Object localObject2 = this.e;
      if ((localObject2 != null) && (((QCircleCommentPanelBlock)localObject2).getItemCount() == 0))
      {
        this.t.setVisibility(0);
        localObject2 = QCircleConfigHelper.ay();
        if (((String)localObject2).isEmpty()) {
          ((TextView)localObject1).setText(2131895777);
        } else {
          ((TextView)localObject1).setText((CharSequence)localObject2);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          ((QCircleBlockContainer)localObject1).setVisibility(8);
        }
      }
    }
  }
  
  private void B()
  {
    H();
    this.A = new SoftKeyboardStateHelper(this.a);
    this.A.a(new QCircleCommentPanelPart.13(this));
  }
  
  private void H()
  {
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.A;
    if (localSoftKeyboardStateHelper != null)
    {
      localSoftKeyboardStateHelper.a();
      this.A = null;
    }
  }
  
  private boolean I()
  {
    return (QCircleReportBean.isContentDetailPage(f())) || (QCircleConfigHelper.bg());
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.d == null) {
        return -1;
      }
      int i2 = 0;
      int i1;
      for (int i3 = -1; i2 < this.d.getRecyclerView().getChildCount(); i3 = i1)
      {
        Object localObject1 = this.d.getRecyclerView().getChildAt(i2);
        if (!(localObject1 instanceof QCircleCommentItemView))
        {
          i1 = i3;
        }
        else
        {
          localObject1 = (QCircleCommentItemView)localObject1;
          i1 = i3;
          if (((QCircleCommentItemView)localObject1).getComment() != null) {
            if (!((QCircleCommentItemView)localObject1).getComment().id.get().equals(paramString1))
            {
              i1 = i3;
            }
            else
            {
              localObject1 = ((QCircleCommentItemView)localObject1).getRvReplyList();
              if (localObject1 == null) {
                return i3;
              }
              int i4 = ((RecyclerView)localObject1).getHeight();
              if (TextUtils.isEmpty(paramString2)) {
                return i4;
              }
              i3 = 0;
              for (;;)
              {
                i1 = i4;
                if (i3 >= ((RecyclerView)localObject1).getChildCount()) {
                  break;
                }
                Object localObject2 = ((RecyclerView)localObject1).getChildAt(i3);
                if ((localObject2 instanceof QCircleReplyItemView))
                {
                  localObject2 = (QCircleReplyItemView)localObject2;
                  if ((((QCircleReplyItemView)localObject2).getReply() != null) && (((QCircleReplyItemView)localObject2).getReply().id.get().equals(paramString2)))
                  {
                    i1 = i4 - ((QCircleReplyItemView)localObject2).getBottom();
                    break;
                  }
                }
                i3 += 1;
              }
            }
          }
        }
        i2 += 1;
      }
      return i3;
    }
    return -1;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.v = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(f()).setfpageid(e()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("reportToLpDc05507 extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleCommentPanelPart", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(paramStUser);
    localQCircleInitBean.setFromReportBean(d().clone());
    QCircleLauncher.b(g(), localQCircleInitBean);
  }
  
  private void a(Object paramObject, boolean paramBoolean)
  {
    Object localObject3 = new FeedCloudMeta.StComment();
    boolean bool = paramObject instanceof FeedCloudMeta.StComment;
    String str2 = "";
    Object localObject4 = null;
    Object localObject1;
    String str1;
    Object localObject2;
    if (bool)
    {
      localObject1 = (FeedCloudMeta.StComment)paramObject;
      str1 = ((FeedCloudMeta.StComment)localObject1).postUser.id.get();
      localObject2 = localObject4;
    }
    else
    {
      localObject1 = localObject3;
      str1 = str2;
      localObject2 = localObject4;
      if ((paramObject instanceof Object[]))
      {
        Object[] arrayOfObject = (Object[])paramObject;
        paramObject = localObject3;
        if (arrayOfObject.length > 0)
        {
          paramObject = localObject3;
          if ((arrayOfObject[0] instanceof FeedCloudMeta.StComment)) {
            paramObject = (FeedCloudMeta.StComment)arrayOfObject[0];
          }
        }
        localObject1 = paramObject;
        str1 = str2;
        localObject2 = localObject4;
        if (arrayOfObject.length > 1)
        {
          localObject1 = paramObject;
          str1 = str2;
          localObject2 = localObject4;
          if (arrayOfObject[1] != null)
          {
            localObject1 = paramObject;
            str1 = str2;
            localObject2 = localObject4;
            if ((arrayOfObject[1] instanceof FeedCloudMeta.StReply))
            {
              localObject2 = (FeedCloudMeta.StReply)arrayOfObject[1];
              str1 = ((FeedCloudMeta.StReply)localObject2).postUser.id.get();
              localObject1 = paramObject;
            }
          }
        }
      }
    }
    localObject3 = new HashMap();
    ((Map)localObject3).put("xsj_cmt_id", ((FeedCloudMeta.StComment)localObject1).id.get());
    if (localObject2 != null)
    {
      ((Map)localObject3).put("xsj_sub_action_type", "reply");
      ((Map)localObject3).put("xsj_reply_id", ((FeedCloudMeta.StReply)localObject2).id.get());
    }
    else
    {
      ((Map)localObject3).put("xsj_sub_action_type", "cmt");
    }
    if (paramBoolean) {
      paramObject = "cancel";
    } else {
      paramObject = "like";
    }
    a("ev_xsj_cmtreply_like_action", paramObject, str1, (Map)localObject3);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Map<String, Object> paramMap)
  {
    Object localObject = this.h;
    if ((localObject != null) && (((QCircleCommentInfo)localObject).a != null))
    {
      if (this.h.b == null) {
        return;
      }
      if (!QCircleConfigHelper.bg()) {
        return;
      }
      if ((f() != 501) && (f() != 503) && (f() != 57)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dtReportCustomShareReport eventId = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" , actionType");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      localObject = new QCircleDTParamBuilder().buildElementParams();
      ((Map)localObject).putAll(QCirclePluginReportUtil.a(this.h.a));
      int i1;
      if (this.h.c != null) {
        i1 = this.h.c.mDataPosition + 1;
      } else {
        i1 = -1;
      }
      ((Map)localObject).put("xsj_feed_index", Integer.valueOf(i1));
      ((Map)localObject).put("xsj_target_qq", paramString3);
      ((Map)localObject).put("xsj_action_type", paramString2);
      if (paramMap != null) {
        ((Map)localObject).putAll(paramMap);
      }
      VideoReport.setElementId(this.a, "em_xsj_cmtpanel");
      VideoReport.reportEvent(paramString1, this.a, (Map)localObject);
    }
  }
  
  private boolean a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    return a(paramStComment, paramStReply, 100);
  }
  
  private boolean a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt)
  {
    if (!QCircleBindPhoneNumberHelper.a())
    {
      QCircleBindPhoneNumberHelper.a(c(), 2);
      return false;
    }
    QCircleFeedCommentInfo localQCircleFeedCommentInfo = new QCircleFeedCommentInfo(v(), paramStComment, paramStReply);
    this.B = new QCircleCommentPanelPart.10(this, paramStComment, paramStReply, paramInt);
    QCircleCommentHelper.a().a(c(), localQCircleFeedCommentInfo, this.B, I(), paramInt);
    if ((paramInt == 103) || (QCircleConfigHelper.bg())) {
      b(7);
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.u;
    if (localQCircleExtraTypeInfo != null)
    {
      if (localQCircleExtraTypeInfo.mFeed == null) {
        return;
      }
      if (I())
      {
        a(paramInt, 2, this.u);
        return;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.u.mFeed).setActionType(paramInt).setSubActionType(2).setToUin(this.u.mFeed.poster.id.get()).setIndex(this.u.mDataPosition).setPageId(f())));
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (this.n != null)
      {
        if (QCirclePluginUtil.d(paramStFeed.poster.id.get())) {
          this.n.setVisibility(8);
        } else {
          this.n.setVisibility(0);
        }
        this.n.setFeedData(new FeedBlockData(paramStFeed), 3);
      }
      Object localObject = this.p;
      if (localObject != null)
      {
        ((QCircleRocketView)localObject).setFeedId(paramStFeed.id.get());
        this.p.setPageType(3);
      }
      localObject = this.q;
      if (localObject != null)
      {
        ((QCirclePushBubbleView)localObject).setFeed(paramStFeed);
        this.q.setPageType(3);
        this.q.setExtraTypeInfo(i());
        this.q.setReportBean(d());
        this.q.setInteractor(this.G);
        this.q.setVisibility(8);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      w().a(c().hashCode(), 0, v(), true, false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestCommentList  loadMore  feedId : ");
      ((StringBuilder)localObject).append(v().id.get());
      QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (bf_() != null)
    {
      localObject = bf_();
      w().a(c().hashCode(), v(), (QQCircleFeedBase.StBusiInfoCommentListData)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestCommentList  refresh(have BusiInfo) feedId : ");
      ((StringBuilder)localObject).append(v().id.get());
      QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      return;
    }
    w().a(c().hashCode(), 0, v(), false, false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestCommentList  refresh  feedId : ");
    ((StringBuilder)localObject).append(v().id.get());
    QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
  }
  
  private void c(int paramInt)
  {
    TextView localTextView = this.j;
    if (localTextView != null)
    {
      if (paramInt > 0)
      {
        localTextView.setText(QCirclePluginUtil.d(paramInt));
        this.j.setVisibility(0);
        return;
      }
      localTextView.setText("");
      this.j.setVisibility(8);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.r;
    if ((localObject != null) && (this.d != null))
    {
      if (this.s == null) {
        return;
      }
      if (paramBoolean)
      {
        ((QCirclePanelLoadingView)localObject).a(this.c.getPanelHeight());
        this.d.setVisibility(8);
        this.s.setVisibility(8);
        localObject = this.t;
        if (localObject != null) {
          ((LinearLayout)localObject).setVisibility(8);
        }
      }
      else
      {
        ((QCirclePanelLoadingView)localObject).b();
        this.d.setVisibility(0);
        this.s.setVisibility(0);
      }
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((QCircleBlockContainer)localObject).getRecyclerView().getChildCount() <= 0) {
        return;
      }
      localObject = this.d.getRecyclerView().getChildAt(this.d.getRecyclerView().getChildCount() - 1);
      if (localObject == null) {
        return;
      }
      if (!(this.d.getRecyclerView().findContainingViewHolder((View)localObject) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
        return;
      }
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeMarginToFooterHolder   paddingTop: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void d(View paramView)
  {
    this.d.setLayoutManagerType(1, 1);
    this.d.getBlockMerger().b(1);
    this.d.setEnableLoadMore(true);
    this.d.setEnableRefresh(false);
    this.d.setParentFragment(j());
    this.d.getRecyclerView().setNestedScrollingEnabled(true);
    this.d.getRecyclerView().setPadding(ImmersiveUtils.a(17.0F), 0, 0, 0);
    paramView = new ArrayList();
    this.e = new QCircleCommentPanelBlock(null);
    this.e.c(10);
    if (this.b != null) {
      this.e.setReportBean(this.b);
    }
    ReportBean localReportBean = this.C;
    if (localReportBean != null) {
      this.e.a(localReportBean);
    }
    paramView.add(this.e);
    this.e.setOnLoadDataDelegate(new QCircleCommentPanelPart.1(this));
    this.e.addOnScrollListener(new QCircleCommentPanelPart.2(this));
    this.e.a(this);
    this.d.getRecyclerView().setItemAnimator(new EnhanceItemAnimator());
    ((SimpleItemAnimator)this.d.getRecyclerView().getItemAnimator()).setSupportsChangeAnimations(false);
    this.d.a(paramView);
    this.d.g();
  }
  
  private void e(View paramView)
  {
    QCircleSlidBottomView localQCircleSlidBottomView = this.c;
    if ((localQCircleSlidBottomView != null) && (localQCircleSlidBottomView.c()))
    {
      this.c.e();
      RFThreadManager.getUIHandler().postDelayed(new QCircleCommentPanelPart.11(this, paramView), 1500L);
      return;
    }
    g(paramView);
  }
  
  private void e(String paramString, Object paramObject)
  {
    l();
    B();
    if ((paramObject instanceof QCircleCommentInfo))
    {
      this.h = ((QCircleCommentInfo)paramObject);
      a(this.h.b);
      a(this.h.c);
      a(this.h.i);
      int i1 = -1;
      int i2 = paramString.hashCode();
      if (i2 != -775642345)
      {
        if ((i2 == -282709448) && (paramString.equals("comment_panel_show"))) {
          i1 = 1;
        }
      }
      else if (paramString.equals("comment_input_window_show")) {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (i1 != 1) {
          return;
        }
        r();
        this.d.getBlockMerger().l();
        paramString = this.w;
        if ((paramString != null) && (!TextUtils.equals(paramString.id.get(), v().id.get())) && (this.e.getItemCount() > 0))
        {
          this.d.getRecyclerView().scrollToPosition(0);
          this.e.clearData();
        }
        b(false);
        y();
        this.a.setVisibility(0);
        if (this.h.g == QCircleCommentInfo.j) {
          this.c.a();
        } else if ((QCirclePluginUtil.d(f())) && (QCircleHostGlobalInfo.isCurrentTabActive())) {
          this.c.a(HostUIHelper.getInstance().getHostTabHeight());
        }
        this.c.a(this.f);
        this.w = v();
        if (HostNetworkUtils.isNetworkAvailable()) {
          c(true);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(7, true));
        return;
      }
      a(this.h.d, this.h.e, this.h.h);
    }
  }
  
  private void f(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    arrayOfInt[1] += paramView.getHeight();
    int i1 = QCircleCommentHelper.a().b();
    if (arrayOfInt[1] > i1)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        ((QCircleBlockContainer)localObject).getRecyclerView().scrollBy(0, arrayOfInt[1] - i1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollItemToVisble  scrollBy: ");
        ((StringBuilder)localObject).append(arrayOfInt[1] - i1);
        QLog.i("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
        d(arrayOfInt[1] - i1);
        RFThreadManager.getUIHandler().postDelayed(new QCircleCommentPanelPart.12(this, paramView, arrayOfInt, i1), 1L);
      }
    }
  }
  
  private void g(View paramView)
  {
    B();
    f(paramView);
  }
  
  private void l()
  {
    if (F() != null)
    {
      if (this.D != null) {
        return;
      }
      b(F());
      n();
      q();
      o();
      p();
      d(F());
    }
  }
  
  private void m()
  {
    QCircleBlockContainer localQCircleBlockContainer = this.d;
    if (localQCircleBlockContainer == null)
    {
      QLog.d("QCircleCommentPanelPart", 1, "[updateBlockContainerPadding] block container not is null.");
      return;
    }
    if (localQCircleBlockContainer.getContext() == null) {
      return;
    }
    localQCircleBlockContainer = this.d;
    localQCircleBlockContainer.setPadding(localQCircleBlockContainer.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), ImmersiveUtils.a(56.0F));
  }
  
  private void n()
  {
    this.m.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.E.setOnClickListener(this);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void o()
  {
    QCircleCommentPanelPart.3 local3 = new QCircleCommentPanelPart.3(this);
    this.c.setOnClickListener(local3);
    this.c.setStatusListener(new QCircleCommentPanelPart.4(this));
    this.g.setOnClickListener(local3);
  }
  
  private void p()
  {
    this.i.setPadding(ViewUtils.a(20.0F), 0, 0, 0);
    this.i.setHintTextColor(QCircleSkinHelper.getInstance().getColor(2131167081));
    String str = QCircleConfigHelper.a("qqcircle", "qcircle_comment_list_input_place_holder", QCircleApplication.APP.getResources().getString(2131895655));
    this.i.setText(str);
  }
  
  private void q()
  {
    Object localObject = this.l;
    if (localObject == null) {
      return;
    }
    ((QCirclePolyLikeFrameLayout)localObject).setAniView(this.o);
    this.l.setOnClickHookListener(new QCircleCommentPanelPart.5(this));
    if (this.b != null) {
      this.l.setReportBean(this.b);
    }
    localObject = this.C;
    if (localObject != null) {
      this.l.setReportBeanAgent((ReportBean)localObject);
    }
    this.l.setPushPageType(3);
  }
  
  private void r()
  {
    this.E.setVisibility(8);
    int i2 = 1;
    if (QCircleConfigHelper.a("qqcircle", "qqcircle_show_barrage_enabled", Integer.valueOf(1)).intValue() != 1) {
      return;
    }
    if (QCircleConfigHelper.bg())
    {
      i1 = i2;
      if (f() == 501) {
        break label78;
      }
      i1 = i2;
      if (f() == 503) {
        break label78;
      }
      if (f() == 57)
      {
        i1 = i2;
        break label78;
      }
    }
    int i1 = 0;
    label78:
    if (i1 == 0) {
      return;
    }
    if (QCircleSwitchConfigManager.a().b()) {
      this.E.setImageResource(2130845150);
    } else {
      this.E.setImageResource(2130845149);
    }
    this.E.setVisibility(0);
  }
  
  private void s()
  {
    RelativeLayout localRelativeLayout = this.a;
    if ((localRelativeLayout != null) && (this.c != null) && (localRelativeLayout.getVisibility() == 0)) {
      this.c.f();
    }
  }
  
  private void t()
  {
    Object localObject = u();
    if ((localObject != null) && (((QCircleInitBean)localObject).getActionBean() != null) && (((QCircleInitBean)localObject).getActionBean().mShowInputKeyboard) && (!this.z))
    {
      localObject = bf_();
      if ((localObject != null) && (a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject).comment, ((QQCircleFeedBase.StBusiInfoCommentListData)localObject).reply))) {
        this.z = true;
      }
    }
  }
  
  private QCircleInitBean u()
  {
    return (QCircleInitBean)((Activity)g()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private FeedCloudMeta.StFeed v()
  {
    QCircleCommentInfo localQCircleCommentInfo = this.h;
    if ((localQCircleCommentInfo != null) && (localQCircleCommentInfo.b != null)) {
      return this.h.b;
    }
    return new FeedCloudMeta.StFeed();
  }
  
  private QCircleCommentBusiness w()
  {
    return QCircleCommentBusiness.a();
  }
  
  private void x()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((QCircleCommentInfo)localObject).b != null))
    {
      if (g() == null) {
        return;
      }
      boolean bool = QCircleSwitchConfigManager.a().b();
      QLog.d("QCircleCommentPanelPart", 1, new Object[] { "[switchBarrage]  before operation | isBarrageOpenBefore: ", Boolean.valueOf(bool) });
      QCircleSwitchConfigManager.a().a(bool ^ true);
      r();
      int i1;
      if (bool) {
        i1 = 10;
      } else {
        i1 = 9;
      }
      localObject = new QCircleDanmakuEvent(i1);
      ((QCircleDanmakuEvent)localObject).feedId = this.h.b.id.get();
      SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
    }
  }
  
  private void y()
  {
    Object localObject = z();
    this.k = w().c((String)localObject);
    if (this.k == null)
    {
      this.k = v().vecComment.get();
      localObject = this.e;
      if (localObject != null) {
        ((QCircleCommentPanelBlock)localObject).a(v(), this.k);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshPanelView commentBusiness no commentList  commentList.size : ");
      ((StringBuilder)localObject).append(this.k.size());
      QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshPanelView use commentBusiness commentList  commentList.size : ");
      ((StringBuilder)localObject).append(this.k.size());
      QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      localObject = this.e;
      if (localObject != null) {
        ((QCircleCommentPanelBlock)localObject).a(v(), this.k);
      }
    }
    c(w().b(v().id.get()));
    A();
  }
  
  private String z()
  {
    String str = v().id.get();
    Object localObject = str;
    if (bf_() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(bf_().comment.id.get());
      ((StringBuilder)localObject).append(bf_().reply.id.get());
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public String a()
  {
    return "QCircleCommentPanelPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (257 == paramInt1) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleAtUpdateEvent(g(), paramIntent));
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.F = paramActivity;
  }
  
  public void a(View paramView)
  {
    a(j(), paramView, E());
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick, pageId: ");
    ((StringBuilder)localObject).append(f());
    ((StringBuilder)localObject).append("  parentPageId: ");
    ((StringBuilder)localObject).append(e());
    QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 7)
          {
            if (paramInt1 != 10)
            {
              if (paramInt1 != 11)
              {
                switch (paramInt1)
                {
                default: 
                  return;
                case 15: 
                  b(51);
                  a(paramObject, true);
                  return;
                case 14: 
                  b(50);
                  a(paramObject, false);
                  return;
                }
                if ((paramObject instanceof FeedCloudMeta.StComment))
                {
                  paramObject = (FeedCloudMeta.StComment)paramObject;
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("onClick replyTextButton, feedId: ");
                  ((StringBuilder)localObject).append(v().id.get());
                  ((StringBuilder)localObject).append(" commentId: ");
                  ((StringBuilder)localObject).append(paramObject.id.get());
                  QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
                  if (a(paramObject, null)) {
                    e(paramView);
                  }
                }
                b(13);
                this.v = 13;
                return;
              }
              if ((paramObject instanceof Object[]))
              {
                paramObject = (Object[])paramObject;
                if ((paramObject.length > 1) && ((paramObject[0] instanceof FeedCloudMeta.StComment)) && ((paramObject[1] instanceof Integer)))
                {
                  paramView = (FeedCloudMeta.StComment)paramObject[0];
                  paramObject = (Integer)paramObject[1];
                  this.e.b(paramInt2, paramObject.intValue());
                  this.d.getRecyclerView().scrollToPosition(paramInt2);
                  paramObject = new StringBuilder();
                  paramObject.append("onClick less reply, feedId: ");
                  paramObject.append(v().id.get());
                  paramObject.append(" commentId: ");
                  paramObject.append(paramView.id.get());
                  QLog.d("QCircleCommentPanelPart", 1, paramObject.toString());
                }
              }
            }
            else
            {
              if ((paramObject instanceof Object[]))
              {
                paramObject = (Object[])paramObject;
                if ((paramObject.length > 1) && ((paramObject[0] instanceof FeedCloudMeta.StComment)) && ((paramObject[1] instanceof Integer)))
                {
                  paramView = (FeedCloudMeta.StComment)paramObject[0];
                  paramObject = (Integer)paramObject[1];
                  this.e.a(paramInt2, paramObject.intValue());
                  paramObject = new StringBuilder();
                  paramObject.append("onClick more reply, feedId: ");
                  paramObject.append(v().id.get());
                  paramObject.append(" commentId: ");
                  paramObject.append(paramView.id.get());
                  QLog.d("QCircleCommentPanelPart", 1, paramObject.toString());
                }
              }
              b(52);
            }
          }
          else
          {
            if ((paramObject instanceof Object[]))
            {
              localObject = (Object[])paramObject;
              if ((localObject.length > 1) && (localObject[0] != null) && (localObject[1] != null) && ((localObject[0] instanceof FeedCloudMeta.StComment)) && ((localObject[1] instanceof FeedCloudMeta.StReply)))
              {
                paramObject = (FeedCloudMeta.StComment)localObject[0];
                localObject = (FeedCloudMeta.StReply)localObject[1];
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("onClick reply, feedId: ");
                localStringBuilder.append(v().id.get());
                localStringBuilder.append(" commentId: ");
                localStringBuilder.append(paramObject.id.get());
                localStringBuilder.append(" replyId: ");
                localStringBuilder.append(((FeedCloudMeta.StReply)localObject).id.get());
                QLog.d("QCircleCommentPanelPart", 1, localStringBuilder.toString());
                if (a(paramObject, (FeedCloudMeta.StReply)localObject)) {
                  e(paramView);
                }
              }
            }
            b(12);
            this.v = 12;
          }
        }
        else
        {
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramObject = (FeedCloudMeta.StComment)paramObject;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onClick comment, feedId: ");
            ((StringBuilder)localObject).append(v().id.get());
            ((StringBuilder)localObject).append(" commentId: ");
            ((StringBuilder)localObject).append(paramObject.id.get());
            QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
            if (a(paramObject, null)) {
              e(paramView);
            }
          }
          b(11);
          this.v = 11;
        }
      }
      else
      {
        if ((paramObject instanceof FeedCloudMeta.StUser))
        {
          paramView = new StringBuilder();
          paramView.append("onClick nickName, feedId: ");
          paramView.append(v().id.get());
          paramView.append(" userId: ");
          paramObject = (FeedCloudMeta.StUser)paramObject;
          paramView.append(paramObject.id.get());
          QLog.d("QCircleCommentPanelPart", 1, paramView.toString());
          a(paramObject);
        }
        b(15);
      }
    }
    else
    {
      if ((paramObject instanceof FeedCloudMeta.StUser))
      {
        paramView = new StringBuilder();
        paramView.append("onClick avatar, feedId: ");
        paramView.append(v().id.get());
        paramView.append(" userId: ");
        paramObject = (FeedCloudMeta.StUser)paramObject;
        paramView.append(paramObject.id.get());
        QLog.d("QCircleCommentPanelPart", 1, paramView.toString());
        a(paramObject);
      }
      b(14);
    }
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.u = paramQCircleExtraTypeInfo;
    paramQCircleExtraTypeInfo = this.l;
    if (paramQCircleExtraTypeInfo != null)
    {
      localQCircleExtraTypeInfo = this.u;
      if (localQCircleExtraTypeInfo != null) {
        paramQCircleExtraTypeInfo.setExtraTypeInfo(localQCircleExtraTypeInfo);
      }
    }
    paramQCircleExtraTypeInfo = new QCirclePushReportReqInterceptor();
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.u;
    if ((localQCircleExtraTypeInfo != null) && (localQCircleExtraTypeInfo.mFeed != null) && (this.n != null))
    {
      paramQCircleExtraTypeInfo.a(56);
      paramQCircleExtraTypeInfo.b(57);
      if (I()) {
        paramQCircleExtraTypeInfo.a(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(this.u.mFeed)).setSubActionType(2).setToUin(this.u.mFeed.poster.id.get()).setPosition(this.u.mDataPosition).setPlayScene(this.u.mPlayScene).setPageId(f()).setfpageid(e()));
      } else {
        paramQCircleExtraTypeInfo.a(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.u.mFeed).setSubActionType(1).setToUin(this.u.mFeed.poster.id.get()).setIndex(this.u.mDataPosition).setPageId(f())));
      }
      this.n.setPushReportReqInterceptor(paramQCircleExtraTypeInfo);
    }
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.C = paramReportBean;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      w().a(paramStFeed.id.get(), paramStFeed.commentCount.get());
    }
    QCirclePolyLikeFrameLayout localQCirclePolyLikeFrameLayout = this.l;
    if (localQCirclePolyLikeFrameLayout != null) {
      localQCirclePolyLikeFrameLayout.setFeedData(v());
    }
    b(paramStFeed);
  }
  
  public void a(String paramString, Object paramObject)
  {
    int i1 = paramString.hashCode();
    if (i1 != -775642345)
    {
      if (i1 != -282709448)
      {
        if ((i1 == -161821329) && (paramString.equals("comment_panel_dismiss")))
        {
          i1 = 2;
          break label76;
        }
      }
      else if (paramString.equals("comment_panel_show"))
      {
        i1 = 1;
        break label76;
      }
    }
    else if (paramString.equals("comment_input_window_show"))
    {
      i1 = 0;
      break label76;
    }
    i1 = -1;
    label76:
    if ((i1 != 0) && (i1 != 1))
    {
      if (i1 != 2) {
        return;
      }
      s();
      return;
    }
    e(paramString, paramObject);
  }
  
  public boolean ah_()
  {
    RelativeLayout localRelativeLayout = this.a;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      this.c.f();
      SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(8, false));
      return true;
    }
    return super.ah_();
  }
  
  protected void b(View paramView)
  {
    this.D = ((ViewStub)paramView.findViewById(2131431109));
    this.o = ((QCirclePolyLikeAniView)paramView.findViewById(2131441777));
    this.a = ((RelativeLayout)this.D.inflate().findViewById(2131431108));
    this.c = ((QCircleSlidBottomView)this.a.findViewById(2131441599));
    this.d = ((QCircleBlockContainer)this.a.findViewById(2131441597));
    this.g = ((ImageView)this.a.findViewById(2131441600));
    this.f = ((FrameLayout)this.a.findViewById(2131441595));
    this.j = ((TextView)this.a.findViewById(2131431095));
    this.i = ((TextView)this.a.findViewById(2131447156));
    this.l = ((QCirclePolyLikeFrameLayout)this.a.findViewById(2131436665));
    this.m = ((ImageView)this.a.findViewById(2131436326));
    this.n = ((QCircleRecommendImageView)this.a.findViewById(2131436508));
    this.p = ((QCircleRocketView)this.a.findViewById(2131431107));
    this.t = ((LinearLayout)this.a.findViewById(2131431078));
    this.q = ((QCirclePushBubbleView)this.a.findViewById(2131431106));
    this.r = ((QCirclePanelLoadingView)this.a.findViewById(2131441596));
    this.s = ((FrameLayout)this.a.findViewById(2131431120));
    this.E = ((ImageView)this.a.findViewById(2131441593));
    m();
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onLongClick, pageId: ");
    ((StringBuilder)localObject1).append(f());
    ((StringBuilder)localObject1).append("  parentPageId: ");
    ((StringBuilder)localObject1).append(e());
    QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new QCircleCommentPanelPart.7(this);
    Object localObject2;
    if (paramInt1 != 5)
    {
      if (paramInt1 != 8) {
        return;
      }
      if ((paramObject instanceof Object[]))
      {
        localObject2 = (Object[])paramObject;
        if ((localObject2.length > 1) && (localObject2[0] != null) && (localObject2[1] != null) && ((localObject2[0] instanceof FeedCloudMeta.StComment)) && ((localObject2[1] instanceof FeedCloudMeta.StReply)))
        {
          paramObject = (FeedCloudMeta.StComment)localObject2[0];
          localObject2 = (FeedCloudMeta.StReply)localObject2[1];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onLongClick reply, feedId: ");
          localStringBuilder.append(v().id.get());
          localStringBuilder.append(" commentId: ");
          localStringBuilder.append(paramObject.id.get());
          localStringBuilder.append(" replyId: ");
          localStringBuilder.append(((FeedCloudMeta.StReply)localObject2).id.get());
          QLog.d("QCircleCommentPanelPart", 1, localStringBuilder.toString());
          QCirclePopupWindowHelper.a().a(paramView, v(), (FeedCloudMeta.StReply)localObject2, new QCircleCommentPanelPart.9(this, (FeedCloudMeta.StReply)localObject2, paramObject), (BubblePopupWindow.OnDismissListener)localObject1);
        }
      }
    }
    else if ((paramObject instanceof FeedCloudMeta.StComment))
    {
      b(45);
      paramObject = (FeedCloudMeta.StComment)paramObject;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onLongClick comment, feedId: ");
      ((StringBuilder)localObject2).append(v().id.get());
      ((StringBuilder)localObject2).append(" commentId: ");
      ((StringBuilder)localObject2).append(paramObject.id.get());
      QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject2).toString());
      QCirclePopupWindowHelper.a().a(paramView, v(), paramObject, new QCircleCommentPanelPart.8(this, paramObject), (BubblePopupWindow.OnDismissListener)localObject1);
    }
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData bf_()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = u();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      this.x = ((FeedCloudMeta.StComment)localStBusiInfoCommentListData.comment.get());
      this.y = ((FeedCloudMeta.StReply)localStBusiInfoCommentListData.reply.get());
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      label57:
      break label57;
    }
    QLog.e("QCircleCommentPanelPart", 1, "getInfoError");
    return null;
  }
  
  public Activity c()
  {
    Activity localActivity2 = this.F;
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = super.c();
    }
    return localActivity1;
  }
  
  public QCircleReportBean d()
  {
    if (this.b != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", this.b).clone();
    }
    ReportBean localReportBean = this.C;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", (QCircleReportBean)localReportBean.getReportBean()).clone();
    }
    return new QCircleReportBean();
  }
  
  protected int e()
  {
    if (this.b != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", this.b);
    }
    ReportBean localReportBean = this.C;
    if (localReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  protected int f()
  {
    if (this.b != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", this.b);
    }
    ReportBean localReportBean = this.C;
    if (localReportBean != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  public Context g()
  {
    Activity localActivity = this.F;
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = super.g();
    }
    return localObject;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    return localArrayList;
  }
  
  public QCircleExtraTypeInfo i()
  {
    return this.u;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    H();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick, pageId: ");
    localStringBuilder.append(f());
    localStringBuilder.append("  parentPageId: ");
    localStringBuilder.append(e());
    QLog.d("QCircleCommentPanelPart", 1, localStringBuilder.toString());
    if (i1 == 2131447156)
    {
      a(this.x, this.y);
      b(60);
      this.v = 60;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick text_input, feedId: ");
      localStringBuilder.append(v().id.get());
      QLog.d("QCircleCommentPanelPart", 1, localStringBuilder.toString());
    }
    else if (i1 == 2131436326)
    {
      a(this.x, this.y);
      b(61);
      this.v = 61;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick iv_comment, feedId: ");
      localStringBuilder.append(v().id.get());
      QLog.d("QCircleCommentPanelPart", 1, localStringBuilder.toString());
    }
    else if (i1 == 2131441593)
    {
      x();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      int i1 = paramSimpleBaseEvent.eventStatus;
      boolean bool2 = false;
      boolean bool1 = false;
      QCircleCommentPanelBlock localQCircleCommentPanelBlock;
      switch (i1)
      {
      default: 
      case 10: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        localQCircleCommentPanelBlock = this.e;
        if (localQCircleCommentPanelBlock != null)
        {
          localQCircleCommentPanelBlock.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.reply.id.get());
          return;
        }
        break;
      case 9: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        localQCircleCommentPanelBlock = this.e;
        if (localQCircleCommentPanelBlock != null)
        {
          localQCircleCommentPanelBlock.a(paramSimpleBaseEvent.comment.id.get());
          return;
        }
        break;
      case 8: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        if ((this.e != null) && (paramSimpleBaseEvent.comment != null)) {
          this.e.b(paramSimpleBaseEvent.comment.id.get());
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        return;
      case 7: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        if ((this.e != null) && (paramSimpleBaseEvent.comment != null)) {
          this.e.c(paramSimpleBaseEvent.comment.id.get());
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        return;
      case 6: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        if ((this.e != null) && (paramSimpleBaseEvent.comment != null) && (paramSimpleBaseEvent.reply != null)) {
          this.e.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.reply.id.get());
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        return;
      case 5: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        if ((this.e != null) && (paramSimpleBaseEvent.comment != null) && (paramSimpleBaseEvent.reply != null)) {
          this.e.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.fakeReplyId, paramSimpleBaseEvent.reply);
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        return;
      case 4: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        if ((this.e != null) && (paramSimpleBaseEvent.comment != null)) {
          this.e.a(paramSimpleBaseEvent.comment.id.get());
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        A();
        return;
      case 3: 
        if (!paramSimpleBaseEvent.feedId.equals(v().id.get())) {
          return;
        }
        if ((this.e != null) && (paramSimpleBaseEvent.comment != null)) {
          this.e.a(paramSimpleBaseEvent.fakeCommentId, paramSimpleBaseEvent.comment);
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        paramSimpleBaseEvent = this.a;
        if ((paramSimpleBaseEvent != null) && (paramSimpleBaseEvent.getVisibility() != 0))
        {
          QCircleToastUtil.a(0L, QCircleToast.d, g().getString(2131896220), 1);
          return;
        }
        break;
      case 2: 
        if (!paramSimpleBaseEvent.feedId.equals(z())) {
          return;
        }
        if ((this.e != null) && (paramSimpleBaseEvent.commentList != null))
        {
          this.e.a(paramSimpleBaseEvent.commentList);
          paramSimpleBaseEvent = this.e.getLoadInfo();
          if (w().a(v().id.get()) == null) {
            bool1 = true;
          }
          paramSimpleBaseEvent.a(bool1);
          this.e.notifyLoadingComplete(true);
          return;
        }
        break;
      case 1: 
        if (!paramSimpleBaseEvent.feedId.equals(z())) {
          return;
        }
        if (paramSimpleBaseEvent.needShowCommentPanel) {
          t();
        }
        c(false);
        y();
        paramSimpleBaseEvent = this.e;
        if (paramSimpleBaseEvent != null)
        {
          paramSimpleBaseEvent = paramSimpleBaseEvent.getLoadInfo();
          bool1 = bool2;
          if (w().a(v().id.get()) == null) {
            bool1 = true;
          }
          paramSimpleBaseEvent.a(bool1);
          this.e.notifyLoadingComplete(true);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart
 * JD-Core Version:    0.7.0.1
 */