package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HotChatPostListAdapter$2
  implements View.OnClickListener
{
  HotChatPostListAdapter$2(HotChatPostListAdapter paramHotChatPostListAdapter, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a, QQBrowserActivity.class).putExtra("url", String.format("https://buluo.qq.com/mobile/detail.html?bid=%s&pid=%s&_wv=1027&webview=1&from=reliao", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.a.startActivity(localIntent);
    ReportController.b(null, "dc00899", "grp_lbs", "", "hot_room", "clk_tribe_post", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.HotChatPostListAdapter.2
 * JD-Core Version:    0.7.0.1
 */