package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleUnsupportedMessagePresenter;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleUnsupportedMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private QCircleUnsupportedMessagePresenter a;
  
  public QCircleUnsupportedMessageItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    QCircleUnsupportedMessagePresenter localQCircleUnsupportedMessagePresenter = this.a;
    if (localQCircleUnsupportedMessagePresenter != null) {
      localQCircleUnsupportedMessagePresenter.a(paramStNotice, paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131626874;
  }
  
  protected String getLogTag()
  {
    return "QCircleUnsupportedMessageItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new QCircleUnsupportedMessagePresenter(getViewType());
    this.a.a(paramContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleUnsupportedMessageItemView
 * JD-Core Version:    0.7.0.1
 */