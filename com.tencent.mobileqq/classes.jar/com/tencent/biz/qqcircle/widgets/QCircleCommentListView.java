package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean.QCircleActionBean;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.ExtraInfoInterface;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper.CommentInputListener;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class QCircleCommentListView
  extends QCircleBaseWidgetView<QCircleCommentInfo>
  implements View.OnClickListener, ExtraInfoInterface, OnCommentElementClickListener, SimpleEventReceiver
{
  private LinearLayout a;
  private QCircleBlockContainer b;
  private QCircleCommentPanelBlock c;
  private QCircleCommentInfo d;
  private TextView e;
  private List<FeedCloudMeta.StComment> f;
  private LinearLayout g;
  private QCircleExtraTypeInfo h;
  private int i;
  private FeedCloudMeta.StComment j;
  private FeedCloudMeta.StReply k;
  private boolean l;
  private SoftKeyboardStateHelper m;
  private QCircleCommentHelper.CommentInputListener n;
  private ReportBean<QCircleReportBean> o;
  private TextView p;
  private LinearLayoutManager q;
  private View r;
  private int s = 3;
  private RecyclerView t;
  
  static {}
  
  public QCircleCommentListView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCommentListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCommentListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.b == null) {
        return -1;
      }
      int i1 = 0;
      while (i1 < this.b.getRecyclerView().getChildCount())
      {
        Object localObject = this.b.getRecyclerView().getChildAt(i1);
        if ((localObject instanceof QCircleCommentItemView))
        {
          localObject = (QCircleCommentItemView)localObject;
          if ((((QCircleCommentItemView)localObject).getComment() != null) && (((QCircleCommentItemView)localObject).getComment().id.get().equals(paramString)))
          {
            paramString = ((QCircleCommentItemView)localObject).getRvReplyList();
            if (paramString == null) {
              break;
            }
            return paramString.getHeight();
          }
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  private int a(List<FeedCloudMeta.StComment> paramList)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        i2 = i1;
        if (!paramList.hasNext()) {
          break;
        }
        i1 += ((FeedCloudMeta.StComment)paramList.next()).replyCount.get() + 1;
      }
    }
    return i2;
  }
  
  private void a(int paramInt)
  {
    if (i())
    {
      a(paramInt, 2, this.h);
      return;
    }
    Object localObject1 = this.h;
    if (localObject1 != null) {
      localObject1 = ((QCircleExtraTypeInfo)localObject1).mFeed;
    } else {
      localObject1 = null;
    }
    Object localObject2 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject1).setActionType(paramInt).setSubActionType(2);
    localObject1 = this.h;
    if ((localObject1 != null) && (((QCircleExtraTypeInfo)localObject1).mFeed != null)) {
      localObject1 = this.h.mFeed.poster.id.get();
    } else {
      localObject1 = "";
    }
    localObject1 = ((QCircleLpReportDc05501.DataBuilder)localObject2).setToUin((String)localObject1);
    localObject2 = this.h;
    if (localObject2 != null) {
      paramInt = ((QCircleExtraTypeInfo)localObject2).mDataPosition;
    } else {
      paramInt = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject1).setIndex(paramInt).setPageId(getPageId())));
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(getPageId()).setfpageid(getParentPageId()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("reportToLpDc05507 extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleCommentPanelPart", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    QCircleCommentPanelBlock localQCircleCommentPanelBlock = this.c;
    if (localQCircleCommentPanelBlock != null) {
      localQCircleCommentPanelBlock.a(paramQCircleCommentUpdateEvent.comment.id.get(), paramQCircleCommentUpdateEvent.reply.id.get());
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(paramStUser);
    localQCircleInitBean.setFromReportBean(getReportBean().clone());
    QCircleLauncher.b(getContext(), localQCircleInitBean);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i1 = this.s;
    if ((i1 == 4) || (i1 == 3))
    {
      String str = null;
      Iterator localIterator = getFeedData().busiTranparent.get().iterator();
      while (localIterator.hasNext())
      {
        FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)localIterator.next();
        if ("FeedCommentListAttach".equals(localBytesEntry.key.get())) {
          str = localBytesEntry.value.get().toStringUtf8();
        }
      }
      getCommentBusiness().a(paramString, str, (ArrayList)getFeedData().vecComment.get(), paramBoolean);
    }
  }
  
  private void a(ArrayList<MultiViewBlock> paramArrayList)
  {
    this.c = new QCircleCommentPanelBlock(null);
    this.c.c(10);
    this.c.b(3);
    if (this.mReportBean != null) {
      this.c.setReportBean(this.mReportBean);
    }
    ReportBean localReportBean = this.o;
    if (localReportBean != null) {
      this.c.a(localReportBean);
    }
    paramArrayList.add(this.c);
    this.c.setOnLoadDataDelegate(new QCircleCommentListView.2(this));
    this.c.addOnScrollListener(new QCircleCommentListView.3(this));
    this.c.a(this);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getCommentBusiness().a(getContext().hashCode(), this.s, getFeedData(), true, false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestCommentList  loadMore  feedId : ");
      ((StringBuilder)localObject).append(getFeedData().id.get());
      QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (getBusiInfo() != null)
    {
      localObject = getBusiInfo();
      getCommentBusiness().a(getContext().hashCode(), getFeedData(), (QQCircleFeedBase.StBusiInfoCommentListData)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestCommentList  refresh(have BusiInfo) feedId : ");
      ((StringBuilder)localObject).append(getFeedData().id.get());
      QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      return;
    }
    getCommentBusiness().a(getContext().hashCode(), this.s, getFeedData(), false, false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestCommentList  refresh  feedId : ");
    ((StringBuilder)localObject).append(getFeedData().id.get());
    QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
  }
  
  private void b(int paramInt)
  {
    if (b())
    {
      NestScrollRecyclerView localNestScrollRecyclerView = this.b.getRecyclerView();
      int i1 = ImmersiveUtils.a(12.0F);
      if (paramInt > 0) {
        paramInt = 0;
      } else {
        paramInt = ImmersiveUtils.a(13.5F);
      }
      localNestScrollRecyclerView.setPadding(i1, 0, 0, paramInt);
    }
  }
  
  private void b(View paramView)
  {
    this.b.setLayoutManagerType(1, 1);
    this.q = ((LinearLayoutManager)this.b.getLayoutManager());
    this.b.getBlockMerger().b(1);
    this.b.setEnableLoadMore(true);
    this.b.setEnableRefresh(false);
    if ((getHostActivity() instanceof CompatPublicActivity)) {
      this.b.setParentFragment(((CompatPublicActivity)getHostActivity()).g());
    }
    this.b.getRecyclerView().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    a(paramView);
    this.b.getRecyclerView().setItemAnimator(new EnhanceItemAnimator());
    ((SimpleItemAnimator)this.b.getRecyclerView().getItemAnimator()).setSupportsChangeAnimations(false);
    this.b.a(paramView);
    this.b.g();
  }
  
  private void b(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    QCircleCommentPanelBlock localQCircleCommentPanelBlock = this.c;
    if (localQCircleCommentPanelBlock != null) {
      localQCircleCommentPanelBlock.a(paramQCircleCommentUpdateEvent.comment.id.get());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    TextView localTextView = this.p;
    if ((localTextView != null) && (this.c != null))
    {
      int i1;
      if ((!paramBoolean) && (!b())) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localTextView.setVisibility(i1);
    }
  }
  
  private void c()
  {
    Object localObject = getInitBean();
    if ((localObject != null) && (((QCircleInitBean)localObject).getActionBean() != null) && (((QCircleInitBean)localObject).getActionBean().mShowInputKeyboard) && (!this.l))
    {
      localObject = getBusiInfo();
      if ((localObject != null) && (a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject).comment, ((QQCircleFeedBase.StBusiInfoCommentListData)localObject).reply))) {
        this.l = true;
      }
    }
  }
  
  private void c(int paramInt)
  {
    TextView localTextView = this.e;
    if (localTextView != null)
    {
      if (paramInt > 0)
      {
        localTextView.setText(QCirclePluginUtil.d(paramInt));
        this.e.setVisibility(0);
        return;
      }
      localTextView.setText("");
      this.e.setVisibility(8);
    }
  }
  
  private void c(View paramView)
  {
    g();
    d(paramView);
  }
  
  private void c(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    if ((this.c != null) && (paramQCircleCommentUpdateEvent.comment != null)) {
      this.c.b(paramQCircleCommentUpdateEvent.comment.id.get());
    }
    c(paramQCircleCommentUpdateEvent.commentTotalNum);
  }
  
  private void d()
  {
    QCircleBlockContainer localQCircleBlockContainer = this.b;
    if (localQCircleBlockContainer != null)
    {
      localQCircleBlockContainer.getRecyclerView().setHasFixedSize(canScrollVertically(1));
      requestLayout();
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((QCircleBlockContainer)localObject).getRecyclerView().getChildCount() <= 0) {
        return;
      }
      localObject = this.b.getRecyclerView().getChildAt(this.b.getRecyclerView().getChildCount() - 1);
      if (localObject == null) {
        return;
      }
      if (!(this.b.getRecyclerView().findContainingViewHolder((View)localObject) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
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
    e(paramView);
  }
  
  private void d(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    if ((this.c != null) && (paramQCircleCommentUpdateEvent.comment != null)) {
      this.c.c(paramQCircleCommentUpdateEvent.comment.id.get());
    }
    c(paramQCircleCommentUpdateEvent.commentTotalNum);
  }
  
  private void e()
  {
    Object localObject = getRealCellId();
    int i1 = getCommentBusiness().b(getFeedData().id.get());
    this.f = getFeedData().vecComment.get();
    boolean bool;
    if (a(getFeedData().vecComment.get()) >= i1) {
      bool = true;
    } else {
      bool = false;
    }
    a((String)localObject, bool);
    localObject = this.c;
    if (localObject != null)
    {
      ((QCircleCommentPanelBlock)localObject).a(getFeedData(), this.f);
      b(this.f.size());
    }
    if (b()) {
      if (!bool)
      {
        a(true);
      }
      else
      {
        localObject = this.c;
        if (localObject != null)
        {
          ((QCircleCommentPanelBlock)localObject).getLoadInfo().a(bool);
          this.c.notifyLoadingComplete(true);
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshPanelView commentBusiness no commentList  commentList.size : ");
    ((StringBuilder)localObject).append(this.f.size());
    QLog.d("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    b(bool);
    c(i1);
    f();
  }
  
  private void e(View paramView)
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
      Object localObject = this.t;
      if (localObject != null)
      {
        ((RecyclerView)localObject).scrollBy(0, arrayOfInt[1] - i1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollItemToVisble  scrollBy: ");
        ((StringBuilder)localObject).append(arrayOfInt[1] - i1);
        QLog.i("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
        d(arrayOfInt[1] - i1);
        RFThreadManager.getUIHandler().postDelayed(new QCircleCommentListView.9(this, paramView, arrayOfInt, i1), 1L);
      }
    }
  }
  
  private void e(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    if ((this.c != null) && (paramQCircleCommentUpdateEvent.comment != null) && (paramQCircleCommentUpdateEvent.reply != null)) {
      this.c.a(paramQCircleCommentUpdateEvent.comment.id.get(), paramQCircleCommentUpdateEvent.reply.id.get());
    }
    c(paramQCircleCommentUpdateEvent.commentTotalNum);
  }
  
  private void f()
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.b;
    if (localObject != null) {
      ((QCircleBlockContainer)localObject).setVisibility(0);
    }
    localObject = (TextView)this.g.findViewById(2131438908);
    if (localObject != null)
    {
      QCircleCommentPanelBlock localQCircleCommentPanelBlock = this.c;
      if ((localQCircleCommentPanelBlock != null) && (localQCircleCommentPanelBlock.getItemCount() == 0))
      {
        this.g.setVisibility(0);
        ((TextView)localObject).setText(2131891215);
        localObject = this.b;
        if (localObject != null) {
          ((QCircleBlockContainer)localObject).setVisibility(8);
        }
      }
    }
  }
  
  private void f(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    if ((this.c != null) && (paramQCircleCommentUpdateEvent.comment != null) && (paramQCircleCommentUpdateEvent.reply != null)) {
      this.c.a(paramQCircleCommentUpdateEvent.comment.id.get(), paramQCircleCommentUpdateEvent.fakeReplyId, paramQCircleCommentUpdateEvent.reply);
    }
    c(paramQCircleCommentUpdateEvent.commentTotalNum);
  }
  
  private void g()
  {
    h();
    this.m = new SoftKeyboardStateHelper(this.a);
    this.m.a(new QCircleCommentListView.10(this));
  }
  
  private void g(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    if ((this.c != null) && (paramQCircleCommentUpdateEvent.comment != null)) {
      this.c.a(paramQCircleCommentUpdateEvent.comment.id.get());
    }
    c(paramQCircleCommentUpdateEvent.commentTotalNum);
    f();
  }
  
  private QCircleCommentBusiness getCommentBusiness()
  {
    return QCircleCommentBusiness.a();
  }
  
  private QCircleInitBean getInitBean()
  {
    return (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private String getRealCellId()
  {
    String str = getFeedData().id.get();
    Object localObject = str;
    if (getBusiInfo() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(getBusiInfo().comment.id.get());
      ((StringBuilder)localObject).append(getBusiInfo().reply.id.get());
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void h()
  {
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.m;
    if (localSoftKeyboardStateHelper != null)
    {
      localSoftKeyboardStateHelper.a();
      this.m = null;
    }
  }
  
  private void h(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getFeedData().id.get())) {
      return;
    }
    if ((this.c != null) && (paramQCircleCommentUpdateEvent.comment != null)) {
      this.c.a(paramQCircleCommentUpdateEvent.fakeCommentId, paramQCircleCommentUpdateEvent.comment);
    }
    c(paramQCircleCommentUpdateEvent.commentTotalNum);
  }
  
  private void i(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getRealCellId())) {
      return;
    }
    String str = getCommentBusiness().a(getFeedData().id.get());
    boolean bool2 = false;
    boolean bool1;
    if (str == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((this.c != null) && (paramQCircleCommentUpdateEvent.commentList != null))
    {
      this.c.a(paramQCircleCommentUpdateEvent.commentList);
      paramQCircleCommentUpdateEvent = this.c.getLoadInfo();
      if (getCommentBusiness().a(getFeedData().id.get()) == null) {
        bool2 = true;
      }
      paramQCircleCommentUpdateEvent.a(bool2);
      this.c.notifyLoadingComplete(true);
      b(bool1);
    }
    paramQCircleCommentUpdateEvent = this.p;
    if (paramQCircleCommentUpdateEvent != null) {
      paramQCircleCommentUpdateEvent.setClickable(true);
    }
  }
  
  private boolean i()
  {
    return QCircleReportBean.isContentDetailPage(getPageId());
  }
  
  private void j(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (!paramQCircleCommentUpdateEvent.feedId.equals(getRealCellId())) {
      return;
    }
    if (paramQCircleCommentUpdateEvent.needShowCommentPanel) {
      c();
    }
    e();
    boolean bool;
    if (getCommentBusiness().a(getFeedData().id.get()) == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramQCircleCommentUpdateEvent = this.c;
    if (paramQCircleCommentUpdateEvent != null)
    {
      paramQCircleCommentUpdateEvent.getLoadInfo().a(bool);
      this.c.notifyLoadingComplete(true);
    }
    b(bool);
  }
  
  private void setSendPreActionType(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.i = paramInt;
  }
  
  public void a()
  {
    if (b()) {
      this.s = 4;
    }
  }
  
  protected void a(View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(2131431108));
    this.b = ((QCircleBlockContainer)paramView.findViewById(2131441597));
    this.b.getRecyclerView().setPadding(ImmersiveUtils.a(12.0F), 0, 0, ImmersiveUtils.a(13.5F));
    this.e = ((TextView)paramView.findViewById(2131431095));
    this.r = paramView.findViewById(2131449304);
    this.g = ((LinearLayout)paramView.findViewById(2131431078));
    this.p = ((TextView)paramView.findViewById(2131441603));
    this.p.setOnClickListener(new QCircleCommentListView.1(this));
  }
  
  @QCircleFeedClick
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    JoinPoint localJoinPoint = Factory.makeJP(v, this, this, new Object[] { paramView, Conversions.intObject(paramInt1), Conversions.intObject(paramInt2), paramObject });
    a(this, paramView, paramInt1, paramInt2, paramObject, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  protected void a(QCircleCommentInfo paramQCircleCommentInfo, int paramInt)
  {
    this.d = paramQCircleCommentInfo;
    setFeedData(this.d.b);
    setExtraTypeInfo(this.d.c);
    e();
    setSendPreActionType(this.d.i);
  }
  
  public boolean a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    return a(paramStComment, paramStReply, 100);
  }
  
  public boolean a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt)
  {
    if (!QCircleBindPhoneNumberHelper.a())
    {
      QCircleBindPhoneNumberHelper.a(getContext(), 2);
      return false;
    }
    paramStReply = new QCircleFeedCommentInfo(getFeedData(), paramStComment, paramStReply);
    this.n = new QCircleCommentListView.8(this, paramStComment);
    QCircleCommentHelper.a().a((Activity)getContext(), paramStReply, this.n, i(), paramInt);
    return true;
  }
  
  @QCircleFeedClick
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    JoinPoint localJoinPoint = Factory.makeJP(w, this, this, new Object[] { paramView, Conversions.intObject(paramInt1), Conversions.intObject(paramInt2), paramObject });
    b(this, paramView, paramInt1, paramInt2, paramObject, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  public boolean b()
  {
    QCircleBaseFragment localQCircleBaseFragment = QCirclePluginUtil.f(getContext());
    if ((localQCircleBaseFragment != null) && (localQCircleBaseFragment.p().a(QCircleFeedDetailBodyPart.class.getName()) != null)) {
      return ((QCircleFeedDetailBodyPart)localQCircleBaseFragment.p().a(QCircleFeedDetailBodyPart.class.getName())).l();
    }
    return false;
  }
  
  public QCircleBlockContainer getBlockContainer()
  {
    return this.b;
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData getBusiInfo()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = getInitBean();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      this.j = ((FeedCloudMeta.StComment)localStBusiInfoCommentListData.comment.get());
      this.k = ((FeedCloudMeta.StReply)localStBusiInfoCommentListData.reply.get());
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
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    return localArrayList;
  }
  
  public QCircleExtraTypeInfo getExtraTypeInfo()
  {
    return this.h;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    QCircleCommentInfo localQCircleCommentInfo = this.d;
    if ((localQCircleCommentInfo != null) && (localQCircleCommentInfo.b != null)) {
      return this.d.b;
    }
    return new FeedCloudMeta.StFeed();
  }
  
  protected int getFeedIndex()
  {
    QCircleCommentInfo localQCircleCommentInfo = this.d;
    if ((localQCircleCommentInfo != null) && (localQCircleCommentInfo.c != null)) {
      return this.d.c.mDataPosition;
    }
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131626775;
  }
  
  protected String getLogTag()
  {
    return "QCircleCommentListView";
  }
  
  protected int getPageId()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", this.mReportBean);
    }
    ReportBean localReportBean = this.o;
    if (localReportBean != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  protected int getParentPageId()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", this.mReportBean);
    }
    ReportBean localReportBean = this.o;
    if (localReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  public QCircleReportBean getReportBean()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", this.mReportBean).clone();
    }
    ReportBean localReportBean = this.o;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", (QCircleReportBean)localReportBean.getReportBean()).clone();
    }
    return new QCircleReportBean();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(u, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    h();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    a();
    a(paramView);
    b(paramView);
    setEnableClickToLoadMore(b() ^ true);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      switch (paramSimpleBaseEvent.eventStatus)
      {
      default: 
        return;
      case 10: 
        a(paramSimpleBaseEvent);
        return;
      case 9: 
        b(paramSimpleBaseEvent);
        return;
      case 8: 
        c(paramSimpleBaseEvent);
        return;
      case 7: 
        d(paramSimpleBaseEvent);
        return;
      case 6: 
        e(paramSimpleBaseEvent);
        return;
      case 5: 
        f(paramSimpleBaseEvent);
        return;
      case 4: 
        g(paramSimpleBaseEvent);
        return;
      case 3: 
        h(paramSimpleBaseEvent);
        return;
      case 2: 
        i(paramSimpleBaseEvent);
        return;
      }
      j(paramSimpleBaseEvent);
    }
  }
  
  public void setEnableClickToLoadMore(boolean paramBoolean)
  {
    QCircleBlockContainer localQCircleBlockContainer = this.b;
    if (localQCircleBlockContainer != null)
    {
      localQCircleBlockContainer.setEnableLoadMore(paramBoolean ^ true);
      this.b.getRecyclerView().setHasFixedSize(paramBoolean ^ true);
      this.b.getRecyclerView().setNestedScrollingEnabled(paramBoolean ^ true);
      this.b.getRecyclerView().setNeedLimitHeightWidth(paramBoolean ^ true);
      if (!paramBoolean) {
        this.b.getRecyclerView().setNestScrollDelegate(new QCircleCommentListView.11(this));
      }
    }
  }
  
  public void setExtraTypeInfo(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.h = paramQCircleExtraTypeInfo;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      getCommentBusiness().a(paramStFeed.id.get(), paramStFeed.commentCount.get());
    }
  }
  
  public void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.t = paramRecyclerView;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    QCircleCommentPanelBlock localQCircleCommentPanelBlock = this.c;
    if (localQCircleCommentPanelBlock != null) {
      localQCircleCommentPanelBlock.setReportBean(paramQCircleReportBean);
    }
  }
  
  public void setReportBeanAgent(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.o = paramReportBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView
 * JD-Core Version:    0.7.0.1
 */