package com.tencent.gamecenter.appointment;

import aahh;
import android.content.Intent;
import android.text.TextUtils;
import asnk;
import bfsc;
import bkib;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.wadl.WadlProvider;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

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
                do
                {
                  do
                  {
                    return;
                    bfsc.a().a();
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
                          ((aahh)((Iterator)localObject4).next()).c((WadlResult)localObject2);
                        }
                      }
                    }
                    return;
                  } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
                  ??? = bkib.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
                } while (TextUtils.isEmpty((CharSequence)???));
                asnk.a(this.a.getExtras(), (String)???);
                return;
              } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
              ??? = bkib.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
            } while (TextUtils.isEmpty((CharSequence)???));
            asnk.a(0, (String)???);
            return;
          } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
          ??? = bkib.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
        } while (TextUtils.isEmpty((CharSequence)???));
        ??? = new WadlParams((String)???, this.a.getStringExtra("pkgName"));
        ((WadlParams)???).q = "biz_src_zf_games";
        asnk.a((WadlParams)???);
        return;
      } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
      ??? = bkib.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty((CharSequence)???));
    asnk.b(0, (String)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */