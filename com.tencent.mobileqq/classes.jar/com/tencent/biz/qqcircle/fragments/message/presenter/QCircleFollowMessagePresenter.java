package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleFollowMessagePresenter
  extends QCircleBaseMessagePresenter
{
  private QCircleFollowView q;
  
  public QCircleFollowMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  void b(Context paramContext, View paramView)
  {
    this.q = ((QCircleFollowView)paramView.findViewById(2131441632));
    this.q.setFollowStateChangeListener(new QCircleFollowMessagePresenter.1(this));
    this.q.setDtParentEmId("em_xsj_msg");
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    paramStNotice = (FeedCloudMeta.StUser)paramStNotice.operation.opUser.get();
    if (paramStNotice != null) {
      this.q.setUserData(paramStNotice);
    }
  }
  
  void c()
  {
    if (this.j != null)
    {
      if (this.a != null) {
        this.a.setOnClickListener(this.j);
      }
      if (this.h != null) {
        this.h.setOnClickListener(this.j);
      }
    }
  }
  
  protected String f()
  {
    return "QCircleFollowMessagePresenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleFollowMessagePresenter
 * JD-Core Version:    0.7.0.1
 */