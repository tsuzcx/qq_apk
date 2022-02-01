package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBusinessMessagePresenter;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleBusinessMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private QCircleBusinessMessagePresenter a;
  
  public QCircleBusinessMessageItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    QCircleBusinessMessagePresenter localQCircleBusinessMessagePresenter = this.a;
    if (localQCircleBusinessMessagePresenter != null) {
      localQCircleBusinessMessagePresenter.a(paramStNotice, paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131626872;
  }
  
  protected String getLogTag()
  {
    return "QCircleUnsupportedMessageItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new QCircleBusinessMessagePresenter(getViewType());
    this.a.a(paramContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleBusinessMessageItemView
 * JD-Core Version:    0.7.0.1
 */