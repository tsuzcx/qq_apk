package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleSystemMessagePresenter
  extends QCircleDefaultMessagePresenter
{
  public QCircleSystemMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.t = new QCircleSystemMessagePresenter.1(this, paramContext);
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
  }
  
  protected View.OnClickListener g()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleSystemMessagePresenter
 * JD-Core Version:    0.7.0.1
 */