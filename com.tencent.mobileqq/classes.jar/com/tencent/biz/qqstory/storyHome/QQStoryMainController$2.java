package com.tencent.biz.qqstory.storyHome;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class QQStoryMainController$2
  implements View.OnClickListener
{
  QQStoryMainController$2(QQStoryMainActivity.ButtonConfig paramButtonConfig, Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("top right button on click:");
    ((StringBuilder)localObject).append(this.a);
    SLog.d("QQStoryMainController", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.a.d)) && (HttpUtil.isValidUrl(this.a.d))) {
      localObject = this.a.d;
    } else {
      localObject = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
    }
    if (this.a.a == 1)
    {
      Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      this.b.startActivity(localIntent);
    }
    else if (this.a.a != 2)
    {
      int i = this.a.a;
    }
    StoryReportor.a("hall", "exp", 0, 0, new String[] { "" });
    if ("troopStoryHallConfig".equals(this.c)) {
      StoryReportor.a("story_grp", "clk_find_left", 0, 0, new String[] { "", "", "", "" });
    } else {
      StoryReportor.a("home_page", "clk_find_entry", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.2
 * JD-Core Version:    0.7.0.1
 */