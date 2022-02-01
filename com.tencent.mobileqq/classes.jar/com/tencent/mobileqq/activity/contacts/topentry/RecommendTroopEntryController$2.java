package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecommendTroopEntryController$2
  implements View.OnClickListener
{
  RecommendTroopEntryController$2(RecommendTroopEntryController paramRecommendTroopEntryController) {}
  
  public void onClick(View paramView)
  {
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.a.a.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    Intent localIntent = new Intent(RecommendTroopEntryController.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", localMayknowRecommendManager.a);
    RecommendTroopEntryController.b(this.a).startActivity(localIntent);
    ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController.2
 * JD-Core Version:    0.7.0.1
 */