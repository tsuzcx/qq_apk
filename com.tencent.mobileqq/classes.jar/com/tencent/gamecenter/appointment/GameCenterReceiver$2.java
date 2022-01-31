package com.tencent.gamecenter.appointment;

import android.content.Intent;
import android.text.TextUtils;
import aqsu;
import bdow;
import biby;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;
import ynz;

class GameCenterReceiver$2
  implements Runnable
{
  GameCenterReceiver$2(GameCenterReceiver paramGameCenterReceiver, Intent paramIntent) {}
  
  public void run()
  {
    switch (this.a.getIntExtra("key_event_id", -1))
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (BaseApplicationImpl.sProcessId == 1);
              bdow.a().a();
              return;
              synchronized (this.this$0.a)
              {
                Object localObject2 = this.a.getStringExtra("key_appid");
                Object localObject4 = this.a.getStringExtra("key_pkg_name");
                if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
                {
                  localObject2 = new WadlResult(new WadlParams((String)localObject2, (String)localObject4));
                  ((WadlResult)localObject2).b = 12;
                  localObject4 = this.this$0.a.iterator();
                  if (((Iterator)localObject4).hasNext()) {
                    ((ynz)((Iterator)localObject4).next()).c((WadlResult)localObject2);
                  }
                }
              }
              return;
            } while ((BaseApplicationImpl.sProcessId != 1) || (TextUtils.isEmpty(biby.b(this.a.getStringExtra("appId"), "^*^%&$((2020ggy!"))));
            aqsu.a(this.a.getExtras());
            return;
          } while (BaseApplicationImpl.sProcessId != 1);
          ??? = biby.b(this.a.getStringExtra("appId"), "^*^%&$((2020ggy!");
        } while (TextUtils.isEmpty((CharSequence)???));
        aqsu.a(0, (String)???);
        return;
      } while (BaseApplicationImpl.sProcessId != 1);
      ??? = biby.b(this.a.getStringExtra("appId"), "^*^%&$((2020ggy!");
    } while (TextUtils.isEmpty((CharSequence)???));
    ??? = new WadlParams((String)???, this.a.getStringExtra("pkgName"));
    ((WadlParams)???).q = "biz_src_zf_games";
    ((WadlParams)???).f = this.a.getIntExtra("versionCode", 0);
    aqsu.a((WadlParams)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */