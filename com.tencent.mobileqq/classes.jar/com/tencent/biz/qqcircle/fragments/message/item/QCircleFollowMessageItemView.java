package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleFollowMessagePresenter;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleFollowMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private QCircleFollowMessagePresenter a;
  
  public QCircleFollowMessageItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleFollowMessageItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    QCircleFollowMessagePresenter localQCircleFollowMessagePresenter = this.a;
    if (localQCircleFollowMessagePresenter != null)
    {
      localQCircleFollowMessagePresenter.a(paramStNotice, paramInt);
      this.a.a(getReportBean());
    }
  }
  
  public int getLayoutId()
  {
    return 2131626875;
  }
  
  protected String getLogTag()
  {
    return "QCircleFollowMessageItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new QCircleFollowMessagePresenter(getViewType());
    this.a.a(paramContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleFollowMessageItemView
 * JD-Core Version:    0.7.0.1
 */