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
    Object localObject;
    if (paramContext.equals("android.intent.action.gameparty.notify"))
    {
      localObject = paramIntent.getStringExtra("uin");
      paramContext = paramIntent.getStringExtra("teamId");
      paramIntent = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("'");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("'");
      paramIntent.callJs("getTeamInfo", new String[] { localObject, localStringBuilder.toString() });
      return;
    }
    if (paramContext.equals("android.intent.action.gameparty.refresh"))
    {
      localObject = paramIntent.getStringExtra("uin");
      long l = paramIntent.getLongExtra("teamId", 0L);
      paramContext = this.a;
      paramIntent = new StringBuilder();
      paramIntent.append("'");
      paramIntent.append((String)localObject);
      paramIntent.append("'");
      paramIntent = paramIntent.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("'");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("'");
      paramContext.callJs("refreshAudioStatus", new String[] { paramIntent, ((StringBuilder)localObject).toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.GamePartyPlugin.GamePartyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */