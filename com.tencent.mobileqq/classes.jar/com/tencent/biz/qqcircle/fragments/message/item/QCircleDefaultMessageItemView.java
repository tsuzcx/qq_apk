package com.tencent.biz.qqcircle.fragments.message.item;

import aabd;
import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import von;
import voq;
import vpd;
import vpf;

public class QCircleDefaultMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private von a;
  
  public QCircleDefaultMessageItemView(Context paramContext, int paramInt, aabd paramaabd)
  {
    super(paramContext, paramInt);
    this.a.a(paramaabd);
  }
  
  public int a()
  {
    return 2131560749;
  }
  
  public String a()
  {
    return "QCircleDefaultMessageWidget";
  }
  
  protected von a(int paramInt)
  {
    if (paramInt == 3) {
      return new vpd(paramInt);
    }
    if ((paramInt == 10) || (paramInt == 11)) {
      return new vpf(paramInt);
    }
    return new voq(paramInt);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    this.a = a(paramInt);
    if (this.a != null) {
      this.a.a(a());
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (this.a != null) {
      this.a.a(paramContext, paramView);
    }
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
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleDefaultMessageItemView
 * JD-Core Version:    0.7.0.1
 */