package com.tencent.biz.qqcircle.widgets.message.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import ugz;
import uhb;
import uhe;
import uhk;

public class QCircleDefaultMessageWidget
  extends BaseWidgetView<FeedCloudMeta.StNotice>
{
  private ugz a;
  
  public QCircleDefaultMessageWidget(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public int a()
  {
    return 2131560559;
  }
  
  protected ugz a(int paramInt)
  {
    if (paramInt == 3) {
      return new uhk(paramInt);
    }
    if ((paramInt == 7) || (paramInt == 6)) {
      return new uhe(paramInt);
    }
    return new uhb(paramInt);
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
  
  public void b(Context paramContext, int paramInt)
  {
    this.a = a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.message.item.QCircleDefaultMessageWidget
 * JD-Core Version:    0.7.0.1
 */