package com.tencent.biz.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GamePartyPlugin$GamePartyBroadcastReceiver
  extends BroadcastReceiver
{
  public GamePartyPlugin$GamePartyBroadcastReceiver(GamePartyPlugin paramGamePartyPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.gameparty.notify"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("teamId");
      this.a.callJs("getTeamInfo", new String[] { "'" + paramContext + "'", "'" + paramIntent + "'" });
    }
    while (!paramContext.equals("android.intent.action.gameparty.refresh")) {
      return;
    }
    paramContext = paramIntent.getStringExtra("uin");
    long l = paramIntent.getLongExtra("teamId", 0L);
    this.a.callJs("refreshAudioStatus", new String[] { "'" + paramContext + "'", "'" + l + "'" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.GamePartyPlugin.GamePartyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */