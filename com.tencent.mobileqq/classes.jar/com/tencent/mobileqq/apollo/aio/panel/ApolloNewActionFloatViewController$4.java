package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.vip.manager.QZoneVipInfoManager;

class ApolloNewActionFloatViewController$4
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$4(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    QZoneVipInfoManager.a(ApolloNewActionFloatViewController.a(this.e).f, ApolloNewActionFloatViewController.a(this.e).d.getCurrentUin(), "lmx_actchat");
    this.e.a();
    ApolloNewActionFloatViewController.a(this.e, this.a, "action_flame_clickgain");
    ApolloTianshuReportUtil.a(125, String.valueOf(this.b), this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.4
 * JD-Core Version:    0.7.0.1
 */