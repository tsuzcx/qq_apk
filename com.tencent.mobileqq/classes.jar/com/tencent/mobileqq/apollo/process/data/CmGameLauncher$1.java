package com.tencent.mobileqq.apollo.process.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class CmGameLauncher$1
  extends BroadcastReceiver
{
  CmGameLauncher$1(CmGameLauncher paramCmGameLauncher) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (CmGameLauncher.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (CmGameLauncher.a(this.a))
          {
            CmGameLauncher.a(this.a).runRenderTask(CmGameLauncher.a(this.a));
            return;
          }
          CmGameLauncher.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!CmGameLauncher.a(this.a)) {
        break;
      }
    } while (CmGameLauncher.a(this.a) == null);
    CmGameLauncher.a(this.a).runRenderTask(CmGameLauncher.b(this.a));
    return;
    CmGameLauncher.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.1
 * JD-Core Version:    0.7.0.1
 */