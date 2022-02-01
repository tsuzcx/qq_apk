package com.tencent.gamecenter.appointment;

import acii;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import avmc;
import bkag;
import bnyd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
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
    int i = this.a.getIntExtra("key_event_id", -1);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterReceiver", 2, "receiveGameCenterAction eventId=" + i);
    }
    switch (i)
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
                    bkag.a().a();
                    return;
                    Object localObject5;
                    synchronized (this.this$0.a)
                    {
                      String str = this.a.getStringExtra("key_appid");
                      localObject5 = this.a.getStringExtra("key_pkg_name");
                      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                      {
                        Iterator localIterator = this.this$0.a.iterator();
                        if (localIterator.hasNext()) {
                          ((acii)localIterator.next()).onTaskDeleted(str, (String)localObject5);
                        }
                      }
                    }
                    return;
                    synchronized (this.this$0.a)
                    {
                      WadlResult localWadlResult1 = (WadlResult)this.a.getParcelableExtra("key_wadl_result");
                      if (localWadlResult1 != null)
                      {
                        localObject5 = this.this$0.a.iterator();
                        if (((Iterator)localObject5).hasNext()) {
                          ((acii)((Iterator)localObject5).next()).onTaskComplete(localWadlResult1);
                        }
                      }
                    }
                    return;
                    synchronized (this.this$0.a)
                    {
                      WadlResult localWadlResult2 = (WadlResult)this.a.getParcelableExtra("key_wadl_result");
                      if (localWadlResult2 != null)
                      {
                        localObject5 = this.this$0.a.iterator();
                        if (((Iterator)localObject5).hasNext()) {
                          ((acii)((Iterator)localObject5).next()).onTaskInstall(localWadlResult2);
                        }
                      }
                    }
                    return;
                  } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
                  ??? = bnyd.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
                } while (TextUtils.isEmpty((CharSequence)???));
                Bundle localBundle = this.a.getExtras();
                localBundle.putString("via", "provider");
                localBundle.putInt("flags", 39);
                avmc.a(localBundle, (String)???, false, 0);
                return;
              } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
              ??? = bnyd.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
            } while (TextUtils.isEmpty((CharSequence)???));
            avmc.a(0, (String)???);
            return;
          } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
          ??? = bnyd.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
        } while (TextUtils.isEmpty((CharSequence)???));
        ??? = new WadlParams((String)???, this.a.getStringExtra("pkgName"));
        ((WadlParams)???).p = "biz_src_zf_games";
        avmc.a((WadlParams)???);
        return;
      } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
      ??? = bnyd.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty((CharSequence)???));
    avmc.b(0, (String)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */