package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.GameCenterListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GameCenterReceiver$2
  implements Runnable
{
  GameCenterReceiver$2(GameCenterReceiver paramGameCenterReceiver, Intent paramIntent) {}
  
  public void run()
  {
    int i = this.a.getIntExtra("key_event_id", -1);
    ??? = new StringBuilder();
    ((StringBuilder)???).append("receiveGameCenterAction eventId=");
    ((StringBuilder)???).append(i);
    QLog.d("Wadl_GameCenterReceiver", 1, ((StringBuilder)???).toString());
    if (i != 1)
    {
      Object localObject5;
      if (i != 2)
      {
        if (i != 7)
        {
          if (i != 8) {
            return;
          }
          synchronized (this.this$0.a)
          {
            WadlResult localWadlResult1 = (WadlResult)this.a.getParcelableExtra("key_wadl_result");
            if (localWadlResult1 != null)
            {
              localObject5 = this.this$0.a.iterator();
              while (((Iterator)localObject5).hasNext()) {
                ((GameCenterListener)((Iterator)localObject5).next()).onTaskInstall(localWadlResult1);
              }
            }
            return;
          }
        }
        synchronized (this.this$0.a)
        {
          WadlResult localWadlResult2 = (WadlResult)this.a.getParcelableExtra("key_wadl_result");
          if (localWadlResult2 != null)
          {
            localObject5 = this.this$0.a.iterator();
            while (((Iterator)localObject5).hasNext()) {
              ((GameCenterListener)((Iterator)localObject5).next()).onTaskComplete(localWadlResult2);
            }
          }
          return;
        }
      }
      synchronized (this.this$0.a)
      {
        String str = this.a.getStringExtra("key_appid");
        localObject5 = this.a.getStringExtra("key_pkg_name");
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          Iterator localIterator = this.this$0.a.iterator();
          while (localIterator.hasNext()) {
            ((GameCenterListener)localIterator.next()).onTaskDeleted(str, (String)localObject5);
          }
        }
        return;
      }
    }
    ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).loadConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */