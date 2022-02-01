package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePartyTipsBar$1
  implements View.OnClickListener
{
  GamePartyTipsBar$1(GamePartyTipsBar paramGamePartyTipsBar) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(GamePartyTipsBar.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { GamePartyTipsBar.b(this.a).getAccount(), GamePartyTipsBar.c(this.a), Integer.valueOf(GamePartyManager.a(GamePartyTipsBar.d(this.a).a)), GamePartyTipsBar.d(this.a).b }));
    GamePartyTipsBar.a(this.a).startActivity(localIntent);
    ReportCenter.a().a(GamePartyTipsBar.b(this.a).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar.1
 * JD-Core Version:    0.7.0.1
 */