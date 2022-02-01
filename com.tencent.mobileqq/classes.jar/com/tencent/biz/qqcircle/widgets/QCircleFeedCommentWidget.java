package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import androidx.annotation.NonNull;
import androidx.core.text.BidiFormatter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.OnDismissListener;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

public class QCircleFeedCommentWidget
  extends QCircleBaseWidgetView<QCircleFeedCommentInfo>
  implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver
{
  private static final String b = HardCodeUtil.a(2131895886);
  BubblePopupWindow.OnDismissListener a = new QCircleFeedCommentWidget.13(this);
  private QCircleAsyncTextView c;
  private QCircleFeedCommentInfo d;
  private int e;
  private RecyclerView f;
  private SoftKeyboardStateHelper g;
  private Drawable h;
  
  static {}
  
  public QCircleFeedCommentWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    boolean bool = d();
    Object localObject1 = "";
    Object localObject3 = null;
    Object localObject2 = null;
    int k = -1;
    if (bool)
    {
      if (getQCircleExtraTypeInfo() != null) {
        localObject2 = getQCircleExtraTypeInfo().mFeed;
      }
      localObject3 = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject2)).setActionType(paramInt).setSubActionType(2);
      localObject2 = localObject1;
      if (getQCircleExtraTypeInfo() != null)
      {
        localObject2 = localObject1;
        if (getQCircleExtraTypeInfo().mFeed != null) {
          localObject2 = getQCircleExtraTypeInfo().mFeed.poster.id.get();
        }
      }
      localObject1 = ((QCircleLpReportDc05507.DataBuilder)localObject3).setToUin((String)localObject2);
      if (getExtraTypeInfo() != null) {
        paramInt = getQCircleExtraTypeInfo().mDataPosition;
      } else {
        paramInt = -1;
      }
      localObject1 = ((QCircleLpReportDc05507.DataBuilder)localObject1).setPosition(paramInt);
      if (getExtraTypeInfo() != null) {
        k = getQCircleExtraTypeInfo().mPlayScene;
      }
      QCircleLpReportDc05507.report(((QCircleLpReportDc05507.DataBuilder)localObject1).setPlayScene(k).setPageId(getPageId()).setfpageid(getParentPageId()));
      return;
    }
    localObject2 = localObject3;
    if (getExtraTypeInfo() != null) {
      localObject2 = getQCircleExtraTypeInfo().mFeed;
    }
    localObject3 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject2).setActionType(paramInt).setSubActionType(2);
    localObject2 = localObject1;
    if (getQCircleExtraTypeInfo() != null)
    {
      localObject2 = localObject1;
      if (getQCircleExtraTypeInfo().mFeed != null) {
        localObject2 = getQCircleExtraTypeInfo().mFeed.poster.id.get();
      }
    }
    localObject1 = ((QCircleLpReportDc05501.DataBuilder)localObject3).setToUin((String)localObject2);
    if (getExtraTypeInfo() != null) {
      k = getQCircleExtraTypeInfo().mDataPosition;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject1).setIndex(k).setPageId(getPageId())));
  }
  
  private void a(View paramView)
  {
    b();
    b(paramView);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    a(62);
    QCirclePopupWindowHelper.a().a(paramView, paramStFeed, paramStComment, new QCircleFeedCommentWidget.9(this, paramStFeed, paramStComment), this.a);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    QCirclePopupWindowHelper.a().a(paramView, paramStFeed, paramStReply, new QCircleFeedCommentWidget.12(this, paramStReply, paramStFeed, paramStComment), this.a);
  }
  
  private void a(QCircleCommentPraiseUpdateEvent paramQCircleCommentPraiseUpdateEvent)
  {
    QCircleFeedCommentInfo localQCircleFeedCommentInfo = this.d;
    if ((localQCircleFeedCommentInfo != null) && (localQCircleFeedCommentInfo.a != null) && (this.d.b != null))
    {
      if (!TextUtils.equals(this.d.a.id.get(), paramQCircleCommentPraiseUpdateEvent.mFeedId)) {
        return;
      }
      if ((paramQCircleCommentPraiseUpdateEvent.mType == 1) && (this.d.c == null))
      {
        if (TextUtils.equals(this.d.b.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId))
        {
          if (QCirclePluginUtil.b((FeedCloudMeta.StUser)this.d.a.poster.get())) {
            this.d.b.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
          }
          this.d.b.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
          this.d.b.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
          setCommentTxt(this.d.b);
        }
      }
      else if ((paramQCircleCommentPraiseUpdateEvent.mType == 2) && (this.d.c != null) && (TextUtils.equals(this.d.b.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId)) && (TextUtils.equals(this.d.c.id.get(), paramQCircleCommentPraiseUpdateEvent.mReplyId)))
      {
        if (QCirclePluginUtil.b((FeedCloudMeta.StUser)this.d.a.poster.get())) {
          this.d.c.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
        }
        this.d.c.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
        this.d.c.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
        setReplyTxt(this.d.c);
      }
    }
  }
  
  private void a(QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if (paramQCircleAsyncTextView != null)
    {
      paramQCircleAsyncTextView.setPreloadText(null, "");
      paramQCircleAsyncTextView.a(false);
      paramQCircleAsyncTextView.setText("");
      paramQCircleAsyncTextView.setVisibility(8);
    }
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt)
  {
    if (a()) {
      return;
    }
    if ((getInteractor() instanceof QCircleInteractor))
    {
      QCircleInteractor localQCircleInteractor = (QCircleInteractor)getInteractor();
      QCircleCommentInfo localQCircleCommentInfo = new QCircleCommentInfo();
      localQCircleCommentInfo.b = this.d.a;
      boolean bool = getExtraTypeInfo() instanceof QCircleExtraTypeInfo;
      Object localObject3 = null;
      Object localObject2 = null;
      if (bool) {
        localObject1 = (QCircleExtraTypeInfo)getExtraTypeInfo();
      } else {
        localObject1 = null;
      }
      localQCircleCommentInfo.c = ((QCircleExtraTypeInfo)localObject1);
      localQCircleCommentInfo.d = paramStComment;
      localQCircleCommentInfo.e = paramStReply;
      int k = -1;
      Object localObject1 = "";
      if ((paramStComment == null) && (paramStReply == null))
      {
        paramStComment = localObject2;
        if (getQCircleExtraTypeInfo() != null) {
          paramStComment = getQCircleExtraTypeInfo().mFeed;
        }
        paramStReply = QCirclePluginReportUtil.b(paramStComment).setActionType(6).setSubActionType(2);
        paramStComment = (FeedCloudMeta.StComment)localObject1;
        if (getQCircleExtraTypeInfo() != null)
        {
          paramStComment = (FeedCloudMeta.StComment)localObject1;
          if (getQCircleExtraTypeInfo().mFeed != null) {
            paramStComment = getQCircleExtraTypeInfo().mFeed.poster.id.get();
          }
        }
        paramStComment = paramStReply.setToUin(paramStComment);
        if (getExtraTypeInfo() != null) {
          k = getQCircleExtraTypeInfo().mDataPosition;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramStComment.setIndex(k).setPageId(getPageId())));
      }
      else
      {
        paramStComment = localObject3;
        if (getExtraTypeInfo() != null) {
          paramStComment = getQCircleExtraTypeInfo().mFeed;
        }
        paramStReply = QCirclePluginReportUtil.b(paramStComment).setActionType(9).setSubActionType(2);
        paramStComment = (FeedCloudMeta.StComment)localObject1;
        if (getQCircleExtraTypeInfo() != null)
        {
          paramStComment = (FeedCloudMeta.StComment)localObject1;
          if (getQCircleExtraTypeInfo().mFeed != null) {
            paramStComment = getQCircleExtraTypeInfo().mFeed.poster.id.get();
          }
        }
        paramStComment = paramStReply.setToUin(paramStComment);
        if (getQCircleExtraTypeInfo() != null) {
          k = getQCircleExtraTypeInfo().mDataPosition;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramStComment.setIndex(k).setPageId(getPageId())));
        localQCircleCommentInfo.i = 9;
      }
      localQCircleCommentInfo.h = paramInt;
      localQCircleInteractor.a("comment_input_window_show", localQCircleCommentInfo);
    }
  }
  
  private void a(String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QCircleCustomDialog.a(getContext(), paramString, null, 2131887648, 2131887629, new QCircleFeedCommentWidget.10(this, paramOnClickListener1), new QCircleFeedCommentWidget.11(this, paramOnClickListener2)).show();
  }
  
  private void a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = getQCircleExtraTypeInfo();
    if ((localObject != null) && (((QCircleExtraTypeInfo)localObject).pageType == 8) && (TextUtils.equals(paramString, ((QCircleExtraTypeInfo)localObject).mCurrentPersonalUin)))
    {
      QLog.d("QCircleFeedCommentWidget", 1, "[launchPersonalDetailPage] call to personal detail repeat.");
      return;
    }
    localObject = new QCircleInitBean();
    ((QCircleInitBean)localObject).setUin(paramString);
    ((QCircleInitBean)localObject).setFeed(paramStFeed);
    ((QCircleInitBean)localObject).setFromReportBean(getReportBean().clone());
    QCircleLauncher.b(getContext(), (QCircleInitBean)localObject);
  }
  
  private void b()
  {
    c();
    this.g = new SoftKeyboardStateHelper(this);
    this.g.a(new QCircleFeedCommentWidget.14(this));
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((RecyclerView)localObject).getChildCount() <= 0) {
        return;
      }
      localObject = this.f;
      localObject = ((RecyclerView)localObject).getChildAt(((RecyclerView)localObject).getChildCount() - 1);
      if (localObject == null) {
        return;
      }
      if (!(this.f.findContainingViewHolder((View)localObject) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
        return;
      }
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeMarginToFooterHolder   paddingTop: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QCircleFeedCommentWidget", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    arrayOfInt[1] += paramView.getHeight();
    int k = QCircleCommentHelper.a().b();
    if ((arrayOfInt[1] > k) && (this.f != null)) {
      b(arrayOfInt[1] - k);
    }
  }
  
  private void c()
  {
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.g;
    if (localSoftKeyboardStateHelper != null)
    {
      localSoftKeyboardStateHelper.a();
      this.g = null;
    }
  }
  
  private boolean d()
  {
    return QCircleReportBean.isContentDetailPage(getPageId());
  }
  
  private QCircleCommentBusiness getCommentBusiness()
  {
    return QCircleCommentBusiness.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = getQCircleExtraTypeInfo();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = getQCircleExtraTypeInfo().mFeed;
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((FeedCloudMeta.StFeed)localObject1).busiReport != null) && (((FeedCloudMeta.StFeed)localObject1).busiReport.has()) && (((FeedCloudMeta.StFeed)localObject1).busiReport.get() != null)) {
      localObject1 = ((FeedCloudMeta.StFeed)localObject1).busiReport.get().toByteArray();
    } else {
      localObject1 = null;
    }
    if (getQCircleExtraTypeInfo() != null) {
      localObject2 = getQCircleExtraTypeInfo().mFeed;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject2).setActionType(paramInt1).setSubActionType(paramInt2);
    if ((getQCircleExtraTypeInfo() != null) && (getQCircleExtraTypeInfo().mFeed != null)) {
      localObject2 = getQCircleExtraTypeInfo().mFeed.poster.id.get();
    } else {
      localObject2 = "";
    }
    localObject2 = localDataBuilder.setToUin((String)localObject2);
    if (getQCircleExtraTypeInfo() != null) {
      paramInt1 = getQCircleExtraTypeInfo().mDataPosition;
    } else {
      paramInt1 = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject2).setIndex(paramInt1).setPageId(getPageId())).setReportInfo((byte[])localObject1));
  }
  
  public void a(QCircleFeedCommentInfo paramQCircleFeedCommentInfo, int paramInt)
  {
    if (paramQCircleFeedCommentInfo == null) {
      return;
    }
    this.d = paramQCircleFeedCommentInfo;
    this.e = paramInt;
    if (this.d.b == null) {
      return;
    }
    if (this.d.c == null)
    {
      setCommentTxt(this.d.b);
      return;
    }
    setReplyTxt(this.d.c);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    QCircleFeedCommentInfo localQCircleFeedCommentInfo = this.d;
    if (localQCircleFeedCommentInfo != null) {
      return localQCircleFeedCommentInfo.a;
    }
    return null;
  }
  
  public int getLayoutId()
  {
    return 2131626803;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedCommentWidget";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(i, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    c();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.c = ((QCircleAsyncTextView)paramView.findViewById(2131441601));
    this.c.setOnClickListener(this);
    this.c.setOnLongClickListener(this);
    this.c.setOnTriggerEllipseListener(new QCircleFeedCommentWidget.1(this));
  }
  
  @QCircleFeedClick
  public boolean onLongClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(j, this, this, paramView);
    return Conversions.booleanValue(b(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint));
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) {
      a((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setCommentTxt(FeedCloudMeta.StComment paramStComment)
  {
    a(this.c);
    if ((paramStComment.postUser.get() != null) && (!TextUtils.isEmpty(paramStComment.postUser.nick.get())) && (this.c != null))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      this.c.setPreloadText("feed_comment_", paramStComment.content.get());
      localSpannableStringBuilder.append(BidiFormatter.getInstance().unicodeWrap(paramStComment.postUser.nick.get())).append("：").append(paramStComment.content.get());
      this.c.a(localSpannableStringBuilder, 0, paramStComment.postUser.nick.get().length(), new QCircleFeedCommentWidget.2(this, paramStComment));
      this.c.setOnClickAtTextListener(new QCircleFeedCommentWidget.3(this));
      if (QCircleCommentHelper.a(paramStComment.typeFlag2.get(), 4))
      {
        if (this.h == null)
        {
          this.h = getResources().getDrawable(2130845085);
          this.h.setBounds(ImmersiveUtils.a(2.5F), ImmersiveUtils.a(0.0F), ImmersiveUtils.a(42.5F), ImmersiveUtils.a(16.0F));
        }
        this.c.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.h);
        this.c.a(true);
        a(9, 1);
      }
      this.c.setText(localSpannableStringBuilder);
      this.c.setVisibility(0);
    }
  }
  
  public void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.f = paramRecyclerView;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.c);
    if ((paramStReply != null) && (this.c != null) && (this.d != null))
    {
      if (TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        localObject = this.d.b.postUser.id;
      } else {
        localObject = paramStReply.targetUser.id;
      }
      String str = ((PBStringField)localObject).get();
      if (TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        localObject = this.d.b.postUser.nick;
      } else {
        localObject = paramStReply.targetUser.nick;
      }
      Object localObject = ((PBStringField)localObject).get();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      this.c.setPreloadText("feed_reply_", paramStReply.content.get());
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(b).append((CharSequence)localObject).append("：").append(paramStReply.content.get());
      this.c.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new QCircleFeedCommentWidget.4(this, paramStReply));
      this.c.a(localSpannableStringBuilder, paramStReply.postUser.nick.get().length() + b.length(), paramStReply.postUser.nick.get().length() + b.length() + ((String)localObject).length(), new QCircleFeedCommentWidget.5(this, str));
      this.c.setOnClickAtTextListener(new QCircleFeedCommentWidget.6(this));
      this.c.setText(localSpannableStringBuilder);
      this.c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget
 * JD-Core Version:    0.7.0.1
 */