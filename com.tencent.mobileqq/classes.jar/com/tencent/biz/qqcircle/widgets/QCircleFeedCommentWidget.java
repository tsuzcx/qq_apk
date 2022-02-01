package com.tencent.biz.qqcircle.widgets;

import aaak;
import aaam;
import aabz;
import aakf;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import anzj;
import blkc;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
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
import uyx;
import uyy;
import uzg;
import var;
import vas;
import vba;
import vjy;
import vtn;
import vtr;
import vvw;
import vvz;
import vzg;
import vzh;
import vzk;
import vzl;
import vzm;
import vzn;
import vzo;
import vzp;
import vzq;
import vzr;

public class QCircleFeedCommentWidget
  extends QCircleBaseWidgetView<vba>
  implements aaam, View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private aakf jdField_a_of_type_Aakf;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  blkc jdField_a_of_type_Blkc = new vzk(this);
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_a_of_type_JavaLangString = anzj.a(2131697327);
  private vba jdField_a_of_type_Vba;
  
  public QCircleFeedCommentWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private vjy a()
  {
    return vjy.a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Aakf = new aakf(this);
    this.jdField_a_of_type_Aakf.a(new vzl(this));
  }
  
  private void a(int paramInt)
  {
    if (b())
    {
      vtr.a(paramInt, 2, a(), e());
      return;
    }
    vtn.a(paramInt, 2, a(), d());
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
      i = vvz.a().a();
    } while ((arrayOfInt[1] <= i) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, arrayOfInt[1] - i);
    QLog.i("QCircleFeedCommentWidget", 1, "scrollItemToVisbleAboveInputLayout  scrollBy: " + (arrayOfInt[1] - i));
    b(arrayOfInt[1] - i);
    ThreadManager.getUIHandler().postDelayed(new QCircleFeedCommentWidget.12(this, paramView, arrayOfInt, i), 1L);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    a(62);
    uyy.a().a(paramView, paramStFeed, paramStComment, new vzr(this, paramStFeed, paramStComment), this.jdField_a_of_type_Blkc);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    uyy.a().a(paramView, paramStFeed, paramStReply, new vzh(this, paramStReply, paramStFeed, paramStComment), this.jdField_a_of_type_Blkc);
  }
  
  private void a(QCircleCommentPraiseUpdateEvent paramQCircleCommentPraiseUpdateEvent)
  {
    if ((this.jdField_a_of_type_Vba == null) || (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), paramQCircleCommentPraiseUpdateEvent.mFeedId))) {}
    do
    {
      do
      {
        return;
        if ((paramQCircleCommentPraiseUpdateEvent.mType != 1) || (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null)) {
          break;
        }
      } while (!TextUtils.equals(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId));
      if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
        this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      }
      this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
      setCommentTxt(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while ((paramQCircleCommentPraiseUpdateEvent.mType != 2) || (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId)) || (!TextUtils.equals(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get(), paramQCircleCommentPraiseUpdateEvent.mReplyId)));
    if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
      this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    }
    this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
    setReplyTxt(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
    while (!(a() instanceof var)) {
      return;
    }
    var localvar = (var)a();
    vas localvas = new vas();
    localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
    localvas.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = a();
    localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    localvas.jdField_a_of_type_JavaLangString = b();
    if ((paramStComment == null) && (paramStReply == null)) {
      vtn.a(6, 2, a(), d());
    }
    for (;;)
    {
      localvar.a("comment_input_window_show", localvas);
      return;
      vtn.a(9, 2, a(), d());
      localvas.c = 9;
    }
  }
  
  private void a(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFromReportBean(a().clone().setElementIdStr("portrait"));
    uyx.b(getContext(), localQCircleInitBean);
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() <= 0)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() - 1);
    } while ((localView == null) || (!(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findContainingViewHolder(localView) instanceof aabz)));
    localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), paramInt);
    QLog.i("QCircleFeedCommentWidget", 1, "changeMarginToFooterHolder   paddingTop: " + paramInt);
  }
  
  private boolean b()
  {
    return QCircleReportBean.isContentDetailPage(d());
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aakf != null)
    {
      this.jdField_a_of_type_Aakf.a();
      this.jdField_a_of_type_Aakf = null;
    }
  }
  
  public int a()
  {
    return 2131560711;
  }
  
  protected String a()
  {
    return "QCircleFeedCommentWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131373909));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnTriggerEllipseListener(new vzg(this));
  }
  
  protected void a(vba paramvba) {}
  
  public void a(vba paramvba, int paramInt)
  {
    if (paramvba == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Vba = paramvba;
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    if (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)
    {
      setCommentTxt(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    }
    setReplyTxt(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
    aaak.a().a(this);
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
      if ((this.jdField_a_of_type_Vba != null) && (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)) {
        if (!vvw.a())
        {
          vvw.a(getContext(), 3);
        }
        else
        {
          a(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
          a(paramView);
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
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
      if ((this.jdField_a_of_type_Vba != null) && (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)) {
        if (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) {
          a(paramView, this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        } else {
          a(paramView, this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStComment.postUser.nick.get().length(), new vzm(this, paramStComment));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(localSpannableStringBuilder, new vzn(this));
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
    if ((paramStReply != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) && (this.jdField_a_of_type_Vba != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label295;
      }
      str1 = this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label310;
      }
    }
    label295:
    label310:
    for (String str2 = this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.jdField_a_of_type_JavaLangString).append(str2).append("：").append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new vzo(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.jdField_a_of_type_JavaLangString.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.jdField_a_of_type_JavaLangString.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new vzp(this, str1));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(localSpannableStringBuilder, new vzq(this));
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