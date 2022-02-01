package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FollowSearchResultPresenter$1
  implements View.OnClickListener
{
  FollowSearchResultPresenter$1(FollowSearchResultPresenter paramFollowSearchResultPresenter) {}
  
  public void onClick(View paramView)
  {
    FollowSearchResultPresenter.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.FollowSearchResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */