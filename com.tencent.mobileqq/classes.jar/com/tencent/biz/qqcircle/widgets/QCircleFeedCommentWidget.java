package com.tencent.biz.qqcircle.widgets;

import aage;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import anni;
import bkiz;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import uxp;
import uxx;
import uzb;
import uzc;
import uzk;
import vhu;
import vrc;
import vrg;
import vtd;
import vwd;
import vwe;
import vwh;
import vwi;
import vwj;
import vwk;
import vwl;
import vwm;
import vwn;
import vwo;
import zwp;
import zwr;
import zyd;

public class QCircleFeedCommentWidget
  extends QCircleBaseWidgetView<uzk>
  implements View.OnClickListener, View.OnLongClickListener, zwr
{
  private int jdField_a_of_type_Int;
  private aage jdField_a_of_type_Aage;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  bkiz jdField_a_of_type_Bkiz = new vwh(this);
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_a_of_type_JavaLangString = anni.a(2131697250);
  private uzk jdField_a_of_type_Uzk;
  
  public QCircleFeedCommentWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private vhu a()
  {
    return vhu.a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Aage = new aage(this);
    this.jdField_a_of_type_Aage.a(new vwi(this));
  }
  
  private void a(int paramInt)
  {
    if (b())
    {
      vrg.a(paramInt, 2, a(), e());
      return;
    }
    vrc.a(paramInt, 2, a(), d());
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    int[] arrayOfInt;
    int i;
    do
    {
      return;
      arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      arrayOfInt[1] += paramView.getHeight();
      i = vtd.a().a();
    } while ((arrayOfInt[1] <= i) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, arrayOfInt[1] - i);
    QLog.i("QCircleFeedCommentWidget", 1, "scrollItemToVisbleAboveInputLayout  scrollBy: " + (arrayOfInt[1] - i));
    b(arrayOfInt[1] - i);
    ThreadManager.getUIHandler().postDelayed(new QCircleFeedCommentWidget.12(this, paramView, arrayOfInt, i), 1L);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    a(62);
    uxp.a().a(paramView, paramStFeed, paramStComment, new vwo(this, paramStFeed, paramStComment), this.jdField_a_of_type_Bkiz);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    uxp.a().a(paramView, paramStFeed, paramStReply, new vwe(this, paramStReply, paramStFeed, paramStComment), this.jdField_a_of_type_Bkiz);
  }
  
  private void a(QCircleCommentPraiseUpdateEvent paramQCircleCommentPraiseUpdateEvent)
  {
    if ((this.jdField_a_of_type_Uzk == null) || (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), paramQCircleCommentPraiseUpdateEvent.mFeedId))) {}
    do
    {
      do
      {
        return;
        if ((paramQCircleCommentPraiseUpdateEvent.mType != 1) || (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null)) {
          break;
        }
      } while (!TextUtils.equals(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId));
      if (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
        this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      }
      this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
      setCommentTxt(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while ((paramQCircleCommentPraiseUpdateEvent.mType != 2) || (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId)) || (!TextUtils.equals(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get(), paramQCircleCommentPraiseUpdateEvent.mReplyId)));
    if (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
      this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    }
    this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
    setReplyTxt(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  private void a(QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if (paramQCircleAsyncTextView != null)
    {
      paramQCircleAsyncTextView.a(false);
      paramQCircleAsyncTextView.setText("");
      paramQCircleAsyncTextView.setVisibility(8);
    }
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (a()) {}
    while (!(a() instanceof uzb)) {
      return;
    }
    uzb localuzb = (uzb)a();
    uzc localuzc = new uzc();
    localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
    localuzc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = a();
    localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    localuzc.jdField_a_of_type_JavaLangString = b();
    if ((paramStComment == null) && (paramStReply == null)) {
      vrc.a(6, 2, a(), d());
    }
    for (;;)
    {
      localuzb.a("comment_input_window_show", localuzc);
      return;
      vrc.a(9, 2, a(), d());
      localuzc.c = 9;
    }
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() <= 0)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() - 1);
    } while ((localView == null) || (!(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findContainingViewHolder(localView) instanceof zyd)));
    localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), paramInt);
    QLog.i("QCircleFeedCommentWidget", 1, "changeMarginToFooterHolder   paddingTop: " + paramInt);
  }
  
  private boolean b()
  {
    return QCircleReportBean.isContentDetailPage(d());
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aage != null)
    {
      this.jdField_a_of_type_Aage.a();
      this.jdField_a_of_type_Aage = null;
    }
  }
  
  public int a()
  {
    return 2131560694;
  }
  
  protected String a()
  {
    return "QCircleFeedCommentWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131373784));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnTriggerEllipseListener(new vwd(this));
  }
  
  protected void a(uzk paramuzk) {}
  
  public void a(uzk paramuzk, int paramInt)
  {
    if (paramuzk == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Uzk = paramuzk;
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    if (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)
    {
      setCommentTxt(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    }
    setReplyTxt(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    zwp.a().a(this);
    a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Uzk != null) && (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
      {
        a(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
        a(paramView);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
    c();
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Uzk != null) && (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)) {
        if (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) {
          a(paramView, this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        } else {
          a(paramView, this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) {
      a((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setCommentTxt(FeedCloudMeta.StComment paramStComment)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    if ((paramStComment.postUser.get() != null) && (!TextUtils.isEmpty(paramStComment.postUser.nick.get())) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStComment.postUser.nick.get()).append("：").append(paramStComment.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStComment.postUser.nick.get().length(), new vwj(this, paramStComment));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(localSpannableStringBuilder, new vwk(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
    }
  }
  
  public void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    String str1;
    if ((paramStReply != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) && (this.jdField_a_of_type_Uzk != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label295;
      }
      str1 = this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label310;
      }
    }
    label295:
    label310:
    for (String str2 = this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.jdField_a_of_type_JavaLangString).append(str2).append("：").append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new vwl(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.jdField_a_of_type_JavaLangString.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.jdField_a_of_type_JavaLangString.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new vwm(this, str1));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(localSpannableStringBuilder, new vwn(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      return;
      str1 = paramStReply.targetUser.id.get();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget
 * JD-Core Version:    0.7.0.1
 */