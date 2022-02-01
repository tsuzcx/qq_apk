package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleCommentOrReplyMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private QCircleReplyMessagePresenter a;
  private RecyclerView b;
  
  public QCircleCommentOrReplyMessageItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    QCircleReplyMessagePresenter localQCircleReplyMessagePresenter = this.a;
    if (localQCircleReplyMessagePresenter != null)
    {
      localQCircleReplyMessagePresenter.a(this.b);
      this.a.a(paramStNotice, paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131626873;
  }
  
  protected String getLogTag()
  {
    return "QCircleCommentOrReplyMessageItemView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QCircleReplyMessagePresenter localQCircleReplyMessagePresenter = this.a;
    if (localQCircleReplyMessagePresenter != null) {
      localQCircleReplyMessagePresenter.k();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QCircleReplyMessagePresenter localQCircleReplyMessagePresenter = this.a;
    if (localQCircleReplyMessagePresenter != null) {
      localQCircleReplyMessagePresenter.l();
    }
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new QCircleReplyMessagePresenter(getViewType());
    this.a.a(paramContext, paramView);
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.b = paramRecyclerView;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    paramQCircleReportBean = this.a;
    if (paramQCircleReportBean != null) {
      paramQCircleReportBean.a(getReportBean());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleCommentOrReplyMessageItemView
 * JD-Core Version:    0.7.0.1
 */