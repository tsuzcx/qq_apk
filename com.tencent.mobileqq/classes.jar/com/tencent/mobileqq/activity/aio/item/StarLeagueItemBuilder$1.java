package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.miniapp.util.MiniAppJumpUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StarLeagueItemBuilder$1
  implements View.OnClickListener
{
  StarLeagueItemBuilder$1(StarLeagueItemBuilder paramStarLeagueItemBuilder) {}
  
  public void onClick(View paramView)
  {
    MessageForStarLeague localMessageForStarLeague = (MessageForStarLeague)((StarLeagueItemBuilder.Holder)AIOUtils.a(paramView)).a;
    if (!MiniAppJumpUtil.a((BaseActivity)paramView.getContext(), localMessageForStarLeague.actionUrl, localMessageForStarLeague))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", localMessageForStarLeague.actionUrl);
      paramView.getContext().startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StarLeagueItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */