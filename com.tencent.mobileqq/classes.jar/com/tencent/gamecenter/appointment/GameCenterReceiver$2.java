package com.tencent.gamecenter.appointment;

import android.content.Intent;
import android.text.TextUtils;
import bckg;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;
import yey;

class GameCenterReceiver$2
  implements Runnable
{
  GameCenterReceiver$2(GameCenterReceiver paramGameCenterReceiver, Intent paramIntent) {}
  
  public void run()
  {
    switch (this.a.getIntExtra("key_event_id", -1))
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (BaseApplicationImpl.sProcessId == 1);
      bckg.a().a();
      return;
    }
    synchronized (this.this$0.a)
    {
      Object localObject1 = this.a.getStringExtra("key_appid");
      Object localObject3 = this.a.getStringExtra("key_pkg_name");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
      {
        localObject1 = new WadlResult(new WadlParams((String)localObject1, (String)localObject3));
        ((WadlResult)localObject1).b = 12;
        localObject3 = this.this$0.a.iterator();
        if (((Iterator)localObject3).hasNext()) {
          ((yey)((Iterator)localObject3).next()).c((WadlResult)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */