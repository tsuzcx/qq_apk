package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class TroopMemberListActivity$3
  implements PopupMenuDialog.OnClickActionListener
{
  TroopMemberListActivity$3(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem.id == this.a.mSortType) {
      return;
    }
    this.a.mSortType = paramMenuItem.id;
    TroopMemberListActivity.access$000(this.a, paramMenuItem.id);
    if ((this.a.mSortType >= 0) && (this.a.mSortType < TroopMemberListActivity.access$100(this.a).length)) {
      this.a.mSubTitle.setText(TroopMemberListActivity.access$100(this.a)[this.a.mSortType]);
    }
    if (this.a.mSortType == 0)
    {
      paramMenuItem = this.a;
      paramMenuItem.doReport("Clk_def", paramMenuItem.mMyTroopRole, "");
    }
    else if (this.a.mSortType == 1)
    {
      ((ITroopOnlineMemberHandler)this.a.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName())).b(this.a.mTroopUin);
      new ReportTask(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.mTroopUin }).a();
      new ReportTask(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.mTroopUin }).a();
    }
    else if (this.a.mSortType == 5)
    {
      ((ITroopOnlineMemberHandler)this.a.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName())).d(this.a.mTroopUin);
    }
    else
    {
      if (this.a.mSortType == 2) {
        paramMenuItem = "Clk_lastactivetime";
      } else {
        paramMenuItem = "Clk_jointime";
      }
      localObject = this.a;
      ((TroopMemberListActivity)localObject).doReport(paramMenuItem, "1", ((TroopMemberListActivity)localObject).mMyTroopRole);
    }
    this.a.checkShowCharIndexView();
    if (!this.a.isPositiveSort) {
      this.a.isPositiveSort = true;
    }
    if (this.a.mAdapter != null) {
      this.a.mAdapter.c();
    }
    if (this.a.mSortType == 0) {
      this.a.mListView.setSelectionFromTop(0, 0);
    } else {
      this.a.mListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131299611));
    }
    paramMenuItem = this.a.mTitleLayout;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.mTitle.getText().toString());
    ((StringBuilder)localObject).append(this.a.mSubTitle.getText().toString());
    paramMenuItem.setContentDescription(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.3
 * JD-Core Version:    0.7.0.1
 */