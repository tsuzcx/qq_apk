package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import vmh;
import vmk;
import vmq;
import vmz;
import vnb;
import zxi;

public class QCircleDefaultMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private vmh a;
  
  public QCircleDefaultMessageItemView(Context paramContext, int paramInt, zxi paramzxi)
  {
    super(paramContext, paramInt);
    this.a.a(paramzxi);
  }
  
  public int a()
  {
    return 2131560728;
  }
  
  public String a()
  {
    return "QCircleDefaultMessageWidget";
  }
  
  protected vmh a(int paramInt)
  {
    if (paramInt == 3) {
      return new vmz(paramInt);
    }
    if ((paramInt == 7) || (paramInt == 6) || (paramInt == 0) || (paramInt == 13)) {
      return new vmq(paramInt);
    }
    if ((paramInt == 10) || (paramInt == 11)) {
      return new vnb(paramInt);
    }
    return new vmk(paramInt);
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