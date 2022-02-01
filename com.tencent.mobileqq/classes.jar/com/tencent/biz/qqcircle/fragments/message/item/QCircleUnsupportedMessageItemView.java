package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import vpg;

public class QCircleUnsupportedMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private vpg a;
  
  public QCircleUnsupportedMessageItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560749;
  }
  
  public String a()
  {
    return "QCircleUnsupportedMessageItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = new vpg(c());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleUnsupportedMessageItemView
 * JD-Core Version:    0.7.0.1
 */