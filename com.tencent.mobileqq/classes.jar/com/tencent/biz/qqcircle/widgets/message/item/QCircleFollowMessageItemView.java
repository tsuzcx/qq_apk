package com.tencent.biz.qqcircle.widgets.message.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import uhd;

public class QCircleFollowMessageItemView
  extends BaseWidgetView<FeedCloudMeta.StNotice>
{
  private uhd a;
  
  public QCircleFollowMessageItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleFollowMessageItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560560;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = new uhd(d());
    this.a.a(paramContext, paramView);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice)
  {
    a(paramStNotice, -1);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramStNotice, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.message.item.QCircleFollowMessageItemView
 * JD-Core Version:    0.7.0.1
 */