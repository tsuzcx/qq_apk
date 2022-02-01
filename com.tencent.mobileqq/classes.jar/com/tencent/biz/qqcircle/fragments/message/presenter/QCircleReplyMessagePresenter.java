package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.os.Handler;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleMessageReplyAdapter;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper.CommentInputListener;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper.QCircleCommentUpdateListener;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.List;

public class QCircleReplyMessagePresenter
  extends QCircleDefaultMessagePresenter
  implements QCircleCommentHelper.QCircleCommentUpdateListener
{
  private RecyclerView A;
  private View B;
  private SoftKeyboardStateHelper C;
  private RecyclerView w;
  private QCircleFeedCommentInfo x;
  private QCircleCommentHelper.CommentInputListener y;
  private QCircleMessageReplyAdapter z;
  
  public QCircleReplyMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  private void a(QCircleFeedCommentInfo paramQCircleFeedCommentInfo, int paramInt, String paramString)
  {
    paramString = new QCircleLpReportDc05504.DataBuilder().setToUin(paramString).setActionType(17).setSubActionType(paramInt).setThrActionType(0);
    if (this.d != null) {
      paramQCircleFeedCommentInfo = this.d.busiReport.get().toByteArray();
    } else {
      paramQCircleFeedCommentInfo = null;
    }
    QCircleLpReportDc05504.report(paramString.setMsgReportInfo(paramQCircleFeedCommentInfo).setPageId(d().getPageId()));
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.A;
    if (localObject != null)
    {
      if (((RecyclerView)localObject).getChildCount() <= 0) {
        return;
      }
      localObject = this.A;
      localObject = ((RecyclerView)localObject).getChildAt(((RecyclerView)localObject).getChildCount() - 1);
      if (localObject == null) {
        return;
      }
      if (!(this.A.findContainingViewHolder((View)localObject) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
        return;
      }
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeMarginToFooterHolder   paddingTop: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QCircleReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
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
    int i = QCircleCommentHelper.a().b();
    if (arrayOfInt[1] > i)
    {
      Object localObject = this.A;
      if (localObject != null)
      {
        ((RecyclerView)localObject).scrollBy(0, arrayOfInt[1] - i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollItemToVisbleAboveInputLayout  scrollBy: ");
        ((StringBuilder)localObject).append(arrayOfInt[1] - i);
        QLog.i("QCircleReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
        b(arrayOfInt[1] - i);
        RFThreadManager.getUIHandler().postDelayed(new QCircleReplyMessagePresenter.6(this, paramView, arrayOfInt, i), 1L);
      }
    }
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCirclePluginUtil.a(paramStNotice.createTime.get() * 1000L));
    paramStNotice = new SpannableString(localStringBuilder);
    this.i.setText(paramStNotice);
  }
  
  private void c(View paramView)
  {
    p();
    b(paramView);
  }
  
  private void m()
  {
    List localList = QCircleCommentHelper.a().a(n());
    if (localList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFakeReplyView");
      localStringBuilder.append(localList.size());
      QLog.d("QCircleReplyMessagePresenter", 4, localStringBuilder.toString());
      this.z.a(localList);
      this.z.notifyDataSetChanged();
      return;
    }
    QLog.d("QCircleReplyMessagePresenter", 4, "initFakeReplyView null");
    this.z.a(new ArrayList());
    this.z.notifyDataSetChanged();
  }
  
  private String n()
  {
    if ((this.d.feed.get() != null) && (this.d.operation.comment.get() != null)) {
      return QCirclePluginUtil.a(this.d.operation.comment.id.get(), this.d.feedId.get());
    }
    return "";
  }
  
  private QCircleFeedCommentInfo o()
  {
    try
    {
      if ((this.d != null) && (this.d.operation.comment.get() != null))
      {
        Object localObject1 = (FeedCloudMeta.StComment)this.d.operation.comment.get();
        localObject2 = ((FeedCloudMeta.StComment)localObject1).vecReply.get();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          QLog.d("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo is Reply");
          return new QCircleFeedCommentInfo((FeedCloudMeta.StFeed)this.d.feed.get(), (FeedCloudMeta.StComment)localObject1, (FeedCloudMeta.StReply)((List)localObject2).get(((List)localObject2).size() - 1));
        }
        QLog.d("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo is comment");
        localObject1 = new QCircleFeedCommentInfo((FeedCloudMeta.StFeed)this.d.feed.get(), (FeedCloudMeta.StComment)localObject1, null);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFeedCommentInfo error");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("QCircleReplyMessagePresenter", 1, ((StringBuilder)localObject2).toString());
      localException.printStackTrace();
      QLog.e("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo return null");
    }
    return null;
  }
  
  private void p()
  {
    q();
    this.C = new SoftKeyboardStateHelper(this.B);
    this.C.a(new QCircleReplyMessagePresenter.7(this));
  }
  
  private void q()
  {
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.C;
    if (localSoftKeyboardStateHelper != null)
    {
      localSoftKeyboardStateHelper.a();
      this.C = null;
    }
  }
  
  private boolean r()
  {
    return QCircleReportBean.isContentDetailPage(e());
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.A = paramRecyclerView;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    super.a(paramQCircleReportBean);
    paramQCircleReportBean = this.z;
    if (paramQCircleReportBean != null) {
      paramQCircleReportBean.a(d());
    }
  }
  
  public void a(List<QCircleFeedCommentInfo> paramList)
  {
    QCircleMessageReplyAdapter localQCircleMessageReplyAdapter = this.z;
    if (localQCircleMessageReplyAdapter != null)
    {
      localQCircleMessageReplyAdapter.a(paramList);
      this.z.notifyDataSetChanged();
    }
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.B = paramView;
    this.w = ((RecyclerView)paramView.findViewById(2131445212));
    paramView = new QCircleReplyMessagePresenter.1(this, this.a.getContext(), 1, false);
    RecyclerView localRecyclerView = this.w;
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutManager(paramView);
      this.z = new QCircleMessageReplyAdapter();
      this.z.a(new QCircleReplyMessagePresenter.2(this, paramContext));
      this.w.setAdapter(this.z);
    }
    this.y = new QCircleReplyMessagePresenter.3(this);
    this.u = new QCircleReplyMessagePresenter.4(this, paramContext);
    this.i.setOnClickListener(new QCircleReplyMessagePresenter.5(this));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
    try
    {
      QCircleCommentHelper.a().a(n(), this);
      b(paramStNotice);
      this.x = o();
      m();
      return;
    }
    catch (Exception paramStNotice)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindCustomData");
      localStringBuilder.append(paramStNotice.getMessage());
      QLog.i("QCircleReplyMessagePresenter", 1, localStringBuilder.toString());
      paramStNotice.printStackTrace();
    }
  }
  
  protected View.OnClickListener h()
  {
    return this.u;
  }
  
  public void k() {}
  
  public void l()
  {
    q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter
 * JD-Core Version:    0.7.0.1
 */