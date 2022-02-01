package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.adapter.QCircleFeedCommentAdapter;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.aspectj.QCirclePolymerizeDetailClick;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushReportReqInterceptor;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleAvatarListUtils;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCircleThreadManager;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCircleFeedItemBottomPresenter
  extends QCircleBaseFeedChildPresenter
  implements View.OnClickListener, LayoutPreLoader.RequestPreloadViewListener, SimpleEventReceiver
{
  private static final String TAG = "QCircleFeedItemBottomPresenter";
  private static final int USER_MAX_COUNT = 3;
  private static boolean isShowDialog;
  static final ConcurrentHashMap<String, QCircleFeedCommentEllipseEvent> residualCommentEllipseEventMap = new ConcurrentHashMap();
  static final ConcurrentHashMap<String, QCircleCommentUpdateEvent> residualCommentUpdateEventMap;
  static final ConcurrentHashMap<String, QCirclePolyPraiseUpdateEvent> residualPraiseEventMap;
  static final ConcurrentHashMap<String, QCirclePushUpdateEvent> residualPushUpdateEventMap;
  static final ConcurrentHashMap<String, QCircleUndoPushUpdateEvent> residualUndoPushUpdateEventMap;
  private Activity mActivity;
  private TextView mAllCommentTxt;
  private QCircleFeedCommentAdapter mCommentAdapter;
  private boolean mCommentExpand;
  private QCircleCommentListView mCommentExpandContainer;
  private List<QCircleFeedCommentInfo> mCommentList;
  private RecyclerView mCommentRv;
  private View mCommentWrapper;
  private View mDividerPoint;
  private View mDividerView;
  private TextView mExpressionCountTxt;
  private QCircleAvatarListView mExpressionImg;
  private View mExpressionWrapper;
  private QCircleRecommendImageView mIvPush;
  private QQCircleFeedBase.StLikeBusiData mLikeBusiData;
  private boolean mNeedFixAnimation;
  private View mOperAreaWrapper;
  private QCircleAvatarListView mPushAvatars;
  private TextView mPushCount;
  private View mPushCountWrapper;
  private View mPushListWrapper;
  private QCirclePushAsyncTextView mPushUserListTxt;
  private RecyclerView mRecyclerView;
  private View mRootView;
  private TextView mVisitCountTxt;
  private QCirclePolyLikeFrameLayout mZanView;
  
  static
  {
    ajc$preClinit();
    residualPraiseEventMap = new ConcurrentHashMap();
    residualPushUpdateEventMap = new ConcurrentHashMap();
    residualUndoPushUpdateEventMap = new ConcurrentHashMap();
    residualCommentUpdateEventMap = new ConcurrentHashMap();
  }
  
  private void addOrRemoveReply(FeedCloudMeta.StComment paramStComment, QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (paramQCircleCommentUpdateEvent.eventStatus == 5)
    {
      paramStComment.vecReply.get().add(0, paramQCircleCommentUpdateEvent.reply);
      return;
    }
    if ((paramQCircleCommentUpdateEvent.eventStatus == 6) && (paramStComment.vecReply.size() > 0))
    {
      paramStComment = paramStComment.vecReply.get().iterator();
      while (paramStComment.hasNext()) {
        if (TextUtils.equals(((FeedCloudMeta.StReply)paramStComment.next()).id.get(), paramQCircleCommentUpdateEvent.reply.id.get())) {
          paramStComment.remove();
        }
      }
    }
  }
  
  private void addPolyLike(QQCircleFeedBase.StPolyLike paramStPolyLike, List<QQCircleFeedBase.StPolyLike> paramList)
  {
    int k = 1;
    if (paramStPolyLike == null)
    {
      QLog.w("QCircleFeedItemBottomPresenter", 1, "[addPolyLike] new like not is null.");
      return;
    }
    paramStPolyLike.count.set(1);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      QQCircleFeedBase.StPolyLike localStPolyLike;
      do
      {
        localStPolyLike = paramStPolyLike;
        if (!localIterator.hasNext()) {
          break;
        }
        localStPolyLike = (QQCircleFeedBase.StPolyLike)localIterator.next();
      } while ((localStPolyLike == null) || (!TextUtils.equals(localStPolyLike.polyLikeID.get(), paramStPolyLike.polyLikeID.get())));
      localStPolyLike.count.set(localStPolyLike.count.get() + 1);
      localIterator.remove();
      int i = 0;
      while (i < paramList.size())
      {
        j = k;
        if (localStPolyLike.articleType.get() == 1) {
          break label187;
        }
        if ((localStPolyLike.articleType.get() == 0) && (((QQCircleFeedBase.StPolyLike)paramList.get(i)).articleType.get() == 0))
        {
          j = k;
          break label187;
        }
        i += 1;
      }
      int j = 0;
      label187:
      if (j != 0)
      {
        paramList.add(i, localStPolyLike);
        return;
      }
      paramList.add(localStPolyLike);
    }
  }
  
  private void allCommentTxtVisible()
  {
    TextView localTextView = this.mAllCommentTxt;
    if ((localTextView != null) && (localTextView.getVisibility() == 8))
    {
      localTextView = this.mAllCommentTxt;
      localTextView.setText(localTextView.getResources().getString(2131895706));
      this.mAllCommentTxt.setVisibility(0);
    }
  }
  
  private void bindItemDataReport(FeedCloudMeta.StFeed paramStFeed)
  {
    paramStFeed = new QCirclePushReportReqInterceptor();
    paramStFeed.a(QCirclePluginReportUtil.b(this.mReportInfo.mFeed).setActionType(34).setSubActionType(2).setToUin(this.mReportInfo.mFeed.poster.id.get()).setIndex(this.mReportInfo.mDataPosition).setPageId(getPageId()));
    QCircleRecommendImageView localQCircleRecommendImageView = this.mIvPush;
    if (localQCircleRecommendImageView != null)
    {
      localQCircleRecommendImageView.setPushReportReqInterceptor(paramStFeed);
      if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType != 1) && (this.mExtraTypeInfo.pageType != 10))
      {
        this.mIvPush.setPageType(4);
        return;
      }
      this.mIvPush.setPageType(1);
    }
  }
  
  private boolean canNotShowCommentPanel()
  {
    if (!QCircleBindPhoneNumberHelper.a())
    {
      QCircleBindPhoneNumberHelper.a(this.mActivity, 2);
      return true;
    }
    if ((this.mData instanceof FeedBlockData)) {
      return this.mIntercator == null;
    }
    return true;
  }
  
  private void dropResidualEvent()
  {
    String str = ((FeedBlockData)this.mData).b().id.get();
    residualPushUpdateEventMap.remove(str);
    residualPraiseEventMap.remove(str);
    residualUndoPushUpdateEventMap.remove(str);
    residualCommentEllipseEventMap.remove(str);
    residualCommentUpdateEventMap.remove(str);
  }
  
  private String getPushListUrl(FeedCloudMeta.StPushList paramStPushList)
  {
    if (paramStPushList != null) {
      return paramStPushList.jumpUrl.get().replace("{id}", paramStPushList.id.get());
    }
    QLog.e("QCircleFeedItemBottomPresenter", 1, "getPushListUrl failed,return empty");
    return "";
  }
  
  public static boolean handleBindPhoneNumber(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      if (isShowDialog) {
        return false;
      }
      if (paramContext.getResources() != null)
      {
        String str1 = paramContext.getResources().getString(2131895637);
        String str2 = paramContext.getResources().getString(2131895635);
        QCircleFeedItemBottomPresenter.5 local5 = new QCircleFeedItemBottomPresenter.5(paramContext);
        paramContext = QCircleCustomDialog.a(paramContext, str1, str2, 2131895634, 2131895636, local5, local5);
        paramContext.setCancelable(false);
        isShowDialog = true;
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(1).setThrActionType(paramInt));
        paramContext.show();
      }
      return true;
    }
    return false;
  }
  
  private void handleEvent(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    switch (paramQCircleCommentUpdateEvent.eventStatus)
    {
    case 2: 
    default: 
      return;
    case 8: 
      onReceiveCancelSticky(paramQCircleCommentUpdateEvent);
      return;
    case 7: 
      onReceiveStickyEvent(paramQCircleCommentUpdateEvent);
      return;
    case 5: 
    case 6: 
      onReceiveReplyEvent(paramQCircleCommentUpdateEvent);
      return;
    case 4: 
      onReceiveDeleteComment(paramQCircleCommentUpdateEvent);
      return;
    case 3: 
      onReceiveAddComment(paramQCircleCommentUpdateEvent);
      return;
    }
    ((FeedBlockData)this.mData).b().commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
  }
  
  @QCirclePolymerizeDetailClick
  private void handleOpNormalLaunchDetail()
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_1, this, this);
    handleOpNormalLaunchDetail_aroundBody3$advice(this, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  private void handleResidualEvent()
  {
    String str = ((FeedBlockData)this.mData).b().id.get();
    if (residualPushUpdateEventMap.containsKey(str)) {
      onReceiveEvent((SimpleBaseEvent)residualPushUpdateEventMap.get(str));
    }
    if (residualPraiseEventMap.containsKey(str)) {
      onReceiveEvent((SimpleBaseEvent)residualPraiseEventMap.get(str));
    }
    if (residualUndoPushUpdateEventMap.containsKey(str)) {
      onReceiveEvent((SimpleBaseEvent)residualUndoPushUpdateEventMap.get(str));
    }
    if (residualCommentEllipseEventMap.containsKey(str)) {
      onReceiveEvent((SimpleBaseEvent)residualCommentEllipseEventMap.get(str));
    }
    if (residualCommentUpdateEventMap.containsKey(str)) {
      onReceiveEvent((SimpleBaseEvent)residualCommentUpdateEventMap.get(str));
    }
  }
  
  private void onReceiveAddComment(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (paramQCircleCommentUpdateEvent.comment == null) {
      return;
    }
    if ((((FeedBlockData)this.mData).b().vecComment.get().size() > 0) && (((FeedCloudMeta.StComment)((FeedBlockData)this.mData).b().vecComment.get().get(0)).typeFlag.get() == 1)) {
      ((FeedBlockData)this.mData).b().vecComment.get().add(1, paramQCircleCommentUpdateEvent.comment);
    } else {
      ((FeedBlockData)this.mData).b().vecComment.get().add(0, paramQCircleCommentUpdateEvent.comment);
    }
    ((FeedBlockData)this.mData).b().commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
    updateComments(((FeedBlockData)this.mData).b());
  }
  
  private void onReceiveCancelSticky(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    List localList = ((FeedBlockData)this.mData).b().vecComment.get();
    if ((localList.size() > 0) && (((FeedCloudMeta.StComment)localList.get(0)).typeFlag.get() == 1) && (((FeedCloudMeta.StComment)localList.get(0)).id.get().equals(paramQCircleCommentUpdateEvent.comment.id.get())))
    {
      ((FeedCloudMeta.StComment)localList.get(0)).typeFlag.set(0);
      updateComments(((FeedBlockData)this.mData).b());
    }
  }
  
  private void onReceiveDeleteComment(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (paramQCircleCommentUpdateEvent.comment == null) {
      return;
    }
    Iterator localIterator = ((FeedBlockData)this.mData).b().vecComment.get().iterator();
    while (localIterator.hasNext()) {
      if (((FeedCloudMeta.StComment)localIterator.next()).id.get().equals(paramQCircleCommentUpdateEvent.comment.id.get())) {
        localIterator.remove();
      }
    }
    ((FeedCloudMeta.StFeed)((FeedBlockData)this.mData).b().get()).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
    updateComments(((FeedBlockData)this.mData).b());
  }
  
  private void onReceiveReplyEvent(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    ((FeedBlockData)this.mData).b().commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
    updateReplysEvent(((FeedBlockData)this.mData).b(), paramQCircleCommentUpdateEvent);
  }
  
  private void onReceiveStickyEvent(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    List localList = ((FeedBlockData)this.mData).b().vecComment.get();
    ((FeedBlockData)this.mData).b().vecComment.set(QCirclePluginUtil.a(paramQCircleCommentUpdateEvent.comment.id.get(), localList));
    updateComments(((FeedBlockData)this.mData).b());
  }
  
  private void removePolyLike(QQCircleFeedBase.StPolyLike paramStPolyLike, List<QQCircleFeedBase.StPolyLike> paramList)
  {
    if ((paramStPolyLike != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      QQCircleFeedBase.StPolyLike localStPolyLike;
      do
      {
        localStPolyLike = paramStPolyLike;
        if (!localIterator.hasNext()) {
          break;
        }
        localStPolyLike = (QQCircleFeedBase.StPolyLike)localIterator.next();
      } while (!TextUtils.equals(localStPolyLike.polyLikeID.get(), paramStPolyLike.polyLikeID.get()));
      localStPolyLike.count.set(localStPolyLike.count.get() - 1);
      localIterator.remove();
      if (localStPolyLike.count.get() == 0) {
        return;
      }
      int k = 0;
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= paramList.size()) {
          break label218;
        }
        if ((localStPolyLike.count.get() > ((QQCircleFeedBase.StPolyLike)paramList.get(i)).count.get()) || ((localStPolyLike.count.get() == ((QQCircleFeedBase.StPolyLike)paramList.get(i)).count.get()) && (Integer.parseInt(localStPolyLike.polyLikeID.get()) <= Integer.parseInt(((QQCircleFeedBase.StPolyLike)paramList.get(i)).polyLikeID.get())))) {
          break;
        }
        i += 1;
      }
      int j = 1;
      label218:
      if (j != 0)
      {
        paramList.add(i, localStPolyLike);
        return;
      }
      paramList.add(localStPolyLike);
    }
  }
  
  private void removePolyLike(QQCircleFeedBase.StPolyLike paramStPolyLike, List<QQCircleFeedBase.StPolyLike> paramList, FeedCloudMeta.StLike paramStLike)
  {
    if ((paramStPolyLike != null) && (paramList != null))
    {
      if (paramStLike == null) {
        return;
      }
      if (paramStLike.count.get() <= 0) {
        paramList.clear();
      }
    }
  }
  
  private void setOnClick()
  {
    this.mCommentWrapper.setOnClickListener(this);
    this.mAllCommentTxt.setOnClickListener(this);
    this.mExpressionWrapper.setOnClickListener(this);
    this.mOperAreaWrapper.setOnClickListener(this);
    this.mZanView.setOnClickHookListener(new QCircleFeedItemBottomPresenter.2(this));
  }
  
  private void updateComments(FeedCloudMeta.StFeed paramStFeed)
  {
    int j = paramStFeed.vecComment.size();
    int i = 8;
    if (j == 0) {
      this.mDividerView.setVisibility(8);
    } else {
      this.mDividerView.setVisibility(0);
    }
    Object localObject1;
    Object localObject2;
    if (this.mCommentExpand)
    {
      localObject1 = new QCircleCommentInfo();
      ((QCircleCommentInfo)localObject1).b = paramStFeed;
      ((QCircleCommentInfo)localObject1).c = this.mExtraTypeInfo;
      ((QCircleCommentInfo)localObject1).i = 6;
      ((QCircleCommentInfo)localObject1).g = QCircleCommentInfo.j;
      localObject2 = this.mCommentExpandContainer;
      if (localObject2 != null)
      {
        if (paramStFeed.vecComment.get().size() != 0) {
          i = 0;
        }
        ((QCircleCommentListView)localObject2).setVisibility(i);
        this.mCommentExpandContainer.setDataPosInList(getPos());
        this.mCommentExpandContainer.setParentRecyclerView(this.mRecyclerView);
        this.mCommentExpandContainer.setReportBean(getReportBean());
        this.mCommentExpandContainer.setFeedData(paramStFeed);
        this.mCommentExpandContainer.setData(localObject1);
      }
    }
    else
    {
      localObject1 = new ArrayList();
      localObject2 = paramStFeed.vecComment.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)((Iterator)localObject2).next();
        ((List)localObject1).add(new QCircleFeedCommentInfo(paramStFeed, localStComment));
        Iterator localIterator = localStComment.vecReply.get().iterator();
        while (localIterator.hasNext()) {
          ((List)localObject1).add(new QCircleFeedCommentInfo(paramStFeed, localStComment, (FeedCloudMeta.StReply)localIterator.next()));
        }
      }
      this.mCommentList = ((List)localObject1);
      if (this.mCommentAdapter == null)
      {
        this.mCommentAdapter = new QCircleFeedCommentAdapter();
        this.mCommentAdapter.a(getReportBean());
      }
      if (paramStFeed.commentCount.get() > ((List)localObject1).size())
      {
        localObject2 = this.mAllCommentTxt;
        ((TextView)localObject2).setText(((TextView)localObject2).getResources().getString(2131895707, new Object[] { QCirclePluginUtil.a(paramStFeed.commentCount.get(), true) }));
        this.mAllCommentTxt.setVisibility(0);
      }
      else
      {
        this.mAllCommentTxt.setVisibility(8);
      }
      this.mCommentAdapter.a((List)localObject1);
      this.mCommentAdapter.a(this.mRecyclerView);
      this.mCommentAdapter.a(this.mReportInfo);
      this.mCommentAdapter.a(this.mIntercator);
      this.mCommentRv.setAdapter(this.mCommentAdapter);
    }
  }
  
  private void updateDividePoint()
  {
    View localView = this.mPushCountWrapper;
    if ((localView != null) && (this.mExpressionCountTxt != null))
    {
      if (this.mDividerPoint == null) {
        return;
      }
      if ((localView.getVisibility() == 0) && (this.mExpressionCountTxt.getVisibility() == 0))
      {
        this.mDividerPoint.setVisibility(0);
        return;
      }
      this.mDividerPoint.setVisibility(8);
    }
  }
  
  private void updateExpressionView(FeedBlockData paramFeedBlockData)
  {
    FeedCloudMeta.StFeed localStFeed = paramFeedBlockData.b();
    Object localObject1 = paramFeedBlockData.a("DITTO_FEED_LIKE_INFO");
    this.mLikeBusiData = null;
    if ((localObject1 instanceof QQCircleFeedBase.StLikeBusiData)) {
      this.mLikeBusiData = ((QQCircleFeedBase.StLikeBusiData)paramFeedBlockData.a("DITTO_FEED_LIKE_INFO"));
    }
    paramFeedBlockData = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject2 = this.mLikeBusiData;
    int i;
    if (localObject2 != null) {
      i = Math.min(((QQCircleFeedBase.StLikeBusiData)localObject2).polyLikeInfo.size(), 3);
    } else {
      i = 0;
    }
    int j = 0;
    while (j < i)
    {
      localObject2 = (QQCircleFeedBase.StPolyLike)this.mLikeBusiData.polyLikeInfo.get(j);
      if ((localObject2 != null) && (((QQCircleFeedBase.StPolyLike)localObject2).polyIconUrl != null)) {
        paramFeedBlockData.add(((QQCircleFeedBase.StPolyLike)localObject2).polyIconUrl.get());
      }
      if ((localObject2 != null) && (((QQCircleFeedBase.StPolyLike)localObject2).polyUnderPicUrl != null)) {
        ((ArrayList)localObject1).add(((QQCircleFeedBase.StPolyLike)localObject2).polyUnderPicUrl.get());
      }
      j += 1;
    }
    localObject2 = this.mExpressionImg;
    if (localObject2 != null) {
      ((QCircleAvatarListView)localObject2).setData(paramFeedBlockData, (List)localObject1);
    }
    paramFeedBlockData = this.mExpressionCountTxt;
    if (paramFeedBlockData != null)
    {
      paramFeedBlockData.setVisibility(8);
      if ((localStFeed != null) && (localStFeed.likeInfo != null) && (localStFeed.likeInfo.count.get() > 0))
      {
        this.mExpressionCountTxt.setVisibility(0);
        this.mExpressionCountTxt.setText(QCirclePluginUtil.d(localStFeed.likeInfo.count.get()));
      }
    }
    updateDividePoint();
  }
  
  private void updatePraiseView(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.mIntercator == null) {
      return;
    }
    this.mZanView.setAniView(this.mIntercator.b());
    this.mZanView.setFeedData(paramStFeed);
    this.mZanView.setExtraTypeInfo(this.mReportInfo);
    if (this.mExtraTypeInfo != null) {
      this.mExtraTypeInfo.mDataPosition = this.mPos;
    }
    if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType != 1) && (this.mExtraTypeInfo.pageType != 10))
    {
      this.mZanView.setPushPageType(4);
      return;
    }
    this.mZanView.setPushPageType(1);
  }
  
  private void updatePushAvatars(List<FeedCloudMeta.StUser> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      QCircleAvatarListView localQCircleAvatarListView = this.mPushAvatars;
      if (localQCircleAvatarListView == null) {
        return;
      }
      localQCircleAvatarListView.setData(QCircleAvatarListUtils.a(paramList, 3));
      this.mPushAvatars.setOnClickListener(this);
    }
  }
  
  private void updatePushCount(int paramInt)
  {
    Object localObject = this.mPushCountWrapper;
    if (localObject != null)
    {
      if (this.mPushCount == null) {
        return;
      }
      ((View)localObject).setVisibility(0);
      this.mPushCountWrapper.setOnClickListener(this);
      TextView localTextView = this.mPushCount;
      if (paramInt > 0) {
        localObject = QCirclePluginUtil.a(paramInt, false);
      } else {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void updatePushListTxt(List<FeedCloudMeta.StUser> paramList, int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 0)
    {
      paramList = this.mPushCountWrapper;
      if (paramList != null) {
        paramList.setVisibility(8);
      }
      paramList = this.mPushListWrapper;
      if (paramList != null) {
        paramList.setVisibility(8);
      }
      updateDividePoint();
      return;
    }
    updatePushCount(paramInt1);
    if ((paramList != null) && (paramList.size() != 0))
    {
      updatePushAvatars(paramList);
      updatePushUserList(paramList, paramInt2);
      updateDividePoint();
      return;
    }
    paramList = this.mPushListWrapper;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    updateDividePoint();
  }
  
  private void updatePushUserList(FeedBlockData paramFeedBlockData)
  {
    FeedCloudMeta.StFeed localStFeed = paramFeedBlockData.b();
    Object localObject = (QQCircleFeedBase.StFeedBusiReqData)paramFeedBlockData.a("DITTO_FEED_BUSI_REQ_DATA");
    paramFeedBlockData = (FeedBlockData)localObject;
    if (localObject == null) {
      paramFeedBlockData = new QQCircleFeedBase.StFeedBusiReqData();
    }
    localObject = QCirclePushInfoManager.a().a(localStFeed.id.get());
    if (localObject != null) {
      paramFeedBlockData.pushList.set((MessageMicro)localObject);
    }
    localStFeed.busiData.set(ByteStringMicro.copyFrom(paramFeedBlockData.toByteArray()));
    localObject = paramFeedBlockData.pushList.vecUser.get();
    int i;
    if (localStFeed.opMask2.get().contains(Integer.valueOf(8))) {
      i = paramFeedBlockData.pushList.totalClickCount.get();
    } else {
      i = 0;
    }
    updatePushListTxt((List)localObject, i, paramFeedBlockData.pushList.count.get(), getPushListUrl((FeedCloudMeta.StPushList)paramFeedBlockData.pushList.get()));
  }
  
  private void updatePushUserList(List<FeedCloudMeta.StUser> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if ((this.mPushUserListTxt != null) && (this.mPushAvatars != null))
      {
        Object localObject = this.mPushListWrapper;
        if (localObject == null) {
          return;
        }
        ((View)localObject).setVisibility(0);
        this.mPushUserListTxt.setBold(true);
        this.mPushUserListTxt.setOnClickItemListener(new QCircleFeedItemBottomPresenter.4(this));
        if (paramInt > 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131895718));
          ((StringBuilder)localObject).append(QCirclePluginUtil.a(paramInt, true));
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131895717));
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = this.mContainer.getContext().getString(2131895716);
        }
        this.mPushAvatars.measure(0, 0);
        this.mPushUserListTxt.setDataList(null, "", paramList, (String)localObject, this.mPushAvatars.getMeasuredWidth() + ViewUtils.a(4.0F));
      }
    }
  }
  
  private void updatePushView(FeedBlockData paramFeedBlockData)
  {
    FeedCloudMeta.StFeed localStFeed = paramFeedBlockData.b();
    if (localStFeed == null) {
      return;
    }
    if (this.mIvPush != null)
    {
      if (!isFakeFeed()) {
        this.mIvPush.setFeedData(paramFeedBlockData, 1);
      }
      if (QCirclePluginUtil.d(localStFeed.poster.id.get()))
      {
        this.mIvPush.setVisibility(8);
        return;
      }
      this.mIvPush.setVisibility(0);
    }
  }
  
  private void updateReplysEvent(FeedCloudMeta.StFeed paramStFeed, QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if ((paramStFeed != null) && (paramQCircleCommentUpdateEvent != null) && (paramQCircleCommentUpdateEvent.comment != null))
    {
      if (paramQCircleCommentUpdateEvent.reply == null) {
        return;
      }
      List localList = paramStFeed.vecComment.get();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
        if (TextUtils.equals(localStComment.id.get(), paramQCircleCommentUpdateEvent.comment.id.get())) {
          addOrRemoveReply(localStComment, paramQCircleCommentUpdateEvent);
        }
      }
      paramStFeed.vecComment.set(localList);
      this.mData = new FeedBlockData(paramStFeed).c();
      updateComments(paramStFeed);
    }
  }
  
  private void updateReportInfo(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.mReportInfo == null)
    {
      QLog.d("QCircleFeedItemBottomPresenter", 1, "[updateReportInfo] report info not is null.");
      return;
    }
    this.mReportInfo.mDataPosition = this.mPos;
    this.mReportInfo.mFeed = paramStFeed;
    this.mReportInfo.mPlayScene = 1;
    if (getParentView() == null) {
      paramStFeed = null;
    } else {
      paramStFeed = getParentView().getQCircleExtraTypeInfo();
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = this.mReportInfo;
    if (paramStFeed == null) {
      localObject = this.mReportInfo.mCurrentPersonalUin;
    } else {
      localObject = paramStFeed.mCurrentPersonalUin;
    }
    localQCircleExtraTypeInfo.mCurrentPersonalUin = ((String)localObject);
    localQCircleExtraTypeInfo = this.mReportInfo;
    Object localObject = paramStFeed;
    if (paramStFeed == null) {
      localObject = this.mReportInfo;
    }
    localQCircleExtraTypeInfo.pageType = ((QCircleExtraTypeInfo)localObject).pageType;
  }
  
  private void updateVisitCountView(FeedCloudMeta.StFeed paramStFeed)
  {
    TextView localTextView = this.mVisitCountTxt;
    if (localTextView == null) {
      return;
    }
    localTextView.setVisibility(8);
    paramStFeed = paramStFeed.visitorInfo.viewDesc.get();
    if (!TextUtils.isEmpty(paramStFeed))
    {
      this.mVisitCountTxt.setText(paramStFeed);
      this.mVisitCountTxt.setVisibility(0);
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData != null) && ((this.mData instanceof FeedBlockData)))
    {
      paramObject = (FeedBlockData)this.mData;
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
      updateReportInfo(localStFeed);
      updateComments(localStFeed);
      updatePraiseView(localStFeed);
      updateExpressionView(paramObject);
      updateVisitCountView(localStFeed);
      updatePushUserList(paramObject);
      updatePushView(paramObject);
      if (paramInt == 0) {
        if (QCirclePopupWindowHelper.a().b()) {
          QCirclePopupWindowHelper.a().a(this.mActivity, this.mIvPush);
        } else {
          this.mNeedFixAnimation = true;
        }
      }
      QCircleThreadManager.a().a(new QCircleFeedItemBottomPresenter.3(this, localStFeed));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleUndoPushUpdateEvent.class);
    localArrayList.add(QCircleCommonAnimationEvent.class);
    localArrayList.add(QCircleFeedCommentEllipseEvent.class);
    return localArrayList;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemBottomPresenter";
  }
  
  public QCircleReportBean getReportBean()
  {
    return super.getReportBean();
  }
  
  public void initView(View paramView)
  {
    if ((paramView.getContext() instanceof Activity)) {
      this.mActivity = ((Activity)paramView.getContext());
    }
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440926), this);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    handleResidualEvent();
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramView);
    onClick_aroundBody1$advice(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    dropResidualEvent();
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mRootView = this.mContainer.findViewById(2131437424);
    this.mZanView = ((QCirclePolyLikeFrameLayout)this.mContainer.findViewById(2131441654));
    this.mOperAreaWrapper = this.mContainer.findViewById(2131441912);
    this.mCommentWrapper = this.mContainer.findViewById(2131441629);
    this.mIvPush = ((QCircleRecommendImageView)this.mContainer.findViewById(2131441633));
    this.mAllCommentTxt = ((TextView)this.mContainer.findViewById(2131441602));
    this.mExpressionWrapper = this.mContainer.findViewById(2131441624);
    this.mExpressionImg = ((QCircleAvatarListView)this.mContainer.findViewById(2131441623));
    this.mExpressionCountTxt = ((TextView)this.mContainer.findViewById(2131441622));
    this.mVisitCountTxt = ((TextView)this.mContainer.findViewById(2131441911));
    this.mPushListWrapper = this.mContainer.findViewById(2131441658);
    this.mPushUserListTxt = ((QCirclePushAsyncTextView)this.mContainer.findViewById(2131448666));
    this.mPushAvatars = ((QCircleAvatarListView)this.mContainer.findViewById(2131441824));
    this.mPushCountWrapper = this.mContainer.findViewById(2131441829);
    this.mPushCount = ((TextView)this.mContainer.findViewById(2131441826));
    this.mDividerPoint = this.mContainer.findViewById(2131441609);
    this.mDividerView = this.mContainer.findViewById(2131449815);
    this.mCommentRv = ((RecyclerView)this.mContainer.findViewById(2131441598));
    this.mCommentExpandContainer = ((QCircleCommentListView)this.mContainer.findViewById(2131441594));
    paramView = new QCircleFeedItemBottomPresenter.1(this, this.mContainer.getContext(), 1, false);
    this.mCommentRv.setLayoutManager(paramView);
    RFWTypefaceUtil.a(this.mExpressionCountTxt, false);
    RFWTypefaceUtil.a(this.mPushCount, false);
    setOnClick();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      updateCommentStatus((QCircleCommentUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent))
    {
      updateExpressionChange((QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
    {
      updatePushListChange((QCirclePushUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleUndoPushUpdateEvent))
    {
      updatePushListChange((QCircleUndoPushUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleCommonAnimationEvent))
    {
      updatePushGuideAnimation((QCircleCommonAnimationEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFeedCommentEllipseEvent)) {
      updateFeedCommentEllipse((QCircleFeedCommentEllipseEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setCommentExpand(boolean paramBoolean)
  {
    this.mCommentExpand = paramBoolean;
    Object localObject = this.mCommentRv;
    int j = 8;
    int i;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      ((RecyclerView)localObject).setVisibility(i);
    }
    localObject = this.mAllCommentTxt;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      ((TextView)localObject).setVisibility(i);
    }
    localObject = this.mCommentExpandContainer;
    if ((localObject != null) && (((QCircleCommentListView)localObject).getBlockContainer() != null))
    {
      localObject = this.mCommentExpandContainer;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      ((QCircleCommentListView)localObject).setVisibility(i);
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    QCirclePolyLikeFrameLayout localQCirclePolyLikeFrameLayout = this.mZanView;
    if (localQCirclePolyLikeFrameLayout != null) {
      localQCirclePolyLikeFrameLayout.setReportBean(paramQCircleReportBean);
    }
    setCommentExpand(QCircleReportBean.isFeedDetailPage(getReportBean().getPageId()));
  }
  
  public void setShareRecyclerViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    Object localObject = this.mCommentExpandContainer;
    if ((localObject != null) && (((QCircleCommentListView)localObject).getBlockContainer() != null)) {
      this.mCommentExpandContainer.getBlockContainer().getRecyclerView().setRecycledViewPool(paramRecycledViewPool);
    }
    localObject = this.mCommentRv;
    if (localObject != null) {
      ((RecyclerView)localObject).setRecycledViewPool(paramRecycledViewPool);
    }
  }
  
  public void showCommentPanelOutSide(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt, boolean paramBoolean)
  {
    if (canNotShowCommentPanel()) {
      return;
    }
    QCircleCommentInfo localQCircleCommentInfo = new QCircleCommentInfo();
    localQCircleCommentInfo.b = ((FeedBlockData)this.mData).b();
    localQCircleCommentInfo.c = this.mReportInfo;
    localQCircleCommentInfo.d = paramStComment;
    localQCircleCommentInfo.e = paramStReply;
    if (this.mReportInfo != null) {
      localObject = this.mReportInfo.mFeed;
    } else {
      localObject = null;
    }
    Object localObject = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject);
    int j = 6;
    int i;
    if ((paramStComment == null) && (paramStReply == null)) {
      i = 6;
    } else {
      i = 9;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = ((QCircleLpReportDc05501.DataBuilder)localObject).setActionType(i).setSubActionType(2);
    if ((this.mReportInfo != null) && (this.mReportInfo.mFeed != null)) {
      localObject = this.mReportInfo.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    localObject = localDataBuilder.setToUin((String)localObject);
    if (this.mReportInfo != null) {
      i = this.mReportInfo.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(getPageId())));
    if (paramBoolean)
    {
      localQCircleCommentInfo.i = 116;
    }
    else
    {
      if ((paramStComment == null) && (paramStReply == null)) {
        i = j;
      } else {
        i = 9;
      }
      localQCircleCommentInfo.i = i;
    }
    localQCircleCommentInfo.h = paramInt;
    if (this.mCommentExpand)
    {
      paramStComment = this.mCommentExpandContainer;
      if (paramStComment != null)
      {
        paramStComment.a(localQCircleCommentInfo.d, localQCircleCommentInfo.e);
        return;
      }
    }
    this.mIntercator.a("comment_input_window_show", localQCircleCommentInfo);
  }
  
  public void updateCommentStatus(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (this.mCommentExpand) {
      return;
    }
    if (paramQCircleCommentUpdateEvent != null)
    {
      if (!(this.mData instanceof FeedBlockData)) {
        return;
      }
      if (((FeedBlockData)this.mData).b().id.get().equals(paramQCircleCommentUpdateEvent.feedId))
      {
        handleEvent(paramQCircleCommentUpdateEvent);
        return;
      }
      residualCommentUpdateEventMap.put(paramQCircleCommentUpdateEvent.feedId, paramQCircleCommentUpdateEvent);
    }
  }
  
  public void updateExpressionChange(QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent)
  {
    if ((paramQCirclePolyPraiseUpdateEvent != null) && ((this.mData instanceof FeedBlockData)))
    {
      if (this.mLikeBusiData == null) {
        return;
      }
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
      if (!TextUtils.equals(localStFeed.id.get(), paramQCirclePolyPraiseUpdateEvent.mTargetFeedId))
      {
        residualPraiseEventMap.put(paramQCirclePolyPraiseUpdateEvent.mTargetFeedId, paramQCirclePolyPraiseUpdateEvent);
        return;
      }
      List localList = this.mLikeBusiData.polyLikeInfo.get();
      int i = paramQCirclePolyPraiseUpdateEvent.mPraisedStatus;
      if (i != 0)
      {
        if ((i == 1) || (i == 2) || (i == 21)) {
          addPolyLike(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike, localList);
        }
      }
      else if (QCirclePolyLikeManager.c(localStFeed)) {
        removePolyLike(paramQCirclePolyPraiseUpdateEvent.moldStPolyLike, localList, (FeedCloudMeta.StLike)localStFeed.likeInfo.get());
      } else {
        removePolyLike(paramQCirclePolyPraiseUpdateEvent.moldStPolyLike, localList);
      }
      ((FeedBlockData)this.mData).a("DITTO_FEED_LIKE_INFO", this.mLikeBusiData);
      updateFeed(paramQCirclePolyPraiseUpdateEvent, (FeedBlockData)this.mData, localList);
    }
  }
  
  public void updateFeed(QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent, FeedBlockData paramFeedBlockData, List<QQCircleFeedBase.StPolyLike> paramList)
  {
    this.mLikeBusiData.polyLikeInfo.set(paramList);
    if (paramQCirclePolyPraiseUpdateEvent.mPraisedStatus == 21) {
      this.mLikeBusiData.rewardstatus.set(1);
    }
    if (!this.mLikeBusiData.likeIDs.get().contains(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike.polyLikeID.get())) {
      this.mLikeBusiData.likeIDs.get().add(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike.polyLikeID.get());
    }
    paramList = paramFeedBlockData.b();
    if (paramList == null)
    {
      QLog.d("QCircleFeedItemBottomPresenter", 2, "[updateFeed] feed not is null.");
      return;
    }
    paramList.likeInfo.count.set(paramQCirclePolyPraiseUpdateEvent.mPraisedNum);
    paramList.likeInfo.busiData.set(ByteStringMicro.copyFrom(this.mLikeBusiData.toByteArray()));
    this.mData = new FeedBlockData(paramList).c();
    updateExpressionView(paramFeedBlockData);
  }
  
  public void updateFeedCommentEllipse(QCircleFeedCommentEllipseEvent paramQCircleFeedCommentEllipseEvent)
  {
    if ((this.mCommentList != null) && (paramQCircleFeedCommentEllipseEvent.mInfo != null) && (paramQCircleFeedCommentEllipseEvent.mInfo.a != null))
    {
      if (paramQCircleFeedCommentEllipseEvent.mInfo.b == null) {
        return;
      }
      Iterator localIterator = this.mCommentList.iterator();
      while (localIterator.hasNext())
      {
        QCircleFeedCommentInfo localQCircleFeedCommentInfo = (QCircleFeedCommentInfo)localIterator.next();
        if ((localQCircleFeedCommentInfo.a != null) && (localQCircleFeedCommentInfo.a.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.a.id.get())))
        {
          if ((localQCircleFeedCommentInfo.b != null) && (localQCircleFeedCommentInfo.b.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.b.id.get())) && (localQCircleFeedCommentInfo.c == null) && (paramQCircleFeedCommentEllipseEvent.mInfo.c == null))
          {
            allCommentTxtVisible();
            return;
          }
          if ((localQCircleFeedCommentInfo.b != null) && (localQCircleFeedCommentInfo.b.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.b.id.get())) && (localQCircleFeedCommentInfo.c != null) && (paramQCircleFeedCommentEllipseEvent.mInfo.c != null) && (localQCircleFeedCommentInfo.c.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.c.id.get()))) {
            allCommentTxtVisible();
          }
        }
        else
        {
          residualCommentEllipseEventMap.put(paramQCircleFeedCommentEllipseEvent.mInfo.a.id.get(), paramQCircleFeedCommentEllipseEvent);
        }
      }
    }
  }
  
  public void updatePushGuideAnimation(QCircleCommonAnimationEvent paramQCircleCommonAnimationEvent)
  {
    if ((paramQCircleCommonAnimationEvent.mType == QCircleCommonAnimationEvent.TYPE_SPLASH_VIDEO) && (paramQCircleCommonAnimationEvent.mState == QCircleCommonAnimationEvent.STATE_ANIMATION_END) && (this.mNeedFixAnimation))
    {
      paramQCircleCommonAnimationEvent = this.mIvPush;
      if ((paramQCircleCommonAnimationEvent != null) && (paramQCircleCommonAnimationEvent.getVisibility() == 0))
      {
        QCirclePopupWindowHelper.a().a(this.mActivity, this.mIvPush);
        this.mNeedFixAnimation = false;
      }
    }
  }
  
  public void updatePushListChange(QCirclePushUpdateEvent paramQCirclePushUpdateEvent)
  {
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    if ((paramQCirclePushUpdateEvent != null) && (TextUtils.equals(localStFeed.id.get(), paramQCirclePushUpdateEvent.mTargetFeedId)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePushUserList feedId");
      localStringBuilder.append(paramQCirclePushUpdateEvent.mTargetFeedId);
      localStringBuilder.append(" allPushTimes:");
      localStringBuilder.append(paramQCirclePushUpdateEvent.mAllPushTimes);
      QLog.d("QCircleFeedItemBottomPresenter", 1, localStringBuilder.toString());
      paramQCirclePushUpdateEvent = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        paramQCirclePushUpdateEvent.mergeFrom(localStFeed.busiData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.e("QCircleFeedItemBottomPresenter", 1, "[updatePushListChange] error: ", localInvalidProtocolBufferMicroException);
      }
      QCirclePushInfoManager.a().a(localStFeed.id.get(), paramQCirclePushUpdateEvent.pushList);
      localStFeed.busiData.set(ByteStringMicro.copyFrom(paramQCirclePushUpdateEvent.toByteArray()));
      List localList = paramQCirclePushUpdateEvent.pushList.vecUser.get();
      int i;
      if (localStFeed.opMask2.get().contains(Integer.valueOf(8))) {
        i = paramQCirclePushUpdateEvent.pushList.totalClickCount.get();
      } else {
        i = 0;
      }
      updatePushListTxt(localList, i, paramQCirclePushUpdateEvent.pushList.count.get(), getPushListUrl((FeedCloudMeta.StPushList)paramQCirclePushUpdateEvent.pushList.get()));
      return;
    }
    residualPushUpdateEventMap.put(paramQCirclePushUpdateEvent.mTargetFeedId, paramQCirclePushUpdateEvent);
  }
  
  public void updatePushListChange(QCircleUndoPushUpdateEvent paramQCircleUndoPushUpdateEvent)
  {
    FeedCloudMeta.StFeed localStFeed;
    if (paramQCircleUndoPushUpdateEvent != null)
    {
      if (this.mData == null) {
        return;
      }
      localStFeed = ((FeedBlockData)this.mData).b();
      if ((localStFeed == null) || (!TextUtils.equals(localStFeed.id.get(), paramQCircleUndoPushUpdateEvent.mTargetFeedId))) {}
    }
    for (;;)
    {
      try
      {
        paramQCircleUndoPushUpdateEvent = new QQCircleFeedBase.StFeedBusiReqData();
        paramQCircleUndoPushUpdateEvent.mergeFrom(localStFeed.busiData.get().toByteArray());
        Object localObject = QCirclePushInfoManager.a().a(localStFeed.id.get());
        paramQCircleUndoPushUpdateEvent.pushList.set((MessageMicro)localObject);
        localStFeed.busiData.set(ByteStringMicro.copyFrom(paramQCircleUndoPushUpdateEvent.toByteArray()));
        localObject = paramQCircleUndoPushUpdateEvent.pushList.vecUser.get();
        if (!localStFeed.opMask2.get().contains(Integer.valueOf(8))) {
          break label211;
        }
        i = paramQCircleUndoPushUpdateEvent.pushList.totalClickCount.get();
        updatePushListTxt((List)localObject, i, paramQCircleUndoPushUpdateEvent.pushList.count.get(), getPushListUrl((FeedCloudMeta.StPushList)paramQCircleUndoPushUpdateEvent.pushList.get()));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQCircleUndoPushUpdateEvent)
      {
        QLog.e("QCircleFeedItemBottomPresenter", 1, "[updatePushListChange] error: ", paramQCircleUndoPushUpdateEvent);
        return;
      }
      residualUndoPushUpdateEventMap.put(paramQCircleUndoPushUpdateEvent.mTargetFeedId, paramQCircleUndoPushUpdateEvent);
      return;
      label211:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBottomPresenter
 * JD-Core Version:    0.7.0.1
 */