package com.tencent.biz.pubaccount.weishi_new;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSFollowFragment$4
  implements View.OnClickListener
{
  WSFollowFragment$4(WSFollowFragment paramWSFollowFragment) {}
  
  public void onClick(View paramView)
  {
    if (WSFollowFragment.a(this.a) != null) {
      WSFollowFragment.a(this.a).b();
    }
    ((WSFollowPresenter)this.a.b()).a(true, true);
    WSFollowFragment.a(this.a).setVisibility(8);
    this.a.c();
    WSReportDc00898.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.4
 * JD-Core Version:    0.7.0.1
 */