package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import vmo;

public class QCircleFollowMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private vmo a;
  
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
    return 2131560729;
  }
  
  public String a()
  {
    return "QCircleFollowMessageItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = new vmo(c());
    this.a.a(paramContext, paramView);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice)
  {
    a(paramStNotice, -1);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (this.a != null)
    {
      this.a.a(paramStNotice, paramInt);
      this.a.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleFollowMessageItemView
 * JD-Core Version:    0.7.0.1
 */