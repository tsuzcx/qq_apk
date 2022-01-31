package com.tencent.biz.qqcircle.widgets;

import alud;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import bhvm;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import tqt;
import tra;
import trw;
import trx;
import tuk;
import tuz;
import tzs;
import tzw;
import tzy;
import ucx;
import ucy;
import ucz;
import uda;
import udb;
import udi;
import udl;
import yiw;
import yiy;

public class QCircleFeedCommentWidget
  extends BaseWidgetView<trx>
  implements View.OnClickListener, View.OnLongClickListener, yiy
{
  private int jdField_a_of_type_Int;
  bhvm jdField_a_of_type_Bhvm = new udl(this);
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_a_of_type_JavaLangString = alud.a(2131698378);
  private trx jdField_a_of_type_Trx;
  
  public QCircleFeedCommentWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private tuk a()
  {
    if (((a() instanceof trw)) && (((trw)a()).a() != null)) {
      return ((trw)a()).a().a();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (tzy.a().c(57))
    {
      tzw.a(paramInt, 2, a());
      return;
    }
    tzs.a(paramInt, 2, a());
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    a(62);
    tqt.a().a(paramView, paramStFeed, paramStComment, new udb(this, paramStFeed, paramStComment), this.jdField_a_of_type_Bhvm);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    tqt.a().a(paramView, paramStFeed, paramStReply, new udi(this, paramStReply, paramStFeed, paramStComment), this.jdField_a_of_type_Bhvm);
  }
  
  private void a(QCircleCommentPraiseUpdateEvent paramQCircleCommentPraiseUpdateEvent)
  {
    if ((this.jdField_a_of_type_Trx == null) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), paramQCircleCommentPraiseUpdateEvent.mFeedId))) {}
    do
    {
      do
      {
        return;
        if ((paramQCircleCommentPraiseUpdateEvent.mType != 1) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null)) {
          break;
        }
      } while (!TextUtils.equals(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId));
      if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
        this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      }
      this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
      setCommentTxt(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while ((paramQCircleCommentPraiseUpdateEvent.mType != 2) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId)) || (!TextUtils.equals(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get(), paramQCircleCommentPraiseUpdateEvent.mReplyId)));
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
      this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    }
    this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
    setReplyTxt(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
    while ((!(a() instanceof trw)) || (((trw)a()).a() == null)) {
      return;
    }
    trw localtrw = (trw)a();
    localtrw.a().a(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
    localtrw.a().a(a());
    localtrw.a().a(localtrw.a());
    localtrw.a().a(paramStComment, paramStReply);
    if ((paramStComment == null) && (paramStReply == null))
    {
      tzs.a(6, 2, a());
      return;
    }
    tzs.a(9, 2, a());
    localtrw.a().a(9);
  }
  
  public int a()
  {
    return 2131560536;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131373153));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnTriggerEllipseListener(new ucx(this));
  }
  
  protected void a(trx paramtrx) {}
  
  public void a(trx paramtrx, int paramInt)
  {
    if (paramtrx == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Trx = paramtrx;
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    if (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)
    {
      setCommentTxt(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    }
    setReplyTxt(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
    yiw.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_Trx == null) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null));
    a(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Trx != null) && (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)) {
        if (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) {
          a(paramView, this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        } else {
          a(paramView, this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStComment.postUser.nick.get().length(), new ucy(this, paramStComment));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
    }
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    String str1;
    if ((paramStReply != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) && (this.jdField_a_of_type_Trx != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label287;
      }
      str1 = this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label302;
      }
    }
    label287:
    label302:
    for (String str2 = this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.jdField_a_of_type_JavaLangString).append(str2).append("：").append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new ucz(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.jdField_a_of_type_JavaLangString.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.jdField_a_of_type_JavaLangString.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new uda(this, str1));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      return;
      str1 = paramStReply.targetUser.id.get();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget
 * JD-Core Version:    0.7.0.1
 */