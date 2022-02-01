package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleUnsupportedMessagePresenter
  extends QCircleBaseMessagePresenter
{
  public QCircleUnsupportedMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  void b(Context paramContext, View paramView) {}
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((this.h != null) && (this.c != null)) {
      this.h.setText(this.c.getString(2131895794));
    }
  }
  
  void c() {}
  
  protected String f()
  {
    return "QCircleUnsupportedMessagePresenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleUnsupportedMessagePresenter
 * JD-Core Version:    0.7.0.1
 */