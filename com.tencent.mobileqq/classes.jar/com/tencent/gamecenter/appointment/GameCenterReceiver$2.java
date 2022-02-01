package com.tencent.gamecenter.appointment;

import abud;
import android.content.Intent;
import android.text.TextUtils;
import bjqs;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

class GameCenterReceiver$2
  implements Runnable
{
  GameCenterReceiver$2(GameCenterReceiver paramGameCenterReceiver, Intent paramIntent) {}
  
  public void run()
  {
    int i = this.a.getIntExtra("key_event_id", -1);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterReceiver", 2, "receiveGameCenterAction eventId=" + i);
    }
    Object localObject4;
    switch (i)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return;
    case 1: 
      bjqs.a().a();
      return;
    case 2: 
      synchronized (this.this$0.a)
      {
        String str = this.a.getStringExtra("key_appid");
        localObject4 = this.a.getStringExtra("key_pkg_name");
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
        {
          Iterator localIterator = this.this$0.a.iterator();
          if (localIterator.hasNext()) {
            ((abud)localIterator.next()).onTaskDeleted(str, (String)localObject4);
          }
        }
      }
      return;
    case 7: 
      synchronized (this.this$0.a)
      {
        WadlResult localWadlResult1 = (WadlResult)this.a.getParcelableExtra("key_wadl_result");
        if (localWadlResult1 != null)
        {
          localObject4 = this.this$0.a.iterator();
          if (((Iterator)localObject4).hasNext()) {
            ((abud)((Iterator)localObject4).next()).onTaskComplete(localWadlResult1);
          }
        }
      }
      return;
    }
    synchronized (this.this$0.a)
    {
      WadlResult localWadlResult2 = (WadlResult)this.a.getParcelableExtra("key_wadl_result");
      if (localWadlResult2 != null)
      {
        localObject4 = this.this$0.a.iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((abud)((Iterator)localObject4).next()).onTaskInstall(localWadlResult2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */